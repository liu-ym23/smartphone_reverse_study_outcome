package b02;

import com.bytedance.android.livesdk.gift.configmodel.o2;
import com.bytedance.android.livesdk.gift.model.o0;
import com.bytedance.android.livesdk.gift.platform.business.normal.model.NormalGiftMessage;
import com.bytedance.android.livesdk.message.model.o7;
import com.bytedance.tools.kcp.ultrasettings.runtime.UltraSettingsManager;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference0Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.properties.ReadOnlyProperty;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class a {
    public static final /* synthetic */ KProperty[] a = null;
    public static final ReadOnlyProperty b = null;
    public static final ReadOnlyProperty c = null;

    static {
        KProperty[] r0 = {Reflection.property0(new PropertyReference0Impl(a.class, "LIVE_BIG_GIFT_COMBO_CLICK_AREA_OPT", "getLIVE_BIG_GIFT_COMBO_CLICK_AREA_OPT()I", 1)), Reflection.property0(new PropertyReference0Impl(a.class, "LIVE_BIG_GIFT_COMBO_ANIM_LEAK_FIX", "getLIVE_BIG_GIFT_COMBO_ANIM_LEAK_FIX()Z", 1))};
        a = r0;
        com.bytedance.tools.kcp.ultrasettings.runtime.a r1 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_big_gift_combo_click_area_opt", 0, Integer.TYPE, false);
        b = UltraSettingsManager.a().a(r1.a, r1.b, r1.getType(), r1.d, r0[0]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r2 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_big_gift_combo_anim_leak_fix", Boolean.FALSE, Boolean.TYPE, false);
        c = UltraSettingsManager.a().a(r2.a, r2.b, r2.getType(), r2.d, r0[1]);
    }

    public static final long a() {
        if (nz1.a.e() != 0) goto L6;
        return 6000;
    L6:
        return ((long) nz1.a.e()) * 1000;
    }

    public static final boolean e() {
        if (com.bytedance.android.livesdk.gift.platform.business.j.b().getEnable() == false) goto L5;
    L8:
        return true;
    L5:
        if (((Boolean) nz1.a.T.getValue(null, nz1.a.a[44])).booleanValue() == true) goto L8;
        return false;
    }

    public static final boolean b(NormalGiftMessage r1) {
        if (com.bytedance.android.livesdk.gift.platform.business.j.a() == false) goto L15;
        if (r1 == null) goto L13;
        o7 r2 = r1.r();
        if (r2 == null) goto L13;
        o0 r3 = r2.getTrayInfo();
        if (r3 == null) goto L13;
        if (r3.getTrayGroupMode() != 2) goto L13;
        return false;
    L13:
        return true;
    L15:
        return com.bytedance.android.livesdk.gift.platform.business.j.b().getEnable();
    }

    public static final boolean c(o7 r1) {
        Intrinsics.checkNotNullParameter(r1, "message");
        if (com.bytedance.android.livesdk.gift.platform.business.j.a() == false) goto L12;
        o0 r2 = r1.getTrayInfo();
        if (r2 != null) goto L7;
    L10:
        return true;
    L7:
        if (r2.getTrayGroupMode() != 2) goto L10;
        return false;
    L12:
        return com.bytedance.android.livesdk.gift.platform.business.j.b().getEnable();
    }

    public static final boolean d(NormalGiftMessage r1) {
        Intrinsics.checkNotNullParameter(r1, "message");
        if (com.bytedance.android.livesdk.gift.platform.business.j.a() == false) goto L11;
        o7 r2 = r1.r();
        if (r2 == null) goto L11;
        o0 r3 = r2.getTrayInfo();
        if (r3 == null) goto L11;
        if (r3.getTrayGroupMode() != 0) goto L11;
        return true;
    L11:
        return false;
    }

    public static final int f(NormalGiftMessage r2) {
        Intrinsics.checkNotNullParameter(r2, "message");
        o7 r3 = r2.r();
        if (r3 == null) goto L10;
        o0 r4 = r3.getTrayInfo();
        if (r4 == null) goto L10;
        Integer r5 = r4.getExpensiveTrayGroupNum();
        if (r5 == null) goto L10;
        return r5.intValue();
    L10:
        return ((Number) com.bytedance.android.livesdk.gift.platform.business.e.D.getValue(null, com.bytedance.android.livesdk.gift.platform.business.e.a[28])).intValue();
    }

    public static final int g(NormalGiftMessage r2) {
        Intrinsics.checkNotNullParameter(r2, "message");
        o7 r3 = r2.r();
        if (r3 == null) goto L10;
        o0 r4 = r3.getTrayInfo();
        if (r4 == null) goto L10;
        Integer r5 = r4.getRegularTrayGroupNum();
        if (r5 == null) goto L10;
        return r5.intValue();
    L10:
        return ((o2) t02.a.b.getValue(null, t02.a.a[0])).b();
    }
}
