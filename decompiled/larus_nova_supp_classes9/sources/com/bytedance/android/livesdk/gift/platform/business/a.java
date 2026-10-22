package com.bytedance.android.livesdk.gift.platform.business;

import com.bytedance.android.livesdk.gift.configmodel.b1;
import com.bytedance.android.livesdk.gift.configmodel.b2;
import com.bytedance.android.livesdk.gift.configmodel.c2;
import com.bytedance.android.livesdk.gift.configmodel.f2;
import com.bytedance.android.livesdk.gift.configmodel.h2;
import com.bytedance.android.livesdk.gift.configmodel.k2;
import com.bytedance.android.livesdk.gift.configmodel.p;
import com.bytedance.bdlocation.BuildConfig;
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

    public static final int a() {
        return ((Number) r.getValue(null, a[16])).intValue();
    }

    public static final p b() {
        return (p) g.getValue(null, a[5]);
    }

    public static final int c() {
        return ((Number) i.getValue(null, a[7])).intValue();
    }

    public static final b1 d() {
        return (b1) w.getValue(null, a[21]);
    }

    public static final k2 e() {
        return (k2) k.getValue(null, a[9]);
    }

    static {
        KProperty[] r0 = {Reflection.property0(new PropertyReference0Impl(a.class, "PK_SINGLE_VIEW_ENABLE", "getPK_SINGLE_VIEW_ENABLE()Z", 1)), Reflection.property0(new PropertyReference0Impl(a.class, "LIVE_MULTI_ANCHOR_SINGLE_VIEW", "getLIVE_MULTI_ANCHOR_SINGLE_VIEW()Z", 1)), Reflection.property0(new PropertyReference0Impl(a.class, "LIVE_PC_ANCHOR_INTERACT_VIDEO_MARGIN_TOP", "getLIVE_PC_ANCHOR_INTERACT_VIDEO_MARGIN_TOP()F", 1)), Reflection.property0(new PropertyReference0Impl(a.class, "LIVE_GIFT_SEND_TO_AUDIENCE_ENABLED", "getLIVE_GIFT_SEND_TO_AUDIENCE_ENABLED()Z", 1)), Reflection.property0(new PropertyReference0Impl(a.class, "LIVE_BASE_POPUP_MANAGER_ENABLE", "getLIVE_BASE_POPUP_MANAGER_ENABLE()Z", 1)), Reflection.property0(new PropertyReference0Impl(a.class, "LIVE_GIFT_DELAY_FETCH_TIME", "getLIVE_GIFT_DELAY_FETCH_TIME()Lcom/bytedance/android/livesdk/gift/configmodel/DelayLoadGiftTimeConfig;", 1)), Reflection.property0(new PropertyReference0Impl(a.class, "LIVE_RECHARGE_RECOMMEND_DIALOG_URL", "getLIVE_RECHARGE_RECOMMEND_DIALOG_URL()Ljava/lang/String;", 1)), Reflection.property0(new PropertyReference0Impl(a.class, "LIVE_GIFT_ENTRANCE_DISABLE_STYLE", "getLIVE_GIFT_ENTRANCE_DISABLE_STYLE()I", 1)), Reflection.property0(new PropertyReference0Impl(a.class, "LIVE_XML_AND_DRAWABLE_CACHE_CONFIG", "getLIVE_XML_AND_DRAWABLE_CACHE_CONFIG()Lcom/bytedance/android/livesdk/gift/configmodel/RevLiveXmlAndDrawableCacheConfig;", 1)), Reflection.property0(new PropertyReference0Impl(a.class, "LIVE_TOOLBAR_COORDINARY_ANIMATION_CONFIG", "getLIVE_TOOLBAR_COORDINARY_ANIMATION_CONFIG()Lcom/bytedance/android/livesdk/gift/configmodel/RevToolbarAnimationConfig;", 1)), Reflection.property0(new PropertyReference0Impl(a.class, "LIVE_PUBLIC_SCREEN_OPTIMIZE_CLEAR_POS", "getLIVE_PUBLIC_SCREEN_OPTIMIZE_CLEAR_POS()Z", 1)), Reflection.property0(new PropertyReference0Impl(a.class, "LIVE_PUBLIC_SCREEN_PLATFORM_TRANSPARENT", "getLIVE_PUBLIC_SCREEN_PLATFORM_TRANSPARENT()Z", 1)), Reflection.property0(new PropertyReference0Impl(a.class, "LIVE_MESSAGE_QUEUE_MAX_LENGTH", "getLIVE_MESSAGE_QUEUE_MAX_LENGTH()I", 1)), Reflection.property0(new PropertyReference0Impl(a.class, "LIVE_AI_GIFT_ASYNC_SORT_CONFIG", "getLIVE_AI_GIFT_ASYNC_SORT_CONFIG()Lcom/bytedance/android/livesdk/gift/configmodel/RevLiveGiftAsyncSortConfig;", 1)), Reflection.property0(new PropertyReference0Impl(a.class, "LIVE_ON_MEASURE_OPT_CONFIG", "getLIVE_ON_MEASURE_OPT_CONFIG()Lcom/bytedance/android/livesdk/gift/configmodel/RevLiveOnMeasureOptConfig;", 1)), Reflection.property0(new PropertyReference0Impl(a.class, "TRAY_QUEUE_OPTIMIZE_AND_ANIMATION", "getTRAY_QUEUE_OPTIMIZE_AND_ANIMATION()I", 1)), Reflection.property0(new PropertyReference0Impl(a.class, "LIVE_ANIMATOR_DEGRADE_FPS_OPT", "getLIVE_ANIMATOR_DEGRADE_FPS_OPT()I", 1)), Reflection.property0(new PropertyReference0Impl(a.class, "LIVE_MULTI_INTERACT_GIFT_EMOJI_SETTINGS", "getLIVE_MULTI_INTERACT_GIFT_EMOJI_SETTINGS()Lcom/bytedance/android/livesdk/gift/configmodel/RevInteractGiftEmojiConfig;", 1)), Reflection.property0(new PropertyReference0Impl(a.class, "LIVE_LYNX_MAPPING_SWITCH", "getLIVE_LYNX_MAPPING_SWITCH()Z", 1)), Reflection.property0(new PropertyReference0Impl(a.class, "LIVE_GIFT_MERGE_INTERACT_GIFT_REQUEST_SWITCH", "getLIVE_GIFT_MERGE_INTERACT_GIFT_REQUEST_SWITCH()Z", 1)), Reflection.property0(new PropertyReference0Impl(a.class, "LIVE_GIFT_MERGE_INTERACT_GIFT_REQUEST_INTERVAL", "getLIVE_GIFT_MERGE_INTERACT_GIFT_REQUEST_INTERVAL()J", 1)), Reflection.property0(new PropertyReference0Impl(a.class, "LIVE_GIFT_INTERACT_GIFT_MESSAGE_NOTICE", "getLIVE_GIFT_INTERACT_GIFT_MESSAGE_NOTICE()Lcom/bytedance/android/livesdk/gift/configmodel/InteractGiftMessageConfig;", 1)), Reflection.property0(new PropertyReference0Impl(a.class, "LIVE_GIFT_INTERACT_GIFT_REQUEST_COUNT", "getLIVE_GIFT_INTERACT_GIFT_REQUEST_COUNT()I", 1))};
        a = r0;
        Boolean r14 = Boolean.FALSE;
        Class r15 = Boolean.TYPE;
        com.bytedance.tools.kcp.ultrasettings.runtime.a r1 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("pk_single_view_enable", r14, r15, false);
        b = UltraSettingsManager.a().a(r1.a, r1.b, r1.getType(), r1.d, r0[0]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r2 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_multi_anchor_single_view", r14, r15, false);
        c = UltraSettingsManager.a().a(r2.a, r2.b, r2.getType(), r2.d, r0[1]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r3 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_pc_anchor_interact_video_margin_top", Float.valueOf(0.19f), Float.TYPE, false);
        d = UltraSettingsManager.a().a(r3.a, r3.b, r3.getType(), r3.d, r0[2]);
        Boolean r4 = Boolean.TRUE;
        com.bytedance.tools.kcp.ultrasettings.runtime.a r5 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_audience_receive_gift_enable", r4, r15, false);
        e = UltraSettingsManager.a().a(r5.a, r5.b, r5.getType(), r5.d, r0[3]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r6 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_base_popup_manager_enable", r4, r15, false);
        f = UltraSettingsManager.a().a(r6.a, r6.b, r6.getType(), r6.d, r0[4]);
        p r7 = new p();
        r7.a();
        com.bytedance.tools.kcp.ultrasettings.runtime.a r8 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_gift_delay_fetch_time", r7, p.class, false);
        g = UltraSettingsManager.a().a(r8.a, r8.b, r8.getType(), r8.d, r0[5]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r9 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_recharge_recommend_dialog_url", BuildConfig.FLAVOR, String.class, false);
        h = UltraSettingsManager.a().a(r9.a, r9.b, r9.getType(), r9.d, r0[6]);
        Class r10 = Integer.TYPE;
        com.bytedance.tools.kcp.ultrasettings.runtime.a r11 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_gift_entrance_disable_style", 0, r10, false);
        i = UltraSettingsManager.a().a(r11.a, r11.b, r11.getType(), r11.d, r0[7]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r13 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_xml_and_drawable_cache_config", new h2(), h2.class, false);
        j = UltraSettingsManager.a().a(r13.a, r13.b, r13.getType(), r13.d, r0[8]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r16 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_toolbar_coordinary_animation_config", new k2(), k2.class, false);
        k = UltraSettingsManager.a().a(r16.a, r16.b, r16.getType(), r16.d, r0[9]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r17 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_public_screen_optimize_clear_pos", r4, r15, false);
        l = UltraSettingsManager.a().a(r17.a, r17.b, r17.getType(), r17.d, r0[10]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r18 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_public_screen_platform_transparent", r4, r15, false);
        m = UltraSettingsManager.a().a(r18.a, r18.b, r18.getType(), r18.d, r0[11]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r19 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_message_queue_max_length", 200, r10, false);
        n = UltraSettingsManager.a().a(r19.a, r19.b, r19.getType(), r19.d, r0[12]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r20 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_ai_gift_async_sort_config", new c2(), c2.class, false);
        o = UltraSettingsManager.a().a(r20.a, r20.b, r20.getType(), r20.d, r0[13]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r21 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_on_measure_opt_config", new f2(), f2.class, false);
        p = UltraSettingsManager.a().a(r21.a, r21.b, r21.getType(), r21.d, r0[14]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r23 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("tray_queue_optimize_and_new_animation", 0, r10, false);
        q = UltraSettingsManager.a().a(r23.a, r23.b, r23.getType(), r23.d, r0[15]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r24 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_animator_degrade_fps_opt", 0, r10, false);
        r = UltraSettingsManager.a().a(r24.a, r24.b, r24.getType(), r24.d, r0[16]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r25 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_interact_gift_emoji_settings", new b2(0), b2.class, false);
        s = UltraSettingsManager.a().a(r25.a, r25.b, r25.getType(), r25.d, r0[17]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r26 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_lynx_mapping_switch", r14, r15, false);
        t = UltraSettingsManager.a().a(r26.a, r26.b, r26.getType(), r26.d, r0[18]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r27 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_gift_merge_interact_gift_request_switch", r14, r15, false);
        u = UltraSettingsManager.a().a(r27.a, r27.b, r27.getType(), r27.d, r0[19]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r28 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_gift_merge_interact_gift_request_interval", 500L, Long.TYPE, false);
        v = UltraSettingsManager.a().a(r28.a, r28.b, r28.getType(), r28.d, r0[20]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r29 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_interact_gift_message_config", new b1(), b1.class, false);
        w = UltraSettingsManager.a().a(r29.a, r29.b, r29.getType(), r29.d, r0[21]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r30 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_gift_interact_gift_request_count", 80, r10, false);
        x = UltraSettingsManager.a().a(r30.a, r30.b, r30.getType(), r30.d, r0[22]);
    }
}
