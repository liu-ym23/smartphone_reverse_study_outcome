package ita;

import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.os.Build;
import android.os.Process;
import com.bytedance.common.utility.Logger;
import com.bytedance.common.utility.StringUtils;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.bytedance.security.android.aopcheck.PolarisFileInputStreamWrapper;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import el9.a;
import f06.b;
import f06.c;
import f06.d;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class k {
    public static String a;
    public static boolean b;
    public static boolean c;
    public static String d;

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class a() throws ClassNotFoundException {
        ConcurrentHashMap r0 = FastClassNotFoundHandler.a;
        FastClassNotFoundHandler.Status r1 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (a.a() == true) goto L34;
        Class<?> r2 = Class.forName("miui.os.Build");     // Catch: Throwable -> L8
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L7;
        FastClassNotFoundHandler.a("miui.os.Build");     // Catch: Throwable -> L8
    L7:
        return r2;
    L8:
        th = move-exception;
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L12;
        FastClassNotFoundHandler.b("miui.os.Build");
    L12:
        throw th;
    L34:
        Class<?> r3 = Class.forName("miui.os.Build");     // Catch: Throwable -> L17
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L16;
        FastClassNotFoundHandler.a("miui.os.Build");     // Catch: Throwable -> L17
    L16:
        return r3;
    L17:
        th = move-exception;
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L22;
        FastClassNotFoundHandler.b("miui.os.Build");
    L22:
        if ((th instanceof PluginClassNotFoundException) == false) goto L24;
        throw th;
    L24:
        if ((th instanceof ClassNotFoundException) == true) goto L30;
        if ((th instanceof NoClassDefFoundError) == true) goto L30;
        throw th;
    L30:
        return MiraPluginFix.forName("miui.os.Build");
    }

    public static String d() {
        if (StringUtils.isEmpty(a) == false) goto L43;
        String r2 = null;
        BufferedReader r4 = new BufferedReader(new InputStreamReader(b(Runtime.getRuntime(), "getprop ro.build.version.emui").getInputStream()), 1024);     // Catch: Throwable -> L14
        r2 = r4.readLine();     // Catch: Throwable -> L12
        r4.close();     // Catch: Throwable -> L12
        a = r2;     // Catch: Throwable -> L12
        r4.close();     // Catch: IOException -> L10
    L23:
        return r2;
    L10:
        e = e;
    L21:
        Logger.e("ToolUtils", "Exception while closing InputStream", e);
    L12:
        th = th;
    L35:
        Logger.e("ToolUtils", "Unable to read sysprop ro.build.version.emui", th);     // Catch: Throwable -> L24
        if (r4 == null) goto L23;
        r4.close();     // Catch: IOException -> L20
    L20:
        e = e;
    L24:
        th = move-exception;
        if (r4 != null) goto L31;
    L30:
        throw th;
    L31:
        r4.close();     // Catch: IOException -> L28
    L28:
        e = move-exception;
        Logger.e("ToolUtils", "Exception while closing InputStream", e);
    L14:
        th = th;
        r4 = null;
        goto L35
    L43:
        return a;
    }

    public static boolean f() {
        String r0 = Build.DISPLAY;
        if (StringUtils.isEmpty(r0) == true) goto L7;
        if (r0.indexOf("Flyme") < 0) goto L7;
        return true;
    L7:
        if (StringUtils.isEmpty(Build.USER) == false) goto L9;
        return false;
    L9:
        if (Build.USER.equals("flyme") == false) goto L15;
        return true;
    L15:
        return false;
    }

    public static boolean j() {
        if (c == true) goto L11;
        if (a() == null) goto L9;
        b = true;     // Catch: Exception -> L12
        c = true;     // Catch: Exception -> L12
        return true;
    L9:
        c = true;
    L11:
        return b;
    }

    public static String c(Context r6) {
        String r1 = d;
        if (StringUtils.isEmpty(r1) == true) goto L42;
        return r1;
    L42:
        int r2 = Process.myPid();     // Catch: Exception -> L15
        Iterator<ActivityManager.RunningAppProcessInfo> r7 = ((ActivityManager) r6.getSystemService("activity")).getRunningAppProcesses().iterator();     // Catch: Exception -> L15
    L7:
        if (r7.hasNext() == false) goto L17;
        ActivityManager.RunningAppProcessInfo r3 = r7.next();     // Catch: Exception -> L15
        if (r3.pid != r2) goto L7;
        if (Logger.debug() == false) goto L13;
        Logger.d("Process", "processName = " + r3.processName);     // Catch: Exception -> L15
    L13:
        String r8 = r3.processName;     // Catch: Exception -> L15
        d = r8;     // Catch: Exception -> L15
        return r8;
    L17:
        String r4 = null;
        BufferedReader r5 = new BufferedReader(new InputStreamReader(new PolarisFileInputStreamWrapper("/proc/" + Process.myPid() + "/cmdline"), "iso-8859-1"));     // Catch: Throwable -> L30
        StringBuilder r9 = new StringBuilder();     // Catch: Throwable -> L29
    L20:
        int r10 = r5.read();     // Catch: Throwable -> L29
        if (r10 <= 0) goto L24;
        r9.append((char) r10);     // Catch: Throwable -> L29
        goto L20
    L24:
        if (Logger.debug() == false) goto L26;
        Logger.d("Process", "get processName = " + r9.toString());     // Catch: Throwable -> L29
    L26:
        r4 = r9.toString();     // Catch: Throwable -> L29
    L38:
        r5.close();     // Catch: Exception -> L35
    L33:
        d = r4;
        return r4;
    L31:
        if (r5 == null) goto L33;
    L30:
        r5 = null;
    L15:
        e = move-exception;
        e.printStackTrace();
        goto L17
    }

    public static boolean i(Context r3) {
        String r0 = c(r3);
        if (r0 != null) goto L5;
    L7:
        if (r0 != null) goto L9;
        return false;
    L9:
        if (r0.equals(r3.getPackageName()) == false) goto L13;
        return true;
    L13:
        return false;
    L5:
        if (r0.contains(":") == false) goto L7;
        return false;
    }

    public static Process b(Runtime r12, String r13) {
        c r8 = new c();
        Object[] r9 = {r13};
        b r10 = new b();
        d r11 = r8.b(102900, "java/lang/Runtime", "exec", r12, r9, "java.lang.Process", r10);
        if (r11.a == false) goto L6;
        r8.a(102900, "java/lang/Runtime", "exec", r12, r9, null, r10, false);
        return (Process) r11.b;
    L6:
        Process r14 = r12.exec(r13);
        r8.a(102900, "java/lang/Runtime", "exec", r12, r9, r14, r10, true);
        return r14;
    }

    public static Intent e(Context r1, String r2) {
        Intent r3 = r1.getPackageManager().getLaunchIntentForPackage(r2);
        if (r3 != null) goto L6;
        return r3;
    L6:
        if (r3.hasCategory("android.intent.category.LAUNCHER") == true) goto L8;
        r3.addCategory("android.intent.category.LAUNCHER");
        Logger.d("ToolUtils", "add category LAUNCHER in launch intent");
    L8:
        r3.setPackage(null);
        r3.addFlags(2097152);
        r3.addFlags(268435456);
        return r3;
    }

    public static boolean g(Context r1, Intent r2) {
        List<ResolveInfo> r3 = r1.getPackageManager().queryIntentActivities(r2, 65536);
        if (r3 != null) goto L5;
        return false;
    L5:
        if (r3.size() <= 0) goto L10;
        return true;
    L10:
        return false;
    }

    public static boolean h(Context r2, String r3) {
        if (r2 != null) goto L5;
        return false;
    L5:
        if (StringUtils.isEmpty(r3) == false) goto L12;
        return false;
    L12:
        if (r2.getPackageManager().getPackageInfo(r3, 16777216) != null) goto L10;
        return false;
    L10:
        return true;
    L17:
        return false;
    }
}
