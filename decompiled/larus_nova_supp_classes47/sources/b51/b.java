package b51;

import com.bytedance.android.live.profile.monitor.DataType;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.SerializableObjectJsonAdapterBase;
import com.bytedance.tools.kcp.ultrasettings.runtime.UltraSettingsManager;
import com.google.gson.annotations.JsonAdapter;
import java.lang.reflect.Constructor;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.properties.ReadOnlyProperty;
import kotlin.reflect.KProperty;
import r11.d;
import r11.j;
import r11.n;
import r11.o;
import r11.p;
import r11.r;
import r11.s;
import r11.t;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
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
    public static final b c0 = null;
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

    public b() {
    }

    public final String a() {
        return (String) d.getValue(this, a[2]);
    }

    public final boolean b() {
        return ((Boolean) i.getValue(this, a[7])).booleanValue();
    }

    public final boolean c() {
        return ((Boolean) Y.getValue(this, a[49])).booleanValue();
    }

    public final j d() {
        return (j) y.getValue(this, a[23]);
    }

    public final s e() {
        return (s) w.getValue(this, a[21]);
    }

    public final n f() {
        return (n) b0.getValue(this, a[52]);
    }

    public final t g() {
        return (t) v.getValue(this, a[20]);
    }

    public final o h() {
        return (o) x.getValue(this, a[22]);
    }

    public final r i() {
        return (r) u.getValue(this, a[19]);
    }

    public final p j() {
        return (p) m.getValue(this, a[11]);
    }

    public final boolean k() {
        return ((Boolean) c.getValue(this, a[1])).booleanValue();
    }

    static {
        KProperty[] r0 = {Reflection.property1(new PropertyReference1Impl(b.class, "multiPkAutoMatchDisable", "getMultiPkAutoMatchDisable()Z", 0)), Reflection.property1(new PropertyReference1Impl(b.class, "multiAnchorEnableFeedbackDialog", "getMultiAnchorEnableFeedbackDialog()Z", 0)), Reflection.property1(new PropertyReference1Impl(b.class, "anchorRankTabName", "getAnchorRankTabName()Ljava/lang/String;", 0)), Reflection.property1(new PropertyReference1Impl(b.class, "pkTopBannerLynxUrl", "getPkTopBannerLynxUrl()Ljava/lang/String;", 0)), Reflection.property1(new PropertyReference1Impl(b.class, "pkSeasonRandomMatchLynxUrl", "getPkSeasonRandomMatchLynxUrl()Ljava/lang/String;", 0)), Reflection.property1(new PropertyReference1Impl(b.class, "liveLinkReserveInviteAndBeInviteFix", "getLiveLinkReserveInviteAndBeInviteFix()Z", 0)), Reflection.property1(new PropertyReference1Impl(b.class, "linkTopBannerLynxUrl", "getLinkTopBannerLynxUrl()Ljava/lang/String;", 0)), Reflection.property1(new PropertyReference1Impl(b.class, "liveAnchorListPanelPreloadEnable", "getLiveAnchorListPanelPreloadEnable()Z", 0)), Reflection.property1(new PropertyReference1Impl(b.class, "liveAnchorLinkingInvitePreloadStrategy", "getLiveAnchorLinkingInvitePreloadStrategy()Lcom/bytedance/android/live/revlink/impl/config/InvitePreloadStrategy;", 0)), Reflection.property1(new PropertyReference1Impl(b.class, "liveMultiShellPkEnable", "getLiveMultiShellPkEnable()Z", 0)), Reflection.property1(new PropertyReference1Impl(b.class, "livePkPanelSpeedUp", "getLivePkPanelSpeedUp()Z", 0)), Reflection.property1(new PropertyReference1Impl(b.class, "livePkPanelSizeOptS", "getLivePkPanelSizeOptS()Lcom/bytedance/android/live/revlink/impl/config/PkPanelSizeStrategy;", 0)), Reflection.property1(new PropertyReference1Impl(b.class, "livePkEnableFeedBackToast", "getLivePkEnableFeedBackToast()Z", 0)), Reflection.property1(new PropertyReference1Impl(b.class, "liveAnchorLinkBlockConcurrentApply", "getLiveAnchorLinkBlockConcurrentApply()Z", 0)), Reflection.property1(new PropertyReference1Impl(b.class, "livePkPanelSpeedUpV2", "getLivePkPanelSpeedUpV2()Z", 0)), Reflection.property1(new PropertyReference1Impl(b.class, "pkPanelOpt", "getPkPanelOpt()I", 0)), Reflection.property1(new PropertyReference1Impl(b.class, "pageLazyLoadEnable", "getPageLazyLoadEnable()Z", 0)), Reflection.property1(new PropertyReference1Impl(b.class, "pageEnableRankPanel", "getPageEnableRankPanel()Z", 0)), Reflection.property1(new PropertyReference1Impl(b.class, "pkRecShowFollowInfo", "getPkRecShowFollowInfo()Z", 0)), Reflection.property1(new PropertyReference1Impl(b.class, "livePkPanelS", "getLivePkPanelS()Lcom/bytedance/android/live/revlink/impl/config/PkPanelUpdateStrategy;", 0)), Reflection.property1(new PropertyReference1Impl(b.class, "livePkPanelAi", "getLivePkPanelAi()Lcom/bytedance/android/live/revlink/impl/config/RevLinkPanelPreloadAiConfig;", 0)), Reflection.property1(new PropertyReference1Impl(b.class, "livePkBubbleTipOpt", "getLivePkBubbleTipOpt()Lcom/bytedance/android/live/revlink/impl/config/PkTipStrategy;", 0)), Reflection.property1(new PropertyReference1Impl(b.class, "livePkPanelFollowS", "getLivePkPanelFollowS()Lcom/bytedance/android/live/revlink/impl/config/PkPanelFollowUpdateStrategy;", 0)), Reflection.property1(new PropertyReference1Impl(b.class, "liveLinkingInvitePanelS", "getLiveLinkingInvitePanelS()Lcom/bytedance/android/live/revlink/impl/config/LinkingPanelUpdateStrategy;", 0)), Reflection.property1(new PropertyReference1Impl(b.class, "linkAutoMatchParam", "getLinkAutoMatchParam()Lcom/bytedance/android/live/revlink/impl/settings/panel/LinkAutoMatchParam;", 0)), Reflection.property1(new PropertyReference1Impl(b.class, "livePkPlayPanelLynxUrl", "getLivePkPlayPanelLynxUrl()Ljava/lang/String;", 0)), Reflection.property1(new PropertyReference1Impl(b.class, "livePkPanelLynxEnable", "getLivePkPanelLynxEnable()Z", 0)), Reflection.property1(new PropertyReference1Impl(b.class, "livePkPanelLynxUrl", "getLivePkPanelLynxUrl()Ljava/lang/String;", 0)), Reflection.property1(new PropertyReference1Impl(b.class, "liveRandomMatchPanelLynxEnable", "getLiveRandomMatchPanelLynxEnable()Z", 0)), Reflection.property1(new PropertyReference1Impl(b.class, "liveRandomMatchPanelLynxUrl", "getLiveRandomMatchPanelLynxUrl()Ljava/lang/String;", 0)), Reflection.property1(new PropertyReference1Impl(b.class, "liveMultiRandomMatchPanelLynxUrl", "getLiveMultiRandomMatchPanelLynxUrl()Ljava/lang/String;", 0)), Reflection.property1(new PropertyReference1Impl(b.class, "liveInviteMorePanelLynxEnable", "getLiveInviteMorePanelLynxEnable()Z", 0)), Reflection.property1(new PropertyReference1Impl(b.class, "liveInviteMorePanelLynxUrl", "getLiveInviteMorePanelLynxUrl()Ljava/lang/String;", 0)), Reflection.property1(new PropertyReference1Impl(b.class, "liveMultiQuitConfirmDialogLynxEnable", "getLiveMultiQuitConfirmDialogLynxEnable()Z", 0)), Reflection.property1(new PropertyReference1Impl(b.class, "liveMultiQuitConfirmDialogLynxUrl", "getLiveMultiQuitConfirmDialogLynxUrl()Ljava/lang/String;", 0)), Reflection.property1(new PropertyReference1Impl(b.class, "liveBattleBeInvitedLynxEnable", "getLiveBattleBeInvitedLynxEnable()Z", 0)), Reflection.property1(new PropertyReference1Impl(b.class, "liveBattleBeInvitedDialogLynxUrl", "getLiveBattleBeInvitedDialogLynxUrl()Ljava/lang/String;", 0)), Reflection.property1(new PropertyReference1Impl(b.class, "liveRelinkInvitationDialogLynxEnable", "getLiveRelinkInvitationDialogLynxEnable()Z", 0)), Reflection.property1(new PropertyReference1Impl(b.class, "liveRelinkInvitationDialogLynxUrl", "getLiveRelinkInvitationDialogLynxUrl()Ljava/lang/String;", 0)), Reflection.property1(new PropertyReference1Impl(b.class, "liveRelinkWaitingDialogLynxUrl", "getLiveRelinkWaitingDialogLynxUrl()Ljava/lang/String;", 0)), Reflection.property1(new PropertyReference1Impl(b.class, "panelErrorOpt", "getPanelErrorOpt()Z", 0)), Reflection.property1(new PropertyReference1Impl(b.class, "recAbCrop", "getRecAbCrop()Ljava/lang/String;", 0)), Reflection.property1(new PropertyReference1Impl(b.class, "livePkPanelUpBannerUrl", "getLivePkPanelUpBannerUrl()Ljava/lang/String;", 0)), Reflection.property1(new PropertyReference1Impl(b.class, "liveLinkPanelRandomLinkUrl", "getLiveLinkPanelRandomLinkUrl()Ljava/lang/String;", 0)), Reflection.property1(new PropertyReference1Impl(b.class, "livePanelHistoryFeedBackUrl", "getLivePanelHistoryFeedBackUrl()Ljava/lang/String;", 0)), Reflection.property1(new PropertyReference1Impl(b.class, "liveMultiLinkRandomEntrance", "getLiveMultiLinkRandomEntrance()Z", 0)), Reflection.property1(new PropertyReference1Impl(b.class, "livePkReserveSettleMessageUrl", "getLivePkReserveSettleMessageUrl()Ljava/lang/String;", 0)), Reflection.property1(new PropertyReference1Impl(b.class, "liveLinkPanelOpt", "getLiveLinkPanelOpt$liverevlink_impl_saasRelease()I", 0)), Reflection.property1(new PropertyReference1Impl(b.class, "liveFoldingStrategyRemoveRoomJudge", "getLiveFoldingStrategyRemoveRoomJudge()Z", 0)), Reflection.property1(new PropertyReference1Impl(b.class, "liveEnableLocalReserveSetting", "getLiveEnableLocalReserveSetting()Z", 0)), Reflection.property1(new PropertyReference1Impl(b.class, "liveEnablePropCardSetting", "getLiveEnablePropCardSetting()Z", 0)), Reflection.property1(new PropertyReference1Impl(b.class, "liveEnableStealDragonSetting", "getLiveEnableStealDragonSetting()Z", 0)), Reflection.property1(new PropertyReference1Impl(b.class, "livePkEggRuleSetting", "getLivePkEggRuleSetting()Lcom/bytedance/android/live/revlink/impl/config/PkEggSettingStrategy;", 0))};
        a = r0;
        c0 = new b();
        Boolean r13 = Boolean.FALSE;
        Class r14 = Boolean.TYPE;
        com.bytedance.tools.kcp.ultrasettings.runtime.a r1 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("multi_pk_auto_match_disable", r13, r14, false);
        b = UltraSettingsManager.a().a(r1.a, r1.b, r1.getType(), r1.d, r0[0]);
        Boolean r12 = Boolean.TRUE;
        com.bytedance.tools.kcp.ultrasettings.runtime.a r2 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("multi_anchor_enable_feedback_dialog", r12, r14, false);
        c = UltraSettingsManager.a().a(r2.a, r2.b, r2.getType(), r2.d, r0[1]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r3 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_revenue_interact_panel_season_tab_name", "巅峰赛", String.class, false);
        d = UltraSettingsManager.a().a(r3.a, r3.b, r3.getType(), r3.d, r0[2]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r4 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_pk_top_banner_lynx_url", "https://lf-webcast-gr-sourcecdn.bytegecko.com/obj/byte-gurd-source-gr/webcast/mono/lynx/revenue_pk_panel_lynx_douyin/pages/top_banner/template.js", String.class, false);
        e = UltraSettingsManager.a().a(r4.a, r4.b, r4.getType(), r4.d, r0[3]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r5 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_pk_season_random_match_lynx_url", "https://lf-webcast-gr-sourcecdn.bytegecko.com/obj/byte-gurd-source-gr/webcast/mono/lynx/revenue_pk_panel_lynx_douyin/pages/rank_random_match/template.js", String.class, false);
        f = UltraSettingsManager.a().a(r5.a, r5.b, r5.getType(), r5.d, r0[4]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r6 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_pk_reserve_invite_and_invited_fix", r12, r14, false);
        g = UltraSettingsManager.a().a(r6.a, r6.b, r6.getType(), r6.d, r0[5]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r7 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_anchor_top_banner_lynx_url", "https://lf-webcast-gr-sourcecdn.bytegecko.com/obj/byte-gurd-source-gr/webcast/mono/lynx/revenue_pk_panel_lynx_douyin/pages/top_banner/template.js", String.class, false);
        h = UltraSettingsManager.a().a(r7.a, r7.b, r7.getType(), r7.d, r0[6]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r8 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_anchor_list_panel_preload_enable", r12, r14, false);
        i = UltraSettingsManager.a().a(r8.a, r8.b, r8.getType(), r8.d, r0[7]);
        Class r9 = d.class.getAnnotation(JsonAdapter.class).value();
        ConcurrentHashMap r10 = vh7.b.a;
        Object r15 = r10.get(r9);
        if (r15 != null) goto L12;
        r15 = r9.getConstructor(new Class[0]);
        if (r15 == null) goto L11;
        Object r16 = r10.putIfAbsent(r9, r15);
        if (r16 == null) goto L12;
        r15 = r16;
        goto L12
    L11:
        throw new NullPointerException("null cannot be cast to non-null type java.lang.reflect.Constructor<out com.bytedance.tools.kcp.modelx.runtime.internal.decode.SerializableObjectJsonAdapterBase>");
    L12:
        Object r17 = ((SerializableObjectJsonAdapterBase) ((Constructor) r15).newInstance(new Object[0])).createInstance();
        if (r17 == null) goto L129;
        com.bytedance.tools.kcp.ultrasettings.runtime.a r18 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_anchor_linking_invite_preload_strategy", (d) r17, d.class, false);
        j = UltraSettingsManager.a().a(r18.a, r18.b, r18.getType(), r18.d, r0[8]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r19 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_multi_shell_pk_enable", r12, r14, false);
        k = UltraSettingsManager.a().a(r19.a, r19.b, r19.getType(), r19.d, r0[9]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r20 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_pk_panel_speed_up", r13, r14, false);
        l = UltraSettingsManager.a().a(r20.a, r20.b, r20.getType(), r20.d, r0[10]);
        Class r22 = p.class.getAnnotation(JsonAdapter.class).value();
        Object r23 = r10.get(r22);
        if (r23 != null) goto L24;
        r23 = r22.getConstructor(new Class[0]);
        if (r23 == null) goto L23;
        Object r24 = r10.putIfAbsent(r22, r23);
        if (r24 == null) goto L24;
        r23 = r24;
        goto L24
    L23:
        throw new NullPointerException("null cannot be cast to non-null type java.lang.reflect.Constructor<out com.bytedance.tools.kcp.modelx.runtime.internal.decode.SerializableObjectJsonAdapterBase>");
    L24:
        Object r25 = ((SerializableObjectJsonAdapterBase) ((Constructor) r23).newInstance(new Object[0])).createInstance();
        if (r25 == null) goto L127;
        com.bytedance.tools.kcp.ultrasettings.runtime.a r26 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("pk_panel_size_opt_s", (p) r25, p.class, false);
        m = UltraSettingsManager.a().a(r26.a, r26.b, r26.getType(), r26.d, r0[11]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r27 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_pk_enable_feed_back_toast", r13, r14, false);
        n = UltraSettingsManager.a().a(r27.a, r27.b, r27.getType(), r27.d, r0[12]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r28 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_anchor_link_block_concurrent_apply", r12, r14, false);
        o = UltraSettingsManager.a().a(r28.a, r28.b, r28.getType(), r28.d, r0[13]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r29 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_pk_panel_speed_up_rf", r13, r14, false);
        p = UltraSettingsManager.a().a(r29.a, r29.b, r29.getType(), r29.d, r0[14]);
        Class r30 = Integer.TYPE;
        com.bytedance.tools.kcp.ultrasettings.runtime.a r32 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_pk_new_panel_opt", 1, r30, false);
        q = UltraSettingsManager.a().a(r32.a, r32.b, r32.getType(), r32.d, r0[15]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r33 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_rev_link_page_lazy_load", r12, r14, false);
        r = UltraSettingsManager.a().a(r33.a, r33.b, r33.getType(), r33.d, r0[16]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r34 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_pk_season_v2", r12, r14, false);
        s = UltraSettingsManager.a().a(r34.a, r34.b, r34.getType(), r34.d, r0[17]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r35 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_rev_link_rec_show_follow", r13, r14, false);
        t = UltraSettingsManager.a().a(r35.a, r35.b, r35.getType(), r35.d, r0[18]);
        Class r36 = r.class.getAnnotation(JsonAdapter.class).value();
        Object r37 = r10.get(r36);
        if (r37 != null) goto L36;
        r37 = r36.getConstructor(new Class[0]);
        if (r37 == null) goto L35;
        Object r38 = r10.putIfAbsent(r36, r37);
        if (r38 == null) goto L36;
        r37 = r38;
        goto L36
    L35:
        throw new NullPointerException("null cannot be cast to non-null type java.lang.reflect.Constructor<out com.bytedance.tools.kcp.modelx.runtime.internal.decode.SerializableObjectJsonAdapterBase>");
    L36:
        Object r39 = ((SerializableObjectJsonAdapterBase) ((Constructor) r37).newInstance(new Object[0])).createInstance();
        if (r39 == null) goto L125;
        com.bytedance.tools.kcp.ultrasettings.runtime.a r40 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_pk_panel_rec_other_s", (r) r39, r.class, false);
        u = UltraSettingsManager.a().a(r40.a, r40.b, r40.getType(), r40.d, r0[19]);
        Class r42 = t.class.getAnnotation(JsonAdapter.class).value();
        Object r43 = r10.get(r42);
        if (r43 != null) goto L48;
        r43 = r42.getConstructor(new Class[0]);
        if (r43 == null) goto L47;
        Object r44 = r10.putIfAbsent(r42, r43);
        if (r44 == null) goto L48;
        r43 = r44;
        goto L48
    L47:
        throw new NullPointerException("null cannot be cast to non-null type java.lang.reflect.Constructor<out com.bytedance.tools.kcp.modelx.runtime.internal.decode.SerializableObjectJsonAdapterBase>");
    L48:
        Object r45 = ((SerializableObjectJsonAdapterBase) ((Constructor) r43).newInstance(new Object[0])).createInstance();
        if (r45 == null) goto L123;
        com.bytedance.tools.kcp.ultrasettings.runtime.a r46 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("pk_panel_cache_strategy", (t) r45, t.class, false);
        v = UltraSettingsManager.a().a(r46.a, r46.b, r46.getType(), r46.d, r0[20]);
        Class r47 = s.class.getAnnotation(JsonAdapter.class).value();
        Object r48 = r10.get(r47);
        if (r48 != null) goto L60;
        r48 = r47.getConstructor(new Class[0]);
        if (r48 == null) goto L59;
        Object r49 = r10.putIfAbsent(r47, r48);
        if (r49 == null) goto L60;
        r48 = r49;
        goto L60
    L59:
        throw new NullPointerException("null cannot be cast to non-null type java.lang.reflect.Constructor<out com.bytedance.tools.kcp.modelx.runtime.internal.decode.SerializableObjectJsonAdapterBase>");
    L60:
        Object r50 = ((SerializableObjectJsonAdapterBase) ((Constructor) r48).newInstance(new Object[0])).createInstance();
        if (r50 == null) goto L121;
        com.bytedance.tools.kcp.ultrasettings.runtime.a r52 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_pk_bubble_tip_opt", (s) r50, s.class, false);
        w = UltraSettingsManager.a().a(r52.a, r52.b, r52.getType(), r52.d, r0[21]);
        Class r53 = o.class.getAnnotation(JsonAdapter.class).value();
        Object r54 = r10.get(r53);
        if (r54 != null) goto L72;
        r54 = r53.getConstructor(new Class[0]);
        if (r54 == null) goto L71;
        Object r55 = r10.putIfAbsent(r53, r54);
        if (r55 == null) goto L72;
        r54 = r55;
        goto L72
    L71:
        throw new NullPointerException("null cannot be cast to non-null type java.lang.reflect.Constructor<out com.bytedance.tools.kcp.modelx.runtime.internal.decode.SerializableObjectJsonAdapterBase>");
    L72:
        Object r56 = ((SerializableObjectJsonAdapterBase) ((Constructor) r54).newInstance(new Object[0])).createInstance();
        if (r56 == null) goto L119;
        com.bytedance.tools.kcp.ultrasettings.runtime.a r57 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_pk_panel_follow_s", (o) r56, o.class, false);
        x = UltraSettingsManager.a().a(r57.a, r57.b, r57.getType(), r57.d, r0[22]);
        Class r58 = j.class.getAnnotation(JsonAdapter.class).value();
        Object r59 = r10.get(r58);
        if (r59 != null) goto L84;
        r59 = r58.getConstructor(new Class[0]);
        if (r59 == null) goto L83;
        Object r60 = r10.putIfAbsent(r58, r59);
        if (r60 == null) goto L84;
        r59 = r60;
        goto L84
    L83:
        throw new NullPointerException("null cannot be cast to non-null type java.lang.reflect.Constructor<out com.bytedance.tools.kcp.modelx.runtime.internal.decode.SerializableObjectJsonAdapterBase>");
    L84:
        Object r62 = ((SerializableObjectJsonAdapterBase) ((Constructor) r59).newInstance(new Object[0])).createInstance();
        if (r62 == null) goto L117;
        com.bytedance.tools.kcp.ultrasettings.runtime.a r63 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("linking_invite_preload_s", (j) r62, j.class, false);
        y = UltraSettingsManager.a().a(r63.a, r63.b, r63.getType(), r63.d, r0[23]);
        Class r64 = a.class.getAnnotation(JsonAdapter.class).value();
        Object r65 = r10.get(r64);
        if (r65 != null) goto L96;
        r65 = r64.getConstructor(new Class[0]);
        if (r65 == null) goto L95;
        Object r66 = r10.putIfAbsent(r64, r65);
        if (r66 == null) goto L96;
        r65 = r66;
        goto L96
    L95:
        throw new NullPointerException("null cannot be cast to non-null type java.lang.reflect.Constructor<out com.bytedance.tools.kcp.modelx.runtime.internal.decode.SerializableObjectJsonAdapterBase>");
    L96:
        Object r67 = ((SerializableObjectJsonAdapterBase) ((Constructor) r65).newInstance(new Object[0])).createInstance();
        if (r67 == null) goto L115;
        com.bytedance.tools.kcp.ultrasettings.runtime.a r68 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("link_auto_match_params", (a) r67, a.class, false);
        z = UltraSettingsManager.a().a(r68.a, r68.b, r68.getType(), r68.d, r0[24]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r69 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_pk_play_panel_lynx_url", "sslocal://webcast_lynxview?url=https%3A%2F%2Flf-webcast-gr-sourcecdn.bytegecko.com%2Fobj%2Fbyte-gurd-source-gr%2Fwebcast%2Fmono%2Flynx%2Frevenue_pk_panel_lynx_douyin%2Fpages%2Fplay_mode_selection%2Ftemplate.js&gravity=bottom&type=popup&rate_height=562&radius=8&pull_down_close=1&pull_down_indicator_not_show=1&compat_lynx_foldview=1&business_type=rev_link", String.class, false);
        A = UltraSettingsManager.a().a(r69.a, r69.b, r69.getType(), r69.d, r0[25]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r70 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_pk_panel_lynx_enable", r13, r14, false);
        B = UltraSettingsManager.a().a(r70.a, r70.b, r70.getType(), r70.d, r0[26]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r72 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_pk_panel_lynx_url", "sslocal://webcast_lynxview?bdhm_pid=rev_link&business_type=rev_link&group=rev_link&url=https%3A%2F%2Flf-webcast-gr-sourcecdn.bytegecko.com%2Fobj%2Fbyte-gurd-source-gr%2Fwebcast%2Fmono%2Flynx%2Frevenue_link_douyin%2Fpages%2Fpk_main_panel%2Ftemplate.js&gravity=bottom&type=popup&rate_height=620&radius=8", String.class, false);
        C = UltraSettingsManager.a().a(r72.a, r72.b, r72.getType(), r72.d, r0[27]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r73 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_random_match_panel_lynx_enable", r13, r14, false);
        D = UltraSettingsManager.a().a(r73.a, r73.b, r73.getType(), r73.d, r0[28]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r74 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_random_match_panel_lynx_url", "sslocal://webcast_lynxview?bdhm_pid=rev_link&business_type=rev_link&group=rev_link&url=https%3A%2F%2Flf-webcast-gr-sourcecdn.bytegecko.com%2Fobj%2Fbyte-gurd-source-gr%2Fwebcast%2Fmono%2Flynx%2Frevenue_link_douyin%2Fpages%2Frandom_match_panel%2Ftemplate.js&gravity=bottom&type=popup&rate_height=484&radius=8", String.class, false);
        E = UltraSettingsManager.a().a(r74.a, r74.b, r74.getType(), r74.d, r0[29]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r75 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_multi_random_match_panel_lynx_url", "sslocal://webcast_lynxview?bdhm_pid=rev_link&business_type=rev_link&group=rev_link&url=https%3A%2F%2Flf-webcast-gr-sourcecdn.bytegecko.com%2Fobj%2Fbyte-gurd-source-gr%2Fwebcast%2Fmono%2Flynx%2Frevenue_link_douyin%2Fpages%2Frandom_match_panel%2Ftemplate.js&gravity=bottom&type=popup&rate_height=220&radius=8", String.class, false);
        F = UltraSettingsManager.a().a(r75.a, r75.b, r75.getType(), r75.d, r0[30]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r76 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_invite_more_panel_lynx_enable", r13, r14, false);
        G = UltraSettingsManager.a().a(r76.a, r76.b, r76.getType(), r76.d, r0[31]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r77 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_invite_more_panel_lynx_url", "sslocal://webcast_lynxview?bdhm_pid=rev_link&business_type=rev_link&group=rev_link&url=https%3A%2F%2Flf-webcast-gr-sourcecdn.bytegecko.com%2Fobj%2Fbyte-gurd-source-gr%2Fwebcast%2Fmono%2Flynx%2Frevenue_link_douyin%2Fpages%2Finvite_more_panel%2Ftemplate.js&gravity=bottom&type=popup&rate_height=544&radius=8", String.class, false);
        H = UltraSettingsManager.a().a(r77.a, r77.b, r77.getType(), r77.d, r0[32]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r78 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_multi_quit_confirm_dialog_lynx_enable", r13, r14, false);
        I = UltraSettingsManager.a().a(r78.a, r78.b, r78.getType(), r78.d, r0[33]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r79 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_multi_quit_confirm_dialog_lynx_url", "sslocal://webcast_lynxview?bdhm_pid=rev_link&business_type=rev_link&group=rev_link&url=https%3A%2F%2Flf-webcast-gr-sourcecdn.bytegecko.com%2Fobj%2Fbyte-gurd-source-gr%2Fwebcast%2Fmono%2Flynx%2Frevenue_link_douyin%2Fpages%2Flink_quit_selection_panel%2Ftemplate.js&gravity=bottom&type=fullscreen&height_percent=100", String.class, false);
        J = UltraSettingsManager.a().a(r79.a, r79.b, r79.getType(), r79.d, r0[34]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r80 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_battle_be_invited_dialog_lynx_enable", r13, r14, false);
        K = UltraSettingsManager.a().a(r80.a, r80.b, r80.getType(), r80.d, r0[35]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r82 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_battle_be_invited_dialog_lynx_url", "sslocal://webcast_lynxview?bdhm_pid=rev_link&business_type=rev_link&group=rev_link&url=https%3A%2F%2Flf-webcast-gr-sourcecdn.bytegecko.com%2Fobj%2Fbyte-gurd-source-gr%2Fwebcast%2Fmono%2Flynx%2Frevenue_link_douyin%2Fpages%2Fplay_be_invited_dialog%2Ftemplate.js&gravity=bottom&type=fullscreen&height_percent=100", String.class, false);
        L = UltraSettingsManager.a().a(r82.a, r82.a(), r82.getType(), r82.c(), r0[36]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r83 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_relink_invitation_dialog_lynx_enable", r13, r14, false);
        M = UltraSettingsManager.a().a(r83.b(), r83.a(), r83.getType(), r83.c(), r0[37]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r84 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_relink_invitation_dialog_lynx_url", "sslocal://webcast_lynxview?bdhm_pid=rev_link&business_type=rev_link&group=rev_link&url=https%3A%2F%2Flf-webcast-gr-sourcecdn.bytegecko.com%2Fobj%2Fbyte-gurd-source-gr%2Fwebcast%2Fmono%2Flynx%2Frevenue_link_douyin%2Fpages%2Frelink_invitation_panel%2Ftemplate.js&gravity=bottom&type=popup&rate_height=322&radius=8", String.class, false);
        N = UltraSettingsManager.a().a(r84.b(), r84.a(), r84.getType(), r84.c(), r0[38]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r85 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_relink_waiting_dialog_lynx_url", "sslocal://webcast_lynxview?bdhm_pid=rev_link&business_type=rev_link&group=rev_link&url=https%3A%2F%2Flf-webcast-gr-sourcecdn.bytegecko.com%2Fobj%2Fbyte-gurd-source-gr%2Fwebcast%2Fmono%2Flynx%2Frevenue_link_douyin%2Fpages%2Frelink_invitation_panel%2Ftemplate.js&gravity=bottom&type=popup&rate_height=272&radius=8", String.class, false);
        O = UltraSettingsManager.a().a(r85.b(), r85.a(), r85.getType(), r85.c(), r0[39]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r86 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("link_panel_error_opt", r12, r14, false);
        P = UltraSettingsManager.a().a(r86.b(), r86.a(), r86.getType(), r86.c(), r0[40]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r87 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_sdk_pk_ab_crop_opt", DataType.FALSE, String.class, false);
        Q = UltraSettingsManager.a().a(r87.b(), r87.a(), r87.getType(), r87.c(), r0[41]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r88 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_pk_panel_up_banner_url", "", String.class, false);
        R = UltraSettingsManager.a().a(r88.b(), r88.a(), r88.getType(), r88.c(), r0[42]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r89 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_link_panel_random_link_url", "https://lf-webcast-gr-sourcecdn.bytegecko.com/obj/byte-gurd-source-gr/webcast/mono/lynx/revenue_pk_panel_lynx_douyin/pages/random_link/template.js", String.class, false);
        S = UltraSettingsManager.a().a(r89.b(), r89.a(), r89.getType(), r89.c(), r0[43]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r90 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_pk_history_feed_back_panel_url", "sslocal://webcast_lynxview?url=https%3A%2F%2Flf-webcast-gr-sourcecdn.bytegecko.com%2Fobj%2Fbyte-gurd-source-gr%2Fwebcast%2Fmono%2Flynx%2Frevenue_pk_panel_lynx_douyin%2Fpages%2Fpk_history_feed_back_page%2Ftemplate.js&gravity=bottom&type=popup&height=400&radius=20&pull_down_close=1&pull_down_indicator_not_show=1&top_level=1&add_safe_area_height=0", String.class, false);
        T = UltraSettingsManager.a().a(r90.b(), r90.a(), r90.getType(), r90.c(), r0[44]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r92 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_multi_link_random_entrance_show", r13, r14, false);
        U = UltraSettingsManager.a().a(r92.b(), r92.a(), r92.getType(), r92.c(), r0[45]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r93 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_pk_reserve_settle_lynx_url", "sslocal://webcast_lynxview?url=https%3A%2F%2Flf-webcast-gr-sourcecdn.bytegecko.com%2Fobj%2Fbyte-gurd-source-gr%2Fwebcast%2Fmono%2Flynx%2Frevenue_pk_panel_lynx_douyin%2Fpages%2Flink_reserve_invite_panel%2Ftemplate.js&gravity=bottom&type=popup&height=258&radius=20&pull_down_close=1&pull_down_indicator_not_show=1&top_level=1&add_safe_area_height=0&mask_bg_color=%2380000000", String.class, false);
        V = UltraSettingsManager.a().a(r93.b(), r93.a(), r93.getType(), r93.c(), r0[46]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r94 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_link_panel_opt", 0, r30, true);
        W = UltraSettingsManager.a().a(r94.b(), r94.a(), r94.getType(), r94.c(), r0[47]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r95 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_pk_folding_strategy_remove_room", r12, r14, false);
        X = UltraSettingsManager.a().a(r95.b(), r95.a(), r95.getType(), r95.c(), r0[48]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r96 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_enable_local_reserve_setting", r13, r14, false);
        Y = UltraSettingsManager.a().a(r96.b(), r96.a(), r96.getType(), r96.c(), r0[49]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r97 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_pk_prop_card_setting_show", r13, r14, false);
        Z = UltraSettingsManager.a().a(r97.b(), r97.a(), r97.getType(), r97.c(), r0[50]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r98 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_pk_steal_dragon_setting_show", r12, r14, false);
        a0 = UltraSettingsManager.a().a(r98.b(), r98.a(), r98.getType(), r98.c(), r0[51]);
        Class r99 = n.class.getAnnotation(JsonAdapter.class).value();
        ConcurrentHashMap r100 = vh7.b.a();
        Object r101 = r100.get(r99);
        if (r101 != null) goto L108;
        r101 = r99.getConstructor(new Class[0]);
        if (r101 == null) goto L107;
        Object r102 = r100.putIfAbsent(r99, r101);
        if (r102 == null) goto L108;
        r101 = r102;
        goto L108
    L107:
        throw new NullPointerException("null cannot be cast to non-null type java.lang.reflect.Constructor<out com.bytedance.tools.kcp.modelx.runtime.internal.decode.SerializableObjectJsonAdapterBase>");
    L108:
        Object r103 = ((SerializableObjectJsonAdapterBase) ((Constructor) r101).newInstance(new Object[0])).createInstance();
        if (r103 == null) goto L113;
        com.bytedance.tools.kcp.ultrasettings.runtime.a r104 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_pk_egg_rule_setting", (n) r103, n.class, false);
        b0 = UltraSettingsManager.a().a(r104.b(), r104.a(), r104.getType(), r104.c(), r0[52]);
        return;
    L113:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.live.revlink.impl.config.PkEggSettingStrategy");
    L115:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.live.revlink.impl.settings.panel.LinkAutoMatchParam");
    L117:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.live.revlink.impl.config.LinkingPanelUpdateStrategy");
    L119:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.live.revlink.impl.config.PkPanelFollowUpdateStrategy");
    L121:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.live.revlink.impl.config.PkTipStrategy");
    L123:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.live.revlink.impl.config.RevLinkPanelPreloadAiConfig");
    L125:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.live.revlink.impl.config.PkPanelUpdateStrategy");
    L127:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.live.revlink.impl.config.PkPanelSizeStrategy");
    L129:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.live.revlink.impl.config.InvitePreloadStrategy");
    }
}
