package com.bytedance.android.livesdk.gift.platform.business.dialog.v3.helper;

import com.bytedance.tools.kcp.ultrasettings.runtime.UltraSettingsManager;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.properties.ReadOnlyProperty;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class x {
    public static final /* synthetic */ KProperty[] a = null;
    public static final ReadOnlyProperty b = null;
    public static final ReadOnlyProperty c = null;
    public static w d;
    public static final x e = null;

    static {
        KProperty[] r0 = {Reflection.property1(new PropertyReference1Impl(x.class, "LIVE_GIFT_PANEL_ANYA_OPT", "getLIVE_GIFT_PANEL_ANYA_OPT()Lcom/bytedance/android/livesdk/gift/platform/business/dialog/v3/helper/GiftPanelAnyaOptConfig;", 0)), Reflection.property1(new PropertyReference1Impl(x.class, "LIVE_GIFT_PANEL_VM_DELAY_DISPOSE", "getLIVE_GIFT_PANEL_VM_DELAY_DISPOSE()Z", 0))};
        a = r0;
        x r1 = new x();
        e = r1;
        com.bytedance.tools.kcp.ultrasettings.runtime.a r3 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_gift_panel_anya_opt", new w(), w.class, false);
        ReadOnlyProperty r4 = UltraSettingsManager.a().a(r3.a, r3.b, r3.getType(), r3.d, r0[0]);
        b = r4;
        com.bytedance.tools.kcp.ultrasettings.runtime.a r5 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_gift_panel_vm_delay_dispose", Boolean.TRUE, Boolean.TYPE, false);
        c = UltraSettingsManager.a().a(r5.a, r5.b, r5.getType(), r5.d, r0[1]);
        d = (w) r4.getValue(r1, r0[0]);
    }

    public x() {
    }

    public static boolean a() {
        return d.b();
    }
}
