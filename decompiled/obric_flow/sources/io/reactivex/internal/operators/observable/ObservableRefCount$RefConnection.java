package io.reactivex.internal.operators.observable;

import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes3.dex */
final class ObservableRefCount$RefConnection extends AtomicReference<Disposable> implements Runnable, pt.g {
    private static final long serialVersionUID = -4552101107598366241L;
    boolean connected;
    boolean disconnectedEarly;
    final a3 parent;
    long subscriberCount;
    Disposable timer;

    public ObservableRefCount$RefConnection(a3 r5) {
        this.parent = r5;
    }

    @Override // pt.g
    public /* bridge */ /* synthetic */ void accept(Object r5) throws Exception {
        accept((Disposable) r5);
    }

    @Override // java.lang.Runnable
    public void run() {
        this.parent.e(this);
    }

    public void accept(Disposable r5) throws Exception {
        DisposableHelper.replace(this, r5);
        a3 r10 = this.parent;
        monitor-enter(r10);
    L7:
        th = move-exception;
        throw th;
    L5:
        if (this.disconnectedEarly == false) goto L9;
        ((qt.c) this.parent.f17709a).a(r5);     // Catch: Throwable -> L7
    L9:
        monitor-exit(r10);     // Catch: Throwable -> L7
    }
}
