package tw0;

import com.bytedance.tools.kcp.aio.runtime.BindsRpc;
import com.bytedance.tools.kcp.aio.runtime.BindsService;
import io.reactivex.Observable;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@BindsService(serviceFullName = "webcast.revenue.biz.recharge.order.RechargeOrderService")
public interface a extends uh7.a {
    @BindsRpc(rpcName = "BuyDiamond")
    Observable<h> buyDiamond(g r1);

    @BindsRpc(rpcName = "PreOrder")
    void preOrder(g r1);
}
