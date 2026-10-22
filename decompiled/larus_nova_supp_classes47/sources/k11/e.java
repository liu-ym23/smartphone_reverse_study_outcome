package k11;

import com.bytedance.tools.kcp.aio.runtime.BindsRpc;
import com.bytedance.tools.kcp.aio.runtime.BindsService;
import com.bytedance.tools.kcp.aio.runtime.RpcParam;
import io.reactivex.Observable;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@BindsService(serviceFullName = "webcast.revenue.biz.revlink.CreateLinkService")
public interface e extends uh7.a {
    @BindsRpc(rpcName = "Apply")
    void apply(@RpcParam(paramName = "server_extra_params") Map<String, String> r1, @RpcParam(paramName = "request_params") d11.h r2, @RpcParam(paramName = "client_params") Map<String, String> r3);

    @BindsRpc(rpcName = "Cancel")
    void cancel(@RpcParam(paramName = "server_extra_params") Map<String, String> r1, @RpcParam(paramName = "request_params") d11.i r2, @RpcParam(paramName = "client_params") Map<String, String> r3);

    @BindsRpc(rpcName = "Invite")
    void invite(@RpcParam(paramName = "server_extra_params") Map<String, String> r1, @RpcParam(paramName = "request_params") d11.j r2, @RpcParam(paramName = "client_params") Map<String, String> r3);

    @BindsRpc(rpcName = "ObserveApplyMessage")
    Observable<j> observeApplyLinkMessage();

    @BindsRpc(rpcName = "ObserveApplyResult")
    Observable<a> observeApplyResult();

    @BindsRpc(rpcName = "ObserveCancelMessage")
    Observable<j> observeCancelLinkMessage();

    @BindsRpc(rpcName = "ObserveCancelResult")
    Observable<b> observeCancelResult();

    @BindsRpc(rpcName = "ObserveInviteMessage")
    Observable<j> observeInviteLinkMessage();

    @BindsRpc(rpcName = "ObserveInviteResult")
    Observable<i> observeInviteResult();

    @BindsRpc(rpcName = "ObservePermitMessage")
    Observable<j> observePermitLinkMessage();

    @BindsRpc(rpcName = "ObservePermitResult")
    Observable<l> observePermitResult();

    @BindsRpc(rpcName = "ObserveReplyMessage")
    Observable<j> observeReplyLinkMessage();

    @BindsRpc(rpcName = "ObserveReplyResult")
    Observable<m> observeReplyResult();

    @BindsRpc(rpcName = "Permit")
    void permit(@RpcParam(paramName = "server_extra_params") Map<String, String> r1, @RpcParam(paramName = "request_params") d11.k r2, @RpcParam(paramName = "client_params") Map<String, String> r3);

    @BindsRpc(rpcName = "Reply")
    void reply(@RpcParam(paramName = "server_extra_params") Map<String, String> r1, @RpcParam(paramName = "request_params") d11.l r2, @RpcParam(paramName = "client_params") Map<String, String> r3);
}
