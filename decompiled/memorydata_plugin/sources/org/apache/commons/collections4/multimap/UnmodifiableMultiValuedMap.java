package org.apache.commons.collections4.multimap;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Collection;
import java.util.Map;
import java.util.Set;
import org.apache.commons.collections4.MapIterator;
import org.apache.commons.collections4.MultiSet;
import org.apache.commons.collections4.MultiValuedMap;
import org.apache.commons.collections4.Unmodifiable;
import org.apache.commons.collections4.collection.UnmodifiableCollection;
import org.apache.commons.collections4.iterators.UnmodifiableMapIterator;
import org.apache.commons.collections4.map.UnmodifiableMap;
import org.apache.commons.collections4.multiset.UnmodifiableMultiSet;
import org.apache.commons.collections4.set.UnmodifiableSet;

/* JADX INFO: loaded from: classes6.dex */
public final class UnmodifiableMultiValuedMap<K, V> extends AbstractMultiValuedMapDecorator<K, V> implements Unmodifiable {
    private static final long serialVersionUID = 20150612;

    private UnmodifiableMultiValuedMap(MultiValuedMap<? extends K, ? extends V> r3) {
        super((MultiValuedMap) ZeusTransformUtils.wrapperContextForParams(r3, MultiValuedMap.class, "com.obric.memorydata.plugin"));
    }

    public static <K, V> UnmodifiableMultiValuedMap<K, V> unmodifiableMultiValuedMap(MultiValuedMap<? extends K, ? extends V> r2) {
        MultiValuedMap r3 = (MultiValuedMap) ZeusTransformUtils.wrapperContextForParams(r2, MultiValuedMap.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r3, Unmodifiable.class) == false) goto L7;
        return (UnmodifiableMultiValuedMap) ZeusTransformUtils.preCheckCast(r3, UnmodifiableMultiValuedMap.class, "com.obric.memorydata.plugin");
    L7:
        return new UnmodifiableMultiValuedMap(r3);
    }

    @Override // org.apache.commons.collections4.multimap.AbstractMultiValuedMapDecorator, org.apache.commons.collections4.MultiValuedMap
    public Map<K, Collection<V>> asMap() {
        return UnmodifiableMap.unmodifiableMap(decorated().asMap());
    }

    @Override // org.apache.commons.collections4.multimap.AbstractMultiValuedMapDecorator, org.apache.commons.collections4.MultiValuedMap
    public void clear() {
        throw new UnsupportedOperationException();
    }

    @Override // org.apache.commons.collections4.multimap.AbstractMultiValuedMapDecorator, org.apache.commons.collections4.MultiValuedMap
    public Collection<Map.Entry<K, V>> entries() {
        return UnmodifiableCollection.unmodifiableCollection(decorated().entries());
    }

    @Override // org.apache.commons.collections4.multimap.AbstractMultiValuedMapDecorator, org.apache.commons.collections4.MultiValuedMap
    public Collection<V> get(K r1) {
        return UnmodifiableCollection.unmodifiableCollection(decorated().get(r1));
    }

    @Override // org.apache.commons.collections4.multimap.AbstractMultiValuedMapDecorator, org.apache.commons.collections4.MultiValuedMap
    public Set<K> keySet() {
        return UnmodifiableSet.unmodifiableSet(decorated().keySet());
    }

    @Override // org.apache.commons.collections4.multimap.AbstractMultiValuedMapDecorator, org.apache.commons.collections4.MultiValuedMap
    public MultiSet<K> keys() {
        return UnmodifiableMultiSet.unmodifiableMultiSet(decorated().keys());
    }

    @Override // org.apache.commons.collections4.multimap.AbstractMultiValuedMapDecorator, org.apache.commons.collections4.MultiValuedMap
    public MapIterator<K, V> mapIterator() {
        return UnmodifiableMapIterator.unmodifiableMapIterator(decorated().mapIterator());
    }

    @Override // org.apache.commons.collections4.multimap.AbstractMultiValuedMapDecorator, org.apache.commons.collections4.MultiValuedMap
    public boolean put(K r1, V r2) {
        throw new UnsupportedOperationException();
    }

    @Override // org.apache.commons.collections4.multimap.AbstractMultiValuedMapDecorator, org.apache.commons.collections4.MultiValuedMap
    public boolean putAll(K r1, Iterable<? extends V> r2) {
        Iterable r0 = (Iterable) ZeusTransformUtils.wrapperContextForParams(r2, Iterable.class, "com.obric.memorydata.plugin");
        throw new UnsupportedOperationException();
    }

    @Override // org.apache.commons.collections4.multimap.AbstractMultiValuedMapDecorator, org.apache.commons.collections4.MultiValuedMap
    public boolean putAll(Map<? extends K, ? extends V> r2) {
        Map r1 = (Map) ZeusTransformUtils.wrapperContextForParams(r2, Map.class, "com.obric.memorydata.plugin");
        throw new UnsupportedOperationException();
    }

    @Override // org.apache.commons.collections4.multimap.AbstractMultiValuedMapDecorator, org.apache.commons.collections4.MultiValuedMap
    public boolean putAll(MultiValuedMap<? extends K, ? extends V> r2) {
        MultiValuedMap r1 = (MultiValuedMap) ZeusTransformUtils.wrapperContextForParams(r2, MultiValuedMap.class, "com.obric.memorydata.plugin");
        throw new UnsupportedOperationException();
    }

    @Override // org.apache.commons.collections4.multimap.AbstractMultiValuedMapDecorator, org.apache.commons.collections4.MultiValuedMap
    public Collection<V> remove(Object r1) {
        throw new UnsupportedOperationException();
    }

    @Override // org.apache.commons.collections4.multimap.AbstractMultiValuedMapDecorator, org.apache.commons.collections4.MultiValuedMap
    public boolean removeMapping(Object r1, Object r2) {
        throw new UnsupportedOperationException();
    }

    @Override // org.apache.commons.collections4.multimap.AbstractMultiValuedMapDecorator, org.apache.commons.collections4.MultiValuedMap
    public Collection<V> values() {
        return UnmodifiableCollection.unmodifiableCollection(decorated().values());
    }
}
