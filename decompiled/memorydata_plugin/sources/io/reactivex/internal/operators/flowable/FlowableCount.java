package io.reactivex.internal.operators.flowable;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import io.reactivex.internal.subscriptions.DeferredScalarSubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.j;

/* JADX INFO: loaded from: classes6.dex */
public final class FlowableCount<T> extends a<T, Long> {

    static final class CountSubscriber extends DeferredScalarSubscription<Long> implements j<Object> {
        private static final long serialVersionUID = 4973004223787171406L;
        long count;
        org.a.d upstream;

        CountSubscriber(org.a.c<? super Long> r3) {
            super((org.a.c) ZeusTransformUtils.wrapperContextForParams(r3, org.a.c.class, "com.obric.memorydata.plugin"));
        }

        @Override // io.reactivex.internal.subscriptions.DeferredScalarSubscription, org.a.d
        public void cancel() {
            super.cancel();
            this.upstream.cancel();
        }

        @Override // org.a.c
        public void onComplete() {
            complete(Long.valueOf(this.count));
        }

        @Override // org.a.c
        public void onError(Throwable r1) {
            this.downstream.onError(r1);
        }

        @Override // org.a.c
        public void onNext(Object r5) {
            this.count++;
        }

        @Override // io.reactivex.j, org.a.c
        public void onSubscribe(org.a.d r3) {
            org.a.d r4 = (org.a.d) ZeusTransformUtils.wrapperContextForParams(r3, org.a.d.class, "com.obric.memorydata.plugin");
            if (SubscriptionHelper.validate(this.upstream, r4) == false) goto L6;
            this.upstream = r4;
            this.downstream.onSubscribe(this);
            r4.request(Long.MAX_VALUE);
            return;
        }
    }

    @Override // io.reactivex.g
    public void a(org.a.c<? super Long> r3) {
        org.a.c r4 = (org.a.c) ZeusTransformUtils.wrapperContextForParams(r3, org.a.c.class, "com.obric.memorydata.plugin");
        this.f16812b.a(new CountSubscriber(r4));
    }
}
