package com.bytedance.android.live.recharge;

import android.content.Context;
import com.bytedance.tools.kcp.aio.runtime.BindsRpc;
import com.bytedance.tools.kcp.aio.runtime.BindsService;
import io.reactivex.Observable;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@BindsService(serviceFullName = "webcast.revenue.biz.recharge.RechargeService")
public interface i extends uh7.a, com.bytedance.android.scope.o {
    long getAvailableDiamonds();

    String getCoinCurrency();

    py.l getCoinImage();

    Observable<Long> observeAvailableDiamonds(boolean r1, String r2);

    void openRechargeDialog(Context r1, q0 r2);

    @BindsRpc(rpcName = "openRechargeDialog")
    void openRechargeDialog(i57.a r1, m r2);

    void refreshAvailableDiamonds(String r1);
}
