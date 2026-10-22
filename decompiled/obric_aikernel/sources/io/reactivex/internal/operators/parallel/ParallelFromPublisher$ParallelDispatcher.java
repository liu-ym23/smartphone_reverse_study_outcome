package io.reactivex.internal.operators.parallel;

import bc.f;
import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.internal.queue.SpscArrayQueue;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.b;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLongArray;
import org.reactivestreams.Subscriber;
import tc.c;
import tc.d;
import xb.g;

/* JADX INFO: loaded from: classes2.dex */
final class ParallelFromPublisher$ParallelDispatcher<T> extends AtomicInteger implements g<T> {
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
    final Subscriber<? super T>[] subscribers;
    d upstream;

    final class a implements d {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final int f9589c;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final int f9590g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        final /* synthetic */ ParallelFromPublisher$ParallelDispatcher f9591h;

        a(ParallelFromPublisher$ParallelDispatcher r10, int r11, int r12) {
            this.f9591h = r10;
            this.f9589c = r11;
            this.f9590g = r12;
        }

        @Override // tc.d
        public void cancel() {
            AtomicLongArray r10 = this.f9591h.requests;
            int r11 = this.f9590g;
            if (r10.compareAndSet(this.f9589c + r11, 0, 1) == false) goto L6;
            ParallelFromPublisher$ParallelDispatcher r12 = this.f9591h;
            int r13 = this.f9590g;
            r12.cancel(r13 + r13);
            return;
        }

        @Override // tc.d
        public void request(long r10) {
            if (SubscriptionHelper.validate(r10) == false) goto L17;
            AtomicLongArray r11 = this.f9591h.requests;
        L5:
            long r12 = r11.get(this.f9589c);
            if (r12 == Long.MAX_VALUE) goto L7;
            long r13 = b.c(r12, r10);
            if (r11.compareAndSet(this.f9589c, r12, r13) == false) goto L5;
            if (this.f9591h.subscriberCount.get() != this.f9590g) goto L18;
            this.f9591h.drain();
            return;
        L18:
            return;
        L7:
            return;
        }
    }

    ParallelFromPublisher$ParallelDispatcher(Subscriber<? super T>[] r10, int r11) {
        this.subscriberCount = new AtomicInteger();
        this.subscribers = r10;
        this.prefetch = r11;
        this.limit = r11 - (r11 >> 2);
        int r12 = r10.length;
        int r13 = r12 + r12;
        AtomicLongArray r14 = new AtomicLongArray(r13 + 1);
        this.requests = r14;
        r14.lazySet(r13, r12);
        this.emissions = new long[r12];
    }

    void cancel(int r10) {
        if (this.requests.decrementAndGet(r10) != 0) goto L8;
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
        f<T> r10 = this.queue;
        c[] r11 = this.subscribers;
        AtomicLongArray r12 = this.requests;
        long[] r13 = this.emissions;
        int r14 = r13.length;
        int r15 = this.index;
        int r16 = this.produced;
        int r17 = 1;
    L3:
        int r18 = 0;
        int r19 = 0;
    L5:
        if (this.cancelled == true) goto L6;
        boolean r110 = this.done;
        if (r110 == false) goto L16;
        Throwable r111 = this.error;
        if (r111 == null) goto L16;
        r10.clear();
        int r20 = r11.length;
    L13:
        if (r18 >= r20) goto L15;
        r11[r18].onError(r111);
        r18 = r18 + 1;
        goto L13
    L15:
        return;
    L16:
        boolean r112 = r10.isEmpty();
        if (r110 == false) goto L23;
        if (r112 == false) goto L23;
        int r21 = r11.length;
    L20:
        if (r18 >= r21) goto L22;
        r11[r18].onComplete();
        r18 = r18 + 1;
        goto L20
    L22:
        return;
    L23:
        if (r112 == true) goto L46;
        long r113 = r12.get(r15);
        long r114 = r13[r15];
        if (r113 != r114) goto L28;
    L41:
        r19 = r19 + 1;
    L42:
        r15 = r15 + 1;
        if (r15 != r14) goto L45;
        r15 = 0;
    L45:
        if (r19 != r14) goto L5;
    L28:
        if (r12.get(r14 + r15) != 0) goto L41;
        T r115 = r10.poll();     // Catch: Throwable -> L36
        if (r115 == null) goto L46;
        r11[r15].onNext(r115);
        r13[r15] = r114 + 1;
        r16 = r16 + 1;
        if (r16 != this.limit) goto L35;
        this.upstream.request(r16);
        r16 = 0;
    L35:
        r19 = 0;
    L36:
        th = move-exception;
        io.reactivex.exceptions.a.a(th);
        this.upstream.cancel();
        int r22 = r11.length;
    L38:
        if (r18 >= r22) goto L40;
        r11[r18].onError(th);
        r18 = r18 + 1;
        goto L38
    L40:
        return;
    L46:
        int r116 = get();
        if (r116 == r17) goto L48;
        r17 = r116;
        goto L3
    L48:
        this.index = r15;
        this.produced = r16;
        r17 = addAndGet(-r17);
        if (r17 != 0) goto L3;
        return;
    L6:
        r10.clear();
    }

    void drainSync() {
        f<T> r10 = this.queue;
        c[] r11 = this.subscribers;
        AtomicLongArray r12 = this.requests;
        long[] r13 = this.emissions;
        int r14 = r13.length;
        int r15 = this.index;
        int r16 = 1;
    L3:
        int r17 = 0;
        int r18 = 0;
    L5:
        if (this.cancelled == true) goto L6;
        if (r10.isEmpty() == true) goto L10;
        long r19 = r12.get(r15);
        long r110 = r13[r15];
        if (r19 != r110) goto L17;
    L30:
        r18 = r18 + 1;
    L31:
        r15 = r15 + 1;
        if (r15 != r14) goto L34;
        r15 = 0;
    L34:
        if (r18 != r14) goto L5;
        int r20 = get();
        if (r20 == r16) goto L37;
        r16 = r20;
        goto L3
    L37:
        this.index = r15;
        r16 = addAndGet(-r16);
        if (r16 != 0) goto L3;
        return;
    L17:
        if (r12.get(r14 + r15) != 0) goto L30;
        T r111 = r10.poll();     // Catch: Throwable -> L25
        if (r111 == null) goto L20;
        r11[r15].onNext(r111);
        r13[r15] = r110 + 1;
        r18 = 0;
        goto L31
    L20:
        int r21 = r11.length;
    L21:
        if (r17 >= r21) goto L23;
        r11[r17].onComplete();
        r17 = r17 + 1;
        goto L21
    L23:
        return;
    L25:
        th = move-exception;
        io.reactivex.exceptions.a.a(th);
        this.upstream.cancel();
        int r22 = r11.length;
    L27:
        if (r17 >= r22) goto L29;
        r11[r17].onError(th);
        r17 = r17 + 1;
        goto L27
    L29:
        return;
    L10:
        int r23 = r11.length;
    L11:
        if (r17 >= r23) goto L13;
        r11[r17].onComplete();
        r17 = r17 + 1;
        goto L11
    L13:
        return;
    L6:
        r10.clear();
    }

    @Override // tc.c
    public void onComplete() {
        this.done = true;
        drain();
    }

    @Override // tc.c
    public void onError(Throwable r10) {
        this.error = r10;
        this.done = true;
        drain();
    }

    @Override // tc.c
    public void onNext(T r10) {
        if (this.sourceMode == 0) goto L5;
    L8:
        drain();
        return;
    L5:
        if (this.queue.offer(r10) == true) goto L8;
        this.upstream.cancel();
        onError(new MissingBackpressureException("Queue is full?"));
    }

    @Override // xb.g, tc.c
    public void onSubscribe(d r10) {
        if (SubscriptionHelper.validate(this.upstream, r10) == false) goto L16;
        this.upstream = r10;
        if ((r10 instanceof bc.d) == false) goto L14;
        bc.d r11 = (bc.d) r10;
        int r12 = r11.requestFusion(7);
        if (r12 != 1) goto L11;
        this.sourceMode = r12;
        this.queue = r11;
        this.done = true;
        setupSubscribers();
        drain();
        return;
    L11:
        if (r12 != 2) goto L14;
        this.sourceMode = r12;
        this.queue = r11;
        setupSubscribers();
        r10.request(this.prefetch);
        return;
    L14:
        this.queue = new SpscArrayQueue(this.prefetch);
        setupSubscribers();
        r10.request(this.prefetch);
        return;
    }

    void setupSubscribers() {
        c[] r10 = this.subscribers;
        int r11 = r10.length;
        int r12 = 0;
    L3:
        if (r12 >= r11) goto L8;
        if (this.cancelled == true) goto L6;
        int r13 = r12 + 1;
        this.subscriberCount.lazySet(r13);
        r10[r12].onSubscribe(new a(this, r12, r11));
        r12 = r13;
        goto L3
    L6:
        return;
    }
}
