package org.apache.commons.collections4.splitmap;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Collection;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import org.apache.commons.collections4.IterableGet;
import org.apache.commons.collections4.MapIterator;
import org.apache.commons.collections4.map.EntrySetToMapIteratorAdapter;

/* JADX INFO: loaded from: classes6.dex */
public class AbstractIterableGetMapDecorator<K, V> implements IterableGet<K, V> {
    transient Map<K, V> map;

    public AbstractIterableGetMapDecorator() {
    }

    public AbstractIterableGetMapDecorator(Map<K, V> r3) {
        Map<K, V> r4 = (Map) ZeusTransformUtils.wrapperContextForParams(r3, Map.class, "com.obric.memorydata.plugin");
        Objects.requireNonNull(r4, "Map must not be null.");
        this.map = r4;
    }

    public boolean containsKey(Object r1) {
        return decorated().containsKey(r1);
    }

    public boolean containsValue(Object r1) {
        return decorated().containsValue(r1);
    }

    public Map<K, V> decorated() {
        return this.map;
    }

    public Set<Map.Entry<K, V>> entrySet() {
        return decorated().entrySet();
    }

    public boolean equals(Object r1) {
        if (r1 != this) goto L6;
        return true;
    L6:
        return decorated().equals(r1);
    }

    public V get(Object r1) {
        return decorated().get(r1);
    }

    public int hashCode() {
        return decorated().hashCode();
    }

    public boolean isEmpty() {
        return decorated().isEmpty();
    }

    public Set<K> keySet() {
        return decorated().keySet();
    }

    @Override // org.apache.commons.collections4.IterableGet
    public MapIterator<K, V> mapIterator() {
        return new EntrySetToMapIteratorAdapter(entrySet());
    }

    public V remove(Object r1) {
        return decorated().remove(r1);
    }

    public int size() {
        return decorated().size();
    }

    public String toString() {
        return decorated().toString();
    }

    public Collection<V> values() {
        return decorated().values();
    }
}
