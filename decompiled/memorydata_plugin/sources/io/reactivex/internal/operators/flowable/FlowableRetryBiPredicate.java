package io.reactivex.internal.operators.flowable;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.internal.subscriptions.SubscriptionArbiter;
import io.reactivex.j;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes6.dex */
public final class FlowableRetryBiPredicate<T> extends a<T, T> {
    final io.reactivex.b.d<? super Integer, ? super Throwable> c;

    static final class RetryBiSubscriber<T> extends AtomicInteger implements j<T> {
        private static final long serialVersionUID = -7098360935104053232L;
        final org.a.c<? super T> downstream;
        final io.reactivex.b.d<? super Integer, ? super Throwable> predicate;
        long produced;
        int retries;
        final SubscriptionArbiter sa;
        final org.a.b<? extends T> source;

        RetryBiSubscriber(org.a.c<? super T> r3, io.reactivex.b.d<? super Integer, ? super Throwable> r4, SubscriptionArbiter r5, org.a.b<? extends T> r6) {
            org.a.c<? super T> r7 = (org.a.c) ZeusTransformUtils.wrapperContextForParams(r3, org.a.c.class, "com.obric.memorydata.plugin");
            io.reactivex.b.d<? super Integer, ? super Throwable> r8 = (io.reactivex.b.d) ZeusTransformUtils.wrapperContextForParams(r4, io.reactivex.b.d.class, "com.obric.memorydata.plugin");
            org.a.b<? extends T> r9 = (org.a.b) ZeusTransformUtils.wrapperContextForParams(r6, org.a.b.class, "com.obric.memorydata.plugin");
            this.downstream = r7;
            this.sa = r5;
            this.source = r9;
            this.predicate = r8;
        }

        @Override // org.a.c
        public void onComplete() {
            this.downstream.onComplete();
        }

        @Override // org.a.c
        public void onError(Throwable r6) {
            io.reactivex.b.d<? super Integer, ? super Throwable> r1 = this.predicate;     // Catch: Throwable -> L9
            int r2 = this.retries + 1;     // Catch: Throwable -> L9
            this.retries = r2;     // Catch: Throwable -> L9
            if (r1.a(Integer.valueOf(r2), r6) == true) goto L7;
            this.downstream.onError(r6);
            return;
        L7:
            subscribeNext();
            return;
        L9:
            th = move-exception;
            io.reactivex.exceptions.a.a(th);
            this.downstream.onError(new CompositeException(new Throwable[]{r6, th}));
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
    public void a(org.a.c<? super T> r4) {
        org.a.c r5 = (org.a.c) ZeusTransformUtils.wrapperContextForParams(r4, org.a.c.class, "com.obric.memorydata.plugin");
        SubscriptionArbiter r0 = new SubscriptionArbiter(false);
        r5.onSubscribe(r0);
        new RetryBiSubscriber(r5, this.c, r0, this.f16812b).subscribeNext();
    }
}
