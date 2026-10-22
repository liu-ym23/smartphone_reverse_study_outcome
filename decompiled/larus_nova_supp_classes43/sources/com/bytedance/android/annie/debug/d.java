package com.bytedance.android.annie.debug;

import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class d {
    public static volatile boolean a;

    static {
    }

    public d() {
    }

    public static final Map a() {
        LinkedHashMap r0 = new LinkedHashMap();
        if (a8.b.a.length() <= 0) goto L5;
        boolean r1 = true;
    L6:
        if (r1 == false) goto L13;
        r0.put("x-tt-env", a8.b.a);
        if (StringsKt.startsWith$default(a8.b.a, "ppe_", false, 2, null) == false) goto L11;
        r0.put("x-use-ppe", "1");
        goto L13
    L11:
        if (StringsKt.startsWith$default(a8.b.a, "boe_", false, 2, null) == false) goto L13;
        r0.put("x-use-boe", "1");
    L13:
        return r0;
    L5:
        r1 = false;
        goto L6
    }
}
