package io.reactivex.internal.operators.flowable;

import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.SequentialDisposable;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes3.dex */
final class FlowableTimeout$TimeoutSubscriber<T> extends AtomicLong implements mt.g, zu.d, u {
    private static final long serialVersionUID = 3764492702657003550L;
    final zu.c downstream;
    final pt.o itemTimeoutIndicator;
    final AtomicLong requested;
    final SequentialDisposable task;
    final AtomicReference<zu.d> upstream;

    public FlowableTimeout$TimeoutSubscriber(zu.c r5, pt.o r10) {
        this.downstream = r5;
        this.itemTimeoutIndicator = r10;
        this.task = new SequentialDisposable();
        this.upstream = new AtomicReference();
        this.requested = new AtomicLong();
    }

    @Override // zu.d
    public void cancel() {
        SubscriptionHelper.cancel(this.upstream);
        this.task.dispose();
    }

    @Override // zu.c
    public void onComplete() {
        if (getAndSet(Long.MAX_VALUE) == Long.MAX_VALUE) goto L6;
        this.task.dispose();
        this.downstream.onComplete();
        return;
    }

    @Override // zu.c
    public void onError(Throwable r5) {
        if (getAndSet(Long.MAX_VALUE) == Long.MAX_VALUE) goto L5;
        this.task.dispose();
        this.downstream.onError(r5);
        return;
    L5:
        wn.f.k(r5);
    }

    @Override // zu.c
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
        getAndSet(Long.MAX_VALUE);
        this.downstream.onError(th);
        return;
    L23:
        return;
    }

    @Override // zu.c
    public void onSubscribe(zu.d r5) {
        SubscriptionHelper.deferredSetOnce(this.upstream, this.requested, r5);
    }

    @Override // io.reactivex.internal.operators.flowable.w
    public void onTimeout(long r5) {
        if (compareAndSet(r5, Long.MAX_VALUE) == false) goto L6;
        SubscriptionHelper.cancel(this.upstream);
        this.downstream.onError(new TimeoutException());
        return;
    }

    @Override // io.reactivex.internal.operators.flowable.u
    public void onTimeoutError(long r5, Throwable r10) {
        if (compareAndSet(r5, Long.MAX_VALUE) == false) goto L5;
        SubscriptionHelper.cancel(this.upstream);
        this.downstream.onError(r10);
        return;
    L5:
        wn.f.k(r10);
    }

    @Override // zu.d
    public void request(long r5) {
        SubscriptionHelper.deferredRequest(this.upstream, this.requested, r5);
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
