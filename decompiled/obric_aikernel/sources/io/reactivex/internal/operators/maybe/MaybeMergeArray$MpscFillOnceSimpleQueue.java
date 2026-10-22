package io.reactivex.internal.operators.maybe;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReferenceArray;

/* JADX INFO: loaded from: classes2.dex */
final class MaybeMergeArray$MpscFillOnceSimpleQueue<T> extends AtomicReferenceArray<T> implements d<T> {
    private static final long serialVersionUID = -7969063454040569579L;
    int consumerIndex;
    final AtomicInteger producerIndex;

    MaybeMergeArray$MpscFillOnceSimpleQueue(int r10) {
        super(r10);
        this.producerIndex = new AtomicInteger();
    }

    @Override // bc.f
    public void clear() {
    L3:
        if (poll() == null) goto L7;
        if (isEmpty() == false) goto L3;
        return;
    }

    @Override // io.reactivex.internal.operators.maybe.d
    public int consumerIndex() {
        return this.consumerIndex;
    }

    @Override // io.reactivex.internal.operators.maybe.d
    public void drop() {
        int r10 = this.consumerIndex;
        lazySet(r10, null);
        this.consumerIndex = r10 + 1;
    }

    @Override // bc.f
    public boolean isEmpty() {
        if (this.consumerIndex != producerIndex()) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // bc.f
    public boolean offer(T r10) {
        io.reactivex.internal.functions.a.d(r10, "value is null");
        int r11 = this.producerIndex.getAndIncrement();
        if (r11 >= length()) goto L6;
        lazySet(r11, r10);
        return true;
    L6:
        return false;
    }

    public boolean offer(T r10, T r11) {
        throw new UnsupportedOperationException();
    }

    @Override // io.reactivex.internal.operators.maybe.d
    public T peek() {
        int r10 = this.consumerIndex;
        if (r10 != length()) goto L7;
        return null;
    L7:
        return get(r10);
    }

    @Override // io.reactivex.internal.operators.maybe.d, java.util.Queue, bc.f
    public T poll() {
        int r10 = this.consumerIndex;
        if (r10 != length()) goto L5;
        return null;
    L5:
        AtomicInteger r11 = this.producerIndex;
    L6:
        T r12 = get(r10);
        if (r12 != null) goto L8;
        if (r11.get() != r10) goto L6;
        return null;
    L8:
        this.consumerIndex = r10 + 1;
        lazySet(r10, null);
        return r12;
    }

    @Override // io.reactivex.internal.operators.maybe.d
    public int producerIndex() {
        return this.producerIndex.get();
    }
}
