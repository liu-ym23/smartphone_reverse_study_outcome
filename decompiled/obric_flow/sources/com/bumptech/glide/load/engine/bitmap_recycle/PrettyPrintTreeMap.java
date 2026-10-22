package com.bumptech.glide.load.engine.bitmap_recycle;

import ai.j0;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

/* JADX INFO: loaded from: classes.dex */
class PrettyPrintTreeMap<K, V> extends TreeMap<K, V> {
    public PrettyPrintTreeMap() {
    }

    @Override // java.util.AbstractMap
    public String toString() {
        StringBuilder r5 = j0.u("( ");
        Iterator<Map.Entry<K, V>> r10 = entrySet().iterator();
    L4:
        if (r10.hasNext() == false) goto L7;
        Map.Entry<K, V> r11 = r10.next();
        r5.append('{');
        r5.append(r11.getKey());
        r5.append(':');
        r5.append(r11.getValue());
        r5.append("}, ");
        goto L4
    L7:
        if (isEmpty() == true) goto L9;
        r5.replace(r5.length() - 2, r5.length(), "");
    L9:
        r5.append(" )");
        return r5.toString();
    }
}
