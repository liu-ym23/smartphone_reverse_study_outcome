package io.reactivex.internal.operators.maybe;

import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.SequentialDisposable;
import java.util.concurrent.atomic.AtomicReference;
import xb.j;

/* JADX INFO: loaded from: classes2.dex */
final class MaybeSubscribeOn$SubscribeOnMaybeObserver<T> extends AtomicReference<io.reactivex.disposables.b> implements j<T>, io.reactivex.disposables.b {
    private static final long serialVersionUID = 8571289934935992137L;
    final j<? super T> downstream;
    final SequentialDisposable task;

    MaybeSubscribeOn$SubscribeOnMaybeObserver(j<? super T> r10) {
        this.downstream = r10;
        this.task = new SequentialDisposable();
    }

    @Override // io.reactivex.disposables.b
    public void dispose() {
        DisposableHelper.dispose(this);
        this.task.dispose();
    }

    @Override // io.reactivex.disposables.b
    public boolean isDisposed() {
        return DisposableHelper.isDisposed(get());
    }

    @Override // xb.j
    public void onComplete() {
        this.downstream.onComplete();
    }

    @Override // xb.j
    public void onError(Throwable r10) {
        this.downstream.onError(r10);
    }

    @Override // xb.j
    public void onSubscribe(io.reactivex.disposables.b r10) {
        DisposableHelper.setOnce(this, r10);
    }

    @Override // xb.j
    public void onSuccess(T r10) {
        this.downstream.onSuccess(r10);
    }
}
