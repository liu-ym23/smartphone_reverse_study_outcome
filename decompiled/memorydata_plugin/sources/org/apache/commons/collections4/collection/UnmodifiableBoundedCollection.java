package org.apache.commons.collections4.collection;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Collection;
import java.util.Iterator;
import java.util.Objects;
import java.util.function.Predicate;
import org.apache.commons.collections4.BoundedCollection;
import org.apache.commons.collections4.Unmodifiable;
import org.apache.commons.collections4.iterators.UnmodifiableIterator;

/* JADX INFO: loaded from: classes6.dex */
public final class UnmodifiableBoundedCollection<E> extends AbstractCollectionDecorator<E> implements BoundedCollection<E>, Unmodifiable {
    private static final long serialVersionUID = -7112672385450340330L;

    private UnmodifiableBoundedCollection(BoundedCollection<? extends E> r3) {
        super((BoundedCollection) ZeusTransformUtils.wrapperContextForParams(r3, BoundedCollection.class, "com.obric.memorydata.plugin"));
    }

    public static <E> BoundedCollection<E> unmodifiableBoundedCollection(Collection<? extends E> r3) {
        Collection<E> r4 = (Collection) ZeusTransformUtils.wrapperContextForParams(r3, Collection.class, "com.obric.memorydata.plugin");
        Objects.requireNonNull(r4, "Collection must not be null.");
        int r0 = 0;
    L4:
        if (r0 >= 1000) goto L16;
        if (ZeusTransformUtils.instanceOf(r4, BoundedCollection.class) == true) goto L16;
        if (ZeusTransformUtils.instanceOf(r4, AbstractCollectionDecorator.class) == false) goto L12;
        r4 = ((AbstractCollectionDecorator) ZeusTransformUtils.preCheckCast(r4, AbstractCollectionDecorator.class, "com.obric.memorydata.plugin")).decorated();
    L14:
        r0 = r0 + 1;
        goto L4
    L12:
        if (ZeusTransformUtils.instanceOf(r4, SynchronizedCollection.class) == false) goto L14;
        r4 = ((SynchronizedCollection) ZeusTransformUtils.preCheckCast(r4, SynchronizedCollection.class, "com.obric.memorydata.plugin")).decorated();
    L16:
        if (ZeusTransformUtils.instanceOf(r4, BoundedCollection.class) == false) goto L20;
        return new UnmodifiableBoundedCollection((BoundedCollection) ZeusTransformUtils.preCheckCast(r4, BoundedCollection.class, "com.obric.memorydata.plugin"));
    L20:
        throw new IllegalArgumentException("Collection is not a bounded collection.");
    }

    public static <E> BoundedCollection<E> unmodifiableBoundedCollection(BoundedCollection<? extends E> r2) {
        BoundedCollection<E> r3 = (BoundedCollection) ZeusTransformUtils.wrapperContextForParams(r2, BoundedCollection.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r3, Unmodifiable.class) == false) goto L6;
        return r3;
    L6:
        return new UnmodifiableBoundedCollection(r3);
    }

    @Override // org.apache.commons.collections4.collection.AbstractCollectionDecorator, java.util.Collection
    public boolean add(E r1) {
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

    @Override // org.apache.commons.collections4.collection.AbstractCollectionDecorator
    public /* bridge */ /* synthetic */ Collection decorated() {
        return decorated();
    }

    @Override // org.apache.commons.collections4.collection.AbstractCollectionDecorator
    public BoundedCollection<E> decorated() {
        return (BoundedCollection) ZeusTransformUtils.preCheckCast(super.decorated(), BoundedCollection.class, "com.obric.memorydata.plugin");
    }

    @Override // org.apache.commons.collections4.BoundedCollection
    public boolean isFull() {
        return decorated().isFull();
    }

    @Override // org.apache.commons.collections4.collection.AbstractCollectionDecorator, java.util.Collection, java.lang.Iterable, org.apache.commons.collections4.Bag
    public Iterator<E> iterator() {
        return UnmodifiableIterator.unmodifiableIterator(decorated().iterator());
    }

    @Override // org.apache.commons.collections4.BoundedCollection
    public int maxSize() {
        return decorated().maxSize();
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
