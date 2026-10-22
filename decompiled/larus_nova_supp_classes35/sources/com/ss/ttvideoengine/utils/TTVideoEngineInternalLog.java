package com.ss.ttvideoengine.utils;

import android.text.TextUtils;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public class TTVideoEngineInternalLog {
    public static final String FORMAT = "<%s>%s";
    public static final int LOG_DEBUG = 1;
    public static final int LOG_ERROR = 6;
    public static final int LOG_INFO = 2;
    public static final int LOG_KILL = 4;
    public static final int LOG_TRACK = 3;
    public static final int LOG_VERBOSE = 0;
    public static final int LOG_WARN = 5;
    public static int LogNotifyLevel = 116;
    public static int LogTurnOn = 112;
    private static final String TAG = "TTVideoEngineLog";
    public static TTVideoEngineLogListener mListener;
    private static boolean sEnablePredicateLoglevelTurn;

    public TTVideoEngineInternalLog() {
    }

    public static boolean d() {
        return logLevelTurnOn(1);
    }

    public static boolean e() {
        return logLevelTurnOn(6);
    }

    public static boolean i() {
        return logLevelTurnOn(2);
    }

    public static boolean k() {
        return logLevelTurnOn(4);
    }

    public static boolean t() {
        return logLevelTurnOn(3);
    }

    public static boolean w() {
        return logLevelTurnOn(5);
    }

    public static void d(Throwable r2) {
        if (((LogTurnOn >> 1) & 1) != 1) goto L6;
        r2.printStackTrace();
        return;
    }

    public static void enablePredicateLoglevelTurn(boolean r0) {
        sEnablePredicateLoglevelTurn = r0;
    }

    public static boolean isPredicateLoglevelTurnOn(int r1) {
        if (sEnablePredicateLoglevelTurn == true) goto L5;
    L8:
        return true;
    L5:
        if (logLevelTurnOn(r1) == true) goto L8;
        return false;
    }

    private static boolean logLevelTurnOn(int r2) {
        if (((LogTurnOn >> r2) & 1) != 1) goto L5;
        return true;
    L5:
        if (((LogNotifyLevel >> r2) & 1) == 1) goto L10;
        return false;
    L10:
        return true;
    }

    public static void setListener(TTVideoEngineLogListener r0) {
        mListener = r0;
    }

    public static void _notifyListener(String r3, String r4) {
        if (mListener != null) goto L5;
        return;
    L5:
        if (TextUtils.isEmpty(r4) == true) goto L13;
        TTVideoEngineLogListener r0 = mListener;
        if (TextUtils.isEmpty(r3) == true) goto L10;
        r4 = "TTVideoEngine: tag = " + r3 + ";  " + r4;
    L10:
        r0.consoleLog(r4);
        return;
    }

    public static void d(String r3, String r4) {
        if (((LogNotifyLevel >> 1) & 1) != 1) goto L6;
        _notifyListener(r3, r4);
    L6:
        if (((LogTurnOn >> 1) & 1) != 1) goto L9;
        String.format(FORMAT, new Object[]{r3, r4});
        return;
    }

    public static void e(String r3, String r4) {
        if (((LogNotifyLevel >> 6) & 1) != 1) goto L6;
        _notifyListener(r3, r4);
    L6:
        if (((LogTurnOn >> 6) & 1) != 1) goto L9;
        String.format(FORMAT, new Object[]{r3, r4});
        return;
    }

    public static void i(String r3, String r4) {
        if (((LogNotifyLevel >> 2) & 1) != 1) goto L6;
        _notifyListener(r3, r4);
    L6:
        if (((LogTurnOn >> 2) & 1) != 1) goto L9;
        String.format(FORMAT, new Object[]{r3, r4});
        return;
    }

    public static void k(String r3, String r4) {
        if (((LogNotifyLevel >> 4) & 1) != 1) goto L6;
        _notifyListener(r3, r4);
    L6:
        if (((LogTurnOn >> 4) & 1) != 1) goto L9;
        String.format(FORMAT, new Object[]{r3, r4});
        return;
    }

    public static void setLogNotifyLevel(int r2, int r3) {
        int r0 = (~(1 << r2)) & LogNotifyLevel;
        LogNotifyLevel = (r3 << r2) | r0;
    }

    public static void t(String r3, String r4) {
        if (((LogNotifyLevel >> 3) & 1) != 1) goto L6;
        _notifyListener(r3, r4);
    L6:
        if (((LogTurnOn >> 3) & 1) != 1) goto L9;
        String.format(FORMAT, new Object[]{r3, r4});
        return;
    }

    public static void turnOn(int r3, int r4) {
        int r1 = ((~(1 << r3)) & LogTurnOn) | (r4 << r3);
        LogTurnOn = r1;
        if (r3 != 1) goto L7;
        if (r4 != 1) goto L8;
        LogTurnOn = (r1 & (-5)) | (r4 << 2);
        return;
    L8:
        return;
    }

    public static void w(String r3, String r4) {
        if (((LogNotifyLevel >> 5) & 1) != 1) goto L6;
        _notifyListener(r3, r4);
    L6:
        if (((LogTurnOn >> 5) & 1) != 1) goto L9;
        String.format(FORMAT, new Object[]{r3, r4});
        return;
    }
}
