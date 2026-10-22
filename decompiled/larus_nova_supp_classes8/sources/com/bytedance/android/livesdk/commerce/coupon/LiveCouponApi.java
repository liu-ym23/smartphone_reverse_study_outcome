package com.bytedance.android.livesdk.commerce.coupon;

import com.bytedance.retrofit2.http.FieldMap;
import com.bytedance.retrofit2.http.FormUrlEncoded;
import com.bytedance.retrofit2.http.GET;
import com.bytedance.retrofit2.http.POST;
import com.bytedance.retrofit2.http.Query;
import io.reactivex.Observable;
import java.util.Map;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\b\b\u0001\u0010\u0003\u001a\u00020\u0002H'J$\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\u00042\u0014\b\u0001\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b0\u0007H'ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\fÀ\u0006\u0001"}, d2 = {"Lcom/bytedance/android/livesdk/commerce/coupon/LiveCouponApi;", "", "", "roomId", "Lio/reactivex/Observable;", "Lcom/bytedance/android/livesdk/commerce/coupon/g;", "queryCurCouponInfo", "", "", "options", "Lcom/bytedance/android/livesdk/commerce/coupon/c;", "tryApplyCurCouponInfo", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface LiveCouponApi {
    @GET("https://lianmengapi.snssdk.com/live/coupon/getcurrent/")
    Observable<g> queryCurCouponInfo(@Query("room_id") long r1);

    @FormUrlEncoded
    @POST("https://lianmengapi.snssdk.com/live/coupon/apply/")
    Observable<c> tryApplyCurCouponInfo(@FieldMap Map<String, String> r1);
}
