package t02;

import com.bytedance.android.livesdk.gift.configmodel.o2;
import com.bytedance.tools.kcp.ultrasettings.runtime.UltraSettingsManager;
import kotlin.jvm.internal.PropertyReference0Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.properties.ReadOnlyProperty;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class a {
    public static final /* synthetic */ KProperty[] a = null;
    public static final ReadOnlyProperty b = null;

    static {
        KProperty[] r1 = {Reflection.property0(new PropertyReference0Impl(a.class, "liveSmallGiftTrayComboCountUpperBound", "getLiveSmallGiftTrayComboCountUpperBound()Lcom/bytedance/android/livesdk/gift/configmodel/SmallGiftMessageConfig;", 1))};
        a = r1;
        com.bytedance.tools.kcp.ultrasettings.runtime.a r0 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_small_gift_tray_combo_count_upper_bound", new o2(), o2.class, false);
        b = UltraSettingsManager.a().a(r0.a, r0.b, r0.getType(), r0.d, r1[0]);
    }
}
