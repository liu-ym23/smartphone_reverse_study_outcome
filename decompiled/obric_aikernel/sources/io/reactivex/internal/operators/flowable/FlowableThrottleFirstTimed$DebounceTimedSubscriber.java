package io.reactivex.internal.operators.flowable;

import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.internal.disposables.SequentialDisposable;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: loaded from: classes2.dex */
final class FlowableThrottleFirstTimed$DebounceTimedSubscriber<T> extends AtomicLong implements xb.g<T>, tc.d, Runnable {
    private static final long serialVersionUID = -9102637559663639004L;
    boolean done;
    final tc.c<? super T> downstream;
    volatile boolean gate;
    final long timeout;
    final SequentialDisposable timer;
    final TimeUnit unit;
    tc.d upstream;
    final xb.p.c worker;

    FlowableThrottleFirstTimed$DebounceTimedSubscriber(tc.c<? super T> r10, long r11, TimeUnit r12, xb.p.c r13) {
        this.timer = new SequentialDisposable();
        this.downstream = r10;
        this.timeout = r11;
        this.unit = r12;
        this.worker = r13;
    }

    @Override // tc.d
    public void cancel() {
        this.upstream.cancel();
        this.worker.dispose();
    }

    @Override // tc.c
    public void onComplete() {
        if (this.done == false) goto L5;
        return;
    L5:
        this.done = true;
        this.downstream.onComplete();
        this.worker.dispose();
    }

    @Override // tc.c
    public void onError(Throwable r10) {
        if (this.done == false) goto L6;
        dc.a.n(r10);
        return;
    L6:
        this.done = true;
        this.downstream.onError(r10);
        this.worker.dispose();
    }

    @Override // tc.c
    public void onNext(T r10) {
        if (this.done == false) goto L6;
        return;
    L6:
        if (this.gate == true) goto L15;
        this.gate = true;
        if (get() == 0) goto L13;
        this.downstream.onNext(r10);
        io.reactivex.internal.util.b.e(this, 1);
        io.reactivex.disposables.b r11 = this.timer.get();
        if (r11 == null) goto L12;
        r11.dispose();
    L12:
        this.timer.replace(this.worker.c(this, this.timeout, this.unit));
        return;
    L13:
        this.done = true;
        cancel();
        this.downstream.onError(new MissingBackpressureException("Could not deliver value due to lack of requests"));
        return;
    }

    @Override // xb.g, tc.c
    public void onSubscribe(tc.d r10) {
        if (SubscriptionHelper.validate(this.upstream, r10) == false) goto L6;
        this.upstream = r10;
        this.downstream.onSubscribe(this);
        r10.request(Long.MAX_VALUE);
        return;
    }

    @Override // tc.d
    public void request(long r10) {
        if (SubscriptionHelper.validate(r10) == false) goto L6;
        io.reactivex.internal.util.b.a(this, r10);
        return;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.gate = false;
    }
}
