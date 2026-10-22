package n4a;

import android.content.Context;
import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class a0 {
    public static Map<String, String> b(Context r2, String r3, String r4, String r5, String r6, String r7, String r8, String r9) {
        HashMap r0 = new HashMap(16);
        r0.put("key", v4.g(r2));
        if (TextUtils.isEmpty(r3) == true) goto L6;
        r0.put("keywords", r3);
    L6:
        if (TextUtils.isEmpty(r4) == true) goto L9;
        r0.put("types", r4);
    L9:
        if (TextUtils.isEmpty(r7) == true) goto L14;
        if (TextUtils.isEmpty(r8) == true) goto L14;
        r0.put("location", r8 + "," + r7);
    L14:
        if (TextUtils.isEmpty(r5) == true) goto L17;
        r0.put("city", r5);
    L17:
        if (TextUtils.isEmpty(r6) == true) goto L20;
        r0.put("offset", r6);
    L20:
        if (TextUtils.isEmpty(r9) == true) goto L22;
        r0.put("radius", r9);
    L22:
        return r0;
    }

    public a0(Context r2) {
        z4.a.a.a(r2);     // Catch: Throwable -> L6
    L4:
        com.loc.c.c();
    }

    public static String a(Context r6, String r7, Map r8) {
        HashMap r0 = new HashMap(16);     // Catch: Throwable -> L9
        x3 r1 = new x3();     // Catch: Throwable -> L9
        r0.clear();     // Catch: Throwable -> L9
        r0.put("Content-Type", "application/x-www-form-urlencoded");     // Catch: Throwable -> L9
        r0.put("Connection", "Keep-Alive");     // Catch: Throwable -> L9
        r0.put("User-Agent", "AMAP_Location_SDK_Android 6.4.8");     // Catch: Throwable -> L9
        String r2 = w4.a();     // Catch: Throwable -> L9
        String r3 = w4.b(r6, r2, f5.l(r8));     // Catch: Throwable -> L9
        HashMap r5 = (HashMap) r8;     // Catch: Throwable -> L9
        r5.put("ts", r2);     // Catch: Throwable -> L9
        r5.put("scode", r3);     // Catch: Throwable -> L9
        r1.l = r8;     // Catch: Throwable -> L9
        r1.k = r0;     // Catch: Throwable -> L9
        r1.m = r7;     // Catch: Throwable -> L9
        r1.b = d5.a(r6);     // Catch: Throwable -> L9
        String r9 = c4.a;     // Catch: Throwable -> L9
        r1.a = 30000;     // Catch: Throwable -> L9
        goto L7
    L13:
        return new String(com.loc.c.a(r1).a, "utf-8");
    L5:
        th = move-exception;
        c4.g(th, "GeoFenceNetManager", "post");     // Catch: Throwable -> L9
    L7:
        return null;
    }
}
