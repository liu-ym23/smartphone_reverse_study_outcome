package yz0;

import com.bytedance.tools.kcp.aio.runtime.BindsRpc;
import com.bytedance.tools.kcp.aio.runtime.BindsService;
import io.reactivex.Observable;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@BindsService(serviceFullName = "webcast.revenue.biz.room.GlobalRoomService")
public interface d extends uh7.a {
    @BindsRpc(rpcName = "ObserveCoreRoomInfo")
    Observable<a> observeCoreRoomInfo();
}
