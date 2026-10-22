package hw0;

import com.bytedance.android.live.recharge.core.RechargeServices;
import com.bytedance.android.live.recharge.deal.n;
import com.bytedance.android.live.recharge.order.j;
import com.bytedance.android.live.recharge.order.k;
import com.bytedance.android.live.recharge.platform.service.IExchangeService;
import com.bytedance.android.live.revenue.common.v;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.google.gson.JsonObject;
import java.util.HashMap;
import java.util.Iterator;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class f extends b<h, i> {

    public static final class a {
    }

    static {
    }

    public f() {
    }

    public final void invoke(Object r24, CallContext r25) {
        h r2 = (h) r24;
        Intrinsics.checkNotNullParameter(r2, "params");
        Intrinsics.checkNotNullParameter(r25, "context");
        Integer r0 = r2.d();
        int r1 = 0;
        if (r0 == null) goto L5;
        int r3 = r0.intValue();
    L6:
        Integer r4 = r2.e();
        if (r4 == null) goto L9;
        int r5 = r4.intValue();
    L10:
        Integer r6 = r2.f();
        if (r6 == null) goto L13;
        int r7 = r6.intValue();
    L14:
        Integer r8 = r2.a();
        if (r8 == null) goto L17;
        r1 = r8.intValue();
    L17:
        if (r3 > 0) goto L19;
        i r9 = new i();
        r9.a(-1);
        r9.b("input diamond invalid");
        Unit r10 = Unit.INSTANCE;
        finishWithResult(r9);
        return;
    L19:
        new com.bytedance.android.live.revenue.common.g("IncomeExchangeMethod", null).b("exchange jsb buyDiamond begin. params=" + r2);
        n r12 = new n(r3, r1, r7);
        HashMap r13 = new HashMap();
        JsonObject r14 = r2.g();
        if (r14 == null) goto L25;
        Iterator r15 = r14.keySet().iterator();
    L23:
        if (r15.hasNext() == false) goto L25;
        String r16 = (String) r15.next();
        r13.put(r16, String.valueOf(r14.get(r16)));
    L25:
        j r17 = new j(r13);
        String r18 = r2.h();
        String r19 = "";
        if (r18 != null) goto L28;
        r18 = "";
    L28:
        r17.e(r18);
        String r20 = r2.c();
        if (r20 != null) goto L31;
        r20 = "";
    L31:
        r17.d(r20);
        String r22 = r2.b();
        if (r22 == null) goto L35;
        r19 = r22;
    L35:
        r17.c(r19);
        k r23 = new k(r17, null, false, 0, false, false, 0, 0, null, null, null, 8190);
        if (r5 != 0) goto L38;
        IExchangeService.ExchangeApiType r26 = IExchangeService.ExchangeApiType.CASH;
    L45:
        IExchangeService.b r110 = new IExchangeService.b(r12, r26, null, false, 110);
        int r27 = v.a;
        v.e("ttlive_exchange", "exchange from jsb, param=" + r2);
        com.bytedance.android.live.recharge.core.d r28 = RechargeServices.b();
        Intrinsics.checkNotNullParameter(r28, "$this$exchangeService");
        IExchangeService r29 = (IExchangeService) r28.a(Reflection.getOrCreateKotlinClass(IExchangeService.class));
        if (r29 == null) goto L51;
        r29.t1(r110, r23, new g(this, r2, r3, r110, r23));
        return;
    L51:
        return;
    L38:
        if (r5 != 1) goto L40;
        r26 = IExchangeService.ExchangeApiType.GOLD_BALANCE;
        goto L45
    L40:
        if (r5 == 2) goto L42;
        r26 = IExchangeService.ExchangeApiType.CASH;
        goto L45
    L42:
        r26 = IExchangeService.ExchangeApiType.HUOSHAN_FLAME;
        goto L45
    L13:
        r7 = 0;
        goto L14
    L9:
        r5 = 0;
        goto L10
    L5:
        r3 = 0;
        goto L6
    }
}
