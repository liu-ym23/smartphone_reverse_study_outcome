package io.reactivex.internal.operators.flowable;

import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.queue.SpscArrayQueue;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.AtomicThrowable;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import xb.r;

/* JADX INFO: loaded from: classes2.dex */
final class FlowableMergeWithSingle$MergeWithObserver<T> extends AtomicInteger implements xb.g<T>, tc.d {
    static final int OTHER_STATE_CONSUMED_OR_EMPTY = 2;
    static final int OTHER_STATE_HAS_VALUE = 1;
    private static final long serialVersionUID = -4592979584110982903L;
    volatile boolean cancelled;
    int consumed;
    final tc.c<? super T> downstream;
    long emitted;
    final AtomicThrowable error;
    final int limit;
    volatile boolean mainDone;
    final AtomicReference<tc.d> mainSubscription;
    final OtherObserver<T> otherObserver;
    volatile int otherState;
    final int prefetch;
    volatile bc.e<T> queue;
    final AtomicLong requested;
    T singleItem;

    static final class OtherObserver<T> extends AtomicReference<io.reactivex.disposables.b> implements r<T> {
        private static final long serialVersionUID = -2935427570954647017L;
        final FlowableMergeWithSingle$MergeWithObserver<T> parent;

        OtherObserver(FlowableMergeWithSingle$MergeWithObserver<T> r10) {
            this.parent = r10;
        }

        @Override // xb.r
        public void onError(Throwable r10) {
            this.parent.otherError(r10);
        }

        @Override // xb.r
        public void onSubscribe(io.reactivex.disposables.b r10) {
            DisposableHelper.setOnce(this, r10);
        }

        @Override // xb.r
        public void onSuccess(T r10) {
            this.parent.otherSuccess(r10);
        }
    }

    FlowableMergeWithSingle$MergeWithObserver(tc.c<? super T> r10) {
        this.downstream = r10;
        this.mainSubscription = new AtomicReference();
        this.otherObserver = new OtherObserver(this);
        this.error = new AtomicThrowable();
        this.requested = new AtomicLong();
        int r11 = xb.e.a();
        this.prefetch = r11;
        this.limit = r11 - (r11 >> 2);
    }

    @Override // tc.d
    public void cancel() {
        this.cancelled = true;
        SubscriptionHelper.cancel(this.mainSubscription);
        DisposableHelper.dispose(this.otherObserver);
        if (getAndIncrement() != 0) goto L6;
        this.queue = null;
        this.singleItem = null;
        return;
    }

    void drain() {
        if (getAndIncrement() != 0) goto L6;
        drainLoop();
        return;
    }

    void drainLoop() {
        tc.c<? super T> r10 = this.downstream;
        long r11 = this.emitted;
        int r12 = this.consumed;
        int r13 = this.limit;
        int r14 = 1;
        int r15 = 1;
    L3:
        long r16 = this.requested.get();
    L5:
        if (r11 == r16) goto L35;
        if (this.cancelled == true) goto L8;
        if (this.error.get() != null) goto L12;
        int r17 = this.otherState;
        if (r17 == r14) goto L16;
        boolean r18 = this.mainDone;
        bc.e<T> r19 = this.queue;
        if (r19 == null) goto L20;
        a1.c r110 = r19.poll();
    L21:
        if (r110 != null) goto L23;
        boolean r111 = true;
    L24:
        if (r18 == false) goto L29;
        if (r111 == false) goto L29;
        if (r17 != 2) goto L29;
        this.queue = null;
        r10.onComplete();
        return;
    L29:
        if (r111 == true) goto L35;
        r10.onNext(r110);
        r11 = r11 + 1;
        r12 = r12 + 1;
        if (r12 != r13) goto L34;
        this.mainSubscription.get().request(r13);
        r12 = 0;
    L34:
        r14 = 1;
        goto L5
    L23:
        r111 = false;
        goto L24
    L20:
        r110 = null;
        goto L21
    L16:
        T r112 = this.singleItem;
        this.singleItem = null;
        this.otherState = 2;
        r10.onNext(r112);
        r11 = r11 + 1;
        goto L5
    L12:
        this.singleItem = null;
        this.queue = null;
        r10.onError(this.error.terminate());
        return;
    L8:
        this.singleItem = null;
        this.queue = null;
        return;
    L35:
        if (r11 == r16) goto L37;
    L57:
        this.emitted = r11;
        this.consumed = r12;
        r15 = addAndGet(-r15);
        if (r15 == 0) goto L59;
        r14 = 1;
        goto L3
    L59:
        return;
    L37:
        if (this.cancelled == true) goto L38;
        if (this.error.get() != null) goto L42;
        boolean r20 = this.mainDone;
        bc.e<T> r21 = this.queue;
        if (r21 != null) goto L47;
    L50:
        boolean r113 = true;
    L51:
        if (r20 == false) goto L57;
        if (r113 == false) goto L57;
        if (this.otherState != 2) goto L57;
        this.queue = null;
        r10.onComplete();
        return;
    L47:
        if (r21.isEmpty() == true) goto L50;
        r113 = false;
        goto L51
    L42:
        this.singleItem = null;
        this.queue = null;
        r10.onError(this.error.terminate());
        return;
    L38:
        this.singleItem = null;
        this.queue = null;
    }

    bc.e<T> getOrCreateQueue() {
        bc.e<T> r10 = this.queue;
        if (r10 != null) goto L6;
        SpscArrayQueue r11 = new SpscArrayQueue(xb.e.a());
        this.queue = r11;
        return r11;
    L6:
        return r10;
    }

    @Override // tc.c
    public void onComplete() {
        this.mainDone = true;
        drain();
    }

    @Override // tc.c
    public void onError(Throwable r10) {
        if (this.error.addThrowable(r10) == false) goto L5;
        SubscriptionHelper.cancel(this.mainSubscription);
        drain();
        return;
    L5:
        dc.a.n(r10);
    }

    @Override // tc.c
    public void onNext(T r10) {
        if (compareAndSet(0, 1) == false) goto L20;
        long r11 = this.emitted;
        if (this.requested.get() == r11) goto L16;
        bc.e<T> r12 = this.queue;
        if (r12 != null) goto L9;
    L12:
        this.emitted = r11 + 1;
        this.downstream.onNext(r10);
        int r13 = this.consumed + 1;
        if (r13 != this.limit) goto L15;
        this.consumed = 0;
        this.mainSubscription.get().request(r13);
    L18:
        if (decrementAndGet() != 0) goto L23;
        return;
    L23:
        drainLoop();
        return;
    L15:
        this.consumed = r13;
        goto L18
    L9:
        if (r12.isEmpty() == true) goto L12;
        r12.offer(r10);
        goto L18
    L16:
        getOrCreateQueue().offer(r10);
        goto L18
    L20:
        getOrCreateQueue().offer(r10);
        if (getAndIncrement() == 0) goto L23;
    }

    @Override // xb.g, tc.c
    public void onSubscribe(tc.d r10) {
        SubscriptionHelper.setOnce(this.mainSubscription, r10, this.prefetch);
    }

    void otherError(Throwable r10) {
        if (this.error.addThrowable(r10) == false) goto L5;
        SubscriptionHelper.cancel(this.mainSubscription);
        drain();
        return;
    L5:
        dc.a.n(r10);
    }

    void otherSuccess(T r10) {
        if (compareAndSet(0, 1) == false) goto L10;
        long r11 = this.emitted;
        if (this.requested.get() == r11) goto L7;
        this.emitted = r11 + 1;
        this.downstream.onNext(r10);
        this.otherState = 2;
    L13:
        drainLoop();
        return;
    L7:
        this.singleItem = r10;
        this.otherState = 1;
        if (decrementAndGet() != 0) goto L13;
        return;
    L10:
        this.singleItem = r10;
        this.otherState = 1;
        if (getAndIncrement() == 0) goto L13;
    }

    @Override // tc.d
    public void request(long r10) {
        io.reactivex.internal.util.b.a(this.requested, r10);
        drain();
    }
}
