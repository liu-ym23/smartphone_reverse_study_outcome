package io.reactivex.internal.operators.flowable;

import com.lynx.tasm.behavior.v0;
import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.internal.queue.SpscArrayQueue;
import io.reactivex.internal.subscriptions.BasicIntQueueSubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes3.dex */
final class FlowableFlattenIterable$FlattenIterableSubscriber<T, R> extends BasicIntQueueSubscription<R> implements mt.g {
    private static final long serialVersionUID = -3096000382929934955L;
    volatile boolean cancelled;
    int consumed;
    Iterator<? extends R> current;
    volatile boolean done;
    final zu.c downstream;
    final AtomicReference<Throwable> error;
    int fusionMode;
    final int limit;
    final pt.o mapper;
    final int prefetch;
    rt.h queue;
    final AtomicLong requested;
    zu.d upstream;

    public FlowableFlattenIterable$FlattenIterableSubscriber(zu.c r5, pt.o r10, int r11) {
        this.downstream = r5;
        this.mapper = r10;
        this.prefetch = r11;
        this.limit = r11 - (r11 >> 2);
        this.error = new AtomicReference();
        this.requested = new AtomicLong();
    }

    @Override // io.reactivex.internal.subscriptions.BasicIntQueueSubscription, zu.d
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

    public boolean checkTerminated(boolean r5, boolean r10, zu.c r11, rt.h r12) {
        if (this.cancelled == false) goto L6;
        this.current = null;
        r12.clear();
        return true;
    L6:
        if (r5 == true) goto L8;
        return false;
    L8:
        if (this.error.get() == null) goto L11;
        Throwable r13 = io.reactivex.internal.util.d.b(this.error);
        this.current = null;
        r12.clear();
        r11.onError(r13);
        return true;
    L11:
        if (r10 == false) goto L16;
        r11.onComplete();
        return true;
    L16:
        return false;
    }

    @Override // io.reactivex.internal.subscriptions.BasicIntQueueSubscription, rt.h
    public void clear() {
        this.current = null;
        this.queue.clear();
    }

    public void consumedOne(boolean r5) {
        if (r5 == false) goto L8;
        int r10 = this.consumed + 1;
        if (r10 != this.limit) goto L6;
        this.consumed = 0;
        this.upstream.request(r10);
        return;
    L6:
        this.consumed = r10;
        return;
    }

    public void drain() {
        if (getAndIncrement() == 0) goto L5;
        return;
    L5:
        zu.c r5 = this.downstream;
        rt.h r10 = this.queue;
        boolean r11 = true;
        if (this.fusionMode == 1) goto L8;
        boolean r12 = true;
    L9:
        Iterator<? extends R> r13 = this.current;
        int r14 = 1;
    L11:
        if (r13 != null) goto L31;
        boolean r15 = this.done;
        Object r16 = r10.poll();     // Catch: Throwable -> L28
        if (r16 != null) goto L16;
        boolean r17 = r11;
    L18:
        if (checkTerminated(r15, r17, r5, r10) == true) goto L19;
        if (r16 == null) goto L31;
        r13 = ((Iterable) this.mapper.apply(r16)).iterator();     // Catch: Throwable -> L25
        if (r13.hasNext() == false) goto L23;
        this.current = r13;
        goto L31
    L23:
        consumedOne(r12);
        r13 = null;
    L25:
        th = move-exception;
        com.lynx.jsbridge.a.t(th);
        this.upstream.cancel();
        io.reactivex.internal.util.d.a(this.error, th);
        r5.onError(io.reactivex.internal.util.d.b(this.error));
        return;
    L19:
        return;
    L16:
        r17 = false;
    L28:
        th = move-exception;
        com.lynx.jsbridge.a.t(th);
        this.upstream.cancel();
        io.reactivex.internal.util.d.a(this.error, th);
        Throwable r18 = io.reactivex.internal.util.d.b(this.error);
        this.current = null;
        r10.clear();
        r5.onError(r18);
        return;
    L31:
        if (r13 == null) goto L70;
        long r19 = this.requested.get();
        long r110 = 0;
    L34:
        if (r110 == r19) goto L54;
        if (checkTerminated(this.done, false, r5, r10) == true) goto L37;
        R r111 = r13.next();     // Catch: Throwable -> L50
        io.reactivex.internal.functions.e.d(r111, "The iterator returned a null value");     // Catch: Throwable -> L50
        r5.onNext(r111);
        if (checkTerminated(this.done, false, r5, r10) == true) goto L41;
        r110 = r110 + 1;
        if (r13.hasNext() == true) goto L34;
        consumedOne(r12);
        this.current = null;
        r13 = null;
    L47:
        th = move-exception;
        com.lynx.jsbridge.a.t(th);
        this.current = null;
        this.upstream.cancel();
        io.reactivex.internal.util.d.a(this.error, th);
        r5.onError(io.reactivex.internal.util.d.b(this.error));
        return;
    L41:
        return;
    L50:
        th = move-exception;
        com.lynx.jsbridge.a.t(th);
        this.current = null;
        this.upstream.cancel();
        io.reactivex.internal.util.d.a(this.error, th);
        r5.onError(io.reactivex.internal.util.d.b(this.error));
        return;
    L37:
        return;
    L54:
        if (r110 != r19) goto L64;
        boolean r20 = this.done;
        if (r10.isEmpty() == false) goto L59;
        if (r13 != null) goto L59;
        boolean r21 = true;
    L61:
        if (checkTerminated(r20, r21, r5, r10) == false) goto L64;
        return;
    L59:
        r21 = false;
    L64:
        if (r110 != 0) goto L66;
    L68:
        if (r13 != null) goto L70;
    L69:
        r11 = true;
        goto L11
    L66:
        if (r19 == Long.MAX_VALUE) goto L68;
        this.requested.addAndGet(-r110);
    L70:
        r14 = addAndGet(-r14);
        if (r14 != 0) goto L69;
        return;
    L8:
        r12 = false;
        goto L9
    }

    @Override // io.reactivex.internal.subscriptions.BasicIntQueueSubscription, rt.h
    public boolean isEmpty() {
        if (this.current == null) goto L5;
    L7:
        return false;
    L5:
        if (this.queue.isEmpty() == false) goto L7;
        return true;
    }

    @Override // zu.c
    public void onComplete() {
        if (this.done == false) goto L5;
        return;
    L5:
        this.done = true;
        drain();
    }

    @Override // zu.c
    public void onError(Throwable r5) {
        if (this.done == false) goto L5;
    L7:
        wn.f.k(r5);
        return;
    L5:
        if (io.reactivex.internal.util.d.a(this.error, r5) == false) goto L7;
        this.done = true;
        drain();
    }

    @Override // zu.c
    public void onNext(T r5) {
        if (this.done == false) goto L6;
        return;
    L6:
        if (this.fusionMode == 0) goto L8;
    L11:
        drain();
        return;
    L8:
        if (this.queue.offer(r5) == true) goto L11;
        onError(new MissingBackpressureException("Queue is full?!"));
    }

    @Override // zu.c
    public void onSubscribe(zu.d r5) {
        if (SubscriptionHelper.validate(this.upstream, r5) == false) goto L16;
        this.upstream = r5;
        if ((r5 instanceof rt.e) == false) goto L14;
        rt.e r10 = (rt.e) r5;
        int r11 = r10.requestFusion(3);
        if (r11 != 1) goto L11;
        this.fusionMode = r11;
        this.queue = r10;
        this.done = true;
        this.downstream.onSubscribe(this);
        return;
    L11:
        if (r11 != 2) goto L14;
        this.fusionMode = r11;
        this.queue = r10;
        this.downstream.onSubscribe(this);
        r5.request(this.prefetch);
        return;
    L14:
        this.queue = new SpscArrayQueue(this.prefetch);
        this.downstream.onSubscribe(this);
        r5.request(this.prefetch);
        return;
    }

    @Override // io.reactivex.internal.subscriptions.BasicIntQueueSubscription, rt.h
    public R poll() throws Exception {
        Iterator<? extends R> r5 = this.current;
    L4:
        if (r5 != null) goto L12;
        Object r10 = this.queue.poll();
        if (r10 == null) goto L7;
        r5 = ((Iterable) this.mapper.apply(r10)).iterator();
        if (r5.hasNext() == true) goto L11;
        r5 = null;
        goto L4
    L11:
        this.current = r5;
        goto L12
    L7:
        return null;
    L12:
        R r11 = r5.next();
        io.reactivex.internal.functions.e.d(r11, "The iterator returned a null value");
        if (r5.hasNext() == true) goto L15;
        this.current = null;
    L15:
        return r11;
    }

    @Override // io.reactivex.internal.subscriptions.BasicIntQueueSubscription, zu.d
    public void request(long r5) {
        if (SubscriptionHelper.validate(r5) == false) goto L6;
        v0.r(this.requested, r5);
        drain();
        return;
    }

    @Override // io.reactivex.internal.subscriptions.BasicIntQueueSubscription, rt.d
    public int requestFusion(int r5) {
        if ((r5 & 1) != 0) goto L5;
        return 0;
    L5:
        if (this.fusionMode != 1) goto L9;
        return 1;
    L9:
        return 0;
    }
}
