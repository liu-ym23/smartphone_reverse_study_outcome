package z41;

import com.bytedance.tools.kcp.ultrasettings.runtime.UltraSettingsManager;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.properties.ReadOnlyProperty;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class c {
    public static final /* synthetic */ KProperty[] a = null;
    public static final ReadOnlyProperty b = null;
    public static final a51.b c = null;
    public static final c d = null;

    static {
        KProperty[] r0 = {Reflection.property1(new PropertyReference1Impl(c.class, "layoutOptConfig", "getLayoutOptConfig()Lcom/bytedance/android/live/revlink/impl/settings/opt/model/RevLinkAnimOptConfig;", 0))};
        a = r0;
        c r1 = new c();
        d = r1;
        com.bytedance.tools.kcp.ultrasettings.runtime.a r2 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("revlink_anim_opt_config", new a51.b(), a51.b.class, false);
        ReadOnlyProperty r3 = UltraSettingsManager.a().a(r2.a, r2.b, r2.getType(), r2.d, r0[0]);
        b = r3;
        c = (a51.b) r3.getValue(r1, r0[0]);
    }

    public c() {
    }
}
