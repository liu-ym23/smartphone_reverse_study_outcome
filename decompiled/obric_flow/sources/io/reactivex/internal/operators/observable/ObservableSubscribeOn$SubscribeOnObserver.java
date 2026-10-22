package io.reactivex.internal.operators.observable;

import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes3.dex */
final class ObservableSubscribeOn$SubscribeOnObserver<T> extends AtomicReference<Disposable> implements mt.u, Disposable {
    private static final long serialVersionUID = 8094547886072529208L;
    final mt.u downstream;
    final AtomicReference<Disposable> upstream;

    public ObservableSubscribeOn$SubscribeOnObserver(mt.u r5) {
        this.downstream = r5;
        this.upstream = new AtomicReference();
    }

    @Override // io.reactivex.disposables.Disposable
    public void dispose() {
        DisposableHelper.dispose(this.upstream);
        DisposableHelper.dispose(this);
    }

    @Override // io.reactivex.disposables.Disposable
    public boolean isDisposed() {
        return DisposableHelper.isDisposed(get());
    }

    @Override // mt.u
    public void onComplete() {
        this.downstream.onComplete();
    }

    @Override // mt.u
    public void onError(Throwable r5) {
        this.downstream.onError(r5);
    }

    @Override // mt.u
    public void onNext(T r5) {
        this.downstream.onNext(r5);
    }

    @Override // mt.u
    public void onSubscribe(Disposable r5) {
        DisposableHelper.setOnce(this.upstream, r5);
    }

    public void setDisposable(Disposable r5) {
        DisposableHelper.setOnce(this, r5);
    }
}
