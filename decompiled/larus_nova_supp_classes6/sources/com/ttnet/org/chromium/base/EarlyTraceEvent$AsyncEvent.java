package com.ttnet.org.chromium.base;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
public final class EarlyTraceEvent$AsyncEvent {
    final long mId;
    final boolean mIsStart;
    final String mName;
    final long mTimeNanos;

    public EarlyTraceEvent$AsyncEvent(String r1, long r2, boolean r4) {
        this.mName = r1;
        this.mId = r2;
        this.mIsStart = r4;
        this.mTimeNanos = System.nanoTime();
    }
}
