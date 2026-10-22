package com.bytedance.android.livesdk.commerce;

import com.bytedance.android.live.base.model.feed.FeedExtra;
import com.bytedance.android.live.network.response.BaseListResponse;
import com.bytedance.android.live.network.response.Response;
import com.bytedance.android.livesdk.end.LiveEndPageData;
import com.bytedance.retrofit2.http.GET;
import com.bytedance.retrofit2.http.Query;
import com.bytedance.retrofit2.http.Url;
import io.reactivex.Observable;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001JL\u0010\r\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f0\n0\t2\b\b\u0001\u0010\u0003\u001a\u00020\u00022\b\b\u0001\u0010\u0005\u001a\u00020\u00042\b\b\u0001\u0010\u0006\u001a\u00020\u00042\b\b\u0001\u0010\u0007\u001a\u00020\u00042\b\b\u0001\u0010\b\u001a\u00020\u0002H'J(\u0010\u0010\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\u000e0\t2\b\b\u0001\u0010\u0003\u001a\u00020\u00022\b\b\u0001\u0010\u0005\u001a\u00020\u0004H'ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0011À\u0006\u0001"}, d2 = {"Lcom/bytedance/android/livesdk/commerce/LiveCommerceApi;", "", "", "url", "", "userId", "offset", LiveEndPageData.TAG_COUNT, "from", "Lio/reactivex/Observable;", "Lcom/bytedance/android/live/network/response/BaseListResponse;", "Lcom/bytedance/android/livesdk/commerce/d;", "Lcom/bytedance/android/live/base/model/feed/FeedExtra;", "fetchLiveCommerce", "Lcom/bytedance/android/live/network/response/Response;", "Lcom/bytedance/android/livesdk/commerce/h;", "fetchLiveGoodsUserStatus", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface LiveCommerceApi {
    @GET
    Observable<BaseListResponse<d, FeedExtra>> fetchLiveCommerce(@Url String r1, @Query("user_id") long r2, @Query("offset") long r4, @Query(LiveEndPageData.TAG_COUNT) long r6, @Query("from") String r8);

    @GET
    Observable<Response<h>> fetchLiveGoodsUserStatus(@Url String r1, @Query("user_id") long r2);
}
