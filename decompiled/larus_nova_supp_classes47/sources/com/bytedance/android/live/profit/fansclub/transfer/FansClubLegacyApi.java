package com.bytedance.android.live.profit.fansclub.transfer;

import com.bytedance.android.live.profit.fansclub.r;
import com.bytedance.retrofit2.http.GET;
import com.bytedance.retrofit2.http.Query;
import io.reactivex.Observable;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public interface FansClubLegacyApi {
    @GET("https://lianmengapi.snssdk.com/ecom/fansclub/entrance/")
    Observable<r> queryShopFansClubMe(@Query("author_id") String r1, @Query("room_id") long r2, @Query("scene") int r4, @Query("join_source") int r5);
}
