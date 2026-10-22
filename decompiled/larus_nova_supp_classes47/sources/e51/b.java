package e51;

import com.bytedance.tools.kcp.ultrasettings.runtime.UltraSettingsManager;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.properties.ReadOnlyProperty;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class b {
    public static final /* synthetic */ KProperty[] a = null;
    public static final ReadOnlyProperty b = null;
    public static final ReadOnlyProperty c = null;
    public static final b d = null;

    static {
        KProperty[] r0 = {Reflection.property1(new PropertyReference1Impl(b.class, "livePkSupportLinkV2", "getLivePkSupportLinkV2()Z", 0)), Reflection.property1(new PropertyReference1Impl(b.class, "livePkAudienceGetOppositeAnchorLinkMicId", "getLivePkAudienceGetOppositeAnchorLinkMicId()Z", 0))};
        a = r0;
        d = new b();
        Boolean r3 = Boolean.TRUE;
        Class r4 = Boolean.TYPE;
        com.bytedance.tools.kcp.ultrasettings.runtime.a r1 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_support_start_pk_with_audience", r3, r4, false);
        b = UltraSettingsManager.a().a(r1.a, r1.b, r1.getType(), r1.d, r0[0]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r2 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_pk_audience_get_opposite_anchor_linkmic_id", r3, r4, false);
        c = UltraSettingsManager.a().a(r2.a, r2.b, r2.getType(), r2.d, r0[1]);
    }

    public b() {
    }

    public final boolean a() {
        return ((Boolean) b.getValue(this, a[0])).booleanValue();
    }
}
