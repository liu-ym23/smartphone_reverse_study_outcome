package io.reactivex.internal.queue;

import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes3.dex */
final class MpscLinkedQueue$LinkedQueueNode<E> extends AtomicReference<MpscLinkedQueue$LinkedQueueNode<E>> {
    private static final long serialVersionUID = 2404266111789071508L;
    private E value;

    public MpscLinkedQueue$LinkedQueueNode() {
    }

    public E getAndNullValue() {
        E r5 = lpValue();
        spValue(null);
        return r5;
    }

    public E lpValue() {
        return this.value;
    }

    public MpscLinkedQueue$LinkedQueueNode<E> lvNext() {
        return get();
    }

    public void soNext(MpscLinkedQueue$LinkedQueueNode<E> r5) {
        lazySet(r5);
    }

    public void spValue(E r5) {
        this.value = r5;
    }

    public MpscLinkedQueue$LinkedQueueNode(E r5) {
        spValue(r5);
    }
}
