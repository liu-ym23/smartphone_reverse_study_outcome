package com.bytedance.awemeopen.infra.plugs.applog;

import java.util.Iterator;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class e {
    public static void a(JSONObject r7, JSONObject r8) {
        if (r7 == null) goto L38;
        if (r8 == null) goto L39;
        Iterator<String> r1 = r8.keys();     // Catch: Throwable -> L25
    L7:
        if (r1.hasNext() == false) goto L40;
        String r2 = r1.next();     // Catch: Throwable -> L25
        if (r7.has(r2) == false) goto L11;
        String r4 = "";
        if (r8.has(r2) == true) goto L23;
        int r3 = 0;
    L17:
        if (r3 >= 10) goto L22;
        String r5 = r2 + "_" + r3;     // Catch: Throwable -> L25
        if (r8.has(r5) == false) goto L20;
        r3 = r3 + 1;     // Catch: Throwable -> L25
        goto L17
    L20:
        r4 = r5;
        goto L23
    L22:
        f.a("EventUtils", "not detect valid key");     // Catch: Throwable -> L25
    L23:
        r7.put(r4, r8.get(r2));     // Catch: Throwable -> L25
        goto L7
    L11:
        r7.put(r2, r8.get(r2));     // Catch: Throwable -> L25
        goto L7
    L40:
        return;
    L25:
        th = move-exception;
        f.a("EventUtils", th);
        return;
    L39:
        return;
    }
}
