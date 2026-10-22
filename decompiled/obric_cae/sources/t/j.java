package t;

/* JADX INFO: loaded from: classes.dex */
public final class j extends p {
    public j(s.e r8) {
        super(r8);
        r8.f11854d.f();
        r8.f11855e.f();
        this.f12198f = ((s.h) r8).f11929w0;
    }

    @Override // t.p, t.d
    public final void a(d r8) {
        f r10 = this.f12200h;
        if (r10.f12161c == true) goto L6;
        return;
    L6:
        if (r10.f12168j == false) goto L8;
        return;
    L8:
        r10.d((int) ((((f) r10.f12170l.get(0)).f12165g * ((s.h) this.f12194b).f11925s0) + 0.5f));
    }

    @Override // t.p
    public final void d() {
        s.e r8 = this.f12194b;
        s.h r10 = (s.h) r8;
        int r11 = r10.f11926t0;
        int r12 = r10.f11927u0;
        int r13 = r10.f11929w0;
        f r14 = this.f12200h;
        if (r13 != 1) goto L10;
        if (r11 == (-1)) goto L6;
        r14.f12170l.add(r8.W.f11854d.f12200h);
        this.f12194b.W.f11854d.f12200h.f12169k.add(r14);
        r14.f12164f = r11;
    L9:
        m(this.f12194b.f11854d.f12200h);
        p r15 = this.f12194b.f11854d;
    L16:
        m(r15.f12201i);
        return;
    L6:
        if (r12 == (-1)) goto L8;
        r14.f12170l.add(r8.W.f11854d.f12201i);
        this.f12194b.W.f11854d.f12201i.f12169k.add(r14);
        r14.f12164f = -r12;
        goto L9
    L8:
        r14.f12160b = true;
        r14.f12170l.add(r8.W.f11854d.f12201i);
        this.f12194b.W.f11854d.f12201i.f12169k.add(r14);
        goto L9
    L10:
        if (r11 == (-1)) goto L12;
        r14.f12170l.add(r8.W.f11855e.f12200h);
        this.f12194b.W.f11855e.f12200h.f12169k.add(r14);
        r14.f12164f = r11;
    L15:
        m(this.f12194b.f11855e.f12200h);
        r15 = this.f12194b.f11855e;
        goto L16
    L12:
        if (r12 == (-1)) goto L14;
        r14.f12170l.add(r8.W.f11855e.f12201i);
        this.f12194b.W.f11855e.f12201i.f12169k.add(r14);
        r14.f12164f = -r12;
        goto L15
    L14:
        r14.f12160b = true;
        r14.f12170l.add(r8.W.f11855e.f12201i);
        this.f12194b.W.f11855e.f12201i.f12169k.add(r14);
        goto L15
    }

    @Override // t.p
    public final void e() {
        s.e r8 = this.f12194b;
        int r10 = ((s.h) r8).f11929w0;
        int r11 = this.f12200h.f12165g;
        if (r10 != 1) goto L5;
        r8.f11851b0 = r11;
        return;
    L5:
        r8.f11853c0 = r11;
    }

    @Override // t.p
    public final void f() {
        this.f12200h.c();
    }

    @Override // t.p
    public final boolean k() {
        return false;
    }

    public final void m(f r8) {
        f r10 = this.f12200h;
        r10.f12169k.add(r8);
        r8.f12170l.add(r10);
    }
}
