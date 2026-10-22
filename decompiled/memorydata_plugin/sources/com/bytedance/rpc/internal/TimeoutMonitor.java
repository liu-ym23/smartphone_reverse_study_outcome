package com.bytedance.rpc.internal;

import android.os.Handler;

/* JADX INFO: loaded from: classes2.dex */
public class TimeoutMonitor implements Runnable {
    private boolean mCanceled;
    private Handler mHandler;
    private int mId;
    private boolean mKeepAlive;
    private long mTimeout;
    private boolean mWatching;
    private int mWhat;

    public TimeoutMonitor(Handler r8, long r9, int r11, int r12) {
        this(r8, r9, r11, r12, false);
    }

    public TimeoutMonitor(Handler r1, long r2, int r4, int r5, boolean r6) {
        this.mHandler = r1;
        this.mTimeout = r2;
        this.mWhat = r4;
        this.mId = r5;
        this.mKeepAlive = r6;
    }

    public void cancel() {
        if (this.mCanceled == false) goto L5;
        return;
    L5:
        if (this.mTimeout <= 0) goto L9;
        Handler r0 = this.mHandler;
        if (r0 == null) goto L9;
        r0.removeCallbacks(this);
    L9:
        this.mCanceled = true;
        this.mWatching = false;
        if (this.mKeepAlive == true) goto L14;
        this.mHandler = null;
        return;
    }

    public void entry() {
        this.mCanceled = false;
        this.mWatching = true;
        long r1 = this.mTimeout;
        if (r1 <= 0) goto L5;
        this.mHandler.postDelayed(this, r1);
        return;
    L5:
        this.mWatching = false;
        if (this.mKeepAlive == true) goto L10;
        this.mHandler = null;
        return;
    }

    public boolean isCanceled() {
        return this.mCanceled;
    }

    public boolean isWatching() {
        return this.mWatching;
    }

    @Override // java.lang.Runnable
    public void run() {
        Handler r0 = this.mHandler;
        if (r0 == null) goto L6;
        r0.obtainMessage(this.mWhat, this.mId, 0).sendToTarget();
    L6:
        if (this.mKeepAlive == true) goto L8;
        this.mHandler = null;
    L8:
        this.mWatching = false;
    }
}
