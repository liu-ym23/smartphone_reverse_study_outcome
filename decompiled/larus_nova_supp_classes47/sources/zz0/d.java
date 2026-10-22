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
public interface d extends b, f80.a, uh7.a {
    i T3(@RpcParam(paramName = "schema") String r1);

    @Override // zz0.b
    @BindsRpc(rpcName = "CloseSelf")
    /* synthetic */ Single<Unit> closeSelfAsync(i57.a r1);

    @Override // zz0.b
    @BindsRpc(rpcName = "OpenSchema")
    /* synthetic */ Single<i> handleSchemeAsync(i57.a r1, @RpcParam(paramName = "schema") String r2);

    @Override // zz0.b
    @BindsRpc(rpcName = "ObserveUIHandleStatus")
    /* synthetic */ Observable<UIHandleStatus> observeUIHandleStatus(j r1);

    @Override // zz0.b
    @BindsRpc(rpcName = "OpenHybridDialog")
    /* synthetic */ Single<j> openHybridDialogAsync(i57.a r1, @RpcParam(paramName = "schema") String r2, @RpcParam(paramName = "config") a r3);
}
