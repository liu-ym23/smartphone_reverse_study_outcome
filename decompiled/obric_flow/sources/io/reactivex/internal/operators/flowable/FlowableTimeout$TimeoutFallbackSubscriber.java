package io.reactivex.internal.operators.flowable;

import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.SequentialDisposable;
import io.reactivex.internal.subscriptions.SubscriptionArbiter;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes3.dex */
final class FlowableTimeout$TimeoutFallbackSubscriber<T> extends SubscriptionArbiter implements mt.g, u {
    private static final long serialVersionUID = 3764492702657003550L;
    long consumed;
    final zu.c downstream;
    zu.b fallback;
    final AtomicLong index;
    final pt.o itemTimeoutIndicator;
    final SequentialDisposable task;
    final AtomicReference<zu.d> upstream;

    public FlowableTimeout$TimeoutFallbackSubscriber(zu.c r5, pt.o r10, zu.b r11) {
        super(true);
        this.downstream = r5;
        this.itemTimeoutIndicator = r10;
        this.task = new SequentialDisposable();
        this.upstream = new AtomicReference();
        this.fallback = r11;
        this.index = new AtomicLong();
    }

    @Override // io.reactivex.internal.subscriptions.SubscriptionArbiter, zu.d
    public void cancel() {
        super.cancel();
        this.task.dispose();
    }

    @Override // zu.c
    public void onComplete() {
        if (this.index.getAndSet(Long.MAX_VALUE) == Long.MAX_VALUE) goto L6;
        this.task.dispose();
        this.downstream.onComplete();
        this.task.dispose();
        return;
    }

    @Override // zu.c
    public void onError(Throwable r10) {
        if (this.index.getAndSet(Long.MAX_VALUE) == Long.MAX_VALUE) goto L5;
        this.task.dispose();
        this.downstream.onError(r10);
        this.task.dispose();
        return;
    L5:
        wn.f.k(r10);
    }

    @Override // zu.c
    public void onNext(T r10) {
        long r5 = this.index.get();
        if (r5 == Long.MAX_VALUE) goto L22;
        long r11 = r5 + 1;
        if (this.index.compareAndSet(r5, r11) == false) goto L23;
        Disposable r12 = this.task.get();
        if (r12 == null) goto L10;
        r12.dispose();
    L10:
        this.consumed++;
        this.downstream.onNext(r10);
        Object r13 = this.itemTimeoutIndicator.apply(r10);     // Catch: Throwable -> L16
        io.reactivex.internal.functions.e.d(r13, "The itemTimeoutIndicator returned a null Publisher.");     // Catch: Throwable -> L16
        zu.b r14 = (zu.b) r13;     // Catch: Throwable -> L16
        FlowableTimeout$TimeoutConsumer r15 = new FlowableTimeout$TimeoutConsumer(r11, this);
        if (this.task.replace(r15) == false) goto L21;
        r14.subscribe(r15);
        return;
    L21:
        return;
    L16:
        th = move-exception;
        com.lynx.jsbridge.a.t(th);
        this.upstream.get().cancel();
        this.index.getAndSet(Long.MAX_VALUE);
        this.downstream.onError(th);
        return;
    L23:
        return;
    }

    @Override // zu.c
    public void onSubscribe(zu.d r5) {
        if (SubscriptionHelper.setOnce(this.upstream, r5) == false) goto L6;
        setSubscription(r5);
        return;
    }

    @Override // io.reactivex.internal.operators.flowable.w
    public void onTimeout(long r5) {
        if (this.index.compareAndSet(r5, Long.MAX_VALUE) == false) goto L9;
        SubscriptionHelper.cancel(this.upstream);
        zu.b r10 = this.fallback;
        this.fallback = null;
        long r11 = this.consumed;
        if (r11 == 0) goto L7;
        produced(r11);
    L7:
        r10.subscribe(new v(this.downstream, this));
        return;
    }

    @Override // io.reactivex.internal.operators.flowable.u
    public void onTimeoutError(long r5, Throwable r10) {
        if (this.index.compareAndSet(r5, Long.MAX_VALUE) == false) goto L5;
        SubscriptionHelper.cancel(this.upstream);
        this.downstream.onError(r10);
        return;
    L5:
        wn.f.k(r10);
    }

    public void startFirstTimeout(zu.b r5) {
        if (r5 == null) goto L7;
        FlowableTimeout$TimeoutConsumer r10 = new FlowableTimeout$TimeoutConsumer(0, this);
        if (this.task.replace(r10) == false) goto L8;
        r5.subscribe(r10);
        return;
    L8:
        return;
    }
}
