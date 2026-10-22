package org.apache.commons.collections4.map;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Collection;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;
import org.apache.commons.collections4.BoundedMap;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.collections4.collection.UnmodifiableCollection;
import org.apache.commons.collections4.set.UnmodifiableSet;

/* JADX INFO: loaded from: classes6.dex */
public class FixedSizeSortedMap<K, V> extends AbstractSortedMapDecorator<K, V> implements Serializable, BoundedMap<K, V> {
    private static final long serialVersionUID = 3126019624511683653L;

    public FixedSizeSortedMap(SortedMap<K, V> r3) {
        super((SortedMap) ZeusTransformUtils.wrapperContextForParams(r3, SortedMap.class, "com.obric.memorydata.plugin"));
    }

    public static <K, V> FixedSizeSortedMap<K, V> fixedSizeSortedMap(SortedMap<K, V> r2) {
        return new FixedSizeSortedMap((SortedMap) ZeusTransformUtils.wrapperContextForParams(r2, SortedMap.class, "com.obric.memorydata.plugin"));
    }

    private void readObject(ObjectInputStream r3) {
        r3.defaultReadObject();
        this.map = (Map) ZeusTransformUtils.preCheckCast(r3.readObject(), Map.class, "com.obric.memorydata.plugin");
    }

    private void writeObject(ObjectOutputStream r1) {
        r1.defaultWriteObject();
        r1.writeObject(this.map);
    }

    @Override // org.apache.commons.collections4.map.AbstractMapDecorator, java.util.Map
    public void clear() {
        throw new UnsupportedOperationException("Map is fixed size");
    }

    @Override // org.apache.commons.collections4.map.AbstractMapDecorator, java.util.Map
    public Set<Map.Entry<K, V>> entrySet() {
        return UnmodifiableSet.unmodifiableSet(this.map.entrySet());
    }

    public SortedMap<K, V> getSortedMap() {
        return (SortedMap) ZeusTransformUtils.preCheckCast(this.map, SortedMap.class, "com.obric.memorydata.plugin");
    }

    @Override // org.apache.commons.collections4.map.AbstractSortedMapDecorator, java.util.SortedMap
    public SortedMap<K, V> headMap(K r2) {
        return new FixedSizeSortedMap(getSortedMap().headMap(r2));
    }

    public boolean isFull() {
        return true;
    }

    @Override // org.apache.commons.collections4.map.AbstractMapDecorator, java.util.Map
    public Set<K> keySet() {
        return UnmodifiableSet.unmodifiableSet(this.map.keySet());
    }

    public int maxSize() {
        return size();
    }

    @Override // org.apache.commons.collections4.map.AbstractMapDecorator, java.util.Map
    public V put(K r2, V r3) {
        if (this.map.containsKey(r2) == false) goto L7;
        return this.map.put(r2, r3);
    L7:
        throw new IllegalArgumentException("Cannot put new key/value pair - Map is fixed size");
    }

    @Override // org.apache.commons.collections4.map.AbstractMapDecorator, java.util.Map
    public void putAll(Map<? extends K, ? extends V> r3) {
        Map<? extends K, ? extends V> r4 = (Map) ZeusTransformUtils.wrapperContextForParams(r3, Map.class, "com.obric.memorydata.plugin");
        if (CollectionUtils.isSubCollection(r4.keySet(), keySet()) == true) goto L7;
        this.map.putAll(r4);
        return;
    L7:
        throw new IllegalArgumentException("Cannot put new key/value pair - Map is fixed size");
    }

    @Override // org.apache.commons.collections4.map.AbstractMapDecorator, java.util.Map
    public V remove(Object r1) {
        throw new UnsupportedOperationException("Map is fixed size");
    }

    @Override // org.apache.commons.collections4.map.AbstractSortedMapDecorator, java.util.SortedMap
    public SortedMap<K, V> subMap(K r2, K r3) {
        return new FixedSizeSortedMap(getSortedMap().subMap(r2, r3));
    }

    @Override // org.apache.commons.collections4.map.AbstractSortedMapDecorator, java.util.SortedMap
    public SortedMap<K, V> tailMap(K r2) {
        return new FixedSizeSortedMap(getSortedMap().tailMap(r2));
    }

    @Override // org.apache.commons.collections4.map.AbstractMapDecorator, java.util.Map
    public Collection<V> values() {
        return UnmodifiableCollection.unmodifiableCollection(this.map.values());
    }
}
