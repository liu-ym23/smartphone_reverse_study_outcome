package ty0;

import com.bytedance.tools.kcp.aio.runtime.BindsRpc;
import com.bytedance.tools.kcp.aio.runtime.BindsService;
import com.bytedance.tools.kcp.aio.runtime.RpcParam;
import io.reactivex.Observable;
import io.reactivex.Single;
import kotlin.Unit;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@BindsService(serviceFullName = "webcast.revenue.biz.demo.DemoService")
public interface d extends uh7.a {
    @BindsRpc(rpcName = "Hello")
    c hello(@RpcParam(paramName = "my_name") String r1);

    @BindsRpc(rpcName = "HelloStream")
    Observable<c> helloStream(@RpcParam(paramName = "my_name") String r1);

    @BindsRpc(rpcName = "HelloStreamActiveClose")
    Observable<c> helloStreamActiveClose();

    @BindsRpc(rpcName = "HelloStreamPassiveClose")
    Observable<c> helloStreamPassiveClose();

    @BindsRpc(rpcName = "HelloThrowBizError")
    void helloThrowBizError();

    @BindsRpc(rpcName = "HelloThrowInternalError")
    Single<Unit> helloThrowInternalError();

    @BindsRpc(rpcName = "NativeTriggerBizError")
    Single<Unit> nativeTriggerBizError();

    @BindsRpc(rpcName = "NativeTriggerHello")
    Single<Unit> nativeTriggerHello();

    @BindsRpc(rpcName = "NativeTriggerHelloStream")
    Single<Unit> nativeTriggerHelloStream();

    @BindsRpc(rpcName = "NativeTriggerNoSuchMethod")
    Single<Unit> nativeTriggerNoSuchMethod();

    @BindsRpc(rpcName = "NativeTriggerNoSuchService")
    Single<Unit> nativeTriggerNoSuchService();

    @BindsRpc(rpcName = "NativeTriggerStreamActiveClose")
    Single<Unit> nativeTriggerStreamActiveClose(@RpcParam(paramName = "my_name") String r1);

    @BindsRpc(rpcName = "NativeTriggerStreamPassiveClose")
    Single<Unit> nativeTriggerStreamPassiveClose(@RpcParam(paramName = "my_name") String r1);
}
