package io.reactivex.internal.operators.flowable;

import io.reactivex.internal.subscriptions.DeferredScalarSubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.Collection;

/* JADX INFO: loaded from: classes3.dex */
final class FlowableToList$ToListSubscriber<T, U extends Collection<? super T>> extends DeferredScalarSubscription<U> implements mt.g, zu.d {
    private static final long serialVersionUID = -8134157938864266736L;
    zu.d upstream;

    /* JADX WARN: Multi-variable type inference failed */
    public FlowableToList$ToListSubscriber(zu.c r5, U r10) {
        super(r5);
        this.value = r10;
    }

    @Override // io.reactivex.internal.subscriptions.DeferredScalarSubscription, io.reactivex.internal.subscriptions.BasicIntQueueSubscription, zu.d
    public void cancel() {
        super.cancel();
        this.upstream.cancel();
    }

    @Override // zu.c
    public void onComplete() {
        complete(this.value);
    }

    @Override // zu.c
    public void onError(Throwable r5) {
        this.value = null;
        this.downstream.onError(r5);
    }

    @Override // zu.c
    public void onNext(T r5) {
        Collection r10 = (Collection) this.value;
        if (r10 == null) goto L6;
        r10.add(r5);
        return;
    }

    @Override // zu.c
    public void onSubscribe(zu.d r5) {
        if (SubscriptionHelper.validate(this.upstream, r5) == false) goto L6;
        this.upstream = r5;
        this.downstream.onSubscribe(this);
        r5.request(Long.MAX_VALUE);
        return;
    }
}
