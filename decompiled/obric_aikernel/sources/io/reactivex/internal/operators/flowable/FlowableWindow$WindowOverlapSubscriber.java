package io.reactivex.internal.operators.flowable;

import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.processors.UnicastProcessor;
import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: loaded from: classes2.dex */
final class FlowableWindow$WindowOverlapSubscriber<T> extends AtomicInteger implements xb.g<T>, tc.d, Runnable {
    private static final long serialVersionUID = 2428527070996323976L;
    final int bufferSize;
    volatile boolean cancelled;
    volatile boolean done;
    final tc.c<? super xb.e<T>> downstream;
    Throwable error;
    final AtomicBoolean firstRequest;
    long index;
    final AtomicBoolean once;
    long produced;
    final io.reactivex.internal.queue.a<UnicastProcessor<T>> queue;
    final AtomicLong requested;
    final long size;
    final long skip;
    tc.d upstream;
    final ArrayDeque<UnicastProcessor<T>> windows;
    final AtomicInteger wip;

    FlowableWindow$WindowOverlapSubscriber(tc.c<? super xb.e<T>> r10, long r11, long r12, int r13) {
        super(1);
        this.downstream = r10;
        this.size = r11;
        this.skip = r12;
        this.queue = new io.reactivex.internal.queue.a(r13);
        this.windows = new ArrayDeque();
        this.once = new AtomicBoolean();
        this.firstRequest = new AtomicBoolean();
        this.requested = new AtomicLong();
        this.wip = new AtomicInteger();
        this.bufferSize = r13;
    }

    @Override // tc.d
    public void cancel() {
        this.cancelled = true;
        if (this.once.compareAndSet(false, true) == false) goto L6;
        run();
        return;
    }

    boolean checkTerminated(boolean r10, boolean r11, tc.c<?> r12, io.reactivex.internal.queue.a<?> r13) {
        if (this.cancelled == false) goto L6;
        r13.clear();
        return true;
    L6:
        if (r10 == false) goto L14;
        Throwable r14 = this.error;
        if (r14 == null) goto L11;
        r13.clear();
        r12.onError(r14);
        return true;
    L11:
        if (r11 == false) goto L16;
        r12.onComplete();
        return true;
    L16:
        return false;
    L14:
        return false;
    }

    void drain() {
        if (this.wip.getAndIncrement() == 0) goto L5;
        return;
    L5:
        tc.c<? super xb.e<T>> r10 = this.downstream;
        io.reactivex.internal.queue.a<UnicastProcessor<T>> r11 = this.queue;
        int r12 = 1;
    L6:
        long r13 = this.requested.get();
        long r14 = 0;
    L8:
        if (r14 == r13) goto L19;
        boolean r15 = this.done;
        UnicastProcessor<T> r16 = r11.poll();
        if (r16 != null) goto L12;
        boolean r17 = true;
    L14:
        if (checkTerminated(r15, r17, r10, r11) == true) goto L15;
        if (r17 == true) goto L19;
        r10.onNext(r16);
        r14 = r14 + 1;
        goto L8
    L15:
        return;
    L12:
        r17 = false;
    L19:
        if (r14 != r13) goto L24;
        if (checkTerminated(this.done, r11.isEmpty(), r10, r11) == false) goto L24;
        return;
    L24:
        if (r14 != 0) goto L26;
    L28:
        r12 = this.wip.addAndGet(-r12);
        if (r12 != 0) goto L6;
        return;
    L26:
        if (r13 == Long.MAX_VALUE) goto L28;
        this.requested.addAndGet(-r14);
        goto L28
    }

    @Override // tc.c
    public void onComplete() {
        if (this.done == false) goto L5;
        return;
    L5:
        Iterator<UnicastProcessor<T>> r10 = this.windows.iterator();
    L7:
        if (r10.hasNext() == false) goto L9;
        r10.next().onComplete();
        goto L7
    L9:
        this.windows.clear();
        this.done = true;
        drain();
    }

    @Override // tc.c
    public void onError(Throwable r10) {
        if (this.done == false) goto L6;
        dc.a.n(r10);
        return;
    L6:
        Iterator<UnicastProcessor<T>> r11 = this.windows.iterator();
    L8:
        if (r11.hasNext() == false) goto L10;
        r11.next().onError(r10);
        goto L8
    L10:
        this.windows.clear();
        this.error = r10;
        this.done = true;
        drain();
    }

    @Override // tc.c
    public void onNext(T r10) {
        if (this.done == false) goto L5;
        return;
    L5:
        long r11 = this.index;
        if (r11 == 0) goto L8;
    L10:
        long r12 = r11 + 1;
        Iterator<UnicastProcessor<T>> r13 = this.windows.iterator();
    L12:
        if (r13.hasNext() == false) goto L14;
        r13.next().onNext(r10);
        goto L12
    L14:
        long r14 = this.produced + 1;
        if (r14 != this.size) goto L19;
        this.produced = r14 - this.skip;
        UnicastProcessor<T> r15 = this.windows.poll();
        if (r15 == null) goto L21;
        r15.onComplete();
    L21:
        if (r12 != this.skip) goto L23;
        this.index = 0;
        return;
    L23:
        this.index = r12;
        return;
    L19:
        this.produced = r14;
        goto L21
    L8:
        if (this.cancelled == true) goto L10;
        getAndIncrement();
        UnicastProcessor<T> r16 = UnicastProcessor.f(this.bufferSize, this);
        this.windows.offer(r16);
        this.queue.offer(r16);
        drain();
        goto L10
    }

    @Override // xb.g, tc.c
    public void onSubscribe(tc.d r10) {
        if (SubscriptionHelper.validate(this.upstream, r10) == false) goto L6;
        this.upstream = r10;
        this.downstream.onSubscribe(this);
        return;
    }

    @Override // tc.d
    public void request(long r10) {
        if (SubscriptionHelper.validate(r10) == false) goto L12;
        io.reactivex.internal.util.b.a(this.requested, r10);
        if (this.firstRequest.get() == false) goto L7;
    L9:
        long r11 = io.reactivex.internal.util.b.d(this.skip, r10);
    L10:
        this.upstream.request(r11);
        drain();
        return;
    L7:
        if (this.firstRequest.compareAndSet(false, true) == false) goto L9;
        long r12 = io.reactivex.internal.util.b.d(this.skip, r10 - 1);
        r11 = io.reactivex.internal.util.b.c(this.size, r12);
        goto L10
    }

    @Override // java.lang.Runnable
    public void run() {
        if (decrementAndGet() != 0) goto L6;
        this.upstream.cancel();
        return;
    }
}
