package kotlin.collections;

import java.io.Serializable;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;
import kotlin.jvm.internal.CollectionToArray;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMappedMarker;

/* JADX INFO: loaded from: classes2.dex */
public final class EmptyList implements List, Serializable, RandomAccess, KMappedMarker {
    public static final EmptyList INSTANCE = null;
    private static final long serialVersionUID = -7390468764508069838L;

    static {
        INSTANCE = new EmptyList();
    }

    private EmptyList() {
    }

    private final Object readResolve() {
        return INSTANCE;
    }

    @Override // java.util.List
    public /* bridge */ /* synthetic */ void add(int r10, Object r11) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public void add(int r10, Void r11) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List, java.util.Collection
    public /* bridge */ /* synthetic */ boolean add(Object r10) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public boolean add(Void r10) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List
    public boolean addAll(int r10, Collection r11) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List, java.util.Collection
    public boolean addAll(Collection r10) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List, java.util.Collection
    public void clear() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List, java.util.Collection
    public final /* bridge */ boolean contains(Object r10) {
        if ((r10 instanceof Void) == true) goto L7;
        return false;
    L7:
        return contains((Void) r10);
    }

    public boolean contains(Void r10) {
        Intrinsics.checkNotNullParameter(r10, "element");
        return false;
    }

    @Override // java.util.List, java.util.Collection
    public boolean containsAll(Collection r10) {
        Intrinsics.checkNotNullParameter(r10, "elements");
        return r10.isEmpty();
    }

    @Override // java.util.List, java.util.Collection
    public boolean equals(Object r10) {
        if ((r10 instanceof List) == true) goto L5;
    L7:
        return false;
    L5:
        if (((List) r10).isEmpty() == false) goto L7;
        return true;
    }

    @Override // java.util.List
    public /* bridge */ /* synthetic */ Object get(int r10) {
        return get(r10);
    }

    @Override // java.util.List
    public Void get(int r10) {
        throw new IndexOutOfBoundsException("Empty list doesn't contain element at index " + r10 + '.');
    }

    public int getSize() {
        return 0;
    }

    @Override // java.util.List, java.util.Collection
    public int hashCode() {
        return 1;
    }

    @Override // java.util.List
    public final /* bridge */ int indexOf(Object r10) {
        if ((r10 instanceof Void) == true) goto L7;
        return -1;
    L7:
        return indexOf((Void) r10);
    }

    public int indexOf(Void r10) {
        Intrinsics.checkNotNullParameter(r10, "element");
        return -1;
    }

    @Override // java.util.List, java.util.Collection
    public boolean isEmpty() {
        return true;
    }

    @Override // java.util.List, java.util.Collection, java.lang.Iterable
    public Iterator iterator() {
        return EmptyIterator.INSTANCE;
    }

    @Override // java.util.List
    public final /* bridge */ int lastIndexOf(Object r10) {
        if ((r10 instanceof Void) == true) goto L7;
        return -1;
    L7:
        return lastIndexOf((Void) r10);
    }

    public int lastIndexOf(Void r10) {
        Intrinsics.checkNotNullParameter(r10, "element");
        return -1;
    }

    @Override // java.util.List
    public ListIterator listIterator() {
        return EmptyIterator.INSTANCE;
    }

    @Override // java.util.List
    public ListIterator listIterator(int r10) {
        if (r10 != 0) goto L6;
        return EmptyIterator.INSTANCE;
    L6:
        throw new IndexOutOfBoundsException("Index: " + r10);
    }

    @Override // java.util.List
    public /* bridge */ /* synthetic */ Object remove(int r10) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List
    public Void remove(int r10) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List, java.util.Collection
    public boolean remove(Object r10) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List, java.util.Collection
    public boolean removeAll(Collection r10) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List, java.util.Collection
    public boolean retainAll(Collection r10) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List
    public /* bridge */ /* synthetic */ Object set(int r10, Object r11) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public Void set(int r10, Void r11) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List, java.util.Collection
    public final /* bridge */ int size() {
        return getSize();
    }

    @Override // java.util.List
    public List subList(int r10, int r11) {
        if (r10 != 0) goto L6;
        if (r11 != 0) goto L6;
        return this;
    L6:
        throw new IndexOutOfBoundsException("fromIndex: " + r10 + ", toIndex: " + r11);
    }

    @Override // java.util.List, java.util.Collection
    public Object[] toArray() {
        return CollectionToArray.toArray(this);
    }

    @Override // java.util.List, java.util.Collection
    public <T> T[] toArray(T[] r10) {
        Intrinsics.checkNotNullParameter(r10, "array");
        return (T[]) CollectionToArray.toArray(this, r10);
    }

    public String toString() {
        return "[]";
    }
}
