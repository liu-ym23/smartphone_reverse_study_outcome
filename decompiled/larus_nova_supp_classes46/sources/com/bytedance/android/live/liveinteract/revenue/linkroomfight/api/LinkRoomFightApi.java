package com.bytedance.android.live.liveinteract.revenue.linkroomfight.api;

import com.bytedance.android.live.base.model.Extra;
import com.bytedance.android.live.network.response.ExtraResponse;
import com.bytedance.android.live.network.response.e;
import com.bytedance.android.livesdk.chatroom.model.interact.r2;
import com.bytedance.android.livesdk.chatroom.model.interact.w0;
import com.bytedance.android.livesdk.chatroom.model.interact.w2;
import com.bytedance.retrofit2.http.GET;
import com.bytedance.retrofit2.http.Query;
import io.reactivex.Observable;
import io.reactivex.Single;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000²\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J(\u0010\t\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u00062\b\b\u0001\u0010\u0003\u001a\u00020\u00022\b\b\u0001\u0010\u0005\u001a\u00020\u0004H'JL\u0010\u0011\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00100\u000e0\u00062\b\b\u0001\u0010\u0005\u001a\u00020\u00042\b\b\u0001\u0010\n\u001a\u00020\u00042\b\b\u0001\u0010\u000b\u001a\u00020\u00022\b\b\u0001\u0010\f\u001a\u00020\u00022\b\b\u0003\u0010\r\u001a\u00020\u0002H'J,\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00120\u00062\b\b\u0001\u0010\u000b\u001a\u00020\u00022\b\b\u0001\u0010\u0005\u001a\u00020\u00042\b\b\u0001\u0010\n\u001a\u00020\u0004H'JF\u0010\u0018\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00170\u00070\u00062\b\b\u0001\u0010\u0014\u001a\u00020\u00022\b\b\u0001\u0010\u000b\u001a\u00020\u00022\b\b\u0001\u0010\u0005\u001a\u00020\u00042\b\b\u0001\u0010\n\u001a\u00020\u00042\b\b\u0003\u0010\u0016\u001a\u00020\u0015H'JZ\u0010 \u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001f0\u00070\u00062\b\b\u0001\u0010\u000b\u001a\u00020\u00022\b\b\u0001\u0010\u0019\u001a\u00020\u00022\b\b\u0001\u0010\u001b\u001a\u00020\u001a2\b\b\u0001\u0010\u001c\u001a\u00020\u001a2\b\b\u0001\u0010\u001d\u001a\u00020\u00022\b\b\u0001\u0010\u001e\u001a\u00020\u00022\b\b\u0001\u0010\u0005\u001a\u00020\u0004H'J,\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00120\u00062\b\b\u0001\u0010!\u001a\u00020\u00022\b\b\u0001\u0010\u0005\u001a\u00020\u00042\b\b\u0001\u0010\n\u001a\u00020\u0004H'J@\u0010$\u001a\b\u0012\u0004\u0012\u00020\u00120\u00062\b\b\u0001\u0010\u0014\u001a\u00020\u00022\b\b\u0001\u0010!\u001a\u00020\u00022\b\b\u0001\u0010\u0005\u001a\u00020\u00042\b\b\u0001\u0010\n\u001a\u00020\u00042\b\b\u0003\u0010#\u001a\u00020\u0015H'J(\u0010'\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020&0\u00070\u00062\b\b\u0001\u0010%\u001a\u00020\u00042\b\b\u0001\u0010!\u001a\u00020\u0002H'J2\u0010+\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020*0\u00070\u00062\b\b\u0001\u0010%\u001a\u00020\u00042\b\b\u0001\u0010(\u001a\u00020\u00022\b\b\u0001\u0010)\u001a\u00020\u0002H'J2\u0010/\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020.0\u00070\u00062\b\b\u0001\u0010,\u001a\u00020\u00042\b\b\u0003\u0010-\u001a\u00020\u00042\b\b\u0001\u0010%\u001a\u00020\u0004H'JB\u00108\u001a\u001a\u0012\u0016\u0012\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020605\u0012\u0004\u0012\u00020704032\n\b\u0001\u00100\u001a\u0004\u0018\u00010\u001a2\b\b\u0001\u00101\u001a\u00020\u00042\n\b\u0001\u00102\u001a\u0004\u0018\u00010\u001aH'Jl\u0010@\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020?0\u0007032\n\b\u0001\u00109\u001a\u0004\u0018\u00010\u001a2\b\b\u0001\u0010,\u001a\u00020\u00022\b\b\u0001\u0010-\u001a\u00020\u00022\n\b\u0001\u0010:\u001a\u0004\u0018\u00010\u001a2\n\b\u0001\u0010;\u001a\u0004\u0018\u00010\u001a2\b\b\u0001\u0010<\u001a\u00020\u00022\b\b\u0001\u0010=\u001a\u00020\u00042\n\b\u0001\u0010>\u001a\u0004\u0018\u00010\u001aH'J\"\u0010B\u001a\b\u0012\u0004\u0012\u00020\u0012032\b\b\u0001\u0010%\u001a\u00020\u00042\b\b\u0001\u0010A\u001a\u00020\u001aH'J(\u0010E\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020D0\u0007032\b\b\u0001\u0010%\u001a\u00020\u00042\b\b\u0003\u0010C\u001a\u00020\u0002H'J(\u0010G\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020F0\u0007032\b\b\u0001\u0010%\u001a\u00020\u00042\b\b\u0003\u0010C\u001a\u00020\u0002H'J(\u0010I\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020H0\u0007032\b\b\u0001\u0010%\u001a\u00020\u00042\b\b\u0003\u0010C\u001a\u00020\u0002H'J2\u0010L\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020K0\u0007032\b\b\u0001\u0010%\u001a\u00020\u00042\b\b\u0001\u0010J\u001a\u00020\u00022\b\b\u0003\u0010C\u001a\u00020\u0002H'J(\u0010N\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020M0\u0007032\b\b\u0001\u0010%\u001a\u00020\u00042\b\b\u0003\u0010C\u001a\u00020\u0002H'¨\u0006O"}, d2 = {"Lcom/bytedance/android/live/liveinteract/revenue/linkroomfight/api/LinkRoomFightApi;", "", "", "inviteType", "", "selfRoomId", "Lio/reactivex/Single;", "Lcom/bytedance/android/live/network/response/e;", "Lcom/bytedance/android/live/liveinteract/revenue/linkroomfight/api/LinkRoomFightFetchListResult;", "fetchList", "targetRoomId", "crossType", "inviteSource", "inviteeStatus", "Lcom/bytedance/android/live/network/response/ExtraResponse;", "Lcom/bytedance/android/live/liveinteract/revenue/linkroomfight/api/LinkRoomFightInviteResult;", "Lcom/bytedance/android/live/liveinteract/revenue/linkroomfight/api/LinkRoomFightInviteResultExtra;", "invite", "Lcom/bytedance/android/live/network/response/a;", "cancelInvite", "replyType", "", "autoRefuseThisInviter", "Lcom/bytedance/android/live/liveinteract/revenue/linkroomfight/api/LinkRoomFightReplyResult;", "reply", "selectType", "", "userIds", "openIds", "toScene", "toUiLayout", "Lcom/bytedance/android/live/liveinteract/revenue/linkroomfight/api/LinkRoomFightSelectGuestsResult;", "selectGuests", "startType", "inviteRoomBattle", "autoRefuseThisUser", "replyRoomBattle", "roomId", "Lcom/bytedance/android/live/liveinteract/revenue/linkroomfight/api/LinkRoomFightCreateRoomBattleResult;", "createRoomBattle", "finishType", "finishReason", "Lcom/bytedance/android/live/liveinteract/revenue/linkroomfight/api/a;", "finishRoomBattle", "offset", "count", "Lcom/bytedance/android/live/liveinteract/revenue/linkroomfight/api/LinkRoomFightRecordResult;", "getLinkRoomFightRecord", "channel", "businessId", "editWord", "Lio/reactivex/Observable;", "Lcom/bytedance/android/livesdk/chatroom/model/interact/w2;", "", "Lcom/bytedance/android/livesdk/chatroom/model/interact/r2;", "Lcom/bytedance/android/live/base/model/Extra;", "searchRivalsHint", "queryWord", "searchId", "activityName", "searchScene", "anchorId", "anchorIdString", "Lcom/bytedance/android/livesdk/chatroom/model/interact/w0;", "searchRivals", "content", "updateRoomBattleSettings", "matchType", "Lcom/bytedance/android/live/liveinteract/revenue/linkroomfight/api/GetRoomBattleMatchInfoResponse;", "getRandomMatchInfo", "Lcom/bytedance/android/live/liveinteract/revenue/linkroomfight/api/RoomBattleMatchReserveResponse;", "randomReserve", "Lcom/bytedance/android/live/liveinteract/revenue/linkroomfight/api/RoomBattleMatchCancelReserveResponse;", "cancelRandomReserve", "status", "Lcom/bytedance/android/live/liveinteract/revenue/linkroomfight/api/RoomBattleMatchResponse;", "randomMatch", "Lcom/bytedance/android/live/liveinteract/revenue/linkroomfight/api/RoomBattleCancelMatchResponse;", "randomMatchCancel", "liveinteract-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface LinkRoomFightApi {
    @GET("/webcast/linkmic_audience/cancel_invite_cross_room_link/")
    Single<com.bytedance.android.live.network.response.a> cancelInvite(@Query("cross_type") int r1, @Query("canceller_room_id") long r2, @Query("cancellee_room_id") long r4);

    @GET("/webcast/linkmic_profit/room_battle_match_cancel_reserve/")
    Observable<e<RoomBattleMatchCancelReserveResponse>> cancelRandomReserve(@Query("room_id") long r1, @Query("match_type") int r3);

    @GET("/webcast/linkmic_profit/create_room_battle/")
    Single<e<LinkRoomFightCreateRoomBattleResult>> createRoomBattle(@Query("room_id") long r1, @Query("start_type") int r3);

    @GET("/webcast/linkmic_audience/invite_cross_room_link_list/")
    Single<e<LinkRoomFightFetchListResult>> fetchList(@Query("invite_type") int r1, @Query("room_id") long r2);

    @GET("/webcast/linkmic_profit/finish_room_battle/")
    Single<e<a>> finishRoomBattle(@Query("room_id") long r1, @Query("finish_type") int r3, @Query("finish_teamfight_reason") int r4);

    @GET("/webcast/linkmic_profit/list_room_battle_record/")
    Single<e<LinkRoomFightRecordResult>> getLinkRoomFightRecord(@Query("offset") long r1, @Query("count") long r3, @Query("room_id") long r5);

    @GET("/webcast/linkmic_profit/get_room_battle_match_info/")
    Observable<e<GetRoomBattleMatchInfoResponse>> getRandomMatchInfo(@Query("room_id") long r1, @Query("match_type") int r3);

    @GET("/webcast/linkmic_audience/invite_cross_room_link/")
    Single<ExtraResponse<LinkRoomFightInviteResult, LinkRoomFightInviteResultExtra>> invite(@Query("inviter_room_id") long r1, @Query("invitee_room_id") long r3, @Query("cross_type") int r5, @Query("invite_source") int r6, @Query("invitee_status") int r7);

    @GET("/webcast/linkmic_profit/invite_room_battle/")
    Single<com.bytedance.android.live.network.response.a> inviteRoomBattle(@Query("start_type") int r1, @Query("inviter_room_id") long r2, @Query("invitee_room_id") long r4);

    @GET("/webcast/linkmic_profit/room_battle_match/")
    Observable<e<RoomBattleMatchResponse>> randomMatch(@Query("room_id") long r1, @Query("status") int r3, @Query("match_type") int r4);

    @GET("/webcast/linkmic_profit/room_battle_cancel_match/")
    Observable<e<RoomBattleCancelMatchResponse>> randomMatchCancel(@Query("room_id") long r1, @Query("match_type") int r3);

    @GET("/webcast/linkmic_profit/room_battle_match_reserve/")
    Observable<e<RoomBattleMatchReserveResponse>> randomReserve(@Query("room_id") long r1, @Query("match_type") int r3);

    @GET("/webcast/linkmic_audience/reply_cross_room_link/")
    Single<e<LinkRoomFightReplyResult>> reply(@Query("reply_type") int r1, @Query("cross_type") int r2, @Query("invitee_room_id") long r3, @Query("inviter_room_id") long r5, @Query("auto_refuse_this_inviter") boolean r7);

    @GET("/webcast/linkmic_profit/reply_room_battle/")
    Single<com.bytedance.android.live.network.response.a> replyRoomBattle(@Query("reply_type") int r1, @Query("start_type") int r2, @Query("invitee_room_id") long r3, @Query("inviter_room_id") long r5, @Query("auto_refuse_this_inviter") boolean r7);

    @GET("/webcast/linkmic/rivals/search/")
    Observable<e<w0>> searchRivals(@Query("query_word") String r1, @Query("offset") int r2, @Query("count") int r3, @Query("search_id") String r4, @Query("activity_name") String r5, @Query("search_scene") int r6, @Query("anchor_id") long r7, @Query("anchor_openid") String r9);

    @GET("https://i.snssdk.com/api/suggest_words/")
    Observable<w2<List<r2>, Extra>> searchRivalsHint(@Query("pd") String r1, @Query("business_id") long r2, @Query("query") String r4);

    @GET("/webcast/linkmic_audience/select_guests/")
    Single<e<LinkRoomFightSelectGuestsResult>> selectGuests(@Query("cross_type") int r1, @Query("select_type") int r2, @Query("user_ids") String r3, @Query("open_ids") String r4, @Query("to_scene") int r5, @Query("to_ui_layout") int r6, @Query("room_id") long r7);

    @GET("/webcast/linkmic_profit/update_room_battle_settings/")
    Observable<com.bytedance.android.live.network.response.a> updateRoomBattleSettings(@Query("room_id") long r1, @Query("content") String r3);
}
