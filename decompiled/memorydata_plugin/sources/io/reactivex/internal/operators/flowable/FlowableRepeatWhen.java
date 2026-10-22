package io.reactivex.internal.operators.flowable;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import io.reactivex.b.h;
import io.reactivex.g;
import io.reactivex.internal.subscriptions.EmptySubscription;
import io.reactivex.internal.subscriptions.SubscriptionArbiter;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.j;
import io.reactivex.processors.UnicastProcessor;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes6.dex */
public final class FlowableRepeatWhen<T> extends a<T, T> {
    final h<? super g<Object>, ? extends org.a.b<?>> c;

    static final class RepeatWhenSubscriber<T> extends WhenSourceSubscriber<T, Object> {
        private static final long serialVersionUID = -2680129890138081029L;

        RepeatWhenSubscriber(org.a.c<? super T> r3, io.reactivex.processors.a<Object> r4, org.a.d r5) {
            super((org.a.c) ZeusTransformUtils.wrapperContextForParams(r3, org.a.c.class, "com.obric.memorydata.plugin"), r4, (org.a.d) ZeusTransformUtils.wrapperContextForParams(r5, org.a.d.class, "com.obric.memorydata.plugin"));
        }

        @Override // org.a.c
        public void onComplete() {
            again(0);
        }

        @Override // org.a.c
        public void onError(Throwable r2) {
            this.receiver.cancel();
            this.downstream.onError(r2);
        }
    }

    static final class WhenReceiver<T, U> extends AtomicInteger implements j<Object>, org.a.d {
        private static final long serialVersionUID = 2827772011130406689L;
        final AtomicLong requested;
        final org.a.b<T> source;
        WhenSourceSubscriber<T, U> subscriber;
        final AtomicReference<org.a.d> upstream;

        WhenReceiver(org.a.b<T> r3) {
            this.source = (org.a.b) ZeusTransformUtils.wrapperContextForParams(r3, org.a.b.class, "com.obric.memorydata.plugin");
            this.upstream = new AtomicReference();
            this.requested = new AtomicLong();
        }

        @Override // org.a.d
        public void cancel() {
            SubscriptionHelper.cancel(this.upstream);
        }

        @Override // org.a.c
        public void onComplete() {
            this.subscriber.cancel();
            this.subscriber.downstream.onComplete();
        }

        @Override // org.a.c
        public void onError(Throwable r2) {
            this.subscriber.cancel();
            this.subscriber.downstream.onError(r2);
        }

        @Override // org.a.c
        public void onNext(Object r2) {
            if (getAndIncrement() == 0) goto L5;
            return;
        L5:
            if (this.upstream.get() == SubscriptionHelper.CANCELLED) goto L6;
            this.source.subscribe(this.subscriber);
            if (decrementAndGet() != 0) goto L5;
            return;
        }

        @Override // io.reactivex.j, org.a.c
        public void onSubscribe(org.a.d r3) {
            org.a.d r4 = (org.a.d) ZeusTransformUtils.wrapperContextForParams(r3, org.a.d.class, "com.obric.memorydata.plugin");
            SubscriptionHelper.deferredSetOnce(this.upstream, this.requested, r4);
        }

        @Override // org.a.d
        public void request(long r2) {
            SubscriptionHelper.deferredRequest(this.upstream, this.requested, r2);
        }
    }

    static abstract class WhenSourceSubscriber<T, U> extends SubscriptionArbiter implements j<T> {
        private static final long serialVersionUID = -5604623027276966720L;
        protected final org.a.c<? super T> downstream;
        protected final io.reactivex.processors.a<U> processor;
        private long produced;
        protected final org.a.d receiver;

        WhenSourceSubscriber(org.a.c<? super T> r3, io.reactivex.processors.a<U> r4, org.a.d r5) {
            org.a.c<? super T> r6 = (org.a.c) ZeusTransformUtils.wrapperContextForParams(r3, org.a.c.class, "com.obric.memorydata.plugin");
            org.a.d r7 = (org.a.d) ZeusTransformUtils.wrapperContextForParams(r5, org.a.d.class, "com.obric.memorydata.plugin");
            super(false);
            this.downstream = r6;
            this.processor = r4;
            this.receiver = r7;
        }

        public final void again(U r6) {
            setSubscription(EmptySubscription.INSTANCE);
            long r0 = this.produced;
            if (r0 == 0) goto L5;
            this.produced = 0;
            produced(r0);
        L5:
            this.receiver.request(1);
            this.processor.onNext(r6);
        }

        @Override // io.reactivex.internal.subscriptions.SubscriptionArbiter, org.a.d
        public final void cancel() {
            super.cancel();
            this.receiver.cancel();
        }

        @Override // org.a.c
        public final void onNext(T r5) {
            this.produced++;
            this.downstream.onNext(r5);
        }

        @Override // io.reactivex.j, org.a.c
        public final void onSubscribe(org.a.d r3) {
            setSubscription((org.a.d) ZeusTransformUtils.wrapperContextForParams(r3, org.a.d.class, "com.obric.memorydata.plugin"));
        }
    }

    @Override // io.reactivex.g
    public void a(org.a.c<? super T> r6) {
        org.a.c r7 = (org.a.c) ZeusTransformUtils.wrapperContextForParams(r6, org.a.c.class, "com.obric.memorydata.plugin");
        io.reactivex.subscribers.b r0 = new io.reactivex.subscribers.b(r7);
        io.reactivex.processors.a<T> r2 = UnicastProcessor.a(8).b();
        org.a.b r1 = (org.a.b) ZeusTransformUtils.preCheckCast(io.reactivex.internal.functions.a.a(this.c.apply(r2), "handler returned a null Publisher"), org.a.b.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L6
        WhenReceiver r3 = new WhenReceiver(this.f16812b);
        RepeatWhenSubscriber r5 = new RepeatWhenSubscriber(r0, r2, r3);
        r3.subscriber = r5;
        r7.onSubscribe(r5);
        r1.subscribe(r3);
        r3.onNext(0);
        return;
    L6:
        th = move-exception;
        io.reactivex.exceptions.a.a(th);
        EmptySubscription.error(th, r7);
    }
}
