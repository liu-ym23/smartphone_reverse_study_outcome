package com.bytedance.retrofit2;

import android.os.SystemClock;
import android.util.Log;
import com.bytedance.common.utility.Logger;
import com.bytedance.retrofit2.ttnet.TTNetExceptionStorage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Objects;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes.dex */
public class z<T> implements com.bytedance.retrofit2.b<T>, m {

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private static s4.b f2728m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private static b f2729n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private static c f2730o;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private n4.c f2731c;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final s<T> f2732g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final Object[] f2733h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private n4.c f2734i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final d f2735j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final RetrofitMetrics f2736k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private long f2737l;

    class a implements b0 {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ RetrofitMetrics f2738c;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ k f2739g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        final /* synthetic */ e f2740h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        final /* synthetic */ z f2741i;

        a(z r10, RetrofitMetrics r11, k r12, e r13) {
            this.f2741i = r10;
            this.f2738c = r11;
            this.f2739g = r12;
            this.f2740h = r13;
        }

        private void a(Throwable r10) {
            this.f2740h.b(this.f2741i, r10);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            th.printStackTrace();
        }

        private void b(a0<T> r10) {
            this.f2740h.a(this.f2741i, r10);     // Catch: Throwable -> L6
            k r11 = this.f2739g;     // Catch: Throwable -> L6
            if (r11 == null) goto L11;
            r11.d(this.f2741i, r10);     // Catch: Throwable -> L6
            return;
        L11:
            return;
        L6:
            th = move-exception;
            th.printStackTrace();
        }

        @Override // com.bytedance.retrofit2.b0
        public int D() {
            if (z.l() != null) goto L5;
        L8:
            n4.c r10 = z.d(this.f2741i);
            z r11 = this.f2741i;
            if (r10 == null) goto L13;
            return z.d(r11).B();
        L13:
            return z.g(r11).f2650e;
        L5:
            if (z.d(this.f2741i) == null) goto L8;
            return z.l().a(z.d(this.f2741i).A(), z.g(this.f2741i).f2650e);
        }

        @Override // com.bytedance.retrofit2.b0
        public boolean M() {
            return z.g(this.f2741i).f2653h;
        }

        @Override // java.lang.Runnable
        public void run() {
        L14:
            th = move-exception;
            RetrofitMetrics r10 = this.f2738c;     // Catch: Throwable -> L20
            r10.f2454o0 = SystemClock.uptimeMillis();     // Catch: Throwable -> L20
            a(th);     // Catch: Throwable -> L20
            RetrofitMetrics r11 = this.f2738c;     // Catch: Throwable -> L20
            r11.f2456p0 = SystemClock.uptimeMillis();     // Catch: Throwable -> L20
            z.h(this.f2741i, th, true);     // Catch: Throwable -> L20
            if (z.i() == null) goto L30;
            z.i().b(z.j(this.f2741i));
            return;
        L30:
            return;
        L20:
            th = move-exception;
            if (z.i() == null) goto L24;
            z.i().b(z.j(this.f2741i));
        L24:
            throw th;
        L4:
            if (z.d(this.f2741i) != null) goto L6;
            RetrofitMetrics r12 = this.f2738c;     // Catch: Throwable -> L14
            r12.K = SystemClock.uptimeMillis();     // Catch: Throwable -> L14
            z r13 = this.f2741i;     // Catch: Throwable -> L14
            z.e(r13, z.g(r13).d(this.f2739g, z.f(this.f2741i)));     // Catch: Throwable -> L14
            RetrofitMetrics r14 = this.f2738c;     // Catch: Throwable -> L14
            r14.L = SystemClock.uptimeMillis();     // Catch: Throwable -> L14
        L6:
            a0 r15 = this.f2741i.p();     // Catch: Throwable -> L14
            if (z.i() == null) goto L10;
            z.i().b(z.j(this.f2741i));
        L10:
            RetrofitMetrics r16 = this.f2738c;
            r16.f2454o0 = SystemClock.uptimeMillis();
            b(r15);
            RetrofitMetrics r17 = this.f2738c;
            r17.f2456p0 = SystemClock.uptimeMillis();
            if (M() == true) goto L29;
            z.k(this.f2741i, r15, true);
            return;
        }

        @Override // com.bytedance.retrofit2.b0
        public RetrofitMetrics u() {
            return this.f2741i.q();
        }

        @Override // com.bytedance.retrofit2.b0
        public int v() {
            return 0;
        }
    }

    public interface b {
        boolean a();

        void b(long r10, long r11, String r12, String r13, Object r14);

        void c(long r10, long r11, String r12, String r13, Object r14, Throwable r15);
    }

    public interface c {
        int a(String r10, int r11);
    }

    z(s<T> r10, Object[] r11) {
        this.f2731c = null;
        this.f2732g = r10;
        this.f2733h = r11;
        this.f2735j = new d(r10);
        this.f2736k = r10.a().a();
    }

    static /* synthetic */ n4.c d(z r10) {
        return r10.f2734i;
    }

    static /* synthetic */ n4.c e(z r10, n4.c r11) {
        r10.f2734i = r11;
        return r11;
    }

    static /* synthetic */ Object[] f(z r10) {
        return r10.f2733h;
    }

    static /* synthetic */ s g(z r10) {
        return r10.f2732g;
    }

    static /* synthetic */ void h(z r10, Throwable r11, boolean r12) {
        r10.r(r11, r12);
    }

    static /* synthetic */ s4.b i() {
        return f2728m;
    }

    static /* synthetic */ n4.c j(z r10) {
        return r10.f2731c;
    }

    static /* synthetic */ void k(z r10, a0 r11, boolean r12) {
        r10.s(r11, r12);
    }

    static /* synthetic */ c l() {
        return f2730o;
    }

    private n4.c m(n4.c r10, RetrofitMetrics r11) {
        if (r11.E < 0) goto L6;
        n4.c.a r12 = r10.O();
        ArrayList r13 = new ArrayList();
        r13.addAll(r10.v());
        r13.add(new n4.b("state-delay", String.valueOf(r11.E)));
        r12.b(r13);
        return r12.a();
    L6:
        return r10;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void r(Throwable r14, boolean r15) {
        if (f2729n != null) goto L5;
        return;
    L5:
        if (r15 == false) goto L7;
        long r10 = this.f2736k.f2469w;
    L8:
        long r11 = SystemClock.uptimeMillis() - r10;
        if ((r14 instanceof TTNetExceptionStorage) == false) goto L18;
        TTNetExceptionStorage r16 = (TTNetExceptionStorage) r14;
        if (r16.needReport == true) goto L13;
        return;
    L13:
        if (r16.reportMonitorOk == false) goto L16;
        f2729n.b(r11, this.f2737l, r16.url, r16.traceCode, r16.infoObj);
    L16:
        if (r16.reportMonitorError == false) goto L32;
        f2729n.c(r11, this.f2737l, r16.url, r16.traceCode, r16.infoObj, r14);
        return;
    L32:
        return;
    L18:
        RetrofitMetrics r17 = this.f2736k;
        if (r17.Q == false) goto L23;
        r17.R = r14;
        Throwable r18 = null;
    L21:
        n(false, r18, false);
        return;
    L23:
        if ((r14 instanceof s4.a) == false) goto L28;
        boolean r19 = ((s4.a) r14).shouldReport();
        r18 = r14;
        if (r19 == true) goto L21;
        return;
    L28:
        if (f2729n.a() == false) goto L36;
        n(false, r14, true);
        return;
    L36:
        return;
    L7:
        r10 = this.f2736k.f2473y;
        goto L8
    }

    private void s(a0<T> r13, boolean r14) {
        if (Logger.debug() == false) goto L6;
        StringBuilder r10 = new StringBuilder();
        r10.append("current url is ");
        r10.append(this.f2734i.G());
        r10.append(" 00  ");
        RetrofitMetrics r11 = this.f2736k;
        r10.append(r11.f2424J - r11.f2469w);
        r10.append(" 01  ");
        RetrofitMetrics r12 = this.f2736k;
        r10.append(r12.f2424J - r12.f2473y);
        r10.append(" 1 interceptorRequestInfo ");
        r10.append(this.f2736k.f());
        r10.append(" 2 openConnectionDuration ");
        r10.append(this.f2736k.f2468v0);
        r10.append(" 3 setThrottleNetSpeedDuration ");
        r10.append(this.f2736k.f2464t0);
        r10.append(" 4 tryNecessaryInitDuration ");
        r10.append(this.f2736k.f2466u0);
        r10.append(" 5 openConnectionDuration ");
        r10.append(this.f2736k.f2468v0);
        r10.append(" 6 setConnectionDuration ");
        r10.append(this.f2736k.f2470w0);
        r10.append(" 7 prepareRequestDuration ");
        r10.append(this.f2736k.f2472x0);
        Logger.d("TTNetReport", r10.toString());
    L6:
        if (f2729n != null) goto L8;
        return;
    L8:
        if (isCanceled() == true) goto L15;
        if (r14 == false) goto L11;
        long r15 = this.f2736k.f2469w;
    L12:
        long r16 = SystemClock.uptimeMillis() - r15;
        f2729n.b(r16, this.f2737l, r13.h().g(), r13.h().f(), r13.h().b());
        return;
    L11:
        r15 = this.f2736k.f2473y;
        goto L12
    }

    public static void t(b r10) {
        f2729n = r10;
    }

    public static void u(s4.b r10) {
        f2728m = r10;
    }

    @Override // com.bytedance.retrofit2.b
    public n4.c a() {
        d r10 = this.f2735j;
        if (r10 == null) goto L8;
        n4.c r11 = r10.j();
        if (r11 == null) goto L8;
        return r11;
    L8:
        if (this.f2734i != null) goto L22;
        RetrofitMetrics r12 = this.f2736k;     // Catch: IOException -> L16 RuntimeException -> L19
        r12.K = SystemClock.uptimeMillis();     // Catch: IOException -> L16 RuntimeException -> L19
        Log.i("ToRequestLog", "before toRequest");     // Catch: IOException -> L16 RuntimeException -> L19
        n4.c r13 = this.f2732g.d(null, this.f2733h);     // Catch: IOException -> L16 RuntimeException -> L19
        this.f2734i = r13;     // Catch: IOException -> L16 RuntimeException -> L19
        if (r13 == null) goto L13;
        String r14 = "originalRequest build success.";
    L12:
        Log.i("ToRequestLog", r14);     // Catch: IOException -> L16 RuntimeException -> L19
        r12.L = SystemClock.uptimeMillis();     // Catch: IOException -> L16 RuntimeException -> L19
    L13:
        r14 = "originalRequest build failed.";
    L16:
        e = move-exception;
        throw new RuntimeException("Unable to create request.", e);
    L19:
        e = move-exception;
        throw e;
    L22:
        return this.f2734i;
    }

    @Override // com.bytedance.retrofit2.b
    public void c(e<T> r10) {
        RetrofitMetrics r11 = this.f2736k;
        r11.f2469w = SystemClock.uptimeMillis();
        r11.f2471x = System.nanoTime();
        this.f2737l = System.currentTimeMillis();
        Objects.requireNonNull(r10, "callback == null");
        d r12 = this.f2735j;
        if (r12 != null) goto L5;
    L9:
        Executor r13 = this.f2732g.f2649d;
        if ((r10 instanceof k) == false) goto L12;
        k r14 = (k) r10;
    L13:
        a r15 = new a(this, r11, r14, r10);
        r11.K = SystemClock.uptimeMillis();     // Catch: Throwable -> L24
        this.f2734i = this.f2732g.d(r14, this.f2733h);     // Catch: Throwable -> L24
        if (Logger.debug() == false) goto L17;
        Logger.d("SsHttpCall", "get enqueue " + this.f2734i.A());     // Catch: Throwable -> L24
    L17:
        r11.L = SystemClock.uptimeMillis();     // Catch: Throwable -> L24
        s4.b r16 = f2728m;     // Catch: Throwable -> L24
        if (r16 == null) goto L22;
        n4.c r17 = r16.c(this.f2734i);     // Catch: Throwable -> L24
        this.f2734i = r17;     // Catch: Throwable -> L24
        this.f2731c = r17;     // Catch: Throwable -> L24
        if (f2728m.d(r17, r11, r13, r15) == false) goto L22;
        return;
    L22:
        r13.execute(r15);
        return;
    L24:
        th = move-exception;
        th.printStackTrace();
        r10.b(this, th);
        r(th, true);
        s4.b r18 = f2728m;
        if (r18 == null) goto L31;
        r18.b(this.f2731c);
        return;
    L31:
        return;
    L12:
        r14 = null;
        goto L13
    L5:
        if (r12.h() == false) goto L9;
        throw new IllegalStateException("Already executed.");
    }

    @Override // com.bytedance.retrofit2.b
    public void cancel() {
        d r10 = this.f2735j;
        if (r10 == null) goto L6;
        r10.c();
        return;
    }

    @Override // com.bytedance.retrofit2.b
    public /* bridge */ /* synthetic */ com.bytedance.retrofit2.b clone() {
        return o();
    }

    /* JADX INFO: renamed from: clone, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m12clone() {
        return o();
    }

    @Override // com.bytedance.retrofit2.b
    public a0<T> execute() {
        RetrofitMetrics r10 = this.f2736k;
        r10.f2473y = SystemClock.uptimeMillis();
        r10.f2475z = System.nanoTime();
        this.f2737l = System.currentTimeMillis();
        r10.K = SystemClock.uptimeMillis();
        this.f2734i = this.f2732g.d(null, this.f2733h);     // Catch: Exception -> L26
        r10.L = SystemClock.uptimeMillis();
        if (Logger.debug() == false) goto L33;
        Logger.d("SsHttpCall", "get execute " + this.f2734i.A());
    L33:
        s4.b r11 = f2728m;     // Catch: Throwable -> L18
        if (r11 == null) goto L11;
        n4.c r12 = r11.c(this.f2734i);     // Catch: Throwable -> L18
        this.f2734i = r12;     // Catch: Throwable -> L18
        this.f2731c = r12;     // Catch: Throwable -> L18
        f2728m.a(r12, r10);     // Catch: Throwable -> L18
    L11:
        a0<T> r13 = p();     // Catch: Throwable -> L18
        SystemClock.uptimeMillis();     // Catch: Throwable -> L18
        if (this.f2732g.f2653h == true) goto L14;
        s(r13, false);     // Catch: Throwable -> L18
    L14:
        s4.b r14 = f2728m;
        if (r14 == null) goto L17;
        r14.b(this.f2731c);
    L17:
        return r13;
    L18:
        th = move-exception;
        SystemClock.uptimeMillis();     // Catch: Throwable -> L21
        r(th, false);     // Catch: Throwable -> L21
        throw th;     // Catch: Throwable -> L21
    L21:
        th = move-exception;
        s4.b r15 = f2728m;
        if (r15 == null) goto L25;
        r15.b(this.f2731c);
    L25:
        throw th;
    L26:
        e = move-exception;
        Log.i("ToRequestLog", "catch and rethrow build ex in execute()");
        throw e;
    }

    @Override // com.bytedance.retrofit2.b
    public boolean isCanceled() {
        d r10 = this.f2735j;
        if (r10 != null) goto L5;
    L7:
        return false;
    L5:
        if (r10.g() == false) goto L7;
        return true;
    }

    public void n(boolean r10, Throwable r11, boolean r12) {
        d r13 = this.f2735j;
        if (r13 == null) goto L6;
        r13.d(r10, r11, r12);
        return;
    }

    public z<T> o() {
        return new z(this.f2732g, this.f2733h);
    }

    a0 p() {
        RetrofitMetrics r10 = this.f2736k;
        r10.f2424J = SystemClock.uptimeMillis();
        if (Logger.debug() == false) goto L5;
        Logger.d("SsHttpCall", "real send " + this.f2734i.A());
    L5:
        LinkedList r11 = new LinkedList();
        if (a().L() == true) goto L8;
        r11.addAll(this.f2732g.f2648c);
    L8:
        r11.add(this.f2735j);
        if (Logger.debug() == false) goto L11;
        this.f2734i = m(this.f2734i, r10);
    L11:
        r10.f2455p = this.f2737l;
        r10.f2457q = System.currentTimeMillis();
        this.f2734i.S(r10);
        a0 r12 = new q4.b(r11, 0, this.f2734i, this, r10).c(this.f2734i);
        r12.i(r10);
        return r12;
    }

    public RetrofitMetrics q() {
        return this.f2736k;
    }
}
