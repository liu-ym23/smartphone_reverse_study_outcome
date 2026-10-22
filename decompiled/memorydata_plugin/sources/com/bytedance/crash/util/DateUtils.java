package com.bytedance.crash.util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/* JADX INFO: loaded from: classes2.dex */
public class DateUtils {
    public static final int DAY = 86400000;
    private static DateFormat sDateFormat;
    private static DateFormat sDateFormatMs;
    private static DateFormat sFileDateFormat;
    private static DateFormat sFileDateFormatMs;

    public DateUtils() {
    }

    public static String formatDate(long r2) {
        return getDateInstance().format(new Date(r2));
    }

    public static String formatDateMs(long r2) {
        return getDateMsInstance().format(new Date(r2));
    }

    public static DateFormat getDateInstance() {
        if (sDateFormat != null) goto L6;
        sDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault());
    L6:
        return sDateFormat;
    }

    public static DateFormat getDateMsInstance() {
        if (sDateFormatMs != null) goto L6;
        sDateFormatMs = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS", Locale.getDefault());
    L6:
        return sDateFormatMs;
    }

    public static DateFormat getFileDateInstance() {
        if (sFileDateFormat != null) goto L6;
        sFileDateFormat = new SimpleDateFormat("yyyy-MM-dd@HH-mm-ss", Locale.getDefault());
    L6:
        return sFileDateFormat;
    }

    public static DateFormat getFileDateInstanceMs() {
        if (sFileDateFormatMs != null) goto L6;
        sFileDateFormatMs = new SimpleDateFormat("yyyy-MM-dd@HH-mm-ss.SSS", Locale.getDefault());
    L6:
        return sFileDateFormatMs;
    }

    public static long parseDateMs(String r2) {
        Date r3 = getDateMsInstance().parse(r2);
        if (r3 != null) goto L7;
        return 0;
    L7:
        return r3.getTime();
    }
}
