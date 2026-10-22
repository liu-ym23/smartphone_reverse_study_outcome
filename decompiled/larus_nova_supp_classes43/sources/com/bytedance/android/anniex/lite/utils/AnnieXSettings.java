package com.bytedance.android.anniex.lite.utils;

import kotlin.Lazy;
import kotlin.LazyKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class AnnieXSettings {
    public static final Lazy a = null;
    public static final Lazy b = null;

    public AnnieXSettings() {
    }

    static {
        a = LazyKt.lazy(AnnieXSettings$optimizeBulletInit$2.INSTANCE);
        b = LazyKt.lazy(AnnieXSettings$optimizeWebcastInit$2.INSTANCE);
    }

    public static boolean a() {
        return ((Boolean) a.getValue()).booleanValue();
    }
}
