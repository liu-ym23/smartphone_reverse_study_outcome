package b01;

import com.bytedance.tools.kcp.aio.runtime.BindsRpc;
import com.bytedance.tools.kcp.aio.runtime.BindsService;
import com.bytedance.tools.kcp.aio.runtime.RpcParam;
import io.reactivex.Single;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@BindsService(serviceFullName = "webcast.revenue.biz.foundation.SettingService")
public interface d extends uh7.a {
    @BindsRpc(rpcName = "getClientSetting")
    Single<c> getClientSettingAsync(@RpcParam(paramName = "type") int r1, @RpcParam(paramName = "key") String r2);

    @BindsRpc(rpcName = "getClientSettingList")
    Single<a> getClientSettingList(@RpcParam(paramName = "params") List<? extends b> r1);
}
