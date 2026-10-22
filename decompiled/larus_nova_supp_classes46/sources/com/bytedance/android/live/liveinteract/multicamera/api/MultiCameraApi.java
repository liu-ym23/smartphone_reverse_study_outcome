package com.bytedance.android.live.liveinteract.multicamera.api;

import cg0.a;
import com.bytedance.android.live.network.response.e;
import com.bytedance.android.livesdk.chatroom.model.multicamera.b;
import com.bytedance.retrofit2.http.Field;
import com.bytedance.retrofit2.http.FormUrlEncoded;
import com.bytedance.retrofit2.http.POST;
import io.reactivex.Single;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\bf\u0018\u00002\u00020\u0001J?\u0010\u000b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\b2\n\b\u0001\u0010\u0003\u001a\u0004\u0018\u00010\u00022\n\b\u0001\u0010\u0005\u001a\u0004\u0018\u00010\u00042\n\b\u0001\u0010\u0007\u001a\u0004\u0018\u00010\u0006H'¢\u0006\u0004\b\u000b\u0010\fJI\u0010\u000f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\b2\n\b\u0001\u0010\u0003\u001a\u0004\u0018\u00010\u00022\n\b\u0001\u0010\r\u001a\u0004\u0018\u00010\u00022\b\b\u0001\u0010\u000e\u001a\u00020\u00062\n\b\u0001\u0010\u0007\u001a\u0004\u0018\u00010\u0006H'¢\u0006\u0004\b\u000f\u0010\u0010¨\u0006\u0011"}, d2 = {"Lcom/bytedance/android/live/liveinteract/multicamera/api/MultiCameraApi;", "", "", "roomID", "Lcg0/a;", "camera", "", "bizScene", "Lio/reactivex/Single;", "Lcom/bytedance/android/live/network/response/e;", "Lcom/bytedance/android/livesdk/chatroom/model/multicamera/b;", "createCameraInfo", "(Ljava/lang/Long;Lcg0/a;Ljava/lang/Integer;)Lio/reactivex/Single;", "cameraId", "cameraStatus", "updateCameraInfo", "(Ljava/lang/Long;Ljava/lang/Long;ILjava/lang/Integer;)Lio/reactivex/Single;", "liveinteract-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface MultiCameraApi {
    @FormUrlEncoded
    @POST("/webcast/room/camera/create/")
    Single<e<b>> createCameraInfo(@Field("room_id") Long r1, @Field("camera") a r2, @Field("biz_scene") Integer r3);

    @FormUrlEncoded
    @POST("/webcast/room/camera/update_status/")
    Single<e<b>> updateCameraInfo(@Field("room_id") Long r1, @Field("camera_id") Long r2, @Field("camera_status") int r3, @Field("biz_scene") Integer r4);
}
