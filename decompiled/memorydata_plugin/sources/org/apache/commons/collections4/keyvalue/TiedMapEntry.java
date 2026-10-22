package org.apache.commons.collections4.keyvalue;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.Serializable;
import java.util.Map;
import org.apache.commons.collections4.KeyValue;

/* JADX INFO: loaded from: classes6.dex */
public class TiedMapEntry<K, V> implements Serializable, Map.Entry<K, V>, KeyValue<K, V> {
    private static final long serialVersionUID = -8453869361373831205L;
    private final K key;
    private final Map<K, V> map;

    public TiedMapEntry(Map<K, V> r3, K r4) {
        this.map = (Map) ZeusTransformUtils.wrapperContextForParams(r3, Map.class, "com.obric.memorydata.plugin");
        this.key = r4;
    }

    @Override // java.util.Map.Entry
    public boolean equals(Object r5) {
        if (r5 != this) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, Map.Entry.class) == true) goto L8;
        return false;
    L8:
        Map.Entry r6 = (Map.Entry) ZeusTransformUtils.preCheckCast(r5, Map.Entry.class, "com.obric.memorydata.plugin");
        V r1 = getValue();
        K r4 = this.key;
        if (r4 != null) goto L14;
        if (r6.getKey() != null) goto L23;
    L15:
        Object r7 = r6.getValue();
        if (r1 != null) goto L20;
        if (r7 != null) goto L23;
        return true;
    L20:
        if (r1.equals(r7) == false) goto L23;
        return true;
    L23:
        return false;
    L14:
        if (r4.equals(r6.getKey()) == false) goto L23;
        goto L15
    }

    @Override // java.util.Map.Entry, org.apache.commons.collections4.KeyValue
    public K getKey() {
        return this.key;
    }

    @Override // java.util.Map.Entry, org.apache.commons.collections4.KeyValue
    public V getValue() {
        return this.map.get(this.key);
    }

    @Override // java.util.Map.Entry
    public int hashCode() {
        V r0 = getValue();
        int r2 = 0;
        if (getKey() != null) goto L5;
        int r3 = 0;
    L6:
        if (r0 == null) goto L10;
        r2 = r0.hashCode();
    L10:
        return r3 ^ r2;
    L5:
        r3 = getKey().hashCode();
        goto L6
    }

    @Override // java.util.Map.Entry
    public V setValue(V r2) {
        if (r2 == this) goto L6;
        return this.map.put(this.key, r2);
    L6:
        throw new IllegalArgumentException("Cannot set value to this map entry");
    }

    public String toString() {
        return getKey() + "=" + getValue();
    }
}
