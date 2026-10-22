package u41;

import com.bytedance.tools.kcp.ultrasettings.runtime.UltraSettingsManager;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.properties.ReadOnlyProperty;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class d {
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
    public static final d n = null;

    public d() {
    }

    public final boolean a() {
        return ((Boolean) c.getValue(this, a[1])).booleanValue();
    }

    static {
        KProperty[] r0 = {Reflection.property1(new PropertyReference1Impl(d.class, "livePkAudienceScoreTrack", "getLivePkAudienceScoreTrack()Z", 0)), Reflection.property1(new PropertyReference1Impl(d.class, "multiAnchorConnectMonitor", "getMultiAnchorConnectMonitor()Z", 0)), Reflection.property1(new PropertyReference1Impl(d.class, "multiAnchorConnectMonitorValidationDuration", "getMultiAnchorConnectMonitorValidationDuration()I", 0)), Reflection.property1(new PropertyReference1Impl(d.class, "multiAnchorEnterDurationCheckLog", "getMultiAnchorEnterDurationCheckLog()Z", 0)), Reflection.property1(new PropertyReference1Impl(d.class, "multiAnchorEnterDurationCheckLimit", "getMultiAnchorEnterDurationCheckLimit()I", 0)), Reflection.property1(new PropertyReference1Impl(d.class, "multiAnchorReportReceiveAudienceStream", "getMultiAnchorReportReceiveAudienceStream()Z", 0)), Reflection.property1(new PropertyReference1Impl(d.class, "multiPlayerTraceLogEnable", "getMultiPlayerTraceLogEnable()Z", 0)), Reflection.property1(new PropertyReference1Impl(d.class, "liveRevControlWidgetAutoUnloadMonitor", "getLiveRevControlWidgetAutoUnloadMonitor()Z", 0)), Reflection.property1(new PropertyReference1Impl(d.class, "multiPkWrdsBackUp", "getMultiPkWrdsBackUp()Z", 0)), Reflection.property1(new PropertyReference1Impl(d.class, "livePkAudienceLoadTrack", "getLivePkAudienceLoadTrack()Z", 0)), Reflection.property1(new PropertyReference1Impl(d.class, "multiRevenueDoubleEnterRoomCallTrace", "getMultiRevenueDoubleEnterRoomCallTrace()Z", 0)), Reflection.property1(new PropertyReference1Impl(d.class, "multiRevenuePkDoubleEnterRoomCallTrace", "getMultiRevenuePkDoubleEnterRoomCallTrace()Z", 0))};
        a = r0;
        n = new d();
        Boolean r14 = Boolean.FALSE;
        Class r15 = Boolean.TYPE;
        com.bytedance.tools.kcp.ultrasettings.runtime.a r1 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_pk_audience_score_message_track", r14, r15, false);
        b = UltraSettingsManager.a().a(r1.a, r1.b, r1.getType(), r1.d, r0[0]);
        Boolean r12 = Boolean.TRUE;
        com.bytedance.tools.kcp.ultrasettings.runtime.a r2 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("multi_anchor_connect_monitor", r12, r15, false);
        c = UltraSettingsManager.a().a(r2.a, r2.b, r2.getType(), r2.d, r0[1]);
        Class r13 = Integer.TYPE;
        com.bytedance.tools.kcp.ultrasettings.runtime.a r3 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("multi_anchor_connect_monitor_validation_duration", 20000, r13, false);
        d = UltraSettingsManager.a().a(r3.a, r3.b, r3.getType(), r3.d, r0[2]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r4 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("multi_anchor_enter_duration_check_log", r12, r15, false);
        e = UltraSettingsManager.a().a(r4.a, r4.b, r4.getType(), r4.d, r0[3]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r5 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("multi_anchor_enter_duration_check_limit", 6000, r13, false);
        f = UltraSettingsManager.a().a(r5.a, r5.b, r5.getType(), r5.d, r0[4]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r6 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("multi_anchor_report_receive_audience_stream", r12, r15, false);
        g = UltraSettingsManager.a().a(r6.a, r6.b, r6.getType(), r6.d, r0[5]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r7 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("multi_player_trace_log_enable", r14, r15, false);
        h = UltraSettingsManager.a().a(r7.a, r7.b, r7.getType(), r7.d, r0[6]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r8 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_rev_control_widget_auto_unload_monitor", r14, r15, false);
        i = UltraSettingsManager.a().a(r8.a, r8.b, r8.getType(), r8.d, r0[7]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r9 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("multi_revenue_pk_wrds_back_up", r14, r15, false);
        j = UltraSettingsManager.a().a(r9.a, r9.b, r9.getType(), r9.d, r0[8]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r10 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_pk_audience_load_track", r14, r15, false);
        k = UltraSettingsManager.a().a(r10.a, r10.b, r10.getType(), r10.d, r0[9]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r16 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("multi_revenue_double_enter_room_call_trace", r12, r15, false);
        l = UltraSettingsManager.a().a(r16.a, r16.b, r16.getType(), r16.d, r0[10]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r17 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("multi_revenue_pk_double_enter_room_call_trace", r12, r15, false);
        m = UltraSettingsManager.a().a(r17.a, r17.b, r17.getType(), r17.d, r0[11]);
    }
}
