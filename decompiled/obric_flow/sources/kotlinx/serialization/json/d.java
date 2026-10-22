package kotlinx.serialization.json;

import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.function.UnaryOperator;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.CollectionToArray;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMappedMarker;

/* JADX INFO: loaded from: classes3.dex */
@kotlinx.serialization.g(with = f.class)
public final class d extends l implements List<l>, KMappedMarker {
    public static final c Companion = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List f19389a;

    static {
        Companion = new c();
    }

    public d(List r5) {
        Intrinsics.checkNotNullParameter(r5, "content");
        this.f19389a = r5;
    }

    @Override // java.util.List
    public final /* bridge */ /* synthetic */ void add(int r5, l r10) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List
    public final boolean addAll(int r5, Collection<? extends l> r10) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List, java.util.Collection
    public final void clear() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List, java.util.Collection
    public final boolean contains(Object r5) {
        if ((r5 instanceof l) == true) goto L6;
        return false;
    L6:
        l r10 = (l) r5;
        Intrinsics.checkNotNullParameter(r10, "element");
        return this.f19389a.contains(r10);
    }

    @Override // java.util.List, java.util.Collection
    public final boolean containsAll(Collection r5) {
        Intrinsics.checkNotNullParameter(r5, "elements");
        return this.f19389a.containsAll(r5);
    }

    @Override // java.util.List, java.util.Collection
    public final boolean equals(Object r5) {
        return Intrinsics.areEqual(this.f19389a, r5);
    }

    @Override // java.util.List
    public final l get(int r5) {
        return (l) this.f19389a.get(r5);
    }

    @Override // java.util.List, java.util.Collection
    public final int hashCode() {
        return this.f19389a.hashCode();
    }

    @Override // java.util.List
    public final int indexOf(Object r5) {
        if ((r5 instanceof l) == true) goto L6;
        return -1;
    L6:
        l r10 = (l) r5;
        Intrinsics.checkNotNullParameter(r10, "element");
        return this.f19389a.indexOf(r10);
    }

    @Override // java.util.List, java.util.Collection
    public final boolean isEmpty() {
        return this.f19389a.isEmpty();
    }

    @Override // java.util.List, java.util.Collection, java.lang.Iterable
    public final Iterator iterator() {
        return this.f19389a.iterator();
    }

    @Override // java.util.List
    public final int lastIndexOf(Object r5) {
        if ((r5 instanceof l) == true) goto L6;
        return -1;
    L6:
        l r10 = (l) r5;
        Intrinsics.checkNotNullParameter(r10, "element");
        return this.f19389a.lastIndexOf(r10);
    }

    @Override // java.util.List
    public final ListIterator<l> listIterator() {
        return this.f19389a.listIterator();
    }

    @Override // java.util.List
    public final /* bridge */ /* synthetic */ l remove(int r5) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List, java.util.Collection
    public final boolean removeAll(Collection r5) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List
    public final void replaceAll(UnaryOperator<l> r5) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List, java.util.Collection
    public final boolean retainAll(Collection r5) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List
    public final /* bridge */ /* synthetic */ l set(int r5, l r10) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List, java.util.Collection
    public final int size() {
        return this.f19389a.size();
    }

    @Override // java.util.List
    public final void sort(Comparator<? super l> r5) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List
    public final List<l> subList(int r5, int r10) {
        return this.f19389a.subList(r5, r10);
    }

    @Override // java.util.List, java.util.Collection
    public final Object[] toArray() {
        return CollectionToArray.toArray(this);
    }

    public final String toString() {
        return CollectionsKt.q(this.f19389a, ",", "[", "]", 0, null, null, 56);
    }

    @Override // java.util.List, java.util.Collection
    public final /* bridge */ /* synthetic */ boolean add(Object r5) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List, java.util.Collection
    public final boolean addAll(Collection r5) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List
    public final ListIterator<l> listIterator(int r5) {
        return this.f19389a.listIterator(r5);
    }

    @Override // java.util.List, java.util.Collection
    public final boolean remove(Object r5) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List, java.util.Collection
    public final Object[] toArray(Object[] r5) {
        Intrinsics.checkNotNullParameter(r5, "array");
        return CollectionToArray.toArray(this, r5);
    }
}
