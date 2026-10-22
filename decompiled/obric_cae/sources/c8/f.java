package c8;

/* JADX INFO: loaded from: classes.dex */
public final class f implements g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ e f3422a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Runnable f3423b;

    public f(Runnable r8, String r10) {
        this.f3422a = e.f3420m;
        this.f3423b = r8;
    }

    @Override // c8.g
    public final e A() {
        return this.f3422a;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Runnable r8 = this.f3423b;     // Catch: Throwable -> L6
        if (r8 == null) goto L10;
        r8.run();     // Catch: Throwable -> L6
        Object r10 = d.f3410e;     // Catch: Throwable -> L6
        d r11 = d.a.f3417a;     // Catch: Throwable -> L6
        return;
    L10:
        return;
    L6:
        Object r12 = d.f3410e;
        d.a.f3417a.getClass();
    }
}
