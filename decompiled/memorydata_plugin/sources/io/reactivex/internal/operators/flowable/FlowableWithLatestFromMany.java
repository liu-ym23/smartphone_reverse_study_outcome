package io.reactivex.internal.operators.flowable;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import io.reactivex.b.h;
import io.reactivex.internal.subscriptions.EmptySubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.internal.util.e;
import io.reactivex.j;
import java.util.Arrays;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.atomic.AtomicReferenceArray;

/* JADX INFO: loaded from: classes6.dex */
public final class FlowableWithLatestFromMany<T, R> extends io.reactivex.internal.operators.flowable.a<T, R> {
    final org.a.b<?>[] c;
    final Iterable<? extends org.a.b<?>> d;
    final h<? super Object[], R> e;

    static final class WithLatestFromSubscriber<T, R> extends AtomicInteger implements io.reactivex.internal.a.a<T>, org.a.d {
        private static final long serialVersionUID = 1577321883966341961L;
        final h<? super Object[], R> combiner;
        volatile boolean done;
        final org.a.c<? super R> downstream;
        final AtomicThrowable error;
        final AtomicLong requested;
        final WithLatestInnerSubscriber[] subscribers;
        final AtomicReference<org.a.d> upstream;
        final AtomicReferenceArray<Object> values;

        WithLatestFromSubscriber(org.a.c<? super R> r3, h<? super Object[], R> r4, int r5) {
            org.a.c<? super R> r6 = (org.a.c) ZeusTransformUtils.wrapperContextForParams(r3, org.a.c.class, "com.obric.memorydata.plugin");
            h<? super Object[], R> r7 = (h) ZeusTransformUtils.wrapperContextForParams(r4, h.class, "com.obric.memorydata.plugin");
            this.downstream = r6;
            this.combiner = r7;
            WithLatestInnerSubscriber[] r8 = new WithLatestInnerSubscriber[r5];
            int r9 = 0;
        L3:
            if (r9 >= r5) goto L5;
            r8[r9] = new WithLatestInnerSubscriber(this, r9);
            r9 = r9 + 1;
            goto L3
        L5:
            this.subscribers = r8;
            this.values = new AtomicReferenceArray(r5);
            this.upstream = new AtomicReference();
            this.requested = new AtomicLong();
            this.error = new AtomicThrowable();
        }

        @Override // org.a.d
        public void cancel() {
            SubscriptionHelper.cancel(this.upstream);
            WithLatestInnerSubscriber[] r3 = this.subscribers;
            int r0 = r3.length;
            int r1 = 0;
        L3:
            if (r1 >= r0) goto L5;
            r3[r1].dispose();
            r1 = r1 + 1;
            goto L3
        }

        void cancelAllBut(int r3) {
            WithLatestInnerSubscriber[] r2 = this.subscribers;
            int r0 = 0;
        L4:
            if (r0 >= r2.length) goto L8;
            if (r0 == r3) goto L7;
            r2[r0].dispose();
        L7:
            r0 = r0 + 1;
            goto L4
        }

        void innerComplete(int r1, boolean r2) {
            if (r2 == true) goto L5;
            this.done = true;
            SubscriptionHelper.cancel(this.upstream);
            cancelAllBut(r1);
            e.a(this.downstream, this, this.error);
            return;
        }

        void innerError(int r2, Throwable r3) {
            this.done = true;
            SubscriptionHelper.cancel(this.upstream);
            cancelAllBut(r2);
            e.a(this.downstream, r3, this, this.error);
        }

        void innerNext(int r1, Object r2) {
            this.values.set(r1, r2);
        }

        @Override // org.a.c
        public void onComplete() {
            if (this.done == true) goto L6;
            this.done = true;
            cancelAllBut(-1);
            e.a(this.downstream, this, this.error);
            return;
        }

        @Override // org.a.c
        public void onError(Throwable r3) {
            if (this.done == false) goto L6;
            io.reactivex.d.a.a(r3);
            return;
        L6:
            this.done = true;
            cancelAllBut(-1);
            e.a(this.downstream, r3, this, this.error);
        }

        @Override // org.a.c
        public void onNext(T r3) {
            if (tryOnNext(r3) == false) goto L5;
            return;
        L5:
            if (this.done == true) goto L9;
            ((org.a.d) ZeusTransformUtils.preCheckCast(this.upstream.get(), org.a.d.class, "com.obric.memorydata.plugin")).request(1);
            return;
        }

        @Override // io.reactivex.j, org.a.c
        public void onSubscribe(org.a.d r3) {
            org.a.d r4 = (org.a.d) ZeusTransformUtils.wrapperContextForParams(r3, org.a.d.class, "com.obric.memorydata.plugin");
            SubscriptionHelper.deferredSetOnce(this.upstream, this.requested, r4);
        }

        @Override // org.a.d
        public void request(long r2) {
            SubscriptionHelper.deferredRequest(this.upstream, this.requested, r2);
        }

        void subscribe(org.a.b<?>[] r5, int r6) {
            WithLatestInnerSubscriber[] r0 = this.subscribers;
            AtomicReference<org.a.d> r4 = this.upstream;
            int r1 = 0;
        L3:
            if (r1 >= r6) goto L8;
            if (r4.get() == SubscriptionHelper.CANCELLED) goto L6;
            r5[r1].subscribe(r0[r1]);
            r1 = r1 + 1;
            goto L3
        L6:
            return;
        }

        @Override // io.reactivex.internal.a.a
        public boolean tryOnNext(T r6) {
            if (this.done == false) goto L5;
            return false;
        L5:
            AtomicReferenceArray<Object> r0 = this.values;
            int r2 = r0.length();
            Object[] r3 = new Object[r2 + 1];
            r3[0] = r6;
            int r7 = 0;
        L6:
            if (r7 >= r2) goto L17;
            Object r4 = r0.get(r7);
            if (r4 == null) goto L9;
            r7 = r7 + 1;
            r3[r7] = r4;
            goto L6
        L9:
            return false;
        L17:
            e.a(this.downstream, io.reactivex.internal.functions.a.a(this.combiner.apply(r3), "The combiner returned a null value"), this, this.error);
            return true;
        L14:
            th = move-exception;
            io.reactivex.exceptions.a.a(th);
            cancel();
            onError(th);
            return false;
        }
    }

    static final class WithLatestInnerSubscriber extends AtomicReference<org.a.d> implements j<Object> {
        private static final long serialVersionUID = 3256684027868224024L;
        boolean hasValue;
        final int index;
        final WithLatestFromSubscriber<?, ?> parent;

        WithLatestInnerSubscriber(WithLatestFromSubscriber<?, ?> r1, int r2) {
            this.parent = r1;
            this.index = r2;
        }

        void dispose() {
            SubscriptionHelper.cancel(this);
        }

        @Override // org.a.c
        public void onComplete() {
            this.parent.innerComplete(this.index, this.hasValue);
        }

        @Override // org.a.c
        public void onError(Throwable r2) {
            this.parent.innerError(this.index, r2);
        }

        @Override // org.a.c
        public void onNext(Object r2) {
            if (this.hasValue == true) goto L5;
            this.hasValue = true;
        L5:
            this.parent.innerNext(this.index, r2);
        }

        @Override // io.reactivex.j, org.a.c
        public void onSubscribe(org.a.d r3) {
            SubscriptionHelper.setOnce(this, (org.a.d) ZeusTransformUtils.wrapperContextForParams(r3, org.a.d.class, "com.obric.memorydata.plugin"), Long.MAX_VALUE);
        }
    }

    final class a implements h<T, R> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ FlowableWithLatestFromMany f16810a;

        a(FlowableWithLatestFromMany r1) {
            this.f16810a = r1;
        }

        /* JADX WARN: Type inference failed for: r0v1, types: [java.lang.Object, java.lang.Object[]] */
        @Override // io.reactivex.b.h
        public R apply(T r3) {
            return (R) io.reactivex.internal.functions.a.a(this.f16810a.e.apply(new Object[]{r3}), "The combiner returned a null value");
        }
    }

    @Override // io.reactivex.g
    public void a(org.a.c<? super R> r7) {
        org.a.c r8 = (org.a.c) ZeusTransformUtils.wrapperContextForParams(r7, org.a.c.class, "com.obric.memorydata.plugin");
        org.a.b<?>[] r0 = this.c;
        if (r0 != null) goto L16;
        r0 = new org.a.b[8];
        Iterator<? extends org.a.b<?>> r2 = this.d.iterator();     // Catch: Throwable -> L13
        int r3 = 0;
    L6:
        if (r2.hasNext() == false) goto L17;
        org.a.b<?> r4 = (org.a.b) ZeusTransformUtils.preCheckCast(r2.next(), org.a.b.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L13
        if (r3 != r0.length) goto L11;
        r0 = (org.a.b[]) ZeusTransformUtils.preCheckCast(Arrays.copyOf(r0, (r3 >> 1) + r3), org.a.b[].class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L13
    L11:
        int r5 = r3 + 1;     // Catch: Throwable -> L13
        r0[r3] = r4;     // Catch: Throwable -> L13
        r3 = r5;
    L17:
        if (r3 != 0) goto L20;
        new b(this.f16812b, new a(this)).a(r8);
        return;
    L20:
        WithLatestFromSubscriber r1 = new WithLatestFromSubscriber(r8, this.e, r3);
        r8.onSubscribe(r1);
        r1.subscribe(r0, r3);
        this.f16812b.a(r1);
        return;
    L13:
        th = move-exception;
        io.reactivex.exceptions.a.a(th);
        EmptySubscription.error(th, r8);
        return;
    L16:
        r3 = r0.length;
        goto L17
    }
}
