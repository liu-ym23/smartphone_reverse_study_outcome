package z00;

import com.bytedance.android.live.base.model.user.CoverImageModel;
import com.bytedance.android.live.broadcast.LiveBroadcastBaseClientCopy;
import com.bytedance.android.live.broadcast.api.UpdateRoomInfoApi;
import com.bytedance.android.live.broadcast.api.gamepromote.GamePromoteDataContext;
import com.bytedance.android.live.core.monitor.BaseMonitor;
import com.bytedance.android.live.core.monitor.LiveSlardarConstants;
import com.bytedance.android.live.core.monitor.LiveSlardarMonitor;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import com.bytedance.android.live.network.response.BaseResponse;
import com.bytedance.android.live.network.response.Response;
import com.bytedance.android.livesdk.log.u;
import io.reactivex.SingleObserver;
import io.reactivex.disposables.Disposable;
import kotlin.Lazy;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class i implements SingleObserver<Response<CoverImageModel>> {
    public final /* synthetic */ String a;
    public final /* synthetic */ k b;

    public final void onError(Throwable r4) {
        this.b.n(r4);
        JSONObject r0 = new JSONObject();
        BaseMonitor.add(r0, LiveSlardarConstants.EXTRA_KEY_ERROR_CODE, GamePromoteDataContext.GAME_TYPE_MOBILE);
        BaseMonitor.add(r0, LiveSlardarConstants.EXTRA_KEY_ERROR_MSG, r4.toString());
        LiveSlardarMonitor.monitorStatus("ttlive_upload_cover_all", 1, r0);
        LiveSlardarMonitor.monitorStatus("ttlive_upload_cover_error", 1, r0);
    }

    public final void onSubscribe(Disposable r2) {
        this.b.e.add(r2);
    }

    public final void onSuccess(Object r12) {
        Response r13 = (Response) r12;
        ((CoverImageModel) ((BaseResponse) r13).data).setPath(this.a);
        k r0 = this.b;
        CoverImageModel r14 = (CoverImageModel) ((BaseResponse) r13).data;
        r0.getClass();
        u.l().sendLog("livesdk_upload_cover_success", r0.m(), new Object[0]);
        r0.d.e();
        f2.c(r0.c.getString(2131919808), 0);
        Lazy r1 = LiveBroadcastBaseClientCopy.a;
        ((UpdateRoomInfoApi) LiveBroadcastBaseClientCopy.a(UpdateRoomInfoApi.class)).updateRoomInfo(r0.a, r14.getUri(), 0, 0, 0).compose(RxUtil.rxSchedulerHelper()).subscribe(new j(r0));
        LiveSlardarMonitor.monitorStatus("ttlive_upload_cover_all", 0, null);
    }

    public i(k r1, String r2) {
        this.b = r1;
        this.a = r2;
    }
}
