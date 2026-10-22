package com.bytedance.android.live.liveinteract.voicechat.api;

import com.bytedance.android.live.liveinteract.chatroom.chatroom.model.FastMatchV2Response;
import com.bytedance.android.live.network.annotation.PbRequest;
import com.bytedance.android.live.network.response.e;
import com.bytedance.android.livesdk.chatroom.model.b1;
import com.bytedance.retrofit2.http.GET;
import com.bytedance.retrofit2.http.Query;
import io.reactivex.Single;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public interface ChatApi {
    @PbRequest(PbRequest.SwitchType.LINKMIC_AUDIENCE)
    @GET("/webcast/linkmic_audience/fast_match/")
    Single<e<b1>> fastMatch(@Query("room_id") long r1, @Query("anchor_id") long r3, @Query("anchor_open_id") String r5, @Query("is_manual") boolean r6, @Query("re_match") boolean r7, @Query("match_type") int r8);

    @GET("/webcast/linkmic_audience/fast_match_v2/")
    Single<e<FastMatchV2Response>> fastMatchV2(@Query("room_id") long r1, @Query("is_manual") boolean r3, @Query("re_match") boolean r4, @Query("match_type") int r5);
}
