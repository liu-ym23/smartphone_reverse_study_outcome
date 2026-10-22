package com.bytedance.android.live.core.utils;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import com.bytedance.android.live.broadcast.api.gamepromote.GamePromoteDataContext;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.util.concurrent.ConcurrentHashMap;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class x1 {
    public static int f() {
        Resources r0 = s1.getResources();
        int r1 = r0.getIdentifier("navigation_bar_height", "dimen", "android");
        if (r1 != 0) goto L5;
        return 0;
    L5:
        return r0.getDimensionPixelSize(r1);
    }

    public static int g() {
        if (s1.y() >= s1.w()) goto L7;
        return s1.w();
    L7:
        return s1.y();
    }

    public static int h() {
        if (s1.y() <= s1.w()) goto L7;
        return s1.w();
    L7:
        return s1.y();
    }

    public static int k() {
        Resources r0 = s1.getResources();
        int r1 = r0.getIdentifier("status_bar_height", "dimen", "android");
        if (r1 > 0) goto L7;
        return 0;
    L7:
        return r0.getDimensionPixelSize(r1);
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class a(String r3) throws ClassNotFoundException {
        ConcurrentHashMap r0 = FastClassNotFoundHandler.a;
        FastClassNotFoundHandler.Status r1 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (el9.a.a() == true) goto L34;
        Class<?> r2 = Class.forName(r3);     // Catch: Throwable -> L8
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
        Class<?> r4 = Class.forName(r3);     // Catch: Throwable -> L17
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

    public static boolean c(Context r6) {
        Resources r7 = r6.getResources();
        int r0 = r7.getIdentifier("config_showNavigationBar", "bool", "android");
        boolean r1 = false;
        if (r0 <= 0) goto L5;
        boolean r8 = r7.getBoolean(r0);
    L16:
        Class r2 = a("android.os.SystemProperties");     // Catch: Exception -> L15
        String r3 = (String) r2.getMethod("get", new Class[]{String.class}).invoke(r2, new Object[]{"qemu.hw.mainkeys"});     // Catch: Exception -> L15
        if (GamePromoteDataContext.GAME_TYPE_MOBILE.equals(r3) == true) goto L14;
        if ("0".equals(r3) == false) goto L12;
        r1 = true;
        goto L14
    L12:
        r1 = r8;
    L14:
        return r1;
    L18:
        return r8;
    L5:
        r8 = false;
        goto L16
    }

    public static int d(Context r2) {
        Rect r0 = new Rect();
        if ((r2 instanceof Activity) == false) goto L6;
        b(((Activity) r2).getWindow()).getWindowVisibleDisplayFrame(r0);
    L6:
        return r0.height();
    }

    public static int e(Context r7) {
        if (r7 != null) goto L20;
        return 0;
    L20:
        if ((r7 instanceof Activity) == false) goto L8;
        WindowManager r8 = ((Activity) r7).getWindowManager();     // Catch: Exception -> L16
    L9:
        Display r9 = r8.getDefaultDisplay();
        DisplayMetrics r1 = new DisplayMetrics();
        a("android.view.Display").getMethod("getRealMetrics", new Class[]{DisplayMetrics.class}).invoke(r9, new Object[]{r1});     // Catch: Exception -> L12
        int r11 = r1.heightPixels;     // Catch: Exception -> L12
    L15:
        return r11;
    L12:
        e = move-exception;
        int r0 = s1.w();
        e.printStackTrace();
        r11 = r0;
        goto L15
    L8:
        r8 = (WindowManager) r7.getSystemService("window");     // Catch: Exception -> L16
        goto L9
    L17:
        return s1.w();
    }

    public static DisplayMetrics i(Activity r1) {
        DisplayMetrics r0 = new DisplayMetrics();
        r1.getWindowManager().getDefaultDisplay().getRealMetrics(r0);
        return r0;
    }

    public static int j(Context r4) {
        Resources r0 = r4.getResources();
        int r1 = r0.getIdentifier("navigation_bar_height", "dimen", "android");
        if (r1 <= 0) goto L5;
        int r2 = r0.getDimensionPixelSize(r1);
    L6:
        Rect r3 = new Rect();
        if ((r4 instanceof Activity) == false) goto L11;
        b(((Activity) r4).getWindow()).getWindowVisibleDisplayFrame(r3);
        int r5 = r3.height();
        return Math.min(Math.max((e(r4) - s1.A()) - r5, 0), r2);
    L11:
        if (c(r4) == true) goto L13;
        return 0;
    L13:
        return r2;
    L5:
        r2 = 0;
        goto L6
    }

    public static boolean l(Activity r4) {
        ViewGroup r5 = (ViewGroup) b(r4.getWindow());
        if (r5 == null) goto L15;
        int r1 = 0;
    L6:
        if (r1 >= r5.getChildCount()) goto L26;
        int r2 = r5.getChildAt(r1).getId();
        if (r2 == (-1)) goto L14;
        if ("navigationBarBackground".equals(s1.getResources().getResourceEntryName(r2)) == false) goto L14;
        if (r5.getChildAt(r1).getVisibility() != 0) goto L14;
        return true;
    L25:
        return false;
    L14:
        r1 = r1 + 1;
        goto L6
    L26:
        return false;
    L15:
        return false;
    }
}
