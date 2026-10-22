package io.reactivex.internal.operators.parallel;

import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes2.dex */
final class ParallelReduceFull$SlotPair<T> extends AtomicInteger {
    private static final long serialVersionUID = 473971317683868662L;
    T first;
    final AtomicInteger releaseIndex;
    T second;

    ParallelReduceFull$SlotPair() {
        this.releaseIndex = new AtomicInteger();
    }

    boolean releaseSlot() {
        if (this.releaseIndex.incrementAndGet() != 2) goto L5;
        return true;
    L5:
        return false;
    }

    int tryAcquireSlot() {
    L2:
        int r10 = get();
        if (r10 >= 2) goto L4;
        if (compareAndSet(r10, r10 + 1) == false) goto L2;
        return r10;
    L4:
        return -1;
    }
}
