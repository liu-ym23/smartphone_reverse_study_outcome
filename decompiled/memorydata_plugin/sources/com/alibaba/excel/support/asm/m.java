package com.alibaba.excel.support.asm;

/* JADX INFO: loaded from: classes.dex */
final class m extends l {
    private final z c;
    private final int d;
    private final int e;
    private final int f;
    private int g;
    private int h;
    private b i;
    private b j;
    private b k;
    private b l;
    private c m;

    m(z r2, int r3, String r4, String r5, String r6, Object r7) {
        super(589824);
        this.c = r2;
        this.d = r3;
        this.e = r2.c(r4);
        this.f = r2.c(r5);
        if (r6 == null) goto L5;
        this.g = r2.c(r6);
    L5:
        if (r7 == null) goto L8;
        this.h = r2.a(r7).f339a;
        return;
    }

    @Override // com.alibaba.excel.support.asm.l
    public a a(int r2, ab r3, String r4, boolean r5) {
        if (r5 == false) goto L5;
        b r6 = b.a(this.c, r2, r3, r4, this.k);
        this.k = r6;
        return r6;
    L5:
        b r7 = b.a(this.c, r2, r3, r4, this.l);
        this.l = r7;
        return r7;
    }

    @Override // com.alibaba.excel.support.asm.l
    public a a(String r2, boolean r3) {
        if (r3 == false) goto L5;
        b r4 = b.a(this.c, r2, this.i);
        this.i = r4;
        return r4;
    L5:
        b r5 = b.a(this.c, r2, this.j);
        this.j = r5;
        return r5;
    }

    @Override // com.alibaba.excel.support.asm.l
    public void a() {
    }

    final void a(c.a r1) {
        r1.a(this.m);
    }

    @Override // com.alibaba.excel.support.asm.l
    public void a(c r2) {
        r2.f305b = this.m;
        this.m = r2;
    }

    void a(d r10) {
        int r1 = 0;
        if (this.c.b() >= 49) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L8;
        int r3 = 4096;
    L9:
        r10.b((~r3) & this.d).b(this.e).b(this.f);
        if (this.h == 0) goto L12;
        r1 = 1;
    L12:
        int r2 = this.d;
        if ((r2 & 4096) == 0) goto L17;
        if (r0 == false) goto L17;
        r1 = r1 + 1;
    L17:
        if (this.g == 0) goto L20;
        r1 = r1 + 1;
    L20:
        if ((131072 & r2) == 0) goto L23;
        r1 = r1 + 1;
    L23:
        if (this.i == null) goto L26;
        r1 = r1 + 1;
    L26:
        if (this.j == null) goto L29;
        r1 = r1 + 1;
    L29:
        if (this.k == null) goto L32;
        r1 = r1 + 1;
    L32:
        if (this.l == null) goto L34;
        r1 = r1 + 1;
    L34:
        c r4 = this.m;
        if (r4 == null) goto L37;
        r1 = r1 + r4.b();
    L37:
        r10.b(r1);
        if (this.h == 0) goto L40;
        r10.b(this.c.c("ConstantValue")).c(2).b(this.h);
    L40:
        c.a(this.c, this.d, this.g, r10);
        b.a(this.c, this.i, this.j, this.k, this.l, r10);
        c r5 = this.m;
        if (r5 == null) goto L44;
        r5.a(this.c, r10);
        return;
    L44:
        return;
    L8:
        r3 = 0;
        goto L9
    L5:
        r0 = false;
        goto L6
    }

    int b() {
        if (this.h == 0) goto L5;
        this.c.c("ConstantValue");
        int r0 = 16;
    L6:
        int r1 = (r0 + c.a(this.c, this.d, this.g)) + b.a(this.i, this.j, this.k, this.l);
        c r2 = this.m;
        if (r2 != null) goto L9;
        return r1;
    L9:
        return r1 + r2.a(this.c);
    L5:
        r0 = 8;
        goto L6
    }
}
