package io.reactivex.internal.operators.flowable;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import io.reactivex.internal.subscriptions.EmptySubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.j;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes6.dex */
public final class FlowableTake<T> extends a<T, T> {
    final long c;

    static final class TakeSubscriber<T> extends AtomicBoolean implements j<T>, org.a.d {
        private static final long serialVersionUID = -5636543848937116287L;
        boolean done;
        final org.a.c<? super T> downstream;
        final long limit;
        long remaining;
        org.a.d upstream;

        TakeSubscriber(org.a.c<? super T> r3, long r4) {
            this.downstream = (org.a.c) ZeusTransformUtils.wrapperContextForParams(r3, org.a.c.class, "com.obric.memorydata.plugin");
            this.limit = r4;
            this.remaining = r4;
        }

        @Override // org.a.d
        public void cancel() {
            this.upstream.cancel();
        }

        @Override // org.a.c
        public void onComplete() {
            if (this.done == true) goto L6;
            this.done = true;
            this.downstream.onComplete();
            return;
        }

        @Override // org.a.c
        public void onError(Throwable r2) {
            if (this.done == true) goto L5;
            this.done = true;
            this.upstream.cancel();
            this.downstream.onError(r2);
            return;
        L5:
            io.reactivex.d.a.a(r2);
        }

        @Override // org.a.c
        public void onNext(T r7) {
            if (this.done == true) goto L14;
            long r0 = this.remaining;
            long r2 = r0 - 1;
            this.remaining = r2;
            if (r0 > 0) goto L7;
            return;
        L7:
            if (r2 != 0) goto L9;
            boolean r1 = true;
        L10:
            this.downstream.onNext(r7);
            if (r1 == false) goto L16;
            this.upstream.cancel();
            onComplete();
            return;
        L16:
            return;
        L9:
            r1 = false;
            goto L10
        }

        @Override // io.reactivex.j, org.a.c
        public void onSubscribe(org.a.d r5) {
            org.a.d r6 = (org.a.d) ZeusTransformUtils.wrapperContextForParams(r5, org.a.d.class, "com.obric.memorydata.plugin");
            if (SubscriptionHelper.validate(this.upstream, r6) == false) goto L9;
            this.upstream = r6;
            if (this.limit != 0) goto L7;
            r6.cancel();
            this.done = true;
            EmptySubscription.complete(this.downstream);
            return;
        L7:
            this.downstream.onSubscribe(this);
            return;
        }

        @Override // org.a.d
        public void request(long r3) {
            if (SubscriptionHelper.validate(r3) == true) goto L6;
            return;
        L6:
            if (get() == false) goto L8;
        L14:
            org.a.d r2 = this.upstream;
        L12:
            r2.request(r3);
            return;
        L8:
            if (compareAndSet(false, true) == false) goto L14;
            if (r3 < this.limit) goto L14;
            r2 = this.upstream;
            r3 = Long.MAX_VALUE;
            goto L12
        }
    }

    @Override // io.reactivex.g
    public void a(org.a.c<? super T> r5) {
        org.a.c r6 = (org.a.c) ZeusTransformUtils.wrapperContextForParams(r5, org.a.c.class, "com.obric.memorydata.plugin");
        this.f16812b.a(new TakeSubscriber(r6, this.c));
    }
}
