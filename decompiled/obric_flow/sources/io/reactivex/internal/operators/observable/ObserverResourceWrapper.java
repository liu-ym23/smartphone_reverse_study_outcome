package io.reactivex.internal.operators.observable;

import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes3.dex */
public final class ObserverResourceWrapper<T> extends AtomicReference<Disposable> implements mt.u, Disposable {
    private static final long serialVersionUID = -8612022020200669122L;
    final mt.u downstream;
    final AtomicReference<Disposable> upstream;

    public ObserverResourceWrapper(mt.u r5) {
        this.upstream = new AtomicReference();
        this.downstream = r5;
    }

    @Override // io.reactivex.disposables.Disposable
    public void dispose() {
        DisposableHelper.dispose(this.upstream);
        DisposableHelper.dispose(this);
    }

    @Override // io.reactivex.disposables.Disposable
    public boolean isDisposed() {
        if (this.upstream.get() != DisposableHelper.DISPOSED) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // mt.u
    public void onComplete() {
        dispose();
        this.downstream.onComplete();
    }

    @Override // mt.u
    public void onError(Throwable r5) {
        dispose();
        this.downstream.onError(r5);
    }

    @Override // mt.u
    public void onNext(T r5) {
        this.downstream.onNext(r5);
    }

    @Override // mt.u
    public void onSubscribe(Disposable r5) {
        if (DisposableHelper.setOnce(this.upstream, r5) == false) goto L6;
        this.downstream.onSubscribe(this);
        return;
    }

    public void setResource(Disposable r5) {
        DisposableHelper.set(this, r5);
    }
}
