package com.google.common.collect;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public abstract class z<K, V> extends ac implements Map.Entry<K, V> {
    public z() {
    }

    public abstract Map.Entry<K, V> a();

    public boolean a(Object r4) {
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

    @Override // com.google.common.collect.ac
    public /* synthetic */ Object delegate() {
        return a();
    }

    public boolean equals(Object r1) {
        return a().equals(r1);
    }

    @Override // java.util.Map.Entry
    public K getKey() {
        return a().getKey();
    }

    public V getValue() {
        return a().getValue();
    }

    @Override // java.util.Map.Entry
    public int hashCode() {
        return a().hashCode();
    }

    public V setValue(V r1) {
        return a().setValue(r1);
    }
}
