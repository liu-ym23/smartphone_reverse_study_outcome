package com.obric.assistant.common.utils;

import android.content.res.Resources;
import com.larus.common.apphost.AppHost;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class f {
    public static final int a(int r2) {
        Resources r0 = AppHost.a.getApplication().getResources();
        return (int) ((r2 * WindowDisplayMetricsOverride.apply(r0, r0.getDisplayMetrics()).density) + 0.5f);
    }
}
