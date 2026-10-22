package y41;

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
        KProperty[] r0 = {Reflection.property1(new PropertyReference1Impl(a.class, "multiAnchorBackupStreamDisable", "getMultiAnchorBackupStreamDisable()Z", 0))};
        a = r0;
        c = new a();
        com.bytedance.tools.kcp.ultrasettings.runtime.a r1 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_multi_linker_backup_stream_disable", Boolean.FALSE, Boolean.TYPE, false);
        b = UltraSettingsManager.a().a(r1.a, r1.b, r1.getType(), r1.d, r0[0]);
    }

    public a() {
    }

    public final boolean a() {
        return ((Boolean) b.getValue(this, a[0])).booleanValue();
    }
}
