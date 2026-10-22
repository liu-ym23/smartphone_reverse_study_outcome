package io.reactivex.internal.operators.flowable;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import io.reactivex.internal.subscriptions.EmptySubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.j;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: loaded from: classes6.dex */
public final class FlowableLimit<T> extends a<T, T> {
    final long c;

    static final class LimitSubscriber<T> extends AtomicLong implements j<T>, org.a.d {
        private static final long serialVersionUID = 2288246011222124525L;
        final org.a.c<? super T> downstream;
        long remaining;
        org.a.d upstream;

        LimitSubscriber(org.a.c<? super T> r3, long r4) {
            this.downstream = (org.a.c) ZeusTransformUtils.wrapperContextForParams(r3, org.a.c.class, "com.obric.memorydata.plugin");
            this.remaining = r4;
            lazySet(r4);
        }

        @Override // org.a.d
        public void cancel() {
            this.upstream.cancel();
        }

        @Override // org.a.c
        public void onComplete() {
            if (this.remaining <= 0) goto L6;
            this.remaining = 0;
            this.downstream.onComplete();
            return;
        }

        @Override // org.a.c
        public void onError(Throwable r5) {
            if (this.remaining <= 0) goto L5;
            this.remaining = 0;
            this.downstream.onError(r5);
            return;
        L5:
            io.reactivex.d.a.a(r5);
        }

        @Override // org.a.c
        public void onNext(T r7) {
            long r0 = this.remaining;
            if (r0 <= 0) goto L8;
            long r1 = r0 - 1;
            this.remaining = r1;
            this.downstream.onNext(r7);
            if (r1 != 0) goto L9;
            this.upstream.cancel();
            this.downstream.onComplete();
            return;
        L9:
            return;
        }

        @Override // io.reactivex.j, org.a.c
        public void onSubscribe(org.a.d r5) {
            org.a.d r6 = (org.a.d) ZeusTransformUtils.wrapperContextForParams(r5, org.a.d.class, "com.obric.memorydata.plugin");
            if (SubscriptionHelper.validate(this.upstream, r6) == true) goto L5;
            return;
        L5:
            if (this.remaining != 0) goto L7;
            r6.cancel();
            EmptySubscription.complete(this.downstream);
            return;
        L7:
            this.upstream = r6;
            this.downstream.onSubscribe(this);
        }

        @Override // org.a.d
        public void request(long r7) {
            if (SubscriptionHelper.validate(r7) == false) goto L18;
        L4:
            long r0 = get();
            if (r0 == 0) goto L19;
            if (r0 > r7) goto L10;
            long r2 = r0;
        L12:
            if (compareAndSet(r0, r0 - r2) == false) goto L4;
            this.upstream.request(r2);
            return;
        L10:
            r2 = r7;
            goto L12
        L19:
            return;
        }
    }

    @Override // io.reactivex.g
    public void a(org.a.c<? super T> r5) {
        org.a.c r6 = (org.a.c) ZeusTransformUtils.wrapperContextForParams(r5, org.a.c.class, "com.obric.memorydata.plugin");
        this.f16812b.a(new LimitSubscriber(r6, this.c));
    }
}
