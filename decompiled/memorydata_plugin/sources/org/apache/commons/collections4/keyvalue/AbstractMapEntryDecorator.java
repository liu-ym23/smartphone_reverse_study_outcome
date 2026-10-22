package org.apache.commons.collections4.keyvalue;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Map;
import java.util.Objects;
import org.apache.commons.collections4.KeyValue;

/* JADX INFO: loaded from: classes6.dex */
public abstract class AbstractMapEntryDecorator<K, V> implements Map.Entry<K, V>, KeyValue<K, V> {
    private final Map.Entry<K, V> entry;

    public AbstractMapEntryDecorator(Map.Entry<K, V> r3) {
        Map.Entry<K, V> r4 = (Map.Entry) ZeusTransformUtils.wrapperContextForParams(r3, Map.Entry.class, "com.obric.memorydata.plugin");
        Objects.requireNonNull(r4, "Map Entry must not be null.");
        this.entry = r4;
    }

    @Override // java.util.Map.Entry
    public boolean equals(Object r1) {
        if (r1 != this) goto L6;
        return true;
    L6:
        return this.entry.equals(r1);
    }

    @Override // java.util.Map.Entry, org.apache.commons.collections4.KeyValue
    public K getKey() {
        return this.entry.getKey();
    }

    public Map.Entry<K, V> getMapEntry() {
        return this.entry;
    }

    @Override // java.util.Map.Entry, org.apache.commons.collections4.KeyValue
    public V getValue() {
        return this.entry.getValue();
    }

    @Override // java.util.Map.Entry
    public int hashCode() {
        return this.entry.hashCode();
    }

    @Override // java.util.Map.Entry
    public V setValue(V r1) {
        return this.entry.setValue(r1);
    }

    public String toString() {
        return this.entry.toString();
    }
}
