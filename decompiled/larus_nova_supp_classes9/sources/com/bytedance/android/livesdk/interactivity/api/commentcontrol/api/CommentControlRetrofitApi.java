package com.bytedance.android.livesdk.interactivity.api.commentcontrol.api;

import com.bytedance.android.live.network.response.Response;
import com.bytedance.android.livesdk.interactivity.api.commentcontrol.model.a;
import com.bytedance.android.livesdk.interactivity.api.commentcontrol.model.b;
import com.bytedance.android.livesdk.interactivity.api.commentcontrol.model.c;
import com.bytedance.bdlocation.BuildConfig;
import com.bytedance.retrofit2.http.Field;
import com.bytedance.retrofit2.http.FormUrlEncoded;
import com.bytedance.retrofit2.http.GET;
import com.bytedance.retrofit2.http.POST;
import com.bytedance.retrofit2.http.Query;
import io.reactivex.Observable;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u001e\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u00042\b\b\u0001\u0010\u0003\u001a\u00020\u0002H'J(\u0010\n\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\u00050\u00042\b\b\u0001\u0010\u0003\u001a\u00020\u00022\b\b\u0001\u0010\b\u001a\u00020\u0002H'J2\u0010\r\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u00050\u00042\b\b\u0001\u0010\u0003\u001a\u00020\u00022\b\b\u0001\u0010\b\u001a\u00020\u00022\b\b\u0001\u0010\u000b\u001a\u00020\u0002H'¨\u0006\u000e"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/api/commentcontrol/api/CommentControlRetrofitApi;", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "roomId", "Lio/reactivex/Observable;", "Lcom/bytedance/android/live/network/response/Response;", "Lcom/bytedance/android/livesdk/interactivity/api/commentcontrol/model/b;", "getCommentControlStatusRequest", "commentControlLevel", "Lcom/bytedance/android/livesdk/interactivity/api/commentcontrol/model/a;", "getCommentControlMessageRequest", "status", "Lcom/bytedance/android/livesdk/interactivity/api/commentcontrol/model/c;", "updateCommentControlStatusRequest", "interactivity-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface CommentControlRetrofitApi {
    @GET("/webcast/interaction/get_comment_control_message/")
    Observable<Response<a>> getCommentControlMessageRequest(@Query("room_id") long r1, @Query("comment_control_level") long r3);

    @GET("/webcast/interaction/get_comment_control_status/")
    Observable<Response<b>> getCommentControlStatusRequest(@Query("room_id") long r1);

    @FormUrlEncoded
    @POST("/webcast/interaction/update_comment_control_status/")
    Observable<Response<c>> updateCommentControlStatusRequest(@Field("room_id") long r1, @Field("comment_control_level") long r3, @Field("status") long r5);
}
