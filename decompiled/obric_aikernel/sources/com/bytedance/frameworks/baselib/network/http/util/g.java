package com.bytedance.frameworks.baselib.network.http.util;

import android.app.ActivityManager;
import android.app.Application;
import android.content.Context;
import android.os.Build;
import android.os.Process;
import com.bytedance.common.utility.Logger;
import com.ttnet.org.chromium.base.TTProcessUtils;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes.dex */
public class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static AtomicInteger f1882a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static volatile String f1883b;

    static {
        f1882a = new AtomicInteger(0);
        f1883b = null;
    }

    public static String a(Context r10) {
        if (com.bytedance.common.utility.g.b(f1883b) == false) goto L5;
        f1883b = e();
        if (com.bytedance.common.utility.g.b(f1883b) == false) goto L9;
        f1883b = d();
        if (com.bytedance.common.utility.g.b(f1883b) == false) goto L13;
        f1883b = c();
        if (com.bytedance.common.utility.g.b(f1883b) == false) goto L17;
        f1883b = b(r10);
        return f1883b;
    L17:
        return f1883b;
    L13:
        return f1883b;
    L9:
        return f1883b;
    L5:
        return f1883b;
    }

    private static String b(Context r10) {
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

    private static String c() {
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

    private static String d() {
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

    private static String e() {
        if (Build.VERSION.SDK_INT < 28) goto L12;
        return Application.getProcessName();
    L6:
        e = move-exception;
        e.printStackTrace();
        return null;
    L12:
        return null;
    }

    public static int f() {
        return f1882a.get();
    }

    public static boolean g(Context r10) {
        String r11 = a(r10);
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

    public static boolean h(Context r10) {
        if (Logger.debug() == false) goto L5;
        Logger.d("ProcessUtils", "TTNet ProcessFlag: " + f1882a);
    L5:
        int r11 = f();
        if (r11 != 1) goto L8;
        return true;
    L8:
        if (r11 != 2) goto L10;
        return false;
    L10:
        return g(r10);
    }

    public static boolean i(Context r10) {
        String r11 = a(r10);
        if (r11 != null) goto L5;
        return false;
    L5:
        if (r11.endsWith(TTProcessUtils.MESSAGE_PROCESS_SUFFIX) == false) goto L7;
        return true;
    L7:
        if (r11.endsWith(TTProcessUtils.MESSAGE_PROCESS_SERVICE_SUFFIX) == false) goto L13;
        return true;
    L13:
        return false;
    }

    public static void j(int r10) {
        f1882a.set(r10);
    }
}
