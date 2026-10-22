package com.bytedance.android.livesdk.chatroom.vs.cache.historyprogress;

import com.bytedance.android.live.network.response.ListResponse;
import com.bytedance.android.live.network.response.Response;
import com.bytedance.android.livesdkapi.depend.model.live.episode.Episode;
import com.bytedance.retrofit2.http.Field;
import com.bytedance.retrofit2.http.FormUrlEncoded;
import com.bytedance.retrofit2.http.GET;
import com.bytedance.retrofit2.http.POST;
import com.bytedance.retrofit2.http.Query;
import com.bytedance.retrofit2.http.QueryMap;
import io.reactivex.Observable;
import java.util.HashMap;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0000\bf\u0018\u00002\u00020\u0001J)\u0010\u0002\u001a\u0012\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004\u0018\u00010\u00032\n\b\u0001\u0010\u0006\u001a\u0004\u0018\u00010\u0007H'¢\u0006\u0002\u0010\bJ[\u0010\t\u001a\u0012\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\n\u0018\u00010\u00032\n\b\u0001\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0001\u0010\u000b\u001a\u0004\u0018\u00010\u00072$\b\u0001\u0010\f\u001a\u001e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000e0\rj\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000e`\u000fH'¢\u0006\u0002\u0010\u0010J[\u0010\u0011\u001a\u0012\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\n\u0018\u00010\u00032\n\b\u0001\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0001\u0010\u0012\u001a\u0004\u0018\u00010\u00072$\b\u0001\u0010\f\u001a\u001e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000e0\rj\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000e`\u000fH'¢\u0006\u0002\u0010\u0010J.\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u00032\b\b\u0001\u0010\u0014\u001a\u00020\u000e2\b\b\u0001\u0010\u0006\u001a\u00020\u000e2\b\b\u0001\u0010\u0015\u001a\u00020\u0016H'¨\u0006\u0017"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/vs/cache/historyprogress/ProgressApi;", "", "getProgress", "Lio/reactivex/Observable;", "Lcom/bytedance/android/live/network/response/ListResponse;", "Lcom/bytedance/android/livesdkapi/depend/model/live/episode/Episode;", "episodeId", "", "(Ljava/lang/Long;)Lio/reactivex/Observable;", "leave", "Lcom/bytedance/android/live/network/response/Response;", "leaveLocation", "map", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "(Ljava/lang/Long;Ljava/lang/Long;Ljava/util/HashMap;)Lio/reactivex/Observable;", "ping", "watchLocation", "synPlayHistory", "seasonId", "seq", "", "vsmain-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface ProgressApi {
    @GET("/webcast/show/mget_episode/?scene=download_list_show_progress")
    Observable<ListResponse<Episode>> getProgress(@Query("episode_ids") Long r1);

    @GET("/webcast/show/episode/leave/")
    Observable<Response<Object>> leave(@Query("episode_id") Long r1, @Query("leave_location") Long r2, @QueryMap HashMap<String, String> r3);

    @GET("/webcast/show/ping/")
    Observable<Response<Object>> ping(@Query("episode_id") Long r1, @Query("watch_location") Long r2, @QueryMap HashMap<String, String> r3);

    @FormUrlEncoded
    @POST("/aweme/v1/format/submit/history/")
    Observable<Object> synPlayHistory(@Field("season_id") String r1, @Field("episode_id") String r2, @Field("seq") int r3);
}
