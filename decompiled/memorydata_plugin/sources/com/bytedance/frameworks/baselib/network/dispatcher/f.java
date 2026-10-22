package com.bytedance.frameworks.baselib.network.dispatcher;

import java.util.concurrent.ThreadPoolExecutor;

/* JADX INFO: loaded from: classes2.dex */
public class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private ThreadPoolExecutor f2337a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private ThreadPoolExecutor f2338b;
    private ThreadPoolExecutor c;
    private ThreadPoolExecutor d;
    private ThreadPoolExecutor e;
    private int f;
    private int g;
    private int h;
    private int i;
    private int j;
    private int k;
    private long l;
    private long m;
    private long n;
    private long o;
    private boolean p;

    /* JADX INFO: renamed from: com.bytedance.frameworks.baselib.network.dispatcher.f$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private ThreadPoolExecutor f2339a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private ThreadPoolExecutor f2340b;
        private ThreadPoolExecutor c;
        private ThreadPoolExecutor d;
        private ThreadPoolExecutor e;
        private int f;
        private int g;
        private int h;
        private int i;
        private long j;
        private long k;
        private long l;
        private int m;
        private boolean n;
        private int o;
        private long p;

        public a() {
            this.n = true;
        }

        static /* synthetic */ ThreadPoolExecutor a(a r0) {
            return r0.f2340b;
        }

        static /* synthetic */ ThreadPoolExecutor b(a r0) {
            return r0.f2339a;
        }

        static /* synthetic */ ThreadPoolExecutor c(a r0) {
            return r0.c;
        }

        static /* synthetic */ ThreadPoolExecutor d(a r0) {
            return r0.d;
        }

        static /* synthetic */ ThreadPoolExecutor e(a r0) {
            return r0.e;
        }

        static /* synthetic */ int f(a r0) {
            return r0.f;
        }

        static /* synthetic */ int g(a r0) {
            return r0.g;
        }

        static /* synthetic */ int h(a r0) {
            return r0.h;
        }

        static /* synthetic */ int i(a r0) {
            return r0.i;
        }

        static /* synthetic */ long j(a r2) {
            return r2.j;
        }

        static /* synthetic */ long k(a r2) {
            return r2.k;
        }

        static /* synthetic */ long l(a r2) {
            return r2.l;
        }

        static /* synthetic */ int m(a r0) {
            return r0.m;
        }

        static /* synthetic */ int n(a r0) {
            return r0.o;
        }

        static /* synthetic */ long o(a r2) {
            return r2.p;
        }

        static /* synthetic */ boolean p(a r0) {
            return r0.n;
        }

        public a a(int r1, int r2) {
            if (r2 <= 0) goto L10;
            if (r1 <= 0) goto L10;
            if (r1 > r2) goto L8;
            this.f = r2;
            this.h = r1;
            return this;
        L8:
            throw new IllegalArgumentException("Core thread size must set less equal than Max thread size.");
        L10:
            throw new IllegalArgumentException("Api thread size must set > 0.");
        }

        public a a(long r3) {
            if (r3 <= 0) goto L7;
            this.j = r3;
            return this;
        L7:
            throw new IllegalArgumentException("Api keep alive time must set > 0 when allow core thread timeout.");
        }

        public a a(boolean r1) {
            this.n = r1;
            return this;
        }

        public f a() {
            return new f(this, null);
        }

        public a b(int r1, int r2) {
            if (r2 <= 0) goto L10;
            if (r1 <= 0) goto L10;
            if (r1 > r2) goto L8;
            this.g = r2;
            this.i = r1;
            return this;
        L8:
            throw new IllegalArgumentException("Core thread size must set less equal than Max thread size.");
        L10:
            throw new IllegalArgumentException("Download thread size must set > 0.");
        }

        public a b(long r3) {
            if (r3 <= 0) goto L7;
            this.k = r3;
            return this;
        L7:
            throw new IllegalArgumentException("Download keep alive time must set > 0 when allow core thread timeout.");
        }

        public a c(long r3) {
            if (r3 <= 0) goto L7;
            this.l = r3;
            return this;
        L7:
            throw new IllegalArgumentException("Immediate keep alive time must set > 0 when allow core thread timeout.");
        }
    }

    private f(a r7) {
        this.f = 0;
        this.g = 8;
        this.h = 8;
        this.i = 1;
        this.j = 8;
        this.k = 8;
        this.l = 10;
        this.m = 30;
        this.n = 10;
        this.o = 10;
        this.p = true;
        if (a.a(r7) == null) goto L6;
        this.f2337a = a.a(r7);
    L6:
        if (a.b(r7) == null) goto L9;
        this.f2338b = a.b(r7);
    L9:
        if (a.c(r7) == null) goto L12;
        this.c = a.c(r7);
    L12:
        if (a.d(r7) == null) goto L15;
        this.d = a.d(r7);
    L15:
        if (a.e(r7) == null) goto L18;
        this.e = a.e(r7);
    L18:
        if (a.f(r7) <= 0) goto L21;
        this.j = a.f(r7);
    L21:
        if (a.g(r7) <= 0) goto L24;
        this.k = a.g(r7);
    L24:
        if (a.h(r7) <= 0) goto L27;
        this.g = a.h(r7);
    L27:
        if (a.i(r7) <= 0) goto L30;
        this.h = a.i(r7);
    L30:
        if (a.j(r7) <= 0) goto L33;
        this.m = a.j(r7);
    L33:
        if (a.k(r7) <= 0) goto L36;
        this.n = a.k(r7);
    L36:
        if (a.l(r7) <= 0) goto L39;
        this.l = a.l(r7);
    L39:
        if (a.m(r7) < 0) goto L42;
        this.f = a.m(r7);
    L42:
        if (a.n(r7) <= 0) goto L45;
        this.i = a.n(r7);
    L45:
        if (a.o(r7) <= 0) goto L47;
        this.o = a.o(r7);
    L47:
        this.p = a.p(r7);
    }

    /* synthetic */ f(a r1, AnonymousClass1 r2) {
        this(r1);
    }

    public static a q() {
        return new a();
    }

    public ThreadPoolExecutor a() {
        return this.f2337a;
    }

    public void a(boolean r1) {
        this.p = r1;
    }

    public ThreadPoolExecutor b() {
        return this.f2338b;
    }

    public ThreadPoolExecutor c() {
        return this.c;
    }

    public ThreadPoolExecutor d() {
        return this.d;
    }

    public ThreadPoolExecutor e() {
        return this.e;
    }

    public int f() {
        return this.j;
    }

    public int g() {
        return this.k;
    }

    public int h() {
        return this.i;
    }

    public long i() {
        return this.o;
    }

    public int j() {
        return this.g;
    }

    public int k() {
        return this.h;
    }

    public long l() {
        return this.m;
    }

    public long m() {
        return this.n;
    }

    public long n() {
        return this.l;
    }

    public int o() {
        return this.f;
    }

    public boolean p() {
        return this.p;
    }
}
