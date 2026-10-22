package com.google.common.collect;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
abstract class b<K, V> implements Map.Entry<K, V> {
    b() {
    }

    @Override // java.util.Map.Entry
    public boolean equals(Object r4) {
        if (ZeusTransformUtils.instanceOf(r4, Map.Entry.class) == false) goto L10;
        Map.Entry r5 = (Map.Entry) ZeusTransformUtils.preCheckCast(r4, Map.Entry.class, "com.obric.memorydata.plugin");
        if (com.google.common.base.k.a(getKey(), r5.getKey()) == true) goto L7;
        return false;
    L7:
        if (com.google.common.base.k.a(getValue(), r5.getValue()) == false) goto L12;
        return true;
    L12:
        return false;
    L10:
        return false;
    }

    @Override // java.util.Map.Entry
    public abstract K getKey();

    @Override // java.util.Map.Entry
    public abstract V getValue();

    @Override // java.util.Map.Entry
    public int hashCode() {
        K r0 = getKey();
        V r2 = getValue();
        int r1 = 0;
        if (r0 != null) goto L5;
        int r3 = 0;
    L6:
        if (r2 == null) goto L10;
        r1 = r2.hashCode();
    L10:
        return r3 ^ r1;
    L5:
        r3 = r0.hashCode();
        goto L6
    }

    @Override // java.util.Map.Entry
    public V setValue(V r1) {
        throw new UnsupportedOperationException();
    }

    public String toString() {
        return getKey() + "=" + getValue();
    }
}
