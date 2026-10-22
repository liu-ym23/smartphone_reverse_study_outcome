package io.reactivex.internal.operators.flowable;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import io.reactivex.b.j;
import io.reactivex.internal.subscriptions.DeferredScalarSubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;

/* JADX INFO: loaded from: classes6.dex */
public final class FlowableAll<T> extends a<T, Boolean> {
    final j<? super T> c;

    static final class AllSubscriber<T> extends DeferredScalarSubscription<Boolean> implements io.reactivex.j<T> {
        private static final long serialVersionUID = -3521127104134758517L;
        boolean done;
        final j<? super T> predicate;
        org.a.d upstream;

        AllSubscriber(org.a.c<? super Boolean> r3, j<? super T> r4) {
            org.a.c r5 = (org.a.c) ZeusTransformUtils.wrapperContextForParams(r3, org.a.c.class, "com.obric.memorydata.plugin");
            j<? super T> r6 = (j) ZeusTransformUtils.wrapperContextForParams(r4, j.class, "com.obric.memorydata.plugin");
            super(r5);
            this.predicate = r6;
        }

        @Override // io.reactivex.internal.subscriptions.DeferredScalarSubscription, org.a.d
        public void cancel() {
            super.cancel();
            this.upstream.cancel();
        }

        @Override // org.a.c
        public void onComplete() {
            if (this.done == false) goto L5;
            return;
        L5:
            this.done = true;
            complete(true);
        }

        @Override // org.a.c
        public void onError(Throwable r2) {
            if (this.done == false) goto L6;
            io.reactivex.d.a.a(r2);
            return;
        L6:
            this.done = true;
            this.downstream.onError(r2);
        }

        @Override // org.a.c
        public void onNext(T r2) {
            if (this.done == false) goto L12;
            return;
        L12:
            if (this.predicate.test(r2) == true) goto L14;
            this.done = true;
            this.upstream.cancel();
            complete(false);
            return;
        L14:
            return;
        L9:
            th = move-exception;
            io.reactivex.exceptions.a.a(th);
            this.upstream.cancel();
            onError(th);
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
    public void a(org.a.c<? super Boolean> r3) {
        org.a.c r4 = (org.a.c) ZeusTransformUtils.wrapperContextForParams(r3, org.a.c.class, "com.obric.memorydata.plugin");
        this.f16812b.a(new AllSubscriber(r4, this.c));
    }
}
