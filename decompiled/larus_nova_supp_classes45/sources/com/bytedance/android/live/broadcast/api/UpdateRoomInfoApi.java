package com.bytedance.android.live.broadcast.api;

import com.bytedance.android.live.broadcast.api.model.g1;
import com.bytedance.retrofit2.http.Field;
import com.bytedance.retrofit2.http.FormUrlEncoded;
import com.bytedance.retrofit2.http.POST;
import io.reactivex.Observable;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001JB\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\b\b\u0001\u0010\u0003\u001a\u00020\u00022\n\b\u0001\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\b\u0001\u0010\u0007\u001a\u00020\u00062\b\b\u0001\u0010\b\u001a\u00020\u00062\b\b\u0001\u0010\t\u001a\u00020\u0006H'J\"\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\b\b\u0001\u0010\u0003\u001a\u00020\u00022\b\b\u0001\u0010\r\u001a\u00020\u0002H'¨\u0006\u000e"}, d2 = {"Lcom/bytedance/android/live/broadcast/api/UpdateRoomInfoApi;", "", "", "roomId", "", "coverUri", "", "giftAuth", "chatAuth", "shareAuth", "Lio/reactivex/Observable;", "Lcom/bytedance/android/live/broadcast/api/model/g1;", "updateRoomInfo", "poiId", "livebroadcast-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface UpdateRoomInfoApi {
    @FormUrlEncoded
    @POST("/webcast/room/update_room_info/")
    Observable<g1> updateRoomInfo(@Field("room_id") long r1, @Field("poi_id") long r3);

    @FormUrlEncoded
    @POST("/webcast/room/update_room_info/")
    Observable<g1> updateRoomInfo(@Field("room_id") long r1, @Field("cover_uri") String r3, @Field("gift_auth") int r4, @Field("chat_auth") int r5, @Field("share_auth") int r6);
}
