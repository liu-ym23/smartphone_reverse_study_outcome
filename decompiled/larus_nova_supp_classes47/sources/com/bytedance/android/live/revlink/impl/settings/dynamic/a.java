package com.bytedance.android.live.revlink.impl.settings.dynamic;

import com.bytedance.tools.kcp.modelx.runtime.internal.decode.SerializableObjectJsonAdapterBase;
import com.bytedance.tools.kcp.ultrasettings.runtime.UltraSettingsManager;
import com.google.gson.annotations.JsonAdapter;
import java.lang.reflect.Constructor;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.properties.ReadOnlyProperty;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class a {
    public static final ReadOnlyProperty A = null;
    public static final ReadOnlyProperty B = null;
    public static final ReadOnlyProperty C = null;
    public static final ReadOnlyProperty D = null;
    public static final ReadOnlyProperty E = null;
    public static final ReadOnlyProperty F = null;
    public static final ReadOnlyProperty G = null;
    public static final a H = null;
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

    public a() {
    }

    public final String[] a() {
        return (String[]) e.getValue(this, a[3]);
    }

    public final boolean b() {
        return ((Boolean) t.getValue(this, a[18])).booleanValue();
    }

    public final boolean c() {
        return ((Boolean) C.getValue(this, a[27])).booleanValue();
    }

    public final long d() {
        return ((Number) j.getValue(this, a[8])).longValue();
    }

    public final boolean e() {
        return ((Boolean) g.getValue(this, a[5])).booleanValue();
    }

    public final boolean f() {
        return ((Boolean) b.getValue(this, a[0])).booleanValue();
    }

    public final boolean g() {
        return ((Boolean) s.getValue(this, a[17])).booleanValue();
    }

    static {
        KProperty[] r0 = {Reflection.property1(new PropertyReference1Impl(a.class, "livePreviewPkDynamicHubLoadEnable", "getLivePreviewPkDynamicHubLoadEnable()Z", 0)), Reflection.property1(new PropertyReference1Impl(a.class, "livePkLynxControlTeamTaskEnable", "getLivePkLynxControlTeamTaskEnable()I", 0)), Reflection.property1(new PropertyReference1Impl(a.class, "livePkDynamicHubLynxParams", "getLivePkDynamicHubLynxParams()Ljava/lang/String;", 0)), Reflection.property1(new PropertyReference1Impl(a.class, "liveFeedEventBlockList", "getLiveFeedEventBlockList()[Ljava/lang/String;", 0)), Reflection.property1(new PropertyReference1Impl(a.class, "livePkDynamicHubLoadTraceEnable", "getLivePkDynamicHubLoadTraceEnable()Z", 0)), Reflection.property1(new PropertyReference1Impl(a.class, "livePkLynxControlNativeViewEnable", "getLivePkLynxControlNativeViewEnable()Z", 0)), Reflection.property1(new PropertyReference1Impl(a.class, "liveFeedHybridMeasureOpt", "getLiveFeedHybridMeasureOpt()Z", 0)), Reflection.property1(new PropertyReference1Impl(a.class, "livePkHybridJsGroupShare", "getLivePkHybridJsGroupShare()Z", 0)), Reflection.property1(new PropertyReference1Impl(a.class, "livePkFeedInitDelay", "getLivePkFeedInitDelay()J", 0)), Reflection.property1(new PropertyReference1Impl(a.class, "liveKtvInitDelay", "getLiveKtvInitDelay()Z", 0)), Reflection.property1(new PropertyReference1Impl(a.class, "liveMultiTestDynamicLoadEnable", "getLiveMultiTestDynamicLoadEnable()Z", 0)), Reflection.property1(new PropertyReference1Impl(a.class, "liveMultiDynamicHubLynxParams", "getLiveMultiDynamicHubLynxParams()Ljava/lang/String;", 0)), Reflection.property1(new PropertyReference1Impl(a.class, "liveDoubleDynamicHubUseAnnieX", "getLiveDoubleDynamicHubUseAnnieX()Z", 0)), Reflection.property1(new PropertyReference1Impl(a.class, "liveMultiDynamicHubUseAnnieX", "getLiveMultiDynamicHubUseAnnieX()Z", 0)), Reflection.property1(new PropertyReference1Impl(a.class, "liveMultiFeedDynamicHubUseAnnieX", "getLiveMultiFeedDynamicHubUseAnnieX()Z", 0)), Reflection.property1(new PropertyReference1Impl(a.class, "livePKHybridUseAnnieX", "getLivePKHybridUseAnnieX()Z", 0)), Reflection.property1(new PropertyReference1Impl(a.class, "liveAnnieXExecuteLoadFailed", "getLiveAnnieXExecuteLoadFailed()Z", 0)), Reflection.property1(new PropertyReference1Impl(a.class, "revnueInteractDataFormat", "getRevnueInteractDataFormat()Z", 0)), Reflection.property1(new PropertyReference1Impl(a.class, "livePkEnableLynxAnchorMicPanel", "getLivePkEnableLynxAnchorMicPanel()Z", 0)), Reflection.property1(new PropertyReference1Impl(a.class, "liveMultiAnnieXExecuteLoadFailed", "getLiveMultiAnnieXExecuteLoadFailed()Z", 0)), Reflection.property1(new PropertyReference1Impl(a.class, "livePkDoubleLynxMicEnable", "getLivePkDoubleLynxMicEnable()Z", 0)), Reflection.property1(new PropertyReference1Impl(a.class, "createLinkLynxLoadEnable", "getCreateLinkLynxLoadEnable()Z", 0)), Reflection.property1(new PropertyReference1Impl(a.class, "linkControlCenterLynxGroupName", "getLinkControlCenterLynxGroupName()Ljava/lang/String;", 0)), Reflection.property1(new PropertyReference1Impl(a.class, "livePkDoubleLinkScoreLynxEnable", "getLivePkDoubleLinkScoreLynxEnable()Z", 0)), Reflection.property1(new PropertyReference1Impl(a.class, "createLinkHubUrl", "getCreateLinkHubUrl()Ljava/lang/String;", 0)), Reflection.property1(new PropertyReference1Impl(a.class, "createLinkHubAnineX", "getCreateLinkHubAnineX()Z", 0)), Reflection.property1(new PropertyReference1Impl(a.class, "livePkInteractCommentLynxEnable", "getLivePkInteractCommentLynxEnable()Z", 0)), Reflection.property1(new PropertyReference1Impl(a.class, "livePkEnablePanelListOpt", "getLivePkEnablePanelListOpt()Z", 0)), Reflection.property1(new PropertyReference1Impl(a.class, "liveDynamicHubLynxV2Opt", "getLiveDynamicHubLynxV2Opt()Z", 0)), Reflection.property1(new PropertyReference1Impl(a.class, "liveMultiDynamicHubLynxParamsV2", "getLiveMultiDynamicHubLynxParamsV2()Ljava/lang/String;", 0)), Reflection.property1(new PropertyReference1Impl(a.class, "liveAiAssistantCellularConfig", "getLiveAiAssistantCellularConfig()Lcom/bytedance/android/live/revlink/impl/settings/config/AiAssistantCellularConfig;", 0)), Reflection.property1(new PropertyReference1Impl(a.class, "livePkMatchBellDialogUrl", "getLivePkMatchBellDialogUrl()Ljava/lang/String;", 0))};
        a = r0;
        H = new a();
        Boolean r13 = Boolean.FALSE;
        Class r14 = Boolean.TYPE;
        com.bytedance.tools.kcp.ultrasettings.runtime.a r1 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_pk_preview_stream_support_dynamic_enable", r13, r14, false);
        b = UltraSettingsManager.a().a(r1.a, r1.b, r1.getType(), r1.d, r0[0]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r2 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_pk_lynx_control_team_task_enable", 0, Integer.TYPE, false);
        c = UltraSettingsManager.a().a(r2.a, r2.b, r2.getType(), r2.d, r0[1]);
        b03.a r12 = b03.a.a;
        if (b03.a.b() == false) goto L5;
        String r15 = "{\"lynx_url\":\"sslocal://webcast_lynxview?url=https%3A%2F%2Flf-webcast-gr-sourcecdn.bytegecko.com%2Fobj%2Fbyte-gurd-source-gr%2Fwebcast%2Fmono%2Flynx%2Frevenue_pk_hybrid_saas%2Fpages%2Fdynamic_central%2Ftemplate.js\",\"tag\":\"dynamic_central\",\"height\":50,\"width_radio\":1.0,\"horizontal_align\":2,\"vertical_align\":1,\"margin_top\":100,\"observer\":[\"pk_status\",\"change_screen\"]}";
    L6:
        com.bytedance.tools.kcp.ultrasettings.runtime.a r3 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_pk_dynamic_hub_lynx_params", r15, String.class, false);
        d = UltraSettingsManager.a().a(r3.a, r3.b, r3.getType(), r3.d, r0[2]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r4 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_feed_event_block_list", new String[0], zn3.a.l, false);
        e = UltraSettingsManager.a().a(r4.a, r4.b, r4.getType(), r4.d, r0[3]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r5 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_pk_dynamic_hub_load_trace_enable", r13, r14, false);
        f = UltraSettingsManager.a().a(r5.a, r5.b, r5.getType(), r5.d, r0[4]);
        Boolean r6 = Boolean.TRUE;
        com.bytedance.tools.kcp.ultrasettings.runtime.a r7 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_pk_lynx_control_native_view_enable", r6, r14, true);
        g = UltraSettingsManager.a().a(r7.a, r7.b, r7.getType(), r7.d, r0[5]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r8 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_feed_hybrid_measure_opt", r6, r14, false);
        h = UltraSettingsManager.a().a(r8.a, r8.b, r8.getType(), r8.d, r0[6]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r9 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_pk_hybrid_share_group", r6, r14, false);
        i = UltraSettingsManager.a().a(r9.a, r9.b, r9.getType(), r9.d, r0[7]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r10 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_pk_feed_init_delay", -1L, Long.TYPE, false);
        j = UltraSettingsManager.a().a(r10.a, r10.b, r10.getType(), r10.d, r0[8]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r16 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_pk_feed_ktv_init_delay", r6, r14, false);
        k = UltraSettingsManager.a().a(r16.a, r16.b, r16.getType(), r16.d, r0[9]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r17 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_multi_change_background_image_enable", r13, r14, false);
        l = UltraSettingsManager.a().a(r17.a, r17.b, r17.getType(), r17.d, r0[10]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r18 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_multi_change_background_image_centre_url", "{\"lynx_url\":\"sslocal://webcast_lynxview?url=https%3A%2F%2Flf-webcast-gr-sourcecdn.bytegecko.com%2Fobj%2Fbyte-gurd-source-gr%2Fwebcast%2Fmono%2Flynx%2Frevenue_pk_hybrid_douyin%2Fpages%2Fmulti_dynamic_demo%2Ftemplate.js\",\"tag\":\"dynamic_central\",\"height_radio\":1.0,\"width_radio\":1.0,\"horizontal_align\":2,\"vertical_align\":1,\"margin_top\":0,\"observer\":[\"pk_status\",\"change_screen\"]}", String.class, false);
        m = UltraSettingsManager.a().a(r18.a, r18.b, r18.getType(), r18.d, r0[11]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r19 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_double_dynamic_hub_use_annie_x", r13, r14, false);
        n = UltraSettingsManager.a().a(r19.a, r19.b, r19.getType(), r19.d, r0[12]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r20 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_multi_dynamic_hub_use_annie_x", r13, r14, false);
        o = UltraSettingsManager.a().a(r20.a, r20.b, r20.getType(), r20.d, r0[13]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r22 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_multi_feed_dynamic_hub_use_annie_x", r13, r14, false);
        p = UltraSettingsManager.a().a(r22.a, r22.b, r22.getType(), r22.d, r0[14]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r23 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_pk_hybrid_use_annie_x", r13, r14, false);
        q = UltraSettingsManager.a().a(r23.a, r23.b, r23.getType(), r23.d, r0[15]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r24 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_annie_x_execute_load_failed", r13, r14, false);
        r = UltraSettingsManager.a().a(r24.a, r24.b, r24.getType(), r24.d, r0[16]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r25 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_revenue_interact_dynamic_data_format", r13, r14, false);
        s = UltraSettingsManager.a().a(r25.a, r25.b, r25.getType(), r25.d, r0[17]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r26 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_pk_enable_lynx_anchor_mic_panel", r13, r14, false);
        t = UltraSettingsManager.a().a(r26.a, r26.b, r26.getType(), r26.d, r0[18]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r27 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_multi_annie_x_execute_load_failed", r13, r14, false);
        u = UltraSettingsManager.a().a(r27.a, r27.b, r27.getType(), r27.d, r0[19]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r28 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_pk_double_lynx_mic_enable", r6, r14, false);
        v = UltraSettingsManager.a().a(r28.a, r28.b, r28.getType(), r28.d, r0[20]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r29 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_link_control_center_enable", r13, r14, true);
        w = UltraSettingsManager.a().a(r29.a, r29.b, r29.getType(), r29.d, r0[21]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r30 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("link_control_center_lynx_group_name", "link_control_center", String.class, true);
        x = UltraSettingsManager.a().a(r30.a, r30.b, r30.getType(), r30.d, r0[22]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r32 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_pk_enable_lynx_double_link_score", r13, r14, false);
        y = UltraSettingsManager.a().a(r32.a, r32.b, r32.getType(), r32.d, r0[23]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r33 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_link_control_center_url", "sslocal://webcast_lynxview?bdhm_pid=link_control_center&business_type=link_control_center&group=link_control_center&url=https%3A%2F%2Flf-webcast-gr-sourcecdn.bytegecko.com%2Fobj%2Fbyte-gurd-source-gr%2Fwebcast%2Fmono%2Flynx%2Frevenue_link_saas%2Fpages%2Flink_control_center%2Ftemplate.js", String.class, false);
        z = UltraSettingsManager.a().a(r33.a, r33.b, r33.getType(), r33.d, r0[24]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r34 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("create_link_hub_anniex_enable", r13, r14, false);
        A = UltraSettingsManager.a().a(r34.a, r34.b, r34.getType(), r34.d, r0[25]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r35 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_pk_enable_lynx_interact_comment", r13, r14, false);
        B = UltraSettingsManager.a().a(r35.a, r35.b, r35.getType(), r35.d, r0[26]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r36 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_pk_enable_panel_list_opt", r13, r14, false);
        C = UltraSettingsManager.a().a(r36.a, r36.b, r36.getType(), r36.d, r0[27]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r37 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_dynamic_hub_lynx_v2_opt", r6, r14, false);
        D = UltraSettingsManager.a().a(r37.a, r37.b, r37.getType(), r37.d, r0[28]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r38 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_multi_dynamic_hub_lynx_params_v2", "{\"lynx_url\":\"sslocal://webcast_lynxview?url=https%3A%2F%2Flf-webcast-gr-sourcecdn.bytegecko.com%2Fobj%2Fbyte-gurd-source-gr%2Fwebcast%2Fmono%2Flynx%2Frevenue_pk_hybrid_saas%2Fpages%2Fdynamic_central_opt_v5%2Ftemplate.js%3Flive_pk_enable_lynx_title%3D1%26live_pk_enable_lynx_center_anim%3D1%26live_pk_enable_team_pk_bar%3D1%26live_pk_time_tik_sync_update%3D0%26score_ver_flag%3D1%26score_report_diff%3D800%26live_lynx_timer_correct%3D1%26live_pk_enable_lynx_mic%3D1%26use_regex_opt%3D1%26load_scene%3D7%26business_type%3Drev_link&business_type=rev_link&bdhm_pid=multi_dynamic_central\",\"tag\":\"multi_dynamic_central\",\"height_radio\":1.6,\"width_radio\":1.0,\"horizontal_align\":2,\"vertical_align\":2,\"observer\":[\"channel_id\",\"link_anchor_list\",\"guest_info\",\"sei\",\"screen_info\",\"interact_timer_count\",\"clean_screen\",\"play_status\",\"play_remain_time\",\"team_task\",\"survival_remain_time\",\"survival_stage_index\",\"show_last_result\",\"intercom_data\",\"pk_status\",\"pk_score\",\"pk_result\",\"team_task\",\"remain_time\",\"clean_screen\",\"change_screen\",\"link_anchor_info\",\"sei_data\",\"survival_remain_time\",\"survival_stage_index\",\"interact_start_time\", \"need_last_result\", \"double_mute_status\", \"ai_anchor_list\"],\"init_data\":[],  \"to_front\":1, \"super_view\":1}", String.class, false);
        E = UltraSettingsManager.a().a(r38.a, r38.b, r38.getType(), r38.d, r0[29]);
        Class r39 = r41.a.class.getAnnotation(JsonAdapter.class).value();
        ConcurrentHashMap r40 = vh7.b.a;
        Object r42 = r40.get(r39);
        if (r42 != null) goto L16;
        r42 = r39.getConstructor(new Class[0]);
        if (r42 == null) goto L15;
        Object r43 = r40.putIfAbsent(r39, r42);
        if (r43 == null) goto L16;
        r42 = r43;
        goto L16
    L15:
        throw new NullPointerException("null cannot be cast to non-null type java.lang.reflect.Constructor<out com.bytedance.tools.kcp.modelx.runtime.internal.decode.SerializableObjectJsonAdapterBase>");
    L16:
        Object r44 = ((SerializableObjectJsonAdapterBase) ((Constructor) r42).newInstance(new Object[0])).createInstance();
        if (r44 == null) goto L21;
        com.bytedance.tools.kcp.ultrasettings.runtime.a r45 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_revenue_ai_assistant_cellular_config", (r41.a) r44, r41.a.class, true);
        F = UltraSettingsManager.a().a(r45.a, r45.b, r45.getType(), r45.d, r0[30]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r46 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("revlink_pk_match_bell_dialog_url", "sslocal://webcast_lynxview?url=https%3A%2F%2Flf-webcast-gr-sourcecdn.bytegecko.com%2Fobj%2Fbyte-gurd-source-gr%2Fwebcast%2Fmono%2Flynx%2Frevenue_pk_panel_lynx_saas%2Fpages%2Fmatch_dialog%2Ftemplate.js&gravity=bottom&type=popup&rate_height=300&radius=8&pull_down_close=1&pull_down_indicator_not_show=1&compat_lynx_foldview=1&business_type=rev_link&panel_list_opt_backup=1", String.class, false);
        G = UltraSettingsManager.a().a(r46.a, r46.b, r46.getType(), r46.d, r0[31]);
        return;
    L21:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.live.revlink.impl.settings.config.AiAssistantCellularConfig");
    L5:
        r15 = "{\"lynx_url\":\"sslocal://webcast_lynxview?bdhm_pid=dynamic_central&url=https%3A%2F%2Flf-webcast-gr-sourcecdn.bytegecko.com%2Fobj%2Fbyte-gurd-source-gr%2Fwebcast%2Fmono%2Flynx%2Frevenue_pk_hybrid_saas%2Fpages%2Fdynamic_central%2Ftemplate.js%3Flive_pk_enable_lynx_title%3D1\",\"tag\":\"dynamic_central\",\"height_radio\":1.0,\"width_radio\":1.0, \"margin_top\": -75, \"horizontal_align\":2,\"vertical_align\":1, \"super_view\":2, \"observer\":[\"pk_status\",\"change_screen\", \"remain_time\",\"team_task\",\"interact_start_time\",\"sei_data\"],\"init_data\":[\"remain_time\",\"interact_start_time\"]}";
        goto L6
    }
}
