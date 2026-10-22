package io.reactivex.internal.operators.parallel;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import io.reactivex.b.c;
import io.reactivex.internal.subscribers.DeferredScalarSubscriber;
import io.reactivex.internal.subscriptions.EmptySubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.parallel.a;
import java.util.concurrent.Callable;
import org.a.d;

/* JADX INFO: loaded from: classes6.dex */
public final class ParallelReduce<T, R> extends a<R> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final a<? extends T> f17043a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final Callable<R> f17044b;
    final c<R, ? super T, R> c;

    static final class ParallelReduceSubscriber<T, R> extends DeferredScalarSubscriber<T, R> {
        private static final long serialVersionUID = 8200530050639449080L;
        R accumulator;
        boolean done;
        final c<R, ? super T, R> reducer;

        ParallelReduceSubscriber(org.a.c<? super R> r3, R r4, c<R, ? super T, R> r5) {
            org.a.c r6 = (org.a.c) ZeusTransformUtils.wrapperContextForParams(r3, org.a.c.class, "com.obric.memorydata.plugin");
            c<R, ? super T, R> r7 = (c) ZeusTransformUtils.wrapperContextForParams(r5, c.class, "com.obric.memorydata.plugin");
            super(r6);
            this.accumulator = r4;
            this.reducer = r7;
        }

        @Override // io.reactivex.internal.subscribers.DeferredScalarSubscriber, io.reactivex.internal.subscriptions.DeferredScalarSubscription, org.a.d
        public void cancel() {
            super.cancel();
            this.upstream.cancel();
        }

        @Override // io.reactivex.internal.subscribers.DeferredScalarSubscriber, org.a.c
        public void onComplete() {
            if (this.done == true) goto L6;
            this.done = true;
            R r0 = this.accumulator;
            this.accumulator = null;
            complete(r0);
            return;
        }

        @Override // io.reactivex.internal.subscribers.DeferredScalarSubscriber, org.a.c
        public void onError(Throwable r2) {
            if (this.done == false) goto L6;
            io.reactivex.d.a.a(r2);
            return;
        L6:
            this.done = true;
            this.accumulator = null;
            this.downstream.onError(r2);
        }

        @Override // org.a.c
        public void onNext(T r3) {
            if (this.done == true) goto L11;
            this.accumulator = (R) io.reactivex.internal.functions.a.a(this.reducer.apply(this.accumulator, r3), "The reducer returned a null value");
            return;
        L6:
            th = move-exception;
            io.reactivex.exceptions.a.a(th);
            cancel();
            onError(th);
            return;
        }

        @Override // io.reactivex.internal.subscribers.DeferredScalarSubscriber, io.reactivex.j, org.a.c
        public void onSubscribe(d r3) {
            d r4 = (d) ZeusTransformUtils.wrapperContextForParams(r3, d.class, "com.obric.memorydata.plugin");
            if (SubscriptionHelper.validate(this.upstream, r4) == false) goto L6;
            this.upstream = r4;
            this.downstream.onSubscribe(this);
            r4.request(Long.MAX_VALUE);
            return;
        }
    }

    @Override // io.reactivex.parallel.a
    public int a() {
        return this.f17043a.a();
    }

    @Override // io.reactivex.parallel.a
    public void a(org.a.c<? super R>[] r8) {
        if (b(r8) == true) goto L5;
        return;
    L5:
        int r0 = r8.length;
        org.a.c<? super Object>[] r1 = new org.a.c[r0];
        int r2 = 0;
    L6:
        if (r2 >= r0) goto L12;
        Object r3 = io.reactivex.internal.functions.a.a(this.f17044b.call(), "The initialSupplier returned a null value");     // Catch: Throwable -> L9
        r1[r2] = new ParallelReduceSubscriber(r8[r2], r3, this.c);
        r2 = r2 + 1;
    L9:
        th = move-exception;
        io.reactivex.exceptions.a.a(th);
        a(r8, th);
        return;
    L12:
        this.f17043a.a(r1);
    }

    void a(org.a.c<?>[] r3, Throwable r4) {
        int r2 = r3.length;
        int r0 = 0;
    L3:
        if (r0 >= r2) goto L5;
        EmptySubscription.error(r4, r3[r0]);
        r0 = r0 + 1;
        goto L3
    }
}
