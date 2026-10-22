package io.reactivex.internal.queue;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import io.reactivex.internal.a.e;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes6.dex */
public final class MpscLinkedQueue<T> implements e<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final AtomicReference<LinkedQueueNode<T>> f17105a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final AtomicReference<LinkedQueueNode<T>> f17106b;

    static final class LinkedQueueNode<E> extends AtomicReference<LinkedQueueNode<E>> {
        private static final long serialVersionUID = 2404266111789071508L;
        private E value;

        LinkedQueueNode() {
        }

        LinkedQueueNode(E r1) {
            spValue(r1);
        }

        public E getAndNullValue() {
            E r0 = lpValue();
            spValue(null);
            return r0;
        }

        public E lpValue() {
            return this.value;
        }

        public LinkedQueueNode<E> lvNext() {
            return (LinkedQueueNode) ZeusTransformUtils.preCheckCast(get(), LinkedQueueNode.class, "com.obric.memorydata.plugin");
        }

        public void soNext(LinkedQueueNode<E> r1) {
            lazySet(r1);
        }

        public void spValue(E r1) {
            this.value = r1;
        }
    }

    public MpscLinkedQueue() {
        this.f17105a = new AtomicReference();
        this.f17106b = new AtomicReference();
        LinkedQueueNode<T> r0 = new LinkedQueueNode();
        b(r0);
        a(r0);
    }

    LinkedQueueNode<T> a() {
        return (LinkedQueueNode) ZeusTransformUtils.preCheckCast(this.f17105a.get(), LinkedQueueNode.class, "com.obric.memorydata.plugin");
    }

    LinkedQueueNode<T> a(LinkedQueueNode<T> r2) {
        return (LinkedQueueNode) ZeusTransformUtils.preCheckCast(this.f17105a.getAndSet(r2), LinkedQueueNode.class, "com.obric.memorydata.plugin");
    }

    LinkedQueueNode<T> b() {
        return (LinkedQueueNode) ZeusTransformUtils.preCheckCast(this.f17106b.get(), LinkedQueueNode.class, "com.obric.memorydata.plugin");
    }

    void b(LinkedQueueNode<T> r1) {
        this.f17106b.lazySet(r1);
    }

    LinkedQueueNode<T> c() {
        return (LinkedQueueNode) ZeusTransformUtils.preCheckCast(this.f17106b.get(), LinkedQueueNode.class, "com.obric.memorydata.plugin");
    }

    @Override // io.reactivex.internal.a.f
    public void clear() {
    L3:
        if (poll() == null) goto L7;
        if (isEmpty() == false) goto L3;
        return;
    }

    @Override // io.reactivex.internal.a.f
    public boolean isEmpty() {
        if (b() != a()) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // io.reactivex.internal.a.f
    public boolean offer(T r2) {
        Objects.requireNonNull(r2, "Null is not a valid element");
        LinkedQueueNode<T> r0 = new LinkedQueueNode(r2);
        a(r0).soNext(r0);
        return true;
    }

    @Override // io.reactivex.internal.a.e, io.reactivex.internal.a.f
    public T poll() {
        LinkedQueueNode<T> r0 = c();
        LinkedQueueNode<T> r1 = r0.lvNext();
        if (r1 == null) goto L7;
    L4:
        T r2 = r1.getAndNullValue();
        b(r1);
        return r2;
    L7:
        if (r0 == a()) goto L11;
    L8:
        r1 = r0.lvNext();
        if (r1 != null) goto L4;
    L11:
        return null;
    }
}
