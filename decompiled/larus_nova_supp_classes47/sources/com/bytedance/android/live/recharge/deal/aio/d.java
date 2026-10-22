package com.bytedance.android.live.recharge.deal.aio;

import com.bytedance.tools.kcp.aio.runtime.BindsRpc;
import com.bytedance.tools.kcp.aio.runtime.BindsService;
import io.reactivex.Observable;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@BindsService(serviceFullName = "webcast.revenue.biz.recharge.deal.RechargeDealService")
public interface d extends uh7.a {
    @BindsRpc(rpcName = "CreateCustomDeal")
    Observable<b> createCustomDeal(f r1);
}
