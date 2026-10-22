package e01;

import com.bytedance.tools.kcp.aio.runtime.BindsRpc;
import com.bytedance.tools.kcp.aio.runtime.BindsService;
import io.reactivex.Observable;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@BindsService(serviceFullName = "webcast.revenue.biz.live_stream.SeiReaderService")
public interface h extends uh7.a {
    @BindsRpc(rpcName = "ObserveSeiField")
    Observable<f> observeSeiField(e r1);
}
