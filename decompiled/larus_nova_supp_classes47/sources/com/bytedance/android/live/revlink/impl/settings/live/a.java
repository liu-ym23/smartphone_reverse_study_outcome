package com.bytedance.android.live.revlink.impl.settings.live;

import com.bytedance.tools.kcp.ultrasettings.runtime.UltraSettingsManager;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.properties.ReadOnlyProperty;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
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
    public static final a j = null;

    public a() {
    }

    public final float a() {
        return ((Number) d.getValue(this, a[2])).floatValue();
    }

    public final float b() {
        return ((Number) b.getValue(this, a[0])).floatValue();
    }

    static {
        KProperty[] r0 = {Reflection.property1(new PropertyReference1Impl(a.class, "pkTopMarginRatio", "getPkTopMarginRatio()F", 0)), Reflection.property1(new PropertyReference1Impl(a.class, "liveJumpFromLivePlayActivityFalseAsNoTransparent", "getLiveJumpFromLivePlayActivityFalseAsNoTransparent()Z", 0)), Reflection.property1(new PropertyReference1Impl(a.class, "livePcAnchorInteractVideoMarginTop", "getLivePcAnchorInteractVideoMarginTop()F", 0)), Reflection.property1(new PropertyReference1Impl(a.class, "liveWangzheGameLinkMarginTop", "getLiveWangzheGameLinkMarginTop()F", 0)), Reflection.property1(new PropertyReference1Impl(a.class, "pushSizeMap", "getPushSizeMap()Ljava/util/HashMap;", 0)), Reflection.property1(new PropertyReference1Impl(a.class, "pushStreamSizeOpt", "getPushStreamSizeOpt()Z", 0)), Reflection.property1(new PropertyReference1Impl(a.class, "livePlayerLayoutOpt", "getLivePlayerLayoutOpt()Z", 0)), Reflection.property1(new PropertyReference1Impl(a.class, "liveScreenRecrodJudgeLiveCore", "getLiveScreenRecrodJudgeLiveCore()Z", 0))};
        a = r0;
        j = new a();
        Float r10 = Float.valueOf(0.02f);
        Class r12 = Float.TYPE;
        com.bytedance.tools.kcp.ultrasettings.runtime.a r1 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_pk_top_spacing_ratio_addition", r10, r12, false);
        b = UltraSettingsManager.a().a(r1.a, r1.b, r1.getType(), r1.d, r0[0]);
        Boolean r13 = Boolean.TRUE;
        Class r14 = Boolean.TYPE;
        com.bytedance.tools.kcp.ultrasettings.runtime.a r2 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_jump_from_live_play_activity_false_as_no_transparent", r13, r14, false);
        c = UltraSettingsManager.a().a(r2.a, r2.b, r2.getType(), r2.d, r0[1]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r3 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_pc_anchor_interact_video_margin_top", Float.valueOf(0.19f), r12, false);
        d = UltraSettingsManager.a().a(r3.a, r3.b, r3.getType(), r3.d, r0[2]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r4 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_wang_zhe_game_link_margin_top", Float.valueOf(0.16f), r12, false);
        e = UltraSettingsManager.a().a(r4.a, r4.b, r4.getType(), r4.d, r0[3]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r5 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_push_stream_size_map", MapsKt.hashMapOf(new Pair[]{TuplesKt.to("1920", "1088"), TuplesKt.to("1280", "720"), TuplesKt.to("960", "544"), TuplesKt.to("864", "480")}), zn3.a.k, false);
        f = UltraSettingsManager.a().a(r5.a, r5.b, r5.getType(), r5.d, r0[4]);
        Boolean r6 = Boolean.FALSE;
        com.bytedance.tools.kcp.ultrasettings.runtime.a r7 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_push_stream_size_opt", r6, r14, false);
        g = UltraSettingsManager.a().a(r7.a, r7.b, r7.getType(), r7.d, r0[5]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r8 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_player_layout_opt_v1", r6, r14, false);
        h = UltraSettingsManager.a().a(r8.a, r8.b, r8.getType(), r8.d, r0[6]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r9 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_screen_record_judge_live_core_param", r6, r14, false);
        i = UltraSettingsManager.a().a(r9.a, r9.b, r9.getType(), r9.d, r0[7]);
    }
}
