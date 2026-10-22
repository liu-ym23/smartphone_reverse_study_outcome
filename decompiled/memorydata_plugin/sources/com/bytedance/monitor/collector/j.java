package com.bytedance.monitor.collector;

/* JADX INFO: loaded from: classes2.dex */
public class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private boolean f2863a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private boolean f2864b;
    private boolean c;
    private boolean d;
    private long e;
    private int f;
    private long g;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private boolean f2865a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private boolean f2866b;
        private boolean c;
        private boolean d;
        private long e;
        private int f;

        public a() {
        }

        static /* synthetic */ boolean a(a r0) {
            return r0.f2865a;
        }

        static /* synthetic */ boolean b(a r0) {
            return r0.f2866b;
        }

        static /* synthetic */ boolean c(a r0) {
            return r0.c;
        }

        static /* synthetic */ long d(a r2) {
            return r2.e;
        }

        static /* synthetic */ int e(a r0) {
            return r0.f;
        }

        static /* synthetic */ boolean f(a r0) {
            return r0.d;
        }

        public a a(int r1) {
            this.f = r1;
            return this;
        }

        public a a(long r1) {
            this.e = r1;
            return this;
        }

        @Deprecated
        public a a(boolean r1) {
            return this;
        }

        public j a() {
            return new j(this);
        }

        public a b(boolean r1) {
            this.f2865a = r1;
            return this;
        }

        public a c(boolean r1) {
            this.f2866b = r1;
            return this;
        }

        public a d(boolean r1) {
            this.c = r1;
            return this;
        }

        public a e(boolean r1) {
            this.d = r1;
            return this;
        }
    }

    public j(a r3) {
        this.g = 0;
        this.f2863a = a.a(r3);
        this.f2864b = a.b(r3);
        this.c = a.c(r3);
        this.e = a.d(r3);
        this.f = a.e(r3);
        this.d = a.f(r3);
    }

    public boolean a() {
        return this.f2863a;
    }

    public boolean b() {
        return this.f2864b;
    }

    public boolean c() {
        return this.c;
    }

    public boolean d() {
        return this.d;
    }

    public long e() {
        return this.e;
    }

    public int f() {
        return this.f;
    }

    public String toString() {
        return "MonitorConfig{enableAtrace=" + this.f2863a + ", enableBinder=" + this.f2864b + ", enableLooperMonitor=" + this.c + ", enableStackSampling=" + this.d + ", atraceTag=" + this.e + ", runMode=" + this.f + ", alogRef=" + this.g + '}';
    }
}
