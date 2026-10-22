package io.reactivex.internal.operators.observable;

import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.SequentialDisposable;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes3.dex */
final class ObservableTimeout$TimeoutObserver<T> extends AtomicLong implements mt.u, Disposable, g4 {
    private static final long serialVersionUID = 3764492702657003550L;
    final mt.u downstream;
    final pt.o itemTimeoutIndicator;
    final SequentialDisposable task;
    final AtomicReference<Disposable> upstream;

    public ObservableTimeout$TimeoutObserver(mt.u r5, pt.o r10) {
        this.downstream = r5;
        this.itemTimeoutIndicator = r10;
        this.task = new SequentialDisposable();
        this.upstream = new AtomicReference();
    }

    @Override // io.reactivex.disposables.Disposable
    public void dispose() {
        DisposableHelper.dispose(this.upstream);
        this.task.dispose();
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
        return;
    }

    @Override // mt.u
    public void onError(Throwable r5) {
        if (getAndSet(Long.MAX_VALUE) == Long.MAX_VALUE) goto L5;
        this.task.dispose();
        this.downstream.onError(r5);
        return;
    L5:
        wn.f.k(r5);
    }

    @Override // mt.u
    public void onNext(T r10) {
        long r5 = get();
        if (r5 == Long.MAX_VALUE) goto L22;
        long r11 = 1 + r5;
        if (compareAndSet(r5, r11) == false) goto L23;
        Disposable r12 = this.task.get();
        if (r12 == null) goto L10;
        r12.dispose();
    L10:
        this.downstream.onNext(r10);
        Object r13 = this.itemTimeoutIndicator.apply(r10);     // Catch: Throwable -> L16
        io.reactivex.internal.functions.e.d(r13, "The itemTimeoutIndicator returned a null ObservableSource.");     // Catch: Throwable -> L16
        mt.s r14 = (mt.s) r13;     // Catch: Throwable -> L16
        ObservableTimeout$TimeoutConsumer r15 = new ObservableTimeout$TimeoutConsumer(r11, this);
        if (this.task.replace(r15) == false) goto L21;
        r14.subscribe(r15);
        return;
    L21:
        return;
    L16:
        th = move-exception;
        com.lynx.jsbridge.a.t(th);
        this.upstream.get().dispose();
        getAndSet(Long.MAX_VALUE);
        this.downstream.onError(th);
        return;
    L23:
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
        this.downstream.onError(new TimeoutException());
        return;
    }

    @Override // io.reactivex.internal.operators.observable.g4
    public void onTimeoutError(long r5, Throwable r10) {
        if (compareAndSet(r5, Long.MAX_VALUE) == false) goto L5;
        DisposableHelper.dispose(this.upstream);
        this.downstream.onError(r10);
        return;
    L5:
        wn.f.k(r10);
    }

    public void startFirstTimeout(mt.s r5) {
        if (r5 == null) goto L7;
        ObservableTimeout$TimeoutConsumer r10 = new ObservableTimeout$TimeoutConsumer(0, this);
        if (this.task.replace(r10) == false) goto L8;
        r5.subscribe(r10);
        return;
    L8:
        return;
    }
}
