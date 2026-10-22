package cv0;

import com.bytedance.android.scope.o;
import com.bytedance.tools.kcp.aio.runtime.BindsRpc;
import com.bytedance.tools.kcp.aio.runtime.BindsService;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@BindsService(serviceFullName = "webcast.revenue.biz.luckyBox.LuckyBoxRouterService")
public interface b extends uh7.a, o {
    @BindsRpc(rpcName = "OpenGrabLuckyBoxView")
    void openGrabLuckyBoxView();

    @BindsRpc(rpcName = "OpenSendLuckyBoxView")
    void openSendLuckyBoxView();
}
