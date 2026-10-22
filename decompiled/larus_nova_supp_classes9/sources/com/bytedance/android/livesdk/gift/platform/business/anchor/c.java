package com.bytedance.android.livesdk.gift.platform.business.anchor;

import com.bytedance.tools.kcp.ultrasettings.runtime.UltraSettingsManager;
import kotlin.jvm.internal.PropertyReference0Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.properties.ReadOnlyProperty;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class c {
    public static final /* synthetic */ KProperty[] a = null;
    public static final ReadOnlyProperty b = null;

    static {
        KProperty[] r1 = {Reflection.property0(new PropertyReference0Impl(c.class, "anchorPostEffectDurationConfig", "getAnchorPostEffectDurationConfig()Lcom/bytedance/android/livesdk/gift/platform/business/anchor/model/AnchorTrayPostEffectConfig;", 1))};
        a = r1;
        com.bytedance.tools.kcp.ultrasettings.runtime.a r0 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_gift_anchor_post_effect_config", new lz1.a(), lz1.a.class, false);
        b = UltraSettingsManager.a().a(r0.a, r0.b, r0.getType(), r0.d, r1[0]);
    }

    public static final lz1.a a() {
        return (lz1.a) b.getValue(null, a[0]);
    }
}
