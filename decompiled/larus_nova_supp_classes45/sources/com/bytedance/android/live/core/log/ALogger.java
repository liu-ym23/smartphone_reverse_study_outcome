package com.bytedance.android.live.core.log;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.bytedance.android.live.core.utils.v;
import com.ss.alog.middleware.ALogService;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public class ALogger {
    public static final int DEBUG = 3;
    public static final int ERROR = 6;
    public static final int INFO = 4;
    public static final int VERBOSE = 2;
    public static final int WARN = 5;

    private ALogger() {
    }

    private static boolean isLevelTooLow(int r2) {
        boolean r0 = ALoggerConfigHelper.a;
        if (v.a() == true) goto L5;
    L7:
        boolean r1 = ALoggerConfigHelper.a().getEnableRestrictLevel();
    L8:
        if (r1 == true) goto L11;
        return false;
    L11:
        if (r2 >= ALoggerConfigHelper.a().getRestrictLevel()) goto L14;
        return true;
    L14:
        return false;
    L5:
        if (ALoggerConfigHelper.a().getEnableTest() == true) goto L7;
        r1 = false;
        goto L8
    }

    public static boolean isLoggable(int r3) {
        boolean r0 = ALoggerConfigHelper.a;
        if (v.a() == false) goto L8;
        if (ALoggerConfigHelper.a().getEnableTest() == true) goto L8;
        boolean r1 = true;
    L11:
        if (r1 == true) goto L14;
        return false;
    L14:
        if (isLevelTooLow(r3) == false) goto L16;
        return false;
    L16:
        return true;
    L8:
        if (ALoggerConfigHelper.a == false) goto L10;
        r1 = false;
        goto L11
    L10:
        r1 = ALoggerConfigHelper.a().getEnable();
        goto L11
    }

    public static void d(String r1, c r2) {
        print(3, r1, r2);
    }

    public static void e(String r2, Throwable r3) {
        throwable(6, r2, null, r3);
    }

    public static void i(String r1, String r2) {
        print(4, r1, r2);
    }

    public static void v(String r1, c r2) {
        print(2, r1, r2);
    }

    public static void w(String r2, Throwable r3) {
        throwable(5, r2, null, r3);
    }

    public static void d(String r1, String r2) {
        print(3, r1, r2);
    }

    public static void e(String r1, String r2) {
        print(6, r1, r2);
    }

    public static void v(String r1, String r2) {
        print(2, r1, r2);
    }

    public static void w(String r1, String r2) {
        print(5, r1, r2);
    }

    public static void bundle(int r1, String r2, Bundle r3) {
        if (isLoggable(r1) == true) goto L5;
        return;
    L5:
        ALogService.bundleSafely(r1, r2, r3);
    }

    public static void e(String r1, String r2, Throwable r3) {
        throwable(6, r1, r2, r3);
    }

    public static void header(int r1, String r2, String r3) {
        if (isLoggable(r1) == true) goto L5;
        return;
    L5:
        ALogService.headerSafely(r1, r2, r3);
    }

    public static void intent(int r1, String r2, Intent r3) {
        if (isLoggable(r1) == true) goto L5;
        return;
    L5:
        ALogService.intentSafely(r1, r2, r3);
    }

    public static void json(int r1, String r2, String r3) {
        if (isLoggable(r1) == true) goto L5;
        return;
    L5:
        ALogService.jsonSafely(r1, r2, r3);
    }

    private static void print(int r1, String r2, c r3) {
        if (r3 != null) goto L4;
        return;
    L4:
        boolean r0 = ALoggerConfigHelper.a;
        if (v.a() == true) goto L7;
    L9:
        boolean r4 = ALoggerConfigHelper.a().getEnablePreCheck();
    L10:
        if (r4 == true) goto L12;
        print(r1, r2, r3.generate());
        return;
    L12:
        if (isLoggable(r1) == false) goto L16;
        print(r1, r2, r3.generate());
        return;
    L16:
        return;
    L7:
        if (ALoggerConfigHelper.a().getEnableTest() == true) goto L9;
        r4 = false;
        goto L10
    }

    public static void stacktrace(int r1, String r2, StackTraceElement[] r3) {
        if (isLoggable(r1) == true) goto L5;
        return;
    L5:
        ALogService.statcktraceSafely(r1, r2, r3);
    }

    public static void thread(int r1, String r2, Thread r3) {
        if (isLoggable(r1) == true) goto L5;
        return;
    L5:
        ALogService.threadSafely(r1, r2, r3);
    }

    public static void w(String r1, String r2, Throwable r3) {
        throwable(5, r1, r2, r3);
    }

    private static void print(int r1, String r2, String r3) {
        if (isLoggable(r1) == true) goto L5;
        return;
    L5:
        int r0 = a.a;
        v.b();
        if (r1 != 2) goto L8;
        ALogService.vSafely(r2, r3);
        return;
    L8:
        if (r1 != 3) goto L10;
        ALogService.dSafely(r2, r3);
        return;
    L10:
        if (r1 != 4) goto L12;
        ALogService.iSafely(r2, r3);
        return;
    L12:
        if (r1 != 5) goto L14;
        ALogService.wSafely(r2, r3);
        return;
    L14:
        if (r1 != 6) goto L26;
        ALogService.eSafely(r2, r3);
        return;
    }

    private static void print(int r2, String r3, String r4, Throwable r5) {
        if (isLoggable(r2) == true) goto L5;
        return;
    L5:
        boolean r0 = TextUtils.isEmpty(r4);
        if (r2 != 5) goto L8;
        if (r0 == false) goto L15;
        ALogService.wSafely(r3, r5);
        return;
    L15:
        ALogService.wSafely(r3, r4, r5);
        return;
    L8:
        if (r2 != 6) goto L20;
        if (r0 == false) goto L12;
        ALogService.eSafely(r3, r5);
        return;
    L12:
        ALogService.eSafely(r3, r4, r5);
        return;
    }

    public static void throwable(int r0, String r1, String r2, Throwable r3) {
        print(r0, r1, r2, r3);
    }
}
