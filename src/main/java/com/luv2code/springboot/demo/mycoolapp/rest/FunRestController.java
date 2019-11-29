package com.luv2code.springboot.demo.mycoolapp.rest;

import java.time.LocalDateTime;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FunRestController {

	private static final Logger LOGGER = LoggerFactory.getLogger(FunRestController.class);

	// Inject properties for: coach.name and team.name
	private final String coachName;
	private final String teamName;

	public FunRestController(@Value("${coach.name}") String coachName, @Value("${team.name}") String teamName) {
		this.coachName = coachName;
		this.teamName = teamName;
	}

	// expose new endpoint for "teaminfo"
	@GetMapping("/teaminfo")
	public String getTeamInfo() {
		return "Coach: " + this.coachName + ", Team name: " + this.teamName;
	}

	// expose "/" that return "Hello World"

	@GetMapping("/")
	public String sayHello() {
		LOGGER.info("calling sayHello function");
		return "Hello World! Time on server is " + LocalDateTime.now();
	}

	// expose a new endpoint for "workout"
	@GetMapping("/workout")
	public String getDailyWorkout() {
		return "Run a hard 5K!";
	}

	// expose a new endpoint for "fortune"
	@GetMapping("/fortune")
	public String getDailyFortune() {
		return "Today is your lucky day.";
	}
}
