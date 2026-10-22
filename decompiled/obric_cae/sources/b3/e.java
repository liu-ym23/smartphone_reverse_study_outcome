package b3;

/* JADX INFO: loaded from: classes.dex */
public final class e implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ f f3041a;

    public e(f r8) {
        this.f3041a = r8;
    }

    /* JADX INFO: Infinite loop detected, blocks: 8, insns: 0 */
    @Override // java.lang.Runnable
    public final void run() {
    L6:
        ((Runnable) this.f3041a.f3042a.take()).run();     // Catch: InterruptedException -> L4
    L4:
        e = move-exception;
        e.printStackTrace();
        goto L6
    }
}
