package com.bytedance.android.live.core.log;

import android.text.TextUtils;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public abstract class g {
    public g() {
    }

    public abstract JSONObject h();

    public static JSONObject l(Map r3) {
        if (r3 != null) goto L5;
        return null;
    L5:
        JSONObject r0 = new JSONObject();
        Iterator r4 = r3.entrySet().iterator();
    L7:
        if (r4.hasNext() == false) goto L12;
        Map.Entry r1 = (Map.Entry) r4.next();     // Catch: Exception -> L10
        r0.put((String) r1.getKey(), r1.getValue());     // Catch: Exception -> L10
    L10:
        e = move-exception;
        e.printStackTrace();
        goto L7
    L12:
        return r0;
    }

    public static void a(String r1, String r2) {
        if (TextUtils.isEmpty(r1) == false) goto L5;
        return;
    L5:
        if (TextUtils.isEmpty(r2) == true) goto L10;
        ALogger.d(r1, r2);
        return;
    }

    public static void c(String r1, String r2) {
        if (TextUtils.isEmpty(r1) == false) goto L5;
        return;
    L5:
        if (TextUtils.isEmpty(r2) == true) goto L10;
        ALogger.e(r1, r2);
        return;
    }

    public static void e(String r1, Throwable r2) {
        if (TextUtils.isEmpty(r1) == true) goto L8;
        if (r2 == null) goto L9;
        ALogger.e(r1, r2);
        return;
    L9:
        return;
    }

    public static void i(String r1, String r2) {
        if (TextUtils.isEmpty(r1) == false) goto L5;
        return;
    L5:
        if (TextUtils.isEmpty(r2) == true) goto L10;
        ALogger.i(r1, r2);
        return;
    }

    public static void m(int r1, StackTraceElement[] r2) {
        ALogger.stacktrace(r1, "ttlive_exception", r2);
    }

    public static void n(String r1, String r2) {
        if (TextUtils.isEmpty(r1) == false) goto L5;
        return;
    L5:
        if (TextUtils.isEmpty(r2) == true) goto L10;
        ALogger.w(r1, r2);
        return;
    }

    public final void b(final String r2, final Map<String, ?> r3) {
        if (TextUtils.isEmpty(r2) == true) goto L8;
        if (r3 == null) goto L9;
        ALogger.d(r2, new e(this, r2, r3));
        return;
    L9:
        return;
    }

    public final void f(String r2, Map<String, ?> r3) {
        if (TextUtils.isEmpty(r2) == true) goto L8;
        if (r3 == null) goto L9;
        ALogger.e(r2, g(r2, l(r3)));
        return;
    L9:
        return;
    }

    public final String g(String r4, JSONObject r5) {
        JSONObject r0 = new JSONObject();
        JSONObject r1 = h();
        r0.put("tag", r4);     // Catch: Exception -> L8
        if (r1 == null) goto L6;
        r0.put("params", h());     // Catch: Exception -> L8
    L6:
        r0.put("data", r5.toString());     // Catch: Exception -> L8
    L11:
        return r0.toString();
    L8:
        e = move-exception;
        e.printStackTrace();
        goto L11
    }

    public final void j(String r2, Map<String, ?> r3) {
        if (TextUtils.isEmpty(r2) == true) goto L8;
        if (r3 == null) goto L9;
        k(r2, l(r3));
        return;
    L9:
        return;
    }

    public final void k(String r2, JSONObject r3) {
        if (TextUtils.isEmpty(r2) == true) goto L8;
        if (r3 == null) goto L9;
        ALogger.i(r2, g(r2, r3));
        return;
    L9:
        return;
    }

    public static void d(String r1, String r2, Throwable r3) {
        if (TextUtils.isEmpty(r1) == true) goto L8;
        if (r3 == null) goto L9;
        ALogger.e(r1, r2, r3);
        return;
    L9:
        return;
    }
}
