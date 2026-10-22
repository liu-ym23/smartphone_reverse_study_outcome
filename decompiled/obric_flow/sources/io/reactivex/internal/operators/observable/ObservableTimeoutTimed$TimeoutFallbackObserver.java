package io.reactivex.internal.operators.observable;

import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.SequentialDisposable;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes3.dex */
final class ObservableTimeoutTimed$TimeoutFallbackObserver<T> extends AtomicReference<Disposable> implements mt.u, Disposable, h4 {
    private static final long serialVersionUID = 3764492702657003550L;
    final mt.u downstream;
    mt.s fallback;
    final AtomicLong index;
    final SequentialDisposable task;
    final long timeout;
    final TimeUnit unit;
    final AtomicReference<Disposable> upstream;
    final mt.y worker;

    public ObservableTimeoutTimed$TimeoutFallbackObserver(mt.u r5, long r10, TimeUnit r11, mt.y r12, mt.s r13) {
        this.downstream = r5;
        this.timeout = r10;
        this.unit = r11;
        this.worker = r12;
        this.fallback = r13;
        this.task = new SequentialDisposable();
        this.index = new AtomicLong();
        this.upstream = new AtomicReference();
    }

    @Override // io.reactivex.disposables.Disposable
    public void dispose() {
        DisposableHelper.dispose(this.upstream);
        DisposableHelper.dispose(this);
        this.worker.dispose();
    }

    @Override // io.reactivex.disposables.Disposable
    public boolean isDisposed() {
        return DisposableHelper.isDisposed(get());
    }

    @Override // mt.u
    public void onComplete() {
        if (this.index.getAndSet(Long.MAX_VALUE) == Long.MAX_VALUE) goto L6;
        this.task.dispose();
        this.downstream.onComplete();
        this.worker.dispose();
        return;
    }

    @Override // mt.u
    public void onError(Throwable r10) {
        if (this.index.getAndSet(Long.MAX_VALUE) == Long.MAX_VALUE) goto L5;
        this.task.dispose();
        this.downstream.onError(r10);
        this.worker.dispose();
        return;
    L5:
        wn.f.k(r10);
    }

    @Override // mt.u
    public void onNext(T r10) {
        long r5 = this.index.get();
        if (r5 == Long.MAX_VALUE) goto L9;
        long r11 = 1 + r5;
        if (this.index.compareAndSet(r5, r11) == false) goto L10;
        this.task.get().dispose();
        this.downstream.onNext(r10);
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
        if (this.index.compareAndSet(r5, Long.MAX_VALUE) == false) goto L6;
        DisposableHelper.dispose(this.upstream);
        mt.s r10 = this.fallback;
        this.fallback = null;
        r10.subscribe(new u2(this.downstream, this, 1));
        this.worker.dispose();
        return;
    }

    public void startTimeout(long r5) {
        this.task.replace(this.worker.b(new com.bytedance.ies.bullet.ui.common.e(r5, this, 5), this.timeout, this.unit));
    }
}
