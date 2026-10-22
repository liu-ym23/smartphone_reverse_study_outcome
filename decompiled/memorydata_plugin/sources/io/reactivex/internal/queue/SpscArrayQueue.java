package io.reactivex.internal.queue;

import io.reactivex.internal.a.e;
import io.reactivex.internal.util.g;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReferenceArray;

/* JADX INFO: loaded from: classes6.dex */
public final class SpscArrayQueue<E> extends AtomicReferenceArray<E> implements e<E> {
    private static final Integer MAX_LOOK_AHEAD_STEP = null;
    private static final long serialVersionUID = -1296597691183856449L;
    final AtomicLong consumerIndex;
    final int lookAheadStep;
    final int mask;
    final AtomicLong producerIndex;
    long producerLookAhead;

    static {
        MAX_LOOK_AHEAD_STEP = Integer.getInteger("jctools.spsc.max.lookahead.step", 4096);
    }

    public SpscArrayQueue(int r2) {
        super(g.a(r2));
        this.mask = length() - 1;
        this.producerIndex = new AtomicLong();
        this.consumerIndex = new AtomicLong();
        this.lookAheadStep = Math.min(r2 / 4, MAX_LOOK_AHEAD_STEP.intValue());
    }

    int calcElementOffset(long r1) {
        int r0 = this.mask;
        return r0 & ((int) r1);
    }

    int calcElementOffset(long r1, int r3) {
        return ((int) r1) & r3;
    }

    @Override // io.reactivex.internal.a.f
    public void clear() {
    L3:
        if (poll() != null) goto L3;
        if (isEmpty() == false) goto L3;
    }

    @Override // io.reactivex.internal.a.f
    public boolean isEmpty() {
        if (this.producerIndex.get() != this.consumerIndex.get()) goto L5;
        return true;
    L5:
        return false;
    }

    E lvElement(int r1) {
        return get(r1);
    }

    @Override // io.reactivex.internal.a.f
    public boolean offer(E r7) {
        Objects.requireNonNull(r7, "Null is not a valid element");
        int r0 = this.mask;
        long r1 = this.producerIndex.get();
        int r3 = calcElementOffset(r1, r0);
        if (r1 < this.producerLookAhead) goto L11;
        long r4 = ((long) this.lookAheadStep) + r1;
        if (lvElement(calcElementOffset(r4, r0)) != null) goto L8;
        this.producerLookAhead = r4;
        goto L11
    L8:
        if (lvElement(r3) == null) goto L11;
        return false;
    L11:
        soElement(r3, r7);
        soProducerIndex(r1 + 1);
        return true;
    }

    public boolean offer(E r1, E r2) {
        if (offer(r1) == true) goto L5;
    L7:
        return false;
    L5:
        if (offer(r2) == false) goto L7;
        return true;
    }

    @Override // io.reactivex.internal.a.e, io.reactivex.internal.a.f
    public E poll() {
        long r0 = this.consumerIndex.get();
        int r2 = calcElementOffset(r0);
        E r3 = lvElement(r2);
        if (r3 != null) goto L5;
        return null;
    L5:
        soConsumerIndex(r0 + 1);
        soElement(r2, null);
        return r3;
    }

    void soConsumerIndex(long r1) {
        this.consumerIndex.lazySet(r1);
    }

    void soElement(int r1, E r2) {
        lazySet(r1, r2);
    }

    void soProducerIndex(long r1) {
        this.producerIndex.lazySet(r1);
    }
}
