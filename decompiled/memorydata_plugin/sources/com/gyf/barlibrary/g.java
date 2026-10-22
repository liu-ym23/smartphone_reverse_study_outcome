package com.gyf.barlibrary;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.view.DisplayCutout;
import android.view.View;
import android.view.Window;
import android.view.WindowInsets;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes3.dex */
public class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static boolean f5134a = false;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static boolean f5135b = false;

    static {
    }

    public static boolean a(Activity r3) {
        Activity r4 = (Activity) ZeusTransformUtils.wrapperContextForParams(r3, Activity.class, "com.obric.memorydata.plugin");
        if (f5135b == true) goto L5;
        boolean r0 = false;
        if (r4 != null) goto L10;
        return false;
    L10:
        if (a(r4) == false) goto L12;
    L19:
        r0 = true;
    L20:
        f5134a = r0;
        f5135b = true;
        return r0;
    L12:
        if (b(r4) == true) goto L19;
        if (d(r4) == true) goto L19;
        if (c(r4) == true) goto L19;
        if (b(r4) == false) goto L20;
    L5:
        return f5134a;
    }

    private static boolean a(Context r7) {
        Context r8 = (Context) ZeusTransformUtils.wrapperContextForParams(r7, Context.class, "com.obric.memorydata.plugin");
        if ("Xiaomi".equals(Build.MANUFACTURER) == true) goto L12;
    L6:
        int r9 = 0;
    L7:
        if (r9 != 1) goto L10;
        return true;
    L10:
        return false;
    L12:
        Class<?> r10 = r8.getClassLoader().loadClass("android.os.SystemProperties");     // Catch: Throwable -> L11
        r9 = ((Integer) ZeusTransformUtils.preCheckCast(r10.getMethod("getInt", new Class[]{String.class, Integer.TYPE}).invoke(r10, new Object[]{"ro.miui.notch", 0}), Integer.class, "com.obric.memorydata.plugin")).intValue();     // Catch: Throwable -> L11
        goto L7
    }

    public static boolean a(View r5) {
        if (f5135b == true) goto L5;
        boolean r0 = false;
        if (r5 != null) goto L10;
        return false;
    L10:
        if (a((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r5.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")) == false) goto L12;
    L19:
        r0 = true;
    L20:
        f5134a = r0;
        f5135b = true;
        return r0;
    L12:
        if (b((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r5.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")) == true) goto L19;
        if (d((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r5.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")) == true) goto L19;
        if (c((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r5.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")) == true) goto L19;
        if (b(r5) == false) goto L20;
    L5:
        return f5134a;
    }

    private static boolean b(Activity r2) {
        if (c((Activity) ZeusTransformUtils.wrapperContextForParams(r2, Activity.class, "com.obric.memorydata.plugin")) == null) goto L5;
        return true;
    L5:
        return false;
    }

    private static boolean b(Context r4) {
        Class<?> r5 = ((Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.memorydata.plugin")).getClassLoader().loadClass("com.huawei.android.util.HwNotchSizeUtil");     // Catch: Throwable -> L5
        return ((Boolean) ZeusTransformUtils.preCheckCast(r5.getMethod("hasNotchInScreen", new Class[0]).invoke(r5, new Object[0]), Boolean.class, "com.obric.memorydata.plugin")).booleanValue();
    L8:
        return false;
    }

    private static boolean b(View r0) {
        if (c(r0) == null) goto L5;
        return true;
    L5:
        return false;
    }

    private static DisplayCutout c(Activity r3) {
        Activity r4 = (Activity) ZeusTransformUtils.wrapperContextForParams(r3, Activity.class, "com.obric.memorydata.plugin");
        if (Build.VERSION.SDK_INT < 28) goto L11;
        if (r4 == null) goto L13;
        Window r5 = ZeusTransformUtils.getWindow(r4, "com.obric.memorydata.plugin");
        if (r5 == null) goto L14;
        WindowInsets r6 = r5.getDecorView().getRootWindowInsets();
        if (r6 != null) goto L10;
        return null;
    L10:
        return r6.getDisplayCutout();
    L14:
        return null;
    L13:
        return null;
    L11:
        return null;
    }

    private static DisplayCutout c(View r2) {
        if (Build.VERSION.SDK_INT < 28) goto L9;
        if (r2 == null) goto L11;
        WindowInsets r3 = r2.getRootWindowInsets();
        if (r3 != null) goto L8;
        return null;
    L8:
        return r3.getDisplayCutout();
    L11:
        return null;
    L9:
        return null;
    }

    private static boolean c(Context r6) {
        Class<?> r7 = ((Context) ZeusTransformUtils.wrapperContextForParams(r6, Context.class, "com.obric.memorydata.plugin")).getClassLoader().loadClass("android.util.FtFeature");     // Catch: Throwable -> L5
        return ((Boolean) ZeusTransformUtils.preCheckCast(r7.getMethod("isFeatureSupport", new Class[]{Integer.TYPE}).invoke(r7, new Object[]{32}), Boolean.class, "com.obric.memorydata.plugin")).booleanValue();
    L8:
        return false;
    }

    private static boolean d(Context r2) {
        return ((Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin")).getPackageManager().hasSystemFeature("com.oppo.feature.screen.heteromorphism");
    L5:
        return false;
    }
}
