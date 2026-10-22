package com.bytedance.android.livesdk.gift.platform.business.anchor;

import com.bytedance.bdlocation.BuildConfig;
import com.bytedance.tools.kcp.ultrasettings.runtime.UltraSettingsManager;
import kotlin.jvm.internal.PropertyReference0Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.properties.ReadOnlyProperty;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class b {
    public static final /* synthetic */ KProperty[] a = null;
    public static final ReadOnlyProperty b = null;
    public static final ReadOnlyProperty c = null;

    static {
        KProperty[] r0 = {Reflection.property0(new PropertyReference0Impl(b.class, "anchorGiftTabConfigEnable", "getAnchorGiftTabConfigEnable()Z", 1)), Reflection.property0(new PropertyReference0Impl(b.class, "anchorGiftTabConfigSchemaUrlString", "getAnchorGiftTabConfigSchemaUrlString()Ljava/lang/String;", 1))};
        a = r0;
        com.bytedance.tools.kcp.ultrasettings.runtime.a r1 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("anchor_gift_tab_config_enable", Boolean.FALSE, Boolean.TYPE, false);
        b = UltraSettingsManager.a().a(r1.a, r1.b, r1.getType(), r1.d, r0[0]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r2 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("anchor_gift_tab_config_schema_url", BuildConfig.FLAVOR, String.class, false);
        c = UltraSettingsManager.a().a(r2.a, r2.b, r2.getType(), r2.d, r0[1]);
    }
}
