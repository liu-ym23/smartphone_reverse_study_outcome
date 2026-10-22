package com.obric.memorydata.memory.ui.a;

/* JADX INFO: loaded from: classes3.dex */
public final class g extends d<g> {
    private h w;
    private float x;
    private boolean y;

    public g(f r1) {
        super(r1);
        this.w = null;
        this.x = Float.MAX_VALUE;
        this.y = false;
    }

    private void d() {
        h r0 = this.w;
        if (r0 == null) goto L14;
        double r1 = r0.a();
        if (r1 > this.u) goto L12;
        if (r1 < this.v) goto L10;
        return;
    L10:
        throw new UnsupportedOperationException("Final position of the spring cannot be less than the min value.");
    L12:
        throw new UnsupportedOperationException("Final position of the spring cannot be greater than the max value.");
    L14:
        throw new UnsupportedOperationException("Incomplete SpringAnimation: Either final position or a spring force needs to be set.");
    }

    public g a(h r1) {
        this.w = r1;
        return this;
    }

    @Override // com.obric.memorydata.memory.ui.a.d
    public void a() {
        d();
        this.w.a(c());
        super.a();
    }

    @Override // com.obric.memorydata.memory.ui.a.d
    boolean a(float r1, float r2) {
        return this.w.a(r1, r2);
    }

    public void b(float r2) {
        if (b() == false) goto L6;
        this.x = r2;
        return;
    L6:
        if (this.w != null) goto L8;
        this.w = new h(r2);
    L8:
        this.w.c(r2);
        a();
    }

    @Override // com.obric.memorydata.memory.ui.a.d
    boolean b(long r21) {
        if (this.y == false) goto L10;
        float r1 = this.x;
        if (r1 == Float.MAX_VALUE) goto L7;
        this.w.c(r1);
        this.x = Float.MAX_VALUE;
    L7:
        this.p = this.w.a();
        this.o = 0.0f;
        this.y = false;
        return true;
    L10:
        if (this.x == Float.MAX_VALUE) goto L12;
        this.w.a();
        long r18 = r21 / 2;
        d.a r2 = this.w.a(this.p, this.o, r18);
        this.w.c(this.x);
        this.x = Float.MAX_VALUE;
        h r13 = this.w;
        double r14 = r2.f10569a;
        double r16 = r2.f10570b;
    L13:
        d.a r3 = r13.a(r14, r16, r18);
        this.p = r3.f10569a;
        this.o = r3.f10570b;
        this.p = Math.max(this.p, this.v);
        this.p = Math.min(this.p, this.u);
        if (a(this.p, this.o) == false) goto L17;
        this.p = this.w.a();
        this.o = 0.0f;
        return true;
    L17:
        return false;
    L12:
        r13 = this.w;
        r14 = this.p;
        r16 = this.o;
        r18 = r21;
        goto L13
    }
}
