package com.bytedance.android.live.core.utils.statusbar;

import android.app.Activity;
import android.os.Build;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.larus.home.impl.utils.c;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.concurrent.ConcurrentHashMap;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public class IESStatusBarUtil {
    public static final int BUILD_VERSION_CODE_M = 23;
    public static final int SYSTEM_UI_FLAG_LIGHT_STATUS_BAR = 8192;

    public static /* synthetic */ Class access$000(String r0) throws ClassNotFoundException {
        return Class.forName(r0);
    }

    private IESStatusBarUtil() {
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class INVOKESTATIC_com_bytedance_android_live_core_utils_statusbar_IESStatusBarUtil_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(String r3) throws ClassNotFoundException {
        ConcurrentHashMap r0 = FastClassNotFoundHandler.a;
        FastClassNotFoundHandler.Status r1 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (el9.a.a() == true) goto L34;
        Class r2 = access$000(r3);     // Catch: Throwable -> L8
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L7;
        FastClassNotFoundHandler.a(r3);     // Catch: Throwable -> L8
    L7:
        return r2;
    L8:
        th = move-exception;
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L12;
        FastClassNotFoundHandler.b(r3);
    L12:
        throw th;
    L34:
        Class r4 = access$000(r3);     // Catch: Throwable -> L17
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L16;
        FastClassNotFoundHandler.a(r3);     // Catch: Throwable -> L17
    L16:
        return r4;
    L17:
        th = move-exception;
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L22;
        FastClassNotFoundHandler.b(r3);
    L22:
        if ((th instanceof PluginClassNotFoundException) == false) goto L24;
        throw th;
    L24:
        if ((th instanceof ClassNotFoundException) == true) goto L30;
        if ((th instanceof NoClassDefFoundError) == true) goto L30;
        throw th;
    L30:
        return MiraPluginFix.forName(r3);
    }

    public static View INVOKEVIRTUAL_com_bytedance_android_live_core_utils_statusbar_IESStatusBarUtil_com_larus_home_impl_utils_DecorViewLancet_getDecorView(Window r3) {
        View r4 = r3.getDecorView();
        if (c.e == false) goto L7;
        FLogger.a.i("DecorViewLancet", "getDecorView");
        Thread r0 = ThreadMethodProxy.currentThread();
        if (r0 == c.a) goto L7;
        c.a(r0, "getDecorView");
    L7:
        return r4;
    }

    public static void hideNavigation(Window r1) {
        if (r1 != null) goto L4;
        return;
    L4:
        View r2 = INVOKEVIRTUAL_com_bytedance_android_live_core_utils_statusbar_IESStatusBarUtil_com_larus_home_impl_utils_DecorViewLancet_getDecorView(r1);
        if (r2 != null) goto L7;
        return;
    L7:
        r2.setSystemUiVisibility((r2.getSystemUiVisibility() | 2) | 512);
    }

    public static void statusBarLightMode(Window r3) {
        if (r3 != null) goto L4;
        return;
    L4:
        int r0 = Build.VERSION.SDK_INT;
        if (miuisetstatusbarlightmode(r3, true) == false) goto L8;
        return;
    L8:
        if (flymeSetStatusBarLightMode(r3, true) == false) goto L11;
        return;
    L11:
        if (r0 < 23) goto L14;
        androidVersionMStatusBarMode(r3, true);
        return;
    }

    public static void transparencyBar(Activity r3) {
        if (r3 != null) goto L4;
        return;
    L4:
        Window r4 = r3.getWindow();
        r4.clearFlags(67108864);
        View r0 = INVOKEVIRTUAL_com_bytedance_android_live_core_utils_statusbar_IESStatusBarUtil_com_larus_home_impl_utils_DecorViewLancet_getDecorView(r4);
        a.C0173a r1 = a.b;
        r1.a();
        r1.a();
        r0.setSystemUiVisibility(1280);
        r1.a();
        r4.addFlags(Integer.MIN_VALUE);
        r4.setStatusBarColor(0);
    }

    public static void statusBarLightMode(Activity r0) {
        if (r0 != null) goto L4;
        return;
    L4:
        statusBarLightMode(r0.getWindow());
    }

    public static void androidVersionMStatusBarMode(Window r1, boolean r2) {
        if (r1 != null) goto L4;
        return;
    L4:
        r1.clearFlags(67108864);
        a.b.a();
        r1.addFlags(Integer.MIN_VALUE);
        View r3 = INVOKEVIRTUAL_com_bytedance_android_live_core_utils_statusbar_IESStatusBarUtil_com_larus_home_impl_utils_DecorViewLancet_getDecorView(r1);
        int r0 = r3.getSystemUiVisibility();
        if (r2 == false) goto L7;
        int r4 = r0 | SYSTEM_UI_FLAG_LIGHT_STATUS_BAR;
    L8:
        r3.setSystemUiVisibility(r4);
        return;
    L7:
        r4 = r0 & (-8193);
        goto L8
    }

    public static boolean flymeSetStatusBarLightMode(Window r5, boolean r6) {
        if (r5 != null) goto L12;
    L9:
        return false;
    L12:
        WindowManager.LayoutParams r0 = r5.getAttributes();     // Catch: Exception -> L11
        Field r1 = WindowManager.LayoutParams.class.getDeclaredField("MEIZU_FLAG_DARK_STATUS_BAR_ICON");     // Catch: Exception -> L11
        Field r2 = WindowManager.LayoutParams.class.getDeclaredField("meizuFlags");     // Catch: Exception -> L11
        r1.setAccessible(true);     // Catch: Exception -> L11
        r2.setAccessible(true);     // Catch: Exception -> L11
        int r3 = r1.getInt(null);     // Catch: Exception -> L11
        int r4 = r2.getInt(r0);     // Catch: Exception -> L11
        if (r6 == false) goto L6;
        int r7 = r4 | r3;     // Catch: Exception -> L11
    L7:
        r2.setInt(r0, r7);     // Catch: Exception -> L11
        r5.setAttributes(r0);     // Catch: Exception -> L11
        return true;
    L6:
        r7 = (~r3) & r4;     // Catch: Exception -> L11
        goto L7
    }

    public static boolean miuisetstatusbarlightmode(Window r8, boolean r9) {
        if (r8 == null) goto L18;
        Class<?> r1 = r8.getClass();
        Class r2 = INVOKESTATIC_com_bytedance_android_live_core_utils_statusbar_IESStatusBarUtil_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName("android.view.MiuiWindowManager$LayoutParams");     // Catch: Exception -> L16
        int r3 = r2.getField("EXTRA_FLAG_STATUS_BAR_DARK_MODE").getInt(r2);     // Catch: Exception -> L16
        Class<?> r6 = Integer.TYPE;     // Catch: Exception -> L16
        Method r4 = r1.getMethod("setExtraFlags", new Class[]{r6, r6});     // Catch: Exception -> L16
        if (r9 == false) goto L8;
        r4.invoke(r8, new Object[]{Integer.valueOf(r3), Integer.valueOf(r3)});     // Catch: Exception -> L16
    L10:
        if (Build.VERSION.SDK_INT < 23) goto L14;
        if (r9 == false) goto L13;
        INVOKEVIRTUAL_com_bytedance_android_live_core_utils_statusbar_IESStatusBarUtil_com_larus_home_impl_utils_DecorViewLancet_getDecorView(r8).setSystemUiVisibility(SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);     // Catch: Exception -> L16
        goto L14
    L13:
        INVOKEVIRTUAL_com_bytedance_android_live_core_utils_statusbar_IESStatusBarUtil_com_larus_home_impl_utils_DecorViewLancet_getDecorView(r8).setSystemUiVisibility(0);     // Catch: Exception -> L16
    L14:
        return true;
    L8:
        r4.invoke(r8, new Object[]{0, Integer.valueOf(r3)});     // Catch: Exception -> L16
        goto L10
    L19:
        return false;
    L18:
        return false;
    }
}
