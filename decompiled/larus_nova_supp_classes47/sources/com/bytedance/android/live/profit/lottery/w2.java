package com.bytedance.android.live.profit.lottery;

import com.bytedance.tools.kcp.ultrasettings.runtime.UltraSettingsManager;
import java.util.ArrayList;
import kotlin.jvm.internal.PropertyReference0Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.properties.ReadOnlyProperty;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class w2 {
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

    public static final boolean a() {
        return ((Boolean) m.getValue(null, a[11])).booleanValue();
    }

    public static final boolean b() {
        return ((Boolean) l.getValue(null, a[10])).booleanValue();
    }

    public static final boolean c() {
        return ((Boolean) f.getValue(null, a[4])).booleanValue();
    }

    public static final long d() {
        return ((Number) h.getValue(null, a[6])).longValue();
    }

    public static final m0 e() {
        return (m0) b.getValue(null, a[0]);
    }

    static {
        KProperty[] r0 = {Reflection.property0(new PropertyReference0Impl(w2.class, "LOTTERY_CONFIG", "getLOTTERY_CONFIG()Lcom/bytedance/android/live/profit/lottery/LotteryConfig;", 1)), Reflection.property0(new PropertyReference0Impl(w2.class, "LOTTERY_STI_FINISH_WEBP_URL", "getLOTTERY_STI_FINISH_WEBP_URL()Ljava/lang/String;", 1)), Reflection.property0(new PropertyReference0Impl(w2.class, "LIFE_LOTTERY_CONFIG", "getLIFE_LOTTERY_CONFIG()Lcom/bytedance/android/live/profit/lottery/LotteryConfig$LifeLotteryConfig;", 1)), Reflection.property0(new PropertyReference0Impl(w2.class, "LIVE_LOTTERY_DYNAMIC_TYPE_CONFIG", "getLIVE_LOTTERY_DYNAMIC_TYPE_CONFIG()Ljava/util/ArrayList;", 1)), Reflection.property0(new PropertyReference0Impl(w2.class, "LIVE_LOTTERY_DRAWING_DISAPPEARABLE", "getLIVE_LOTTERY_DRAWING_DISAPPEARABLE()Z", 1)), Reflection.property0(new PropertyReference0Impl(w2.class, "LIVE_LOTTERY_MAX_COUNTDOWN_DISMISS", "getLIVE_LOTTERY_MAX_COUNTDOWN_DISMISS()J", 1)), Reflection.property0(new PropertyReference0Impl(w2.class, "LIVE_LOTTERY_DRAW_RESULT_DELAY", "getLIVE_LOTTERY_DRAW_RESULT_DELAY()J", 1)), Reflection.property0(new PropertyReference0Impl(w2.class, "LIVE_LOTTERY_HOT_DRAW_OPT", "getLIVE_LOTTERY_HOT_DRAW_OPT()Z", 1)), Reflection.property0(new PropertyReference0Impl(w2.class, "LIVE_LOTTERY_DRAW_BIGCARD_FIX", "getLIVE_LOTTERY_DRAW_BIGCARD_FIX()Z", 1)), Reflection.property0(new PropertyReference0Impl(w2.class, "LIVE_LOTTERY_DRAWING_DIALOG_FIX", "getLIVE_LOTTERY_DRAWING_DIALOG_FIX()Z", 1)), Reflection.property0(new PropertyReference0Impl(w2.class, "LIVE_LOTTERY_ATMOSPHERE", "getLIVE_LOTTERY_ATMOSPHERE()Z", 1)), Reflection.property0(new PropertyReference0Impl(w2.class, "LIVE_ENABLE_SHORTTOUCH_TERM_STRATEGY", "getLIVE_ENABLE_SHORTTOUCH_TERM_STRATEGY()Z", 1)), Reflection.property0(new PropertyReference0Impl(w2.class, "LIVE_LOTTERY_LOCALINFO_CACHE_ENABLE", "getLIVE_LOTTERY_LOCALINFO_CACHE_ENABLE()Z", 1))};
        a = r0;
        m0 r14 = new m0();
        r14.enabled = 0;
        r14.anchorLotteryCreateUri = "";
        r14.anchorLotteryDetailUri = "";
        r14.audienceLotteryWaitUri = "";
        r14.audienceLotteryResultUri = "";
        r14.lotteryNetworkErrorString = "";
        r14.reviewingString = "";
        r14.rejectedTitleString = "";
        r14.rejectedMessageString = "";
        r14.redDotEnabled = 0;
        com.bytedance.tools.kcp.ultrasettings.runtime.a r1 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_lottery_config", r14, m0.class, false);
        b = UltraSettingsManager.a().a(r1.a, r1.b, r1.getType(), r1.d, r0[0]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r2 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_lottery_sti_finish_webp_url", com.bytedance.android.live.revenue.common.v0.a("obj/live-android/ttlive_lottery_sti_finish.webp"), String.class, false);
        c = UltraSettingsManager.a().a(r2.a, r2.b, r2.getType(), r2.d, r0[1]);
        m0.a r5 = new m0.a();
        r5.anchorLotteryDetailUri = "sslocal://webcast_webview?url=https%3A%2F%2Fwebcast.amemv.com%2Ffalcon%2Fwebcast_douyin%2Fpage%2Flottery%2Fanchor_detail%2Findex.html%3Fweb_bg_color%3Dff000000&height=440&type=popup&gravity=bottom&radius=8";
        r5.audienceLotteryWaitUri = "sslocal://webcast_lynxview?type=popup&url=https%3A%2F%2Flf-webcast-sourcecdn-tos.bytegecko.com%2Fobj%2Fbyte-gurd-source%2Fwebcast%2Ffalcon%2Fdouyin%2Fmp_live_lynx_entry_coupon%2Flottery_involve%2Findex%2Ftemplate.js&load_taro=0&height_percent=100&width_percent=100&open_animate=0&mask_click_disable=0&lottery_from_source=icon";
        r5.audienceLotteryResultUri = "sslocal://webcast_lynxview?type=popup&url=https%3A%2F%2Flf-webcast-sourcecdn-tos.bytegecko.com%2Fobj%2Fbyte-gurd-source%2Fwebcast%2Ffalcon%2Fdouyin%2Fmp_live_lynx_entry_coupon%2Flottery_result%2Findex%2Ftemplate.js&load_taro=0&height_percent=100&width_percent=100&open_animate=0&mask_click_disable=1&top_level=1&allowing_state_loss=1";
        com.bytedance.tools.kcp.ultrasettings.runtime.a r3 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_life_lottery_config", r5, m0.a.class, false);
        d = UltraSettingsManager.a().a(r3.a, r3.b, r3.getType(), r3.d, r0[2]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r4 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_lottery_common_config", new ArrayList(), un3.a.b, false);
        e = UltraSettingsManager.a().a(r4.a, r4.b, r4.getType(), r4.d, r0[3]);
        Boolean r6 = Boolean.TRUE;
        Class r7 = Boolean.TYPE;
        com.bytedance.tools.kcp.ultrasettings.runtime.a r8 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_lottery_drawing_disappearable", r6, r7, false);
        f = UltraSettingsManager.a().a(r8.a, r8.b, r8.getType(), r8.d, r0[4]);
        Class r9 = Long.TYPE;
        com.bytedance.tools.kcp.ultrasettings.runtime.a r10 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_lottery_max_countdown_dismiss", 90000L, r9, false);
        g = UltraSettingsManager.a().a(r10.a, r10.b, r10.getType(), r10.d, r0[5]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r12 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_lottery_draw_result_delay", 0L, r9, false);
        h = UltraSettingsManager.a().a(r12.a, r12.b, r12.getType(), r12.d, r0[6]);
        Boolean r13 = Boolean.FALSE;
        com.bytedance.tools.kcp.ultrasettings.runtime.a r15 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_lottery_hot_draw_opt", r13, r7, false);
        i = UltraSettingsManager.a().a(r15.a, r15.b, r15.getType(), r15.d, r0[7]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r16 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_lottery_draw_bigcard_fix", r13, r7, false);
        j = UltraSettingsManager.a().a(r16.a, r16.b, r16.getType(), r16.d, r0[8]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r17 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_lottery_drawing_dialog_fix", r13, r7, false);
        k = UltraSettingsManager.a().a(r17.a, r17.b, r17.getType(), r17.d, r0[9]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r18 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_lottery_atmosphere", r6, r7, false);
        l = UltraSettingsManager.a().a(r18.a, r18.b, r18.getType(), r18.d, r0[10]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r19 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_enable_shorttouch_term_strategy", r6, r7, false);
        m = UltraSettingsManager.a().a(r19.a, r19.b, r19.getType(), r19.d, r0[11]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r20 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_lottery_localinfo_cache_enable", r6, r7, false);
        n = UltraSettingsManager.a().a(r20.a, r20.b, r20.getType(), r20.d, r0[12]);
    }
}
