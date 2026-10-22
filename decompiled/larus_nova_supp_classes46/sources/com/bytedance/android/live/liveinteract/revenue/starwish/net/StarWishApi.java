package com.bytedance.android.live.liveinteract.revenue.starwish.net;

import com.bytedance.android.live.network.response.e;
import com.bytedance.retrofit2.http.GET;
import com.bytedance.retrofit2.http.POST;
import com.bytedance.retrofit2.http.Query;
import io.reactivex.Observable;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u001e\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u00042\b\b\u0001\u0010\u0003\u001a\u00020\u0002H'J2\u0010\f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\u00050\u00042\b\b\u0001\u0010\u0003\u001a\u00020\u00022\b\b\u0001\u0010\b\u001a\u00020\u00022\b\b\u0001\u0010\n\u001a\u00020\tH'¨\u0006\r"}, d2 = {"Lcom/bytedance/android/live/liveinteract/revenue/starwish/net/StarWishApi;", "", "", "roomId", "Lio/reactivex/Observable;", "Lcom/bytedance/android/live/network/response/e;", "Lcom/bytedance/android/live/liveinteract/revenue/starwish/net/a;", "getStarWishSettings", "targetScore", "", "anchorInvolved", "Lcom/bytedance/android/live/liveinteract/revenue/starwish/net/c;", "openStarWish", "liveinteract-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface StarWishApi {
    @GET("/webcast/linkmic_profit/get_starwish_setting/")
    Observable<e<a>> getStarWishSettings(@Query("room_id") long r1);

    @POST("/webcast/linkmic_profit/starwish_open/")
    Observable<e<c>> openStarWish(@Query("room_id") long r1, @Query("target_score") long r3, @Query("anchor_involved") boolean r5);
}
