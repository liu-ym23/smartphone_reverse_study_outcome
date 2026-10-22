package io.reactivex.internal.operators.flowable;

import io.reactivex.internal.disposables.SequentialDisposable;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes2.dex */
final class FlowableTimeout$TimeoutSubscriber<T> extends AtomicLong implements xb.g<T>, tc.d, l {
    private static final long serialVersionUID = 3764492702657003550L;
    final tc.c<? super T> downstream;
    final zb.h<? super T, ? extends tc.b<?>> itemTimeoutIndicator;
    final AtomicLong requested;
    final SequentialDisposable task;
    final AtomicReference<tc.d> upstream;

    FlowableTimeout$TimeoutSubscriber(tc.c<? super T> r10, zb.h<? super T, ? extends tc.b<?>> r11) {
        this.downstream = r10;
        this.itemTimeoutIndicator = r11;
        this.task = new SequentialDisposable();
        this.upstream = new AtomicReference();
        this.requested = new AtomicLong();
    }

    @Override // tc.d
    public void cancel() {
        SubscriptionHelper.cancel(this.upstream);
        this.task.dispose();
    }

    @Override // tc.c
    public void onComplete() {
        if (getAndSet(Long.MAX_VALUE) == Long.MAX_VALUE) goto L6;
        this.task.dispose();
        this.downstream.onComplete();
        return;
    }

    @Override // tc.c
    public void onError(Throwable r10) {
        if (getAndSet(Long.MAX_VALUE) == Long.MAX_VALUE) goto L5;
        this.task.dispose();
        this.downstream.onError(r10);
        return;
    L5:
        dc.a.n(r10);
    }

    @Override // tc.c
    public void onNext(T r10) {
        long r11 = get();
        if (r11 == Long.MAX_VALUE) goto L22;
        long r12 = 1 + r11;
        if (compareAndSet(r11, r12) == false) goto L23;
        io.reactivex.disposables.b r13 = this.task.get();
        if (r13 == null) goto L10;
        r13.dispose();
    L10:
        this.downstream.onNext(r10);
        tc.b r14 = (tc.b) io.reactivex.internal.functions.a.d(this.itemTimeoutIndicator.apply(r10), "The itemTimeoutIndicator returned a null Publisher.");     // Catch: Throwable -> L16
        FlowableTimeout$TimeoutConsumer r15 = new FlowableTimeout$TimeoutConsumer(r12, this);
        if (this.task.replace(r15) == false) goto L21;
        r14.subscribe(r15);
        return;
    L21:
        return;
    L16:
        th = move-exception;
        io.reactivex.exceptions.a.a(th);
        this.upstream.get().cancel();
        getAndSet(Long.MAX_VALUE);
        this.downstream.onError(th);
        return;
    L23:
        return;
    }

    @Override // xb.g, tc.c
    public void onSubscribe(tc.d r10) {
        SubscriptionHelper.deferredSetOnce(this.upstream, this.requested, r10);
    }

    @Override // io.reactivex.internal.operators.flowable.n
    public void onTimeout(long r10) {
        if (compareAndSet(r10, Long.MAX_VALUE) == false) goto L6;
        SubscriptionHelper.cancel(this.upstream);
        this.downstream.onError(new TimeoutException());
        return;
    }

    @Override // io.reactivex.internal.operators.flowable.l
    public void onTimeoutError(long r10, Throwable r11) {
        if (compareAndSet(r10, Long.MAX_VALUE) == false) goto L5;
        SubscriptionHelper.cancel(this.upstream);
        this.downstream.onError(r11);
        return;
    L5:
        dc.a.n(r11);
    }

    @Override // tc.d
    public void request(long r10) {
        SubscriptionHelper.deferredRequest(this.upstream, this.requested, r10);
    }

    void startFirstTimeout(tc.b<?> r10) {
        if (r10 == null) goto L7;
        FlowableTimeout$TimeoutConsumer r11 = new FlowableTimeout$TimeoutConsumer(0, this);
        if (this.task.replace(r11) == false) goto L8;
        r10.subscribe(r11);
        return;
    L8:
        return;
    }
}
