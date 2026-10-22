package l01;

import com.bytedance.tools.kcp.aio.runtime.BindsRpc;
import com.bytedance.tools.kcp.aio.runtime.BindsService;
import io.reactivex.Observable;
import io.reactivex.Single;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@BindsService(serviceFullName = "webcast.revenue.biz.user.UserService")
public interface c extends uh7.a {
    @BindsRpc(rpcName = "GetCurrentUser")
    Single<b> getCurrentUserSingle();

    @BindsRpc(rpcName = "ObserveCurrentUserInfo")
    Observable<a> observeCurrentUserInfo();
}
