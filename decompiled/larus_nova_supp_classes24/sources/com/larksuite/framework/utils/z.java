package com.larksuite.framework.utils;

import android.app.ActivityManager;
import android.app.Application;
import android.content.Context;
import android.os.Build;
import android.os.Process;
import android.text.TextUtils;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.bytedance.security.android.aopcheck.PolarisFileInputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import com.ss.android.lark.log.Log;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class z {
    public static String a;
    public static boolean b;

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class a() throws ClassNotFoundException {
        ConcurrentHashMap r0 = FastClassNotFoundHandler.a;
        FastClassNotFoundHandler.Status r1 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (el9.a.a() == true) goto L34;
        Class<?> r2 = Class.forName("android.app.ActivityThread");     // Catch: Throwable -> L8
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L7;
        FastClassNotFoundHandler.a("android.app.ActivityThread");     // Catch: Throwable -> L8
    L7:
        return r2;
    L8:
        th = move-exception;
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L12;
        FastClassNotFoundHandler.b("android.app.ActivityThread");
    L12:
        throw th;
    L34:
        Class<?> r3 = Class.forName("android.app.ActivityThread");     // Catch: Throwable -> L17
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L16;
        FastClassNotFoundHandler.a("android.app.ActivityThread");     // Catch: Throwable -> L17
    L16:
        return r3;
    L17:
        th = move-exception;
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L22;
        FastClassNotFoundHandler.b("android.app.ActivityThread");
    L22:
        if ((th instanceof PluginClassNotFoundException) == false) goto L24;
        throw th;
    L24:
        if ((th instanceof ClassNotFoundException) == true) goto L30;
        if ((th instanceof NoClassDefFoundError) == true) goto L30;
        throw th;
    L30:
        return MiraPluginFix.forName("android.app.ActivityThread");
    }

    public static String b(Context r6) {
        if (TextUtils.isEmpty(a) == false) goto L5;
        BufferedReader r4 = null;
        if (Build.VERSION.SDK_INT < 28) goto L83;
        a = Application.getProcessName();
    L13:
        if (TextUtils.isEmpty(a) == false) goto L15;
        Application r0 = (Application) r6.getApplicationContext();     // Catch: Exception -> L18
        Field r1 = r0.getClass().getField("mLoadedApk");     // Catch: Exception -> L18
        r1.setAccessible(true);     // Catch: Exception -> L18
        Object r2 = r1.get(r0);     // Catch: Exception -> L18
        Field r3 = r2.getClass().getDeclaredField("mActivityThread");     // Catch: Exception -> L18
        r3.setAccessible(true);     // Catch: Exception -> L18
        Object r5 = r3.get(r2);     // Catch: Exception -> L18
        String r7 = (String) r5.getClass().getDeclaredMethod("getProcessName", new Class[0]).invoke(r5, new Object[0]);     // Catch: Exception -> L18
    L20:
        a = r7;
        if (TextUtils.isEmpty(r7) == false) goto L23;
        PolarisFileWrapper r8 = new PolarisFileWrapper("/proc/self/cmdline");
        String r9 = "";
        if (r8.exists() == true) goto L76;
    L58:
        String r10 = "";
    L59:
        a = r10;
        if (TextUtils.isEmpty(r10) == false) goto L62;
        ActivityManager r11 = (ActivityManager) r6.getSystemService("activity");
        if (r11 == null) goto L73;
        List<ActivityManager.RunningAppProcessInfo> r12 = r11.getRunningAppProcesses();
        if (r12 == null) goto L73;
        Iterator<ActivityManager.RunningAppProcessInfo> r13 = r12.iterator();
    L69:
        if (r13.hasNext() == false) goto L73;
        ActivityManager.RunningAppProcessInfo r14 = r13.next();
        if (r14.pid != Process.myPid()) goto L69;
        r9 = r14.processName.trim();
    L73:
        a = r9;
        return r9;
    L62:
        return a;
    L42:
        th = th;
        BufferedReader r15 = r4;
    L52:
        if (r15 != null) goto L81;
    L57:
        throw th;
    L81:
        r15.close();     // Catch: Exception -> L55
    L55:
        e = move-exception;
        e.printStackTrace();
        goto L57
    L76:
        if (r8.isDirectory() == true) goto L58;
        r15 = new BufferedReader(new InputStreamReader(new PolarisFileInputStreamWrapper(r8)));     // Catch: Throwable -> L42 Exception -> L44
        String r16 = r15.readLine();     // Catch: Throwable -> L38 Exception -> L40
        if (TextUtils.isEmpty(r16) == true) goto L36;
        r10 = r16.trim();     // Catch: Throwable -> L38 Exception -> L40
        r15.close();     // Catch: Exception -> L34
    L34:
        e = move-exception;
        e.printStackTrace();
        goto L59
    L36:
        r15.close();     // Catch: Exception -> L49
    L75:
    L40:
        e = e;
        r4 = r15;
    L45:
        e.printStackTrace();     // Catch: Throwable -> L42
        if (r4 == null) goto L58;
        r4.close();     // Catch: Exception -> L49
    L38:
        th = th;
    L44:
        e = e;
    L49:
        e = move-exception;
        e.printStackTrace();
        goto L58
    L23:
        return a;
    L18:
        e = move-exception;
        e.printStackTrace();
        r7 = null;
        goto L20
    L15:
        return a;
    L83:
        Method r17 = a().getMethod("currentProcessName", new Class[0]);     // Catch: Exception -> L11
        r17.setAccessible(true);     // Catch: Exception -> L11
        a = (String) r17.invoke(null, new Object[0]);     // Catch: Exception -> L11
        goto L13
    L5:
        return a;
    }

    public static String c(Context r2) {
        if (e(r2) == false) goto L7;
        return "";
    L7:
        if (TextUtils.isEmpty(a) == false) goto L9;
        return "unknown";
    L9:
        int r3 = a.indexOf(":");
        if (r3 != (-1)) goto L12;
        return "unknown";
    L12:
        return a.substring(r3 + 1);
    }

    public static boolean d(Context r6) {
        ActivityManager r0 = (ActivityManager) r6.getSystemService("activity");
        if (r0 != null) goto L6;
        Log.e("ProcessUtil", "getForegroundProcess: activityManager is null, so return");
        return false;
    L6:
        String r7 = r6.getPackageName();
        List<ActivityManager.RunningAppProcessInfo> r1 = r0.getRunningAppProcesses();
        if (r1 != null) goto L10;
        Log.e("ProcessUtil", "getForegroundProcess: get running process info  is null, so return");
        return false;
    L10:
        Iterator<ActivityManager.RunningAppProcessInfo> r2 = r1.iterator();
    L12:
        if (r2.hasNext() == false) goto L19;
        ActivityManager.RunningAppProcessInfo r3 = r2.next();
        if (r3.processName.contains(r7) == false) goto L12;
        Log.i("ProcessUtil", "process name is " + r3.processName + ", process import is  " + r3.importance);
        if (r3.importance != 100) goto L12;
        return true;
    L19:
        return false;
    }

    public static boolean e(Context r1) {
        boolean r0 = b;
        if (r0 == false) goto L5;
        return r0;
    L5:
        String r2 = b(r1);
        a = r2;
        if (TextUtils.isEmpty(r2) == true) goto L11;
        if (a.indexOf(":") != (-1)) goto L11;
        b = true;
    L11:
        return b;
    }
}
