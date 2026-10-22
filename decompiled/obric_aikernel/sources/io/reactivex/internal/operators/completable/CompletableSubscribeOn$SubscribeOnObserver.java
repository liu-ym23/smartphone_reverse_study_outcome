package io.reactivex.internal.operators.completable;

import io.reactivex.disposables.b;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.SequentialDisposable;
import java.util.concurrent.atomic.AtomicReference;
import xb.c;

/* JADX INFO: loaded from: classes2.dex */
final class CompletableSubscribeOn$SubscribeOnObserver extends AtomicReference<b> implements xb.b, b, Runnable {
    private static final long serialVersionUID = 7000911171163930287L;
    final xb.b downstream;
    final c source;
    final SequentialDisposable task;

    CompletableSubscribeOn$SubscribeOnObserver(xb.b r10, c r11) {
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

    @Override // xb.b
    public void onComplete() {
        this.downstream.onComplete();
    }

    @Override // xb.b
    public void onError(Throwable r10) {
        this.downstream.onError(r10);
    }

    @Override // xb.b
    public void onSubscribe(b r10) {
        DisposableHelper.setOnce(this, r10);
    }

    @Override // java.lang.Runnable
    public void run() {
        this.source.a(this);
    }
}
