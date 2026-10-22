package io.reactivex.internal.operators.flowable;

import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.internal.queue.SpscArrayQueue;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes3.dex */
final class FlowablePublishAlt$PublishConnection<T> extends AtomicInteger implements mt.g, Disposable {
    static final FlowablePublishAlt$InnerSubscription[] EMPTY = null;
    static final FlowablePublishAlt$InnerSubscription[] TERMINATED = null;
    private static final long serialVersionUID = -1672047311619175801L;
    final int bufferSize;
    final AtomicBoolean connect;
    int consumed;
    final AtomicReference<FlowablePublishAlt$PublishConnection<T>> current;
    volatile boolean done;
    Throwable error;
    volatile rt.h queue;
    int sourceMode;
    final AtomicReference<FlowablePublishAlt$InnerSubscription<T>[]> subscribers;
    final AtomicReference<zu.d> upstream;

    static {
        EMPTY = new FlowablePublishAlt$InnerSubscription[0];
        TERMINATED = new FlowablePublishAlt$InnerSubscription[0];
    }

    public FlowablePublishAlt$PublishConnection(AtomicReference<FlowablePublishAlt$PublishConnection<T>> r5, int r10) {
        this.current = r5;
        this.upstream = new AtomicReference();
        this.connect = new AtomicBoolean();
        this.bufferSize = r10;
        this.subscribers = new AtomicReference(EMPTY);
    }

    public boolean add(FlowablePublishAlt$InnerSubscription<T> r5) {
    L2:
        FlowablePublishAlt$InnerSubscription<T>[] r10 = this.subscribers.get();
        if (r10 == TERMINATED) goto L4;
        int r11 = r10.length;
        FlowablePublishAlt$InnerSubscription<T>[] r12 = new FlowablePublishAlt$InnerSubscription[r11 + 1];
        System.arraycopy(r10, 0, r12, 0, r11);
        r12[r11] = r5;
        AtomicReference<FlowablePublishAlt$InnerSubscription<T>[]> r13 = this.subscribers;
    L7:
        if (r13.compareAndSet(r10, r12) == true) goto L8;
        if (r13.get() == r10) goto L7;
    L8:
        return true;
    L4:
        return false;
    }

    public boolean checkTerminated(boolean r5, boolean r10) {
        int r11 = 0;
        if (r5 == false) goto L16;
        if (r10 == false) goto L16;
        Throwable r12 = this.error;
        if (r12 == null) goto L8;
        signalError(r12);
        return true;
    L8:
        FlowablePublishAlt$InnerSubscription<T>[] r13 = this.subscribers.getAndSet(TERMINATED);
        int r14 = r13.length;
    L9:
        if (r11 >= r14) goto L20;
        FlowablePublishAlt$InnerSubscription<T> r15 = r13[r11];
        if (r15.isCancelled() == true) goto L13;
        r15.downstream.onComplete();
    L13:
        r11 = r11 + 1;
        goto L9
    L20:
        return true;
    L16:
        return false;
    }

    @Override // io.reactivex.disposables.Disposable
    public void dispose() {
        this.subscribers.getAndSet(TERMINATED);
        AtomicReference<FlowablePublishAlt$PublishConnection<T>> r5 = this.current;
    L4:
        if (r5.compareAndSet(this, null) == true) goto L8;
        if (r5.get() == this) goto L4;
    L8:
        SubscriptionHelper.cancel(this.upstream);
    }

    public void drain() {
        if (getAndIncrement() == 0) goto L5;
        return;
    L5:
        rt.h r5 = this.queue;
        int r10 = this.consumed;
        int r11 = this.bufferSize;
        int r12 = r11 - (r11 >> 2);
        if (this.sourceMode == 1) goto L8;
        boolean r13 = true;
    L9:
        int r14 = 1;
        rt.h r15 = r5;
        int r16 = r10;
    L10:
        if (r15 == null) goto L53;
        FlowablePublishAlt$InnerSubscription<T>[] r17 = this.subscribers.get();
        int r18 = r17.length;
        long r19 = Long.MAX_VALUE;
        int r110 = 0;
        boolean r111 = false;
    L12:
        if (r110 >= r18) goto L17;
        FlowablePublishAlt$InnerSubscription<T> r112 = r17[r110];
        long r113 = r112.get();
        if (r113 == Long.MIN_VALUE) goto L16;
        r19 = Math.min(r113 - r112.emitted, r19);
        r111 = true;
    L16:
        r110 = r110 + 1;
        goto L12
    L17:
        long r114 = 0;
        if (r111 == true) goto L21;
        r19 = 0;
    L21:
        if (r19 == r114) goto L51;
        boolean r20 = this.done;
        Object r115 = r15.poll();     // Catch: Throwable -> L47
        if (r115 != null) goto L26;
        boolean r116 = true;
    L28:
        if (checkTerminated(r20, r116) == true) goto L29;
        if (r116 == true) goto L51;
        int r21 = r17.length;
        int r117 = 0;
    L34:
        if (r117 >= r21) goto L39;
        FlowablePublishAlt$InnerSubscription<T> r22 = r17[r117];
        if (r22.isCancelled() == true) goto L38;
        r22.downstream.onNext(r115);
        r22.emitted++;
    L38:
        r117 = r117 + 1;
        goto L34
    L39:
        if (r13 == false) goto L43;
        r16 = r16 + 1;
        if (r16 != r12) goto L43;
        this.upstream.get().request(r12);
        r16 = 0;
    L43:
        r19 = r19 - 1;
        if (r17 != this.subscribers.get()) goto L10;
        r114 = 0;
        goto L21
    L29:
        return;
    L26:
        r116 = false;
    L47:
        th = move-exception;
        com.lynx.jsbridge.a.t(th);
        this.upstream.get().cancel();
        r15.clear();
        this.done = true;
        signalError(th);
        return;
    L51:
        if (checkTerminated(this.done, r15.isEmpty()) == false) goto L53;
        return;
    L53:
        this.consumed = r16;
        r14 = addAndGet(-r14);
        if (r14 == 0) goto L55;
        if (r15 != null) goto L10;
        r15 = this.queue;
        goto L10
    L55:
        return;
    L8:
        r13 = false;
        goto L9
    }

    @Override // io.reactivex.disposables.Disposable
    public boolean isDisposed() {
        if (this.subscribers.get() != TERMINATED) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // zu.c
    public void onComplete() {
        this.done = true;
        drain();
    }

    @Override // zu.c
    public void onError(Throwable r5) {
        if (this.done == false) goto L5;
        wn.f.k(r5);
        return;
    L5:
        this.error = r5;
        this.done = true;
        drain();
    }

    @Override // zu.c
    public void onNext(T r5) {
        if (this.sourceMode == 0) goto L5;
    L8:
        drain();
        return;
    L5:
        if (this.queue.offer(r5) == true) goto L8;
        onError(new MissingBackpressureException("Prefetch queue is full?!"));
    }

    @Override // zu.c
    public void onSubscribe(zu.d r5) {
        if (SubscriptionHelper.setOnce(this.upstream, r5) == true) goto L5;
        return;
    L5:
        if ((r5 instanceof rt.e) == false) goto L14;
        rt.e r10 = (rt.e) r5;
        int r11 = r10.requestFusion(7);
        if (r11 != 1) goto L11;
        this.sourceMode = r11;
        this.queue = r10;
        this.done = true;
        drain();
        return;
    L11:
        if (r11 != 2) goto L14;
        this.sourceMode = r11;
        this.queue = r10;
        r5.request(this.bufferSize);
        return;
    L14:
        this.queue = new SpscArrayQueue(this.bufferSize);
        r5.request(this.bufferSize);
    }

    public void remove(FlowablePublishAlt$InnerSubscription<T> r10) {
    L2:
        FlowablePublishAlt$InnerSubscription<T>[] r5 = this.subscribers.get();
        int r11 = r5.length;
        if (r11 == 0) goto L21;
        int r12 = 0;
    L6:
        if (r12 >= r11) goto L11;
        if (r5[r12] == r10) goto L12;
        r12 = r12 + 1;
    L12:
        if (r12 < 0) goto L13;
        if (r11 != 1) goto L17;
        FlowablePublishAlt$InnerSubscription<T>[] r13 = EMPTY;
    L18:
        AtomicReference<FlowablePublishAlt$InnerSubscription<T>[]> r14 = this.subscribers;
    L20:
        if (r14.compareAndSet(r5, r13) == true) goto L32;
        if (r14.get() == r5) goto L20;
    L32:
        return;
    L17:
        FlowablePublishAlt$InnerSubscription<T>[] r15 = new FlowablePublishAlt$InnerSubscription[r11 - 1];
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

    public void signalError(Throwable r5) {
        FlowablePublishAlt$InnerSubscription<T>[] r10 = this.subscribers.getAndSet(TERMINATED);
        int r11 = r10.length;
        int r12 = 0;
    L3:
        if (r12 >= r11) goto L8;
        FlowablePublishAlt$InnerSubscription<T> r13 = r10[r12];
        if (r13.isCancelled() == true) goto L7;
        r13.downstream.onError(r5);
    L7:
        r12 = r12 + 1;
        goto L3
    }
}
