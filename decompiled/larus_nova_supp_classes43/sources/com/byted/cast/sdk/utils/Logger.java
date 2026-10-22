package com.byted.cast.sdk.utils;

import com.byted.cast.common.api.ILogger;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public class Logger {
    private static int LOG_LEVEL = 4;
    private static String TAG = "BYTELINK";
    private static ILogger sLogger;

    public Logger() {
    }

    private static int transNativeLogLevelToJava(int r1) {
        if (r1 == (-1)) goto L19;
        if (r1 != 0) goto L6;
        return 6;
    L6:
        if (r1 != 1) goto L8;
        return 5;
    L8:
        if (r1 != 3) goto L10;
        return 3;
    L10:
        if (r1 == 4) goto L12;
        return 4;
    L12:
        return 2;
    L19:
        return 7;
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

    public static void setLogLevel(int r0) {
        LOG_LEVEL = r0;
    }

    public static void setLogger(ILogger r0) {
        sLogger = r0;
    }

    public static void d(String r10, String r11) {
        if (LOG_LEVEL <= 3) goto L5;
        return;
    L5:
        ILogger r0 = sLogger;
        if (r0 == null) goto L8;
        r0.onDebug(TAG, prefix(r10) + r11);
        return;
    L8:
        prefix(r10);
    }

    public static void e(String r10, String r11) {
        if (LOG_LEVEL <= 6) goto L5;
        return;
    L5:
        ILogger r0 = sLogger;
        if (r0 == null) goto L8;
        r0.onError(TAG, prefix(r10) + r11);
        return;
    L8:
        prefix(r10);
    }

    public static void i(String r10, String r11) {
        if (LOG_LEVEL <= 4) goto L5;
        return;
    L5:
        ILogger r0 = sLogger;
        if (r0 == null) goto L8;
        r0.onInfo(TAG, prefix(r10) + r11);
        return;
    L8:
        prefix(r10);
    }

    public static void v(String r10, String r11) {
        if (LOG_LEVEL <= 2) goto L5;
        return;
    L5:
        ILogger r0 = sLogger;
        if (r0 == null) goto L8;
        r0.onVerbose(TAG, prefix(r10) + r11);
        return;
    L8:
        prefix(r10);
    }

    public static void w(String r10, String r11) {
        if (LOG_LEVEL <= 5) goto L5;
        return;
    L5:
        ILogger r0 = sLogger;
        if (r0 == null) goto L8;
        r0.onWarn(TAG, prefix(r10) + r11);
        return;
    L8:
        prefix(r10);
    }

    public static void logger(int r0, String r1, String r10) {
        switch(transNativeLogLevelToJava(r0)) {
            case 2: goto L9;
            case 3: goto L8;
            case 4: goto L7;
            case 5: goto L6;
            case 6: goto L5;
            case 7: goto L9;
            default: goto L15;
        };
    L5:
        e(r1, r10);
        return;
    L6:
        w(r1, r10);
        return;
    L7:
        i(r1, r10);
        return;
    L8:
        d(r1, r10);
        return;
    L9:
        v(r1, r10);
        return;
    }
}
