package com.lynx.tasm.utils;

import android.content.Context;
import android.graphics.Typeface;
import android.hardware.display.DisplayManager;
import android.os.Build;
import android.text.TextPaint;
import android.view.Display;
import android.widget.TextView;
import com.bytedance.lynx.service.monitor.LynxMonitorService;
import com.lynx.base.log.LynxLog;
import com.lynx.tasm.LynxEnv;
import com.lynx.tasm.base.CalledByNative;

/* JADX INFO: loaded from: classes2.dex */
public class DeviceUtils {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static boolean f11151a = false;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static boolean f11152b = false;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static int f11153c = -1;
    public static String d;
    public static Typeface e;
    public static boolean f;

    public static float a(Context r5) {
        DisplayManager r10 = (DisplayManager) r5.getSystemService(DisplayManager.class);
        if (r10 == null) goto L5;
        Display r11 = r10.getDisplay(0);
    L6:
        if (r11 != null) goto L8;
        return 60.0f;
    L8:
        return r11.getRefreshRate();
    L5:
        r11 = null;
        goto L6
    }

    public static synchronized Typeface b() {
        monitor-enter(DeviceUtils.class);
        monitor-enter(DeviceUtils.class);     // Catch: Throwable -> L25
    L11:
        th = move-exception;
        throw th;     // Catch: Throwable -> L25
    L8:
        if (f11151a == false) goto L43;
    L14:
        boolean r5 = f11152b;     // Catch: Throwable -> L11
        monitor-exit(DeviceUtils.class);     // Catch: Throwable -> L25
        if (r5 == true) goto L21;
        monitor-exit(DeviceUtils.class);
        return null;
    L21:
        if (f == false) goto L45;
        Typeface r10 = e;     // Catch: Throwable -> L25
        monitor-exit(DeviceUtils.class);
        return r10;
    L45:
        TextPaint r11 = new TextView(LynxEnv.inst().getAppContext()).getPaint();     // Catch: Throwable -> L25 Exception -> L31
        if (r11 == null) goto L32;
        e = r11.getTypeface();     // Catch: Throwable -> L25 Exception -> L31
    L32:
        f = true;     // Catch: Throwable -> L25
        Typeface r12 = e;     // Catch: Throwable -> L25
        monitor-exit(DeviceUtils.class);
        return r12;
    L31:
        LynxLog.b(4, LynxMonitorService.DEFAULT_PID, "get default typeface failed");     // Catch: Throwable -> L25
        goto L32
    L43:
        Class.forName("miui.os.Build");     // Catch: Throwable -> L11 Exception -> L39
        f11152b = true;     // Catch: Throwable -> L11 Exception -> L39
    L13:
        f11151a = true;     // Catch: Throwable -> L11
    L25:
        th = move-exception;
        throw th;
    }

    @CalledByNative
    public static boolean is64BitDevice() {
        if (f11153c != (-1)) goto L24;
        if (d == null) goto L27;
    L22:
        f11153c = d.contains("64") ? 1 : 0;
        goto L24
    L27:
        StringBuilder r5 = new StringBuilder();     // Catch: Exception -> L21
        if (Build.SUPPORTED_ABIS.length <= 0) goto L15;
        int r10 = 0;
    L9:
        String[] r11 = Build.SUPPORTED_ABIS;     // Catch: Exception -> L21
        if (r10 >= r11.length) goto L17;
        r5.append(r11[r10]);     // Catch: Exception -> L21
        if (r10 == (r11.length - 1)) goto L14;
        r5.append(", ");     // Catch: Exception -> L21
    L14:
        r10 = r10 + 1;     // Catch: Exception -> L21
    L17:
        if (android.text.TextUtils.isEmpty(r5.toString()) == false) goto L19;
        d = "unknown";     // Catch: Exception -> L21
    L19:
        d = r5.toString();     // Catch: Exception -> L21
        goto L22
    L15:
        r5 = new StringBuilder(Build.CPU_ABI);     // Catch: Exception -> L21
    L21:
        LynxLog.b(4, "DeviceUtils", "Lynx get unknown CPU ABIs");
        d = "unknown";
    L24:
        if (f11153c == 1) goto L26;
        return false;
    L26:
        return true;
    }
}
