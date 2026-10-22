package io.reactivex.internal.subscribers;

import io.reactivex.internal.subscriptions.DeferredScalarSubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import mt.g;
import zu.c;
import zu.d;

/* JADX INFO: loaded from: classes3.dex */
public abstract class DeferredScalarSubscriber<T, R> extends DeferredScalarSubscription<R> implements g {
    private static final long serialVersionUID = 2984505488220891551L;
    protected boolean hasValue;
    protected d upstream;

    public DeferredScalarSubscriber(c r5) {
        super(r5);
    }

    @Override // io.reactivex.internal.subscriptions.DeferredScalarSubscription, io.reactivex.internal.subscriptions.BasicIntQueueSubscription, zu.d
    public void cancel() {
        super.cancel();
        this.upstream.cancel();
    }

    public void onComplete() {
        if (this.hasValue == false) goto L5;
        complete(this.value);
        return;
    L5:
        this.downstream.onComplete();
    }

    public void onError(Throwable r5) {
        this.value = null;
        this.downstream.onError(r5);
    }

    public abstract /* synthetic */ void onNext(Object r5);

    public void onSubscribe(d r5) {
        if (SubscriptionHelper.validate(this.upstream, r5) == false) goto L6;
        this.upstream = r5;
        this.downstream.onSubscribe(this);
        r5.request(Long.MAX_VALUE);
        return;
    }
}
