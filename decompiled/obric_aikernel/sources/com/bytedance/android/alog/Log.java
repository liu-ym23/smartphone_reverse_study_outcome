package com.bytedance.android.alog;

import com.ss.android.agilelogger.ALog;
import java.io.File;
import java.util.HashMap;

/* JADX INFO: loaded from: classes.dex */
@Deprecated
public class Log {
    private static Alog instance;

    static {
    }

    public Log() {
    }

    public static void asyncFlush() {
        Alog r10 = instance;
        if (r10 == null) goto L6;
        r10.asyncFlush();
        return;
    }

    public static void close() {
        Alog.nativeSetDefaultInstance(0);
        instance.close();
        instance = null;
    }

    @Deprecated
    public static void d(String r10, String r11) {
        ALog.d(r10, r11);
    }

    @Deprecated
    public static void e(String r10, String r11) {
        ALog.e(r10, r11);
    }

    @Deprecated
    public static void f(String r10, String r11) {
        ALog.e(r10, r11);
    }

    public static Alog getInstance() {
        return instance;
    }

    public static HashMap<String, String> getLastFetchErrorInfo() {
        Alog r10 = instance;
        if (r10 != null) goto L5;
        HashMap<String, String> r11 = new HashMap();
        r11.put("reason", "Log.instance does not exist");
        return r11;
    L5:
        return r10.getLastFetchErrorInfo();
    }

    public static long getLegacyFlushFuncAddr() {
        Alog r10 = instance;
        if (r10 != null) goto L5;
        return 0;
    L5:
        return r10.getLegacyFlushFuncAddr();
    }

    public static long getLegacyGetLogFileDirFuncAddr() {
        Alog r10 = instance;
        if (r10 != null) goto L5;
        return 0;
    L5:
        return r10.getLegacyGetLogFileDirFuncAddr();
    }

    public static long getLegacyWriteFuncAddr() {
        Alog r10 = instance;
        if (r10 != null) goto L5;
        return 0;
    L5:
        return r10.getLegacyWriteFuncAddr();
    }

    public static File[] getLogs(long r10, long r11) {
        Alog r12 = instance;
        if (r12 == null) goto L7;
        return r12.getLogs(r10, r11);
    L7:
        return new File[0];
    }

    public static File[] getLogs(String r10, String r11, long r12, long r13) {
        Alog r14 = instance;
        if (r14 == null) goto L7;
        return r14.getLogs(r10, r11, r12, r13);
    L7:
        return new File[0];
    }

    public static long getNativeWriteFuncAddr() {
        Alog r10 = instance;
        if (r10 != null) goto L5;
        return 0;
    L5:
        return r10.getNativeWriteFuncAddr();
    }

    public static String getStatus() {
        Alog r10 = instance;
        if (r10 != null) goto L5;
        return "default log instance is null";
    L5:
        return r10.getStatus();
    }

    @Deprecated
    public static void i(String r10, String r11) {
        ALog.i(r10, r11);
    }

    @Deprecated
    public static void innerDebug(String r10, String r11) {
        write(1, r10, r11);
    }

    @Deprecated
    public static void innerError(String r10, String r11) {
        write(4, r10, r11);
    }

    @Deprecated
    public static void innerFatal(String r10, String r11) {
        write(5, r10, r11);
    }

    @Deprecated
    public static void innerInfo(String r10, String r11) {
        write(2, r10, r11);
    }

    @Deprecated
    public static void innerVerbose(String r10, String r11) {
        write(0, r10, r11);
    }

    @Deprecated
    public static void innerWarn(String r10, String r11) {
        write(3, r10, r11);
    }

    @Deprecated
    public static void innerWrite(int r10, String r11, String r12) {
        Alog r13 = instance;
        if (r13 == null) goto L6;
        r13.write(r10, r11, r12);
        return;
    }

    @Deprecated
    public static void innerWriteAsyncMsg(int r10, String r11, String r12, long r13, long r14) {
        Alog r15 = instance;
        if (r15 == null) goto L6;
        r15.writeAsyncMsg(r10, r11, r12, r13, r14);
        return;
    }

    public static void setInstance(Alog r10) {
        instance = r10;
        if (r10 != null) goto L5;
        long r11 = 0;
    L6:
        Alog.nativeSetDefaultInstance(r11);
        return;
    L5:
        r11 = r10.getNativeRef();
        goto L6
    }

    public static void setLevel(int r10) {
        Alog r11 = instance;
        if (r11 == null) goto L6;
        r11.setLevel(r10);
        return;
    }

    public static void setSyslog(boolean r10) {
        Alog r11 = instance;
        if (r11 == null) goto L6;
        r11.setSyslog(r10);
        return;
    }

    public static void syncFlush() {
        Alog r10 = instance;
        if (r10 == null) goto L6;
        r10.syncFlush();
        return;
    }

    public static void timedSyncFlush(int r10) {
        Alog r11 = instance;
        if (r11 == null) goto L6;
        r11.timedSyncFlush(r10);
        return;
    }

    @Deprecated
    public static void v(String r10, String r11) {
        ALog.v(r10, r11);
    }

    @Deprecated
    public static void w(String r10, String r11) {
        ALog.w(r10, r11);
    }

    @Deprecated
    public static void write(int r10, String r11, String r12) {
        Alog r13 = instance;
        if (r13 == null) goto L6;
        r13.write(r10, r11, r12);
        return;
    }

    @Deprecated
    public static void writeAsyncMsg(int r10, String r11, String r12, long r13, long r14) {
        Alog r15 = instance;
        if (r15 == null) goto L6;
        r15.writeAsyncMsg(r10, r11, r12, r13, r14);
        return;
    }
}
