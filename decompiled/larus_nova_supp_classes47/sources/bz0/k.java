package bz0;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class k implements yy0.h {
    public Integer a;
    public Integer b;
    public String c;
    public Integer d;
    public Integer e;
    public Integer f;
    public Integer g;
    public Boolean h;
    public Integer i;
    public Boolean j;
    public String k;
    public Boolean l;
    public Boolean m;
    public Boolean n;
    public Boolean o;
    public Integer p;
    public Integer q;
    public Integer r;

    public k() {
    }

    @Override // yy0.h
    public final void a(int r1) {
        this.r = Integer.valueOf(r1);
    }

    @Override // yy0.h
    public final void b(int r2) {
        if (r2 != 17) goto L5;
        String r3 = "center";
    L9:
        this.c = r3;
        return;
    L5:
        if (r2 == 80) goto L7;
        r3 = "other";
        goto L9
    L7:
        r3 = "bottom";
        goto L9
    }

    @Override // yy0.h
    public final void c(boolean r1) {
        this.n = Boolean.valueOf(r1);
    }

    @Override // yy0.h
    public final void d(int r1) {
        this.p = Integer.valueOf(r1);
    }

    @Override // yy0.h
    public final void e(int r1) {
        this.q = Integer.valueOf(r1);
    }

    @Override // yy0.h
    public final void f(boolean r1) {
        this.j = Boolean.valueOf(r1);
    }

    @Override // yy0.h
    public final void g(boolean r1) {
        this.m = Boolean.valueOf(r1);
    }

    @Override // yy0.h
    public final void h(String r2) {
        Intrinsics.checkNotNullParameter(r2, "value");
        this.k = r2;
    }

    @Override // yy0.h
    public final void i(int r1) {
        this.i = Integer.valueOf(r1);
    }

    @Override // yy0.h
    public final void j(boolean r1) {
        this.o = Boolean.valueOf(r1);
    }

    @Override // yy0.h
    public final void k(int r1) {
        this.b = Integer.valueOf(r1);
    }

    @Override // yy0.h
    public final void l(boolean r1) {
        this.h = Boolean.valueOf(r1);
    }

    @Override // yy0.h
    public final void n(boolean r1) {
        this.l = Boolean.valueOf(r1);
    }

    @Override // yy0.h
    public final void o(int r1) {
        this.a = Integer.valueOf(r1);
    }

    @Override // yy0.h
    public final void m(int r1, int r2, int r3, int r4) {
        this.d = Integer.valueOf(r1);
        this.e = Integer.valueOf(r2);
        this.f = Integer.valueOf(r3);
        this.g = Integer.valueOf(r4);
    }
}
