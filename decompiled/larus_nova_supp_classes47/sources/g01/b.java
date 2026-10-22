package g01;

import com.bytedance.tools.kcp.aio.runtime.BindsRpc;
import com.bytedance.tools.kcp.aio.runtime.BindsService;
import dy0.c;
import io.reactivex.Single;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@BindsService(serviceFullName = "webcast.revenue.biz.foundation.TimeService")
public interface b extends uh7.a, c, f80.a {
    @BindsRpc(rpcName = "GetServerTimestamp")
    Single<a> getServerTimestamp();
}
