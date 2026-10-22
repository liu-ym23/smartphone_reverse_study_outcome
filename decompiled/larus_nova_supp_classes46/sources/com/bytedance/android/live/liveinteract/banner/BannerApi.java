package com.bytedance.android.live.liveinteract.banner;

import com.bytedance.android.live.network.annotation.PbRequest;
import com.bytedance.android.live.network.response.e;
import com.bytedance.retrofit2.http.GET;
import com.bytedance.retrofit2.http.Query;
import io.reactivex.Observable;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J2\u0010\n\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b0\u00072\b\b\u0001\u0010\u0003\u001a\u00020\u00022\b\b\u0001\u0010\u0005\u001a\u00020\u00042\b\b\u0001\u0010\u0006\u001a\u00020\u0004H'¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/live/liveinteract/banner/BannerApi;", "", "", "roomId", "", "activity_ids", "source", "Lio/reactivex/Observable;", "Lcom/bytedance/android/live/network/response/e;", "Lcom/bytedance/android/live/liveinteract/banner/KtvActivityLinkResponse;", "getActivityLinks", "liveinteract-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface BannerApi {
    @PbRequest(PbRequest.SwitchType.LINKMIC_AUDIENCE)
    @GET("/webcast/linkmic_audience/get_dynamic_activity_links/")
    Observable<e<KtvActivityLinkResponse>> getActivityLinks(@Query("room_id") long r1, @Query("activity_ids") String r3, @Query("source") String r4);
}
