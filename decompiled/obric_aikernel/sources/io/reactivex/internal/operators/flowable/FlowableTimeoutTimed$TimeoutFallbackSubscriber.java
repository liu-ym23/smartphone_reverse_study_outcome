package io.reactivex.internal.operators.flowable;

import io.reactivex.internal.disposables.SequentialDisposable;
import io.reactivex.internal.subscriptions.SubscriptionArbiter;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes2.dex */
final class FlowableTimeoutTimed$TimeoutFallbackSubscriber<T> extends SubscriptionArbiter implements xb.g<T>, n {
    private static final long serialVersionUID = 3764492702657003550L;
    long consumed;
    final tc.c<? super T> downstream;
    tc.b<? extends T> fallback;
    final AtomicLong index;
    final SequentialDisposable task;
    final long timeout;
    final TimeUnit unit;
    final AtomicReference<tc.d> upstream;
    final xb.p.c worker;

    FlowableTimeoutTimed$TimeoutFallbackSubscriber(tc.c<? super T> r10, long r11, TimeUnit r12, xb.p.c r13, tc.b<? extends T> r14) {
        super(true);
        this.downstream = r10;
        this.timeout = r11;
        this.unit = r12;
        this.worker = r13;
        this.fallback = r14;
        this.task = new SequentialDisposable();
        this.upstream = new AtomicReference();
        this.index = new AtomicLong();
    }

    @Override // io.reactivex.internal.subscriptions.SubscriptionArbiter, tc.d
    public void cancel() {
        super.cancel();
        this.worker.dispose();
    }

    @Override // tc.c
    public void onComplete() {
        if (this.index.getAndSet(Long.MAX_VALUE) == Long.MAX_VALUE) goto L6;
        this.task.dispose();
        this.downstream.onComplete();
        this.worker.dispose();
        return;
    }

    @Override // tc.c
    public void onError(Throwable r10) {
        if (this.index.getAndSet(Long.MAX_VALUE) == Long.MAX_VALUE) goto L5;
        this.task.dispose();
        this.downstream.onError(r10);
        this.worker.dispose();
        return;
    L5:
        dc.a.n(r10);
    }

    @Override // tc.c
    public void onNext(T r10) {
        long r11 = this.index.get();
        if (r11 == Long.MAX_VALUE) goto L9;
        long r12 = r11 + 1;
        if (this.index.compareAndSet(r11, r12) == false) goto L10;
        this.task.get().dispose();
        this.consumed++;
        this.downstream.onNext(r10);
        startTimeout(r12);
        return;
    L10:
        return;
    }

    @Override // xb.g, tc.c
    public void onSubscribe(tc.d r10) {
        if (SubscriptionHelper.setOnce(this.upstream, r10) == false) goto L6;
        setSubscription(r10);
        return;
    }

    @Override // io.reactivex.internal.operators.flowable.n
    public void onTimeout(long r10) {
        if (this.index.compareAndSet(r10, Long.MAX_VALUE) == false) goto L9;
        SubscriptionHelper.cancel(this.upstream);
        long r11 = this.consumed;
        if (r11 == 0) goto L7;
        produced(r11);
    L7:
        tc.b<? extends T> r12 = this.fallback;
        this.fallback = null;
        r12.subscribe(new m(this.downstream, this));
        this.worker.dispose();
        return;
    }

    void startTimeout(long r10) {
        this.task.replace(this.worker.c(new o(r10, this), this.timeout, this.unit));
    }
}
