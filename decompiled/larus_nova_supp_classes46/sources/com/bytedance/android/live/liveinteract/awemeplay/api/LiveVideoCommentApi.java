package com.bytedance.android.live.liveinteract.awemeplay.api;

import com.bytedance.android.live.network.response.Response;
import com.bytedance.retrofit2.http.Field;
import com.bytedance.retrofit2.http.FormUrlEncoded;
import com.bytedance.retrofit2.http.GET;
import com.bytedance.retrofit2.http.POST;
import com.bytedance.retrofit2.http.Query;
import io.reactivex.Observable;
import kotlin.Metadata;
import sd0.b;
import sd0.c;
import sd0.d;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u001e\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u00042\b\b\u0001\u0010\u0003\u001a\u00020\u0002H'J]\u0010\u0012\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00110\u00050\u00042\b\b\u0001\u0010\t\u001a\u00020\b2\n\b\u0001\u0010\n\u001a\u0004\u0018\u00010\u00022\n\b\u0001\u0010\u000b\u001a\u0004\u0018\u00010\u00022\b\b\u0001\u0010\f\u001a\u00020\b2\b\b\u0001\u0010\u000e\u001a\u00020\r2\n\b\u0001\u0010\u0010\u001a\u0004\u0018\u00010\u000fH'¢\u0006\u0004\b\u0012\u0010\u0013J<\u0010\u0017\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00160\u00050\u00042\b\b\u0001\u0010\u0003\u001a\u00020\u00022\b\b\u0001\u0010\u0014\u001a\u00020\u00022\b\b\u0001\u0010\u0015\u001a\u00020\u00022\b\b\u0001\u0010\t\u001a\u00020\bH'¨\u0006\u0018"}, d2 = {"Lcom/bytedance/android/live/liveinteract/awemeplay/api/LiveVideoCommentApi;", "", "", "roomId", "Lio/reactivex/Observable;", "Lcom/bytedance/android/live/network/response/Response;", "Lsd0/d;", "videoTab", "", "type", "maxCursor", "minCursor", "count", "", "teenagerMode", "", "scene", "Lsd0/b;", "videoList", "(ILjava/lang/Long;Ljava/lang/Long;IZLjava/lang/String;)Lio/reactivex/Observable;", "itemId", "item_type", "Lsd0/c;", "videoShare", "liveinteract-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface LiveVideoCommentApi {
    @GET("/webcast/room/video_list/")
    Observable<Response<b>> videoList(@Query("type") int r1, @Query("max_cursor") Long r2, @Query("min_cursor") Long r3, @Query("count") int r4, @Query("teenager_mode") boolean r5, @Query("scene") String r6);

    @FormUrlEncoded
    @POST("/webcast/room/video_share/")
    Observable<Response<c>> videoShare(@Field("room_id") long r1, @Field("item_id") long r3, @Field("item_type") long r5, @Field("type") int r7);

    @GET("/webcast/room/video_tab/")
    Observable<Response<d>> videoTab(@Query("room_id") long r1);
}
