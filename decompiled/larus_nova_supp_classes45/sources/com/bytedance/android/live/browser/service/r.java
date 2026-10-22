package com.bytedance.android.live.browser.service;

import android.text.TextUtils;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.broadcast.api.gamepromote.GamePromoteDataContext;
import com.bytedance.android.live.browser.AnnieParamUtil;
import com.bytedance.android.live.core.utils.m2;
import com.bytedance.android.live.user.IMiddlewareUserService;
import com.bytedance.android.livehostapi.foundation.IMiddleWareHostContext;
import com.bytedance.android.livehostapi.foundation.depend.HostBoeParams;
import com.bytedance.android.livesdk.chatroom.utils.o3;
import com.bytedance.android.livesdk.config.fq;
import com.bytedance.android.livesdk.config.ky0;
import com.bytedance.android.livesdk.log.j0;
import com.bytedance.android.livesdk.utils.e4;
import com.bytedance.android.livesdk.utils.r3;
import com.bytedance.android.livesdk.vscore_api.paid.PaidSceneEnum;
import com.bytedance.android.livesdkapi.depend.model.DesireInfo;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.IRoomAuthStatus;
import com.bytedance.android.livesdkapi.depend.model.live.RoomInteractData;
import com.bytedance.android.livesdkapi.depend.model.live.episode.Episode;
import com.bytedance.android.livesdkapi.depend.model.live.episode.IEpisodeExtraInfo;
import com.ss.android.common.applog.AppLog;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class r implements com.bytedance.android.annie.service.network.i {
    public r() {
    }

    public final Map<String, String> s1() {
        LinkedHashMap r0 = new LinkedHashMap();
        com.bytedance.android.livesdk.chatroom.o r1 = o3.f();
        com.bytedance.live.datacontext.m r2 = r1.getRoom();
        String r3 = null;
        if (r2 == null) goto L5;
        IRoom r4 = (IRoom) r2.getValue();
    L6:
        String r5 = "";
        if (r4 == null) goto L10;
        String r6 = r4.getIdStr();
        if (r6 == null) goto L10;
    L11:
        r0.put("room_id", r6);
        if (r4 == null) goto L16;
        String r7 = r4.getOwnerUserIdString();
        if (r7 == null) goto L16;
    L17:
        r0.put("anchor_id", r7);
        if (r4 == null) goto L24;
        IBaseUser r8 = r4.getOwner();
        if (r8 == null) goto L24;
        Intrinsics.checkNotNullParameter(r8, "$this$secUidExt");
        String r9 = r8.getCastSecUid();
        if (r9 == null) goto L24;
    L25:
        r0.put("sec_anchor_id", r9);
        com.bytedance.android.livesdk.user.e r11 = jc1.k.n(IMiddlewareUserService.class).user();
        String r12 = r11.n();
        if (r12 != null) goto L29;
        r12 = "";
    L29:
        r0.put("user_id", r12);
        String r13 = com.bytedance.android.live.base.model.user.o.a(r11.b());
        if (r13 != null) goto L33;
        r13 = "";
    L33:
        r0.put("sec_user_id", r13);
        if (r4 == null) goto L37;
        String r14 = r4.getLog_pb();
        if (r14 == null) goto L37;
    L38:
        r0.put("log_pb", r14);
        if (r4 == null) goto L42;
        String r15 = r4.getRequestId();
        if (r15 == null) goto L42;
    L43:
        r0.put("request_id", r15);
        com.bytedance.android.livesdk.log.filter.t r16 = j0.l().c(am2.x.class);
        if ((r16 instanceof com.bytedance.android.livesdk.log.filter.t) == false) goto L75;
        com.bytedance.android.livesdk.log.filter.t r17 = r16;
        String r18 = (String) r17.getMap().get("enter_from");
        if (r18 != null) goto L48;
        r18 = "";
    L48:
        r0.put("enter_from", r18);
        String r19 = (String) r17.getMap().get("source");
        if (r19 != null) goto L51;
        r19 = "";
    L51:
        r0.put("source", r19);
        String r21 = (String) r17.getMap().get("push_type");
        if (r21 != null) goto L54;
        r21 = "";
    L54:
        r0.put("push_type", r21);
        String r22 = (String) r17.getMap().get("action_type");
        if (r22 != null) goto L57;
        r22 = "";
    L57:
        r0.put("action_type", r22);
        String r23 = (String) r17.getMap().get("video_id");
        if (r23 != null) goto L60;
        r23 = "";
    L60:
        r0.put("video_id", r23);
        String r24 = (String) r17.getMap().get("gd_label");
        if (r24 != null) goto L63;
        r24 = "";
    L63:
        r0.put("gd_label", r24);
        if (TextUtils.isEmpty((CharSequence) r17.getMap().get("enter_from_ad_type")) == false) goto L68;
        String r25 = (String) r17.getMap().get("enter_from_merge");
        if (r25 == null) goto L70;
    L71:
        r0.put("enter_from_merge", r25);
        String r26 = (String) r17.getMap().get("enter_method");
        if (r26 != null) goto L74;
        r26 = "";
    L74:
        r0.put("enter_method", r26);
    L70:
        r25 = "";
        goto L71
    L68:
        r25 = (String) r17.getMap().get("enter_from_ad_type");
        if (r25 != null) goto L71;
    L75:
        com.bytedance.android.livesdk.log.filter.u r27 = j0.l().c(IRoom.class);
        if ((r27 instanceof com.bytedance.android.livesdk.log.filter.u) == false) goto L90;
        com.bytedance.android.livesdk.log.filter.u r28 = r27;
        String r29 = (String) r28.getMap().get("lottery_id");
        if (r29 != null) goto L80;
        r29 = "";
    L80:
        r0.put("lottery_id", r29);
        String r31 = (String) r28.getMap().get("is_fans");
        if (r31 == null) goto L84;
        r5 = r31;
    L84:
        r0.put("is_fans", r5);
        String r32 = (String) r28.getMap().get("joint_anchor_id");
        if (r32 == null) goto L87;
        r0.put("from_user_id", r32);
        r0.put("joint_anchor_id", r32);
    L87:
        String r33 = (String) r28.getMap().get("live_template_type");
        if (r33 == null) goto L90;
        r0.put("live_template_type", r33);
    L90:
        boolean r34 = true;
        if (r4 == null) goto L128;
        String r35 = "0";
        if (r4.allowGift() == false) goto L95;
        Object r36 = GamePromoteDataContext.GAME_TYPE_MOBILE;
    L96:
        r0.put("allow_gift", r36);
        com.bytedance.android.live.incentive.exchange.c r37 = (com.bytedance.android.live.incentive.exchange.c) qa0.c.b.getService(com.bytedance.android.live.incentive.exchange.c.class);
        if (r37 != null) goto L99;
    L101:
        boolean r38 = false;
    L102:
        r0.put("allow_exchange", m2.b(r38));
        DesireInfo r39 = r4.getDesireInfo();
        if (r39 == null) goto L108;
        String r41 = r39.desireIdStr;
        if (r41 == null) goto L108;
        r0.put("desire_id", r41);
    L108:
        if (r4.isPaidRoom() == false) goto L110;
        r35 = GamePromoteDataContext.GAME_TYPE_MOBILE;
    L110:
        r0.put("is_paidlive", r35);
        IRoom r42 = com.bytedance.android.live.browser.utils.c.f();
        if (((Boolean) fq.a.getValue()).booleanValue() == false) goto L119;
        if (r42 == null) goto L116;
        IBaseUser r43 = r42.getOwner();
        if (r43 == null) goto L116;
        boolean r44 = r43.isEnableShowFansClubReverse();
    L117:
        if (r44 == false) goto L119;
        boolean r45 = true;
    L120:
        IRoomAuthStatus r46 = r4.getRoomAuthStatus();
        if (r46 == null) goto L128;
        if (r46.getEcomFansClubAuth() != 1) goto L126;
        if (r45 == true) goto L126;
        r0.put("fansclub_type", "ecom");
    L126:
        r0.put("fansclub_type", GamePromoteDataContext.LIVE);
    L116:
        r44 = false;
    L119:
        r45 = false;
        goto L120
    L99:
        if (r37.a() != true) goto L101;
        r38 = true;
        goto L102
    L95:
        r36 = "0";
    L128:
        if (com.bytedance.android.live.core.utils.v.a() == false) goto L138;
        boolean r47 = tb1.c.a;
        HostBoeParams r48 = jc1.k.n(IMiddleWareHostContext.class).getHostBoeParams();
        if (r48 == null) goto L138;
        if (r48.getPpeEnable() == false) goto L134;
    L137:
        r0.put("device_id", AppLog.v());
        goto L138
    L134:
        if (r48.getBoeEnable() == true) goto L137;
        if (((Boolean) ky0.a.getValue()).booleanValue() == true) goto L137;
    L138:
        r0.put("currency_name", r3.c());
        r0.put("short_currency_name", r3.b());
        j40.m r49 = j40.m.a;
        r0.put("currency_full_name", r49.getValue().getCoinFullDesc());
        r0.put("point_name", r49.getValue().getPoint());
        r0.put("recharge_desc", e4.a());
        if (r4 == null) goto L145;
        RoomInteractData r51 = r4.getRoomInteractData();
        if (r51 == null) goto L145;
        IEpisodeExtraInfo r52 = r51.getComponentExtra();
        if (r52 == null) goto L145;
        r0.put("vs_episode_id", String.valueOf(r52.getId()));
    L145:
        if (r4 != null) goto L147;
    L157:
        boolean r53 = pm1.h.a;
        if (pm1.h.a == false) goto L173;
        lm1.b r54 = pm1.f.d(null);
        if (r54 == null) goto L173;
        com.bytedance.live.datacontext.n r55 = r54.getEpisode();
        if (r55 == null) goto L173;
        Episode r56 = (Episode) r55.getValue();
        if (r56 == null) goto L173;
        int r57 = am2.a0.L;
        r0.putAll(am2.a0.a.a(r56).a());
        String r58 = com.bytedance.android.livesdk.vscore_api.paidlive.scope.g.d(null).s1(PaidSceneEnum.PAID_REPLAY_ROOM);
        if (r58.length() > 0) goto L169;
        r34 = false;
    L169:
        if (r34 == false) goto L171;
        r3 = r58;
    L171:
        if (r3 == null) goto L173;
        String r59 = (String) r0.put("watch_paidlive_status", r3);
    L173:
        com.bytedance.live.datacontext.m r61 = o3.f().C1();
        if (r61 == null) goto L182;
        Map r62 = (Map) r61.getValue();
        if (r62 == null) goto L182;
        Iterator r63 = r62.entrySet().iterator();
    L179:
        if (r63.hasNext() == false) goto L182;
        Map.Entry r64 = (Map.Entry) r63.next();
        r0.put(r64.getKey(), r64.getValue());
    L182:
        if (TextUtils.isEmpty(am2.n.f().c()) == true) goto L184;
        r0.put("creative_id", am2.n.f().c());
    L184:
        return r0;
    L147:
        if (r4.isMergeVSRoom() != true) goto L157;
        r0.put("vs_is_merge", GamePromoteDataContext.GAME_TYPE_MOBILE);
        if (Intrinsics.areEqual(r1.isPortraitInteraction(), Boolean.TRUE) == false) goto L151;
        String r65 = "portrait";
    L152:
        r0.put("vs_screen_type", r65);
        IRoomAuthStatus r66 = r4.getRoomAuthStatus();
        if (r66 == null) goto L155;
        Boolean r67 = Boolean.valueOf(r66.isVSRoomEnableSeek());
    L156:
        r0.put("can_replay", String.valueOf(r67.booleanValue()));
        r0.putAll(AnnieParamUtil.i());
        goto L157
    L155:
        r67 = null;
        goto L156
    L151:
        r65 = "landscape";
    L42:
        r15 = "";
    L37:
        r14 = "";
    L24:
        r9 = "";
    L16:
        r7 = "";
    L10:
        r6 = "";
        goto L11
    L5:
        r4 = null;
        goto L6
    }
}
