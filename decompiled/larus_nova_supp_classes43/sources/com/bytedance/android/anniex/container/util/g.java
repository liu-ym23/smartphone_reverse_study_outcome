package com.bytedance.android.anniex.container.util;

import android.app.Activity;
import android.os.Build;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import com.bytedance.ies.bullet.base.utils.RomUtils;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.concurrent.ConcurrentHashMap;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class g {
    public static Field a;
    public static Field b;
    public static Field c;
    public static Method d;

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

    public static View b(Window r10) {
        View r11 = r10.getDecorView();
        if (com.larus.home.impl.utils.c.e == false) goto L7;
        FLogger.a.i("DecorViewLancet", "getDecorView");
        Thread r0 = ThreadMethodProxy.currentThread();
        if (r0 == com.larus.home.impl.utils.c.a) goto L7;
        com.larus.home.impl.utils.c.a(r0, "getDecorView");
    L7:
        return r11;
    }

    public static void c(Activity r10) {
        Window r0 = r10.getWindow();
        if (r0 == null) goto L11;
        int r1 = b46.b.a;
        if ((b(r10.getWindow()).getSystemUiVisibility() & 1024) != 1024) goto L7;
        boolean r11 = true;
    L8:
        if (r11 == false) goto L12;
        View r12 = b(r0);
        r12.setSystemUiVisibility(r12.getSystemUiVisibility() & (-1025));
        return;
    L12:
        return;
    L7:
        r11 = false;
        goto L8
    }

    public static void f(Activity r10) {
        if (r10 != null) goto L4;
        return;
    L4:
        Window r11 = r10.getWindow();
        if (Build.VERSION.SDK_INT < 23) goto L20;
        if (r11 != null) goto L9;
        return;
    L9:
        if (b(r11) == null) goto L22;
        View r0 = k.a(r11);
        if (r0 == null) goto L18;
        int r1 = r0.getSystemUiVisibility();
        if ((r1 & 8192) == 0) goto L18;
        r0.setSystemUiVisibility(r1 & (-8193));
    L18:
        e(r11, false);
        d(r11, false);
        return;
    L22:
        return;
    }

    public static void g(Activity r10) {
        Window r11 = r10.getWindow();
        if (Build.VERSION.SDK_INT < 23) goto L18;
        if (r11 != null) goto L7;
        return;
    L7:
        if (b(r11) == null) goto L20;
        View r0 = k.a(r11);
        if (r0 == null) goto L16;
        int r1 = r0.getSystemUiVisibility();
        if ((r1 & 9216) == 9216) goto L16;
        r0.setSystemUiVisibility(r1 | 9216);
    L16:
        e(r11, true);
        d(r11, true);
        return;
    L20:
        return;
    }

    public static void d(Window r10, boolean r11) {
        if (((Boolean) RomUtils.b.getValue()).booleanValue() == false) goto L19;
        WindowManager.LayoutParams r0 = r10.getAttributes();     // Catch: Throwable -> L16
        if (b != null) goto L8;
        Field r1 = WindowManager.LayoutParams.class.getDeclaredField("MEIZU_FLAG_DARK_STATUS_BAR_ICON");     // Catch: Throwable -> L16
        b = r1;     // Catch: Throwable -> L16
        r1.setAccessible(true);     // Catch: Throwable -> L16
    L8:
        if (a != null) goto L10;
        Field r12 = WindowManager.LayoutParams.class.getDeclaredField("meizuFlags");     // Catch: Throwable -> L16
        a = r12;     // Catch: Throwable -> L16
        r12.setAccessible(true);     // Catch: Throwable -> L16
    L10:
        int r13 = b.getInt(null);     // Catch: Throwable -> L16
        int r14 = a.getInt(r0);     // Catch: Throwable -> L16
        if (r11 == false) goto L13;
        int r15 = r14 | r13;     // Catch: Throwable -> L16
    L14:
        a.setInt(r0, r15);     // Catch: Throwable -> L16
        r10.setAttributes(r0);     // Catch: Throwable -> L16
        return;
    L13:
        r15 = (~r13) & r14;     // Catch: Throwable -> L16
    L20:
        return;
    }

    public static void e(Window r10, boolean r11) {
        if (((Boolean) RomUtils.a.getValue()).booleanValue() == false) goto L18;
        Class<?> r0 = r10.getClass();     // Catch: Throwable -> L15
        Class r1 = a();     // Catch: Throwable -> L15
        if (c != null) goto L7;
    L8:
        Field r12 = r1.getField("EXTRA_FLAG_STATUS_BAR_DARK_MODE");     // Catch: Throwable -> L15
        c = r12;     // Catch: Throwable -> L15
        r12.setAccessible(true);     // Catch: Throwable -> L15
        Class<?> r13 = Integer.TYPE;     // Catch: Throwable -> L15
        Method r14 = r0.getMethod("setExtraFlags", new Class[]{r13, r13});     // Catch: Throwable -> L15
        d = r14;     // Catch: Throwable -> L15
        r14.setAccessible(true);     // Catch: Throwable -> L15
    L9:
        int r15 = c.getInt(r1);     // Catch: Throwable -> L15
        Method r16 = d;     // Catch: Throwable -> L15
        Object[] r17 = new Object[2];     // Catch: Throwable -> L15
        if (r11 == false) goto L12;
        int r18 = r15;
    L13:
        r17[0] = Integer.valueOf(r18);     // Catch: Throwable -> L15
        r17[1] = Integer.valueOf(r15);     // Catch: Throwable -> L15
        r16.invoke(r10, r17);     // Catch: Throwable -> L15
        return;
    L12:
        r18 = 0;
        goto L13
    L7:
        if (d != null) goto L9;
    L18:
        return;
    }
}
