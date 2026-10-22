package fx0;

import com.bytedance.android.live.recharge.order.Order;
import com.bytedance.android.live.recharge.platform.service.PayService;
import com.bytedance.android.live.revenue.common.q;
import com.bytedance.android.livesdk.event.v;
import com.bytedance.badger.collect.impl.constants.Constants;
import io.reactivex.functions.Consumer;
import kotlin.Pair;
import kotlin.TuplesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class g<T> implements Consumer {
    public final /* synthetic */ Order a;
    public final /* synthetic */ f b;
    public final /* synthetic */ com.bytedance.android.live.recharge.deal.f c;

    public g(Order r1, f r2, com.bytedance.android.live.recharge.deal.f r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    public final void accept(Object r8) {
        Order.State r9 = (Order.State) r8;
        Object r10 = this.a.getState();
        if ((r10 instanceof PayService.b) == true) goto L5;
        r10 = null;
    L5:
        PayService.b r12 = (PayService.b) r10;
        if (r12 == null) goto L9;
        this.b.finishWithResult(q.b(new Pair[]{TuplesKt.to(Constants.OperatorKey.CODE, 1), TuplesKt.to(Constants.Keys.DATA, q.b(new Pair[]{TuplesKt.to("pay_code", Integer.valueOf(r12.a)), TuplesKt.to("pay_msg", r12.b)}))}));
        xs2.b.a().post(new v(this.c.i(), this.c.h()));
        return;
    }
}
