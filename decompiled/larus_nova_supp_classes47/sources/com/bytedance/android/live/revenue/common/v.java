package com.bytedance.android.live.revenue.common;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class v {
    public static final /* synthetic */ int a = 0;

    public v() {
    }

    static {
    }

    public static JSONObject g(Map r3) {
        JSONObject r0 = new JSONObject();
        Iterator r4 = ((HashMap) r3).entrySet().iterator();
    L4:
        if (r4.hasNext() == false) goto L9;
        Map.Entry r1 = (Map.Entry) r4.next();     // Catch: Exception -> L7
        r0.put((String) r1.getKey(), r1.getValue());     // Catch: Exception -> L7
    L7:
        e = move-exception;
        e.printStackTrace();
        goto L4
    L9:
        return r0;
    }

    public static void a(String r1, String r2) {
        Intrinsics.checkNotNullParameter(r1, "tag");
        Intrinsics.checkNotNullParameter(r2, "message");
        jy0.b.a(r1, r2);
    }

    public static void c(String r2, Throwable r3) {
        Intrinsics.checkNotNullParameter(r2, "tag");
        Intrinsics.checkNotNullParameter(r3, "throwable");
        jy0.b.c(r2, null, r3, 2);
    }

    public static void d(String r1, Map r2) {
        Intrinsics.checkNotNullParameter(r1, "tag");
        if (r1.length() != 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == true) goto L9;
        b(r1, String.valueOf(g(r2)), null);
        return;
    L9:
        return;
    L5:
        r0 = false;
        goto L6
    }

    public static void e(String r1, String r2) {
        Intrinsics.checkNotNullParameter(r1, "tag");
        Intrinsics.checkNotNullParameter(r2, "message");
        jy0.b.d(r1, r2);
    }

    public static void f(String r3, Map r4) {
        boolean r1 = false;
        if (r3.length() != 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == true) goto L13;
        JSONObject r5 = g(r4);
        if (r3.length() != 0) goto L10;
        r1 = true;
    L10:
        if (r1 == true) goto L14;
        jy0.b.d(r3, r5.toString());
        return;
    L14:
        return;
    L13:
        return;
    L5:
        r0 = false;
        goto L6
    }

    public static void h(String r1, String r2) {
        Intrinsics.checkNotNullParameter(r1, "tag");
        Intrinsics.checkNotNullParameter(r2, "message");
        jy0.b.e(r1, r2, null);
    }

    public static void b(String r1, String r2, Throwable r3) {
        Intrinsics.checkNotNullParameter(r1, "tag");
        Intrinsics.checkNotNullParameter(r2, "message");
        jy0.b.b(r1, r2, r3);
    }
}
