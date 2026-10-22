package com.ttnet.org.chromium.base;

import android.app.ActivityManager;
import android.app.Application;
import android.content.Context;
import android.os.Build;
import android.os.Process;
import android.text.TextUtils;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Method;
import java.util.Iterator;
import org.apache.logging.log4j.message.ParameterizedMessage;

/* JADX INFO: loaded from: classes6.dex */
public class TTProcessUtils {
    public static final String MESSAGE_PROCESS_SERVICE_SUFFIX = ":pushservice";
    public static final String MESSAGE_PROCESS_SUFFIX = ":push";
    private static volatile String sCurProcessName;

    public TTProcessUtils() {
    }

    public static String getCurProcessName(Context r2) {
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin");
        if (TextUtils.isEmpty(sCurProcessName) == false) goto L5;
        sCurProcessName = getCurrentProcessNameFromApplication();
        if (TextUtils.isEmpty(sCurProcessName) == false) goto L9;
        sCurProcessName = getCurrentProcessNameFromActivityThread();
        if (TextUtils.isEmpty(sCurProcessName) == false) goto L13;
        sCurProcessName = getCurProcessNameFromProc();
        if (TextUtils.isEmpty(sCurProcessName) == false) goto L17;
        sCurProcessName = getCurProcessNameFromActivityManager(r3);
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

    private static String getCurProcessNameFromActivityManager(Context r7) {
        Context r8 = (Context) ZeusTransformUtils.wrapperContextForParams(r7, Context.class, "com.obric.memorydata.plugin");
        String r0 = null;
        if (r8 != null) goto L18;
        return null;
    L18:
        int r2 = Process.myPid();     // Catch: Exception -> L15
        Iterator<ActivityManager.RunningAppProcessInfo> r9 = ((ActivityManager) ZeusTransformUtils.preCheckCast(r8.getSystemService("activity"), ActivityManager.class, "com.obric.memorydata.plugin")).getRunningAppProcesses().iterator();     // Catch: Exception -> L15
    L6:
        if (r9.hasNext() == false) goto L17;
        ActivityManager.RunningAppProcessInfo r3 = (ActivityManager.RunningAppProcessInfo) ZeusTransformUtils.preCheckCast(r9.next(), ActivityManager.RunningAppProcessInfo.class, "com.obric.memorydata.plugin");     // Catch: Exception -> L15
        if (r3.pid != r2) goto L6;
        if (Logger.debug() == false) goto L13;
        Logger.d("Process", "processName = " + r3.processName);     // Catch: Exception -> L15
    L13:
        r0 = r3.processName;     // Catch: Exception -> L15
    L17:
        return r0;
    L15:
        e = move-exception;
        e.printStackTrace();
        goto L17
    }

    private static String getCurProcessNameFromProc() {
        BufferedReader r1 = new BufferedReader(new InputStreamReader(new FileInputStream("/proc/" + Process.myPid() + "/cmdline"), "iso-8859-1"));     // Catch: Throwable -> L14
        StringBuilder r2 = new StringBuilder();     // Catch: Throwable -> L19
    L5:
        int r3 = r1.read();     // Catch: Throwable -> L19
        if (r3 <= 0) goto L9;
        r2.append((char) r3);     // Catch: Throwable -> L19
        goto L5
    L9:
        if (Logger.debug() == false) goto L11;
        Logger.d("Process", "get processName = " + r2.toString());     // Catch: Throwable -> L19
    L11:
        String r0 = r2.toString();     // Catch: Throwable -> L19
        r1.close();     // Catch: Exception -> L18
    L13:
        return r0;
    L15:
        if (r1 != null) goto L21;
    L17:
        return null;
    L21:
        r1.close();     // Catch: Exception -> L20
    L14:
        r1 = null;
        goto L15
    }

    private static String getCurrentProcessNameFromActivityThread() {
        Method r1 = Class.forName("android.app.ActivityThread", false, Application.class.getClassLoader()).getDeclaredMethod("currentProcessName", new Class[0]);     // Catch: Throwable -> L7
        r1.setAccessible(true);     // Catch: Throwable -> L7
        Object r2 = r1.invoke(null, new Object[0]);     // Catch: Throwable -> L7
        if (ZeusTransformUtils.instanceOf(r2, String.class) == false) goto L12;
        return (String) ZeusTransformUtils.preCheckCast(r2, String.class, "com.obric.memorydata.plugin");
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

    public static boolean isMainProcess(Context r3) {
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        String r0 = getCurProcessName(r4);
        if (r0 != null) goto L5;
    L7:
        if (r0 != null) goto L9;
        return false;
    L9:
        if (r0.equals(r4.getPackageName()) == false) goto L13;
        return true;
    L13:
        return false;
    L5:
        if (r0.contains(ParameterizedMessage.ERROR_MSG_SEPARATOR) == false) goto L7;
        return false;
    }

    public static boolean isMessageProcess(Context r2) {
        String r3 = getCurProcessName((Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin"));
        if (r3 != null) goto L5;
        return false;
    L5:
        if (r3.endsWith(MESSAGE_PROCESS_SUFFIX) == false) goto L7;
        return true;
    L7:
        if (r3.endsWith(MESSAGE_PROCESS_SERVICE_SUFFIX) == false) goto L13;
        return true;
    L13:
        return false;
    }
}
