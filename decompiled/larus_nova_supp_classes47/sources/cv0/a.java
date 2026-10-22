package cv0;

import com.bytedance.android.live.profit.redpacket.model.h;
import com.bytedance.tools.kcp.aio.runtime.BindsRpc;
import com.bytedance.tools.kcp.aio.runtime.BindsService;
import com.bytedance.tools.kcp.aio.runtime.RpcParam;
import io.reactivex.Observable;
import io.reactivex.Single;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@BindsService(serviceFullName = "webcast.revenue.biz.luckyBox.LuckyBoxClientService")
public interface a extends uh7.a {
    @BindsRpc(rpcName = "ActivateIconFirst")
    void activateIconFirst();

    @BindsRpc(rpcName = "AdjustToTempStateWidth")
    void adjustToTempStateWidth();

    @BindsRpc(rpcName = "CreateLuckyBoxShortTouchItem")
    void createLuckyBoxShortTouchItem(@RpcParam(paramName = "lucky_box_show_touch_init_data") String r1, @RpcParam(paramName = "is_show_entrance_animation") boolean r2, @RpcParam(paramName = "lucky_box_ani_veiw_init_data") String r3);

    @BindsRpc(rpcName = "GetTempStateDuration")
    Single<com.bytedance.android.live.profit.redpacket.model.a> getTempStateDuration(@RpcParam(paramName = "temp_status") int r1);

    @BindsRpc(rpcName = "ObserveLuckyBoxShortTouchTempState")
    Observable<h> observeLuckyBoxShortTouchTempState();

    @BindsRpc(rpcName = "RemoveLuckyBoxShortTouchItem")
    void removeLuckyBoxShortTouchItem();

    @BindsRpc(rpcName = "RequestShowTempState")
    void requestShowTempState(@RpcParam(paramName = "temp_status") int r1);

    @BindsRpc(rpcName = "ShowNormalState")
    void showNormalState();

    @BindsRpc(rpcName = "UpdateDiamondCountForTempState")
    void updateDiamondCountForTempState(@RpcParam(paramName = "diamond_count") long r1);
}
