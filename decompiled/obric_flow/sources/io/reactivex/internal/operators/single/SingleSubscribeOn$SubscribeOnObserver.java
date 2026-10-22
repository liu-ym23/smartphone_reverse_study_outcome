package io.reactivex.internal.operators.single;

import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.SequentialDisposable;
import java.util.concurrent.atomic.AtomicReference;
import mt.a0;
import mt.b0;
import mt.c0;

/* JADX INFO: loaded from: classes3.dex */
final class SingleSubscribeOn$SubscribeOnObserver<T> extends AtomicReference<Disposable> implements b0, Disposable, Runnable {
    private static final long serialVersionUID = 7000911171163930287L;
    final b0 downstream;
    final c0 source;
    final SequentialDisposable task;

    public SingleSubscribeOn$SubscribeOnObserver(b0 r5, c0 r10) {
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

    @Override // mt.b0, mt.j
    public void onError(Throwable r5) {
        this.downstream.onError(r5);
    }

    @Override // mt.b0, mt.j
    public void onSubscribe(Disposable r5) {
        DisposableHelper.setOnce(this, r5);
    }

    @Override // mt.b0, mt.j
    public void onSuccess(T r5) {
        this.downstream.onSuccess(r5);
    }

    @Override // java.lang.Runnable
    public void run() {
        ((a0) this.source).b(this);
    }
}
