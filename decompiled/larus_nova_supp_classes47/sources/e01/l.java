package e01;

import com.bytedance.tools.kcp.aio.runtime.BindsRpc;
import com.bytedance.tools.kcp.aio.runtime.BindsService;
import io.reactivex.Single;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@BindsService(serviceFullName = "webcast.revenue.biz.live_stream.StreamCaptureService")
public interface l extends uh7.a {
    @BindsRpc(rpcName = "CaptureVideoFrame")
    Single<b> captureVideoFrame(a r1);
}
