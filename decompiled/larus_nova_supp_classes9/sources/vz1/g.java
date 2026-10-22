package vz1;

import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.livesdk.gift.platform.business.config.DiamondConfig;
import com.bytedance.android.livesdk.gift.platform.business.config.GiftConfigKey;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class g {
    public static DiamondConfig a;

    public static final String a(Long r7, boolean r8) {
        if (r7 != null) goto L5;
        return null;
    L5:
        DiamondConfig r0 = a;
        if (r0 != null) goto L9;
        com.bytedance.android.livesdk.gift.platform.business.config.j r1 = com.bytedance.android.livesdk.gift.util.b.a();
        GiftConfigKey r2 = GiftConfigKey.KEY_GIFT_DIALOG_DIAMOND;
        DiamondConfig.d.getClass();
        r0 = (DiamondConfig) r1.c(r2, DiamondConfig.a.a());
    L9:
        if (nz1.a.k().a() == false) goto L15;
        if (r7.longValue() <= nz1.a.k().b()) goto L15;
        if (r8 == false) goto L15;
        return String.valueOf(nz1.a.k().b()) + " " + r0.b + "+";
    L15:
        if (r7.longValue() <= 0) goto L18;
        return String.valueOf(r7.longValue()) + " " + r0.b;
    L18:
        return s1.B(2131919120);
    }
}
