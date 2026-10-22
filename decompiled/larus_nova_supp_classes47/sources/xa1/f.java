package xa1;

import com.bytedance.tools.kcp.ultrasettings.runtime.UltraSettingsManager;
import kotlin.jvm.internal.PropertyReference0Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.properties.ReadOnlyProperty;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class f {
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

    public static final boolean a() {
        return ((Boolean) l.getValue(null, a[10])).booleanValue();
    }

    static {
        KProperty[] r0 = {Reflection.property0(new PropertyReference0Impl(f.class, "showLinkCrossRoomResetStacktrace", "getShowLinkCrossRoomResetStacktrace()Z", 1)), Reflection.property0(new PropertyReference0Impl(f.class, "liveTurnOnOptEnable", "getLiveTurnOnOptEnable()Z", 1)), Reflection.property0(new PropertyReference0Impl(f.class, "multiChannelOptEnable", "getMultiChannelOptEnable()Z", 1)), Reflection.property0(new PropertyReference0Impl(f.class, "liveMonitorLiveCoreResolutionEnable", "getLiveMonitorLiveCoreResolutionEnable()Z", 1)), Reflection.property0(new PropertyReference0Impl(f.class, "livePkMonitorRtcResolutionEnable", "getLivePkMonitorRtcResolutionEnable()Z", 1)), Reflection.property0(new PropertyReference0Impl(f.class, "resetLiveCoreParamsLeaveChannel", "getResetLiveCoreParamsLeaveChannel()Z", 1)), Reflection.property0(new PropertyReference0Impl(f.class, "enableRtcChorusOptimic", "getEnableRtcChorusOptimic()Z", 1)), Reflection.property0(new PropertyReference0Impl(f.class, "liveLinkSdkEnableSwitch", "getLiveLinkSdkEnableSwitch()Z", 1)), Reflection.property0(new PropertyReference0Impl(f.class, "liveLinkSdkMultiSupportedScenes", "getLiveLinkSdkMultiSupportedScenes()[Ljava/lang/Integer;", 1)), Reflection.property0(new PropertyReference0Impl(f.class, "multiLinkAudienceRtcRenderYuvOpt", "getMultiLinkAudienceRtcRenderYuvOpt()Z", 1)), Reflection.property0(new PropertyReference0Impl(f.class, "liveRevKibanaLogDebug", "getLiveRevKibanaLogDebug()Z", 1)), Reflection.property0(new PropertyReference0Impl(f.class, "liveRevPkTalkVolumeEnable", "getLiveRevPkTalkVolumeEnable()Z", 1))};
        a = r0;
        Boolean r14 = Boolean.TRUE;
        Class r15 = Boolean.TYPE;
        com.bytedance.tools.kcp.ultrasettings.runtime.a r1 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("show_link_cross_room_reset_stacktrace", r14, r15, false);
        b = UltraSettingsManager.a().a(r1.a, r1.b, r1.getType(), r1.d, r0[0]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r2 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_turn_on_opt_enable", r14, r15, false);
        c = UltraSettingsManager.a().a(r2.a, r2.b, r2.getType(), r2.d, r0[1]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r3 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_revenue_interact_forward_stream_opt_enable", r14, r15, false);
        d = UltraSettingsManager.a().a(r3.a, r3.b, r3.getType(), r3.d, r0[2]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r4 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_monitor_livecore_resolution_enable", r14, r15, false);
        e = UltraSettingsManager.a().a(r4.a, r4.b, r4.getType(), r4.d, r0[3]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r5 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_pk_monitor_rtc_resolution_enable", r14, r15, false);
        f = UltraSettingsManager.a().a(r5.a, r5.b, r5.getType(), r5.d, r0[4]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r6 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_core_reset_params_leave_channel", r14, r15, false);
        g = UltraSettingsManager.a().a(r6.a, r6.b, r6.getType(), r6.d, r0[5]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r7 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("enable_rtc_chorus_optimic", r14, r15, false);
        h = UltraSettingsManager.a().a(r7.a, r7.b, r7.getType(), r7.d, r0[6]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r8 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_link_sdk_enable_switch", r14, r15, false);
        i = UltraSettingsManager.a().a(r8.a, r8.b, r8.getType(), r8.d, r0[7]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r9 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_link_sdk_multi_supported_scenes", new Integer[0], yo3.a.a, false);
        j = UltraSettingsManager.a().a(r9.a, r9.b, r9.getType(), r9.d, r0[8]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r10 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("multi_link_audience_rtc_render_yuv_opt", Boolean.FALSE, r15, false);
        k = UltraSettingsManager.a().a(r10.a, r10.b, r10.getType(), r10.d, r0[9]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r12 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_rev_kibana_log_debug", r14, r15, false);
        l = UltraSettingsManager.a().a(r12.a, r12.b, r12.getType(), r12.d, r0[10]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r13 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_rev_pk_talk_volume_enable", r14, r15, false);
        m = UltraSettingsManager.a().a(r13.a, r13.b, r13.getType(), r13.d, r0[11]);
    }
}
