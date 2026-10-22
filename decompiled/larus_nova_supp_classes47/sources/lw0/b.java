package lw0;

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

    static {
        KProperty[] r0 = {Reflection.property0(new PropertyReference0Impl(b.class, "LIVE_CASH_EXCHANGE_PROMPT_OPT_ENABLE", "getLIVE_CASH_EXCHANGE_PROMPT_OPT_ENABLE()Z", 1)), Reflection.property0(new PropertyReference0Impl(b.class, "AUTO_EXCHANGE_SWITCH_ON_SERVER", "getAUTO_EXCHANGE_SWITCH_ON_SERVER()Z", 1)), Reflection.property0(new PropertyReference0Impl(b.class, "LIVE_CASH_EXCHANGE_ENABLE", "getLIVE_CASH_EXCHANGE_ENABLE()Z", 1)), Reflection.property0(new PropertyReference0Impl(b.class, "LIVE_FLAME_EXCHANGE_ENABLE", "getLIVE_FLAME_EXCHANGE_ENABLE()Z", 1)), Reflection.property0(new PropertyReference0Impl(b.class, "LIVE_XIGUA_DIAMOND_EXCHANGE_API", "getLIVE_XIGUA_DIAMOND_EXCHANGE_API()Z", 1))};
        a = r0;
        Boolean r7 = Boolean.FALSE;
        Class r8 = Boolean.TYPE;
        com.bytedance.tools.kcp.ultrasettings.runtime.a r1 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_show_income_exchange_reminder", r7, r8, false);
        b = UltraSettingsManager.a().a(r1.a, r1.b, r1.getType(), r1.d, r0[0]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r2 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("auto_exchange_switch_on_server", r7, r8, false);
        c = UltraSettingsManager.a().a(r2.a, r2.b, r2.getType(), r2.d, r0[1]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r3 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_cash_exchange_enable", r7, r8, false);
        d = UltraSettingsManager.a().a(r3.a, r3.b, r3.getType(), r3.d, r0[2]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r4 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_flame_redeem_enable", r7, r8, false);
        e = UltraSettingsManager.a().a(r4.a, r4.b, r4.getType(), r4.d, r0[3]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r5 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_xigua_diamond_exchange_api", Boolean.TRUE, r8, false);
        f = UltraSettingsManager.a().a(r5.a, r5.b, r5.getType(), r5.d, r0[4]);
    }

    public static final boolean a() {
        return ((Boolean) c.getValue(null, a[1])).booleanValue();
    }
}
