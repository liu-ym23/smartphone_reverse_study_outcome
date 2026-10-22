package com.bytedance.android.live.revenue.common;

import android.content.res.Resources;
import com.bytedance.android.livehostapi.TTMiddlewareLiveSDK;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class i {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static float a(float r2) {
        Resources r0 = TTMiddlewareLiveSDK.getContext().getApplicationContext().getResources();
        return (r2 * WindowDisplayMetricsOverride.apply(r0, r0.getDisplayMetrics()).density) + 0.5f;
    }

    public static int b(int r0) {
        return (int) a(r0);
    }
}
