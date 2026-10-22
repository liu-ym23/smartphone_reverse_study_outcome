package com.bytedance.android.livesdk.interactivity.api.comment.video;

import com.bytedance.android.live.network.response.Response;
import com.bytedance.android.livesdk.chatroom.model.x3;
import com.bytedance.android.livesdk.interactivity.api.comment.data.g;
import com.bytedance.bdlocation.BuildConfig;
import com.bytedance.retrofit2.http.Field;
import com.bytedance.retrofit2.http.FormUrlEncoded;
import com.bytedance.retrofit2.http.GET;
import com.bytedance.retrofit2.http.POST;
import com.bytedance.retrofit2.http.Query;
import io.reactivex.Observable;
import io.reactivex.Single;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J<\u0010\u000b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\b2\b\b\u0001\u0010\u0003\u001a\u00020\u00022\b\b\u0001\u0010\u0004\u001a\u00020\u00022\b\b\u0001\u0010\u0005\u001a\u00020\u00022\b\b\u0001\u0010\u0007\u001a\u00020\u0006H'JX\u0010\u0015\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00140\t0\u00132\n\b\u0001\u0010\r\u001a\u0004\u0018\u00010\f2\n\b\u0001\u0010\u000e\u001a\u0004\u0018\u00010\f2\n\b\u0001\u0010\u000f\u001a\u0004\u0018\u00010\f2\b\b\u0001\u0010\u0010\u001a\u00020\u00022\b\b\u0001\u0010\u0011\u001a\u00020\u00062\n\b\u0001\u0010\u0012\u001a\u0004\u0018\u00010\fH'¨\u0006\u0016"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/api/comment/video/VideoApi;", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "roomId", "itemId", "itemType", BuildConfig.FLAVOR, "type", "Lio/reactivex/Observable;", "Lcom/bytedance/android/live/network/response/Response;", "Lcom/bytedance/android/livesdk/interactivity/api/comment/data/g;", "videoPinShare", BuildConfig.FLAVOR, "searchScene", "searchSource", "keyword", "offset", "count", "searchId", "Lio/reactivex/Single;", "Lcom/bytedance/android/livesdk/chatroom/model/x3;", "videoSearch", "interactivity-platform-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface VideoApi {
    @FormUrlEncoded
    @POST("/webcast/room/video_share/")
    Observable<Response<g>> videoPinShare(@Field("room_id") long r1, @Field("item_id") long r3, @Field("item_type") long r5, @Field("type") int r7);

    @GET("/webcast/room/video_search/")
    Single<Response<x3>> videoSearch(@Query("search_scene") String r1, @Query("search_source") String r2, @Query("keyword") String r3, @Query("offset") long r4, @Query("count") int r6, @Query("search_id") String r7);
}
