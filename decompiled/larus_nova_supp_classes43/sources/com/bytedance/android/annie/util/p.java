package com.bytedance.android.annie.util;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.res.Resources;
import android.os.Build;
import android.util.DisplayMetrics;
import android.view.WindowManager;
import com.bytedance.android.annie.service.setting.AnnieConfigSettingKeys;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class p {
    public static final p a = null;
    public static int b;

    static {
        a = new p();
    }

    public p() {
    }

    public static int f() {
        int r0 = b;
        if (r0 == 0) goto L5;
        return r0;
    L5:
        int r1 = 0;
        Resources r10 = com.bytedance.android.annie.ng.g.a().getResources();     // Catch: Exception -> L19
        Integer r11 = null;
        if (r10 == null) goto L9;
        Integer r12 = Integer.valueOf(r10.getIdentifier("status_bar_height", "dimen", "android"));     // Catch: Exception -> L19
    L10:
        if (r12 != null) goto L12;
    L17:
        b = r1;
        goto L18
    L12:
        if (r12.intValue() <= 0) goto L17;
        int r13 = r12.intValue();     // Catch: Exception -> L19
        Resources r14 = com.bytedance.android.annie.ng.g.a().getResources();     // Catch: Exception -> L19
        if (r14 == null) goto L16;
        r11 = Integer.valueOf(r14.getDimensionPixelSize(r13));     // Catch: Exception -> L19
    L16:
        Intrinsics.checkNotNull(r11);     // Catch: Exception -> L19
        r1 = r11.intValue();     // Catch: Exception -> L19
    L9:
        r12 = null;
    L18:
        return r1;
    }

    private final Application getContext() {
        if (com.bytedance.android.annie.ng.g.g == true) goto L7;
        return null;
    L7:
        return com.bytedance.android.annie.ng.g.a();
    }

    public final DisplayMetrics b() {
        if (AnnieConfigSettingKeys.ANNIE_METRICS_ADAPTER.a().booleanValue() == true) goto L6;
        Resources r0 = Resources.getSystem();
        return WindowDisplayMetricsOverride.apply(r0, r0.getDisplayMetrics());
    L6:
        Application r1 = getContext();
        if (r1 == null) goto L13;
        Context r10 = r1.getApplicationContext();
        if (r10 == null) goto L13;
        Resources r11 = r10.getResources();
        if (r11 == null) goto L13;
        DisplayMetrics r12 = WindowDisplayMetricsOverride.apply(r11, r11.getDisplayMetrics());
    L14:
        if (r12 != null) goto L17;
        Resources r13 = Resources.getSystem();
        return WindowDisplayMetricsOverride.apply(r13, r13.getDisplayMetrics());
    L17:
        return r12;
    L13:
        r12 = null;
        goto L14
    }

    public final int d() {
        return b().heightPixels;
    }

    public final int e() {
        return b().widthPixels;
    }

    public final Resources getResources() {
        Application r0 = getContext();
        if (r0 == null) goto L5;
        Resources r1 = r0.getResources();
    L6:
        if (r1 == null) goto L8;
        return r1;
    L8:
        return Resources.getSystem();
    L5:
        r1 = null;
        goto L6
    }

    public static DisplayMetrics c(Context r10) {
        DisplayMetrics r0 = new DisplayMetrics();
        if (r10 != null) goto L6;
        return r0;
    L6:
        if ((r10 instanceof Activity) == false) goto L8;
        WindowManager r11 = ((Activity) r10).getWindowManager();
    L9:
        if (r11 != null) goto L11;
        return r0;
    L11:
        r11.getDefaultDisplay().getRealMetrics(r0);
        return r0;
    L8:
        Object r12 = r10.getSystemService("window");
        Intrinsics.checkNotNull(r12, "null cannot be cast to non-null type android.view.WindowManager");
        r11 = (WindowManager) r12;
        goto L9
    }

    public static float g(Context r10) {
        int r0 = DisplayMetrics.DENSITY_DEVICE_STABLE;
        if (Build.VERSION.SDK_INT >= 24) goto L5;
    L6:
        r0 = 0;
        ConcurrentHashMap r1 = FastClassNotFoundHandler.a;     // Catch: Exception -> L34
        FastClassNotFoundHandler.Status r11 = FastClassNotFoundHandler.Status.STATUS_NOTING;     // Catch: Exception -> L34
        if (el9.a.a() == true) goto L46;
        Class<?> r12 = Class.forName("android.os.SystemProperties");     // Catch: Throwable -> L13
        if (r11 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L36;
        FastClassNotFoundHandler.a("android.os.SystemProperties");     // Catch: Throwable -> L13
    L36:
        Object r13 = r12.getMethod("get", new Class[]{String.class}).invoke(null, new Object[]{"ro.sf.lcd_density"});     // Catch: Exception -> L34
        Intrinsics.checkNotNull(r13, "null cannot be cast to non-null type kotlin.Int");     // Catch: Exception -> L34
        r0 = ((Integer) r13).intValue();     // Catch: Exception -> L34
    L13:
        th = move-exception;
        if (r11 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L17;
        FastClassNotFoundHandler.b("android.os.SystemProperties");     // Catch: Exception -> L34
    L17:
        throw th;     // Catch: Exception -> L34
    L46:
        r12 = Class.forName("android.os.SystemProperties");     // Catch: Throwable -> L22
        if (r11 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L36;
        FastClassNotFoundHandler.a("android.os.SystemProperties");     // Catch: Throwable -> L22
    L22:
        th = move-exception;
        if (r11 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L27;
        FastClassNotFoundHandler.b("android.os.SystemProperties");     // Catch: Exception -> L34
    L27:
        if ((th instanceof PluginClassNotFoundException) == false) goto L29;
        throw th;     // Catch: Exception -> L34
    L29:
        if ((th instanceof ClassNotFoundException) == false) goto L31;
    L35:
        r12 = MiraPluginFix.forName("android.os.SystemProperties");     // Catch: Exception -> L34
        goto L36
    L31:
        if ((th instanceof NoClassDefFoundError) == true) goto L35;
        throw th;     // Catch: Exception -> L34
    L38:
        if (r0 == 0) goto L41;
        if (r10 == null) goto L41;
        return r10.getResources().getConfiguration().densityDpi / r0;
    L41:
        return 1.0f;
    L5:
        if (DisplayMetrics.DENSITY_DEVICE_STABLE != 160) goto L38;
        goto L6
    }

    public final int a(float r10) {
        return (int) ((r10 * b().density) + 0.5f);
    }

    public final float h(int r10) {
        return r10 / b().density;
    }
}
