package io.reactivex.internal.operators.flowable;

import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes3.dex */
final class FlowableUnsubscribeOn$UnsubscribeSubscriber<T> extends AtomicBoolean implements mt.g, zu.d {
    private static final long serialVersionUID = 1015244841293359600L;
    final zu.c downstream;
    final mt.z scheduler;
    zu.d upstream;

    public FlowableUnsubscribeOn$UnsubscribeSubscriber(zu.c r5, mt.z r10) {
        this.downstream = r5;
        this.scheduler = r10;
    }

    @Override // zu.d
    public void cancel() {
        if (compareAndSet(false, true) == false) goto L6;
        this.scheduler.c(new x(this));
        return;
    }

    @Override // zu.c
    public void onComplete() {
        if (get() == true) goto L6;
        this.downstream.onComplete();
        return;
    }

    @Override // zu.c
    public void onError(Throwable r5) {
        if (get() == false) goto L6;
        wn.f.k(r5);
        return;
    L6:
        this.downstream.onError(r5);
    }

    @Override // zu.c
    public void onNext(T r5) {
        if (get() == true) goto L6;
        this.downstream.onNext(r5);
        return;
    }

    @Override // zu.c
    public void onSubscribe(zu.d r5) {
        if (SubscriptionHelper.validate(this.upstream, r5) == false) goto L6;
        this.upstream = r5;
        this.downstream.onSubscribe(this);
        return;
    }

    @Override // zu.d
    public void request(long r5) {
        this.upstream.request(r5);
    }
}
