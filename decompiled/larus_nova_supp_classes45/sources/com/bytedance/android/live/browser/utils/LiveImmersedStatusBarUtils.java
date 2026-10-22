package com.bytedance.android.live.browser.utils;

import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.android.live.core.utils.statusbar.IESStatusBarUtil;
import com.bytedance.android.live.core.utils.statusbar.RomUtils;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.concurrent.ConcurrentHashMap;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class LiveImmersedStatusBarUtils {
    public static Field a;
    public static Field b;
    public static Field c;
    public static Method d;

    public static class ImmerseStatusBarView extends View {
        public ImmerseStatusBarView(Context r1) {
            super(r1);
        }

        public ImmerseStatusBarView(Context r1, AttributeSet r2) {
            super(r1, r2);
        }

        public ImmerseStatusBarView(Context r1, AttributeSet r2, int r3) {
            super(r1, r2, r3);
        }
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class a() throws ClassNotFoundException {
        ConcurrentHashMap r0 = FastClassNotFoundHandler.a;
        FastClassNotFoundHandler.Status r1 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (el9.a.a() == true) goto L34;
        Class<?> r2 = Class.forName("android.view.MiuiWindowManager$LayoutParams");     // Catch: Throwable -> L8
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L7;
        FastClassNotFoundHandler.a("android.view.MiuiWindowManager$LayoutParams");     // Catch: Throwable -> L8
    L7:
        return r2;
    L8:
        th = move-exception;
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L12;
        FastClassNotFoundHandler.b("android.view.MiuiWindowManager$LayoutParams");
    L12:
        throw th;
    L34:
        Class<?> r3 = Class.forName("android.view.MiuiWindowManager$LayoutParams");     // Catch: Throwable -> L17
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L16;
        FastClassNotFoundHandler.a("android.view.MiuiWindowManager$LayoutParams");     // Catch: Throwable -> L17
    L16:
        return r3;
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

    public static View b(Window r3) {
        View r4 = r3.getDecorView();
        if (com.larus.home.impl.utils.c.e == false) goto L7;
        FLogger.a.i("DecorViewLancet", "getDecorView");
        Thread r0 = ThreadMethodProxy.currentThread();
        if (r0 == com.larus.home.impl.utils.c.a) goto L7;
        com.larus.home.impl.utils.c.a(r0, "getDecorView");
    L7:
        return r4;
    }

    public static void c(FragmentActivity r2) {
        Window r0 = r2.getWindow();
        if (r0 != null) goto L5;
        return;
    L5:
        if ((b(r2.getWindow()).getSystemUiVisibility() & RomUtils.SZ) != 1024) goto L7;
        boolean r3 = true;
    L8:
        if (r3 == false) goto L12;
        View r4 = b(r0);
        r4.setSystemUiVisibility(r4.getSystemUiVisibility() & (-1025));
        return;
    L12:
        return;
    L7:
        r3 = false;
        goto L8
    }

    public static void f(FragmentActivity r3) {
        Window r4 = r3.getWindow();
        if (Build.VERSION.SDK_INT < 23) goto L18;
        if (r4 != null) goto L7;
        return;
    L7:
        if (b(r4) == null) goto L20;
        View r0 = f.a(r4);
        if (r0 == null) goto L16;
        int r1 = r0.getSystemUiVisibility();
        if ((r1 & IESStatusBarUtil.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR) == 0) goto L16;
        r0.setSystemUiVisibility(r1 & (-8193));
    L16:
        e(r4, false);
        d(r4, false);
        return;
    L20:
        return;
    }

    public static void g(FragmentActivity r4) {
        Window r5 = r4.getWindow();
        if (Build.VERSION.SDK_INT < 23) goto L18;
        if (r5 != null) goto L7;
        return;
    L7:
        if (b(r5) == null) goto L20;
        View r0 = f.a(r5);
        if (r0 == null) goto L16;
        int r1 = r0.getSystemUiVisibility();
        if ((r1 & 9216) == 9216) goto L16;
        r0.setSystemUiVisibility(r1 | 9216);
    L16:
        e(r5, true);
        d(r5, true);
        return;
    L20:
        return;
    }

    public static void d(Window r4, boolean r5) {
        if (puc.a.isFlyme() == false) goto L19;
        WindowManager.LayoutParams r0 = r4.getAttributes();     // Catch: Throwable -> L16
        if (b != null) goto L8;
        Field r1 = WindowManager.LayoutParams.class.getDeclaredField("MEIZU_FLAG_DARK_STATUS_BAR_ICON");     // Catch: Throwable -> L16
        b = r1;     // Catch: Throwable -> L16
        r1.setAccessible(true);     // Catch: Throwable -> L16
    L8:
        if (a != null) goto L10;
        Field r2 = WindowManager.LayoutParams.class.getDeclaredField("meizuFlags");     // Catch: Throwable -> L16
        a = r2;     // Catch: Throwable -> L16
        r2.setAccessible(true);     // Catch: Throwable -> L16
    L10:
        int r3 = b.getInt(null);     // Catch: Throwable -> L16
        int r6 = a.getInt(r0);     // Catch: Throwable -> L16
        if (r5 == false) goto L13;
        int r7 = r6 | r3;     // Catch: Throwable -> L16
    L14:
        a.setInt(r0, r7);     // Catch: Throwable -> L16
        r4.setAttributes(r0);     // Catch: Throwable -> L16
        return;
    L13:
        r7 = (~r3) & r6;     // Catch: Throwable -> L16
    L20:
        return;
    }

    public static void e(Window r8, boolean r9) {
        if (puc.a.isMiui() == false) goto L18;
        Class<?> r0 = r8.getClass();     // Catch: Throwable -> L15
        Class r1 = a();     // Catch: Throwable -> L15
        if (c != null) goto L7;
    L8:
        Field r2 = r1.getField("EXTRA_FLAG_STATUS_BAR_DARK_MODE");     // Catch: Throwable -> L15
        c = r2;     // Catch: Throwable -> L15
        r2.setAccessible(true);     // Catch: Throwable -> L15
        Class<?> r7 = Integer.TYPE;     // Catch: Throwable -> L15
        Method r3 = r0.getMethod("setExtraFlags", new Class[]{r7, r7});     // Catch: Throwable -> L15
        d = r3;     // Catch: Throwable -> L15
        r3.setAccessible(true);     // Catch: Throwable -> L15
    L9:
        int r4 = c.getInt(r1);     // Catch: Throwable -> L15
        Method r5 = d;     // Catch: Throwable -> L15
        Object[] r6 = new Object[2];     // Catch: Throwable -> L15
        if (r9 == false) goto L12;
        int r11 = r4;
    L13:
        r6[0] = Integer.valueOf(r11);     // Catch: Throwable -> L15
        r6[1] = Integer.valueOf(r4);     // Catch: Throwable -> L15
        r5.invoke(r8, r6);     // Catch: Throwable -> L15
        return;
    L12:
        r11 = 0;
        goto L13
    L7:
        if (d != null) goto L9;
    L18:
        return;
    }
}
