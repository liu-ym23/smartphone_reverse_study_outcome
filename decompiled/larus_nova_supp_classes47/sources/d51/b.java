package d51;

import com.bytedance.tools.kcp.ultrasettings.runtime.UltraSettingsManager;
import kotlin.jvm.internal.PropertyReference1Impl;
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
    public static final ReadOnlyProperty i = null;
    public static final ReadOnlyProperty j = null;
    public static final ReadOnlyProperty k = null;
    public static final ReadOnlyProperty l = null;
    public static final b m = null;

    public b() {
    }

    public final boolean a() {
        return ((Boolean) c.getValue(this, a[1])).booleanValue();
    }

    public final boolean b() {
        return ((Boolean) b.getValue(this, a[0])).booleanValue();
    }

    static {
        KProperty[] r0 = {Reflection.property1(new PropertyReference1Impl(b.class, "useDynamicCotainerSizeByGet", "getUseDynamicCotainerSizeByGet()Z", 0)), Reflection.property1(new PropertyReference1Impl(b.class, "livePkOptEnable", "getLivePkOptEnable()Z", 0)), Reflection.property1(new PropertyReference1Impl(b.class, "livePkUnloadNoticeOptEnable", "getLivePkUnloadNoticeOptEnable()Z", 0)), Reflection.property1(new PropertyReference1Impl(b.class, "pkStatusBarOpt", "getPkStatusBarOpt()Z", 0)), Reflection.property1(new PropertyReference1Impl(b.class, "videoTalkSwitchOpt", "getVideoTalkSwitchOpt()Z", 0)), Reflection.property1(new PropertyReference1Impl(b.class, "pkWithGuestStopRtcValidLinkIds", "getPkWithGuestStopRtcValidLinkIds()Z", 0)), Reflection.property1(new PropertyReference1Impl(b.class, "enableStopForwardRemoveMultiChannel", "getEnableStopForwardRemoveMultiChannel()Z", 0)), Reflection.property1(new PropertyReference1Impl(b.class, "pkSwitchLinkNotLoadVideoTalk", "getPkSwitchLinkNotLoadVideoTalk()Z", 0)), Reflection.property1(new PropertyReference1Impl(b.class, "livePkBarRelativeScoreShowOptEnable", "getLivePkBarRelativeScoreShowOptEnable()Z", 0)), Reflection.property1(new PropertyReference1Impl(b.class, "livePkSeiDataMergeOptEnable", "getLivePkSeiDataMergeOptEnable()Z", 0)), Reflection.property1(new PropertyReference1Impl(b.class, "livePkCloudOptEnable", "getLivePkCloudOptEnable()Z", 0))};
        a = r0;
        m = new b();
        Boolean r13 = Boolean.TRUE;
        Class r14 = Boolean.TYPE;
        com.bytedance.tools.kcp.ultrasettings.runtime.a r1 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_pk_opt_use_dynamic_container_size_by_get", r13, r14, false);
        b = UltraSettingsManager.a().a(r1.a, r1.b, r1.getType(), r1.d, r0[0]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r2 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_pk_opt_enable", r13, r14, false);
        c = UltraSettingsManager.a().a(r2.a, r2.b, r2.getType(), r2.d, r0[1]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r3 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_pk_unload_notice_opt_enable", r13, r14, false);
        d = UltraSettingsManager.a().a(r3.a, r3.b, r3.getType(), r3.d, r0[2]);
        Boolean r4 = Boolean.FALSE;
        com.bytedance.tools.kcp.ultrasettings.runtime.a r5 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("pk_status_bar_opt", r4, r14, false);
        e = UltraSettingsManager.a().a(r5.a, r5.b, r5.getType(), r5.d, r0[3]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r6 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("video_talk_and_pk_switch_widget_load_unload_enable", r13, r14, false);
        f = UltraSettingsManager.a().a(r6.a, r6.b, r6.getType(), r6.d, r0[4]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r7 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("pk_with_guest_stop_rtc_valid_link_ids", r13, r14, false);
        g = UltraSettingsManager.a().a(r7.a, r7.b, r7.getType(), r7.d, r0[5]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r8 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("enable_stop_forward_remove_multi_channel", r13, r14, false);
        h = UltraSettingsManager.a().a(r8.a, r8.b, r8.getType(), r8.d, r0[6]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r9 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("pk_switch_link_not_load_video_talk", r13, r14, false);
        i = UltraSettingsManager.a().a(r9.a, r9.b, r9.getType(), r9.d, r0[7]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r10 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_pk_bar_relative_score_show_opt_enable", r13, r14, false);
        j = UltraSettingsManager.a().a(r10.a, r10.b, r10.getType(), r10.d, r0[8]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r12 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_pk_sei_data_merge_opt_enable", r4, r14, false);
        k = UltraSettingsManager.a().a(r12.a, r12.b, r12.getType(), r12.d, r0[9]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r15 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_pk_cloud_opt_enable", r13, r14, false);
        l = UltraSettingsManager.a().a(r15.a, r15.b, r15.getType(), r15.d, r0[10]);
    }
}
