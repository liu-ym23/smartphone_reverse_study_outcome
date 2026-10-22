package v6;

/* JADX INFO: loaded from: classes.dex */
public final class a extends b {

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final Runnable f12731n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final c.a f12732o;

    public a(c.a r8, int r10, Runnable r11) {
        this.f12732o = r8;
        this.f12734b = r10;
        this.f12731n = r11;
    }

    @Override // v6.c
    public final int a() {
        return this.f12735m;
    }

    @Override // v6.c
    public final c.a b() {
        return this.f12732o;
    }

    @Override // java.lang.Comparable
    public final int compareTo(c r8) {
        c r10 = r8;
        c.a r11 = r10.b();
        c.a r12 = this.f12732o;
        if (r12 != null) goto L5;
        r12 = c.a.f12737b;
    L5:
        if (r11 != null) goto L7;
        r11 = c.a.f12737b;
    L7:
        if (r12 != r11) goto L9;
        int r13 = this.f12735m;
        int r14 = r10.a();
    L11:
        return r13 - r14;
    L9:
        r13 = r11.ordinal();
        r14 = r12.ordinal();
        goto L11
    }

    public final a e(int r8) {
        this.f12735m = r8;
        return this;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Runnable r8 = this.f12731n;
        if (r8 != null) goto L5;
        return;
    L5:
        if (d() == true) goto L9;
        r8.run();
        return;
    }
}
