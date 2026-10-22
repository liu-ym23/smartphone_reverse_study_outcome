package k11;

import com.bytedance.tools.kcp.aio.runtime.BindsRpc;
import com.bytedance.tools.kcp.aio.runtime.BindsService;
import com.bytedance.tools.kcp.aio.runtime.RpcParam;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@BindsService(serviceFullName = "webcast.revenue.biz.revlink.RevlinkExtraService")
public interface h extends uh7.a {
    @BindsRpc(rpcName = "DismissNativePanel")
    void dismissNativePanel(@RpcParam(paramName = "panel_type") int r1);

    @BindsRpc(rpcName = "OpenPanel")
    void openPanel(@RpcParam(paramName = "panel_type") int r1);

    @BindsRpc(rpcName = "ShowTipsOnPkIcon")
    void showTipsOnPkIcon(@RpcParam(paramName = "tip_string") String r1);
}
