package ty0;

import com.bytedance.tools.kcp.aio.runtime.BindsRpc;
import com.bytedance.tools.kcp.aio.runtime.BindsService;
import com.bytedance.tools.kcp.aio.runtime.RpcParam;
import io.reactivex.Observable;
import io.reactivex.Single;
import kotlin.Unit;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@BindsService(serviceFullName = "webcast.revenue.biz.demo.DynamicDemoService")
public interface e extends uh7.a {
    @BindsRpc(rpcName = "DynamicHello")
    Single<b> dynamicHello(@RpcParam(paramName = "my_name") String r1);

    @BindsRpc(rpcName = "DynamicHelloStream")
    Observable<b> dynamicHelloStream(@RpcParam(paramName = "my_name") String r1);

    @BindsRpc(rpcName = "DynamicHelloStreamActiveClose")
    Observable<b> dynamicHelloStreamActiveClose();

    @BindsRpc(rpcName = "DynamicHelloStreamPassiveClose")
    Observable<b> dynamicHelloStreamPassiveClose();

    @BindsRpc(rpcName = "DynamicHelloThrowBizError")
    Single<Unit> dynamicHelloThrowBizError();
}
