package org.apache.commons.collections4.collection;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.Serializable;
import java.util.Collection;
import java.util.Iterator;
import java.util.Objects;
import java.util.function.Predicate;

/* JADX INFO: loaded from: classes6.dex */
public abstract class AbstractCollectionDecorator<E> implements Serializable, Collection<E> {
    private static final long serialVersionUID = 6249888059822088500L;
    private Collection<E> collection;

    public AbstractCollectionDecorator() {
    }

    public AbstractCollectionDecorator(Collection<E> r3) {
        Collection<E> r4 = (Collection) ZeusTransformUtils.wrapperContextForParams(r3, Collection.class, "com.obric.memorydata.plugin");
        Objects.requireNonNull(r4, "Collection must not be null.");
        this.collection = r4;
    }

    public boolean add(E r1) {
        return decorated().add(r1);
    }

    public boolean addAll(Collection<? extends E> r3) {
        Collection<? extends E> r4 = (Collection) ZeusTransformUtils.wrapperContextForParams(r3, Collection.class, "com.obric.memorydata.plugin");
        return decorated().addAll(r4);
    }

    public void clear() {
        decorated().clear();
    }

    public boolean contains(Object r1) {
        return decorated().contains(r1);
    }

    public boolean containsAll(Collection<?> r3) {
        Collection<?> r4 = (Collection) ZeusTransformUtils.wrapperContextForParams(r3, Collection.class, "com.obric.memorydata.plugin");
        return decorated().containsAll(r4);
    }

    public Collection<E> decorated() {
        return this.collection;
    }

    @Override // java.util.Collection
    public boolean isEmpty() {
        return decorated().isEmpty();
    }

    public Iterator<E> iterator() {
        return decorated().iterator();
    }

    public boolean remove(Object r1) {
        return decorated().remove(r1);
    }

    public boolean removeAll(Collection<?> r3) {
        Collection<?> r4 = (Collection) ZeusTransformUtils.wrapperContextForParams(r3, Collection.class, "com.obric.memorydata.plugin");
        return decorated().removeAll(r4);
    }

    public boolean removeIf(Predicate<? super E> r3) {
        Predicate<? super E> r4 = (Predicate) ZeusTransformUtils.wrapperContextForParams(r3, Predicate.class, "com.obric.memorydata.plugin");
        return decorated().removeIf(r4);
    }

    public boolean retainAll(Collection<?> r3) {
        Collection<?> r4 = (Collection) ZeusTransformUtils.wrapperContextForParams(r3, Collection.class, "com.obric.memorydata.plugin");
        return decorated().retainAll(r4);
    }

    public void setCollection(Collection<E> r3) {
        this.collection = (Collection) ZeusTransformUtils.wrapperContextForParams(r3, Collection.class, "com.obric.memorydata.plugin");
    }

    @Override // java.util.Collection
    public int size() {
        return decorated().size();
    }

    @Override // java.util.Collection
    public Object[] toArray() {
        return decorated().toArray();
    }

    @Override // java.util.Collection
    public <T> T[] toArray(T[] r1) {
        return (T[]) decorated().toArray(r1);
    }

    public String toString() {
        return decorated().toString();
    }
}
