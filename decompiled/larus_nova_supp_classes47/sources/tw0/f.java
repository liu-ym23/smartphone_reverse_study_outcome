package tw0;

import com.bytedance.android.live.recharge.order.Order;
import com.bytedance.android.live.recharge.order.aio.OrderResultCode;
import com.bytedance.android.live.recharge.platform.service.PayService;
import io.reactivex.functions.Consumer;
import io.reactivex.subjects.ReplaySubject;
import io.reactivex.subjects.Subject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class f<T> implements Consumer {
    public final /* synthetic */ Order a;
    public final /* synthetic */ b b;
    public final /* synthetic */ Order c;
    public final /* synthetic */ Subject d;

    public f(Order r1, b r2, Order r3, ReplaySubject r4) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
    }

    public final void accept(Object r4) {
        Order.State r5 = (Order.State) r4;
        int r6 = c.a[((Order.State) this.c.getState().b).ordinal()];
        if (r6 != 1) goto L5;
        this.b.getClass();
        h r7 = new h();
        r7.e(OrderResultCode.Success);
    L18:
        jy0.b.d("AioRechargeOrderService", "dispatch final result code " + r7.a());
        this.d.onNext(r7);
        this.d.onComplete();
        return;
    L5:
        if (r6 != 2) goto L7;
        b r8 = this.b;
        Object r0 = this.c.getResult();
        if (r0 != null) goto L13;
        r8.getClass();
        r7 = b.V1(-1, "order failed with null result");
        goto L18
    L13:
        r8.getClass();
        if ((r0 instanceof PayService.b) == false) goto L16;
        PayService.b r1 = (PayService.b) r0;
        r7 = b.V1(r1.a, r1.b);
        goto L18
    L16:
        r7 = b.V1(-1, "order failed with result " + r0);
        goto L18
    L7:
        if (r6 == 3) goto L9;
        b r9 = this.b;
        String r2 = "unknown order state " + this.c.getState();
        r9.getClass();
        r7 = b.V1(-1, r2);
        goto L18
    L9:
        this.b.getClass();
        r7 = new h();
        r7.e(OrderResultCode.Cancelled);
        goto L18
    }
}
