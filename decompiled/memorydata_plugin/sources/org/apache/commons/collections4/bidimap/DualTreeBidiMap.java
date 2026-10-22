package org.apache.commons.collections4.bidimap;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;
import org.apache.commons.collections4.BidiMap;
import org.apache.commons.collections4.MapIterator;
import org.apache.commons.collections4.OrderedBidiMap;
import org.apache.commons.collections4.OrderedMap;
import org.apache.commons.collections4.OrderedMapIterator;
import org.apache.commons.collections4.ResettableIterator;
import org.apache.commons.collections4.SortedBidiMap;
import org.apache.commons.collections4.map.AbstractSortedMapDecorator;

/* JADX INFO: loaded from: classes6.dex */
public class DualTreeBidiMap<K, V> extends AbstractDualBidiMap<K, V> implements Serializable, SortedBidiMap<K, V> {
    private static final long serialVersionUID = 721969328361809L;
    private final Comparator<? super K> comparator;
    private final Comparator<? super V> valueComparator;

    protected static class BidiOrderedMapIterator<K, V> implements OrderedMapIterator<K, V>, ResettableIterator<K> {
        private ListIterator<Map.Entry<K, V>> iterator;
        private Map.Entry<K, V> last;
        private final AbstractDualBidiMap<K, V> parent;

        public BidiOrderedMapIterator(AbstractDualBidiMap<K, V> r2) {
            this.last = null;
            this.parent = r2;
            this.iterator = new ArrayList(r2.entrySet()).listIterator();
        }

        public K getKey() {
            Map.Entry<K, V> r1 = this.last;
            if (r1 == null) goto L7;
            return r1.getKey();
        L7:
            throw new IllegalStateException("Iterator getKey() can only be called after next() and before remove()");
        }

        @Override // org.apache.commons.collections4.MapIterator
        public V getValue() {
            Map.Entry<K, V> r1 = this.last;
            if (r1 == null) goto L7;
            return r1.getValue();
        L7:
            throw new IllegalStateException("Iterator getValue() can only be called after next() and before remove()");
        }

        @Override // org.apache.commons.collections4.MapIterator, java.util.Iterator
        public boolean hasNext() {
            return this.iterator.hasNext();
        }

        @Override // org.apache.commons.collections4.MapIterator, java.util.Iterator
        public K next() {
            Map.Entry<K, V> r0 = (Map.Entry) ZeusTransformUtils.preCheckCast(this.iterator.next(), Map.Entry.class, "com.obric.memorydata.plugin");
            this.last = r0;
            return r0.getKey();
        }

        @Override // org.apache.commons.collections4.MapIterator, java.util.Iterator
        public void remove() {
            this.iterator.remove();
            this.parent.remove(this.last.getKey());
            this.last = null;
        }

        public String toString() {
            if (this.last != null) goto L5;
            return "MapIterator[]";
        L5:
            return "MapIterator[" + getKey() + "=" + getValue() + "]";
        }
    }

    protected static class ViewMap<K, V> extends AbstractSortedMapDecorator<K, V> {
        public ViewMap(DualTreeBidiMap<K, V> r3, SortedMap<K, V> r4) {
            super(new DualTreeBidiMap((SortedMap) ZeusTransformUtils.wrapperContextForParams(r4, SortedMap.class, "com.obric.memorydata.plugin"), r3.reverseMap, r3.inverseBidiMap));
        }

        @Override // org.apache.commons.collections4.map.AbstractMapDecorator, java.util.Map
        public void clear() {
            Iterator<K> r1 = keySet().iterator();
        L4:
            if (r1.hasNext() == false) goto L6;
            r1.next();
            r1.remove();
            goto L4
        }

        @Override // org.apache.commons.collections4.map.AbstractMapDecorator, java.util.Map
        public boolean containsValue(Object r1) {
            return decorated().normalMap.containsValue(r1);
        }

        @Override // org.apache.commons.collections4.map.AbstractSortedMapDecorator, org.apache.commons.collections4.map.AbstractMapDecorator
        public /* bridge */ /* synthetic */ Map decorated() {
            return decorated();
        }

        @Override // org.apache.commons.collections4.map.AbstractSortedMapDecorator, org.apache.commons.collections4.map.AbstractMapDecorator
        public /* bridge */ /* synthetic */ SortedMap decorated() {
            return decorated();
        }

        @Override // org.apache.commons.collections4.map.AbstractSortedMapDecorator, org.apache.commons.collections4.map.AbstractMapDecorator
        public DualTreeBidiMap<K, V> decorated() {
            return (DualTreeBidiMap) ZeusTransformUtils.preCheckCast(super.decorated(), DualTreeBidiMap.class, "com.obric.memorydata.plugin");
        }

        @Override // org.apache.commons.collections4.map.AbstractSortedMapDecorator, java.util.SortedMap
        public SortedMap<K, V> headMap(K r3) {
            return new ViewMap(decorated(), super.headMap(r3));
        }

        @Override // org.apache.commons.collections4.map.AbstractSortedMapDecorator, org.apache.commons.collections4.OrderedMap
        public K nextKey(K r1) {
            return decorated().nextKey(r1);
        }

        @Override // org.apache.commons.collections4.map.AbstractSortedMapDecorator, org.apache.commons.collections4.OrderedMap
        public K previousKey(K r1) {
            return decorated().previousKey(r1);
        }

        @Override // org.apache.commons.collections4.map.AbstractSortedMapDecorator, java.util.SortedMap
        public SortedMap<K, V> subMap(K r3, K r4) {
            return new ViewMap(decorated(), super.subMap(r3, r4));
        }

        @Override // org.apache.commons.collections4.map.AbstractSortedMapDecorator, java.util.SortedMap
        public SortedMap<K, V> tailMap(K r3) {
            return new ViewMap(decorated(), super.tailMap(r3));
        }
    }

    public DualTreeBidiMap() {
        super(new TreeMap(), new TreeMap());
        this.comparator = null;
        this.valueComparator = null;
    }

    public DualTreeBidiMap(Comparator<? super K> r3, Comparator<? super V> r4) {
        Comparator<? super K> r5 = (Comparator) ZeusTransformUtils.wrapperContextForParams(r3, Comparator.class, "com.obric.memorydata.plugin");
        Comparator<? super V> r6 = (Comparator) ZeusTransformUtils.wrapperContextForParams(r4, Comparator.class, "com.obric.memorydata.plugin");
        super(new TreeMap(r5), new TreeMap(r6));
        this.comparator = r5;
        this.valueComparator = r6;
    }

    public DualTreeBidiMap(Map<? extends K, ? extends V> r3) {
        Map<? extends K, ? extends V> r4 = (Map) ZeusTransformUtils.wrapperContextForParams(r3, Map.class, "com.obric.memorydata.plugin");
        super(new TreeMap(), new TreeMap());
        putAll(r4);
        this.comparator = null;
        this.valueComparator = null;
    }

    public DualTreeBidiMap(Map<K, V> r3, Map<V, K> r4, BidiMap<V, K> r5) {
        Map r6 = (Map) ZeusTransformUtils.wrapperContextForParams(r3, Map.class, "com.obric.memorydata.plugin");
        Map r7 = (Map) ZeusTransformUtils.wrapperContextForParams(r4, Map.class, "com.obric.memorydata.plugin");
        super(r6, r7, (BidiMap) ZeusTransformUtils.wrapperContextForParams(r5, BidiMap.class, "com.obric.memorydata.plugin"));
        this.comparator = ((SortedMap) ZeusTransformUtils.preCheckCast(r6, SortedMap.class, "com.obric.memorydata.plugin")).comparator();
        this.valueComparator = ((SortedMap) ZeusTransformUtils.preCheckCast(r7, SortedMap.class, "com.obric.memorydata.plugin")).comparator();
    }

    private void readObject(ObjectInputStream r3) {
        r3.defaultReadObject();
        this.normalMap = new TreeMap(this.comparator);
        this.reverseMap = new TreeMap(this.valueComparator);
        putAll((Map) ZeusTransformUtils.preCheckCast(r3.readObject(), Map.class, "com.obric.memorydata.plugin"));
    }

    private void writeObject(ObjectOutputStream r1) {
        r1.defaultWriteObject();
        r1.writeObject(this.normalMap);
    }

    @Override // java.util.SortedMap
    public Comparator<? super K> comparator() {
        return ((SortedMap) ZeusTransformUtils.preCheckCast(this.normalMap, SortedMap.class, "com.obric.memorydata.plugin")).comparator();
    }

    @Override // org.apache.commons.collections4.bidimap.AbstractDualBidiMap
    public /* synthetic */ BidiMap createBidiMap(Map r3, Map r4, BidiMap r5) {
        return createBidiMap((Map) ZeusTransformUtils.wrapperContextForParams(r3, Map.class, "com.obric.memorydata.plugin"), (Map) ZeusTransformUtils.wrapperContextForParams(r4, Map.class, "com.obric.memorydata.plugin"), (BidiMap) ZeusTransformUtils.wrapperContextForParams(r5, BidiMap.class, "com.obric.memorydata.plugin"));
    }

    @Override // org.apache.commons.collections4.bidimap.AbstractDualBidiMap
    public DualTreeBidiMap<V, K> createBidiMap(Map<V, K> r2, Map<K, V> r3, BidiMap<K, V> r4) {
        return new DualTreeBidiMap((Map) ZeusTransformUtils.wrapperContextForParams(r2, Map.class, "com.obric.memorydata.plugin"), (Map) ZeusTransformUtils.wrapperContextForParams(r3, Map.class, "com.obric.memorydata.plugin"), (BidiMap) ZeusTransformUtils.wrapperContextForParams(r4, BidiMap.class, "com.obric.memorydata.plugin"));
    }

    @Override // java.util.SortedMap, org.apache.commons.collections4.OrderedMap
    public K firstKey() {
        return (K) ((SortedMap) ZeusTransformUtils.preCheckCast(this.normalMap, SortedMap.class, "com.obric.memorydata.plugin")).firstKey();
    }

    @Override // java.util.SortedMap
    public SortedMap<K, V> headMap(K r4) {
        return new ViewMap(this, ((SortedMap) ZeusTransformUtils.preCheckCast(this.normalMap, SortedMap.class, "com.obric.memorydata.plugin")).headMap(r4));
    }

    @Override // org.apache.commons.collections4.bidimap.AbstractDualBidiMap
    public /* bridge */ /* synthetic */ BidiMap inverseBidiMap() {
        return inverseBidiMap();
    }

    @Override // org.apache.commons.collections4.bidimap.AbstractDualBidiMap
    public /* bridge */ /* synthetic */ OrderedBidiMap inverseBidiMap() {
        return inverseBidiMap();
    }

    @Override // org.apache.commons.collections4.bidimap.AbstractDualBidiMap
    public SortedBidiMap<V, K> inverseBidiMap() {
        return (SortedBidiMap) ZeusTransformUtils.preCheckCast(super.inverseBidiMap(), SortedBidiMap.class, "com.obric.memorydata.plugin");
    }

    public OrderedBidiMap<V, K> inverseOrderedBidiMap() {
        return inverseBidiMap();
    }

    public SortedBidiMap<V, K> inverseSortedBidiMap() {
        return inverseBidiMap();
    }

    @Override // java.util.SortedMap, org.apache.commons.collections4.OrderedMap
    public K lastKey() {
        return (K) ((SortedMap) ZeusTransformUtils.preCheckCast(this.normalMap, SortedMap.class, "com.obric.memorydata.plugin")).lastKey();
    }

    @Override // org.apache.commons.collections4.bidimap.AbstractDualBidiMap, org.apache.commons.collections4.IterableGet
    public /* bridge */ /* synthetic */ MapIterator mapIterator() {
        return mapIterator();
    }

    @Override // org.apache.commons.collections4.bidimap.AbstractDualBidiMap, org.apache.commons.collections4.IterableGet
    public OrderedMapIterator<K, V> mapIterator() {
        return new BidiOrderedMapIterator(this);
    }

    @Override // org.apache.commons.collections4.OrderedMap
    public K nextKey(K r4) {
        if (isEmpty() == false) goto L5;
        return null;
    L5:
        boolean r0 = ZeusTransformUtils.instanceOf(this.normalMap, OrderedMap.class);
        Map<K, V> r3 = this.normalMap;
        if (r0 == true) goto L8;
        Iterator<K> r5 = ((SortedMap) ZeusTransformUtils.preCheckCast(r3, SortedMap.class, "com.obric.memorydata.plugin")).tailMap(r4).keySet().iterator();
        r5.next();
        if (r5.hasNext() == true) goto L12;
        return null;
    L12:
        return r5.next();
    L8:
        return (K) ((OrderedMap) ZeusTransformUtils.preCheckCast(r3, OrderedMap.class, "com.obric.memorydata.plugin")).nextKey(r4);
    }

    @Override // org.apache.commons.collections4.OrderedMap
    public K previousKey(K r4) {
        if (isEmpty() == false) goto L5;
        return null;
    L5:
        boolean r0 = ZeusTransformUtils.instanceOf(this.normalMap, OrderedMap.class);
        Map<K, V> r3 = this.normalMap;
        if (r0 == true) goto L8;
        SortedMap<K, V> r5 = ((SortedMap) ZeusTransformUtils.preCheckCast(r3, SortedMap.class, "com.obric.memorydata.plugin")).headMap(r4);
        if (r5.isEmpty() == false) goto L13;
        return null;
    L13:
        return r5.lastKey();
    L8:
        return (K) ((OrderedMap) ZeusTransformUtils.preCheckCast(r3, OrderedMap.class, "com.obric.memorydata.plugin")).previousKey(r4);
    }

    @Override // java.util.SortedMap
    public SortedMap<K, V> subMap(K r4, K r5) {
        return new ViewMap(this, ((SortedMap) ZeusTransformUtils.preCheckCast(this.normalMap, SortedMap.class, "com.obric.memorydata.plugin")).subMap(r4, r5));
    }

    @Override // java.util.SortedMap
    public SortedMap<K, V> tailMap(K r4) {
        return new ViewMap(this, ((SortedMap) ZeusTransformUtils.preCheckCast(this.normalMap, SortedMap.class, "com.obric.memorydata.plugin")).tailMap(r4));
    }

    public Comparator<? super V> valueComparator() {
        return ((SortedMap) ZeusTransformUtils.preCheckCast(this.reverseMap, SortedMap.class, "com.obric.memorydata.plugin")).comparator();
    }
}
