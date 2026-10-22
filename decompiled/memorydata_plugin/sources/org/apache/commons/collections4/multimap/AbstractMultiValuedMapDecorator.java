package org.apache.commons.collections4.multimap;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.Serializable;
import java.util.Collection;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import org.apache.commons.collections4.MapIterator;
import org.apache.commons.collections4.MultiSet;
import org.apache.commons.collections4.MultiValuedMap;

/* JADX INFO: loaded from: classes6.dex */
public abstract class AbstractMultiValuedMapDecorator<K, V> implements Serializable, MultiValuedMap<K, V> {
    private static final long serialVersionUID = 20150612;
    private final MultiValuedMap<K, V> map;

    public AbstractMultiValuedMapDecorator(MultiValuedMap<K, V> r3) {
        MultiValuedMap<K, V> r4 = (MultiValuedMap) ZeusTransformUtils.wrapperContextForParams(r3, MultiValuedMap.class, "com.obric.memorydata.plugin");
        Objects.requireNonNull(r4, "MultiValuedMap must not be null.");
        this.map = r4;
    }

    @Override // org.apache.commons.collections4.MultiValuedMap
    public Map<K, Collection<V>> asMap() {
        return decorated().asMap();
    }

    @Override // org.apache.commons.collections4.MultiValuedMap
    public void clear() {
        decorated().clear();
    }

    @Override // org.apache.commons.collections4.MultiValuedMap
    public boolean containsKey(Object r1) {
        return decorated().containsKey(r1);
    }

    @Override // org.apache.commons.collections4.MultiValuedMap
    public boolean containsMapping(Object r1, Object r2) {
        return decorated().containsMapping(r1, r2);
    }

    @Override // org.apache.commons.collections4.MultiValuedMap
    public boolean containsValue(Object r1) {
        return decorated().containsValue(r1);
    }

    public MultiValuedMap<K, V> decorated() {
        return this.map;
    }

    @Override // org.apache.commons.collections4.MultiValuedMap
    public Collection<Map.Entry<K, V>> entries() {
        return decorated().entries();
    }

    public boolean equals(Object r1) {
        if (r1 != this) goto L6;
        return true;
    L6:
        return decorated().equals(r1);
    }

    @Override // org.apache.commons.collections4.MultiValuedMap
    public Collection<V> get(K r1) {
        return decorated().get(r1);
    }

    public int hashCode() {
        return decorated().hashCode();
    }

    @Override // org.apache.commons.collections4.MultiValuedMap
    public boolean isEmpty() {
        return decorated().isEmpty();
    }

    @Override // org.apache.commons.collections4.MultiValuedMap
    public Set<K> keySet() {
        return decorated().keySet();
    }

    @Override // org.apache.commons.collections4.MultiValuedMap
    public MultiSet<K> keys() {
        return decorated().keys();
    }

    @Override // org.apache.commons.collections4.MultiValuedMap
    public MapIterator<K, V> mapIterator() {
        return decorated().mapIterator();
    }

    @Override // org.apache.commons.collections4.MultiValuedMap
    public boolean put(K r1, V r2) {
        return decorated().put(r1, r2);
    }

    @Override // org.apache.commons.collections4.MultiValuedMap
    public boolean putAll(K r3, Iterable<? extends V> r4) {
        Iterable<? extends V> r5 = (Iterable) ZeusTransformUtils.wrapperContextForParams(r4, Iterable.class, "com.obric.memorydata.plugin");
        return decorated().putAll(r3, r5);
    }

    @Override // org.apache.commons.collections4.MultiValuedMap
    public boolean putAll(Map<? extends K, ? extends V> r3) {
        Map<? extends K, ? extends V> r4 = (Map) ZeusTransformUtils.wrapperContextForParams(r3, Map.class, "com.obric.memorydata.plugin");
        return decorated().putAll(r4);
    }

    @Override // org.apache.commons.collections4.MultiValuedMap
    public boolean putAll(MultiValuedMap<? extends K, ? extends V> r3) {
        MultiValuedMap<? extends K, ? extends V> r4 = (MultiValuedMap) ZeusTransformUtils.wrapperContextForParams(r3, MultiValuedMap.class, "com.obric.memorydata.plugin");
        return decorated().putAll(r4);
    }

    @Override // org.apache.commons.collections4.MultiValuedMap
    public Collection<V> remove(Object r1) {
        return decorated().remove(r1);
    }

    @Override // org.apache.commons.collections4.MultiValuedMap
    public boolean removeMapping(Object r1, Object r2) {
        return decorated().removeMapping(r1, r2);
    }

    @Override // org.apache.commons.collections4.MultiValuedMap
    public int size() {
        return decorated().size();
    }

    public String toString() {
        return decorated().toString();
    }

    @Override // org.apache.commons.collections4.MultiValuedMap
    public Collection<V> values() {
        return decorated().values();
    }
}
