package io.reactivex.internal.operators.flowable;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import io.reactivex.internal.subscriptions.DeferredScalarSubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.j;

/* JADX INFO: loaded from: classes6.dex */
public final class FlowableReduce<T> extends a<T, T> {
    final io.reactivex.b.c<T, T, T> c;

    static final class ReduceSubscriber<T> extends DeferredScalarSubscription<T> implements j<T> {
        private static final long serialVersionUID = -4663883003264602070L;
        final io.reactivex.b.c<T, T, T> reducer;
        org.a.d upstream;

        ReduceSubscriber(org.a.c<? super T> r3, io.reactivex.b.c<T, T, T> r4) {
            org.a.c r5 = (org.a.c) ZeusTransformUtils.wrapperContextForParams(r3, org.a.c.class, "com.obric.memorydata.plugin");
            io.reactivex.b.c<T, T, T> r6 = (io.reactivex.b.c) ZeusTransformUtils.wrapperContextForParams(r4, io.reactivex.b.c.class, "com.obric.memorydata.plugin");
            super(r5);
            this.reducer = r6;
        }

        @Override // io.reactivex.internal.subscriptions.DeferredScalarSubscription, org.a.d
        public void cancel() {
            super.cancel();
            this.upstream.cancel();
            this.upstream = SubscriptionHelper.CANCELLED;
        }

        @Override // org.a.c
        public void onComplete() {
            if (this.upstream != SubscriptionHelper.CANCELLED) goto L5;
            return;
        L5:
            this.upstream = SubscriptionHelper.CANCELLED;
            T r0 = this.value;
            if (r0 == null) goto L8;
            complete(r0);
            return;
        L8:
            this.downstream.onComplete();
        }

        @Override // org.a.c
        public void onError(Throwable r3) {
            if (this.upstream != SubscriptionHelper.CANCELLED) goto L6;
            io.reactivex.d.a.a(r3);
            return;
        L6:
            this.upstream = SubscriptionHelper.CANCELLED;
            this.downstream.onError(r3);
        }

        @Override // org.a.c
        public void onNext(T r3) {
            if (this.upstream != SubscriptionHelper.CANCELLED) goto L5;
            return;
        L5:
            T r0 = this.value;
            if (r0 != null) goto L13;
            this.value = r3;
            return;
        L13:
            this.value = (T) io.reactivex.internal.functions.a.a(this.reducer.apply(r0, r3), "The reducer returned a null value");     // Catch: Throwable -> L10
            return;
        L10:
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
    public void a(org.a.c<? super T> r3) {
        org.a.c r4 = (org.a.c) ZeusTransformUtils.wrapperContextForParams(r3, org.a.c.class, "com.obric.memorydata.plugin");
        this.f16812b.a(new ReduceSubscriber(r4, this.c));
    }
}
