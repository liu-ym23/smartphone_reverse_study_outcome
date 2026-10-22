package com.google.gson.internal;

import ai.j0;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Locale;

/* JADX INFO: loaded from: classes2.dex */
public class PreJava9DateFormatProvider {
    private PreJava9DateFormatProvider() {
    }

    private static String getDatePartOfDateTimePattern(int r5) {
        if (r5 != 0) goto L4;
        return "EEEE, MMMM d, yyyy";
    L4:
        if (r5 != 1) goto L6;
        return "MMMM d, yyyy";
    L6:
        if (r5 != 2) goto L8;
        return "MMM d, yyyy";
    L8:
        if (r5 != 3) goto L12;
        return "M/d/yy";
    L12:
        throw new IllegalArgumentException(j0.g(r5, "Unknown DateFormat style: "));
    }

    private static String getTimePartOfDateTimePattern(int r5) {
        if (r5 != 0) goto L4;
        return "h:mm:ss a z";
    L4:
        if (r5 != 1) goto L6;
        return "h:mm:ss a z";
    L6:
        if (r5 != 2) goto L8;
        return "h:mm:ss a";
    L8:
        if (r5 != 3) goto L12;
        return "h:mm a";
    L12:
        throw new IllegalArgumentException(j0.g(r5, "Unknown DateFormat style: "));
    }

    public static DateFormat getUsDateTimeFormat(int r5, int r10) {
        return new SimpleDateFormat(getDatePartOfDateTimePattern(r5) + " " + getTimePartOfDateTimePattern(r10), Locale.US);
    }
}
