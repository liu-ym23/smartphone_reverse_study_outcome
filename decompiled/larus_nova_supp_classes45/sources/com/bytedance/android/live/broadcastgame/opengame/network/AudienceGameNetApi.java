package com.bytedance.android.live.broadcastgame.opengame.network;

import com.bytedance.android.live.broadcastgame.opengame.debug.OpenPlatformBaseDebugger;
import com.bytedance.android.live.broadcastgame.opengame.network.model.OpenPlatformRespExtra;
import com.bytedance.android.live.network.response.BaseResponse;
import com.bytedance.android.live.network.response.ExtraResponse;
import com.bytedance.retrofit2.http.Field;
import com.bytedance.retrofit2.http.FormUrlEncoded;
import com.bytedance.retrofit2.http.GET;
import com.bytedance.retrofit2.http.POST;
import com.bytedance.retrofit2.http.Query;
import io.reactivex.Observable;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001JN\u0010\f\u001a\u001e\u0012\u001a\u0012\u0018\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\n0\tj\b\u0012\u0004\u0012\u00020\u0001`\u000b0\b2\b\b\u0001\u0010\u0003\u001a\u00020\u00022\b\b\u0001\u0010\u0005\u001a\u00020\u00042\b\b\u0001\u0010\u0006\u001a\u00020\u00042\n\b\u0003\u0010\u0007\u001a\u0004\u0018\u00010\u0004H'J8\u0010\u000e\u001a\u001e\u0012\u001a\u0012\u0018\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\n0\tj\b\u0012\u0004\u0012\u00020\r`\u000b0\b2\b\b\u0001\u0010\u0005\u001a\u00020\u00042\b\b\u0001\u0010\u0003\u001a\u00020\u0002H'J2\u0010\u0013\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00120\u00110\b2\b\b\u0001\u0010\u0003\u001a\u00020\u00022\b\b\u0001\u0010\u000f\u001a\u00020\u00022\b\b\u0001\u0010\u0010\u001a\u00020\u0002H'J(\u0010\u0015\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00140\u00110\b2\b\b\u0001\u0010\u0003\u001a\u00020\u00022\b\b\u0001\u0010\u0010\u001a\u00020\u0004H'J8\u0010\u0017\u001a\u001e\u0012\u001a\u0012\u0018\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\n0\tj\b\u0012\u0004\u0012\u00020\u0016`\u000b0\b2\b\b\u0001\u0010\u0005\u001a\u00020\u00042\b\b\u0001\u0010\u0003\u001a\u00020\u0002H'J`\u0010\u001d\u001a\u001e\u0012\u001a\u0012\u0018\u0012\u0004\u0012\u00020\u001c\u0012\u0004\u0012\u00020\n0\tj\b\u0012\u0004\u0012\u00020\u001c`\u000b0\b2\b\b\u0001\u0010\u0005\u001a\u00020\u00042\b\b\u0001\u0010\u0003\u001a\u00020\u00022\b\b\u0001\u0010\u0018\u001a\u00020\u00042\b\b\u0001\u0010\u0019\u001a\u00020\u00022\b\b\u0001\u0010\u001a\u001a\u00020\u00042\b\b\u0001\u0010\u001b\u001a\u00020\u0004H'JB\u0010\u001f\u001a\u001e\u0012\u001a\u0012\u0018\u0012\u0004\u0012\u00020\u001e\u0012\u0004\u0012\u00020\n0\tj\b\u0012\u0004\u0012\u00020\u001e`\u000b0\b2\b\b\u0001\u0010\u0005\u001a\u00020\u00042\b\b\u0001\u0010\u0018\u001a\u00020\u00042\b\b\u0001\u0010\u0003\u001a\u00020\u0002H'J`\u0010!\u001a\u001e\u0012\u001a\u0012\u0018\u0012\u0004\u0012\u00020 \u0012\u0004\u0012\u00020\n0\tj\b\u0012\u0004\u0012\u00020 `\u000b0\b2\b\b\u0001\u0010\u0005\u001a\u00020\u00042\b\b\u0001\u0010\u0003\u001a\u00020\u00022\b\b\u0001\u0010\u0018\u001a\u00020\u00042\b\b\u0001\u0010\u0019\u001a\u00020\u00022\b\b\u0001\u0010\u001a\u001a\u00020\u00042\b\b\u0001\u0010\u001b\u001a\u00020\u0004H'J8\u0010#\u001a\u001e\u0012\u001a\u0012\u0018\u0012\u0004\u0012\u00020\"\u0012\u0004\u0012\u00020\n0\tj\b\u0012\u0004\u0012\u00020\"`\u000b0\b2\b\b\u0001\u0010\u0005\u001a\u00020\u00042\b\b\u0001\u0010\u0003\u001a\u00020\u0002H'J.\u0010&\u001a\u001e\u0012\u001a\u0012\u0018\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\n0$j\b\u0012\u0004\u0012\u00020\u0001`%0\b2\b\b\u0001\u0010\u0005\u001a\u00020\u0004H'J8\u0010(\u001a\u001e\u0012\u001a\u0012\u0018\u0012\u0004\u0012\u00020'\u0012\u0004\u0012\u00020\n0$j\b\u0012\u0004\u0012\u00020'`%0\b2\b\b\u0001\u0010\u0005\u001a\u00020\u00042\b\b\u0001\u0010\u0003\u001a\u00020\u0002H'¨\u0006)"}, d2 = {"Lcom/bytedance/android/live/broadcastgame/opengame/network/AudienceGameNetApi;", "", "", "roomId", "", "appId", "data", "extra", "Lio/reactivex/Observable;", "Lcom/bytedance/android/live/network/response/BaseResponse;", "Lcom/bytedance/android/live/broadcastgame/opengame/network/model/OpenPlatformRespExtra;", "Lcom/bytedance/android/live/broadcastgame/opengame/network/model/OpenPlatformBaseResponse;", "sendMessageToAnchor", "Lcom/bytedance/android/live/broadcastgame/opengame/network/n;", "isFollowAnchor", "elemType", "elemId", "Lcom/bytedance/android/live/network/response/e;", "Lcom/bytedance/android/live/broadcastgame/opengame/network/i;", "getEntranceVisiable", "Lcom/bytedance/android/live/broadcastgame/opengame/network/j;", "getEntranceVisibleV2", "Lcom/bytedance/android/live/broadcastgame/opengame/network/d;", "createOrderId", "orderId", "diamonds", "tag", "tagsExtra", "Lcom/bytedance/android/live/broadcastgame/opengame/network/g0;", "payDiamond", "Lcom/bytedance/android/live/broadcastgame/opengame/network/i0;", "queryOrderStatus", "Lcom/bytedance/android/live/broadcastgame/opengame/network/h0;", "payDiamondV3", "Lcom/bytedance/android/live/broadcastgame/opengame/network/r;", "getCollectionStatus", "Lcom/bytedance/android/live/network/response/ExtraResponse;", "Lcom/bytedance/android/live/broadcastgame/opengame/network/model/OpenPlatformBaseResponseV2;", "addToFavorite", "Lcom/bytedance/android/live/broadcastgame/opengame/network/m;", "getEntranceVision", "livebroadcastgame-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface AudienceGameNetApi {
    @POST("/webcast/openapi/user/collect_app/")
    Observable<ExtraResponse<Object, OpenPlatformRespExtra>> addToFavorite(@Query(OpenPlatformBaseDebugger.APP_ID) String r1);

    @GET("/webcast/openapi/business/order/gen_id/")
    Observable<BaseResponse<d, OpenPlatformRespExtra>> createOrderId(@Query(OpenPlatformBaseDebugger.APP_ID) String r1, @Query("room_id") long r2);

    @GET("/webcast/openapi/user/collection_status/")
    Observable<BaseResponse<r, OpenPlatformRespExtra>> getCollectionStatus(@Query(OpenPlatformBaseDebugger.APP_ID) String r1, @Query("room_id") long r2);

    @GET("/webcast/stamp/entrance_visiable/")
    Observable<com.bytedance.android.live.network.response.e<i>> getEntranceVisiable(@Query("room_id") long r1, @Query("elem_type") long r3, @Query("elem_id") long r5);

    @GET("/webcast/user_interact/entrance_visible_v2/")
    Observable<com.bytedance.android.live.network.response.e<j>> getEntranceVisibleV2(@Query("room_id") long r1, @Query("mini_app_id") String r3);

    @GET("/webcast/user_interact/entrance_vision/")
    Observable<ExtraResponse<m, OpenPlatformRespExtra>> getEntranceVision(@Query("mini_app_id") String r1, @Query("room_id") long r2);

    @GET("/webcast/openapi/follow/status/")
    Observable<BaseResponse<n, OpenPlatformRespExtra>> isFollowAnchor(@Query(OpenPlatformBaseDebugger.APP_ID) String r1, @Query("room_id") long r2);

    @FormUrlEncoded
    @POST("/webcast/openapi/business/diamond/pay/")
    Observable<BaseResponse<g0, OpenPlatformRespExtra>> payDiamond(@Query(OpenPlatformBaseDebugger.APP_ID) String r1, @Query("room_id") long r2, @Query("order_id") String r4, @Query("diamonds") long r5, @Query("pay_tag") String r7, @Field("tags_extra") String r8);

    @FormUrlEncoded
    @POST("/webcast/openapi/business/order/pay/")
    Observable<BaseResponse<h0, OpenPlatformRespExtra>> payDiamondV3(@Query(OpenPlatformBaseDebugger.APP_ID) String r1, @Query("room_id") long r2, @Query("order_id") String r4, @Query("diamonds") long r5, @Query("pay_tag") String r7, @Field("tags_extra") String r8);

    @GET("/webcast/openapi/business/diamond/query/")
    Observable<BaseResponse<i0, OpenPlatformRespExtra>> queryOrderStatus(@Query(OpenPlatformBaseDebugger.APP_ID) String r1, @Query("order_id") String r2, @Query("room_id") long r3);

    @POST("/webcast/openapi/channel/send_data_from_audience/")
    Observable<BaseResponse<Object, OpenPlatformRespExtra>> sendMessageToAnchor(@Query("room_id") long r1, @Query(OpenPlatformBaseDebugger.APP_ID) String r3, @Query("data") String r4, @Query("extra") String r5);
}
