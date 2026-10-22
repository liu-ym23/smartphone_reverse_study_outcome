package com.bytedance.android.live.broadcast.api;

import c00.a;
import com.bytedance.android.live.broadcast.api.model.CategoryNode;
import com.bytedance.android.live.broadcast.api.model.Game;
import com.bytedance.android.live.broadcast.api.model.PreBlockInfoResponse;
import com.bytedance.android.live.broadcast.api.model.RoomCreateInfo;
import com.bytedance.android.live.broadcast.api.model.h;
import com.bytedance.android.live.broadcast.api.model.h1;
import com.bytedance.android.live.broadcast.api.model.t0;
import com.bytedance.android.live.core.monitor.NewBroadcastMonitor;
import com.bytedance.android.live.network.annotation.PbRequest;
import com.bytedance.android.live.network.response.ListResponse;
import com.bytedance.android.live.network.response.Response;
import com.bytedance.android.live.network.response.e;
import com.bytedance.android.livesdk.chatroom.model.g3;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.depend.model.live.ShouldAddCoverResult;
import com.bytedance.retrofit2.http.Field;
import com.bytedance.retrofit2.http.FormUrlEncoded;
import com.bytedance.retrofit2.http.GET;
import com.bytedance.retrofit2.http.POST;
import com.bytedance.retrofit2.http.Query;
import com.bytedance.retrofit2.http.QueryMap;
import io.reactivex.Observable;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public interface BroadcastRoomApi {
    @GET("/webcast/room/create_check/")
    Observable<String> checkPermission(@QueryMap Map<String, String> r1);

    @GET("/webcast/gamelive/category/review/")
    Observable<e<h1>> checkSensitiveWords(@Query("text") String r1);

    @GET("/webcast/room/get_all_category/")
    Observable<Response<List<CategoryNode>>> getAllCategory(@Query("platform") int r1);

    @GET("/webcast/room/pre_block_info/")
    Observable<e<PreBlockInfoResponse>> getBlockInfo(@Query("quick_live_source") String r1, @Query("quick_live_biz_params") String r2);

    @POST("/webcast/room/get_latest_room/")
    Observable<Response<Room>> getLatestRoom();

    @GET("/webcast/room/game_list/")
    Observable<ListResponse<Game>> getLiveGameList(@Query("game_icon") int r1);

    @GET("/webcast/room/get_obs_audit_status/")
    Observable<Response<t0>> getObsAuditStatusInfo();

    @GET("/webcast/anchor/permission/status/")
    Observable<Response<h>> getPCLivePermissionStatus(@Query("permission_name") String r1, @Query("need_apply_detail") Boolean r2);

    @PbRequest(NewBroadcastMonitor.PAGE.ROOM)
    @GET("/webcast/room/create_info/")
    Observable<Response<RoomCreateInfo>> getPreviewRoomCreateInfo(@Query("platform") int r1);

    @GET("/webcast/room/tag_list/")
    Observable<ListResponse<g3>> getRoomTags();

    @FormUrlEncoded
    @POST("/webcast/room/modify_category/")
    Observable<Response<CategoryNode>> modifyCategory(@Field("platform") long r1, @Field("room_id") long r3, @Field("old_category_id") long r5, @Field("new_category_id") long r7);

    @FormUrlEncoded
    @POST("/webcast/room/reach_report")
    Observable<e> sendReachReport(@Field("scene") String r1, @Field("id") String r2, @Field("reach_data") String r3);

    @GET("/webcast/anchor/cover/neednotice/")
    Observable<Response<ShouldAddCoverResult>> shouldShowCoverNotice();

    @FormUrlEncoded
    @POST("/webcast/room/certificate/skip/")
    Observable<Response> skipVerify(@Field("certificate_key") String r1);

    @FormUrlEncoded
    @POST("/webcast/room/update_room_challenge/")
    Observable<Response<a>> updateRoomHashTag(@Field("room_id") long r1, @Field("old_challenge_id") long r3, @Field("new_challenge_id") long r5, @Field("new_challenge_name") String r7);

    @FormUrlEncoded
    @POST("/webcast/room/verify_result/upload")
    Observable<e> verifyResultUpload(@Field("scene") String r1, @Field("verify_result") int r2, @Field("failed_reason") String r3, @Field("unique_id") String r4);
}
