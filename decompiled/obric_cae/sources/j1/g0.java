package j1;

/* JADX INFO: loaded from: classes.dex */
public final class g0 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ga.a f8480a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ i0 f8481b;

    public g0(i0 r8, t1.c r10) {
        this.f8481b = r8;
        this.f8480a = r10;
    }

    @Override // java.lang.Runnable
    public final void run() {
        i0 r8 = this.f8481b;
        if (r8.A.isCancelled() == false) goto L10;
        return;
    L10:
        this.f8480a.get();     // Catch: Throwable -> L7
        androidx.work.m.d().a(i0.C, "Starting work for " + r8.f8490o.f11341c);     // Catch: Throwable -> L7
        r8.A.i(r8.f8491p.startWork());     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        r8.A.k(th);
    }
}
