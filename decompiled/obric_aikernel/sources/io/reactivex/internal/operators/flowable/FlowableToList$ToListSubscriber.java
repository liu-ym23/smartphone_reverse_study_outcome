package io.reactivex.internal.operators.flowable;

import io.reactivex.internal.subscriptions.DeferredScalarSubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.Collection;

/* JADX INFO: loaded from: classes2.dex */
final class FlowableToList$ToListSubscriber<T, U extends Collection<? super T>> extends DeferredScalarSubscription<U> implements xb.g<T>, tc.d {
    private static final long serialVersionUID = -8134157938864266736L;
    tc.d upstream;

    /* JADX WARN: Multi-variable type inference failed */
    FlowableToList$ToListSubscriber(tc.c<? super U> r10, U r11) {
        super(r10);
        this.value = r11;
    }

    @Override // io.reactivex.internal.subscriptions.DeferredScalarSubscription, io.reactivex.internal.subscriptions.BasicIntQueueSubscription, tc.d
    public void cancel() {
        super.cancel();
        this.upstream.cancel();
    }

    @Override // tc.c
    public void onComplete() {
        complete(this.value);
    }

    @Override // tc.c
    public void onError(Throwable r10) {
        this.value = null;
        this.downstream.onError(r10);
    }

    @Override // tc.c
    public void onNext(T r10) {
        Collection r11 = (Collection) this.value;
        if (r11 == null) goto L6;
        r11.add(r10);
        return;
    }

    @Override // xb.g, tc.c
    public void onSubscribe(tc.d r10) {
        if (SubscriptionHelper.validate(this.upstream, r10) == false) goto L6;
        this.upstream = r10;
        this.downstream.onSubscribe(this);
        r10.request(Long.MAX_VALUE);
        return;
    }
}
