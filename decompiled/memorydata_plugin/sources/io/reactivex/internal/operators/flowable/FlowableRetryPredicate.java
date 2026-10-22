package io.reactivex.internal.operators.flowable;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import io.reactivex.b.j;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.internal.subscriptions.SubscriptionArbiter;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes6.dex */
public final class FlowableRetryPredicate<T> extends a<T, T> {
    final j<? super Throwable> c;
    final long d;

    static final class RetrySubscriber<T> extends AtomicInteger implements io.reactivex.j<T> {
        private static final long serialVersionUID = -7098360935104053232L;
        final org.a.c<? super T> downstream;
        final j<? super Throwable> predicate;
        long produced;
        long remaining;
        final SubscriptionArbiter sa;
        final org.a.b<? extends T> source;

        RetrySubscriber(org.a.c<? super T> r3, long r4, j<? super Throwable> r6, SubscriptionArbiter r7, org.a.b<? extends T> r8) {
            org.a.c<? super T> r5 = (org.a.c) ZeusTransformUtils.wrapperContextForParams(r3, org.a.c.class, "com.obric.memorydata.plugin");
            j<? super Throwable> r9 = (j) ZeusTransformUtils.wrapperContextForParams(r6, j.class, "com.obric.memorydata.plugin");
            org.a.b<? extends T> r10 = (org.a.b) ZeusTransformUtils.wrapperContextForParams(r8, org.a.b.class, "com.obric.memorydata.plugin");
            this.downstream = r5;
            this.sa = r7;
            this.source = r10;
            this.predicate = r9;
            this.remaining = r4;
        }

        @Override // org.a.c
        public void onComplete() {
            this.downstream.onComplete();
        }

        @Override // org.a.c
        public void onError(Throwable r5) {
            long r0 = this.remaining;
            if (r0 == Long.MAX_VALUE) goto L6;
            this.remaining = r0 - 1;
        L6:
            if (r0 != 0) goto L17;
            this.downstream.onError(r5);
            return;
        L17:
            if (this.predicate.test(r5) == true) goto L12;
            this.downstream.onError(r5);
            return;
        L12:
            subscribeNext();
            return;
        L14:
            th = move-exception;
            io.reactivex.exceptions.a.a(th);
            this.downstream.onError(new CompositeException(new Throwable[]{r5, th}));
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
        SubscriptionArbiter r5 = new SubscriptionArbiter(false);
        r1.onSubscribe(r5);
        new RetrySubscriber(r1, this.d, this.c, r5, this.f16812b).subscribeNext();
    }
}
