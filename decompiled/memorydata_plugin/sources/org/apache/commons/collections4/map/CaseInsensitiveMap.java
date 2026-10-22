package org.apache.commons.collections4.map;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Map;

/* JADX INFO: loaded from: classes6.dex */
public class CaseInsensitiveMap<K, V> extends AbstractHashedMap<K, V> implements Serializable, Cloneable {
    private static final long serialVersionUID = -7074655917369299456L;

    public CaseInsensitiveMap() {
        super(16, 0.75f, 12);
    }

    public CaseInsensitiveMap(int r1) {
        super(r1);
    }

    public CaseInsensitiveMap(int r1, float r2) {
        super(r1, r2);
    }

    public CaseInsensitiveMap(Map<? extends K, ? extends V> r3) {
        super((Map) ZeusTransformUtils.wrapperContextForParams(r3, Map.class, "com.obric.memorydata.plugin"));
    }

    private void readObject(ObjectInputStream r1) {
        r1.defaultReadObject();
        doReadObject(r1);
    }

    private void writeObject(ObjectOutputStream r1) {
        r1.defaultWriteObject();
        doWriteObject(r1);
    }

    @Override // org.apache.commons.collections4.map.AbstractHashedMap, java.util.AbstractMap
    public /* bridge */ /* synthetic */ Object clone() {
        return clone();
    }

    @Override // org.apache.commons.collections4.map.AbstractHashedMap, java.util.AbstractMap
    public /* bridge */ /* synthetic */ AbstractHashedMap clone() {
        return clone();
    }

    @Override // org.apache.commons.collections4.map.AbstractHashedMap, java.util.AbstractMap
    public CaseInsensitiveMap<K, V> clone() {
        return (CaseInsensitiveMap) ZeusTransformUtils.preCheckCast(super.clone(), CaseInsensitiveMap.class, "com.obric.memorydata.plugin");
    }

    @Override // org.apache.commons.collections4.map.AbstractHashedMap
    public Object convertKey(Object r2) {
        if (r2 == null) goto L9;
        char[] r1 = r2.toString().toCharArray();
        int r3 = r1.length - 1;
    L4:
        if (r3 < 0) goto L7;
        r1[r3] = Character.toLowerCase(Character.toUpperCase(r1[r3]));
        r3 = r3 - 1;
        goto L4
    L7:
        return new String(r1);
    L9:
        return AbstractHashedMap.NULL;
    }
}
