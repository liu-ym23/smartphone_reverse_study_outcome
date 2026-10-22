package io.reactivex.internal.operators.maybe;

import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;
import mt.j;

/* JADX INFO: loaded from: classes3.dex */
final class MaybeTimeoutMaybe$TimeoutFallbackMaybeObserver<T> extends AtomicReference<Disposable> implements j {
    private static final long serialVersionUID = 8663801314800248617L;
    final j downstream;

    public MaybeTimeoutMaybe$TimeoutFallbackMaybeObserver(j r5) {
        this.downstream = r5;
    }

    @Override // mt.j
    public void onComplete() {
        this.downstream.onComplete();
    }

    @Override // mt.j
    public void onError(Throwable r5) {
        this.downstream.onError(r5);
    }

    @Override // mt.j
    public void onSubscribe(Disposable r5) {
        DisposableHelper.setOnce(this, r5);
    }

    @Override // mt.j
    public void onSuccess(T r5) {
        this.downstream.onSuccess(r5);
    }
}
