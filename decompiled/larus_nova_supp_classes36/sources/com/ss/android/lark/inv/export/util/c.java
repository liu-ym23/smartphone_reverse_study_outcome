package com.ss.android.lark.inv.export.util;

import android.util.Pair;
import com.ss.ugc.live.sdk.message.data.LimitedSizeHashMap;
import java.util.HashMap;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class c {
    /* JADX WARN: Multi-variable type inference failed */
    @SafeVarargs
    public static <K, V> HashMap<K, V> a(Pair<K, V>... r5) {
        LimitedSizeHashMap r0 = (HashMap<K, V>) new HashMap();
        if (r5.length == 0) goto L12;
        int r1 = r5.length;
        int r2 = 0;
    L6:
        if (r2 >= r1) goto L12;
        Pair<K, V> r3 = r5[r2];
        if (r3 == null) goto L11;
        r0.put(r3.first, r3.second);
    L11:
        r2 = r2 + 1;
    L12:
        return r0;
    }
}
