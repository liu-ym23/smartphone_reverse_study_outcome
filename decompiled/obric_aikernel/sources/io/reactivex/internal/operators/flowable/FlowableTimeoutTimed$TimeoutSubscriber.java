package io.reactivex.internal.operators.flowable;

import io.reactivex.internal.disposables.SequentialDisposable;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.ExceptionHelper;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes2.dex */
final class FlowableTimeoutTimed$TimeoutSubscriber<T> extends AtomicLong implements xb.g<T>, tc.d, n {
    private static final long serialVersionUID = 3764492702657003550L;
    final tc.c<? super T> downstream;
    final AtomicLong requested;
    final SequentialDisposable task;
    final long timeout;
    final TimeUnit unit;
    final AtomicReference<tc.d> upstream;
    final xb.p.c worker;

    FlowableTimeoutTimed$TimeoutSubscriber(tc.c<? super T> r10, long r11, TimeUnit r12, xb.p.c r13) {
        this.downstream = r10;
        this.timeout = r11;
        this.unit = r12;
        this.worker = r13;
        this.task = new SequentialDisposable();
        this.upstream = new AtomicReference();
        this.requested = new AtomicLong();
    }

    @Override // tc.d
    public void cancel() {
        SubscriptionHelper.cancel(this.upstream);
        this.worker.dispose();
    }

    @Override // tc.c
    public void onComplete() {
        if (getAndSet(Long.MAX_VALUE) == Long.MAX_VALUE) goto L6;
        this.task.dispose();
        this.downstream.onComplete();
        this.worker.dispose();
        return;
    }

    @Override // tc.c
    public void onError(Throwable r10) {
        if (getAndSet(Long.MAX_VALUE) == Long.MAX_VALUE) goto L5;
        this.task.dispose();
        this.downstream.onError(r10);
        this.worker.dispose();
        return;
    L5:
        dc.a.n(r10);
    }

    @Override // tc.c
    public void onNext(T r10) {
        long r11 = get();
        if (r11 == Long.MAX_VALUE) goto L9;
        long r12 = 1 + r11;
        if (compareAndSet(r11, r12) == false) goto L10;
        this.task.get().dispose();
        this.downstream.onNext(r10);
        startTimeout(r12);
        return;
    L10:
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
        this.downstream.onError(new TimeoutException(ExceptionHelper.c(this.timeout, this.unit)));
        this.worker.dispose();
        return;
    }

    @Override // tc.d
    public void request(long r10) {
        SubscriptionHelper.deferredRequest(this.upstream, this.requested, r10);
    }

    void startTimeout(long r10) {
        this.task.replace(this.worker.c(new o(r10, this), this.timeout, this.unit));
    }
}
