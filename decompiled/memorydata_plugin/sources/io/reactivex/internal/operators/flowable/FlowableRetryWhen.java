package io.reactivex.internal.operators.flowable;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import io.reactivex.b.h;
import io.reactivex.g;
import io.reactivex.internal.subscriptions.EmptySubscription;
import io.reactivex.processors.UnicastProcessor;

/* JADX INFO: loaded from: classes6.dex */
public final class FlowableRetryWhen<T> extends a<T, T> {
    final h<? super g<Throwable>, ? extends org.a.b<?>> c;

    static final class RetryWhenSubscriber<T> extends FlowableRepeatWhen.WhenSourceSubscriber<T, Throwable> {
        private static final long serialVersionUID = -2680129890138081029L;

        RetryWhenSubscriber(org.a.c<? super T> r3, io.reactivex.processors.a<Throwable> r4, org.a.d r5) {
            super((org.a.c) ZeusTransformUtils.wrapperContextForParams(r3, org.a.c.class, "com.obric.memorydata.plugin"), r4, (org.a.d) ZeusTransformUtils.wrapperContextForParams(r5, org.a.d.class, "com.obric.memorydata.plugin"));
        }

        @Override // org.a.c
        public void onComplete() {
            this.receiver.cancel();
            this.downstream.onComplete();
        }

        @Override // org.a.c
        public void onError(Throwable r1) {
            again(r1);
        }
    }

    @Override // io.reactivex.g
    public void a(org.a.c<? super T> r6) {
        org.a.c r7 = (org.a.c) ZeusTransformUtils.wrapperContextForParams(r6, org.a.c.class, "com.obric.memorydata.plugin");
        io.reactivex.subscribers.b r0 = new io.reactivex.subscribers.b(r7);
        io.reactivex.processors.a<T> r2 = UnicastProcessor.a(8).b();
        org.a.b r1 = (org.a.b) ZeusTransformUtils.preCheckCast(io.reactivex.internal.functions.a.a(this.c.apply(r2), "handler returned a null Publisher"), org.a.b.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L6
        FlowableRepeatWhen.WhenReceiver r3 = new FlowableRepeatWhen.WhenReceiver(this.f16812b);
        RetryWhenSubscriber r5 = new RetryWhenSubscriber(r0, r2, r3);
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
