package com.alibaba.excel.support.cglib.core;

/* JADX INFO: loaded from: classes.dex */
public class v extends com.alibaba.excel.support.asm.r {
    private final a c;
    protected final int d;

    /* JADX INFO: renamed from: com.alibaba.excel.support.cglib.core.v$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    private static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int[] f429a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        int f430b;

        private a() {
            this.f429a = new int[40];
        }

        /* synthetic */ a(AnonymousClass1 r1) {
            this();
        }
    }

    public v(int r3, String r4, com.alibaba.excel.support.asm.r r5) {
        super(i.h, r5);
        a r6 = new a(null);
        this.c = r6;
        com.alibaba.excel.support.asm.aa[] r7 = com.alibaba.excel.support.asm.aa.c(r4);
        int r0 = 0;
        if ((r3 & 8) == 0) goto L5;
        int r8 = 0;
    L6:
        r6.f430b = r8;
    L8:
        if (r0 >= r7.length) goto L10;
        this.c.f430b += r7[r0].g();
        r0 = r0 + 1;
        goto L8
    L10:
        this.d = this.c.f430b;
        return;
    L5:
        r8 = 1;
        goto L6
    }

    private int b(int r4) {
        if (r4 >= this.d) goto L5;
        return r4;
    L5:
        int r0 = r4 * 2;
        int r2 = 0;
        if (r0 >= this.c.f429a.length) goto L8;
        int r1 = this.c.f429a[r0];
    L9:
        if (r1 != 0) goto L14;
        int r3 = r0 + 1;
        if (r3 >= this.c.f429a.length) goto L13;
        r2 = this.c.f429a[r3];
    L13:
        r1 = r2;
    L14:
        if (r1 == 0) goto L18;
        return r1 - 1;
    L18:
        throw new IllegalStateException("Unknown local variable " + r4);
    L8:
        r1 = 0;
        goto L9
    }

    private int e(int r5, int r6) {
        if (r5 >= this.d) goto L5;
        return r5;
    L5:
        int r7 = ((r5 * 2) + r6) - 1;
        int r0 = this.c.f429a.length;
        if (r7 < r0) goto L8;
        int[] r1 = new int[Math.max(r0 * 2, r7 + 1)];
        System.arraycopy(this.c.f429a, 0, r1, 0, r0);
        this.c.f429a = r1;
    L8:
        int r2 = this.c.f429a[r7];
        if (r2 != 0) goto L12;
        r2 = this.c.f430b + 1;
        this.c.f429a[r7] = r2;
        this.c.f430b += r6;
    L12:
        return r2 - 1;
    }

    @Override // com.alibaba.excel.support.asm.r
    public void a(String r8, String r9, String r10, com.alibaba.excel.support.asm.q r11, com.alibaba.excel.support.asm.q r12, int r13) {
        this.f331b.a(r8, r9, r10, r11, r12, b(r13));
    }

    @Override // com.alibaba.excel.support.asm.r
    public void b(int r3, int r4) {
        if (r3 != 22) goto L5;
    L11:
        int r0 = 2;
    L12:
        this.f331b.b(r3, e(r4, r0));
        return;
    L5:
        if (r3 == 24) goto L11;
        if (r3 == 55) goto L11;
        if (r3 == 57) goto L11;
        r0 = 1;
        goto L12
    }

    @Override // com.alibaba.excel.support.asm.r
    public void c(int r3, int r4) {
        this.f331b.c(e(r3, 1), r4);
    }

    @Override // com.alibaba.excel.support.asm.r
    public void d(int r1, int r2) {
        this.f331b.d(r1, this.c.f430b);
    }

    public int e(int r3) {
        int r0 = this.c.f430b;
        this.c.f430b += r3;
        return r0;
    }
}
