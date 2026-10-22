package io.reactivex.internal.operators.flowable;

import com.lynx.tasm.behavior.v0;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.internal.disposables.SequentialDisposable;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: loaded from: classes3.dex */
final class FlowableThrottleFirstTimed$DebounceTimedSubscriber<T> extends AtomicLong implements mt.g, zu.d, Runnable {
    private static final long serialVersionUID = -9102637559663639004L;
    boolean done;
    final zu.c downstream;
    volatile boolean gate;
    final long timeout;
    final SequentialDisposable timer;
    final TimeUnit unit;
    zu.d upstream;
    final mt.y worker;

    public FlowableThrottleFirstTimed$DebounceTimedSubscriber(zu.c r5, long r10, TimeUnit r11, mt.y r12) {
        this.timer = new SequentialDisposable();
        this.downstream = r5;
        this.timeout = r10;
        this.unit = r11;
        this.worker = r12;
    }

    @Override // zu.d
    public void cancel() {
        this.upstream.cancel();
        this.worker.dispose();
    }

    @Override // zu.c
    public void onComplete() {
        if (this.done == false) goto L5;
        return;
    L5:
        this.done = true;
        this.downstream.onComplete();
        this.worker.dispose();
    }

    @Override // zu.c
    public void onError(Throwable r5) {
        if (this.done == false) goto L6;
        wn.f.k(r5);
        return;
    L6:
        this.done = true;
        this.downstream.onError(r5);
        this.worker.dispose();
    }

    @Override // zu.c
    public void onNext(T r10) {
        if (this.done == false) goto L6;
        return;
    L6:
        if (this.gate == true) goto L15;
        this.gate = true;
        if (get() == 0) goto L13;
        this.downstream.onNext(r10);
        v0.y(this, 1);
        Disposable r11 = this.timer.get();
        if (r11 == null) goto L12;
        r11.dispose();
    L12:
        this.timer.replace(this.worker.b(this, this.timeout, this.unit));
        return;
    L13:
        this.done = true;
        cancel();
        this.downstream.onError(new MissingBackpressureException("Could not deliver value due to lack of requests"));
        return;
    }

    @Override // zu.c
    public void onSubscribe(zu.d r5) {
        if (SubscriptionHelper.validate(this.upstream, r5) == false) goto L6;
        this.upstream = r5;
        this.downstream.onSubscribe(this);
        r5.request(Long.MAX_VALUE);
        return;
    }

    @Override // zu.d
    public void request(long r5) {
        if (SubscriptionHelper.validate(r5) == false) goto L6;
        v0.r(this, r5);
        return;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.gate = false;
    }
}
