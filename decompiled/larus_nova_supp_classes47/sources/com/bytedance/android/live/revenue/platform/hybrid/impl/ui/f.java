package com.bytedance.android.live.revenue.platform.hybrid.impl.ui;

import com.bytedance.tools.kcp.ultrasettings.runtime.UltraSettingsManager;
import kotlin.jvm.internal.PropertyReference0Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.properties.ReadOnlyProperty;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class f {
    public static final /* synthetic */ KProperty[] a = null;
    public static final ReadOnlyProperty b = null;

    static {
        KProperty[] r1 = {Reflection.property0(new PropertyReference0Impl(f.class, "REVENUE_HYBRID_CARD_MEM_LEAK_SETTING", "getREVENUE_HYBRID_CARD_MEM_LEAK_SETTING()Z", 1))};
        a = r1;
        com.bytedance.tools.kcp.ultrasettings.runtime.a r0 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("revenue_hybrid_card_mem_leak_setting", Boolean.TRUE, Boolean.TYPE, false);
        b = UltraSettingsManager.a().a(r0.a, r0.b, r0.getType(), r0.d, r1[0]);
    }
}
