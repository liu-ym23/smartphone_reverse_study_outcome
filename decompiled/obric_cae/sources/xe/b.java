package xe;

/* JADX INFO: loaded from: classes2.dex */
public abstract class b implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f13879a;

    public b(String r8, Object... r10) {
        this.f13879a = c.n(r8, r10);
    }

    public abstract void a();

    @Override // java.lang.Runnable
    public final void run() {
        String r8 = Thread.currentThread().getName();
        Thread.currentThread().setName(this.f13879a);
        a();     // Catch: Throwable -> L6
        Thread.currentThread().setName(r8);
        return;
    L6:
        th = move-exception;
        Thread.currentThread().setName(r8);
        throw th;
    }
}
