package sa0;

import java.util.LinkedHashMap;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import pa0.f;
import pa0.k;
import pa0.o;
import ra0.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class c {
    public final com.bytedance.android.live.incentive.balance.d a;
    public final f b;

    public c(com.bytedance.android.live.incentive.balance.d r3) {
        o r0 = o.c;
        Intrinsics.checkNotNullParameter(r3, "balanceRepository");
        Intrinsics.checkNotNullParameter(r0, "userIncomeRepository");
        this.a = r3;
        this.b = r0;
    }

    public final ra0.b a(k r5) {
        ra0.b r0 = new ra0.b();
        LinkedHashMap r1 = new LinkedHashMap();
        com.bytedance.android.live.incentive.balance.d r2 = this.a;
        if (va0.a.a == false) goto L5;
        com.bytedance.android.live.incentive.balance.b r3 = com.bytedance.android.live.incentive.balance.b.a.a;
    L6:
        Long r4 = r2.c(r3);
        if (r4 == null) goto L9;
        r1.put("", d.a(r4.longValue()));
    L9:
        Long r6 = this.a.c(com.bytedance.android.live.incentive.balance.b.a.a);
        if (r6 == null) goto L12;
        r1.put("cash", d.a(r6.longValue()));
    L12:
        Long r7 = this.a.c(com.bytedance.android.live.incentive.balance.b.d.a);
        if (r7 == null) goto L15;
        r1.put("gold", d.a(r7.longValue()));
    L15:
        Long r8 = this.a.c(com.bytedance.android.live.incentive.balance.b.C0199b.a);
        if (r8 == null) goto L18;
        r1.put("equivalent_cash", d.a(r8.longValue()));
    L18:
        r0.a(r1);
        com.bytedance.android.live.recharge.platform.business.model.a r9 = r5.a.getRebateData();
        if (r9 == null) goto L21;
        e r11 = new e();
        r11.c(r9.getRebateLimit());
        r11.a(r9.getGiftAmount());
        r11.b(r9.getLeftAmount());
        Unit r12 = Unit.INSTANCE;
        r0.b(r11);
    L21:
        return r0;
    L5:
        r3 = com.bytedance.android.live.incentive.balance.b.e.a;
        goto L6
    }
}
