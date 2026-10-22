package b6;

/* JADX INFO: loaded from: classes.dex */
public final class a implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ c f3072a;

    public a(c r8) {
        this.f3072a = r8;
    }

    @Override // java.lang.Runnable
    public final void run() {
        c r8 = this.f3072a;
    L9:
        if (r8.k() == true) goto L9;
        return;
    L6:
        e = move-exception;
        r8.d(e, null);
    }
}
