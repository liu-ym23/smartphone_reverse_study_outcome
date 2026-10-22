package com.bytedance.framwork.core.sdklib.apm6;

import com.bytedance.apm6.util.ListUtils;
import com.bytedance.apm6.util.cache.LimitedQueue;
import com.bytedance.crash.resource.vmmonitor.VmMonitorConfig;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class d implements k3.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private volatile long f1905a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private volatile long f1906b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private LimitedQueue<b> f1907c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private volatile i f1908d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private boolean f1909e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private long f1910f;

    private static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static final d f1911a = null;

        static {
            f1911a = new d();
        }

        static /* synthetic */ d a() {
            return f1911a;
        }
    }

    public d() {
        this.f1905a = VmMonitorConfig.SLEEP_TIME_BEFORE_RECOVER;
        this.f1906b = 1048576;
        this.f1907c = new LimitedQueue(10);
    }

    private void a() {
    L6:
        th = move-exception;
        j3.c.c("APM-SDK", "flushBuffer", th);
        return;
    L3:
        if (this.f1908d == null) goto L11;
        this.f1908d.b();     // Catch: Throwable -> L6
        return;
    }

    public static d c() {
        return a.a();
    }

    private void e() {
        long r10 = System.currentTimeMillis();     // Catch: Throwable -> L10
        a();     // Catch: Throwable -> L10
        g();     // Catch: Throwable -> L10
        if (j.g() == false) goto L7;
        f();     // Catch: Throwable -> L10
    L7:
        if (j.f() == false) goto L15;
        j3.c.a("APM-SDK", "LogReporter One Loop Cost:" + (System.currentTimeMillis() - r10));     // Catch: Throwable -> L10
        return;
    L15:
        return;
    L10:
        th = move-exception;
        j3.c.c("APM-SDK", "report", th);
    }

    private void f() {
        ArrayList r10 = new ArrayList();
        if (this.f1908d == null) goto L8;
        List<File> r11 = this.f1908d.i();
        if (ListUtils.isEmpty(r11) == true) goto L8;
        r10.addAll(r11);
    L8:
        if (ListUtils.isEmpty(r10) == false) goto L10;
        return;
    L10:
        ArrayList r12 = new ArrayList();
        int r13 = 0;
        int r14 = 0;
    L12:
        if (r13 >= r10.size()) goto L32;
        File r15 = (File) r10.get(r13);
        if (r15.exists() == true) goto L16;
        j3.c.b("APM-SDK", "reportFile file is not exist:" + r15.getAbsolutePath());
    L30:
        r13 = r13 + 1;
        goto L12
    L16:
        b r16 = b.a(r15);
        if (r16 == null) goto L19;
        int r17 = r16.e();
        if (r14 != 0) goto L25;
    L29:
        r14 = r14 + r17;
        r12.add(r16);
        goto L30
    L25:
        if ((r14 + r17) < this.f1906b) goto L29;
        e.d().i(r12);
        return;
    L19:
        if (j.f() == false) goto L21;
        j3.c.a("APM-SDK", "logFile invalid. delete now.");
    L21:
        r15.delete();
        goto L30
    L32:
        if (ListUtils.isEmpty(r12) == true) goto L40;
        e.d().i(r12);
        return;
    }

    private void g() {
        if (this.f1907c.isEmpty() == false) goto L5;
        return;
    L5:
        ArrayList r10 = new ArrayList();
        int r11 = 0;
    L7:
        if (this.f1907c.isEmpty() == true) goto L18;
        r10.add(this.f1907c.pop());
        b r12 = this.f1907c.pop();
        if (r12 == null) goto L7;
        int r13 = r12.e();
        if (r11 == 0) goto L17;
        if ((r11 + r13) < this.f1906b) goto L17;
        e.d().i(r10);
        r10.clear();
        r10.add(r12);
        r11 = r13;
    L17:
        r11 = r11 + r13;
        r10.add(r12);
        goto L7
    L18:
        e.d().i(r10);
    }

    public synchronized void b() {
        monitor-enter(this);
        f();     // Catch: Throwable -> L5
    L7:
        monitor-exit(this);
        return;
    L5:
        th = move-exception;
        j3.c.c("APM-SDK", "forceReport", th);     // Catch: Throwable -> L9
    L9:
        th = move-exception;
        throw th;
    }

    public synchronized void d() {
        monitor-enter(this);
    L11:
        th = move-exception;
        throw th;
    L4:
        if (this.f1909e == false) goto L8;
        monitor-exit(this);
        return;
    L8:
        this.f1909e = true;     // Catch: Throwable -> L11
        k3.a.e().d(this);     // Catch: Throwable -> L11
        monitor-exit(this);
    }

    public void h(b r10) {
        if (r10 != null) goto L4;
        return;
    L4:
        this.f1907c.push(r10);
    }

    public synchronized void i(long r10) {
        monitor-enter(this);
    L16:
        th = move-exception;
        throw th;
    L4:
        if (j.f() == false) goto L7;
        j3.c.a("APM-SDK", "setLoopInterval:" + r10);     // Catch: Throwable -> L16
    L7:
        if (r10 > 0) goto L9;
    L14:
        monitor-exit(this);
        return;
    L9:
        if (this.f1905a == r10) goto L14;
        this.f1905a = Math.min(r10, this.f1905a);     // Catch: Throwable -> L16
        monitor-exit(this);
    }

    public void j(i r10) {
        this.f1908d = r10;
    }

    @Override // k3.b
    public void onTimeEvent(long r10) {
        if ((r10 - this.f1910f) < this.f1905a) goto L8;
        e();
        this.f1910f = System.currentTimeMillis();
        if (j.f() == false) goto L9;
        j3.c.a("APM-SDK", "onTimeEvent");
        return;
    L9:
        return;
    }
}
