package io.reactivex.internal.operators.flowable;

import com.lynx.tasm.behavior.v0;
import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: loaded from: classes3.dex */
final class FlowableOnBackpressureError$BackpressureErrorSubscriber<T> extends AtomicLong implements mt.g, zu.d {
    private static final long serialVersionUID = -3176480756392482682L;
    boolean done;
    final zu.c downstream;
    zu.d upstream;

    public FlowableOnBackpressureError$BackpressureErrorSubscriber(zu.c r5) {
        this.downstream = r5;
    }

    @Override // zu.d
    public void cancel() {
        this.upstream.cancel();
    }

    @Override // zu.c
    public void onComplete() {
        if (this.done == false) goto L5;
        return;
    L5:
        this.done = true;
        this.downstream.onComplete();
    }

    @Override // zu.c
    public void onError(Throwable r5) {
        if (this.done == false) goto L6;
        wn.f.k(r5);
        return;
    L6:
        this.done = true;
        this.downstream.onError(r5);
    }

    @Override // zu.c
    public void onNext(T r5) {
        if (this.done == false) goto L6;
        return;
    L6:
        if (get() == 0) goto L8;
        this.downstream.onNext(r5);
        v0.y(this, 1);
        return;
    L8:
        onError(new MissingBackpressureException("could not emit value due to lack of requests"));
    }

    @Override // zu.c
    public void onSubscribe(zu.d r5) {
        if (SubscriptionHelper.validate(this.upstream, r5) == false) goto L6;
        this.upstream = r5;
        this.downstream.onSubscribe(this);
        r5.request(Long.MAX_VALUE);
        return;
    }

    @Override // zu.d
    public void request(long r5) {
        if (SubscriptionHelper.validate(r5) == false) goto L6;
        v0.r(this, r5);
        return;
    }
}
