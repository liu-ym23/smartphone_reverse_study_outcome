package qa;

/* JADX INFO: loaded from: classes.dex */
public abstract class m1 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public n1.a f10824a;

    public abstract void a();

    @Override // java.lang.Runnable
    public final void run() {
    L22:
        th = move-exception;
        q.f("ThreadTask", "run", th);
        th.printStackTrace();
        return;
    L3:
        if (Thread.interrupted() == false) goto L5;
        return;
    L5:
        a();     // Catch: Throwable -> L22
        if (Thread.interrupted() == false) goto L8;
        return;
    L8:
        n1.a r8 = this.f10824a;     // Catch: Throwable -> L22
        if (r8 == null) goto L21;
        n1 r10 = r8.f10850a;     // Catch: Throwable -> L22
        monitor-enter(r10);     // Catch: Throwable -> L22
        r10.f10848b.remove(this);     // Catch: Throwable -> L14
    L16:
        monitor-exit(r10);     // Catch: Throwable -> L22
        return;
    L14:
        th = move-exception;
        q.f("TPool", "removeQueue", th);     // Catch: Throwable -> L18
        th.printStackTrace();     // Catch: Throwable -> L18
    L18:
        th = move-exception;
        throw th;     // Catch: Throwable -> L22
    }
}
