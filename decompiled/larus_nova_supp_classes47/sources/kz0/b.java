package kz0;

import com.bytedance.tools.kcp.aio.runtime.BindsRpc;
import com.bytedance.tools.kcp.aio.runtime.BindsService;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@BindsService(serviceFullName = "webcast.revenue.biz.foundation.LinkMicStateService")
public interface b extends uh7.a {
    @BindsRpc(rpcName = "GetCurrentLinkMicState")
    a getCurrentLinkMicState();
}
