package org.apache.commons.collections4.map;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Collection;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

/* JADX INFO: loaded from: classes6.dex */
public abstract class AbstractMapDecorator<K, V> extends AbstractIterableMap<K, V> {
    transient Map<K, V> map;

    public AbstractMapDecorator() {
    }

    public AbstractMapDecorator(Map<K, V> r3) {
        Map<K, V> r4 = (Map) ZeusTransformUtils.wrapperContextForParams(r3, Map.class, "com.obric.memorydata.plugin");
        Objects.requireNonNull(r4, "Map must not be null.");
        this.map = r4;
    }

    @Override // java.util.Map
    public void clear() {
        decorated().clear();
    }

    @Override // java.util.Map
    public boolean containsKey(Object r1) {
        return decorated().containsKey(r1);
    }

    @Override // java.util.Map
    public boolean containsValue(Object r1) {
        return decorated().containsValue(r1);
    }

    public Map<K, V> decorated() {
        return this.map;
    }

    @Override // java.util.Map
    public Set<Map.Entry<K, V>> entrySet() {
        return decorated().entrySet();
    }

    @Override // java.util.Map
    public boolean equals(Object r1) {
        if (r1 != this) goto L6;
        return true;
    L6:
        return decorated().equals(r1);
    }

    @Override // java.util.Map
    public V get(Object r1) {
        return decorated().get(r1);
    }

    @Override // java.util.Map
    public int hashCode() {
        return decorated().hashCode();
    }

    @Override // java.util.Map
    public boolean isEmpty() {
        return decorated().isEmpty();
    }

    @Override // java.util.Map
    public Set<K> keySet() {
        return decorated().keySet();
    }

    @Override // java.util.Map
    public V put(K r1, V r2) {
        return decorated().put(r1, r2);
    }

    @Override // java.util.Map
    public void putAll(Map<? extends K, ? extends V> r3) {
        Map<? extends K, ? extends V> r4 = (Map) ZeusTransformUtils.wrapperContextForParams(r3, Map.class, "com.obric.memorydata.plugin");
        decorated().putAll(r4);
    }

    @Override // java.util.Map
    public V remove(Object r1) {
        return decorated().remove(r1);
    }

    @Override // java.util.Map
    public int size() {
        return decorated().size();
    }

    public String toString() {
        return decorated().toString();
    }

    @Override // java.util.Map
    public Collection<V> values() {
        return decorated().values();
    }
}
