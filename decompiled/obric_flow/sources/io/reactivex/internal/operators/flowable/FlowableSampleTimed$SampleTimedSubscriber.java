package io.reactivex.internal.operators.flowable;

import com.lynx.tasm.behavior.v0;
import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.SequentialDisposable;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes3.dex */
abstract class FlowableSampleTimed$SampleTimedSubscriber<T> extends AtomicReference<T> implements mt.g, zu.d, Runnable {
    private static final long serialVersionUID = -3517602651313910099L;
    final zu.c downstream;
    final long period;
    final AtomicLong requested;
    final mt.z scheduler;
    final SequentialDisposable timer;
    final TimeUnit unit;
    zu.d upstream;

    public FlowableSampleTimed$SampleTimedSubscriber(zu.c r5, long r10, TimeUnit r11, mt.z r12) {
        this.requested = new AtomicLong();
        this.timer = new SequentialDisposable();
        this.downstream = r5;
        this.period = r10;
        this.unit = r11;
        this.scheduler = r12;
    }

    @Override // zu.d
    public void cancel() {
        cancelTimer();
        this.upstream.cancel();
    }

    public void cancelTimer() {
        DisposableHelper.dispose(this.timer);
    }

    public abstract void complete();

    public void emit() {
        T r5 = getAndSet(null);
        if (r5 != null) goto L5;
        return;
    L5:
        if (this.requested.get() == 0) goto L7;
        this.downstream.onNext(r5);
        v0.y(this.requested, 1);
        return;
    L7:
        cancel();
        this.downstream.onError(new MissingBackpressureException("Couldn't emit value due to lack of requests!"));
    }

    @Override // zu.c
    public void onComplete() {
        cancelTimer();
        complete();
    }

    @Override // zu.c
    public void onError(Throwable r5) {
        cancelTimer();
        this.downstream.onError(r5);
    }

    @Override // zu.c
    public void onNext(T r5) {
        lazySet(r5);
    }

    @Override // zu.c
    public void onSubscribe(zu.d r10) {
        if (SubscriptionHelper.validate(this.upstream, r10) == false) goto L6;
        this.upstream = r10;
        this.downstream.onSubscribe(this);
        SequentialDisposable r5 = this.timer;
        mt.z r11 = this.scheduler;
        long r12 = this.period;
        r5.replace(r11.e(this, r12, r12, this.unit));
        r10.request(Long.MAX_VALUE);
        return;
    }

    @Override // zu.d
    public void request(long r5) {
        if (SubscriptionHelper.validate(r5) == false) goto L6;
        v0.r(this.requested, r5);
        return;
    }
}
