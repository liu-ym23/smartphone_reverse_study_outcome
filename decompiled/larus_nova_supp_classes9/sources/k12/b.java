package k12;

import com.bytedance.tools.kcp.aio.runtime.BindsRpc;
import com.bytedance.tools.kcp.aio.runtime.BindsService;
import com.bytedance.tools.kcp.aio.runtime.RpcParam;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@BindsService(serviceFullName = "webcast.revenue.biz.effect.EffectTrackService")
public interface b extends uh7.a {
    @BindsRpc(rpcName = "TrackPlayInfoForSlardar")
    void trackPlayInfoForSlardar(@RpcParam(paramName = "slardar_key") String r1, @RpcParam(paramName = "slardar_info") String r2);
}
