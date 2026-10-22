package org.apache.commons.collections4.map;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;
import org.apache.commons.collections4.IterableSortedMap;
import org.apache.commons.collections4.MapIterator;
import org.apache.commons.collections4.OrderedMapIterator;
import org.apache.commons.collections4.iterators.ListIteratorWrapper;

/* JADX INFO: loaded from: classes6.dex */
public abstract class AbstractSortedMapDecorator<K, V> extends AbstractMapDecorator<K, V> implements IterableSortedMap<K, V> {

    protected static class SortedMapIterator<K, V> extends EntrySetToMapIteratorAdapter<K, V> implements OrderedMapIterator<K, V> {
        public SortedMapIterator(Set<Map.Entry<K, V>> r3) {
            super((Set) ZeusTransformUtils.wrapperContextForParams(r3, Set.class, "com.obric.memorydata.plugin"));
        }

        @Override // org.apache.commons.collections4.map.EntrySetToMapIteratorAdapter
        public synchronized void reset() {
            monitor-enter(this);
            super.reset();     // Catch: Throwable -> L6
            this.iterator = new ListIteratorWrapper(this.iterator);     // Catch: Throwable -> L6
            monitor-exit(this);
            return;
        L6:
            th = move-exception;
            throw th;
        }
    }

    public AbstractSortedMapDecorator() {
    }

    public AbstractSortedMapDecorator(SortedMap<K, V> r3) {
        super((SortedMap) ZeusTransformUtils.wrapperContextForParams(r3, SortedMap.class, "com.obric.memorydata.plugin"));
    }

    @Override // java.util.SortedMap
    public Comparator<? super K> comparator() {
        return decorated().comparator();
    }

    @Override // org.apache.commons.collections4.map.AbstractMapDecorator
    public /* bridge */ /* synthetic */ Map decorated() {
        return decorated();
    }

    @Override // org.apache.commons.collections4.map.AbstractMapDecorator
    public SortedMap<K, V> decorated() {
        return (SortedMap) ZeusTransformUtils.preCheckCast(super.decorated(), SortedMap.class, "com.obric.memorydata.plugin");
    }

    @Override // java.util.SortedMap, org.apache.commons.collections4.OrderedMap
    public K firstKey() {
        return decorated().firstKey();
    }

    public SortedMap<K, V> headMap(K r1) {
        return decorated().headMap(r1);
    }

    @Override // java.util.SortedMap, org.apache.commons.collections4.OrderedMap
    public K lastKey() {
        return decorated().lastKey();
    }

    @Override // org.apache.commons.collections4.map.AbstractIterableMap, org.apache.commons.collections4.IterableGet
    public /* bridge */ /* synthetic */ MapIterator mapIterator() {
        return mapIterator();
    }

    @Override // org.apache.commons.collections4.map.AbstractIterableMap, org.apache.commons.collections4.IterableGet
    public OrderedMapIterator<K, V> mapIterator() {
        return new SortedMapIterator(entrySet());
    }

    public K nextKey(K r1) {
        Iterator<K> r0 = tailMap(r1).keySet().iterator();
        r0.next();
        if (r0.hasNext() == true) goto L7;
        return null;
    L7:
        return r0.next();
    }

    public K previousKey(K r1) {
        SortedMap<K, V> r0 = headMap(r1);
        if (r0.isEmpty() == false) goto L6;
        return null;
    L6:
        return r0.lastKey();
    }

    public SortedMap<K, V> subMap(K r1, K r2) {
        return decorated().subMap(r1, r2);
    }

    public SortedMap<K, V> tailMap(K r1) {
        return decorated().tailMap(r1);
    }
}
