package com.byted.cast.render.utils;

import com.byted.cast.common.CastLogger;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public class Logger {
    private static int LOG_LEVEL = 2;
    private static final String TAG = "MediaRender";
    private static CastLogger mCastLogger;

    public Logger() {
    }

    private static String prefix(String r10) {
        if (r10 != null) goto L5;
        return "";
    L5:
        if ("".equals(r10) == false) goto L7;
        return "";
    L7:
        return r10.concat(":");
    }

    public static void setCastLogger(CastLogger r0) {
        mCastLogger = r0;
    }

    public static void setLogLevel(int r0) {
        LOG_LEVEL = r0;
    }

    public static void d(String r10, String r11) {
        CastLogger r0 = mCastLogger;
        if (r0 == null) goto L7;
        r0.d(TAG, prefix(r10) + r11);
        return;
    L7:
        if (LOG_LEVEL <= 3) goto L9;
        return;
    L9:
        prefix(r10);
    }

    public static void e(String r10, String r11) {
        CastLogger r0 = mCastLogger;
        if (r0 == null) goto L7;
        r0.e(TAG, prefix(r10) + r11);
        return;
    L7:
        if (LOG_LEVEL <= 6) goto L9;
        return;
    L9:
        prefix(r10);
    }

    public static void i(String r10, String r11) {
        CastLogger r0 = mCastLogger;
        if (r0 == null) goto L7;
        r0.i(TAG, prefix(r10) + r11);
        return;
    L7:
        if (LOG_LEVEL <= 4) goto L9;
        return;
    L9:
        prefix(r10);
    }

    public static void v(String r10, String r11) {
        CastLogger r0 = mCastLogger;
        if (r0 == null) goto L7;
        r0.v(TAG, prefix(r10) + r11);
        return;
    L7:
        if (LOG_LEVEL <= 2) goto L9;
        return;
    L9:
        prefix(r10);
    }

    public static void w(String r10, String r11) {
        CastLogger r0 = mCastLogger;
        if (r0 == null) goto L7;
        r0.w(TAG, prefix(r10) + r11);
        return;
    L7:
        if (LOG_LEVEL <= 5) goto L9;
        return;
    L9:
        prefix(r10);
    }
}
