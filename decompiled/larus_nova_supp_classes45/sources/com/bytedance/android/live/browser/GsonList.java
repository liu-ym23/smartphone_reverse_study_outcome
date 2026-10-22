package com.bytedance.android.live.browser;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.function.UnaryOperator;
import kotlin.Unit;
import kotlin.jvm.internal.CollectionToArray;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMappedMarker;
import kotlin.sequences.SequencesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class GsonList implements List<Object>, KMappedMarker {
    public final JsonArray a;

    public final class a implements ListIterator<Object>, KMappedMarker {
        public int a;
        public final /* synthetic */ GsonList b;

        @Override // java.util.ListIterator
        public final void add(Object r2) {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        @Override // java.util.ListIterator, java.util.Iterator
        public final void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        @Override // java.util.ListIterator
        public final void set(Object r2) {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        @Override // java.util.ListIterator, java.util.Iterator
        public final boolean hasNext() {
            if (this.a >= this.b.a.size()) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // java.util.ListIterator
        public final boolean hasPrevious() {
            if (this.a <= 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // java.util.ListIterator, java.util.Iterator
        public final Object next() {
            JsonArray r0 = this.b.a;
            int r1 = this.a;
            this.a = r1 + 1;
            Unit r2 = Unit.INSTANCE;
            JsonElement r3 = r0.get(r1);
            if (r3 != null) goto L7;
            return null;
        L7:
            return UtilsKt.b(r3);
        }

        @Override // java.util.ListIterator
        public final Object previous() {
            JsonArray r0 = this.b.a;
            int r1 = this.a - 1;
            this.a = r1;
            Unit r2 = Unit.INSTANCE;
            JsonElement r3 = r0.get(r1);
            if (r3 != null) goto L7;
            return null;
        L7:
            return UtilsKt.b(r3);
        }

        @Override // java.util.ListIterator
        public final int previousIndex() {
            return this.a - 1;
        }

        @Override // java.util.ListIterator
        public final int nextIndex() {
            return this.a;
        }

        public a(GsonList r1, int r2) {
            this.b = r1;
            this.a = r2;
        }
    }

    public static final class b implements Iterator<Object>, KMappedMarker {
        public final Iterator<JsonElement> a;

        @Override // java.util.Iterator
        public final void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        @Override // java.util.Iterator
        public final boolean hasNext() {
            return this.a.hasNext();
        }

        @Override // java.util.Iterator
        public final Object next() {
            JsonElement r0 = this.a.next();
            if (r0 != null) goto L7;
            return null;
        L7:
            return UtilsKt.b(r0);
        }

        public b(GsonList r1) {
            this.a = r1.a.iterator();
        }
    }

    @Override // java.util.List
    public final void add(int r1, Object r2) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List, java.util.Collection
    public final boolean add(Object r2) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List
    public final boolean addAll(int r1, Collection<? extends Object> r2) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List, java.util.Collection
    public final boolean addAll(Collection<? extends Object> r2) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List, java.util.Collection
    public final void clear() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List
    public final Object remove(int r2) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List, java.util.Collection
    public final boolean remove(Object r2) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List, java.util.Collection
    public final boolean removeAll(Collection<? extends Object> r2) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List
    public final void replaceAll(UnaryOperator<Object> r2) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List, java.util.Collection
    public final boolean retainAll(Collection<? extends Object> r2) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List
    public final Object set(int r1, Object r2) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List
    public final void sort(Comparator<? super Object> r2) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List, java.util.Collection
    public final Object[] toArray() {
        return CollectionToArray.toArray(this);
    }

    @Override // java.util.List, java.util.Collection
    public final <T> T[] toArray(T[] r1) {
        return (T[]) CollectionToArray.toArray(this, r1);
    }

    @Override // java.util.List, java.util.Collection, java.lang.Iterable
    public final Iterator<Object> iterator() {
        return new b(this);
    }

    @Override // java.util.List
    public final ListIterator<Object> listIterator() {
        return new a(this, 0);
    }

    @Override // java.util.List, java.util.Collection
    public final int size() {
        return this.a.size();
    }

    @Override // java.util.List, java.util.Collection
    public final boolean isEmpty() {
        if (size() != 0) goto L5;
        return true;
    L5:
        return false;
    }

    public GsonList(JsonArray r2) {
        Intrinsics.checkNotNullParameter(r2, "delegate");
        this.a = r2;
    }

    @Override // java.util.List, java.util.Collection
    public final boolean contains(Object r2) {
        throw new UnsupportedOperationException("Operation not supported.");
    }

    @Override // java.util.List, java.util.Collection
    public final boolean containsAll(Collection<? extends Object> r2) {
        Intrinsics.checkNotNullParameter(r2, "elements");
        throw new UnsupportedOperationException("Operation not supported.");
    }

    @Override // java.util.List
    public final Object get(int r2) {
        JsonElement r3 = this.a.get(r2);
        if (r3 != null) goto L7;
        return null;
    L7:
        return UtilsKt.b(r3);
    }

    @Override // java.util.List
    public final int indexOf(Object r2) {
        throw new UnsupportedOperationException("Operation not supported.");
    }

    @Override // java.util.List
    public final int lastIndexOf(Object r2) {
        throw new UnsupportedOperationException("Operation not supported.");
    }

    @Override // java.util.List
    public final ListIterator<Object> listIterator(int r2) {
        return new a(this, r2);
    }

    @Override // java.util.List
    public final List<Object> subList(final int r3, final int r4) {
        return SequencesKt.toList(SequencesKt.map(SequencesKt.filterIndexed(SequencesKt.asSequence(this.a.iterator()), new AnonymousClass1(r3, r4)), AnonymousClass2.INSTANCE));
    }
}
