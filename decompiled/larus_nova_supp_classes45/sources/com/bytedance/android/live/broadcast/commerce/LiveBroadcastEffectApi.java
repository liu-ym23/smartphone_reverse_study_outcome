package com.bytedance.android.live.broadcast.commerce;

import com.bytedance.android.live.network.response.Response;
import com.bytedance.retrofit2.http.Field;
import com.bytedance.retrofit2.http.FormUrlEncoded;
import com.bytedance.retrofit2.http.POST;
import io.reactivex.Observable;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public interface LiveBroadcastEffectApi {
    @FormUrlEncoded
    @POST("/webcast/room/internal_ci_info/")
    Observable<Response<Void>> uploadBeautyParams(@Field("room_id") long r1, @Field("filter_name") String r3, @Field("whitening") int r4, @Field("beauty_skin") int r5, @Field("big_eyes") int r6, @Field("face_lift") int r7, @Field("use_filter") boolean r8, @Field("commerce_use_filter") boolean r9);
}
