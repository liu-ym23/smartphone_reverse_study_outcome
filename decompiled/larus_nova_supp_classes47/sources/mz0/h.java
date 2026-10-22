package mz0;

import com.bytedance.tools.kcp.aio.runtime.BindsRpc;
import com.bytedance.tools.kcp.aio.runtime.BindsService;
import com.bytedance.tools.kcp.aio.runtime.RpcParam;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@BindsService(serviceFullName = "webcast.revenue.biz.foundation.TeaLogService")
public interface h extends uh7.a, f80.a, dy0.c {
    @BindsRpc(rpcName = "SendLog")
    void sendLog(@RpcParam(paramName = "event_name") String r1, @RpcParam(paramName = "params") Map<String, String> r2);
}
