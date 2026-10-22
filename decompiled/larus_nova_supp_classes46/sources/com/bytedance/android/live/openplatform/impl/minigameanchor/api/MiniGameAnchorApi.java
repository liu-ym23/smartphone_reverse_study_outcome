package com.bytedance.android.live.openplatform.impl.minigameanchor.api;

import com.bytedance.android.live.network.response.Response;
import com.bytedance.android.live.openplatform.impl.minigameanchor.api.response.StartGameResponse;
import com.bytedance.retrofit2.http.Field;
import com.bytedance.retrofit2.http.FormUrlEncoded;
import com.bytedance.retrofit2.http.GET;
import com.bytedance.retrofit2.http.POST;
import com.bytedance.retrofit2.http.Query;
import io.reactivex.Observable;
import kotlin.Metadata;
import yq0.a;
import yq0.b;
import yq0.c;
import yq0.d;
import yq0.e;
import yq0.f;
import yq0.g;
import yq0.h;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001Jm\u0010\u0010\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\u000e0\r2\b\b\u0001\u0010\u0003\u001a\u00020\u00022\b\b\u0001\u0010\u0004\u001a\u00020\u00022\b\b\u0001\u0010\u0005\u001a\u00020\u00022\b\b\u0001\u0010\u0006\u001a\u00020\u00022\b\b\u0001\u0010\b\u001a\u00020\u00072\b\b\u0001\u0010\t\u001a\u00020\u00072\n\b\u0003\u0010\u000b\u001a\u0004\u0018\u00010\n2\b\b\u0003\u0010\f\u001a\u00020\u0007H'¢\u0006\u0004\b\u0010\u0010\u0011J2\u0010\u0013\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00010\u000e0\r2\b\b\u0001\u0010\u0012\u001a\u00020\u00072\b\b\u0001\u0010\u0003\u001a\u00020\u00022\b\b\u0001\u0010\u0004\u001a\u00020\u0002H'J(\u0010\u0015\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00140\u000e0\r2\b\b\u0001\u0010\u0004\u001a\u00020\u00022\b\b\u0001\u0010\b\u001a\u00020\u0007H'J\u001e\u0010\u0017\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00160\u000e0\r2\b\b\u0001\u0010\u0004\u001a\u00020\u0002H'J(\u0010\u001a\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00190\u000e0\r2\b\b\u0001\u0010\u0004\u001a\u00020\u00022\b\b\u0001\u0010\u0018\u001a\u00020\u0007H'J2\u0010\u001f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001e0\u000e0\r2\b\b\u0001\u0010\u001b\u001a\u00020\u00072\b\b\u0001\u0010\u0004\u001a\u00020\u00022\b\b\u0003\u0010\u001d\u001a\u00020\u001cH'J\u001e\u0010!\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020 0\u000e0\r2\b\b\u0001\u0010\u0004\u001a\u00020\u0002H'J(\u0010$\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020#0\u000e0\r2\b\b\u0001\u0010\b\u001a\u00020\u00072\b\b\u0001\u0010\"\u001a\u00020\nH'J\u001e\u0010&\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00010\u000e0\r2\b\b\u0001\u0010%\u001a\u00020\u0007H'J\u001e\u0010(\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00010\u000e0\r2\b\b\u0001\u0010'\u001a\u00020\nH'J,\u0010+\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00010\u000e0\r2\n\b\u0001\u0010)\u001a\u0004\u0018\u00010\u00072\n\b\u0001\u0010*\u001a\u0004\u0018\u00010\u0007H'J2\u0010.\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020-0\u000e0\r2\b\b\u0001\u0010\u001b\u001a\u00020\u00072\b\b\u0001\u0010\u0004\u001a\u00020\u00022\b\b\u0001\u0010,\u001a\u00020\nH'J,\u00102\u001a\b\u0012\u0004\u0012\u0002010\r2\b\b\u0001\u0010\u001b\u001a\u00020\u00072\b\b\u0001\u0010/\u001a\u00020\u00072\b\b\u0001\u00100\u001a\u00020\u0007H'J2\u00104\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002030\u000e0\r2\b\b\u0001\u0010\u0004\u001a\u00020\u00022\b\b\u0001\u0010\t\u001a\u00020\u00072\b\b\u0001\u0010\f\u001a\u00020\u0007H'¨\u00065"}, d2 = {"Lcom/bytedance/android/live/openplatform/impl/minigameanchor/api/MiniGameAnchorApi;", "", "", "aid", "roomId", "launchSource", "timeStamp", "", "taskId", "gameId", "", "entranceFrom", "openExtra", "Lio/reactivex/Observable;", "Lcom/bytedance/android/live/network/response/Response;", "Lcom/bytedance/android/live/openplatform/impl/minigameanchor/api/response/StartGameResponse;", "requestGameStart", "(JJJJLjava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;)Lio/reactivex/Observable;", "startId", "requestGameStop", "Lyq0/g;", "setExplainCard", "Lyq0/b;", "deleteExplainCard", "start_id", "Lyq0/d;", "getRealTimeData", "mpId", "", "needRtc", "Lyq0/e;", "requestStartConfig", "Lyq0/f;", "getWebcastMetaMicroGameConfig", "entrance_from", "Lyq0/a;", "checkLiveThreshold", "protocols", "signUserAgreement", "sourceType", "starAuthorRegister", "fromTaskId", "toTaskId", "previewSwitchTask", "status", "Lcom/bytedance/android/live/network/response/a;", "instantPlayUpdateConfig", "progressInfo", "anchorId", "Lyq0/c;", "instantPlayUploadProgress", "Lyq0/h;", "requestGameStartCast", "liveopenplatform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface MiniGameAnchorApi {
    @GET("/reward/miscellany/can_upload")
    Observable<Response<a>> checkLiveThreshold(@Query("task_id") String r1, @Query("entrance_from") int r2);

    @FormUrlEncoded
    @POST("/mgplatform/api/apps/live/card/delete")
    Observable<Response<b>> deleteExplainCard(@Field("room_id") long r1);

    @GET("/mgplatform/api/apps/live/data/real_time")
    Observable<Response<d>> getRealTimeData(@Query("room_id") long r1, @Query("start_id") String r3);

    @GET("/mgplatform/api/apps/live/webcast_config")
    Observable<Response<f>> getWebcastMetaMicroGameConfig(@Query("room_id") long r1);

    @FormUrlEncoded
    @POST("/mgplatform/api/apps/live/instant_play/update_config")
    Observable<Response<com.bytedance.android.live.network.response.a>> instantPlayUpdateConfig(@Field("mp_id") String r1, @Field("room_id") long r2, @Field("status") int r4);

    @FormUrlEncoded
    @POST("/mgplatform/api/apps/instant_play/upload_anchor_progress_info")
    Observable<c> instantPlayUploadProgress(@Field("mp_id") String r1, @Field("progress_info") String r2, @Field("anchor_id") String r3);

    @FormUrlEncoded
    @POST("/pop/api/v2/live_page/switch_task")
    Observable<Response<Object>> previewSwitchTask(@Field("from_task_id") String r1, @Field("to_task_id") String r2);

    @FormUrlEncoded
    @POST("/mgplatform/api/apps/live/game/start")
    Observable<Response<StartGameResponse>> requestGameStart(@Field("aid") long r1, @Field("room_id") long r3, @Field("launch_source") long r5, @Field("time_stamp") long r7, @Field("task_id") String r9, @Field("mp_id") String r10, @Field("entrance_from") Integer r11, @Field("open_extra") String r12);

    @FormUrlEncoded
    @POST("/mgplatform/api/apps/live/game/start_casting")
    Observable<Response<h>> requestGameStartCast(@Field("room_id") long r1, @Field("mp_id") String r3, @Field("open_extra") String r4);

    @FormUrlEncoded
    @POST("/mgplatform/api/apps/live/game/stop")
    Observable<Response<Object>> requestGameStop(@Field("start_id") String r1, @Field("aid") long r2, @Field("room_id") long r4);

    @GET("/mgplatform/api/apps/live/start/config")
    Observable<Response<e>> requestStartConfig(@Query("mp_id") String r1, @Query("room_id") long r2, @Query("need_rtc") boolean r4);

    @FormUrlEncoded
    @POST("/mgplatform/api/apps/live/card/set")
    Observable<Response<g>> setExplainCard(@Field("room_id") long r1, @Field("task_id") String r3);

    @FormUrlEncoded
    @POST("/reward/agreement/sign")
    Observable<Response<Object>> signUserAgreement(@Field("protocol_list") String r1);

    @FormUrlEncoded
    @POST("/gw/api/author/star_author_register")
    Observable<Response<Object>> starAuthorRegister(@Field("source_type") int r1);
}
