package yz0;

import com.bytedance.tools.kcp.aio.runtime.BindsRpc;
import com.bytedance.tools.kcp.aio.runtime.BindsService;
import io.reactivex.Single;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@BindsService(serviceFullName = "webcast.revenue.biz.room.RoomService")
public interface e extends uh7.a {
    @BindsRpc(rpcName = "GetCurrentRoom")
    Single<b> getCurrentRoom();

    @BindsRpc(rpcName = "GetOrientation")
    Single<c> getOrientation();
}
