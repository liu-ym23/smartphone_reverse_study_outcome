package com.bytedance.android.anniex.utils;

import android.content.res.Resources;
import android.util.TypedValue;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class j {
    public static final int a(int r10) {
        Resources r0 = Resources.getSystem();
        return (int) TypedValue.applyDimension(1, r10, WindowDisplayMetricsOverride.apply(r0, r0.getDisplayMetrics()));
    }

    public static final int b(float r10) {
        Resources r0 = Resources.getSystem();
        return (int) ((r10 / WindowDisplayMetricsOverride.apply(r0, r0.getDisplayMetrics()).density) + 0.5f);
    }
}
