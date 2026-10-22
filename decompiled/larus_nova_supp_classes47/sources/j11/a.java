package j11;

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
    public static final a d = null;

    static {
        KProperty[] r0 = {Reflection.property1(new PropertyReference1Impl(a.class, "linkKmpWidgetFixPure", "getLinkKmpWidgetFixPure()Z", 0)), Reflection.property1(new PropertyReference1Impl(a.class, "linkKmpWidgetFixLeak", "getLinkKmpWidgetFixLeak()Z", 0))};
        a = r0;
        d = new a();
        Boolean r3 = Boolean.FALSE;
        Class r4 = Boolean.TYPE;
        com.bytedance.tools.kcp.ultrasettings.runtime.a r1 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("link_kmp_widget_fix_pure", r3, r4, false);
        b = UltraSettingsManager.a().a(r1.a, r1.b, r1.getType(), r1.d, r0[0]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r2 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("link_kmp_widget_fix_leak", Boolean.TRUE, r4, false);
        c = UltraSettingsManager.a().a(r2.a, r2.b, r2.getType(), r2.d, r0[1]);
    }

    public a() {
    }
}
