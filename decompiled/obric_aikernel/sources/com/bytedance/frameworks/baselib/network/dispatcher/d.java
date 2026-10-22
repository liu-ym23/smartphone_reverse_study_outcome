package com.bytedance.frameworks.baselib.network.dispatcher;

import java.util.concurrent.ThreadPoolExecutor;

/* JADX INFO: loaded from: classes.dex */
public class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private ThreadPoolExecutor f1574a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private ThreadPoolExecutor f1575b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private ThreadPoolExecutor f1576c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private ThreadPoolExecutor f1577d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private ThreadPoolExecutor f1578e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f1579f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private int f1580g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private int f1581h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private int f1582i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private int f1583j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private int f1584k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private long f1585l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private long f1586m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private long f1587n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private long f1588o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private boolean f1589p;

    static /* synthetic */ class a {
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private ThreadPoolExecutor f1590a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private ThreadPoolExecutor f1591b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private ThreadPoolExecutor f1592c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private ThreadPoolExecutor f1593d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private ThreadPoolExecutor f1594e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private int f1595f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private int f1596g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private int f1597h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private int f1598i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        private long f1599j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        private long f1600k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        private long f1601l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        private int f1602m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        private boolean f1603n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        private int f1604o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        private long f1605p;

        public b() {
            this.f1603n = true;
        }

        static /* synthetic */ ThreadPoolExecutor a(b r10) {
            return r10.f1591b;
        }

        static /* synthetic */ ThreadPoolExecutor b(b r10) {
            return r10.f1590a;
        }

        static /* synthetic */ long c(b r10) {
            return r10.f1600k;
        }

        static /* synthetic */ long d(b r10) {
            return r10.f1601l;
        }

        static /* synthetic */ int e(b r10) {
            return r10.f1602m;
        }

        static /* synthetic */ int f(b r10) {
            return r10.f1604o;
        }

        static /* synthetic */ long g(b r10) {
            return r10.f1605p;
        }

        static /* synthetic */ boolean h(b r10) {
            return r10.f1603n;
        }

        static /* synthetic */ ThreadPoolExecutor i(b r10) {
            return r10.f1592c;
        }

        static /* synthetic */ ThreadPoolExecutor j(b r10) {
            return r10.f1593d;
        }

        static /* synthetic */ ThreadPoolExecutor k(b r10) {
            return r10.f1594e;
        }

        static /* synthetic */ int l(b r10) {
            return r10.f1595f;
        }

        static /* synthetic */ int m(b r10) {
            return r10.f1596g;
        }

        static /* synthetic */ int n(b r10) {
            return r10.f1597h;
        }

        static /* synthetic */ int o(b r10) {
            return r10.f1598i;
        }

        static /* synthetic */ long p(b r10) {
            return r10.f1599j;
        }

        public d q() {
            return new d(this, null);
        }

        public b r(long r10) {
            if (r10 <= 0) goto L7;
            this.f1599j = r10;
            return this;
        L7:
            throw new IllegalArgumentException("Api keep alive time must set > 0 when allow core thread timeout.");
        }

        public b s(int r10, int r11) {
            if (r11 <= 0) goto L10;
            if (r10 <= 0) goto L10;
            if (r10 > r11) goto L8;
            this.f1595f = r11;
            this.f1597h = r10;
            return this;
        L8:
            throw new IllegalArgumentException("Core thread size must set less equal than Max thread size.");
        L10:
            throw new IllegalArgumentException("Api thread size must set > 0.");
        }

        public b t(long r10) {
            if (r10 <= 0) goto L7;
            this.f1600k = r10;
            return this;
        L7:
            throw new IllegalArgumentException("Download keep alive time must set > 0 when allow core thread timeout.");
        }

        public b u(int r10, int r11) {
            if (r11 <= 0) goto L10;
            if (r10 <= 0) goto L10;
            if (r10 > r11) goto L8;
            this.f1596g = r11;
            this.f1598i = r10;
            return this;
        L8:
            throw new IllegalArgumentException("Core thread size must set less equal than Max thread size.");
        L10:
            throw new IllegalArgumentException("Download thread size must set > 0.");
        }

        public b v(boolean r10) {
            this.f1603n = r10;
            return this;
        }

        public b w(long r10) {
            if (r10 <= 0) goto L7;
            this.f1601l = r10;
            return this;
        L7:
            throw new IllegalArgumentException("Immediate keep alive time must set > 0 when allow core thread timeout.");
        }
    }

    private d(b r10) {
        this.f1579f = 0;
        this.f1580g = 8;
        this.f1581h = 8;
        this.f1582i = 1;
        this.f1583j = 8;
        this.f1584k = 8;
        this.f1585l = 10;
        this.f1586m = 30;
        this.f1587n = 10;
        this.f1588o = 10;
        this.f1589p = true;
        if (b.a(r10) == null) goto L6;
        this.f1574a = b.a(r10);
    L6:
        if (b.b(r10) == null) goto L9;
        this.f1575b = b.b(r10);
    L9:
        if (b.i(r10) == null) goto L12;
        this.f1576c = b.i(r10);
    L12:
        if (b.j(r10) == null) goto L15;
        this.f1577d = b.j(r10);
    L15:
        if (b.k(r10) == null) goto L18;
        this.f1578e = b.k(r10);
    L18:
        if (b.l(r10) <= 0) goto L21;
        this.f1583j = b.l(r10);
    L21:
        if (b.m(r10) <= 0) goto L24;
        this.f1584k = b.m(r10);
    L24:
        if (b.n(r10) <= 0) goto L27;
        this.f1580g = b.n(r10);
    L27:
        if (b.o(r10) <= 0) goto L30;
        this.f1581h = b.o(r10);
    L30:
        if (b.p(r10) <= 0) goto L33;
        this.f1586m = b.p(r10);
    L33:
        if (b.c(r10) <= 0) goto L36;
        this.f1587n = b.c(r10);
    L36:
        if (b.d(r10) <= 0) goto L39;
        this.f1585l = b.d(r10);
    L39:
        if (b.e(r10) < 0) goto L42;
        this.f1579f = b.e(r10);
    L42:
        if (b.f(r10) <= 0) goto L45;
        this.f1582i = b.f(r10);
    L45:
        if (b.g(r10) <= 0) goto L47;
        this.f1588o = b.g(r10);
    L47:
        this.f1589p = b.h(r10);
    }

    /* synthetic */ d(b r10, a r11) {
        this(r10);
    }

    public static b q() {
        return new b();
    }

    public long a() {
        return this.f1586m;
    }

    public int b() {
        return this.f1580g;
    }

    public int c() {
        return this.f1581h;
    }

    public int d() {
        return this.f1579f;
    }

    public int e() {
        return this.f1582i;
    }

    public long f() {
        return this.f1587n;
    }

    public ThreadPoolExecutor g() {
        return this.f1577d;
    }

    public long h() {
        return this.f1585l;
    }

    public ThreadPoolExecutor i() {
        return this.f1574a;
    }

    public ThreadPoolExecutor j() {
        return this.f1575b;
    }

    public long k() {
        return this.f1588o;
    }

    public ThreadPoolExecutor l() {
        return this.f1578e;
    }

    public int m() {
        return this.f1583j;
    }

    public int n() {
        return this.f1584k;
    }

    public ThreadPoolExecutor o() {
        return this.f1576c;
    }

    public boolean p() {
        return this.f1589p;
    }

    public void r(boolean r10) {
        this.f1589p = r10;
    }
}
