package com.lynx.tasm.utils;

import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import com.lynx.tasm.LynxEnv;
import com.lynx.tasm.base.LLog;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public class DisplayMetricsHolder {
    public static final float DEFAULT_SCREEN_SCALE = 1.0f;
    public static final int UNDEFINE_SCREEN_SIZE_VALUE = -1;
    private static boolean hasNativeUpdateDeviceInfo = false;
    private static boolean isCacheInvalid = false;
    private static int sOrientation = -1;
    private static float sScaleDensity = -1.0f;
    private static DisplayMetrics sScreenDisplayMetrics;
    private static DisplayMetrics sWindowDisplayMetrics;

    public DisplayMetricsHolder() {
    }

    public static native void nativeUpdateDevice(int r0, int r1, float r2);

    public static DisplayMetrics getScreenDisplayMetrics() {
        monitor-enter(DisplayMetricsHolder.class);
    L12:
        th = move-exception;
        throw th;
    L5:
        if (sScreenDisplayMetrics != null) goto L9;
        monitor-exit(DisplayMetricsHolder.class);     // Catch: Throwable -> L12
        return null;
    L9:
        DisplayMetrics r1 = new DisplayMetrics();     // Catch: Throwable -> L12
        r1.setTo(sScreenDisplayMetrics);     // Catch: Throwable -> L12
        monitor-exit(DisplayMetricsHolder.class);     // Catch: Throwable -> L12
        return r1;
    }

    public static DisplayMetrics getWindowDisplayMetrics() {
        monitor-enter(DisplayMetricsHolder.class);
    L12:
        th = move-exception;
        throw th;
    L5:
        if (sWindowDisplayMetrics != null) goto L9;
        monitor-exit(DisplayMetricsHolder.class);     // Catch: Throwable -> L12
        return null;
    L9:
        DisplayMetrics r1 = new DisplayMetrics();     // Catch: Throwable -> L12
        r1.setTo(sWindowDisplayMetrics);     // Catch: Throwable -> L12
        monitor-exit(DisplayMetricsHolder.class);     // Catch: Throwable -> L12
        return r1;
    }

    public static DisplayMetrics INVOKEVIRTUAL_com_lynx_tasm_utils_DisplayMetricsHolder_com_obric_assistant_interaction_impl_window_helpers_ResourcesLancet_getDisplayMetrics(Resources r1) {
        return WindowDisplayMetricsOverride.apply(r1, r1.getDisplayMetrics());
    }

    public static DisplayMetrics getRealScreenDisplayMetrics(Context r2) {
        DisplayMetrics r0 = new DisplayMetrics();
        DisplayMetrics r1 = getWindowDisplayMetrics();
        if (r1 == null) goto L5;
        r0.setTo(r1);
    L5:
        WindowManager r3 = (WindowManager) r2.getSystemService("window");
        if (r3 == null) goto L12;
        Display r4 = r3.getDefaultDisplay();
        if (r4 == null) goto L10;
        r4.getRealMetrics(r0);
    L10:
        return r0;
    L12:
        throw new AssertionError("WindowManager is null!");
    }

    private static boolean isDensityChanged(Float r1) {
        DisplayMetrics r0 = sScreenDisplayMetrics;
        if (r0 == null) goto L8;
        if (r1 == null) goto L8;
        if (r0.density == r1.floatValue()) goto L8;
        return true;
    L8:
        return false;
    }

    private static boolean isOrientationChanged(Context r1) {
        if (sOrientation == r1.getResources().getConfiguration().orientation) goto L5;
        return true;
    L5:
        return false;
    }

    private static boolean isScaleDensityChange(DisplayMetrics r1) {
        if (sScaleDensity == r1.scaledDensity) goto L5;
        return true;
    L5:
        return false;
    }

    private static void setScreenDisplayMetrics(DisplayMetrics r3) {
        boolean r0 = LynxEnv.inst().isNativeLibraryLoaded();
        monitor-enter(DisplayMetricsHolder.class);
        sScreenDisplayMetrics = r3;     // Catch: Throwable -> L9
        if (r0 == false) goto L7;
        hasNativeUpdateDeviceInfo = true;     // Catch: Throwable -> L9
        nativeUpdateDevice(r3.widthPixels, r3.heightPixels, r3.density);     // Catch: Throwable -> L9
    L7:
        monitor-exit(DisplayMetricsHolder.class);     // Catch: Throwable -> L9
        return;
    L9:
        th = move-exception;
        throw th;
    }

    private static void setWindowDisplayMetrics(DisplayMetrics r2) {
        monitor-enter(DisplayMetricsHolder.class);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (sWindowDisplayMetrics != null) goto L7;
        sWindowDisplayMetrics = new DisplayMetrics();     // Catch: Throwable -> L10
    L7:
        sWindowDisplayMetrics.setTo(r2);     // Catch: Throwable -> L10
        monitor-exit(DisplayMetricsHolder.class);     // Catch: Throwable -> L10
    }

    private static void updateCurrentProps(Context r1) {
        sScaleDensity = INVOKEVIRTUAL_com_lynx_tasm_utils_DisplayMetricsHolder_com_obric_assistant_interaction_impl_window_helpers_ResourcesLancet_getDisplayMetrics(r1.getResources()).scaledDensity;
        sOrientation = r1.getResources().getConfiguration().orientation;
    }

    public static boolean updateOrInitDisplayMetrics(Context r1) {
        return updateOrInitDisplayMetrics(r1, null);
    }

    private static boolean shouldUpdateScreenMetrics(Context r2, Float r3) {
        DisplayMetrics r0 = INVOKEVIRTUAL_com_lynx_tasm_utils_DisplayMetricsHolder_com_obric_assistant_interaction_impl_window_helpers_ResourcesLancet_getDisplayMetrics(r2.getResources());
        if (getScreenDisplayMetrics() != null) goto L5;
    L14:
        return true;
    L5:
        if (isOrientationChanged(r2) == true) goto L14;
        if (isScaleDensityChange(r0) == true) goto L14;
        if (hasNativeUpdateDeviceInfo == false) goto L14;
        if (isDensityChanged(r3) == true) goto L14;
        return false;
    }

    public static void updateDisplayMetrics(int r2, int r3) {
        monitor-enter(DisplayMetricsHolder.class);
        isCacheInvalid = true;     // Catch: Throwable -> L13
        DisplayMetrics r1 = sWindowDisplayMetrics;     // Catch: Throwable -> L13
        if (r1 == null) goto L8;
        r1.widthPixels = r2;     // Catch: Throwable -> L13
        r1.heightPixels = r3;     // Catch: Throwable -> L13
    L8:
        DisplayMetrics r4 = sScreenDisplayMetrics;     // Catch: Throwable -> L13
        if (r4 == null) goto L11;
        r4.widthPixels = r2;     // Catch: Throwable -> L13
        r4.heightPixels = r3;     // Catch: Throwable -> L13
    L11:
        monitor-exit(DisplayMetricsHolder.class);     // Catch: Throwable -> L13
        return;
    L13:
        th = move-exception;
        throw th;
    }

    public static boolean updateOrInitDisplayMetrics(Context r2, Float r3) {
        if (r2 != null) goto L4;
        LLog.w("Lynx", "updateOrInitDisplayMetrics context parameter is null, fallback to updateOrInitDisplayMetrics by ApplicationContext");
        r2 = LynxEnv.inst().getAppContext();
    L4:
        updateWindowDisplayMetrics(r2, r3);
        boolean r0 = shouldUpdateScreenMetrics(r2, r3);
        if (r0 == false) goto L7;
    L8:
        updateScreenDisplayMetrics(r2, r3);
        isCacheInvalid = false;
    L9:
        updateCurrentProps(r2);
        return r0;
    L7:
        if (isCacheInvalid == false) goto L9;
        goto L8
    }

    private static void updateScreenDisplayMetrics(Context r0, Float r1) {
        DisplayMetrics r2 = getRealScreenDisplayMetrics(r0);
        if (r1 == null) goto L5;
        r2.density = r1.floatValue();
    L5:
        setScreenDisplayMetrics(r2);
    }

    private static void updateWindowDisplayMetrics(Context r0, Float r1) {
        DisplayMetrics r2 = INVOKEVIRTUAL_com_lynx_tasm_utils_DisplayMetricsHolder_com_obric_assistant_interaction_impl_window_helpers_ResourcesLancet_getDisplayMetrics(r0.getResources());
        if (r1 == null) goto L5;
        r2.density = r1.floatValue();
    L5:
        setWindowDisplayMetrics(r2);
    }
}
