package com.bytedance.frameworks.baselib.network.http.util;

/* JADX INFO: loaded from: classes2.dex */
public abstract class b implements Runnable {
    private final long mInitialDelay;
    private boolean mIsLoop;
    private long mLoopInterval;
    private final String mTaskIdentifier;

    public b() {
        this(0);
    }

    public b(long r7) {
        this(r7, 0, "");
    }

    public b(long r1, long r3, String r5) {
        this.mInitialDelay = r1;
        this.mLoopInterval = r3;
        this.mTaskIdentifier = r5;
        if (r3 <= 0) goto L6;
        this.mIsLoop = true;
        return;
    }

    public b(long r7, String r9) {
        this(r7, 0, r9);
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
