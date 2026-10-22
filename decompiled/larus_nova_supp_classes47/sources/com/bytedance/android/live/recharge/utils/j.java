package com.bytedance.android.live.recharge.utils;

import com.bytedance.android.live.ai.api.model.RechargeCacheConfig;
import com.bytedance.android.live.base.abtest.ClientABTestKey;
import com.bytedance.live.kmp.core.KmpEnv;
import com.bytedance.tools.kcp.ultrasettings.runtime.UltraSettingsManager;
import java.util.LinkedHashMap;
import kotlin.jvm.internal.PropertyReference0Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.properties.ReadOnlyProperty;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class j {
    public static final ReadOnlyProperty A = null;
    public static final ReadOnlyProperty B = null;
    public static final ReadOnlyProperty C = null;
    public static final ReadOnlyProperty D = null;
    public static final ReadOnlyProperty E = null;
    public static final ReadOnlyProperty F = null;
    public static final ReadOnlyProperty G = null;
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
    public static final ClientABTestKey<Boolean> o = null;
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
        return ((Boolean) E.getValue(null, a[28])).booleanValue();
    }

    public static final int b() {
        return ((Number) c.getValue(null, a[1])).intValue();
    }

    public static final boolean c() {
        return ((Boolean) j.getValue(null, a[8])).booleanValue();
    }

    public static final RechargeCacheConfig d() {
        return (RechargeCacheConfig) l.getValue(null, a[10]);
    }

    static {
        KProperty[] r0 = {Reflection.property0(new PropertyReference0Impl(j.class, "CASH_EXCHANGE_OPT_CONFIG", "getCASH_EXCHANGE_OPT_CONFIG()Lcom/bytedance/android/live/recharge/utils/LiveCashExchangeOptConfig;", 1)), Reflection.property0(new PropertyReference0Impl(j.class, "LIVE_EXCHANGE_DIALOG_FREQUENCY", "getLIVE_EXCHANGE_DIALOG_FREQUENCY()I", 1)), Reflection.property0(new PropertyReference0Impl(j.class, "LIVE_BASE_POPUP_MANAGER_ENABLE", "getLIVE_BASE_POPUP_MANAGER_ENABLE()Z", 1)), Reflection.property0(new PropertyReference0Impl(j.class, "LIVE_WALLET_INFO_REQUEST_TIME", "getLIVE_WALLET_INFO_REQUEST_TIME()I", 1)), Reflection.property0(new PropertyReference0Impl(j.class, "LIVE_LYNX_EXCHANGE_DIALOG", "getLIVE_LYNX_EXCHANGE_DIALOG()Ljava/lang/String;", 1)), Reflection.property0(new PropertyReference0Impl(j.class, "LIVE_EXCHANGE_REASON_MAP", "getLIVE_EXCHANGE_REASON_MAP()Ljava/util/Map;", 1)), Reflection.property0(new PropertyReference0Impl(j.class, "CHARGE_PROTOCOL", "getCHARGE_PROTOCOL()Ljava/lang/String;", 1)), Reflection.property0(new PropertyReference0Impl(j.class, "CHARGE_SECURITY_PROTOCOL", "getCHARGE_SECURITY_PROTOCOL()Ljava/lang/String;", 1)), Reflection.property0(new PropertyReference0Impl(j.class, "LIVE_INCENTIVES_EXPERIMENT_ENABLE", "getLIVE_INCENTIVES_EXPERIMENT_ENABLE()Z", 1)), Reflection.property0(new PropertyReference0Impl(j.class, "LIVE_LYNX_EXCHANGE_DIALOG_SHORTCUT", "getLIVE_LYNX_EXCHANGE_DIALOG_SHORTCUT()Ljava/lang/String;", 1)), Reflection.property0(new PropertyReference0Impl(j.class, "RECHARGE_PANEL_USE_CACHE_DATA", "getRECHARGE_PANEL_USE_CACHE_DATA()Lcom/bytedance/android/live/ai/api/model/RechargeCacheConfig;", 1)), Reflection.property0(new PropertyReference0Impl(j.class, "LIVE_BALANCE_CACHE_UPDATE", "getLIVE_BALANCE_CACHE_UPDATE()Lcom/bytedance/android/live/recharge/utils/BalanceCacheUpdateConfig;", 1)), Reflection.property0(new PropertyReference0Impl(j.class, "LIVE_USER_CHANGE_SYNC_DISABLE", "getLIVE_USER_CHANGE_SYNC_DISABLE()Z", 1)), Reflection.property0(new PropertyReference0Impl(j.class, "LIVE_EXCHANGE_DIAMOND_PROCESS_OPTIMIZATION", "getLIVE_EXCHANGE_DIAMOND_PROCESS_OPTIMIZATION()Lcom/bytedance/android/live/recharge/utils/ExchangeDiamondProcessConfig;", 1)), Reflection.property0(new PropertyReference0Impl(j.class, "LIVE_OPEN_TREASURE_BOX_SCHEMA", "getLIVE_OPEN_TREASURE_BOX_SCHEMA()Ljava/lang/String;", 1)), Reflection.property0(new PropertyReference0Impl(j.class, "LIVE_EXCHANGE_COUNT_DOWN_TIME_REQUEST_ENABLE", "getLIVE_EXCHANGE_COUNT_DOWN_TIME_REQUEST_ENABLE()Z", 1)), Reflection.property0(new PropertyReference0Impl(j.class, "LIVE_OPEN_EXCHANGE_INTRO_SCHEMA", "getLIVE_OPEN_EXCHANGE_INTRO_SCHEMA()Ljava/lang/String;", 1)), Reflection.property0(new PropertyReference0Impl(j.class, "LIVE_OPEN_EXCHANGE_INTRO_SCHEME_TAX_SAVING", "getLIVE_OPEN_EXCHANGE_INTRO_SCHEME_TAX_SAVING()Ljava/lang/String;", 1)), Reflection.property0(new PropertyReference0Impl(j.class, "LIVE_CHECK_IAC_FINANCIAL_VISIBLE", "getLIVE_CHECK_IAC_FINANCIAL_VISIBLE()Z", 1)), Reflection.property0(new PropertyReference0Impl(j.class, "LIVE_RECHARGE_BANNER_USE_ANNIEX", "getLIVE_RECHARGE_BANNER_USE_ANNIEX()Z", 1)), Reflection.property0(new PropertyReference0Impl(j.class, "LIVE_RECHARGE_BANNER_USE_CACHE", "getLIVE_RECHARGE_BANNER_USE_CACHE()Z", 1)), Reflection.property0(new PropertyReference0Impl(j.class, "LIVE_RECHARGE_GOOGLE_IAP_CONFIG", "getLIVE_RECHARGE_GOOGLE_IAP_CONFIG()Lcom/bytedance/android/live/wallet/pay/iap/LiveIAPSettingConfig;", 1)), Reflection.property0(new PropertyReference0Impl(j.class, "LIVE_RECHARGE_TRACE_CONFIG", "getLIVE_RECHARGE_TRACE_CONFIG()Lcom/bytedance/android/live/recharge/trace/RechargeTraceSettingConfig;", 1)), Reflection.property0(new PropertyReference0Impl(j.class, "LIVE_CUSTOM_RECHARGE_DYNAMIC_CONFIG", "getLIVE_CUSTOM_RECHARGE_DYNAMIC_CONFIG()Lcom/bytedance/android/live/ai/api/model/CustomRechargeDynamicConfig;", 1)), Reflection.property0(new PropertyReference0Impl(j.class, "LIVE_WALLET_LOG_USE_EVENT_TRACKER_SWITCH", "getLIVE_WALLET_LOG_USE_EVENT_TRACKER_SWITCH()Z", 1)), Reflection.property0(new PropertyReference0Impl(j.class, "LIVE_RECHARGE_ONE_STEP_PRELOAD_CONFIG", "getLIVE_RECHARGE_ONE_STEP_PRELOAD_CONFIG()J", 1)), Reflection.property0(new PropertyReference0Impl(j.class, "LIVE_RECHARGE_PANEL_PAD_UI_FIX", "getLIVE_RECHARGE_PANEL_PAD_UI_FIX()Z", 1)), Reflection.property0(new PropertyReference0Impl(j.class, "LIVE_RECHARGE_PANEL_ONE_STEP_LOADING_BLOCK", "getLIVE_RECHARGE_PANEL_ONE_STEP_LOADING_BLOCK()Z", 1)), Reflection.property0(new PropertyReference0Impl(j.class, "LIVESDK_CLIENT_AI_PREORDER_ENABLE", "getLIVESDK_CLIENT_AI_PREORDER_ENABLE()Z", 1)), Reflection.property0(new PropertyReference0Impl(j.class, "LIVE_RECHARGE_PANEL_SETTING_CONFIG", "getLIVE_RECHARGE_PANEL_SETTING_CONFIG()Lcom/bytedance/android/live/recharge/config/RechargePanelSettingConfig;", 1)), Reflection.property0(new PropertyReference0Impl(j.class, "LIVE_RECHARGE_PANEL_BACKGROUND_TRANSPARENT", "getLIVE_RECHARGE_PANEL_BACKGROUND_TRANSPARENT()Z", 1))};
        a = r0;
        com.bytedance.tools.kcp.ultrasettings.runtime.a r1 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("cash_exchange_frequency_config", new d(), d.class, false);
        b = UltraSettingsManager.a().a(r1.a, r1.b, r1.getType(), r1.d, r0[0]);
        Class r13 = Integer.TYPE;
        com.bytedance.tools.kcp.ultrasettings.runtime.a r2 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_exchange_dialog_frequency", 0, r13, false);
        c = UltraSettingsManager.a().a(r2.a, r2.b, r2.getType(), r2.d, r0[1]);
        Boolean r14 = Boolean.TRUE;
        Class r15 = Boolean.TYPE;
        com.bytedance.tools.kcp.ultrasettings.runtime.a r3 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_base_popup_manager_enable", r14, r15, false);
        d = UltraSettingsManager.a().a(r3.a, r3.b, r3.getType(), r3.d, r0[2]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r4 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_wallet_info_request_time", 0, r13, false);
        e = UltraSettingsManager.a().a(r4.a, r4.b, r4.getType(), r4.d, r0[3]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r5 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_lynx_exchange_dialog", "sslocal://webcast_lynxview?url=https%3A%2F%2Flf-webcast-sourcecdn-tos.bytegecko.com%2Fobj%2Fbyte-gurd-source%2Fwebcast%2Fmono%2Flynx%2Frevenue_exchange_saas%2Fpages%2Fexchange_panel%2Ftemplate.js%3FenterFrom%3Dgift_entrance&type=popup&height_percent=55&width_percent=100&gravity=bottom&enable_latch=1&initialProps=%5B%22setting%3Aaweme_lite_live_income_exchange%3Alive_show_income_exchange_reminder%3Alive_redeem_ploy_exchange%3Alive_trial_diamond_exchange%22%5D", String.class, false);
        f = UltraSettingsManager.a().a(r5.a, r5.b, r5.getType(), r5.d, r0[4]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r6 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_exchange_reason_map", new LinkedHashMap(), wn3.a.a, false);
        g = UltraSettingsManager.a().a(r6.a, r6.b, r6.getType(), r6.d, r0[5]);
        KmpEnv r7 = KmpEnv.a;
        if (KmpEnv.a() == false) goto L5;
        String r8 = "sslocal://webcast_webview?url=https%3A%2F%2Fsf3-draftcdn-tos.pstatp.com%2Fobj%2Fies-hotsoon-draft%2Fdouyin%2F36ba590b-4606-410f-b035-bc38f7ef6a50.html";
    L6:
        com.bytedance.tools.kcp.ultrasettings.runtime.a r9 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("charge_protocol", r8, String.class, false);
        h = UltraSettingsManager.a().a(r9.a, r9.b, r9.getType(), r9.d, r0[6]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r10 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_purchase_safe_remind_schema", "sslocal://webcast_webview?url=https%3A%2F%2Flf-webcast-gr-sourcecdn.bytegecko.com%2Fobj%2Fbyte-gurd-source-gr%2Fwebcast%2Fmono%2Fh5%2Fwallet_money_douyin%2Fpages%2Frecharge_safety_reminder%2Findex.html&hide_nav_bar=1", String.class, false);
        i = UltraSettingsManager.a().a(r10.a, r10.b, r10.getType(), r10.d, r0[7]);
        Boolean r12 = Boolean.FALSE;
        com.bytedance.tools.kcp.ultrasettings.runtime.a r16 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_incentives_experiment_enable", r12, r15, false);
        j = UltraSettingsManager.a().a(r16.a, r16.b, r16.getType(), r16.d, r0[8]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r17 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_lynx_exchange_dialog_shortcut", "sslocal://webcast_lynxview?url=https%3A%2F%2Flf-webcast-sourcecdn-tos.bytegecko.com%2Fobj%2Fbyte-gurd-source%2Fwebcast%2Fmono%2Flynx%2Frevenue_exchange_douyin%2Fpages%2Fexchange_panel%2Ftemplate.js%3FenterFrom%3Dshortcut&type=popup&height_percent=55&width_percent=100&gravity=bottom&enable_latch=1&initialProps=%5B%22setting%3Aaweme_lite_live_income_exchange%3Alive_show_income_exchange_reminder%3Alive_redeem_ploy_exchange%22%5D", String.class, false);
        k = UltraSettingsManager.a().a(r17.a, r17.b, r17.getType(), r17.d, r0[9]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r18 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_recharge_panel_use_cache_data", new RechargeCacheConfig(), RechargeCacheConfig.class, false);
        l = UltraSettingsManager.a().a(r18.a, r18.b, r18.getType(), r18.d, r0[10]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r19 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_balance_cache_update", new b(), b.class, false);
        m = UltraSettingsManager.a().a(r19.a, r19.b, r19.getType(), r19.d, r0[11]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r20 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_user_change_sync_disable", r12, r15, false);
        n = UltraSettingsManager.a().a(r20.a, r20.b, r20.getType(), r20.d, r0[12]);
        o = new ClientABTestKey("live_recharge_enable_cache_precision", r15, r12, 1);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r22 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_exchange_diamond_process_optimization", new c(), c.class, false);
        p = UltraSettingsManager.a().a(r22.a, r22.b, r22.getType(), r22.d, r0[13]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r23 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_open_treasure_box_schema", "sslocal://webcast_webview?url=https%3A%2F%2Flf-webcast-gr-sourcecdn.bytegecko.com%2Fobj%2Fbyte-gurd-source-gr%2Fwebcast%2Fmono%2Fh5%2Ftask_center_douyin_h5_douyin%2Fpages%2Ftask_panel%2Findex.html%3Forigin_page%3Dtool_bar_icon&enable_preload=all&type=popup&gravity=bottom&height_percent=56&add_safe_area_height=0&use_real_screen_height=1&radius=20", String.class, false);
        q = UltraSettingsManager.a().a(r23.a, r23.b, r23.getType(), r23.d, r0[14]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r24 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_exchange_count_down_time_request_enable", r12, r15, false);
        r = UltraSettingsManager.a().a(r24.a, r24.b, r24.getType(), r24.d, r0[15]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r25 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_open_exchange_intro_schema", "sslocal://webcast_webview?url=https%3A%2F%2Flf3-cdn-tos.draftstatic.com%2Fobj%2Fies-hotsoon-draft%2F2329_lite%2Fe0c7a0ed-8361-4f56-9e62-8e0ab46fc607.html&hide_nav_bar=0&hide_status_bar=0", String.class, false);
        s = UltraSettingsManager.a().a(r25.a, r25.b, r25.getType(), r25.d, r0[16]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r26 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_open_exchange_intro_scheme_tax_saving", "sslocal://webcast_webview?url=https%3A%2F%2Flf3-cdn-tos.draftstatic.com%2Fobj%2Fies-hotsoon-draft%2F2329_lite%2Fd319a114-9b06-4018-8fa9-64fb879838a5.html&hide_nav_bar=0&hide_status_bar=0", String.class, false);
        t = UltraSettingsManager.a().a(r26.a, r26.b, r26.getType(), r26.d, r0[17]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r27 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_check_iac_financial_visable", r12, r15, false);
        u = UltraSettingsManager.a().a(r27.a, r27.b, r27.getType(), r27.d, r0[18]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r28 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_recharge_banner_use_annix", r12, r15, false);
        v = UltraSettingsManager.a().a(r28.a, r28.b, r28.getType(), r28.d, r0[19]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r29 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_recharge_banner_use_cache", r14, r15, false);
        w = UltraSettingsManager.a().a(r29.a, r29.b, r29.getType(), r29.d, r0[20]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r30 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_recharge_google_iap_config", new com.bytedance.android.live.wallet.pay.iap.e(), com.bytedance.android.live.wallet.pay.iap.e.class, false);
        x = UltraSettingsManager.a().a(r30.a, r30.b, r30.getType(), r30.d, r0[21]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r32 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_recharge_trace_config", new com.bytedance.android.live.recharge.trace.g(), com.bytedance.android.live.recharge.trace.g.class, false);
        y = UltraSettingsManager.a().a(r32.a, r32.b, r32.getType(), r32.d, r0[22]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r33 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_custom_recharge_dynamic_config", zx.a.a, zx.a.class, false);
        z = UltraSettingsManager.a().a(r33.a, r33.b, r33.getType(), r33.d, r0[23]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r34 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_wallet_log_use_event_tracker_switch", r14, r15, false);
        A = UltraSettingsManager.a().a(r34.a, r34.b, r34.getType(), r34.d, r0[24]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r35 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_recharge_one_step_preload_config", -1L, Long.TYPE, false);
        B = UltraSettingsManager.a().a(r35.a, r35.b, r35.getType(), r35.d, r0[25]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r36 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_recharge_panel_pad_ui_fix", r14, r15, false);
        C = UltraSettingsManager.a().a(r36.a, r36.b, r36.getType(), r36.d, r0[26]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r37 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_recharge_panel_one_step_loading_block", r14, r15, false);
        D = UltraSettingsManager.a().a(r37.a, r37.b, r37.getType(), r37.d, r0[27]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r38 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("livesdk_clientAI_preorder_enable", r12, r15, false);
        E = UltraSettingsManager.a().a(r38.a, r38.b, r38.getType(), r38.d, r0[28]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r39 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_recharge_panel_setting_config", new com.bytedance.android.live.recharge.config.b(), com.bytedance.android.live.recharge.config.b.class, false);
        F = UltraSettingsManager.a().a(r39.a, r39.b, r39.getType(), r39.d, r0[29]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r40 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_recharge_panel_background_opt", r12, r15, false);
        G = UltraSettingsManager.a().a(r40.a, r40.b, r40.getType(), r40.d, r0[30]);
        return;
    L5:
        r8 = "";
        goto L6
    }
}
