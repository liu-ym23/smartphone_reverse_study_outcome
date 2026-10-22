package com.bytedance.ai.applet.base.log;

import java.util.Map;
import kotlin.collections.MapsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class f {
    public static final ThreadLocal<Map<String, String>> a = null;

    static {
        a = new ThreadLocal();
    }

    public static Map a() {
        Map<String, String> r0 = a.get();
        if (r0 == null) goto L5;
        return r0;
    L5:
        return MapsKt.emptyMap();
    }

    public static void b(Map r1) {
        if (r1 != null) goto L4;
    L7:
        boolean r0 = true;
    L8:
        if (r0 == false) goto L10;
        a.remove();
        return;
    L10:
        a.set(r1);
        return;
    L4:
        if (r1.isEmpty() == true) goto L7;
        r0 = false;
        goto L8
    }
}
