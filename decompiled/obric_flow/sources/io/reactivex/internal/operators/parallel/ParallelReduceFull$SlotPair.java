package io.reactivex.internal.operators.parallel;

import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes3.dex */
final class ParallelReduceFull$SlotPair<T> extends AtomicInteger {
    private static final long serialVersionUID = 473971317683868662L;
    T first;
    final AtomicInteger releaseIndex;
    T second;

    public ParallelReduceFull$SlotPair() {
        this.releaseIndex = new AtomicInteger();
    }

    public boolean releaseSlot() {
        if (this.releaseIndex.incrementAndGet() != 2) goto L5;
        return true;
    L5:
        return false;
    }

    public int tryAcquireSlot() {
    L2:
        int r5 = get();
        if (r5 >= 2) goto L4;
        if (compareAndSet(r5, r5 + 1) == false) goto L2;
        return r5;
    L4:
        return -1;
    }
}
