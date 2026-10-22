package com.bytedance.android.live.liveinteract.api;

import com.bytedance.android.live.network.response.Response;
import com.bytedance.android.livesdk.rank.model.c;
import com.bytedance.retrofit2.http.GET;
import com.bytedance.retrofit2.http.Query;
import io.reactivex.Observable;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public interface LinkRankApi {
    @GET("/webcast/ranklist/linker/")
    Observable<Response<c>> getLinkerRankList(@Query("room_id") long r1, @Query("sec_anchor_id") String r3, @Query("sec_linker_user_id") String r4, @Query("anchor_open_id") String r5, @Query("linker_open_id") String r6, @Query("scene") long r7);
}
