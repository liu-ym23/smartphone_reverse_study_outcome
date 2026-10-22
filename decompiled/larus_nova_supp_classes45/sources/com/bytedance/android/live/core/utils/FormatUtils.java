package com.bytedance.android.live.core.utils;

import java.text.SimpleDateFormat;
import java.util.Locale;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public class FormatUtils {
    private static SimpleDateFormat format;
    private static SimpleDateFormat format1;
    private static SimpleDateFormat format2;

    static {
        format = new SimpleDateFormat("HH:mm:ss");
        format1 = new SimpleDateFormat("HH:mm:ss SSS");
        format2 = new SimpleDateFormat("HH:mm:ss.SSS");
    }

    private FormatUtils() {
    }

    public static String format(String r1, Object... r2) {
        return String.format(Locale.US, r1, r2);
    L4:
        return "";
    }
}
