package androidx.collection;

import androidx.annotation.Nullable;
import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
abstract class MapCollections<K, V> {

    @Nullable
    MapCollections<K, V>.EntrySet mEntrySet;

    @Nullable
    MapCollections<K, V>.KeySet mKeySet;

    @Nullable
    MapCollections<K, V>.ValuesCollection mValues;

    final class ArrayIterator<T> implements Iterator<T> {
        boolean mCanRemove;
        int mIndex;
        final int mOffset;
        int mSize;
        final /* synthetic */ MapCollections this$0;

        ArrayIterator(MapCollections r10, int r11) {
            this.this$0 = r10;
            this.mCanRemove = false;
            this.mOffset = r11;
            this.mSize = r10.colGetSize();
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (this.mIndex >= this.mSize) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // java.util.Iterator
        public T next() {
            if (hasNext() == false) goto L7;
            T r10 = (T) this.this$0.colGetEntry(this.mIndex, this.mOffset);
            this.mIndex++;
            this.mCanRemove = true;
            return r10;
        L7:
            throw new NoSuchElementException();
        }

        @Override // java.util.Iterator
        public void remove() {
            if (this.mCanRemove == false) goto L7;
            int r10 = this.mIndex - 1;
            this.mIndex = r10;
            this.mSize--;
            this.mCanRemove = false;
            this.this$0.colRemoveAt(r10);
            return;
        L7:
            throw new IllegalStateException();
        }
    }

    final class EntrySet implements Set<Map.Entry<K, V>> {
        final /* synthetic */ MapCollections this$0;

        EntrySet(MapCollections r10) {
            this.this$0 = r10;
        }

        @Override // java.util.Set, java.util.Collection
        public /* bridge */ /* synthetic */ boolean add(Object r10) {
            return add((Map.Entry) r10);
        }

        public boolean add(Map.Entry<K, V> r10) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Set, java.util.Collection
        public boolean addAll(Collection<? extends Map.Entry<K, V>> r10) {
            int r11 = this.this$0.colGetSize();
            Iterator<? extends Map.Entry<K, V>> r12 = r10.iterator();
        L4:
            if (r12.hasNext() == false) goto L7;
            Map.Entry<K, V> r13 = r12.next();
            this.this$0.colPut(r13.getKey(), r13.getValue());
            goto L4
        L7:
            if (r11 == this.this$0.colGetSize()) goto L9;
            return true;
        L9:
            return false;
        }

        @Override // java.util.Set, java.util.Collection
        public void clear() {
            this.this$0.colClear();
        }

        @Override // java.util.Set, java.util.Collection
        public boolean contains(Object r10) {
            if ((r10 instanceof Map.Entry) == true) goto L5;
            return false;
        L5:
            Map.Entry r11 = (Map.Entry) r10;
            int r12 = this.this$0.colIndexOfKey(r11.getKey());
            if (r12 >= 0) goto L9;
            return false;
        L9:
            return ContainerHelpers.equal(this.this$0.colGetEntry(r12, 1), r11.getValue());
        }

        @Override // java.util.Set, java.util.Collection
        public boolean containsAll(Collection<?> r10) {
            Iterator<?> r11 = r10.iterator();
        L4:
            if (r11.hasNext() == false) goto L9;
            if (contains(r11.next()) == true) goto L4;
            return false;
        L9:
            return true;
        }

        @Override // java.util.Set, java.util.Collection
        public boolean equals(Object r10) {
            return MapCollections.equalsSetHelper(this, r10);
        }

        @Override // java.util.Set, java.util.Collection
        public int hashCode() {
            int r10 = this.this$0.colGetSize() - 1;
            int r11 = 0;
        L3:
            if (r10 < 0) goto L12;
            Object r12 = this.this$0.colGetEntry(r10, 0);
            Object r13 = this.this$0.colGetEntry(r10, 1);
            if (r12 != null) goto L7;
            int r14 = 0;
        L8:
            if (r13 != null) goto L10;
            int r15 = 0;
        L11:
            r11 = r11 + (r14 ^ r15);
            r10 = r10 - 1;
            goto L3
        L10:
            r15 = r13.hashCode();
            goto L11
        L7:
            r14 = r12.hashCode();
            goto L8
        L12:
            return r11;
        }

        @Override // java.util.Set, java.util.Collection
        public boolean isEmpty() {
            if (this.this$0.colGetSize() != 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // java.util.Set, java.util.Collection, java.lang.Iterable
        public Iterator<Map.Entry<K, V>> iterator() {
            return new MapIterator(this.this$0);
        }

        @Override // java.util.Set, java.util.Collection
        public boolean remove(Object r10) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Set, java.util.Collection
        public boolean removeAll(Collection<?> r10) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Set, java.util.Collection
        public boolean retainAll(Collection<?> r10) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Set, java.util.Collection
        public int size() {
            return this.this$0.colGetSize();
        }

        @Override // java.util.Set, java.util.Collection
        public Object[] toArray() {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Set, java.util.Collection
        public <T> T[] toArray(T[] r10) {
            throw new UnsupportedOperationException();
        }
    }

    final class KeySet implements Set<K> {
        final /* synthetic */ MapCollections this$0;

        KeySet(MapCollections r10) {
            this.this$0 = r10;
        }

        @Override // java.util.Set, java.util.Collection
        public boolean add(K r10) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Set, java.util.Collection
        public boolean addAll(Collection<? extends K> r10) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Set, java.util.Collection
        public void clear() {
            this.this$0.colClear();
        }

        @Override // java.util.Set, java.util.Collection
        public boolean contains(Object r10) {
            if (this.this$0.colIndexOfKey(r10) < 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // java.util.Set, java.util.Collection
        public boolean containsAll(Collection<?> r10) {
            return MapCollections.containsAllHelper(this.this$0.colGetMap(), r10);
        }

        @Override // java.util.Set, java.util.Collection
        public boolean equals(Object r10) {
            return MapCollections.equalsSetHelper(this, r10);
        }

        @Override // java.util.Set, java.util.Collection
        public int hashCode() {
            int r10 = this.this$0.colGetSize() - 1;
            int r11 = 0;
        L3:
            if (r10 < 0) goto L9;
            Object r12 = this.this$0.colGetEntry(r10, 0);
            if (r12 != null) goto L7;
            int r13 = 0;
        L8:
            r11 = r11 + r13;
            r10 = r10 - 1;
            goto L3
        L7:
            r13 = r12.hashCode();
            goto L8
        L9:
            return r11;
        }

        @Override // java.util.Set, java.util.Collection
        public boolean isEmpty() {
            if (this.this$0.colGetSize() != 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // java.util.Set, java.util.Collection, java.lang.Iterable
        public Iterator<K> iterator() {
            return new ArrayIterator(this.this$0, 0);
        }

        @Override // java.util.Set, java.util.Collection
        public boolean remove(Object r10) {
            int r11 = this.this$0.colIndexOfKey(r10);
            if (r11 < 0) goto L6;
            this.this$0.colRemoveAt(r11);
            return true;
        L6:
            return false;
        }

        @Override // java.util.Set, java.util.Collection
        public boolean removeAll(Collection<?> r10) {
            return MapCollections.removeAllHelper(this.this$0.colGetMap(), r10);
        }

        @Override // java.util.Set, java.util.Collection
        public boolean retainAll(Collection<?> r10) {
            return MapCollections.retainAllHelper(this.this$0.colGetMap(), r10);
        }

        @Override // java.util.Set, java.util.Collection
        public int size() {
            return this.this$0.colGetSize();
        }

        @Override // java.util.Set, java.util.Collection
        public Object[] toArray() {
            return this.this$0.toArrayHelper(0);
        }

        @Override // java.util.Set, java.util.Collection
        public <T> T[] toArray(T[] r10) {
            return (T[]) this.this$0.toArrayHelper(r10, 0);
        }
    }

    final class MapIterator implements Iterator<Map.Entry<K, V>>, Map.Entry<K, V> {
        int mEnd;
        boolean mEntryValid;
        int mIndex;
        final /* synthetic */ MapCollections this$0;

        MapIterator(MapCollections r10) {
            this.this$0 = r10;
            this.mEntryValid = false;
            this.mEnd = r10.colGetSize() - 1;
            this.mIndex = -1;
        }

        @Override // java.util.Map.Entry
        public boolean equals(Object r10) {
            if (this.mEntryValid == false) goto L14;
            if ((r10 instanceof Map.Entry) == true) goto L7;
            return false;
        L7:
            Map.Entry r11 = (Map.Entry) r10;
            if (ContainerHelpers.equal(r11.getKey(), this.this$0.colGetEntry(this.mIndex, 0)) == true) goto L10;
            return false;
        L10:
            if (ContainerHelpers.equal(r11.getValue(), this.this$0.colGetEntry(this.mIndex, 1)) == true) goto L12;
            return false;
        L12:
            return true;
        L14:
            throw new IllegalStateException("This container does not support retaining Map.Entry objects");
        }

        @Override // java.util.Map.Entry
        public K getKey() {
            if (this.mEntryValid == false) goto L7;
            return (K) this.this$0.colGetEntry(this.mIndex, 0);
        L7:
            throw new IllegalStateException("This container does not support retaining Map.Entry objects");
        }

        @Override // java.util.Map.Entry
        public V getValue() {
            if (this.mEntryValid == false) goto L7;
            return (V) this.this$0.colGetEntry(this.mIndex, 1);
        L7:
            throw new IllegalStateException("This container does not support retaining Map.Entry objects");
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (this.mIndex >= this.mEnd) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // java.util.Map.Entry
        public int hashCode() {
            if (this.mEntryValid == false) goto L14;
            int r10 = 0;
            Object r11 = this.this$0.colGetEntry(this.mIndex, 0);
            Object r12 = this.this$0.colGetEntry(this.mIndex, 1);
            if (r11 != null) goto L7;
            int r13 = 0;
        L8:
            if (r12 == null) goto L12;
            r10 = r12.hashCode();
        L12:
            return r13 ^ r10;
        L7:
            r13 = r11.hashCode();
            goto L8
        L14:
            throw new IllegalStateException("This container does not support retaining Map.Entry objects");
        }

        @Override // java.util.Iterator
        public /* bridge */ /* synthetic */ Object next() {
            return next();
        }

        @Override // java.util.Iterator
        public Map.Entry<K, V> next() {
            if (hasNext() == false) goto L7;
            this.mIndex++;
            this.mEntryValid = true;
            return this;
        L7:
            throw new NoSuchElementException();
        }

        @Override // java.util.Iterator
        public void remove() {
            if (this.mEntryValid == false) goto L7;
            this.this$0.colRemoveAt(this.mIndex);
            this.mIndex--;
            this.mEnd--;
            this.mEntryValid = false;
            return;
        L7:
            throw new IllegalStateException();
        }

        @Override // java.util.Map.Entry
        public V setValue(V r10) {
            if (this.mEntryValid == false) goto L7;
            return (V) this.this$0.colSetValue(this.mIndex, r10);
        L7:
            throw new IllegalStateException("This container does not support retaining Map.Entry objects");
        }

        public String toString() {
            return getKey() + "=" + getValue();
        }
    }

    final class ValuesCollection implements Collection<V> {
        final /* synthetic */ MapCollections this$0;

        ValuesCollection(MapCollections r10) {
            this.this$0 = r10;
        }

        @Override // java.util.Collection
        public boolean add(V r10) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Collection
        public boolean addAll(Collection<? extends V> r10) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Collection
        public void clear() {
            this.this$0.colClear();
        }

        @Override // java.util.Collection
        public boolean contains(Object r10) {
            if (this.this$0.colIndexOfValue(r10) < 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // java.util.Collection
        public boolean containsAll(Collection<?> r10) {
            Iterator<?> r11 = r10.iterator();
        L4:
            if (r11.hasNext() == false) goto L9;
            if (contains(r11.next()) == true) goto L4;
            return false;
        L9:
            return true;
        }

        @Override // java.util.Collection
        public boolean isEmpty() {
            if (this.this$0.colGetSize() != 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // java.util.Collection, java.lang.Iterable
        public Iterator<V> iterator() {
            return new ArrayIterator(this.this$0, 1);
        }

        @Override // java.util.Collection
        public boolean remove(Object r10) {
            int r11 = this.this$0.colIndexOfValue(r10);
            if (r11 < 0) goto L6;
            this.this$0.colRemoveAt(r11);
            return true;
        L6:
            return false;
        }

        @Override // java.util.Collection
        public boolean removeAll(Collection<?> r10) {
            int r11 = this.this$0.colGetSize();
            int r12 = 0;
            boolean r13 = false;
        L3:
            if (r12 >= r11) goto L8;
            if (r10.contains(this.this$0.colGetEntry(r12, 1)) == false) goto L7;
            this.this$0.colRemoveAt(r12);
            r12 = r12 - 1;
            r11 = r11 - 1;
            r13 = true;
        L7:
            r12 = r12 + 1;
            goto L3
        L8:
            return r13;
        }

        @Override // java.util.Collection
        public boolean retainAll(Collection<?> r10) {
            int r11 = this.this$0.colGetSize();
            int r12 = 0;
            boolean r13 = false;
        L3:
            if (r12 >= r11) goto L8;
            if (r10.contains(this.this$0.colGetEntry(r12, 1)) == true) goto L7;
            this.this$0.colRemoveAt(r12);
            r12 = r12 - 1;
            r11 = r11 - 1;
            r13 = true;
        L7:
            r12 = r12 + 1;
            goto L3
        L8:
            return r13;
        }

        @Override // java.util.Collection
        public int size() {
            return this.this$0.colGetSize();
        }

        @Override // java.util.Collection
        public Object[] toArray() {
            return this.this$0.toArrayHelper(1);
        }

        @Override // java.util.Collection
        public <T> T[] toArray(T[] r10) {
            return (T[]) this.this$0.toArrayHelper(r10, 1);
        }
    }

    MapCollections() {
    }

    public static <K, V> boolean containsAllHelper(Map<K, V> r10, Collection<?> r11) {
        Iterator<?> r12 = r11.iterator();
    L4:
        if (r12.hasNext() == false) goto L9;
        if (r10.containsKey(r12.next()) == true) goto L4;
        return false;
    L9:
        return true;
    }

    public static <T> boolean equalsSetHelper(Set<T> r10, Object r11) {
        if (r10 != r11) goto L6;
        return true;
    L6:
        if ((r11 instanceof Set) == false) goto L15;
        Set r12 = (Set) r11;
        if (r10.size() != r12.size()) goto L14;
        if (r10.containsAll(r12) == false) goto L14;
        return true;
    L14:
        return false;
    L15:
        return false;
    }

    public static <K, V> boolean removeAllHelper(Map<K, V> r10, Collection<?> r11) {
        int r12 = r10.size();
        Iterator<?> r13 = r11.iterator();
    L4:
        if (r13.hasNext() == false) goto L7;
        r10.remove(r13.next());
        goto L4
    L7:
        if (r12 == r10.size()) goto L9;
        return true;
    L9:
        return false;
    }

    public static <K, V> boolean retainAllHelper(Map<K, V> r10, Collection<?> r11) {
        int r12 = r10.size();
        Iterator<K> r13 = r10.keySet().iterator();
    L4:
        if (r13.hasNext() == false) goto L9;
        if (r11.contains(r13.next()) == true) goto L4;
        r13.remove();
        goto L4
    L9:
        if (r12 == r10.size()) goto L11;
        return true;
    L11:
        return false;
    }

    protected abstract void colClear();

    protected abstract Object colGetEntry(int r10, int r11);

    protected abstract Map<K, V> colGetMap();

    protected abstract int colGetSize();

    protected abstract int colIndexOfKey(Object r10);

    protected abstract int colIndexOfValue(Object r10);

    protected abstract void colPut(K r10, V r11);

    protected abstract void colRemoveAt(int r10);

    protected abstract V colSetValue(int r10, V r11);

    public Set<Map.Entry<K, V>> getEntrySet() {
        if (this.mEntrySet != null) goto L6;
        this.mEntrySet = new EntrySet(this);
    L6:
        return this.mEntrySet;
    }

    public Set<K> getKeySet() {
        if (this.mKeySet != null) goto L6;
        this.mKeySet = new KeySet(this);
    L6:
        return this.mKeySet;
    }

    public Collection<V> getValues() {
        if (this.mValues != null) goto L6;
        this.mValues = new ValuesCollection(this);
    L6:
        return this.mValues;
    }

    public Object[] toArrayHelper(int r10) {
        int r11 = colGetSize();
        Object[] r12 = new Object[r11];
        int r13 = 0;
    L3:
        if (r13 >= r11) goto L5;
        r12[r13] = colGetEntry(r13, r10);
        r13 = r13 + 1;
        goto L3
    L5:
        return r12;
    }

    public <T> T[] toArrayHelper(T[] r10, int r11) {
        int r12 = colGetSize();
        if (r10.length >= r12) goto L5;
        r10 = (T[]) ((Object[]) Array.newInstance(r10.getClass().getComponentType(), r12));
    L5:
        int r13 = 0;
    L6:
        if (r13 >= r12) goto L9;
        T[] r14 = r10;
        r14[r13] = colGetEntry(r13, r11);
        r13 = r13 + 1;
        goto L6
    L9:
        if (r10.length <= r12) goto L11;
        r10[r12] = null;
    L11:
        return r10;
    }
}
