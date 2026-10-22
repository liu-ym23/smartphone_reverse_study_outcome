package io.reactivex.internal.operators.observable;

import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.SequentialDisposable;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes3.dex */
final class ObservableTimeoutTimed$TimeoutObserver<T> extends AtomicLong implements mt.u, Disposable, h4 {
    private static final long serialVersionUID = 3764492702657003550L;
    final mt.u downstream;
    final SequentialDisposable task;
    final long timeout;
    final TimeUnit unit;
    final AtomicReference<Disposable> upstream;
    final mt.y worker;

    public ObservableTimeoutTimed$TimeoutObserver(mt.u r5, long r10, TimeUnit r11, mt.y r12) {
        this.downstream = r5;
        this.timeout = r10;
        this.unit = r11;
        this.worker = r12;
        this.task = new SequentialDisposable();
        this.upstream = new AtomicReference();
    }

    @Override // io.reactivex.disposables.Disposable
    public void dispose() {
        DisposableHelper.dispose(this.upstream);
        this.worker.dispose();
    }

    @Override // io.reactivex.disposables.Disposable
    public boolean isDisposed() {
        return DisposableHelper.isDisposed(this.upstream.get());
    }

    @Override // mt.u
    public void onComplete() {
        if (getAndSet(Long.MAX_VALUE) == Long.MAX_VALUE) goto L6;
        this.task.dispose();
        this.downstream.onComplete();
        this.worker.dispose();
        return;
    }

    @Override // mt.u
    public void onError(Throwable r5) {
        if (getAndSet(Long.MAX_VALUE) == Long.MAX_VALUE) goto L5;
        this.task.dispose();
        this.downstream.onError(r5);
        this.worker.dispose();
        return;
    L5:
        wn.f.k(r5);
    }

    @Override // mt.u
    public void onNext(T r5) {
        long r10 = get();
        if (r10 == Long.MAX_VALUE) goto L9;
        long r11 = 1 + r10;
        if (compareAndSet(r10, r11) == false) goto L10;
        this.task.get().dispose();
        this.downstream.onNext(r5);
        startTimeout(r11);
        return;
    L10:
        return;
    }

    @Override // mt.u
    public void onSubscribe(Disposable r5) {
        DisposableHelper.setOnce(this.upstream, r5);
    }

    @Override // io.reactivex.internal.operators.observable.h4
    public void onTimeout(long r5) {
        if (compareAndSet(r5, Long.MAX_VALUE) == false) goto L6;
        DisposableHelper.dispose(this.upstream);
        this.downstream.onError(new TimeoutException(io.reactivex.internal.util.d.c(this.timeout, this.unit)));
        this.worker.dispose();
        return;
    }

    public void startTimeout(long r5) {
        this.task.replace(this.worker.b(new com.bytedance.ies.bullet.ui.common.e(r5, this, 5), this.timeout, this.unit));
    }
}
