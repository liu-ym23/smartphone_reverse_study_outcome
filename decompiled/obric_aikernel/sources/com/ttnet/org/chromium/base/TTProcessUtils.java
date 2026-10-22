package com.ttnet.org.chromium.base;

import android.app.ActivityManager;
import android.app.Application;
import android.content.Context;
import android.os.Build;
import android.os.Process;
import android.text.TextUtils;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Method;
import java.util.Iterator;

/* JADX INFO: loaded from: classes2.dex */
public class TTProcessUtils {
    public static final String MESSAGE_PROCESS_SERVICE_SUFFIX = ":pushservice";
    public static final String MESSAGE_PROCESS_SUFFIX = ":push";
    private static volatile String sCurProcessName;

    public TTProcessUtils() {
    }

    public static String getCurProcessName(Context r10) {
        if (TextUtils.isEmpty(sCurProcessName) == false) goto L5;
        sCurProcessName = getCurrentProcessNameFromApplication();
        if (TextUtils.isEmpty(sCurProcessName) == false) goto L9;
        sCurProcessName = getCurrentProcessNameFromActivityThread();
        if (TextUtils.isEmpty(sCurProcessName) == false) goto L13;
        sCurProcessName = getCurProcessNameFromProc();
        if (TextUtils.isEmpty(sCurProcessName) == false) goto L17;
        sCurProcessName = getCurProcessNameFromActivityManager(r10);
        return sCurProcessName;
    L17:
        return sCurProcessName;
    L13:
        return sCurProcessName;
    L9:
        return sCurProcessName;
    L5:
        return sCurProcessName;
    }

    private static String getCurProcessNameFromActivityManager(Context r10) {
        String r11 = null;
        if (r10 != null) goto L18;
        return null;
    L18:
        int r12 = Process.myPid();     // Catch: Exception -> L15
        Iterator<ActivityManager.RunningAppProcessInfo> r13 = ((ActivityManager) r10.getSystemService("activity")).getRunningAppProcesses().iterator();     // Catch: Exception -> L15
    L6:
        if (r13.hasNext() == false) goto L17;
        ActivityManager.RunningAppProcessInfo r14 = r13.next();     // Catch: Exception -> L15
        if (r14.pid != r12) goto L6;
        if (Logger.debug() == false) goto L13;
        Logger.d("Process", "processName = " + r14.processName);     // Catch: Exception -> L15
    L13:
        r11 = r14.processName;     // Catch: Exception -> L15
    L17:
        return r11;
    L15:
        e = move-exception;
        e.printStackTrace();
        goto L17
    }

    private static String getCurProcessNameFromProc() {
        BufferedReader r10 = new BufferedReader(new InputStreamReader(new FileInputStream("/proc/" + Process.myPid() + "/cmdline"), "iso-8859-1"));     // Catch: Throwable -> L14
        StringBuilder r11 = new StringBuilder();     // Catch: Throwable -> L19
    L5:
        int r12 = r10.read();     // Catch: Throwable -> L19
        if (r12 <= 0) goto L9;
        r11.append((char) r12);     // Catch: Throwable -> L19
        goto L5
    L9:
        if (Logger.debug() == false) goto L11;
        Logger.d("Process", "get processName = " + r11.toString());     // Catch: Throwable -> L19
    L11:
        String r13 = r11.toString();     // Catch: Throwable -> L19
        r10.close();     // Catch: Exception -> L18
    L13:
        return r13;
    L15:
        if (r10 != null) goto L25;
    L17:
        return null;
    L25:
        r10.close();     // Catch: Exception -> L20
    L14:
        r10 = null;
        goto L15
    }

    private static String getCurrentProcessNameFromActivityThread() {
        Method r10 = Class.forName("android.app.ActivityThread", false, Application.class.getClassLoader()).getDeclaredMethod("currentProcessName", new Class[0]);     // Catch: Throwable -> L7
        r10.setAccessible(true);     // Catch: Throwable -> L7
        Object r11 = r10.invoke(null, new Object[0]);     // Catch: Throwable -> L7
        if ((r11 instanceof String) == false) goto L12;
        return (String) r11;
    L12:
        return null;
    L7:
        th = move-exception;
        th.printStackTrace();
        return null;
    }

    private static String getCurrentProcessNameFromApplication() {
        if (Build.VERSION.SDK_INT < 28) goto L12;
        return Application.getProcessName();
    L6:
        e = move-exception;
        e.printStackTrace();
        return null;
    L12:
        return null;
    }

    public static boolean isMainProcess(Context r10) {
        String r11 = getCurProcessName(r10);
        if (r11 != null) goto L5;
    L7:
        if (r11 != null) goto L9;
        return false;
    L9:
        if (r11.equals(r10.getPackageName()) == false) goto L13;
        return true;
    L13:
        return false;
    L5:
        if (r11.contains(":") == false) goto L7;
        return false;
    }

    public static boolean isMessageProcess(Context r10) {
        String r11 = getCurProcessName(r10);
        if (r11 != null) goto L5;
        return false;
    L5:
        if (r11.endsWith(MESSAGE_PROCESS_SUFFIX) == false) goto L7;
        return true;
    L7:
        if (r11.endsWith(MESSAGE_PROCESS_SERVICE_SUFFIX) == false) goto L13;
        return true;
    L13:
        return false;
    }
}
