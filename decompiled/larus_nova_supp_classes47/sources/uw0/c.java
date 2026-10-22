package uw0;

import com.bytedance.android.live.recharge.order.k;
import com.bytedance.android.live.recharge.platform.model.NoPasswordPayType;
import kotlin.jvm.internal.Intrinsics;
import tw0.j;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class c implements b {
    public final j a;

    public c(j r2) {
        Intrinsics.checkNotNullParameter(r2, "option");
        this.a = r2;
    }

    @Override // uw0.b
    public final k a(k r10) {
        Intrinsics.checkNotNullParameter(r10, "orderOptions");
        NoPasswordPayType.a r0 = NoPasswordPayType.Companion;
        int r1 = this.a.getOrderType();
        r0.getClass();
        NoPasswordPayType[] r2 = NoPasswordPayType.values();
        int r4 = r2.length;
        int r6 = 0;
    L3:
        if (r6 >= r4) goto L11;
        NoPasswordPayType r7 = r2[r6];
        if (r7.getValue() != r1) goto L7;
        boolean r8 = true;
    L8:
        if (r8 == true) goto L12;
        r6 = r6 + 1;
    L12:
        if (r7 != null) goto L14;
        NoPasswordPayType r5 = NoPasswordPayType.NOT_USE_NO_PASSWORD;
    L16:
        return k.a(r10, null, null, null, r5, 7167);
    L14:
        r5 = r7;
        goto L16
    L7:
        r8 = false;
        goto L8
    L11:
        r7 = null;
        goto L12
    }
}
