package jw0;

import com.bytedance.android.live.recharge.IRechargeService;
import com.bytedance.android.live.recharge.order.Order;
import io.reactivex.functions.Consumer;
import jc1.k;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class f<T> implements Consumer {
    public final /* synthetic */ Order a;
    public final /* synthetic */ long b;
    public final /* synthetic */ zv0.e c;

    public f(Order r1, long r2, zv0.e r4) {
        this.a = r1;
        this.b = r2;
        this.c = r4;
    }

    public final void accept(Object r7) {
        Order.State r8 = (Order.State) r7;
        Order.State r9 = (Order.State) this.a.getState().b;
        int r10 = a.c[r9.ordinal()];
        if (r10 != 1) goto L5;
        IRechargeService r12 = (IRechargeService) k.f(IRechargeService.class);
        if (r12 == null) goto L26;
        zv0.f r13 = r12.rechargeCenter();
        if (r13 == null) goto L26;
        long r2 = r13.getAvailableDiamonds();
    L27:
        long r3 = r2 + this.b;
        IRechargeService r14 = (IRechargeService) k.f(IRechargeService.class);
        if (r14 == null) goto L32;
        zv0.f r15 = r14.rechargeCenter();
        if (r15 == null) goto L32;
        r15.setAvailableDiamonds(r3);
    L32:
        IRechargeService r16 = (IRechargeService) k.f(IRechargeService.class);
        if (r16 == null) goto L37;
        zv0.f r17 = r16.rechargeCenter();
        if (r17 == null) goto L37;
        r17.sync("exchange");
    L37:
        IRechargeService r18 = (IRechargeService) k.f(IRechargeService.class);
        if (r18 == null) goto L42;
        zv0.f r19 = r18.rechargeCenter();
        if (r19 == null) goto L42;
        r19.syncExchangeInfo();
    L42:
        int r20 = h.a;
        h.e("live_detail", Long.valueOf(this.b));
        zv0.e r22 = this.c;
        if (r22 == null) goto L47;
        r22.c(null);
        return;
    L47:
        return;
    L26:
        r2 = 0;
        goto L27
    L5:
        if (r10 != 2) goto L48;
        Throwable r23 = new Throwable("下单失败");
        IRechargeService r0 = (IRechargeService) k.f(IRechargeService.class);
        if (r0 == null) goto L12;
        zv0.f r1 = r0.rechargeCenter();
        if (r1 == null) goto L12;
        r1.sync("exchange");
    L12:
        IRechargeService r4 = (IRechargeService) k.f(IRechargeService.class);
        if (r4 == null) goto L17;
        zv0.f r5 = r4.rechargeCenter();
        if (r5 == null) goto L17;
        r5.syncExchangeInfo();
    L17:
        zv0.e r6 = this.c;
        if (r6 == null) goto L20;
        r6.a(r23);
    L20:
        h.a(r23);
        return;
    }
}
