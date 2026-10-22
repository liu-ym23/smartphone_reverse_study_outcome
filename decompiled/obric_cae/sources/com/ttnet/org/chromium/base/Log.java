package com.ttnet.org.chromium.base;

import com.obric.cae.smartBluetooth.deviceIdentification.bdim.BdimCategoryConstants;
import com.ttnet.org.chromium.base.annotations.RemovableInRelease;
import java.util.Locale;

/* JADX INFO: loaded from: classes2.dex */
public class Log {
    public static final int ASSERT = 7;
    public static final int DEBUG = 3;
    public static final int ERROR = 6;
    public static final int INFO = 4;
    public static final int VERBOSE = 2;
    public static final int WARN = 5;
    private static final String sDeprecatedTagPrefix = "cr.";
    private static final String sTagPrefix = "cr_";

    private Log() {
    }

    @VisibleForTesting
    @RemovableInRelease
    public static void d(String r8, String r10) {
        debug(r8, r10, new Object[0]);
    }

    private static void debug(String r8, String r10, Object... r11) {
        String r12 = formatLogWithStack(r10, r11);
        Throwable r13 = getThrowableToLog(r11);
        String r14 = normalizeTag(r8);
        if (r13 == null) goto L5;
        android.util.Log.d(r14, r12, r13);
        return;
    L5:
        android.util.Log.d(r14, r12);
    }

    @VisibleForTesting
    public static void e(String r8, String r10, Object... r11) {
        String r12 = formatLog(r10, r11);
        Throwable r13 = getThrowableToLog(r11);
        String r14 = normalizeTag(r8);
        if (r13 == null) goto L5;
        android.util.Log.e(r14, r12, r13);
        return;
    L5:
        android.util.Log.e(r14, r12);
    }

    private static String formatLog(String r8, Object... r10) {
        if (r10 != null) goto L4;
        return r8;
    L4:
        if (r10.length != 0) goto L6;
        return r8;
    L6:
        return String.format(Locale.US, r8, r10);
    }

    private static String formatLogWithStack(String r8, Object... r10) {
        return "[" + getCallOrigin() + "] " + formatLog(r8, r10);
    }

    private static String getCallOrigin() {
        StackTraceElement[] r8 = Thread.currentThread().getStackTrace();
        String r10 = Log.class.getName();
        int r11 = 0;
    L4:
        if (r11 >= r8.length) goto L10;
        if (r8[r11].getClassName().equals(r10) == true) goto L7;
        r11 = r11 + 1;
        goto L4
    L7:
        r11 = r11 + 4;
    L10:
        return r8[r11].getFileName() + BdimCategoryConstants.SEPARATOR_COLON + r8[r11].getLineNumber();
    }

    public static String getStackTraceString(Throwable r8) {
        return android.util.Log.getStackTraceString(r8);
    }

    private static Throwable getThrowableToLog(Object[] r8) {
        if (r8 != null) goto L5;
    L12:
        return null;
    L5:
        if (r8.length == 0) goto L12;
        Object r10 = r8[r8.length - 1];
        if ((r10 instanceof Throwable) == true) goto L11;
        return null;
    L11:
        return (Throwable) r10;
    }

    @VisibleForTesting
    public static void i(String r8, String r10, Object... r11) {
        String r12 = formatLog(r10, r11);
        Throwable r13 = getThrowableToLog(r11);
        String r14 = normalizeTag(r8);
        if (r13 == null) goto L5;
        android.util.Log.i(r14, r12, r13);
        return;
    L5:
        android.util.Log.i(r14, r12);
    }

    public static boolean isLoggable(String r8, int r10) {
        return android.util.Log.isLoggable(r8, r10);
    }

    public static String normalizeTag(String r8) {
        if (r8.startsWith(sTagPrefix) == false) goto L6;
        return r8;
    L6:
        if (r8.startsWith(sDeprecatedTagPrefix) == false) goto L8;
        int r10 = 3;
    L10:
        return sTagPrefix + r8.substring(r10, r8.length());
    L8:
        r10 = 0;
        goto L10
    }

    @VisibleForTesting
    @RemovableInRelease
    public static void v(String r8, String r10) {
        verbose(r8, r10, new Object[0]);
    }

    private static void verbose(String r8, String r10, Object... r11) {
        String r12 = formatLogWithStack(r10, r11);
        Throwable r13 = getThrowableToLog(r11);
        String r14 = normalizeTag(r8);
        if (r13 == null) goto L5;
        android.util.Log.v(r14, r12, r13);
        return;
    L5:
        android.util.Log.v(r14, r12);
    }

    @VisibleForTesting
    public static void w(String r8, String r10, Object... r11) {
        String r12 = formatLog(r10, r11);
        Throwable r13 = getThrowableToLog(r11);
        String r14 = normalizeTag(r8);
        if (r13 == null) goto L5;
        android.util.Log.w(r14, r12, r13);
        return;
    L5:
        android.util.Log.w(r14, r12);
    }

    @VisibleForTesting
    public static void wtf(String r8, String r10, Object... r11) {
        String r12 = formatLog(r10, r11);
        Throwable r13 = getThrowableToLog(r11);
        String r14 = normalizeTag(r8);
        if (r13 == null) goto L5;
        android.util.Log.wtf(r14, r12, r13);
        return;
    L5:
        android.util.Log.wtf(r14, r12);
    }

    @VisibleForTesting
    @RemovableInRelease
    public static void d(String r8, String r10, Object r11) {
        debug(r8, r10, new Object[]{r11});
    }

    @VisibleForTesting
    @RemovableInRelease
    public static void v(String r8, String r10, Object r11) {
        verbose(r8, r10, new Object[]{r11});
    }

    @VisibleForTesting
    @RemovableInRelease
    public static void d(String r8, String r10, Object r11, Object r12) {
        debug(r8, r10, new Object[]{r11, r12});
    }

    @VisibleForTesting
    @RemovableInRelease
    public static void v(String r8, String r10, Object r11, Object r12) {
        verbose(r8, r10, new Object[]{r11, r12});
    }

    @VisibleForTesting
    @RemovableInRelease
    public static void d(String r8, String r10, Object r11, Object r12, Object r13) {
        debug(r8, r10, new Object[]{r11, r12, r13});
    }

    @VisibleForTesting
    @RemovableInRelease
    public static void v(String r8, String r10, Object r11, Object r12, Object r13) {
        verbose(r8, r10, new Object[]{r11, r12, r13});
    }

    @VisibleForTesting
    @RemovableInRelease
    public static void d(String r8, String r10, Object r11, Object r12, Object r13, Object r14) {
        debug(r8, r10, new Object[]{r11, r12, r13, r14});
    }

    @VisibleForTesting
    @RemovableInRelease
    public static void v(String r8, String r10, Object r11, Object r12, Object r13, Object r14) {
        verbose(r8, r10, new Object[]{r11, r12, r13, r14});
    }

    @VisibleForTesting
    @RemovableInRelease
    public static void d(String r8, String r10, Object r11, Object r12, Object r13, Object r14, Object r15) {
        debug(r8, r10, new Object[]{r11, r12, r13, r14, r15});
    }

    @VisibleForTesting
    @RemovableInRelease
    public static void v(String r8, String r10, Object r11, Object r12, Object r13, Object r14, Object r15) {
        verbose(r8, r10, new Object[]{r11, r12, r13, r14, r15});
    }

    @VisibleForTesting
    @RemovableInRelease
    public static void d(String r8, String r10, Object r11, Object r12, Object r13, Object r14, Object r15, Object r16) {
        debug(r8, r10, new Object[]{r11, r12, r13, r14, r15, r16});
    }

    @VisibleForTesting
    @RemovableInRelease
    public static void v(String r8, String r10, Object r11, Object r12, Object r13, Object r14, Object r15, Object r16) {
        verbose(r8, r10, new Object[]{r11, r12, r13, r14, r15, r16});
    }

    @VisibleForTesting
    @RemovableInRelease
    public static void d(String r8, String r10, Object r11, Object r12, Object r13, Object r14, Object r15, Object r16, Object r17) {
        debug(r8, r10, new Object[]{r11, r12, r13, r14, r15, r16, r17});
    }

    @VisibleForTesting
    @RemovableInRelease
    public static void v(String r8, String r10, Object r11, Object r12, Object r13, Object r14, Object r15, Object r16, Object r17) {
        verbose(r8, r10, new Object[]{r11, r12, r13, r14, r15, r16, r17});
    }
}
