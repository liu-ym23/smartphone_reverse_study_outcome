package z41;

import com.bytedance.tools.kcp.ultrasettings.runtime.UltraSettingsManager;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.properties.ReadOnlyProperty;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class g {
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
    public static final g o = null;

    public g() {
    }

    public final boolean a() {
        return ((Boolean) k.getValue(this, a[9])).booleanValue();
    }

    public final boolean b() {
        return ((Boolean) i.getValue(this, a[7])).booleanValue();
    }

    static {
        KProperty[] r0 = {Reflection.property1(new PropertyReference1Impl(g.class, "liveRevStreamLayoutHeightStrategy", "getLiveRevStreamLayoutHeightStrategy()Ljava/util/Map;", 0)), Reflection.property1(new PropertyReference1Impl(g.class, "liveRevDoubleManualUpdateLinkUserCenter", "getLiveRevDoubleManualUpdateLinkUserCenter()Z", 0)), Reflection.property1(new PropertyReference1Impl(g.class, "liveRegionTsChangeByLayout", "getLiveRegionTsChangeByLayout()Z", 0)), Reflection.property1(new PropertyReference1Impl(g.class, "liveRevBlockDomainLinkMicListRequest", "getLiveRevBlockDomainLinkMicListRequest()Z", 0)), Reflection.property1(new PropertyReference1Impl(g.class, "liveWithLynxCardRegistry", "getLiveWithLynxCardRegistry()Z", 0)), Reflection.property1(new PropertyReference1Impl(g.class, "liveRevSceneMergeSwitchToPKBeforeBattleOpenSetting", "getLiveRevSceneMergeSwitchToPKBeforeBattleOpenSetting()Z", 0)), Reflection.property1(new PropertyReference1Impl(g.class, "liveRevFrameMatchScoreTime", "getLiveRevFrameMatchScoreTime()I", 0)), Reflection.property1(new PropertyReference1Impl(g.class, "liveRevUseMixGrids", "getLiveRevUseMixGrids()Z", 0)), Reflection.property1(new PropertyReference1Impl(g.class, "liveRevPkGuestInfoFix", "getLiveRevPkGuestInfoFix()Z", 0)), Reflection.property1(new PropertyReference1Impl(g.class, "liveRevManualControlHybridLoad", "getLiveRevManualControlHybridLoad()Z", 0)), Reflection.property1(new PropertyReference1Impl(g.class, "liveRevReplyCacheEnable", "getLiveRevReplyCacheEnable()Z", 0)), Reflection.property1(new PropertyReference1Impl(g.class, "liveRevBlockAudienceStatus", "getLiveRevBlockAudienceStatus()Z", 0)), Reflection.property1(new PropertyReference1Impl(g.class, "liveRevFixWidgetUnload", "getLiveRevFixWidgetUnload()Z", 0))};
        a = r0;
        o = new g();
        com.bytedance.tools.kcp.ultrasettings.runtime.a r1 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_rev_stream_layout_height_strateg", MapsKt.emptyMap(), zn3.a.m, false);
        b = UltraSettingsManager.a().a(r1.a, r1.b, r1.getType(), r1.d, r0[0]);
        Boolean r13 = Boolean.TRUE;
        Class r14 = Boolean.TYPE;
        com.bytedance.tools.kcp.ultrasettings.runtime.a r2 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_rev_double_manaual_update_link_user_center", r13, r14, false);
        c = UltraSettingsManager.a().a(r2.a, r2.b, r2.getType(), r2.d, r0[1]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r3 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_region_ts_change_by_layout", r13, r14, false);
        d = UltraSettingsManager.a().a(r3.a, r3.b, r3.getType(), r3.d, r0[2]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r4 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_rev_block_domain_link_mic_list_request", r13, r14, false);
        e = UltraSettingsManager.a().a(r4.a, r4.b, r4.getType(), r4.d, r0[3]);
        Boolean r5 = Boolean.FALSE;
        com.bytedance.tools.kcp.ultrasettings.runtime.a r6 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_with_lynx_card_registry", r5, r14, false);
        f = UltraSettingsManager.a().a(r6.a, r6.b, r6.getType(), r6.d, r0[4]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r7 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_rev_scene_merge_switch_to_pk_before_battle_open", r13, r14, false);
        g = UltraSettingsManager.a().a(r7.a, r7.b, r7.getType(), r7.d, r0[5]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r8 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_rev_frame_match_score_time", 5000, Integer.TYPE, false);
        h = UltraSettingsManager.a().a(r8.a, r8.b, r8.getType(), r8.d, r0[6]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r9 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_rev_use_mix_grids", r5, r14, true);
        i = UltraSettingsManager.a().a(r9.a, r9.b, r9.getType(), r9.d, r0[7]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r10 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_rev_pk_guest_info_fix", r13, r14, true);
        j = UltraSettingsManager.a().a(r10.a, r10.b, r10.getType(), r10.d, r0[8]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r12 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_rev_manual_control_hybrid_control", r5, r14, true);
        k = UltraSettingsManager.a().a(r12.a, r12.b, r12.getType(), r12.d, r0[9]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r15 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_rev_reply_cache_enable", r13, r14, false);
        l = UltraSettingsManager.a().a(r15.a, r15.b, r15.getType(), r15.d, r0[10]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r16 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_rev_block_audience_status", r13, r14, false);
        m = UltraSettingsManager.a().a(r16.a, r16.b, r16.getType(), r16.d, r0[11]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r17 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_rev_fix_widget_unload", r13, r14, false);
        n = UltraSettingsManager.a().a(r17.a, r17.b, r17.getType(), r17.d, r0[12]);
    }
}
