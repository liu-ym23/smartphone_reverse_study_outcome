package pu0;

import com.bytedance.tools.kcp.aio.runtime.BindsRpc;
import com.bytedance.tools.kcp.aio.runtime.RpcParam;
import io.reactivex.Observable;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public interface g {
    @BindsRpc(rpcName = "ObserveGiftEffectEvent")
    Observable<a> observeGiftEffectEvent(@RpcParam(paramName = "gift_ids") List<Long> r1);

    @BindsRpc(rpcName = "ObserveGiftTrayEvent")
    Observable<b> observeGiftTrayEvent(@RpcParam(paramName = "gift_ids") List<Long> r1);

    @BindsRpc(rpcName = "ObserveLinkRegion")
    Observable<c> observeLinkRegion();

    @BindsRpc(rpcName = "ObservePetRegion")
    Observable<i> observePetRegion();
}
