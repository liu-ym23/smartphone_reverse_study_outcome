package com.bytedance.android.live.broadcastgame.opengame.network;

import com.bytedance.android.live.broadcastgame.opengame.debug.OpenPlatformBaseDebugger;
import com.bytedance.android.live.network.response.Response;
import com.bytedance.retrofit2.http.Body;
import com.bytedance.retrofit2.http.GET;
import com.bytedance.retrofit2.http.POST;
import com.bytedance.retrofit2.http.Query;
import com.bytedance.retrofit2.mime.TypedOutput;
import io.reactivex.Observable;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J(\u0010\t\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u00062\b\b\u0001\u0010\u0003\u001a\u00020\u00022\b\b\u0001\u0010\u0005\u001a\u00020\u0004H'J<\u0010\r\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00010\u00070\u00062\b\b\u0001\u0010\n\u001a\u00020\u00022\b\b\u0001\u0010\u000b\u001a\u00020\u00022\b\b\u0001\u0010\f\u001a\u00020\u00022\b\b\u0001\u0010\u0005\u001a\u00020\u0002H'J}\u0010\u0017\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00160\u00070\u00062\b\b\u0001\u0010\u0003\u001a\u00020\u00022\b\b\u0001\u0010\u000e\u001a\u00020\u00022\b\b\u0001\u0010\u000f\u001a\u00020\u00022\b\b\u0001\u0010\u0010\u001a\u00020\u00022\b\b\u0001\u0010\u0005\u001a\u00020\u00042\n\b\u0003\u0010\u0011\u001a\u0004\u0018\u00010\u00022\n\b\u0003\u0010\u0013\u001a\u0004\u0018\u00010\u00122\n\b\u0003\u0010\u0014\u001a\u0004\u0018\u00010\u00022\n\b\u0003\u0010\u0015\u001a\u0004\u0018\u00010\u0002H'¢\u0006\u0004\b\u0017\u0010\u0018J\u0018\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001b0\u00062\b\b\u0001\u0010\u001a\u001a\u00020\u0019H'¨\u0006\u001d"}, d2 = {"Lcom/bytedance/android/live/broadcastgame/opengame/network/GameReportApi;", "", "", "appId", "", "roomId", "Lio/reactivex/Observable;", "Lcom/bytedance/android/live/network/response/Response;", "Lcom/bytedance/android/live/broadcastgame/opengame/network/q;", "getReportReasonList", "reportId", "appScreenShotUris", "fullScreenShotUri", "submitReportExtraInfoRequest", "reasonId", "reportDesc", "report_uris", "reasonDesc", "", "noExtra", "appPath", "appQuery", "Lcom/bytedance/android/live/broadcastgame/opengame/network/l0;", "submitReportBaseInfoRequest", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JLjava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;)Lio/reactivex/Observable;", "Lcom/bytedance/retrofit2/mime/TypedOutput;", "typedOutput", "Lcom/bytedance/android/live/broadcastgame/opengame/network/o0;", "uploadImg", "livebroadcastgame-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface GameReportApi {
    @GET("/webcast/openapi/report/reason_list/")
    Observable<Response<q>> getReportReasonList(@Query("scene") String r1, @Query("room_id") long r2);

    @POST("/webcast/openapi/report/baseinfo/submit/")
    Observable<Response<l0>> submitReportBaseInfoRequest(@Query(OpenPlatformBaseDebugger.APP_ID) String r1, @Query("reason_id") String r2, @Query("report_desc") String r3, @Query("report_uris") String r4, @Query("room_id") long r5, @Query("reason_desc") String r7, @Query("no_extra") Boolean r8, @Query("app_path") String r9, @Query("app_query") String r11);

    @POST("/webcast/openapi/report/extrainfo/submit/")
    Observable<Response<Object>> submitReportExtraInfoRequest(@Query("report_id") String r1, @Query("app_screenshot_oids") String r2, @Query("full_screenshot_oids") String r3, @Query("room_id") String r4);

    @POST("/wsos_v2/webcast_interact_open/upload/")
    Observable<o0> uploadImg(@Body TypedOutput r1);
}
