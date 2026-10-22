package io.reactivex.internal.operators.completable;

import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.SequentialDisposable;
import java.util.concurrent.atomic.AtomicReference;
import mt.b;
import mt.c;

/* JADX INFO: loaded from: classes3.dex */
final class CompletableSubscribeOn$SubscribeOnObserver extends AtomicReference<Disposable> implements b, Disposable, Runnable {
    private static final long serialVersionUID = 7000911171163930287L;
    final b downstream;
    final c source;
    final SequentialDisposable task;

    public CompletableSubscribeOn$SubscribeOnObserver(b r5, c r10) {
        this.downstream = r5;
        this.source = r10;
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

    @Override // mt.b
    public void onComplete() {
        this.downstream.onComplete();
    }

    @Override // mt.b
    public void onError(Throwable r5) {
        this.downstream.onError(r5);
    }

    @Override // mt.b
    public void onSubscribe(Disposable r5) {
        DisposableHelper.setOnce(this, r5);
    }

    @Override // java.lang.Runnable
    public void run() {
        ((mt.a) this.source).b(this);
    }
}
