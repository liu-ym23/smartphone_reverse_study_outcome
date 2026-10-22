package com.bytedance.apm.launch;

/* JADX INFO: loaded from: classes.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private boolean f1418a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private boolean f1419b;
    private boolean c;
    private boolean d;
    private boolean e;
    private long f;
    private long g;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private boolean f1420a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private boolean f1421b;
        private boolean c;
        private boolean d;
        private boolean e;
        private long f;
        private long g;

        public a() {
            this.f1420a = false;
            this.f1421b = false;
            this.c = false;
            this.d = false;
            this.e = false;
            this.f = -1;
            this.g = 1000;
        }

        public c a() {
            return new c(this.f1420a, this.f1421b, this.c, this.f, this.d, this.g, this.e);
        }
    }

    public c(boolean r1, boolean r2, boolean r3, long r4, boolean r6, long r7, boolean r9) {
        this.f1418a = r1;
        this.f1419b = r2;
        this.c = r3;
        this.f = r4;
        this.d = r6;
        this.g = r7;
        this.e = r9;
    }

    public boolean a() {
        return this.f1418a;
    }

    public boolean b() {
        return this.f1419b;
    }

    public boolean c() {
        return this.d;
    }

    public long d() {
        return this.f;
    }
}
