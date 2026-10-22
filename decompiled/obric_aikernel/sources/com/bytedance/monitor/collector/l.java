package com.bytedance.monitor.collector;

import android.util.Pair;

/* JADX INFO: loaded from: classes.dex */
public class l extends b {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f2367f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private int f2368g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private boolean f2369h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    z3.d f2370i;

    class a implements Runnable {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ l f2371c;

        a(l r10) {
            this.f2371c = r10;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f2371c.g();
        }
    }

    l(int r10) {
        super(r10, "proc_monitor");
        this.f2367f = 200;
        this.f2368g = 1000;
        this.f2369h = true;
        this.f2370i = z3.b.e("collect-proc", new a(this));
    }

    public static long h(int r10) {
    L9:
        return -1;
    L4:
        if (k.f2350p == true) goto L6;
        return -1;
    L6:
        return MonitorJni.doGetCpuTime(r10) * n.b();
    }

    public static void i() {
        if (k.f2350p == true) goto L5;
        return;
    L5:
        MonitorJni.doInit();     // Catch: Throwable -> L7
        return;
    }

    @Override // com.bytedance.monitor.collector.b
    public synchronized Pair<String, String> a() {
        monitor-enter(this);
        if (k.f2350p == true) goto L8;
        monitor-exit(this);
        return null;
    L8:
        Pair<String, String> r10 = new Pair(this.f2245a, MonitorJni.getProcInfos());     // Catch: Throwable -> L11
        monitor-exit(this);
        return r10;
    L12:
        return null;
    }

    @Override // com.bytedance.monitor.collector.b
    public synchronized Pair<String, String> b(long r10, long r11) {
        monitor-enter(this);
        if (k.f2350p == true) goto L8;
        monitor-exit(this);
        return null;
    L8:
        Pair<String, String> r12 = new Pair(this.f2245a, MonitorJni.getProcInfoTimeRange(r10, r11));     // Catch: Throwable -> L11
        monitor-exit(this);
        return r12;
    L12:
        return null;
    }

    @Override // com.bytedance.monitor.collector.b
    public void d() {
        super.d();
        if (k.f2350p == true) goto L6;
        return;
    L6:
        if (this.f2247c == 0) goto L20;
        boolean r10 = this.f2369h;     // Catch: Throwable -> L16
        if (r10 == false) goto L11;
        this.f2368g = 5000;     // Catch: Throwable -> L16
    L12:
        MonitorJni.keepProcHyperOpen(r10);     // Catch: Throwable -> L16
        MonitorJni.doStart();     // Catch: Throwable -> L16
        z3.c r11 = this.f2249e;     // Catch: Throwable -> L16
        if (r11 == null) goto L21;
        r11.g(this.f2370i, 0, this.f2368g);     // Catch: Throwable -> L16
        return;
    L21:
        return;
    L11:
        this.f2368g = 1000;     // Catch: Throwable -> L16
        goto L12
    L20:
        return;
    }

    @Override // com.bytedance.monitor.collector.b
    public void e() {
        super.e();
        if (k.f2350p == true) goto L6;
        return;
    L6:
        z3.c r10 = this.f2249e;     // Catch: Throwable -> L11
        if (r10 == null) goto L9;
        r10.f(this.f2370i);     // Catch: Throwable -> L11
    L9:
        MonitorJni.doStop();     // Catch: Throwable -> L11
        return;
    }

    @Override // com.bytedance.monitor.collector.b
    protected void f(int r10) {
        if (k.f2350p == true) goto L5;
        return;
    L5:
        e();     // Catch: Throwable -> L19
        if (r10 != 0) goto L8;
        return;
    L8:
        if (r10 != 1) goto L10;
        int r11 = 200;
        this.f2367f = 200;     // Catch: Throwable -> L19
    L15:
        this.f2368g = 1000;     // Catch: Throwable -> L19
        MonitorJni.setBufferSize(r11);     // Catch: Throwable -> L19
    L17:
        d();     // Catch: Throwable -> L19
        return;
    L10:
        if (r10 != 2) goto L12;
    L14:
        r11 = 400;
        this.f2367f = 400;     // Catch: Throwable -> L19
        goto L15
    L12:
        if (r10 == 3) goto L14;
    }

    public synchronized void g() {
        monitor-enter(this);
        if (k.f2350p == true) goto L7;
        monitor-exit(this);
        return;
    L7:
        MonitorJni.doCollect();     // Catch: Throwable -> L10
    L8:
        monitor-exit(this);
    }
}
