package com.bytedance.android.live.revenue.platform.container.impl.core;

import com.bytedance.tools.kcp.aio.runtime.BindsRpc;
import com.bytedance.tools.kcp.aio.runtime.BindsService;
import com.bytedance.tools.kcp.aio.runtime.RpcParam;
import io.reactivex.Single;
import kotlin.Unit;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@BindsService(serviceFullName = "core.service.DynamicHostService")
public interface i extends uh7.a {
    @BindsRpc(rpcName = "NotifyRoomState")
    Single<Unit> notifyRoomState(@RpcParam(paramName = "state") int r1);
}
