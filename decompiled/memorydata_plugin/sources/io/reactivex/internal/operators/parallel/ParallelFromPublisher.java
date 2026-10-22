package io.reactivex.internal.operators.parallel;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.internal.a.f;
import io.reactivex.internal.queue.SpscArrayQueue;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.j;
import io.reactivex.parallel.a;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLongArray;
import org.a.b;
import org.a.c;
import org.a.d;

/* JADX INFO: loaded from: classes6.dex */
public final class ParallelFromPublisher<T> extends a<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final b<? extends T> f17038a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final int f17039b;
    final int c;

    static final class ParallelDispatcher<T> extends AtomicInteger implements j<T> {
        private static final long serialVersionUID = -4470634016609963609L;
        volatile boolean cancelled;
        volatile boolean done;
        final long[] emissions;
        Throwable error;
        int index;
        final int limit;
        final int prefetch;
        int produced;
        f<T> queue;
        final AtomicLongArray requests;
        int sourceMode;
        final AtomicInteger subscriberCount;
        final c<? super T>[] subscribers;
        d upstream;

        final class a implements d {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final int f17040a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final int f17041b;
            final /* synthetic */ ParallelDispatcher c;

            a(ParallelDispatcher r1, int r2, int r3) {
                this.c = r1;
                this.f17040a = r2;
                this.f17041b = r3;
            }

            @Override // org.a.d
            public void cancel() {
                AtomicLongArray r1 = this.c.requests;
                int r0 = this.f17041b;
                if (r1.compareAndSet(this.f17040a + r0, 0, 1) == false) goto L6;
                ParallelDispatcher r2 = this.c;
                int r7 = this.f17041b;
                r2.cancel(r7 + r7);
                return;
            }

            @Override // org.a.d
            public void request(long r8) {
                if (SubscriptionHelper.validate(r8) == false) goto L17;
                AtomicLongArray r0 = this.c.requests;
            L5:
                long r3 = r0.get(this.f17040a);
                if (r3 == Long.MAX_VALUE) goto L7;
                long r5 = io.reactivex.internal.util.b.a(r3, r8);
                if (r0.compareAndSet(this.f17040a, r3, r5) == false) goto L5;
                if (this.c.subscriberCount.get() != this.f17041b) goto L18;
                this.c.drain();
                return;
            L18:
                return;
            L7:
                return;
            }
        }

        ParallelDispatcher(c<? super T>[] r4, int r5) {
            this.subscriberCount = new AtomicInteger();
            this.subscribers = r4;
            this.prefetch = r5;
            this.limit = r5 - (r5 >> 2);
            int r6 = r4.length;
            int r0 = r6 + r6;
            AtomicLongArray r7 = new AtomicLongArray(r0 + 1);
            this.requests = r7;
            r7.lazySet(r0, r6);
            this.emissions = new long[r6];
        }

        void cancel(int r5) {
            if (this.requests.decrementAndGet(r5) != 0) goto L8;
            this.cancelled = true;
            this.upstream.cancel();
            if (getAndIncrement() != 0) goto L9;
            this.queue.clear();
            return;
        L9:
            return;
        }

        void drain() {
            if (getAndIncrement() == 0) goto L6;
            return;
        L6:
            if (this.sourceMode != 1) goto L8;
            drainSync();
            return;
        L8:
            drainAsync();
        }

        void drainAsync() {
            f<T> r0 = this.queue;
            c<? super T>[] r2 = this.subscribers;
            AtomicLongArray r3 = this.requests;
            long[] r4 = this.emissions;
            int r5 = r4.length;
            int r6 = this.index;
            int r7 = this.produced;
            int r9 = 1;
        L3:
            int r10 = 0;
            int r11 = 0;
        L5:
            if (this.cancelled == true) goto L6;
            boolean r12 = this.done;
            if (r12 == false) goto L16;
            Throwable r13 = this.error;
            if (r13 == null) goto L16;
            r0.clear();
            int r1 = r2.length;
        L13:
            if (r10 >= r1) goto L15;
            r2[r10].onError(r13);
            r10 = r10 + 1;
            goto L13
        L15:
            return;
        L16:
            boolean r14 = r0.isEmpty();
            if (r12 == false) goto L23;
            if (r14 == false) goto L23;
            int r8 = r2.length;
        L20:
            if (r10 >= r8) goto L22;
            r2[r10].onComplete();
            r10 = r10 + 1;
            goto L20
        L22:
            return;
        L23:
            if (r14 == true) goto L46;
            long r15 = r3.get(r6);
            long r16 = r4[r6];
            if (r15 != r16) goto L28;
        L41:
            r11 = r11 + 1;
        L42:
            r6 = r6 + 1;
            if (r6 != r5) goto L45;
            r6 = 0;
        L45:
            if (r11 != r5) goto L5;
        L28:
            if (r3.get(r5 + r6) != 0) goto L41;
            T r17 = r0.poll();     // Catch: Throwable -> L36
            if (r17 == null) goto L46;
            r2[r6].onNext(r17);
            r4[r6] = r16 + 1;
            r7 = r7 + 1;
            if (r7 != this.limit) goto L35;
            this.upstream.request(r7);
            r7 = 0;
        L35:
            r11 = 0;
        L36:
            th = move-exception;
            io.reactivex.exceptions.a.a(th);
            this.upstream.cancel();
            int r18 = r2.length;
        L38:
            if (r10 >= r18) goto L40;
            r2[r10].onError(th);
            r10 = r10 + 1;
            goto L38
        L40:
            return;
        L46:
            int r19 = get();
            if (r19 == r9) goto L48;
            r9 = r19;
            goto L3
        L48:
            this.index = r6;
            this.produced = r7;
            r9 = addAndGet(-r9);
            if (r9 != 0) goto L3;
            return;
        L6:
            r0.clear();
        }

        void drainSync() {
            f<T> r0 = this.queue;
            c<? super T>[] r2 = this.subscribers;
            AtomicLongArray r3 = this.requests;
            long[] r4 = this.emissions;
            int r5 = r4.length;
            int r6 = this.index;
            int r8 = 1;
        L3:
            int r9 = 0;
            int r10 = 0;
        L5:
            if (this.cancelled == true) goto L6;
            if (r0.isEmpty() == true) goto L10;
            long r11 = r3.get(r6);
            long r13 = r4[r6];
            if (r11 != r13) goto L17;
        L30:
            r10 = r10 + 1;
        L31:
            r6 = r6 + 1;
            if (r6 != r5) goto L34;
            r6 = 0;
        L34:
            if (r10 != r5) goto L5;
            int r12 = get();
            if (r12 == r8) goto L37;
            r8 = r12;
            goto L3
        L37:
            this.index = r6;
            r8 = addAndGet(-r8);
            if (r8 != 0) goto L3;
            return;
        L17:
            if (r3.get(r5 + r6) != 0) goto L30;
            T r14 = r0.poll();     // Catch: Throwable -> L25
            if (r14 == null) goto L20;
            r2[r6].onNext(r14);
            r4[r6] = r13 + 1;
            r10 = 0;
            goto L31
        L20:
            int r1 = r2.length;
        L21:
            if (r9 >= r1) goto L23;
            r2[r9].onComplete();
            r9 = r9 + 1;
            goto L21
        L23:
            return;
        L25:
            th = move-exception;
            io.reactivex.exceptions.a.a(th);
            this.upstream.cancel();
            int r7 = r2.length;
        L27:
            if (r9 >= r7) goto L29;
            r2[r9].onError(th);
            r9 = r9 + 1;
            goto L27
        L29:
            return;
        L10:
            int r15 = r2.length;
        L11:
            if (r9 >= r15) goto L13;
            r2[r9].onComplete();
            r9 = r9 + 1;
            goto L11
        L13:
            return;
        L6:
            r0.clear();
        }

        @Override // org.a.c
        public void onComplete() {
            this.done = true;
            drain();
        }

        @Override // org.a.c
        public void onError(Throwable r1) {
            this.error = r1;
            this.done = true;
            drain();
        }

        @Override // org.a.c
        public void onNext(T r2) {
            if (this.sourceMode == 0) goto L5;
        L8:
            drain();
            return;
        L5:
            if (this.queue.offer(r2) == true) goto L8;
            this.upstream.cancel();
            onError(new MissingBackpressureException("Queue is full?"));
        }

        @Override // io.reactivex.j, org.a.c
        public void onSubscribe(d r4) {
            d r5 = (d) ZeusTransformUtils.wrapperContextForParams(r4, d.class, "com.obric.memorydata.plugin");
            if (SubscriptionHelper.validate(this.upstream, r5) == false) goto L16;
            this.upstream = r5;
            if (ZeusTransformUtils.instanceOf(r5, io.reactivex.internal.a.d.class) == false) goto L14;
            io.reactivex.internal.a.d r0 = (io.reactivex.internal.a.d) ZeusTransformUtils.preCheckCast(r5, io.reactivex.internal.a.d.class, "com.obric.memorydata.plugin");
            int r1 = r0.requestFusion(7);
            if (r1 != 1) goto L11;
            this.sourceMode = r1;
            this.queue = r0;
            this.done = true;
            setupSubscribers();
            drain();
            return;
        L11:
            if (r1 != 2) goto L14;
            this.sourceMode = r1;
            this.queue = r0;
            setupSubscribers();
            r5.request(this.prefetch);
            return;
        L14:
            this.queue = new SpscArrayQueue(this.prefetch);
            setupSubscribers();
            r5.request(this.prefetch);
            return;
        }

        void setupSubscribers() {
            c<? super T>[] r0 = this.subscribers;
            int r1 = r0.length;
            int r2 = 0;
        L3:
            if (r2 >= r1) goto L8;
            if (this.cancelled == true) goto L6;
            int r4 = r2 + 1;
            this.subscriberCount.lazySet(r4);
            r0[r2].onSubscribe(new a(this, r2, r1));
            r2 = r4;
            goto L3
        L6:
            return;
        }
    }

    @Override // io.reactivex.parallel.a
    public int a() {
        return this.f17039b;
    }

    @Override // io.reactivex.parallel.a
    public void a(c<? super T>[] r3) {
        if (b(r3) == true) goto L5;
        return;
    L5:
        this.f17038a.subscribe(new ParallelDispatcher(r3, this.c));
    }
}
