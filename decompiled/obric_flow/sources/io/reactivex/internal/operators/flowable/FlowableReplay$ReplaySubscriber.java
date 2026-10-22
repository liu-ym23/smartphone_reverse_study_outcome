package io.reactivex.internal.operators.flowable;

import io.reactivex.disposables.Disposable;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes3.dex */
final class FlowableReplay$ReplaySubscriber<T> extends AtomicReference<zu.d> implements mt.g, Disposable {
    static final FlowableReplay$InnerSubscription[] EMPTY = null;
    static final FlowableReplay$InnerSubscription[] TERMINATED = null;
    private static final long serialVersionUID = 7224554242710036740L;
    final r buffer;
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

    public FlowableReplay$ReplaySubscriber(r r5) {
        this.buffer = r5;
        this.management = new AtomicInteger();
        this.subscribers = new AtomicReference(EMPTY);
        this.shouldConnect = new AtomicBoolean();
    }

    public boolean add(FlowableReplay$InnerSubscription<T> r5) {
        r5.getClass();
    L3:
        FlowableReplay$InnerSubscription<T>[] r10 = this.subscribers.get();
        if (r10 == TERMINATED) goto L5;
        int r11 = r10.length;
        FlowableReplay$InnerSubscription<T>[] r12 = new FlowableReplay$InnerSubscription[r11 + 1];
        System.arraycopy(r10, 0, r12, 0, r11);
        r12[r11] = r5;
        AtomicReference<FlowableReplay$InnerSubscription<T>[]> r13 = this.subscribers;
    L8:
        if (r13.compareAndSet(r10, r12) == true) goto L9;
        if (r13.get() == r10) goto L8;
    L9:
        return true;
    L5:
        return false;
    }

    @Override // io.reactivex.disposables.Disposable
    public void dispose() {
        this.subscribers.set(TERMINATED);
        SubscriptionHelper.cancel(this);
    }

    @Override // io.reactivex.disposables.Disposable
    public boolean isDisposed() {
        if (this.subscribers.get() != TERMINATED) goto L5;
        return true;
    L5:
        return false;
    }

    public void manageRequests() {
        if (this.management.getAndIncrement() == 0) goto L5;
        return;
    L5:
        int r5 = 1;
    L7:
        if (isDisposed() == true) goto L8;
        FlowableReplay$InnerSubscription<T>[] r10 = this.subscribers.get();
        long r11 = this.maxChildRequested;
        int r12 = r10.length;
        int r13 = 0;
        long r14 = r11;
    L10:
        if (r13 >= r12) goto L12;
        r14 = Math.max(r14, r10[r13].totalRequested.get());
        r13 = r13 + 1;
        goto L10
    L12:
        long r15 = this.maxUpstreamRequested;
        zu.d r16 = get();
        long r17 = r14 - r11;
        if (r17 == 0) goto L25;
        this.maxChildRequested = r14;
        if (r16 != null) goto L17;
        long r18 = r15 + r17;
        if (r18 >= 0) goto L23;
        r18 = Long.MAX_VALUE;
    L23:
        this.maxUpstreamRequested = r18;
    L28:
        r5 = this.management.addAndGet(-r5);
        if (r5 != 0) goto L7;
        return;
    L17:
        if (r15 == 0) goto L19;
        this.maxUpstreamRequested = 0;
        r16.request(r15 + r17);
        goto L28
    L19:
        r16.request(r17);
        goto L28
    L25:
        if (r15 == 0) goto L28;
        if (r16 == null) goto L28;
        this.maxUpstreamRequested = 0;
        r16.request(r15);
        goto L28
    }

    @Override // zu.c
    public void onComplete() {
        if (this.done == true) goto L7;
        this.done = true;
        this.buffer.complete();
        FlowableReplay$InnerSubscription<T>[] r5 = this.subscribers.getAndSet(TERMINATED);
        int r10 = r5.length;
        int r11 = 0;
    L5:
        if (r11 >= r10) goto L9;
        FlowableReplay$InnerSubscription<T> r12 = r5[r11];
        this.buffer.replay(r12);
        r11 = r11 + 1;
        goto L5
    L9:
        return;
    }

    @Override // zu.c
    public void onError(Throwable r5) {
        if (this.done == true) goto L7;
        this.done = true;
        this.buffer.error(r5);
        FlowableReplay$InnerSubscription<T>[] r10 = this.subscribers.getAndSet(TERMINATED);
        int r11 = r10.length;
        int r12 = 0;
    L5:
        if (r12 >= r11) goto L10;
        FlowableReplay$InnerSubscription<T> r13 = r10[r12];
        this.buffer.replay(r13);
        r12 = r12 + 1;
        goto L5
    L10:
        return;
    L7:
        wn.f.k(r5);
    }

    @Override // zu.c
    public void onNext(T r5) {
        if (this.done == true) goto L7;
        this.buffer.next(r5);
        FlowableReplay$InnerSubscription<T>[] r10 = this.subscribers.get();
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

    @Override // zu.c
    public void onSubscribe(zu.d r5) {
        if (SubscriptionHelper.setOnce(this, r5) == false) goto L7;
        manageRequests();
        FlowableReplay$InnerSubscription<T>[] r10 = this.subscribers.get();
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

    public void remove(FlowableReplay$InnerSubscription<T> r10) {
    L2:
        FlowableReplay$InnerSubscription<T>[] r5 = this.subscribers.get();
        int r11 = r5.length;
        if (r11 == 0) goto L4;
        int r12 = 0;
    L6:
        if (r12 >= r11) goto L11;
        if (r5[r12].equals(r10) == true) goto L12;
        r12 = r12 + 1;
    L12:
        if (r12 < 0) goto L13;
        if (r11 != 1) goto L17;
        FlowableReplay$InnerSubscription<T>[] r13 = EMPTY;
    L18:
        AtomicReference<FlowableReplay$InnerSubscription<T>[]> r14 = this.subscribers;
    L20:
        if (r14.compareAndSet(r5, r13) == true) goto L21;
        if (r14.get() == r5) goto L20;
    L21:
        return;
    L17:
        FlowableReplay$InnerSubscription<T>[] r15 = new FlowableReplay$InnerSubscription[r11 - 1];
        System.arraycopy(r5, 0, r15, 0, r12);
        System.arraycopy(r5, r12 + 1, r15, r12, (r11 - r12) - 1);
        r13 = r15;
        goto L18
    L13:
        return;
    L11:
        r12 = -1;
        goto L12
    }
}
