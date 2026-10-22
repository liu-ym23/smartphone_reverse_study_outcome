package oy1;

import com.bytedance.android.live.recharge.IRechargeService;
import com.bytedance.android.live.revenue.core.util.j;
import com.bytedance.android.livesdk.gift.model.h1;
import com.bytedance.android.livesdk.gift.model.k0;
import kotlin.jvm.internal.Intrinsics;
import yz0.k;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class e implements a {
    public e() {
    }

    @Override // oy1.a
    public final boolean a(h1 r6) {
        Intrinsics.checkNotNullParameter(r6, "gift");
        long r0 = r6.getDiamondCount();
        k r2 = com.bytedance.android.live.revenue.core.util.f.d(j.C0.a(), k.class);
        if (r2 != null) goto L6;
        return false;
    L6:
        if (jc1.k.n(IRechargeService.class).rechargeCenter().isSyncWalletInfoSuccess() == true) goto L9;
        return false;
    L9:
        if (jc1.k.n(IRechargeService.class).rechargeCenter().isDiamondAvailable(r0) == false) goto L11;
    L19:
        return true;
    L11:
        if (r2.isLiveTypeSandbox() == true) goto L13;
    L14:
        k0 r7 = r6.getGiftPreviewInfo();
        if (r7 != null) goto L17;
    L18:
        return false;
    L17:
        if (r7.getClientCheckLeftDiamond() == false) goto L19;
    L13:
        if (((Boolean) com.bytedance.android.livesdk.gift.platform.business.d.c.getValue(null, com.bytedance.android.livesdk.gift.platform.business.d.a[1])).booleanValue() == false) goto L19;
        goto L14
    }
}
