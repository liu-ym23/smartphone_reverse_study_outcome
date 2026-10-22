package io.reactivex.internal.operators.flowable;

import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes2.dex */
abstract class FlowableSamplePublisher$SamplePublisherSubscriber<T> extends AtomicReference<T> implements xb.g<T>, tc.d {
    private static final long serialVersionUID = -3517602651313910099L;
    final tc.c<? super T> downstream;
    final AtomicReference<tc.d> other;
    final AtomicLong requested;
    final tc.b<?> sampler;
    tc.d upstream;

    FlowableSamplePublisher$SamplePublisherSubscriber(tc.c<? super T> r10, tc.b<?> r11) {
        this.requested = new AtomicLong();
        this.other = new AtomicReference();
        this.downstream = r10;
        this.sampler = r11;
    }

    @Override // tc.d
    public void cancel() {
        SubscriptionHelper.cancel(this.other);
        this.upstream.cancel();
    }

    public void complete() {
        this.upstream.cancel();
        completeOther();
    }

    abstract void completeMain();

    abstract void completeOther();

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

    public void error(Throwable r10) {
        this.upstream.cancel();
        this.downstream.onError(r10);
    }

    @Override // tc.c
    public void onComplete() {
        SubscriptionHelper.cancel(this.other);
        completeMain();
    }

    @Override // tc.c
    public void onError(Throwable r10) {
        SubscriptionHelper.cancel(this.other);
        this.downstream.onError(r10);
    }

    @Override // tc.c
    public void onNext(T r10) {
        lazySet(r10);
    }

    @Override // xb.g, tc.c
    public void onSubscribe(tc.d r10) {
        if (SubscriptionHelper.validate(this.upstream, r10) == false) goto L8;
        this.upstream = r10;
        this.downstream.onSubscribe(this);
        if (this.other.get() != null) goto L9;
        this.sampler.subscribe(new j(this));
        r10.request(Long.MAX_VALUE);
        return;
    L9:
        return;
    }

    @Override // tc.d
    public void request(long r10) {
        if (SubscriptionHelper.validate(r10) == false) goto L6;
        io.reactivex.internal.util.b.a(this.requested, r10);
        return;
    }

    abstract void run();

    void setOther(tc.d r10) {
        SubscriptionHelper.setOnce(this.other, r10, Long.MAX_VALUE);
    }
}
