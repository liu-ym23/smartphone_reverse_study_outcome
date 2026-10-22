package com.lynx.tasm.utils;

import com.lynx.react.bridge.ReadableMap;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class j {
    public static Map<String, String> a(ReadableMap r5) {
        HashMap r0 = new HashMap();
        HashMap<String, Object> r6 = r5.asHashMap();
        Iterator<String> r1 = r6.keySet().iterator();
    L4:
        if (r1.hasNext() == false) goto L13;
        String r2 = r1.next();
        Object r3 = r6.get(r2);
        if ((r3 instanceof List) == true) goto L7;
        if ((r3 instanceof Number) == true) goto L10;
        if (r3 == null) goto L4;
        r0.put(r2, r3.toString());
        goto L4
    L10:
        r0.put(r2, com.lynx.tasm.behavior.shadow.text.b.h(((Number) r3).doubleValue()));
        goto L4
    L7:
        r0.put(r2, android.text.TextUtils.join(",", (Iterable) r3));
        goto L4
    L13:
        return r0;
    }
}
