package io.reactivex.internal.operators.flowable;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import io.reactivex.internal.subscriptions.DeferredScalarSubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.j;
import java.util.NoSuchElementException;

/* JADX INFO: loaded from: classes6.dex */
public final class FlowableElementAt<T> extends a<T, T> {
    final long c;
    final T d;
    final boolean e;

    static final class ElementAtSubscriber<T> extends DeferredScalarSubscription<T> implements j<T> {
        private static final long serialVersionUID = 4066607327284737757L;
        long count;
        final T defaultValue;
        boolean done;
        final boolean errorOnFewer;
        final long index;
        org.a.d upstream;

        ElementAtSubscriber(org.a.c<? super T> r3, long r4, T r6, boolean r7) {
            super((org.a.c) ZeusTransformUtils.wrapperContextForParams(r3, org.a.c.class, "com.obric.memorydata.plugin"));
            this.index = r4;
            this.defaultValue = r6;
            this.errorOnFewer = r7;
        }

        @Override // io.reactivex.internal.subscriptions.DeferredScalarSubscription, org.a.d
        public void cancel() {
            super.cancel();
            this.upstream.cancel();
        }

        @Override // org.a.c
        public void onComplete() {
            if (this.done == true) goto L12;
            this.done = true;
            T r0 = this.defaultValue;
            if (r0 != null) goto L10;
            boolean r1 = this.errorOnFewer;
            org.a.c<? super T> r2 = this.downstream;
            if (r1 == false) goto L9;
            r2.onError(new NoSuchElementException());
            return;
        L9:
            r2.onComplete();
            return;
        L10:
            complete(r0);
            return;
        }

        @Override // org.a.c
        public void onError(Throwable r2) {
            if (this.done == false) goto L6;
            io.reactivex.d.a.a(r2);
            return;
        L6:
            this.done = true;
            this.downstream.onError(r2);
        }

        @Override // org.a.c
        public void onNext(T r5) {
            if (this.done == false) goto L5;
            return;
        L5:
            long r0 = this.count;
            if (r0 != this.index) goto L9;
            this.done = true;
            this.upstream.cancel();
            complete(r5);
            return;
        L9:
            this.count = r0 + 1;
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
    }

    @Override // io.reactivex.g
    public void a(org.a.c<? super T> r8) {
        org.a.c r1 = (org.a.c) ZeusTransformUtils.wrapperContextForParams(r8, org.a.c.class, "com.obric.memorydata.plugin");
        this.f16812b.a(new ElementAtSubscriber(r1, this.c, this.d, this.e));
    }
}
