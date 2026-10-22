package com.alibaba.excel.support.asm;

/* JADX INFO: loaded from: classes.dex */
public abstract class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected final int f298a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected a f299b;

    public a(int r2) {
        this(r2, null);
    }

    public a(int r2, a r3) {
        if (r2 != 589824) goto L5;
    L19:
        this.f298a = r2;
        this.f299b = r3;
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

    public a a(String r1) {
        a r0 = this.f299b;
        if (r0 != null) goto L5;
        return null;
    L5:
        return r0.a(r1);
    }

    public a a(String r1, String r2) {
        a r0 = this.f299b;
        if (r0 != null) goto L5;
        return null;
    L5:
        return r0.a(r1, r2);
    }

    public void a() {
        a r0 = this.f299b;
        if (r0 == null) goto L6;
        r0.a();
        return;
    }

    public void a(String r1, Object r2) {
        a r0 = this.f299b;
        if (r0 == null) goto L6;
        r0.a(r1, r2);
        return;
    }

    public void a(String r1, String r2, String r3) {
        a r0 = this.f299b;
        if (r0 == null) goto L6;
        r0.a(r1, r2, r3);
        return;
    }
}
