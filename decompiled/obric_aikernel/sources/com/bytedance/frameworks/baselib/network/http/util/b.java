package com.bytedance.frameworks.baselib.network.http.util;

/* JADX INFO: loaded from: classes.dex */
public abstract class b implements Runnable {
    private final long mInitialDelay;
    private boolean mIsLoop;
    private long mLoopInterval;
    private final String mTaskIdentifier;

    public b() {
        this(0);
    }

    public b(long r10) {
        this(r10, 0, "");
    }

    public b(long r10, long r11, String r12) {
        this.mInitialDelay = r10;
        this.mLoopInterval = r11;
        this.mTaskIdentifier = r12;
        if (r11 <= 0) goto L6;
        this.mIsLoop = true;
        return;
    }

    public b(long r10, String r11) {
        this(r10, 0, r11);
    }

    public final long getInitialDelay() {
        return this.mInitialDelay;
    }

    public final long getLoopInterval() {
        return this.mLoopInterval;
    }

    public final String getTaskIdentifier() {
        return this.mTaskIdentifier;
    }

    public final boolean isLoop() {
        return this.mIsLoop;
    }
}
