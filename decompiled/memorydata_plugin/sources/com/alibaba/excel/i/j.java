package com.alibaba.excel.i;

import java.util.HashMap;
import java.util.LinkedHashMap;

/* JADX INFO: loaded from: classes.dex */
public class j {
    public static <K, V> HashMap<K, V> a() {
        return new HashMap(16);
    }

    public static <K, V> HashMap<K, V> a(int r1) {
        return new HashMap(c(r1));
    }

    public static <K, V> LinkedHashMap<K, V> b(int r1) {
        return new LinkedHashMap(c(r1));
    }

    static int c(int r1) {
        if (r1 >= 3) goto L7;
        return r1 + 1;
    L7:
        if (r1 < 1073741824) goto L9;
        return Integer.MAX_VALUE;
    L9:
        return (int) ((r1 / 0.75f) + 1.0f);
    }
}
