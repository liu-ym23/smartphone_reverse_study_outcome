package io.reactivex.internal.operators.observable;

import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes2.dex */
final class ObservablePublishSelector$TargetObserver<T, R> extends AtomicReference<io.reactivex.disposables.b> implements xb.o<R>, io.reactivex.disposables.b {
    private static final long serialVersionUID = 854110278590336484L;
    final xb.o<? super R> downstream;
    io.reactivex.disposables.b upstream;

    ObservablePublishSelector$TargetObserver(xb.o<? super R> r10) {
        this.downstream = r10;
    }

    @Override // io.reactivex.disposables.b
    public void dispose() {
        this.upstream.dispose();
        DisposableHelper.dispose(this);
    }

    @Override // io.reactivex.disposables.b
    public boolean isDisposed() {
        return this.upstream.isDisposed();
    }

    @Override // xb.o
    public void onComplete() {
        DisposableHelper.dispose(this);
        this.downstream.onComplete();
    }

    @Override // xb.o
    public void onError(Throwable r10) {
        DisposableHelper.dispose(this);
        this.downstream.onError(r10);
    }

    @Override // xb.o
    public void onNext(R r10) {
        this.downstream.onNext(r10);
    }

    @Override // xb.o
    public void onSubscribe(io.reactivex.disposables.b r10) {
        if (DisposableHelper.validate(this.upstream, r10) == false) goto L6;
        this.upstream = r10;
        this.downstream.onSubscribe(this);
        return;
    }
}
