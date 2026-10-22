package io.reactivex.internal.queue;

import bc.e;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes2.dex */
public final class MpscLinkedQueue<T> implements e<T> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final AtomicReference<LinkedQueueNode<T>> f9598c;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final AtomicReference<LinkedQueueNode<T>> f9599g;

    static final class LinkedQueueNode<E> extends AtomicReference<LinkedQueueNode<E>> {
        private static final long serialVersionUID = 2404266111789071508L;
        private E value;

        LinkedQueueNode() {
        }

        LinkedQueueNode(E r10) {
            spValue(r10);
        }

        public E getAndNullValue() {
            E r10 = lpValue();
            spValue(null);
            return r10;
        }

        public E lpValue() {
            return this.value;
        }

        public LinkedQueueNode<E> lvNext() {
            return get();
        }

        public void soNext(LinkedQueueNode<E> r10) {
            lazySet(r10);
        }

        public void spValue(E r10) {
            this.value = r10;
        }
    }

    public MpscLinkedQueue() {
        this.f9598c = new AtomicReference();
        this.f9599g = new AtomicReference();
        LinkedQueueNode<T> r10 = new LinkedQueueNode();
        d(r10);
        e(r10);
    }

    LinkedQueueNode<T> a() {
        return this.f9599g.get();
    }

    LinkedQueueNode<T> b() {
        return this.f9599g.get();
    }

    LinkedQueueNode<T> c() {
        return this.f9598c.get();
    }

    @Override // bc.f
    public void clear() {
    L3:
        if (poll() == null) goto L7;
        if (isEmpty() == false) goto L3;
        return;
    }

    void d(LinkedQueueNode<T> r10) {
        this.f9599g.lazySet(r10);
    }

    LinkedQueueNode<T> e(LinkedQueueNode<T> r10) {
        return this.f9598c.getAndSet(r10);
    }

    @Override // bc.f
    public boolean isEmpty() {
        if (b() != c()) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // bc.f
    public boolean offer(T r10) {
        Objects.requireNonNull(r10, "Null is not a valid element");
        LinkedQueueNode<T> r11 = new LinkedQueueNode(r10);
        e(r11).soNext(r11);
        return true;
    }

    @Override // bc.e, bc.f
    public T poll() {
        LinkedQueueNode<T> r10 = a();
        LinkedQueueNode<T> r11 = r10.lvNext();
        if (r11 == null) goto L7;
    L4:
        T r12 = r11.getAndNullValue();
        d(r11);
        return r12;
    L7:
        if (r10 == c()) goto L11;
    L8:
        r11 = r10.lvNext();
        if (r11 != null) goto L4;
    L11:
        return null;
    }
}
