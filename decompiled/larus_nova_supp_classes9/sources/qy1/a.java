package qy1;

import com.bytedance.tools.kcp.ultrasettings.runtime.UltraSettingsManager;
import kotlin.jvm.internal.PropertyReference0Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.properties.ReadOnlyProperty;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class a {
    public static final /* synthetic */ KProperty[] a = null;
    public static final ReadOnlyProperty b = null;
    public static final ReadOnlyProperty c = null;
    public static final ReadOnlyProperty d = null;
    public static final ReadOnlyProperty e = null;
    public static final ReadOnlyProperty f = null;
    public static final ReadOnlyProperty g = null;
    public static final ReadOnlyProperty h = null;

    static {
        KProperty[] r0 = {Reflection.property0(new PropertyReference0Impl(a.class, "LIVE_GROUP_COMPONENT_USE_WRDS", "getLIVE_GROUP_COMPONENT_USE_WRDS()Z", 1)), Reflection.property0(new PropertyReference0Impl(a.class, "LIVE_GROUP_REFRESH_LAYOUT_WHEN_ORIENTATION_CHANGE", "getLIVE_GROUP_REFRESH_LAYOUT_WHEN_ORIENTATION_CHANGE()Z", 1)), Reflection.property0(new PropertyReference0Impl(a.class, "LIVE_GROUP_VIEW_TOP_MARGIN_OPTIMIZE", "getLIVE_GROUP_VIEW_TOP_MARGIN_OPTIMIZE()Z", 1)), Reflection.property0(new PropertyReference0Impl(a.class, "LIVE_GROUP_LIVE_COMPONENT_USE_ANNIEX", "getLIVE_GROUP_LIVE_COMPONENT_USE_ANNIEX()Z", 1)), Reflection.property0(new PropertyReference0Impl(a.class, "LIVE_GROUP_LIVE_FE_FOLD_OPT", "getLIVE_GROUP_LIVE_FE_FOLD_OPT()Z", 1)), Reflection.property0(new PropertyReference0Impl(a.class, "GROUP_LIVE_CONTAINER_RTS", "getGROUP_LIVE_CONTAINER_RTS()Z", 1)), Reflection.property0(new PropertyReference0Impl(a.class, "GROUP_LIVE_STREAM_MESSAGE", "getGROUP_LIVE_STREAM_MESSAGE()Z", 1))};
        a = r0;
        Boolean r9 = Boolean.TRUE;
        Class r10 = Boolean.TYPE;
        com.bytedance.tools.kcp.ultrasettings.runtime.a r1 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_group_component_use_wrds", r9, r10, false);
        b = UltraSettingsManager.a().a(r1.a, r1.b, r1.getType(), r1.d, r0[0]);
        Boolean r11 = Boolean.FALSE;
        com.bytedance.tools.kcp.ultrasettings.runtime.a r2 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_group_refresh_layout_when_orientation_change", r11, r10, false);
        c = UltraSettingsManager.a().a(r2.a, r2.b, r2.getType(), r2.d, r0[1]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r3 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_group_view_top_margin_optimize", r9, r10, false);
        d = UltraSettingsManager.a().a(r3.a, r3.b, r3.getType(), r3.d, r0[2]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r4 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_group_live_component_use_anniex", r9, r10, false);
        e = UltraSettingsManager.a().a(r4.a, r4.b, r4.getType(), r4.d, r0[3]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r5 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("group_live_fe_fold_opt", r11, r10, false);
        f = UltraSettingsManager.a().a(r5.a, r5.b, r5.getType(), r5.d, r0[4]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r6 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("group_live_container_rts", r11, r10, false);
        g = UltraSettingsManager.a().a(r6.a, r6.b, r6.getType(), r6.d, r0[5]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r7 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("group_live_stream_message", r11, r10, false);
        h = UltraSettingsManager.a().a(r7.a, r7.b, r7.getType(), r7.d, r0[6]);
    }

    public static final boolean a() {
        return ((Boolean) g.getValue(null, a[5])).booleanValue();
    }
}
