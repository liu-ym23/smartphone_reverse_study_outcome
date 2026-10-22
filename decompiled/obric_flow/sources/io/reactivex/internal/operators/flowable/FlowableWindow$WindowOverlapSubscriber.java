package io.reactivex.internal.operators.flowable;

import com.lynx.tasm.behavior.v0;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: loaded from: classes3.dex */
final class FlowableWindow$WindowOverlapSubscriber<T> extends AtomicInteger implements mt.g, zu.d, Runnable {
    private static final long serialVersionUID = 2428527070996323976L;
    final int bufferSize;
    volatile boolean cancelled;
    volatile boolean done;
    final zu.c downstream;
    Throwable error;
    final AtomicBoolean firstRequest;
    long index;
    final AtomicBoolean once;
    long produced;
    final io.reactivex.internal.queue.b queue;
    final AtomicLong requested;
    final long size;
    final long skip;
    zu.d upstream;
    final ArrayDeque<io.reactivex.processors.g> windows;
    final AtomicInteger wip;

    public FlowableWindow$WindowOverlapSubscriber(zu.c r5, long r10, long r11, int r12) {
        super(1);
        this.downstream = r5;
        this.size = r10;
        this.skip = r11;
        this.queue = new io.reactivex.internal.queue.b(r12);
        this.windows = new ArrayDeque();
        this.once = new AtomicBoolean();
        this.firstRequest = new AtomicBoolean();
        this.requested = new AtomicLong();
        this.wip = new AtomicInteger();
        this.bufferSize = r12;
    }

    @Override // zu.d
    public void cancel() {
        this.cancelled = true;
        if (this.once.compareAndSet(false, true) == false) goto L6;
        run();
        return;
    }

    public boolean checkTerminated(boolean r5, boolean r10, zu.c r11, io.reactivex.internal.queue.b r12) {
        if (this.cancelled == false) goto L6;
        r12.clear();
        return true;
    L6:
        if (r5 == false) goto L14;
        Throwable r13 = this.error;
        if (r13 == null) goto L11;
        r12.clear();
        r11.onError(r13);
        return true;
    L11:
        if (r10 == false) goto L16;
        r11.onComplete();
        return true;
    L16:
        return false;
    L14:
        return false;
    }

    public void drain() {
        if (this.wip.getAndIncrement() == 0) goto L5;
        return;
    L5:
        zu.c r5 = this.downstream;
        io.reactivex.internal.queue.b r10 = this.queue;
        int r11 = 1;
    L6:
        long r12 = this.requested.get();
        long r13 = 0;
    L8:
        if (r13 == r12) goto L19;
        boolean r14 = this.done;
        io.reactivex.processors.g r15 = (io.reactivex.processors.g) r10.poll();
        if (r15 != null) goto L12;
        boolean r16 = true;
    L14:
        if (checkTerminated(r14, r16, r5, r10) == true) goto L15;
        if (r16 == true) goto L19;
        r5.onNext(r15);
        r13 = r13 + 1;
        goto L8
    L15:
        return;
    L12:
        r16 = false;
    L19:
        if (r13 != r12) goto L24;
        if (checkTerminated(this.done, r10.isEmpty(), r5, r10) == false) goto L24;
        return;
    L24:
        if (r13 != 0) goto L26;
    L28:
        r11 = this.wip.addAndGet(-r11);
        if (r11 != 0) goto L6;
        return;
    L26:
        if (r12 == Long.MAX_VALUE) goto L28;
        this.requested.addAndGet(-r13);
        goto L28
    }

    @Override // zu.c
    public void onComplete() {
        if (this.done == false) goto L5;
        return;
    L5:
        Iterator<io.reactivex.processors.g> r5 = this.windows.iterator();
    L7:
        if (r5.hasNext() == false) goto L9;
        r5.next().onComplete();
        goto L7
    L9:
        this.windows.clear();
        this.done = true;
        drain();
    }

    @Override // zu.c
    public void onError(Throwable r5) {
        if (this.done == false) goto L6;
        wn.f.k(r5);
        return;
    L6:
        Iterator<io.reactivex.processors.g> r10 = this.windows.iterator();
    L8:
        if (r10.hasNext() == false) goto L10;
        r10.next().onError(r5);
        goto L8
    L10:
        this.windows.clear();
        this.error = r5;
        this.done = true;
        drain();
    }

    @Override // zu.c
    public void onNext(T r10) {
        if (this.done == false) goto L5;
        return;
    L5:
        long r5 = this.index;
        if (r5 == 0) goto L8;
    L10:
        long r11 = r5 + 1;
        Iterator<io.reactivex.processors.g> r12 = this.windows.iterator();
    L12:
        if (r12.hasNext() == false) goto L14;
        r12.next().onNext(r10);
        goto L12
    L14:
        long r13 = this.produced + 1;
        if (r13 != this.size) goto L19;
        this.produced = r13 - this.skip;
        io.reactivex.processors.g r14 = this.windows.poll();
        if (r14 == null) goto L21;
        r14.onComplete();
    L21:
        if (r11 != this.skip) goto L23;
        this.index = 0;
        return;
    L23:
        this.index = r11;
        return;
    L19:
        this.produced = r13;
        goto L21
    L8:
        if (this.cancelled == true) goto L10;
        getAndIncrement();
        io.reactivex.processors.g r15 = new io.reactivex.processors.g(this, this.bufferSize);
        this.windows.offer(r15);
        this.queue.offer(r15);
        drain();
        goto L10
    }

    @Override // zu.c
    public void onSubscribe(zu.d r5) {
        if (SubscriptionHelper.validate(this.upstream, r5) == false) goto L6;
        this.upstream = r5;
        this.downstream.onSubscribe(this);
        return;
    }

    @Override // zu.d
    public void request(long r5) {
        if (SubscriptionHelper.validate(r5) == false) goto L12;
        v0.r(this.requested, r5);
        if (this.firstRequest.get() == false) goto L7;
    L9:
        long r10 = v0.x(this.skip, r5);
        this.upstream.request(r10);
    L10:
        drain();
        return;
    L7:
        if (this.firstRequest.compareAndSet(false, true) == false) goto L9;
        long r11 = v0.x(this.skip, r5 - 1);
        long r12 = v0.t(this.size, r11);
        this.upstream.request(r12);
        goto L10
    }

    @Override // java.lang.Runnable
    public void run() {
        if (decrementAndGet() != 0) goto L6;
        this.upstream.cancel();
        return;
    }
}
