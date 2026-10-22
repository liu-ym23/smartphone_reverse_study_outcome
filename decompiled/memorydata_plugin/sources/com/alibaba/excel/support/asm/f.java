package com.alibaba.excel.support.asm;

/* JADX INFO: loaded from: classes.dex */
public abstract class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected final int f312a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected f f313b;

    public f(int r2) {
        this(r2, null);
    }

    public f(int r2, f r3) {
        if (r2 != 589824) goto L5;
    L19:
        this.f312a = r2;
        this.f313b = r3;
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
        if (this.f312a < 327680) goto L11;
        f r2 = this.f313b;
        if (r2 != null) goto L7;
        return null;
    L7:
        return r2.a(r3, r4, r5, r6);
    L11:
        throw new UnsupportedOperationException("TypeAnnotation requires ASM5");
    }

    public a a(String r1, boolean r2) {
        f r0 = this.f313b;
        if (r0 != null) goto L5;
        return null;
    L5:
        return r0.a(r1, r2);
    }

    public l a(int r7, String r8, String r9, String r10, Object r11) {
        f r0 = this.f313b;
        if (r0 != null) goto L5;
        return null;
    L5:
        return r0.a(r7, r8, r9, r10, r11);
    }

    public r a(int r7, String r8, String r9, String r10, String[] r11) {
        f r0 = this.f313b;
        if (r0 != null) goto L5;
        return null;
    L5:
        return r0.a(r7, r8, r9, r10, r11);
    }

    public t a(String r3, int r4, String r5) {
        if (this.f312a < 393216) goto L11;
        f r2 = this.f313b;
        if (r2 != null) goto L7;
        return null;
    L7:
        return r2.a(r3, r4, r5);
    L11:
        throw new UnsupportedOperationException("Module requires ASM6");
    }

    public void a() {
        f r0 = this.f313b;
        if (r0 == null) goto L6;
        r0.a();
        return;
    }

    public void a(int r8, int r9, String r10, String r11, String r12, String[] r13) {
        if (this.f312a < 524288) goto L5;
    L9:
        f r0 = this.f313b;
        if (r0 == null) goto L13;
        r0.a(r8, r9, r10, r11, r12, r13);
        return;
    L13:
        return;
    L5:
        if ((65536 & r9) == 0) goto L9;
        throw new UnsupportedOperationException("Records requires ASM8");
    }

    public void a(c r1) {
        f r0 = this.f313b;
        if (r0 == null) goto L6;
        r0.a(r1);
        return;
    }

    public void a(String r3) {
        if (this.f312a < 458752) goto L9;
        f r2 = this.f313b;
        if (r2 == null) goto L10;
        r2.a(r3);
        return;
    L10:
        return;
    L9:
        throw new UnsupportedOperationException("NestHost requires ASM7");
    }

    public void a(String r1, String r2) {
        f r0 = this.f313b;
        if (r0 == null) goto L6;
        r0.a(r1, r2);
        return;
    }

    public void a(String r1, String r2, String r3) {
        f r0 = this.f313b;
        if (r0 == null) goto L6;
        r0.a(r1, r2, r3);
        return;
    }

    public void a(String r1, String r2, String r3, int r4) {
        f r0 = this.f313b;
        if (r0 == null) goto L6;
        r0.a(r1, r2, r3, r4);
        return;
    }

    public w b(String r3, String r4, String r5) {
        if (this.f312a < 524288) goto L11;
        f r2 = this.f313b;
        if (r2 != null) goto L7;
        return null;
    L7:
        return r2.b(r3, r4, r5);
    L11:
        throw new UnsupportedOperationException("Record requires ASM8");
    }

    public void b(String r3) {
        if (this.f312a < 458752) goto L9;
        f r2 = this.f313b;
        if (r2 == null) goto L10;
        r2.b(r3);
        return;
    L10:
        return;
    L9:
        throw new UnsupportedOperationException("NestMember requires ASM7");
    }

    public void c(String r3) {
        if (this.f312a < 589824) goto L9;
        f r2 = this.f313b;
        if (r2 == null) goto L10;
        r2.c(r3);
        return;
    L10:
        return;
    L9:
        throw new UnsupportedOperationException("PermittedSubclasses requires ASM9");
    }
}
