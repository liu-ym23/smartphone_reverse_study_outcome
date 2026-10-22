package com.bytedance.android.livesdk.gift.biggift;

import com.bytedance.tools.kcp.ultrasettings.runtime.UltraSettingsManager;
import kotlin.jvm.internal.PropertyReference0Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.properties.ReadOnlyProperty;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class e {
    public static final /* synthetic */ KProperty[] a = null;
    public static final ReadOnlyProperty b = null;
    public static final ReadOnlyProperty c = null;

    static {
        KProperty[] r0 = {Reflection.property0(new PropertyReference0Impl(e.class, "VS_LIVE_INTERACTIVE_CONTAINER_SHOW_TYPE", "getVS_LIVE_INTERACTIVE_CONTAINER_SHOW_TYPE()I", 1)), Reflection.property0(new PropertyReference0Impl(e.class, "SEND_GIFT_OPEN_RECHARGE_OPT", "getSEND_GIFT_OPEN_RECHARGE_OPT()Z", 1))};
        a = r0;
        com.bytedance.tools.kcp.ultrasettings.runtime.a r1 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("vs_live_interactive_container_show_type", 0, Integer.TYPE, false);
        b = UltraSettingsManager.a().a(r1.a, r1.b, r1.getType(), r1.d, r0[0]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r2 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("send_gift_open_recharge_opt", Boolean.FALSE, Boolean.TYPE, false);
        c = UltraSettingsManager.a().a(r2.a, r2.b, r2.getType(), r2.d, r0[1]);
    }
}
