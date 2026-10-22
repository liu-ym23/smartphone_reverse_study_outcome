package org.apache.commons.collections4.map;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.apache.commons.collections4.BoundedMap;
import org.apache.commons.collections4.collection.UnmodifiableCollection;
import org.apache.commons.collections4.set.UnmodifiableSet;

/* JADX INFO: loaded from: classes6.dex */
public class FixedSizeMap<K, V> extends AbstractMapDecorator<K, V> implements Serializable, BoundedMap<K, V> {
    private static final long serialVersionUID = 7450927208116179316L;

    public FixedSizeMap(Map<K, V> r3) {
        super((Map) ZeusTransformUtils.wrapperContextForParams(r3, Map.class, "com.obric.memorydata.plugin"));
    }

    public static <K, V> FixedSizeMap<K, V> fixedSizeMap(Map<K, V> r2) {
        return new FixedSizeMap((Map) ZeusTransformUtils.wrapperContextForParams(r2, Map.class, "com.obric.memorydata.plugin"));
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
        Iterator<K> r0 = r4.keySet().iterator();
    L4:
        if (r0.hasNext() == false) goto L10;
        if (containsKey(r0.next()) == true) goto L4;
        throw new IllegalArgumentException("Cannot put new key/value pair - Map is fixed size");
    L10:
        this.map.putAll(r4);
    }

    @Override // org.apache.commons.collections4.map.AbstractMapDecorator, java.util.Map
    public V remove(Object r1) {
        throw new UnsupportedOperationException("Map is fixed size");
    }

    @Override // org.apache.commons.collections4.map.AbstractMapDecorator, java.util.Map
    public Collection<V> values() {
        return UnmodifiableCollection.unmodifiableCollection(this.map.values());
    }
}
