package io.reactivex.internal.operators.maybe;

import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.SequentialDisposable;
import java.util.concurrent.atomic.AtomicReference;
import mt.j;

/* JADX INFO: loaded from: classes3.dex */
final class MaybeSubscribeOn$SubscribeOnMaybeObserver<T> extends AtomicReference<Disposable> implements j, Disposable {
    private static final long serialVersionUID = 8571289934935992137L;
    final j downstream;
    final SequentialDisposable task;

    public MaybeSubscribeOn$SubscribeOnMaybeObserver(j r5) {
        this.downstream = r5;
        this.task = new SequentialDisposable();
    }

    @Override // io.reactivex.disposables.Disposable
    public void dispose() {
        DisposableHelper.dispose(this);
        this.task.dispose();
    }

    @Override // io.reactivex.disposables.Disposable
    public boolean isDisposed() {
        return DisposableHelper.isDisposed(get());
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
