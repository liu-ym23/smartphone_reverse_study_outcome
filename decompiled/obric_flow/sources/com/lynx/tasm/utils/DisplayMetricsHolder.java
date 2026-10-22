package com.lynx.tasm.utils;

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import com.bytedance.lynx.service.monitor.LynxMonitorService;
import com.lynx.base.log.LynxLog;
import com.lynx.tasm.LynxEnv;

/* JADX INFO: loaded from: classes2.dex */
public class DisplayMetricsHolder {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static DisplayMetrics f11154a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static DisplayMetrics f11155b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static int f11156c = -1;
    public static float d = -1.0f;
    public static boolean e = false;
    public static boolean f = false;

    public static DisplayMetrics a() {
        monitor-enter(DisplayMetricsHolder.class);
    L9:
        th = move-exception;
        throw th;
    L5:
        if (f11155b != null) goto L11;
        monitor-exit(DisplayMetricsHolder.class);     // Catch: Throwable -> L9
        return null;
    L11:
        DisplayMetrics r5 = new DisplayMetrics();     // Catch: Throwable -> L9
        r5.setTo(f11155b);     // Catch: Throwable -> L9
        monitor-exit(DisplayMetricsHolder.class);     // Catch: Throwable -> L9
        return r5;
    }

    public static DisplayMetrics b(Context r5) {
        DisplayMetrics r10 = new DisplayMetrics();
        if (d() == null) goto L5;
        r10.setTo(d());
    L5:
        WindowManager r11 = (WindowManager) r5.getSystemService("window");
        if (r11 == null) goto L12;
        Display r12 = r11.getDefaultDisplay();
        if (r12 == null) goto L10;
        r12.getRealMetrics(r10);
    L10:
        return r10;
    L12:
        throw new AssertionError("WindowManager is null!");
    }

    public static void c(Context r5, Float r10) {
        if (r5 != null) goto L4;
        LynxLog.b(3, LynxMonitorService.DEFAULT_PID, "updateOrInitDisplayMetrics context parameter is null, fallback to updateOrInitDisplayMetrics by ApplicationContext");
        r5 = LynxEnv.inst().getAppContext();
    L4:
        DisplayMetrics r11 = r5.getResources().getDisplayMetrics();
        if (r10 == null) goto L8;
        r11.density = r10.floatValue();
    L8:
        monitor-enter(DisplayMetricsHolder.class);
    L12:
        th = move-exception;
        throw th;
    L10:
        if (f11154a != null) goto L14;
        f11154a = new DisplayMetrics();     // Catch: Throwable -> L12
    L14:
        f11154a.setTo(r11);     // Catch: Throwable -> L12
        monitor-exit(DisplayMetricsHolder.class);     // Catch: Throwable -> L12
        DisplayMetrics r12 = r5.getResources().getDisplayMetrics();
        if (a() != null) goto L19;
    L34:
        DisplayMetrics r13 = b(r5);
        if (r10 == null) goto L37;
        r13.density = r10.floatValue();
    L37:
        boolean r14 = LynxEnv.inst().isNativeLibraryLoaded();
        monitor-enter(DisplayMetricsHolder.class);
        f11155b = r13;     // Catch: Throwable -> L42
        if (r14 == false) goto L44;
        e = true;     // Catch: Throwable -> L42
        nativeUpdateDevice(r13.widthPixels, r13.heightPixels, r13.density);     // Catch: Throwable -> L42
    L44:
        monitor-exit(DisplayMetricsHolder.class);     // Catch: Throwable -> L42
        f = false;
    L46:
        d = r5.getResources().getDisplayMetrics().scaledDensity;
        f11156c = r5.getResources().getConfiguration().orientation;
        return;
    L42:
        th = move-exception;
        throw th;
    L19:
        if (f11156c != r5.getResources().getConfiguration().orientation) goto L34;
        if (d != r12.scaledDensity) goto L34;
        if (e == false) goto L34;
        DisplayMetrics r15 = f11155b;
        if (r15 == null) goto L33;
        if (r10 == null) goto L33;
        if (r15.density != r10.floatValue()) goto L34;
    L33:
        if (f == false) goto L46;
        goto L34
    }

    public static DisplayMetrics d() {
        monitor-enter(DisplayMetricsHolder.class);
    L9:
        th = move-exception;
        throw th;
    L5:
        if (f11154a != null) goto L11;
        monitor-exit(DisplayMetricsHolder.class);     // Catch: Throwable -> L9
        return null;
    L11:
        DisplayMetrics r5 = new DisplayMetrics();     // Catch: Throwable -> L9
        r5.setTo(f11154a);     // Catch: Throwable -> L9
        monitor-exit(DisplayMetricsHolder.class);     // Catch: Throwable -> L9
        return r5;
    }

    public static native void nativeUpdateDevice(int r5, int r10, float r11);
}
