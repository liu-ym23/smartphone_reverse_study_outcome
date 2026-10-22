package e51;

import com.bytedance.tools.kcp.ultrasettings.runtime.UltraSettingsManager;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.properties.ReadOnlyProperty;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class a {
    public static final /* synthetic */ KProperty[] a = null;
    public static final ReadOnlyProperty b = null;
    public static final a c = null;

    static {
        KProperty[] r1 = {Reflection.property1(new PropertyReference1Impl(a.class, "liveFlexActivityEntrance", "getLiveFlexActivityEntrance()I", 0))};
        a = r1;
        c = new a();
        com.bytedance.tools.kcp.ultrasettings.runtime.a r2 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_flex_activity_entrance", 1, Integer.TYPE, true);
        b = UltraSettingsManager.a().a(r2.a, r2.b, r2.getType(), r2.d, r1[0]);
    }

    public a() {
    }

    public final int a() {
        return ((Number) b.getValue(this, a[0])).intValue();
    }
}
