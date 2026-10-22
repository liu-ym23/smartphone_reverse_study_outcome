package io.reactivex.internal.operators.observable;

import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes2.dex */
public final class ObserverResourceWrapper<T> extends AtomicReference<io.reactivex.disposables.b> implements xb.o<T>, io.reactivex.disposables.b {
    private static final long serialVersionUID = -8612022020200669122L;
    final xb.o<? super T> downstream;
    final AtomicReference<io.reactivex.disposables.b> upstream;

    public ObserverResourceWrapper(xb.o<? super T> r10) {
        this.upstream = new AtomicReference();
        this.downstream = r10;
    }

    @Override // io.reactivex.disposables.b
    public void dispose() {
        DisposableHelper.dispose(this.upstream);
        DisposableHelper.dispose(this);
    }

    @Override // io.reactivex.disposables.b
    public boolean isDisposed() {
        if (this.upstream.get() != DisposableHelper.DISPOSED) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // xb.o
    public void onComplete() {
        dispose();
        this.downstream.onComplete();
    }

    @Override // xb.o
    public void onError(Throwable r10) {
        dispose();
        this.downstream.onError(r10);
    }

    @Override // xb.o
    public void onNext(T r10) {
        this.downstream.onNext(r10);
    }

    @Override // xb.o
    public void onSubscribe(io.reactivex.disposables.b r10) {
        if (DisposableHelper.setOnce(this.upstream, r10) == false) goto L6;
        this.downstream.onSubscribe(this);
        return;
    }

    public void setResource(io.reactivex.disposables.b r10) {
        DisposableHelper.set(this, r10);
    }
}
