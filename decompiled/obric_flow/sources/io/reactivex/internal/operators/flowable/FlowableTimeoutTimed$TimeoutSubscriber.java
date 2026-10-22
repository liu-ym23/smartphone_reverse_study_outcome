package io.reactivex.internal.operators.flowable;

import io.reactivex.internal.disposables.SequentialDisposable;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes3.dex */
final class FlowableTimeoutTimed$TimeoutSubscriber<T> extends AtomicLong implements mt.g, zu.d, w {
    private static final long serialVersionUID = 3764492702657003550L;
    final zu.c downstream;
    final AtomicLong requested;
    final SequentialDisposable task;
    final long timeout;
    final TimeUnit unit;
    final AtomicReference<zu.d> upstream;
    final mt.y worker;

    public FlowableTimeoutTimed$TimeoutSubscriber(zu.c r5, long r10, TimeUnit r11, mt.y r12) {
        this.downstream = r5;
        this.timeout = r10;
        this.unit = r11;
        this.worker = r12;
        this.task = new SequentialDisposable();
        this.upstream = new AtomicReference();
        this.requested = new AtomicLong();
    }

    @Override // zu.d
    public void cancel() {
        SubscriptionHelper.cancel(this.upstream);
        this.worker.dispose();
    }

    @Override // zu.c
    public void onComplete() {
        if (getAndSet(Long.MAX_VALUE) == Long.MAX_VALUE) goto L6;
        this.task.dispose();
        this.downstream.onComplete();
        this.worker.dispose();
        return;
    }

    @Override // zu.c
    public void onError(Throwable r5) {
        if (getAndSet(Long.MAX_VALUE) == Long.MAX_VALUE) goto L5;
        this.task.dispose();
        this.downstream.onError(r5);
        this.worker.dispose();
        return;
    L5:
        wn.f.k(r5);
    }

    @Override // zu.c
    public void onNext(T r5) {
        long r10 = get();
        if (r10 == Long.MAX_VALUE) goto L9;
        long r11 = 1 + r10;
        if (compareAndSet(r10, r11) == false) goto L10;
        this.task.get().dispose();
        this.downstream.onNext(r5);
        startTimeout(r11);
        return;
    L10:
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
        this.downstream.onError(new TimeoutException(io.reactivex.internal.util.d.c(this.timeout, this.unit)));
        this.worker.dispose();
        return;
    }

    @Override // zu.d
    public void request(long r5) {
        SubscriptionHelper.deferredRequest(this.upstream, this.requested, r5);
    }

    public void startTimeout(long r5) {
        this.task.replace(this.worker.b(new com.bytedance.ies.bullet.ui.common.e(r5, this), this.timeout, this.unit));
    }
}
