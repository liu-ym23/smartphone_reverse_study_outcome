package io.reactivex.internal.operators.single;

import io.reactivex.disposables.b;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.SequentialDisposable;
import java.util.concurrent.atomic.AtomicReference;
import xb.r;
import xb.s;

/* JADX INFO: loaded from: classes2.dex */
final class SingleSubscribeOn$SubscribeOnObserver<T> extends AtomicReference<b> implements r<T>, b, Runnable {
    private static final long serialVersionUID = 7000911171163930287L;
    final r<? super T> downstream;
    final s<? extends T> source;
    final SequentialDisposable task;

    SingleSubscribeOn$SubscribeOnObserver(r<? super T> r10, s<? extends T> r11) {
        this.downstream = r10;
        this.source = r11;
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

    @Override // xb.r
    public void onError(Throwable r10) {
        this.downstream.onError(r10);
    }

    @Override // xb.r
    public void onSubscribe(b r10) {
        DisposableHelper.setOnce(this, r10);
    }

    @Override // xb.r
    public void onSuccess(T r10) {
        this.downstream.onSuccess(r10);
    }

    @Override // java.lang.Runnable
    public void run() {
        this.source.a(this);
    }
}
