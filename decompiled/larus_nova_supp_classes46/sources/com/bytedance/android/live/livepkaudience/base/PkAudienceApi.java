package com.bytedance.android.live.livepkaudience.base;

import com.bytedance.android.live.liveinteract.plantform.model.WaitingListResponse;
import com.bytedance.android.live.liveinteract.plantform.model.a1;
import com.bytedance.android.live.network.annotation.PbRequest;
import com.bytedance.android.live.network.response.Response;
import com.bytedance.retrofit2.http.GET;
import com.bytedance.retrofit2.http.Query;
import io.reactivex.Observable;
import io.reactivex.Single;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public interface PkAudienceApi {
    @GET("/webcast/linkmic_audience/list_friends/")
    Observable<Response<bl0.b>> getAnchorFriends(@Query("count") long r1);

    @GET("/webcast/linkmic_audience/invite_list/")
    Single<Response<a1>> getInviteList(@Query("room_id") long r1, @Query("type") int r3, @Query("kicked_users_unique_id") String r4);

    @PbRequest(PbRequest.SwitchType.LINKMIC_AUDIENCE)
    @GET("/webcast/linkmic_audience/waiting_list/")
    Single<com.bytedance.android.live.network.response.e<WaitingListResponse>> getLinkWaitingList(@Query("room_id") long r1, @Query("count") long r3, @Query("cursor") String r5);

    @GET("/webcast/linkmic_audience/waiting_list/")
    Single<Response<WaitingListResponse>> getLinkWaitingList(@Query("room_id") long r1, @Query("count") long r3, @Query("cursor") String r5, @Query("type") int r6, @Query("source") int r7);

    @GET("/webcast/linkmic_audience/invite_friend/")
    Single<Response<bl0.c>> inviteFriends(@Query("room_id") long r1, @Query("to_user_id_list") String r3, @Query("is_quick_invite") int r4, @Query("msg_board_item_id") long r5);

    @PbRequest(PbRequest.SwitchType.LINKMIC_AUDIENCE)
    @GET("/webcast/linkmic_audience/user_search/")
    Single<com.bytedance.android.live.network.response.e<com.bytedance.android.live.liveinteract.plantform.model.t>> userSearch(@Query("room_id") long r1, @Query("query_word") String r3, @Query("page") int r4);
}
