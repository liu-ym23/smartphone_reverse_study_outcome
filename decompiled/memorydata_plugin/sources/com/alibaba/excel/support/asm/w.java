package com.alibaba.excel.support.asm;

/* JADX INFO: loaded from: classes.dex */
public abstract class w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected final int f337a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected w f338b;

    public w(int r2) {
        this(r2, null);
    }

    public w(int r2, w r3) {
        if (r2 != 589824) goto L5;
    L19:
        this.f337a = r2;
        this.f338b = r3;
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

    public a a(int r1, ab r2, String r3, boolean r4) {
        w r0 = this.f338b;
        if (r0 != null) goto L5;
        return null;
    L5:
        return r0.a(r1, r2, r3, r4);
    }

    public a a(String r1, boolean r2) {
        w r0 = this.f338b;
        if (r0 != null) goto L5;
        return null;
    L5:
        return r0.a(r1, r2);
    }

    public void a() {
        w r0 = this.f338b;
        if (r0 == null) goto L6;
        r0.a();
        return;
    }

    public void a(c r1) {
        w r0 = this.f338b;
        if (r0 == null) goto L6;
        r0.a(r1);
        return;
    }
}
