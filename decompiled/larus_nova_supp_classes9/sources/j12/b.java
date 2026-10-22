package j12;

import com.bytedance.tools.kcp.aio.runtime.BindsRpc;
import com.bytedance.tools.kcp.aio.runtime.BindsService;
import com.bytedance.tools.kcp.aio.runtime.RpcParam;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@BindsService(serviceFullName = "webcast.revenue.biz.gift.dialog.tab.GiftTabActionUseCase")
public interface b extends uh7.a {
    @BindsRpc(rpcName = "ClickTab")
    void clickTab(@RpcParam(paramName = "tab_index") int r1, @RpcParam(paramName = "tab_type") int r2, @RpcParam(paramName = "log_extra") Map<String, String> r3, @RpcParam(paramName = "order_rule") int r4, @RpcParam(paramName = "related_topic_id") long r5);
}
