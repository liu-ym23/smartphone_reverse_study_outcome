package com.bytedance.framwork.core.sdklib.apm6;

import com.bytedance.apm6.util.ListUtils;
import com.bytedance.apm6.util.cache.LimitedQueue;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class d implements com.bytedance.framwork.core.sdklib.a.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private volatile long f2586a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private volatile long f2587b;
    private LimitedQueue<b> c;
    private volatile i d;
    private boolean e;
    private long f;

    private static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static final d f2588a = null;

        static {
            f2588a = new d();
        }

        static /* synthetic */ d a() {
            return f2588a;
        }
    }

    public d() {
        this.f2586a = 60000;
        this.f2587b = 1048576;
        this.c = new LimitedQueue(10);
    }

    public static d a() {
        return a.a();
    }

    private void d() {
        long r1 = System.currentTimeMillis();     // Catch: Throwable -> L10
        e();     // Catch: Throwable -> L10
        f();     // Catch: Throwable -> L10
        if (j.c() == false) goto L7;
        g();     // Catch: Throwable -> L10
    L7:
        if (j.d() == false) goto L15;
        com.bytedance.framwork.core.sdklib.apm6.safety.c.a("APM-SDK", "LogReporter One Loop Cost:" + (System.currentTimeMillis() - r1));     // Catch: Throwable -> L10
        return;
    L15:
        return;
    L10:
        th = move-exception;
        com.bytedance.framwork.core.sdklib.apm6.safety.c.a("APM-SDK", "report", th);
    }

    private void e() {
    L6:
        th = move-exception;
        com.bytedance.framwork.core.sdklib.apm6.safety.c.a("APM-SDK", "flushBuffer", th);
        return;
    L3:
        if (this.d == null) goto L11;
        this.d.a();     // Catch: Throwable -> L6
        return;
    }

    private void f() {
        if (this.c.isEmpty() == false) goto L5;
        return;
    L5:
        ArrayList r0 = new ArrayList();
        int r1 = 0;
    L7:
        if (this.c.isEmpty() == true) goto L18;
        r0.add(this.c.pop());
        b r2 = (b) ZeusTransformUtils.preCheckCast(this.c.pop(), b.class, "com.obric.memorydata.plugin");
        if (r2 == null) goto L7;
        int r3 = r2.a();
        if (r1 == 0) goto L17;
        if ((r1 + r3) < this.f2587b) goto L17;
        e.a().a(r0);
        r0.clear();
        r0.add(r2);
        r1 = r3;
    L17:
        r1 = r1 + r3;
        r0.add(r2);
        goto L7
    L18:
        e.a().a(r0);
    }

    private void g() {
        ArrayList r0 = new ArrayList();
        if (this.d == null) goto L8;
        List<File> r1 = this.d.b();
        if (ListUtils.isEmpty(r1) == true) goto L8;
        r0.addAll(r1);
    L8:
        if (ListUtils.isEmpty(r0) == false) goto L10;
        return;
    L10:
        ArrayList r2 = new ArrayList();
        int r3 = 0;
        int r4 = 0;
    L12:
        if (r3 >= r0.size()) goto L32;
        File r5 = (File) ZeusTransformUtils.preCheckCast(r0.get(r3), File.class, "com.obric.memorydata.plugin");
        if (r5.exists() == true) goto L16;
        com.bytedance.framwork.core.sdklib.apm6.safety.c.c("APM-SDK", "reportFile file is not exist:" + r5.getAbsolutePath());
    L30:
        r3 = r3 + 1;
        goto L12
    L16:
        b r6 = b.a(r5);
        if (r6 == null) goto L19;
        int r7 = r6.a();
        if (r4 != 0) goto L25;
    L29:
        r4 = r4 + r7;
        r2.add(r6);
        goto L30
    L25:
        if ((r4 + r7) < this.f2587b) goto L29;
        e.a().a(r2);
        return;
    L19:
        if (j.d() == false) goto L21;
        com.bytedance.framwork.core.sdklib.apm6.safety.c.a("APM-SDK", "logFile invalid. delete now.");
    L21:
        r5.delete();
        goto L30
    L32:
        if (ListUtils.isEmpty(r2) == true) goto L40;
        e.a().a(r2);
        return;
    }

    public synchronized void a(long r4) {
        monitor-enter(this);
    L16:
        th = move-exception;
        throw th;
    L4:
        if (j.d() == false) goto L7;
        com.bytedance.framwork.core.sdklib.apm6.safety.c.a("APM-SDK", "setLoopInterval:" + r4);     // Catch: Throwable -> L16
    L7:
        if (r4 > 0) goto L9;
    L14:
        monitor-exit(this);
        return;
    L9:
        if (this.f2586a == r4) goto L14;
        this.f2586a = Math.min(r4, this.f2586a);     // Catch: Throwable -> L16
        monitor-exit(this);
    }

    public void a(b r1) {
        if (r1 != null) goto L4;
        return;
    L4:
        this.c.push(r1);
    }

    public void a(i r1) {
        this.d = r1;
    }

    public synchronized void b() {
        monitor-enter(this);
    L11:
        th = move-exception;
        throw th;
    L4:
        if (this.e == false) goto L8;
        monitor-exit(this);
        return;
    L8:
        this.e = true;     // Catch: Throwable -> L11
        com.bytedance.framwork.core.sdklib.a.a.a().a(this);     // Catch: Throwable -> L11
        monitor-exit(this);
    }

    public synchronized void c() {
        monitor-enter(this);
        g();     // Catch: Throwable -> L5
    L7:
        monitor-exit(this);
        return;
    L5:
        th = move-exception;
        com.bytedance.framwork.core.sdklib.apm6.safety.c.a("APM-SDK", "forceReport", th);     // Catch: Throwable -> L9
    L9:
        th = move-exception;
        throw th;
    }

    @Override // com.bytedance.framwork.core.sdklib.a.b
    public void onTimeEvent(long r3) {
        if ((r3 - this.f) < this.f2586a) goto L8;
        d();
        this.f = System.currentTimeMillis();
        if (j.d() == false) goto L9;
        com.bytedance.framwork.core.sdklib.apm6.safety.c.a("APM-SDK", "onTimeEvent");
        return;
    L9:
        return;
    }
}
