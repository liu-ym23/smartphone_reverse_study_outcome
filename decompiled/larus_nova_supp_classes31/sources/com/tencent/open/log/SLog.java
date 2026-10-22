package com.tencent.open.log;

import android.os.Environment;
import android.text.TextUtils;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.io.File;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public class SLog implements TraceLevel {
    public static final String TAG = "openSDK_LOG";
    private static boolean c;
    public static SLog instance;
    protected a a;
    private Tracer b;

    public static File a() {
        String r0 = c.d;
        d.c r1 = d.b.b();     // Catch: Throwable -> L13
        if (r1 != null) goto L6;
    L8:
        boolean r2 = false;
    L9:
        if (r2 == false) goto L18;
        return new PolarisFileWrapper(Environment.getExternalStorageDirectory(), r0);
    L18:
        return new PolarisFileWrapper(com.tencent.open.utils.g.c(), r0);
    L6:
        if (r1.c() <= c.f) goto L8;
        r2 = true;
    L13:
        th = move-exception;
        e(TAG, "getLogFilePath:", th);
        return null;
    }

    private void d() {
        this.a = new a(new b(a(), c.m, c.g, c.h, c.c, c.i, 10, c.e, c.n));
    }

    public static SLog getInstance() {
        if (instance != null) goto L15;
        monitor-enter(SLog.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (instance != null) goto L9;
        SLog r1 = new SLog();     // Catch: Throwable -> L11
        instance = r1;     // Catch: Throwable -> L11
        r1.d();     // Catch: Throwable -> L11
        c = true;     // Catch: Throwable -> L11
    L9:
        monitor-exit(SLog.class);     // Catch: Throwable -> L11
    L15:
        return instance;
    }

    public static void release() {
        monitor-enter(SLog.class);
        getInstance().b();     // Catch: Throwable -> L9
        if (instance == null) goto L7;
        instance = null;     // Catch: Throwable -> L9
    L7:
        monitor-exit(SLog.class);     // Catch: Throwable -> L9
        return;
    L9:
        th = move-exception;
        throw th;
    }

    public void b() {
        a r0 = this.a;
        if (r0 == null) goto L6;
        r0.a();
        this.a.b();
        this.a = null;
        return;
    }

    public void c() {
        a r0 = this.a;
        if (r0 == null) goto L6;
        r0.a();
        return;
    }

    public static void flushLogs() {
        getInstance().c();
    }

    private SLog() {
    }

    private String a(String r2) {
        if (TextUtils.isEmpty(r2) == false) goto L7;
        return "";
    L7:
        if (d.a(r2) == false) goto L10;
        return "xxxxxx";
    L10:
        return r2;
    }

    public void setCustomLogger(Tracer r1) {
        this.b = r1;
    }

    public static final void d(String r3, String r4) {
        getInstance().a(2, r3, r4, null);
    }

    public static final void e(String r3, String r4) {
        getInstance().a(16, r3, r4, null);
    }

    public static final void i(String r3, String r4) {
        getInstance().a(4, r3, r4, null);
    }

    public static final void u(String r3, String r4) {
        getInstance().a(32, r3, r4, null);
    }

    public static final void v(String r3, String r4) {
        getInstance().a(1, r3, r4, null);
    }

    public static final void w(String r3, String r4) {
        getInstance().a(8, r3, r4, null);
    }

    public static final void d(String r2, String r3, Throwable r4) {
        getInstance().a(2, r2, r3, r4);
    }

    public static final void e(String r2, String r3, Throwable r4) {
        getInstance().a(16, r2, r3, r4);
    }

    public static final void i(String r2, String r3, Throwable r4) {
        getInstance().a(4, r2, r3, r4);
    }

    public static final void u(String r2, String r3, Throwable r4) {
        getInstance().a(32, r2, r3, r4);
    }

    public static final void v(String r2, String r3, Throwable r4) {
        getInstance().a(1, r2, r3, r4);
    }

    public static final void w(String r2, String r3, Throwable r4) {
        getInstance().a(8, r2, r3, r4);
    }

    public void a(int r11, String r12, String r13, Throwable r14) {
        if (c == false) goto L11;
        String r0 = com.tencent.open.utils.g.b();
        if (TextUtils.isEmpty(r0) == true) goto L11;
        String r1 = r0 + " SDK_VERSION:3.5.11.lite";
        if (this.a != null) goto L10;
        return;
    L10:
        e.a.a(32, ThreadMethodProxy.currentThread(), System.currentTimeMillis(), TAG, r1, null);
        this.a.a(32, ThreadMethodProxy.currentThread(), System.currentTimeMillis(), TAG, r1, null);
        c = false;
    L11:
        e.a.a(r11, ThreadMethodProxy.currentThread(), System.currentTimeMillis(), r12, r13, r14);
        if (d.a.a(c.b, r11) == false) goto L17;
        a r2 = this.a;
        if (r2 != null) goto L16;
        return;
    L16:
        r2.a(r11, ThreadMethodProxy.currentThread(), System.currentTimeMillis(), r12, r13, r14);
    L17:
        Tracer r3 = this.b;
        if (r3 == null) goto L24;
        r3.a(r11, ThreadMethodProxy.currentThread(), System.currentTimeMillis(), r12, a(r13), r14);     // Catch: Exception -> L21
        return;
    L25:
        return;
    }
}
