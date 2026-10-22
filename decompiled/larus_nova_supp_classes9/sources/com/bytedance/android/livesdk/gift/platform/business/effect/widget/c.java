package com.bytedance.android.livesdk.gift.platform.business.effect.widget;

import com.bytedance.tools.kcp.ultrasettings.runtime.UltraSettingsManager;
import kotlin.jvm.internal.PropertyReference0Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.properties.ReadOnlyProperty;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class c {
    public static final /* synthetic */ KProperty[] a = null;
    public static final ReadOnlyProperty b = null;
    public static final ReadOnlyProperty c = null;

    static {
        KProperty[] r0 = {Reflection.property0(new PropertyReference0Impl(c.class, "LIVE_GIFT_LYNX_EFFECT_CONTAINER_USE_ANNIEX", "getLIVE_GIFT_LYNX_EFFECT_CONTAINER_USE_ANNIEX()Z", 1)), Reflection.property0(new PropertyReference0Impl(c.class, "LIVE_GIFT_LYNX_EFFECT_CONTAINER_LOAD_AMAZING", "getLIVE_GIFT_LYNX_EFFECT_CONTAINER_LOAD_AMAZING()Z", 1))};
        a = r0;
        Boolean r3 = Boolean.TRUE;
        Class r4 = Boolean.TYPE;
        com.bytedance.tools.kcp.ultrasettings.runtime.a r1 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_gift_lynx_effect_container_use_anniex", r3, r4, false);
        b = UltraSettingsManager.a().a(r1.a, r1.b, r1.getType(), r1.d, r0[0]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r2 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_gift_lynx_effect_container_load_amazing", r3, r4, false);
        c = UltraSettingsManager.a().a(r2.a, r2.b, r2.getType(), r2.d, r0[1]);
    }

    public static final boolean a() {
        return ((Boolean) b.getValue(null, a[0])).booleanValue();
    }
}
