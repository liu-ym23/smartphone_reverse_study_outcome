package com.bytedance.android.live.recharge.exchange;

import androidx.lifecycle.MutableLiveData;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.recharge.IRechargeService;
import com.bytedance.android.live.recharge.core.RechargeServices;
import com.bytedance.android.live.recharge.deal.n;
import com.bytedance.android.live.recharge.exchange.model.g;
import com.bytedance.android.live.recharge.order.BusinessType;
import com.bytedance.android.live.recharge.order.Order;
import com.bytedance.android.live.recharge.order.j;
import com.bytedance.android.live.recharge.platform.core.config.RechargeConfigKey;
import com.bytedance.android.live.recharge.platform.service.IExchangeService;
import com.bytedance.android.live.recharge.trace.ExchangeTraceEvent;
import com.bytedance.android.live.revenue.common.ToastUtil;
import com.bytedance.android.scope.o;
import io.reactivex.functions.Consumer;
import jc1.k;
import kotlin.Unit;
import zv0.e;
import zv0.f;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class a implements o, xw0.a {
    public final MutableLiveData<g> a;
    public final String b;
    public int c;
    public int d;
    public long e;

    /* JADX INFO: renamed from: com.bytedance.android.live.recharge.exchange.a$a, reason: collision with other inner class name */
    public static final class C0062a {
    }

    public static final class b<T> implements Consumer {
        public final /* synthetic */ Order a;
        public final /* synthetic */ a b;
        public final /* synthetic */ long c;
        public final /* synthetic */ e d;
        public final /* synthetic */ com.bytedance.android.live.revenue.common.g e;

        public b(Order r1, a r2, long r3, e r5, com.bytedance.android.live.revenue.common.g r6) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r5;
            this.e = r6;
        }

        public final void accept(Object r14) {
            Order.State r15 = (Order.State) r14;
            Order r16 = this.a;
            Order.State r0 = (Order.State) r16.getState().b;
            int r1 = com.bytedance.android.live.recharge.exchange.b.a[r0.ordinal()];
            boolean r2 = true;
            if (r1 != 1) goto L5;
            a r3 = this.b;
            long r4 = this.c;
            r3.getClass();
            IRechargeService r5 = (IRechargeService) k.f(IRechargeService.class);
            if (r5 == null) goto L33;
            f r6 = r5.rechargeCenter();
            if (r6 == null) goto L33;
            long r7 = r6.getAvailableDiamonds();
        L34:
            long r8 = r7 + r4;
            IRechargeService r9 = (IRechargeService) k.f(IRechargeService.class);
            if (r9 == null) goto L39;
            f r10 = r9.rechargeCenter();
            if (r10 == null) goto L39;
            r10.setAvailableDiamonds(r8);
        L39:
            IRechargeService r12 = (IRechargeService) k.f(IRechargeService.class);
            if (r12 == null) goto L44;
            f r13 = r12.rechargeCenter();
            if (r13 == null) goto L44;
            r13.sync("exchange");
        L44:
            IRechargeService r17 = (IRechargeService) k.f(IRechargeService.class);
            if (r17 == null) goto L50;
            f r18 = r17.rechargeCenter();
            if (r18 == null) goto L50;
            r18.syncExchangeInfo();
        L50:
            if (((Boolean) com.bytedance.android.live.recharge.core.f.k(RechargeServices.b()).E1(RechargeConfigKey.KEY_CASH_EXCHANGE_REBATE, Boolean.FALSE)).booleanValue() == false) goto L60;
            Object r19 = r16.getResult();
            if (r19 == null) goto L59;
            Integer r20 = Integer.valueOf(((IExchangeService.c) r19).e);
            Object r110 = r16.getResult();
            if (r110 == null) goto L57;
            g r22 = new g(5, null, r20, ((IExchangeService.c) r110).f, this.c, this.d, 32);
        L61:
            this.b.a.setValue(r22);
            this.e.a("buyDiamondByExchange auto");
            a r111 = this.b;
            Integer r23 = r22.c;
            String r24 = r22.d;
            r111.getClass();
            if (r24 != null) goto L64;
        L67:
            if (r2 == true) goto L69;
            ToastUtil.b(r24, 0);
        L73:
            final a r112 = this.b;
            e r25 = this.d;
            r112.getClass();
            int r26 = com.bytedance.android.live.recharge.trace.a.a;
            com.bytedance.android.live.recharge.trace.a.b(ExchangeTraceEvent.DIAMOND_AUTO_EXCHANGE.getEventType());
            if (r25 == null) goto L79;
            r25.c(new ExchangeDialogViewModel$onExchangeSuccess$1(r112));
            return;
        L79:
            return;
        L69:
            if (r23 == null) goto L73;
            if (r23.intValue() == 0) goto L73;
            int r113 = ToastUtil.a;
            ToastUtil.c(new mw0.a(r23.intValue(), Integer.valueOf(((IRechargeService) k.n(IRechargeService.class)).rechargeCenter().getExchangeInfo().getRebateLimit()), Integer.valueOf(((IRechargeService) k.n(IRechargeService.class)).rechargeCenter().getExchangeInfo().getGiftAmount()), s1.getContext()).getView());
            goto L73
        L64:
            if (r24.length() == 0) goto L67;
            r2 = false;
            goto L67
        L57:
            throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.live.recharge.platform.service.IExchangeService.ExchangeResult");
        L59:
            throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.live.recharge.platform.service.IExchangeService.ExchangeResult");
        L60:
            r22 = new g(5, null, null, null, 0, null, 124);
        L33:
            r7 = 0;
            goto L34
        L5:
            if (r1 != 2) goto L80;
            MutableLiveData<g> r27 = this.b.a;
            Object r28 = r16.getResult();
            if (r28 == null) goto L27;
            r27.setValue(new g(6, (Throwable) r28, null, null, 0, null, 124));
            IRechargeService r29 = (IRechargeService) k.f(IRechargeService.class);
            if (r29 == null) goto L14;
            f r30 = r29.rechargeCenter();
            if (r30 == null) goto L14;
            r30.sync("exchange");
        L14:
            IRechargeService r32 = (IRechargeService) k.f(IRechargeService.class);
            if (r32 == null) goto L19;
            f r33 = r32.rechargeCenter();
            if (r33 == null) goto L19;
            r33.syncExchangeInfo();
        L19:
            e r34 = this.d;
            if (r34 == null) goto L77;
            Object r114 = r16.getResult();
            if (r114 == null) goto L25;
            r34.a((Throwable) r114);
            return;
        L25:
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Throwable");
        L77:
            return;
        L27:
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Throwable");
        }
    }

    static {
    }

    public final void onStart() {
    }

    public final void onStop() {
    }

    public a() {
        MutableLiveData<g> r0 = new MutableLiveData();
        r0.setValue(new g(1, null, null, null, 0, null, 124));
        Unit r1 = Unit.INSTANCE;
        this.a = r0;
        this.b = "ExchangeDialogViewModel";
    }

    @Override // xw0.a
    public final void C1(long r22, e r24, boolean r25, int r26, int r27) {
        this.a.setValue(new g(1, null, null, null, 0, null, 124));
        com.bytedance.android.live.revenue.common.g r6 = new com.bytedance.android.live.revenue.common.g(this.b, null);
        r6.b("buyDiamondByExchange begin.");
        int r1 = (int) r22;
        if (r25 == false) goto L5;
        int r2 = r26;
    L6:
        if (r25 == false) goto L8;
        int r5 = r27;
    L9:
        n r0 = new n(r1, r2, r5);
        this.e = r22;
        if (r25 == false) goto L12;
        this.c = r26;
        this.d = r27;
    L12:
        com.bytedance.android.live.recharge.order.a r3 = com.bytedance.android.live.recharge.core.f.i(RechargeServices.b());
        j r9 = new j();
        r9.e("gift_sendgift");
        r9.d("");
        r9.c("");
        com.bytedance.android.live.recharge.order.f.b r4 = r3.u1(r0, new com.bytedance.android.live.recharge.order.k(r9, null, false, 0, false, false, 0, 0, null, null, null, 8190), BusinessType.ExchangeOnly);
        com.bytedance.android.live.revenue.common.reactive.j.a(r4.c, true).filter(com.bytedance.android.live.recharge.order.d.a).take(1).subscribe(new b(r4, this, r22, r24, r6));
        return;
    L8:
        r5 = this.d;
        goto L9
    L5:
        r2 = this.c;
        goto L6
    }
}
