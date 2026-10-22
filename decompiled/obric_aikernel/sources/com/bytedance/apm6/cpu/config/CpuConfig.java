package com.bytedance.apm6.cpu.config;

/* JADX INFO: loaded from: classes.dex */
public class CpuConfig {
    private static final long DEFAULT_BACK_COLLECT_INTERVAL = 600;
    private static final long DEFAULT_BACK_THREAD_INTERVAL = 600;
    private static final long DEFAULT_FRONT_COLLECT_INTERVAL = 120;
    private static final long DEFAULT_FRONT_THREAD_INTERVAL = 120;
    private static final long DEFAULT_MONITOR_INTERVAL = 1200;
    private long mBackCollectInterval;
    private long mBackThreadCollectInterval;
    private boolean mCollectAllProcess;
    private boolean mEnableUpload;
    private long mFrontCollectInterval;
    private long mFrontThreadCollectInterval;
    private long mMonitorInterval;

    public CpuConfig() {
        this.mEnableUpload = false;
        this.mCollectAllProcess = false;
        this.mFrontCollectInterval = 120;
        this.mBackCollectInterval = 600;
        this.mMonitorInterval = DEFAULT_MONITOR_INTERVAL;
        this.mFrontThreadCollectInterval = 120;
        this.mBackThreadCollectInterval = 600;
    }

    public long getBackCollectInterval() {
        return this.mBackCollectInterval * 1000;
    }

    public long getBackThreadCollectInterval() {
        return this.mBackThreadCollectInterval * 1000;
    }

    public long getFrontCollectInterval() {
        return this.mFrontCollectInterval * 1000;
    }

    public long getFrontThreadCollectInterval() {
        return this.mFrontThreadCollectInterval * 1000;
    }

    public long getMonitorInterval() {
        return this.mMonitorInterval * 1000;
    }

    public boolean isCollectAllProcess() {
        return this.mCollectAllProcess;
    }

    public boolean isEnableUpload() {
        return this.mEnableUpload;
    }

    public void setBackCollectInterval(long r10) {
        this.mBackCollectInterval = r10;
    }

    public void setBackThreadCollectInterval(long r10) {
        this.mBackThreadCollectInterval = r10;
    }

    public void setCollectAllProcess(boolean r10) {
        this.mCollectAllProcess = r10;
    }

    public void setEnableUpload(boolean r10) {
        this.mEnableUpload = r10;
    }

    public void setFrontCollectInterval(long r10) {
        this.mFrontCollectInterval = r10;
    }

    public void setFrontThreadCollectInterval(long r10) {
        this.mFrontThreadCollectInterval = r10;
    }

    public void setMonitorInterval(long r10) {
        this.mMonitorInterval = r10;
    }

    public String toString() {
        return "CpuConfig{mEnableUpload=" + this.mEnableUpload + ", mCollectAllProcess=" + this.mCollectAllProcess + ", mFrontCollectInterval=" + this.mFrontCollectInterval + ", mBackCollectInterval=" + this.mBackCollectInterval + ", mMonitorInterval=" + this.mMonitorInterval + ", mFrontThreadCollectInterval=" + this.mFrontThreadCollectInterval + ", mBackThreadCollectInterval=" + this.mBackThreadCollectInterval + '}';
    }
}
