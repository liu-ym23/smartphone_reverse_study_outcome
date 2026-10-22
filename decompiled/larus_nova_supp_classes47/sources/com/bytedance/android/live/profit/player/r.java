package com.bytedance.android.live.profit.player;

import com.bytedance.tools.kcp.ultrasettings.runtime.UltraSettingsManager;
import kotlin.jvm.internal.PropertyReference0Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.properties.ReadOnlyProperty;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class r {
    public static final /* synthetic */ KProperty[] a = null;
    public static final ReadOnlyProperty b = null;
    public static final ReadOnlyProperty c = null;
    public static final ReadOnlyProperty d = null;
    public static final ReadOnlyProperty e = null;

    static {
        KProperty[] r0 = {Reflection.property0(new PropertyReference0Impl(r.class, "PlayerLynxSchema", "getPlayerLynxSchema()Ljava/lang/String;", 1)), Reflection.property0(new PropertyReference0Impl(r.class, "PlayerDestroyDelay", "getPlayerDestroyDelay()J", 1)), Reflection.property0(new PropertyReference0Impl(r.class, "LIVE_LYNX_ALPHA_PLAYER_USE_ANNIEX", "getLIVE_LYNX_ALPHA_PLAYER_USE_ANNIEX()Z", 1)), Reflection.property0(new PropertyReference0Impl(r.class, "LIVE_LYNX_CANVAS_TT_PLAYER_ENABLE", "getLIVE_LYNX_CANVAS_TT_PLAYER_ENABLE()Z", 1))};
        a = r0;
        com.bytedance.tools.kcp.ultrasettings.runtime.a r1 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_lynx_alphaplayer_schema", "", String.class, false);
        b = UltraSettingsManager.a().a(r1.a, r1.b, r1.getType(), r1.d, r0[0]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r2 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_lynx_alphaplayer_destroy_delay", 0L, Long.TYPE, false);
        c = UltraSettingsManager.a().a(r2.a, r2.b, r2.getType(), r2.d, r0[1]);
        Boolean r5 = Boolean.FALSE;
        Class r6 = Boolean.TYPE;
        com.bytedance.tools.kcp.ultrasettings.runtime.a r3 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_lynx_alpha_player_use_anniex", r5, r6, false);
        d = UltraSettingsManager.a().a(r3.a, r3.b, r3.getType(), r3.d, r0[2]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r4 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_lynx_canvas_tt_player_enable", r5, r6, false);
        e = UltraSettingsManager.a().a(r4.a, r4.b, r4.getType(), r4.d, r0[3]);
    }

    public static final long a() {
        return ((Number) c.getValue(null, a[1])).longValue();
    }
}
