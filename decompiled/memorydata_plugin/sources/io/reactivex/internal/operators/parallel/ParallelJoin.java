package io.reactivex.internal.operators.parallel;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.g;
import io.reactivex.internal.a.e;
import io.reactivex.internal.queue.SpscArrayQueue;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.internal.util.b;
import io.reactivex.j;
import io.reactivex.parallel.a;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.a.c;
import org.a.d;

/* JADX INFO: loaded from: classes6.dex */
public final class ParallelJoin<T> extends g<T> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final a<? extends T> f17042b;
    final int c;
    final boolean d;

    static final class JoinInnerSubscriber<T> extends AtomicReference<d> implements j<T> {
        private static final long serialVersionUID = 8410034718427740355L;
        final int limit;
        final JoinSubscriptionBase<T> parent;
        final int prefetch;
        long produced;
        volatile e<T> queue;

        JoinInnerSubscriber(JoinSubscriptionBase<T> r1, int r2) {
            this.parent = r1;
            this.prefetch = r2;
            this.limit = r2 - (r2 >> 2);
        }

        public boolean cancel() {
            return SubscriptionHelper.cancel(this);
        }

        e<T> getQueue() {
            e<T> r0 = this.queue;
            if (r0 != null) goto L6;
            SpscArrayQueue r1 = new SpscArrayQueue(this.prefetch);
            this.queue = r1;
            return r1;
        L6:
            return r0;
        }

        @Override // org.a.c
        public void onComplete() {
            this.parent.onComplete();
        }

        @Override // org.a.c
        public void onError(Throwable r1) {
            this.parent.onError(r1);
        }

        @Override // org.a.c
        public void onNext(T r2) {
            this.parent.onNext(this, r2);
        }

        @Override // io.reactivex.j, org.a.c
        public void onSubscribe(d r3) {
            SubscriptionHelper.setOnce(this, (d) ZeusTransformUtils.wrapperContextForParams(r3, d.class, "com.obric.memorydata.plugin"), this.prefetch);
        }

        public void request(long r3) {
            long r0 = this.produced + r3;
            if (r0 < this.limit) goto L5;
            this.produced = 0;
            ((d) ZeusTransformUtils.preCheckCast(get(), d.class, "com.obric.memorydata.plugin")).request(r0);
            return;
        L5:
            this.produced = r0;
        }

        public void requestOne() {
            long r0 = this.produced + 1;
            if (r0 != this.limit) goto L5;
            this.produced = 0;
            ((d) ZeusTransformUtils.preCheckCast(get(), d.class, "com.obric.memorydata.plugin")).request(r0);
            return;
        L5:
            this.produced = r0;
        }
    }

    static final class JoinSubscription<T> extends JoinSubscriptionBase<T> {
        private static final long serialVersionUID = 6312374661811000451L;

        JoinSubscription(c<? super T> r3, int r4, int r5) {
            super((c) ZeusTransformUtils.wrapperContextForParams(r3, c.class, "com.obric.memorydata.plugin"), r4, r5);
        }

        @Override // io.reactivex.internal.operators.parallel.ParallelJoin.JoinSubscriptionBase
        void drain() {
            if (getAndIncrement() == 0) goto L5;
            return;
        L5:
            drainLoop();
        }

        void drainLoop() {
            JoinInnerSubscriber<T>[] r1 = this.subscribers;
            int r2 = r1.length;
            c<? super T> r3 = this.downstream;
            int r5 = 1;
        L3:
            long r6 = this.requested.get();
            long r10 = 0;
        L5:
            if (r10 == r6) goto L36;
            if (this.cancelled == true) goto L8;
            Throwable r12 = (Throwable) ZeusTransformUtils.preCheckCast(this.errors.get(), Throwable.class, "com.obric.memorydata.plugin");
            if (r12 != null) goto L12;
            if (this.done.get() != 0) goto L17;
            boolean r13 = true;
        L18:
            int r15 = 0;
            boolean r16 = true;
        L20:
            if (r15 >= r1.length) goto L30;
            JoinInnerSubscriber<T> r4 = r1[r15];
            e<T> r14 = r4.queue;
            if (r14 == null) goto L29;
            T r17 = r14.poll();
            if (r17 == null) goto L29;
            r3.onNext(r17);
            r4.requestOne();
            r10 = r10 + 1;
            if (r10 == r6) goto L36;
            r16 = false;
        L29:
            r15 = r15 + 1;
            goto L20
        L30:
            if (r13 == false) goto L34;
            if (r16 == false) goto L34;
            r3.onComplete();
            return;
        L34:
            if (r16 == false) goto L5;
        L17:
            r13 = false;
            goto L18
        L12:
            cleanup();
            r3.onError(r12);
            return;
        L8:
            cleanup();
            return;
        L36:
            if (r10 != r6) goto L63;
            if (this.cancelled == true) goto L39;
            Throwable r7 = (Throwable) ZeusTransformUtils.preCheckCast(this.errors.get(), Throwable.class, "com.obric.memorydata.plugin");
            if (r7 != null) goto L43;
            if (this.done.get() != 0) goto L48;
            boolean r8 = true;
        L49:
            int r18 = 0;
        L50:
            if (r18 >= r2) goto L57;
            e<T> r19 = r1[r18].queue;
            if (r19 == null) goto L56;
            if (r19.isEmpty() == true) goto L56;
            boolean r110 = false;
        L58:
            if (r8 == false) goto L63;
            if (r110 == false) goto L63;
            r3.onComplete();
            return;
        L56:
            r18 = r18 + 1;
            goto L50
        L57:
            r110 = true;
            goto L58
        L48:
            r8 = false;
            goto L49
        L43:
            cleanup();
            r3.onError(r7);
            return;
        L39:
            cleanup();
            return;
        L63:
            if (r10 != 0) goto L65;
        L67:
            int r9 = get();
            if (r9 != r5) goto L72;
            r9 = addAndGet(-r5);
            if (r9 != 0) goto L72;
            return;
        L72:
            r5 = r9;
            goto L3
        L65:
            if (r6 == Long.MAX_VALUE) goto L67;
            this.requested.addAndGet(-r10);
            goto L67
        }

        @Override // io.reactivex.internal.operators.parallel.ParallelJoin.JoinSubscriptionBase
        public void onComplete() {
            this.done.decrementAndGet();
            drain();
        }

        @Override // io.reactivex.internal.operators.parallel.ParallelJoin.JoinSubscriptionBase
        public void onError(Throwable r3) {
            if (this.errors.compareAndSet(null, r3) == false) goto L6;
            cancelAll();
            drain();
            return;
        L6:
            if (r3 == this.errors.get()) goto L10;
            io.reactivex.d.a.a(r3);
            return;
        }

        @Override // io.reactivex.internal.operators.parallel.ParallelJoin.JoinSubscriptionBase
        public void onNext(JoinInnerSubscriber<T> r7, T r8) {
            if (get() != 0) goto L23;
            if (compareAndSet(0, 1) == false) goto L23;
            if (this.requested.get() == 0) goto L13;
            this.downstream.onNext(r8);
            if (this.requested.get() == Long.MAX_VALUE) goto L11;
            this.requested.decrementAndGet();
        L11:
            r7.request(1);
        L20:
            if (decrementAndGet() != 0) goto L29;
            return;
        L29:
            drainLoop();
            return;
        L13:
            if (r7.getQueue().offer(r8) == true) goto L20;
            cancelAll();
            MissingBackpressureException r9 = new MissingBackpressureException("Queue full?!");
            if (this.errors.compareAndSet(null, r9) == false) goto L17;
            this.downstream.onError(r9);
            return;
        L17:
            io.reactivex.d.a.a(r9);
            return;
        L23:
            if (r7.getQueue().offer(r8) == true) goto L27;
            cancelAll();
            onError(new MissingBackpressureException("Queue full?!"));
            return;
        L27:
            if (getAndIncrement() == 0) goto L29;
        }
    }

    static abstract class JoinSubscriptionBase<T> extends AtomicInteger implements d {
        private static final long serialVersionUID = 3100232009247827843L;
        volatile boolean cancelled;
        final AtomicInteger done;
        final c<? super T> downstream;
        final AtomicThrowable errors;
        final AtomicLong requested;
        final JoinInnerSubscriber<T>[] subscribers;

        JoinSubscriptionBase(c<? super T> r3, int r4, int r5) {
            c<? super T> r6 = (c) ZeusTransformUtils.wrapperContextForParams(r3, c.class, "com.obric.memorydata.plugin");
            this.errors = new AtomicThrowable();
            this.requested = new AtomicLong();
            this.done = new AtomicInteger();
            this.downstream = r6;
            JoinInnerSubscriber<T>[] r7 = new JoinInnerSubscriber[r4];
            int r0 = 0;
        L3:
            if (r0 >= r4) goto L5;
            r7[r0] = new JoinInnerSubscriber(this, r5);
            r0 = r0 + 1;
            goto L3
        L5:
            this.subscribers = r7;
            this.done.lazySet(r4);
        }

        @Override // org.a.d
        public void cancel() {
            if (this.cancelled == true) goto L8;
            this.cancelled = true;
            cancelAll();
            if (getAndIncrement() != 0) goto L9;
            cleanup();
            return;
        L9:
            return;
        }

        void cancelAll() {
            JoinInnerSubscriber<T>[] r3 = this.subscribers;
            int r0 = r3.length;
            int r1 = 0;
        L3:
            if (r1 >= r0) goto L5;
            r3[r1].cancel();
            r1 = r1 + 1;
            goto L3
        }

        void cleanup() {
            JoinInnerSubscriber<T>[] r4 = this.subscribers;
            int r0 = r4.length;
            int r1 = 0;
        L3:
            if (r1 >= r0) goto L5;
            r4[r1].queue = null;
            r1 = r1 + 1;
            goto L3
        }

        abstract void drain();

        abstract void onComplete();

        abstract void onError(Throwable r1);

        abstract void onNext(JoinInnerSubscriber<T> r1, T r2);

        @Override // org.a.d
        public void request(long r2) {
            if (SubscriptionHelper.validate(r2) == false) goto L6;
            b.a(this.requested, r2);
            drain();
            return;
        }
    }

    static final class JoinSubscriptionDelayError<T> extends JoinSubscriptionBase<T> {
        private static final long serialVersionUID = -5737965195918321883L;

        JoinSubscriptionDelayError(c<? super T> r3, int r4, int r5) {
            super((c) ZeusTransformUtils.wrapperContextForParams(r3, c.class, "com.obric.memorydata.plugin"), r4, r5);
        }

        @Override // io.reactivex.internal.operators.parallel.ParallelJoin.JoinSubscriptionBase
        void drain() {
            if (getAndIncrement() == 0) goto L5;
            return;
        L5:
            drainLoop();
        }

        void drainLoop() {
            JoinInnerSubscriber<T>[] r1 = this.subscribers;
            int r2 = r1.length;
            c<? super T> r3 = this.downstream;
            int r5 = 1;
        L3:
            long r6 = this.requested.get();
            long r10 = 0;
        L5:
            if (r10 == r6) goto L34;
            if (this.cancelled == true) goto L8;
            if (this.done.get() != 0) goto L13;
            boolean r12 = true;
        L14:
            int r15 = 0;
            boolean r16 = true;
        L15:
            if (r15 >= r2) goto L25;
            JoinInnerSubscriber<T> r4 = r1[r15];
            e<T> r14 = r4.queue;
            if (r14 == null) goto L24;
            T r17 = r14.poll();
            if (r17 == null) goto L24;
            r3.onNext(r17);
            r4.requestOne();
            r10 = r10 + 1;
            if (r10 == r6) goto L34;
            r16 = false;
        L24:
            r15 = r15 + 1;
            goto L15
        L25:
            if (r12 == false) goto L32;
            if (r16 == false) goto L32;
            if (((Throwable) ZeusTransformUtils.preCheckCast(this.errors.get(), Throwable.class, "com.obric.memorydata.plugin")) == null) goto L30;
            r3.onError(this.errors.terminate());
            return;
        L30:
            r3.onComplete();
            return;
        L32:
            if (r16 == false) goto L5;
        L13:
            r12 = false;
            goto L14
        L8:
            cleanup();
            return;
        L34:
            if (r10 != r6) goto L60;
            if (this.cancelled == true) goto L37;
            if (this.done.get() != 0) goto L42;
            boolean r7 = true;
        L43:
            int r13 = 0;
        L44:
            if (r13 >= r2) goto L51;
            e<T> r18 = r1[r13].queue;
            if (r18 == null) goto L50;
            if (r18.isEmpty() == true) goto L50;
            boolean r19 = false;
        L52:
            if (r7 == false) goto L60;
            if (r19 == false) goto L60;
            if (((Throwable) ZeusTransformUtils.preCheckCast(this.errors.get(), Throwable.class, "com.obric.memorydata.plugin")) == null) goto L57;
            r3.onError(this.errors.terminate());
            return;
        L57:
            r3.onComplete();
            return;
        L50:
            r13 = r13 + 1;
            goto L44
        L51:
            r19 = true;
            goto L52
        L42:
            r7 = false;
            goto L43
        L37:
            cleanup();
            return;
        L60:
            if (r10 != 0) goto L62;
        L64:
            int r8 = get();
            if (r8 != r5) goto L69;
            r8 = addAndGet(-r5);
            if (r8 != 0) goto L69;
            return;
        L69:
            r5 = r8;
            goto L3
        L62:
            if (r6 == Long.MAX_VALUE) goto L64;
            this.requested.addAndGet(-r10);
            goto L64
        }

        @Override // io.reactivex.internal.operators.parallel.ParallelJoin.JoinSubscriptionBase
        void onComplete() {
            this.done.decrementAndGet();
            drain();
        }

        @Override // io.reactivex.internal.operators.parallel.ParallelJoin.JoinSubscriptionBase
        void onError(Throwable r2) {
            this.errors.addThrowable(r2);
            this.done.decrementAndGet();
            drain();
        }

        @Override // io.reactivex.internal.operators.parallel.ParallelJoin.JoinSubscriptionBase
        void onNext(JoinInnerSubscriber<T> r7, T r8) {
            if (get() != 0) goto L20;
            if (compareAndSet(0, 1) == false) goto L20;
            if (this.requested.get() == 0) goto L13;
            this.downstream.onNext(r8);
            if (this.requested.get() == Long.MAX_VALUE) goto L11;
            this.requested.decrementAndGet();
        L11:
            r7.request(1);
        L17:
            if (decrementAndGet() != 0) goto L27;
            return;
        L27:
            drainLoop();
            return;
        L13:
            if (r7.getQueue().offer(r8) == true) goto L17;
            r7.cancel();
            this.errors.addThrowable(new MissingBackpressureException("Queue full?!"));
            this.done.decrementAndGet();
            drainLoop();
            return;
        L20:
            if (r7.getQueue().offer(r8) == true) goto L25;
            if (r7.cancel() == false) goto L25;
            this.errors.addThrowable(new MissingBackpressureException("Queue full?!"));
            this.done.decrementAndGet();
        L25:
            if (getAndIncrement() == 0) goto L27;
        }
    }

    @Override // io.reactivex.g
    public void a(c<? super T> r4) {
        c r5 = (c) ZeusTransformUtils.wrapperContextForParams(r4, c.class, "com.obric.memorydata.plugin");
        if (this.d == false) goto L5;
        JoinSubscriptionBase r0 = new JoinSubscriptionDelayError(r5, this.f17042b.a(), this.c);
    L6:
        r5.onSubscribe(r0);
        this.f17042b.a(r0.subscribers);
        return;
    L5:
        r0 = new JoinSubscription(r5, this.f17042b.a(), this.c);
        goto L6
    }
}
