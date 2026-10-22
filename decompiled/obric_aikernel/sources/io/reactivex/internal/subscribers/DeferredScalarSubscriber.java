package io.reactivex.internal.subscribers;

import io.reactivex.internal.subscriptions.DeferredScalarSubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import tc.c;
import tc.d;
import xb.g;

/* JADX INFO: loaded from: classes2.dex */
public abstract class DeferredScalarSubscriber<T, R> extends DeferredScalarSubscription<R> implements g<T> {
    private static final long serialVersionUID = 2984505488220891551L;
    protected boolean hasValue;
    protected d upstream;

    public DeferredScalarSubscriber(c<? super R> r10) {
        super(r10);
    }

    @Override // io.reactivex.internal.subscriptions.DeferredScalarSubscription, io.reactivex.internal.subscriptions.BasicIntQueueSubscription, tc.d
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

    public void onError(Throwable r10) {
        this.value = null;
        this.downstream.onError(r10);
    }

    public abstract /* synthetic */ void onNext(T r10);

    public void onSubscribe(d r10) {
        if (SubscriptionHelper.validate(this.upstream, r10) == false) goto L6;
        this.upstream = r10;
        this.downstream.onSubscribe(this);
        r10.request(Long.MAX_VALUE);
        return;
    }
}
