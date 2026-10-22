package com.google.android.material.snackbar;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.obric.cae.userAware.NearElevator.NearElevator;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes2.dex */
class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static b f4103a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Object f4104b;
    private final Handler c;
    private C0187b d;
    private C0187b e;

    interface a {
        void a();

        void a(int r1);
    }

    /* JADX INFO: renamed from: com.google.android.material.snackbar.b$b, reason: collision with other inner class name */
    private static class C0187b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final WeakReference<a> f4106a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        int f4107b;
        boolean c;

        boolean a(a r3) {
            a r4 = (a) ZeusTransformUtils.wrapperContextForParams(r3, a.class, "com.obric.memorydata.plugin");
            if (r4 != null) goto L5;
        L7:
            return false;
        L5:
            if (this.f4106a.get() != r4) goto L7;
            return true;
        }
    }

    private b() {
        this.f4104b = new Object();
        this.c = new Handler(Looper.getMainLooper(), new AnonymousClass1(this));
    }

    static b a() {
        if (f4103a != null) goto L6;
        f4103a = new b();
    L6:
        return f4103a;
    }

    private boolean a(C0187b r4, int r5) {
        a r0 = (a) ZeusTransformUtils.preCheckCast(r4.f4106a.get(), a.class, "com.obric.memorydata.plugin");
        if (r0 == null) goto L6;
        this.c.removeCallbacksAndMessages(r4);
        r0.a(r5);
        return true;
    L6:
        return false;
    }

    private void b() {
        C0187b r0 = this.e;
        if (r0 == null) goto L9;
        this.d = r0;
        this.e = null;
        a r1 = (a) ZeusTransformUtils.preCheckCast(r0.f4106a.get(), a.class, "com.obric.memorydata.plugin");
        if (r1 == null) goto L7;
        r1.a();
        return;
    L7:
        this.d = null;
        return;
    }

    private void b(C0187b r4) {
        if (r4.f4107b != (-2)) goto L5;
        return;
    L5:
        int r0 = 2750;
        if (r4.f4107b <= 0) goto L9;
        r0 = r4.f4107b;
    L11:
        this.c.removeCallbacksAndMessages(r4);
        Handler r3 = this.c;
        r3.sendMessageDelayed(Message.obtain(r3, 0, r4), r0);
        return;
    L9:
        if (r4.f4107b != (-1)) goto L11;
        r0 = NearElevator.WIFI_SCAN_INTERVAL_WHEN_OUT_ELEVATOR;
        goto L11
    }

    private boolean f(a r3) {
        a r4 = (a) ZeusTransformUtils.wrapperContextForParams(r3, a.class, "com.obric.memorydata.plugin");
        C0187b r2 = this.d;
        if (r2 != null) goto L5;
    L7:
        return false;
    L5:
        if (r2.a(r4) == false) goto L7;
        return true;
    }

    private boolean g(a r3) {
        a r4 = (a) ZeusTransformUtils.wrapperContextForParams(r3, a.class, "com.obric.memorydata.plugin");
        C0187b r2 = this.e;
        if (r2 != null) goto L5;
    L7:
        return false;
    L5:
        if (r2.a(r4) == false) goto L7;
        return true;
    }

    public void a(a r3) {
        a r4 = (a) ZeusTransformUtils.wrapperContextForParams(r3, a.class, "com.obric.memorydata.plugin");
        Object r0 = this.f4104b;
        monitor-enter(r0);
    L11:
        th = move-exception;
        throw th;
    L5:
        if (f(r4) == false) goto L9;
        this.d = null;     // Catch: Throwable -> L11
        if (this.e == null) goto L9;
        b();     // Catch: Throwable -> L11
    L9:
        monitor-exit(r0);     // Catch: Throwable -> L11
    }

    public void a(a r3, int r4) {
        a r5 = (a) ZeusTransformUtils.wrapperContextForParams(r3, a.class, "com.obric.memorydata.plugin");
        Object r0 = this.f4104b;
        monitor-enter(r0);
    L13:
        th = move-exception;
        throw th;
    L5:
        if (f(r5) == false) goto L9;
        C0187b r6 = this.d;     // Catch: Throwable -> L13
    L7:
        a(r6, r4);     // Catch: Throwable -> L13
    L11:
        monitor-exit(r0);     // Catch: Throwable -> L13
        return;
    L9:
        if (g(r5) == false) goto L11;
        r6 = this.e;     // Catch: Throwable -> L13
        goto L7
    }

    void a(C0187b r3) {
        Object r0 = this.f4104b;
        monitor-enter(r0);
    L11:
        th = move-exception;
        throw th;
    L5:
        if (this.d != r3) goto L7;
    L8:
        a(r3, 2);     // Catch: Throwable -> L11
    L9:
        monitor-exit(r0);     // Catch: Throwable -> L11
        return;
    L7:
        if (this.e != r3) goto L9;
        goto L8
    }

    public void b(a r3) {
        a r4 = (a) ZeusTransformUtils.wrapperContextForParams(r3, a.class, "com.obric.memorydata.plugin");
        Object r0 = this.f4104b;
        monitor-enter(r0);
    L9:
        th = move-exception;
        throw th;
    L5:
        if (f(r4) == false) goto L7;
        b(this.d);     // Catch: Throwable -> L9
    L7:
        monitor-exit(r0);     // Catch: Throwable -> L9
    }

    public void c(a r3) {
        a r4 = (a) ZeusTransformUtils.wrapperContextForParams(r3, a.class, "com.obric.memorydata.plugin");
        Object r0 = this.f4104b;
        monitor-enter(r0);
    L11:
        th = move-exception;
        throw th;
    L5:
        if (f(r4) == true) goto L7;
    L9:
        monitor-exit(r0);     // Catch: Throwable -> L11
        return;
    L7:
        if (this.d.c == true) goto L9;
        this.d.c = true;     // Catch: Throwable -> L11
        this.c.removeCallbacksAndMessages(this.d);     // Catch: Throwable -> L11
        goto L9
    }

    public void d(a r3) {
        a r4 = (a) ZeusTransformUtils.wrapperContextForParams(r3, a.class, "com.obric.memorydata.plugin");
        Object r0 = this.f4104b;
        monitor-enter(r0);
    L11:
        th = move-exception;
        throw th;
    L5:
        if (f(r4) == true) goto L7;
    L9:
        monitor-exit(r0);     // Catch: Throwable -> L11
        return;
    L7:
        if (this.d.c == false) goto L9;
        this.d.c = false;     // Catch: Throwable -> L11
        b(this.d);     // Catch: Throwable -> L11
        goto L9
    }

    public boolean e(a r3) {
        a r4 = (a) ZeusTransformUtils.wrapperContextForParams(r3, a.class, "com.obric.memorydata.plugin");
        Object r0 = this.f4104b;
        monitor-enter(r0);
    L13:
        th = move-exception;
        throw th;
    L5:
        if (f(r4) == false) goto L7;
    L10:
        boolean r2 = true;
    L11:
        monitor-exit(r0);     // Catch: Throwable -> L13
        return r2;
    L7:
        if (g(r4) == true) goto L10;
        r2 = false;
        goto L11
    }
}
