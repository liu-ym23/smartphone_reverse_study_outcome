package com.bytedance.android.live.revenuelink.rtc;

import com.bytedance.tools.kcp.ultrasettings.runtime.UltraSettingsManager;
import kotlin.jvm.internal.PropertyReference1Impl;
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
    public static final ReadOnlyProperty h = null;
    public static final ReadOnlyProperty i = null;
    public static final k j = null;

    public k() {
    }

    public final boolean a() {
        return ((Boolean) h.getValue(this, a[6])).booleanValue();
    }

    static {
        KProperty[] r0 = {Reflection.property1(new PropertyReference1Impl(k.class, "anchorLinkMixType", "getAnchorLinkMixType()I", 0)), Reflection.property1(new PropertyReference1Impl(k.class, "liveLinkScreenRecordVolFix", "getLiveLinkScreenRecordVolFix()Z", 0)), Reflection.property1(new PropertyReference1Impl(k.class, "linkLiveCoreUpdateAfterMixEnable", "getLinkLiveCoreUpdateAfterMixEnable()Z", 0)), Reflection.property1(new PropertyReference1Impl(k.class, "liveMonitorRtcResolutionRedundancyThreshold", "getLiveMonitorRtcResolutionRedundancyThreshold()F", 0)), Reflection.property1(new PropertyReference1Impl(k.class, "liveLinkAnotherLiveCoreWrite", "getLiveLinkAnotherLiveCoreWrite()Z", 0)), Reflection.property1(new PropertyReference1Impl(k.class, "liveEnableMixInterceptor", "getLiveEnableMixInterceptor()Z", 0)), Reflection.property1(new PropertyReference1Impl(k.class, "liveEnableUnMuteAudioByLeave", "getLiveEnableUnMuteAudioByLeave()Z", 0)), Reflection.property1(new PropertyReference1Impl(k.class, "linkSetVolumeReasonEnable", "getLinkSetVolumeReasonEnable()Z", 0))};
        a = r0;
        j = new k();
        com.bytedance.tools.kcp.ultrasettings.runtime.a r1 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("anchor_link_mix_type", -1, Integer.TYPE, false);
        b = UltraSettingsManager.a().a(r1.a, r1.b, r1.getType(), r1.d, r0[0]);
        Boolean r10 = Boolean.TRUE;
        Class r12 = Boolean.TYPE;
        com.bytedance.tools.kcp.ultrasettings.runtime.a r2 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_link_screen_record_vol_fix", r10, r12, false);
        c = UltraSettingsManager.a().a(r2.a, r2.b, r2.getType(), r2.d, r0[1]);
        Boolean r3 = Boolean.FALSE;
        com.bytedance.tools.kcp.ultrasettings.runtime.a r4 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_mix_start_success_optimize", r3, r12, false);
        d = UltraSettingsManager.a().a(r4.a, r4.b, r4.getType(), r4.d, r0[2]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r5 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_monitor_rtc_resolutio_redundancy_threshold", Float.valueOf(0.1f), Float.TYPE, false);
        e = UltraSettingsManager.a().a(r5.a, r5.b, r5.getType(), r5.d, r0[3]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r6 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_core_another_live_core_write", r10, r12, false);
        f = UltraSettingsManager.a().a(r6.a, r6.b, r6.getType(), r6.d, r0[4]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r7 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_mix_interceptor_enable", r10, r12, false);
        g = UltraSettingsManager.a().a(r7.a, r7.b, r7.getType(), r7.d, r0[5]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r8 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_unmute_audio_on_leave_enable", r10, r12, false);
        h = UltraSettingsManager.a().a(r8.a, r8.b, r8.getType(), r8.d, r0[6]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r9 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("link_set_volume_reason_enable", r3, r12, false);
        i = UltraSettingsManager.a().a(r9.a, r9.b, r9.getType(), r9.d, r0[7]);
    }
}
