package org.apache.commons.collections4.keyvalue;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Map;

/* JADX INFO: loaded from: classes6.dex */
public abstract class AbstractMapEntry<K, V> extends AbstractKeyValue<K, V> implements Map.Entry<K, V> {
    public AbstractMapEntry(K r1, V r2) {
        super(r1, r2);
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
        if (getKey() != null) goto L14;
        if (r6.getKey() == null) goto L16;
    L24:
        return false;
    L16:
        if (getValue() != null) goto L21;
        if (r6.getValue() != null) goto L24;
        return true;
    L21:
        if (getValue().equals(r6.getValue()) == false) goto L24;
        return true;
    L14:
        if (getKey().equals(r6.getKey()) == false) goto L24;
        goto L24
    }

    @Override // java.util.Map.Entry
    public int hashCode() {
        int r1 = 0;
        if (getKey() != null) goto L5;
        int r0 = 0;
    L7:
        if (getValue() == null) goto L11;
        r1 = getValue().hashCode();
    L11:
        return r0 ^ r1;
    L5:
        r0 = getKey().hashCode();
        goto L7
    }

    @Override // org.apache.commons.collections4.keyvalue.AbstractKeyValue, java.util.Map.Entry
    public V setValue(V r1) {
        return (V) super.setValue(r1);
    }
}
