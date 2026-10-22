package com.alibaba.excel.support.asm;

/* JADX INFO: loaded from: classes.dex */
public abstract class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected final int f320a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected l f321b;

    public l(int r2) {
        this(r2, null);
    }

    public l(int r2, l r3) {
        if (r2 != 589824) goto L5;
    L19:
        this.f320a = r2;
        this.f321b = r3;
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

    public a a(int r3, ab r4, String r5, boolean r6) {
        if (this.f320a < 327680) goto L11;
        l r2 = this.f321b;
        if (r2 != null) goto L7;
        return null;
    L7:
        return r2.a(r3, r4, r5, r6);
    L11:
        throw new UnsupportedOperationException("This feature requires ASM5");
    }

    public a a(String r1, boolean r2) {
        l r0 = this.f321b;
        if (r0 != null) goto L5;
        return null;
    L5:
        return r0.a(r1, r2);
    }

    public void a() {
        l r0 = this.f321b;
        if (r0 == null) goto L6;
        r0.a();
        return;
    }

    public void a(c r1) {
        l r0 = this.f321b;
        if (r0 == null) goto L6;
        r0.a(r1);
        return;
    }
}
