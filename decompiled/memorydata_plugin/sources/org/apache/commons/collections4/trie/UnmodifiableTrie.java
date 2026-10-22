package org.apache.commons.collections4.trie;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.Serializable;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.SortedMap;
import org.apache.commons.collections4.MapIterator;
import org.apache.commons.collections4.OrderedMapIterator;
import org.apache.commons.collections4.Trie;
import org.apache.commons.collections4.Unmodifiable;
import org.apache.commons.collections4.iterators.UnmodifiableOrderedMapIterator;

/* JADX INFO: loaded from: classes6.dex */
public class UnmodifiableTrie<K, V> implements Serializable, Trie<K, V>, Unmodifiable {
    private static final long serialVersionUID = -7156426030315945159L;
    private final Trie<K, V> delegate;

    public UnmodifiableTrie(Trie<K, ? extends V> r3) {
        Trie<K, V> r4 = (Trie) ZeusTransformUtils.wrapperContextForParams(r3, Trie.class, "com.obric.memorydata.plugin");
        Objects.requireNonNull(r4, "Trie must not be null");
        this.delegate = r4;
    }

    public static <K, V> Trie<K, V> unmodifiableTrie(Trie<K, ? extends V> r2) {
        Trie<K, V> r3 = (Trie) ZeusTransformUtils.wrapperContextForParams(r2, Trie.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r3, Unmodifiable.class) == false) goto L6;
        return r3;
    L6:
        return new UnmodifiableTrie(r3);
    }

    @Override // java.util.Map
    public void clear() {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.SortedMap
    public Comparator<? super K> comparator() {
        return this.delegate.comparator();
    }

    @Override // java.util.Map
    public boolean containsKey(Object r1) {
        return this.delegate.containsKey(r1);
    }

    @Override // java.util.Map
    public boolean containsValue(Object r1) {
        return this.delegate.containsValue(r1);
    }

    @Override // java.util.SortedMap, java.util.Map
    public Set<Map.Entry<K, V>> entrySet() {
        return Collections.unmodifiableSet(this.delegate.entrySet());
    }

    @Override // java.util.Map
    public boolean equals(Object r1) {
        return this.delegate.equals(r1);
    }

    @Override // java.util.SortedMap, org.apache.commons.collections4.OrderedMap
    public K firstKey() {
        return this.delegate.firstKey();
    }

    @Override // java.util.Map
    public V get(Object r1) {
        return (V) this.delegate.get(r1);
    }

    @Override // java.util.Map
    public int hashCode() {
        return this.delegate.hashCode();
    }

    @Override // java.util.SortedMap
    public SortedMap<K, V> headMap(K r1) {
        return Collections.unmodifiableSortedMap(this.delegate.headMap(r1));
    }

    @Override // java.util.Map
    public boolean isEmpty() {
        return this.delegate.isEmpty();
    }

    @Override // java.util.SortedMap, java.util.Map
    public Set<K> keySet() {
        return Collections.unmodifiableSet(this.delegate.keySet());
    }

    @Override // java.util.SortedMap, org.apache.commons.collections4.OrderedMap
    public K lastKey() {
        return this.delegate.lastKey();
    }

    @Override // org.apache.commons.collections4.OrderedMap, org.apache.commons.collections4.IterableGet
    public /* bridge */ /* synthetic */ MapIterator mapIterator() {
        return mapIterator();
    }

    @Override // org.apache.commons.collections4.OrderedMap, org.apache.commons.collections4.IterableGet
    public OrderedMapIterator<K, V> mapIterator() {
        return UnmodifiableOrderedMapIterator.unmodifiableOrderedMapIterator(this.delegate.mapIterator());
    }

    @Override // org.apache.commons.collections4.OrderedMap
    public K nextKey(K r1) {
        return this.delegate.nextKey(r1);
    }

    @Override // org.apache.commons.collections4.Trie
    public SortedMap<K, V> prefixMap(K r1) {
        return Collections.unmodifiableSortedMap(this.delegate.prefixMap(r1));
    }

    @Override // org.apache.commons.collections4.OrderedMap
    public K previousKey(K r1) {
        return this.delegate.previousKey(r1);
    }

    @Override // java.util.Map
    public V put(K r1, V r2) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Map
    public void putAll(Map<? extends K, ? extends V> r2) {
        Map r1 = (Map) ZeusTransformUtils.wrapperContextForParams(r2, Map.class, "com.obric.memorydata.plugin");
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Map
    public V remove(Object r1) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Map
    public int size() {
        return this.delegate.size();
    }

    @Override // java.util.SortedMap
    public SortedMap<K, V> subMap(K r1, K r2) {
        return Collections.unmodifiableSortedMap(this.delegate.subMap(r1, r2));
    }

    @Override // java.util.SortedMap
    public SortedMap<K, V> tailMap(K r1) {
        return Collections.unmodifiableSortedMap(this.delegate.tailMap(r1));
    }

    public String toString() {
        return this.delegate.toString();
    }

    @Override // java.util.SortedMap, java.util.Map
    public Collection<V> values() {
        return Collections.unmodifiableCollection(this.delegate.values());
    }
}
