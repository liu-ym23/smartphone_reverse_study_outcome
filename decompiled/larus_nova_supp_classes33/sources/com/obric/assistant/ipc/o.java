package com.obric.assistant.ipc;

import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class o {
    /* JADX WARN: Multi-variable type inference failed */
    public static final Map<String, String> a(Map<Object, Object> r6) {
        if (r6 != null) goto L5;
        return null;
    L5:
        boolean r2 = true;
        if (r6.isEmpty() == true) goto L19;
        Iterator<Map.Entry<Object, Object>> r1 = r6.entrySet().iterator();
    L10:
        if (r1.hasNext() == false) goto L19;
        Map.Entry<Object, Object> r3 = r1.next();
        Object r4 = r3.getKey();
        Object r5 = r3.getValue();
        if ((r4 instanceof String) == true) goto L14;
    L16:
        boolean r7 = false;
    L17:
        if (r7 == true) goto L10;
        r2 = false;
        goto L19
    L14:
        if ((r5 instanceof String) == false) goto L16;
        r7 = true;
    L19:
        if (r2 == true) goto L22;
        r6 = null;
    L22:
        if (r6 != null) goto L24;
        return null;
    L24:
        return r6;
    }
}
