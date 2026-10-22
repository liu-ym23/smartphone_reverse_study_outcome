package io.reactivex.internal.operators.maybe;

import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes2.dex */
final class MaybeMergeArray$ClqSimpleQueue<T> extends ConcurrentLinkedQueue<T> implements d<T> {
    private static final long serialVersionUID = -4025173261791142821L;
    int consumerIndex;
    final AtomicInteger producerIndex;

    MaybeMergeArray$ClqSimpleQueue() {
        this.producerIndex = new AtomicInteger();
    }

    @Override // io.reactivex.internal.operators.maybe.d
    public int consumerIndex() {
        return this.consumerIndex;
    }

    @Override // io.reactivex.internal.operators.maybe.d
    public void drop() {
        poll();
    }

    @Override // java.util.concurrent.ConcurrentLinkedQueue, java.util.Queue, bc.f
    public boolean offer(T r10) {
        this.producerIndex.getAndIncrement();
        return super.offer(r10);
    }

    public boolean offer(T r10, T r11) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.concurrent.ConcurrentLinkedQueue, java.util.Queue, io.reactivex.internal.operators.maybe.d, bc.f
    public T poll() {
        T r10 = (T) super.poll();
        if (r10 == null) goto L5;
        this.consumerIndex++;
    L5:
        return r10;
    }

    @Override // io.reactivex.internal.operators.maybe.d
    public int producerIndex() {
        return this.producerIndex.get();
    }
}
