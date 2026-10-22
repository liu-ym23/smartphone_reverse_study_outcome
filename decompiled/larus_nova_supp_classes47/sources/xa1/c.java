package xa1;

import com.bytedance.tools.kcp.ultrasettings.runtime.UltraSettingsManager;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.properties.ReadOnlyProperty;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class c {
    public static final /* synthetic */ KProperty[] a = null;
    public static final ReadOnlyProperty b = null;
    public static final c c = null;

    static {
        KProperty[] r0 = {Reflection.property1(new PropertyReference1Impl(c.class, "liveStreamEnableSeiSign", "getLiveStreamEnableSeiSign()Z", 0))};
        a = r0;
        c = new c();
        com.bytedance.tools.kcp.ultrasettings.runtime.a r1 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_stream_enable_sei_sign", Boolean.FALSE, Boolean.TYPE, false);
        b = UltraSettingsManager.a().a(r1.a, r1.b, r1.getType(), r1.d, r0[0]);
    }

    public c() {
    }
}
