package com.bytedance.android.ec.core.utils;

import android.app.Activity;
import android.os.Build;
import android.view.View;
import android.view.Window;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.gyf.barlibrary.FlymeOSStatusBarFontUtils;
import com.gyf.barlibrary.OSUtils;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.lang.reflect.Method;
import java.util.concurrent.ConcurrentHashMap;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class y1 {
    public static final /* synthetic */ int a = 0;

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class a() throws ClassNotFoundException {
        ConcurrentHashMap r0 = FastClassNotFoundHandler.a;
        FastClassNotFoundHandler.Status r1 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (el9.a.a() == true) goto L34;
        Class<?> r10 = Class.forName("android.view.MiuiWindowManager$LayoutParams");     // Catch: Throwable -> L8
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L7;
        FastClassNotFoundHandler.a("android.view.MiuiWindowManager$LayoutParams");     // Catch: Throwable -> L8
    L7:
        return r10;
    L8:
        th = move-exception;
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L12;
        FastClassNotFoundHandler.b("android.view.MiuiWindowManager$LayoutParams");
    L12:
        throw th;
    L34:
        Class<?> r11 = Class.forName("android.view.MiuiWindowManager$LayoutParams");     // Catch: Throwable -> L17
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L16;
        FastClassNotFoundHandler.a("android.view.MiuiWindowManager$LayoutParams");     // Catch: Throwable -> L17
    L16:
        return r11;
    L17:
        th = move-exception;
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L22;
        FastClassNotFoundHandler.b("android.view.MiuiWindowManager$LayoutParams");
    L22:
        if ((th instanceof PluginClassNotFoundException) == false) goto L24;
        throw th;
    L24:
        if ((th instanceof ClassNotFoundException) == true) goto L30;
        if ((th instanceof NoClassDefFoundError) == true) goto L30;
        throw th;
    L30:
        return MiraPluginFix.forName("android.view.MiuiWindowManager$LayoutParams");
    }

    static {
    }

    public static void b(boolean r10, Window r11) {
        Class<?> r0 = r11.getClass();     // Catch: Throwable -> L8
        Class r1 = a();     // Catch: Throwable -> L8
        int r12 = r1.getField("EXTRA_FLAG_STATUS_BAR_DARK_MODE").getInt(r1);     // Catch: Throwable -> L8
        Class<?> r13 = Integer.TYPE;     // Catch: Throwable -> L8
        Method r14 = r0.getMethod("setExtraFlags", new Class[]{r13, r13});     // Catch: Throwable -> L8
        Object[] r15 = new Object[2];     // Catch: Throwable -> L8
        if (r10 == false) goto L5;
        int r16 = r12;
    L6:
        r15[0] = Integer.valueOf(r16);     // Catch: Throwable -> L8
        r15[1] = Integer.valueOf(r12);     // Catch: Throwable -> L8
        r14.invoke(r11, r15);     // Catch: Throwable -> L8
        return;
    L5:
        r16 = 0;
    L8:
        th = move-exception;
        th.printStackTrace();
    }

    public static void c(Activity r10, Window r11, boolean r12) {
        if (r10 == null) goto L29;
        if (r11 == null) goto L31;
    L24:
        th = move-exception;
        th.printStackTrace();
        return;
    L6:
        if (Build.VERSION.SDK_INT < 23) goto L18;
        View r0 = r11.getDecorView();     // Catch: Throwable -> L24
        if (com.larus.home.impl.utils.c.e == false) goto L12;
        FLogger.a.i("DecorViewLancet", "getDecorView");     // Catch: Throwable -> L24
        Thread r1 = ThreadMethodProxy.currentThread();     // Catch: Throwable -> L24
        if (r1 == com.larus.home.impl.utils.c.a) goto L12;
        com.larus.home.impl.utils.c.a(r1, "getDecorView");     // Catch: Throwable -> L24
    L12:
        int r13 = r0.getSystemUiVisibility();     // Catch: Throwable -> L24
        if (r12 == true) goto L15;
        r0.setSystemUiVisibility(r13 & (-8193));     // Catch: Throwable -> L24
    L16:
        r11.clearFlags(67108864);     // Catch: Throwable -> L24
        r11.addFlags(Integer.MIN_VALUE);     // Catch: Throwable -> L24
        goto L18
    L15:
        r0.setSystemUiVisibility(r13 | 8192);     // Catch: Throwable -> L24
    L18:
        if (OSUtils.isMIUI6Later() == false) goto L21;
        b(r12, r11);     // Catch: Throwable -> L24
    L21:
        if (OSUtils.isFlymeOS4Later() == false) goto L30;
        FlymeOSStatusBarFontUtils.setStatusBarDarkIcon(r10, r12);     // Catch: Throwable -> L24
        return;
    L30:
        return;
    L31:
        return;
    }
}
