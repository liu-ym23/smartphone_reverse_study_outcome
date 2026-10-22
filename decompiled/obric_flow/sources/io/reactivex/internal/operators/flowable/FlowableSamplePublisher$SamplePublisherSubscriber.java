package io.reactivex.internal.operators.flowable;

import com.lynx.tasm.behavior.v0;
import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes3.dex */
abstract class FlowableSamplePublisher$SamplePublisherSubscriber<T> extends AtomicReference<T> implements mt.g, zu.d {
    private static final long serialVersionUID = -3517602651313910099L;
    final zu.c downstream;
    final AtomicReference<zu.d> other;
    final AtomicLong requested;
    final zu.b sampler;
    zu.d upstream;

    public FlowableSamplePublisher$SamplePublisherSubscriber(zu.c r5, zu.b r10) {
        this.requested = new AtomicLong();
        this.other = new AtomicReference();
        this.downstream = r5;
        this.sampler = r10;
    }

    @Override // zu.d
    public void cancel() {
        SubscriptionHelper.cancel(this.other);
        this.upstream.cancel();
    }

    public void complete() {
        this.upstream.cancel();
        completion();
    }

    public abstract void completion();

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

    public void error(Throwable r5) {
        this.upstream.cancel();
        this.downstream.onError(r5);
    }

    @Override // zu.c
    public void onComplete() {
        SubscriptionHelper.cancel(this.other);
        completion();
    }

    @Override // zu.c
    public void onError(Throwable r5) {
        SubscriptionHelper.cancel(this.other);
        this.downstream.onError(r5);
    }

    @Override // zu.c
    public void onNext(T r5) {
        lazySet(r5);
    }

    @Override // zu.c
    public void onSubscribe(zu.d r5) {
        if (SubscriptionHelper.validate(this.upstream, r5) == false) goto L8;
        this.upstream = r5;
        this.downstream.onSubscribe(this);
        if (this.other.get() != null) goto L9;
        this.sampler.subscribe(new s(this));
        r5.request(Long.MAX_VALUE);
        return;
    L9:
        return;
    }

    @Override // zu.d
    public void request(long r5) {
        if (SubscriptionHelper.validate(r5) == false) goto L6;
        v0.r(this.requested, r5);
        return;
    }

    public abstract void run();

    public void setOther(zu.d r5) {
        SubscriptionHelper.setOnce(this.other, r5, Long.MAX_VALUE);
    }
}
