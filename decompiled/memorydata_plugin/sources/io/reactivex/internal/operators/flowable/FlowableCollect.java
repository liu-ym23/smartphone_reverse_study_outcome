package io.reactivex.internal.operators.flowable;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import io.reactivex.internal.subscriptions.DeferredScalarSubscription;
import io.reactivex.internal.subscriptions.EmptySubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.j;
import java.util.concurrent.Callable;

/* JADX INFO: loaded from: classes6.dex */
public final class FlowableCollect<T, U> extends a<T, U> {
    final Callable<? extends U> c;
    final io.reactivex.b.b<? super U, ? super T> d;

    static final class CollectSubscriber<T, U> extends DeferredScalarSubscription<U> implements j<T> {
        private static final long serialVersionUID = -3589550218733891694L;
        final io.reactivex.b.b<? super U, ? super T> collector;
        boolean done;
        final U u;
        org.a.d upstream;

        CollectSubscriber(org.a.c<? super U> r3, U r4, io.reactivex.b.b<? super U, ? super T> r5) {
            org.a.c r6 = (org.a.c) ZeusTransformUtils.wrapperContextForParams(r3, org.a.c.class, "com.obric.memorydata.plugin");
            io.reactivex.b.b<? super U, ? super T> r7 = (io.reactivex.b.b) ZeusTransformUtils.wrapperContextForParams(r5, io.reactivex.b.b.class, "com.obric.memorydata.plugin");
            super(r6);
            this.collector = r7;
            this.u = r4;
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
            complete(this.u);
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
        public void onNext(T r3) {
            if (this.done == false) goto L10;
            return;
        L10:
            this.collector.a(this.u, r3);     // Catch: Throwable -> L7
            return;
        L7:
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
    public void a(org.a.c<? super U> r4) {
        org.a.c r5 = (org.a.c) ZeusTransformUtils.wrapperContextForParams(r4, org.a.c.class, "com.obric.memorydata.plugin");
        Object r0 = io.reactivex.internal.functions.a.a(this.c.call(), "The initial value supplied is null");     // Catch: Throwable -> L6
        this.f16812b.a(new CollectSubscriber(r5, r0, this.d));
        return;
    L6:
        th = move-exception;
        EmptySubscription.error(th, r5);
    }
}
