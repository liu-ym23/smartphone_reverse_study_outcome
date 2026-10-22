package com.bytedance.android.live.broadcastgame.opengame.network;

import com.bytedance.android.live.broadcastgame.opengame.debug.OpenPlatformBaseDebugger;
import com.bytedance.android.live.broadcastgame.opengame.network.model.OpenPlatformRespExtra;
import com.bytedance.android.live.network.response.BaseResponse;
import com.bytedance.retrofit2.http.Field;
import com.bytedance.retrofit2.http.FormUrlEncoded;
import com.bytedance.retrofit2.http.GET;
import com.bytedance.retrofit2.http.POST;
import com.bytedance.retrofit2.http.Query;
import io.reactivex.Observable;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001Jt\u0010\u0012\u001a\u001e\u0012\u001a\u0012\u0018\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00100\u000ej\b\u0012\u0004\u0012\u00020\u000f`\u00110\r2\b\b\u0001\u0010\u0003\u001a\u00020\u00022\b\b\u0001\u0010\u0005\u001a\u00020\u00042\b\b\u0001\u0010\u0006\u001a\u00020\u00022\b\b\u0001\u0010\u0007\u001a\u00020\u00042\b\b\u0003\u0010\t\u001a\u00020\b2\b\b\u0003\u0010\n\u001a\u00020\u00042\b\b\u0003\u0010\u000b\u001a\u00020\u00042\b\b\u0003\u0010\f\u001a\u00020\u0004H'JV\u0010\u0015\u001a\u001e\u0012\u001a\u0012\u0018\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00100\u000ej\b\u0012\u0004\u0012\u00020\u0001`\u00110\r2\b\b\u0001\u0010\u0013\u001a\u00020\u00042\b\b\u0001\u0010\u0005\u001a\u00020\u00042\b\b\u0001\u0010\u0003\u001a\u00020\u00022\b\b\u0001\u0010\u0007\u001a\u00020\u00042\b\b\u0003\u0010\u0014\u001a\u00020\u0004H'JX\u0010\u0018\u001a\u001e\u0012\u001a\u0012\u0018\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00100\u000ej\b\u0012\u0004\u0012\u00020\u0001`\u00110\r2\b\b\u0001\u0010\u0003\u001a\u00020\u00022\b\b\u0001\u0010\u0005\u001a\u00020\u00042\b\b\u0001\u0010\u0016\u001a\u00020\u00022\b\b\u0001\u0010\u0017\u001a\u00020\u00022\n\b\u0003\u0010\u0007\u001a\u0004\u0018\u00010\u0004H'Jd\u0010\u001b\u001a\u001e\u0012\u001a\u0012\u0018\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00100\u000ej\b\u0012\u0004\u0012\u00020\u0001`\u00110\r2\b\b\u0001\u0010\u0003\u001a\u00020\u00022\b\b\u0001\u0010\u0005\u001a\u00020\u00042\b\b\u0001\u0010\u0016\u001a\u00020\u00022\n\b\u0003\u0010\u0019\u001a\u0004\u0018\u00010\u00042\b\b\u0001\u0010\u001a\u001a\u00020\u00042\n\b\u0003\u0010\u0007\u001a\u0004\u0018\u00010\u0004H'JB\u0010\u001d\u001a\u001e\u0012\u001a\u0012\u0018\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00100\u000ej\b\u0012\u0004\u0012\u00020\u0001`\u00110\r2\b\b\u0001\u0010\u0005\u001a\u00020\u00042\b\b\u0001\u0010\u0003\u001a\u00020\u00022\b\b\u0001\u0010\u001c\u001a\u00020\u0004H'J8\u0010\u001e\u001a\u001e\u0012\u001a\u0012\u0018\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00100\u000ej\b\u0012\u0004\u0012\u00020\u0001`\u00110\r2\b\b\u0001\u0010\u0005\u001a\u00020\u00042\b\b\u0001\u0010\u0003\u001a\u00020\u0002H'JB\u0010 \u001a\u001e\u0012\u001a\u0012\u0018\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00100\u000ej\b\u0012\u0004\u0012\u00020\u0001`\u00110\r2\b\b\u0001\u0010\u0005\u001a\u00020\u00042\b\b\u0001\u0010\u0003\u001a\u00020\u00022\b\b\u0001\u0010\u001f\u001a\u00020\u0004H'J8\u0010!\u001a\u001e\u0012\u001a\u0012\u0018\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00100\u000ej\b\u0012\u0004\u0012\u00020\u0001`\u00110\r2\b\b\u0001\u0010\u0005\u001a\u00020\u00042\b\b\u0001\u0010\u0003\u001a\u00020\u0002H'J8\u0010\"\u001a\u001e\u0012\u001a\u0012\u0018\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00100\u000ej\b\u0012\u0004\u0012\u00020\u0001`\u00110\r2\b\b\u0001\u0010\u0005\u001a\u00020\u00042\b\b\u0001\u0010\u0003\u001a\u00020\u0002H'J8\u0010#\u001a\u001e\u0012\u001a\u0012\u0018\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00100\u000ej\b\u0012\u0004\u0012\u00020\u0001`\u00110\r2\b\b\u0001\u0010\u0005\u001a\u00020\u00042\b\b\u0001\u0010\u0003\u001a\u00020\u0002H'JB\u0010%\u001a\u001e\u0012\u001a\u0012\u0018\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00100\u000ej\b\u0012\u0004\u0012\u00020\u0001`\u00110\r2\b\b\u0001\u0010\u0005\u001a\u00020\u00042\b\b\u0001\u0010\u0003\u001a\u00020\u00022\b\b\u0001\u0010$\u001a\u00020\u0004H'J8\u0010&\u001a\u001e\u0012\u001a\u0012\u0018\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00100\u000ej\b\u0012\u0004\u0012\u00020\u0001`\u00110\r2\b\b\u0001\u0010\u0005\u001a\u00020\u00042\b\b\u0001\u0010\u0003\u001a\u00020\u0002H'J8\u0010(\u001a\u001e\u0012\u001a\u0012\u0018\u0012\u0004\u0012\u00020'\u0012\u0004\u0012\u00020\u00100\u000ej\b\u0012\u0004\u0012\u00020'`\u00110\r2\b\b\u0001\u0010\u0005\u001a\u00020\u00042\b\b\u0001\u0010\u0003\u001a\u00020\u0002H'J8\u0010*\u001a\u001e\u0012\u001a\u0012\u0018\u0012\u0004\u0012\u00020)\u0012\u0004\u0012\u00020\u00100\u000ej\b\u0012\u0004\u0012\u00020)`\u00110\r2\b\b\u0001\u0010\u0005\u001a\u00020\u00042\b\b\u0001\u0010\u0003\u001a\u00020\u0002H'¨\u0006+"}, d2 = {"Lcom/bytedance/android/live/broadcastgame/opengame/network/AnchorGameNetApi;", "", "", "roomId", "", "appId", "launchSource", "extra", "", "isBeforeStart", "stamp", "introCardInfo", "openExtra", "Lio/reactivex/Observable;", "Lcom/bytedance/android/live/network/response/BaseResponse;", "Lcom/bytedance/android/live/broadcastgame/opengame/network/v;", "Lcom/bytedance/android/live/broadcastgame/opengame/network/model/OpenPlatformRespExtra;", "Lcom/bytedance/android/live/broadcastgame/opengame/network/model/OpenPlatformBaseResponse;", "sendAppStart", "startId", "stopXplayInfo", "sendAppStop", "sendType", "status", "sendStatusMessage", "audienceOpenId", "data", "sendMessageToAudience", "keyWords", "subscribeSpecifiedContentComment", "unSubscribeAllSpecifiedContentComment", "openUid", "subscribeSpecifiedUserComment", "unSubscribeAllSpecifiedUserComment", "subscribeAudienceFollowAction", "unSubscribeAudienceFollowAction", "toOpenId", "showSpecifyAudienceCornerMark", "showAllAudienceCornerMark", "Lcom/bytedance/android/live/broadcastgame/opengame/network/m0;", "getTotalDiamonds", "Lcom/bytedance/android/live/broadcastgame/opengame/network/f;", "getDiamondRankList", "livebroadcastgame-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface AnchorGameNetApi {
    @GET("/webcast/openapi/business/diamond/rank_list/")
    Observable<BaseResponse<f, OpenPlatformRespExtra>> getDiamondRankList(@Query(OpenPlatformBaseDebugger.APP_ID) String r1, @Query("room_id") long r2);

    @GET("/webcast/openapi/business/diamond/total/")
    Observable<BaseResponse<m0, OpenPlatformRespExtra>> getTotalDiamonds(@Query(OpenPlatformBaseDebugger.APP_ID) String r1, @Query("room_id") long r2);

    @FormUrlEncoded
    @POST("/webcast/openapi/v2/app/start/")
    Observable<BaseResponse<v, OpenPlatformRespExtra>> sendAppStart(@Field("room_id") long r1, @Field(OpenPlatformBaseDebugger.APP_ID) String r3, @Field("launch_source") long r4, @Field("extra") String r6, @Field("is_before_start") boolean r7, @Field("stamp") String r8, @Field("game_card") String r9, @Field("open_extra") String r11);

    @POST("/webcast/openapi/v2/app/stop/")
    Observable<BaseResponse<Object, OpenPlatformRespExtra>> sendAppStop(@Query("start_id") String r1, @Query(OpenPlatformBaseDebugger.APP_ID) String r2, @Query("room_id") long r3, @Query("extra") String r5, @Query("stop_xplay_info") String r6);

    @POST("/webcast/openapi/channel/send_data_from_anchor/")
    Observable<BaseResponse<Object, OpenPlatformRespExtra>> sendMessageToAudience(@Query("room_id") long r1, @Query(OpenPlatformBaseDebugger.APP_ID) String r3, @Query("send_type") long r4, @Query("to_open_id") String r6, @Query("data") String r7, @Query("extra") String r8);

    @POST("/webcast/openapi/channel/send_status_msg/")
    Observable<BaseResponse<Object, OpenPlatformRespExtra>> sendStatusMessage(@Query("room_id") long r1, @Query(OpenPlatformBaseDebugger.APP_ID) String r3, @Query("send_type") long r4, @Query("status") long r6, @Query("extra") String r8);

    @POST("/webcast/openapi/corner_mark/reach/all/")
    Observable<BaseResponse<Object, OpenPlatformRespExtra>> showAllAudienceCornerMark(@Query(OpenPlatformBaseDebugger.APP_ID) String r1, @Query("room_id") long r2);

    @POST("/webcast/openapi/corner_mark/reach/spec/")
    Observable<BaseResponse<Object, OpenPlatformRespExtra>> showSpecifyAudienceCornerMark(@Query(OpenPlatformBaseDebugger.APP_ID) String r1, @Query("room_id") long r2, @Query("to_open_id") String r4);

    @POST("/webcast/openapi/follow/subscribe/")
    Observable<BaseResponse<Object, OpenPlatformRespExtra>> subscribeAudienceFollowAction(@Query(OpenPlatformBaseDebugger.APP_ID) String r1, @Query("room_id") long r2);

    @POST("/webcast/openapi/comment/subscribe/keyword/")
    Observable<BaseResponse<Object, OpenPlatformRespExtra>> subscribeSpecifiedContentComment(@Query(OpenPlatformBaseDebugger.APP_ID) String r1, @Query("room_id") long r2, @Query("keywords") String r4);

    @POST("/webcast/openapi/comment/subscribe/spec_user/")
    Observable<BaseResponse<Object, OpenPlatformRespExtra>> subscribeSpecifiedUserComment(@Query(OpenPlatformBaseDebugger.APP_ID) String r1, @Query("room_id") long r2, @Query("openids") String r4);

    @POST("/webcast/openapi/comment/unsubscribe/keyword/")
    Observable<BaseResponse<Object, OpenPlatformRespExtra>> unSubscribeAllSpecifiedContentComment(@Query(OpenPlatformBaseDebugger.APP_ID) String r1, @Query("room_id") long r2);

    @POST("/webcast/openapi/comment/unsubscribe/spec_user/")
    Observable<BaseResponse<Object, OpenPlatformRespExtra>> unSubscribeAllSpecifiedUserComment(@Query(OpenPlatformBaseDebugger.APP_ID) String r1, @Query("room_id") long r2);

    @POST("/webcast/openapi/follow/unsubscribe/")
    Observable<BaseResponse<Object, OpenPlatformRespExtra>> unSubscribeAudienceFollowAction(@Query(OpenPlatformBaseDebugger.APP_ID) String r1, @Query("room_id") long r2);
}
