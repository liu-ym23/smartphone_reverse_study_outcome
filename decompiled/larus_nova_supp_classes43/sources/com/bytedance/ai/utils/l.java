package com.bytedance.ai.utils;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.Window;
import android.view.WindowManager;
import com.bytedance.ai.model.AppletRuntimeManager;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class l {
    public static final l a = null;

    static {
        a = new l();
    }

    public l() {
    }

    public static int a(Context r10) {
        Resources r1 = null;
        ConcurrentHashMap r11 = FastClassNotFoundHandler.a;     // Catch: Exception -> L30
        FastClassNotFoundHandler.Status r12 = FastClassNotFoundHandler.Status.STATUS_NOTING;     // Catch: Exception -> L30
        if (el9.a.a() == false) goto L63;
        Class<?> r13 = Class.forName("android.os.SystemProperties");     // Catch: Throwable -> L18
        if (r12 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L32;
        FastClassNotFoundHandler.a("android.os.SystemProperties");     // Catch: Throwable -> L18
    L32:
        boolean r14 = true;
        Object r15 = r13.getMethod("get", new Class[]{String.class}).invoke(r13, new Object[]{"qemu.hw.mainkeys"});     // Catch: Exception -> L30
        Intrinsics.checkNotNull(r15, "null cannot be cast to non-null type kotlin.String");     // Catch: Exception -> L30
        String r16 = (String) r15;     // Catch: Exception -> L30
        if (Intrinsics.areEqual("1", r16) == false) goto L36;
    L48:
        r14 = false;
    L49:
        if (r14 == true) goto L51;
        return 0;
    L51:
        if (r10 == null) goto L53;
        r1 = r10.getResources();
    L53:
        if (r1 == null) goto L55;
        int r17 = r1.getIdentifier("navigation_bar_height", "dimen", "android");
    L56:
        if (r17 <= 0) goto L65;
        if (r1 != null) goto L59;
        return 0;
    L59:
        return r1.getDimensionPixelSize(r17);
    L65:
        return 0;
    L55:
        r17 = 0;
        goto L56
    L36:
        if (Intrinsics.areEqual("0", r16) == false) goto L39;
    L18:
        th = move-exception;
        if (r12 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L23;
        FastClassNotFoundHandler.b("android.os.SystemProperties");     // Catch: Exception -> L30
    L23:
        if ((th instanceof PluginClassNotFoundException) == false) goto L25;
        throw th;     // Catch: Exception -> L30
    L25:
        if ((th instanceof ClassNotFoundException) == false) goto L27;
    L31:
        r13 = MiraPluginFix.forName("android.os.SystemProperties");     // Catch: Exception -> L30
        goto L32
    L27:
        if ((th instanceof NoClassDefFoundError) == true) goto L31;
        throw th;     // Catch: Exception -> L30
    L63:
        r13 = Class.forName("android.os.SystemProperties");     // Catch: Throwable -> L9
        if (r12 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L32;
        FastClassNotFoundHandler.a("android.os.SystemProperties");     // Catch: Throwable -> L9
    L9:
        th = move-exception;
        if (r12 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L13;
        FastClassNotFoundHandler.b("android.os.SystemProperties");     // Catch: Exception -> L30
    L13:
        throw th;     // Catch: Exception -> L30
    L39:
        if (r10 == null) goto L41;
        Resources r18 = r10.getResources();
    L42:
        if (r18 == null) goto L44;
        int r19 = r18.getIdentifier("config_showNavigationBar", "bool", "android");
    L45:
        if (r19 <= 0) goto L48;
        if (r18 == null) goto L48;
        r14 = r18.getBoolean(r19);
        goto L49
    L44:
        r19 = 0;
        goto L45
    L41:
        r18 = null;
        goto L42
    }

    @JvmStatic
    public static final int b(Window r1) {
        if (r1 != null) goto L9;
        AppletRuntimeManager.INSTANCE.getClass();
        g2.b r10 = AppletRuntimeManager.d;
        if (r10 == null) goto L8;
        Activity r11 = r10.currentActivity();
        if (r11 == null) goto L8;
        r1 = r11.getWindow();
    L8:
        r1 = null;
    L9:
        if (r1 == null) goto L17;
        a.getClass();
        DisplayMetrics r0 = new DisplayMetrics();
        WindowManager r12 = r1.getWindowManager();
        if (r12 == null) goto L16;
        Display r13 = r12.getDefaultDisplay();
        if (r13 == null) goto L16;
        r13.getRealMetrics(r0);
    L16:
        return r0.heightPixels;
    L17:
        Resources r14 = Resources.getSystem();
        return WindowDisplayMetricsOverride.apply(r14, r14.getDisplayMetrics()).heightPixels;
    }

    @JvmStatic
    public static final int c(Window r1) {
        if (r1 != null) goto L9;
        AppletRuntimeManager.INSTANCE.getClass();
        g2.b r10 = AppletRuntimeManager.d;
        if (r10 == null) goto L8;
        Activity r11 = r10.currentActivity();
        if (r11 == null) goto L8;
        r1 = r11.getWindow();
    L8:
        r1 = null;
    L9:
        if (r1 == null) goto L17;
        a.getClass();
        DisplayMetrics r0 = new DisplayMetrics();
        WindowManager r12 = r1.getWindowManager();
        if (r12 == null) goto L16;
        Display r13 = r12.getDefaultDisplay();
        if (r13 == null) goto L16;
        r13.getRealMetrics(r0);
    L16:
        return r0.widthPixels;
    L17:
        Resources r14 = Resources.getSystem();
        return WindowDisplayMetricsOverride.apply(r14, r14.getDisplayMetrics()).widthPixels;
    }

    public static String e(l r10, String r11) {
        r10.getClass();
        Intrinsics.checkNotNullParameter(r11, "targetKey");
        h2.a r12 = f2.b.c;
        if (r12 == null) goto L10;
        Context r13 = r12.a;
        if (r13 == null) goto L10;
        int r14 = r13.getResources().getIdentifier(r11, "string", r13.getPackageName());
        if (r14 == 0) goto L10;
        return r13.getString(r14);
    L10:
        return null;
    }

    public static String d(Context r10, String r11, int r12) {
        Intrinsics.checkNotNullParameter(r10, "context");
        Intrinsics.checkNotNullParameter(r11, "targetKey");
        int r13 = r10.getResources().getIdentifier(r11, "string", r10.getPackageName());
        if (r13 == 0) goto L5;
        String r14 = r10.getString(r13);
        Intrinsics.checkNotNull(r14);
        return r14;
    L5:
        String r15 = r10.getString(r12);
        Intrinsics.checkNotNull(r15);
        return r15;
    }
}
