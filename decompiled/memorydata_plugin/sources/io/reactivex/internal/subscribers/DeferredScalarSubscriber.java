package io.reactivex.internal.subscribers;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import io.reactivex.internal.subscriptions.DeferredScalarSubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.j;
import org.a.d;

/* JADX INFO: loaded from: classes6.dex */
public abstract class DeferredScalarSubscriber<T, R> extends DeferredScalarSubscription<R> implements j<T> {
    private static final long serialVersionUID = 2984505488220891551L;
    protected boolean hasValue;
    protected d upstream;

    public DeferredScalarSubscriber(org.a.c<? super R> r3) {
        super((org.a.c) ZeusTransformUtils.wrapperContextForParams(r3, org.a.c.class, "com.obric.memorydata.plugin"));
    }

    @Override // io.reactivex.internal.subscriptions.DeferredScalarSubscription, org.a.d
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

    public void onError(Throwable r2) {
        this.value = null;
        this.downstream.onError(r2);
    }

    public void onSubscribe(d r3) {
        d r4 = (d) ZeusTransformUtils.wrapperContextForParams(r3, d.class, "com.obric.memorydata.plugin");
        if (SubscriptionHelper.validate(this.upstream, r4) == false) goto L6;
        this.upstream = r4;
        this.downstream.onSubscribe(this);
        r4.request(Long.MAX_VALUE);
        return;
    }
}
