package io.reactivex.internal.operators.flowable;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.g;
import io.reactivex.internal.a.f;
import io.reactivex.internal.queue.SpscArrayQueue;
import io.reactivex.internal.subscriptions.DeferredScalarSubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.j;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes6.dex */
public final class FlowableSequenceEqual<T> extends g<Boolean> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final org.a.b<? extends T> f16792b;
    final org.a.b<? extends T> c;
    final io.reactivex.b.d<? super T, ? super T> d;
    final int e;

    static final class EqualCoordinator<T> extends DeferredScalarSubscription<Boolean> implements a {
        private static final long serialVersionUID = -6178010334400373240L;
        final io.reactivex.b.d<? super T, ? super T> comparer;
        final AtomicThrowable error;
        final EqualSubscriber<T> first;
        final EqualSubscriber<T> second;
        T v1;
        T v2;
        final AtomicInteger wip;

        EqualCoordinator(org.a.c<? super Boolean> r3, int r4, io.reactivex.b.d<? super T, ? super T> r5) {
            org.a.c r6 = (org.a.c) ZeusTransformUtils.wrapperContextForParams(r3, org.a.c.class, "com.obric.memorydata.plugin");
            io.reactivex.b.d<? super T, ? super T> r7 = (io.reactivex.b.d) ZeusTransformUtils.wrapperContextForParams(r5, io.reactivex.b.d.class, "com.obric.memorydata.plugin");
            super(r6);
            this.comparer = r7;
            this.wip = new AtomicInteger();
            this.first = new EqualSubscriber(this, r4);
            this.second = new EqualSubscriber(this, r4);
            this.error = new AtomicThrowable();
        }

        @Override // io.reactivex.internal.subscriptions.DeferredScalarSubscription, org.a.d
        public void cancel() {
            super.cancel();
            this.first.cancel();
            this.second.cancel();
            if (this.wip.getAndIncrement() != 0) goto L6;
            this.first.clear();
            this.second.clear();
            return;
        }

        void cancelAndClear() {
            this.first.cancel();
            this.first.clear();
            this.second.cancel();
            this.second.clear();
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableSequenceEqual.a
        public void drain() {
            if (this.wip.getAndIncrement() == 0) goto L5;
            return;
        L5:
            int r1 = 1;
        L6:
            f<T> r2 = this.first.queue;
            f<T> r3 = this.second.queue;
            if (r2 == null) goto L61;
            if (r3 == null) goto L61;
        L10:
            if (isCancelled() == true) goto L11;
            if (((Throwable) ZeusTransformUtils.preCheckCast(this.error.get(), Throwable.class, "com.obric.memorydata.plugin")) != null) goto L15;
            boolean r5 = this.first.done;
            T r6 = this.v1;
            if (r6 != null) goto L25;
            r6 = r2.poll();     // Catch: Throwable -> L21
            this.v1 = r6;
        L21:
            th = move-exception;
            io.reactivex.exceptions.a.a(th);
            cancelAndClear();
            this.error.addThrowable(th);
            this.downstream.onError(this.error.terminate());
            return;
        L25:
            if (r6 != null) goto L27;
            boolean r8 = true;
        L28:
            boolean r9 = this.second.done;
            T r10 = this.v2;
            if (r10 == null) goto L71;
        L35:
            if (r10 != null) goto L37;
            boolean r11 = true;
        L38:
            if (r5 == false) goto L44;
            if (r9 == false) goto L44;
            if (r8 == false) goto L44;
            if (r11 == false) goto L44;
            complete(true);
            return;
        L44:
            if (r5 == false) goto L49;
            if (r9 == false) goto L49;
            if (r8 == r11) goto L49;
            cancelAndClear();
            complete(false);
            return;
        L49:
            if (r8 == true) goto L68;
            if (r11 == true) goto L68;
            if (this.comparer.a(r6, r10) == false) goto L54;
            this.v1 = null;
            this.v2 = null;
            this.first.request();
            this.second.request();
            goto L10
        L54:
            cancelAndClear();
            complete(false);
            return;
        L57:
            th = move-exception;
            io.reactivex.exceptions.a.a(th);
            cancelAndClear();
            this.error.addThrowable(th);
            this.downstream.onError(this.error.terminate());
            return;
        L68:
            r1 = this.wip.addAndGet(-r1);
            if (r1 != 0) goto L6;
            return;
        L37:
            r11 = false;
            goto L38
        L71:
            r10 = r3.poll();     // Catch: Throwable -> L32
            this.v2 = r10;
        L32:
            th = move-exception;
            io.reactivex.exceptions.a.a(th);
            cancelAndClear();
            this.error.addThrowable(th);
            this.downstream.onError(this.error.terminate());
            return;
        L27:
            r8 = false;
            goto L28
        L15:
            cancelAndClear();
            this.downstream.onError(this.error.terminate());
            return;
        L11:
            this.first.clear();
            this.second.clear();
            return;
        L61:
            if (isCancelled() == true) goto L62;
            if (((Throwable) ZeusTransformUtils.preCheckCast(this.error.get(), Throwable.class, "com.obric.memorydata.plugin")) == null) goto L68;
            cancelAndClear();
            this.downstream.onError(this.error.terminate());
            return;
        L62:
            this.first.clear();
            this.second.clear();
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableSequenceEqual.a
        public void innerError(Throwable r2) {
            if (this.error.addThrowable(r2) == false) goto L5;
            drain();
            return;
        L5:
            io.reactivex.d.a.a(r2);
        }

        void subscribe(org.a.b<? extends T> r3, org.a.b<? extends T> r4) {
            org.a.b r5 = (org.a.b) ZeusTransformUtils.wrapperContextForParams(r3, org.a.b.class, "com.obric.memorydata.plugin");
            org.a.b r6 = (org.a.b) ZeusTransformUtils.wrapperContextForParams(r4, org.a.b.class, "com.obric.memorydata.plugin");
            r5.subscribe(this.first);
            r6.subscribe(this.second);
        }
    }

    static final class EqualSubscriber<T> extends AtomicReference<org.a.d> implements j<T> {
        private static final long serialVersionUID = 4804128302091633067L;
        volatile boolean done;
        final int limit;
        final a parent;
        final int prefetch;
        long produced;
        volatile f<T> queue;
        int sourceMode;

        EqualSubscriber(a r3, int r4) {
            this.parent = (a) ZeusTransformUtils.wrapperContextForParams(r3, a.class, "com.obric.memorydata.plugin");
            this.limit = r4 - (r4 >> 2);
            this.prefetch = r4;
        }

        public void cancel() {
            SubscriptionHelper.cancel(this);
        }

        void clear() {
            f<T> r0 = this.queue;
            if (r0 == null) goto L6;
            r0.clear();
            return;
        }

        @Override // org.a.c
        public void onComplete() {
            this.done = true;
            this.parent.drain();
        }

        @Override // org.a.c
        public void onError(Throwable r1) {
            this.parent.innerError(r1);
        }

        @Override // org.a.c
        public void onNext(T r2) {
            if (this.sourceMode == 0) goto L5;
        L8:
            this.parent.drain();
            return;
        L5:
            if (this.queue.offer(r2) == true) goto L8;
            onError(new MissingBackpressureException());
        }

        @Override // io.reactivex.j, org.a.c
        public void onSubscribe(org.a.d r4) {
            org.a.d r5 = (org.a.d) ZeusTransformUtils.wrapperContextForParams(r4, org.a.d.class, "com.obric.memorydata.plugin");
            if (SubscriptionHelper.setOnce(this, r5) == true) goto L5;
            return;
        L5:
            if (ZeusTransformUtils.instanceOf(r5, io.reactivex.internal.a.d.class) == false) goto L14;
            io.reactivex.internal.a.d r0 = (io.reactivex.internal.a.d) ZeusTransformUtils.preCheckCast(r5, io.reactivex.internal.a.d.class, "com.obric.memorydata.plugin");
            int r1 = r0.requestFusion(3);
            if (r1 != 1) goto L11;
            this.sourceMode = r1;
            this.queue = r0;
            this.done = true;
            this.parent.drain();
            return;
        L11:
            if (r1 != 2) goto L14;
            this.sourceMode = r1;
            this.queue = r0;
            r5.request(this.prefetch);
            return;
        L14:
            this.queue = new SpscArrayQueue(this.prefetch);
            r5.request(this.prefetch);
        }

        public void request() {
            if (this.sourceMode == 1) goto L9;
            long r0 = this.produced + 1;
            if (r0 < this.limit) goto L7;
            this.produced = 0;
            ((org.a.d) ZeusTransformUtils.preCheckCast(get(), org.a.d.class, "com.obric.memorydata.plugin")).request(r0);
            return;
        L7:
            this.produced = r0;
            return;
        }
    }

    interface a {
        void drain();

        void innerError(Throwable r1);
    }

    @Override // io.reactivex.g
    public void a(org.a.c<? super Boolean> r4) {
        org.a.c r5 = (org.a.c) ZeusTransformUtils.wrapperContextForParams(r4, org.a.c.class, "com.obric.memorydata.plugin");
        EqualCoordinator r0 = new EqualCoordinator(r5, this.e, this.d);
        r5.onSubscribe(r0);
        r0.subscribe(this.f16792b, this.c);
    }
}
