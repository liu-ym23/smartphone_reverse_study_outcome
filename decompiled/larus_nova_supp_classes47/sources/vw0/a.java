package vw0;

import com.bytedance.android.live.recharge.panel.aio.IPanelProperties;
import com.bytedance.tools.kcp.aio.runtime.BindsRpc;
import com.bytedance.tools.kcp.aio.runtime.BindsService;
import io.reactivex.Observable;
import io.reactivex.Single;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@BindsService(serviceFullName = "webcast.revenue.biz.recharge.panel.RechargePanelService")
public interface a extends uh7.a {
    @BindsRpc(rpcName = "EnsureRechargeAgreementAccepted")
    Single<IPanelProperties> ensureRechargeAgreementAccepted();

    @BindsRpc(rpcName = "ObservePanelProperties")
    Observable<IPanelProperties> observePanelProperties();

    @BindsRpc(rpcName = "UpdatePanelProperties")
    void updatePanelProperties(IPanelProperties r1);
}
