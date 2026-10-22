package com.bytedance.android.livesdk.gift.platform.business.effect;

import com.bytedance.android.livesdk.gift.configmodel.GiftVolumeAdjustConfig;
import com.bytedance.android.livesdk.gift.configmodel.b0;
import com.bytedance.android.livesdk.gift.configmodel.g1;
import com.bytedance.android.livesdk.gift.configmodel.p1;
import com.bytedance.android.livesdk.gift.configmodel.q1;
import com.bytedance.android.livesdk.gift.configmodel.q2;
import com.bytedance.android.livesdk.gift.configmodel.s;
import com.bytedance.android.livesdkapi.model.GiftPlayerAutoReleaseSwitch;
import com.bytedance.android.livesdkapi.model.LynxAlphaPlayerAutoReleaseSwitch;
import com.bytedance.tools.kcp.ultrasettings.runtime.UltraSettingsManager;
import java.util.HashMap;
import java.util.Map;
import kotlin.jvm.internal.PropertyReference0Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.properties.ReadOnlyProperty;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class a {
    public static final ReadOnlyProperty A = null;
    public static final ReadOnlyProperty B = null;
    public static final ReadOnlyProperty C = null;
    public static final ReadOnlyProperty D = null;
    public static final ReadOnlyProperty E = null;
    public static final ReadOnlyProperty F = null;
    public static final ReadOnlyProperty G = null;
    public static final ReadOnlyProperty H = null;
    public static final ReadOnlyProperty I = null;
    public static final ReadOnlyProperty J = null;
    public static final ReadOnlyProperty K = null;
    public static final ReadOnlyProperty L = null;
    public static final ReadOnlyProperty M = null;
    public static final ReadOnlyProperty N = null;
    public static final ReadOnlyProperty O = null;
    public static final ReadOnlyProperty P = null;
    public static final ReadOnlyProperty Q = null;
    public static final ReadOnlyProperty R = null;
    public static final ReadOnlyProperty S = null;
    public static final ReadOnlyProperty T = null;
    public static final ReadOnlyProperty U = null;
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
    public static final ReadOnlyProperty l = null;
    public static final ReadOnlyProperty m = null;
    public static final ReadOnlyProperty n = null;
    public static final ReadOnlyProperty o = null;
    public static final ReadOnlyProperty p = null;
    public static final ReadOnlyProperty q = null;
    public static final ReadOnlyProperty r = null;
    public static final ReadOnlyProperty s = null;
    public static final ReadOnlyProperty t = null;
    public static final ReadOnlyProperty u = null;
    public static final ReadOnlyProperty v = null;
    public static final ReadOnlyProperty w = null;
    public static final ReadOnlyProperty x = null;
    public static final ReadOnlyProperty y = null;
    public static final ReadOnlyProperty z = null;

    public static final boolean a() {
        return ((Boolean) U.getValue(null, a[45])).booleanValue();
    }

    public static final boolean b() {
        return ((Boolean) S.getValue(null, a[43])).booleanValue();
    }

    public static final Map<String, g1> c() {
        return (Map) N.getValue(null, a[38]);
    }

    public static final s d() {
        return (s) q.getValue(null, a[15]);
    }

    public static final b0 e() {
        return (b0) G.getValue(null, a[31]);
    }

    public static final boolean f() {
        return ((Boolean) y.getValue(null, a[23])).booleanValue();
    }

    public static final int g() {
        return ((Number) d.getValue(null, a[2])).intValue();
    }

    public static final int h() {
        return ((Number) b.getValue(null, a[0])).intValue();
    }

    public static final q2 i() {
        return (q2) f.getValue(null, a[4]);
    }

    static {
        KProperty[] r0 = {Reflection.property0(new PropertyReference0Impl(a.class, "LIVE_GIFT_TTPLAYER_USE_HARDCORE", "getLIVE_GIFT_TTPLAYER_USE_HARDCORE()I", 1)), Reflection.property0(new PropertyReference0Impl(a.class, "LIVE_GIFT_USE_TEXTURE_RENDER", "getLIVE_GIFT_USE_TEXTURE_RENDER()Z", 1)), Reflection.property0(new PropertyReference0Impl(a.class, "LIVE_GIFT_PLAYER_USE_TYPE", "getLIVE_GIFT_PLAYER_USE_TYPE()I", 1)), Reflection.property0(new PropertyReference0Impl(a.class, "LIVE_GIFT_DOWNLOAD_POLICY", "getLIVE_GIFT_DOWNLOAD_POLICY()I", 1)), Reflection.property0(new PropertyReference0Impl(a.class, "LIVE_SUPER_RESOLUTION_720_CONFIG", "getLIVE_SUPER_RESOLUTION_720_CONFIG()Lcom/bytedance/android/livesdk/gift/configmodel/SuperResolution720Config;", 1)), Reflection.property0(new PropertyReference0Impl(a.class, "LIVE_GIFT_SR_CONFIG_ALG_TYPE", "getLIVE_GIFT_SR_CONFIG_ALG_TYPE()I", 1)), Reflection.property0(new PropertyReference0Impl(a.class, "LIVE_GIFT_SOUND_VOLUME_DYNAMIC_ADJUST", "getLIVE_GIFT_SOUND_VOLUME_DYNAMIC_ADJUST()Z", 1)), Reflection.property0(new PropertyReference0Impl(a.class, "LIVE_GIFT_SOUND_VOLUME_ADJUST_CONFIGS", "getLIVE_GIFT_SOUND_VOLUME_ADJUST_CONFIGS()Lcom/bytedance/android/livesdk/gift/configmodel/GiftVolumeAdjustConfig;", 1)), Reflection.property0(new PropertyReference0Impl(a.class, "LIVE_GIFT_LYNX_V8_ENABLE", "getLIVE_GIFT_LYNX_V8_ENABLE()Z", 1)), Reflection.property0(new PropertyReference0Impl(a.class, "LIVE_GIFT_LYNX_V8_FORCE_ENABLE", "getLIVE_GIFT_LYNX_V8_FORCE_ENABLE()Z", 1)), Reflection.property0(new PropertyReference0Impl(a.class, "LIVE_TRAY_EFFECT_MESSAGE_QUEUE", "getLIVE_TRAY_EFFECT_MESSAGE_QUEUE()Z", 1)), Reflection.property0(new PropertyReference0Impl(a.class, "LIVE_LOCAL_HOST_GIFT_NEED_FILTER_TEST_ASSET", "getLIVE_LOCAL_HOST_GIFT_NEED_FILTER_TEST_ASSET()Z", 1)), Reflection.property0(new PropertyReference0Impl(a.class, "LIVE_VS_VERTICAL_OPEN_EFFECT", "getLIVE_VS_VERTICAL_OPEN_EFFECT()Z", 1)), Reflection.property0(new PropertyReference0Impl(a.class, "LIVE_GIFT_QUEUE_SWITCH_CONSUME_OPTIMIZE", "getLIVE_GIFT_QUEUE_SWITCH_CONSUME_OPTIMIZE()Z", 1)), Reflection.property0(new PropertyReference0Impl(a.class, "LIVE_GIFT_EFFECT_SHOW_TOUCH_LISTENER", "getLIVE_GIFT_EFFECT_SHOW_TOUCH_LISTENER()Z", 1)), Reflection.property0(new PropertyReference0Impl(a.class, "LIVE_GIFT_ASSET_PRE_DOWNLOAD", "getLIVE_GIFT_ASSET_PRE_DOWNLOAD()Lcom/bytedance/android/livesdk/gift/configmodel/GiftAssetPreDownloadConfig;", 1)), Reflection.property0(new PropertyReference0Impl(a.class, "LIVE_GIFT_DIALOG_ENABLE", "getLIVE_GIFT_DIALOG_ENABLE()Z", 1)), Reflection.property0(new PropertyReference0Impl(a.class, "LIVE_GIFT_RESOURCE_DELETE_THRESHOLD", "getLIVE_GIFT_RESOURCE_DELETE_THRESHOLD()J", 1)), Reflection.property0(new PropertyReference0Impl(a.class, "USE_TEXTURERENDER_CATCH", "getUSE_TEXTURERENDER_CATCH()Z", 1)), Reflection.property0(new PropertyReference0Impl(a.class, "LIVE_OFFLINE_ENTER_ROOM_TIME_OPTIMIZE", "getLIVE_OFFLINE_ENTER_ROOM_TIME_OPTIMIZE()Z", 1)), Reflection.property0(new PropertyReference0Impl(a.class, "LIVE_REMOVE_CONTEXT_JUDGEMENT", "getLIVE_REMOVE_CONTEXT_JUDGEMENT()Z", 1)), Reflection.property0(new PropertyReference0Impl(a.class, "LIVE_GIFT_PLAYER_AUTO_RELEASE_SWITCH", "getLIVE_GIFT_PLAYER_AUTO_RELEASE_SWITCH()Lcom/bytedance/android/livesdkapi/model/GiftPlayerAutoReleaseSwitch;", 1)), Reflection.property0(new PropertyReference0Impl(a.class, "LIVE_TOOLBAR_COVER_OPT_ENABLE", "getLIVE_TOOLBAR_COVER_OPT_ENABLE()Z", 1)), Reflection.property0(new PropertyReference0Impl(a.class, "LIVE_GIFT_FLY_DIALOG_DELAY_START", "getLIVE_GIFT_FLY_DIALOG_DELAY_START()Z", 1)), Reflection.property0(new PropertyReference0Impl(a.class, "LIVE_FLY_DIALOG_XIAOMI_SETTING", "getLIVE_FLY_DIALOG_XIAOMI_SETTING()Z", 1)), Reflection.property0(new PropertyReference0Impl(a.class, "LIVE_LYNX_ALPHA_PLAYER_AUTO_RELEASE_SWITCH", "getLIVE_LYNX_ALPHA_PLAYER_AUTO_RELEASE_SWITCH()Lcom/bytedance/android/livesdkapi/model/LynxAlphaPlayerAutoReleaseSwitch;", 1)), Reflection.property0(new PropertyReference0Impl(a.class, "LIVE_DISABLE_OLD_CONTAINER_GESTURE_GIFT", "getLIVE_DISABLE_OLD_CONTAINER_GESTURE_GIFT()Z", 1)), Reflection.property0(new PropertyReference0Impl(a.class, "NEW_STICKER_MP4_ASSET_IDS", "getNEW_STICKER_MP4_ASSET_IDS()Ljava/util/Map;", 1)), Reflection.property0(new PropertyReference0Impl(a.class, "LIVE_GIFT_PLAYER_ENABLE_ELEMENT_CLICK", "getLIVE_GIFT_PLAYER_ENABLE_ELEMENT_CLICK()Z", 1)), Reflection.property0(new PropertyReference0Impl(a.class, "LIVE_GIFT_GL_OPTIMIZE", "getLIVE_GIFT_GL_OPTIMIZE()Z", 1)), Reflection.property0(new PropertyReference0Impl(a.class, "live_ds_allow_enter_gift_animation", "getLive_ds_allow_enter_gift_animation()Z", 1)), Reflection.property0(new PropertyReference0Impl(a.class, "LIVE_GIFT_EFFECT_PERFORMANCE_OPT_CONFIG", "getLIVE_GIFT_EFFECT_PERFORMANCE_OPT_CONFIG()Lcom/bytedance/android/livesdk/gift/configmodel/GiftEffectPerfOptConfig;", 1)), Reflection.property0(new PropertyReference0Impl(a.class, "LIVE_GIFT_EFFECT_PLAY_METRICS_ENABLE", "getLIVE_GIFT_EFFECT_PLAY_METRICS_ENABLE()Z", 1)), Reflection.property0(new PropertyReference0Impl(a.class, "LIVE_GIFT_EFFECT_MEMORY_METRICS_ENABLE", "getLIVE_GIFT_EFFECT_MEMORY_METRICS_ENABLE()Z", 1)), Reflection.property0(new PropertyReference0Impl(a.class, "LIVE_GIFT_LYNX_EFFECT_PLAY_METRICS_ENABLE", "getLIVE_GIFT_LYNX_EFFECT_PLAY_METRICS_ENABLE()Z", 1)), Reflection.property0(new PropertyReference0Impl(a.class, "LIVE_LYNX_UI_CANVAS_MONITOR_CONFIG", "getLIVE_LYNX_UI_CANVAS_MONITOR_CONFIG()Lcom/bytedance/android/livesdk/gift/configmodel/LynxCanvasMonitorConfig;", 1)), Reflection.property0(new PropertyReference0Impl(a.class, "LIVE_LYNX_GIFT_LOAD_OPT_CONFIG", "getLIVE_LYNX_GIFT_LOAD_OPT_CONFIG()Lcom/bytedance/android/livesdk/gift/configmodel/LynxGiftLoadOptConfig;", 1)), Reflection.property0(new PropertyReference0Impl(a.class, "LIVE_GIFT_EFFECT_PLAYER_DASP_ENABLE", "getLIVE_GIFT_EFFECT_PLAYER_DASP_ENABLE()Z", 1)), Reflection.property0(new PropertyReference0Impl(a.class, "LIVE_GIFT_ASSETS_LRU_CLEAN_CONFIG", "getLIVE_GIFT_ASSETS_LRU_CLEAN_CONFIG()Ljava/util/Map;", 1)), Reflection.property0(new PropertyReference0Impl(a.class, "LIVE_GIFTS_NOT_USE_REQUIRED_ASSETS", "getLIVE_GIFTS_NOT_USE_REQUIRED_ASSETS()[J", 1)), Reflection.property0(new PropertyReference0Impl(a.class, "LIVE_GIFT_MP4__MASK_FIX_SPECIAL_TEXT_SYMBOL_HEIGHT", "getLIVE_GIFT_MP4__MASK_FIX_SPECIAL_TEXT_SYMBOL_HEIGHT()Z", 1)), Reflection.property0(new PropertyReference0Impl(a.class, "LIVE_GIFT_ISSUE_REPORT_GIFT_INFO", "getLIVE_GIFT_ISSUE_REPORT_GIFT_INFO()Z", 1)), Reflection.property0(new PropertyReference0Impl(a.class, "LIVE_GIFT_EFFECT_LYNX_INFO_WIDGET_OPTIMIZE", "getLIVE_GIFT_EFFECT_LYNX_INFO_WIDGET_OPTIMIZE()Z", 1)), Reflection.property0(new PropertyReference0Impl(a.class, "LIVE_DOWNLOAD_GIFT_ASSET_JSB_OPT", "getLIVE_DOWNLOAD_GIFT_ASSET_JSB_OPT()Z", 1)), Reflection.property0(new PropertyReference0Impl(a.class, "LIVE_DOWNLOAD_GIFT_ASSET_JSB_OPT_NEW", "getLIVE_DOWNLOAD_GIFT_ASSET_JSB_OPT_NEW()Z", 1)), Reflection.property0(new PropertyReference0Impl(a.class, "ENABLE_GIFT_ASSET_MESSAGE_FOR_LYNX", "getENABLE_GIFT_ASSET_MESSAGE_FOR_LYNX()Z", 1))};
        a = r0;
        Class r13 = Integer.TYPE;
        com.bytedance.tools.kcp.ultrasettings.runtime.a r1 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_gift_ttplayer_use_hardcore", 0, r13, false);
        b = UltraSettingsManager.a().a(r1.a, r1.b, r1.getType(), r1.d, r0[0]);
        Boolean r14 = Boolean.FALSE;
        Class r15 = Boolean.TYPE;
        com.bytedance.tools.kcp.ultrasettings.runtime.a r2 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_gift_use_texture_render", r14, r15, false);
        c = UltraSettingsManager.a().a(r2.a, r2.b, r2.getType(), r2.d, r0[1]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r3 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_gift_player_user_type", 4, r13, false);
        d = UltraSettingsManager.a().a(r3.a, r3.b, r3.getType(), r3.d, r0[2]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r4 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("gift_download_optimize", 0, r13, false);
        e = UltraSettingsManager.a().a(r4.a, r4.b, r4.getType(), r4.d, r0[3]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r5 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_gift_720p_super_resolution_config", new q2(0), q2.class, false);
        f = UltraSettingsManager.a().a(r5.a, r5.b, r5.getType(), r5.d, r0[4]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r6 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_gift_sr_config_alg_type", 4, r13, false);
        g = UltraSettingsManager.a().a(r6.a, r6.b, r6.getType(), r6.d, r0[5]);
        Boolean r7 = Boolean.TRUE;
        com.bytedance.tools.kcp.ultrasettings.runtime.a r8 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_gift_sound_volume_dynamic_adjust", r7, r15, false);
        h = UltraSettingsManager.a().a(r8.a, r8.b, r8.getType(), r8.d, r0[6]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r9 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_gift_sound_volume_adjust_configs", new GiftVolumeAdjustConfig(0, 0, 0, 0, 0.0f, 0.0f, 63, null), GiftVolumeAdjustConfig.class, false);
        i = UltraSettingsManager.a().a(r9.a, r9.b, r9.getType(), r9.d, r0[7]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r10 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_gift_lynx_v8_enable", r14, r15, false);
        j = UltraSettingsManager.a().a(r10.a, r10.b, r10.getType(), r10.d, r0[8]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r11 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_gift_lynx_v8_force_enable", r14, r15, false);
        k = UltraSettingsManager.a().a(r11.a, r11.b, r11.getType(), r11.d, r0[9]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r16 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_tray_effect_message_queue", r7, r15, false);
        l = UltraSettingsManager.a().a(r16.a, r16.b, r16.getType(), r16.d, r0[10]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r17 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_local_host_gift_need_filter_test_asset", r7, r15, false);
        m = UltraSettingsManager.a().a(r17.a, r17.b, r17.getType(), r17.d, r0[11]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r18 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_vs_vertical_open_effect", r7, r15, false);
        n = UltraSettingsManager.a().a(r18.a, r18.b, r18.getType(), r18.d, r0[12]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r19 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_gift_queue_switch_consume_optimize", r7, r15, false);
        o = UltraSettingsManager.a().a(r19.a, r19.b, r19.getType(), r19.d, r0[13]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r20 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_gift_effect_show_touch_listener", r14, r15, false);
        p = UltraSettingsManager.a().a(r20.a, r20.b, r20.getType(), r20.d, r0[14]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r21 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_gift_assets_pre_download", new s(), s.class, false);
        q = UltraSettingsManager.a().a(r21.a, r21.b, r21.getType(), r21.d, r0[15]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r23 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_gift_dialog_enable", r7, r15, false);
        r = UltraSettingsManager.a().a(r23.a, r23.b, r23.getType(), r23.d, r0[16]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r24 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_gift_resource_delete_size_threshold", -1L, Long.TYPE, false);
        s = UltraSettingsManager.a().a(r24.a, r24.b, r24.getType(), r24.d, r0[17]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r25 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("use_texturerender_catch", r7, r15, false);
        t = UltraSettingsManager.a().a(r25.a, r25.b, r25.getType(), r25.d, r0[18]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r26 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_offline_enter_room_time_optimize", r14, r15, false);
        u = UltraSettingsManager.a().a(r26.a, r26.b, r26.getType(), r26.d, r0[19]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r27 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_remove_context_judgement", r14, r15, false);
        v = UltraSettingsManager.a().a(r27.a, r27.b, r27.getType(), r27.d, r0[20]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r28 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("gift_player_auto_release_switch", new GiftPlayerAutoReleaseSwitch(), GiftPlayerAutoReleaseSwitch.class, false);
        w = UltraSettingsManager.a().a(r28.a, r28.b, r28.getType(), r28.d, r0[21]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r29 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_toolbar_cover_optimize", r14, r15, false);
        x = UltraSettingsManager.a().a(r29.a, r29.b, r29.getType(), r29.d, r0[22]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r30 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_gift_fly_dialog_delay_start", r7, r15, false);
        y = UltraSettingsManager.a().a(r30.a, r30.b, r30.getType(), r30.d, r0[23]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r31 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_fly_dialog_xiaomi_setting", r7, r15, false);
        z = UltraSettingsManager.a().a(r31.a, r31.b, r31.getType(), r31.d, r0[24]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r33 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("lynx_alpha_player_auto_release_switch", new LynxAlphaPlayerAutoReleaseSwitch(), LynxAlphaPlayerAutoReleaseSwitch.class, false);
        A = UltraSettingsManager.a().a(r33.a, r33.b, r33.getType(), r33.d, r0[25]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r34 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_disable_old_container_gesture_gift", r7, r15, false);
        B = UltraSettingsManager.a().a(r34.a, r34.b, r34.getType(), r34.d, r0[26]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r35 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("new_sticker_mp4_asset_ids", new HashMap(), nn3.a.j, false);
        C = UltraSettingsManager.a().a(r35.a, r35.b, r35.getType(), r35.d, r0[27]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r36 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_gift_player_enable_element_click", r7, r15, false);
        D = UltraSettingsManager.a().a(r36.a, r36.b, r36.getType(), r36.d, r0[28]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r37 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_gift_gl_optimize", r14, r15, false);
        E = UltraSettingsManager.a().a(r37.a, r37.b, r37.getType(), r37.d, r0[29]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r38 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_ds_allow_enter_gift_animation", r7, r15, false);
        F = UltraSettingsManager.a().a(r38.a, r38.b, r38.getType(), r38.d, r0[30]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r39 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_gift_effect_performance_opt_config", new b0(), b0.class, false);
        G = UltraSettingsManager.a().a(r39.a, r39.b, r39.getType(), r39.d, r0[31]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r40 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_gift_effect_play_metrics_enable", r14, r15, false);
        H = UltraSettingsManager.a().a(r40.a, r40.b, r40.getType(), r40.d, r0[32]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r41 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_gift_effect_memory_metrics_enable", r7, r15, false);
        I = UltraSettingsManager.a().a(r41.a, r41.b, r41.getType(), r41.d, r0[33]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r43 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_gift_lynx_effect_play_metrics_enable", r14, r15, false);
        J = UltraSettingsManager.a().a(r43.a, r43.b, r43.getType(), r43.d, r0[34]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r44 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_lynx_ui_canvas_monitor_config", new p1(), p1.class, false);
        K = UltraSettingsManager.a().a(r44.a, r44.b, r44.getType(), r44.d, r0[35]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r45 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_lynx_gift_load_opt_config", new q1(), q1.class, false);
        L = UltraSettingsManager.a().a(r45.a, r45.b, r45.getType(), r45.d, r0[36]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r46 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_gift_effect_player_dasp_enable", r7, r15, false);
        M = UltraSettingsManager.a().a(r46.a, r46.b, r46.getType(), r46.d, r0[37]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r47 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_gift_assets_lru_clean_config", new HashMap(), nn3.a.i, false);
        N = UltraSettingsManager.a().a(r47.a, r47.b, r47.getType(), r47.d, r0[38]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r48 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_gifts_not_use_required_assets", new long[0], long[].class, false);
        O = UltraSettingsManager.a().a(r48.a, r48.b, r48.getType(), r48.d, r0[39]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r49 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_gift_mp4_mask_fix_special_text_symbol_height", r7, r15, false);
        P = UltraSettingsManager.a().a(r49.a, r49.b, r49.getType(), r49.d, r0[40]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r50 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_gift_issue_report_gift_info", r7, r15, false);
        Q = UltraSettingsManager.a().a(r50.a, r50.b, r50.getType(), r50.d, r0[41]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r51 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_gift_effect_lynx_info_widget_optimize", r7, r15, false);
        R = UltraSettingsManager.a().a(r51.a, r51.b, r51.getType(), r51.d, r0[42]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r53 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_download_gift_asset_jsb_opt", r7, r15, false);
        S = UltraSettingsManager.a().a(r53.a, r53.b, r53.getType(), r53.d, r0[43]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r54 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_download_gift_asset_jsb_opt_new", r14, r15, false);
        T = UltraSettingsManager.a().a(r54.a, r54.b, r54.getType(), r54.d, r0[44]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r55 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("enable_gift_asset_message_for_lynx", r14, r15, false);
        U = UltraSettingsManager.a().a(r55.a, r55.b, r55.getType(), r55.d, r0[45]);
    }
}
