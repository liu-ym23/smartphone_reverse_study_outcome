package org.apache.commons.collections4.queue;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Queue;
import org.apache.commons.collections4.Transformer;
import org.apache.commons.collections4.collection.TransformedCollection;

/* JADX INFO: loaded from: classes6.dex */
public class TransformedQueue<E> extends TransformedCollection<E> implements Queue<E> {
    private static final long serialVersionUID = -7901091318986132033L;

    public TransformedQueue(Queue<E> r3, Transformer<? super E, ? extends E> r4) {
        super((Queue) ZeusTransformUtils.wrapperContextForParams(r3, Queue.class, "com.obric.memorydata.plugin"), (Transformer) ZeusTransformUtils.wrapperContextForParams(r4, Transformer.class, "com.obric.memorydata.plugin"));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static <E> TransformedQueue<E> transformedQueue(Queue<E> r5, Transformer<? super E, ? extends E> r6) {
        Queue r7 = (Queue) ZeusTransformUtils.wrapperContextForParams(r5, Queue.class, "com.obric.memorydata.plugin");
        Transformer r8 = (Transformer) ZeusTransformUtils.wrapperContextForParams(r6, Transformer.class, "com.obric.memorydata.plugin");
        TransformedQueue<E> r0 = new TransformedQueue(r7, r8);
        if (r7.size() <= 0) goto L7;
        Object[] r1 = (Object[]) ZeusTransformUtils.preCheckCast(r7.toArray(), Object[].class, "com.obric.memorydata.plugin");
        r7.clear();
        int r9 = r1.length;
        int r2 = 0;
    L5:
        if (r2 >= r9) goto L7;
        Object r3 = r1[r2];
        r0.decorated().add(r8.transform(r3));
        r2 = r2 + 1;
    L7:
        return r0;
    }

    public static <E> TransformedQueue<E> transformingQueue(Queue<E> r2, Transformer<? super E, ? extends E> r3) {
        return new TransformedQueue((Queue) ZeusTransformUtils.wrapperContextForParams(r2, Queue.class, "com.obric.memorydata.plugin"), (Transformer) ZeusTransformUtils.wrapperContextForParams(r3, Transformer.class, "com.obric.memorydata.plugin"));
    }

    @Override // java.util.Queue
    public E element() {
        return getQueue().element();
    }

    public Queue<E> getQueue() {
        return (Queue) ZeusTransformUtils.preCheckCast(decorated(), Queue.class, "com.obric.memorydata.plugin");
    }

    @Override // java.util.Queue
    public boolean offer(E r2) {
        return getQueue().offer(transform(r2));
    }

    @Override // java.util.Queue
    public E peek() {
        return getQueue().peek();
    }

    @Override // java.util.Queue
    public E poll() {
        return getQueue().poll();
    }

    @Override // java.util.Queue
    public E remove() {
        return getQueue().remove();
    }
}
