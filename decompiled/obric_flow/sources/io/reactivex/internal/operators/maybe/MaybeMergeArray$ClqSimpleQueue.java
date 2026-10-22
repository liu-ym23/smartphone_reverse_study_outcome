package io.reactivex.internal.operators.maybe;

import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes3.dex */
final class MaybeMergeArray$ClqSimpleQueue<T> extends ConcurrentLinkedQueue<T> implements c {
    private static final long serialVersionUID = -4025173261791142821L;
    int consumerIndex;
    final AtomicInteger producerIndex;

    public MaybeMergeArray$ClqSimpleQueue() {
        this.producerIndex = new AtomicInteger();
    }

    @Override // io.reactivex.internal.operators.maybe.c
    public int consumerIndex() {
        return this.consumerIndex;
    }

    @Override // io.reactivex.internal.operators.maybe.c
    public void drop() {
        poll();
    }

    public boolean offer(T r5, T r10) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.concurrent.ConcurrentLinkedQueue, java.util.Queue, rt.h
    public T poll() {
        T r5 = (T) super.poll();
        if (r5 == null) goto L5;
        this.consumerIndex++;
    L5:
        return r5;
    }

    @Override // io.reactivex.internal.operators.maybe.c
    public int producerIndex() {
        return this.producerIndex.get();
    }

    @Override // java.util.concurrent.ConcurrentLinkedQueue, java.util.Queue, rt.h
    public boolean offer(T r5) {
        this.producerIndex.getAndIncrement();
        return super.offer(r5);
    }
}
