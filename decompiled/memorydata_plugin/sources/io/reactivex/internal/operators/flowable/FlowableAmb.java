package io.reactivex.internal.operators.flowable;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import io.reactivex.g;
import io.reactivex.internal.subscriptions.EmptySubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.j;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes6.dex */
public final class FlowableAmb<T> extends g<T> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final org.a.b<? extends T>[] f16756b;
    final Iterable<? extends org.a.b<? extends T>> c;

    static final class AmbInnerSubscriber<T> extends AtomicReference<org.a.d> implements j<T>, org.a.d {
        private static final long serialVersionUID = -1185974347409665484L;
        final org.a.c<? super T> downstream;
        final int index;
        final AtomicLong missedRequested;
        final a<T> parent;
        boolean won;

        AmbInnerSubscriber(a<T> r3, int r4, org.a.c<? super T> r5) {
            org.a.c<? super T> r6 = (org.a.c) ZeusTransformUtils.wrapperContextForParams(r5, org.a.c.class, "com.obric.memorydata.plugin");
            this.missedRequested = new AtomicLong();
            this.parent = r3;
            this.index = r4;
            this.downstream = r6;
        }

        @Override // org.a.d
        public void cancel() {
            SubscriptionHelper.cancel(this);
        }

        @Override // org.a.c
        public void onComplete() {
            if (this.won == false) goto L6;
        L4:
            this.downstream.onComplete();
            return;
        L6:
            if (this.parent.a(this.index) == false) goto L8;
            this.won = true;
            goto L4
        L8:
            ((org.a.d) ZeusTransformUtils.preCheckCast(get(), org.a.d.class, "com.obric.memorydata.plugin")).cancel();
        }

        @Override // org.a.c
        public void onError(Throwable r3) {
            if (this.won == false) goto L6;
        L4:
            this.downstream.onError(r3);
            return;
        L6:
            if (this.parent.a(this.index) == false) goto L8;
            this.won = true;
            goto L4
        L8:
            ((org.a.d) ZeusTransformUtils.preCheckCast(get(), org.a.d.class, "com.obric.memorydata.plugin")).cancel();
            io.reactivex.d.a.a(r3);
        }

        @Override // org.a.c
        public void onNext(T r3) {
            if (this.won == false) goto L6;
        L4:
            this.downstream.onNext(r3);
            return;
        L6:
            if (this.parent.a(this.index) == false) goto L8;
            this.won = true;
            goto L4
        L8:
            ((org.a.d) ZeusTransformUtils.preCheckCast(get(), org.a.d.class, "com.obric.memorydata.plugin")).cancel();
        }

        @Override // io.reactivex.j, org.a.c
        public void onSubscribe(org.a.d r3) {
            org.a.d r4 = (org.a.d) ZeusTransformUtils.wrapperContextForParams(r3, org.a.d.class, "com.obric.memorydata.plugin");
            SubscriptionHelper.deferredSetOnce(this, this.missedRequested, r4);
        }

        @Override // org.a.d
        public void request(long r2) {
            SubscriptionHelper.deferredRequest(this, this.missedRequested, r2);
        }
    }

    static final class a<T> implements org.a.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final org.a.c<? super T> f16757a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final AmbInnerSubscriber<T>[] f16758b;
        final AtomicInteger c;

        a(org.a.c<? super T> r3, int r4) {
            org.a.c<? super T> r5 = (org.a.c) ZeusTransformUtils.wrapperContextForParams(r3, org.a.c.class, "com.obric.memorydata.plugin");
            this.c = new AtomicInteger();
            this.f16757a = r5;
            this.f16758b = new AmbInnerSubscriber[r4];
        }

        public void a(org.a.b<? extends T>[] r8) {
            AmbInnerSubscriber<T>[] r0 = this.f16758b;
            int r1 = r0.length;
            int r2 = 0;
            int r3 = 0;
        L3:
            if (r3 >= r1) goto L5;
            int r5 = r3 + 1;
            r0[r3] = new AmbInnerSubscriber(this, r5, this.f16757a);
            r3 = r5;
            goto L3
        L5:
            this.c.lazySet(0);
            this.f16757a.onSubscribe(this);
        L6:
            if (r2 >= r1) goto L11;
            if (this.c.get() != 0) goto L9;
            r8[r2].subscribe(r0[r2]);
            r2 = r2 + 1;
            goto L6
        L9:
            return;
        }

        public boolean a(int r4) {
            int r1 = 0;
            if (this.c.get() == 0) goto L5;
        L14:
            return false;
        L5:
            if (this.c.compareAndSet(0, r4) == false) goto L14;
            AmbInnerSubscriber<T>[] r3 = this.f16758b;
            int r0 = r3.length;
        L7:
            if (r1 >= r0) goto L12;
            int r2 = r1 + 1;
            if (r2 == r4) goto L11;
            r3[r1].cancel();
        L11:
            r1 = r2;
            goto L7
        L12:
            return true;
        }

        @Override // org.a.d
        public void cancel() {
            if (this.c.get() == (-1)) goto L7;
            this.c.lazySet(-1);
            AmbInnerSubscriber<T>[] r3 = this.f16758b;
            int r0 = r3.length;
            int r1 = 0;
        L5:
            if (r1 >= r0) goto L9;
            r3[r1].cancel();
            r1 = r1 + 1;
            goto L5
        L9:
            return;
        }

        @Override // org.a.d
        public void request(long r4) {
            if (SubscriptionHelper.validate(r4) == false) goto L11;
            int r0 = this.c.get();
            if (r0 <= 0) goto L7;
            this.f16758b[r0 - 1].request(r4);
            return;
        L7:
            if (r0 != 0) goto L14;
            AmbInnerSubscriber<T>[] r3 = this.f16758b;
            int r1 = r3.length;
            int r2 = 0;
        L9:
            if (r2 >= r1) goto L15;
            r3[r2].request(r4);
            r2 = r2 + 1;
            goto L9
        L15:
            return;
        L14:
            return;
        }
    }

    @Override // io.reactivex.g
    public void a(org.a.c<? super T> r7) {
        org.a.c<? super Object> r8 = (org.a.c) ZeusTransformUtils.wrapperContextForParams(r7, org.a.c.class, "com.obric.memorydata.plugin");
        org.a.b<? extends T>[] r0 = this.f16756b;
        if (r0 != null) goto L20;
        r0 = new org.a.b[8];
        Iterator<? extends org.a.b<? extends T>> r6 = this.c.iterator();     // Catch: Throwable -> L17
        int r3 = 0;
    L7:
        if (r6.hasNext() == false) goto L21;
        org.a.b<? extends T> r4 = (org.a.b) ZeusTransformUtils.preCheckCast(r6.next(), org.a.b.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L17
        if (r4 == null) goto L10;
        if (r3 != r0.length) goto L15;
        org.a.b<? extends T>[] r5 = new org.a.b[(r3 >> 2) + r3];     // Catch: Throwable -> L17
        System.arraycopy(r0, 0, r5, 0, r3);     // Catch: Throwable -> L17
        r0 = r5;
    L15:
        int r9 = r3 + 1;     // Catch: Throwable -> L17
        r0[r3] = r4;     // Catch: Throwable -> L17
        r3 = r9;
        goto L7
    L10:
        EmptySubscription.error(new NullPointerException("One of the sources is null"), r8);     // Catch: Throwable -> L17
        return;
    L21:
        if (r3 != 0) goto L25;
        EmptySubscription.complete(r8);
        return;
    L25:
        if (r3 != 1) goto L28;
        r0[0].subscribe(r8);
        return;
    L28:
        new a(r8, r3).a(r0);
        return;
    L17:
        th = move-exception;
        io.reactivex.exceptions.a.a(th);
        EmptySubscription.error(th, r8);
        return;
    L20:
        r3 = r0.length;
        goto L21
    }
}
