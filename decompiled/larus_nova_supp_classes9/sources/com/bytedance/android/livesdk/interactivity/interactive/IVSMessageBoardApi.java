package com.bytedance.android.livesdk.interactivity.interactive;

import com.bytedance.android.live.network.response.Response;
import com.bytedance.bdlocation.BuildConfig;
import com.bytedance.retrofit2.http.GET;
import com.bytedance.retrofit2.http.Query;
import io.reactivex.Observable;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J(\u0010\t\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u00062\b\b\u0001\u0010\u0003\u001a\u00020\u00022\b\b\u0001\u0010\u0005\u001a\u00020\u0004H'J(\u0010\u000b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\u00070\u00062\b\b\u0001\u0010\u0003\u001a\u00020\u00022\b\b\u0001\u0010\u0005\u001a\u00020\u0004H'J2\u0010\u000f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\u00070\u00062\b\b\u0001\u0010\f\u001a\u00020\u00022\b\b\u0001\u0010\u0003\u001a\u00020\u00022\b\b\u0001\u0010\r\u001a\u00020\u0004H'J<\u0010\u0013\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00120\u00070\u00062\b\b\u0001\u0010\u0003\u001a\u00020\u00022\b\b\u0001\u0010\u0010\u001a\u00020\u00022\b\b\u0001\u0010\f\u001a\u00020\u00022\b\b\u0001\u0010\u0011\u001a\u00020\u0004H'¨\u0006\u0014"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/interactive/IVSMessageBoardApi;", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "episodeId", BuildConfig.FLAVOR, "data", "Lio/reactivex/Observable;", "Lcom/bytedance/android/live/network/response/Response;", "Lcom/bytedance/android/livesdk/interactivity/interactive/VSMessageBoardCommentLikeResponseData;", "getCommentLikeList", "Lcom/bytedance/android/livesdk/interactivity/interactive/c1;", "createComment", "roomId", "anchorId", "Lcom/bytedance/android/livesdk/interactivity/interactive/d1;", "getSelfComment", "uid", "paidInfo", "Lcom/bytedance/android/livesdk/chatroom/msgboard/b;", "getInteractDressInfo", "vs-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface IVSMessageBoardApi {
    @GET("/webcast/activity/vs/interactive/create_comment/")
    Observable<Response<c1>> createComment(@Query("episode_id") long r1, @Query("data") String r3);

    @GET("/webcast/activity/vs/interactive/thumbup/")
    Observable<Response<VSMessageBoardCommentLikeResponseData>> getCommentLikeList(@Query("episode_id") long r1, @Query("data") String r3);

    @GET("/webcast/activity/vs/interactive/dress/")
    Observable<Response<com.bytedance.android.livesdk.chatroom.msgboard.b>> getInteractDressInfo(@Query("episode_id") long r1, @Query("uid") long r3, @Query("room_id") long r5, @Query("paid_info") String r7);

    @GET("/webcast/activity/vs/interactive/selfcomment/")
    Observable<Response<d1>> getSelfComment(@Query("room_id") long r1, @Query("episode_id") long r3, @Query("anchor_uid") String r5);
}
