package com.bytedance.monitor.collector;

import android.util.Pair;

/* JADX INFO: loaded from: classes2.dex */
public class l extends b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    com.bytedance.monitor.util.thread.d f2870a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f2871b;
    private int c;
    private boolean d;

    l(int r2) {
        super(r2, "proc_monitor");
        this.f2871b = 200;
        this.c = 1000;
        this.d = true;
        this.f2870a = com.bytedance.monitor.util.thread.b.a("collect-proc", new AnonymousClass1(this));
    }

    public static long a(int r4) {
    L9:
        return -1;
    L4:
        if (k.f2867a == true) goto L6;
        return -1;
    L6:
        return MonitorJni.doGetCpuTime(r4) * n.a();
    }

    public static void a() {
        if (k.f2867a == true) goto L5;
        return;
    L5:
        MonitorJni.doInit();     // Catch: Throwable -> L7
        return;
    }

    public synchronized void b() {
        monitor-enter(this);
        if (k.f2867a == true) goto L7;
        monitor-exit(this);
        return;
    L7:
        MonitorJni.doCollect();     // Catch: Throwable -> L10
    L8:
        monitor-exit(this);
    }

    @Override // com.bytedance.monitor.collector.b
    public void destroy() {
        super.destroy();
        if (k.f2867a == true) goto L6;
        return;
    L6:
        MonitorJni.doDestroy();     // Catch: Throwable -> L8
        return;
    }

    @Override // com.bytedance.monitor.collector.b
    public synchronized Pair<String, String> dumpInfo() {
        monitor-enter(this);
        if (k.f2867a == true) goto L8;
        monitor-exit(this);
        return null;
    L8:
        Pair<String, String> r1 = new Pair(this.mCollectorType, MonitorJni.getProcInfos());     // Catch: Throwable -> L11
        monitor-exit(this);
        return r1;
    L12:
        return null;
    }

    @Override // com.bytedance.monitor.collector.b
    public synchronized Pair<String, String> dumpInfosRange(long r4, long r6) {
        monitor-enter(this);
        if (k.f2867a == true) goto L8;
        monitor-exit(this);
        return null;
    L8:
        Pair<String, String> r1 = new Pair(this.mCollectorType, MonitorJni.getProcInfoTimeRange(r4, r6));     // Catch: Throwable -> L11
        monitor-exit(this);
        return r1;
    L12:
        return null;
    }

    @Override // com.bytedance.monitor.collector.b
    void dumpInfosToALog(long r2, long r4, long r6) {
        if (k.f2867a == true) goto L5;
        return;
    L5:
        if (this.d == true) goto L13;
        MonitorJni.dumpProcInfoTimeRangeToALog(r2 - r6, r4);     // Catch: Throwable -> L9
        return;
    L13:
        return;
    }

    @Override // com.bytedance.monitor.collector.b
    public void start() {
        super.start();
        if (k.f2867a == true) goto L6;
        return;
    L6:
        if (this.mRunMode == 0) goto L20;
        boolean r0 = this.d;     // Catch: Throwable -> L16
        if (r0 == false) goto L11;
        this.c = 5000;     // Catch: Throwable -> L16
    L12:
        MonitorJni.keepProcHyperOpen(r0);     // Catch: Throwable -> L16
        MonitorJni.doStart();     // Catch: Throwable -> L16
        if (this.mAsyncTaskManager == null) goto L21;
        this.mAsyncTaskManager.a(this.f2870a, 0, this.c);     // Catch: Throwable -> L16
        return;
    L21:
        return;
    L11:
        this.c = 1000;     // Catch: Throwable -> L16
        goto L12
    L20:
        return;
    }

    @Override // com.bytedance.monitor.collector.b
    public void stop() {
        super.stop();
        if (k.f2867a == true) goto L7;
        return;
    L7:
        if (this.mAsyncTaskManager == null) goto L9;
        this.mAsyncTaskManager.b(this.f2870a);     // Catch: Throwable -> L11
    L9:
        MonitorJni.doStop();     // Catch: Throwable -> L11
        return;
    }

    @Override // com.bytedance.monitor.collector.b
    public void updateConfig(int r3) {
        if (k.f2867a == true) goto L5;
        return;
    L5:
        stop();     // Catch: Throwable -> L19
        if (r3 != 0) goto L8;
        return;
    L8:
        if (r3 != 1) goto L10;
        int r4 = 200;
        this.f2871b = 200;     // Catch: Throwable -> L19
    L15:
        this.c = 1000;     // Catch: Throwable -> L19
        MonitorJni.setBufferSize(r4);     // Catch: Throwable -> L19
    L17:
        start();     // Catch: Throwable -> L19
        return;
    L10:
        if (r3 != 2) goto L12;
    L14:
        r4 = 400;
        this.f2871b = 400;     // Catch: Throwable -> L19
        goto L15
    L12:
        if (r3 == 3) goto L14;
    }
}
