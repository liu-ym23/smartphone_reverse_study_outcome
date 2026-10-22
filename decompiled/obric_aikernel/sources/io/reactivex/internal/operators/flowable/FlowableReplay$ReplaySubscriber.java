package io.reactivex.internal.operators.flowable;

import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes2.dex */
final class FlowableReplay$ReplaySubscriber<T> extends AtomicReference<tc.d> implements xb.g<T>, io.reactivex.disposables.b {
    static final FlowableReplay$InnerSubscription[] EMPTY = null;
    static final FlowableReplay$InnerSubscription[] TERMINATED = null;
    private static final long serialVersionUID = 7224554242710036740L;
    final i<T> buffer;
    boolean done;
    final AtomicInteger management;
    long maxChildRequested;
    long maxUpstreamRequested;
    final AtomicBoolean shouldConnect;
    final AtomicReference<FlowableReplay$InnerSubscription<T>[]> subscribers;

    static {
        EMPTY = new FlowableReplay$InnerSubscription[0];
        TERMINATED = new FlowableReplay$InnerSubscription[0];
    }

    FlowableReplay$ReplaySubscriber(i<T> r10) {
        this.buffer = r10;
        this.management = new AtomicInteger();
        this.subscribers = new AtomicReference(EMPTY);
        this.shouldConnect = new AtomicBoolean();
    }

    boolean add(FlowableReplay$InnerSubscription<T> r10) {
        Objects.requireNonNull(r10);
    L3:
        FlowableReplay$InnerSubscription<T>[] r11 = this.subscribers.get();
        if (r11 == TERMINATED) goto L5;
        int r12 = r11.length;
        FlowableReplay$InnerSubscription<T>[] r13 = new FlowableReplay$InnerSubscription[r12 + 1];
        System.arraycopy(r11, 0, r13, 0, r12);
        r13[r12] = r10;
        if (this.subscribers.compareAndSet(r11, r13) == false) goto L3;
        return true;
    L5:
        return false;
    }

    @Override // io.reactivex.disposables.b
    public void dispose() {
        this.subscribers.set(TERMINATED);
        SubscriptionHelper.cancel(this);
    }

    @Override // io.reactivex.disposables.b
    public boolean isDisposed() {
        if (this.subscribers.get() != TERMINATED) goto L5;
        return true;
    L5:
        return false;
    }

    void manageRequests() {
        if (this.management.getAndIncrement() == 0) goto L5;
        return;
    L5:
        int r10 = 1;
    L7:
        if (isDisposed() == true) goto L8;
        FlowableReplay$InnerSubscription<T>[] r11 = this.subscribers.get();
        long r12 = this.maxChildRequested;
        int r13 = r11.length;
        int r14 = 0;
        long r15 = r12;
    L10:
        if (r14 >= r13) goto L12;
        r15 = Math.max(r15, r11[r14].totalRequested.get());
        r14 = r14 + 1;
        goto L10
    L12:
        long r16 = this.maxUpstreamRequested;
        tc.d r17 = get();
        long r18 = r15 - r12;
        if (r18 == 0) goto L25;
        this.maxChildRequested = r15;
        if (r17 != null) goto L17;
        long r19 = r16 + r18;
        if (r19 >= 0) goto L23;
        r19 = Long.MAX_VALUE;
    L23:
        this.maxUpstreamRequested = r19;
    L29:
        r10 = this.management.addAndGet(-r10);
        if (r10 != 0) goto L7;
        return;
    L17:
        if (r16 == 0) goto L19;
        this.maxUpstreamRequested = 0;
        r16 = r16 + r18;
    L28:
        r17.request(r16);
        goto L29
    L19:
        r17.request(r18);
        goto L29
    L25:
        if (r16 == 0) goto L29;
        if (r17 == null) goto L29;
        this.maxUpstreamRequested = 0;
        goto L28
    }

    @Override // tc.c
    public void onComplete() {
        if (this.done == true) goto L7;
        this.done = true;
        this.buffer.complete();
        FlowableReplay$InnerSubscription<T>[] r10 = this.subscribers.getAndSet(TERMINATED);
        int r11 = r10.length;
        int r12 = 0;
    L5:
        if (r12 >= r11) goto L9;
        FlowableReplay$InnerSubscription<T> r13 = r10[r12];
        this.buffer.replay(r13);
        r12 = r12 + 1;
        goto L5
    L9:
        return;
    }

    @Override // tc.c
    public void onError(Throwable r10) {
        if (this.done == true) goto L7;
        this.done = true;
        this.buffer.error(r10);
        FlowableReplay$InnerSubscription<T>[] r11 = this.subscribers.getAndSet(TERMINATED);
        int r12 = r11.length;
        int r13 = 0;
    L5:
        if (r13 >= r12) goto L10;
        FlowableReplay$InnerSubscription<T> r14 = r11[r13];
        this.buffer.replay(r14);
        r13 = r13 + 1;
        goto L5
    L10:
        return;
    L7:
        dc.a.n(r10);
    }

    @Override // tc.c
    public void onNext(T r10) {
        if (this.done == true) goto L7;
        this.buffer.next(r10);
        FlowableReplay$InnerSubscription<T>[] r11 = this.subscribers.get();
        int r12 = r11.length;
        int r13 = 0;
    L5:
        if (r13 >= r12) goto L9;
        FlowableReplay$InnerSubscription<T> r14 = r11[r13];
        this.buffer.replay(r14);
        r13 = r13 + 1;
        goto L5
    L9:
        return;
    }

    @Override // xb.g, tc.c
    public void onSubscribe(tc.d r10) {
        if (SubscriptionHelper.setOnce(this, r10) == false) goto L7;
        manageRequests();
        FlowableReplay$InnerSubscription<T>[] r11 = this.subscribers.get();
        int r12 = r11.length;
        int r13 = 0;
    L5:
        if (r13 >= r12) goto L9;
        FlowableReplay$InnerSubscription<T> r14 = r11[r13];
        this.buffer.replay(r14);
        r13 = r13 + 1;
        goto L5
    L9:
        return;
    }

    void remove(FlowableReplay$InnerSubscription<T> r10) {
    L2:
        FlowableReplay$InnerSubscription<T>[] r11 = this.subscribers.get();
        int r12 = r11.length;
        if (r12 == 0) goto L4;
        int r13 = -1;
        int r14 = 0;
    L6:
        if (r14 >= r12) goto L11;
        if (r11[r14].equals(r10) == true) goto L9;
        r14 = r14 + 1;
        goto L6
    L9:
        r13 = r14;
    L11:
        if (r13 < 0) goto L12;
        if (r12 != 1) goto L16;
        FlowableReplay$InnerSubscription<T>[] r15 = EMPTY;
    L18:
        if (this.subscribers.compareAndSet(r11, r15) == false) goto L2;
        return;
    L16:
        FlowableReplay$InnerSubscription<T>[] r16 = new FlowableReplay$InnerSubscription[r12 - 1];
        System.arraycopy(r11, 0, r16, 0, r13);
        System.arraycopy(r11, r13 + 1, r16, r13, (r12 - r13) - 1);
        r15 = r16;
        goto L18
    L12:
        return;
    }
}
