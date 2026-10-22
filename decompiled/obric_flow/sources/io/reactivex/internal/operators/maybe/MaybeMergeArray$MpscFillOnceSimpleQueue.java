package io.reactivex.internal.operators.maybe;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReferenceArray;

/* JADX INFO: loaded from: classes3.dex */
final class MaybeMergeArray$MpscFillOnceSimpleQueue<T> extends AtomicReferenceArray<T> implements c {
    private static final long serialVersionUID = -7969063454040569579L;
    int consumerIndex;
    final AtomicInteger producerIndex;

    public MaybeMergeArray$MpscFillOnceSimpleQueue(int r5) {
        super(r5);
        this.producerIndex = new AtomicInteger();
    }

    @Override // rt.h
    public void clear() {
    L3:
        if (poll() == null) goto L7;
        if (isEmpty() == false) goto L3;
        return;
    }

    @Override // io.reactivex.internal.operators.maybe.c
    public int consumerIndex() {
        return this.consumerIndex;
    }

    @Override // io.reactivex.internal.operators.maybe.c
    public void drop() {
        int r5 = this.consumerIndex;
        lazySet(r5, null);
        this.consumerIndex = r5 + 1;
    }

    @Override // rt.h
    public boolean isEmpty() {
        if (this.consumerIndex != producerIndex()) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // rt.h
    public boolean offer(T r5) {
        io.reactivex.internal.functions.e.d(r5, "value is null");
        int r10 = this.producerIndex.getAndIncrement();
        if (r10 >= length()) goto L6;
        lazySet(r10, r5);
        return true;
    L6:
        return false;
    }

    @Override // io.reactivex.internal.operators.maybe.c
    public T peek() {
        int r5 = this.consumerIndex;
        if (r5 != length()) goto L7;
        return null;
    L7:
        return get(r5);
    }

    @Override // rt.h
    public T poll() {
        int r5 = this.consumerIndex;
        if (r5 != length()) goto L5;
        return null;
    L5:
        AtomicInteger r10 = this.producerIndex;
    L6:
        T r11 = get(r5);
        if (r11 != null) goto L8;
        if (r10.get() != r5) goto L6;
        return null;
    L8:
        this.consumerIndex = r5 + 1;
        lazySet(r5, null);
        return r11;
    }

    @Override // io.reactivex.internal.operators.maybe.c
    public int producerIndex() {
        return this.producerIndex.get();
    }

    public boolean offer(T r5, T r10) {
        throw new UnsupportedOperationException();
    }
}
