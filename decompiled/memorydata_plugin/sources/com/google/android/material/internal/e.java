package com.google.android.material.internal;

import android.R;
import android.content.Context;
import android.os.Build;
import android.view.Window;
import androidx.core.graphics.ColorUtils;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowCompat;
import androidx.core.view.WindowInsetsControllerCompat;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes2.dex */
public class e {
    private static int a(Context r4, boolean r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.memorydata.plugin");
        if (r5 == true) goto L5;
    L8:
        if (r5 == false) goto L12;
        return 0;
    L12:
        return com.google.android.material.c.a.a(r6, R.attr.statusBarColor, ViewCompat.MEASURED_STATE_MASK);
    L5:
        if (Build.VERSION.SDK_INT >= 23) goto L8;
        return ColorUtils.setAlphaComponent(com.google.android.material.c.a.a(r6, R.attr.statusBarColor, ViewCompat.MEASURED_STATE_MASK), 128);
    }

    public static void a(Window r6, boolean r7, Integer r8, Integer r9) {
        if (Build.VERSION.SDK_INT >= 21) goto L5;
        return;
    L5:
        boolean r0 = false;
        if (r8 != null) goto L8;
    L11:
        boolean r2 = true;
    L12:
        if (r9 != null) goto L14;
    L15:
        r0 = true;
    L17:
        if (r2 == true) goto L19;
        if (r0 == true) goto L19;
    L24:
        WindowCompat.setDecorFitsSystemWindows(r6, !r7);
        int r1 = a((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r6.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), r7);
        int r10 = b((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r6.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), r7);
        r6.setStatusBarColor(r1);
        r6.setNavigationBarColor(r10);
        boolean r11 = a(r1, com.google.android.material.c.a.a(r8.intValue()));
        boolean r12 = a(r10, com.google.android.material.c.a.a(r9.intValue()));
        WindowInsetsControllerCompat r13 = WindowCompat.getInsetsController(r6, r6.getDecorView());
        if (r13 == null) goto L28;
        r13.setAppearanceLightStatusBars(r11);
        r13.setAppearanceLightNavigationBars(r12);
        return;
    L28:
        return;
    L19:
        int r3 = com.google.android.material.c.a.a((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r6.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), R.attr.colorBackground, ViewCompat.MEASURED_STATE_MASK);
        if (r2 == false) goto L22;
        r8 = Integer.valueOf(r3);
    L22:
        if (r0 == false) goto L24;
        r9 = Integer.valueOf(r3);
        goto L24
    L14:
        if (r9.intValue() != 0) goto L17;
    L8:
        if (r8.intValue() == 0) goto L11;
        r2 = false;
        goto L12
    }

    private static boolean a(int r1, boolean r2) {
        if (com.google.android.material.c.a.a(r1) == true) goto L8;
        if (r1 != 0) goto L7;
        if (r2 == true) goto L8;
    L7:
        return false;
    L8:
        return true;
    }

    private static int b(Context r4, boolean r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.memorydata.plugin");
        if (r5 == true) goto L5;
    L8:
        if (r5 == false) goto L12;
        return 0;
    L12:
        return com.google.android.material.c.a.a(r6, R.attr.navigationBarColor, ViewCompat.MEASURED_STATE_MASK);
    L5:
        if (Build.VERSION.SDK_INT >= 27) goto L8;
        return ColorUtils.setAlphaComponent(com.google.android.material.c.a.a(r6, R.attr.navigationBarColor, ViewCompat.MEASURED_STATE_MASK), 128);
    }
}
