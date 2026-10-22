package com.bytedance.android.livesdk.coupon.api;

import com.bytedance.android.live.network.response.e;
import com.bytedance.android.livesdk.coupon.balancecoupon.model.b;
import com.bytedance.android.livesdk.coupon.balancecoupon.model.c;
import com.bytedance.retrofit2.http.Field;
import com.bytedance.retrofit2.http.FieldMap;
import com.bytedance.retrofit2.http.FormUrlEncoded;
import com.bytedance.retrofit2.http.GET;
import com.bytedance.retrofit2.http.POST;
import com.bytedance.retrofit2.http.Query;
import com.bytedance.retrofit2.http.QueryMap;
import io.reactivex.Observable;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public interface CouponApi {
    @FormUrlEncoded
    @POST("/webcast/openapi/room/user_benefit_popup/exchange/")
    Observable<e<b>> exchangeBenefitCoupon(@Field("room_id") long r1, @Field("anchor_open_id") String r3, @FieldMap Map<String, Object> r4);

    @GET("/webcast/openapi/room/user_benefit_popup/query/")
    Observable<e<c>> queryBenefitCoupon(@Query("room_id") long r1, @Query("anchor_open_id") String r3, @Query("benefit_type") int r4, @QueryMap Map<String, Object> r5);
}
