package u41;

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
    public static final b i = null;

    static {
        KProperty[] r0 = {Reflection.property1(new PropertyReference1Impl(b.class, "multiLoadRevInP0", "getMultiLoadRevInP0()I", 0)), Reflection.property1(new PropertyReference1Impl(b.class, "multiRevenueLinkWrdsBackup", "getMultiRevenueLinkWrdsBackup()Z", 0)), Reflection.property1(new PropertyReference1Impl(b.class, "multiRevenueLinkEnterCheckThreshold", "getMultiRevenueLinkEnterCheckThreshold()J", 0)), Reflection.property1(new PropertyReference1Impl(b.class, "multiRevenueSuperPreload", "getMultiRevenueSuperPreload()Z", 0)), Reflection.property1(new PropertyReference1Impl(b.class, "multiRevenueDoubleEnterRoomCall", "getMultiRevenueDoubleEnterRoomCall()Z", 0)), Reflection.property1(new PropertyReference1Impl(b.class, "multiRevenuePreloadDataThreshold", "getMultiRevenuePreloadDataThreshold()J", 0)), Reflection.property1(new PropertyReference1Impl(b.class, "multiInteractModeChangeSetting", "getMultiInteractModeChangeSetting()Z", 0))};
        a = r0;
        i = new b();
        com.bytedance.tools.kcp.ultrasettings.runtime.a r1 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_multi_load_rev_in_p0", 0, Integer.TYPE, false);
        b = UltraSettingsManager.a().a(r1.a, r1.b, r1.getType(), r1.d, r0[0]);
        Boolean r9 = Boolean.FALSE;
        Class r10 = Boolean.TYPE;
        com.bytedance.tools.kcp.ultrasettings.runtime.a r2 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("multi_revenue_link_wrds_back_up", r9, r10, false);
        c = UltraSettingsManager.a().a(r2.a, r2.b, r2.getType(), r2.d, r0[1]);
        Class r12 = Long.TYPE;
        com.bytedance.tools.kcp.ultrasettings.runtime.a r3 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("multi_revenue_link_enter_check_threshold", 500L, r12, false);
        d = UltraSettingsManager.a().a(r3.a, r3.b, r3.getType(), r3.d, r0[2]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r4 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("multi_revenue_super_preload", r9, r10, false);
        e = UltraSettingsManager.a().a(r4.a, r4.b, r4.getType(), r4.d, r0[3]);
        Boolean r5 = Boolean.TRUE;
        com.bytedance.tools.kcp.ultrasettings.runtime.a r6 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("multi_revenue_double_enter_room_call", r5, r10, false);
        f = UltraSettingsManager.a().a(r6.a, r6.b, r6.getType(), r6.d, r0[4]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r7 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("multi_revenue_preload_data_threshold", 3000L, r12, false);
        g = UltraSettingsManager.a().a(r7.a, r7.b, r7.getType(), r7.d, r0[5]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r8 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("multi_interact_mode_change_settings", r5, r10, false);
        h = UltraSettingsManager.a().a(r8.a, r8.b, r8.getType(), r8.d, r0[6]);
    }

    public b() {
    }

    public final boolean a() {
        return ((Boolean) h.getValue(this, a[6])).booleanValue();
    }

    public final boolean b() {
        return ((Boolean) e.getValue(this, a[3])).booleanValue();
    }
}
