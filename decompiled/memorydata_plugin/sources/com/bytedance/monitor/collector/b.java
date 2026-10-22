package com.bytedance.monitor.collector;

import android.util.Pair;

/* JADX INFO: loaded from: classes2.dex */
public abstract class b {
    protected volatile boolean isHyperMode;
    protected com.bytedance.monitor.util.thread.c mAsyncTaskManager;
    protected String mCollectorType;
    protected int mRunMode;
    protected int mState;

    public b(int r3, String r4) {
        this.mState = 0;
        this.mRunMode = 1;
        this.isHyperMode = false;
        this.mCollectorType = r4;
        this.mRunMode = r3;
        k.a().a(this);
        this.mAsyncTaskManager = com.bytedance.monitor.util.thread.b.a();
    }

    void destroy() {
        this.mState = -1;
    }

    Pair<String, ?> dumpInfo() {
        return null;
    }

    Pair<String, ?> dumpInfosRange(long r1, long r3) {
        return null;
    }

    void dumpInfosToALog(long r1, long r3, long r5) {
    }

    public String getMonitorType() {
        return this.mCollectorType;
    }

    public final void refreshConfig(final int r2) {
        com.bytedance.monitor.util.thread.d r3 = com.bytedance.monitor.util.thread.b.a("refreshConfig", new AnonymousClass1(this, r2));
        com.bytedance.monitor.util.thread.c r1 = this.mAsyncTaskManager;
        if (r1 == null) goto L6;
        r1.a(r3);
        return;
    }

    void start() {
        if (this.mState < 0) goto L7;
        this.mState = 2;
        return;
    L7:
        throw new IllegalStateException("collector has destroyed, can not start.");
    }

    void startHyperMode() {
        this.isHyperMode = true;
    }

    void stop() {
        this.mState = 1;
    }

    void stopHyperMode() {
        this.isHyperMode = false;
    }

    public abstract void updateConfig(int r1);
}
