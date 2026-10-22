package f51;

import com.bytedance.live.kmp.core.KmpEnv;
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
    public static final a e = null;

    static {
        KProperty[] r0 = {Reflection.property1(new PropertyReference1Impl(a.class, "livePkPrivacyHint", "getLivePkPrivacyHint()Ljava/lang/String;", 0)), Reflection.property1(new PropertyReference1Impl(a.class, "livePkRuleUrl", "getLivePkRuleUrl()Ljava/lang/String;", 0)), Reflection.property1(new PropertyReference1Impl(a.class, "anchorBluetoothPermission", "getAnchorBluetoothPermission()Z", 0))};
        a = r0;
        e = new a();
        com.bytedance.tools.kcp.ultrasettings.runtime.a r1 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_pk_privacy_hint", "私密账号在%s时，对方观众可看到你的直播内容", String.class, false);
        b = UltraSettingsManager.a().a(r1.a, r1.b, r1.getType(), r1.d, r0[0]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r2 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_pk_rule_url_android", "", String.class, false);
        c = UltraSettingsManager.a().a(r2.a, r2.b, r2.getType(), r2.d, r0[1]);
        KmpEnv r3 = KmpEnv.a;
        com.bytedance.tools.kcp.ultrasettings.runtime.a r4 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("anchor_bluetooth_permission", Boolean.valueOf(KmpEnv.a()), Boolean.TYPE, false);
        d = UltraSettingsManager.a().a(r4.a, r4.b, r4.getType(), r4.d, r0[2]);
    }

    public a() {
    }

    public final String a() {
        return (String) b.getValue(this, a[0]);
    }
}
