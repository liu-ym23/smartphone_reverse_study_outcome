package com.bytedance.android.livesdk.gift.platform.core;

import com.bytedance.android.livesdk.config.d51;
import com.bytedance.android.livesdk.config.ti1;
import com.bytedance.android.livesdk.gift.configmodel.i2;
import com.bytedance.android.livesdk.gift.configmodel.z1;
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
    public static final int e = 0;
    public static final ReadOnlyProperty f = null;
    public static final ReadOnlyProperty g = null;
    public static final ReadOnlyProperty h = null;
    public static final ReadOnlyProperty i = null;
    public static final ReadOnlyProperty j = null;
    public static final ReadOnlyProperty k = null;
    public static final ReadOnlyProperty l = null;
    public static final ReadOnlyProperty m = null;
    public static final ReadOnlyProperty n = null;
    public static final ReadOnlyProperty o = null;
    public static final ReadOnlyProperty p = null;
    public static final ReadOnlyProperty q = null;

    public static final int a() {
        return ((Number) f.getValue(null, a[3])).intValue();
    }

    static {
        KProperty[] r0 = {Reflection.property0(new PropertyReference0Impl(g.class, "LIVE_VBOOST_OPT", "getLIVE_VBOOST_OPT()Lcom/bytedance/android/livesdk/config/VBoostConfig;", 1)), Reflection.property0(new PropertyReference0Impl(g.class, "LIVE_ANCHOR_GIFT_ANIMATION_SWITCH", "getLIVE_ANCHOR_GIFT_ANIMATION_SWITCH()Lcom/bytedance/android/livesdk/gift/configmodel/RevAnchorGiftSwitchConfig;", 1)), Reflection.property0(new PropertyReference0Impl(g.class, "LIVE_GIFT_MULTIPLE_SEND_OPTIMIZE", "getLIVE_GIFT_MULTIPLE_SEND_OPTIMIZE()I", 1)), Reflection.property0(new PropertyReference0Impl(g.class, "LIVE_ROOM_CHARGE_TYPE", "getLIVE_ROOM_CHARGE_TYPE()I", 1)), Reflection.property0(new PropertyReference0Impl(g.class, "MATCH_ROOM_TOOLBAR_CONFIG", "getMATCH_ROOM_TOOLBAR_CONFIG()Lcom/bytedance/android/livesdk/gift/configmodel/RevMatchRoomGiftToolbarConfig;", 1)), Reflection.property0(new PropertyReference0Impl(g.class, "LIVE_INCENTIVES_EXPERIMENT_ENABLE", "getLIVE_INCENTIVES_EXPERIMENT_ENABLE()Z", 1)), Reflection.property0(new PropertyReference0Impl(g.class, "LIVE_PAYMENT_PANEL_DARK_MODE", "getLIVE_PAYMENT_PANEL_DARK_MODE()I", 1)), Reflection.property0(new PropertyReference0Impl(g.class, "GIFT_MESSAGE_NEW_STRUCT", "getGIFT_MESSAGE_NEW_STRUCT()Z", 1)), Reflection.property0(new PropertyReference0Impl(g.class, "LIVE_ENABLE_SUBSCRIBE_OPEN_EFFECT", "getLIVE_ENABLE_SUBSCRIBE_OPEN_EFFECT()Z", 1)), Reflection.property0(new PropertyReference0Impl(g.class, "LIVE_CLEAR_SCREEN_OPTIMIZE_ENABLE", "getLIVE_CLEAR_SCREEN_OPTIMIZE_ENABLE()Z", 1)), Reflection.property0(new PropertyReference0Impl(g.class, "LIVE_LANDSCAPE_OPT_CONFIG", "getLIVE_LANDSCAPE_OPT_CONFIG()Lcom/bytedance/android/livesdk/config/LiveLandscapeOptConfig;", 1)), Reflection.property0(new PropertyReference0Impl(g.class, "LIVE_GROUP_COMPONENT_CLOSE_SIMPLE_MODE_BY_TYPE", "getLIVE_GROUP_COMPONENT_CLOSE_SIMPLE_MODE_BY_TYPE()Z", 1)), Reflection.property0(new PropertyReference0Impl(g.class, "LIVE_LANDSCAPE_LOG_ENABLE", "getLIVE_LANDSCAPE_LOG_ENABLE()Z", 1)), Reflection.property0(new PropertyReference0Impl(g.class, "LIVE_GROUP_CONTAINER_SUPPORT_LANDSCAPE", "getLIVE_GROUP_CONTAINER_SUPPORT_LANDSCAPE()Z", 1)), Reflection.property0(new PropertyReference0Impl(g.class, "LIVE_GIFT_ENABLE_ON_LEAVE_ROOM_MEMORY_CACHE_RELEASE", "getLIVE_GIFT_ENABLE_ON_LEAVE_ROOM_MEMORY_CACHE_RELEASE()Z", 1))};
        a = r0;
        com.bytedance.tools.kcp.ultrasettings.runtime.a r1 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_vboost_opt", new ti1(), ti1.class, false);
        b = UltraSettingsManager.a().a(r1.a, r1.b, r1.getType(), r1.d, r0[0]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r2 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_anchor_gift_animation_switch", new z1(), z1.class, false);
        c = UltraSettingsManager.a().a(r2.a, r2.b, r2.getType(), r2.d, r0[1]);
        Class r14 = Integer.TYPE;
        com.bytedance.tools.kcp.ultrasettings.runtime.a r3 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_gift_multiple_send_optimize", 7, r14, false);
        d = UltraSettingsManager.a().a(r3.a, r3.b, r3.getType(), r3.d, r0[2]);
        e = 1;
        com.bytedance.tools.kcp.ultrasettings.runtime.a r4 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_room_charge_type", 1, r14, false);
        f = UltraSettingsManager.a().a(r4.a, r4.b, r4.getType(), r4.d, r0[3]);
        i2 r5 = new i2();
        r5.a();
        com.bytedance.tools.kcp.ultrasettings.runtime.a r6 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("match_room_toolbar_config", r5, i2.class, false);
        g = UltraSettingsManager.a().a(r6.a, r6.b, r6.getType(), r6.d, r0[4]);
        Boolean r7 = Boolean.FALSE;
        Class r8 = Boolean.TYPE;
        com.bytedance.tools.kcp.ultrasettings.runtime.a r9 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_incentives_experiment_enable", r7, r8, false);
        h = UltraSettingsManager.a().a(r9.a, r9.b, r9.getType(), r9.d, r0[5]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r10 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_payment_panel_dark_mode", 0, r14, false);
        i = UltraSettingsManager.a().a(r10.a, r10.b, r10.getType(), r10.d, r0[6]);
        Boolean r11 = Boolean.TRUE;
        com.bytedance.tools.kcp.ultrasettings.runtime.a r13 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("gift_message_new_struct", r11, r8, false);
        j = UltraSettingsManager.a().a(r13.a, r13.b, r13.getType(), r13.d, r0[7]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r15 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_enable_subscribe_open_effect", r7, r8, false);
        k = UltraSettingsManager.a().a(r15.a, r15.b, r15.getType(), r15.d, r0[8]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r16 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_clear_screen_optimize", r7, r8, false);
        l = UltraSettingsManager.a().a(r16.a, r16.b, r16.getType(), r16.d, r0[9]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r17 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_landscape_opt_config", new d51(), d51.class, false);
        m = UltraSettingsManager.a().a(r17.a, r17.b, r17.getType(), r17.d, r0[10]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r18 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_group_component_close_simple_mode_by_type", r11, r8, false);
        n = UltraSettingsManager.a().a(r18.a, r18.b, r18.getType(), r18.d, r0[11]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r19 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_landscape_log_enable", r11, r8, false);
        o = UltraSettingsManager.a().a(r19.a, r19.b, r19.getType(), r19.d, r0[12]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r20 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_group_container_support_landscape", r11, r8, false);
        p = UltraSettingsManager.a().a(r20.a, r20.b, r20.getType(), r20.d, r0[13]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r21 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_gift_enable_leave_room_memory_cache_release", r7, r8, false);
        q = UltraSettingsManager.a().a(r21.a, r21.b, r21.getType(), r21.d, r0[14]);
    }
}
