package e02;

import com.bytedance.tools.kcp.aio.runtime.BindsRpc;
import com.bytedance.tools.kcp.aio.runtime.BindsService;
import io.reactivex.Observable;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@BindsService(serviceFullName = "webcast.revenue.biz.effect.EffectDataService")
public interface a extends uh7.a {
    @BindsRpc(rpcName = "ObserveEffectMessage")
    Observable<d02.a> observeEffectMessage();
}
