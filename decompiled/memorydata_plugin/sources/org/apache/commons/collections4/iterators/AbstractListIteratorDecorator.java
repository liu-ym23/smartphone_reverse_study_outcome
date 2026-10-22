package org.apache.commons.collections4.iterators;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ListIterator;
import java.util.Objects;

/* JADX INFO: loaded from: classes6.dex */
public class AbstractListIteratorDecorator<E> implements ListIterator<E> {
    private final ListIterator<E> iterator;

    public AbstractListIteratorDecorator(ListIterator<E> r3) {
        ListIterator<E> r4 = (ListIterator) ZeusTransformUtils.wrapperContextForParams(r3, ListIterator.class, "com.obric.memorydata.plugin");
        Objects.requireNonNull(r4, "ListIterator must not be null");
        this.iterator = r4;
    }

    @Override // java.util.ListIterator
    public void add(E r1) {
        this.iterator.add(r1);
    }

    public ListIterator<E> getListIterator() {
        return this.iterator;
    }

    @Override // java.util.ListIterator, java.util.Iterator
    public boolean hasNext() {
        return this.iterator.hasNext();
    }

    @Override // java.util.ListIterator
    public boolean hasPrevious() {
        return this.iterator.hasPrevious();
    }

    @Override // java.util.ListIterator, java.util.Iterator
    public E next() {
        return this.iterator.next();
    }

    @Override // java.util.ListIterator
    public int nextIndex() {
        return this.iterator.nextIndex();
    }

    @Override // java.util.ListIterator
    public E previous() {
        return this.iterator.previous();
    }

    @Override // java.util.ListIterator
    public int previousIndex() {
        return this.iterator.previousIndex();
    }

    @Override // java.util.ListIterator, java.util.Iterator
    public void remove() {
        this.iterator.remove();
    }

    @Override // java.util.ListIterator
    public void set(E r1) {
        this.iterator.set(r1);
    }
}
