package com.bytedance.android.annie.util;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.provider.Settings;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import com.bytedance.android.annie.service.setting.AnnieConfigSettingKeys;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class t {
    public static final t a = null;

    static {
        a = new t();
    }

    public t() {
    }

    private final Application getContext() {
        if (com.bytedance.android.annie.ng.g.g == true) goto L7;
        return null;
    L7:
        return com.bytedance.android.annie.ng.g.a();
    }

    public static int i() {
        Resources r0 = p.a.getResources();
        int r1 = r0.getIdentifier("status_bar_height", "dimen", "android");
        if (r1 > 0) goto L7;
        return 0;
    L7:
        return r0.getDimensionPixelSize(r1);
    }

    public final int h() {
        if (AnnieConfigSettingKeys.ANNIE_METRICS_ADAPTER.a().booleanValue() == true) goto L5;
        Resources r0 = Resources.getSystem();
        DisplayMetrics r1 = WindowDisplayMetricsOverride.apply(r0, r0.getDisplayMetrics());
    L16:
        return r1.heightPixels;
    L5:
        Application r10 = getContext();
        if (r10 == null) goto L12;
        Context r11 = r10.getApplicationContext();
        if (r11 == null) goto L12;
        Resources r12 = r11.getResources();
        if (r12 == null) goto L12;
        r1 = WindowDisplayMetricsOverride.apply(r12, r12.getDisplayMetrics());
    L13:
        if (r1 != null) goto L16;
        Resources r13 = Resources.getSystem();
        r1 = WindowDisplayMetricsOverride.apply(r13, r13.getDisplayMetrics());
    L12:
        r1 = null;
        goto L13
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class a(String r10) throws ClassNotFoundException {
        ConcurrentHashMap r0 = FastClassNotFoundHandler.a;
        FastClassNotFoundHandler.Status r1 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (el9.a.a() == true) goto L34;
        Class<?> r11 = Class.forName(r10);     // Catch: Throwable -> L8
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L7;
        FastClassNotFoundHandler.a(r10);     // Catch: Throwable -> L8
    L7:
        return r11;
    L8:
        th = move-exception;
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L12;
        FastClassNotFoundHandler.b(r10);
    L12:
        throw th;
    L34:
        Class<?> r12 = Class.forName(r10);     // Catch: Throwable -> L17
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L16;
        FastClassNotFoundHandler.a(r10);     // Catch: Throwable -> L17
    L16:
        return r12;
    L17:
        th = move-exception;
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L22;
        FastClassNotFoundHandler.b(r10);
    L22:
        if ((th instanceof PluginClassNotFoundException) == false) goto L24;
        throw th;
    L24:
        if ((th instanceof ClassNotFoundException) == true) goto L30;
        if ((th instanceof NoClassDefFoundError) == true) goto L30;
        throw th;
    L30:
        return MiraPluginFix.forName(r10);
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

    public static boolean c(Context r10) {
        Intrinsics.checkNotNullParameter(r10, "context");
        Resources r11 = r10.getResources();
        int r0 = r11.getIdentifier("config_showNavigationBar", "bool", "android");
        if (r0 <= 0) goto L5;
        boolean r12 = r11.getBoolean(r0);
    L15:
        Class r1 = a("android.os.SystemProperties");     // Catch: Exception -> L14
        Object r13 = r1.getMethod("get", new Class[]{String.class}).invoke(r1, new Object[]{"qemu.hw.mainkeys"});     // Catch: Exception -> L14
        Intrinsics.checkNotNull(r13, "null cannot be cast to non-null type kotlin.String");     // Catch: Exception -> L14
        String r14 = (String) r13;     // Catch: Exception -> L14
        if (Intrinsics.areEqual("1", r14) == true) goto L17;
        if (Intrinsics.areEqual("0", r14) == false) goto L13;
        return true;
    L17:
        return false;
    L13:
        return r12;
    L5:
        r12 = false;
        goto L15
    }

    public static int f(Activity r1) {
        Intrinsics.checkNotNullParameter(r1, com.bytedance.android.ec.core.event.a.VALUE_ACTIVITY);
        DisplayMetrics r0 = new DisplayMetrics();
        r1.getWindowManager().getDefaultDisplay().getRealMetrics(r0);
        return r0.heightPixels;
    }

    public static int g(Activity r1) {
        Intrinsics.checkNotNullParameter(r1, com.bytedance.android.ec.core.event.a.VALUE_ACTIVITY);
        DisplayMetrics r0 = new DisplayMetrics();
        r1.getWindowManager().getDefaultDisplay().getRealMetrics(r0);
        return r0.widthPixels;
    }

    public final int d(Context r10) {
        Intrinsics.checkNotNullParameter(r10, "context");
        if ((r10 instanceof Activity) == false) goto L6;
        WindowManager r11 = ((Activity) r10).getWindowManager();     // Catch: Exception -> L13
    L7:
        Display r12 = r11.getDefaultDisplay();
        DisplayMetrics r0 = new DisplayMetrics();
        a("android.view.Display").getMethod("getRealMetrics", new Class[]{DisplayMetrics.class}).invoke(r12, new Object[]{r0});     // Catch: Exception -> L10
        return r0.heightPixels;
    L10:
        e = move-exception;
        int r1 = h();
        e.printStackTrace();
        return r1;
    L6:
        Object r13 = r10.getSystemService("window");     // Catch: Exception -> L13
        Intrinsics.checkNotNull(r13, "null cannot be cast to non-null type android.view.WindowManager");     // Catch: Exception -> L13
        r11 = (WindowManager) r13;     // Catch: Exception -> L13
        goto L7
    L14:
        return h();
    }

    public final int e(Context r10) {
        if (r10 != null) goto L6;
        return 0;
    L6:
        if (((Boolean) RomUtils.a.getValue()).booleanValue() == true) goto L8;
    L10:
        Resources r1 = r10.getResources();
        int r11 = r1.getIdentifier("navigation_bar_height", "dimen", "android");
        if (r11 <= 0) goto L13;
        int r12 = r1.getDimensionPixelSize(r11);
    L14:
        Rect r13 = new Rect();
        if ((r10 instanceof Activity) == false) goto L19;
        b(((Activity) r10).getWindow()).getWindowVisibleDisplayFrame(r13);
        int r14 = r13.height();
        return RangesKt.coerceAtMost(RangesKt.coerceAtLeast((d(r10) - i()) - r14, 0), r12);
    L19:
        if (c(r10) == true) goto L22;
        return 0;
    L22:
        return r12;
    L13:
        r12 = 0;
        goto L14
    L8:
        if (Settings.Global.getInt(r10.getContentResolver(), "hide_gesture_line", 0) != 1) goto L10;
        return 0;
    }
}
