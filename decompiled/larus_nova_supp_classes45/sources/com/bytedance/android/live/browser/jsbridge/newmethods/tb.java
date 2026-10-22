package com.bytedance.android.live.browser.jsbridge.newmethods;

import android.text.TextUtils;
import com.bytedance.android.live.base.model.user.User;
import com.bytedance.android.live.broadcast.api.gamepromote.GamePromoteDataContext;
import com.bytedance.android.live.core.utils.JsonUtil;
import com.bytedance.android.live.core.utils.screen.FoldScreenUtils;
import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.android.live.openplatform.api.minigame.IOpenPlatformMgAnchorService;
import com.bytedance.android.live.openplatform.api.minigame.IOpenPlatformMgAudienceService;
import com.bytedance.android.live.room.IMiddlewareRoomService;
import com.bytedance.android.livehostapi.business.IMiddlewareHostBusiness;
import com.bytedance.android.livehostapi.foundation.IMiddleWareHostContext;
import com.bytedance.android.livesdk.chatroom.MiddlewareRoomContext;
import com.bytedance.android.livesdk.interactivity.api.IGroupLiveService;
import com.bytedance.android.livesdk.log.filter.PadFoldDeviceSendFilter;
import com.bytedance.android.livesdk.padutils.PadConfigUtils;
import com.bytedance.android.livesdkapi.depend.model.live.IAnchorTogetherLive;
import com.bytedance.android.livesdkapi.depend.model.live.IGroupLiveData;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.depend.model.live.RoomOthersData;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@XBridgeMethod(biz = "webcast", name = "sendLogV3")
public final class tb extends com.bytedance.ies.web.jsbridge2.g<JSONObject, Object> {
    public tb() {
    }

    public final /* bridge */ /* synthetic */ Object invoke(Object r1, CallContext r2) throws Exception {
        return j((JSONObject) r1, r2);
    }

    public final Object j(JSONObject r22, CallContext r23) throws Exception {
        String r3 = r22.optString("eventName");
        if (TextUtils.isEmpty(r3) == false) goto L6;
        JSONObject r0 = new JSONObject();
        r0.put("code", 0);
        r0.put("msg", "eventName is null");
        return r0;
    L6:
        JSONObject r1 = r22.optJSONObject("params");
        xs2.b.a().post(new jd0.l(r3, JsonUtil.copyJson2(r1)));
        HashMap r8 = new HashMap();
        if (r1 == null) goto L12;
        Iterator<String> r9 = r1.keys();
    L10:
        if (r9.hasNext() == false) goto L12;
        String r11 = r9.next();
        String r12 = r1.optString(r11);
        r9.remove();
        r8.put(r11, r12);
    L12:
        r8.remove("addClientPublicParam");
        com.bytedance.android.live.liveinteract.api.utils.i.a(r8);
        int r2 = l30.g.a;
        Intrinsics.checkNotNullParameter(r8, "args");
        com.bytedance.android.livesdk.chatroom.o r13 = com.bytedance.android.livesdk.chatroom.utils.o3.f();
        if (r13 == null) goto L15;
        Boolean r14 = r13.isVSRoom();
    L16:
        Boolean r15 = Boolean.TRUE;
        if (Intrinsics.areEqual(r14, r15) == false) goto L42;
        com.bytedance.android.livesdk.log.filter.o r16 = com.bytedance.android.livesdk.log.j0.l().c(IRoom.class);
        if ((r16 instanceof com.bytedance.android.livesdk.log.filter.u) == true) goto L21;
        r16 = null;
    L21:
        com.bytedance.android.livesdk.log.filter.u r17 = (com.bytedance.android.livesdk.log.filter.u) r16;
        if (r17 == null) goto L24;
        Map r18 = r17.getMap();
    L25:
        if (r18 == null) goto L42;
        String r19 = (String) r18.get("vs_episode_sub_type");
        if (r19 != null) goto L29;
        r19 = "";
    L29:
        l30.g.a(r8, "vs_episode_sub_type", r19);
        l30.g.a(r8, "request_id", (String) r18.get("request_id"));
        l30.g.a(r8, "log_pb", (String) r18.get("log_pb"));
        l30.g.a(r8, "video_id", (String) r18.get("video_id"));
        l30.g.a(r8, "vs_season_id", (String) r18.get("vs_season_id"));
        l30.g.a(r8, "vs_content_id", (String) r18.get("vs_content_id"));
        com.bytedance.android.livesdk.chatroom.o r110 = com.bytedance.android.livesdk.chatroom.utils.o3.f();
        if (r110 == null) goto L32;
        Boolean r111 = r110.isVSRoom();
    L34:
        if (Intrinsics.areEqual(r111, r15) == false) goto L36;
        String r112 = GamePromoteDataContext.GAME_TYPE_MOBILE;
    L37:
        l30.g.a(r8, "is_vs", r112);
        l30.g.a(r8, "vs_episode_id", (String) r18.get("vs_episode_id"));
        l30.g.a(r8, "vs_ep_group_id", (String) r18.get("vs_ep_group_id"));
        l30.g.a(r8, "vs_episode_stage", (String) r18.get("vs_episode_stage"));
        if (com.bytedance.android.livesdk.utils.e5.n() == false) goto L40;
        String r113 = "landscape";
    L41:
        l30.g.a(r8, "vs_screen_type", r113);
        l30.g.a(r8, "vs_is_portraid_content", (String) r18.get("vs_is_portraid_content"));
        goto L42
    L40:
        r113 = "portrait";
        goto L41
    L36:
        r112 = "0";
        goto L37
    L32:
        r111 = null;
        goto L34
    L24:
        r18 = null;
    L42:
        int r21 = l30.a.a;
        Intrinsics.checkNotNullParameter(r8, "args");
        MiddlewareRoomContext.a r24 = MiddlewareRoomContext.Companion;
        long r114 = 0;
        MiddlewareRoomContext r115 = MiddlewareRoomContext.a.c(r24, null, 0, 3);
        if (r115 == null) goto L55;
        com.bytedance.live.datacontext.m r116 = r115.getRoom();
        if (r116 == null) goto L55;
        Room r117 = (Room) r116.getValue();
        if (r117 == null) goto L55;
        RoomOthersData r118 = r117.others;
        if (r118 == null) goto L55;
        IGroupLiveData r119 = r118.getGroupData();
        if (r119 == null) goto L55;
        if (r119.isCurrentGroupLive() != true) goto L55;
        r8.put("is_grouped_lived", GamePromoteDataContext.GAME_TYPE_MOBILE);
    L56:
        MiddlewareRoomContext r120 = MiddlewareRoomContext.a.c(r24, null, 0, 3);
        if (r120 == null) goto L69;
        com.bytedance.live.datacontext.m r121 = r120.getRoom();
        if (r121 == null) goto L69;
        Room r122 = (Room) r121.getValue();
        if (r122 == null) goto L69;
        RoomOthersData r123 = r122.others;
        if (r123 == null) goto L69;
        IAnchorTogetherLive r124 = r123.getAnchorTogetherLive();
        if (r124 == null) goto L69;
        if (r124.getLiveTogetherStatus() != 1) goto L69;
        r8.put("is_group_co_rec", GamePromoteDataContext.GAME_TYPE_MOBILE);
    L70:
        MiddlewareRoomContext r125 = MiddlewareRoomContext.a.c(r24, null, 0, 3);
        if (r125 == null) goto L79;
        com.bytedance.live.datacontext.m r126 = r125.getRoom();
        if (r126 == null) goto L79;
        Room r127 = (Room) r126.getValue();
        if (r127 == null) goto L79;
        User r128 = r127.getOwner();
        if (r128 == null) goto L79;
        String r129 = r128.getIdString();
    L80:
        IGroupLiveService r130 = jc1.k.f(IGroupLiveService.class);
        if (r130 != null) goto L83;
        DataCenter r7 = null;
        int r131 = 3;
    L102:
        MiddlewareRoomContext r25 = MiddlewareRoomContext.a.c(r24, r7, r114, r131);
        if (r25 == null) goto L113;
        com.bytedance.live.datacontext.m r26 = r25.getRoom();
        if (r26 == null) goto L113;
        Room r27 = (Room) r26.getValue();
        if (r27 == null) goto L113;
        RoomOthersData r28 = r27.others;
        if (r28 == null) goto L113;
        IGroupLiveData r29 = r28.getGroupData();
        if (r29 == null) goto L113;
        int r31 = r29.getGroupLiveMode();
    L114:
        r8.put("group_live_mode", String.valueOf(r31));
        IGroupLiveService r32 = jc1.k.f(IGroupLiveService.class);
        if (r32 == null) goto L128;
        String r33 = r32.getAnchorIdBeforeJump();
        if (r33 == null) goto L128;
        if (r33.length() <= 0) goto L121;
        boolean r34 = true;
    L122:
        if (r34 == false) goto L128;
        if ((!Intrinsics.areEqual(r33, "0")) == false) goto L128;
        if ((!Intrinsics.areEqual(r129, r33)) == false) goto L128;
        Object r35 = GamePromoteDataContext.GAME_TYPE_MOBILE;
    L129:
        r8.put("is_link_screen_co_rec", r35);
        com.bytedance.android.livesdk.log.filter.o r132 = com.bytedance.android.livesdk.log.j0.l().c(am2.x.class);
        if ((r132 instanceof com.bytedance.android.livesdk.log.filter.t) == true) goto L132;
        r132 = null;
    L132:
        com.bytedance.android.livesdk.log.filter.t r133 = (com.bytedance.android.livesdk.log.filter.t) r132;
        if (r133 == null) goto L145;
        String r134 = r133.D();
        if (r134 == null) goto L145;
        if (r134.length() <= 0) goto L139;
        boolean r36 = true;
    L140:
        if (r36 == true) goto L143;
        r134 = null;
    L143:
        if (r134 == null) goto L145;
        r8.put("group_member_id", r134);
        goto L145
    L139:
        r36 = false;
    L145:
        IOpenPlatformMgAnchorService r37 = jc1.k.f(IOpenPlatformMgAnchorService.class);
        if (r37 == null) goto L148;
        r37.injectMgParams(r8);
    L148:
        IOpenPlatformMgAudienceService r38 = jc1.k.f(IOpenPlatformMgAudienceService.class);
        if (r38 == null) goto L152;
        r38.injectMgParams(r8);
    L152:
        if (((Boolean) com.bytedance.android.livesdk.w0.a.getValue()).booleanValue() == false) goto L179;
        int r39 = l30.e.a;
        Intrinsics.checkNotNullParameter(r3, "eventName");
        Intrinsics.checkNotNullParameter(r8, "args");
        if (r3.hashCode() != (-1837102167)) goto L179;
        if (r3.equals("livesdk_fans_club_join_success") == false) goto L179;
        CharSequence r41 = (CharSequence) r8.get("live_recommend_info");
        if (r41 != null) goto L161;
    L164:
        boolean r42 = true;
    L165:
        if (r42 == false) goto L179;
        com.bytedance.android.livesdk.log.filter.o r43 = com.bytedance.android.livesdk.log.j0.l().c(am2.x.class);
        if (r43 == null) goto L179;
        String r44 = (String) r43.getMap().get("live_recommend_info");
        if (r44 != null) goto L172;
    L175:
        boolean r45 = true;
    L176:
        if (r45 == true) goto L179;
        r8.put("live_recommend_info", r44);
        goto L179
    L172:
        if (r44.length() == 0) goto L175;
        r45 = false;
        goto L176
    L161:
        if (r41.length() == 0) goto L164;
        r42 = false;
    L179:
        com.bytedance.android.live.incentive.et.c r4 = (com.bytedance.android.live.incentive.et.c) qa0.c.b.getService(com.bytedance.android.live.incentive.et.c.class);
        if (r4 == null) goto L183;
        r4.j(r3, r8);
    L183:
        if (r8.containsKey("addClientParamForGuestBattle") == true) goto L185;
    L187:
        r8.remove("addClientParamForGuestBattle");
        if (r8.containsKey("addClientParamForSelfDiscipline") == true) goto L190;
    L197:
        r8.put("sdk_version", String.valueOf(com.bytedance.android.livesdk.paas.c.b()));
        r8.put("_param_live_platform", GamePromoteDataContext.LIVE);
        r8.put("room_orientation", com.bytedance.android.livesdk.log.j0.d);
        if (TextUtils.equals(r3, "page_view") == false) goto L212;
        if (r8.containsKey("btm") == false) goto L212;
        if (TextUtils.equals((CharSequence) r8.get("btm"), "a1.b7411.c0.d0") == false) goto L212;
        IMiddlewareHostBusiness r5 = jc1.k.f(IMiddlewareHostBusiness.class);
        if (r5 == null) goto L212;
        Map r6 = r5.getEcomExtraLogParams(r3, r8, r23.d);
        if (r6 == null) goto L212;
        Iterator r46 = r6.entrySet().iterator();
    L209:
        if (r46.hasNext() == false) goto L212;
        Map.Entry r47 = (Map.Entry) r46.next();
        r8.put((String) r47.getKey(), (String) r47.getValue());
    L212:
        if (r8.containsKey("btm") == false) goto L221;
        if (r8.containsKey("btm_show_id") == true) goto L221;
        IMiddlewareHostBusiness r48 = jc1.k.f(IMiddlewareHostBusiness.class);
        if (r48 == null) goto L221;
        Map r49 = r48.obtainEventParams(r8, r23.d);
        if (r49 == null) goto L221;
        r8.putAll(r49);
    L221:
        if (r8.containsKey("btm") == true) goto L224;
        com.bytedance.android.livesdk.log.filter.g.b.L9(r3, r8);
    L224:
        if (r8.containsKey("explain_product_id") == true) goto L226;
        com.bytedance.android.livesdk.log.filter.j0.a.L9(r3, r8);
    L226:
        IMiddlewareRoomService r51 = jc1.k.f(IMiddlewareRoomService.class);
        if (r51 == null) goto L253;
        r51.getPadFoldDeviceSendFilter().getClass();
        Intrinsics.checkNotNullParameter(r3, "eventName");
        Intrinsics.checkNotNullParameter(r8, "params");
        if (PadFoldDeviceSendFilter.c(r3) == false) goto L253;
        if (PadConfigUtils.a() == false) goto L233;
        Object r52 = GamePromoteDataContext.GAME_TYPE_MOBILE;
    L234:
        r8.put("is_pad", r52);
        if (FoldScreenUtils.f() == false) goto L237;
        Object r53 = GamePromoteDataContext.GAME_TYPE_MOBILE;
    L238:
        r8.put("is_fold_screen", r53);
        if (FoldScreenUtils.a != null) goto L241;
        FoldScreenUtils.a = jc1.k.f(IMiddleWareHostContext.class);
    L241:
        IMiddleWareHostContext r54 = FoldScreenUtils.a;
        if (r54 == null) goto L244;
        int r55 = r54.getFoldType();
    L245:
        r8.put("fold_type", String.valueOf(r55));
        ce1.d r56 = ce1.e.a;
        if (r56 != null) goto L248;
    L250:
        Object r57 = "0";
    L251:
        r8.put("is_pad_landscape", r57);
        r8.put("fold_position", PadFoldDeviceSendFilter.b());
        int r58 = com.bytedance.android.live.core.utils.s1.y();
        int r59 = com.bytedance.android.live.core.utils.s1.w();
        StringBuilder r61 = new StringBuilder();
        r61.append(r58);
        r61.append('x');
        r61.append(r59);
        r8.put("app_available_size", r61.toString());
        r8.put("app_aspect_ratio", PadFoldDeviceSendFilter.a(r58, r59));
        goto L253
    L248:
        if (r56.e() != true) goto L250;
        r57 = GamePromoteDataContext.GAME_TYPE_MOBILE;
        goto L251
    L244:
        r55 = -1;
        goto L245
    L237:
        r53 = "0";
        goto L238
    L233:
        r52 = "0";
    L253:
        if (r23.f == false) goto L255;
        r8.put("is_open_anniex", GamePromoteDataContext.GAME_TYPE_MOBILE);
    L257:
        if (r3.startsWith("livesdk_replay_video") == false) goto L259;
        pm1.f.f().f(null, r3, r8, new Object[0]);
        int r62 = 1;
    L260:
        JSONObject r63 = new JSONObject();
        r63.put("code", r62);
        r63.put("msg", "SUCCESS");
        return r63;
    L259:
        r62 = 1;
        com.bytedance.android.livesdk.log.j0.l().sendLog(r3, r8, new Object[]{am2.x.class, Room.class});
        goto L260
    L255:
        r8.put("is_open_anniex", "0");
        goto L257
    L190:
        if (TextUtils.equals((CharSequence) r8.get("addClientParamForSelfDiscipline"), GamePromoteDataContext.GAME_TYPE_MOBILE) == false) goto L197;
        IInteractService r64 = jc1.k.f(IInteractService.class);
        if (r64 == null) goto L196;
        kj0.b r65 = r64.getSelfDisciplineService();
        if (r65 == null) goto L196;
        r65.addExtraLog(r8);
    L196:
        r8.remove("addClientParamForSelfDiscipline");
        goto L197
    L185:
        if (TextUtils.equals((CharSequence) r8.get("addClientParamForGuestBattle"), GamePromoteDataContext.GAME_TYPE_MOBILE) == false) goto L187;
        com.bytedance.android.live.liveinteract.utils.w.b(r8);
        goto L187
    L121:
        r34 = false;
    L128:
        r35 = "0";
    L113:
        r31 = 0;
        goto L114
    L83:
        if (r130.getAnchorIdBeforeJump().length() <= 0) goto L85;
        boolean r135 = true;
    L86:
        if (r135 == true) goto L88;
    L94:
        boolean r136 = false;
    L95:
        if (r136 == true) goto L98;
        r130 = null;
    L98:
        if (r130 == null) goto L100;
        r8.put("throw_user_id", r130.getAnchorIdBeforeJump());
        r8.put("throw_room_id", String.valueOf(r130.getRoomIdBeforeJump()));
        r8.put("link_screen_request_id", r130.getRequestIdBeforeJump());
    L100:
        r7 = null;
        r131 = 3;
        r114 = 0;
        goto L102
    L88:
        if ((!Intrinsics.areEqual(r130.getAnchorIdBeforeJump(), "0")) == false) goto L94;
        if (r130.getRoomIdBeforeJump() <= 0) goto L94;
        if ((!Intrinsics.areEqual(r129, r130.getAnchorIdBeforeJump())) == false) goto L94;
        r136 = true;
        goto L95
    L85:
        r135 = false;
    L79:
        r129 = null;
    L69:
        r8.put("is_group_co_rec", "0");
    L55:
        r8.put("is_grouped_lived", "0");
        goto L56
    L15:
        r14 = null;
        goto L16
    }
}
