package org.apache.commons.collections4.map;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.Serializable;
import java.util.AbstractSet;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import org.apache.commons.collections4.BoundedMap;
import org.apache.commons.collections4.KeyValue;
import org.apache.commons.collections4.MapIterator;
import org.apache.commons.collections4.OrderedMap;
import org.apache.commons.collections4.OrderedMapIterator;
import org.apache.commons.collections4.ResettableIterator;
import org.apache.commons.collections4.iterators.SingletonIterator;
import org.apache.commons.collections4.keyvalue.TiedMapEntry;

/* JADX INFO: loaded from: classes6.dex */
public class SingletonMap<K, V> implements Serializable, Cloneable, BoundedMap<K, V>, KeyValue<K, V>, OrderedMap<K, V> {
    private static final long serialVersionUID = -8931271118676803261L;
    private final K key;
    private V value;

    static class SingletonMapIterator<K, V> implements OrderedMapIterator<K, V>, ResettableIterator<K> {
        private boolean canGetSet;
        private boolean hasNext;
        private final SingletonMap<K, V> parent;

        SingletonMapIterator(SingletonMap<K, V> r2) {
            this.hasNext = true;
            this.canGetSet = false;
            this.parent = r2;
        }

        public K getKey() {
            if (this.canGetSet == false) goto L7;
            return this.parent.getKey();
        L7:
            throw new IllegalStateException("getKey() can only be called after next() and before remove()");
        }

        @Override // org.apache.commons.collections4.MapIterator
        public V getValue() {
            if (this.canGetSet == false) goto L7;
            return this.parent.getValue();
        L7:
            throw new IllegalStateException("getValue() can only be called after next() and before remove()");
        }

        @Override // org.apache.commons.collections4.MapIterator, java.util.Iterator
        public boolean hasNext() {
            return this.hasNext;
        }

        @Override // org.apache.commons.collections4.MapIterator, java.util.Iterator
        public K next() {
            if (this.hasNext == false) goto L7;
            this.hasNext = false;
            this.canGetSet = true;
            return this.parent.getKey();
        L7:
            throw new NoSuchElementException("No next() entry in the iteration");
        }

        @Override // org.apache.commons.collections4.MapIterator, java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException();
        }

        public String toString() {
            if (this.hasNext == false) goto L7;
            return "Iterator[]";
        L7:
            return "Iterator[" + getKey() + "=" + getValue() + "]";
        }
    }

    static class SingletonValues<V> extends AbstractSet<V> implements Serializable {
        private static final long serialVersionUID = -3689524741863047872L;
        private final SingletonMap<?, V> parent;

        SingletonValues(SingletonMap<?, V> r1) {
            this.parent = r1;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object r1) {
            return this.parent.containsValue(r1);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean isEmpty() {
            return false;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<V> iterator() {
            return new SingletonIterator(this.parent.getValue(), false);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return 1;
        }
    }

    public SingletonMap() {
        this.key = null;
    }

    public SingletonMap(K r1, V r2) {
        this.key = r1;
        this.value = r2;
    }

    public SingletonMap(Map.Entry<? extends K, ? extends V> r3) {
        Map.Entry r4 = (Map.Entry) ZeusTransformUtils.wrapperContextForParams(r3, Map.Entry.class, "com.obric.memorydata.plugin");
        this.key = (K) r4.getKey();
        this.value = (V) r4.getValue();
    }

    public SingletonMap(Map<? extends K, ? extends V> r4) {
        Map r5 = (Map) ZeusTransformUtils.wrapperContextForParams(r4, Map.class, "com.obric.memorydata.plugin");
        if (r5.size() != 1) goto L7;
        Map.Entry r6 = (Map.Entry) ZeusTransformUtils.preCheckCast(r5.entrySet().iterator().next(), Map.Entry.class, "com.obric.memorydata.plugin");
        this.key = (K) r6.getKey();
        this.value = (V) r6.getValue();
        return;
    L7:
        throw new IllegalArgumentException("The map size must be 1");
    }

    public SingletonMap(KeyValue<K, V> r3) {
        KeyValue r4 = (KeyValue) ZeusTransformUtils.wrapperContextForParams(r3, KeyValue.class, "com.obric.memorydata.plugin");
        this.key = (K) r4.getKey();
        this.value = (V) r4.getValue();
    }

    @Override // java.util.Map
    public void clear() {
        throw new UnsupportedOperationException();
    }

    public /* bridge */ /* synthetic */ Object clone() {
        return m3072clone();
    }

    /* JADX INFO: renamed from: clone, reason: collision with other method in class */
    public SingletonMap<K, V> m3072clone() {
        return (SingletonMap) ZeusTransformUtils.preCheckCast(super.clone(), SingletonMap.class, "com.obric.memorydata.plugin");
    L5:
        throw new InternalError();
    }

    @Override // java.util.Map
    public boolean containsKey(Object r1) {
        return isEqualKey(r1);
    }

    @Override // java.util.Map
    public boolean containsValue(Object r1) {
        return isEqualValue(r1);
    }

    @Override // java.util.Map
    public Set<Map.Entry<K, V>> entrySet() {
        return Collections.singleton(new TiedMapEntry(this, getKey()));
    }

    @Override // java.util.Map
    public boolean equals(Object r5) {
        if (r5 != this) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, Map.class) == true) goto L8;
        return false;
    L8:
        Map r6 = (Map) ZeusTransformUtils.preCheckCast(r5, Map.class, "com.obric.memorydata.plugin");
        if (r6.size() == 1) goto L11;
        return false;
    L11:
        Map.Entry r7 = (Map.Entry) ZeusTransformUtils.preCheckCast(r6.entrySet().iterator().next(), Map.Entry.class, "com.obric.memorydata.plugin");
        if (isEqualKey(r7.getKey()) == false) goto L17;
        if (isEqualValue(r7.getValue()) == false) goto L17;
        return true;
    L17:
        return false;
    }

    @Override // org.apache.commons.collections4.OrderedMap
    public K firstKey() {
        return getKey();
    }

    @Override // java.util.Map
    public V get(Object r1) {
        if (isEqualKey(r1) == true) goto L5;
        return null;
    L5:
        return this.value;
    }

    @Override // org.apache.commons.collections4.KeyValue
    public K getKey() {
        return this.key;
    }

    @Override // org.apache.commons.collections4.KeyValue
    public V getValue() {
        return this.value;
    }

    @Override // java.util.Map
    public int hashCode() {
        int r1 = 0;
        if (getKey() != null) goto L5;
        int r0 = 0;
    L7:
        if (getValue() == null) goto L11;
        r1 = getValue().hashCode();
    L11:
        return r0 ^ r1;
    L5:
        r0 = getKey().hashCode();
        goto L7
    }

    @Override // java.util.Map
    public boolean isEmpty() {
        return false;
    }

    public boolean isEqualKey(Object r1) {
        K r0 = getKey();
        if (r1 != null) goto L8;
        if (r0 != null) goto L6;
        return true;
    L6:
        return false;
    L8:
        return r1.equals(r0);
    }

    public boolean isEqualValue(Object r1) {
        V r0 = getValue();
        if (r1 != null) goto L8;
        if (r0 != null) goto L6;
        return true;
    L6:
        return false;
    L8:
        return r1.equals(r0);
    }

    public boolean isFull() {
        return true;
    }

    @Override // java.util.Map
    public Set<K> keySet() {
        return Collections.singleton(this.key);
    }

    @Override // org.apache.commons.collections4.OrderedMap
    public K lastKey() {
        return getKey();
    }

    @Override // org.apache.commons.collections4.IterableGet
    public /* bridge */ /* synthetic */ MapIterator mapIterator() {
        return mapIterator();
    }

    @Override // org.apache.commons.collections4.IterableGet
    public OrderedMapIterator<K, V> mapIterator() {
        return new SingletonMapIterator(this);
    }

    public int maxSize() {
        return 1;
    }

    @Override // org.apache.commons.collections4.OrderedMap
    public K nextKey(K r1) {
        return null;
    }

    @Override // org.apache.commons.collections4.OrderedMap
    public K previousKey(K r1) {
        return null;
    }

    @Override // java.util.Map
    public V put(K r1, V r2) {
        if (isEqualKey(r1) == false) goto L7;
        return setValue(r2);
    L7:
        throw new IllegalArgumentException("Cannot put new key/value pair - Map is fixed size singleton");
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Map
    public void putAll(Map<? extends K, ? extends V> r4) {
        Map r5 = (Map) ZeusTransformUtils.wrapperContextForParams(r4, Map.class, "com.obric.memorydata.plugin");
        int r0 = r5.size();
        if (r0 != 0) goto L5;
        return;
    L5:
        if (r0 != 1) goto L9;
        Map.Entry r6 = (Map.Entry) ZeusTransformUtils.preCheckCast(r5.entrySet().iterator().next(), Map.Entry.class, "com.obric.memorydata.plugin");
        put(r6.getKey(), r6.getValue());
        return;
    L9:
        throw new IllegalArgumentException("The map size must be 0 or 1");
    }

    @Override // java.util.Map
    public V remove(Object r1) {
        throw new UnsupportedOperationException();
    }

    public V setValue(V r2) {
        V r0 = this.value;
        this.value = r2;
        return r0;
    }

    @Override // java.util.Map
    public int size() {
        return 1;
    }

    public String toString() {
        StringBuilder r0 = new StringBuilder(128).append('{');
        Object r2 = "(this Map)";
        if (getKey() != this) goto L5;
        Object r1 = "(this Map)";
    L6:
        StringBuilder r3 = r0.append(r1).append('=');
        if (getValue() == this) goto L11;
        r2 = getValue();
    L11:
        return r3.append(r2).append('}').toString();
    L5:
        r1 = getKey();
        goto L6
    }

    @Override // java.util.Map
    public Collection<V> values() {
        return new SingletonValues(this);
    }
}
