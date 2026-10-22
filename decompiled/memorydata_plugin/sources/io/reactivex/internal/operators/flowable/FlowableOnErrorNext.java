package io.reactivex.internal.operators.flowable;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import io.reactivex.b.h;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.internal.subscriptions.SubscriptionArbiter;
import io.reactivex.j;

/* JADX INFO: loaded from: classes6.dex */
public final class FlowableOnErrorNext<T> extends a<T, T> {
    final h<? super Throwable, ? extends org.a.b<? extends T>> c;
    final boolean d;

    static final class OnErrorNextSubscriber<T> extends SubscriptionArbiter implements j<T> {
        private static final long serialVersionUID = 4063763155303814625L;
        final boolean allowFatal;
        boolean done;
        final org.a.c<? super T> downstream;
        final h<? super Throwable, ? extends org.a.b<? extends T>> nextSupplier;
        boolean once;
        long produced;

        OnErrorNextSubscriber(org.a.c<? super T> r3, h<? super Throwable, ? extends org.a.b<? extends T>> r4, boolean r5) {
            org.a.c<? super T> r6 = (org.a.c) ZeusTransformUtils.wrapperContextForParams(r3, org.a.c.class, "com.obric.memorydata.plugin");
            h<? super Throwable, ? extends org.a.b<? extends T>> r7 = (h) ZeusTransformUtils.wrapperContextForParams(r4, h.class, "com.obric.memorydata.plugin");
            super(false);
            this.downstream = r6;
            this.nextSupplier = r7;
            this.allowFatal = r5;
        }

        @Override // org.a.c
        public void onComplete() {
            if (this.done == false) goto L5;
            return;
        L5:
            this.done = true;
            this.once = true;
            this.downstream.onComplete();
        }

        @Override // org.a.c
        public void onError(Throwable r7) {
            if (this.once == true) goto L5;
            this.once = true;
            if (this.allowFatal == true) goto L13;
        L25:
            org.a.b r1 = (org.a.b) ZeusTransformUtils.preCheckCast(io.reactivex.internal.functions.a.a(this.nextSupplier.apply(r7), "The nextSupplier returned a null Publisher"), org.a.b.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L22
            long r2 = this.produced;
            if (r2 == 0) goto L20;
            produced(r2);
        L20:
            r1.subscribe(this);
            return;
        L22:
            th = move-exception;
            io.reactivex.exceptions.a.a(th);
            this.downstream.onError(new CompositeException(new Throwable[]{r7, th}));
            return;
        L13:
            if (ZeusTransformUtils.instanceOf(r7, Exception.class) == true) goto L25;
            this.downstream.onError(r7);
            return;
        L5:
            if (this.done == false) goto L8;
            io.reactivex.d.a.a(r7);
            return;
        L8:
            this.downstream.onError(r7);
        }

        @Override // org.a.c
        public void onNext(T r5) {
            if (this.done == false) goto L6;
            return;
        L6:
            if (this.once == true) goto L8;
            this.produced++;
        L8:
            this.downstream.onNext(r5);
        }

        @Override // io.reactivex.j, org.a.c
        public void onSubscribe(org.a.d r3) {
            setSubscription((org.a.d) ZeusTransformUtils.wrapperContextForParams(r3, org.a.d.class, "com.obric.memorydata.plugin"));
        }
    }

    @Override // io.reactivex.g
    public void a(org.a.c<? super T> r4) {
        org.a.c r5 = (org.a.c) ZeusTransformUtils.wrapperContextForParams(r4, org.a.c.class, "com.obric.memorydata.plugin");
        OnErrorNextSubscriber r0 = new OnErrorNextSubscriber(r5, this.c, this.d);
        r5.onSubscribe(r0);
        this.f16812b.a(r0);
    }
}
