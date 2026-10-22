package com.bytedance.apm.config;

import com.obric.cae.userAware.SubwayFusionAware.SubwayUtils;

/* JADX INFO: loaded from: classes.dex */
public class b {
    private boolean A;
    private com.bytedance.apm.a.b B;
    private com.bytedance.apm.net.a C;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f1248a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private boolean f1249b;
    private boolean c;
    private long d;
    private long e;
    private com.bytedance.apm.trace.a f;
    private boolean g;
    private long h;
    private boolean i;
    private boolean j;
    private boolean k;
    private boolean l;
    private boolean m;
    private boolean n;
    private int o;
    private long p;
    private com.bytedance.apm.config.a q;
    private String r;
    private String s;
    private boolean t;
    private com.bytedance.apm.launch.c u;
    private boolean v;
    private boolean w;
    private boolean x;
    private boolean y;
    private boolean z;

    /* JADX INFO: renamed from: com.bytedance.apm.config.b$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    public static final class a {
        private boolean A;
        private boolean B;
        private boolean C;
        private com.bytedance.apm.a.b D;
        private com.bytedance.apm.net.a E;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private int f1250a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private boolean f1251b;
        private boolean c;
        private long d;
        private long e;
        private com.bytedance.apm.trace.a f;
        private boolean g;
        private long h;
        private boolean i;
        private boolean j;
        private boolean k;
        private boolean l;
        private boolean m;
        private boolean n;
        private String o;
        private int p;
        private long q;
        private String r;
        private boolean s;
        private boolean t;
        private boolean u;
        private com.bytedance.apm.config.a v;
        private com.bytedance.apm.launch.c w;
        private boolean x;
        private boolean y;
        private boolean z;

        private a() {
            this.k = false;
            this.l = false;
            this.m = false;
            this.u = false;
            this.f1250a = 1000;
            this.c = false;
            this.d = 20000;
            this.e = SubwayUtils.OUTDOOR_PUNISH_DELAY_TIME;
            this.g = false;
            this.h = 1000;
            this.p = 0;
            this.q = 30000;
            this.D = new com.bytedance.apm.a.a();
        }

        /* synthetic */ a(AnonymousClass1 r1) {
            this();
        }

        static /* synthetic */ boolean A(a r0) {
            return r0.z;
        }

        static /* synthetic */ boolean B(a r0) {
            return r0.A;
        }

        static /* synthetic */ boolean C(a r0) {
            return r0.B;
        }

        static /* synthetic */ boolean D(a r0) {
            return r0.C;
        }

        static /* synthetic */ com.bytedance.apm.net.a E(a r0) {
            return r0.E;
        }

        static /* synthetic */ int a(a r0) {
            return r0.f1250a;
        }

        static /* synthetic */ boolean b(a r0) {
            return r0.c;
        }

        static /* synthetic */ long c(a r2) {
            return r2.d;
        }

        static /* synthetic */ long d(a r2) {
            return r2.e;
        }

        static /* synthetic */ com.bytedance.apm.trace.a e(a r0) {
            return r0.f;
        }

        static /* synthetic */ boolean f(a r0) {
            return r0.g;
        }

        static /* synthetic */ long g(a r2) {
            return r2.h;
        }

        static /* synthetic */ boolean h(a r0) {
            return r0.i;
        }

        static /* synthetic */ boolean i(a r0) {
            return r0.j;
        }

        static /* synthetic */ boolean j(a r0) {
            return r0.k;
        }

        static /* synthetic */ boolean k(a r0) {
            return r0.l;
        }

        static /* synthetic */ boolean l(a r0) {
            return r0.m;
        }

        static /* synthetic */ boolean m(a r0) {
            return r0.n;
        }

        static /* synthetic */ long n(a r2) {
            return r2.q;
        }

        static /* synthetic */ int o(a r0) {
            return r0.p;
        }

        static /* synthetic */ String p(a r0) {
            return r0.r;
        }

        static /* synthetic */ String q(a r0) {
            return r0.o;
        }

        static /* synthetic */ com.bytedance.apm.config.a r(a r0) {
            return r0.v;
        }

        static /* synthetic */ com.bytedance.apm.launch.c s(a r0) {
            return r0.w;
        }

        static /* synthetic */ boolean t(a r0) {
            return r0.x;
        }

        static /* synthetic */ boolean u(a r0) {
            return r0.s;
        }

        static /* synthetic */ boolean v(a r0) {
            return r0.t;
        }

        static /* synthetic */ boolean w(a r0) {
            return r0.u;
        }

        static /* synthetic */ com.bytedance.apm.a.b x(a r0) {
            return r0.D;
        }

        static /* synthetic */ boolean y(a r0) {
            return r0.f1251b;
        }

        static /* synthetic */ boolean z(a r0) {
            return r0.y;
        }

        public b a() {
            return new b(this);
        }
    }

    public b(a r3) {
        this.f1248a = a.a(r3);
        this.c = a.b(r3);
        this.d = a.c(r3);
        this.e = a.d(r3);
        this.f = a.e(r3);
        this.g = a.f(r3);
        this.h = a.g(r3);
        this.i = a.h(r3);
        this.j = a.i(r3);
        this.k = a.j(r3);
        this.l = a.k(r3);
        this.m = a.l(r3);
        this.n = a.m(r3);
        this.p = a.n(r3);
        this.o = a.o(r3);
        this.r = a.p(r3);
        this.s = a.q(r3);
        this.q = a.r(r3);
        this.u = a.s(r3);
        this.v = a.t(r3);
        com.bytedance.apm.b.a(a.u(r3));
        com.bytedance.apm.b.b(a.v(r3));
        this.t = a.w(r3);
        this.B = a.x(r3);
        this.f1249b = a.y(r3);
        this.w = a.z(r3);
        this.x = a.A(r3);
        this.y = a.B(r3);
        this.z = a.C(r3);
        this.A = a.D(r3);
        this.C = a.E(r3);
    }

    public static a h() {
        return new a(null);
    }

    public long a() {
        return this.d;
    }

    public com.bytedance.apm.trace.a b() {
        return this.f;
    }

    public boolean c() {
        return this.x;
    }

    public boolean d() {
        return this.z;
    }

    public boolean e() {
        return this.n;
    }

    public int f() {
        return this.o;
    }

    public long g() {
        long r0 = com.bytedance.apm.launch.a.a().b().d();
        if (r0 == (-1)) goto L6;
        return r0;
    L6:
        return this.p;
    }

    public boolean i() {
        return this.w;
    }

    public String toString() {
        return "ApmInitConfig{mCacheBufferCount=" + this.f1248a + ", isReportCacheException=" + this.f1249b + ", mViewIdmonitorPageSwitch=" + this.c + ", mMaxValidPageLoadTimeMs=" + this.d + ", mMaxValidLaunchTimeMs=" + this.e + ", mTraceListener=" + this.f + ", mReportEvilMethodSwitch=" + this.g + ", mEvilMethodThresholdMs=" + this.h + ", mLimitEvilMethodDepth=" + this.i + ", mFullFpsTracer=" + this.j + ", mDisableFpsTracer=" + this.k + ", mChangeFpsLifeCycle=" + this.l + ", mActivityFps=" + this.m + ", mBinderMonitor=" + this.n + ", mTraceExtraFlag=" + this.o + ", mTraceExtraCollectTimeMs=" + this.p + ", mActivityLeakDetectConfig=" + this.q + ", mIgnoreNetMonitorUserAgentLabel='" + this.r + "', mProcessName='" + this.s + "', mEnableDeviceInfoOnPerfData=" + this.t + ", mLaunchConfig=" + this.u + ", mSupportMultiFrameRate=" + this.v + ", mEnableSliverDump=" + this.w + ", mEnableCpuAllocOpt=" + this.x + ", mEnableCloseListener=" + this.y + ", mEnableLooperOpt=" + this.z + ", mAlogUploadStrategy=" + this.B + '}';
    }
}
