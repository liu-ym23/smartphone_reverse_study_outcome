package com.bytedance.android.livesdk.chatroom.vs_base.util;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.livesdk.end.LiveEndPageData;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class t {
    public static final /* synthetic */ int a = 0;

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class a() throws ClassNotFoundException {
        ConcurrentHashMap r0 = FastClassNotFoundHandler.a;
        FastClassNotFoundHandler.Status r1 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (el9.a.a() == true) goto L34;
        Class<?> r2 = Class.forName("android.view.Display");     // Catch: Throwable -> L8
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L7;
        FastClassNotFoundHandler.a("android.view.Display");     // Catch: Throwable -> L8
    L7:
        return r2;
    L8:
        th = move-exception;
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L12;
        FastClassNotFoundHandler.b("android.view.Display");
    L12:
        throw th;
    L34:
        Class<?> r3 = Class.forName("android.view.Display");     // Catch: Throwable -> L17
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L16;
        FastClassNotFoundHandler.a("android.view.Display");     // Catch: Throwable -> L17
    L16:
        return r3;
    L17:
        th = move-exception;
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L22;
        FastClassNotFoundHandler.b("android.view.Display");
    L22:
        if ((th instanceof PluginClassNotFoundException) == false) goto L24;
        throw th;
    L24:
        if ((th instanceof ClassNotFoundException) == true) goto L30;
        if ((th instanceof NoClassDefFoundError) == true) goto L30;
        throw th;
    L30:
        return MiraPluginFix.forName("android.view.Display");
    }

    public static String c() {
        String r0 = Build.BRAND;
        if (TextUtils.isEmpty(r0) == false) goto L6;
        return "navigationbar_is_min";
    L6:
        if (StringsKt.equals(r0, "HUAWEI", true) == false) goto L8;
    L33:
        return "navigationbar_is_min";
    L8:
        if (StringsKt.equals("HONOR", r0, true) == true) goto L33;
        if (StringsKt.equals(r0, "XIAOMI", true) == false) goto L15;
        return "force_fsg_nav_bar";
    L15:
        if (StringsKt.equals(r0, "vivo", true) == false) goto L19;
        return "navigation_gesture_on";
    L19:
        if (StringsKt.equals(r0, "oppo", true) == false) goto L23;
        return "hide_navigationbar_enable";
    L23:
        if (StringsKt.equals(r0, "samsung", true) == false) goto L27;
        return "navigationbar_hide_bar_enabled";
    L27:
        if (StringsKt.equals(r0, "Nokia", true) == false) goto L33;
        if (Build.VERSION.SDK_INT >= 28) goto L31;
        return "navigation_bar_can_hiden";
    L31:
        return "swipe_up_to_switch_apps_enabled";
    }

    public static int e() {
        return Math.max(s1.w(), s1.y());
    }

    public static int f() {
        return Math.min(s1.w(), s1.y());
    }

    @JvmStatic
    public static final int g() {
        if (s1.getContext() == null) goto L8;
        if (i() == false) goto L8;
        return Math.max(s1.w(), s1.y());
    L8:
        return Math.min(s1.w(), s1.y());
    }

    @JvmStatic
    public static final int h() {
        if (s1.getContext() == null) goto L8;
        if (i() == false) goto L8;
        return Math.min(s1.w(), s1.y());
    L8:
        return Math.max(s1.w(), s1.y());
    }

    @JvmStatic
    public static final boolean i() {
        if (s1.getContext().getResources().getConfiguration().orientation == 1) goto L7;
        return false;
    L7:
        return true;
    }

    public static int j() {
        DisplayMetrics r0 = s1.q(s1.getContext());
        return Math.min(r0.heightPixels, r0.widthPixels);
    }

    static {
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

    public static int d(Context r7) {
        Intrinsics.checkNotNullParameter(r7, "context");
        if ((r7 instanceof Activity) == false) goto L6;
        WindowManager r8 = ((Activity) r7).getWindowManager();     // Catch: Exception -> L17
    L9:
        Display r9 = r8.getDefaultDisplay();
        DisplayMetrics r0 = new DisplayMetrics();
        a().getMethod("getRealMetrics", new Class[]{DisplayMetrics.class}).invoke(r9, new Object[]{r0});     // Catch: Exception -> L12
        return r0.heightPixels;
    L12:
        e = move-exception;
        int r1 = g();
        e.printStackTrace();
        return r1;
    L6:
        Object r10 = r7.getSystemService(LiveEndPageData.TAG_WINDOW);     // Catch: Exception -> L17
        if (r10 == null) goto L16;
        r8 = (WindowManager) r10;     // Catch: Exception -> L17
        goto L9
    L16:
        throw new NullPointerException("null cannot be cast to non-null type android.view.WindowManager");     // Catch: Exception -> L17
    L18:
        return g();
    }
}
