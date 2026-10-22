package ta0;

import com.bytedance.android.live.incentive.exchange.d;
import com.bytedance.android.live.incentive.exchange.f;
import com.bytedance.android.live.incentive.exchange.jsb.RevenueNotifyIncomeExchangeResultResultModel;
import com.bytedance.ies.web.jsbridge2.CallContext;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class b extends a<c, RevenueNotifyIncomeExchangeResultResultModel> {
    public b() {
    }

    public final void invoke(Object r9, CallContext r11) {
        c r12 = (c) r9;
        Intrinsics.checkNotNullParameter(r12, "args");
        Intrinsics.checkNotNullParameter(r11, "callContext");
        String r0 = r12.d();
        if (r0 != null) goto L5;
        String r2 = "";
    L6:
        Integer r1 = r12.e();
        if (r1 == null) goto L9;
        int r3 = r1.intValue();
    L10:
        String r4 = r12.getType();
        if (r4 != null) goto L13;
        r4 = "";
    L13:
        Integer r5 = r12.a();
        if (r5 == null) goto L16;
        int r6 = r5.intValue();
    L17:
        Integer r7 = r12.b();
        if (r7 == null) goto L20;
        int r8 = r7.intValue();
    L21:
        String r13 = r12.c();
        if (r13 != null) goto L24;
        String r14 = "";
    L25:
        f r15 = new f(r2, r3, r4, r6, r8, r14);
        jy0.b.a("Incentive/RevenueNotifyIncomeExchangeResultMethod", r15.toString());
        qa0.a r16 = qa0.c.b.getService(d.class);
        Intrinsics.checkNotNull(r16);
        ((d) r16).h(r15);
        finishWithSuccess();
        return;
    L24:
        r14 = r13;
        goto L25
    L20:
        r8 = 0;
        goto L21
    L16:
        r6 = 0;
        goto L17
    L9:
        r3 = 0;
        goto L10
    L5:
        r2 = r0;
        goto L6
    }
}
