package com.bytedance.android.livesdk.chatroom.viewmodule.toolbar;

import com.bytedance.android.live.base.model.user.IUser;
import com.bytedance.android.live.base.model.user.User;
import com.bytedance.android.live.broadcast.api.model.WelfarePermissionInfo;
import com.bytedance.android.live.core.setting.LiveInfraSettingKeys;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar_behavior.ToolbarGroupPurchaseWidgetBehavior;
import com.bytedance.android.livesdk.config.db;
import com.bytedance.android.livesdk.config.eq0;
import com.bytedance.android.livesdk.config.l4;
import com.bytedance.android.livesdk.config.mq0;
import com.bytedance.android.livesdk.config.qh;
import com.bytedance.android.livesdk.config.qi0;
import com.bytedance.android.livesdk.config.rq0;
import com.bytedance.android.livesdk.config.ud0;
import com.bytedance.android.livesdk.config.uj;
import com.bytedance.android.livesdk.config.vl0;
import com.bytedance.android.livesdk.config.xc;
import com.bytedance.android.livesdk.config.z90;
import com.bytedance.android.livesdk.utils.AnchorFansGroupUtil;
import com.bytedance.android.livesdk.utils.n5;
import com.bytedance.android.livesdkapi.depend.model.live.LiveMode;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.depend.model.live.RoomAuthStatus;
import com.bytedance.android.livesdkapi.depend.model.live.RoomSpecificSceneTypeInfo;
import com.bytedance.android.livesdkapi.depend.model.live.im.IMIndustryServiceInfo;
import com.bytedance.android.livesdkapi.model.com.bytedance.android.livesdk.config.LiveOpenFeatureChooseConfig;
import com.bytedance.android.livesdkapi.model.com.bytedance.android.livesdkapi.model.LiveAddPictureConfig;
import com.bytedance.ies.sdk.widgets.DataCenter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class p implements v {

    public static final class a implements com.bytedance.android.livesdk.service.k.b<v> {
        public a() {
        }

        public final com.bytedance.android.livesdk.service.k.b.a<v> setup(com.bytedance.android.livesdk.service.k.b.a<v> r2) {
            Intrinsics.checkNotNullParameter(r2, "config");
            r2.a = new p();
            r2.b = true;
            return r2;
        }
    }

    public p() {
    }

    public static boolean e() {
        return qh.a.getValue().booleanValue();
    }

    public static boolean f() {
        return ((Boolean) com.bytedance.android.livesdk.sharedpref.b.U0.getValue()).booleanValue();
    }

    public static boolean g() {
        uj r0 = uj.a;
        if (r0.getValue() != null) goto L5;
    L7:
        return false;
    L5:
        if (r0.getValue().showChallenge == false) goto L7;
        return true;
    }

    public static boolean d(Room r1) {
        if (r1 == null) goto L6;
        Map r2 = r1.anchorAbMap;
        if (r2 == null) goto L6;
        String r3 = (String) r2.get("live_anchor_hl_auto_post_enable");
    L8:
        return "true".equals(r3);
    L6:
        r3 = null;
        goto L8
    }

    public static boolean h(Room r4) {
        if (r4 == null) goto L8;
        RoomAuthStatus r5 = r4.getRoomAuthStatus();
        if (r5 == null) goto L8;
        if (r5.showQualification != 2) goto L8;
    L10:
        return false;
    L8:
        if (m71.e.d() == false) goto L10;
        return true;
    }

    public static boolean j(DataCenter r1) {
        if (yt2.b.a().booleanValue() == false) goto L9;
        WelfarePermissionInfo r2 = (WelfarePermissionInfo) r1.get("data_welfare_permission_info");
        if (r2 == null) goto L9;
        if (r2.available != true) goto L9;
        return true;
    L9:
        return false;
    }

    public static boolean k(Room r1) {
        if (r1 == null) goto L8;
        User r2 = r1.getOwner();
        if (r2 == null) goto L8;
        if (r2.getSecret() != 1) goto L8;
        return true;
    L8:
        return false;
    }

    public static void m(DataCenter r2) {
        com.bytedance.android.live.core.utils.z.b(r2);
        Room r3 = (Room) r2.get("data_room", null);
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.v
    public final List<ToolbarButton> a(DataCenter r10) {
        Intrinsics.checkNotNullParameter(r10, "dataCenter");
        ArrayList r0 = new ArrayList();
        Integer r2 = null;
        Room r1 = (Room) r10.get("data_room", null);
        boolean r4 = false;
        if (com.bytedance.android.live.core.utils.z.h(r10) == false) goto L44;
        r0.add(ToolbarButton.REVERSE_CAMERA);
        if (z90.a.getValue().booleanValue() == true) goto L8;
        r0.add(ToolbarButton.REVERSE_MIRROR);
    L8:
        if (j(r10) == false) goto L10;
        r0.add(ToolbarButton.WELFARE_FOLD);
    L10:
        r0.add(ToolbarButton.COMMENT);
        r0.add(ToolbarButton.MANAGE);
        r0.add(ToolbarButton.BROADCAST_ADMIN);
        if (k(r1) == true) goto L14;
        r0.add(ToolbarButton.SHARE);
    L14:
        if (e() == false) goto L16;
        r0.add(ToolbarButton.BROADCAST_PAUSE);
    L16:
        RoomContext r3 = RoomContext.a.c(RoomContext.Companion, r10, 0, 2);
        if (r3 == null) goto L21;
        com.bytedance.live.datacontext.m r5 = r3.getMediaReviewStatus();
        if (r5 == null) goto L21;
        r2 = (Integer) r5.getValue();
    L21:
        if (r2 != null) goto L24;
    L25:
        if (r2 != null) goto L28;
    L29:
        if (r2 != null) goto L32;
    L34:
        boolean r6 = false;
    L36:
        if (r6 == true) goto L38;
        r0.add(ToolbarButton.PUBLIC_SCREEN_CONFIG);
    L38:
        int r7 = com.bytedance.android.livesdk.utils.m3.a;
        if (com.bytedance.android.livesdk.utils.m3.a(com.bytedance.android.live.core.utils.z.c(r10)) == false) goto L41;
    L42:
        r0.add(ToolbarButton.BROADCAST_RESTART);
    L43:
        boolean r8 = true;
    L45:
        if (r8 == false) goto L48;
        return r0;
    L48:
        if (com.bytedance.android.live.core.utils.z.k(r10) == false) goto L130;
        if (r1 == null) goto L55;
        IMIndustryServiceInfo r9 = r1.imIndustryServiceInfo;
        if (r9 == null) goto L55;
        if (r9.isEntranceOpen() != true) goto L55;
        r0.add(ToolbarButton.LIVE_IM_ENTRANCE_MORE);
    L55:
        int r11 = j40.g4.a;
        if (j40.g4.a.a() == false) goto L58;
        r0.add(ToolbarButton.VOTE);
        r0.add(ToolbarButton.LOTTERY);
        r0.add(ToolbarButton.WISH_LIST);
    L58:
        r0.add(ToolbarButton.REVERSE_CAMERA);
        r0.add(ToolbarButton.REVERSE_MIRROR);
        r0.add(ToolbarButton.RECORD);
        r0.add(ToolbarButton.RECORD_COMBINE);
        r0.add(ToolbarButton.INTERACT_GIFT);
        ud0.a.getValue().booleanValue();
        r0.add(ToolbarButton.COMMENT);
        r0.add(ToolbarButton.AUDIO_COMMENT);
        if (com.bytedance.android.livesdk.utils.j.c() == false) goto L61;
        r0.add(ToolbarButton.ANCHOR_BACKTRACK);
    L61:
        r0.add(ToolbarButton.MANAGE);
        if (k(r1) == true) goto L64;
        r0.add(ToolbarButton.SHARE);
    L64:
        r0.add(ToolbarButton.BROADCAST_GIFT);
        if (com.bytedance.android.livesdk.config.q0.a.getValue().booleanValue() == false) goto L68;
        r0.add(ToolbarButton.BROADCAST_TASK);
    L68:
        if (d(r1) == false) goto L71;
        r0.add(ToolbarButton.LIVING_DRAINAGE);
    L71:
        if (l(r1, r10) == false) goto L73;
        r0.add(ToolbarButton.DOU_PLUS_PROMOTE);
    L73:
        m(r10);
        if (i(r1, r10) == false) goto L77;
        r0.add(ToolbarButton.POI);
    L77:
        if (g() == false) goto L80;
        r0.add(ToolbarButton.HASH_TAG);
    L80:
        if (e() == false) goto L82;
        r0.add(ToolbarButton.BROADCAST_PAUSE);
    L82:
        int r12 = com.bytedance.android.livesdk.utils.m3.a;
        if (com.bytedance.android.livesdk.utils.m3.a(com.bytedance.android.live.core.utils.z.c(r10)) == false) goto L85;
    L86:
        RoomSpecificSceneTypeInfo r13 = com.bytedance.android.live.core.utils.z.o(r10).getSceneTypeInfo();
        if (r13 != null) goto L89;
    L91:
        if (r4 == true) goto L93;
        r0.add(ToolbarButton.BROADCAST_RESTART);
    L93:
        r0.add(ToolbarButton.BGM);
        if (db.a.getValue().getLive_anchor_clarity_open() == false) goto L96;
        r0.add(ToolbarButton.IN_ROOM_RESOLUTION);
    L96:
        r0.add(ToolbarButton.ROOM_INTRO);
        r0.add(ToolbarButton.ADVANCE_ANNOUNCEMENT);
        if (f() == false) goto L103;
        if (AnchorFansGroupUtil.a() == false) goto L101;
        r0.add(ToolbarButton.FAN_GROUP_MANAGE);
        goto L103
    L101:
        r0.add(ToolbarButton.FNA_GROUP);
    L103:
        if (com.bytedance.android.live.core.utils.z.k(r10) == false) goto L108;
        if (l4.a.getValue().booleanValue() == false) goto L108;
        r0.add(ToolbarButton.VIDEO_PLAY);
    L108:
        if (j(r10) == false) goto L110;
        r0.add(ToolbarButton.WELFARE_FOLD);
    L110:
        r0.add(ToolbarButton.TICKET_SALE_ANCHOR_MORE);
        r0.add(ToolbarButton.GAME_PROMOTE_MORE);
        if (n5.a(r10) == false) goto L114;
        r0.add(ToolbarButton.REN_QI_BAO);
    L114:
        if (xc.a.getValue().booleanValue() == false) goto L117;
        r0.add(ToolbarButton.ANCHOR_SHOW);
    L117:
        if (h(r1) == false) goto L119;
        r0.add(ToolbarButton.LICENSE_INFO);
    L119:
        r0.add(ToolbarButton.PUBLIC_SCREEN_CONFIG);
        if (com.bytedance.android.livesdk.utils.o.a() == true) goto L122;
    L124:
        r0.add(ToolbarButton.PERMANENT_CHAT_ROOM);
        r0.add(ToolbarButton.PERMANENT_CHAT_GUEST);
        if (((LiveAddPictureConfig) LiveInfraSettingKeys.LIVE_ANCHOR_ADD_PICTURE_CONFIG.getValue()).getEnable() == false) goto L287;
        if (r1.isMediaRoom() == true) goto L287;
        r0.add(ToolbarButton.ADD_PICTURE);
    L287:
        if (tb1.c.a == true) goto L289;
    L291:
        return r0;
    L289:
        if (z90.a.getValue().booleanValue() == false) goto L291;
        r0.add(ToolbarButton.BROADCAST_ADMIN);
        r0.remove(ToolbarButton.REVERSE_MIRROR);
        r0.remove(ToolbarButton.IN_ROOM_RESOLUTION);
        r0.remove(ToolbarButton.AUDIO_COMMENT);
        goto L291
    L122:
        if (r1.isMediaRoom() == true) goto L124;
        r0.add(ToolbarButton.GUARD_BOX);
        goto L124
    L89:
        if (r13.isLandscapeVertical() != true) goto L91;
        r4 = true;
        goto L91
    L85:
        if (com.bytedance.android.livesdk.utils.m3.b(com.bytedance.android.live.core.utils.z.c(r10)) == false) goto L93;
    L130:
        if (com.bytedance.android.live.core.utils.z.g(r10) == false) goto L182;
        r0.add(ToolbarButton.RECORD);
        r0.add(ToolbarButton.RECORD_COMBINE);
        ud0.a.getValue().booleanValue();
        r0.add(ToolbarButton.COMMENT);
        r0.add(ToolbarButton.AUDIO_COMMENT);
        if (com.bytedance.android.livesdk.utils.j.c() == false) goto L134;
        r0.add(ToolbarButton.ANCHOR_BACKTRACK);
    L134:
        r0.add(ToolbarButton.MANAGE);
        if (k(r1) == true) goto L137;
        r0.add(ToolbarButton.SHARE);
    L137:
        r0.add(ToolbarButton.BROADCAST_GIFT);
        if (com.bytedance.android.livesdk.config.q0.a.getValue().booleanValue() == false) goto L141;
        r0.add(ToolbarButton.BROADCAST_TASK);
    L141:
        if (d(r1) == false) goto L144;
        r0.add(ToolbarButton.LIVING_DRAINAGE);
    L144:
        if (l(r1, r10) == false) goto L146;
        r0.add(ToolbarButton.DOU_PLUS_PROMOTE);
    L146:
        m(r10);
        if (g() == false) goto L150;
        r0.add(ToolbarButton.HASH_TAG);
    L150:
        if (e() == false) goto L152;
        r0.add(ToolbarButton.BROADCAST_PAUSE);
    L152:
        int r14 = com.bytedance.android.livesdk.utils.m3.a;
        if (com.bytedance.android.livesdk.utils.m3.a(com.bytedance.android.live.core.utils.z.c(r10)) == false) goto L155;
    L156:
        r0.add(ToolbarButton.BROADCAST_RESTART);
    L157:
        r0.add(ToolbarButton.BGM);
        r0.add(ToolbarButton.KTV_GROUP);
        r0.add(ToolbarButton.ADVANCE_ANNOUNCEMENT);
        r0.add(ToolbarButton.ROOM_INTRO);
        if (f() == false) goto L164;
        if (AnchorFansGroupUtil.a() == false) goto L162;
        r0.add(ToolbarButton.FAN_GROUP_MANAGE);
        goto L164
    L162:
        r0.add(ToolbarButton.FNA_GROUP);
    L164:
        if (j(r10) == false) goto L166;
        r0.add(ToolbarButton.WELFARE_FOLD);
    L166:
        r0.add(ToolbarButton.TICKET_SALE_ANCHOR_MORE);
        r0.add(ToolbarButton.GAME_PROMOTE_MORE);
        if (n5.a(r10) == false) goto L170;
        r0.add(ToolbarButton.REN_QI_BAO);
    L170:
        if (xc.a.getValue().booleanValue() == false) goto L173;
        r0.add(ToolbarButton.ANCHOR_SHOW);
    L173:
        if (h(r1) == false) goto L175;
        r0.add(ToolbarButton.LICENSE_INFO);
    L175:
        r0.add(ToolbarButton.PUBLIC_SCREEN_CONFIG);
        if (com.bytedance.android.livesdk.utils.o.a() == true) goto L178;
    L180:
        r0.add(ToolbarButton.PERMANENT_CHAT_ROOM);
        r0.add(ToolbarButton.PERMANENT_CHAT_GUEST);
        goto L287
    L178:
        if (r1.isMediaRoom() == true) goto L180;
        r0.add(ToolbarButton.GUARD_BOX);
        goto L180
    L155:
        if (com.bytedance.android.livesdk.utils.m3.b(com.bytedance.android.live.core.utils.z.c(r10)) == false) goto L157;
    L182:
        if (com.bytedance.android.live.core.utils.z.i(r10) == false) goto L247;
        ud0.a.getValue().booleanValue();
        r0.add(ToolbarButton.COMMENT);
        r0.add(ToolbarButton.AUDIO_COMMENT);
        r0.add(ToolbarButton.MANAGE);
        if (com.bytedance.android.livesdk.utils.j.c() == false) goto L189;
        kh1.a r15 = kh1.a.a;
        if (kh1.a.d(r1) == true) goto L189;
        r0.add(ToolbarButton.ANCHOR_BACKTRACK);
    L189:
        if (k(r1) == true) goto L191;
        r0.add(ToolbarButton.SHARE);
    L191:
        r0.add(ToolbarButton.BROADCAST_GIFT);
        if (com.bytedance.android.livesdk.config.q0.a.getValue().booleanValue() == false) goto L195;
        r0.add(ToolbarButton.BROADCAST_TASK);
    L195:
        if (d(r1) == false) goto L198;
        r0.add(ToolbarButton.LIVING_DRAINAGE);
    L198:
        if (l(r1, r10) == false) goto L200;
        r0.add(ToolbarButton.DOU_PLUS_PROMOTE);
    L200:
        m(r10);
        if (i(r1, r10) == false) goto L203;
        r0.add(ToolbarButton.POI);
    L203:
        r0.add(ToolbarButton.MESSAGE_PUSH);
        if (g() == false) goto L207;
        r0.add(ToolbarButton.HASH_TAG);
    L207:
        if (rq0.a.getValue().booleanValue() == false) goto L210;
        r0.add(ToolbarButton.LIVE_CONTENT);
    L210:
        if (e() == false) goto L212;
        r0.add(ToolbarButton.BROADCAST_PAUSE);
    L212:
        int r16 = com.bytedance.android.livesdk.utils.m3.a;
        if (com.bytedance.android.livesdk.utils.m3.a(com.bytedance.android.live.core.utils.z.c(r10)) == false) goto L215;
    L216:
        r0.add(ToolbarButton.BROADCAST_RESTART);
    L217:
        r0.add(ToolbarButton.ROOM_INTRO);
        r0.add(ToolbarButton.QUESTION_AND_ANSWER);
        if (f() == false) goto L224;
        if (AnchorFansGroupUtil.a() == false) goto L222;
        r0.add(ToolbarButton.FAN_GROUP_MANAGE);
        goto L224
    L222:
        r0.add(ToolbarButton.FNA_GROUP);
    L224:
        if (j(r10) == false) goto L226;
        r0.add(ToolbarButton.WELFARE_FOLD);
    L226:
        r0.add(ToolbarButton.TICKET_SALE_ANCHOR_MORE);
        r0.add(ToolbarButton.GAME_PROMOTE_MORE);
        if (n5.a(r10) == false) goto L230;
        r0.add(ToolbarButton.REN_QI_BAO);
    L230:
        if (xc.a.getValue().booleanValue() == false) goto L233;
        r0.add(ToolbarButton.ANCHOR_SHOW);
    L233:
        if (mq0.a.getValue().booleanValue() == false) goto L236;
        r0.add(ToolbarButton.BGM);
    L236:
        if (h(r1) == false) goto L238;
        r0.add(ToolbarButton.LICENSE_INFO);
    L238:
        r0.add(ToolbarButton.PUBLIC_SCREEN_CONFIG);
        if (com.bytedance.android.livesdk.utils.o.a() == true) goto L241;
    L243:
        r0.add(ToolbarButton.PERMANENT_CHAT_ROOM);
        r0.add(ToolbarButton.PERMANENT_CHAT_GUEST);
        if (eq0.a.getValue().booleanValue() == false) goto L287;
        r0.add(ToolbarButton.ADVANCE_ANNOUNCEMENT);
        goto L287
    L241:
        if (r1.isMediaRoom() == true) goto L243;
        r0.add(ToolbarButton.GUARD_BOX);
        goto L243
    L215:
        if (com.bytedance.android.livesdk.utils.m3.b(com.bytedance.android.live.core.utils.z.c(r10)) == false) goto L217;
    L247:
        if (com.bytedance.android.live.core.utils.z.j(r10) == false) goto L287;
        int r17 = j40.g4.a;
        if (j40.g4.a.a() == false) goto L251;
        r0.add(ToolbarButton.VOTE);
        r0.add(ToolbarButton.LOTTERY);
        r0.add(ToolbarButton.WISH_LIST);
    L251:
        r0.add(ToolbarButton.PUSH_URL);
        r0.add(ToolbarButton.RECORD);
        r0.add(ToolbarButton.RECORD_COMBINE);
        ud0.a.getValue().booleanValue();
        r0.add(ToolbarButton.COMMENT);
        r0.add(ToolbarButton.AUDIO_COMMENT);
        if (com.bytedance.android.livesdk.utils.j.c() == false) goto L254;
        r0.add(ToolbarButton.ANCHOR_BACKTRACK);
    L254:
        r0.add(ToolbarButton.MANAGE);
        if (k(r1) == true) goto L257;
        r0.add(ToolbarButton.SHARE);
    L257:
        r0.add(ToolbarButton.BROADCAST_GIFT);
        if (com.bytedance.android.livesdk.config.q0.a.getValue().booleanValue() == false) goto L261;
        r0.add(ToolbarButton.BROADCAST_TASK);
    L261:
        if (d(r1) == false) goto L264;
        r0.add(ToolbarButton.LIVING_DRAINAGE);
    L264:
        if (l(r1, r10) == false) goto L266;
        r0.add(ToolbarButton.DOU_PLUS_PROMOTE);
    L266:
        m(r10);
        if (g() == false) goto L269;
        r0.add(ToolbarButton.HASH_TAG);
    L269:
        r0.add(ToolbarButton.ROOM_INTRO);
        if (f() == true) goto L272;
    L275:
        r0.add(ToolbarButton.GAME_PROMOTE_MORE);
        if (n5.a(r10) == false) goto L279;
        r0.add(ToolbarButton.REN_QI_BAO);
    L279:
        if (h(r1) == false) goto L281;
        r0.add(ToolbarButton.LICENSE_INFO);
    L281:
        r0.add(ToolbarButton.PUBLIC_SCREEN_CONFIG);
        if (com.bytedance.android.livesdk.utils.o.a() == false) goto L287;
        if (r1.isMediaRoom() == true) goto L287;
        r0.add(ToolbarButton.GUARD_BOX);
        goto L287
    L272:
        if (AnchorFansGroupUtil.a() == false) goto L274;
        r0.add(ToolbarButton.FAN_GROUP_MANAGE);
        goto L275
    L274:
        r0.add(ToolbarButton.FNA_GROUP);
        goto L275
    L41:
        if (com.bytedance.android.livesdk.utils.m3.b(com.bytedance.android.live.core.utils.z.c(r10)) == false) goto L43;
    L32:
        if (r2.intValue() != 3) goto L34;
    L35:
        r6 = true;
        goto L36
    L28:
        if (r2.intValue() == 2) goto L35;
    L24:
        if (r2.intValue() == 1) goto L35;
    L44:
        r8 = false;
        goto L45
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.v
    public final List<ToolbarButton> b(DataCenter r3) {
        Intrinsics.checkNotNullParameter(r3, "dataCenter");
        ArrayList r0 = new ArrayList();
        if (com.bytedance.android.live.core.utils.z.h(r3) == false) goto L7;
        r0.add(ToolbarButton.PK);
        return r0;
    L7:
        if (com.bytedance.android.live.core.utils.z.k(r3) == false) goto L16;
        r0.add(ToolbarButton.PK);
        if (qi0.a.getValue().booleanValue() == false) goto L12;
        r0.add(ToolbarButton.MULTI_SCENE_GAME_PLAY);
    L12:
        if (com.bytedance.android.livesdk.config.o3.a.getValue().booleanValue() == false) goto L14;
        r0.add(ToolbarButton.TEAM_FIGHT);
        r0.add(ToolbarButton.INTERACTION);
    L14:
        r0.add(ToolbarButton.AUDIO_TOGGLE);
    L24:
        return r0;
    L16:
        if (com.bytedance.android.live.core.utils.z.g(r3) == false) goto L22;
        r0.add(ToolbarButton.PK);
        if (vl0.a.getValue().booleanValue() == false) goto L20;
        r0.add(ToolbarButton.INTERACTION_SCENE);
        r0.add(ToolbarButton.TEAM_FIGHT);
        r0.add(ToolbarButton.INTERACTION);
        r0.add(ToolbarButton.INTERACTION_ROOM);
    L20:
        r0.add(ToolbarButton.AUDIO_TOGGLE);
        goto L24
    L22:
        if (com.bytedance.android.live.core.utils.z.i(r3) == false) goto L24;
        r0.add(ToolbarButton.PK);
        goto L24
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.v
    public final List<ToolbarButton> c(DataCenter r5) {
        Intrinsics.checkNotNullParameter(r5, "dataCenter");
        ArrayList r0 = new ArrayList();
        LiveMode r1 = (LiveMode) r5.get("data_live_mode", LiveMode.VIDEO);
        Room r2 = (Room) r5.get("data_room");
        r0.add(ToolbarButton.LIVE_IM_ENTRANCE);
        r0.add(ToolbarButton.CHANNEL_COMMENT);
        r0.add(ToolbarButton.SQUARE_COMMENT);
        if (com.bytedance.android.live.core.utils.z.k(r5) == false) goto L6;
        r0.add(ToolbarButton.ATTACK_AND_DEFENSE);
    L6:
        if (com.bytedance.android.live.core.utils.z.h(r5) == false) goto L13;
        r0.add(ToolbarButton.BROADCAST_EFFECT);
        if (j(r5) == false) goto L10;
        r0.add(ToolbarButton.WELFARE);
    L10:
        r0.add(ToolbarButton.CLOSE_ROOM);
        r0.add(ToolbarButton.MORE);
        return r0;
    L13:
        if (com.bytedance.android.live.core.utils.z.k(r5) == true) goto L39;
        if (com.bytedance.android.live.core.utils.z.g(r5) == true) goto L39;
        if (com.bytedance.android.live.core.utils.z.i(r5) == false) goto L30;
        r0.add(ToolbarButton.INTERACT_GAME);
        r0.add(ToolbarButton.BROADCAST_EFFECT);
        r0.add(ToolbarButton.TICKET_SALE_ANCHOR);
        r0.add(ToolbarButton.GAME_PROMOTE);
        r0.add(ToolbarButton.COMMERCE);
        r0.add(ToolbarButton.LITTLE_GAME);
        if (com.bytedance.android.livesdk.chatroom.utils.k0.e(r1) == false) goto L22;
        r0.add(ToolbarButton.TRANSFORM_WIDGET);
    L22:
        int r3 = ToolbarGroupPurchaseWidgetBehavior.l;
        if (ToolbarGroupPurchaseWidgetBehavior.a.a(r1) == false) goto L26;
        r0.add(ToolbarButton.GROUP_PURCHASE);
    L26:
        if (j(r5) == false) goto L28;
        r0.add(ToolbarButton.WELFARE);
    L28:
        r0.add(ToolbarButton.CLOSE_ROOM);
        r0.add(ToolbarButton.MORE);
    L66:
        return r0;
    L30:
        if (com.bytedance.android.live.core.utils.z.j(r5) == false) goto L66;
        r0.add(ToolbarButton.INTERACT_GAME);
        r0.add(ToolbarButton.BROADCAST_EFFECT);
        r0.add(ToolbarButton.GAME_PROMOTE);
        r0.add(ToolbarButton.COMMERCE);
        if (com.bytedance.android.livesdk.chatroom.utils.k0.e(r1) == false) goto L34;
        r0.add(ToolbarButton.TRANSFORM_WIDGET);
    L34:
        int r6 = ToolbarGroupPurchaseWidgetBehavior.l;
        if (ToolbarGroupPurchaseWidgetBehavior.a.a(r1) == false) goto L37;
        r0.add(ToolbarButton.GROUP_PURCHASE);
    L37:
        r0.add(ToolbarButton.CLOSE_ROOM);
        r0.add(ToolbarButton.MORE);
    L39:
        if (LiveOpenFeatureChooseConfig.useV3() == false) goto L41;
        r0.add(ToolbarButton.INTERACT_PLAY_FOR_GROUP_LIVE_GAME);
        r0.add(ToolbarButton.INTERACT_PLAY);
        r0.add(ToolbarButton.LITTLE_GAME);
    L41:
        r0.add(ToolbarButton.INTERACT_GAME);
        if (r2 != null) goto L44;
    L46:
        r0.add(ToolbarButton.BROADCAST_EFFECT);
    L47:
        ToolbarButton r4 = ToolbarButton.INTERACT_PLAY_FOR_GROUP_LIVE_GAME;
        if (r0.contains(r4) == true) goto L50;
        r0.add(r4);
    L50:
        ToolbarButton r7 = ToolbarButton.INTERACT_PLAY;
        if (r0.contains(r7) == true) goto L53;
        r0.add(r7);
    L53:
        r0.add(ToolbarButton.OPEN_PLATFORM_MINI_APP);
        r0.add(ToolbarButton.TICKET_SALE_ANCHOR);
        r0.add(ToolbarButton.GAME_PROMOTE);
        r0.add(ToolbarButton.COMMERCE);
        ToolbarButton r8 = ToolbarButton.LITTLE_GAME;
        if (r0.contains(r8) == true) goto L57;
        r0.add(r8);
    L57:
        if (com.bytedance.android.livesdk.chatroom.utils.k0.e(r1) == false) goto L59;
        r0.add(ToolbarButton.TRANSFORM_WIDGET);
    L59:
        int r9 = ToolbarGroupPurchaseWidgetBehavior.l;
        if (ToolbarGroupPurchaseWidgetBehavior.a.a(r1) == false) goto L63;
        r0.add(ToolbarButton.GROUP_PURCHASE);
    L63:
        if (j(r5) == false) goto L65;
        r0.add(ToolbarButton.WELFARE);
    L65:
        r0.add(ToolbarButton.CLOSE_ROOM);
        r0.add(ToolbarButton.MORE);
        r0.add(ToolbarButton.GAME_EXIT);
        r0.add(ToolbarButton.GAME_GUESS);
        r0.add(ToolbarButton.OPEN_PLATFORM_LYNX_GAME);
        goto L66
    L44:
        if (r2.isVirtualLive != true) goto L46;
        r0.add(ToolbarButton.VIRTUAL_LIVE);
        goto L47
    }

    public static boolean i(Room r2, DataCenter r3) {
        com.bytedance.android.livesdk.user.f r4 = (com.bytedance.android.livesdk.user.f) r3.get("data_user_center", null);
        if (r4 == null) goto L20;
        IUser r5 = r4.b();
        if ((r5 instanceof User) == false) goto L21;
        if (r2 == null) goto L10;
        RoomAuthStatus r6 = r2.getRoomAuthStatus();
        if (r6 == null) goto L10;
        int r1 = au2.a.a;
        boolean r7 = r6.getEnablePoi();
    L11:
        if (r7 == true) goto L13;
        return false;
    L13:
        if (r5.getPoiInfo() != null) goto L15;
        return false;
    L15:
        if (r5.getPoiInfo().isPoiPermission() == true) goto L17;
        return false;
    L17:
        if (r5.getSecret() == 1) goto L25;
        return true;
    L25:
        return false;
    L10:
        r7 = false;
        goto L11
    L21:
        return false;
    L20:
        return false;
    }

    public static boolean l(Room r1, DataCenter r2) {
        if (r1 == null) goto L7;
        if (r1.isDouPlusPromotion != true) goto L7;
        return true;
    L7:
        if (com.bytedance.android.livesdk.utils.c1.a(r2).hasDouPlusEntry == true) goto L12;
        return false;
    L12:
        return true;
    }
}
