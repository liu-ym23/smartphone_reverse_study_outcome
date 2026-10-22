package io.reactivex.internal.operators.parallel;

import io.reactivex.internal.functions.e;
import io.reactivex.internal.subscriptions.DeferredScalarSubscription;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import pt.c;
import wn.f;

/* JADX INFO: loaded from: classes3.dex */
final class ParallelReduceFull$ParallelReduceFullMainSubscriber<T> extends DeferredScalarSubscription<T> {
    private static final long serialVersionUID = -5370107872170712765L;
    final AtomicReference<ParallelReduceFull$SlotPair<T>> current;
    final AtomicReference<Throwable> error;
    final c reducer;
    final AtomicInteger remaining;
    final ParallelReduceFull$ParallelReduceFullInnerSubscriber<T>[] subscribers;

    public ParallelReduceFull$ParallelReduceFullMainSubscriber(zu.c r5, int r10, c r11) {
        super(r5);
        this.current = new AtomicReference();
        this.remaining = new AtomicInteger();
        this.error = new AtomicReference();
        ParallelReduceFull$ParallelReduceFullInnerSubscriber<T>[] r12 = new ParallelReduceFull$ParallelReduceFullInnerSubscriber[r10];
        int r13 = 0;
    L3:
        if (r13 >= r10) goto L5;
        r12[r13] = new ParallelReduceFull$ParallelReduceFullInnerSubscriber(this, r11);
        r13 = r13 + 1;
        goto L3
    L5:
        this.subscribers = r12;
        this.reducer = r11;
        this.remaining.lazySet(r10);
    }

    public ParallelReduceFull$SlotPair<T> addValue(T r5) {
    L2:
        ParallelReduceFull$SlotPair<T> r10 = this.current.get();
        if (r10 != null) goto L11;
        ParallelReduceFull$SlotPair<T> r11 = new ParallelReduceFull$SlotPair();
        AtomicReference<ParallelReduceFull$SlotPair<T>> r12 = this.current;
    L6:
        if (r12.compareAndSet(null, r11) == true) goto L7;
        if (r12.get() == null) goto L6;
    L7:
        r10 = r11;
    L11:
        int r13 = r10.tryAcquireSlot();
        if (r13 >= 0) goto L20;
        AtomicReference<ParallelReduceFull$SlotPair<T>> r14 = this.current;
    L15:
        if (r14.compareAndSet(r10, null) == true) goto L2;
        if (r14.get() == r10) goto L15;
    L20:
        if (r13 != 0) goto L22;
        r10.first = r5;
    L24:
        if (r10.releaseSlot() == false) goto L32;
        AtomicReference<ParallelReduceFull$SlotPair<T>> r15 = this.current;
    L27:
        if (r15.compareAndSet(r10, null) == true) goto L31;
        if (r15.get() == r10) goto L27;
    L31:
        return r10;
    L32:
        return null;
    L22:
        r10.second = r5;
        goto L24
    }

    @Override // io.reactivex.internal.subscriptions.DeferredScalarSubscription, io.reactivex.internal.subscriptions.BasicIntQueueSubscription, zu.d
    public void cancel() {
        ParallelReduceFull$ParallelReduceFullInnerSubscriber<T>[] r5 = this.subscribers;
        int r10 = r5.length;
        int r11 = 0;
    L3:
        if (r11 >= r10) goto L5;
        r5[r11].cancel();
        r11 = r11 + 1;
        goto L3
    }

    public void innerComplete(T r5) {
        if (r5 == null) goto L11;
    L3:
        ParallelReduceFull$SlotPair<T> r10 = addValue(r5);
        if (r10 == null) goto L11;
        r5 = (T) this.reducer.apply(r10.first, r10.second);
        e.d(r5, "The reducer returned a null value");     // Catch: Throwable -> L7
    L7:
        th = move-exception;
        com.lynx.jsbridge.a.t(th);
        innerError(th);
        return;
    L11:
        if (this.remaining.decrementAndGet() != 0) goto L21;
        ParallelReduceFull$SlotPair<T> r11 = this.current.get();
        this.current.lazySet(null);
        if (r11 == null) goto L15;
        complete(r11.first);
        return;
    L15:
        this.downstream.onComplete();
        return;
    }

    public void innerError(Throwable r5) {
        AtomicReference<Throwable> r10 = this.error;
    L4:
        if (r10.compareAndSet(null, r5) == true) goto L5;
        if (r10.get() == null) goto L4;
        if (r5 == this.error.get()) goto L16;
        f.k(r5);
        return;
    L16:
        return;
    L5:
        cancel();
        this.downstream.onError(r5);
    }
}
