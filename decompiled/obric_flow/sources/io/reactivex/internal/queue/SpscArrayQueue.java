package io.reactivex.internal.queue;

import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReferenceArray;
import rt.g;

/* JADX INFO: loaded from: classes3.dex */
public final class SpscArrayQueue<E> extends AtomicReferenceArray<E> implements g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Integer f18110a = null;
    private static final long serialVersionUID = -1296597691183856449L;
    final AtomicLong consumerIndex;
    final int lookAheadStep;
    final int mask;
    final AtomicLong producerIndex;
    long producerLookAhead;

    static {
        f18110a = Integer.getInteger("jctools.spsc.max.lookahead.step", 4096);
    }

    public SpscArrayQueue(int r5) {
        super(1 << (32 - Integer.numberOfLeadingZeros(r5 - 1)));
        this.mask = length() - 1;
        this.producerIndex = new AtomicLong();
        this.consumerIndex = new AtomicLong();
        this.lookAheadStep = Math.min(r5 / 4, f18110a.intValue());
    }

    public int calcElementOffset(long r5, int r10) {
        return ((int) r5) & r10;
    }

    @Override // rt.h
    public void clear() {
    L3:
        if (poll() != null) goto L3;
        if (isEmpty() == false) goto L3;
    }

    @Override // rt.h
    public boolean isEmpty() {
        if (this.producerIndex.get() != this.consumerIndex.get()) goto L5;
        return true;
    L5:
        return false;
    }

    public E lvElement(int r5) {
        return get(r5);
    }

    @Override // rt.h
    public boolean offer(E r10) {
        if (r10 == null) goto L15;
        int r5 = this.mask;
        long r11 = this.producerIndex.get();
        int r12 = calcElementOffset(r11, r5);
        if (r11 < this.producerLookAhead) goto L12;
        long r13 = ((long) this.lookAheadStep) + r11;
        if (lvElement(calcElementOffset(r13, r5)) != null) goto L9;
        this.producerLookAhead = r13;
        goto L12
    L9:
        if (lvElement(r12) == null) goto L12;
        return false;
    L12:
        soElement(r12, r10);
        soProducerIndex(r11 + 1);
        return true;
    L15:
        throw new NullPointerException("Null is not a valid element");
    }

    @Override // rt.h
    public E poll() {
        long r5 = this.consumerIndex.get();
        int r10 = calcElementOffset(r5);
        E r11 = lvElement(r10);
        if (r11 != null) goto L5;
        return null;
    L5:
        soConsumerIndex(r5 + 1);
        soElement(r10, null);
        return r11;
    }

    public void soConsumerIndex(long r5) {
        this.consumerIndex.lazySet(r5);
    }

    public void soElement(int r5, E r10) {
        lazySet(r5, r10);
    }

    public void soProducerIndex(long r5) {
        this.producerIndex.lazySet(r5);
    }

    public int calcElementOffset(long r5) {
        int r10 = this.mask;
        return r10 & ((int) r5);
    }

    public boolean offer(E r5, E r10) {
        if (offer(r5) == true) goto L5;
    L7:
        return false;
    L5:
        if (offer(r10) == false) goto L7;
        return true;
    }
}
