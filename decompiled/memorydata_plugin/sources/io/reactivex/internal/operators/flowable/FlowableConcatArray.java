package io.reactivex.internal.operators.flowable;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.g;
import io.reactivex.internal.subscriptions.SubscriptionArbiter;
import io.reactivex.j;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes6.dex */
public final class FlowableConcatArray<T> extends g<T> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final org.a.b<? extends T>[] f16765b;
    final boolean c;

    static final class ConcatArraySubscriber<T> extends SubscriptionArbiter implements j<T> {
        private static final long serialVersionUID = -8158322871608889516L;
        final boolean delayError;
        final org.a.c<? super T> downstream;
        List<Throwable> errors;
        int index;
        long produced;
        final org.a.b<? extends T>[] sources;
        final AtomicInteger wip;

        ConcatArraySubscriber(org.a.b<? extends T>[] r3, boolean r4, org.a.c<? super T> r5) {
            org.a.c<? super T> r6 = (org.a.c) ZeusTransformUtils.wrapperContextForParams(r5, org.a.c.class, "com.obric.memorydata.plugin");
            super(false);
            this.downstream = r6;
            this.sources = r3;
            this.delayError = r4;
            this.wip = new AtomicInteger();
        }

        @Override // org.a.c
        public void onComplete() {
            if (this.wip.getAndIncrement() != 0) goto L30;
            org.a.b<? extends T>[] r0 = this.sources;
            int r1 = r0.length;
            int r2 = this.index;
        L6:
            if (r2 == r1) goto L7;
            org.a.b<? extends T> r4 = r0[r2];
            if (r4 == null) goto L17;
            long r5 = this.produced;
            if (r5 == 0) goto L28;
            this.produced = 0;
            produced(r5);
        L28:
            r4.subscribe(this);
            r2 = r2 + 1;
            this.index = r2;
            if (this.wip.decrementAndGet() != 0) goto L6;
            return;
        L17:
            NullPointerException r6 = new NullPointerException("A Publisher entry is null");
            if (this.delayError == false) goto L23;
            List r7 = this.errors;
            if (r7 != null) goto L22;
            r7 = new ArrayList((r1 - r2) + 1);
            this.errors = r7;
        L22:
            r7.add(r6);
            r2 = r2 + 1;
            goto L6
        L23:
            this.downstream.onError(r6);
            return;
        L7:
            List<Throwable> r3 = this.errors;
            if (r3 == null) goto L13;
            int r8 = r3.size();
            org.a.c<? super T> r9 = this.downstream;
            if (r8 != 1) goto L12;
            r9.onError((Throwable) ZeusTransformUtils.preCheckCast(r3.get(0), Throwable.class, "com.obric.memorydata.plugin"));
            return;
        L12:
            r9.onError(new CompositeException(r3));
            return;
        L13:
            this.downstream.onComplete();
            return;
        }

        @Override // org.a.c
        public void onError(Throwable r4) {
            if (this.delayError == false) goto L8;
            List r0 = this.errors;
            if (r0 != null) goto L7;
            r0 = new ArrayList((this.sources.length - this.index) + 1);
            this.errors = r0;
        L7:
            r0.add(r4);
            onComplete();
            return;
        L8:
            this.downstream.onError(r4);
        }

        @Override // org.a.c
        public void onNext(T r5) {
            this.produced++;
            this.downstream.onNext(r5);
        }

        @Override // io.reactivex.j, org.a.c
        public void onSubscribe(org.a.d r3) {
            setSubscription((org.a.d) ZeusTransformUtils.wrapperContextForParams(r3, org.a.d.class, "com.obric.memorydata.plugin"));
        }
    }

    @Override // io.reactivex.g
    public void a(org.a.c<? super T> r3) {
        org.a.c r4 = (org.a.c) ZeusTransformUtils.wrapperContextForParams(r3, org.a.c.class, "com.obric.memorydata.plugin");
        ConcatArraySubscriber r0 = new ConcatArraySubscriber(this.f16765b, this.c, r4);
        r4.onSubscribe(r0);
        r0.onComplete();
    }
}
