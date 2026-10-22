package org.apache.commons.collections4.map;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.AbstractList;
import java.util.AbstractSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import org.apache.commons.collections4.MapIterator;
import org.apache.commons.collections4.OrderedMap;
import org.apache.commons.collections4.OrderedMapIterator;
import org.apache.commons.collections4.ResettableIterator;
import org.apache.commons.collections4.iterators.AbstractUntypedIteratorDecorator;
import org.apache.commons.collections4.keyvalue.AbstractMapEntry;
import org.apache.commons.collections4.list.UnmodifiableList;

/* JADX INFO: loaded from: classes6.dex */
public class ListOrderedMap<K, V> extends AbstractMapDecorator<K, V> implements Serializable, OrderedMap<K, V> {
    private static final long serialVersionUID = 2728177751851003750L;
    private final List<K> insertOrder;

    static class EntrySetView<K, V> extends AbstractSet<Map.Entry<K, V>> {
        private Set<Map.Entry<K, V>> entrySet;
        private final List<K> insertOrder;
        private final ListOrderedMap<K, V> parent;

        public EntrySetView(ListOrderedMap<K, V> r3, List<K> r4) {
            List<K> r5 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.memorydata.plugin");
            this.parent = r3;
            this.insertOrder = r5;
        }

        private Set<Map.Entry<K, V>> getEntrySet() {
            if (this.entrySet != null) goto L6;
            this.entrySet = this.parent.decorated().entrySet();
        L6:
            return this.entrySet;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            this.parent.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object r1) {
            return getEntrySet().contains(r1);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean containsAll(Collection<?> r3) {
            Collection<?> r4 = (Collection) ZeusTransformUtils.wrapperContextForParams(r3, Collection.class, "com.obric.memorydata.plugin");
            return getEntrySet().containsAll(r4);
        }

        @Override // java.util.AbstractSet, java.util.Collection, java.util.Set
        public boolean equals(Object r1) {
            if (r1 != this) goto L6;
            return true;
        L6:
            return getEntrySet().equals(r1);
        }

        @Override // java.util.AbstractSet, java.util.Collection, java.util.Set
        public int hashCode() {
            return getEntrySet().hashCode();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean isEmpty() {
            return this.parent.isEmpty();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<Map.Entry<K, V>> iterator() {
            return new ListOrderedIterator(this.parent, this.insertOrder);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object r3) {
            if (ZeusTransformUtils.instanceOf(r3, Map.Entry.class) == true) goto L6;
            return false;
        L6:
            if (getEntrySet().contains(r3) == false) goto L9;
            Object r4 = ((Map.Entry) ZeusTransformUtils.preCheckCast(r3, Map.Entry.class, "com.obric.memorydata.plugin")).getKey();
            this.parent.remove(r4);
            return true;
        L9:
            return false;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return this.parent.size();
        }

        @Override // java.util.AbstractCollection
        public String toString() {
            return getEntrySet().toString();
        }
    }

    static class KeySetView<K> extends AbstractSet<K> {
        private final ListOrderedMap<K, Object> parent;

        KeySetView(ListOrderedMap<K, ?> r1) {
            this.parent = r1;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            this.parent.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object r1) {
            return this.parent.containsKey(r1);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<K> iterator() {
            final Iterator<Map.Entry<K, Object>> r1 = this.parent.entrySet().iterator();
            return new AnonymousClass1(this, r1);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return this.parent.size();
        }
    }

    static class ListOrderedIterator<K, V> extends AbstractUntypedIteratorDecorator<K, Map.Entry<K, V>> {
        private K last;
        private final ListOrderedMap<K, V> parent;

        ListOrderedIterator(ListOrderedMap<K, V> r3, List<K> r4) {
            super(((List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.memorydata.plugin")).iterator());
            this.last = null;
            this.parent = r3;
        }

        @Override // java.util.Iterator
        public /* bridge */ /* synthetic */ Object next() {
            return next();
        }

        @Override // java.util.Iterator
        public Map.Entry<K, V> next() {
            this.last = getIterator().next();
            return new ListOrderedMapEntry(this.parent, this.last);
        }

        @Override // org.apache.commons.collections4.iterators.AbstractUntypedIteratorDecorator, java.util.Iterator
        public void remove() {
            super.remove();
            this.parent.decorated().remove(this.last);
        }
    }

    static class ListOrderedMapEntry<K, V> extends AbstractMapEntry<K, V> {
        private final ListOrderedMap<K, V> parent;

        ListOrderedMapEntry(ListOrderedMap<K, V> r2, K r3) {
            super(r3, null);
            this.parent = r2;
        }

        @Override // org.apache.commons.collections4.keyvalue.AbstractKeyValue, org.apache.commons.collections4.KeyValue
        public V getValue() {
            return this.parent.get(getKey());
        }

        @Override // org.apache.commons.collections4.keyvalue.AbstractMapEntry, org.apache.commons.collections4.keyvalue.AbstractKeyValue, java.util.Map.Entry
        public V setValue(V r2) {
            return this.parent.decorated().put(getKey(), r2);
        }
    }

    static class ListOrderedMapIterator<K, V> implements OrderedMapIterator<K, V>, ResettableIterator<K> {
        private ListIterator<K> iterator;
        private K last;
        private final ListOrderedMap<K, V> parent;
        private boolean readable;

        ListOrderedMapIterator(ListOrderedMap<K, V> r2) {
            this.last = null;
            this.readable = false;
            this.parent = r2;
            this.iterator = ListOrderedMap.access$000(r2).listIterator();
        }

        public K getKey() {
            if (this.readable == false) goto L7;
            return this.last;
        L7:
            throw new IllegalStateException("getKey() can only be called after next() and before remove()");
        }

        @Override // org.apache.commons.collections4.MapIterator
        public V getValue() {
            if (this.readable == false) goto L7;
            return this.parent.get(this.last);
        L7:
            throw new IllegalStateException("getValue() can only be called after next() and before remove()");
        }

        @Override // org.apache.commons.collections4.MapIterator, java.util.Iterator
        public boolean hasNext() {
            return this.iterator.hasNext();
        }

        @Override // org.apache.commons.collections4.MapIterator, java.util.Iterator
        public K next() {
            K r0 = this.iterator.next();
            this.last = r0;
            this.readable = true;
            return r0;
        }

        @Override // org.apache.commons.collections4.MapIterator, java.util.Iterator
        public void remove() {
            if (this.readable == false) goto L7;
            this.iterator.remove();
            this.parent.map.remove(this.last);
            this.readable = false;
            return;
        L7:
            throw new IllegalStateException("remove() can only be called once after next()");
        }

        public String toString() {
            if (this.readable == true) goto L5;
            return "Iterator[]";
        L5:
            return "Iterator[" + getKey() + "=" + getValue() + "]";
        }
    }

    static class ValuesView<V> extends AbstractList<V> {
        private final ListOrderedMap<Object, V> parent;

        ValuesView(ListOrderedMap<?, V> r1) {
            this.parent = r1;
        }

        @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
        public void clear() {
            this.parent.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public boolean contains(Object r1) {
            return this.parent.containsValue(r1);
        }

        @Override // java.util.AbstractList, java.util.List
        public V get(int r1) {
            return this.parent.getValue(r1);
        }

        @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.List
        public Iterator<V> iterator() {
            final Iterator<Map.Entry<Object, V>> r1 = this.parent.entrySet().iterator();
            return new AnonymousClass1(this, r1);
        }

        @Override // java.util.AbstractList, java.util.List
        public V remove(int r1) {
            return this.parent.remove(r1);
        }

        @Override // java.util.AbstractList, java.util.List
        public V set(int r1, V r2) {
            return this.parent.setValue(r1, r2);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            return this.parent.size();
        }
    }

    public ListOrderedMap() {
        this(new HashMap());
    }

    public ListOrderedMap(Map<K, V> r3) {
        super((Map) ZeusTransformUtils.wrapperContextForParams(r3, Map.class, "com.obric.memorydata.plugin"));
        ArrayList r4 = new ArrayList();
        this.insertOrder = r4;
        r4.addAll(decorated().keySet());
    }

    static /* synthetic */ List access$000(ListOrderedMap r0) {
        return r0.insertOrder;
    }

    public static <K, V> ListOrderedMap<K, V> listOrderedMap(Map<K, V> r2) {
        return new ListOrderedMap((Map) ZeusTransformUtils.wrapperContextForParams(r2, Map.class, "com.obric.memorydata.plugin"));
    }

    private void readObject(ObjectInputStream r3) {
        r3.defaultReadObject();
        this.map = (Map) ZeusTransformUtils.preCheckCast(r3.readObject(), Map.class, "com.obric.memorydata.plugin");
    }

    private void writeObject(ObjectOutputStream r1) {
        r1.defaultWriteObject();
        r1.writeObject(this.map);
    }

    public List<K> asList() {
        return keyList();
    }

    @Override // org.apache.commons.collections4.map.AbstractMapDecorator, java.util.Map
    public void clear() {
        decorated().clear();
        this.insertOrder.clear();
    }

    @Override // org.apache.commons.collections4.map.AbstractMapDecorator, java.util.Map
    public Set<Map.Entry<K, V>> entrySet() {
        return new EntrySetView(this, this.insertOrder);
    }

    @Override // org.apache.commons.collections4.OrderedMap
    public K firstKey() {
        if (size() == 0) goto L7;
        return this.insertOrder.get(0);
    L7:
        throw new NoSuchElementException("Map is empty");
    }

    public K get(int r1) {
        return this.insertOrder.get(r1);
    }

    public V getValue(int r2) {
        return get(this.insertOrder.get(r2));
    }

    public int indexOf(Object r1) {
        return this.insertOrder.indexOf(r1);
    }

    public List<K> keyList() {
        return UnmodifiableList.unmodifiableList(this.insertOrder);
    }

    @Override // org.apache.commons.collections4.map.AbstractMapDecorator, java.util.Map
    public Set<K> keySet() {
        return new KeySetView(this);
    }

    @Override // org.apache.commons.collections4.OrderedMap
    public K lastKey() {
        if (size() == 0) goto L7;
        return this.insertOrder.get(size() - 1);
    L7:
        throw new NoSuchElementException("Map is empty");
    }

    @Override // org.apache.commons.collections4.map.AbstractIterableMap, org.apache.commons.collections4.IterableGet
    public /* bridge */ /* synthetic */ MapIterator mapIterator() {
        return mapIterator();
    }

    @Override // org.apache.commons.collections4.map.AbstractIterableMap, org.apache.commons.collections4.IterableGet
    public OrderedMapIterator<K, V> mapIterator() {
        return new ListOrderedMapIterator(this);
    }

    @Override // org.apache.commons.collections4.OrderedMap
    public K nextKey(Object r2) {
        int r3 = this.insertOrder.indexOf(r2);
        if (r3 >= 0) goto L5;
        return null;
    L5:
        if (r3 < (size() - 1)) goto L7;
        return null;
    L7:
        return this.insertOrder.get(r3 + 1);
    }

    @Override // org.apache.commons.collections4.OrderedMap
    public K previousKey(Object r2) {
        int r3 = this.insertOrder.indexOf(r2);
        if (r3 > 0) goto L5;
        return null;
    L5:
        return this.insertOrder.get(r3 - 1);
    }

    public V put(int r5, K r6, V r7) {
        if (r5 < 0) goto L15;
        if (r5 > this.insertOrder.size()) goto L15;
        Map<K, V> r0 = decorated();
        if (r0.containsKey(r6) == false) goto L12;
        V r1 = r0.remove(r6);
        int r2 = this.insertOrder.indexOf(r6);
        this.insertOrder.remove(r2);
        if (r2 >= r5) goto L10;
        r5 = r5 - 1;
    L10:
        this.insertOrder.add(r5, r6);
        r0.put(r6, r7);
        return r1;
    L12:
        this.insertOrder.add(r5, r6);
        r0.put(r6, r7);
        return null;
    L15:
        throw new IndexOutOfBoundsException("Index: " + r5 + ", Size: " + this.insertOrder.size());
    }

    @Override // org.apache.commons.collections4.map.AbstractMapDecorator, java.util.Map
    public V put(K r2, V r3) {
        if (decorated().containsKey(r2) == true) goto L5;
        V r4 = decorated().put(r2, r3);
        this.insertOrder.add(r2);
        return r4;
    L5:
        return decorated().put(r2, r3);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void putAll(int r6, Map<? extends K, ? extends V> r7) {
        Map r8 = (Map) ZeusTransformUtils.wrapperContextForParams(r7, Map.class, "com.obric.memorydata.plugin");
        if (r6 < 0) goto L16;
        if (r6 > this.insertOrder.size()) goto L16;
        Iterator<Map.Entry<K, V>> r9 = r8.entrySet().iterator();
    L8:
        if (r9.hasNext() == false) goto L14;
        Map.Entry r0 = (Map.Entry) ZeusTransformUtils.preCheckCast(r9.next(), Map.Entry.class, "com.obric.memorydata.plugin");
        boolean r2 = containsKey(r0.getKey());
        put(r6, r0.getKey(), r0.getValue());
        if (r2 == false) goto L13;
        r6 = indexOf(r0.getKey());
    L13:
        r6 = r6 + 1;
        goto L8
    L14:
        return;
    L16:
        throw new IndexOutOfBoundsException("Index: " + r6 + ", Size: " + this.insertOrder.size());
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // org.apache.commons.collections4.map.AbstractMapDecorator, java.util.Map
    public void putAll(Map<? extends K, ? extends V> r4) {
        Iterator<Map.Entry<K, V>> r5 = ((Map) ZeusTransformUtils.wrapperContextForParams(r4, Map.class, "com.obric.memorydata.plugin")).entrySet().iterator();
    L4:
        if (r5.hasNext() == false) goto L6;
        Map.Entry r0 = (Map.Entry) ZeusTransformUtils.preCheckCast(r5.next(), Map.Entry.class, "com.obric.memorydata.plugin");
        put(r0.getKey(), r0.getValue());
        goto L4
    }

    public V remove(int r1) {
        return remove(get(r1));
    }

    @Override // org.apache.commons.collections4.map.AbstractMapDecorator, java.util.Map
    public V remove(Object r2) {
        if (decorated().containsKey(r2) == false) goto L5;
        V r0 = decorated().remove(r2);
        this.insertOrder.remove(r2);
        return r0;
    L5:
        return null;
    }

    public V setValue(int r2, V r3) {
        return put(this.insertOrder.get(r2), r3);
    }

    @Override // org.apache.commons.collections4.map.AbstractMapDecorator
    public String toString() {
        if (isEmpty() == false) goto L6;
        return "{}";
    L6:
        StringBuilder r0 = new StringBuilder();
        r0.append('{');
        boolean r1 = true;
        Iterator<Map.Entry<K, V>> r2 = entrySet().iterator();
    L8:
        if (r2.hasNext() == false) goto L20;
        Map.Entry r3 = (Map.Entry) ZeusTransformUtils.preCheckCast(r2.next(), Map.Entry.class, "com.obric.memorydata.plugin");
        Object r4 = r3.getKey();
        Object r5 = r3.getValue();
        if (r1 == false) goto L12;
        r1 = false;
    L14:
        if (r4 != this) goto L16;
        r4 = "(this Map)";
    L16:
        r0.append(r4);
        r0.append('=');
        if (r5 != this) goto L19;
        r5 = "(this Map)";
    L19:
        r0.append(r5);
        goto L8
    L12:
        r0.append(", ");
        goto L14
    L20:
        r0.append('}');
        return r0.toString();
    }

    public List<V> valueList() {
        return new ValuesView(this);
    }

    @Override // org.apache.commons.collections4.map.AbstractMapDecorator, java.util.Map
    public Collection<V> values() {
        return new ValuesView(this);
    }
}
