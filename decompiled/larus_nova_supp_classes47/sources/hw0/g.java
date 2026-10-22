package hw0;

import com.bytedance.android.live.base.exception.ApiServerException;
import com.bytedance.android.live.profile.monitor.DataType;
import com.bytedance.android.live.recharge.IRechargeService;
import com.bytedance.android.live.recharge.exchange.trace.ExchangeTraceBusinessScene;
import com.bytedance.android.live.recharge.exchange.trace.ExchangeTraceKey;
import com.bytedance.android.live.recharge.order.j;
import com.bytedance.android.live.recharge.order.k;
import com.bytedance.android.live.recharge.platform.service.IExchangeService;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class g implements IExchangeService.a {
    public final /* synthetic */ f a;
    public final /* synthetic */ h b;
    public final /* synthetic */ int c;
    public final /* synthetic */ IExchangeService.b d;
    public final /* synthetic */ k e;

    @Override // com.bytedance.android.live.recharge.platform.service.IExchangeService.a
    public final void a(IExchangeService.c r7) {
        Intrinsics.checkNotNullParameter(r7, "result");
        IRechargeService r0 = (IRechargeService) jc1.k.f(IRechargeService.class);
        if (r0 == null) goto L7;
        zv0.f r1 = r0.rechargeCenter();
        if (r1 == null) goto L7;
        r1.sync("exchange");
    L7:
        IRechargeService r2 = (IRechargeService) jc1.k.f(IRechargeService.class);
        if (r2 == null) goto L12;
        zv0.f r3 = r2.rechargeCenter();
        if (r3 == null) goto L12;
        r3.syncExchangeInfo();
    L12:
        int r4 = jw0.h.a;
        jw0.h.e(this.b.h(), Long.valueOf(this.c));
        f r5 = this.a;
        IExchangeService.b r6 = this.d;
        k r8 = this.e;
        r5.getClass();
        j r9 = r8.a;
        Map<String, String> r10 = com.bytedance.android.live.recharge.exchange.trace.a.a;
        ExchangeTraceKey r12 = ExchangeTraceKey.KEY_IS_COMBINE_EXCHANGE;
        if (com.bytedance.android.live.recharge.utils.e.d() == false) goto L15;
        String r13 = DataType.TRUE;
    L16:
        com.bytedance.android.live.recharge.exchange.trace.a.b(r12, r13);
        com.bytedance.android.live.recharge.exchange.trace.a.b(ExchangeTraceKey.KEY_GIFT_SHOW_FROM, "live.incomeExchange JSB");
        com.bytedance.android.live.recharge.exchange.trace.a.b(ExchangeTraceKey.KEY_BUSINESS_SCENE, String.valueOf(ExchangeTraceBusinessScene.EXCHANGE_BUSINESS_SCENE_EXCHANGE_JSB_COMMON.getValue()));
        com.bytedance.android.live.recharge.exchange.trace.a.b(ExchangeTraceKey.KEY_REQUEST_PAGE, r9.b());
        com.bytedance.android.live.recharge.exchange.trace.a.b(ExchangeTraceKey.KEY_CHARGE_REASON, r9.a());
        com.bytedance.android.live.recharge.exchange.trace.a.b(ExchangeTraceKey.KEY_CHARGE_SCENE, (String) r9.b.a(r9, j.i[1]));
        com.bytedance.android.live.recharge.exchange.trace.a.b(ExchangeTraceKey.KEY_DIAMOND_COUNT, String.valueOf(r6.a.e()));
        com.bytedance.android.live.recharge.exchange.trace.a.b(ExchangeTraceKey.KEY_CASH_COUNT, String.valueOf(com.bytedance.android.live.recharge.deal.g.a(r6.a)));
        com.bytedance.android.live.recharge.exchange.trace.a.b(ExchangeTraceKey.KEY_GOLD_COUNT, String.valueOf(com.bytedance.android.live.recharge.deal.g.b(r6.a)));
        com.bytedance.android.live.recharge.exchange.trace.a.a();
        f r14 = this.a;
        i r15 = new i();
        r15.a(0);
        r15.c(r7.a);
        Unit r16 = Unit.INSTANCE;
        r14.finishWithResult(r15);
        return;
    L15:
        r13 = DataType.FALSE;
        goto L16
    }

    @Override // com.bytedance.android.live.recharge.platform.service.IExchangeService.a
    public final void onFailure(Throwable r4) {
        Intrinsics.checkNotNullParameter(r4, "throwable");
        i r0 = new i();
        if ((r4 instanceof ApiServerException) == false) goto L5;
        ApiServerException r1 = (ApiServerException) r4;
        r0.b(r1.getErrorMsg());
        r0.a(Integer.valueOf(r1.getErrorCode()));
    L5:
        IRechargeService r2 = (IRechargeService) jc1.k.f(IRechargeService.class);
        if (r2 == null) goto L10;
        zv0.f r3 = r2.rechargeCenter();
        if (r3 == null) goto L10;
        r3.sync("exchange_jsb");
    L10:
        IRechargeService r5 = (IRechargeService) jc1.k.f(IRechargeService.class);
        if (r5 == null) goto L15;
        zv0.f r6 = r5.rechargeCenter();
        if (r6 == null) goto L15;
        r6.syncExchangeInfo();
    L15:
        jw0.h.a(r4);
        this.a.finishWithResult(r0);
    }

    public g(f r1, h r2, int r3, IExchangeService.b r4, k r5) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
    }
}
