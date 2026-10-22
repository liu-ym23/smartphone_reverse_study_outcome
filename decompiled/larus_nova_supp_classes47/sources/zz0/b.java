package zz0;

import com.bytedance.android.live.revenue.platform.schema.api.UIHandleStatus;
import com.bytedance.tools.kcp.aio.runtime.BindsRpc;
import com.bytedance.tools.kcp.aio.runtime.BindsService;
import com.bytedance.tools.kcp.aio.runtime.RpcParam;
import io.reactivex.Observable;
import io.reactivex.Single;
import kotlin.Unit;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@BindsService(serviceFullName = "webcast.revenue.biz.foundation.RouterService")
public interface b extends f80.a, dy0.c, uh7.a {
    @BindsRpc(rpcName = "CloseSelf")
    Single<Unit> closeSelfAsync(i57.a r1);

    @BindsRpc(rpcName = "OpenSchema")
    Single<i> handleSchemeAsync(i57.a r1, @RpcParam(paramName = "schema") String r2);

    @BindsRpc(rpcName = "ObserveUIHandleStatus")
    Observable<UIHandleStatus> observeUIHandleStatus(j r1);

    @BindsRpc(rpcName = "OpenHybridDialog")
    Single<j> openHybridDialogAsync(i57.a r1, @RpcParam(paramName = "schema") String r2, @RpcParam(paramName = "config") a r3);
}
