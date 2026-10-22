package io.reactivex.internal.operators.observable;

import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes3.dex */
final class ObservablePublishSelector$TargetObserver<T, R> extends AtomicReference<Disposable> implements mt.u, Disposable {
    private static final long serialVersionUID = 854110278590336484L;
    final mt.u downstream;
    Disposable upstream;

    public ObservablePublishSelector$TargetObserver(mt.u r5) {
        this.downstream = r5;
    }

    @Override // io.reactivex.disposables.Disposable
    public void dispose() {
        this.upstream.dispose();
        DisposableHelper.dispose(this);
    }

    @Override // io.reactivex.disposables.Disposable
    public boolean isDisposed() {
        return this.upstream.isDisposed();
    }

    @Override // mt.u
    public void onComplete() {
        DisposableHelper.dispose(this);
        this.downstream.onComplete();
    }

    @Override // mt.u
    public void onError(Throwable r5) {
        DisposableHelper.dispose(this);
        this.downstream.onError(r5);
    }

    @Override // mt.u
    public void onNext(R r5) {
        this.downstream.onNext(r5);
    }

    @Override // mt.u
    public void onSubscribe(Disposable r5) {
        if (DisposableHelper.validate(this.upstream, r5) == false) goto L6;
        this.upstream = r5;
        this.downstream.onSubscribe(this);
        return;
    }
}
