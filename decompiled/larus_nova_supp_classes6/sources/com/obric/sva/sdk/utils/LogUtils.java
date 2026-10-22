package com.obric.sva.sdk.utils;

import com.obric.sva.sdk.logger.SLogger;
import com.obric.sva.sdk.logger.SpecialCategory;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
public class LogUtils {
    public LogUtils() {
    }

    public static void flushLog() {
        SLogger.INSTANCE.flush();
    }

    private static String getArgsString(Object... r4) {
        if (r4 != null) goto L4;
        return "";
    L4:
        if (r4.length == 0) goto L20;
        StringBuilder r0 = new StringBuilder();
        int r1 = r4.length;
        int r2 = 0;
    L7:
        if (r2 >= r1) goto L14;
        Object r3 = r4[r2];
        if (r3 != null) goto L11;
        r0.append("null");
    L12:
        r0.append(" ");
        r2 = r2 + 1;
        goto L7
    L11:
        r0.append(r3);
        goto L12
    L14:
        return r0.toString();
    L20:
        return "";
    }

    public static void d(String r2, Object... r3) {
        SLogger.INSTANCE.d("", r2 + " " + getArgsString(r3));
    }

    public static void e(String r2, Object... r3) {
        SLogger.INSTANCE.e("", r2 + " " + getArgsString(r3));
    }

    public static void d(String r2, String r3, Object... r4) {
        SLogger.INSTANCE.d(r2, r3 + " " + getArgsString(r4));
    }

    public static void e(String r2, String r3, Object... r4) {
        SLogger.INSTANCE.e(r2, r3 + " " + getArgsString(r4));
    }

    public static void i(String r2, String r3, Object... r4) {
        SLogger.INSTANCE.i(r2, r3 + " " + getArgsString(r4));
    }

    public static void v(String r2, String r3, Object... r4) {
        SLogger.INSTANCE.v(r2, r3 + " " + getArgsString(r4));
    }

    public static void w(String r2, String r3, Object... r4) {
        SLogger.INSTANCE.w(r2, r3 + " " + getArgsString(r4));
    }

    public static void s(String r2, String r3, SpecialCategory r4, Object... r5) {
        SLogger.INSTANCE.s(r2, r3 + " " + getArgsString(r5), r4);
    }
}
