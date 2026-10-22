package io.reactivex.internal.operators.flowable;

import io.reactivex.internal.disposables.SequentialDisposable;
import io.reactivex.internal.subscriptions.SubscriptionArbiter;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes3.dex */
final class FlowableTimeoutTimed$TimeoutFallbackSubscriber<T> extends SubscriptionArbiter implements mt.g, w {
    private static final long serialVersionUID = 3764492702657003550L;
    long consumed;
    final zu.c downstream;
    zu.b fallback;
    final AtomicLong index;
    final SequentialDisposable task;
    final long timeout;
    final TimeUnit unit;
    final AtomicReference<zu.d> upstream;
    final mt.y worker;

    public FlowableTimeoutTimed$TimeoutFallbackSubscriber(zu.c r5, long r10, TimeUnit r11, mt.y r12, zu.b r13) {
        super(true);
        this.downstream = r5;
        this.timeout = r10;
        this.unit = r11;
        this.worker = r12;
        this.fallback = r13;
        this.task = new SequentialDisposable();
        this.upstream = new AtomicReference();
        this.index = new AtomicLong();
    }

    @Override // io.reactivex.internal.subscriptions.SubscriptionArbiter, zu.d
    public void cancel() {
        super.cancel();
        this.worker.dispose();
    }

    @Override // zu.c
    public void onComplete() {
        if (this.index.getAndSet(Long.MAX_VALUE) == Long.MAX_VALUE) goto L6;
        this.task.dispose();
        this.downstream.onComplete();
        this.worker.dispose();
        return;
    }

    @Override // zu.c
    public void onError(Throwable r10) {
        if (this.index.getAndSet(Long.MAX_VALUE) == Long.MAX_VALUE) goto L5;
        this.task.dispose();
        this.downstream.onError(r10);
        this.worker.dispose();
        return;
    L5:
        wn.f.k(r10);
    }

    @Override // zu.c
    public void onNext(T r10) {
        long r5 = this.index.get();
        if (r5 == Long.MAX_VALUE) goto L9;
        long r11 = r5 + 1;
        if (this.index.compareAndSet(r5, r11) == false) goto L10;
        this.task.get().dispose();
        this.consumed++;
        this.downstream.onNext(r10);
        startTimeout(r11);
        return;
    L10:
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
        long r10 = this.consumed;
        if (r10 == 0) goto L7;
        produced(r10);
    L7:
        zu.b r11 = this.fallback;
        this.fallback = null;
        r11.subscribe(new v(this.downstream, this));
        this.worker.dispose();
        return;
    }

    public void startTimeout(long r5) {
        this.task.replace(this.worker.b(new com.bytedance.ies.bullet.ui.common.e(r5, this), this.timeout, this.unit));
    }
}
