package org.apache.commons.collections4.iterators;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ListIterator;
import java.util.Objects;
import org.apache.commons.collections4.Unmodifiable;

/* JADX INFO: loaded from: classes6.dex */
public final class UnmodifiableListIterator<E> implements ListIterator<E>, Unmodifiable {
    private final ListIterator<? extends E> iterator;

    private UnmodifiableListIterator(ListIterator<? extends E> r3) {
        this.iterator = (ListIterator) ZeusTransformUtils.wrapperContextForParams(r3, ListIterator.class, "com.obric.memorydata.plugin");
    }

    public static <E> ListIterator<E> umodifiableListIterator(ListIterator<? extends E> r2) {
        ListIterator<E> r3 = (ListIterator) ZeusTransformUtils.wrapperContextForParams(r2, ListIterator.class, "com.obric.memorydata.plugin");
        Objects.requireNonNull(r3, "ListIterator must not be null");
        if (ZeusTransformUtils.instanceOf(r3, Unmodifiable.class) == false) goto L6;
        return r3;
    L6:
        return new UnmodifiableListIterator(r3);
    }

    @Override // java.util.ListIterator
    public void add(E r1) {
        throw new UnsupportedOperationException("add() is not supported");
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
        throw new UnsupportedOperationException("remove() is not supported");
    }

    @Override // java.util.ListIterator
    public void set(E r1) {
        throw new UnsupportedOperationException("set() is not supported");
    }
}
