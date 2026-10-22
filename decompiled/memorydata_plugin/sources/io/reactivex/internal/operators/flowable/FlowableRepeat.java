package io.reactivex.internal.operators.flowable;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import io.reactivex.internal.subscriptions.SubscriptionArbiter;
import io.reactivex.j;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes6.dex */
public final class FlowableRepeat<T> extends a<T, T> {
    final long c;

    static final class RepeatSubscriber<T> extends AtomicInteger implements j<T> {
        private static final long serialVersionUID = -7098360935104053232L;
        final org.a.c<? super T> downstream;
        long produced;
        long remaining;
        final SubscriptionArbiter sa;
        final org.a.b<? extends T> source;

        RepeatSubscriber(org.a.c<? super T> r3, long r4, SubscriptionArbiter r6, org.a.b<? extends T> r7) {
            org.a.c<? super T> r5 = (org.a.c) ZeusTransformUtils.wrapperContextForParams(r3, org.a.c.class, "com.obric.memorydata.plugin");
            org.a.b<? extends T> r8 = (org.a.b) ZeusTransformUtils.wrapperContextForParams(r7, org.a.b.class, "com.obric.memorydata.plugin");
            this.downstream = r5;
            this.sa = r6;
            this.source = r8;
            this.remaining = r4;
        }

        @Override // org.a.c
        public void onComplete() {
            long r0 = this.remaining;
            if (r0 == Long.MAX_VALUE) goto L6;
            this.remaining = r0 - 1;
        L6:
            if (r0 == 0) goto L8;
            subscribeNext();
            return;
        L8:
            this.downstream.onComplete();
        }

        @Override // org.a.c
        public void onError(Throwable r1) {
            this.downstream.onError(r1);
        }

        @Override // org.a.c
        public void onNext(T r5) {
            this.produced++;
            this.downstream.onNext(r5);
        }

        @Override // io.reactivex.j, org.a.c
        public void onSubscribe(org.a.d r3) {
            org.a.d r4 = (org.a.d) ZeusTransformUtils.wrapperContextForParams(r3, org.a.d.class, "com.obric.memorydata.plugin");
            this.sa.setSubscription(r4);
        }

        void subscribeNext() {
            if (getAndIncrement() != 0) goto L13;
            int r0 = 1;
        L6:
            if (this.sa.isCancelled() == true) goto L7;
            long r1 = this.produced;
            if (r1 == 0) goto L11;
            this.produced = 0;
            this.sa.produced(r1);
        L11:
            this.source.subscribe(this);
            r0 = addAndGet(-r0);
            if (r0 != 0) goto L6;
            return;
        L7:
            return;
        }
    }

    @Override // io.reactivex.g
    public void a(org.a.c<? super T> r8) {
        org.a.c r1 = (org.a.c) ZeusTransformUtils.wrapperContextForParams(r8, org.a.c.class, "com.obric.memorydata.plugin");
        SubscriptionArbiter r4 = new SubscriptionArbiter(false);
        r1.onSubscribe(r4);
        long r2 = this.c;
        if (r2 == Long.MAX_VALUE) goto L5;
        long r3 = r2 - 1;
    L6:
        new RepeatSubscriber(r1, r3, r4, this.f16812b).subscribeNext();
        return;
    L5:
        r3 = Long.MAX_VALUE;
        goto L6
    }
}
