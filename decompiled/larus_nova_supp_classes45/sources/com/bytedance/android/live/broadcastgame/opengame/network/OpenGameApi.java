package com.bytedance.android.live.broadcastgame.opengame.network;

import com.bytedance.android.live.broadcastgame.opengame.debug.OpenPlatformBaseDebugger;
import com.bytedance.android.live.broadcastgame.opengame.network.model.OpenPlatformRespExtra;
import com.bytedance.android.live.broadcastgame.opengame.network.model.PassOpenApiCheck;
import com.bytedance.android.live.network.response.BaseResponse;
import com.bytedance.android.live.network.response.ExtraResponse;
import com.bytedance.android.live.network.response.Response;
import com.bytedance.retrofit2.http.GET;
import com.bytedance.retrofit2.http.POST;
import com.bytedance.retrofit2.http.Query;
import io.reactivex.Observable;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(d1 = {"\u0000¼\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001Jm\u0010\u0011\u001a\u001e\u0012\u001a\u0012\u0018\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000f0\rj\b\u0012\u0004\u0012\u00020\u000e`\u00100\f2\n\b\u0001\u0010\u0003\u001a\u0004\u0018\u00010\u00022\n\b\u0001\u0010\u0005\u001a\u0004\u0018\u00010\u00042\n\b\u0001\u0010\u0006\u001a\u0004\u0018\u00010\u00042\b\b\u0001\u0010\b\u001a\u00020\u00072\b\b\u0003\u0010\n\u001a\u00020\t2\b\b\u0001\u0010\u000b\u001a\u00020\u0007H'¢\u0006\u0004\b\u0011\u0010\u0012JC\u0010\u0014\u001a\u001e\u0012\u001a\u0012\u0018\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u000f0\rj\b\u0012\u0004\u0012\u00020\u0001`\u00100\f2\n\b\u0001\u0010\u0013\u001a\u0004\u0018\u00010\u00022\n\b\u0001\u0010\u0005\u001a\u0004\u0018\u00010\u0004H'¢\u0006\u0004\b\u0014\u0010\u0015J(\u0010\u0018\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00170\u00160\f2\b\b\u0001\u0010\u0005\u001a\u00020\u00042\b\b\u0001\u0010\u0003\u001a\u00020\u0002H'JB\u0010\u001b\u001a\u001e\u0012\u001a\u0012\u0018\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u00020\u000f0\rj\b\u0012\u0004\u0012\u00020\u001a`\u00100\f2\b\b\u0001\u0010\u0005\u001a\u00020\u00042\b\b\u0001\u0010\u0003\u001a\u00020\u00022\b\b\u0001\u0010\u0019\u001a\u00020\u0004H'JB\u0010\u001d\u001a\u001e\u0012\u001a\u0012\u0018\u0012\u0004\u0012\u00020\u001c\u0012\u0004\u0012\u00020\u000f0\rj\b\u0012\u0004\u0012\u00020\u001c`\u00100\f2\b\b\u0001\u0010\u0005\u001a\u00020\u00042\b\b\u0001\u0010\u0003\u001a\u00020\u00022\b\b\u0001\u0010\u0019\u001a\u00020\u0004H'JL\u0010 \u001a\u001e\u0012\u001a\u0012\u0018\u0012\u0004\u0012\u00020\u001f\u0012\u0004\u0012\u00020\u000f0\rj\b\u0012\u0004\u0012\u00020\u001f`\u00100\f2\b\b\u0001\u0010\u0005\u001a\u00020\u00042\b\b\u0001\u0010\u0003\u001a\u00020\u00022\b\b\u0001\u0010\u0019\u001a\u00020\u00042\b\b\u0001\u0010\u001e\u001a\u00020\u0007H'JL\u0010\"\u001a\u001e\u0012\u001a\u0012\u0018\u0012\u0004\u0012\u00020!\u0012\u0004\u0012\u00020\u000f0\rj\b\u0012\u0004\u0012\u00020!`\u00100\f2\b\b\u0001\u0010\u0005\u001a\u00020\u00042\b\b\u0001\u0010\u0003\u001a\u00020\u00022\b\b\u0001\u0010\u0019\u001a\u00020\u00042\b\b\u0001\u0010\u001e\u001a\u00020\u0007H'JB\u0010%\u001a\u001e\u0012\u001a\u0012\u0018\u0012\u0004\u0012\u00020$\u0012\u0004\u0012\u00020\u000f0\rj\b\u0012\u0004\u0012\u00020$`\u00100\f2\b\b\u0001\u0010\u0003\u001a\u00020\u00022\b\b\u0001\u0010\u0005\u001a\u00020\u00042\b\b\u0001\u0010#\u001a\u00020\u0004H'J(\u0010'\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020&0\u00160\f2\b\b\u0001\u0010\u0005\u001a\u00020\u00042\b\b\u0001\u0010\u0003\u001a\u00020\u0002H'J8\u0010+\u001a\u001e\u0012\u001a\u0012\u0018\u0012\u0004\u0012\u00020)\u0012\u0004\u0012\u00020\u000f0(j\b\u0012\u0004\u0012\u00020)`*0\f2\b\b\u0001\u0010\u0005\u001a\u00020\u00042\b\b\u0001\u0010\u0003\u001a\u00020\u0002H'J8\u0010-\u001a\u001e\u0012\u001a\u0012\u0018\u0012\u0004\u0012\u00020,\u0012\u0004\u0012\u00020\u000f0(j\b\u0012\u0004\u0012\u00020,`*0\f2\b\b\u0001\u0010\u0005\u001a\u00020\u00042\b\b\u0001\u0010\u0003\u001a\u00020\u0002H'J8\u0010/\u001a\u001e\u0012\u001a\u0012\u0018\u0012\u0004\u0012\u00020.\u0012\u0004\u0012\u00020\u000f0\rj\b\u0012\u0004\u0012\u00020.`\u00100\f2\b\b\u0001\u0010\u0005\u001a\u00020\u00042\b\b\u0001\u0010\u0003\u001a\u00020\u0002H'J\u001e\u00102\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u000201000\f2\b\b\u0001\u0010\u0003\u001a\u00020\u0002H'J<\u00105\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u0001000\f2\b\b\u0001\u0010\u0005\u001a\u00020\u00042\b\b\u0001\u00103\u001a\u00020\u00042\b\b\u0001\u0010\u0003\u001a\u00020\u00022\b\b\u0001\u00104\u001a\u00020\u0004H'J2\u00107\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u000206000\f2\b\b\u0001\u0010\u0005\u001a\u00020\u00042\b\b\u0001\u0010\u0003\u001a\u00020\u00022\b\b\u0001\u00103\u001a\u00020\u0004H'J<\u00109\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u0001000\f2\b\b\u0001\u0010\u0005\u001a\u00020\u00042\b\b\u0001\u0010\u0003\u001a\u00020\u00022\b\b\u0001\u00103\u001a\u00020\u00042\b\b\u0001\u00108\u001a\u00020\u0004H'J2\u0010:\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u0001000\f2\b\b\u0001\u0010\u0005\u001a\u00020\u00042\b\b\u0001\u0010\u0003\u001a\u00020\u00022\b\b\u0001\u00103\u001a\u00020\u0004H'JB\u0010=\u001a\u001e\u0012\u001a\u0012\u0018\u0012\u0004\u0012\u00020<\u0012\u0004\u0012\u00020\u000f0(j\b\u0012\u0004\u0012\u00020<`*0\f2\b\b\u0001\u0010\u0005\u001a\u00020\u00042\b\b\u0001\u0010\u0003\u001a\u00020\u00022\b\b\u0001\u0010;\u001a\u00020\tH'J8\u0010?\u001a\u001e\u0012\u001a\u0012\u0018\u0012\u0004\u0012\u00020>\u0012\u0004\u0012\u00020\u000f0\rj\b\u0012\u0004\u0012\u00020>`\u00100\f2\b\b\u0001\u0010\u0005\u001a\u00020\u00042\b\b\u0001\u0010\u0003\u001a\u00020\u0002H'JB\u0010B\u001a\u001e\u0012\u001a\u0012\u0018\u0012\u0004\u0012\u00020A\u0012\u0004\u0012\u00020\u000f0\rj\b\u0012\u0004\u0012\u00020A`\u00100\f2\b\b\u0001\u0010\u0005\u001a\u00020\u00042\b\b\u0001\u0010\u0003\u001a\u00020\u00022\b\b\u0001\u0010@\u001a\u00020\u0004H'JL\u0010F\u001a\u001e\u0012\u001a\u0012\u0018\u0012\u0004\u0012\u00020E\u0012\u0004\u0012\u00020\u000f0\rj\b\u0012\u0004\u0012\u00020E`\u00100\f2\b\b\u0001\u0010\u0005\u001a\u00020\u00042\b\b\u0001\u0010\u0003\u001a\u00020\u00022\b\b\u0001\u0010C\u001a\u00020\u00022\b\b\u0001\u0010D\u001a\u00020\u0002H'¨\u0006G"}, d2 = {"Lcom/bytedance/android/live/broadcastgame/opengame/network/OpenGameApi;", "", "", "roomId", "", "appId", "anchorId", "", "liveScene", "", "isDebug", "launchSource", "Lio/reactivex/Observable;", "Lcom/bytedance/android/live/network/response/ExtraResponse;", "Lcom/bytedance/android/live/broadcastgame/opengame/network/w;", "Lcom/bytedance/android/live/broadcastgame/opengame/network/model/OpenPlatformRespExtra;", "Lcom/bytedance/android/live/broadcastgame/opengame/network/model/OpenPlatformBaseResponseV2;", "sendAudienceStart", "(Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;IZI)Lio/reactivex/Observable;", "startId", "sendAudienceStop", "(Ljava/lang/Long;Ljava/lang/String;)Lio/reactivex/Observable;", "Lcom/bytedance/android/live/network/response/Response;", "Lcom/bytedance/android/live/broadcastgame/opengame/network/a;", "getBootConfig", "openIdList", "Lcom/bytedance/android/live/broadcastgame/opengame/network/t;", "inviteLiveUser", "Lcom/bytedance/android/live/broadcastgame/opengame/network/u;", "kickOutUser", "disable", "Lcom/bytedance/android/live/broadcastgame/opengame/network/f0;", "operateUserMicrophone", "Lcom/bytedance/android/live/broadcastgame/opengame/network/e0;", "operateUserCamera", "cacheHash", "Lcom/bytedance/android/live/broadcastgame/opengame/network/o;", "getApiConfig", "Lcom/bytedance/android/live/broadcastgame/opengame/network/p;", "getCrypt", "Lcom/bytedance/android/live/network/response/BaseResponse;", "Lcom/bytedance/android/live/broadcastgame/opengame/network/b0;", "Lcom/bytedance/android/live/broadcastgame/opengame/network/model/OpenPlatformBaseResponse;", "getRoomInfo", "Lcom/bytedance/android/live/broadcastgame/opengame/network/c0;", "getCurrentUserInfo", "Lcom/bytedance/android/live/broadcastgame/opengame/network/d0;", "getUserInfoV2", "Lcom/bytedance/android/live/network/response/e;", "Lcom/bytedance/android/live/broadcastgame/api/model/response/a;", "getEntranceInfo", "taskId", "appVersion", "runPerfTestTask", "Lcom/bytedance/android/live/broadcastgame/opengame/network/j0;", "checkPerfTestStatus", "data", "uploadPerfTestData", "submitPerfTestTask", "isNew", "Lcom/bytedance/android/live/broadcastgame/opengame/network/b;", "checkIndividualPlayer", "Lcom/bytedance/android/live/broadcastgame/opengame/network/c;", "checkIntermediateIndividualPlayer", "propIds", "Lcom/bytedance/android/live/broadcastgame/opengame/network/s;", "getUserPropInfo", "propId", "propNum", "Lcom/bytedance/android/live/broadcastgame/opengame/network/e;", "createPropUsageOrder", "livebroadcastgame-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface OpenGameApi {
    @GET("/webcast/openapi/business/individual/player/")
    Observable<BaseResponse<b, OpenPlatformRespExtra>> checkIndividualPlayer(@Query(OpenPlatformBaseDebugger.APP_ID) String r1, @Query("room_id") long r2, @Query("is_new") boolean r4);

    @GET("/webcast/openapi/business/individual/intermediate_player/")
    Observable<ExtraResponse<c, OpenPlatformRespExtra>> checkIntermediateIndividualPlayer(@Query(OpenPlatformBaseDebugger.APP_ID) String r1, @Query("room_id") long r2);

    @PassOpenApiCheck
    @POST("/webcast/openapi/performance/task/status/")
    Observable<com.bytedance.android.live.network.response.e<j0>> checkPerfTestStatus(@Query(OpenPlatformBaseDebugger.APP_ID) String r1, @Query("room_id") long r2, @Query("task_id") String r4);

    @POST("/webcast/openapi/game_prop/usage_order/create/")
    Observable<ExtraResponse<e, OpenPlatformRespExtra>> createPropUsageOrder(@Query(OpenPlatformBaseDebugger.APP_ID) String r1, @Query("room_id") long r2, @Query("prop_id") long r4, @Query("prop_num") long r6);

    @POST("/webcast/openapi/apiconfig/")
    Observable<ExtraResponse<o, OpenPlatformRespExtra>> getApiConfig(@Query("room_id") long r1, @Query(OpenPlatformBaseDebugger.APP_ID) String r3, @Query("cache_hash") String r4);

    @PassOpenApiCheck
    @POST("/webcast/openapi/bootconfig/")
    Observable<Response<a>> getBootConfig(@Query(OpenPlatformBaseDebugger.APP_ID) String r1, @Query("room_id") long r2);

    @PassOpenApiCheck
    @POST("/webcast/openapi/crypt/room/")
    Observable<Response<p>> getCrypt(@Query(OpenPlatformBaseDebugger.APP_ID) String r1, @Query("room_id") long r2);

    @GET("/webcast/openapi/user/info/mine/")
    Observable<BaseResponse<c0, OpenPlatformRespExtra>> getCurrentUserInfo(@Query(OpenPlatformBaseDebugger.APP_ID) String r1, @Query("room_id") long r2);

    @GET("/webcast/stamp/entrance_info/")
    Observable<com.bytedance.android.live.network.response.e<com.bytedance.android.live.broadcastgame.api.model.response.a>> getEntranceInfo(@Query("room_id") long r1);

    @GET("/webcast/openapi/room/info/")
    Observable<BaseResponse<b0, OpenPlatformRespExtra>> getRoomInfo(@Query(OpenPlatformBaseDebugger.APP_ID) String r1, @Query("room_id") long r2);

    @GET("/webcast/openapi/user/unencrypted_info/mine")
    Observable<ExtraResponse<d0, OpenPlatformRespExtra>> getUserInfoV2(@Query(OpenPlatformBaseDebugger.APP_ID) String r1, @Query("room_id") long r2);

    @GET("/webcast/openapi/game_prop/player/query/")
    Observable<ExtraResponse<s, OpenPlatformRespExtra>> getUserPropInfo(@Query(OpenPlatformBaseDebugger.APP_ID) String r1, @Query("room_id") long r2, @Query("prop_ids_str") String r4);

    @POST("/webcast/openapi/linkmic/invite/")
    Observable<ExtraResponse<t, OpenPlatformRespExtra>> inviteLiveUser(@Query(OpenPlatformBaseDebugger.APP_ID) String r1, @Query("room_id") long r2, @Query("open_id_list") String r4);

    @POST("/webcast/openapi/linkmic/kickout/")
    Observable<ExtraResponse<u, OpenPlatformRespExtra>> kickOutUser(@Query(OpenPlatformBaseDebugger.APP_ID) String r1, @Query("room_id") long r2, @Query("open_id_list") String r4);

    @POST("/webcast/openapi/linkmic/camera/disable/")
    Observable<ExtraResponse<e0, OpenPlatformRespExtra>> operateUserCamera(@Query(OpenPlatformBaseDebugger.APP_ID) String r1, @Query("room_id") long r2, @Query("open_id_list") String r4, @Query("disable") int r5);

    @POST("/webcast/openapi/linkmic/microphone/disable/")
    Observable<ExtraResponse<f0, OpenPlatformRespExtra>> operateUserMicrophone(@Query(OpenPlatformBaseDebugger.APP_ID) String r1, @Query("room_id") long r2, @Query("open_id_list") String r4, @Query("disable") int r5);

    @PassOpenApiCheck
    @POST("/webcast/openapi/performance/task/run/")
    Observable<com.bytedance.android.live.network.response.e<Object>> runPerfTestTask(@Query(OpenPlatformBaseDebugger.APP_ID) String r1, @Query("task_id") String r2, @Query("room_id") long r3, @Query("app_version") String r5);

    @GET("/webcast/openapi/applet/audience/start/")
    Observable<ExtraResponse<w, OpenPlatformRespExtra>> sendAudienceStart(@Query("room_id") Long r1, @Query(OpenPlatformBaseDebugger.APP_ID) String r2, @Query("anchor_id") String r3, @Query("live_scene_type") int r4, @Query("is_debug") boolean r5, @Query("launch_source") int r6);

    @GET("/webcast/openapi/applet/audience/stop/")
    Observable<ExtraResponse<Object, OpenPlatformRespExtra>> sendAudienceStop(@Query("start_id") Long r1, @Query(OpenPlatformBaseDebugger.APP_ID) String r2);

    @PassOpenApiCheck
    @POST("/webcast/openapi/performance/task/finish/")
    Observable<com.bytedance.android.live.network.response.e<Object>> submitPerfTestTask(@Query(OpenPlatformBaseDebugger.APP_ID) String r1, @Query("room_id") long r2, @Query("task_id") String r4);

    @PassOpenApiCheck
    @POST("/webcast/openapi/performance/data/upload/")
    Observable<com.bytedance.android.live.network.response.e<Object>> uploadPerfTestData(@Query(OpenPlatformBaseDebugger.APP_ID) String r1, @Query("room_id") long r2, @Query("task_id") String r4, @Query("data") String r5);
}
