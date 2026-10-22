package org.apache.commons.collections4.queue;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Collection;
import java.util.Iterator;
import java.util.Queue;
import java.util.function.Predicate;
import org.apache.commons.collections4.Unmodifiable;
import org.apache.commons.collections4.iterators.UnmodifiableIterator;

/* JADX INFO: loaded from: classes6.dex */
public final class UnmodifiableQueue<E> extends AbstractQueueDecorator<E> implements Unmodifiable {
    private static final long serialVersionUID = 1832948656215393357L;

    private UnmodifiableQueue(Queue<? extends E> r3) {
        super((Queue) ZeusTransformUtils.wrapperContextForParams(r3, Queue.class, "com.obric.memorydata.plugin"));
    }

    private void readObject(ObjectInputStream r3) {
        r3.defaultReadObject();
        setCollection((Collection) ZeusTransformUtils.preCheckCast(r3.readObject(), Collection.class, "com.obric.memorydata.plugin"));
    }

    public static <E> Queue<E> unmodifiableQueue(Queue<? extends E> r2) {
        Queue<E> r3 = (Queue) ZeusTransformUtils.wrapperContextForParams(r2, Queue.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r3, Unmodifiable.class) == false) goto L6;
        return r3;
    L6:
        return new UnmodifiableQueue(r3);
    }

    private void writeObject(ObjectOutputStream r1) {
        r1.defaultWriteObject();
        r1.writeObject(decorated());
    }

    @Override // org.apache.commons.collections4.collection.AbstractCollectionDecorator, java.util.Collection
    public boolean add(Object r1) {
        throw new UnsupportedOperationException();
    }

    @Override // org.apache.commons.collections4.collection.AbstractCollectionDecorator, java.util.Collection
    public boolean addAll(Collection<? extends E> r2) {
        Collection r1 = (Collection) ZeusTransformUtils.wrapperContextForParams(r2, Collection.class, "com.obric.memorydata.plugin");
        throw new UnsupportedOperationException();
    }

    @Override // org.apache.commons.collections4.collection.AbstractCollectionDecorator, java.util.Collection
    public void clear() {
        throw new UnsupportedOperationException();
    }

    @Override // org.apache.commons.collections4.collection.AbstractCollectionDecorator, java.util.Collection, java.lang.Iterable, org.apache.commons.collections4.Bag
    public Iterator<E> iterator() {
        return UnmodifiableIterator.unmodifiableIterator(decorated().iterator());
    }

    @Override // org.apache.commons.collections4.queue.AbstractQueueDecorator, java.util.Queue
    public boolean offer(E r1) {
        throw new UnsupportedOperationException();
    }

    @Override // org.apache.commons.collections4.queue.AbstractQueueDecorator, java.util.Queue
    public E poll() {
        throw new UnsupportedOperationException();
    }

    @Override // org.apache.commons.collections4.queue.AbstractQueueDecorator, java.util.Queue
    public E remove() {
        throw new UnsupportedOperationException();
    }

    @Override // org.apache.commons.collections4.collection.AbstractCollectionDecorator, java.util.Collection
    public boolean remove(Object r1) {
        throw new UnsupportedOperationException();
    }

    @Override // org.apache.commons.collections4.collection.AbstractCollectionDecorator, java.util.Collection, org.apache.commons.collections4.Bag
    public boolean removeAll(Collection<?> r2) {
        Collection r1 = (Collection) ZeusTransformUtils.wrapperContextForParams(r2, Collection.class, "com.obric.memorydata.plugin");
        throw new UnsupportedOperationException();
    }

    @Override // org.apache.commons.collections4.collection.AbstractCollectionDecorator, java.util.Collection
    public boolean removeIf(Predicate<? super E> r2) {
        Predicate r1 = (Predicate) ZeusTransformUtils.wrapperContextForParams(r2, Predicate.class, "com.obric.memorydata.plugin");
        throw new UnsupportedOperationException();
    }

    @Override // org.apache.commons.collections4.collection.AbstractCollectionDecorator, java.util.Collection, org.apache.commons.collections4.Bag
    public boolean retainAll(Collection<?> r2) {
        Collection r1 = (Collection) ZeusTransformUtils.wrapperContextForParams(r2, Collection.class, "com.obric.memorydata.plugin");
        throw new UnsupportedOperationException();
    }
}
