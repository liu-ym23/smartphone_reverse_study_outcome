package com.google.common.collect;

import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.Spliterator;
import java.util.function.Consumer;

/* JADX INFO: loaded from: classes2.dex */
final class RegularImmutableSortedSet<E> extends ImmutableSortedSet<E> {
    static final RegularImmutableSortedSet<Comparable> NATURAL_EMPTY_SET = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final transient ImmutableList f8864c;

    static {
        NATURAL_EMPTY_SET = new RegularImmutableSortedSet(ImmutableList.of(), g8.natural());
    }

    public RegularImmutableSortedSet(ImmutableList<E> r5, Comparator<? super E> r10) {
        super(r10);
        this.f8864c = r5;
    }

    @Override // com.google.common.collect.ImmutableSortedSet, java.util.NavigableSet
    public E ceiling(E r5) {
        int r10 = tailIndex(r5, true);
        if (r10 != size()) goto L6;
        return null;
    L6:
        return this.f8864c.get(r10);
    }

    @Override // com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean contains(Object r5) {
        if (r5 == null) goto L11;
        if (Collections.binarySearch(this.f8864c, r5, unsafeComparator()) < 0) goto L12;
        return true;
    L12:
        return false;
    L13:
        return false;
    L11:
        return false;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean containsAll(Collection<?> r10) {
        if ((r10 instanceof z7) == false) goto L6;
        r10 = ((z7) r10).elementSet();
    L6:
        if (p7.I(comparator(), r10) == false) goto L29;
        if (r10.size() <= 1) goto L29;
        ga r5 = iterator();
        Iterator<?> r11 = r10.iterator();
        if (r5.hasNext() == true) goto L13;
        return false;
    L13:
        Object r12 = r11.next();
        Object r13 = r5.next();
    L31:
        int r14 = unsafeCompare(r13, r12);     // Catch: Throwable -> L30
        if (r14 < 0) goto L17;
        if (r14 == 0) goto L22;
        if (r14 <= 0) goto L31;
    L22:
        if (r11.hasNext() == false) goto L23;
        r12 = r11.next();     // Catch: Throwable -> L30
        goto L31
    L23:
        return true;
    L17:
        if (r5.hasNext() == false) goto L18;
        r13 = r5.next();     // Catch: Throwable -> L30
        goto L31
    L18:
        return false;
    L27:
        return false;
    L29:
        return super.containsAll(r10);
    }

    @Override // com.google.common.collect.ImmutableCollection
    public int copyIntoArray(Object[] r5, int r10) {
        return this.f8864c.copyIntoArray(r5, r10);
    }

    @Override // com.google.common.collect.ImmutableSet.CachingAsList
    public ImmutableList<E> createAsList() {
        int r5 = size();
        ImmutableList<E> r10 = this.f8864c;
        if (r5 > 1) goto L6;
        return r10;
    L6:
        return new ImmutableSortedAsList(this, r10);
    }

    @Override // com.google.common.collect.ImmutableSortedSet
    public ImmutableSortedSet<E> createDescendingSet() {
        Comparator r5 = Collections.reverseOrder(this.comparator);
        if (isEmpty() == false) goto L6;
        return ImmutableSortedSet.emptySet(r5);
    L6:
        return new RegularImmutableSortedSet(this.f8864c.reverse(), r5);
    }

    @Override // com.google.common.collect.ImmutableSortedSet, java.util.NavigableSet
    public /* bridge */ /* synthetic */ Iterator descendingIterator() {
        return descendingIterator();
    }

    @Override // com.google.common.collect.ImmutableSet, java.util.Collection, java.util.Set
    public boolean equals(Object r10) {
        if (r10 != this) goto L6;
        return true;
    L6:
        if ((r10 instanceof Set) == true) goto L8;
        return false;
    L8:
        Set r11 = (Set) r10;
        if (size() == r11.size()) goto L12;
        return false;
    L12:
        if (isEmpty() == false) goto L15;
        return true;
    L15:
        if (p7.I(this.comparator, r11) == false) goto L28;
        Iterator<E> r12 = r11.iterator();
        ga r5 = iterator();     // Catch: Throwable -> L26
    L19:
        if (r5.hasNext() == false) goto L25;
        Object r13 = r5.next();     // Catch: Throwable -> L26
        E r14 = r12.next();     // Catch: Throwable -> L26
        if (r14 == null) goto L24;
        if (unsafeCompare(r13, r14) == 0) goto L19;
    L24:
        return false;
    L25:
        return true;
    L26:
        return false;
    L28:
        return containsAll(r11);
    }

    @Override // com.google.common.collect.ImmutableSortedSet, java.util.SortedSet
    public E first() {
        if (isEmpty() == true) goto L7;
        return this.f8864c.get(0);
    L7:
        throw new NoSuchElementException();
    }

    @Override // com.google.common.collect.ImmutableSortedSet, java.util.NavigableSet
    public E floor(E r5) {
        int r10 = headIndex(r5, true) - 1;
        if (r10 != (-1)) goto L6;
        return null;
    L6:
        return this.f8864c.get(r10);
    }

    @Override // java.lang.Iterable
    public void forEach(Consumer<? super E> r5) {
        this.f8864c.forEach(r5);
    }

    public RegularImmutableSortedSet<E> getSubSet(int r5, int r10) {
        if (r5 == 0) goto L4;
    L6:
        if (r5 >= r10) goto L10;
        return new RegularImmutableSortedSet(this.f8864c.subList(r5, r10), this.comparator);
    L10:
        return ImmutableSortedSet.emptySet(this.comparator);
    L4:
        if (r10 != size()) goto L6;
        return this;
    }

    public int headIndex(E r5, boolean r10) {
        r5.getClass();
        Comparator<? super E> r11 = comparator();
        int r12 = Collections.binarySearch(this.f8864c, r5, r11);
        if (r12 < 0) goto L8;
        if (r10 == true) goto L6;
        return r12;
    L6:
        return r12 + 1;
    L8:
        return ~r12;
    }

    @Override // com.google.common.collect.ImmutableSortedSet
    public ImmutableSortedSet<E> headSetImpl(E r5, boolean r10) {
        return getSubSet(0, headIndex(r5, r10));
    }

    @Override // com.google.common.collect.ImmutableSortedSet, java.util.NavigableSet
    public E higher(E r5) {
        int r10 = tailIndex(r5, false);
        if (r10 != size()) goto L6;
        return null;
    L6:
        return this.f8864c.get(r10);
    }

    @Override // com.google.common.collect.ImmutableSortedSet
    public int indexOf(Object r5) {
        if (r5 != null) goto L10;
        return -1;
    L10:
        int r10 = Collections.binarySearch(this.f8864c, r5, unsafeComparator());     // Catch: ClassCastException -> L9
        if (r10 >= 0) goto L8;
        return -1;
    L8:
        return r10;
    L13:
        return -1;
    }

    @Override // com.google.common.collect.ImmutableCollection
    public Object[] internalArray() {
        return this.f8864c.internalArray();
    }

    @Override // com.google.common.collect.ImmutableCollection
    public int internalArrayEnd() {
        return this.f8864c.internalArrayEnd();
    }

    @Override // com.google.common.collect.ImmutableCollection
    public int internalArrayStart() {
        return this.f8864c.internalArrayStart();
    }

    @Override // com.google.common.collect.ImmutableCollection
    public boolean isPartialView() {
        return this.f8864c.isPartialView();
    }

    @Override // com.google.common.collect.ImmutableSortedSet, com.google.common.collect.ImmutableSet.CachingAsList, com.google.common.collect.ImmutableSet, com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set, java.util.NavigableSet
    public /* bridge */ /* synthetic */ Iterator iterator() {
        return iterator();
    }

    @Override // com.google.common.collect.ImmutableSortedSet, java.util.SortedSet
    public E last() {
        if (isEmpty() == true) goto L7;
        return this.f8864c.get(size() - 1);
    L7:
        throw new NoSuchElementException();
    }

    @Override // com.google.common.collect.ImmutableSortedSet, java.util.NavigableSet
    public E lower(E r5) {
        int r10 = headIndex(r5, false) - 1;
        if (r10 != (-1)) goto L6;
        return null;
    L6:
        return this.f8864c.get(r10);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public int size() {
        return this.f8864c.size();
    }

    @Override // com.google.common.collect.ImmutableSortedSet, com.google.common.collect.ImmutableCollection, java.util.Collection, java.lang.Iterable
    public Spliterator<E> spliterator() {
        return asList().spliterator();
    }

    @Override // com.google.common.collect.ImmutableSortedSet
    public ImmutableSortedSet<E> subSetImpl(E r5, boolean r10, E r11, boolean r12) {
        return tailSetImpl(r5, r10).headSetImpl(r11, r12);
    }

    public int tailIndex(E r5, boolean r10) {
        r5.getClass();
        Comparator<? super E> r11 = comparator();
        int r12 = Collections.binarySearch(this.f8864c, r5, r11);
        if (r12 < 0) goto L9;
        if (r10 == false) goto L7;
        return r12;
    L7:
        return r12 + 1;
    L9:
        return ~r12;
    }

    @Override // com.google.common.collect.ImmutableSortedSet
    public ImmutableSortedSet<E> tailSetImpl(E r5, boolean r10) {
        return getSubSet(tailIndex(r5, r10), size());
    }

    public Comparator<Object> unsafeComparator() {
        return this.comparator;
    }

    @Override // com.google.common.collect.ImmutableSortedSet, java.util.NavigableSet
    public ga descendingIterator() {
        return this.f8864c.reverse().iterator();
    }

    @Override // com.google.common.collect.ImmutableSortedSet, com.google.common.collect.ImmutableSet.CachingAsList, com.google.common.collect.ImmutableSet, com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set, java.util.NavigableSet
    public ga iterator() {
        return this.f8864c.iterator();
    }
}
