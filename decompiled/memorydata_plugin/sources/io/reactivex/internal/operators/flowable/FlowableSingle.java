package io.reactivex.internal.operators.flowable;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import io.reactivex.internal.subscriptions.DeferredScalarSubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.j;
import java.util.NoSuchElementException;

/* JADX INFO: loaded from: classes6.dex */
public final class FlowableSingle<T> extends a<T, T> {
    final T c;
    final boolean d;

    static final class SingleElementSubscriber<T> extends DeferredScalarSubscription<T> implements j<T> {
        private static final long serialVersionUID = -5526049321428043809L;
        final T defaultValue;
        boolean done;
        final boolean failOnEmpty;
        org.a.d upstream;

        SingleElementSubscriber(org.a.c<? super T> r3, T r4, boolean r5) {
            super((org.a.c) ZeusTransformUtils.wrapperContextForParams(r3, org.a.c.class, "com.obric.memorydata.plugin"));
            this.defaultValue = r4;
            this.failOnEmpty = r5;
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
            T r0 = this.value;
            this.value = null;
            if (r0 != null) goto L8;
            r0 = this.defaultValue;
        L8:
            if (r0 != null) goto L13;
            boolean r1 = this.failOnEmpty;
            org.a.c<? super T> r2 = this.downstream;
            if (r1 == false) goto L12;
            r2.onError(new NoSuchElementException());
            return;
        L12:
            r2.onComplete();
            return;
        L13:
            complete(r0);
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
            if (this.done == false) goto L6;
            return;
        L6:
            if (this.value == null) goto L9;
            this.done = true;
            this.upstream.cancel();
            this.downstream.onError(new IllegalArgumentException("Sequence contains more than one element!"));
            return;
        L9:
            this.value = r2;
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
    public void a(org.a.c<? super T> r4) {
        org.a.c r5 = (org.a.c) ZeusTransformUtils.wrapperContextForParams(r4, org.a.c.class, "com.obric.memorydata.plugin");
        this.f16812b.a(new SingleElementSubscriber(r5, this.c, this.d));
    }
}
