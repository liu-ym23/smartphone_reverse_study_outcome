package com.bytedance.android.live.liveinteract.revenue.adventure.api;

import com.bytedance.android.live.network.response.e;
import com.bytedance.retrofit2.http.GET;
import com.bytedance.retrofit2.http.Query;
import io.reactivex.Single;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public interface AdventureApi {
    @GET("/webcast/linkmic_profit/adventure/invite/")
    Single<e<Object>> invite(@Query("room_id") long r1, @Query("to_user_id") long r3, @Query("to_open_id") String r5);
}
