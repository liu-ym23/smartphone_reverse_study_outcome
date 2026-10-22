package io.reactivex.internal.operators.flowable;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import io.reactivex.internal.subscriptions.DeferredScalarSubscription;
import io.reactivex.internal.subscriptions.EmptySubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.j;
import java.util.Collection;
import java.util.concurrent.Callable;

/* JADX INFO: loaded from: classes6.dex */
public final class FlowableToList<T, U extends Collection<? super T>> extends a<T, U> {
    final Callable<U> c;

    static final class ToListSubscriber<T, U extends Collection<? super T>> extends DeferredScalarSubscription<U> implements j<T>, org.a.d {
        private static final long serialVersionUID = -8134157938864266736L;
        org.a.d upstream;

        ToListSubscriber(org.a.c<? super U> r3, U r4) {
            org.a.c r5 = (org.a.c) ZeusTransformUtils.wrapperContextForParams(r3, org.a.c.class, "com.obric.memorydata.plugin");
            T r6 = (T) ((Collection) ZeusTransformUtils.wrapperContextForParams(r4, Collection.class, "com.obric.memorydata.plugin"));
            super(r5);
            this.value = r6;
        }

        @Override // io.reactivex.internal.subscriptions.DeferredScalarSubscription, org.a.d
        public void cancel() {
            super.cancel();
            this.upstream.cancel();
        }

        @Override // org.a.c
        public void onComplete() {
            complete(this.value);
        }

        @Override // org.a.c
        public void onError(Throwable r2) {
            this.value = null;
            this.downstream.onError(r2);
        }

        @Override // org.a.c
        public void onNext(T r3) {
            Collection r2 = (Collection) ZeusTransformUtils.preCheckCast(this.value, Collection.class, "com.obric.memorydata.plugin");
            if (r2 == null) goto L6;
            r2.add(r3);
            return;
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
        Collection r0 = (Collection) ZeusTransformUtils.preCheckCast(io.reactivex.internal.functions.a.a(this.c.call(), "The collectionSupplier returned a null collection. Null values are generally not allowed in 2.x operators and sources."), Collection.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L6
        this.f16812b.a(new ToListSubscriber(r5, r0));
        return;
    L6:
        th = move-exception;
        io.reactivex.exceptions.a.a(th);
        EmptySubscription.error(th, r5);
    }
}
