package io.reactivex.internal.operators.observable;

import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes2.dex */
final class ObservableThrottleFirstTimed$DebounceTimedObserver<T> extends AtomicReference<io.reactivex.disposables.b> implements xb.o<T>, io.reactivex.disposables.b, Runnable {
    private static final long serialVersionUID = 786994795061867455L;
    boolean done;
    final xb.o<? super T> downstream;
    volatile boolean gate;
    final long timeout;
    final TimeUnit unit;
    io.reactivex.disposables.b upstream;
    final xb.p.c worker;

    ObservableThrottleFirstTimed$DebounceTimedObserver(xb.o<? super T> r10, long r11, TimeUnit r12, xb.p.c r13) {
        this.downstream = r10;
        this.timeout = r11;
        this.unit = r12;
        this.worker = r13;
    }

    @Override // io.reactivex.disposables.b
    public void dispose() {
        this.upstream.dispose();
        this.worker.dispose();
    }

    @Override // io.reactivex.disposables.b
    public boolean isDisposed() {
        return this.worker.isDisposed();
    }

    @Override // xb.o
    public void onComplete() {
        if (this.done == true) goto L6;
        this.done = true;
        this.downstream.onComplete();
        this.worker.dispose();
        return;
    }

    @Override // xb.o
    public void onError(Throwable r10) {
        if (this.done == false) goto L5;
        dc.a.n(r10);
        return;
    L5:
        this.done = true;
        this.downstream.onError(r10);
        this.worker.dispose();
    }

    @Override // xb.o
    public void onNext(T r10) {
        if (this.gate == false) goto L5;
        return;
    L5:
        if (this.done == true) goto L12;
        this.gate = true;
        this.downstream.onNext(r10);
        io.reactivex.disposables.b r11 = get();
        if (r11 == null) goto L9;
        r11.dispose();
    L9:
        DisposableHelper.replace(this, this.worker.c(this, this.timeout, this.unit));
        return;
    }

    @Override // xb.o
    public void onSubscribe(io.reactivex.disposables.b r10) {
        if (DisposableHelper.validate(this.upstream, r10) == false) goto L6;
        this.upstream = r10;
        this.downstream.onSubscribe(this);
        return;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.gate = false;
    }
}
