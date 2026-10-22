package com.bytedance.crash.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class ListMap<K, V> extends HashMap<K, List<V>> {
    public ListMap() {
    }

    public List a() {
        return new ArrayList();
    }

    public final void a(Object r5, Object... r10) {
        if (r5 != null) goto L5;
        return;
    L5:
        if (r10.length <= 0) goto L9;
        int r11 = r10.length;
        int r12 = 0;
    L7:
        if (r12 >= r11) goto L12;
        a(r10[r12]).add(r5);
        r12 = r12 + 1;
        goto L7
    L12:
        return;
    }

    public final List a(Object r5) {
        List r10 = (List) super.get(r5);
        if (r10 != null) goto L6;
        List r11 = a();
        put(r5, r11);
        return r11;
    L6:
        return r10;
    }
}
