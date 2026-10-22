package io.reactivex.internal.operators.observable;

import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes3.dex */
final class ObservableThrottleFirstTimed$DebounceTimedObserver<T> extends AtomicReference<Disposable> implements mt.u, Disposable, Runnable {
    private static final long serialVersionUID = 786994795061867455L;
    boolean done;
    final mt.u downstream;
    volatile boolean gate;
    final long timeout;
    final TimeUnit unit;
    Disposable upstream;
    final mt.y worker;

    public ObservableThrottleFirstTimed$DebounceTimedObserver(mt.u r5, long r10, TimeUnit r11, mt.y r12) {
        this.downstream = r5;
        this.timeout = r10;
        this.unit = r11;
        this.worker = r12;
    }

    @Override // io.reactivex.disposables.Disposable
    public void dispose() {
        this.upstream.dispose();
        this.worker.dispose();
    }

    @Override // io.reactivex.disposables.Disposable
    public boolean isDisposed() {
        return this.worker.isDisposed();
    }

    @Override // mt.u
    public void onComplete() {
        if (this.done == true) goto L6;
        this.done = true;
        this.downstream.onComplete();
        this.worker.dispose();
        return;
    }

    @Override // mt.u
    public void onError(Throwable r5) {
        if (this.done == false) goto L5;
        wn.f.k(r5);
        return;
    L5:
        this.done = true;
        this.downstream.onError(r5);
        this.worker.dispose();
    }

    @Override // mt.u
    public void onNext(T r5) {
        if (this.gate == false) goto L5;
        return;
    L5:
        if (this.done == true) goto L12;
        this.gate = true;
        this.downstream.onNext(r5);
        Disposable r10 = get();
        if (r10 == null) goto L9;
        r10.dispose();
    L9:
        DisposableHelper.replace(this, this.worker.b(this, this.timeout, this.unit));
        return;
    }

    @Override // mt.u
    public void onSubscribe(Disposable r5) {
        if (DisposableHelper.validate(this.upstream, r5) == false) goto L6;
        this.upstream = r5;
        this.downstream.onSubscribe(this);
        return;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.gate = false;
    }
}
