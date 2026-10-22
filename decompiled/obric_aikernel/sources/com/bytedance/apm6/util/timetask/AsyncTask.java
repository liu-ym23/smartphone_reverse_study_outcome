package com.bytedance.apm6.util.timetask;

/* JADX INFO: loaded from: classes.dex */
public abstract class AsyncTask implements Runnable {
    private long mInitialDelay;
    private boolean mIsLoop;
    private long mLoopInterval;

    public AsyncTask() {
        this(0);
    }

    public AsyncTask(long r10) {
        this(r10, 0);
    }

    public AsyncTask(long r10, long r11) {
        this.mInitialDelay = r10;
        this.mLoopInterval = r11;
        if (r11 <= 0) goto L6;
        this.mIsLoop = true;
        return;
    }

    public long getInitialDelay() {
        return this.mInitialDelay;
    }

    public final long getLoopInterval() {
        return this.mLoopInterval;
    }

    public final boolean isLoop() {
        return this.mIsLoop;
    }

    public void refresh(long r10, long r11) {
        this.mInitialDelay = r10;
        this.mLoopInterval = r11;
        if (r11 <= 0) goto L6;
        this.mIsLoop = true;
        return;
    }
}
