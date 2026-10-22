package com.obric.flow.cardlistpage.util;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.hardware.display.DisplayManager;
import android.util.DisplayMetrics;
import android.util.DisplayUtils;
import android.view.Display;
import android.view.DisplayInfo;
import kotlin.jvm.internal.Intrinsics;
import obric.flow.app.FlowApplication;

/* JADX INFO: loaded from: classes3.dex */
public abstract class b {
    public static final float a(DisplayInfo r5) {
        Display.Mode r10 = DisplayUtils.getMaximumResolutionDisplayMode(r5.supportedModes);
        float r11 = DisplayUtils.getPhysicalPixelDisplaySizeRatio(r10.getPhysicalWidth(), r10.getPhysicalHeight(), r5.getNaturalWidth(), r5.getNaturalHeight());
        if (r11 != Float.POSITIVE_INFINITY) goto L6;
        return 1.0f;
    L6:
        return r11;
    }

    public static final int b(Context r5) {
        DisplayInfo r10 = new DisplayInfo();     // Catch: Exception -> L5
        r5.getDisplay().getDisplayInfo(r10);     // Catch: Exception -> L5
        return (int) (a(r10) * DisplayMetrics.DENSITY_DEVICE_STABLE);
    L5:
        e = move-exception;
        ju.a.f18481a.w("DensityUtils", "getTargetDensity fail:" + e);
        return c(r5);
    }

    public static final int c(Context r5) {
        DisplayInfo r10 = new DisplayInfo();     // Catch: Exception -> L8
        Object r11 = r5.getSystemService("display");     // Catch: Exception -> L8
        Intrinsics.checkNotNull(r11, "null cannot be cast to non-null type android.hardware.display.DisplayManager");     // Catch: Exception -> L8
        Display r12 = ((DisplayManager) r11).getDisplay(0);     // Catch: Exception -> L8
        if (r12 == null) goto L10;
        r12.getDisplayInfo(r10);     // Catch: Exception -> L8
        return (int) (a(r10) * DisplayMetrics.DENSITY_DEVICE_STABLE);
    L10:
        return 560;
    L8:
        e = move-exception;
        ju.a.f18481a.e("DensityUtils", "getTargetDensityFallBack fail", e);
        return 560;
    }

    public static final void d(Context r10, String r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "desc");
        int r5 = b(r10);
        DisplayMetrics r12 = r10.getResources().getDisplayMetrics();
        Configuration r13 = r10.getResources().getConfiguration();
        float r14 = r5 / 160.0f;
        if (r12 == null) goto L6;
        r12.density = r14;
    L6:
        if (r12 == null) goto L9;
        r12.densityDpi = r5;
    L9:
        r13.densityDpi = r5;
        r13.screenWidthDp = 361;
        r13.screenHeightDp = 746;
        r13.smallestScreenWidthDp = 361;
        FlowApplication r15 = obric.flow.a.f20424a;
        if (r15 != null) goto L13;
        Intrinsics.throwUninitializedPropertyAccessException("instance");
        r15 = null;
    L13:
        DisplayMetrics r16 = r15.getResources().getDisplayMetrics();
        if (r16 == null) goto L16;
        r16.density = r14;
        r16.densityDpi = r5;
        r16.scaledDensity = r14;
    L16:
        DisplayMetrics r17 = Resources.getSystem().getDisplayMetrics();
        if (r17 == null) goto L19;
        r17.density = r14;
        r17.densityDpi = r5;
        r17.scaledDensity = r14;
    L19:
        r10.getResources().updateConfiguration(r13, r12);
        if (Intrinsics.areEqual(r11, "contextWrapperForWidgetDensityChange") == false) goto L23;
        r13.fontScale = 1.0f;
        r10.getResources().updateConfiguration(r13, r12);
        return;
    }
}
