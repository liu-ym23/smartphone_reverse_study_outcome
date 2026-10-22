package e01;

import com.bytedance.tools.kcp.aio.runtime.BindsRpc;
import com.bytedance.tools.kcp.aio.runtime.BindsService;
import io.reactivex.Single;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@BindsService(serviceFullName = "webcast.revenue.biz.live_stream.SeiWriterService")
public interface i extends uh7.a {
    @BindsRpc(rpcName = "ClearSeiField")
    Single<d> clearSeiField(c r1);

    @BindsRpc(rpcName = "SetSeiField")
    Single<k> setSeiField(j r1);
}
