package z41;

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
    public static final boolean d = false;
    public static final boolean e = false;
    public static final a f = null;

    static {
        KProperty[] r0 = {Reflection.property1(new PropertyReference1Impl(a.class, "printRequestLayout", "getPrintRequestLayout()Z", 0)), Reflection.property1(new PropertyReference1Impl(a.class, "printPkMeasureDuration", "getPrintPkMeasureDuration()Z", 0))};
        a = r0;
        a r1 = new a();
        f = r1;
        Boolean r4 = Boolean.FALSE;
        Class r6 = Boolean.TYPE;
        com.bytedance.tools.kcp.ultrasettings.runtime.a r3 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("pk_measure_debug_print_request_layout", r4, r6, false);
        ReadOnlyProperty r5 = UltraSettingsManager.a().a(r3.a, r3.b, r3.getType(), r3.d, r0[0]);
        b = r5;
        com.bytedance.tools.kcp.ultrasettings.runtime.a r7 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("pk_measure_debug_print_duration", r4, r6, false);
        ReadOnlyProperty r8 = UltraSettingsManager.a().a(r7.a, r7.b, r7.getType(), r7.d, r0[1]);
        c = r8;
        d = ((Boolean) r5.getValue(r1, r0[0])).booleanValue();
        e = ((Boolean) r8.getValue(r1, r0[1])).booleanValue();
    }

    public a() {
    }
}
