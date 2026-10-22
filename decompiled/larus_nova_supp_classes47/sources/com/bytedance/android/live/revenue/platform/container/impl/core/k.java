package com.bytedance.android.live.revenue.platform.container.impl.core;

import com.bytedance.tools.kcp.ultrasettings.runtime.UltraSettingsManager;
import kotlin.jvm.internal.PropertyReference0Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.properties.ReadOnlyProperty;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class k {
    public static final /* synthetic */ KProperty[] a = null;
    public static final ReadOnlyProperty b = null;
    public static final ReadOnlyProperty c = null;
    public static final ReadOnlyProperty d = null;

    static {
        KProperty[] r0 = {Reflection.property0(new PropertyReference0Impl(k.class, "LIVE_SERVICE_CENTER_REUSE", "getLIVE_SERVICE_CENTER_REUSE()Z", 1)), Reflection.property0(new PropertyReference0Impl(k.class, "LIVE_SERVICE_CENTER_AIOLINK_ASYNC", "getLIVE_SERVICE_CENTER_AIOLINK_ASYNC()Z", 1)), Reflection.property0(new PropertyReference0Impl(k.class, "LIVE_REDPACKET_SERVICE_LAZY_LOAD", "getLIVE_REDPACKET_SERVICE_LAZY_LOAD()Z", 1))};
        a = r0;
        Boolean r4 = Boolean.FALSE;
        Class r6 = Boolean.TYPE;
        com.bytedance.tools.kcp.ultrasettings.runtime.a r1 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_service_center_reuse", r4, r6, false);
        b = UltraSettingsManager.a().a(r1.a, r1.b, r1.getType(), r1.d, r0[0]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r2 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_service_center_aiolink_async", r4, r6, false);
        c = UltraSettingsManager.a().a(r2.a, r2.b, r2.getType(), r2.d, r0[1]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r3 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_redpacket_service_lazy_load", r4, r6, false);
        d = UltraSettingsManager.a().a(r3.a, r3.b, r3.getType(), r3.d, r0[2]);
    }

    public static final boolean a() {
        return ((Boolean) b.getValue(null, a[0])).booleanValue();
    }
}
