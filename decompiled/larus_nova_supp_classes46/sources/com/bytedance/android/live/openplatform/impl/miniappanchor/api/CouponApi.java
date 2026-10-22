package com.bytedance.android.live.openplatform.impl.miniappanchor.api;

import com.bytedance.android.live.network.response.e;
import com.bytedance.android.live.openplatform.api.model.coupon.a;
import com.bytedance.retrofit2.http.GET;
import com.bytedance.retrofit2.http.Query;
import com.bytedance.retrofit2.http.Url;
import io.reactivex.Observable;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u001e\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u00042\b\b\u0001\u0010\u0003\u001a\u00020\u0002H'J(\u0010\n\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u00042\b\b\u0001\u0010\t\u001a\u00020\b2\b\b\u0001\u0010\u0003\u001a\u00020\u0002H'¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/live/openplatform/impl/miniappanchor/api/CouponApi;", "", "", "scene", "Lio/reactivex/Observable;", "Lcom/bytedance/android/live/network/response/e;", "Lcom/bytedance/android/live/openplatform/api/model/coupon/a;", "fetchSendCouponEntranceInfo", "", "url", "fetchSendCouponEntranceInfoBOE", "liveopenplatform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface CouponApi {
    @GET("/open/promotion/show_coupon_entrance/")
    Observable<e<a>> fetchSendCouponEntranceInfo(@Query("entrance_way") int r1);

    @GET
    Observable<e<a>> fetchSendCouponEntranceInfoBOE(@Url String r1, @Query("entrance_way") int r2);
}
