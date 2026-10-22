package io.reactivex.internal.operators.maybe;

import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import mt.j;
import mt.z;

/* JADX INFO: loaded from: classes3.dex */
final class MaybeDelay$DelayMaybeObserver<T> extends AtomicReference<Disposable> implements j, Disposable, Runnable {
    private static final long serialVersionUID = 5566860102500855068L;
    final long delay;
    final j downstream;
    Throwable error;
    final z scheduler;
    final TimeUnit unit;
    T value;

    public MaybeDelay$DelayMaybeObserver(j r5, long r10, TimeUnit r11, z r12) {
        this.downstream = r5;
        this.delay = r10;
        this.unit = r11;
        this.scheduler = r12;
    }

    @Override // io.reactivex.disposables.Disposable
    public void dispose() {
        DisposableHelper.dispose(this);
    }

    @Override // io.reactivex.disposables.Disposable
    public boolean isDisposed() {
        return DisposableHelper.isDisposed(get());
    }

    @Override // mt.j
    public void onComplete() {
        schedule();
    }

    @Override // mt.j
    public void onError(Throwable r5) {
        this.error = r5;
        schedule();
    }

    @Override // mt.j
    public void onSubscribe(Disposable r5) {
        if (DisposableHelper.setOnce(this, r5) == false) goto L6;
        this.downstream.onSubscribe(this);
        return;
    }

    @Override // mt.j
    public void onSuccess(T r5) {
        this.value = r5;
        schedule();
    }

    @Override // java.lang.Runnable
    public void run() {
        Throwable r5 = this.error;
        if (r5 == null) goto L5;
        this.downstream.onError(r5);
        return;
    L5:
        T r10 = this.value;
        if (r10 == null) goto L8;
        this.downstream.onSuccess(r10);
        return;
    L8:
        this.downstream.onComplete();
    }

    public void schedule() {
        DisposableHelper.replace(this, this.scheduler.d(this, this.delay, this.unit));
    }
}
