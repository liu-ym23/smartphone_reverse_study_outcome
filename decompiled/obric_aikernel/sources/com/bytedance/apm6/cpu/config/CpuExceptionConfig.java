package com.bytedance.apm6.cpu.config;

import androidx.annotation.NonNull;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class CpuExceptionConfig {
    private static final double DEFAULT_MAX_PROCESS_BACK_CPU_SPEED = 3.0d;
    private static final double DEFAULT_MAX_PROCESS_FORE_CPU_SPEED = 6.0d;
    private static final double DEFAULT_MAX_THREAD_CPU_RATE = 0.05d;
    private Map<String, Double> backSceneMaxSpeedMap;
    private Map<String, Double> foreSceneMaxSpeedMap;
    private boolean isCollectAllProcess;
    private boolean isCollectMainThread;
    private boolean isCollectNativeThread;
    private boolean isCollectThreadStack;
    private boolean isOpen;
    private double maxProcessBackCpuSpeed;
    private double maxProcessForeCpuSpeed;
    private double maxThreadCpuRate;
    private Map<String, Double> maxThreadCpuRateMap;
    private int processDetectInterval;
    private int threadDetectInterval;

    public CpuExceptionConfig() {
        this.isOpen = false;
        this.isCollectMainThread = false;
        this.maxProcessBackCpuSpeed = DEFAULT_MAX_PROCESS_BACK_CPU_SPEED;
        this.maxProcessForeCpuSpeed = DEFAULT_MAX_PROCESS_FORE_CPU_SPEED;
        this.maxThreadCpuRate = DEFAULT_MAX_THREAD_CPU_RATE;
        this.isCollectAllProcess = false;
        this.isCollectThreadStack = true;
        this.isCollectNativeThread = false;
    }

    @NonNull
    public Map<String, Double> getBackSceneMaxSpeedMap() {
        return this.backSceneMaxSpeedMap;
    }

    @NonNull
    public Map<String, Double> getForeSceneMaxSpeedMap() {
        return this.foreSceneMaxSpeedMap;
    }

    public double getMaxProcessBackCpuSpeed() {
        return this.maxProcessBackCpuSpeed;
    }

    public double getMaxProcessForeCpuSpeed() {
        return this.maxProcessForeCpuSpeed;
    }

    public double getMaxThreadCpuRate() {
        return this.maxThreadCpuRate;
    }

    public Map<String, Double> getMaxThreadCpuRateMap() {
        return this.maxThreadCpuRateMap;
    }

    public int getProcessDetectInterval() {
        return this.processDetectInterval;
    }

    public int getThreadDetectInterval() {
        return this.threadDetectInterval;
    }

    public boolean isCollectAllProcess() {
        return this.isCollectAllProcess;
    }

    public boolean isCollectMainThread() {
        return this.isCollectMainThread;
    }

    public boolean isCollectNativeThread() {
        return this.isCollectNativeThread;
    }

    public boolean isCollectThreadStack() {
        return this.isCollectThreadStack;
    }

    public boolean isOpen() {
        return this.isOpen;
    }

    public void setBackSceneMaxSpeedMap(Map<String, Double> r10) {
        this.backSceneMaxSpeedMap = r10;
    }

    public void setCollectAllProcess(boolean r10) {
        this.isCollectAllProcess = r10;
    }

    public void setCollectMainThread(boolean r10) {
        this.isCollectMainThread = r10;
    }

    public void setCollectNativeThread(boolean r10) {
        this.isCollectNativeThread = r10;
    }

    public void setCollectThreadStack(boolean r10) {
        this.isCollectThreadStack = r10;
    }

    public void setForeSceneMaxSpeedMap(Map<String, Double> r10) {
        this.foreSceneMaxSpeedMap = r10;
    }

    public void setMaxProcessBackCpuSpeed(double r10) {
        this.maxProcessBackCpuSpeed = r10;
    }

    public void setMaxProcessForeCpuSpeed(double r10) {
        this.maxProcessForeCpuSpeed = r10;
    }

    public void setMaxThreadCpuRate(double r10) {
        this.maxThreadCpuRate = r10;
    }

    public void setMaxThreadCpuRateMap(Map<String, Double> r10) {
        this.maxThreadCpuRateMap = r10;
    }

    public void setOpen(boolean r10) {
        this.isOpen = r10;
    }

    public void setProcessDetectInterval(int r10) {
        this.processDetectInterval = r10;
    }

    public void setThreadDetectInterval(int r10) {
        this.threadDetectInterval = r10;
    }

    public String toString() {
        return "CpuExceptionConfig{isOpen=" + this.isOpen + ", isCollectMainThread=" + this.isCollectMainThread + ", maxProcessBackCpuSpeed=" + this.maxProcessBackCpuSpeed + ", maxProcessForeCpuSpeed=" + this.maxProcessForeCpuSpeed + ", maxThreadCpuRate=" + this.maxThreadCpuRate + ", isCollectAllProcess=" + this.isCollectAllProcess + ", backSceneMaxSpeedMap=" + this.backSceneMaxSpeedMap + ", foreSceneMaxSpeedMap=" + this.foreSceneMaxSpeedMap + '}';
    }
}
