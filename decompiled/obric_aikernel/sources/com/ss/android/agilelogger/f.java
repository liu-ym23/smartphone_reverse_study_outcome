package com.ss.android.agilelogger;

import android.app.Application;
import android.content.Context;
import android.os.Build;
import android.os.Looper;
import android.text.TextUtils;
import java.io.BufferedReader;
import java.io.FileReader;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes2.dex */
public class f {
    public static String a() {
        if (Build.VERSION.SDK_INT < 28) goto L39;
        return Application.getProcessName();
    L39:
        Method r10 = Class.forName("android.app.ActivityThread").getMethod("currentProcessName", new Class[0]);     // Catch: Exception -> L9
        r10.setAccessible(true);     // Catch: Exception -> L9
        return (String) r10.invoke(null, new Object[0]);
    L9:
        BufferedReader r11 = new BufferedReader(new FileReader("/proc/self/cmdline"));     // Catch: Throwable -> L20 Exception -> L25
        String r12 = r11.readLine();     // Catch: Throwable -> L18 Exception -> L32
        if (TextUtils.isEmpty(r12) == true) goto L33;
        String r13 = r12.trim();     // Catch: Throwable -> L18 Exception -> L32
        if (TextUtils.isEmpty(r13) == true) goto L33;
        r11.close();     // Catch: Exception -> L29
    L15:
        return r13;
    L33:
        r11.close();     // Catch: Exception -> L30
    L28:
        return null;
    L18:
        Throwable th = th;
    L22:
        if (r11 != null) goto L35;
    L24:
        throw th;
    L35:
        r11.close();     // Catch: Exception -> L31
    L26:
        if (r11 == null) goto L28;
    L25:
        r11 = null;
    L20:
        th = move-exception;
        r11 = null;
        th = th;
        goto L22
    }

    public static boolean b(Context r10) {
        String r11 = a();
        if (r11 != null) goto L6;
        return false;
    L6:
        if (r11.contains(":") == false) goto L9;
        return false;
    L9:
        if (r11.equals(r10.getPackageName()) == false) goto L12;
        return true;
    L12:
        if (r11.equals(r10.getApplicationInfo().processName) == false) goto L14;
        return true;
    L14:
        return false;
    }

    public static boolean c() {
        if (Looper.getMainLooper().getThread() != Thread.currentThread()) goto L5;
        return true;
    L5:
        return false;
    }
}
