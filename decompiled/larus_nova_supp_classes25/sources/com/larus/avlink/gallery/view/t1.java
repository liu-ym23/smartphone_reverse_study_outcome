package com.larus.avlink.gallery.view;

import android.content.Context;
import android.content.res.Resources;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class t1 {
    public static final float a(Context r1, float r2) {
        Resources r3 = r1.getResources();
        return r2 * WindowDisplayMetricsOverride.apply(r3, r3.getDisplayMetrics()).density;
    }
}
