package com.alibaba.excel.support.asm;

/* JADX INFO: loaded from: classes.dex */
final class x extends w {
    private final z c;
    private final int d;
    private final int e;
    private int f;
    private b g;
    private b h;
    private b i;
    private b j;
    private c k;

    x(z r2, String r3, String r4, String r5) {
        super(589824);
        this.c = r2;
        this.d = r2.c(r3);
        this.e = r2.c(r4);
        if (r5 == null) goto L6;
        this.f = r2.c(r5);
        return;
    }

    @Override // com.alibaba.excel.support.asm.w
    public a a(int r2, ab r3, String r4, boolean r5) {
        if (r5 == false) goto L5;
        b r6 = b.a(this.c, r2, r3, r4, this.i);
        this.i = r6;
        return r6;
    L5:
        b r7 = b.a(this.c, r2, r3, r4, this.j);
        this.j = r7;
        return r7;
    }

    @Override // com.alibaba.excel.support.asm.w
    public a a(String r2, boolean r3) {
        if (r3 == false) goto L5;
        b r4 = b.a(this.c, r2, this.g);
        this.g = r4;
        return r4;
    L5:
        b r5 = b.a(this.c, r2, this.h);
        this.h = r5;
        return r5;
    }

    @Override // com.alibaba.excel.support.asm.w
    public void a() {
    }

    final void a(c.a r1) {
        r1.a(this.k);
    }

    @Override // com.alibaba.excel.support.asm.w
    public void a(c r2) {
        r2.f305b = this.k;
        this.k = r2;
    }

    void a(d r10) {
        r10.b(this.d).b(this.e);
        if (this.f == 0) goto L5;
        int r0 = 1;
    L7:
        if (this.g == null) goto L10;
        r0 = r0 + 1;
    L10:
        if (this.h == null) goto L13;
        r0 = r0 + 1;
    L13:
        if (this.i == null) goto L16;
        r0 = r0 + 1;
    L16:
        if (this.j == null) goto L18;
        r0 = r0 + 1;
    L18:
        c r2 = this.k;
        if (r2 == null) goto L21;
        r0 = r0 + r2.b();
    L21:
        r10.b(r0);
        c.a(this.c, 0, this.f, r10);
        b.a(this.c, this.g, this.h, this.i, this.j, r10);
        c r1 = this.k;
        if (r1 == null) goto L25;
        r1.a(this.c, r10);
        return;
    L25:
        return;
    L5:
        r0 = 0;
        goto L7
    }

    int b() {
        int r0 = (c.a(this.c, 0, this.f) + 6) + b.a(this.g, this.h, this.i, this.j);
        c r1 = this.k;
        if (r1 != null) goto L5;
        return r0;
    L5:
        return r0 + r1.a(this.c);
    }
}
