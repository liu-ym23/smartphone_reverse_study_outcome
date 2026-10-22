package com.bytedance.apm6.fd.config;

/* JADX INFO: loaded from: classes.dex */
public class FdConfig {
    public static final long DEFAULT_COLLECT_INTERVAL_MINUTE = 10;
    public static final int DEFAULT_FD_COUNT_THRESHOLD = 800;
    private long collectIntervalMs;
    private long fdCountThreshold;
    private boolean isSampled;

    public FdConfig(long r10, long r11, boolean r12) {
        this.fdCountThreshold = r10;
        this.collectIntervalMs = r11;
        this.isSampled = r12;
    }

    public long getCollectIntervalMs() {
        return this.collectIntervalMs;
    }

    public long getFdCountThreshold() {
        return this.fdCountThreshold;
    }

    public boolean isSampled() {
        return this.isSampled;
    }

    public String toString() {
        return "FdConfig{fdCountThreshold=" + this.fdCountThreshold + ", collectIntervalMs=" + this.collectIntervalMs + ", isSampled=" + this.isSampled + '}';
    }
}
