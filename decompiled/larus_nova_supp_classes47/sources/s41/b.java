package s41;

import com.bytedance.tools.kcp.ultrasettings.runtime.UltraSettingsManager;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.properties.ReadOnlyProperty;
import kotlin.reflect.KProperty;
import r11.u;
import r11.v;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class b {
    public static final /* synthetic */ KProperty[] a = null;
    public static final ReadOnlyProperty b = null;
    public static final b c = null;

    static {
        KProperty[] r0 = {Reflection.property1(new PropertyReference1Impl(b.class, "liveInterCommentConfig", "getLiveInterCommentConfig()Lcom/bytedance/android/live/revlink/impl/config/RevLiveInterComDialogConfig;", 0))};
        a = r0;
        c = new b();
        com.bytedance.tools.kcp.ultrasettings.runtime.a r1 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_intercom_comment_config", new v(), u.class, false);
        b = UltraSettingsManager.a().a(r1.a, r1.b, r1.getType(), r1.d, r0[0]);
    }

    public b() {
    }

    public final u a() {
        return (u) b.getValue(this, a[0]);
    }
}
