package y41;

import com.bytedance.live.kmp.core.KmpEnv;
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
public final class f {
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
    public static final f N = null;
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

    public f() {
    }

    public final boolean a() {
        return ((Boolean) z.getValue(this, a[24])).booleanValue();
    }

    public final boolean b() {
        return ((Boolean) x.getValue(this, a[22])).booleanValue();
    }

    public final boolean c() {
        return ((Boolean) M.getValue(this, a[37])).booleanValue();
    }

    public final boolean d() {
        return ((Boolean) H.getValue(this, a[32])).booleanValue();
    }

    public final boolean e() {
        return ((Boolean) s.getValue(this, a[17])).booleanValue();
    }

    public final boolean f() {
        return ((Boolean) b.getValue(this, a[0])).booleanValue();
    }

    public final boolean g() {
        return ((Boolean) w.getValue(this, a[21])).booleanValue();
    }

    public final boolean h() {
        return ((Boolean) f.getValue(this, a[4])).booleanValue();
    }

    public final boolean i() {
        return ((Boolean) E.getValue(this, a[29])).booleanValue();
    }

    static {
        KProperty[] r0 = {Reflection.property1(new PropertyReference1Impl(f.class, "multiAnchorRemoveDataHolder", "getMultiAnchorRemoveDataHolder()Z", 0)), Reflection.property1(new PropertyReference1Impl(f.class, "multiAnchorLeaveLinkRefactorDisable", "getMultiAnchorLeaveLinkRefactorDisable()Z", 0)), Reflection.property1(new PropertyReference1Impl(f.class, "enableInviteClearWhenTimeout", "getEnableInviteClearWhenTimeout()Z", 0)), Reflection.property1(new PropertyReference1Impl(f.class, "enableVideoMixPlanarRender", "getEnableVideoMixPlanarRender()Z", 0)), Reflection.property1(new PropertyReference1Impl(f.class, "multiLinkUseNewRtcConnectModel", "getMultiLinkUseNewRtcConnectModel()Z", 0)), Reflection.property1(new PropertyReference1Impl(f.class, "defaultMuteRemoteUser", "getDefaultMuteRemoteUser()Z", 0)), Reflection.property1(new PropertyReference1Impl(f.class, "multiLinkUseReplyLinkedUsers", "getMultiLinkUseReplyLinkedUsers()Z", 0)), Reflection.property1(new PropertyReference1Impl(f.class, "multiLinkRemoveWindowByLeaveMsg", "getMultiLinkRemoveWindowByLeaveMsg()Z", 0)), Reflection.property1(new PropertyReference1Impl(f.class, "multiLinkMockCrossTalk", "getMultiLinkMockCrossTalk()Z", 0)), Reflection.property1(new PropertyReference1Impl(f.class, "multiLinkNewConnectAdaptSwitchStream", "getMultiLinkNewConnectAdaptSwitchStream()Z", 0)), Reflection.property1(new PropertyReference1Impl(f.class, "multiAudienceSuperPreload", "getMultiAudienceSuperPreload()Z", 0)), Reflection.property1(new PropertyReference1Impl(f.class, "multiAnchorSingleViewOverlapCheck", "getMultiAnchorSingleViewOverlapCheck()Z", 0)), Reflection.property1(new PropertyReference1Impl(f.class, "multiAnchorSeiOverlapCheck", "getMultiAnchorSeiOverlapCheck()Z", 0)), Reflection.property1(new PropertyReference1Impl(f.class, "multiAnchorSeiOverlapReportControl", "getMultiAnchorSeiOverlapReportControl()J", 0)), Reflection.property1(new PropertyReference1Impl(f.class, "multiAnchorPkEnable", "getMultiAnchorPkEnable()Z", 0)), Reflection.property1(new PropertyReference1Impl(f.class, "nineMultiAnchorPkEnable", "getNineMultiAnchorPkEnable()Z", 0)), Reflection.property1(new PropertyReference1Impl(f.class, "nineMultiAnchorEnlargeEnable", "getNineMultiAnchorEnlargeEnable()Z", 0)), Reflection.property1(new PropertyReference1Impl(f.class, "multiAnchorMarginReviseEnable", "getMultiAnchorMarginReviseEnable()Z", 0)), Reflection.property1(new PropertyReference1Impl(f.class, "nineMultiClientMixerPerfLimit", "getNineMultiClientMixerPerfLimit()F", 0)), Reflection.property1(new PropertyReference1Impl(f.class, "multiAsyncPreloadData", "getMultiAsyncPreloadData()Z", 0)), Reflection.property1(new PropertyReference1Impl(f.class, "multiFixedMoveDist", "getMultiFixedMoveDist()I", 0)), Reflection.property1(new PropertyReference1Impl(f.class, "multiConfigureBgEnable", "getMultiConfigureBgEnable()Z", 0)), Reflection.property1(new PropertyReference1Impl(f.class, "LIVE_MULTI_LEAVE_USER_CACHE_TRY_CATCH", "getLIVE_MULTI_LEAVE_USER_CACHE_TRY_CATCH()Z", 0)), Reflection.property1(new PropertyReference1Impl(f.class, "enableLeaveWithFriends", "getEnableLeaveWithFriends()Z", 0)), Reflection.property1(new PropertyReference1Impl(f.class, "disableLeaveWithMultiFriends", "getDisableLeaveWithMultiFriends()Z", 0)), Reflection.property1(new PropertyReference1Impl(f.class, "enableNormalRtcLeaveKickOut", "getEnableNormalRtcLeaveKickOut()Z", 0)), Reflection.property1(new PropertyReference1Impl(f.class, "relinkInterceptRtcLeaveKickOutDuration", "getRelinkInterceptRtcLeaveKickOutDuration()J", 0)), Reflection.property1(new PropertyReference1Impl(f.class, "RELINK_INVITE_TIMEOUT_DURATION", "getRELINK_INVITE_TIMEOUT_DURATION()J", 0)), Reflection.property1(new PropertyReference1Impl(f.class, "multiDelayPreviewLynxLoad", "getMultiDelayPreviewLynxLoad()Z", 0)), Reflection.property1(new PropertyReference1Impl(f.class, "revAsyncBackgroundControl", "getRevAsyncBackgroundControl()Z", 0)), Reflection.property1(new PropertyReference1Impl(f.class, "multiBlockPkRenderViewRequestLayout", "getMultiBlockPkRenderViewRequestLayout()I", 0)), Reflection.property1(new PropertyReference1Impl(f.class, "liveSeiFrameCompareTimeStamp", "getLiveSeiFrameCompareTimeStamp()Z", 0)), Reflection.property1(new PropertyReference1Impl(f.class, "liveMultiRelayoutOpt", "getLiveMultiRelayoutOpt()Z", 0)), Reflection.property1(new PropertyReference1Impl(f.class, "liveMultiAnchorMoreResize", "getLiveMultiAnchorMoreResize()Z", 0)), Reflection.property1(new PropertyReference1Impl(f.class, "multiBgMonitorConfig", "getMultiBgMonitorConfig()Lcom/bytedance/android/live/revlink/impl/multianchor/player/layoutmanager/IMultiBgMonitorConfig;", 0)), Reflection.property1(new PropertyReference1Impl(f.class, "liveMultiTeamTaskFixEnable", "getLiveMultiTeamTaskFixEnable()Z", 0)), Reflection.property1(new PropertyReference1Impl(f.class, "liveRevenueVolumeIndicatorConfig", "getLiveRevenueVolumeIndicatorConfig()Lcom/bytedance/android/live/revlink/impl/settings/config/LiveRevenueVolumeIndicatorConfig;", 0)), Reflection.property1(new PropertyReference1Impl(f.class, "liveMultiPkSofaOpt", "getLiveMultiPkSofaOpt()Z", 0))};
        a = r0;
        N = new f();
        Boolean r13 = Boolean.TRUE;
        Class r14 = Boolean.TYPE;
        com.bytedance.tools.kcp.ultrasettings.runtime.a r1 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("multi_anchor_remove_data_holder", r13, r14, false);
        b = UltraSettingsManager.a().a(r1.a, r1.b, r1.getType(), r1.d, r0[0]);
        Boolean r12 = Boolean.FALSE;
        com.bytedance.tools.kcp.ultrasettings.runtime.a r2 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("multi_anchor_leave_link_refactor_disable", r12, r14, false);
        c = UltraSettingsManager.a().a(r2.a, r2.b, r2.getType(), r2.d, r0[1]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r3 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("multi_invitee_clear_by_timeout", r13, r14, false);
        d = UltraSettingsManager.a().a(r3.a, r3.b, r3.getType(), r3.d, r0[2]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r4 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("multi_link_video_mix_planar_render", r12, r14, false);
        e = UltraSettingsManager.a().a(r4.a, r4.b, r4.getType(), r4.d, r0[3]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r5 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("multi_link_use_new_rtc_connect_model", r13, r14, false);
        f = UltraSettingsManager.a().a(r5.a, r5.b, r5.getType(), r5.d, r0[4]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r6 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("multi_link_default_mute_remote", r13, r14, false);
        g = UltraSettingsManager.a().a(r6.a, r6.b, r6.getType(), r6.d, r0[5]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r7 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("multi_link_use_reply_linked_users", r13, r14, false);
        h = UltraSettingsManager.a().a(r7.a, r7.b, r7.getType(), r7.d, r0[6]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r8 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("multi_link_remove_window_by_leave_msg", r13, r14, false);
        i = UltraSettingsManager.a().a(r8.a, r8.b, r8.getType(), r8.d, r0[7]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r9 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("multi_link_mock_cross_talk_problem", r12, r14, false);
        j = UltraSettingsManager.a().a(r9.a, r9.b, r9.getType(), r9.d, r0[8]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r10 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("multi_link_new_connect_adapt_switch_stream", r13, r14, false);
        k = UltraSettingsManager.a().a(r10.a, r10.b, r10.getType(), r10.d, r0[9]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r15 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_multi_audience_super_preload", r13, r14, false);
        l = UltraSettingsManager.a().a(r15.a, r15.b, r15.getType(), r15.d, r0[10]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r16 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_multi_anchor_single_view_overlap_check", r13, r14, false);
        m = UltraSettingsManager.a().a(r16.a, r16.b, r16.getType(), r16.d, r0[11]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r17 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_multi_anchor_sei_overlap_check", r13, r14, false);
        n = UltraSettingsManager.a().a(r17.a, r17.b, r17.getType(), r17.d, r0[12]);
        Class r18 = Long.TYPE;
        com.bytedance.tools.kcp.ultrasettings.runtime.a r19 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_multi_anchor_sei_overlap_report_control", 30000L, r18, false);
        o = UltraSettingsManager.a().a(r19.a, r19.b, r19.getType(), r19.d, r0[13]);
        KmpEnv r20 = KmpEnv.a;
        com.bytedance.tools.kcp.ultrasettings.runtime.a r22 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("multi_anchor_pk_enable", Boolean.valueOf(KmpEnv.a()), r14, false);
        p = UltraSettingsManager.a().a(r22.a, r22.b, r22.getType(), r22.d, r0[14]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r23 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_revenue_interact_so_many_anchor", r12, r14, false);
        q = UltraSettingsManager.a().a(r23.a, r23.b, r23.getType(), r23.d, r0[15]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r24 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_revenue_interact_so_many_anchor_enlarge", r12, r14, false);
        r = UltraSettingsManager.a().a(r24.a, r24.b, r24.getType(), r24.d, r0[16]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r25 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_rev_anchor_margin_enable", r12, r14, false);
        s = UltraSettingsManager.a().a(r25.a, r25.b, r25.getType(), r25.d, r0[17]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r26 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_multi_nine_pk_client_mixer_performance_limit", Float.valueOf(5.0f), Float.TYPE, false);
        t = UltraSettingsManager.a().a(r26.a, r26.b, r26.getType(), r26.d, r0[18]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r27 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_multi_async_preload_data", r13, r14, false);
        u = UltraSettingsManager.a().a(r27.a, r27.b, r27.getType(), r27.d, r0[19]);
        Class r28 = Integer.TYPE;
        com.bytedance.tools.kcp.ultrasettings.runtime.a r29 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_fixed_move_dist", 0, r28, false);
        v = UltraSettingsManager.a().a(r29.a, r29.b, r29.getType(), r29.d, r0[20]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r30 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_multi_configure_bg_enable", r13, r14, false);
        w = UltraSettingsManager.a().a(r30.a, r30.b, r30.getType(), r30.d, r0[21]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r32 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_multi_leave_user_cache_try_catch", r12, r14, false);
        x = UltraSettingsManager.a().a(r32.a, r32.b, r32.getType(), r32.d, r0[22]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r33 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_multi_leave_with_friends", r13, r14, false);
        y = UltraSettingsManager.a().a(r33.a, r33.b, r33.getType(), r33.d, r0[23]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r34 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_disable_leave_with_multi_friends", r12, r14, false);
        z = UltraSettingsManager.a().a(r34.a, r34.b, r34.getType(), r34.d, r0[24]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r35 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_enable_normal_rtc_leave_kickout", r12, r14, false);
        A = UltraSettingsManager.a().a(r35.a, r35.b, r35.getType(), r35.d, r0[25]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r36 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("relink_intercept_rtc_leave_kickout_duration", 15L, r18, false);
        B = UltraSettingsManager.a().a(r36.a, r36.b, r36.getType(), r36.d, r0[26]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r37 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("multi_anchor_relink_invite_timeout_duration", 30L, r18, false);
        C = UltraSettingsManager.a().a(r37.a, r37.b, r37.getType(), r37.d, r0[27]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r38 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_multi_delay_preview_lynx_load", r13, r14, false);
        D = UltraSettingsManager.a().a(r38.a, r38.b, r38.getType(), r38.d, r0[28]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r39 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("rev_async_background_control", r12, r14, false);
        E = UltraSettingsManager.a().a(r39.a, r39.b, r39.getType(), r39.d, r0[29]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r40 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("multi_block_pk_render_view_request_layout", 0, r28, false);
        F = UltraSettingsManager.a().a(r40.a, r40.b, r40.getType(), r40.d, r0[30]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r42 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_sei_frame_compare_timestamp", r13, r14, false);
        G = UltraSettingsManager.a().a(r42.a, r42.b, r42.getType(), r42.d, r0[31]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r43 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_rev_multi_relayout_opt", r13, r14, false);
        H = UltraSettingsManager.a().a(r43.a, r43.b, r43.getType(), r43.d, r0[32]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r44 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_revlink_anchor_more_resize", r13, r14, false);
        I = UltraSettingsManager.a().a(r44.a, r44.b, r44.getType(), r44.d, r0[33]);
        Class r45 = com.bytedance.android.live.revlink.impl.multianchor.player.layoutmanager.a.class.getAnnotation(JsonAdapter.class).value();
        ConcurrentHashMap r46 = vh7.b.a;
        Object r47 = r46.get(r45);
        if (r47 != null) goto L12;
        r47 = r45.getConstructor(new Class[0]);
        if (r47 == null) goto L11;
        Object r48 = r46.putIfAbsent(r45, r47);
        if (r48 == null) goto L12;
        r47 = r48;
        goto L12
    L11:
        throw new NullPointerException("null cannot be cast to non-null type java.lang.reflect.Constructor<out com.bytedance.tools.kcp.modelx.runtime.internal.decode.SerializableObjectJsonAdapterBase>");
    L12:
        Object r49 = ((SerializableObjectJsonAdapterBase) ((Constructor) r47).newInstance(new Object[0])).createInstance();
        if (r49 == null) goto L31;
        com.bytedance.tools.kcp.ultrasettings.runtime.a r50 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("multi_bg_monitor_config", (com.bytedance.android.live.revlink.impl.multianchor.player.layoutmanager.a) r49, com.bytedance.android.live.revlink.impl.multianchor.player.layoutmanager.a.class, false);
        J = UltraSettingsManager.a().a(r50.a, r50.b, r50.getType(), r50.d, r0[34]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r52 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_multi_team_task_fix_enable", r12, r14, false);
        K = UltraSettingsManager.a().a(r52.a, r52.b, r52.getType(), r52.d, r0[35]);
        Class r53 = r41.e.class.getAnnotation(JsonAdapter.class).value();
        Object r54 = r46.get(r53);
        if (r54 != null) goto L24;
        r54 = r53.getConstructor(new Class[0]);
        if (r54 == null) goto L23;
        Object r55 = r46.putIfAbsent(r53, r54);
        if (r55 == null) goto L24;
        r54 = r55;
        goto L24
    L23:
        throw new NullPointerException("null cannot be cast to non-null type java.lang.reflect.Constructor<out com.bytedance.tools.kcp.modelx.runtime.internal.decode.SerializableObjectJsonAdapterBase>");
    L24:
        Object r56 = ((SerializableObjectJsonAdapterBase) ((Constructor) r54).newInstance(new Object[0])).createInstance();
        if (r56 == null) goto L29;
        com.bytedance.tools.kcp.ultrasettings.runtime.a r57 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_revenue_volume_indicator_config", (r41.e) r56, r41.e.class, false);
        L = UltraSettingsManager.a().a(r57.a, r57.b, r57.getType(), r57.d, r0[36]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r58 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_multi_pk_sofa_opt", r12, r14, false);
        M = UltraSettingsManager.a().a(r58.a, r58.b, r58.getType(), r58.d, r0[37]);
        return;
    L29:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.live.revlink.impl.settings.config.LiveRevenueVolumeIndicatorConfig");
    L31:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.live.revlink.impl.multianchor.player.layoutmanager.IMultiBgMonitorConfig");
    }
}
