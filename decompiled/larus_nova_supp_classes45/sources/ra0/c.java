package ra0;

import com.bytedance.tools.kcp.aio.runtime.BindsRpc;
import com.bytedance.tools.kcp.aio.runtime.BindsService;
import io.reactivex.Observable;
import io.reactivex.Single;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@BindsService(serviceFullName = "webcast.revenue.biz.incentive.exchange.IncentiveExchangeService")
public interface c extends uh7.a {
    @BindsRpc(rpcName = "ObserveExchangeInfo")
    Observable<b> observeExchangeInfo();

    @BindsRpc(rpcName = "UpdateExchangeInfo")
    Single<b> updateExchangeInfo(f r1);
}
