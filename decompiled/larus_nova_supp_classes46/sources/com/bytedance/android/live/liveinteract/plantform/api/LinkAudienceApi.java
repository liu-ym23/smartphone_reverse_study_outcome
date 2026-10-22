package com.bytedance.android.live.liveinteract.plantform.api;

import com.bytedance.android.live.liveinteract.plantform.model.GetInfoBeforeAddPriceResponse;
import com.bytedance.android.live.network.annotation.PbRequest;
import com.bytedance.android.live.network.response.Response;
import com.bytedance.android.live.network.response.a;
import com.bytedance.android.live.network.response.e;
import com.bytedance.android.livesdk.chatroom.interact.model.v;
import com.bytedance.android.livesdk.chatroom.model.EnlargeGuestCloseResponse;
import com.bytedance.android.livesdk.chatroom.model.IApplyResult;
import com.bytedance.android.livesdk.chatroom.model.d1;
import com.bytedance.android.livesdk.chatroom.model.e1;
import com.bytedance.android.livesdk.chatroom.model.h1;
import com.bytedance.android.livesdk.chatroom.model.interact.m;
import com.bytedance.android.livesdk.chatroom.model.interact.q1;
import com.bytedance.android.livesdk.chatroom.model.interact.w;
import com.bytedance.android.livesdk.chatroom.model.interact.x;
import com.bytedance.android.livesdk.chatroom.model.r1;
import com.bytedance.android.livesdk.chatroom.model.t1;
import com.bytedance.android.livesdk.chatroom.model.y0;
import com.bytedance.android.livesdk.chatroom.model.z0;
import com.bytedance.android.livesdk.link.model.bridge.m0;
import com.bytedance.retrofit2.http.Field;
import com.bytedance.retrofit2.http.FieldMap;
import com.bytedance.retrofit2.http.FormUrlEncoded;
import com.bytedance.retrofit2.http.GET;
import com.bytedance.retrofit2.http.POST;
import com.bytedance.retrofit2.http.Query;
import com.bytedance.retrofit2.http.QueryMap;
import io.reactivex.Observable;
import io.reactivex.Single;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public interface LinkAudienceApi {
    @GET("/webcast/linkmic_audience/enlarge_guest_settings_update/")
    Single<a> UpdateEnlargeGuestSettings(@Query("room_id") long r1, @QueryMap Map<String, Object> r3);

    @FormUrlEncoded
    @PbRequest(PbRequest.SwitchType.LINKMIC_AUDIENCE)
    @POST("/webcast/linkmic_audience/apply/")
    Single<e<IApplyResult>> apply(@Field("room_id") long r1, @Field("anchor_id") String r3, @Field("anchor_open_id") String r4, @FieldMap Map<String, String> r5);

    @FormUrlEncoded
    @PbRequest(PbRequest.SwitchType.LINKMIC_AUDIENCE)
    @POST("/webcast/linkmic_audience/apply_callback/")
    Observable<a> applyCallbackReq(@Field("room_id") long r1, @Field("callback_type") int r3);

    @PbRequest(PbRequest.SwitchType.LINKMIC_AUDIENCE)
    @POST("/webcast/linkmic_audience/enlarge_guest/close/")
    Single<e<EnlargeGuestCloseResponse>> closeCPosition(@Query("room_id") long r1, @Query("kickout_uids_str") String r3, @Query("kickout_open_ids_str") String r4);

    @PbRequest(PbRequest.SwitchType.LINKMIC_AUDIENCE)
    @GET("/webcast/linkmic_audience/interact_entrance/")
    Observable<e<d1>> fetchInteractEntrances(@Query("room_id") long r1);

    @PbRequest(PbRequest.SwitchType.LINKMIC_AUDIENCE)
    @GET("/webcast/linkmic_audience/interact_entrance/")
    Observable<e<d1>> fetchInteractEntrances(@Query("room_id") long r1, @Query("to_user_id") long r3, @Query("to_open_id") String r5);

    @PbRequest(PbRequest.SwitchType.LINKMIC_AUDIENCE)
    @GET("/webcast/linkmic_audience/get_audience_settings/")
    Single<e<h1>> getAudienceSettings(@Query("keys") String r1, @Query("room_id") long r2);

    @GET("/webcast/linkmic_profit/get_info_before_add_price/")
    Single<e<GetInfoBeforeAddPriceResponse>> getInfoBeforeAddPrice(@Query("room_id") long r1, @Query("mode") int r3, @Query("expected_add_price_value") long r4);

    @GET("/webcast/linkmic_audience/get_latest_interact/")
    Single<e<w>> getLatestInteract(@Query("room_id") long r1);

    @PbRequest(PbRequest.SwitchType.LINKMIC_AUDIENCE)
    @GET("/webcast/linkmic_audience/get_user_waiting_offset/")
    Single<e<x>> getUserWaitingRankPosition(@Query("room_id") long r1, @Query("linker_id") long r3, @Query("scene") int r5, @Query("type") int r6);

    @GET("/webcast/linkmic_profit/normal_paid_linkmic_add_price/")
    Single<a> increasePriceApply(@Query("room_id") long r1, @Query("add_price_value") long r3, @Query("mode") int r5, @Query("now_paid_amount") long r6);

    @PbRequest(PbRequest.SwitchType.LINKMIC_AUDIENCE)
    @GET("/webcast/linkmic_audience/interact_list/")
    Single<e<e1>> interactList(@Query("room_id") long r1);

    @PbRequest(PbRequest.SwitchType.LINKMIC_AUDIENCE)
    @GET("/webcast/linkmic_audience/invite/")
    Observable<e<m0>> invite(@Query("room_id") long r1, @Query("sec_to_user_id") String r3, @Query("layout") int r4, @Query("position") int r5, @Query("teamfight_team_id") int r6, @Query("msg_board_item_id") long r7);

    @PbRequest(PbRequest.SwitchType.LINKMIC_AUDIENCE)
    @GET("/webcast/linkmic_audience/invite/")
    Observable<e<v>> invite(@Query("room_id") long r1, @Query("sec_to_user_id") String r3, @Query("to_user_id_list") String r4, @Query("layout") int r5, @Query("position") int r6, @Query("is_quick_invite") int r7, @Query("teamfight_team_id") int r8, @Query("msg_board_item_id") long r9, @Query("invite_source") int r11);

    @PbRequest(PbRequest.SwitchType.LINKMIC_AUDIENCE)
    @GET("/webcast/linkmic_audience/invite/")
    Observable<e<m0>> invite(@Query("room_id") long r1, @Query("sec_to_user_id") String r3, @Query("to_user_id") String r4, @Query("layout") int r5, @Query("position") int r6, @Query("teamfight_team_id") int r7, @Query("msg_board_item_id") long r8);

    @PbRequest(PbRequest.SwitchType.LINKMIC_AUDIENCE)
    @GET("/webcast/linkmic_audience/invite/")
    Observable<e<v>> invite(@Query("room_id") long r1, @Query("to_user_id") String r3, @Query("to_open_id") String r4, @Query("to_user_id_list") String r5, @Query("to_open_id_list") String r6, @Query("layout") int r7, @Query("position") int r8, @Query("is_quick_invite") int r9, @Query("teamfight_team_id") int r10, @Query("msg_board_item_id") long r11, @Query("invite_source") int r13);

    @PbRequest(PbRequest.SwitchType.LINKMIC_AUDIENCE)
    @GET("/webcast/linkmic_audience/notify_join_rtc/")
    Single<a> notifyJoinRtc(@Query("room_id") long r1, @Query("token") String r3);

    @FormUrlEncoded
    @PbRequest(PbRequest.SwitchType.LINKMIC_AUDIENCE)
    @POST("/webcast/linkmic_audience/prepare_apply/")
    Single<e<r1>> prepareApply(@Field("room_id") long r1, @Field("guest_supported_vendor") int r3, @Field("link_type") int r4, @Field("silence_status") int r5);

    @PbRequest(PbRequest.SwitchType.LINKMIC_AUDIENCE)
    @GET("/webcast/linkmic_audience/cancel_prepare_apply/")
    Single<a> prepareApplyCancel(@Query("room_id") long r1);

    @GET("/webcast/linkmic_audience/prepare_reply")
    Single<a> prepareReply(@Query("room_id") long r1, @Query("to_user_id") long r3, @Query("to_open_id") String r5, @Query("reply_type") int r6);

    @GET("/webcast/linkmic_audience/reject_unsilence/")
    Single<a> rejectUnsilence(@Query("room_id") long r1, @Query("to_user_id") long r3, @Query("to_open_id") String r5);

    @PbRequest(PbRequest.SwitchType.LINKMIC_AUDIENCE)
    @GET("/webcast/linkmic_audience/reply/")
    Observable<e<m>> reply(@Query("room_id") long r1, @Query("sec_to_user_id") String r3, @Query("reply_type") int r4, @Query("layout") int r5, @Query("link_type") int r6, @Query("user_distribution_source") String r7);

    @PbRequest(PbRequest.SwitchType.LINKMIC_AUDIENCE)
    @GET("/webcast/linkmic_audience/reply/")
    Observable<e<m>> reply(@Query("room_id") long r1, @Query("sec_to_user_id") String r3, @Query("to_user_id") String r4, @Query("to_open_id") String r5, @Query("reply_type") int r6, @Query("layout") int r7, @Query("link_type") int r8, @Query("user_distribution_source") String r9);

    @PbRequest(PbRequest.SwitchType.LINKMIC_AUDIENCE)
    @POST("/webcast/linkmic_audience/enlarge_guest/reply/")
    Single<e<z0>> replyCPosition(@Query("room_id") long r1, @Query("to_user_id") long r3, @Query("to_openid") String r5, @Query("reply_type") int r6);

    @PbRequest(PbRequest.SwitchType.LINKMIC_AUDIENCE)
    @POST("/webcast/linkmic_audience/enlarge_guest/invite/")
    Single<e<y0>> setCPosition(@Query("room_id") long r1, @Query("to_user_id") long r3, @Query("to_openid") String r5, @Query("invite_type") int r6, @Query("to_enlarge_pos") long r7);

    @FormUrlEncoded
    @POST("/webcast/linkmic_audience/show_guideline/")
    Single<e<q1>> showApplyPopupSuccess(@Field("room_id") long r1, @Field("guideline_type") long r3);

    @PbRequest(PbRequest.SwitchType.LINKMIC_AUDIENCE)
    @GET("/webcast/linkmic_audience/update_application_reason/")
    Single<a> updateApplyReason(@Query("room_id") long r1, @Query("scene") int r3, @Query("type") int r4, @Query("reason") String r5);

    @FormUrlEncoded
    @PbRequest(PbRequest.SwitchType.LINKMIC_AUDIENCE)
    @POST("/webcast/linkmic_audience/update_audience_settings/")
    Single<a> updateAudienceSettings(@Field("room_id") long r1, @Field("settings") String r3);

    @GET("/webcast/linkmic_profit/update_paid_queue_settings/")
    Single<Response<com.bytedance.android.live.liveinteract.plantform.model.z0>> updatePaidQueueSettings(@Query("room_id") long r1, @Query("open") boolean r3);

    @FormUrlEncoded
    @POST("/webcast/linkmic_profit/themed_competition/update_performer/")
    Single<e<t1>> updatePerformer(@Field("room_id") long r1, @Field("performer_user_id") long r3, @Field("performer_open_id") String r5, @Field("update_type") int r6);
}
