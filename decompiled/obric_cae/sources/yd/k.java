package yd;

import java.io.Serializable;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;

/* JADX INFO: loaded from: classes2.dex */
public final class k implements List, Serializable, RandomAccess {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final k f14119a = null;

    static {
        f14119a = new k();
    }

    @Override // java.util.List
    public final /* bridge */ /* synthetic */ void add(int r8, Object r10) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List
    public final boolean addAll(int r8, Collection r10) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List, java.util.Collection
    public final void clear() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List, java.util.Collection
    public final boolean contains(Object r8) {
        if ((r8 instanceof Void) == true) goto L5;
        return false;
    L5:
        he.i.f((Void) r8, "element");
        return false;
    }

    @Override // java.util.List, java.util.Collection
    public final boolean containsAll(Collection r8) {
        he.i.f(r8, "elements");
        return r8.isEmpty();
    }

    @Override // java.util.List, java.util.Collection
    public final boolean equals(Object r8) {
        if ((r8 instanceof List) == true) goto L5;
    L7:
        return false;
    L5:
        if (((List) r8).isEmpty() == false) goto L7;
        return true;
    }

    @Override // java.util.List
    public final Object get(int r8) {
        throw new IndexOutOfBoundsException("Empty list doesn't contain element at index " + r8 + '.');
    }

    @Override // java.util.List, java.util.Collection
    public final int hashCode() {
        return 1;
    }

    @Override // java.util.List
    public final int indexOf(Object r8) {
        if ((r8 instanceof Void) == true) goto L5;
        return -1;
    L5:
        he.i.f((Void) r8, "element");
        return -1;
    }

    @Override // java.util.List, java.util.Collection
    public final boolean isEmpty() {
        return true;
    }

    @Override // java.util.List, java.util.Collection, java.lang.Iterable
    public final Iterator iterator() {
        return j.f14118a;
    }

    @Override // java.util.List
    public final int lastIndexOf(Object r8) {
        if ((r8 instanceof Void) == true) goto L5;
        return -1;
    L5:
        he.i.f((Void) r8, "element");
        return -1;
    }

    @Override // java.util.List
    public final ListIterator listIterator() {
        return j.f14118a;
    }

    @Override // java.util.List
    public final /* bridge */ /* synthetic */ Object remove(int r8) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List, java.util.Collection
    public final boolean removeAll(Collection r8) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List, java.util.Collection
    public final boolean retainAll(Collection r8) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List
    public final /* bridge */ /* synthetic */ Object set(int r8, Object r10) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List, java.util.Collection
    public final /* bridge */ int size() {
        return 0;
    }

    @Override // java.util.List
    public final List subList(int r8, int r10) {
        if (r8 != 0) goto L6;
        if (r10 != 0) goto L6;
        return this;
    L6:
        throw new IndexOutOfBoundsException("fromIndex: " + r8 + ", toIndex: " + r10);
    }

    @Override // java.util.List, java.util.Collection
    public final Object[] toArray() {
        return l6.a.U0(this);
    }

    public final String toString() {
        return "[]";
    }

    @Override // java.util.List, java.util.Collection
    public final /* bridge */ /* synthetic */ boolean add(Object r8) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List, java.util.Collection
    public final boolean addAll(Collection r8) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List
    public final ListIterator listIterator(int r8) {
        if (r8 != 0) goto L6;
        return j.f14118a;
    L6:
        throw new IndexOutOfBoundsException(defpackage.a.d("Index: ", r8));
    }

    @Override // java.util.List, java.util.Collection
    public final boolean remove(Object r8) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List, java.util.Collection
    public final <T> T[] toArray(T[] r8) {
        he.i.f(r8, "array");
        return (T[]) l6.a.V0(this, r8);
    }
}
