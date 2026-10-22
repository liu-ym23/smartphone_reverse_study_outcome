package com.bytedance.android.livesdk.gift.platform.business.effect.service.feed;

import com.bytedance.tools.kcp.ultrasettings.runtime.UltraSettingsManager;
import kotlin.jvm.internal.PropertyReference0Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.properties.ReadOnlyProperty;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class g {
    public static final /* synthetic */ KProperty[] a = null;
    public static final ReadOnlyProperty b = null;
    public static final ReadOnlyProperty c = null;
    public static final ReadOnlyProperty d = null;
    public static final ReadOnlyProperty e = null;
    public static final ReadOnlyProperty f = null;

    static {
        KProperty[] r0 = {Reflection.property0(new PropertyReference0Impl(g.class, "LIVE_REVENUE_GAME_EFFECT_SERVICE_URL", "getLIVE_REVENUE_GAME_EFFECT_SERVICE_URL()Ljava/lang/String;", 1)), Reflection.property0(new PropertyReference0Impl(g.class, "LIVE_REVENUE_EFFECT_SERVICE_DELAY_TIME", "getLIVE_REVENUE_EFFECT_SERVICE_DELAY_TIME()J", 1)), Reflection.property0(new PropertyReference0Impl(g.class, "LIVE_REVENUE_EFFECT_GAME_SERVICE_ENABLE", "getLIVE_REVENUE_EFFECT_GAME_SERVICE_ENABLE()Z", 1)), Reflection.property0(new PropertyReference0Impl(g.class, "LIVE_REVENUE_EFFECT_GAME_SERVICE_FALLBACK", "getLIVE_REVENUE_EFFECT_GAME_SERVICE_FALLBACK()Z", 1)), Reflection.property0(new PropertyReference0Impl(g.class, "LIVE_REVENUE_EFFECT_GAME_SERVICE_ENABLE_LAYOUT_CHANGE_EVENT", "getLIVE_REVENUE_EFFECT_GAME_SERVICE_ENABLE_LAYOUT_CHANGE_EVENT()Z", 1))};
        a = r0;
        com.bytedance.tools.kcp.ultrasettings.runtime.a r1 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_revenue_preview_effect_service_url", "sslocal://webcast_lynxview?url=https%3A%2F%2Flf-webcast-gr-sourcecdn.bytegecko.com%2Fobj%2Fbyte-gurd-source-gr%2Fwebcast%2Fmono%2Flynx%2Ftemplate_douyin%2Fpages%2Feffect_service_load_page%2Ftemplate.js&preview=1", String.class, false);
        b = UltraSettingsManager.a().a(r1.a, r1.b, r1.getType(), r1.d, r0[0]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r2 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_revenue_effect_revenue_service_delay_time", 200L, Long.TYPE, false);
        c = UltraSettingsManager.a().a(r2.a, r2.b, r2.getType(), r2.d, r0[1]);
        Boolean r5 = Boolean.TRUE;
        Class r7 = Boolean.TYPE;
        com.bytedance.tools.kcp.ultrasettings.runtime.a r3 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_revenue_effect_game_service_enable", r5, r7, false);
        d = UltraSettingsManager.a().a(r3.a, r3.b, r3.getType(), r3.d, r0[2]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r4 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_revenue_effect_game_service_fallback", Boolean.FALSE, r7, false);
        e = UltraSettingsManager.a().a(r4.a, r4.b, r4.getType(), r4.d, r0[3]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r6 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_revenue_effect_game_service_enable_layout_change_event", r5, r7, false);
        f = UltraSettingsManager.a().a(r6.a, r6.b, r6.getType(), r6.d, r0[4]);
    }
}
