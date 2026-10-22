package com.ttnet.org.chromium.base;

import android.os.Process;
import android.os.SystemClock;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
public final class EarlyTraceEvent$Event {
    final boolean mIsStart;
    final boolean mIsToplevel;
    final String mName;
    final int mThreadId;
    final long mThreadTimeMillis;
    final long mTimeNanos;

    public EarlyTraceEvent$Event(String r1, boolean r2, boolean r3) {
        this.mIsStart = r2;
        this.mIsToplevel = r3;
        this.mName = r1;
        this.mThreadId = Process.myTid();
        this.mTimeNanos = System.nanoTime();
        this.mThreadTimeMillis = SystemClock.currentThreadTimeMillis();
    }
}
