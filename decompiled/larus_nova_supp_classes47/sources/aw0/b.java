package aw0;

import com.bytedance.tools.kcp.aio.runtime.BindsRpc;
import com.bytedance.tools.kcp.aio.runtime.BindsService;
import io.reactivex.Observable;
import io.reactivex.Single;
import vw0.g;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@BindsService(serviceFullName = "webcast.revenue.biz.recharge.wallet.RechargeWalletService")
public interface b extends uh7.a {
    @BindsRpc(rpcName = "GetRechargeCommonParams")
    g getRechargeCommonParams();

    @BindsRpc(rpcName = "ObserveBalanceInfo")
    Observable<a> observeBalanceInfo();

    @BindsRpc(rpcName = "UpdateBalanceInfo")
    Single<a> updateBalanceInfo(d r1);
}
