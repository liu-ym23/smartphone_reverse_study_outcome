package com.bytedance.crash;

import ai.g0;
import android.app.Application;
import android.content.Context;
import android.os.SystemClock;
import com.bumptech.glide.load.engine.h0;
import com.bytedance.crash.gwpasan.GwpAsan;
import com.bytedance.crash.heaptracker.NativeHeapTracker;
import com.bytedance.crash.nativecrash.NativeImpl;
import java.io.File;
import org.json.JSONException;

/* JADX INFO: loaded from: classes2.dex */
public abstract class p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static boolean f4081a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static boolean f4082b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static boolean f4083c;
    public static boolean d;
    public static boolean e;
    public static final g0 f = null;
    public static long g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static boolean f4084h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static boolean f4085i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static boolean f4086j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static r9.c f4087k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static s6.b f4088l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static sj.e f4089m;

    static {
        f = new g0(2);
    }

    public static void a() {
        f4089m.getClass();
        File r5 = new File(com.bytedance.crash.util.g.h(n.f4057a), "npth/FDTracker");
        Context r10 = n.f4057a;
        String r11 = n.f();
        File r12 = new File(com.bytedance.crash.util.g.h(r10), td.d.b("npth/FDTracker/", r11));
        File[] r13 = r5.listFiles();
        if (r13 == null) goto L19;
        int r14 = r13.length;
        int r15 = 0;
    L6:
        if (r15 >= r14) goto L28;
        File r16 = r13[r15];
        if (r16.isFile() == true) goto L18;
        if (r16.getAbsolutePath().equals(r12.getAbsolutePath()) == true) goto L18;
    L16:
        th = move-exception;
        c.f4025a.getClass();
        m.b.h("NPTH_CATCH", th);
        goto L18
    L13:
        if (j9.b.a(r16) == 0) goto L18;
        cl.a.C(r16);     // Catch: Throwable -> L16
    L18:
        r15 = r15 + 1;
        goto L6
    L28:
        return;
    }

    public static synchronized void b(Application r5, Context r10, boolean r11, boolean r12, boolean r13, boolean r14) {
        monitor-enter(p.class);
    L15:
        th = move-exception;
        throw th;
    L5:
        if (f4081a == true) goto L39;
        f4081a = true;     // Catch: Throwable -> L15
        a.a.j("start");     // Catch: Throwable -> L15
        if (r10 == null) goto L42;
        if (r5 == null) goto L42;
        if (n.f4058b != null) goto L13;
    L17:
        n.f4059c = System.currentTimeMillis();     // Catch: Throwable -> L15
        n.d = SystemClock.uptimeMillis();     // Catch: Throwable -> L15
        n.f4057a = r10;     // Catch: Throwable -> L15
        n.f4058b = r5;     // Catch: Throwable -> L15
        n.f4067o = n.f();     // Catch: Throwable -> L15
    L18:
        a.a.j("NpthBus_initGlobal");     // Catch: Throwable -> L15
        if (r11 == true) goto L22;
        if (r12 == true) goto L22;
    L30:
        a.a.j("javaCrashInit");     // Catch: Throwable -> L15
        NativeImpl.m();     // Catch: Throwable -> L15
        a.a.j("NativeImpl_loadLibrary");     // Catch: Throwable -> L15
        if (r13 == false) goto L35;
        d = NativeImpl.k(r10);     // Catch: Throwable -> L15
        a.a.j("NativeImpl_startMonitorNativeCrash");     // Catch: Throwable -> L15
        if (d == true) goto L35;
        e = true;     // Catch: Throwable -> L15
    L35:
        m9.c.e();     // Catch: Throwable -> L15
        l9.o.e().c(new o(r14), 0);     // Catch: Throwable -> L15
        a.a.j("startNpthDefaultThread");     // Catch: Throwable -> L15
        long r15 = SystemClock.uptimeMillis();     // Catch: Throwable -> L15
        a.a.f15a.put("total", r15 - a.a.f17c);     // Catch: Throwable -> L15 JSONException -> L45
        io.reactivex.exceptions.a.i("npth init total cost : " + (r15 - a.a.f17c) + " ms");     // Catch: Throwable -> L15 JSONException -> L45
        monitor-exit(p.class);
        return;
    L22:
        if (d9.b.g != null) goto L24;
        d9.b.g = new d9.b();     // Catch: Throwable -> L15
    L24:
        d9.b r16 = d9.b.g;     // Catch: Throwable -> L15
        if (r12 == false) goto L27;
        r16.f16617b = new h0(r10, true);     // Catch: Throwable -> L15
    L27:
        if (r11 == false) goto L29;
        r16.f16618c = new h0(r10, false);     // Catch: Throwable -> L15
    L29:
        f4082b = true;     // Catch: Throwable -> L15
        goto L30
    L13:
        if (n.f4057a != null) goto L18;
    L42:
        throw new IllegalArgumentException("context or Application must be not null.");     // Catch: Throwable -> L15
    L39:
        monitor-exit(p.class);
    }

    public static synchronized void c(Context r10) {
        monitor-enter(p.class);
        Application r5 = n.f4058b;     // Catch: Throwable -> L14
        if (r5 == null) goto L8;
    L21:
        b(r5, r10, true, true, true, true);     // Catch: Throwable -> L14
        monitor-exit(p.class);
        return;
    L8:
        if ((r10 instanceof Application) == false) goto L30;
        r5 = (Application) r10;     // Catch: Throwable -> L14
        if (r5.getBaseContext() != null) goto L21;
        throw new IllegalArgumentException("Please slardar oncall. Application not be attached, please init use the param from attachBaseContext, and invoke Npth.setApplication(Application) before init.");     // Catch: Throwable -> L14
    L30:
        r5 = (Application) r10.getApplicationContext();     // Catch: Throwable -> L26
        if (r5 == null) goto L25;
        if (r5.getBaseContext() == null) goto L21;
        r10 = r5.getBaseContext();     // Catch: Throwable -> L14
        goto L21
    L25:
        throw new IllegalArgumentException("Please slardar oncall. Please invoke Npth.setApplication(Application) before init.");     // Catch: Throwable -> L14
    L27:
        throw new IllegalArgumentException("Please slardar oncall. Please invoke Npth.setApplication(Application) before init.");     // Catch: Throwable -> L14
    L14:
        th = move-exception;
        throw th;
    }

    public static void d(String r5) {
        if (f4088l == null) goto L22;
        Context r10 = GwpAsan.f4038n;
        String r11 = com.bytedance.crash.util.g.f4181a;
        if (r10 != null) goto L7;
        r10 = n.f4057a;
    L7:
        File[] r12 = new File(com.bytedance.crash.util.g.h(r10), com.bytedance.crash.util.g.f4182b).listFiles();
        if (r12 != null) goto L10;
        return;
    L10:
        if (r12.length <= 0) goto L30;
        int r13 = r12.length;
        int r14 = 0;
    L13:
        if (r14 >= r13) goto L31;
        File r15 = r12[r14];
        if (r15.isFile() == true) goto L21;
        GwpAsan.f(r15, r5);     // Catch: Throwable -> L19
    L19:
        th = move-exception;
        c.f4025a.getClass();
        m.b.h("NPTH_CATCH", th);
    L21:
        r14 = r14 + 1;
        goto L13
    L31:
        return;
    L30:
        return;
    }

    public static boolean e() {
        if (d9.b.f16613h == false) goto L5;
        return true;
    L5:
        if (NativeImpl.j() == true) goto L11;
        return false;
    L11:
        return true;
    }

    public static void f() {
        f4087k.getClass();
        Context r5 = n.f4057a;
        String r10 = com.bytedance.crash.util.g.f4181a;
        File[] r11 = new File(com.bytedance.crash.util.g.h(r5), "npth/NativeHeapTracker").listFiles();
        if (r11 == null) goto L15;
        int r12 = r11.length;
        int r13 = 0;
    L6:
        if (r13 >= r12) goto L22;
        File r14 = r11[r13];
        if (r14.isFile() == true) goto L14;
        NativeHeapTracker.e(r14);     // Catch: Throwable -> L12
    L12:
        th = move-exception;
        c.f4025a.getClass();
        m.b.h("NPTH_CATCH", th);
    L14:
        r13 = r13 + 1;
        goto L6
    L22:
        return;
    }
}
