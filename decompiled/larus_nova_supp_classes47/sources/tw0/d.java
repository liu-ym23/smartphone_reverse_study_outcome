package tw0;

import com.bytedance.android.live.recharge.order.Order;
import com.bytedance.android.live.recharge.order.aio.OrderResultCode;
import io.reactivex.subjects.ReplaySubject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class d<T1, T2> implements ttc.a {
    public final /* synthetic */ b a;
    public final /* synthetic */ ReplaySubject b;
    public final /* synthetic */ com.bytedance.android.live.recharge.panel.context.c c;

    public d(b r1, ReplaySubject r2, com.bytedance.android.live.recharge.panel.context.c r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    public final void accept(Object r5, Object r6) {
        Order r7 = (Order) r5;
        Throwable r8 = (Throwable) r6;
        if (r8 == null) goto L5;
        this.b.onError(r8);
        return;
    L5:
        b r9 = this.a;
        ReplaySubject r0 = this.b;
        r9.getClass();
        StringBuilder r1 = new StringBuilder("dispatch intermediate result code ");
        OrderResultCode r2 = OrderResultCode.Submitted;
        r1.append(r2);
        jy0.b.d("AioRechargeOrderService", r1.toString());
        h r3 = new h();
        r3.e(r2);
        r0.onNext(r3);
        com.bytedance.android.live.revenue.common.reactive.j.a(r7.getState(), true).filter(com.bytedance.android.live.recharge.order.d.a).take(1).subscribe(new f(r7, r9, r7, r0));
        com.bytedance.android.live.recharge.panel.context.c r10 = this.c;
        if (r10 == null) goto L12;
        com.bytedance.android.live.revenue.common.reactive.b<Order> r12 = r10.f();
        if (r12 == null) goto L13;
        r12.setValue(r7);
        return;
    L13:
        return;
    }
}
