package com.bytedance.android.livesdk.drawer.relax;

import com.bytedance.android.livesdk.link.model.z5;
import com.bytedance.android.livesdkapi.depend.model.live.EcomData;
import com.bytedance.android.livesdkapi.depend.model.live.IRoomCart;
import com.bytedance.android.livesdkapi.depend.model.live.IRoomCartV2;
import com.bytedance.android.livesdkapi.depend.model.live.LinkMicBattleSetting;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.depend.model.live.RoomLifeGrouponInfo;
import com.bytedance.android.livesdkapi.depend.model.live.RoomLinkInfo;
import com.bytedance.salamander.anniex.l2;
import com.bytedance.salamander.anniex.y3;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class LiveDrawerLog {
    public static final Companion a = null;

    public static final class Companion {
        public Companion() {
        }

        public static void b(String r3, Map r4) {
            Intrinsics.checkNotNullParameter(r3, "eventName");
            final LinkedHashMap r0 = new LinkedHashMap();
            com.bytedance.rts.foundation.m.e(r0, "enter_from_merge", "drawer_hot");
            com.bytedance.rts.foundation.m.e(r0, "enter_method", "live_history_page");
            if (r4 == null) goto L5;
            com.bytedance.rts.foundation.m.d(r4, new LiveDrawerLog$Companion$sendLogCommonParams$1(r0));
        L5:
            Companion r1 = LiveDrawerLog.a;
            if (r4 != null) goto L8;
            r4 = new LinkedHashMap();
        L8:
            r1.getClass();
            a(r3, r4, null);
            int r5 = l2.a;
            y3 r6 = new y3(r3, r0);
            LiveDrawerLog$Companion$sendLogCommonParams$2 r7 = LiveDrawerLog$Companion$sendLogCommonParams$2.INSTANCE;
            Intrinsics.checkNotNullParameter(r6, "params");
            Intrinsics.checkNotNullParameter(r7, "callback");
            com.bytedance.salamander.bridge.k.a(r6, r7);
        }

        public static void a(final String r2, Map r3, e r4) {
            Intrinsics.checkNotNullParameter(r2, "eventName");
            Intrinsics.checkNotNullParameter(r3, "params");
            final LinkedHashMap r0 = new LinkedHashMap();
            if (r4 == null) goto L9;
            Function0<? extends Map<String, Object>> r5 = r4.i;
            if (r5 == null) goto L9;
            Map r6 = (Map) r5.invoke();
            if (r6 == null) goto L9;
            com.bytedance.rts.foundation.m.d(r6, new LiveDrawerLog$Companion$reportAppLog$1(r0));
        L9:
            com.bytedance.rts.foundation.m.d(r3, new LiveDrawerLog$Companion$reportAppLog$2(r0));
            int r7 = com.bytedance.salamander.adapter.r.a;
            Function1<Boolean, Object> r8 = new LiveDrawerLog$Companion$reportAppLog$3(r2, r0);
            com.bytedance.salamander.adapter.i r9 = com.bytedance.salamander.adapter.i.d;
            if (r9 != null) goto L12;
            r9 = new com.bytedance.salamander.adapter.i("", true);
        L12:
            com.bytedance.salamander.adapter.r.a.a(r8, r9, 0.0d);
        }

        public static Map c(Room r20, String r21, String r22, Map r23, String r24, e r25) {
            Intrinsics.checkNotNullParameter(r20, "room");
            Intrinsics.checkNotNullParameter(r21, "enterFromMerge");
            Intrinsics.checkNotNullParameter(r22, "enterMethod");
            Intrinsics.checkNotNullParameter(r23, "extraParams");
            Intrinsics.checkNotNullParameter(r20, "curRoom");
            Intrinsics.checkNotNullParameter(r21, "enterFromMerge");
            Intrinsics.checkNotNullParameter(r22, "enterMethod");
            Intrinsics.checkNotNullParameter(r23, "extraParams");
            Object[][] r5 = new Object[6][];
            int r10 = 1;
            r5[0] = new Object[]{"enter_from_merge", r21};
            r5[1] = new Object[]{"enter_method", r22};
            r5[2] = new Object[]{"action_type", "click"};
            r5[3] = new Object[]{"liveroom_orientation", 0};
            r5[4] = new Object[]{"room_orientation", 0};
            Object[] r1 = new Object[2];
            r1[0] = "request_id";
            if (r24 != null) goto L5;
            String r2 = "";
        L6:
            r1[1] = r2;
            r5[5] = r1;
            final Map r3 = com.bytedance.rts.foundation.m.a(com.bytedance.rts.foundation.j.k(r5));
            com.bytedance.rts.foundation.m.d(r23, new LiveDrawerLog$Companion$paramsFromRoom$1(r3));
            int r4 = com.bytedance.rts.foundation.f.a;
            String r6 = r20.getItemExplicitInfo();
            if (r6 != null) goto L9;
            r6 = "{}";
        L9:
            Integer r7 = (Integer) com.bytedance.rts.foundation.g.j(com.bytedance.rts.foundation.f.a.c(r6, LiveDrawerLog$Companion$paramsFromRoom$info$1.INSTANCE), "is_ecom_live");
            if (r7 != null) goto L13;
        L15:
            int r8 = 0;
        L16:
            com.bytedance.rts.foundation.m.e(r3, "is_ecom_live", Integer.valueOf(r8));
            z5 r9 = r20.getLinkerDetail();
            if (r9 == null) goto L21;
            List r11 = r9.getPlayModes();
            if (r11 == null) goto L21;
            Boolean r12 = Boolean.valueOf(com.bytedance.rts.foundation.j.n(r11, LiveDrawerLog$Companion$paramsFromRoom$openContainerCasting$1.INSTANCE));
        L22:
            Boolean r13 = Boolean.TRUE;
            com.bytedance.rts.foundation.m.e(r3, "is_share_screen", Integer.valueOf(Intrinsics.areEqual(r12, r13) ? 1 : 0));
            Map r14 = r20.getLinkMap();
            if (r14 == null) goto L25;
            Long r15 = (Long) r14.get("1");
        L26:
            Map r16 = r20.getLinkMap();
            if (r16 == null) goto L29;
            Long r17 = (Long) r16.get("7");
        L30:
            String r18 = "individual_pvp";
            String r19 = "connection";
            if (r15 != null) goto L33;
        L43:
            if (r17 != null) goto L45;
        L66:
            if (r15 != null) goto L68;
        L69:
            if (r17 != null) goto L71;
        L132:
            if (r20.getRoomCart() == null) goto L135;
            IRoomCart r26 = r20.getRoomCart();
            Intrinsics.checkNotNull(r26);
            if (r26.getShowCartExt() == 0) goto L135;
        L141:
            com.bytedance.rts.foundation.m.e(r3, "is_ecom_cart", 1);
        L143:
            RoomLifeGrouponInfo r27 = r20.lifeGrouponInfo;
            if (r27 == null) goto L153;
            Intrinsics.checkNotNull(r27);
            if (r27.getAggCardId() == null) goto L150;
            RoomLifeGrouponInfo r28 = r20.lifeGrouponInfo;
            Intrinsics.checkNotNull(r28);
            Long r29 = r28.getAggCardId();
            Intrinsics.checkNotNull(r29);
            if (r29.longValue() <= 0) goto L150;
        L151:
            com.bytedance.rts.foundation.m.e(r3, "is_life_cart", Integer.valueOf(r10));
        L150:
            r10 = 0;
        L153:
            if (r20.getContentLabel() == null) goto L160;
            py.k r0 = r20.getContentLabel();
            Intrinsics.checkNotNull(r0);
            Integer r30 = r0.getImageType();
            if (r30 == null) goto L157;
            int r31 = r30.intValue();
        L158:
            com.bytedance.rts.foundation.m.e(r3, "drawer_room_icon_type", Integer.valueOf(r31));
            goto L160
        L157:
            r31 = 0;
        L160:
            if (r25 == null) goto L166;
            Function0<? extends Map<String, Object>> r32 = r25.i;
            if (r32 == null) goto L166;
            Map r33 = (Map) r32.invoke();
            if (r33 == null) goto L166;
            Object r34 = r33.get("launch_method");
        L168:
            if (Intrinsics.areEqual((String) r34, "shortcuts") == false) goto L170;
            com.bytedance.rts.foundation.m.e(r3, "launch_method", "live_shortcut");
        L171:
            return r3;
        L170:
            com.bytedance.rts.foundation.m.e(r3, "launch_method", "others");
        L166:
            r34 = null;
        L135:
            EcomData r35 = r20.ecomData;
            if (r35 == null) goto L142;
            IRoomCartV2 r36 = r35.getRoomCartV2();
            if (r36 == null) goto L142;
            if (r36.getShowCart() == 1) goto L141;
        L142:
            com.bytedance.rts.foundation.m.e(r3, "is_ecom_cart", 0);
            goto L143
        L71:
            if (r17.longValue() <= 0) goto L132;
        L72:
            RoomLinkInfo r37 = r20.getLinkMicInfo();
            if (r37 == null) goto L75;
            LinkMicBattleSetting r38 = r37.battleSetting;
        L76:
            RoomLinkInfo r39 = r20.getLinkMicInfo();
            if (r39 == null) goto L79;
            Long r40 = Long.valueOf(r39.channelId);
        L80:
            if (r40 == null) goto L89;
            RoomLinkInfo r41 = r20.getLinkMicInfo();
            Intrinsics.checkNotNull(r41);
            if (r41.channelId <= 0) goto L89;
            if (r38 == null) goto L89;
            if (r38.finished != 0) goto L89;
            if (r38.battleId <= 0) goto L89;
            boolean r42 = true;
        L90:
            if (r42 == false) goto L121;
            Intrinsics.checkNotNull(r38);
            Intrinsics.checkNotNullParameter(r38, "battleSettings");
            long r43 = r38.playMode;
            if (r43 != 10) goto L95;
        L96:
            String r44 = "customize_pk";
        L97:
            r19 = r44;
            long r45 = r38.battleId;
        L122:
            com.bytedance.rts.foundation.m.e(r3, "invite_mode", r19);
            com.bytedance.rts.foundation.m.e(r3, "pk_id", Long.valueOf(r45));
            RoomLinkInfo r46 = r20.getLinkMicInfo();
            if (r46 == null) goto L125;
            long r47 = r46.channelId;
        L126:
            com.bytedance.rts.foundation.m.e(r3, "channel_id", Long.valueOf(r47));
            RoomLinkInfo r48 = r20.getLinkMicInfo();
            if (r48 == null) goto L129;
            long r49 = r48.linkmicAnchorCount;
        L130:
            com.bytedance.rts.foundation.m.e(r3, "anchor_connect_status", Long.valueOf(r49));
            goto L132
        L129:
            r49 = 0;
            goto L130
        L125:
            r47 = 0;
            goto L126
        L95:
            if (r43 == 11) goto L96;
            if (r43 != 101) goto L102;
            r44 = "vote";
            goto L97
        L102:
            if (r43 != 102) goto L105;
            r44 = "cooperation";
            goto L97
        L105:
            if (r43 != 201) goto L108;
            r44 = "compete";
            goto L97
        L108:
            if (r43 != 300) goto L111;
            r44 = "focus_gift";
            goto L97
        L111:
            if (r43 != 400) goto L114;
            r44 = "still_standing";
            goto L97
        L114:
            if (r38.teamMode != 1) goto L117;
            r44 = "team_pk";
            goto L97
        L117:
            if (r38.activityMode != 1) goto L119;
            r44 = "activity_pk";
            goto L97
        L119:
            r44 = "routine_pk";
            goto L97
        L121:
            r45 = 0;
        L89:
            r42 = false;
            goto L90
        L79:
            r40 = null;
            goto L80
        L75:
            r38 = null;
            goto L76
        L68:
            if (r15.longValue() > 0) goto L72;
        L45:
            if (r17.longValue() <= 0) goto L66;
            z5 r50 = r20.getLinkerDetail();
            if (r50 == null) goto L51;
            List r51 = r50.getPlayModes();
            if (r51 == null) goto L51;
            Boolean r52 = Boolean.valueOf(com.bytedance.rts.foundation.j.n(r51, LiveDrawerLog$Companion$paramsFromRoom$isTeamPK$1.INSTANCE));
        L52:
            z5 r53 = r20.getLinkerDetail();
            if (r53 == null) goto L57;
            List r54 = r53.getPlayModes();
            if (r54 == null) goto L57;
            Boolean r55 = Boolean.valueOf(com.bytedance.rts.foundation.j.n(r54, LiveDrawerLog$Companion$paramsFromRoom$isIndividualPK$1.INSTANCE));
        L59:
            if (Intrinsics.areEqual(r52, r13) == false) goto L62;
            r18 = "team_pvp";
        L65:
            com.bytedance.rts.foundation.m.e(r3, "room_scene", 7);
            com.bytedance.rts.foundation.m.e(r3, "room_link_status", r18);
            goto L66
        L62:
            if (Intrinsics.areEqual(r55, r13) == true) goto L65;
            r18 = "connection";
        L57:
            r55 = null;
        L51:
            r52 = null;
            goto L52
        L33:
            if (r15.longValue() <= 0) goto L43;
            RoomLinkInfo r56 = r20.getLinkMicInfo();
            if (r56 == null) goto L41;
            LinkMicBattleSetting r57 = r56.battleSetting;
            if (r57 == null) goto L41;
            if (r57.finished != 0) goto L41;
        L42:
            com.bytedance.rts.foundation.m.e(r3, "room_scene", 1);
            com.bytedance.rts.foundation.m.e(r3, "room_link_status", r18);
        L41:
            r18 = "connection";
            goto L42
        L29:
            r17 = null;
            goto L30
        L25:
            r15 = null;
        L21:
            r12 = null;
            goto L22
        L13:
            if (r7.intValue() != 1) goto L15;
            r8 = 1;
            goto L16
        L5:
            r2 = r24;
            goto L6
        }
    }

    static {
        a = new Companion();
    }
}
