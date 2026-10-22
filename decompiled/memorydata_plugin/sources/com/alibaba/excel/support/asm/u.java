package com.alibaba.excel.support.asm;

/* JADX INFO: loaded from: classes.dex */
final class u extends t {
    private final z c;
    private final int d;
    private final int e;
    private final int f;
    private int g;
    private final d h;
    private int i;
    private final d j;
    private int k;
    private final d l;
    private int m;
    private final d n;
    private int o;
    private final d p;
    private int q;
    private final d r;
    private int s;

    u(z r2, int r3, int r4, int r5) {
        super(589824);
        this.c = r2;
        this.d = r3;
        this.e = r4;
        this.f = r5;
        this.h = new d();
        this.j = new d();
        this.l = new d();
        this.n = new d();
        this.p = new d();
        this.r = new d();
    }

    @Override // com.alibaba.excel.support.asm.t
    public void a() {
    }

    void a(d r6) {
        int r0 = ((((this.h.f309b + 16) + this.j.f309b) + this.l.f309b) + this.n.f309b) + this.p.f309b;
        r6.b(this.c.c("Module")).c(r0).b(this.d).b(this.e).b(this.f).b(this.g).a(this.h.f308a, 0, this.h.f309b).b(this.i).a(this.j.f308a, 0, this.j.f309b).b(this.k).a(this.l.f308a, 0, this.l.f309b).b(this.m).a(this.n.f308a, 0, this.n.f309b).b(this.o).a(this.p.f308a, 0, this.p.f309b);
        if (this.q <= 0) goto L6;
        r6.b(this.c.c("ModulePackages")).c(this.r.f309b + 2).b(this.q).a(this.r.f308a, 0, this.r.f309b);
    L6:
        if (this.s <= 0) goto L9;
        r6.b(this.c.c("ModuleMainClass")).c(2).b(this.s);
        return;
    }

    @Override // com.alibaba.excel.support.asm.t
    public void a(String r2) {
        this.s = this.c.a(r2).f339a;
    }

    @Override // com.alibaba.excel.support.asm.t
    public void a(String r3, int r4, String r5) {
        d r6 = this.h.b(this.c.e(r3).f339a).b(r4);
        if (r5 != null) goto L5;
        int r7 = 0;
    L6:
        r6.b(r7);
        this.g++;
        return;
    L5:
        r7 = this.c.c(r5);
        goto L6
    }

    @Override // com.alibaba.excel.support.asm.t
    public void a(String r4, int r5, String... r6) {
        this.j.b(this.c.f(r4).f339a).b(r5);
        int r7 = 0;
        d r8 = this.j;
        if (r6 != null) goto L5;
        r8.b(0);
    L8:
        this.i++;
        return;
    L5:
        r8.b(r6.length);
        int r9 = r6.length;
    L6:
        if (r7 >= r9) goto L8;
        this.j.b(this.c.e(r6[r7]).f339a);
        r7 = r7 + 1;
        goto L6
    }

    @Override // com.alibaba.excel.support.asm.t
    public void a(String r5, String... r6) {
        this.p.b(this.c.a(r5).f339a);
        this.p.b(r6.length);
        int r7 = r6.length;
        int r0 = 0;
    L3:
        if (r0 >= r7) goto L5;
        this.p.b(this.c.a(r6[r0]).f339a);
        r0 = r0 + 1;
        goto L3
    L5:
        this.o++;
    }

    int b() {
        int r1 = 0;
        if (this.q <= 0) goto L5;
        int r0 = 1;
    L6:
        int r2 = r0 + 1;
        if (this.s <= 0) goto L10;
        r1 = 1;
    L10:
        return r2 + r1;
    L5:
        r0 = 0;
        goto L6
    }

    @Override // com.alibaba.excel.support.asm.t
    public void b(String r3) {
        this.r.b(this.c.f(r3).f339a);
        this.q++;
    }

    @Override // com.alibaba.excel.support.asm.t
    public void b(String r4, int r5, String... r6) {
        this.l.b(this.c.f(r4).f339a).b(r5);
        int r7 = 0;
        d r8 = this.l;
        if (r6 != null) goto L5;
        r8.b(0);
    L8:
        this.k++;
        return;
    L5:
        r8.b(r6.length);
        int r9 = r6.length;
    L6:
        if (r7 >= r9) goto L8;
        this.l.b(this.c.e(r6[r7]).f339a);
        r7 = r7 + 1;
        goto L6
    }

    int c() {
        this.c.c("Module");
        int r0 = ((((this.h.f309b + 22) + this.j.f309b) + this.l.f309b) + this.n.f309b) + this.p.f309b;
        if (this.q <= 0) goto L6;
        this.c.c("ModulePackages");
        r0 = r0 + (this.r.f309b + 8);
    L6:
        if (this.s <= 0) goto L9;
        this.c.c("ModuleMainClass");
        return r0 + 8;
    L9:
        return r0;
    }

    @Override // com.alibaba.excel.support.asm.t
    public void c(String r3) {
        this.n.b(this.c.a(r3).f339a);
        this.m++;
    }
}
