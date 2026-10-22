package z41;

import com.bytedance.tools.kcp.ultrasettings.runtime.UltraSettingsManager;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.properties.ReadOnlyProperty;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class f {
    public static final /* synthetic */ KProperty[] a = null;
    public static final ReadOnlyProperty b = null;
    public static final boolean c = false;
    public static final f d = null;

    static {
        KProperty[] r0 = {Reflection.property1(new PropertyReference1Impl(f.class, "revLinkUselessLog", "getRevLinkUselessLog()Z", 0))};
        a = r0;
        f r1 = new f();
        d = r1;
        com.bytedance.tools.kcp.ultrasettings.runtime.a r2 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("revlink_useless_log", Boolean.FALSE, Boolean.TYPE, false);
        ReadOnlyProperty r3 = UltraSettingsManager.a().a(r2.a, r2.b, r2.getType(), r2.d, r0[0]);
        b = r3;
        c = ((Boolean) r3.getValue(r1, r0[0])).booleanValue();
    }

    public f() {
    }
}
