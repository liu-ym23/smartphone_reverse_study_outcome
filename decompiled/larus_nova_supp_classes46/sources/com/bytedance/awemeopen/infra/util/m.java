package com.bytedance.awemeopen.infra.util;

import android.app.ActivityManager;
import android.app.Application;
import android.content.Context;
import android.os.Build;
import android.os.Process;
import android.text.TextUtils;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.bytedance.security.android.aopcheck.PolarisFileInputStreamWrapper;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class m {
    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.mira.core.opt.res+"})
    public static Class a(ClassLoader r5) throws ClassNotFoundException {
        ConcurrentHashMap r0 = FastClassNotFoundHandler.a;
        FastClassNotFoundHandler.Status r1 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (el9.a.a() == false) goto L34;
        Class<?> r6 = Class.forName("android.app.ActivityThread", false, r5);     // Catch: Throwable -> L17
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L16;
        FastClassNotFoundHandler.a("android.app.ActivityThread");     // Catch: Throwable -> L17
    L16:
        return r6;
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
    L34:
        Class<?> r7 = Class.forName("android.app.ActivityThread", false, r5);     // Catch: Throwable -> L8
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L7;
        FastClassNotFoundHandler.a("android.app.ActivityThread");     // Catch: Throwable -> L8
    L7:
        return r7;
    L8:
        th = move-exception;
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L12;
        FastClassNotFoundHandler.b("android.app.ActivityThread");
    L12:
        throw th;
    }

    public static boolean b(Context r7) {
        String r2 = null;
        if (Build.VERSION.SDK_INT >= 28) goto L59;
    L8:
        String r0 = null;
    L10:
        if (TextUtils.isEmpty(r0) == false) goto L58;
        Method r1 = a(Application.class.getClassLoader()).getDeclaredMethod("currentProcessName", new Class[0]);     // Catch: Throwable -> L16
        r1.setAccessible(true);     // Catch: Throwable -> L16
        Object r3 = r1.invoke(null, new Object[0]);     // Catch: Throwable -> L16
        if ((r3 instanceof String) == false) goto L18;
        r0 = (String) r3;     // Catch: Throwable -> L16
    L20:
        if (TextUtils.isEmpty(r0) == false) goto L58;
        BufferedReader r4 = new BufferedReader(new InputStreamReader(new PolarisFileInputStreamWrapper("/proc/" + Process.myPid() + "/cmdline"), "iso-8859-1"));     // Catch: Throwable -> L33
        StringBuilder r5 = new StringBuilder();     // Catch: Throwable -> L32
    L25:
        int r6 = r4.read();     // Catch: Throwable -> L32
        if (r6 <= 0) goto L28;
        r5.append((char) r6);     // Catch: Throwable -> L32
        goto L25
    L28:
        String r8 = r5.toString();     // Catch: Throwable -> L32
        r4.close();     // Catch: Exception -> L31
    L40:
        if (TextUtils.isEmpty(r8) == true) goto L42;
        r0 = r8;
        goto L58
    L42:
        if (r7 == null) goto L55;
        int r9 = Process.myPid();
        ActivityManager r10 = (ActivityManager) r7.getSystemService("activity");
        if (r10 == null) goto L55;
        List<ActivityManager.RunningAppProcessInfo> r11 = r10.getRunningAppProcesses();
        if (r11 == null) goto L55;
        Iterator<ActivityManager.RunningAppProcessInfo> r12 = r11.iterator();
    L50:
        if (r12.hasNext() == false) goto L55;
        ActivityManager.RunningAppProcessInfo r13 = r12.next();
        if (r13.pid != r9) goto L50;
        r2 = r13.processName;
    L55:
        if (TextUtils.isEmpty(r2) == true) goto L58;
        r0 = r2;
    L34:
        if (r4 != null) goto L63;
    L38:
        r8 = null;
        goto L40
    L63:
        r4.close();     // Catch: Exception -> L37
    L33:
        r4 = null;
    L18:
        r0 = null;
    L16:
        th = move-exception;
        th.printStackTrace();
    L58:
        return r0.equals(r7.getPackageName());
    L59:
        r0 = Application.getProcessName();     // Catch: Exception -> L6
    L6:
        e = move-exception;
        e.printStackTrace();
        goto L8
    }
}
