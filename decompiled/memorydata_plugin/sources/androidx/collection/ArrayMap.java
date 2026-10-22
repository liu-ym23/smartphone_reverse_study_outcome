package androidx.collection;

import androidx.collection.internal.ContainerHelpersKt;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.reflect.Array;
import java.util.AbstractSet;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public class ArrayMap<K, V> extends SimpleArrayMap<K, V> implements Map<K, V> {
    ArrayMap<K, V>.EntrySet mEntrySet;
    ArrayMap<K, V>.KeySet mKeySet;
    ArrayMap<K, V>.ValueCollection mValues;

    final class EntrySet extends AbstractSet<Map.Entry<K, V>> {
        final /* synthetic */ ArrayMap this$0;

        EntrySet(ArrayMap r1) {
            this.this$0 = r1;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<Map.Entry<K, V>> iterator() {
            return new MapIterator(this.this$0);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return this.this$0.size();
        }
    }

    final class KeyIterator extends IndexBasedArrayIterator<K> {
        final /* synthetic */ ArrayMap this$0;

        KeyIterator(ArrayMap r1) {
            this.this$0 = r1;
            super(r1.size());
        }

        @Override // androidx.collection.IndexBasedArrayIterator
        public K elementAt(int r1) {
            return this.this$0.keyAt(r1);
        }

        @Override // androidx.collection.IndexBasedArrayIterator
        public void removeAt(int r1) {
            this.this$0.removeAt(r1);
        }
    }

    final class KeySet implements Set<K> {
        final /* synthetic */ ArrayMap this$0;

        KeySet(ArrayMap r1) {
            this.this$0 = r1;
        }

        @Override // java.util.Set, java.util.Collection
        public boolean add(K r1) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Set, java.util.Collection
        public boolean addAll(Collection<? extends K> r2) {
            Collection r1 = (Collection) ZeusTransformUtils.wrapperContextForParams(r2, Collection.class, "com.obric.memorydata.plugin");
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Set, java.util.Collection
        public void clear() {
            this.this$0.clear();
        }

        @Override // java.util.Set, java.util.Collection
        public boolean contains(Object r1) {
            return this.this$0.containsKey(r1);
        }

        @Override // java.util.Set, java.util.Collection
        public boolean containsAll(Collection<?> r3) {
            Collection<?> r4 = (Collection) ZeusTransformUtils.wrapperContextForParams(r3, Collection.class, "com.obric.memorydata.plugin");
            return this.this$0.containsAll(r4);
        }

        @Override // java.util.Set, java.util.Collection
        public boolean equals(Object r1) {
            return ArrayMap.equalsSetHelper(this, r1);
        }

        @Override // java.util.Set, java.util.Collection
        public int hashCode() {
            int r0 = this.this$0.size() - 1;
            int r2 = 0;
        L3:
            if (r0 < 0) goto L9;
            K r3 = this.this$0.keyAt(r0);
            if (r3 != null) goto L7;
            int r4 = 0;
        L8:
            r2 = r2 + r4;
            r0 = r0 - 1;
            goto L3
        L7:
            r4 = r3.hashCode();
            goto L8
        L9:
            return r2;
        }

        @Override // java.util.Set, java.util.Collection
        public boolean isEmpty() {
            return this.this$0.isEmpty();
        }

        @Override // java.util.Set, java.util.Collection, java.lang.Iterable
        public Iterator<K> iterator() {
            return new KeyIterator(this.this$0);
        }

        @Override // java.util.Set, java.util.Collection
        public boolean remove(Object r2) {
            int r3 = this.this$0.indexOfKey(r2);
            if (r3 < 0) goto L6;
            this.this$0.removeAt(r3);
            return true;
        L6:
            return false;
        }

        @Override // java.util.Set, java.util.Collection
        public boolean removeAll(Collection<?> r3) {
            Collection<?> r4 = (Collection) ZeusTransformUtils.wrapperContextForParams(r3, Collection.class, "com.obric.memorydata.plugin");
            return this.this$0.removeAll(r4);
        }

        @Override // java.util.Set, java.util.Collection
        public boolean retainAll(Collection<?> r3) {
            Collection<?> r4 = (Collection) ZeusTransformUtils.wrapperContextForParams(r3, Collection.class, "com.obric.memorydata.plugin");
            return this.this$0.retainAll(r4);
        }

        @Override // java.util.Set, java.util.Collection
        public int size() {
            return this.this$0.size();
        }

        @Override // java.util.Set, java.util.Collection
        public Object[] toArray() {
            int r0 = this.this$0.size();
            Object[] r1 = new Object[r0];
            int r2 = 0;
        L3:
            if (r2 >= r0) goto L5;
            r1[r2] = this.this$0.keyAt(r2);
            r2 = r2 + 1;
            goto L3
        L5:
            return r1;
        }

        @Override // java.util.Set, java.util.Collection
        public <T> T[] toArray(T[] r4) {
            int r0 = size();
            if (r4.length >= r0) goto L5;
            r4 = (T[]) ((Object[]) ZeusTransformUtils.preCheckCast(Array.newInstance(r4.getClass().getComponentType(), r0), Object[].class, "com.obric.memorydata.plugin"));
        L5:
            int r1 = 0;
        L6:
            if (r1 >= r0) goto L9;
            T[] r5 = r4;
            r5[r1] = this.this$0.keyAt(r1);
            r1 = r1 + 1;
            goto L6
        L9:
            if (r4.length <= r0) goto L11;
            r4[r0] = null;
        L11:
            return r4;
        }
    }

    final class MapIterator implements Iterator<Map.Entry<K, V>>, Map.Entry<K, V> {
        int mEnd;
        boolean mEntryValid;
        int mIndex;
        final /* synthetic */ ArrayMap this$0;

        MapIterator(ArrayMap r1) {
            this.this$0 = r1;
            this.mEnd = r1.size() - 1;
            this.mIndex = -1;
        }

        @Override // java.util.Map.Entry
        public boolean equals(Object r5) {
            if (this.mEntryValid == false) goto L14;
            if (ZeusTransformUtils.instanceOf(r5, Map.Entry.class) == true) goto L7;
            return false;
        L7:
            Map.Entry r6 = (Map.Entry) ZeusTransformUtils.preCheckCast(r5, Map.Entry.class, "com.obric.memorydata.plugin");
            if (ContainerHelpersKt.equal(r6.getKey(), this.this$0.keyAt(this.mIndex)) == true) goto L10;
            return false;
        L10:
            if (ContainerHelpersKt.equal(r6.getValue(), this.this$0.valueAt(this.mIndex)) == false) goto L16;
            return true;
        L16:
            return false;
        L14:
            throw new IllegalStateException("This container does not support retaining Map.Entry objects");
        }

        @Override // java.util.Map.Entry
        public K getKey() {
            if (this.mEntryValid == false) goto L7;
            return this.this$0.keyAt(this.mIndex);
        L7:
            throw new IllegalStateException("This container does not support retaining Map.Entry objects");
        }

        @Override // java.util.Map.Entry
        public V getValue() {
            if (this.mEntryValid == false) goto L7;
            return this.this$0.valueAt(this.mIndex);
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
            K r0 = this.this$0.keyAt(this.mIndex);
            V r2 = this.this$0.valueAt(this.mIndex);
            int r1 = 0;
            if (r0 != null) goto L7;
            int r3 = 0;
        L8:
            if (r2 == null) goto L12;
            r1 = r2.hashCode();
        L12:
            return r3 ^ r1;
        L7:
            r3 = r0.hashCode();
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
            this.this$0.removeAt(this.mIndex);
            this.mIndex--;
            this.mEnd--;
            this.mEntryValid = false;
            return;
        L7:
            throw new IllegalStateException();
        }

        @Override // java.util.Map.Entry
        public V setValue(V r2) {
            if (this.mEntryValid == false) goto L7;
            return this.this$0.setValueAt(this.mIndex, r2);
        L7:
            throw new IllegalStateException("This container does not support retaining Map.Entry objects");
        }

        public String toString() {
            return getKey() + "=" + getValue();
        }
    }

    final class ValueCollection implements Collection<V> {
        final /* synthetic */ ArrayMap this$0;

        ValueCollection(ArrayMap r1) {
            this.this$0 = r1;
        }

        @Override // java.util.Collection
        public boolean add(V r1) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Collection
        public boolean addAll(Collection<? extends V> r2) {
            Collection r1 = (Collection) ZeusTransformUtils.wrapperContextForParams(r2, Collection.class, "com.obric.memorydata.plugin");
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Collection
        public void clear() {
            this.this$0.clear();
        }

        @Override // java.util.Collection
        public boolean contains(Object r1) {
            if (this.this$0.__restricted$indexOfValue(r1) < 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // java.util.Collection
        public boolean containsAll(Collection<?> r3) {
            Iterator r4 = ((Collection) ZeusTransformUtils.wrapperContextForParams(r3, Collection.class, "com.obric.memorydata.plugin")).iterator();
        L4:
            if (r4.hasNext() == false) goto L9;
            if (contains(r4.next()) == true) goto L4;
            return false;
        L9:
            return true;
        }

        @Override // java.util.Collection
        public boolean isEmpty() {
            return this.this$0.isEmpty();
        }

        @Override // java.util.Collection, java.lang.Iterable
        public Iterator<V> iterator() {
            return new ValueIterator(this.this$0);
        }

        @Override // java.util.Collection
        public boolean remove(Object r2) {
            int r3 = this.this$0.__restricted$indexOfValue(r2);
            if (r3 < 0) goto L6;
            this.this$0.removeAt(r3);
            return true;
        L6:
            return false;
        }

        @Override // java.util.Collection
        public boolean removeAll(Collection<?> r6) {
            Collection r7 = (Collection) ZeusTransformUtils.wrapperContextForParams(r6, Collection.class, "com.obric.memorydata.plugin");
            int r0 = this.this$0.size();
            int r1 = 0;
            boolean r2 = false;
        L3:
            if (r1 >= r0) goto L8;
            if (r7.contains(this.this$0.valueAt(r1)) == false) goto L7;
            this.this$0.removeAt(r1);
            r1 = r1 - 1;
            r0 = r0 - 1;
            r2 = true;
        L7:
            r1 = r1 + 1;
            goto L3
        L8:
            return r2;
        }

        @Override // java.util.Collection
        public boolean retainAll(Collection<?> r6) {
            Collection r7 = (Collection) ZeusTransformUtils.wrapperContextForParams(r6, Collection.class, "com.obric.memorydata.plugin");
            int r0 = this.this$0.size();
            int r1 = 0;
            boolean r2 = false;
        L3:
            if (r1 >= r0) goto L8;
            if (r7.contains(this.this$0.valueAt(r1)) == true) goto L7;
            this.this$0.removeAt(r1);
            r1 = r1 - 1;
            r0 = r0 - 1;
            r2 = true;
        L7:
            r1 = r1 + 1;
            goto L3
        L8:
            return r2;
        }

        @Override // java.util.Collection
        public int size() {
            return this.this$0.size();
        }

        @Override // java.util.Collection
        public Object[] toArray() {
            int r0 = this.this$0.size();
            Object[] r1 = new Object[r0];
            int r2 = 0;
        L3:
            if (r2 >= r0) goto L5;
            r1[r2] = this.this$0.valueAt(r2);
            r2 = r2 + 1;
            goto L3
        L5:
            return r1;
        }

        @Override // java.util.Collection
        public <T> T[] toArray(T[] r4) {
            int r0 = size();
            if (r4.length >= r0) goto L5;
            r4 = (T[]) ((Object[]) ZeusTransformUtils.preCheckCast(Array.newInstance(r4.getClass().getComponentType(), r0), Object[].class, "com.obric.memorydata.plugin"));
        L5:
            int r1 = 0;
        L6:
            if (r1 >= r0) goto L9;
            T[] r5 = r4;
            r5[r1] = this.this$0.valueAt(r1);
            r1 = r1 + 1;
            goto L6
        L9:
            if (r4.length <= r0) goto L11;
            r4[r0] = null;
        L11:
            return r4;
        }
    }

    final class ValueIterator extends IndexBasedArrayIterator<V> {
        final /* synthetic */ ArrayMap this$0;

        ValueIterator(ArrayMap r1) {
            this.this$0 = r1;
            super(r1.size());
        }

        @Override // androidx.collection.IndexBasedArrayIterator
        public V elementAt(int r1) {
            return this.this$0.valueAt(r1);
        }

        @Override // androidx.collection.IndexBasedArrayIterator
        public void removeAt(int r1) {
            this.this$0.removeAt(r1);
        }
    }

    public ArrayMap() {
    }

    public ArrayMap(int r1) {
        super(r1);
    }

    public ArrayMap(SimpleArrayMap r1) {
        super(r1);
    }

    static <T> boolean equalsSetHelper(Set<T> r4, Object r5) {
        Set r6 = (Set) ZeusTransformUtils.wrapperContextForParams(r4, Set.class, "com.obric.memorydata.plugin");
        if (r6 != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, Set.class) == false) goto L15;
        Set r7 = (Set) ZeusTransformUtils.preCheckCast(r5, Set.class, "com.obric.memorydata.plugin");
        if (r6.size() != r7.size()) goto L14;
        if (r6.containsAll(r7) == false) goto L14;
        return true;
    L14:
        return false;
    L15:
        return false;
    }

    public boolean containsAll(Collection<?> r3) {
        Iterator r4 = ((Collection) ZeusTransformUtils.wrapperContextForParams(r3, Collection.class, "com.obric.memorydata.plugin")).iterator();
    L4:
        if (r4.hasNext() == false) goto L9;
        if (containsKey(r4.next()) == true) goto L4;
        return false;
    L9:
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.collection.SimpleArrayMap, java.util.Map
    public boolean containsKey(Object r1) {
        return super.containsKey(r1);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.collection.SimpleArrayMap, java.util.Map
    public boolean containsValue(Object r1) {
        return super.containsValue(r1);
    }

    @Override // java.util.Map
    public Set<Map.Entry<K, V>> entrySet() {
        ArrayMap<K, V>.EntrySet r0 = this.mEntrySet;
        if (r0 != null) goto L6;
        ArrayMap<K, V>.EntrySet r1 = new EntrySet(this);
        this.mEntrySet = r1;
        return r1;
    L6:
        return r0;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.collection.SimpleArrayMap, java.util.Map
    public V get(Object r1) {
        return (V) super.get(r1);
    }

    @Override // java.util.Map
    public Set<K> keySet() {
        ArrayMap<K, V>.KeySet r0 = this.mKeySet;
        if (r0 != null) goto L6;
        ArrayMap<K, V>.KeySet r1 = new KeySet(this);
        this.mKeySet = r1;
        return r1;
    L6:
        return r0;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Map
    public void putAll(Map<? extends K, ? extends V> r4) {
        Map r5 = (Map) ZeusTransformUtils.wrapperContextForParams(r4, Map.class, "com.obric.memorydata.plugin");
        ensureCapacity(size() + r5.size());
        Iterator<Map.Entry<K, V>> r6 = r5.entrySet().iterator();
    L4:
        if (r6.hasNext() == false) goto L6;
        Map.Entry r0 = (Map.Entry) ZeusTransformUtils.preCheckCast(r6.next(), Map.Entry.class, "com.obric.memorydata.plugin");
        put(r0.getKey(), r0.getValue());
        goto L4
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.collection.SimpleArrayMap, java.util.Map
    public V remove(Object r1) {
        return (V) super.remove(r1);
    }

    public boolean removeAll(Collection<?> r3) {
        Collection r4 = (Collection) ZeusTransformUtils.wrapperContextForParams(r3, Collection.class, "com.obric.memorydata.plugin");
        int r0 = size();
        Iterator r5 = r4.iterator();
    L4:
        if (r5.hasNext() == false) goto L7;
        remove(r5.next());
        goto L4
    L7:
        if (r0 == size()) goto L9;
        return true;
    L9:
        return false;
    }

    public boolean retainAll(Collection<?> r5) {
        Collection r6 = (Collection) ZeusTransformUtils.wrapperContextForParams(r5, Collection.class, "com.obric.memorydata.plugin");
        int r0 = size();
        int r1 = size() - 1;
    L3:
        if (r1 < 0) goto L9;
        if (r6.contains(keyAt(r1)) == true) goto L7;
        removeAt(r1);
    L7:
        r1 = r1 - 1;
        goto L3
    L9:
        if (r0 != size()) goto L16;
        return false;
    L16:
        return true;
    }

    @Override // java.util.Map
    public Collection<V> values() {
        ArrayMap<K, V>.ValueCollection r0 = this.mValues;
        if (r0 != null) goto L6;
        ArrayMap<K, V>.ValueCollection r1 = new ValueCollection(this);
        this.mValues = r1;
        return r1;
    L6:
        return r0;
    }
}
