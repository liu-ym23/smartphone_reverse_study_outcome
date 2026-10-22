package com.bytedance.android.live.profit.taskcenter;

import com.bytedance.tools.kcp.ultrasettings.runtime.UltraSettingsManager;
import kotlin.jvm.internal.PropertyReference0Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.properties.ReadOnlyProperty;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class k {
    public static final /* synthetic */ KProperty[] a = null;
    public static final ReadOnlyProperty b = null;
    public static final ReadOnlyProperty c = null;
    public static final ReadOnlyProperty d = null;
    public static final ReadOnlyProperty e = null;
    public static final ReadOnlyProperty f = null;
    public static final ReadOnlyProperty g = null;

    static {
        KProperty[] r0 = {Reflection.property0(new PropertyReference0Impl(k.class, "LIVE_TASK_PANEL_DAILY_LIMIT_ENABLE", "getLIVE_TASK_PANEL_DAILY_LIMIT_ENABLE()Z", 1)), Reflection.property0(new PropertyReference0Impl(k.class, "LIVE_TASK_PANEL_LIFETIME_LIMIT_ENABLE", "getLIVE_TASK_PANEL_LIFETIME_LIMIT_ENABLE()Z", 1)), Reflection.property0(new PropertyReference0Impl(k.class, "LIVE_TASK_API_PRELOAD_CONFIG", "getLIVE_TASK_API_PRELOAD_CONFIG()Lcom/bytedance/android/live/profit/taskcenter/preload/PreloadSettingConfig;", 1)), Reflection.property0(new PropertyReference0Impl(k.class, "LIVE_TASK_PANEL_READY_TIMEOUT", "getLIVE_TASK_PANEL_READY_TIMEOUT()J", 1)), Reflection.property0(new PropertyReference0Impl(k.class, "LIVE_PANEL_FLEXIBLY_LOWER_FREQ", "getLIVE_PANEL_FLEXIBLY_LOWER_FREQ()Lcom/bytedance/android/live/profit/taskcenter/FlexiblyLowerFreqConfig;", 1)), Reflection.property0(new PropertyReference0Impl(k.class, "LIVE_INCENTIVE_PANEL_FEEDBACK_OPT", "getLIVE_INCENTIVE_PANEL_FEEDBACK_OPT()Lcom/bytedance/android/live/profit/taskcenter/IncentivePanelFeedbackOptConfig;", 1))};
        a = r0;
        Boolean r8 = Boolean.TRUE;
        Class r9 = Boolean.TYPE;
        com.bytedance.tools.kcp.ultrasettings.runtime.a r1 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_task_panel_daily_limit_enable", r8, r9, false);
        b = UltraSettingsManager.a().a(r1.a, r1.b, r1.getType(), r1.d, r0[0]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r2 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_task_panel_lifetime_limit_enable", r8, r9, false);
        c = UltraSettingsManager.a().a(r2.a, r2.b, r2.getType(), r2.d, r0[1]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r3 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_incentive_panel_access_intelligence", new com.bytedance.android.live.profit.taskcenter.preload.b(), com.bytedance.android.live.profit.taskcenter.preload.b.class, false);
        d = UltraSettingsManager.a().a(r3.a, r3.b, r3.getType(), r3.d, r0[2]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r4 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_task_panel_ready_timeout", 5L, Long.TYPE, false);
        e = UltraSettingsManager.a().a(r4.a, r4.b, r4.getType(), r4.d, r0[3]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r5 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_panel_flexibly_lower_freq", new a(), a.class, false);
        f = UltraSettingsManager.a().a(r5.a, r5.b, r5.getType(), r5.d, r0[4]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r6 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_incentive_panel_feedback_opt", new d(), d.class, false);
        g = UltraSettingsManager.a().a(r6.a, r6.b, r6.getType(), r6.d, r0[5]);
    }
}
