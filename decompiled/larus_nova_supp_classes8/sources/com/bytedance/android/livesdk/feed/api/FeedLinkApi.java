package com.bytedance.android.livesdk.feed.api;

import com.bytedance.android.live.liveinteract.plantform.model.a1;
import com.bytedance.android.live.liveinteract.plantform.model.w0;
import com.bytedance.android.live.network.annotation.PbRequest;
import com.bytedance.android.live.network.response.e;
import com.bytedance.retrofit2.http.GET;
import com.bytedance.retrofit2.http.Query;
import io.reactivex.Single;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public interface FeedLinkApi {
    @PbRequest("linkmic_audience")
    @GET("/webcast/linkmic_audience/list/v2/")
    Single<e<w0>> getLinkListV2(@Query("room_id") long r1, @Query("anchor_id") long r3, @Query("need_follow_info") boolean r5);

    @PbRequest("linkmic_audience")
    @GET("/webcast/linkmic_audience/list/v2/")
    Single<e<w0>> getLinkListV2(@Query("room_id") long r1, @Query("anchor_id") String r3);

    @PbRequest("linkmic_audience")
    @GET("/webcast/linkmic_audience/list/")
    Single<e<a1>> getList(@Query("room_id") long r1, @Query("anchor_id") String r3, @Query("link_status") int r4, @Query("link_type") int r5);
}
