package io.reactivex.internal.operators.flowable;

import com.lynx.tasm.behavior.v0;
import io.reactivex.internal.subscriptions.BasicIntQueueSubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.Iterator;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: loaded from: classes3.dex */
public final class FlowableGroupBy$GroupBySubscriber<T, K, V> extends BasicIntQueueSubscription<ot.a> implements mt.g {
    static final Object NULL_KEY = null;
    private static final long serialVersionUID = -3688291656102519502L;
    final int bufferSize;
    final AtomicBoolean cancelled;
    final boolean delayError;
    boolean done;
    final zu.c downstream;
    Throwable error;
    final Queue<j> evictedGroups;
    volatile boolean finished;
    final AtomicInteger groupCount;
    final Map<Object, j> groups;
    final pt.o keySelector;
    boolean outputFused;
    final io.reactivex.internal.queue.b queue;
    final AtomicLong requested;
    zu.d upstream;
    final pt.o valueSelector;

    static {
        NULL_KEY = new Object();
    }

    public FlowableGroupBy$GroupBySubscriber(zu.c r5, pt.o r10, pt.o r11, int r12, boolean r13, Map<Object, j> r14, Queue<j> r15) {
        this.cancelled = new AtomicBoolean();
        this.requested = new AtomicLong();
        this.groupCount = new AtomicInteger(1);
        this.downstream = r5;
        this.keySelector = r10;
        this.valueSelector = r11;
        this.bufferSize = r12;
        this.delayError = r13;
        this.groups = r14;
        this.evictedGroups = r15;
        this.queue = new io.reactivex.internal.queue.b(r12);
    }

    public final void a() {
        if (this.evictedGroups == null) goto L12;
        int r5 = 0;
    L5:
        j r10 = this.evictedGroups.poll();
        if (r10 == null) goto L8;
        r10.f17663c.onComplete();
        r5 = r5 + 1;
        goto L5
    L8:
        if (r5 == 0) goto L13;
        this.groupCount.addAndGet(-r5);
        return;
    L13:
        return;
    }

    @Override // io.reactivex.internal.subscriptions.BasicIntQueueSubscription, zu.d
    public void cancel() {
        if (this.cancelled.compareAndSet(false, true) == false) goto L8;
        a();
        if (this.groupCount.decrementAndGet() != 0) goto L9;
        this.upstream.cancel();
        return;
    L9:
        return;
    }

    public boolean checkTerminated(boolean r5, boolean r10, zu.c r11, io.reactivex.internal.queue.b r12) {
        if (this.cancelled.get() == false) goto L7;
        r12.clear();
        return true;
    L7:
        if (this.delayError == false) goto L15;
        if (r5 == false) goto L23;
        if (r10 == false) goto L25;
        Throwable r13 = this.error;
        if (r13 == null) goto L13;
        r11.onError(r13);
    L14:
        return true;
    L13:
        r11.onComplete();
        goto L14
    L25:
        return false;
    L23:
        return false;
    L15:
        if (r5 == false) goto L26;
        Throwable r14 = this.error;
        if (r14 == null) goto L20;
        r12.clear();
        r11.onError(r14);
        return true;
    L20:
        if (r10 == false) goto L27;
        r11.onComplete();
        return true;
    L27:
        return false;
    L26:
        return false;
    }

    @Override // io.reactivex.internal.subscriptions.BasicIntQueueSubscription, rt.h
    public void clear() {
        this.queue.clear();
    }

    public void drain() {
        if (getAndIncrement() == 0) goto L6;
        return;
    L6:
        if (this.outputFused == false) goto L8;
        drainFused();
        return;
    L8:
        drainNormal();
    }

    public void drainFused() {
        io.reactivex.internal.queue.b r5 = this.queue;
        zu.c r10 = this.downstream;
        int r11 = 1;
    L4:
        if (this.cancelled.get() == true) goto L5;
        boolean r12 = this.finished;
        if (r12 == true) goto L10;
    L15:
        r10.onNext(null);
        if (r12 == true) goto L17;
        r11 = addAndGet(-r11);
        if (r11 != 0) goto L4;
        return;
    L17:
        Throwable r13 = this.error;
        if (r13 == null) goto L20;
        r10.onError(r13);
        return;
    L20:
        r10.onComplete();
        return;
    L10:
        if (this.delayError == true) goto L15;
        Throwable r14 = this.error;
        if (r14 == null) goto L15;
        r5.clear();
        r10.onError(r14);
        return;
    L5:
        r5.clear();
    }

    public void drainNormal() {
        io.reactivex.internal.queue.b r5 = this.queue;
        zu.c r10 = this.downstream;
        int r11 = 1;
    L3:
        long r12 = this.requested.get();
        long r13 = 0;
    L5:
        if (r13 == r12) goto L16;
        boolean r14 = this.finished;
        ot.a r15 = (ot.a) r5.poll();
        if (r15 != null) goto L9;
        boolean r16 = true;
    L11:
        if (checkTerminated(r14, r16, r10, r5) == true) goto L12;
        if (r16 == true) goto L16;
        r10.onNext(r15);
        r13 = r13 + 1;
        goto L5
    L12:
        return;
    L9:
        r16 = false;
    L16:
        if (r13 != r12) goto L21;
        if (checkTerminated(this.finished, r5.isEmpty(), r10, r5) == false) goto L21;
        return;
    L21:
        if (r13 != 0) goto L23;
    L26:
        r11 = addAndGet(-r11);
        if (r11 != 0) goto L3;
        return;
    L23:
        if (r12 == Long.MAX_VALUE) goto L25;
        this.requested.addAndGet(-r13);
    L25:
        this.upstream.request(r13);
        goto L26
    }

    @Override // io.reactivex.internal.subscriptions.BasicIntQueueSubscription, rt.h
    public boolean isEmpty() {
        return this.queue.isEmpty();
    }

    @Override // zu.c
    public void onComplete() {
        if (this.done == true) goto L14;
        Iterator<j> r5 = this.groups.values().iterator();
    L6:
        if (r5.hasNext() == false) goto L8;
        r5.next().f17663c.onComplete();
        goto L6
    L8:
        this.groups.clear();
        Queue<j> r10 = this.evictedGroups;
        if (r10 == null) goto L11;
        r10.clear();
    L11:
        this.done = true;
        this.finished = true;
        drain();
        return;
    }

    @Override // zu.c
    public void onError(Throwable r5) {
        if (this.done == false) goto L6;
        wn.f.k(r5);
        return;
    L6:
        this.done = true;
        Iterator<j> r10 = this.groups.values().iterator();
    L8:
        if (r10.hasNext() == false) goto L10;
        r10.next().f17663c.onError(r5);
        goto L8
    L10:
        this.groups.clear();
        Queue<j> r11 = this.evictedGroups;
        if (r11 == null) goto L13;
        r11.clear();
    L13:
        this.error = r5;
        this.finished = true;
        drain();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // zu.c
    public void onNext(T r10) {
        if (this.done == false) goto L5;
        return;
    L5:
        io.reactivex.internal.queue.b r5 = this.queue;
        Object r11 = this.keySelector.apply(r10);     // Catch: Throwable -> L25
        if (r11 == null) goto L9;
        Object r12 = r11;
    L10:
        j r13 = this.groups.get(r12);
        if (r13 == null) goto L13;
        boolean r14 = false;
    L30:
        Object r15 = this.valueSelector.apply(r10);     // Catch: Throwable -> L22
        io.reactivex.internal.functions.e.d(r15, "The valueSelector returned null");     // Catch: Throwable -> L22
        r13.f17663c.onNext(r15);
        a();
        if (r14 == false) goto L32;
        r5.offer(r13);
        drain();
        return;
    L32:
        return;
    L22:
        th = move-exception;
        com.lynx.jsbridge.a.t(th);
        this.upstream.cancel();
        onError(th);
        return;
    L13:
        if (this.cancelled.get() == false) goto L15;
        return;
    L15:
        int r16 = this.bufferSize;
        boolean r17 = this.delayError;
        int r18 = j.d;
        r13 = new j(r11, new FlowableGroupBy$State(r16, this, r11, r17));
        this.groups.put(r12, r13);
        this.groupCount.getAndIncrement();
        r14 = true;
        goto L30
    L9:
        r12 = NULL_KEY;
    L25:
        th = move-exception;
        com.lynx.jsbridge.a.t(th);
        this.upstream.cancel();
        onError(th);
    }

    @Override // zu.c
    public void onSubscribe(zu.d r5) {
        if (SubscriptionHelper.validate(this.upstream, r5) == false) goto L6;
        this.upstream = r5;
        this.downstream.onSubscribe(this);
        r5.request(this.bufferSize);
        return;
    }

    @Override // io.reactivex.internal.subscriptions.BasicIntQueueSubscription, rt.h
    public /* bridge */ /* synthetic */ Object poll() throws Exception {
        return poll();
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
        if ((r5 & 2) == 0) goto L6;
        this.outputFused = true;
        return 2;
    L6:
        return 0;
    }

    @Override // io.reactivex.internal.subscriptions.BasicIntQueueSubscription, rt.h
    public ot.a poll() {
        return (ot.a) this.queue.poll();
    }

    public void cancel(K r5) {
        if (r5 != null) goto L5;
        r5 = (K) NULL_KEY;
    L5:
        this.groups.remove(r5);
        if (this.groupCount.decrementAndGet() != 0) goto L11;
        this.upstream.cancel();
        if (getAndIncrement() != 0) goto L12;
        this.queue.clear();
        return;
    L12:
        return;
    }
}
