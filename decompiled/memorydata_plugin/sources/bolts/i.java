package bolts;

/* JADX INFO: loaded from: classes.dex */
class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private g<?> f114a;

    public i(g<?> r1) {
        this.f114a = r1;
    }

    public void a() {
        this.f114a = null;
    }

    public void finalize() {
        g<?> r0 = this.f114a;     // Catch: Throwable -> L9
        if (r0 == null) goto L7;
        g.a r1 = g.a();     // Catch: Throwable -> L9
        if (r1 == null) goto L7;
        r1.a(r0, new UnobservedTaskException(r0.c()));     // Catch: Throwable -> L9
    L7:
        super.finalize();
        return;
    L9:
        th = move-exception;
        super.finalize();
        throw th;
    }
}
