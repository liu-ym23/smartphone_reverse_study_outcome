package com.bytedance.android.livesdk.coupon;

import com.bytedance.android.live.network.response.Response;
import com.bytedance.retrofit2.http.GET;
import com.bytedance.retrofit2.http.Query;
import io.reactivex.Observable;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J<\u0010\f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n0\t2\b\b\u0001\u0010\u0003\u001a\u00020\u00022\b\b\u0001\u0010\u0005\u001a\u00020\u00042\b\b\u0001\u0010\u0007\u001a\u00020\u00062\b\b\u0001\u0010\b\u001a\u00020\u0006H'¨\u0006\r"}, d2 = {"Lcom/bytedance/android/livesdk/coupon/CommerceCouponApi;", "", "", "type", "", "roomId", "", "enterMethod", "enterFromMerge", "Lio/reactivex/Observable;", "Lcom/bytedance/android/live/network/response/Response;", "Lcom/bytedance/android/livesdk/coupon/b;", "getUgCouponData", "live-impl-saas_release"}, k = 1, mv = {1, 4, 3})
public interface CommerceCouponApi {
    @GET("/webcast/openapi/room/retain_popup_window/")
    Observable<Response<b>> getUgCouponData(@Query("window_type") int r1, @Query("room_id") long r2, @Query("enter_method") String r4, @Query("enter_from_merge") String r5);
}
