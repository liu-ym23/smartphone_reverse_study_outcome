package com.bumptech.glide.load.engine.bitmap_recycle;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

/* JADX INFO: loaded from: classes.dex */
class PrettyPrintTreeMap<K, V> extends TreeMap<K, V> {
    PrettyPrintTreeMap() {
    }

    @Override // java.util.AbstractMap
    public String toString() {
        StringBuilder r0 = new StringBuilder();
        r0.append("( ");
        Iterator<Map.Entry<K, V>> r1 = entrySet().iterator();
    L4:
        if (r1.hasNext() == false) goto L7;
        Map.Entry r2 = (Map.Entry) ZeusTransformUtils.preCheckCast(r1.next(), Map.Entry.class, "com.obric.memorydata.plugin");
        r0.append('{').append(r2.getKey()).append(':').append(r2.getValue()).append("}, ");
        goto L4
    L7:
        if (isEmpty() == true) goto L10;
        r0.replace(r0.length() - 2, r0.length(), "");
    L10:
        return r0.append(" )").toString();
    }
}
