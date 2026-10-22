package c51;

import com.bytedance.tools.kcp.ultrasettings.runtime.UltraSettingsManager;
import kotlin.jvm.internal.PropertyReference1Impl;
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
    public static final ReadOnlyProperty g = null;
    public static final a h = null;

    static {
        KProperty[] r0 = {Reflection.property1(new PropertyReference1Impl(a.class, "livePkPeakPeriodBeginTime", "getLivePkPeakPeriodBeginTime()Ljava/lang/String;", 0)), Reflection.property1(new PropertyReference1Impl(a.class, "livePkPeakPeriodEndTime", "getLivePkPeakPeriodEndTime()Ljava/lang/String;", 0)), Reflection.property1(new PropertyReference1Impl(a.class, "livePkPeakPeriodAdjustDurationTopTip", "getLivePkPeakPeriodAdjustDurationTopTip()Ljava/lang/String;", 0)), Reflection.property1(new PropertyReference1Impl(a.class, "livePkPeakPeriodAutoAdjustDurationEnable", "getLivePkPeakPeriodAutoAdjustDurationEnable()Z", 0)), Reflection.property1(new PropertyReference1Impl(a.class, "livePkPeakPeriodAutoAdjustDurationOnceForAll", "getLivePkPeakPeriodAutoAdjustDurationOnceForAll()Z", 0)), Reflection.property1(new PropertyReference1Impl(a.class, "livePkDisconnectToastCountControl", "getLivePkDisconnectToastCountControl()I", 0))};
        a = r0;
        h = new a();
        com.bytedance.tools.kcp.ultrasettings.runtime.a r1 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_pk_peak_period_begin_time", "20:00:00", String.class, false);
        b = UltraSettingsManager.a().a(r1.a, r1.b, r1.getType(), r1.d, r0[0]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r2 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_pk_peak_period_end_time", "22:00:00", String.class, false);
        c = UltraSettingsManager.a().a(r2.a, r2.b, r2.getType(), r2.d, r0[1]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r3 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_pk_peak_period_adjust_duration_top_tip", "20~22点仅可PK2次，默认10分钟，可手动改回", String.class, false);
        d = UltraSettingsManager.a().a(r3.a, r3.b, r3.getType(), r3.d, r0[2]);
        Boolean r4 = Boolean.TRUE;
        Class r5 = Boolean.TYPE;
        com.bytedance.tools.kcp.ultrasettings.runtime.a r6 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_pk_peak_period_auto_adjust_duration_enable", r4, r5, false);
        e = UltraSettingsManager.a().a(r6.a, r6.b, r6.getType(), r6.d, r0[3]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r7 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_pk_peak_period_auto_adjust_duration_once_for_all", Boolean.FALSE, r5, false);
        f = UltraSettingsManager.a().a(r7.a, r7.b, r7.getType(), r7.d, r0[4]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r8 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_pk_disconnect_toast_count_control", 3, Integer.TYPE, false);
        g = UltraSettingsManager.a().a(r8.a, r8.b, r8.getType(), r8.d, r0[5]);
    }

    public a() {
    }

    public final boolean a() {
        return ((Boolean) f.getValue(this, a[4])).booleanValue();
    }
}
