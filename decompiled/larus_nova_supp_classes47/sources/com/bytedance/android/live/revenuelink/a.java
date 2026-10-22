package com.bytedance.android.live.revenuelink;

import com.bytedance.tools.kcp.ultrasettings.runtime.UltraSettingsManager;
import kotlin.jvm.internal.PropertyReference0Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.properties.ReadOnlyProperty;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class a {
    public static final /* synthetic */ KProperty[] a = null;
    public static final ReadOnlyProperty b = null;

    static {
        KProperty[] r1 = {Reflection.property0(new PropertyReference0Impl(a.class, "LIVE_ENABLE_NEW_GAME_RECORD_LINK", "getLIVE_ENABLE_NEW_GAME_RECORD_LINK()Z", 1))};
        a = r1;
        com.bytedance.tools.kcp.ultrasettings.runtime.a r0 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_revenue_screen_cast_link_opt", Boolean.FALSE, Boolean.TYPE, false);
        b = UltraSettingsManager.a().a(r0.a, r0.b, r0.getType(), r0.d, r1[0]);
    }
}
