package io.reactivex.internal.operators.flowable;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.j;
import java.util.ArrayDeque;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: loaded from: classes6.dex */
public final class FlowableTakeLast<T> extends a<T, T> {
    final int c;

    static final class TakeLastSubscriber<T> extends ArrayDeque<T> implements j<T>, org.a.d {
        private static final long serialVersionUID = 7240042530241604978L;
        volatile boolean cancelled;
        final int count;
        volatile boolean done;
        final org.a.c<? super T> downstream;
        final AtomicLong requested;
        org.a.d upstream;
        final AtomicInteger wip;

        TakeLastSubscriber(org.a.c<? super T> r3, int r4) {
            org.a.c<? super T> r5 = (org.a.c) ZeusTransformUtils.wrapperContextForParams(r3, org.a.c.class, "com.obric.memorydata.plugin");
            this.requested = new AtomicLong();
            this.wip = new AtomicInteger();
            this.downstream = r5;
            this.count = r4;
        }

        @Override // org.a.d
        public void cancel() {
            this.cancelled = true;
            this.upstream.cancel();
        }

        void drain() {
            if (this.wip.getAndIncrement() != 0) goto L28;
            org.a.c<? super T> r0 = this.downstream;
            long r1 = this.requested.get();
        L6:
            if (this.cancelled == true) goto L7;
            if (this.done == false) goto L27;
            long r5 = 0;
        L12:
            if (r5 == r1) goto L22;
            if (this.cancelled == true) goto L15;
            T r7 = poll();
            if (r7 == null) goto L18;
            r0.onNext(r7);
            r5 = r5 + 1;
            goto L12
        L18:
            r0.onComplete();
            return;
        L15:
            return;
        L22:
            if (r5 == 0) goto L27;
            if (r1 == Long.MAX_VALUE) goto L27;
            r1 = this.requested.addAndGet(-r5);
        L27:
            if (this.wip.decrementAndGet() != 0) goto L6;
            return;
        L7:
            return;
        }

        @Override // org.a.c
        public void onComplete() {
            this.done = true;
            drain();
        }

        @Override // org.a.c
        public void onError(Throwable r1) {
            this.downstream.onError(r1);
        }

        @Override // org.a.c
        public void onNext(T r3) {
            if (this.count != size()) goto L5;
            poll();
        L5:
            offer(r3);
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

        @Override // org.a.d
        public void request(long r2) {
            if (SubscriptionHelper.validate(r2) == false) goto L6;
            io.reactivex.internal.util.b.a(this.requested, r2);
            drain();
            return;
        }
    }

    @Override // io.reactivex.g
    public void a(org.a.c<? super T> r3) {
        org.a.c r4 = (org.a.c) ZeusTransformUtils.wrapperContextForParams(r3, org.a.c.class, "com.obric.memorydata.plugin");
        this.f16812b.a(new TakeLastSubscriber(r4, this.c));
    }
}
