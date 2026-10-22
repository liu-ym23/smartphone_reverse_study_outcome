package com.bytedance.android.live.recharge.util;

import com.bytedance.live.kmp.core.KmpEnv;
import com.bytedance.tools.kcp.ultrasettings.runtime.UltraSettingsManager;
import kotlin.jvm.internal.PropertyReference0Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.properties.ReadOnlyProperty;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class e {
    public static final /* synthetic */ KProperty[] a = null;
    public static final ReadOnlyProperty b = null;
    public static final ReadOnlyProperty c = null;
    public static final ReadOnlyProperty d = null;
    public static final ReadOnlyProperty e = null;

    static {
        KProperty[] r0 = {Reflection.property0(new PropertyReference0Impl(e.class, "LIVE_CASH_EXCHANGE_NEW_STYLE", "getLIVE_CASH_EXCHANGE_NEW_STYLE()Z", 1)), Reflection.property0(new PropertyReference0Impl(e.class, "LIVE_CASH_EXCHANGE_REBATE_TYPE", "getLIVE_CASH_EXCHANGE_REBATE_TYPE()I", 1)), Reflection.property0(new PropertyReference0Impl(e.class, "LIVE_TRIAL_DIAMOND_EXCHANGE", "getLIVE_TRIAL_DIAMOND_EXCHANGE()I", 1)), Reflection.property0(new PropertyReference0Impl(e.class, "LIVE_LITE_WEALTH_SCHEME", "getLIVE_LITE_WEALTH_SCHEME()Ljava/lang/String;", 1))};
        a = r0;
        com.bytedance.tools.kcp.ultrasettings.runtime.a r1 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_cash_exchange_new_style", Boolean.FALSE, Boolean.TYPE, false);
        b = UltraSettingsManager.a().a(r1.a, r1.b, r1.getType(), r1.d, r0[0]);
        Class r7 = Integer.TYPE;
        com.bytedance.tools.kcp.ultrasettings.runtime.a r2 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_redeem_rebate_type", 0, r7, false);
        c = UltraSettingsManager.a().a(r2.a, r2.b, r2.getType(), r2.d, r0[1]);
        KmpEnv r5 = KmpEnv.a;
        com.bytedance.tools.kcp.ultrasettings.runtime.a r3 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_trial_diamond_exchange", Integer.valueOf(KmpEnv.b() ? 1 : 0), r7, false);
        d = UltraSettingsManager.a().a(r3.a, r3.b, r3.getType(), r3.d, r0[2]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r4 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_lite_wealth_scheme", "sslocal://webcast_lynxview?url=https%3A%2F%2Flf-webcast-sourcecdn-tos.bytegecko.com%2Fobj%2Fbyte-gurd-source%2Fwebcast%2Fmono%2Flynx%2Frevenue_exchange_douyin%2Fpages%2Fasset_panel%2Ftemplate.js%3FenterFrom%3Dgift_entrance&initialProps=%5B%22setting%3Alive_incentive_box_with_anniex%3Alive_incentive_box_can_click%22%5D", String.class, false);
        e = UltraSettingsManager.a().a(r4.a, r4.b, r4.getType(), r4.d, r0[3]);
    }

    public static final int a() {
        return ((Number) d.getValue(null, a[2])).intValue();
    }
}
