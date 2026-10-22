package com.lynx.tasm.utils;

import android.app.Activity;
import android.content.Context;
import android.graphics.Typeface;
import android.hardware.display.DisplayManager;
import android.os.Build;
import android.text.TextPaint;
import android.view.Display;
import android.widget.TextView;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import com.lynx.tasm.LynxEnv;
import com.lynx.tasm.base.LLog;
import java.util.concurrent.ConcurrentHashMap;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public class DeviceUtils {
    public static boolean a = false;
    public static boolean b = false;
    public static int c = -1;
    public static String d;
    public static Typeface e;
    public static boolean f;

    public DeviceUtils() {
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class a() throws ClassNotFoundException {
        ConcurrentHashMap r0 = FastClassNotFoundHandler.a;
        FastClassNotFoundHandler.Status r1 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (el9.a.a() == true) goto L34;
        Class<?> r2 = Class.forName("miui.os.Build");     // Catch: Throwable -> L8
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L7;
        FastClassNotFoundHandler.a("miui.os.Build");     // Catch: Throwable -> L8
    L7:
        return r2;
    L8:
        th = move-exception;
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L12;
        FastClassNotFoundHandler.b("miui.os.Build");
    L12:
        throw th;
    L34:
        Class<?> r3 = Class.forName("miui.os.Build");     // Catch: Throwable -> L17
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L16;
        FastClassNotFoundHandler.a("miui.os.Build");     // Catch: Throwable -> L17
    L16:
        return r3;
    L17:
        th = move-exception;
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L22;
        FastClassNotFoundHandler.b("miui.os.Build");
    L22:
        if ((th instanceof PluginClassNotFoundException) == false) goto L24;
        throw th;
    L24:
        if ((th instanceof ClassNotFoundException) == true) goto L30;
        if ((th instanceof NoClassDefFoundError) == true) goto L30;
        throw th;
    L30:
        return MiraPluginFix.forName("miui.os.Build");
    }

    public static synchronized Typeface b() {
        monitor-enter(DeviceUtils.class);
    L22:
        th = move-exception;
        throw th;
    L5:
        if (d() == true) goto L10;
        monitor-exit(DeviceUtils.class);
        return null;
    L10:
        if (f == false) goto L25;
        Typeface r1 = e;     // Catch: Throwable -> L22
        monitor-exit(DeviceUtils.class);
        return r1;
    L25:
        TextPaint r2 = new TextView(LynxEnv.inst().getAppContext()).getPaint();     // Catch: Exception -> L18 Throwable -> L22
        if (r2 == null) goto L19;
        e = r2.getTypeface();     // Catch: Exception -> L18 Throwable -> L22
    L19:
        f = true;     // Catch: Throwable -> L22
        Typeface r3 = e;     // Catch: Throwable -> L22
        monitor-exit(DeviceUtils.class);
        return r3;
    L18:
        LLog.e("Lynx", "get default typeface failed");     // Catch: Throwable -> L22
        goto L19
    }

    public static synchronized boolean d() {
        monitor-enter(DeviceUtils.class);
    L14:
        th = move-exception;
        throw th;
    L5:
        if (a == false) goto L18;
    L11:
        boolean r1 = b;     // Catch: Throwable -> L14
        monitor-exit(DeviceUtils.class);
        return r1;
    L18:
        if (a() == null) goto L10;
        b = true;     // Catch: Exception -> L17 Throwable -> L14
    L10:
        a = true;     // Catch: Throwable -> L14
        goto L11
    }

    public static boolean is64BitDevice() {
        if (c != (-1)) goto L24;
        if (d == null) goto L27;
    L22:
        c = d.contains("64") ? 1 : 0;
        goto L24
    L27:
        StringBuilder r3 = new StringBuilder();     // Catch: Exception -> L21
        if (Build.SUPPORTED_ABIS.length <= 0) goto L15;
        int r4 = 0;
    L9:
        String[] r5 = Build.SUPPORTED_ABIS;     // Catch: Exception -> L21
        if (r4 >= r5.length) goto L17;
        r3.append(r5[r4]);     // Catch: Exception -> L21
        if (r4 == (r5.length - 1)) goto L14;
        r3.append(", ");     // Catch: Exception -> L21
    L14:
        r4 = r4 + 1;     // Catch: Exception -> L21
    L17:
        if (android.text.TextUtils.isEmpty(r3.toString()) == false) goto L19;
        d = "unknown";     // Catch: Exception -> L21
    L19:
        d = r3.toString();     // Catch: Exception -> L21
        goto L22
    L15:
        r3 = new StringBuilder(Build.CPU_ABI);     // Catch: Exception -> L21
    L21:
        LLog.e("DeviceUtils", "Lynx get unknown CPU ABIs");
        d = "unknown";
    L24:
        if (c != 1) goto L32;
        return true;
    L32:
        return false;
    }

    public static float c(Context r3) {
        Display r2 = null;
        if (Build.VERSION.SDK_INT < 23) goto L7;
        DisplayManager r4 = (DisplayManager) r3.getSystemService(DisplayManager.class);
        if (r4 == null) goto L10;
        r2 = r4.getDisplay(0);
    L10:
        if (r2 != null) goto L12;
        return 60.0f;
    L12:
        return r2.getRefreshRate();
    L7:
        Activity r5 = a.getActivity(r3);
        if (r5 == null) goto L10;
        r2 = r5.getWindowManager().getDefaultDisplay();
        goto L10
    }
}
