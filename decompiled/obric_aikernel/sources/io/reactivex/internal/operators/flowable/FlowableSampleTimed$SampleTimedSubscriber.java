package io.reactivex.internal.operators.flowable;

import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.SequentialDisposable;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes2.dex */
abstract class FlowableSampleTimed$SampleTimedSubscriber<T> extends AtomicReference<T> implements xb.g<T>, tc.d, Runnable {
    private static final long serialVersionUID = -3517602651313910099L;
    final tc.c<? super T> downstream;
    final long period;
    final AtomicLong requested;
    final xb.p scheduler;
    final SequentialDisposable timer;
    final TimeUnit unit;
    tc.d upstream;

    FlowableSampleTimed$SampleTimedSubscriber(tc.c<? super T> r10, long r11, TimeUnit r12, xb.p r13) {
        this.requested = new AtomicLong();
        this.timer = new SequentialDisposable();
        this.downstream = r10;
        this.period = r11;
        this.unit = r12;
        this.scheduler = r13;
    }

    @Override // tc.d
    public void cancel() {
        cancelTimer();
        this.upstream.cancel();
    }

    void cancelTimer() {
        DisposableHelper.dispose(this.timer);
    }

    abstract void complete();

    void emit() {
        T r10 = getAndSet(null);
        if (r10 != null) goto L5;
        return;
    L5:
        if (this.requested.get() == 0) goto L7;
        this.downstream.onNext(r10);
        io.reactivex.internal.util.b.e(this.requested, 1);
        return;
    L7:
        cancel();
        this.downstream.onError(new MissingBackpressureException("Couldn't emit value due to lack of requests!"));
    }

    @Override // tc.c
    public void onComplete() {
        cancelTimer();
        complete();
    }

    @Override // tc.c
    public void onError(Throwable r10) {
        cancelTimer();
        this.downstream.onError(r10);
    }

    @Override // tc.c
    public void onNext(T r10) {
        lazySet(r10);
    }

    @Override // xb.g, tc.c
    public void onSubscribe(tc.d r10) {
        if (SubscriptionHelper.validate(this.upstream, r10) == false) goto L6;
        this.upstream = r10;
        this.downstream.onSubscribe(this);
        SequentialDisposable r11 = this.timer;
        xb.p r12 = this.scheduler;
        long r13 = this.period;
        r11.replace(r12.e(this, r13, r13, this.unit));
        r10.request(Long.MAX_VALUE);
        return;
    }

    @Override // tc.d
    public void request(long r10) {
        if (SubscriptionHelper.validate(r10) == false) goto L6;
        io.reactivex.internal.util.b.a(this.requested, r10);
        return;
    }
}
