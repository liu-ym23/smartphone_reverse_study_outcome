package sy0;

import com.bytedance.tools.kcp.aio.runtime.BindsRpc;
import com.bytedance.tools.kcp.aio.runtime.BindsService;
import com.bytedance.tools.kcp.aio.runtime.RpcParam;
import io.reactivex.Single;
import zy0.d;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@BindsService(serviceFullName = "webcast.revenue.biz.rank.RankRouter")
public interface a extends uh7.a {
    @BindsRpc(rpcName = "OpenAudienceListOpt")
    Single<d> openAudienceListOpt(i57.a r1, @RpcParam(paramName = "enableStraigtOut") boolean r2, @RpcParam(paramName = "enableSkeleton") boolean r3, @RpcParam(paramName = "audienceListOptEnable") boolean r4, @RpcParam(paramName = "source") String r5, @RpcParam(paramName = "is_openlive_lite") boolean r6, @RpcParam(paramName = "scene") String r7, @RpcParam(paramName = "audienceCount") int r8, @RpcParam(paramName = "sec_anchor_id") String r9, @RpcParam(paramName = "anchor_id") String r10, @RpcParam(paramName = "sec_user_id") String r12, @RpcParam(paramName = "room_id") String r13, @RpcParam(paramName = "enter_from") String r14, @RpcParam(paramName = "ktvRankTab") int r15, @RpcParam(paramName = "avatarFormat") String r16, @RpcParam(paramName = "player_rank_forbidden_code") String r17);

    @BindsRpc(rpcName = "OpenHonorRankOpt")
    void openHonorRankOpt(@RpcParam(paramName = "room_id") String r1, @RpcParam(paramName = "honor_rank_type") long r2, @RpcParam(paramName = "honor_index") long r4, @RpcParam(paramName = "is_openlive_lite") String r6, @RpcParam(paramName = "page_from") String r7);
}
