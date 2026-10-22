package com.bytedance.android.livesdk.gift.platform.business.toolbar;

import com.bytedance.android.livesdk.gift.configmodel.h0;
import com.bytedance.tools.kcp.ultrasettings.runtime.UltraSettingsManager;
import kotlin.jvm.internal.PropertyReference0Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.properties.ReadOnlyProperty;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class a {
    public static final /* synthetic */ KProperty[] a = null;
    public static final ReadOnlyProperty b = null;
    public static final ReadOnlyProperty c = null;
    public static final ReadOnlyProperty d = null;
    public static final ReadOnlyProperty e = null;
    public static final ReadOnlyProperty f = null;
    public static final ReadOnlyProperty g = null;
    public static final ReadOnlyProperty h = null;
    public static final ReadOnlyProperty i = null;
    public static final ReadOnlyProperty j = null;
    public static final ReadOnlyProperty k = null;

    static {
        KProperty[] r0 = {Reflection.property0(new PropertyReference0Impl(a.class, "LIVE_GIFT_ICON_SCORE_DEGRADE_CONFIG", "getLIVE_GIFT_ICON_SCORE_DEGRADE_CONFIG()Lcom/bytedance/android/livesdk/gift/configmodel/GiftIconScoreDegradeConfig;", 1)), Reflection.property0(new PropertyReference0Impl(a.class, "LIVE_GIFT_SHOW_SKIN_ANIMATION_INTERVAL", "getLIVE_GIFT_SHOW_SKIN_ANIMATION_INTERVAL()J", 1)), Reflection.property0(new PropertyReference0Impl(a.class, "LIVE_ANIMATED_GIFT_BUTTON_CONFIG", "getLIVE_ANIMATED_GIFT_BUTTON_CONFIG()I", 1)), Reflection.property0(new PropertyReference0Impl(a.class, "LIVE_TOOLBAR_ANIMAITON_REPEAT_FIX", "getLIVE_TOOLBAR_ANIMAITON_REPEAT_FIX()Z", 1)), Reflection.property0(new PropertyReference0Impl(a.class, "GIFT_PANEL_SELECT_GIFT_STRONG_STRATEGY", "getGIFT_PANEL_SELECT_GIFT_STRONG_STRATEGY()I", 1)), Reflection.property0(new PropertyReference0Impl(a.class, "LIVE_MULTI_SEND_GIT_TO_C_POSITION_ENABLE", "getLIVE_MULTI_SEND_GIT_TO_C_POSITION_ENABLE()Z", 1)), Reflection.property0(new PropertyReference0Impl(a.class, "LIVE_GIFT_TOOLBAR_ITEM_SERVER_CTRL", "getLIVE_GIFT_TOOLBAR_ITEM_SERVER_CTRL()Z", 1)), Reflection.property0(new PropertyReference0Impl(a.class, "LIVE_SPEED_SLOT_TOOLBAR_ITEM_SERVER_CTRL", "getLIVE_SPEED_SLOT_TOOLBAR_ITEM_SERVER_CTRL()Z", 1)), Reflection.property0(new PropertyReference0Impl(a.class, "LIVE_TOOLBAR_FAST_GIFT_ENABLE_DELAY", "getLIVE_TOOLBAR_FAST_GIFT_ENABLE_DELAY()Z", 1)), Reflection.property0(new PropertyReference0Impl(a.class, "LIVE_TOOLBAR_FAST_GIFT_LOG_SHOW_TIMING", "getLIVE_TOOLBAR_FAST_GIFT_LOG_SHOW_TIMING()Z", 1))};
        a = r0;
        com.bytedance.tools.kcp.ultrasettings.runtime.a r1 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_gift_icon_score_degrade_config", new h0(), h0.class, false);
        b = UltraSettingsManager.a().a(r1.a, r1.b, r1.getType(), r1.d, r0[0]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r2 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_gift_show_skin_animation_interval", 10L, Long.TYPE, false);
        c = UltraSettingsManager.a().a(r2.a, r2.b, r2.getType(), r2.d, r0[1]);
        Class r13 = Integer.TYPE;
        com.bytedance.tools.kcp.ultrasettings.runtime.a r3 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_animated_gift_button_config", 2, r13, false);
        d = UltraSettingsManager.a().a(r3.a, r3.b, r3.getType(), r3.d, r0[2]);
        Boolean r4 = Boolean.FALSE;
        Class r5 = Boolean.TYPE;
        com.bytedance.tools.kcp.ultrasettings.runtime.a r6 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_toolbar_animation_repeat_fix", r4, r5, false);
        e = UltraSettingsManager.a().a(r6.a, r6.b, r6.getType(), r6.d, r0[3]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r7 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("gift_panel_select_gift_strong_strategy", 0, r13, false);
        f = UltraSettingsManager.a().a(r7.a, r7.b, r7.getType(), r7.d, r0[4]);
        Boolean r8 = Boolean.TRUE;
        com.bytedance.tools.kcp.ultrasettings.runtime.a r9 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_multi_send_git_to_c_position_enable", r8, r5, false);
        g = UltraSettingsManager.a().a(r9.a, r9.b, r9.getType(), r9.d, r0[5]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r10 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_gift_toolbar_item_server_ctrl", r8, r5, false);
        h = UltraSettingsManager.a().a(r10.a, r10.b, r10.getType(), r10.d, r0[6]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r11 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_speed_slot_toolbar_item_server_ctrl", r4, r5, false);
        i = UltraSettingsManager.a().a(r11.a, r11.b, r11.getType(), r11.d, r0[7]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r14 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_toolbar_fast_gift_enable_delay", r4, r5, false);
        j = UltraSettingsManager.a().a(r14.a, r14.b, r14.getType(), r14.d, r0[8]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r15 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_toolbar_fast_gift_log_show_timing", r4, r5, false);
        k = UltraSettingsManager.a().a(r15.a, r15.b, r15.getType(), r15.d, r0[9]);
    }
}
