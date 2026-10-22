package io.reactivex.internal.operators.parallel;

import io.reactivex.internal.functions.a;
import io.reactivex.internal.subscriptions.DeferredScalarSubscription;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import zb.c;

/* JADX INFO: loaded from: classes2.dex */
final class ParallelReduceFull$ParallelReduceFullMainSubscriber<T> extends DeferredScalarSubscription<T> {
    private static final long serialVersionUID = -5370107872170712765L;
    final AtomicReference<ParallelReduceFull$SlotPair<T>> current;
    final AtomicReference<Throwable> error;
    final c<T, T, T> reducer;
    final AtomicInteger remaining;
    final ParallelReduceFull$ParallelReduceFullInnerSubscriber<T>[] subscribers;

    ParallelReduceFull$ParallelReduceFullMainSubscriber(tc.c<? super T> r10, int r11, c<T, T, T> r12) {
        super(r10);
        this.current = new AtomicReference();
        this.remaining = new AtomicInteger();
        this.error = new AtomicReference();
        ParallelReduceFull$ParallelReduceFullInnerSubscriber<T>[] r13 = new ParallelReduceFull$ParallelReduceFullInnerSubscriber[r11];
        int r14 = 0;
    L3:
        if (r14 >= r11) goto L5;
        r13[r14] = new ParallelReduceFull$ParallelReduceFullInnerSubscriber(this, r12);
        r14 = r14 + 1;
        goto L3
    L5:
        this.subscribers = r13;
        this.reducer = r12;
        this.remaining.lazySet(r11);
    }

    ParallelReduceFull$SlotPair<T> addValue(T r10) {
    L2:
        ParallelReduceFull$SlotPair<T> r11 = this.current.get();
        if (r11 != null) goto L7;
        r11 = new ParallelReduceFull$SlotPair();
        if (this.current.compareAndSet(null, r11) == false) goto L2;
    L7:
        int r12 = r11.tryAcquireSlot();
        if (r12 >= 0) goto L10;
        this.current.compareAndSet(r11, null);
        goto L2
    L10:
        if (r12 != 0) goto L12;
        r11.first = r10;
    L14:
        if (r11.releaseSlot() == false) goto L17;
        this.current.compareAndSet(r11, null);
        return r11;
    L17:
        return null;
    L12:
        r11.second = r10;
        goto L14
    }

    @Override // io.reactivex.internal.subscriptions.DeferredScalarSubscription, io.reactivex.internal.subscriptions.BasicIntQueueSubscription, tc.d
    public void cancel() {
        ParallelReduceFull$ParallelReduceFullInnerSubscriber<T>[] r10 = this.subscribers;
        int r11 = r10.length;
        int r12 = 0;
    L3:
        if (r12 >= r11) goto L5;
        r10[r12].cancel();
        r12 = r12 + 1;
        goto L3
    }

    void innerComplete(T r10) {
        if (r10 == null) goto L11;
    L3:
        ParallelReduceFull$SlotPair<T> r11 = addValue(r10);
        if (r11 == null) goto L11;
        r10 = (T) a.d(this.reducer.apply(r11.first, r11.second), "The reducer returned a null value");
    L7:
        th = move-exception;
        io.reactivex.exceptions.a.a(th);
        innerError(th);
        return;
    L11:
        if (this.remaining.decrementAndGet() != 0) goto L21;
        ParallelReduceFull$SlotPair<T> r12 = this.current.get();
        this.current.lazySet(null);
        if (r12 == null) goto L15;
        complete(r12.first);
        return;
    L15:
        this.downstream.onComplete();
        return;
    }

    void innerError(Throwable r10) {
        if (this.error.compareAndSet(null, r10) == false) goto L6;
        cancel();
        this.downstream.onError(r10);
        return;
    L6:
        if (r10 == this.error.get()) goto L10;
        dc.a.n(r10);
        return;
    }
}
