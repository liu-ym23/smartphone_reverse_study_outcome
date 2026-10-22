package com.bytedance.android.anniex.base.depend;

import kotlin.Lazy;
import kotlin.LazyKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class AnnieXRuntime {
    public static final Lazy a = null;
    public static final Lazy b = null;
    public static final Lazy c = null;
    public static final Lazy d = null;

    static {
        a = LazyKt.lazy(AnnieXRuntime$hostDepend$2.INSTANCE);
        b = LazyKt.lazy(AnnieXRuntime$salamanderDepend$2.INSTANCE);
        c = LazyKt.lazy(AnnieXRuntime$applicationDepend$2.INSTANCE);
        d = LazyKt.lazy(AnnieXRuntime$deviceDepend$2.INSTANCE);
    }

    public static ApplicationDepend a() {
        return (ApplicationDepend) c.getValue();
    }

    public static DeviceDepend b() {
        return (DeviceDepend) d.getValue();
    }
}
