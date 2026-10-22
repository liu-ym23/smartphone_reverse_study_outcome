package k11;

import com.bytedance.android.livesdk.link.model.IBattlePrecisionMatcher;
import com.bytedance.android.livesdk.link.model.h0;
import com.bytedance.tools.kcp.aio.runtime.BindsRpc;
import com.bytedance.tools.kcp.aio.runtime.BindsService;
import com.bytedance.tools.kcp.aio.runtime.RpcParam;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@BindsService(serviceFullName = "webcast.revenue.biz.revlink.AutoMatchService")
public interface d extends uh7.a {
    @BindsRpc(rpcName = "UpdateAutoMatchPredictWaitTime")
    void updateAutoMatchPredictWaitTime(@RpcParam(paramName = "match_type") long r1, @RpcParam(paramName = "predict_wait_time") long r3, @RpcParam(paramName = "waited_time") long r5, @RpcParam(paramName = "preview_user") h0 r7);

    @BindsRpc(rpcName = "UpdateAutoMatchState")
    void updateAutoMatchState(@RpcParam(paramName = "match_type") long r1, @RpcParam(paramName = "event") int r3);

    @BindsRpc(rpcName = "UpdateMatchBell")
    void updateMatchBell(@RpcParam(paramName = "match_type") long r1, @RpcParam(paramName = "precision_match_id_str") String r3, @RpcParam(paramName = "flex_activity_id") long r4, @RpcParam(paramName = "remain_time") long r6, @RpcParam(paramName = "source") int r8, @RpcParam(paramName = "ownerAnchor") IBattlePrecisionMatcher r9, @RpcParam(paramName = "oppositeAnchor") IBattlePrecisionMatcher r10);
}
