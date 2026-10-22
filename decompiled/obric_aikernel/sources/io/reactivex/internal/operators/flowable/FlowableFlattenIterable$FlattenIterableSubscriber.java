package io.reactivex.internal.operators.flowable;

import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.internal.queue.SpscArrayQueue;
import io.reactivex.internal.subscriptions.BasicIntQueueSubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.ExceptionHelper;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes2.dex */
final class FlowableFlattenIterable$FlattenIterableSubscriber<T, R> extends BasicIntQueueSubscription<R> implements xb.g<T> {
    private static final long serialVersionUID = -3096000382929934955L;
    volatile boolean cancelled;
    int consumed;
    Iterator<? extends R> current;
    volatile boolean done;
    final tc.c<? super R> downstream;
    final AtomicReference<Throwable> error;
    int fusionMode;
    final int limit;
    final zb.h<? super T, ? extends Iterable<? extends R>> mapper;
    final int prefetch;
    bc.f<T> queue;
    final AtomicLong requested;
    tc.d upstream;

    FlowableFlattenIterable$FlattenIterableSubscriber(tc.c<? super R> r10, zb.h<? super T, ? extends Iterable<? extends R>> r11, int r12) {
        this.downstream = r10;
        this.mapper = r11;
        this.prefetch = r12;
        this.limit = r12 - (r12 >> 2);
        this.error = new AtomicReference();
        this.requested = new AtomicLong();
    }

    @Override // io.reactivex.internal.subscriptions.BasicIntQueueSubscription, tc.d
    public void cancel() {
        if (this.cancelled == true) goto L8;
        this.cancelled = true;
        this.upstream.cancel();
        if (getAndIncrement() != 0) goto L9;
        this.queue.clear();
        return;
    L9:
        return;
    }

    boolean checkTerminated(boolean r10, boolean r11, tc.c<?> r12, bc.f<?> r13) {
        if (this.cancelled == false) goto L6;
        this.current = null;
        r13.clear();
        return true;
    L6:
        if (r10 == true) goto L8;
        return false;
    L8:
        if (this.error.get() == null) goto L11;
        Throwable r14 = ExceptionHelper.b(this.error);
        this.current = null;
        r13.clear();
        r12.onError(r14);
        return true;
    L11:
        if (r11 == false) goto L16;
        r12.onComplete();
        return true;
    L16:
        return false;
    }

    @Override // io.reactivex.internal.subscriptions.BasicIntQueueSubscription, bc.f
    public void clear() {
        this.current = null;
        this.queue.clear();
    }

    void consumedOne(boolean r10) {
        if (r10 == false) goto L8;
        int r11 = this.consumed + 1;
        if (r11 != this.limit) goto L6;
        this.consumed = 0;
        this.upstream.request(r11);
        return;
    L6:
        this.consumed = r11;
        return;
    }

    void drain() {
        if (getAndIncrement() == 0) goto L5;
        return;
    L5:
        tc.c<?> r10 = this.downstream;
        bc.f<T> r11 = this.queue;
        boolean r12 = true;
        if (this.fusionMode == 1) goto L8;
        boolean r13 = true;
    L9:
        Iterator<? extends R> r14 = this.current;
        int r15 = 1;
    L10:
        if (r14 != null) goto L32;
        boolean r16 = this.done;
        T r17 = r11.poll();     // Catch: Throwable -> L30
        if (r17 != null) goto L15;
        boolean r18 = r12;
    L17:
        if (checkTerminated(r16, r18, r10, r11) == true) goto L18;
        if (r17 == null) goto L32;
        r14 = this.mapper.apply(r17).iterator();     // Catch: Throwable -> L24
        if (r14.hasNext() == false) goto L22;
        this.current = r14;
        goto L32
    L22:
        consumedOne(r13);
        r14 = null;
    L24:
        Throwable th = th;
        io.reactivex.exceptions.a.a(th);
    L26:
        this.upstream.cancel();
        ExceptionHelper.a(this.error, th);
    L27:
        Throwable r19 = ExceptionHelper.b(this.error);
    L28:
        r10.onError(r19);
        return;
    L18:
        return;
    L15:
        r18 = false;
    L30:
        th = move-exception;
        io.reactivex.exceptions.a.a(th);
        this.upstream.cancel();
        ExceptionHelper.a(this.error, th);
        r19 = ExceptionHelper.b(this.error);
        this.current = null;
        r11.clear();
    L32:
        if (r14 == null) goto L69;
        long r20 = this.requested.get();
        long r110 = 0;
    L35:
        if (r110 == r20) goto L53;
        if (checkTerminated(this.done, false, r10, r11) == true) goto L38;
        r10.onNext((Object) io.reactivex.internal.functions.a.d(r14.next(), "The iterator returned a null value"));
        if (checkTerminated(this.done, false, r10, r11) == true) goto L42;
        r110 = r110 + 1;
        if (r14.hasNext() == true) goto L35;
        consumedOne(r13);
        this.current = null;
        r14 = null;
    L48:
        th = move-exception;
        io.reactivex.exceptions.a.a(th);
        this.current = null;
        this.upstream.cancel();
        ExceptionHelper.a(this.error, th);
        goto L27
    L42:
        return;
    L50:
        th = th;
        io.reactivex.exceptions.a.a(th);
        this.current = null;
        goto L26
    L38:
        return;
    L53:
        if (r110 != r20) goto L63;
        boolean r21 = this.done;
        if (r11.isEmpty() == false) goto L58;
        if (r14 != null) goto L58;
        boolean r111 = true;
    L60:
        if (checkTerminated(r21, r111, r10, r11) == false) goto L63;
        return;
    L58:
        r111 = false;
    L63:
        if (r110 != 0) goto L65;
    L67:
        if (r14 != null) goto L69;
    L72:
        r12 = true;
        goto L10
    L65:
        if (r20 == Long.MAX_VALUE) goto L67;
        this.requested.addAndGet(-r110);
    L69:
        r15 = addAndGet(-r15);
        if (r15 != 0) goto L72;
        return;
    L8:
        r13 = false;
        goto L9
    }

    @Override // io.reactivex.internal.subscriptions.BasicIntQueueSubscription, bc.f
    public boolean isEmpty() {
        if (this.current == null) goto L5;
    L7:
        return false;
    L5:
        if (this.queue.isEmpty() == false) goto L7;
        return true;
    }

    @Override // tc.c
    public void onComplete() {
        if (this.done == false) goto L5;
        return;
    L5:
        this.done = true;
        drain();
    }

    @Override // tc.c
    public void onError(Throwable r10) {
        if (this.done == false) goto L5;
    L7:
        dc.a.n(r10);
        return;
    L5:
        if (ExceptionHelper.a(this.error, r10) == false) goto L7;
        this.done = true;
        drain();
    }

    @Override // tc.c
    public void onNext(T r10) {
        if (this.done == false) goto L6;
        return;
    L6:
        if (this.fusionMode == 0) goto L8;
    L11:
        drain();
        return;
    L8:
        if (this.queue.offer(r10) == true) goto L11;
        onError(new MissingBackpressureException("Queue is full?!"));
    }

    @Override // xb.g, tc.c
    public void onSubscribe(tc.d r10) {
        if (SubscriptionHelper.validate(this.upstream, r10) == false) goto L16;
        this.upstream = r10;
        if ((r10 instanceof bc.d) == false) goto L14;
        bc.d r11 = (bc.d) r10;
        int r12 = r11.requestFusion(3);
        if (r12 != 1) goto L11;
        this.fusionMode = r12;
        this.queue = r11;
        this.done = true;
        this.downstream.onSubscribe(this);
        return;
    L11:
        if (r12 != 2) goto L14;
        this.fusionMode = r12;
        this.queue = r11;
        this.downstream.onSubscribe(this);
        r10.request(this.prefetch);
        return;
    L14:
        this.queue = new SpscArrayQueue(this.prefetch);
        this.downstream.onSubscribe(this);
        r10.request(this.prefetch);
        return;
    }

    @Override // io.reactivex.internal.subscriptions.BasicIntQueueSubscription, bc.f
    public R poll() {
        Iterator<? extends R> r10 = this.current;
    L3:
        if (r10 != null) goto L11;
        T r11 = this.queue.poll();
        if (r11 == null) goto L6;
        r10 = this.mapper.apply(r11).iterator();
        if (r10.hasNext() == true) goto L10;
        r10 = null;
        goto L3
    L10:
        this.current = r10;
        goto L11
    L6:
        return null;
    L11:
        R r12 = (R) io.reactivex.internal.functions.a.d(r10.next(), "The iterator returned a null value");
        if (r10.hasNext() == true) goto L14;
        this.current = null;
    L14:
        return r12;
    }

    @Override // io.reactivex.internal.subscriptions.BasicIntQueueSubscription, tc.d
    public void request(long r10) {
        if (SubscriptionHelper.validate(r10) == false) goto L6;
        io.reactivex.internal.util.b.a(this.requested, r10);
        drain();
        return;
    }

    @Override // io.reactivex.internal.subscriptions.BasicIntQueueSubscription, bc.c
    public int requestFusion(int r10) {
        if ((r10 & 1) != 0) goto L5;
        return 0;
    L5:
        if (this.fusionMode != 1) goto L9;
        return 1;
    L9:
        return 0;
    }
}
