package com.ss.android.common.b;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Build;
import android.os.Process;
import com.bytedance.common.utility.Logger;
import com.bytedance.common.utility.h;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;

/* JADX INFO: loaded from: classes6.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static String f15118a = ":push";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static boolean f15119b = false;
    public static boolean c = false;
    private static String d = null;
    private static String e = null;
    private static boolean f = true;

    static {
    }

    public static String a() {
        return a("ro.build.version.emui");
    }

    private static String a(String r8) {
        if (h.a(d) == false) goto L5;
        BufferedReader r2 = null;
        String r3 = null;
        BufferedReader r4 = new BufferedReader(new InputStreamReader(Runtime.getRuntime().exec("getprop " + r8).getInputStream()), 1024);     // Catch: Throwable -> L16
        r3 = r4.readLine();     // Catch: Throwable -> L14
        r4.close();     // Catch: Throwable -> L14
        d = r3;     // Catch: Throwable -> L14
        r4.close();     // Catch: IOException -> L11
    L13:
        return r3;
    L11:
        e = move-exception;
        Logger.e("ToolUtils", "Exception while closing InputStream", e);
    L14:
        th = move-exception;
        String r5 = r3;
        r2 = r4;
        Throwable r6 = th;
    L36:
        Logger.e("ToolUtils", "Unable to read sysprop " + r8, r6);     // Catch: Throwable -> L25
        if (r2 != null) goto L38;
    L24:
        return r5;
    L38:
        r2.close();     // Catch: IOException -> L22
    L22:
        e = move-exception;
        Logger.e("ToolUtils", "Exception while closing InputStream", e);
    L25:
        th = move-exception;
        if (r2 != null) goto L40;
    L31:
        throw th;
    L40:
        r2.close();     // Catch: IOException -> L29
    L29:
        e = move-exception;
        Logger.e("ToolUtils", "Exception while closing InputStream", e);
    L16:
        th = move-exception;
        r6 = th;
        r5 = null;
        goto L36
    L5:
        return d;
    }

    public static boolean a(Context r2) {
        String r3 = b((Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin"));
        if (r3 != null) goto L5;
        return false;
    L5:
        if (r3.endsWith(f15118a) == false) goto L10;
        return true;
    L10:
        return false;
    }

    public static String b(Context r4) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.memorydata.plugin");
        String r0 = e;
        if (h.a(r0) == true) goto L19;
        return r0;
    L19:
        int r1 = Process.myPid();     // Catch: Exception -> L15
        Iterator<ActivityManager.RunningAppProcessInfo> r6 = ((ActivityManager) ZeusTransformUtils.preCheckCast(r5.getSystemService("activity"), ActivityManager.class, "com.obric.memorydata.plugin")).getRunningAppProcesses().iterator();     // Catch: Exception -> L15
    L7:
        if (r6.hasNext() == false) goto L17;
        ActivityManager.RunningAppProcessInfo r2 = (ActivityManager.RunningAppProcessInfo) ZeusTransformUtils.preCheckCast(r6.next(), ActivityManager.RunningAppProcessInfo.class, "com.obric.memorydata.plugin");     // Catch: Exception -> L15
        if (r2.pid != r1) goto L7;
        if (Logger.debug() == false) goto L13;
        Logger.d("Process", "processName = " + r2.processName);     // Catch: Exception -> L15
    L13:
        String r7 = r2.processName;     // Catch: Exception -> L15
        e = r7;     // Catch: Exception -> L15
        return r7;
    L17:
        String r8 = d();
        e = r8;
        return r8;
    L15:
        e = move-exception;
        e.printStackTrace();
        goto L17
    }

    public static boolean b() {
        if (c == true) goto L11;
        if (ZeusTransformUtils.forName("miui.os.Build", "com.obric.memorydata.plugin") == null) goto L9;
        f15119b = true;     // Catch: Exception -> L12
        c = true;     // Catch: Exception -> L12
        return true;
    L9:
        c = true;
    L11:
        return f15119b;
    }

    public static boolean c() {
        if (h.a(Build.DISPLAY) == true) goto L7;
        if (Build.DISPLAY.indexOf("Flyme") < 0) goto L7;
        return true;
    L7:
        if (h.a(Build.USER) == false) goto L9;
        return false;
    L9:
        if (Build.USER.equals("flyme") == false) goto L15;
        return true;
    L15:
        return false;
    }

    private static String d() {
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
}
