package io.reactivex.internal.operators.maybe;

import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import xb.j;
import xb.p;

/* JADX INFO: loaded from: classes2.dex */
final class MaybeDelay$DelayMaybeObserver<T> extends AtomicReference<io.reactivex.disposables.b> implements j<T>, io.reactivex.disposables.b, Runnable {
    private static final long serialVersionUID = 5566860102500855068L;
    final long delay;
    final j<? super T> downstream;
    Throwable error;
    final p scheduler;
    final TimeUnit unit;
    T value;

    MaybeDelay$DelayMaybeObserver(j<? super T> r10, long r11, TimeUnit r12, p r13) {
        this.downstream = r10;
        this.delay = r11;
        this.unit = r12;
        this.scheduler = r13;
    }

    @Override // io.reactivex.disposables.b
    public void dispose() {
        DisposableHelper.dispose(this);
    }

    @Override // io.reactivex.disposables.b
    public boolean isDisposed() {
        return DisposableHelper.isDisposed(get());
    }

    @Override // xb.j
    public void onComplete() {
        schedule();
    }

    @Override // xb.j
    public void onError(Throwable r10) {
        this.error = r10;
        schedule();
    }

    @Override // xb.j
    public void onSubscribe(io.reactivex.disposables.b r10) {
        if (DisposableHelper.setOnce(this, r10) == false) goto L6;
        this.downstream.onSubscribe(this);
        return;
    }

    @Override // xb.j
    public void onSuccess(T r10) {
        this.value = r10;
        schedule();
    }

    @Override // java.lang.Runnable
    public void run() {
        Throwable r10 = this.error;
        if (r10 == null) goto L5;
        this.downstream.onError(r10);
        return;
    L5:
        T r11 = this.value;
        j<? super T> r12 = this.downstream;
        if (r11 == null) goto L8;
        r12.onSuccess(r11);
        return;
    L8:
        r12.onComplete();
    }

    void schedule() {
        DisposableHelper.replace(this, this.scheduler.d(this, this.delay, this.unit));
    }
}
