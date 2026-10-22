package com.bytedance.android.live.incentive.exchange;

import com.bytedance.tools.kcp.ultrasettings.runtime.UltraSettingsManager;
import kotlin.jvm.internal.PropertyReference0Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.properties.ReadOnlyProperty;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class b {
    public static final /* synthetic */ KProperty[] a = null;
    public static final ReadOnlyProperty b = null;
    public static final ReadOnlyProperty c = null;
    public static final ReadOnlyProperty d = null;
    public static final ReadOnlyProperty e = null;

    static {
        KProperty[] r0 = {Reflection.property0(new PropertyReference0Impl(b.class, "LIVE_INCENTIVE_INCOME_EXCHANGE_UI_STYLE", "getLIVE_INCENTIVE_INCOME_EXCHANGE_UI_STYLE()I", 1)), Reflection.property0(new PropertyReference0Impl(b.class, "LIVE_INCENTIVE_INCOME_EXCHANGE_PANEL_SCHEME", "getLIVE_INCENTIVE_INCOME_EXCHANGE_PANEL_SCHEME()Ljava/lang/String;", 1)), Reflection.property0(new PropertyReference0Impl(b.class, "LIVE_INCENTIVE_INCOME_EXCHANGE_TAX_SAVING", "getLIVE_INCENTIVE_INCOME_EXCHANGE_TAX_SAVING()I", 1)), Reflection.property0(new PropertyReference0Impl(b.class, "LIVE_GIFT_PANEL_NEW_STRUCTURE", "getLIVE_GIFT_PANEL_NEW_STRUCTURE()Lcom/bytedance/android/live/incentive/exchange/NewArchitectureGiftPanelConfig;", 1))};
        a = r0;
        Class r7 = Integer.TYPE;
        com.bytedance.tools.kcp.ultrasettings.runtime.a r1 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_incentive_income_exchange_ui_style", 0, r7, false);
        b = UltraSettingsManager.a().a(r1.a, r1.b, r1.getType(), r1.d, r0[0]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r2 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_incentive_income_exchange_panel_scheme", "sslocal://webcast_lynxview?url=https%3A%2F%2Flf-webcast-sourcecdn-tos.bytegecko.com%2Fobj%2Fbyte-gurd-source%2Fwebcast%2Fmono%2Flynx%2Frevenue_exchange_douyin%2Fpages%2Fexchange_panel%2Ftemplate.js&type=popup&height_percent=55&width_percent=100&gravity=bottom&enable_latch=1", String.class, false);
        c = UltraSettingsManager.a().a(r2.a, r2.b, r2.getType(), r2.d, r0[1]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r3 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_incentive_income_exchange_tax_saving", 0, r7, false);
        d = UltraSettingsManager.a().a(r3.a, r3.b, r3.getType(), r3.d, r0[2]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r4 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_gift_panel_new_architecture", new k(), k.class, false);
        e = UltraSettingsManager.a().a(r4.a, r4.b, r4.getType(), r4.d, r0[3]);
    }
}
