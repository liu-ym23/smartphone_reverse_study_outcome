package com.bytedance.monitor.collector;

/* JADX INFO: loaded from: classes.dex */
public class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private boolean f2336a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private boolean f2337b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f2338c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f2339d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private long f2340e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f2341f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private long f2342g;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private boolean f2343a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private boolean f2344b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private boolean f2345c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private boolean f2346d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private long f2347e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private int f2348f;

        public a() {
        }

        static /* synthetic */ boolean a(a r10) {
            return r10.f2343a;
        }

        static /* synthetic */ boolean b(a r10) {
            return r10.f2344b;
        }

        static /* synthetic */ boolean c(a r10) {
            return r10.f2345c;
        }

        static /* synthetic */ long d(a r10) {
            return r10.f2347e;
        }

        static /* synthetic */ int e(a r10) {
            return r10.f2348f;
        }

        static /* synthetic */ boolean f(a r10) {
            return r10.f2346d;
        }

        public a g(long r10) {
            this.f2347e = r10;
            return this;
        }

        public j h() {
            return new j(this);
        }

        public a i(boolean r10) {
            this.f2343a = r10;
            return this;
        }

        public a j(boolean r10) {
            this.f2344b = r10;
            return this;
        }

        @Deprecated
        public a k(boolean r10) {
            return this;
        }

        public a l(boolean r10) {
            this.f2345c = r10;
            return this;
        }

        public a m(boolean r10) {
            this.f2346d = r10;
            return this;
        }

        public a n(int r10) {
            this.f2348f = r10;
            return this;
        }
    }

    public j(a r10) {
        this.f2342g = 0;
        this.f2336a = a.a(r10);
        this.f2337b = a.b(r10);
        this.f2338c = a.c(r10);
        this.f2340e = a.d(r10);
        this.f2341f = a.e(r10);
        this.f2339d = a.f(r10);
    }

    public long a() {
        return this.f2340e;
    }

    public int b() {
        return this.f2341f;
    }

    public boolean c() {
        return this.f2336a;
    }

    public boolean d() {
        return this.f2337b;
    }

    public boolean e() {
        return this.f2338c;
    }

    public boolean f() {
        return this.f2339d;
    }

    public String toString() {
        return "MonitorConfig{enableAtrace=" + this.f2336a + ", enableBinder=" + this.f2337b + ", enableLooperMonitor=" + this.f2338c + ", enableStackSampling=" + this.f2339d + ", atraceTag=" + this.f2340e + ", runMode=" + this.f2341f + ", alogRef=" + this.f2342g + '}';
    }
}
