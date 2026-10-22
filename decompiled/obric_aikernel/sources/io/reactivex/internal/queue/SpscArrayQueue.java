package io.reactivex.internal.queue;

import bc.e;
import io.reactivex.internal.util.g;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReferenceArray;

/* JADX INFO: loaded from: classes2.dex */
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

    public SpscArrayQueue(int r10) {
        super(g.a(r10));
        this.mask = length() - 1;
        this.producerIndex = new AtomicLong();
        this.consumerIndex = new AtomicLong();
        this.lookAheadStep = Math.min(r10 / 4, MAX_LOOK_AHEAD_STEP.intValue());
    }

    int calcElementOffset(long r10) {
        int r11 = this.mask;
        return r11 & ((int) r10);
    }

    int calcElementOffset(long r10, int r11) {
        return ((int) r10) & r11;
    }

    @Override // bc.f
    public void clear() {
    L3:
        if (poll() != null) goto L3;
        if (isEmpty() == false) goto L3;
    }

    @Override // bc.f
    public boolean isEmpty() {
        if (this.producerIndex.get() != this.consumerIndex.get()) goto L5;
        return true;
    L5:
        return false;
    }

    E lvElement(int r10) {
        return get(r10);
    }

    @Override // bc.f
    public boolean offer(E r10) {
        Objects.requireNonNull(r10, "Null is not a valid element");
        int r11 = this.mask;
        long r12 = this.producerIndex.get();
        int r13 = calcElementOffset(r12, r11);
        if (r12 < this.producerLookAhead) goto L11;
        long r14 = ((long) this.lookAheadStep) + r12;
        if (lvElement(calcElementOffset(r14, r11)) != null) goto L8;
        this.producerLookAhead = r14;
        goto L11
    L8:
        if (lvElement(r13) == null) goto L11;
        return false;
    L11:
        soElement(r13, r10);
        soProducerIndex(r12 + 1);
        return true;
    }

    public boolean offer(E r10, E r11) {
        if (offer(r10) == true) goto L5;
    L7:
        return false;
    L5:
        if (offer(r11) == false) goto L7;
        return true;
    }

    @Override // bc.e, bc.f
    public E poll() {
        long r10 = this.consumerIndex.get();
        int r11 = calcElementOffset(r10);
        E r12 = lvElement(r11);
        if (r12 != null) goto L5;
        return null;
    L5:
        soConsumerIndex(r10 + 1);
        soElement(r11, null);
        return r12;
    }

    void soConsumerIndex(long r10) {
        this.consumerIndex.lazySet(r10);
    }

    void soElement(int r10, E r11) {
        lazySet(r10, r11);
    }

    void soProducerIndex(long r10) {
        this.producerIndex.lazySet(r10);
    }
}
