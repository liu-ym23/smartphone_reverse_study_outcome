package com.bytedance.ai.utils;

import android.content.Context;
import android.content.res.Resources;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class o {
    public static final /* synthetic */ int a = 0;

    static {
    }

    @JvmStatic
    public static final int a(float r10) {
        Resources r0 = Resources.getSystem();
        return (int) ((r10 * WindowDisplayMetricsOverride.apply(r0, r0.getDisplayMetrics()).density) + 0.5f);
    }

    public static int c(Number r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        float r11 = r10.floatValue();
        Resources r0 = Resources.getSystem();
        return (int) ((r11 * WindowDisplayMetricsOverride.apply(r0, r0.getDisplayMetrics()).density) + 0.5f);
    }

    public static int b(Context r10, double r11) {
        Intrinsics.checkNotNullParameter(r10, "context");
        if (r10.getResources() == null) goto L8;
        Resources r0 = r10.getResources();
        if (WindowDisplayMetricsOverride.apply(r0, r0.getDisplayMetrics()) == null) goto L10;
        Resources r12 = r10.getResources();
        return (int) ((r11 * ((double) WindowDisplayMetricsOverride.apply(r12, r12.getDisplayMetrics()).density)) + ((double) 0.5f));
    L10:
        return 0;
    L8:
        return 0;
    }

    public static int d(double r10, Context r11) {
        Intrinsics.checkNotNullParameter(r11, "context");
        Resources r12 = r11.getResources();
        return (int) ((r10 / ((double) WindowDisplayMetricsOverride.apply(r12, r12.getDisplayMetrics()).density)) + ((double) 0.5f));
    }
}
