package y12;

import com.bytedance.tools.kcp.ultrasettings.runtime.UltraSettingsManager;
import kotlin.jvm.internal.PropertyReference0Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.properties.ReadOnlyProperty;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class b {
    public static final /* synthetic */ KProperty[] a = null;
    public static final ReadOnlyProperty b = null;
    public static final ReadOnlyProperty c = null;
    public static final ReadOnlyProperty d = null;
    public static final ReadOnlyProperty e = null;

    static {
        KProperty[] r0 = {Reflection.property0(new PropertyReference0Impl(b.class, "LIVE_ENABLE_GIFT_PANEL_HEIGHT_INCREASE", "getLIVE_ENABLE_GIFT_PANEL_HEIGHT_INCREASE()Z", 1)), Reflection.property0(new PropertyReference0Impl(b.class, "LIVE_GIFT_DEFAULT_SELECT_SWITCH", "getLIVE_GIFT_DEFAULT_SELECT_SWITCH()Z", 1)), Reflection.property0(new PropertyReference0Impl(b.class, "LIVE_GIFTPANEL_PROPERTY_EXPIRE_REMIND_II", "getLIVE_GIFTPANEL_PROPERTY_EXPIRE_REMIND_II()I", 1)), Reflection.property0(new PropertyReference0Impl(b.class, "LIVE_GIFTPANEL_PROPERTY_UP_FLOW_OPEN", "getLIVE_GIFTPANEL_PROPERTY_UP_FLOW_OPEN()Z", 1))};
        a = r0;
        Boolean r7 = Boolean.FALSE;
        Class r8 = Boolean.TYPE;
        com.bytedance.tools.kcp.ultrasettings.runtime.a r1 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_enable_gift_panel_height_increase", r7, r8, false);
        b = UltraSettingsManager.a().a(r1.a, r1.b, r1.getType(), r1.d, r0[0]);
        Boolean r9 = Boolean.TRUE;
        com.bytedance.tools.kcp.ultrasettings.runtime.a r2 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_gift_default_select_switch", r9, r8, false);
        c = UltraSettingsManager.a().a(r2.a, r2.b, r2.getType(), r2.d, r0[1]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r3 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_giftpanel_property_expire_remind_II", 0, Integer.TYPE, false);
        d = UltraSettingsManager.a().a(r3.a, r3.b, r3.getType(), r3.d, r0[2]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r4 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("LIVE_GIFTPANEL_PROPERTY_UP_FLOW_OPEN", r9, r8, false);
        e = UltraSettingsManager.a().a(r4.a, r4.b, r4.getType(), r4.d, r0[3]);
    }
}
