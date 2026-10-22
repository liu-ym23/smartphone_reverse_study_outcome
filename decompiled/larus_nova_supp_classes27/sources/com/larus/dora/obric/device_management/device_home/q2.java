package com.larus.dora.obric.device_management.device_home;

import android.content.Context;
import android.content.res.Resources;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class q2 {
    public static final int a(int r1, Context r2) {
        Resources r3 = r2.getResources();
        return (int) ((r1 * WindowDisplayMetricsOverride.apply(r3, r3.getDisplayMetrics()).density) + 0.5f);
    }
}
