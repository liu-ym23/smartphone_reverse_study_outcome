package com.bytedance.android.live.broadcastgame.opengame.message;

import com.bytedance.android.live.broadcastgame.opengame.debug.OpenPlatformBaseDebugger;
import com.bytedance.android.live.broadcastgame.opengame.network.model.PassOpenApiCheck;
import com.bytedance.android.live.network.annotation.PbRequest;
import com.bytedance.android.live.network.response.Response;
import com.bytedance.retrofit2.http.Body;
import com.bytedance.retrofit2.http.Field;
import com.bytedance.retrofit2.http.FormUrlEncoded;
import com.bytedance.retrofit2.http.Headers;
import com.bytedance.retrofit2.http.POST;
import io.reactivex.Observable;
import kotlin.Metadata;
import okhttp3.RequestBody;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u0006H'J(\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00010\b0\u00032\b\b\u0001\u0010\t\u001a\u00020\n2\b\b\u0001\u0010\u000b\u001a\u00020\fH'J(\u0010\r\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00010\b0\u00032\b\b\u0001\u0010\t\u001a\u00020\n2\b\b\u0001\u0010\u000b\u001a\u00020\fH'J<\u0010\u000e\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00010\b0\u00032\b\b\u0001\u0010\t\u001a\u00020\n2\b\b\u0001\u0010\u000b\u001a\u00020\f2\b\b\u0001\u0010\u000f\u001a\u00020\f2\b\b\u0001\u0010\u0010\u001a\u00020\nH'J\u0018\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00120\u00032\b\b\u0001\u0010\u0013\u001a\u00020\u0014H'¨\u0006\u0015"}, d2 = {"Lcom/bytedance/android/live/broadcastgame/opengame/message/ReviewApi;", "", "preUploadCheck", "Lio/reactivex/Observable;", "Lcom/bytedance/android/live/broadcastgame/opengame/message/UploadCheckRsp;", "preUploadCheckBean", "Lcom/bytedance/android/live/broadcastgame/opengame/message/PreUploadCheckBean;", "reportPanelHide", "Lcom/bytedance/android/live/network/response/Response;", "appId", "", "roomId", "", "reportPanelShow", "sendScreenShotAudit", "recallId", "auditList", "uploadFiles", "Lcom/bytedance/android/live/broadcastgame/opengame/message/UploadFileRsp;", "files", "Lokhttp3/RequestBody;", "livebroadcastgame-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface ReviewApi {
    @POST("/wsos_v2/webcast_interact_open/object_exists/")
    Observable<UploadCheckRsp> preUploadCheck(@Body PreUploadCheckBean r1);

    @PassOpenApiCheck
    @FormUrlEncoded
    @PbRequest("live_game")
    @POST("/webcast/openapi/panel/hide/")
    Observable<Response<Object>> reportPanelHide(@Field(OpenPlatformBaseDebugger.APP_ID) String r1, @Field("room_id") long r2);

    @PassOpenApiCheck
    @FormUrlEncoded
    @PbRequest("live_game")
    @POST("/webcast/openapi/panel/show/")
    Observable<Response<Object>> reportPanelShow(@Field(OpenPlatformBaseDebugger.APP_ID) String r1, @Field("room_id") long r2);

    @PassOpenApiCheck
    @FormUrlEncoded
    @PbRequest("live_game")
    @POST("/webcast/openapi/screenshot/audit/")
    Observable<Response<Object>> sendScreenShotAudit(@Field(OpenPlatformBaseDebugger.APP_ID) String r1, @Field("room_id") long r2, @Field("recall_id") long r4, @Field("audit_list") String r6);

    @Headers({"Content-Type:image/jpeg"})
    @POST("/wsos_v2/webcast_interact_open/upload/")
    Observable<UploadFileRsp> uploadFiles(@Body RequestBody r1);
}
