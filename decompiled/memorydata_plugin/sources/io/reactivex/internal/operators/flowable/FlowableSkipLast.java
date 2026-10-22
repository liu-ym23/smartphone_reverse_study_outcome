package io.reactivex.internal.operators.flowable;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.j;
import java.util.ArrayDeque;

/* JADX INFO: loaded from: classes6.dex */
public final class FlowableSkipLast<T> extends a<T, T> {
    final int c;

    static final class SkipLastSubscriber<T> extends ArrayDeque<T> implements j<T>, org.a.d {
        private static final long serialVersionUID = -3807491841935125653L;
        final org.a.c<? super T> downstream;
        final int skip;
        org.a.d upstream;

        SkipLastSubscriber(org.a.c<? super T> r3, int r4) {
            org.a.c<? super T> r5 = (org.a.c) ZeusTransformUtils.wrapperContextForParams(r3, org.a.c.class, "com.obric.memorydata.plugin");
            super(r4);
            this.downstream = r5;
            this.skip = r4;
        }

        @Override // org.a.d
        public void cancel() {
            this.upstream.cancel();
        }

        @Override // org.a.c
        public void onComplete() {
            this.downstream.onComplete();
        }

        @Override // org.a.c
        public void onError(Throwable r1) {
            this.downstream.onError(r1);
        }

        @Override // org.a.c
        public void onNext(T r4) {
            if (this.skip != size()) goto L5;
            this.downstream.onNext(poll());
        L6:
            offer(r4);
            return;
        L5:
            this.upstream.request(1);
            goto L6
        }

        @Override // io.reactivex.j, org.a.c
        public void onSubscribe(org.a.d r3) {
            org.a.d r4 = (org.a.d) ZeusTransformUtils.wrapperContextForParams(r3, org.a.d.class, "com.obric.memorydata.plugin");
            if (SubscriptionHelper.validate(this.upstream, r4) == false) goto L6;
            this.upstream = r4;
            this.downstream.onSubscribe(this);
            return;
        }

        @Override // org.a.d
        public void request(long r1) {
            this.upstream.request(r1);
        }
    }

    @Override // io.reactivex.g
    public void a(org.a.c<? super T> r3) {
        org.a.c r4 = (org.a.c) ZeusTransformUtils.wrapperContextForParams(r3, org.a.c.class, "com.obric.memorydata.plugin");
        this.f16812b.a(new SkipLastSubscriber(r4, this.c));
    }
}
