package com.bytedance.android.live.recharge.nopassword;

import com.bytedance.tools.kcp.aio.runtime.BindsRpc;
import com.bytedance.tools.kcp.aio.runtime.BindsService;
import com.bytedance.tools.kcp.aio.runtime.RpcParam;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@BindsService(serviceFullName = "webcast.revenue.biz.recharge.nopassword.NoPasswordService")
public interface a extends uh7.a {
    @BindsRpc(rpcName = "ObserveSignInfo")
    com.bytedance.revenue.platform.api.core.rx.a<com.bytedance.android.live.recharge.platform.model.f> observeSignInfo();

    @BindsRpc(rpcName = "RequestSignInfo")
    void requestSignInfo(@RpcParam(paramName = "amount") Long r1);
}
