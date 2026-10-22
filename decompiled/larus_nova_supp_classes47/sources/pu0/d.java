package pu0;

import com.bytedance.android.livesdk.message.model.cb;
import com.bytedance.tools.kcp.aio.runtime.BindsRpc;
import com.bytedance.tools.kcp.aio.runtime.BindsService;
import com.bytedance.tools.kcp.aio.runtime.RpcParam;
import io.reactivex.Observable;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@BindsService(serviceFullName = "webcast.revenue.biz.live_pet.LivePetService")
public interface d extends uh7.a {
    @BindsRpc(rpcName = "ObserveGiftEffectEvent")
    Observable<a> observeGiftEffectEvent(@RpcParam(paramName = "gift_ids") List<Long> r1);

    @BindsRpc(rpcName = "ObserveGiftTrayEvent")
    Observable<b> observeGiftTrayEvent(@RpcParam(paramName = "gift_ids") List<Long> r1);

    @BindsRpc(rpcName = "ObserveLinkRegion")
    Observable<c> observeLinkRegion();

    @BindsRpc(rpcName = "ObservePetEffectInfo")
    Observable<cb> observePetEffectInfo();

    @BindsRpc(rpcName = "ObservePetRegion")
    Observable<i> observePetRegion();

    @BindsRpc(rpcName = "UnloadPet")
    void unloadPet();
}
