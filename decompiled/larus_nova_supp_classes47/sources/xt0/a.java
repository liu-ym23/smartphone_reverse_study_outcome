package xt0;

import com.bytedance.tools.kcp.ultrasettings.runtime.UltraSettingsManager;
import kotlin.jvm.internal.PropertyReference0Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.properties.ReadOnlyProperty;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class a {
    public static final /* synthetic */ KProperty[] a = null;
    public static final ReadOnlyProperty b = null;

    static {
        KProperty[] r1 = {Reflection.property0(new PropertyReference0Impl(a.class, "LIVE_GUIDE_AI_TITLE_GROUP", "getLIVE_GUIDE_AI_TITLE_GROUP()I", 1))};
        a = r1;
        com.bytedance.tools.kcp.ultrasettings.runtime.a r2 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_guide_ai_title_group", 1, Integer.TYPE, false);
        b = UltraSettingsManager.a().a(r2.a, r2.b, r2.getType(), r2.d, r1[0]);
    }
}
