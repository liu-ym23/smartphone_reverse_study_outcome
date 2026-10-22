package com.alibaba.excel.support.asm;

/* JADX INFO: loaded from: classes.dex */
public abstract class t {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected final int f333a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected t f334b;

    public t(int r2) {
        this(r2, null);
    }

    public t(int r2, t r3) {
        if (r2 != 589824) goto L5;
    L19:
        this.f333a = r2;
        this.f334b = r3;
        return;
    L5:
        if (r2 == 524288) goto L19;
        if (r2 == 458752) goto L19;
        if (r2 == 393216) goto L19;
        if (r2 == 327680) goto L19;
        if (r2 == 262144) goto L19;
        if (r2 == 17432576) goto L19;
        throw new IllegalArgumentException("Unsupported api " + r2);
    }

    public void a() {
        t r0 = this.f334b;
        if (r0 == null) goto L6;
        r0.a();
        return;
    }

    public void a(String r1) {
        t r0 = this.f334b;
        if (r0 == null) goto L6;
        r0.a(r1);
        return;
    }

    public void a(String r1, int r2, String r3) {
        t r0 = this.f334b;
        if (r0 == null) goto L6;
        r0.a(r1, r2, r3);
        return;
    }

    public void a(String r1, int r2, String... r3) {
        t r0 = this.f334b;
        if (r0 == null) goto L6;
        r0.a(r1, r2, r3);
        return;
    }

    public void a(String r1, String... r2) {
        t r0 = this.f334b;
        if (r0 == null) goto L6;
        r0.a(r1, r2);
        return;
    }

    public void b(String r1) {
        t r0 = this.f334b;
        if (r0 == null) goto L6;
        r0.b(r1);
        return;
    }

    public void b(String r1, int r2, String... r3) {
        t r0 = this.f334b;
        if (r0 == null) goto L6;
        r0.b(r1, r2, r3);
        return;
    }

    public void c(String r1) {
        t r0 = this.f334b;
        if (r0 == null) goto L6;
        r0.c(r1);
        return;
    }
}
