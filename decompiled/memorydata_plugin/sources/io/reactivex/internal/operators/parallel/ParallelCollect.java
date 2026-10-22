package io.reactivex.internal.operators.parallel;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import io.reactivex.b.b;
import io.reactivex.internal.subscribers.DeferredScalarSubscriber;
import io.reactivex.internal.subscriptions.EmptySubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.parallel.a;
import java.util.concurrent.Callable;
import org.a.c;
import org.a.d;

/* JADX INFO: loaded from: classes6.dex */
public final class ParallelCollect<T, C> extends a<C> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final a<? extends T> f17036a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final Callable<? extends C> f17037b;
    final b<? super C, ? super T> c;

    static final class ParallelCollectSubscriber<T, C> extends DeferredScalarSubscriber<T, C> {
        private static final long serialVersionUID = -4767392946044436228L;
        C collection;
        final b<? super C, ? super T> collector;
        boolean done;

        ParallelCollectSubscriber(c<? super C> r3, C r4, b<? super C, ? super T> r5) {
            c r6 = (c) ZeusTransformUtils.wrapperContextForParams(r3, c.class, "com.obric.memorydata.plugin");
            b<? super C, ? super T> r7 = (b) ZeusTransformUtils.wrapperContextForParams(r5, b.class, "com.obric.memorydata.plugin");
            super(r6);
            this.collection = r4;
            this.collector = r7;
        }

        @Override // io.reactivex.internal.subscribers.DeferredScalarSubscriber, io.reactivex.internal.subscriptions.DeferredScalarSubscription, org.a.d
        public void cancel() {
            super.cancel();
            this.upstream.cancel();
        }

        @Override // io.reactivex.internal.subscribers.DeferredScalarSubscriber, org.a.c
        public void onComplete() {
            if (this.done == false) goto L5;
            return;
        L5:
            this.done = true;
            C r0 = this.collection;
            this.collection = null;
            complete(r0);
        }

        @Override // io.reactivex.internal.subscribers.DeferredScalarSubscriber, org.a.c
        public void onError(Throwable r2) {
            if (this.done == false) goto L6;
            io.reactivex.d.a.a(r2);
            return;
        L6:
            this.done = true;
            this.collection = null;
            this.downstream.onError(r2);
        }

        @Override // org.a.c
        public void onNext(T r3) {
            if (this.done == false) goto L10;
            return;
        L10:
            this.collector.a(this.collection, r3);     // Catch: Throwable -> L7
            return;
        L7:
            th = move-exception;
            io.reactivex.exceptions.a.a(th);
            cancel();
            onError(th);
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
        return this.f17036a.a();
    }

    @Override // io.reactivex.parallel.a
    public void a(c<? super C>[] r8) {
        if (b(r8) == true) goto L5;
        return;
    L5:
        int r0 = r8.length;
        c<? super Object>[] r1 = new c[r0];
        int r2 = 0;
    L6:
        if (r2 >= r0) goto L12;
        Object r3 = io.reactivex.internal.functions.a.a(this.f17037b.call(), "The initialSupplier returned a null value");     // Catch: Throwable -> L9
        r1[r2] = new ParallelCollectSubscriber(r8[r2], r3, this.c);
        r2 = r2 + 1;
    L9:
        th = move-exception;
        io.reactivex.exceptions.a.a(th);
        a(r8, th);
        return;
    L12:
        this.f17036a.a(r1);
    }

    void a(c<?>[] r3, Throwable r4) {
        int r2 = r3.length;
        int r0 = 0;
    L3:
        if (r0 >= r2) goto L5;
        EmptySubscription.error(r4, r3[r0]);
        r0 = r0 + 1;
        goto L3
    }
}
