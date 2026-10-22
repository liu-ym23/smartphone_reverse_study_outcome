package com.bytedance.android.live.openplatform.impl.minigameaudience.api;

import com.bytedance.android.live.network.response.Response;
import com.bytedance.retrofit2.http.Field;
import com.bytedance.retrofit2.http.FormUrlEncoded;
import com.bytedance.retrofit2.http.GET;
import com.bytedance.retrofit2.http.POST;
import com.bytedance.retrofit2.http.Query;
import fr0.a;
import fr0.b;
import io.reactivex.Observable;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J(\u0010\t\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u00062\b\b\u0001\u0010\u0003\u001a\u00020\u00022\b\b\u0003\u0010\u0005\u001a\u00020\u0004H'J\"\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u00062\b\b\u0001\u0010\u0003\u001a\u00020\u00022\b\b\u0001\u0010\u000b\u001a\u00020\nH'J(\u0010\u0010\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\u00070\u00062\b\b\u0001\u0010\u0003\u001a\u00020\u00022\b\b\u0001\u0010\u000e\u001a\u00020\u0004H'¨\u0006\u0011"}, d2 = {"Lcom/bytedance/android/live/openplatform/impl/minigameaudience/api/MiniGameAudienceApi;", "", "", "roomId", "", "clientExtra", "Lio/reactivex/Observable;", "Lcom/bytedance/android/live/network/response/Response;", "Lfr0/b;", "getEntranceInfo", "", "liveSumType", "Lcom/bytedance/android/live/network/response/a;", "reportLiveSum", "mpId", "Lfr0/a;", "instantPlayGetProgress", "liveopenplatform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface MiniGameAudienceApi {
    @FormUrlEncoded
    @POST("/mgplatform/api/apps/live/entrance_info")
    Observable<Response<b>> getEntranceInfo(@Field("room_id") long r1, @Field("client_extra") String r3);

    @GET("/mgplatform/api/apps/live/instant_play/get_game_progress_info")
    Observable<Response<a>> instantPlayGetProgress(@Query("room_id") long r1, @Query("mp_id") String r3);

    @FormUrlEncoded
    @POST("/mgplatform/api/apps/live/live_sum")
    Observable<com.bytedance.android.live.network.response.a> reportLiveSum(@Field("room_id") long r1, @Field("live_sum_type") int r3);
}
