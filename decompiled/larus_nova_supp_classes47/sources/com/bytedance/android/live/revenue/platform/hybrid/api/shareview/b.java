package com.bytedance.android.live.revenue.platform.hybrid.api.shareview;

import com.bytedance.tools.kcp.ultrasettings.runtime.UltraSettingsManager;
import kotlin.jvm.internal.PropertyReference0Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.properties.ReadOnlyProperty;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class b {
    public static final /* synthetic */ KProperty[] a = null;
    public static final ReadOnlyProperty b = null;
    public static final ReadOnlyProperty c = null;
    public static final ReadOnlyProperty d = null;
    public static final ReadOnlyProperty e = null;
    public static final ReadOnlyProperty f = null;
    public static final ReadOnlyProperty g = null;
    public static final ReadOnlyProperty h = null;

    static {
        KProperty[] r0 = {Reflection.property0(new PropertyReference0Impl(b.class, "ShareViewMinServiceCenterVersion", "getShareViewMinServiceCenterVersion()Ljava/lang/String;", 1)), Reflection.property0(new PropertyReference0Impl(b.class, "ShareViewTriggerServiceCenterLoad", "getShareViewTriggerServiceCenterLoad()Z", 1)), Reflection.property0(new PropertyReference0Impl(b.class, "ShareViewSharerSchema", "getShareViewSharerSchema()Ljava/lang/String;", 1)), Reflection.property0(new PropertyReference0Impl(b.class, "ShareViewImmediateCreateStandaloneSharer", "getShareViewImmediateCreateStandaloneSharer()Z", 1)), Reflection.property0(new PropertyReference0Impl(b.class, "ShareViewEnableStandaloneSharer", "getShareViewEnableStandaloneSharer()Z", 1)), Reflection.property0(new PropertyReference0Impl(b.class, "ShareViewForceEnableStandaloneSharer", "getShareViewForceEnableStandaloneSharer()Z", 1)), Reflection.property0(new PropertyReference0Impl(b.class, "ShareViewEnableFirstScreen", "getShareViewEnableFirstScreen()Z", 1))};
        a = r0;
        com.bytedance.tools.kcp.ultrasettings.runtime.a r1 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("livesdk_share_view_min_service_center_version", "1.0.0.3745", String.class, false);
        b = UltraSettingsManager.a().a(r1.a, r1.b, r1.getType(), r1.d, r0[0]);
        Boolean r9 = Boolean.FALSE;
        Class r10 = Boolean.TYPE;
        com.bytedance.tools.kcp.ultrasettings.runtime.a r2 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("livesdk_share_view_trigger_service_center_load", r9, r10, false);
        c = UltraSettingsManager.a().a(r2.a, r2.b, r2.getType(), r2.d, r0[1]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r3 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("livesdk_share_view_sharer_schema", "sslocal://webcast_lynxview?url=https%3A%2F%2Flf-webcast-gr-sourcecdn.bytegecko.com%2Fobj%2Fbyte-gurd-source-gr%2Fwebcast%2Fmono%2Flynx%2Frevenue_rank_list_douyin%2Fpages%2Fshare_view_sharer_speedy_v2%2Ftemplate.js&group=webcast_revenue&use_storage_group=1&mix_container_type=annie", String.class, false);
        d = UltraSettingsManager.a().a(r3.a, r3.b, r3.getType(), r3.d, r0[2]);
        Boolean r4 = Boolean.TRUE;
        com.bytedance.tools.kcp.ultrasettings.runtime.a r5 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("livesdk_share_view_immediate_create_standalone_sharer", r4, r10, false);
        e = UltraSettingsManager.a().a(r5.a, r5.b, r5.getType(), r5.d, r0[3]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r6 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("livesdk_share_view_enable_standalone", r9, r10, false);
        f = UltraSettingsManager.a().a(r6.a, r6.b, r6.getType(), r6.d, r0[4]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r7 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("livesdk_share_view_force_enable_standalone", r9, r10, false);
        g = UltraSettingsManager.a().a(r7.a, r7.b, r7.getType(), r7.d, r0[5]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r8 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("enableShareViewFirstScreen", r4, r10, false);
        h = UltraSettingsManager.a().a(r8.a, r8.b, r8.getType(), r8.d, r0[6]);
    }
}
