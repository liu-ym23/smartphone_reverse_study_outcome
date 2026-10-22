package com.bytedance.android.livesdk.feed.dislike;

import com.bytedance.android.live.base.model.live.DislikeResult;
import com.bytedance.android.live.network.response.Response;
import com.bytedance.retrofit2.http.Field;
import com.bytedance.retrofit2.http.FormUrlEncoded;
import com.bytedance.retrofit2.http.GET;
import com.bytedance.retrofit2.http.POST;
import com.bytedance.retrofit2.http.Query;
import io.reactivex.Observable;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public interface DislikeApi {
    @GET("/webcast/room/dislike/")
    Observable<Response<DislikeResult>> dislikeRoom(@Query("id") long r1, @Query("owner_uid") String r3, @Query("request_id") String r4, @Query("enter_source") String r5, @Query("source") String r6, @Query("log_pb") String r7);

    @GET("/webcast/room/dislike/")
    Observable<Response<DislikeResult>> dislikeRoomForDouyin(@Query("room_id") long r1, @Query("owner_uid") String r3, @Query("request_id") String r4, @Query("source") String r5, @Query("enter_from_merge") String r6, @Query("enter_method") String r7);

    @FormUrlEncoded
    @POST("/webcast/openapi/room/dislike/")
    Observable<Response<DislikeResult>> dislikeRoomSaasLegacy(@Field("id") long r1, @Field("owner_uid") String r3, @Field("owner_open_id") String r4, @Field("request_id") String r5, @Field("enter_source") String r6, @Field("source") String r7, @Field("log_pb") String r8);

    @FormUrlEncoded
    @POST("/webcast/openapi/room/dislike/")
    Observable<Response<DislikeResult>> dislikeRoomSaasLegacy(@Field("room_id") long r1, @Field("owner_uid") String r3, @Field("owner_open_id") String r4, @Field("request_id") String r5, @Field("source") String r6, @Field("enter_from_merge") String r7, @Field("enter_method") String r8, @Field("position_type") int r9);
}
