package com.bytedance.retrofit2;

import android.os.SystemClock;
import android.util.Log;
import java.io.IOException;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class d<T> implements q4.a, m {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final s<T> f2502c;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private volatile n4.e f2503g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private n4.c f2504h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private volatile boolean f2505i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private Throwable f2506j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private volatile boolean f2507k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private volatile long f2508l;

    public d(s<T> r10) {
        this.f2502c = r10;
    }

    private n4.e e(n4.c r10) {
        return this.f2502c.f2647b.get().a(r10);
    }

    private n4.d f(n4.e r10, RetrofitMetrics r11) {
        if (r11 == null) goto L5;
        r11.M = SystemClock.uptimeMillis();
    L5:
        return r10.execute();
    }

    @Override // q4.a
    public a0 a(q4.a.InterfaceC0283a r10) {
        RetrofitMetrics r11 = r10.b();
        if (r11 == null) goto L5;
        r11.f2459r = System.currentTimeMillis();
    L5:
        long r12 = SystemClock.uptimeMillis();
        n4.c r13 = r10.a();
        this.f2504h = r13;
        if (r11 == null) goto L8;
        r13.B();
        this.f2504h.E();
    L8:
        monitor-enter(this);
    L75:
        th = move-exception;
        throw th;
    L10:
        if (this.f2507k == true) goto L74;
        this.f2507k = true;     // Catch: Throwable -> L75
        monitor-exit(this);     // Catch: Throwable -> L75
        Throwable r14 = this.f2506j;
        if (r14 != null) goto L16;
        n4.c r15 = this.f2504h;
        if (r15 == null) goto L24;
        r15.S(r11);
    L24:
        n4.d r16 = null;
        if (this.f2502c.f2659n == null) goto L30;
        if (r11 == null) goto L28;
        r11.S.put("CallServerInterceptor", Long.valueOf(SystemClock.uptimeMillis() - r12));
    L28:
        r16 = this.f2502c.f2659n.b(this.f2504h);
    L30:
        if (r16 == null) goto L79;
    L64:
        if (r11 == null) goto L69;
        List<n4.b> r17 = r16.h("content-encoding");
        if (r17 == null) goto L68;
        r17.get(0).b();
    L68:
        r11.k(this);
    L69:
        long r18 = SystemClock.uptimeMillis();
        a0<T> r19 = i(r16, r11);
        if (r11 == null) goto L72;
        r11.T.put("CallServerInterceptor", Long.valueOf(SystemClock.uptimeMillis() - r18));
    L72:
        return r19;
    L79:
        this.f2503g = e(this.f2504h);     // Catch: Throwable -> L54 Throwable -> L61
        if (this.f2508l <= 0) goto L37;
        long r20 = SystemClock.uptimeMillis();     // Catch: Throwable -> L54 Throwable -> L61
        this.f2503g.c(this.f2508l);     // Catch: Throwable -> L54 Throwable -> L61
        if (r11 == null) goto L37;
        r11.f2464t0 = SystemClock.uptimeMillis() - r20;     // Catch: Throwable -> L54 Throwable -> L61
    L37:
        if (this.f2505i == false) goto L39;
        this.f2503g.cancel();
    L39:
        if (r11 == null) goto L46;
        r11.S.put("CallServerInterceptor", Long.valueOf(SystemClock.uptimeMillis() - r12));
        List<n4.b> r21 = this.f2504h.H("content-encoding");
        if (r21 != null) goto L43;
    L45:
        r11.h();
        goto L46
    L43:
        if (r21.size() <= 0) goto L45;
        this.f2504h.H("content-encoding").get(0).b();
    L46:
        r16 = f(this.f2503g, r11);
        if (r11 == null) goto L49;
        r11.Q = true;
    L49:
        m4.a r110 = this.f2502c.f2659n;
        if (r110 == null) goto L64;
        n4.d r111 = r110.a(this.f2504h, r16);
        if (r111 == null) goto L64;
        r16 = r111;
    L61:
        e = move-exception;
        this.f2506j = e;
        throw e;
    L54:
        th = move-exception;
        this.f2506j = th;
        if ((th instanceof Exception) == false) goto L60;
        throw th;
    L60:
        throw new Exception(th);
    L16:
        if ((r14 instanceof IOException) == false) goto L20;
        throw ((IOException) r14);
    L20:
        throw new Exception(this.f2506j);
    L74:
        throw new IllegalStateException("Already executed.");     // Catch: Throwable -> L75
    }

    public void c() {
        this.f2505i = true;
        if (this.f2503g == null) goto L6;
        this.f2503g.cancel();
        return;
    }

    public void d(boolean r10, Throwable r11, boolean r12) {
        this.f2505i = r10;
        if (this.f2503g != null) goto L5;
        return;
    L5:
        if ((this.f2503g instanceof s4.c) == false) goto L9;
        ((s4.c) this.f2503g).a(r11, r12);
        return;
    }

    public boolean g() {
        return this.f2505i;
    }

    public synchronized boolean h() {
        monitor-enter(this);
        boolean r10 = this.f2507k;     // Catch: Throwable -> L6
        monitor-exit(this);
        return r10;
    L6:
        th = move-exception;
        throw th;
    }

    a0<T> i(n4.d r10, RetrofitMetrics r11) {
        if (r10 == null) goto L28;
        r4.e r12 = r10.a();
        int r13 = r10.e();
        if (r13 < 200) goto L26;
        if (r13 >= 300) goto L26;
        if (r13 == 204) goto L24;
        if (r13 == 205) goto L24;
        if (r11 != null) goto L29;
    L15:
        T r14 = this.f2502c.e(r12);     // Catch: Throwable -> L20
        if (r11 == null) goto L18;
        r11.P = SystemClock.uptimeMillis();     // Catch: Throwable -> L20
    L18:
        return a0.j(r14, r10);
    L20:
        th = move-exception;
        Log.i("ToResponseLog", "toResponse failed");
        throw th;
    L29:
        r11.O = SystemClock.uptimeMillis();     // Catch: Throwable -> L20
    L24:
        return a0.j(null, r10);
    L26:
        return a0.c(r12, r10);
    L28:
        throw new IOException("SsResponse is null");
    }

    public n4.c j() {
        return this.f2504h;
    }

    public synchronized void k() {
        monitor-enter(this);
        this.f2507k = false;     // Catch: Throwable -> L7
        monitor-exit(this);
        return;
    L7:
        th = move-exception;
        throw th;
    }
}
