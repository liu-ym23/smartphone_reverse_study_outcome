package com.bytedance.sdk.account.save.entity;

/* JADX INFO: loaded from: classes2.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private long f3159a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f3160b;
    private String c;
    private long d;
    private String e;
    private String f;
    private String g;
    private String h;
    private String i;
    private com.bytedance.sdk.account.save.entity.a j;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private long f3161a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private int f3162b;
        private String c;
        private long d;
        private String e;
        private String f;
        private String g;
        private String h;
        private String i;
        private com.bytedance.sdk.account.save.entity.a j;

        public a() {
        }

        public a a(int r1) {
            this.f3162b = r1;
            return this;
        }

        public a a(long r1) {
            this.f3161a = r1;
            return this;
        }

        public a a(Integer r2) {
            if (this.j != null) goto L5;
            this.j = new com.bytedance.sdk.account.save.entity.a();
        L5:
            this.j.a(r2);
            return this;
        }

        public a a(String r1) {
            this.c = r1;
            return this;
        }

        public c a() {
            return new c(this.f3161a, this.f3162b, this.c, this.d, this.e, this.f, this.g, this.h, this.i, this.j);
        }

        public a b(long r1) {
            this.d = r1;
            return this;
        }

        public a b(String r1) {
            this.f = r1;
            return this;
        }

        public a c(String r1) {
            this.e = r1;
            return this;
        }

        public a d(String r1) {
            this.g = r1;
            return this;
        }

        public a e(String r1) {
            this.h = r1;
            return this;
        }

        public a f(String r1) {
            this.i = r1;
            return this;
        }
    }

    public c(long r1, int r3, String r4, long r5, String r7, String r8, String r9, String r10, String r11, com.bytedance.sdk.account.save.entity.a r12) {
        this.f3159a = r1;
        this.f3160b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r7;
        this.f = r8;
        this.g = r9;
        this.h = r10;
        this.i = r11;
        this.j = r12;
    }

    public long a() {
        return this.f3159a;
    }

    public String b() {
        return this.c;
    }

    public long c() {
        return this.d;
    }

    public String d() {
        return this.f;
    }

    public String e() {
        return this.g;
    }

    public String f() {
        return this.h;
    }

    public String g() {
        return this.i;
    }

    public int getType() {
        return this.f3160b;
    }

    public String h() {
        return this.e;
    }

    public com.bytedance.sdk.account.save.entity.a i() {
        return this.j;
    }
}
