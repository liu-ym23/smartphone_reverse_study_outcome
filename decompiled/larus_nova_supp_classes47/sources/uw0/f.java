package uw0;

import com.bytedance.android.live.recharge.order.j;
import com.bytedance.android.live.recharge.order.k;
import kotlin.jvm.internal.Intrinsics;
import tw0.l;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class f implements b {
    public final l a;

    public f(l r2) {
        Intrinsics.checkNotNullParameter(r2, "option");
        this.a = r2;
    }

    @Override // uw0.b
    public final k a(k r5) {
        Intrinsics.checkNotNullParameter(r5, "orderOptions");
        String r0 = this.a.getPreCalcInfo();
        if (r0 != null) goto L5;
    L8:
        boolean r1 = true;
    L9:
        if (r1 == false) goto L11;
        return r5;
    L11:
        j r2 = r5.a;
        String r3 = this.a.t7();
        String r4 = "";
        if (r3 != null) goto L14;
        r3 = "";
    L14:
        r2.put("giving_diamond_badge", r3);
        String r6 = this.a.t4();
        if (r6 != null) goto L17;
        r6 = "";
    L17:
        r2.put("giving_diamond_bar", r6);
        String r7 = this.a.getPreCalcInfo();
        if (r7 == null) goto L21;
        r4 = r7;
    L21:
        r2.put("pre_calc_info", r4);
        return r5;
    L5:
        if (r0.length() == 0) goto L8;
        r1 = false;
        goto L9
    }
}
