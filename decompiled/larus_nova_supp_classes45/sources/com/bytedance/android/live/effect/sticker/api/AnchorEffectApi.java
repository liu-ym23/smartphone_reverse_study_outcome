package com.bytedance.android.live.effect.sticker.api;

import com.bytedance.android.live.network.response.e;
import com.bytedance.retrofit2.http.GET;
import com.bytedance.retrofit2.http.Query;
import io.reactivex.Observable;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public interface AnchorEffectApi {
    @GET("/webcast/room/multi_anchor_effect/list/")
    Observable<e<com.bytedance.android.live.effect.sticker.api.model.a>> getMultiAnchorEffect(@Query("room_id") long r1);

    @GET("/webcast/room/multi_anchor_effect/update/")
    Observable<e<com.bytedance.android.live.effect.sticker.api.model.a>> updateMultiAnchorEffect(@Query("room_id") long r1, @Query("effect_id") String r3, @Query("status") int r4);
}
