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

    public final class ArrayIterator<T> implements Iterator<T> {
        boolean mCanRemove;
        int mIndex;
        final int mOffset;
        int mSize;
        final /* synthetic */ MapCollections this$0;

        public ArrayIterator(MapCollections r5, int r10) {
            this.this$0 = r5;
            this.mCanRemove = false;
            this.mOffset = r10;
            this.mSize = r5.colGetSize();
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
            T r5 = (T) this.this$0.colGetEntry(this.mIndex, this.mOffset);
            this.mIndex++;
            this.mCanRemove = true;
            return r5;
        L7:
            throw new NoSuchElementException();
        }

        @Override // java.util.Iterator
        public void remove() {
            if (this.mCanRemove == false) goto L7;
            int r5 = this.mIndex - 1;
            this.mIndex = r5;
            this.mSize--;
            this.mCanRemove = false;
            this.this$0.colRemoveAt(r5);
            return;
        L7:
            throw new IllegalStateException();
        }
    }

    public final class EntrySet implements Set<Map.Entry<K, V>> {
        final /* synthetic */ MapCollections this$0;

        public EntrySet(MapCollections r5) {
            this.this$0 = r5;
        }

        @Override // java.util.Set, java.util.Collection
        public /* bridge */ /* synthetic */ boolean add(Object r5) {
            return add((Map.Entry) r5);
        }

        @Override // java.util.Set, java.util.Collection
        public boolean addAll(Collection<? extends Map.Entry<K, V>> r5) {
            int r10 = this.this$0.colGetSize();
            Iterator<? extends Map.Entry<K, V>> r11 = r5.iterator();
        L4:
            if (r11.hasNext() == false) goto L7;
            Map.Entry<K, V> r12 = r11.next();
            this.this$0.colPut(r12.getKey(), r12.getValue());
            goto L4
        L7:
            if (r10 == this.this$0.colGetSize()) goto L9;
            return true;
        L9:
            return false;
        }

        @Override // java.util.Set, java.util.Collection
        public void clear() {
            this.this$0.colClear();
        }

        @Override // java.util.Set, java.util.Collection
        public boolean contains(Object r5) {
            if ((r5 instanceof Map.Entry) == true) goto L5;
            return false;
        L5:
            Map.Entry r10 = (Map.Entry) r5;
            int r11 = this.this$0.colIndexOfKey(r10.getKey());
            if (r11 >= 0) goto L9;
            return false;
        L9:
            return ContainerHelpers.equal(this.this$0.colGetEntry(r11, 1), r10.getValue());
        }

        @Override // java.util.Set, java.util.Collection
        public boolean containsAll(Collection<?> r5) {
            Iterator<?> r10 = r5.iterator();
        L4:
            if (r10.hasNext() == false) goto L9;
            if (contains(r10.next()) == true) goto L4;
            return false;
        L9:
            return true;
        }

        @Override // java.util.Set, java.util.Collection
        public boolean equals(Object r5) {
            return MapCollections.equalsSetHelper(this, r5);
        }

        @Override // java.util.Set, java.util.Collection
        public int hashCode() {
            int r5 = this.this$0.colGetSize() - 1;
            int r10 = 0;
        L3:
            if (r5 < 0) goto L12;
            Object r11 = this.this$0.colGetEntry(r5, 0);
            Object r12 = this.this$0.colGetEntry(r5, 1);
            if (r11 != null) goto L7;
            int r13 = 0;
        L8:
            if (r12 != null) goto L10;
            int r14 = 0;
        L11:
            r10 = r10 + (r13 ^ r14);
            r5 = r5 - 1;
            goto L3
        L10:
            r14 = r12.hashCode();
            goto L11
        L7:
            r13 = r11.hashCode();
            goto L8
        L12:
            return r10;
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
        public boolean remove(Object r5) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Set, java.util.Collection
        public boolean removeAll(Collection<?> r5) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Set, java.util.Collection
        public boolean retainAll(Collection<?> r5) {
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

        public boolean add(Map.Entry<K, V> r5) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Set, java.util.Collection
        public <T> T[] toArray(T[] r5) {
            throw new UnsupportedOperationException();
        }
    }

    public final class KeySet implements Set<K> {
        final /* synthetic */ MapCollections this$0;

        public KeySet(MapCollections r5) {
            this.this$0 = r5;
        }

        @Override // java.util.Set, java.util.Collection
        public boolean add(K r5) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Set, java.util.Collection
        public boolean addAll(Collection<? extends K> r5) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Set, java.util.Collection
        public void clear() {
            this.this$0.colClear();
        }

        @Override // java.util.Set, java.util.Collection
        public boolean contains(Object r5) {
            if (this.this$0.colIndexOfKey(r5) < 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // java.util.Set, java.util.Collection
        public boolean containsAll(Collection<?> r5) {
            return MapCollections.containsAllHelper(this.this$0.colGetMap(), r5);
        }

        @Override // java.util.Set, java.util.Collection
        public boolean equals(Object r5) {
            return MapCollections.equalsSetHelper(this, r5);
        }

        @Override // java.util.Set, java.util.Collection
        public int hashCode() {
            int r5 = this.this$0.colGetSize() - 1;
            int r10 = 0;
        L3:
            if (r5 < 0) goto L9;
            Object r11 = this.this$0.colGetEntry(r5, 0);
            if (r11 != null) goto L7;
            int r12 = 0;
        L8:
            r10 = r10 + r12;
            r5 = r5 - 1;
            goto L3
        L7:
            r12 = r11.hashCode();
            goto L8
        L9:
            return r10;
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
        public boolean remove(Object r5) {
            int r10 = this.this$0.colIndexOfKey(r5);
            if (r10 < 0) goto L6;
            this.this$0.colRemoveAt(r10);
            return true;
        L6:
            return false;
        }

        @Override // java.util.Set, java.util.Collection
        public boolean removeAll(Collection<?> r5) {
            return MapCollections.removeAllHelper(this.this$0.colGetMap(), r5);
        }

        @Override // java.util.Set, java.util.Collection
        public boolean retainAll(Collection<?> r5) {
            return MapCollections.retainAllHelper(this.this$0.colGetMap(), r5);
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
        public <T> T[] toArray(T[] r5) {
            return (T[]) this.this$0.toArrayHelper(r5, 0);
        }
    }

    public final class MapIterator implements Iterator<Map.Entry<K, V>>, Map.Entry<K, V> {
        int mEnd;
        boolean mEntryValid;
        int mIndex;
        final /* synthetic */ MapCollections this$0;

        public MapIterator(MapCollections r5) {
            this.this$0 = r5;
            this.mEntryValid = false;
            this.mEnd = r5.colGetSize() - 1;
            this.mIndex = -1;
        }

        @Override // java.util.Map.Entry
        public boolean equals(Object r5) {
            if (this.mEntryValid == false) goto L14;
            if ((r5 instanceof Map.Entry) == true) goto L7;
            return false;
        L7:
            Map.Entry r10 = (Map.Entry) r5;
            if (ContainerHelpers.equal(r10.getKey(), this.this$0.colGetEntry(this.mIndex, 0)) == true) goto L10;
            return false;
        L10:
            if (ContainerHelpers.equal(r10.getValue(), this.this$0.colGetEntry(this.mIndex, 1)) == true) goto L12;
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
            int r5 = 0;
            Object r10 = this.this$0.colGetEntry(this.mIndex, 0);
            Object r11 = this.this$0.colGetEntry(this.mIndex, 1);
            if (r10 != null) goto L7;
            int r12 = 0;
        L8:
            if (r11 == null) goto L12;
            r5 = r11.hashCode();
        L12:
            return r12 ^ r5;
        L7:
            r12 = r10.hashCode();
            goto L8
        L14:
            throw new IllegalStateException("This container does not support retaining Map.Entry objects");
        }

        @Override // java.util.Iterator
        public /* bridge */ /* synthetic */ Object next() {
            return next();
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
        public V setValue(V r5) {
            if (this.mEntryValid == false) goto L7;
            return (V) this.this$0.colSetValue(this.mIndex, r5);
        L7:
            throw new IllegalStateException("This container does not support retaining Map.Entry objects");
        }

        public String toString() {
            return getKey() + "=" + getValue();
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
    }

    public final class ValuesCollection implements Collection<V> {
        final /* synthetic */ MapCollections this$0;

        public ValuesCollection(MapCollections r5) {
            this.this$0 = r5;
        }

        @Override // java.util.Collection
        public boolean add(V r5) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Collection
        public boolean addAll(Collection<? extends V> r5) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Collection
        public void clear() {
            this.this$0.colClear();
        }

        @Override // java.util.Collection
        public boolean contains(Object r5) {
            if (this.this$0.colIndexOfValue(r5) < 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // java.util.Collection
        public boolean containsAll(Collection<?> r5) {
            Iterator<?> r10 = r5.iterator();
        L4:
            if (r10.hasNext() == false) goto L9;
            if (contains(r10.next()) == true) goto L4;
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
        public boolean remove(Object r5) {
            int r10 = this.this$0.colIndexOfValue(r5);
            if (r10 < 0) goto L6;
            this.this$0.colRemoveAt(r10);
            return true;
        L6:
            return false;
        }

        @Override // java.util.Collection
        public boolean removeAll(Collection<?> r10) {
            int r5 = this.this$0.colGetSize();
            int r11 = 0;
            boolean r12 = false;
        L3:
            if (r11 >= r5) goto L8;
            if (r10.contains(this.this$0.colGetEntry(r11, 1)) == false) goto L7;
            this.this$0.colRemoveAt(r11);
            r11 = r11 - 1;
            r5 = r5 - 1;
            r12 = true;
        L7:
            r11 = r11 + 1;
            goto L3
        L8:
            return r12;
        }

        @Override // java.util.Collection
        public boolean retainAll(Collection<?> r10) {
            int r5 = this.this$0.colGetSize();
            int r11 = 0;
            boolean r12 = false;
        L3:
            if (r11 >= r5) goto L8;
            if (r10.contains(this.this$0.colGetEntry(r11, 1)) == true) goto L7;
            this.this$0.colRemoveAt(r11);
            r11 = r11 - 1;
            r5 = r5 - 1;
            r12 = true;
        L7:
            r11 = r11 + 1;
            goto L3
        L8:
            return r12;
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
        public <T> T[] toArray(T[] r5) {
            return (T[]) this.this$0.toArrayHelper(r5, 1);
        }
    }

    public MapCollections() {
    }

    public static <K, V> boolean containsAllHelper(Map<K, V> r5, Collection<?> r10) {
        Iterator<?> r11 = r10.iterator();
    L4:
        if (r11.hasNext() == false) goto L9;
        if (r5.containsKey(r11.next()) == true) goto L4;
        return false;
    L9:
        return true;
    }

    public static <T> boolean equalsSetHelper(Set<T> r5, Object r10) {
        if (r5 != r10) goto L6;
        return true;
    L6:
        if ((r10 instanceof Set) == false) goto L15;
        Set r11 = (Set) r10;
        if (r5.size() != r11.size()) goto L14;
        if (r5.containsAll(r11) == false) goto L14;
        return true;
    L14:
        return false;
    L15:
        return false;
    }

    public static <K, V> boolean removeAllHelper(Map<K, V> r5, Collection<?> r10) {
        int r11 = r5.size();
        Iterator<?> r12 = r10.iterator();
    L4:
        if (r12.hasNext() == false) goto L7;
        r5.remove(r12.next());
        goto L4
    L7:
        if (r11 == r5.size()) goto L9;
        return true;
    L9:
        return false;
    }

    public static <K, V> boolean retainAllHelper(Map<K, V> r5, Collection<?> r10) {
        int r11 = r5.size();
        Iterator<K> r12 = r5.keySet().iterator();
    L4:
        if (r12.hasNext() == false) goto L9;
        if (r10.contains(r12.next()) == true) goto L4;
        r12.remove();
        goto L4
    L9:
        if (r11 == r5.size()) goto L11;
        return true;
    L11:
        return false;
    }

    public abstract void colClear();

    public abstract Object colGetEntry(int r5, int r10);

    public abstract Map<K, V> colGetMap();

    public abstract int colGetSize();

    public abstract int colIndexOfKey(Object r5);

    public abstract int colIndexOfValue(Object r5);

    public abstract void colPut(K r5, V r10);

    public abstract void colRemoveAt(int r5);

    public abstract V colSetValue(int r5, V r10);

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

    public Object[] toArrayHelper(int r5) {
        int r10 = colGetSize();
        Object[] r11 = new Object[r10];
        int r12 = 0;
    L3:
        if (r12 >= r10) goto L5;
        r11[r12] = colGetEntry(r12, r5);
        r12 = r12 + 1;
        goto L3
    L5:
        return r11;
    }

    public <T> T[] toArrayHelper(T[] r5, int r10) {
        int r11 = colGetSize();
        if (r5.length >= r11) goto L5;
        r5 = (T[]) ((Object[]) Array.newInstance(r5.getClass().getComponentType(), r11));
    L5:
        int r12 = 0;
    L6:
        if (r12 >= r11) goto L9;
        T[] r13 = r5;
        r13[r12] = colGetEntry(r12, r10);
        r12 = r12 + 1;
        goto L6
    L9:
        if (r5.length <= r11) goto L11;
        r5[r11] = null;
    L11:
        return r5;
    }
}
