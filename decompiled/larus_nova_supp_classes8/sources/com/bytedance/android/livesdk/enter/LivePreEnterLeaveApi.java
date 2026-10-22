package com.bytedance.android.livesdk.enter;

import com.bytedance.android.live.network.annotation.PbRequest;
import com.bytedance.android.live.network.response.Response;
import com.bytedance.retrofit2.http.Field;
import com.bytedance.retrofit2.http.FieldMap;
import com.bytedance.retrofit2.http.FormUrlEncoded;
import com.bytedance.retrofit2.http.POST;
import io.reactivex.Observable;
import java.util.HashMap;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\bf\u0018\u00002\u00020\u0001JT\u0010\u0002\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00010\u00040\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u00062\b\b\u0001\u0010\u0007\u001a\u00020\u00062\b\b\u0001\u0010\b\u001a\u00020\u00062\b\b\u0001\u0010\t\u001a\u00020\u00062\u0016\b\u0001\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\f\u0018\u00010\u000bH'ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\rÀ\u0006\u0001"}, d2 = {"Lcom/bytedance/android/livesdk/enter/LivePreEnterLeaveApi;", "", "preEnterRoom", "Lio/reactivex/Observable;", "Lcom/bytedance/android/live/network/response/Response;", "roomId", "", "holdLivingRoom", "isLogin", "enterFromUidByShared", "map", "Ljava/util/HashMap;", "", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface LivePreEnterLeaveApi {
    @FormUrlEncoded
    @PbRequest("room")
    @POST("/webcast/room/pre_enter/")
    Observable<Response<Object>> preEnterRoom(@Field("room_id") long r1, @Field("hold_living_room") long r3, @Field("is_login") long r5, @Field("enter_from_uid_by_shared") long r7, @FieldMap HashMap<String, String> r9);
}
