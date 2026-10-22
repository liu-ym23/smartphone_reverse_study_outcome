package com.bytedance.android.live.effect.api;

import com.bytedance.android.live.base.model.Extra;
import com.bytedance.android.live.network.response.BaseResponse;
import com.bytedance.retrofit2.http.POST;
import com.bytedance.retrofit2.http.Query;
import io.reactivex.Observable;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001JB\u0010\u0002\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u00040\u00032\b\b\u0001\u0010\u0007\u001a\u00020\b2\b\b\u0001\u0010\t\u001a\u00020\n2\b\b\u0001\u0010\u000b\u001a\u00020\n2\b\b\u0001\u0010\f\u001a\u00020\bH'JB\u0010\r\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u00060\u00040\u00032\b\b\u0001\u0010\u0007\u001a\u00020\b2\b\b\u0001\u0010\t\u001a\u00020\n2\b\b\u0001\u0010\u000b\u001a\u00020\n2\b\b\u0001\u0010\f\u001a\u00020\bH'¨\u0006\u000f"}, d2 = {"Lcom/bytedance/android/live/effect/api/LiveCommonInteractStickerApi;", "", "getInteractStickerInfo", "Lio/reactivex/Observable;", "Lcom/bytedance/android/live/network/response/BaseResponse;", "Lcom/bytedance/android/live/effect/api/GetInteractStickerInfoResponse;", "Lcom/bytedance/android/live/base/model/Extra;", "roomID", "", "anchorID", "", "rules", "effectID", "notifyInteractStickerInUse", "Lcom/bytedance/android/live/effect/api/NotifyInteractStickerInUseResponse;", "liveeffect-middleware-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface LiveCommonInteractStickerApi {
    @POST("/webcast/room/interact_effect/query/")
    Observable<BaseResponse<GetInteractStickerInfoResponse, Extra>> getInteractStickerInfo(@Query("room_id") long r1, @Query("anchor_id") String r3, @Query("rules") String r4, @Query("effect_id") long r5);

    @POST("/webcast/room/interact_effect/init/")
    Observable<BaseResponse<NotifyInteractStickerInUseResponse, Extra>> notifyInteractStickerInUse(@Query("room_id") long r1, @Query("anchor_id") String r3, @Query("rules") String r4, @Query("effect_id") long r5);
}
