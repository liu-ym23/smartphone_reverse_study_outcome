package com.google.common.collect;

import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.AbstractCollection;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.Spliterator;
import java.util.Spliterators;
import java.util.function.Predicate;

/* JADX INFO: loaded from: classes2.dex */
public abstract class ImmutableCollection<E> extends AbstractCollection<E> implements Serializable {
    static final int SPLITERATOR_CHARACTERISTICS = 1296;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Object[] f8816a = null;

    static {
        f8816a = new Object[0];
    }

    public ImmutableCollection() {
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    @Deprecated
    public final boolean add(E r5) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    @Deprecated
    public final boolean addAll(Collection<? extends E> r5) {
        throw new UnsupportedOperationException();
    }

    public ImmutableList<E> asList() {
        int r5 = size();
        if (r5 == 0) goto L11;
        if (r5 == 1) goto L9;
        return new RegularImmutableAsList(this, toArray());
    L9:
        return ImmutableList.of(iterator().next());
    L11:
        return ImmutableList.of();
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    @Deprecated
    public final void clear() {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public abstract boolean contains(Object r5);

    public int copyIntoArray(Object[] r5, int r10) {
        ga r11 = iterator();
    L4:
        if (r11.hasNext() == false) goto L6;
        r5[r10] = r11.next();
        r10 = r10 + 1;
        goto L4
    L6:
        return r10;
    }

    public Object[] internalArray() {
        return null;
    }

    public int internalArrayEnd() {
        throw new UnsupportedOperationException();
    }

    public int internalArrayStart() {
        throw new UnsupportedOperationException();
    }

    public abstract boolean isPartialView();

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set, java.util.NavigableSet
    public abstract ga iterator();

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public /* bridge */ /* synthetic */ Iterator iterator() {
        return iterator();
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    @Deprecated
    public final boolean remove(Object r5) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    @Deprecated
    public final boolean removeAll(Collection<?> r5) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Collection
    @Deprecated
    public final boolean removeIf(Predicate<? super E> r5) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    @Deprecated
    public final boolean retainAll(Collection<?> r5) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Collection, java.lang.Iterable
    public Spliterator<E> spliterator() {
        return Spliterators.spliterator(this, SPLITERATOR_CHARACTERISTICS);
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final Object[] toArray() {
        return toArray(f8816a);
    }

    public Object writeReplace() {
        return new ImmutableList.SerializedForm(toArray());
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final <T> T[] toArray(T[] r5) {
        r5.getClass();
        int r10 = size();
        if (r5.length >= r10) goto L10;
        Object[] r11 = internalArray();
        if (r11 == null) goto L8;
        int r12 = internalArrayStart();
        int r13 = internalArrayEnd();
        int r14 = h8.f9015a;
        return (T[]) Arrays.copyOfRange(r11, r12, r13, r5.getClass());
    L8:
        int r15 = h8.f9015a;
        r5 = (T[]) ((Object[]) Array.newInstance(r5.getClass().getComponentType(), r10));
    L12:
        copyIntoArray(r5, 0);
        return r5;
    L10:
        if (r5.length <= r10) goto L12;
        r5[r10] = null;
        goto L12
    }
}
