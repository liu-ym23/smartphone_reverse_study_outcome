package com.ss.android.token;

import android.app.ActivityManager;
import android.app.Application;
import android.content.Context;
import android.os.Build;
import android.os.Process;
import android.text.TextUtils;
import android.util.Log;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.bytedance.security.android.aopcheck.PolarisFileInputStreamWrapper;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import el9.a;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class h0 {
    public static volatile String a;
    public static volatile boolean b;

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.mira.core.opt.res+"})
    public static Class a(ClassLoader r5) throws ClassNotFoundException {
        ConcurrentHashMap r0 = FastClassNotFoundHandler.a;
        FastClassNotFoundHandler.Status r1 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (a.a() == false) goto L34;
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

    public static String b(Context r7) {
        if (TextUtils.isEmpty(a) == false) goto L5;
        String r2 = null;
        if (Build.VERSION.SDK_INT >= 28) goto L83;
    L12:
        String r0 = null;
    L13:
        a = r0;
        tb7.a.a("Process", "getCurProcessName: " + a);
        if (TextUtils.isEmpty(a) == false) goto L16;
        Method r1 = a(Application.class.getClassLoader()).getDeclaredMethod("currentProcessName", new Class[0]);     // Catch: Throwable -> L21
        r1.setAccessible(true);     // Catch: Throwable -> L21
        Object r3 = r1.invoke(null, new Object[0]);     // Catch: Throwable -> L21
        if ((r3 instanceof String) == false) goto L23;
        String r4 = (String) r3;     // Catch: Throwable -> L21
    L24:
        a = r4;
        tb7.a.a("Process", "getCurrentProcessNameByActivityThread: " + a);
        if (TextUtils.isEmpty(a) == true) goto L81;
        return a;
    L81:
        BufferedReader r5 = new BufferedReader(new InputStreamReader(new PolarisFileInputStreamWrapper("/proc/" + Process.myPid() + "/cmdline"), "iso-8859-1"));     // Catch: Throwable -> L41
        StringBuilder r6 = new StringBuilder();     // Catch: Throwable -> L39
    L31:
        int r8 = r5.read();     // Catch: Throwable -> L39
        if (r8 <= 0) goto L34;
        r6.append((char) r8);     // Catch: Throwable -> L39
        goto L31
    L34:
        tb7.a.a("Process", "get processName = " + r6.toString());     // Catch: Throwable -> L39
        String r9 = r6.toString();     // Catch: Throwable -> L39
        r5.close();     // Catch: Exception -> L37
    L50:
        a = r9;
        tb7.a.a("Process", "getCurProcessNameFromProc: " + a);
        if (TextUtils.isEmpty(a) == false) goto L53;
        if (r7 == null) goto L66;
        int r10 = Process.myPid();
        ActivityManager r11 = (ActivityManager) r7.getSystemService("activity");
        if (r11 == null) goto L66;
        List<ActivityManager.RunningAppProcessInfo> r12 = r11.getRunningAppProcesses();
        if (r12 == null) goto L66;
        Iterator<ActivityManager.RunningAppProcessInfo> r13 = r12.iterator();
    L62:
        if (r13.hasNext() == false) goto L66;
        ActivityManager.RunningAppProcessInfo r14 = r13.next();
        if (r14.pid != r10) goto L62;
        r2 = r14.processName;
    L66:
        a = r2;
        tb7.a.a("Process", "getCurrentProcessNameByActivityManager: " + a);
        return a;
    L53:
        return a;
    L37:
        e = move-exception;
        TTTokenMonitor.d(e);
    L39:
        th = th;
    L85:
        TTTokenMonitor.d(th);     // Catch: Throwable -> L68
        if (r5 != null) goto L89;
    L49:
        r9 = null;
        goto L50
    L89:
        r5.close();     // Catch: Exception -> L47
    L47:
        e = move-exception;
        TTTokenMonitor.d(e);
    L68:
        th = move-exception;
        if (r5 != null) goto L87;
    L74:
        throw th;
    L87:
        r5.close();     // Catch: Exception -> L72
    L72:
        e = move-exception;
        TTTokenMonitor.d(e);
    L41:
        th = th;
        r5 = null;
    L23:
        r4 = null;
    L21:
        th = move-exception;
        th.printStackTrace();
        goto L23
    L16:
        return a;
    L83:
        r0 = Application.getProcessName();     // Catch: Exception -> L10
    L10:
        e = move-exception;
        e.printStackTrace();
        goto L12
    L5:
        return a;
    }

    public static boolean d(Context r5) {
        String r0 = b(r5);
        if (TextUtils.isEmpty(r0) == false) goto L14;
        return false;
    L14:
        return r0.equals(r5.getPackageManager().getApplicationInfo(r5.getPackageName(), 128).processName);
    L7:
        th = move-exception;
        tb7.a.a("Process", "isMainProcess exception" + Log.getStackTraceString(th));
        if (r0.contains(":") == false) goto L11;
        return false;
    L11:
        if (r0.equals(r5.getPackageName()) == false) goto L17;
        return true;
    L17:
        return false;
    }

    public static boolean c(String r4, Set<String> r5) {
        Iterator<String> r6 = r5.iterator();
    L4:
        if (r6.hasNext() == false) goto L17;
        String r0 = r6.next();
        if (TextUtils.isEmpty(r0) == true) goto L4;
        if (r4.equals(r0) == true) goto L10;
        if (r0.startsWith(".") == true) goto L15;
        r0 = ".".concat(r0);
    L15:
        if (r4.endsWith(r0) == false) goto L4;
        return true;
    L10:
        return true;
    L17:
        return false;
    }
}
