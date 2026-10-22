package com.bytedance.android.live.recharge.et.aio;

import com.bytedance.tools.kcp.aio.runtime.BindsRpc;
import com.bytedance.tools.kcp.aio.runtime.BindsService;
import com.bytedance.tools.kcp.aio.runtime.RpcParam;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@BindsService(serviceFullName = "webcast.revenue.biz.recharge.et.RechargeEventTrackerService")
public interface a extends uh7.a {
    @BindsRpc(rpcName = "ReportEvent")
    void reportEvent(@RpcParam(paramName = "event_name") String r1, @RpcParam(paramName = "event_properties") Map<String, String> r2, @RpcParam(paramName = "event_context") List<? extends Object> r3);
}
