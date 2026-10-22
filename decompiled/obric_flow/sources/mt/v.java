package mt;

import io.reactivex.disposables.Disposable;

/* JADX INFO: loaded from: classes3.dex */
public final class v implements Disposable, Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Runnable f20172a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final y f20173b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Thread f20174c;

    public v(Runnable r5, y r10) {
        this.f20172a = r5;
        this.f20173b = r10;
    }

    @Override // io.reactivex.disposables.Disposable
    public final void dispose() {
        if (this.f20174c != Thread.currentThread()) goto L9;
        y r5 = this.f20173b;
        if ((r5 instanceof io.reactivex.internal.schedulers.k) == false) goto L9;
        io.reactivex.internal.schedulers.k r10 = (io.reactivex.internal.schedulers.k) r5;
        if (r10.f18143b == true) goto L11;
        r10.f18143b = true;
        r10.f18142a.shutdown();
        return;
    L11:
        return;
    L9:
        this.f20173b.dispose();
    }

    @Override // io.reactivex.disposables.Disposable
    public final boolean isDisposed() {
        return this.f20173b.isDisposed();
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f20174c = Thread.currentThread();
        this.f20172a.run();     // Catch: Throwable -> L6
        dispose();
        this.f20174c = null;
        return;
    L6:
        th = move-exception;
        dispose();
        this.f20174c = null;
        throw th;
    }
}
