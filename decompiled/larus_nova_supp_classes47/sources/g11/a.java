package g11;

import com.bytedance.tools.kcp.ultrasettings.runtime.UltraSettingsManager;
import java.util.ArrayList;
import kotlin.jvm.internal.PropertyReference0Impl;
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

    static {
        KProperty[] r0 = {Reflection.property0(new PropertyReference0Impl(a.class, "multiAnchorCrossChannelCheckEnable", "getMultiAnchorCrossChannelCheckEnable()I", 1)), Reflection.property0(new PropertyReference0Impl(a.class, "multiAnchorChannelTimer", "getMultiAnchorChannelTimer()I", 1)), Reflection.property0(new PropertyReference0Impl(a.class, "pkTraceLogEnable", "getPkTraceLogEnable()Z", 1)), Reflection.property0(new PropertyReference0Impl(a.class, "linkMediaInfoChangeEnable", "getLinkMediaInfoChangeEnable()Z", 1)), Reflection.property0(new PropertyReference0Impl(a.class, "interactFullLinkPointBlackList", "getInteractFullLinkPointBlackList()Ljava/util/ArrayList;", 1))};
        a = r0;
        Class r8 = Integer.TYPE;
        com.bytedance.tools.kcp.ultrasettings.runtime.a r1 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("multi_anchor_cross_channel_check_enable", 0, r8, false);
        b = UltraSettingsManager.a().a(r1.a, r1.b, r1.getType(), r1.d, r0[0]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r2 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("multi_anchor_cross_channel_backup_timer_duration", 8, r8, false);
        c = UltraSettingsManager.a().a(r2.a, r2.b, r2.getType(), r2.d, r0[1]);
        Boolean r5 = Boolean.FALSE;
        Class r7 = Boolean.TYPE;
        com.bytedance.tools.kcp.ultrasettings.runtime.a r3 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("pk_trance_log_enable", r5, r7, false);
        d = UltraSettingsManager.a().a(r3.a, r3.b, r3.getType(), r3.d, r0[2]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r4 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_link_media_info_change_callback_enable", Boolean.TRUE, r7, false);
        e = UltraSettingsManager.a().a(r4.a, r4.b, r4.getType(), r4.d, r0[3]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r6 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("interact_fulllink_point_blacklist", new ArrayList(), xo3.a.a, false);
        f = UltraSettingsManager.a().a(r6.a, r6.b, r6.getType(), r6.d, r0[4]);
    }

    public static final boolean a() {
        return ((Boolean) d.getValue(null, a[2])).booleanValue();
    }
}
