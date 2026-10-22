package com.bytedance.android.livesdk.gift.platform.business;

import com.bytedance.android.livesdk.gift.configmodel.GiftAfterSendConfig;
import com.bytedance.android.livesdk.gift.configmodel.GiftPanelOptConfig;
import com.bytedance.android.livesdk.gift.configmodel.c1;
import com.bytedance.android.livesdk.gift.configmodel.d1;
import com.bytedance.android.livesdk.gift.configmodel.e1;
import com.bytedance.android.livesdk.gift.configmodel.g0;
import com.bytedance.android.livesdk.gift.configmodel.i1;
import com.bytedance.android.livesdk.gift.configmodel.m2;
import com.bytedance.android.livesdk.gift.configmodel.n1;
import com.bytedance.android.livesdk.gift.configmodel.t;
import com.bytedance.android.livesdk.gift.configmodel.w0;
import com.bytedance.android.livesdk.gift.configmodel.x1;
import com.bytedance.android.livesdk.gift.configmodel.y0;
import com.bytedance.android.livesdk.gift.configmodel.z0;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.SerializableObjectJsonAdapterBase;
import com.bytedance.tools.kcp.ultrasettings.runtime.UltraSettingsManager;
import com.google.gson.annotations.JsonAdapter;
import java.lang.reflect.Constructor;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.PropertyReference0Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.properties.ReadOnlyProperty;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class b {
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
    public static final ReadOnlyProperty V = null;
    public static final ReadOnlyProperty W = null;
    public static final ReadOnlyProperty X = null;
    public static final ReadOnlyProperty Y = null;
    public static final ReadOnlyProperty Z = null;
    public static final /* synthetic */ KProperty[] a = null;
    public static final ReadOnlyProperty a0 = null;
    public static final ReadOnlyProperty b = null;
    public static final ReadOnlyProperty b0 = null;
    public static final ReadOnlyProperty c = null;
    public static final ReadOnlyProperty c0 = null;
    public static final ReadOnlyProperty d = null;
    public static final ReadOnlyProperty d0 = null;
    public static final ReadOnlyProperty e = null;
    public static final ReadOnlyProperty e0 = null;
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
        return ((Boolean) i.getValue(null, a[7])).booleanValue();
    }

    public static final int b() {
        return ((Number) j.getValue(null, a[8])).intValue();
    }

    public static final GiftAfterSendConfig c() {
        return (GiftAfterSendConfig) K.getValue(null, a[35]);
    }

    public static final boolean d() {
        return ((Boolean) P.getValue(null, a[40])).booleanValue();
    }

    public static final boolean e() {
        return ((Boolean) V.getValue(null, a[46])).booleanValue();
    }

    public static final w0 f() {
        return (w0) e0.getValue(null, a[55]);
    }

    public static final boolean g() {
        return ((Boolean) c.getValue(null, a[1])).booleanValue();
    }

    public static final y0 h() {
        return (y0) S.getValue(null, a[43]);
    }

    public static final boolean i() {
        return ((Boolean) r.getValue(null, a[16])).booleanValue();
    }

    static {
        KProperty[] r0 = {Reflection.property0(new PropertyReference0Impl(b.class, "LIVE_MATCH_ATMOSPHERE_EFFECT_IDS", "getLIVE_MATCH_ATMOSPHERE_EFFECT_IDS()Ljava/util/List;", 1)), Reflection.property0(new PropertyReference0Impl(b.class, "LIVE_GIFT_REORDER_OPTIMIZE_ENABLE", "getLIVE_GIFT_REORDER_OPTIMIZE_ENABLE()Z", 1)), Reflection.property0(new PropertyReference0Impl(b.class, "LIVE_GIFT_SEND_TIMEOUT_REPORT_ENABLE", "getLIVE_GIFT_SEND_TIMEOUT_REPORT_ENABLE()Z", 1)), Reflection.property0(new PropertyReference0Impl(b.class, "LIVE_PROP_SEND_TIMEOUT_REPORT_ENABLE", "getLIVE_PROP_SEND_TIMEOUT_REPORT_ENABLE()Z", 1)), Reflection.property0(new PropertyReference0Impl(b.class, "LIVE_ENABLE_SEND_GIFT_ALERT_IN_GUEST_BATTLE", "getLIVE_ENABLE_SEND_GIFT_ALERT_IN_GUEST_BATTLE()Z", 1)), Reflection.property0(new PropertyReference0Impl(b.class, "LIVE_REVENUE_GIFT_ICON_DEGRADE_CONFIG", "getLIVE_REVENUE_GIFT_ICON_DEGRADE_CONFIG()Z", 1)), Reflection.property0(new PropertyReference0Impl(b.class, "LIVE_GIFT_EFFECT_PLAY_INTERVAL", "getLIVE_GIFT_EFFECT_PLAY_INTERVAL()I", 1)), Reflection.property0(new PropertyReference0Impl(b.class, "LIVE_ANIMATOR_DURATION_SCALE_FIX", "getLIVE_ANIMATOR_DURATION_SCALE_FIX()Z", 1)), Reflection.property0(new PropertyReference0Impl(b.class, "LIVE_DEFAULT_SELECT_OPTIMIZE_FOR_ANDROID", "getLIVE_DEFAULT_SELECT_OPTIMIZE_FOR_ANDROID()I", 1)), Reflection.property0(new PropertyReference0Impl(b.class, "GIFT_PANEL_OPT_CONFIG", "getGIFT_PANEL_OPT_CONFIG()Lcom/bytedance/android/livesdk/gift/configmodel/GiftPanelOptConfig;", 1)), Reflection.property0(new PropertyReference0Impl(b.class, "GIFT_FRESCO_CACHE_OPT_ENABLE", "getGIFT_FRESCO_CACHE_OPT_ENABLE()Z", 1)), Reflection.property0(new PropertyReference0Impl(b.class, "LIVE_SCENE_GIFT_SYNC_CONFIG_SETTING", "getLIVE_SCENE_GIFT_SYNC_CONFIG_SETTING()Lcom/bytedance/android/livesdk/configmodel/LiveSceneGiftSyncConfig;", 1)), Reflection.property0(new PropertyReference0Impl(b.class, "LIVE_TOOLBAR_COORDINARY_ANIMAITON_STYLE", "getLIVE_TOOLBAR_COORDINARY_ANIMAITON_STYLE()I", 1)), Reflection.property0(new PropertyReference0Impl(b.class, "LIVE_AI_OPEN_GIFT_PANEL", "getLIVE_AI_OPEN_GIFT_PANEL()Z", 1)), Reflection.property0(new PropertyReference0Impl(b.class, "LIVE_ENTER_ROOM_PRELOAD_ICON_COUNT", "getLIVE_ENTER_ROOM_PRELOAD_ICON_COUNT()I", 1)), Reflection.property0(new PropertyReference0Impl(b.class, "LIVE_OPEN_PANEL_PRELOAD_ICON_COUNT", "getLIVE_OPEN_PANEL_PRELOAD_ICON_COUNT()I", 1)), Reflection.property0(new PropertyReference0Impl(b.class, "LIVE_PROP_LIST_UPDATE_PANEL", "getLIVE_PROP_LIST_UPDATE_PANEL()Z", 1)), Reflection.property0(new PropertyReference0Impl(b.class, "LIVE_OPT_FIND_GIFT", "getLIVE_OPT_FIND_GIFT()Z", 1)), Reflection.property0(new PropertyReference0Impl(b.class, "ASSETS_CLEAN_STRATEGY_CONFIG", "getASSETS_CLEAN_STRATEGY_CONFIG()Lcom/bytedance/android/livesdk/gift/configmodel/AssetsCleanStrategyConfig;", 1)), Reflection.property0(new PropertyReference0Impl(b.class, "LIVE_ASSET_PORTRAIT_CLEAN_ENABLE", "getLIVE_ASSET_PORTRAIT_CLEAN_ENABLE()Z", 1)), Reflection.property0(new PropertyReference0Impl(b.class, "LIVE_GIFT_RESOURCE_MANAGER_USE_NEW_QUEUE", "getLIVE_GIFT_RESOURCE_MANAGER_USE_NEW_QUEUE()Z", 1)), Reflection.property0(new PropertyReference0Impl(b.class, "YYH_INTERACT_DOWNGRADE_CONFIG", "getYYH_INTERACT_DOWNGRADE_CONFIG()Lcom/bytedance/android/livesdk/configmodel/InteractDegradeConfig;", 1)), Reflection.property0(new PropertyReference0Impl(b.class, "SEND_GIFT_INTERCEPT_OFFLINE", "getSEND_GIFT_INTERCEPT_OFFLINE()Z", 1)), Reflection.property0(new PropertyReference0Impl(b.class, "LIVE_LANDSCAPE_TRAY_FIX", "getLIVE_LANDSCAPE_TRAY_FIX()Z", 1)), Reflection.property0(new PropertyReference0Impl(b.class, "LIVE_JSON_OPT_ENABLE", "getLIVE_JSON_OPT_ENABLE()Lcom/bytedance/android/livesdk/gift/configmodel/LiveJsonOptConfig;", 1)), Reflection.property0(new PropertyReference0Impl(b.class, "LIVE_GIFT_COUNTER_CONFIG", "getLIVE_GIFT_COUNTER_CONFIG()Lcom/bytedance/android/livesdk/gift/configmodel/LiveCounterShowConfig;", 1)), Reflection.property0(new PropertyReference0Impl(b.class, "LIVE_GIFT_CURATED_USE_DEFAULT_CARD", "getLIVE_GIFT_CURATED_USE_DEFAULT_CARD()Lcom/bytedance/android/livesdk/gift/configmodel/LiveCuratedUseDefaultCard;", 1)), Reflection.property0(new PropertyReference0Impl(b.class, "GIFT_RESOURCE_UNZIP_METHOD", "getGIFT_RESOURCE_UNZIP_METHOD()I", 1)), Reflection.property0(new PropertyReference0Impl(b.class, "GIFT_WIDGET_SP_OPT", "getGIFT_WIDGET_SP_OPT()Z", 1)), Reflection.property0(new PropertyReference0Impl(b.class, "LIVE_DISABLE_GIFT_ITEM_COMPLETELY_VISIBLE_ACTION", "getLIVE_DISABLE_GIFT_ITEM_COMPLETELY_VISIBLE_ACTION()Z", 1)), Reflection.property0(new PropertyReference0Impl(b.class, "DOUYIN_CLEAN_APPASSET", "getDOUYIN_CLEAN_APPASSET()Z", 1)), Reflection.property0(new PropertyReference0Impl(b.class, "LIVE_BIG_GIFT_COMBO_DEBOUNCE_OPTIMIZE", "getLIVE_BIG_GIFT_COMBO_DEBOUNCE_OPTIMIZE()Z", 1)), Reflection.property0(new PropertyReference0Impl(b.class, "LIVE_ASSET_LRU_CLEAN_CONFIG", "getLIVE_ASSET_LRU_CLEAN_CONFIG()Lcom/bytedance/android/livesdk/gift/configmodel/LiveAssetLRUCleanConfig;", 1)), Reflection.property0(new PropertyReference0Impl(b.class, "LIVE_SEND_GIFT_JSB_EXCHANGE_OPT", "getLIVE_SEND_GIFT_JSB_EXCHANGE_OPT()Lcom/bytedance/android/livesdk/gift/configmodel/SendGiftJsbExchangeOptConfig;", 1)), Reflection.property0(new PropertyReference0Impl(b.class, "GIFT_PREVIEW_DEBUG_WIDGET_LOAD_SWITCH", "getGIFT_PREVIEW_DEBUG_WIDGET_LOAD_SWITCH()Z", 1)), Reflection.property0(new PropertyReference0Impl(b.class, "LIVE_GIFT_AFTER_SEND_CONFIG", "getLIVE_GIFT_AFTER_SEND_CONFIG()Lcom/bytedance/android/livesdk/gift/configmodel/GiftAfterSendConfig;", 1)), Reflection.property0(new PropertyReference0Impl(b.class, "LIVE_ACTIVITY_FLOAT_ASSET_DOWNLOAD_CONFIG", "getLIVE_ACTIVITY_FLOAT_ASSET_DOWNLOAD_CONFIG()Lcom/bytedance/android/livesdk/gift/configmodel/PreDownloadConfig;", 1)), Reflection.property0(new PropertyReference0Impl(b.class, "LIVE_GIFT_DIALOG_TOPIC_CONFIG", "getLIVE_GIFT_DIALOG_TOPIC_CONFIG()Lcom/bytedance/android/livesdk/gift/configmodel/GiftTopicConfig;", 1)), Reflection.property0(new PropertyReference0Impl(b.class, "LIVE_GIFT_OLD_DIALOG_TOPIC_ENABLE", "getLIVE_GIFT_OLD_DIALOG_TOPIC_ENABLE()Z", 1)), Reflection.property0(new PropertyReference0Impl(b.class, "LIVE_TOPIC_PAGING_FIX", "getLIVE_TOPIC_PAGING_FIX()Z", 1)), Reflection.property0(new PropertyReference0Impl(b.class, "LIVE_GIFT_LOAD_IMAGE_OPTIMIZE", "getLIVE_GIFT_LOAD_IMAGE_OPTIMIZE()Z", 1)), Reflection.property0(new PropertyReference0Impl(b.class, "LIVE_GIFT_ICON_PREFETCH_OPT", "getLIVE_GIFT_ICON_PREFETCH_OPT()Lcom/bytedance/android/livesdk/gift/configmodel/GiftIconPrefetchOpt;", 1)), Reflection.property0(new PropertyReference0Impl(b.class, "ENABLE_DEFAULT_SELECT_RECHARGE_PREVIEW_GIFT", "getENABLE_DEFAULT_SELECT_RECHARGE_PREVIEW_GIFT()Z", 1)), Reflection.property0(new PropertyReference0Impl(b.class, "LIVE_GIFT_SORT_FOR_SCENE", "getLIVE_GIFT_SORT_FOR_SCENE()Lcom/bytedance/android/livesdk/gift/configmodel/GiftSortSceneOpt;", 1)), Reflection.property0(new PropertyReference0Impl(b.class, "LIVE_GIFT_LIST_FILTER_OPT_NEW", "getLIVE_GIFT_LIST_FILTER_OPT_NEW()Z", 1)), Reflection.property0(new PropertyReference0Impl(b.class, "LIVE_GIFT_LIST_FILTER_OPT_FIXBUG", "getLIVE_GIFT_LIST_FILTER_OPT_FIXBUG()Z", 1)), Reflection.property0(new PropertyReference0Impl(b.class, "LIVE_GIFT_PANEL_INSERT_OPT", "getLIVE_GIFT_PANEL_INSERT_OPT()Z", 1)), Reflection.property0(new PropertyReference0Impl(b.class, "LIVE_GROUP_LIVE_ENABLE_SEND_PROP_TO_GROUP_MEMBER", "getLIVE_GROUP_LIVE_ENABLE_SEND_PROP_TO_GROUP_MEMBER()Z", 1)), Reflection.property0(new PropertyReference0Impl(b.class, "LIVE_GROUP_LIVE_ENABLE_SEND_FANS_GIFT_TO_GROUP_MEMBER", "getLIVE_GROUP_LIVE_ENABLE_SEND_FANS_GIFT_TO_GROUP_MEMBER()Z", 1)), Reflection.property0(new PropertyReference0Impl(b.class, "LIVE_ENABLE_SEND_FANS_GIFT_TO_GUEST", "getLIVE_ENABLE_SEND_FANS_GIFT_TO_GUEST()Z", 1)), Reflection.property0(new PropertyReference0Impl(b.class, "LIVE_GIFT_BANNER_LYNX_SCHEME", "getLIVE_GIFT_BANNER_LYNX_SCHEME()Ljava/lang/String;", 1)), Reflection.property0(new PropertyReference0Impl(b.class, "LIVE_GIFT_LIST_IS_LOADED_CHECK_OPT", "getLIVE_GIFT_LIST_IS_LOADED_CHECK_OPT()Z", 1)), Reflection.property0(new PropertyReference0Impl(b.class, "LIVE_GIFT_PANEL_LIST_OHR", "getLIVE_GIFT_PANEL_LIST_OHR()Lcom/bytedance/android/livesdk/gift/configmodel/LiveGiftPanelListOhrConfig;", 1)), Reflection.property0(new PropertyReference0Impl(b.class, "LIVE_GIFT_HOTSOON_PROP_ASSET_NOT_IN_LIST_OPTIMIZE", "getLIVE_GIFT_HOTSOON_PROP_ASSET_NOT_IN_LIST_OPTIMIZE()Z", 1)), Reflection.property0(new PropertyReference0Impl(b.class, "LIVE_GIFT_BATTLE_TOOLBAR_CONFIG", "getLIVE_GIFT_BATTLE_TOOLBAR_CONFIG()Lcom/bytedance/android/livesdk/gift/configmodel/GiftBattleToolbarConfig;", 1)), Reflection.property0(new PropertyReference0Impl(b.class, "LIVE_GIFT_PRICE_RECOMMEND_CONFIG", "getLIVE_GIFT_PRICE_RECOMMEND_CONFIG()Lcom/bytedance/android/livesdk/gift/configmodel/GiftPriceRecommendConfig;", 1))};
        a = r0;
        com.bytedance.tools.kcp.ultrasettings.runtime.a r1 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_match_atmosphere_effect_ids", CollectionsKt.listOf(new Long[]{2723L, 2737L}), nn3.a.l, false);
        b = UltraSettingsManager.a().a(r1.a, r1.b, r1.getType(), r1.d, r0[0]);
        Boolean r13 = Boolean.TRUE;
        Class r14 = Boolean.TYPE;
        com.bytedance.tools.kcp.ultrasettings.runtime.a r2 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_gift_reorder_optimize_enable", r13, r14, false);
        c = UltraSettingsManager.a().a(r2.a, r2.b, r2.getType(), r2.d, r0[1]);
        Boolean r5 = Boolean.FALSE;
        com.bytedance.tools.kcp.ultrasettings.runtime.a r3 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_gift_send_timeout_report_enable", r5, r14, false);
        d = UltraSettingsManager.a().a(r3.a, r3.b, r3.getType(), r3.d, r0[2]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r4 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_prop_send_timeout_report_enable", r13, r14, false);
        e = UltraSettingsManager.a().a(r4.a, r4.b, r4.getType(), r4.d, r0[3]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r6 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_enable_send_gift_alert_in_guest_battle", r5, r14, false);
        f = UltraSettingsManager.a().a(r6.a, r6.b, r6.getType(), r6.d, r0[4]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r7 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_revenue_gift_icon_degrade_config", r5, r14, false);
        g = UltraSettingsManager.a().a(r7.a, r7.b, r7.getType(), r7.d, r0[5]);
        Class r8 = Integer.TYPE;
        com.bytedance.tools.kcp.ultrasettings.runtime.a r9 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_gift_effect_play_interval", 0, r8, false);
        h = UltraSettingsManager.a().a(r9.a, r9.b, r9.getType(), r9.d, r0[6]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r10 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_animator_duration_scale_fix", r5, r14, false);
        i = UltraSettingsManager.a().a(r10.a, r10.b, r10.getType(), r10.d, r0[7]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r11 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_default_select_optimize_for_android", 0, r8, false);
        j = UltraSettingsManager.a().a(r11.a, r11.b, r11.getType(), r11.d, r0[8]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r15 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_gift_fresco_cache_config", new GiftPanelOptConfig(), GiftPanelOptConfig.class, false);
        k = UltraSettingsManager.a().a(r15.a, r15.b, r15.getType(), r15.d, r0[9]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r16 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_gift_fresco_cache_opt_enable", r13, r14, false);
        l = UltraSettingsManager.a().a(r16.a, r16.b, r16.getType(), r16.d, r0[10]);
        Class r17 = ys1.b.class.getAnnotation(JsonAdapter.class).value();
        ConcurrentHashMap r18 = vh7.b.a;
        Object r19 = r18.get(r17);
        if (r19 != null) goto L12;
        r19 = r17.getConstructor(new Class[0]);
        if (r19 == null) goto L11;
        Object r20 = r18.putIfAbsent(r17, r19);
        if (r20 == null) goto L12;
        r19 = r20;
        goto L12
    L11:
        throw new NullPointerException("null cannot be cast to non-null type java.lang.reflect.Constructor<out com.bytedance.tools.kcp.modelx.runtime.internal.decode.SerializableObjectJsonAdapterBase>");
    L12:
        Object r21 = ((SerializableObjectJsonAdapterBase) ((Constructor) r19).newInstance(new Object[0])).createInstance();
        if (r21 == null) goto L17;
        com.bytedance.tools.kcp.ultrasettings.runtime.a r23 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_scene_gift_sync_config_setting", (ys1.b) r21, ys1.b.class, false);
        m = UltraSettingsManager.a().a(r23.a, r23.b, r23.getType(), r23.d, r0[11]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r24 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_toolbar_coordinary_animation_style", 0, r8, false);
        n = UltraSettingsManager.a().a(r24.a, r24.b, r24.getType(), r24.d, r0[12]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r25 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_ai_open_gift_panel", r5, r14, false);
        o = UltraSettingsManager.a().a(r25.a, r25.b, r25.getType(), r25.d, r0[13]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r26 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_enter_room_preload_icon_count", -1, r8, false);
        p = UltraSettingsManager.a().a(r26.a, r26.b, r26.getType(), r26.d, r0[14]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r27 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_open_panel_preload_icon_count", -1, r8, false);
        q = UltraSettingsManager.a().a(r27.a, r27.b, r27.getType(), r27.d, r0[15]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r28 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_prop_list_update_panel", r5, r14, false);
        r = UltraSettingsManager.a().a(r28.a, r28.b, r28.getType(), r28.d, r0[16]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r29 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_opt_find_gift", r13, r14, false);
        s = UltraSettingsManager.a().a(r29.a, r29.b, r29.getType(), r29.d, r0[17]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r30 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_asset_clean_strategy_config", new com.bytedance.android.livesdk.gift.configmodel.i(), com.bytedance.android.livesdk.gift.configmodel.i.class, false);
        t = UltraSettingsManager.a().a(r30.a, r30.b, r30.getType(), r30.d, r0[18]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r31 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_asset_portrait_clean_strategy_enable", r5, r14, false);
        u = UltraSettingsManager.a().a(r31.a, r31.b, r31.getType(), r31.d, r0[19]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r33 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_gift_resource_manager_use_new_queue", r13, r14, false);
        v = UltraSettingsManager.a().a(r33.a, r33.b, r33.getType(), r33.d, r0[20]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r34 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("yyh_interact_downgrade_config", new ys1.a(), ys1.a.class, false);
        w = UltraSettingsManager.a().a(r34.a, r34.b, r34.getType(), r34.d, r0[21]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r35 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("send_gift_intercept_anchor_offline", r13, r14, false);
        x = UltraSettingsManager.a().a(r35.a, r35.b, r35.getType(), r35.d, r0[22]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r36 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_landscape_tray_fix", r13, r14, false);
        y = UltraSettingsManager.a().a(r36.a, r36.b, r36.getType(), r36.d, r0[23]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r37 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_json_opt_enable", new n1(), n1.class, false);
        z = UltraSettingsManager.a().a(r37.a, r37.b, r37.getType(), r37.d, r0[24]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r38 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_gift_section_show_config", new d1(), d1.class, false);
        A = UltraSettingsManager.a().a(r38.a, r38.b, r38.getType(), r38.d, r0[25]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r39 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_gift_curated_use_default_card", new e1(), e1.class, false);
        B = UltraSettingsManager.a().a(r39.a, r39.b, r39.getType(), r39.d, r0[26]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r40 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("gift_resource_unzip_method", 0, r8, false);
        C = UltraSettingsManager.a().a(r40.a, r40.b, r40.getType(), r40.d, r0[27]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r41 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("gift_widget_sp_opt", r5, r14, false);
        D = UltraSettingsManager.a().a(r41.a, r41.b, r41.getType(), r41.d, r0[28]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r43 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_disable_gift_item_completely_visible_action", r13, r14, false);
        E = UltraSettingsManager.a().a(r43.a, r43.b, r43.getType(), r43.d, r0[29]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r44 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("douyin_user_clean_appasset", r13, r14, false);
        F = UltraSettingsManager.a().a(r44.a, r44.b, r44.getType(), r44.d, r0[30]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r45 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_big_gift_combo_debounce_optimize", r5, r14, false);
        G = UltraSettingsManager.a().a(r45.a, r45.b, r45.getType(), r45.d, r0[31]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r46 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_asset_lru_clean_config", new c1(), c1.class, false);
        H = UltraSettingsManager.a().a(r46.a, r46.b, r46.getType(), r46.d, r0[32]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r47 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_send_gift_jsb_exchange_opt", new m2(), m2.class, false);
        I = UltraSettingsManager.a().a(r47.a, r47.b, r47.getType(), r47.d, r0[33]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r48 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("gift_preview_debug_widget_load_switch", r5, r14, false);
        J = UltraSettingsManager.a().a(r48.a, r48.b, r48.getType(), r48.d, r0[34]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r49 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_gift_after_send_config", new GiftAfterSendConfig(), GiftAfterSendConfig.class, false);
        K = UltraSettingsManager.a().a(r49.a, r49.b, r49.getType(), r49.d, r0[35]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r50 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_activity_float_asset_download_config", new x1(), x1.class, false);
        L = UltraSettingsManager.a().a(r50.a, r50.b, r50.getType(), r50.d, r0[36]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r51 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_gift_panel_topic_item_config", new z0(), z0.class, false);
        M = UltraSettingsManager.a().a(r51.a, r51.b, r51.getType(), r51.d, r0[37]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r53 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_gift_old_dialog_topic_enable", r5, r14, false);
        N = UltraSettingsManager.a().a(r53.a, r53.b, r53.getType(), r53.d, r0[38]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r54 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_topic_paging_fix", r13, r14, false);
        O = UltraSettingsManager.a().a(r54.a, r54.b, r54.getType(), r54.d, r0[39]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r55 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_gift_load_image_optimize", r13, r14, false);
        P = UltraSettingsManager.a().a(r55.a, r55.b, r55.getType(), r55.d, r0[40]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r56 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_gift_icon_prefetch_opt", new g0(), g0.class, false);
        Q = UltraSettingsManager.a().a(r56.a, r56.b, r56.getType(), r56.d, r0[41]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r57 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("enable_default_select_recharge_preview_gift", r13, r14, false);
        R = UltraSettingsManager.a().a(r57.a, r57.b, r57.getType(), r57.d, r0[42]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r58 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_gift_list_request_config", new y0(), y0.class, false);
        S = UltraSettingsManager.a().a(r58.a, r58.b, r58.getType(), r58.d, r0[43]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r59 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_gift_list_filter_config_opt_new", r13, r14, false);
        T = UltraSettingsManager.a().a(r59.a, r59.b, r59.getType(), r59.d, r0[44]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r60 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_gift_list_filter_config_opt_fixbug", r5, r14, false);
        U = UltraSettingsManager.a().a(r60.a, r60.b, r60.getType(), r60.d, r0[45]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r61 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_gift_panel_insert_opt", r5, r14, false);
        V = UltraSettingsManager.a().a(r61.a, r61.b, r61.getType(), r61.d, r0[46]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r63 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_gift_enable_group_live_room_send_prop_to_group_member", r5, r14, false);
        W = UltraSettingsManager.a().a(r63.a, r63.b, r63.getType(), r63.d, r0[47]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r64 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_gift_enable_group_live_room_send_fans_gift_to_group_member", r5, r14, false);
        X = UltraSettingsManager.a().a(r64.a, r64.b, r64.getType(), r64.d, r0[48]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r65 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_enable_send_fans_gift_to_guest", r5, r14, false);
        Y = UltraSettingsManager.a().a(r65.a, r65.b, r65.getType(), r65.d, r0[49]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r66 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_gift_banner_lynx_scheme", "sslocal://webcast_lynxview?url=https%3A%2F%2Flf-webcast-gr-sourcecdn.bytegecko.com%2Fobj%2Fbyte-gurd-source-gr%2Fwebcast%2Fmono%2Flynx%2Frevenue_gift_panel_douyin%2Fpages%2Fbanner%2Fprogress%2Ftemplate.js&enable_canvas=1&enable_canvas_optmize=1", String.class, false);
        Z = UltraSettingsManager.a().a(r66.a, r66.b, r66.getType(), r66.d, r0[50]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r67 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_gift_list_is_loaded_check_opt", r5, r14, false);
        a0 = UltraSettingsManager.a().a(r67.a, r67.b, r67.getType(), r67.d, r0[51]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r68 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_gift_panel_list_ohr_config", new i1(), i1.class, false);
        b0 = UltraSettingsManager.a().a(r68.a, r68.b, r68.getType(), r68.d, r0[52]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r69 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_gift_hotsoon_prop_asset_not_in_list_optimize", r5, r14, false);
        c0 = UltraSettingsManager.a().a(r69.a, r69.b, r69.getType(), r69.d, r0[53]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r70 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_gift_battle_toolbar_config", new t(), t.class, false);
        d0 = UltraSettingsManager.a().a(r70.a, r70.b, r70.getType(), r70.d, r0[54]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r71 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_gift_price_recommend_config", new w0(), w0.class, false);
        e0 = UltraSettingsManager.a().a(r71.a, r71.b, r71.getType(), r71.d, r0[55]);
        return;
    L17:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.livesdk.configmodel.LiveSceneGiftSyncConfig");
    }
}
