package g0;

/* JADX INFO: loaded from: classes.dex */
public final class b implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ t2.b f7499a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f7500b;

    public b(t2.b r8, int r10) {
        this.f7499a = r8;
        this.f7500b = r10;
    }

    @Override // java.lang.Runnable
    public final void run() {
        z.f.e r8 = ((a0.e.a) this.f7499a).H;
        if (r8 == null) goto L6;
        r8.c(this.f7500b);
        return;
    }
}
