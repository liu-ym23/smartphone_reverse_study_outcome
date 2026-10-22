package com.bytedance.badger.utils;

import android.os.Build;
import android.text.TextUtils;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import java.util.concurrent.ConcurrentHashMap;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class y {
    public static String b(String r8) {
    L7:
        return "";
    L5:
        return (String) a().getMethod("get", new Class[]{String.class, String.class}).invoke(null, new Object[]{r8, ""});
    }

    public static boolean c() {
        Class r1 = a();     // Catch: Exception -> L9
        if (TextUtils.isEmpty((String) r1.getDeclaredMethod("get", new Class[]{String.class}).invoke(r1, new Object[]{"ro.build.version.emui"})) == true) goto L8;
        return true;
    L8:
        return false;
    }

    public static boolean d() {
        if ("oppo".equalsIgnoreCase(Build.MANUFACTURER) == true) goto L12;
        String r0 = Build.BRAND;
        if ("oppo".equalsIgnoreCase(r0) == true) goto L12;
        if ("realme".equalsIgnoreCase(r0) == true) goto L12;
        if ("OnePlus".equalsIgnoreCase(r0) == true) goto L12;
        return false;
    L12:
        return true;
    }

    public static boolean e() {
        String r0 = Build.BRAND;
        if (TextUtils.isEmpty(r0) == false) goto L5;
    L6:
        String r1 = Build.MANUFACTURER;
        if (TextUtils.isEmpty(r1) == true) goto L11;
        if (r1.toLowerCase().startsWith("honor") == false) goto L11;
    L12:
        return true;
    L11:
        if ("HONOR".equalsIgnoreCase(r1) == true) goto L12;
        return false;
    L5:
        if (r0.toLowerCase().startsWith("honor") == true) goto L12;
        goto L6
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class a() throws ClassNotFoundException {
        ConcurrentHashMap r0 = FastClassNotFoundHandler.a;
        FastClassNotFoundHandler.Status r1 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (el9.a.a() == true) goto L34;
        Class<?> r2 = Class.forName("android.os.SystemProperties");     // Catch: Throwable -> L8
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L7;
        FastClassNotFoundHandler.a("android.os.SystemProperties");     // Catch: Throwable -> L8
    L7:
        return r2;
    L8:
        th = move-exception;
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L12;
        FastClassNotFoundHandler.b("android.os.SystemProperties");
    L12:
        throw th;
    L34:
        Class<?> r3 = Class.forName("android.os.SystemProperties");     // Catch: Throwable -> L17
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L16;
        FastClassNotFoundHandler.a("android.os.SystemProperties");     // Catch: Throwable -> L17
    L16:
        return r3;
    L17:
        th = move-exception;
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L22;
        FastClassNotFoundHandler.b("android.os.SystemProperties");
    L22:
        if ((th instanceof PluginClassNotFoundException) == false) goto L24;
        throw th;
    L24:
        if ((th instanceof ClassNotFoundException) == true) goto L30;
        if ((th instanceof NoClassDefFoundError) == true) goto L30;
        throw th;
    L30:
        return MiraPluginFix.forName("android.os.SystemProperties");
    }
}
