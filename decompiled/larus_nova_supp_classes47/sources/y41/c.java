package y41;

import com.bytedance.tools.kcp.ultrasettings.runtime.UltraSettingsManager;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.properties.ReadOnlyProperty;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class c {
    public static final /* synthetic */ KProperty[] a = null;
    public static final ReadOnlyProperty b = null;
    public static final ReadOnlyProperty c = null;
    public static final ReadOnlyProperty d = null;
    public static final c e = null;

    static {
        KProperty[] r0 = {Reflection.property1(new PropertyReference1Impl(c.class, "livePkChorusPerformanceLimit", "getLivePkChorusPerformanceLimit()F", 0)), Reflection.property1(new PropertyReference1Impl(c.class, "livePkEnableChorus", "getLivePkEnableChorus()Z", 0)), Reflection.property1(new PropertyReference1Impl(c.class, "livePkChorusMuteBackupEnable", "getLivePkChorusMuteBackupEnable()Z", 0))};
        a = r0;
        e = new c();
        com.bytedance.tools.kcp.ultrasettings.runtime.a r1 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_pk_chorus_performance_limit", Float.valueOf(7.02f), Float.TYPE, false);
        b = UltraSettingsManager.a().a(r1.a, r1.b, r1.getType(), r1.d, r0[0]);
        Boolean r4 = Boolean.TRUE;
        Class r6 = Boolean.TYPE;
        com.bytedance.tools.kcp.ultrasettings.runtime.a r2 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_pk_enable_chorus", r4, r6, false);
        c = UltraSettingsManager.a().a(r2.a, r2.b, r2.getType(), r2.d, r0[1]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r3 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_pk_chorus_mute_back_up_enable", r4, r6, false);
        d = UltraSettingsManager.a().a(r3.a, r3.b, r3.getType(), r3.d, r0[2]);
    }

    public c() {
    }
}
