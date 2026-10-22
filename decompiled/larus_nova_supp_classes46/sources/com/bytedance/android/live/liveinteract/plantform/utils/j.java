package com.bytedance.android.live.liveinteract.plantform.utils;

import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.core.setting.b6;
import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge;
import com.bytedance.android.live.liveinteract.revenue.fight.TeamFightContext;
import com.bytedance.android.live.liveinteract.revenue.linkroomfight.core.LinkRoomFightContext;
import com.bytedance.android.livesdk.link.model.bridge.g2;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import java.util.Iterator;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class j implements com.bytedance.android.livesdk.log.filter.v {
    public static final j a = null;

    public j() {
    }

    public final void Rd() {
    }

    public final void onRemove() {
    }

    static {
        a = new j();
    }

    public final void L9(String r11, Map<String, String> r12) {
        Intrinsics.checkNotNullParameter(r11, "eventName");
        Intrinsics.checkNotNullParameter(r12, "params");
        String r1 = r12.get("user_type");
        boolean r2 = false;
        if (r1 != null) goto L5;
    L8:
        boolean r3 = true;
    L9:
        String r4 = "user";
        String r6 = "anchor";
        if (r3 == false) goto L24;
        com.bytedance.android.livesdk.chatroom.o r5 = com.bytedance.android.live.liveinteract.api.utils.m.i();
        if (r5 == null) goto L24;
        if (Intrinsics.areEqual(r5.isAnchor(), Boolean.TRUE) == false) goto L16;
        String r7 = "anchor";
    L23:
        r12.put("user_type", r7);
        goto L24
    L16:
        Integer r8 = (Integer) ((ge1.a) hd0.c.f()).b;
        if (r8 != null) goto L20;
    L21:
        r7 = "guest";
        goto L23
    L20:
        if (r8.intValue() != 0) goto L21;
        r7 = "user";
    L24:
        IRoom r9 = null;
        switch(r11.hashCode()) {
            case -1958427520: goto L197;
            case -1837102167: goto L194;
            case -1122536402: goto L191;
            case -1115849514: goto L185;
            case -804282046: goto L159;
            case -596374427: goto L156;
            case -509441308: goto L153;
            case -505186085: goto L150;
            case 21313630: goto L128;
            case 22217128: goto L125;
            case 479193863: goto L122;
            case 516631638: goto L64;
            case 516908681: goto L61;
            case 525059201: goto L58;
            case 748649960: goto L55;
            case 1125973814: goto L52;
            case 1166841325: goto L49;
            case 1282714792: goto L46;
            case 1372525185: goto L43;
            case 1499179894: goto L40;
            case 1507583969: goto L37;
            case 1744840954: goto L34;
            case 2009019068: goto L31;
            case 2041791848: goto L28;
            default: goto L237;
        };
    L237:
        return;
    L28:
        if (r11.equals("livesdk_like") == false) goto L203;
    L129:
        TalkRoomLogUtils.K0(r12);
        TalkRoomLogUtils.C0(r12);
        g r13 = g.a;
        g.a(r12);
        Intrinsics.checkNotNullParameter(r12, "logMap");
        if (((Boolean) b6.q.getValue()).booleanValue() == false) goto L132;
        String r14 = "on";
    L133:
        r12.put("link_distribute_switch_type", r14);
        Intrinsics.checkNotNullParameter(r12, "logMap");
        com.bytedance.android.live.liveinteract.plantform.base.i<ILinkPlayerInfoBridge> r15 = ((IInteractService) jc1.k.n(IInteractService.class)).getLinkUserInfoCenter();
        if ((r15 instanceof com.bytedance.android.live.liveinteract.plantform.core.y) == false) goto L222;
        Iterator<ILinkPlayerInfoBridge> r16 = ((com.bytedance.android.live.liveinteract.plantform.core.y) r15).c.iterator();
    L137:
        if (r16.hasNext() == false) goto L141;
        ILinkPlayerInfoBridge r0 = r16.next();
        if (com.bytedance.android.live.liveinteract.plantform.a.a(r0) == false) goto L137;
    L142:
        ILinkPlayerInfoBridge r10 = r0;
        if (r10 == null) goto L148;
        r12.put("is_AI_guest", "1");
        IBaseUser r17 = r10.getUser();
        if (r17 == null) goto L147;
        r9 = r17.getIdString();
    L147:
        r12.put("AI_guest_id", r9);
        return;
    L148:
        r12.put("is_AI_guest", "0");
        return;
    L141:
        r0 = null;
        goto L142
    L222:
        return;
    L132:
        r14 = "off";
        goto L133
    L203:
        return;
    L31:
        if (r11.equals("livesdk_recharge_success") == false) goto L204;
    L198:
        TalkRoomLogUtils.K0(r12);
        TalkRoomLogUtils.C0(r12);
        return;
    L204:
        return;
    L34:
        if (r11.equals("livesdk_send_barrage") == true) goto L198;
        return;
    L37:
        if (r11.equals("livesdk_recharge_pay") == true) goto L198;
        return;
    L40:
        if (r11.equals("livesdk_live_play") == false) goto L207;
    L186:
        TalkRoomLogUtils.C0(r12);
        com.bytedance.live.datacontext.m r18 = com.bytedance.android.live.liveinteract.api.utils.m.i().getRoom();
        if (r18 == null) goto L189;
        r9 = (IRoom) r18.getValue();
    L189:
        r12.put("play_mode", u0.c(r9));
        return;
    L207:
        return;
    L43:
        if (r11.equals("livesdk_recharge_click") == true) goto L198;
        return;
    L46:
        if (r11.equals("livesdk_recharge_page_pay_click") == true) goto L198;
        return;
    L49:
        if (r11.equals("livesdk_audience_guest_connection_show") == true) goto L129;
        return;
    L52:
        if (r11.equals("livesdk_check_out_show") == true) goto L198;
        return;
    L55:
        if (r11.equals("livesdk_guest_head_decorate_show") == true) goto L198;
        return;
    L58:
        if (r11.equals("livesdk_redpackage_send") == true) goto L198;
        return;
    L61:
        if (r11.equals("livesdk_send_prop") == true) goto L198;
        return;
    L64:
        if (r11.equals("livesdk_send_gift") == false) goto L215;
        com.bytedance.android.livesdk.chatroom.o r19 = com.bytedance.android.live.liveinteract.api.utils.m.i();
        if (r19 != null) goto L68;
    L77:
        TalkRoomLogUtils.K0(r12);
        TalkRoomLogUtils.C0(r12);
        i0 r110 = TalkRoomLogUtils.a;
        TalkRoomLogUtils.Y0(r12);
        com.bytedance.live.datacontext.m r111 = com.bytedance.android.live.liveinteract.api.utils.m.i().getRoom();
        if (r111 == null) goto L80;
        IRoom r112 = (IRoom) r111.getValue();
    L81:
        r12.put("playmode", u0.c(r112));
        if (TalkRoomLogUtils.E() == false) goto L86;
        String r113 = r12.get("to_user_id");
        if (r113 == null) goto L86;
        TalkRoomLogUtils.h1(r12, r113);
    L86:
        g2 r114 = zi0.d.b;
        Intrinsics.checkNotNullParameter(r12, "logMap");
        if (je0.d.f() != 16) goto L107;
        LinkRoomFightContext r115 = LinkRoomFightContext.Companion.getContext();
        if (r115 == null) goto L94;
        com.bytedance.live.datacontext.m<com.bytedance.android.live.liveinteract.revenue.linkroomfight.core.c.b> r116 = r115.getFightState();
        if (r116 == null) goto L94;
        Object r117 = (com.bytedance.android.live.liveinteract.revenue.linkroomfight.core.c.b) r116.getValue();
        if (r117 == null) goto L94;
    L95:
        Intrinsics.checkNotNullParameter(r117, "fightState");
        r117.getClass();
        if ((r117 instanceof com.bytedance.android.live.liveinteract.revenue.linkroomfight.core.c.b.a) == false) goto L98;
    L99:
        r2 = true;
    L100:
        if (r2 == false) goto L103;
        String r118 = "processing";
    L106:
        r12.put("play_stage", r118);
        goto L107
    L103:
        if ((r117 instanceof com.bytedance.android.live.liveinteract.revenue.linkroomfight.core.c.b.e) == false) goto L105;
        r118 = "punish";
        goto L106
    L105:
        r118 = "punish_finish";
        goto L106
    L98:
        if ((r117 instanceof com.bytedance.android.live.liveinteract.revenue.linkroomfight.core.c.b.f) == false) goto L100;
    L94:
        r117 = com.bytedance.android.live.liveinteract.revenue.linkroomfight.core.c.b.C0093c.c;
    L107:
        li0.b r119 = li0.b.b;
        Intrinsics.checkNotNullParameter(r12, "logMap");
        TeamFightContext.a r120 = TeamFightContext.Companion;
        if (r120.h() == false) goto L110;
    L111:
        com.bytedance.android.live.liveinteract.multiscene.a r121 = r120.b();
        if (r121 == null) goto L217;
        r12.put("play_layout", li0.b.a(r121));
        com.bytedance.android.live.liveinteract.multiscene.j r20 = li0.d.i(r121);
        com.bytedance.android.live.liveinteract.multiscene.j r122 = li0.d.a(r121);
        if (r20 == null) goto L116;
        Long r21 = r20.getMaxMember();
    L117:
        r12.put("grouppk_redcnt", String.valueOf(r21));
        if (r122 == null) goto L120;
        r9 = r122.getMaxMember();
    L120:
        r12.put("grouppk_bluecnt", String.valueOf(r9));
        return;
    L116:
        r21 = null;
        goto L117
    L217:
        return;
    L110:
        if (r120.g() == true) goto L111;
        return;
    L80:
        r112 = null;
        goto L81
    L68:
        if (Intrinsics.areEqual(r19.isAnchor(), Boolean.TRUE) == false) goto L70;
        r4 = "anchor";
    L76:
        r12.put("user_type", r4);
        goto L77
    L70:
        Integer r123 = (Integer) ((ge1.a) hd0.c.f()).b;
        if (r123 != null) goto L74;
    L75:
        r4 = "guest";
        goto L76
    L74:
        if (r123.intValue() == 0) goto L76;
    L215:
        return;
    L122:
        if (r11.equals("livesdk_rec_live_play") == true) goto L186;
        return;
    L125:
        if (r11.equals("livesdk_customized_recharge_show") == true) goto L198;
        return;
    L128:
        if (r11.equals("livesdk_audience_live_message") == true) goto L129;
        return;
    L150:
        if (r11.equals("livesdk_unfollow") == false) goto L225;
    L160:
        TalkRoomLogUtils.K0(r12);
        TalkRoomLogUtils.C0(r12);
        i0 r124 = TalkRoomLogUtils.a;
        TalkRoomLogUtils.Y0(r12);
        if (TalkRoomLogUtils.E() == false) goto L229;
        String r125 = r12.get("to_user_id");
        if (r125 == null) goto L230;
        TalkRoomLogUtils.h1(r12, r125);
        Intrinsics.checkNotNullParameter(r12, "logMap");
        Intrinsics.checkNotNullParameter(r125, "uid");
        if (TalkRoomLogUtils.E() == false) goto L182;
        com.bytedance.live.datacontext.m r22 = com.bytedance.android.live.liveinteract.api.utils.m.i().getRoom();
        if (r22 == null) goto L171;
        IRoom r23 = (IRoom) r22.getValue();
        if (r23 == null) goto L171;
        String r24 = r23.getOwnerUserIdString();
    L173:
        if (Intrinsics.areEqual(r125, r24) == true) goto L183;
        IInteractService r25 = (IInteractService) jc1.k.f(IInteractService.class);
        if (r25 == null) goto L180;
        com.bytedance.android.live.liveinteract.plantform.base.i<ILinkPlayerInfoBridge> r26 = r25.getLinkUserInfoCenter();
        if (r26 == null) goto L180;
        r9 = je0.d.i(r26, r125);
    L180:
        if (r9 == null) goto L182;
        r6 = "link_user";
    L183:
        r12.put("to_user_type", r6);
        return;
    L171:
        r24 = null;
    L182:
        r6 = "normal";
        goto L183
    L230:
        return;
    L229:
        return;
    L225:
        return;
    L153:
        if (r11.equals("livesdk_recharge_show") == true) goto L198;
        return;
    L156:
        if (r11.equals("livesdk_link_interact_panel_head_decorate_icon_click") == true) goto L198;
        return;
    L159:
        if (r11.equals("livesdk_follow") == true) goto L160;
        return;
    L185:
        if (r11.equals("livesdk_live_duration") == true) goto L186;
        return;
    L191:
        if (r11.equals("livesdk_share") == true) goto L198;
        return;
    L194:
        if (r11.equals("livesdk_fans_club_join_success") == true) goto L198;
        return;
    L197:
        if (r11.equals("livesdk_link_interact_panel_head_decorate_icon_show") == true) goto L198;
        return;
    L5:
        if (r1.length() == 0) goto L8;
        r3 = false;
        goto L9
    }
}
