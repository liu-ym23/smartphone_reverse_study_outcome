package com.bytedance.android.live.liveinteract.linkpanel.api;

import com.bytedance.android.live.liveinteract.linkpanel.model.InteractiveScreenCastCloseResponse;
import com.bytedance.android.live.liveinteract.linkpanel.model.InviteFriendsBody;
import com.bytedance.android.live.liveinteract.plantform.model.a1;
import com.bytedance.android.live.liveinteract.plantform.model.j;
import com.bytedance.android.live.liveinteract.plantform.model.l0;
import com.bytedance.android.live.liveinteract.plantform.model.m0;
import com.bytedance.android.live.liveinteract.plantform.model.s;
import com.bytedance.android.live.liveinteract.plantform.model.t;
import com.bytedance.android.live.liveinteract.plantform.model.w0;
import com.bytedance.android.live.network.annotation.PbRequest;
import com.bytedance.android.live.network.response.Response;
import com.bytedance.android.live.network.response.e;
import com.bytedance.android.livesdk.chatroom.model.PrepareInviteResponse;
import com.bytedance.retrofit2.http.GET;
import com.bytedance.retrofit2.http.Query;
import io.reactivex.Observable;
import io.reactivex.Single;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000 \u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J,\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\b\b\u0001\u0010\u0003\u001a\u00020\u00022\b\b\u0001\u0010\u0004\u001a\u00020\u00022\b\b\u0001\u0010\u0006\u001a\u00020\u0005H'J@\u0010\u000f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\r0\u00072\b\b\u0001\u0010\u0003\u001a\u00020\u00022\b\b\u0001\u0010\n\u001a\u00020\u00022\n\b\u0001\u0010\u000b\u001a\u0004\u0018\u00010\u00052\n\b\u0001\u0010\f\u001a\u0004\u0018\u00010\u0005H'J\u001e\u0010\u0012\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00110\r0\u00072\b\b\u0001\u0010\u0010\u001a\u00020\u0002H'J*\u0010\u0017\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00160\r0\u00152\b\b\u0001\u0010\u0013\u001a\u00020\u00022\n\b\u0001\u0010\u0014\u001a\u0004\u0018\u00010\u0005H'J\u008a\u0001\u0010$\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020#0\r0\u00152\b\b\u0001\u0010\u0003\u001a\u00020\u00022\b\b\u0001\u0010\u0018\u001a\u00020\u00022\n\b\u0001\u0010\u0019\u001a\u0004\u0018\u00010\u00052\b\b\u0001\u0010\u001b\u001a\u00020\u001a2\b\b\u0001\u0010\u001c\u001a\u00020\u001a2\b\b\u0001\u0010\u0010\u001a\u00020\u00022\b\b\u0001\u0010\u001e\u001a\u00020\u001d2\n\b\u0001\u0010\u001f\u001a\u0004\u0018\u00010\u00052\b\b\u0001\u0010 \u001a\u00020\u00022\n\b\u0001\u0010!\u001a\u0004\u0018\u00010\u00052\n\b\u0001\u0010\"\u001a\u0004\u0018\u00010\u0005H'JR\u0010%\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020#0\r0\u00152\b\b\u0001\u0010\u0003\u001a\u00020\u00022\n\b\u0001\u0010\u0019\u001a\u0004\u0018\u00010\u00052\b\b\u0001\u0010\u0018\u001a\u00020\u00022\b\b\u0001\u0010\u001b\u001a\u00020\u001a2\b\b\u0001\u0010\u001c\u001a\u00020\u001a2\b\b\u0001\u0010\u001e\u001a\u00020\u001dH'J^\u0010%\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020#0\r0\u00152\b\b\u0001\u0010\u0003\u001a\u00020\u00022\n\b\u0001\u0010\u0019\u001a\u0004\u0018\u00010\u00052\b\b\u0001\u0010\u0018\u001a\u00020\u00022\b\b\u0001\u0010\u001b\u001a\u00020\u001a2\b\b\u0001\u0010\u001c\u001a\u00020\u001a2\b\b\u0001\u0010\u001e\u001a\u00020\u001d2\n\b\u0001\u0010\"\u001a\u0004\u0018\u00010\u0005H'J4\u0010'\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020&0\r0\u00152\b\b\u0001\u0010\u0003\u001a\u00020\u00022\b\b\u0001\u0010\u0018\u001a\u00020\u00022\n\b\u0001\u0010\u0019\u001a\u0004\u0018\u00010\u0005H'J2\u0010'\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020&0\r0\u00152\b\b\u0001\u0010\u0003\u001a\u00020\u00022\b\b\u0001\u0010\u0018\u001a\u00020\u00022\b\b\u0001\u0010(\u001a\u00020\u001dH'JF\u0010'\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020&0\r0\u00152\b\b\u0001\u0010\u0003\u001a\u00020\u00022\b\b\u0001\u0010\u0018\u001a\u00020\u00022\b\b\u0001\u0010\u0019\u001a\u00020\u00052\b\b\u0001\u0010(\u001a\u00020\u001d2\b\b\u0001\u0010)\u001a\u00020\u001dH'J4\u0010+\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020*0\r0\u00152\b\b\u0001\u0010\u0003\u001a\u00020\u00022\b\b\u0001\u0010\u0010\u001a\u00020\u00022\n\b\u0001\u0010!\u001a\u0004\u0018\u00010\u0005H'JH\u0010+\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020*0\r0\u00152\b\b\u0001\u0010\u0003\u001a\u00020\u00022\b\b\u0001\u0010\u0010\u001a\u00020\u00022\n\b\u0001\u0010!\u001a\u0004\u0018\u00010\u00052\b\b\u0001\u0010\u001c\u001a\u00020\u001a2\b\b\u0001\u0010\f\u001a\u00020\u001aH'J\u001e\u0010-\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020,0\r0\u00152\b\b\u0001\u0010\u0003\u001a\u00020\u0002H'J\u001e\u0010/\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020.0\r0\u00152\b\b\u0001\u0010\u0003\u001a\u00020\u0002H'JF\u00105\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002040\r0\u00152\b\b\u0001\u0010\u0003\u001a\u00020\u00022\b\b\u0001\u00100\u001a\u00020\u00022\b\b\u0001\u00101\u001a\u00020\u00052\b\b\u0001\u00102\u001a\u00020\u00022\b\b\u0001\u00103\u001a\u00020\u0005H'JF\u00108\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u00152\b\b\u0001\u0010\u0003\u001a\u00020\u00022\b\b\u0001\u00100\u001a\u00020\u00022\n\b\u0001\u00106\u001a\u0004\u0018\u00010\u00052\b\b\u0001\u00102\u001a\u00020\u00022\n\b\u0001\u00107\u001a\u0004\u0018\u00010\u0005H'J(\u00109\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020#0\r0\u00152\b\b\u0001\u0010\u0003\u001a\u00020\u00022\b\b\u0001\u0010\u001c\u001a\u00020\u001aH'J2\u00109\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020#0\r0\u00152\b\b\u0001\u0010\u0003\u001a\u00020\u00022\b\b\u0001\u0010\u001c\u001a\u00020\u001a2\b\b\u0001\u0010\u0010\u001a\u00020\u0002H'J>\u0010>\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020=0\r0\u00152\b\b\u0001\u0010\u0003\u001a\u00020\u00022\n\b\u0001\u0010:\u001a\u0004\u0018\u00010\u00052\b\b\u0001\u0010;\u001a\u00020\u001a2\b\b\u0001\u0010<\u001a\u00020\u0002H'J\u0018\u0010?\u001a\b\u0012\u0004\u0012\u00020\b0\u00152\b\b\u0001\u0010\u0003\u001a\u00020\u0002H'J>\u0010E\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020D0C0\u00152\b\b\u0001\u0010\u0003\u001a\u00020\u00022\n\b\u0001\u0010@\u001a\u0004\u0018\u00010\u00052\b\b\u0001\u0010A\u001a\u00020\u001a2\b\b\u0001\u0010B\u001a\u00020\u001aH'J4\u0010G\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020F0C0\u00152\b\b\u0001\u0010\u0003\u001a\u00020\u00022\n\b\u0001\u0010@\u001a\u0004\u0018\u00010\u00052\b\b\u0001\u0010A\u001a\u00020\u001aH'J4\u0010K\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020J0\r0\u00152\b\b\u0001\u0010\u0003\u001a\u00020\u00022\n\b\u0001\u0010H\u001a\u0004\u0018\u00010\u00052\b\b\u0001\u0010I\u001a\u00020\u001aH'¨\u0006L"}, d2 = {"Lcom/bytedance/android/live/liveinteract/linkpanel/api/LinkAnchorApi;", "", "", "roomId", "applyUserId", "", "applyUserIdString", "Lio/reactivex/Observable;", "Lcom/bytedance/android/live/network/response/a;", "permitPreApply", "toUserId", "toUserIdString", "source", "Lcom/bytedance/android/live/network/response/e;", "Lcom/bytedance/android/livesdk/chatroom/model/PrepareInviteResponse;", "prepareInvite", "count", "Lcom/bytedance/android/live/liveinteract/linkpanel/model/a;", "getAnchorFriends", "room_id", "word", "Lio/reactivex/Single;", "Lcom/bytedance/android/live/liveinteract/plantform/model/j;", "searchInvite", "anchorId", "anchorOpenId", "", "status", "type", "", "enablePagination", "extra", "modifyTimeAfter", "cursor", "requestSource", "Lcom/bytedance/android/live/liveinteract/plantform/model/a1;", "getPageList", "getAllList", "Lcom/bytedance/android/live/liveinteract/plantform/model/w0;", "getLinkListV2", "needFollowInfo", "isOChannelRoom", "Lcom/bytedance/android/live/liveinteract/plantform/model/m0;", "getLinkWaitingList", "Lcom/bytedance/android/live/liveinteract/plantform/model/a;", "sendLinkCall", "Lcom/bytedance/android/live/liveinteract/plantform/model/s;", "getPairUserList", "guestId", "openGuestId", "investorId", "investorIdStr", "Lcom/bytedance/android/live/liveinteract/plantform/model/l0;", "updatePairUser", "guestIdString", "investorIdString", "openPair", "getInviteList", "uidList", "quickInvite", "msgBoardItemId", "Lcom/bytedance/android/live/liveinteract/linkpanel/model/InviteFriendsBody;", "inviteFriends", "closePaidLinkGuide", "appId", "itemType", "profile", "Lcom/bytedance/android/live/network/response/Response;", "Lcom/bytedance/android/live/liveinteract/linkpanel/model/b;", "startLinkCast", "Lcom/bytedance/android/live/liveinteract/linkpanel/model/InteractiveScreenCastCloseResponse;", "stopLinkCast", "query", "page", "Lcom/bytedance/android/live/liveinteract/plantform/model/t;", "userSearch", "multilink-business-platform_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface LinkAnchorApi {
    @GET("/webcast/linkmic_profit/close_paid_linkmic_guide/")
    Single<com.bytedance.android.live.network.response.a> closePaidLinkGuide(@Query("room_id") long r1);

    @PbRequest(PbRequest.SwitchType.LINKMIC_AUDIENCE)
    @GET("/webcast/linkmic_audience/list/")
    Single<e<a1>> getAllList(@Query("room_id") long r1, @Query("anchor_open_id") String r3, @Query("anchor_id") long r4, @Query("link_status") int r6, @Query("link_type") int r7, @Query("enable_pagination") boolean r8);

    @PbRequest(PbRequest.SwitchType.LINKMIC_AUDIENCE)
    @GET("/webcast/linkmic_audience/list/")
    Single<e<a1>> getAllList(@Query("room_id") long r1, @Query("anchor_open_id") String r3, @Query("anchor_id") long r4, @Query("link_status") int r6, @Query("link_type") int r7, @Query("enable_pagination") boolean r8, @Query("request_source") String r9);

    @PbRequest(PbRequest.SwitchType.LINKMIC_AUDIENCE)
    @GET("/webcast/linkmic_audience/list_friends/")
    Observable<e<com.bytedance.android.live.liveinteract.linkpanel.model.a>> getAnchorFriends(@Query("count") long r1);

    @PbRequest(PbRequest.SwitchType.LINKMIC_AUDIENCE)
    @GET("/webcast/linkmic_audience/invite_list/")
    Single<e<a1>> getInviteList(@Query("room_id") long r1, @Query("type") int r3);

    @PbRequest(PbRequest.SwitchType.LINKMIC_AUDIENCE)
    @GET("/webcast/linkmic_audience/invite_list/")
    Single<e<a1>> getInviteList(@Query("room_id") long r1, @Query("type") int r3, @Query("count") long r4);

    @PbRequest(PbRequest.SwitchType.LINKMIC_AUDIENCE)
    @GET("/webcast/linkmic_audience/list/v2/")
    Single<e<w0>> getLinkListV2(@Query("room_id") long r1, @Query("anchor_id") long r3, @Query("anchor_open_id") String r5);

    @PbRequest(PbRequest.SwitchType.LINKMIC_AUDIENCE)
    @GET("/webcast/linkmic_audience/list/v2/")
    Single<e<w0>> getLinkListV2(@Query("room_id") long r1, @Query("anchor_id") long r3, @Query("anchor_open_id") String r5, @Query("need_follow_info") boolean r6, @Query("is_ochannel_room") boolean r7);

    @PbRequest(PbRequest.SwitchType.LINKMIC_AUDIENCE)
    @GET("/webcast/linkmic_audience/list/v2/")
    Single<e<w0>> getLinkListV2(@Query("room_id") long r1, @Query("anchor_id") long r3, @Query("need_follow_info") boolean r5);

    @PbRequest(PbRequest.SwitchType.LINKMIC_AUDIENCE)
    @GET("/webcast/linkmic_audience/waiting_list/")
    Single<e<m0>> getLinkWaitingList(@Query("room_id") long r1, @Query("count") long r3, @Query("cursor") String r5);

    @PbRequest(PbRequest.SwitchType.LINKMIC_AUDIENCE)
    @GET("/webcast/linkmic_audience/waiting_list/")
    Single<e<m0>> getLinkWaitingList(@Query("room_id") long r1, @Query("count") long r3, @Query("cursor") String r5, @Query("type") int r6, @Query("source") int r7);

    @PbRequest(PbRequest.SwitchType.LINKMIC_AUDIENCE)
    @GET("/webcast/linkmic_audience/list/")
    Single<e<a1>> getPageList(@Query("room_id") long r1, @Query("anchor_id") long r3, @Query("anchor_open_id") String r5, @Query("link_status") int r6, @Query("link_type") int r7, @Query("count") long r8, @Query("enable_pagination") boolean r10, @Query("extra") String r11, @Query("modify_time_after_in_nano") long r12, @Query("cursor") String r14, @Query("request_source") String r15);

    @PbRequest(PbRequest.SwitchType.LINKMIC_AUDIENCE)
    @GET("/webcast/linkmic_audience/list_pair_users/")
    Single<e<s>> getPairUserList(@Query("room_id") long r1);

    @PbRequest(PbRequest.SwitchType.LINKMIC_AUDIENCE)
    @GET("/webcast/linkmic_audience/invite_friend/")
    Single<e<InviteFriendsBody>> inviteFriends(@Query("room_id") long r1, @Query("to_user_id_list") String r3, @Query("is_quick_invite") int r4, @Query("msg_board_item_id") long r5);

    @PbRequest(PbRequest.SwitchType.LINKMIC_AUDIENCE)
    @GET("/webcast/linkmic_audience/open_pair/")
    Single<com.bytedance.android.live.network.response.a> openPair(@Query("room_id") long r1, @Query("guest_id") long r3, @Query("guest_open_id") String r5, @Query("investor_id") long r6, @Query("investor_open_id") String r8);

    @GET("/webcast/linkmic_audience/prepare_apply_permit/")
    Observable<com.bytedance.android.live.network.response.a> permitPreApply(@Query("room_id") long r1, @Query("to_user_id") long r3, @Query("to_open_id") String r5);

    @GET("/webcast/linkmic_audience/prepare_invite")
    Observable<e<PrepareInviteResponse>> prepareInvite(@Query("room_id") long r1, @Query("to_user_id") long r3, @Query("to_open_id") String r5, @Query("source") String r6);

    @PbRequest(PbRequest.SwitchType.LINKMIC_AUDIENCE)
    @GET("/webcast/linkmic_audience/invite_search/")
    Single<e<j>> searchInvite(@Query("room_id") long r1, @Query("query_word") String r3);

    @PbRequest(PbRequest.SwitchType.LINKMIC_AUDIENCE)
    @GET("/webcast/linkmic_audience/call_to_linkmic/")
    Single<e<com.bytedance.android.live.liveinteract.plantform.model.a>> sendLinkCall(@Query("room_id") long r1);

    @GET("/webcast/linkmic_profit/interactive_screen_cast_open/")
    Single<Response<com.bytedance.android.live.liveinteract.linkpanel.model.b>> startLinkCast(@Query("room_id") long r1, @Query("item_app_id") String r3, @Query("item_type") int r4, @Query("anchor_push_profile") int r5);

    @GET("/webcast/linkmic_profit/interactive_screen_cast_close/")
    Single<Response<InteractiveScreenCastCloseResponse>> stopLinkCast(@Query("room_id") long r1, @Query("item_app_id") String r3, @Query("item_type") int r4);

    @PbRequest(PbRequest.SwitchType.LINKMIC_AUDIENCE)
    @GET("/webcast/linkmic_audience/update_pair_user/")
    Single<e<l0>> updatePairUser(@Query("room_id") long r1, @Query("guest_id") long r3, @Query("guest_open_id") String r5, @Query("investor_id") long r6, @Query("investor_open_id") String r8);

    @PbRequest(PbRequest.SwitchType.LINKMIC_AUDIENCE)
    @GET("/webcast/linkmic_audience/user_search/")
    Single<e<t>> userSearch(@Query("room_id") long r1, @Query("query_word") String r3, @Query("page") int r4);
}
