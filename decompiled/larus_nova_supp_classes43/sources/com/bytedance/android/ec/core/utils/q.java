package com.bytedance.android.ec.core.utils;

import android.content.res.Resources;
import android.util.TypedValue;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class q {
    public static final float a(Number r10) {
        Intrinsics.checkNotNullParameter(r10, "$this$dpFloat");
        float r11 = r10.floatValue();
        Resources r0 = uf4.a.a().getResources();
        return TypedValue.applyDimension(1, r11, WindowDisplayMetricsOverride.apply(r0, r0.getDisplayMetrics()));
    }

    public static final float b(Number r10) {
        Intrinsics.checkNotNullParameter(r10, "$this$spFloat");
        float r11 = r10.floatValue();
        Resources r0 = uf4.a.a().getResources();
        return TypedValue.applyDimension(2, r11, WindowDisplayMetricsOverride.apply(r0, r0.getDisplayMetrics()));
    }
}
