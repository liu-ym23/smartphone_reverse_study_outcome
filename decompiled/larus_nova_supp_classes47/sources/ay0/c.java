package ay0;

import com.bytedance.tools.kcp.ultrasettings.runtime.UltraSettingsManager;
import kotlin.jvm.internal.PropertyReference0Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.properties.ReadOnlyProperty;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class c {
    public static final /* synthetic */ KProperty[] a = null;
    public static final ReadOnlyProperty b = null;
    public static final ReadOnlyProperty c = null;
    public static final ReadOnlyProperty d = null;
    public static final ReadOnlyProperty e = null;
    public static final ReadOnlyProperty f = null;

    static {
        KProperty[] r0 = {Reflection.property0(new PropertyReference0Impl(c.class, "LIVE_INCENTIVE_EXCHANGE_STRATEGY_V1", "getLIVE_INCENTIVE_EXCHANGE_STRATEGY_V1()I", 1)), Reflection.property0(new PropertyReference0Impl(c.class, "LIVE_INCENTIVE_EXCHANGE_STRATEGY_V2", "getLIVE_INCENTIVE_EXCHANGE_STRATEGY_V2()I", 1)), Reflection.property0(new PropertyReference0Impl(c.class, "LIVE_INCENTIVE_EXCHANGE_STRATEGY_V3", "getLIVE_INCENTIVE_EXCHANGE_STRATEGY_V3()I", 1)), Reflection.property0(new PropertyReference0Impl(c.class, "LIVE_SEND_GIFT_REDEEM_OPT", "getLIVE_SEND_GIFT_REDEEM_OPT()Z", 1)), Reflection.property0(new PropertyReference0Impl(c.class, "LIVE_SEND_GIFT_JSB_API_REVERT_OPT", "getLIVE_SEND_GIFT_JSB_API_REVERT_OPT()Z", 1))};
        a = r0;
        Class r8 = Integer.TYPE;
        com.bytedance.tools.kcp.ultrasettings.runtime.a r1 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_incentive_exchange_strategy_v1", 0, r8, false);
        b = UltraSettingsManager.a().a(r1.a, r1.b, r1.getType(), r1.d, r0[0]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r2 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_incentive_exchange_strategy_v2", 0, r8, false);
        c = UltraSettingsManager.a().a(r2.a, r2.b, r2.getType(), r2.d, r0[1]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r3 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_incentive_exchange_strategy_v3", 0, r8, false);
        d = UltraSettingsManager.a().a(r3.a, r3.b, r3.getType(), r3.d, r0[2]);
        Boolean r4 = Boolean.FALSE;
        Class r5 = Boolean.TYPE;
        com.bytedance.tools.kcp.ultrasettings.runtime.a r6 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_send_gift_redeem_opt", r4, r5, false);
        e = UltraSettingsManager.a().a(r6.a, r6.b, r6.getType(), r6.d, r0[3]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r7 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_send_gift_jsb_api_revert_opt", r4, r5, false);
        f = UltraSettingsManager.a().a(r7.a, r7.b, r7.getType(), r7.d, r0[4]);
    }

    public static final int a() {
        return ((Number) b.getValue(null, a[0])).intValue();
    }

    public static final int b() {
        return ((Number) c.getValue(null, a[1])).intValue();
    }

    public static final int c() {
        return ((Number) d.getValue(null, a[2])).intValue();
    }

    public static final boolean d() {
        return ((Boolean) f.getValue(null, a[4])).booleanValue();
    }
}
