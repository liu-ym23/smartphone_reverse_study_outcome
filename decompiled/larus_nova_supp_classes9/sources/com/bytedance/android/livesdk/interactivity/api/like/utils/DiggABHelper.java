package com.bytedance.android.livesdk.interactivity.api.like.utils;

import com.bytedance.android.livesdk.config.mn;
import kotlin.Lazy;
import r52.z0;
import ss1.c;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class DiggABHelper {
    public static final boolean a = false;
    public static final Lazy b = null;
    public static final Lazy c = null;
    public static final Lazy d = null;
    public static final int e = 0;

    public static c a() {
        return (c) b.getValue();
    }

    static {
        a = ((Boolean) mn.a.getValue()).booleanValue();
        b = com.bytedance.android.livesdk.interactivity.api.base.utils.a.a(DiggABHelper$diggAnimOptConfig$2.INSTANCE);
        c = com.bytedance.android.livesdk.interactivity.api.base.utils.a.a(DiggABHelper$diggHideConfig$2.INSTANCE);
        d = com.bytedance.android.livesdk.interactivity.api.base.utils.a.a(DiggABHelper$performanceOpt$2.INSTANCE);
        e = ((Integer) z0.a.getValue()).intValue();
    }
}
