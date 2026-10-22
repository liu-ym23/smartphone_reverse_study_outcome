package com.bytedance.apm6.memory.config;

/* JADX INFO: loaded from: classes.dex */
public final class MemoryConfig {
    public static final double BENCHMARK_RATE = 0.8d;
    public static final long MEM_MONITOR_INTERVAL_SECONDS = 120;
    public static final double REACH_TOP_MIN_RATE = 0.5d;
    private boolean isApm6SampleEnable;
    private boolean isRealTimeMemEnable;
    private boolean isStopWhenBackground;
    private boolean isUploadEnable;
    private long memoryCollectionInterval;
    private double memoryTopCheckThreshold;

    public MemoryConfig(long r10, double r11, boolean r12, boolean r13, boolean r14, boolean r15) {
        if (r10 > 0) goto L5;
        r10 = 120;
    L5:
        this.memoryCollectionInterval = r10;
        this.memoryTopCheckThreshold = r11;
        this.isApm6SampleEnable = r15;
        this.isStopWhenBackground = r12;
        this.isRealTimeMemEnable = r13;
        this.isUploadEnable = r14;
    }

    public boolean isApm6SampleEnable() {
        return this.isApm6SampleEnable;
    }

    public boolean isRealTimeMemEnable() {
        return this.isRealTimeMemEnable;
    }

    public boolean isStopWhenBackground() {
        return this.isStopWhenBackground;
    }

    public boolean isUploadEnable() {
        return this.isUploadEnable;
    }

    public long memoryCollectionInterval() {
        return this.memoryCollectionInterval;
    }

    public double memoryTopCheckThreshold() {
        double r10 = this.memoryTopCheckThreshold;
        if (r10 <= 0.5d) goto L5;
        return r10;
    L5:
        return 0.8d;
    }

    public void setRealTimeMemEnable(boolean r10) {
        this.isRealTimeMemEnable = r10;
    }

    public void setStopWhenBackground(boolean r10) {
        this.isStopWhenBackground = r10;
    }

    public String toString() {
        return "MemoryConfig{memoryCollectionInterval=" + this.memoryCollectionInterval + ", memoryTopCheckThreshold=" + this.memoryTopCheckThreshold + ", isStopWhenBackground=" + this.isStopWhenBackground + ", isRealTimeMemEnable=" + this.isRealTimeMemEnable + ", isUploadEnable=" + this.isUploadEnable + ", isApm6SampleEnable=" + this.isApm6SampleEnable + '}';
    }
}
