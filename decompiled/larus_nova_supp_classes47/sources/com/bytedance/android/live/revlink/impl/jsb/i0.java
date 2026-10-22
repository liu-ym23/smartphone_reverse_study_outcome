package com.bytedance.android.live.revlink.impl.jsb;

import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.browser.jsbridge.base.TrackPKEventResultModel;
import com.bytedance.android.live.profile.monitor.DataType;
import com.bytedance.android.live.revlink.impl.LinkCrossRoomDataHolder;
import com.bytedance.android.live.revlink.impl.pk.service.IPKLinkBizDataService;
import com.bytedance.android.live.revlink.impl.pk.vm.linkout.PkCustomizePlayDataContext;
import com.bytedance.android.livesdk.link.model.IBattleConfigSetting;
import com.bytedance.android.livesdk.link.model.ILinkMicBattleInviteMessage;
import com.bytedance.android.livesdk.link.model.IProfitGameStatusMessage;
import com.bytedance.android.livesdk.link.model.api.IBaseBattleSetting;
import com.bytedance.android.livesdk.link.model.ca;
import com.bytedance.android.livesdk.link.model.n3;
import com.bytedance.android.livesdk.link.model.v2;
import com.bytedance.android.livesdk.revenue.log.LogCommon;
import com.bytedance.android.livesdkapi.depend.model.live.IRoomBase;
import com.bytedance.android.livesdkapi.depend.model.live.IRoomKtKt;
import com.bytedance.ies.web.jsbridge2.CallContext;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.TypesJVMKt;
import org.json.JSONObject;
import w20.gf;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class i0 extends wy0.b<gf, TrackPKEventResultModel> {
    public final Type a;
    public final com.bytedance.android.livesdk.revenue.service.room.c b;
    public final yz0.g c;
    public final com.bytedance.android.live.revlink.impl.global.c d;

    public final com.bytedance.android.live.revlink.impl.multianchor.utils.q m() {
        com.bytedance.android.live.revlink.impl.global.c r0 = this.d;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getMultiAnchorLinkLogUtils();
    }

    public final com.bytedance.android.live.revlink.impl.mergepk.pkbase.e n() {
        com.bytedance.android.live.revlink.impl.global.c r0 = this.d;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.Ig();
    }

    public final d31.d o() {
        com.bytedance.android.live.revlink.impl.global.c r0 = this.d;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getRevLinkLogHelper();
    }

    @Override // wy0.b
    public final Type k() {
        return this.a;
    }

    @Override // wy0.b
    public final void l(vh7.j r44, CallContext r45) {
        gf r1 = (gf) r44;
        Intrinsics.checkNotNullParameter(r1, "params");
        Intrinsics.checkNotNullParameter(r45, "callContext");
        jy0.b.d("TrackPKEventMethod", "param: " + r1);
        com.bytedance.android.live.revlink.impl.global.c r2 = this.d;
        if (r2 == null) goto L5;
        com.bytedance.android.live.revlink.impl.service.internal.a r3 = r2.Do();
    L6:
        if (r3 == null) goto L664;
        int r4 = r3.getCurrentMode();
        String r5 = r1.c1();
        if (r5 == null) goto L664;
        JSONObject r6 = new JSONObject(r1.getExtra().toString());
        String r32 = "";
        if (com.bytedance.android.live.utils.c.a(r4, 4) == false) goto L337;
        LinkedHashMap r7 = new LinkedHashMap();
        yz0.g r12 = this.c;
        if (r12 == null) goto L21;
        IRoomBase r13 = r12.mo444getRoom();
        if (r13 == null) goto L21;
        IBaseUser r14 = r13.getOwnerKt();
        if (r14 == null) goto L21;
        String r15 = r14.getIdString();
        if (r15 == null) goto L21;
    L22:
        com.bytedance.android.live.revlink.impl.global.c r16 = this.d;
        if (r16 == null) goto L25;
        com.bytedance.android.live.revlink.impl.utils.s r17 = r16.getRevLinkCommonUtil();
    L26:
        if (r17 == null) goto L28;
        String r18 = r17.e();
    L29:
        String r19 = String.valueOf(r18);
        r7.put("user_id", r19);
        r7.put("anchor_id", r15);
        yz0.g r8 = this.c;
        if (r8 == null) goto L35;
        IRoomBase r9 = r8.mo444getRoom();
        if (r9 == null) goto L35;
        String r10 = String.valueOf(IRoomKtKt.getId(r9));
        if (r10 == null) goto L35;
    L36:
        r7.put("room_id", r10);
        com.bytedance.android.live.revlink.impl.multianchor.utils.q r20 = m();
        if (r20 == null) goto L41;
        LinkCrossRoomDataHolder r22 = r20.f();
        if (r22 == null) goto L41;
        Long r23 = Long.valueOf(r22.c());
    L42:
        r7.put("channel_id", String.valueOf(r23));
        com.bytedance.android.live.revlink.impl.global.c r24 = this.d;
        if (r24 == null) goto L45;
        w31.c r25 = r24.getPkLinkUtils();
    L46:
        if (r25 == null) goto L48;
        Long r26 = Long.valueOf(r25.i());
    L49:
        r7.put("pk_id", String.valueOf(r26));
        if (Intrinsics.areEqual(r19, r15) == false) goto L52;
        Object r27 = DataType.TRUE;
    L53:
        r7.put("is_anchor", r27);
        if (Intrinsics.areEqual(r19, r15) == false) goto L56;
        Object r28 = DataType.FALSE;
    L57:
        r7.put("user_type", r28);
        com.bytedance.android.live.revlink.impl.global.c r29 = this.d;
        if (r29 == null) goto L60;
        w31.c r30 = r29.getPkLinkUtils();
    L61:
        if (r30 == null) goto L72;
        com.bytedance.android.live.revlink.impl.global.c r33 = r30.c;
        if (r33 == null) goto L65;
        com.bytedance.android.live.revlink.impl.mergepk.pkbase.e r34 = r33.Ig();
    L66:
        if (r34 == null) goto L70;
        IBaseBattleSetting r35 = r34.getBattleSettings();
        if (r35 == null) goto L70;
        int r36 = (int) r35.getDuration();
    L71:
        Integer r37 = Integer.valueOf(r36);
    L73:
        r7.put("pk_time", String.valueOf(r37));
        com.bytedance.android.live.revlink.impl.multianchor.utils.q r38 = m();
        if (r38 == null) goto L90;
        LinkCrossRoomDataHolder r39 = r38.f();
        if (r39 == null) goto L90;
        if (r39.l().length() != 0) goto L80;
        boolean r40 = true;
    L82:
        if (r40 != true) goto L90;
        mz0.e<?> r42 = mz0.d.b(LogCommon.ROOM);
        if (r42 == null) goto L95;
        Map<String, String> r43 = ((com.bytedance.android.live.revenue.platform.log.impl.filterimpl.a) r42).getMap();
        if (r43 == null) goto L95;
        String r46 = r43.get("request_id");
        if (r46 == null) goto L95;
    L96:
        r7.put("request_id", r46);
        r7.put("anchor_connect_status", "2");
        r7.put("connection_anchor_cnt", "2");
        r7.put("pk_anchor_cnt", "2");
        r7.put("npk_link_type", "single");
        com.bytedance.android.live.revlink.impl.global.c r47 = this.d;
        if (r47 == null) goto L99;
        com.bytedance.android.live.revlink.impl.multianchor.dialog.linkopt.f r48 = r47.getLinkPlayHelper();
    L100:
        if (r48 != null) goto L102;
    L116:
        d31.d r49 = o();
        if (r49 == null) goto L127;
        com.bytedance.android.live.revlink.impl.global.c r50 = this.d;
        if (r50 == null) goto L121;
        com.bytedance.android.live.revlink.impl.multianchor.vm.g r52 = r50.getMultiAnchorLinkContextObj();
    L122:
        if (r52 == null) goto L124;
        int r53 = r52.b();
    L125:
        String r54 = r49.p(r53);
        if (r54 == null) goto L127;
    L128:
        r7.put("invitee_list", r54);
        d31.d r55 = o();
        if (r55 == null) goto L131;
        String r56 = r55.c();
    L132:
        r7.put("connection_type", r56);
        if (o() == null) goto L135;
        Integer r57 = Integer.valueOf(n41.a.b());
    L136:
        r7.put("audience_connect_cnt", String.valueOf(r57));
        d31.d r58 = o();
        if (r58 == null) goto L139;
        String r59 = r58.f();
    L140:
        r7.put("invite_mode", r59);
        d31.d r60 = o();
        if (r60 == null) goto L143;
        String r62 = r60.d();
    L144:
        r7.put("battle_mode", r62);
        com.bytedance.android.live.revlink.impl.mergepk.pkbase.e r63 = n();
        if (r63 != null) goto L147;
    L149:
        Object r64 = DataType.FALSE;
    L150:
        r7.put("is_oncemore", r64);
        d31.d r65 = o();
        if (r65 == null) goto L153;
        String r66 = r65.s();
    L154:
        r7.put("room_status", r66);
        d31.d r67 = o();
        if (r67 == null) goto L157;
        String r68 = r67.o();
    L158:
        r7.put("is_manager", r68);
        com.bytedance.android.live.revlink.impl.global.c r69 = this.d;
        if (r69 == null) goto L161;
        d31.e r70 = r69.q4();
    L162:
        if (r70 == null) goto L164;
        String r72 = r70.a();
    L165:
        r7.put("source", r72);
        d31.d r73 = o();
        if (r73 == null) goto L168;
        String r74 = r73.b();
    L169:
        r7.put("connection_sub_type", r74);
        com.bytedance.android.live.revlink.impl.global.c r75 = this.d;
        if (r75 == null) goto L172;
        IPKLinkBizDataService r76 = r75.mk();
    L173:
        if (r76 == null) goto L178;
        cy0.e.a.getClass();
        cy0.j r77 = cy0.e.a.a;
        com.bytedance.android.scope.m.e.getClass();
        Object r78 = com.bytedance.android.scope.m.b(r77).b(com.bytedance.android.livesdk.revenue.service.user.a.class);
        Intrinsics.checkNotNull(r78);
        String r79 = r76.getTransformReason(null, ((com.bytedance.live.kmp.core.c) r78).getCurrentUserId());
        if (r79 == null) goto L178;
    L179:
        r7.put("transform_reason", r79);
        com.bytedance.android.live.revlink.impl.global.c r80 = this.d;
        if (r80 == null) goto L182;
        com.bytedance.android.live.revlink.impl.pk.utils.q r82 = r80.getPkUtils();
    L183:
        if (r82 == null) goto L188;
        PkCustomizePlayDataContext r83 = r82.f();
        if (r83 == null) goto L188;
        IBattleConfigSetting r84 = r83.getBattleConfigSetting();
        if (r84 == null) goto L188;
    L192:
        if (r84 == null) goto L196;
        v2 r85 = r84.getSelfSettingRate();
        if (r85 == null) goto L196;
        int r86 = (int) r85.getPkValueType();
    L198:
        if (Intrinsics.areEqual(r5, "livesdk_pk_power_container_show") == false) goto L200;
    L201:
        if (r19 != r15) goto L203;
        String r87 = "anchor";
    L204:
        r7.put("user_type", r87);
    L205:
        if (r86 > 0) goto L207;
    L244:
        com.bytedance.android.live.revlink.impl.global.c r88 = this.d;
        if (r88 == null) goto L247;
        com.bytedance.android.live.revlink.impl.multianchor.dialog.linkopt.f r89 = r88.getLinkPlayHelper();
    L248:
        if (r89 == null) goto L289;
        if (r89.d() != true) goto L289;
        com.bytedance.android.live.revlink.impl.mergepk.pkbase.e r90 = n();
        if (r90 == null) goto L257;
        n3 r92 = r90.getBreakThroughInfo();
        if (r92 == null) goto L257;
        String r93 = String.valueOf(r92.getStage());
        if (r93 == null) goto L257;
    L258:
        r7.put("pve_level", r93);
        com.bytedance.android.live.revlink.impl.global.c r94 = this.d;
        if (r94 == null) goto L261;
        com.bytedance.android.live.revlink.impl.multianchor.dialog.linkopt.f r95 = r94.getLinkPlayHelper();
    L262:
        if (r95 == null) goto L289;
        com.bytedance.android.live.revlink.impl.global.c r96 = r95.c;
        if (r96 == null) goto L266;
        com.bytedance.android.live.revlink.impl.pk.utils.q r97 = r96.getPkUtils();
    L267:
        if (r97 == null) goto L269;
        q11.b r98 = r97.a();
    L271:
        if (Intrinsics.areEqual(r98, q11.b.c.b) != true) goto L289;
        com.bytedance.android.live.revlink.impl.mergepk.pkbase.e r99 = n();
        if (r99 == null) goto L278;
        n3 r100 = r99.getBreakThroughInfo();
        if (r100 == null) goto L278;
        String r101 = String.valueOf(r100.getStage());
        if (r101 == null) goto L278;
    L279:
        r7.put("finish_level", r101);
        com.bytedance.android.live.revlink.impl.mergepk.pkbase.e r102 = n();
        if (r102 == null) goto L286;
        n3 r103 = r102.getBreakThroughInfo();
        if (r103 == null) goto L286;
        if (r103.getState() != 1) goto L286;
        Object r104 = DataType.TRUE;
    L287:
        r7.put("is_finish", r104);
    L286:
        r104 = DataType.FALSE;
    L278:
        r101 = DataType.FALSE;
        goto L279
    L269:
        r98 = null;
        goto L271
    L266:
        r97 = null;
        goto L267
    L261:
        r95 = null;
    L257:
        r93 = DataType.FALSE;
    L289:
        if (Intrinsics.areEqual(r5, "livesdk_connection_chorus_icon_show") == false) goto L291;
    L292:
        cy0.e.a.getClass();
        cy0.j r105 = cy0.e.a.a;
        com.bytedance.android.scope.m.e.getClass();
        Object r106 = com.bytedance.android.scope.m.b(r105).b(er2.b.class);
        Intrinsics.checkNotNull(r106);
        iq2.b r107 = ((com.bytedance.live.kmp.core.c) r106).getChorusService();
        if (r107 != null) goto L295;
    L301:
        Object r108 = com.bytedance.android.scope.m.b(r105).b(er2.b.class);
        Intrinsics.checkNotNull(r108);
        iq2.b r109 = ((com.bytedance.live.kmp.core.c) r108).getChorusService();
        if (r109 != null) goto L304;
    L310:
        r7.put("role_type", r32);
    L311:
        com.bytedance.android.live.revlink.impl.mergepk.pkbase.e r110 = n();
        if (r110 != null) goto L314;
    L324:
        Map<String, String> r111 = com.bytedance.android.live.revenue.common.q.a(r6);
        if (r111 == null) goto L330;
        Iterator<Map.Entry<String, String>> r112 = r111.entrySet().iterator();
    L328:
        if (r112.hasNext() == false) goto L330;
        Map.Entry<String, String> r113 = r112.next();
        r7.put(r113.getKey(), r113.getValue());
    L330:
        mz0.n r114 = new mz0.n();
        Map<String, String> r115 = r114.a;
        Intrinsics.checkNotNullParameter(r115, "map");
        Intrinsics.checkNotNullParameter(r7, "map");
        r115.putAll(r7);
        com.bytedance.android.live.revlink.impl.mergepk.pkbase.e r116 = n();
        if (r116 == null) goto L335;
        Map<String, String> r117 = r116.getServerEventTrackingInfo();
        if (r117 == null) goto L335;
        Intrinsics.checkNotNullParameter(r117, "map");
        r115.putAll(r117);
    L335:
        mz0.m r118 = new mz0.m();
        r118.b(LogCommon.PAGE_SOURCE_LOG);
        r118.b(LogCommon.ROOM);
        ((ArrayList) r114.b).addAll(r118.a);
        cy0.e.a.getClass();
        cy0.j r119 = cy0.e.a.a;
        com.bytedance.android.scope.m.e.getClass();
        Object r120 = com.bytedance.android.scope.m.b(r119).a(Reflection.getOrCreateKotlinClass(mz0.i.class));
        Intrinsics.checkNotNull(r120);
        ((mz0.i) ((f80.a) r120)).w3(r5, r114.a, r114.b);
    L662:
        TrackPKEventResultModel r0 = new TrackPKEventResultModel();
        r0.a(TrackPKEventResultModel.Code.Success);
        finishWithResult(r0);
        return;
    L314:
        if (r110.isInInteractPk() != true) goto L324;
        com.bytedance.android.live.revlink.impl.mergepk.pkbase.e r121 = n();
        if (r121 == null) goto L324;
        ca r122 = r121.getInteractPkInfo();
        if (r122 == null) goto L324;
        r7.put("playmode_name", r122.getName());
        r7.put("playmode_id", r122.getId());
        if (r122.getInteractType() != 0) goto L322;
        Object r123 = "bonus_penalty";
    L323:
        r7.put("playmode_type", r123);
        goto L324
    L322:
        r123 = "pk_effect";
        goto L323
    L304:
        if (r109.e() != true) goto L310;
        Object r124 = com.bytedance.android.scope.m.b(r105).b(er2.b.class);
        Intrinsics.checkNotNull(r124);
        iq2.b r125 = ((com.bytedance.live.kmp.core.c) r124).getChorusService();
        if (r125 == null) goto L310;
        if (r125.d() != 2) goto L310;
        r32 = "follower";
        goto L310
    L295:
        if (r107.e() != true) goto L301;
        Object r126 = com.bytedance.android.scope.m.b(r105).b(er2.b.class);
        Intrinsics.checkNotNull(r126);
        iq2.b r127 = ((com.bytedance.live.kmp.core.c) r126).getChorusService();
        if (r127 == null) goto L301;
        if (r127.d() != 1) goto L301;
        r32 = "leader";
        goto L310
    L291:
        if (Intrinsics.areEqual(r5, "livesdk_connection_chorus_icon_click") == false) goto L311;
    L247:
        r89 = null;
        goto L248
    L207:
        if (r86 >= 100) goto L244;
        r7.put("customize_pk_type", String.valueOf(r86));
        if (r84 == null) goto L214;
        v2 r128 = r84.getSelfSettingRate();
        if (r128 == null) goto L214;
        String r129 = String.valueOf(r128.getPkGiftRate());
        if (r129 == null) goto L214;
    L215:
        r7.put("giftvalue_exchange_rate", r129);
        if (r84 == null) goto L221;
        v2 r130 = r84.getSelfSettingRate();
        if (r130 == null) goto L221;
        String r131 = String.valueOf(r130.getPkUVRate());
        if (r131 == null) goto L221;
    L222:
        r7.put("giftuv_exchange_rate", r131);
        if (r84 == null) goto L228;
        v2 r132 = r84.getSelfSettingRate();
        if (r132 == null) goto L228;
        String r133 = String.valueOf(r132.getPkTicketRate());
        if (r133 == null) goto L228;
    L229:
        r7.put("ticket_exchange_rate", r133);
        if (r84 == null) goto L235;
        v2 r134 = r84.getSelfSettingRate();
        if (r134 == null) goto L235;
        String r135 = String.valueOf(r134.getPkLikeRate());
        if (r135 == null) goto L235;
    L236:
        r7.put("like_exchange_rate", r135);
        if (r84 == null) goto L242;
        v2 r136 = r84.getSelfSettingRate();
        if (r136 == null) goto L242;
        String r137 = String.valueOf(r136.getPkVIPRate());
        if (r137 == null) goto L242;
    L243:
        r7.put("membership_exchange_rate", r137);
    L242:
        r137 = "";
    L235:
        r135 = "";
    L228:
        r133 = "";
    L221:
        r131 = "";
    L214:
        r129 = "";
        goto L215
    L203:
        r87 = "audience";
        goto L204
    L200:
        if (Intrinsics.areEqual(r5, "livesdk_pk_rank_container_show") == false) goto L205;
    L196:
        r86 = 0;
    L188:
        com.bytedance.android.live.revlink.impl.mergepk.pkbase.e r138 = n();
        if (r138 == null) goto L191;
        r84 = r138.getConfigSetting();
        goto L192
    L191:
        r84 = null;
        goto L192
    L182:
        r82 = null;
    L178:
        r79 = "";
        goto L179
    L172:
        r76 = null;
        goto L173
    L168:
        r74 = "";
        goto L169
    L164:
        r72 = "";
        goto L165
    L161:
        r70 = null;
        goto L162
    L157:
        r68 = "";
        goto L158
    L153:
        r66 = "";
        goto L154
    L147:
        if (r63.isOnceMoreBattle() != true) goto L149;
        r64 = DataType.TRUE;
        goto L150
    L143:
        r62 = "";
        goto L144
    L139:
        r59 = "";
        goto L140
    L135:
        r57 = null;
        goto L136
    L131:
        r56 = "";
        goto L132
    L124:
        r53 = 0;
        goto L125
    L121:
        r52 = null;
    L127:
        r54 = "";
        goto L128
    L102:
        if (r48.f() != true) goto L116;
        com.bytedance.android.live.revlink.impl.global.c r139 = this.d;
        if (r139 == null) goto L106;
        com.bytedance.android.live.revlink.impl.pk.utils.q r140 = r139.getPkUtils();
    L107:
        if (r140 == null) goto L127;
        com.bytedance.android.live.revlink.impl.mergepk.pkdouble.c r141 = r140.g();
        if (r141 == null) goto L127;
        int r142 = r141.getInviteType();
        d31.d r143 = o();
        if (r143 == null) goto L113;
        r54 = r143.p(r142);
    L114:
        if (r54 != null) goto L128;
    L113:
        r54 = null;
        goto L114
    L106:
        r140 = null;
        goto L107
    L99:
        r48 = null;
    L95:
        r46 = "";
        goto L96
    L80:
        r40 = false;
    L90:
        com.bytedance.android.live.revlink.impl.multianchor.utils.q r144 = m();
        if (r144 == null) goto L95;
        LinkCrossRoomDataHolder r145 = r144.f();
        if (r145 == null) goto L95;
        r46 = r145.l();
    L70:
        r36 = 0;
        goto L71
    L65:
        r34 = null;
        goto L66
    L72:
        r37 = null;
        goto L73
    L60:
        r30 = null;
        goto L61
    L56:
        r28 = DataType.TRUE;
        goto L57
    L52:
        r27 = DataType.FALSE;
        goto L53
    L48:
        r26 = null;
        goto L49
    L45:
        r25 = null;
    L41:
        r23 = null;
    L35:
        r10 = DataType.FALSE;
        goto L36
    L28:
        r18 = null;
        goto L29
    L25:
        r17 = null;
    L21:
        r15 = DataType.FALSE;
        goto L22
    L337:
        if (com.bytedance.android.live.utils.c.a(r4, 64) == false) goto L546;
        LinkedHashMap r146 = new LinkedHashMap();
        d31.d r147 = o();
        if (r147 == null) goto L341;
        String r148 = r147.f();
    L343:
        if (Intrinsics.areEqual(r148, "team_pk") == false) goto L355;
        com.bytedance.android.live.revlink.impl.global.c r149 = this.d;
        if (r149 == null) goto L347;
        com.bytedance.android.live.revlink.impl.mergepk.pkmulti.b r150 = r149.Q1();
    L348:
        if (r150 == null) goto L355;
        Pair<List<String>, List<String>> r151 = r150.getTeamPkUids4Finish();
        if (r151 == null) goto L355;
        if (((List) r151.getFirst()).size() == 0) goto L355;
        StringBuilder r152 = new StringBuilder();
        r152.append(((List) r151.getFirst()).size());
        r152.append('V');
        r152.append(((List) r151.getSecond()).size());
        r146.put("team_type", r152.toString());
        goto L355
    L347:
        r150 = null;
    L355:
        com.bytedance.android.live.revlink.impl.global.c r153 = this.d;
        if (r153 == null) goto L358;
        com.bytedance.android.live.revlink.impl.mergepk.pkmulti.b r154 = r153.Q1();
    L359:
        if (r154 == null) goto L361;
        r146.putAll(r154.getCurrentSceneLogParam());
    L361:
        com.bytedance.android.live.revlink.impl.global.c r155 = this.d;
        if (r155 == null) goto L364;
        com.bytedance.android.live.revlink.impl.pk.utils.q r156 = r155.getPkUtils();
    L365:
        if (r156 == null) goto L371;
        PkCustomizePlayDataContext r157 = r156.f();
        if (r157 == null) goto L371;
        IBattleConfigSetting r158 = r157.getBattleConfigSetting();
        if (r158 == null) goto L371;
        com.bytedance.android.live.revlink.impl.multianchor.utils.r.a(r158, MapsKt.toMutableMap(r146));
    L371:
        com.bytedance.android.livesdk.revenue.service.room.c r159 = this.b;
        if (r159 == null) goto L381;
        com.bytedance.android.livesdk.revenue.room.a r160 = r159.getRoomContext();
        if (r160 == null) goto L381;
        IRoomBase r161 = r160.getCommonRoom();
        if (r161 == null) goto L381;
        IBaseUser r162 = r161.getOwnerKt();
        if (r162 == null) goto L381;
        String r163 = r162.getIdString();
        if (r163 == null) goto L381;
    L382:
        com.bytedance.android.live.revlink.impl.global.c r164 = this.d;
        if (r164 == null) goto L385;
        com.bytedance.android.live.revlink.impl.utils.s r165 = r164.getRevLinkCommonUtil();
    L386:
        if (r165 == null) goto L388;
        String r166 = r165.e();
    L390:
        if (String.valueOf(r166) != r163) goto L392;
        Object r167 = DataType.FALSE;
    L393:
        r146.put("user_type", r167);
        com.bytedance.android.live.revlink.impl.multianchor.utils.q r168 = m();
        if (r168 == null) goto L398;
        LinkCrossRoomDataHolder r169 = r168.f();
        if (r169 == null) goto L398;
        Long r170 = Long.valueOf(r169.c());
    L399:
        r146.put("channel_id", String.valueOf(r170));
        com.bytedance.android.live.revlink.impl.global.c r171 = this.d;
        if (r171 == null) goto L402;
        w31.c r172 = r171.getPkLinkUtils();
    L403:
        if (r172 == null) goto L405;
        Long r173 = Long.valueOf(r172.i());
    L406:
        r146.put("pk_id", String.valueOf(r173));
        if (r148 != null) goto L409;
        String r174 = "";
    L410:
        r146.put("invite_mode", r174);
        d31.d r175 = o();
        if (r175 == null) goto L413;
        String r176 = r175.d();
    L414:
        r146.put("battle_mode", r176);
        d31.d r177 = o();
        if (r177 == null) goto L417;
        String r178 = r177.s();
    L418:
        r146.put("room_status", r178);
        d31.d r179 = o();
        if (r179 == null) goto L421;
        String r180 = r179.c();
    L422:
        r146.put("connection_type", r180);
        com.bytedance.android.live.revlink.impl.global.c r181 = this.d;
        if (r181 == null) goto L425;
        com.bytedance.android.live.revlink.impl.multianchor.dialog.linkopt.f r182 = r181.getLinkPlayHelper();
    L426:
        if (r182 != null) goto L428;
    L442:
        d31.d r183 = o();
        if (r183 == null) goto L453;
        com.bytedance.android.live.revlink.impl.global.c r184 = this.d;
        if (r184 == null) goto L447;
        com.bytedance.android.live.revlink.impl.multianchor.vm.g r185 = r184.getMultiAnchorLinkContextObj();
    L448:
        if (r185 == null) goto L450;
        int r186 = r185.b();
    L451:
        String r187 = r183.p(r186);
        if (r187 == null) goto L453;
    L454:
        r146.put("invitee_list", r187);
        if (r6.has("is_oncemore") == true) goto L461;
        d31.d r188 = o();
        if (r188 == null) goto L459;
        String r189 = r188.g();
    L460:
        r146.put("is_oncemore", r189);
        goto L461
    L459:
        r189 = "";
    L461:
        d31.d r190 = o();
        if (r190 == null) goto L465;
        String r191 = r190.a();
        if (r191 == null) goto L465;
    L466:
        r146.put("anchor_connect_status", r191);
        d31.d r192 = o();
        if (r192 == null) goto L470;
        String r193 = r192.a();
        if (r193 == null) goto L470;
    L471:
        r146.put("connection_anchor_cnt", r193);
        r146.put("audience_connect_cnt", DataType.FALSE);
        if ((!Intrinsics.areEqual("connection", r148)) == false) goto L479;
        d31.d r194 = o();
        if (r194 == null) goto L479;
        String r195 = r194.a();
        if (r195 == null) goto L479;
    L480:
        r146.put("pk_anchor_cnt", r195);
        d31.d r196 = o();
        if (r196 == null) goto L483;
        String r197 = r196.b();
    L484:
        r146.put("connection_sub_type", r197);
        d31.d r198 = o();
        if (r198 == null) goto L487;
        String r199 = r198.o();
    L488:
        r146.put("is_manager", r199);
        r146.put("is_game_connection", DataType.FALSE);
        com.bytedance.android.live.revlink.impl.global.c r200 = this.d;
        if (r200 == null) goto L491;
        com.bytedance.android.live.revlink.impl.multianchor.vm.g r201 = r200.getMultiAnchorLinkContextObj();
    L492:
        if (r201 == null) goto L494;
        int r202 = r201.b();
    L496:
        if (r202 != ILinkMicBattleInviteMessage.BattleInviteType.BattleInviteType_Multiple_Activity.ordinal()) goto L498;
    L501:
        String r1100 = "double";
    L502:
        r146.put("npk_link_type", r1100);
        b03.a r203 = b03.a.a;
        if (b03.a.c() == false) goto L505;
        Object r1101 = DataType.FALSE;
    L506:
        r146.put("room_orientation", r1101);
        com.bytedance.android.live.revlink.impl.global.c r204 = this.d;
        if (r204 == null) goto L509;
        com.bytedance.android.live.revlink.impl.mergepk.pkmulti.c r205 = r204.U7();
    L510:
        if (r205 != null) goto L512;
    L514:
        com.bytedance.android.live.revlink.impl.global.c r206 = this.d;
        if (r206 == null) goto L517;
        IPKLinkBizDataService r207 = r206.mk();
    L518:
        if (r207 == null) goto L523;
        cy0.e.a.getClass();
        cy0.j r208 = cy0.e.a.a;
        com.bytedance.android.scope.m.e.getClass();
        Object r209 = com.bytedance.android.scope.m.b(r208).b(com.bytedance.android.livesdk.revenue.service.user.a.class);
        Intrinsics.checkNotNull(r209);
        String r210 = r207.getTransformReason(null, ((com.bytedance.live.kmp.core.c) r209).getCurrentUserId());
        if (r210 == null) goto L523;
    L524:
        r146.put("transform_reason", r210);
        com.bytedance.android.live.revlink.impl.mergepk.pkbase.e r211 = n();
        if (r211 != null) goto L527;
    L537:
        Map<String, String> r212 = com.bytedance.android.live.revenue.common.q.a(r6);
        if (r212 == null) goto L545;
        Iterator<Map.Entry<String, String>> r213 = r212.entrySet().iterator();
    L541:
        if (r213.hasNext() == false) goto L545;
        Map.Entry<String, String> r214 = r213.next();
        String r215 = r214.getValue();
        if (r215 == null) goto L541;
        r146.put(r214.getKey(), r215);
    L545:
        mz0.n r216 = new mz0.n();
        Map<String, String> r217 = r216.a;
        Intrinsics.checkNotNullParameter(r217, "map");
        Intrinsics.checkNotNullParameter(r146, "map");
        r217.putAll(r146);
        mz0.m r218 = new mz0.m();
        r218.b(LogCommon.PAGE_SOURCE_LOG);
        r218.b(LogCommon.ROOM);
        ((ArrayList) r216.b).addAll(r218.a);
        cy0.e.a.getClass();
        cy0.j r219 = cy0.e.a.a;
        com.bytedance.android.scope.m.e.getClass();
        Object r220 = com.bytedance.android.scope.m.b(r219).a(Reflection.getOrCreateKotlinClass(mz0.i.class));
        Intrinsics.checkNotNull(r220);
        ((mz0.i) ((f80.a) r220)).w3(r5, r216.a, r216.b);
        goto L662
    L527:
        if (r211.isInInteractPk() != true) goto L537;
        com.bytedance.android.live.revlink.impl.mergepk.pkbase.e r221 = n();
        if (r221 == null) goto L537;
        ca r222 = r221.getInteractPkInfo();
        if (r222 == null) goto L537;
        r146.put("playmode_name", r222.getName());
        r146.put("playmode_id", r222.getId());
        if (r222.getInteractType() != 0) goto L535;
        Object r223 = "bonus_penalty";
    L536:
        r146.put("playmode_type", r223);
        goto L537
    L535:
        r223 = "pk_effect";
    L523:
        r210 = "";
        goto L524
    L517:
        r207 = null;
        goto L518
    L512:
        if (r205.getCurrentGameStatus() != IProfitGameStatusMessage.GameStatus.BizStart.ordinal()) goto L514;
        r146.putAll(r205.getCurrentTrackInfo());
        r146.put("is_game_connection", DataType.TRUE);
        goto L514
    L509:
        r205 = null;
        goto L510
    L505:
        r1101 = DataType.TRUE;
        goto L506
    L498:
        if (r202 == ILinkMicBattleInviteMessage.BattleInviteType.BattleInviteType_Multiple_Again.ordinal()) goto L501;
        r1100 = "single";
        goto L502
    L494:
        r202 = 0;
        goto L496
    L491:
        r201 = null;
        goto L492
    L487:
        r199 = "";
        goto L488
    L483:
        r197 = "";
    L479:
        r195 = "";
    L470:
        r193 = "";
    L465:
        r191 = "";
        goto L466
    L450:
        r186 = 0;
        goto L451
    L447:
        r185 = null;
    L453:
        r187 = "";
        goto L454
    L428:
        if (r182.f() != true) goto L442;
        com.bytedance.android.live.revlink.impl.global.c r224 = this.d;
        if (r224 == null) goto L432;
        com.bytedance.android.live.revlink.impl.pk.utils.q r225 = r224.getPkUtils();
    L433:
        if (r225 == null) goto L453;
        com.bytedance.android.live.revlink.impl.mergepk.pkdouble.c r226 = r225.g();
        if (r226 == null) goto L453;
        int r227 = r226.getInviteType();
        d31.d r228 = o();
        if (r228 == null) goto L439;
        r187 = r228.p(r227);
    L440:
        if (r187 != null) goto L454;
    L439:
        r187 = null;
        goto L440
    L432:
        r225 = null;
        goto L433
    L425:
        r182 = null;
        goto L426
    L421:
        r180 = "";
        goto L422
    L417:
        r178 = "";
        goto L418
    L413:
        r176 = "";
        goto L414
    L409:
        r174 = r148;
        goto L410
    L405:
        r173 = null;
        goto L406
    L402:
        r172 = null;
    L398:
        r170 = null;
        goto L399
    L392:
        r167 = DataType.TRUE;
        goto L393
    L388:
        r166 = null;
        goto L390
    L385:
        r165 = null;
    L381:
        r163 = DataType.FALSE;
        goto L382
    L364:
        r156 = null;
        goto L365
    L358:
        r154 = null;
        goto L359
    L341:
        r148 = null;
        goto L343
    L546:
        LinkedHashMap r229 = new LinkedHashMap();
        yz0.g r230 = this.c;
        if (r230 == null) goto L555;
        IRoomBase r231 = r230.mo444getRoom();
        if (r231 == null) goto L555;
        IBaseUser r232 = r231.getOwnerKt();
        if (r232 == null) goto L555;
        String r233 = r232.getIdString();
        if (r233 == null) goto L555;
    L556:
        com.bytedance.android.live.revlink.impl.global.c r234 = this.d;
        if (r234 == null) goto L559;
        com.bytedance.android.live.revlink.impl.utils.s r235 = r234.getRevLinkCommonUtil();
    L560:
        if (r235 == null) goto L562;
        String r236 = r235.e();
    L563:
        String r237 = String.valueOf(r236);
        r229.put("user_id", r237);
        r229.put("anchor_id", r233);
        yz0.g r238 = this.c;
        if (r238 == null) goto L571;
        IRoomBase r239 = r238.mo444getRoom();
        if (r239 == null) goto L571;
        String r240 = String.valueOf(IRoomKtKt.getId(r239));
        if (r240 == null) goto L571;
    L572:
        r229.put("room_id", r240);
        if (Intrinsics.areEqual(r237, r233) == false) goto L575;
        Object r241 = DataType.TRUE;
    L576:
        r229.put("is_anchor", r241);
        if (Intrinsics.areEqual(r237, r233) == false) goto L579;
        Object r242 = DataType.FALSE;
    L580:
        r229.put("user_type", r242);
        com.bytedance.android.live.revlink.impl.multianchor.utils.q r243 = m();
        if (r243 == null) goto L599;
        LinkCrossRoomDataHolder r244 = r243.f();
        if (r244 == null) goto L599;
        if (r244.l().length() != 0) goto L587;
        boolean r245 = true;
    L589:
        if (r245 != true) goto L599;
        mz0.e<?> r246 = mz0.d.b(LogCommon.ROOM);
        if (r246 == null) goto L597;
        Map<String, String> r247 = ((com.bytedance.android.live.revenue.platform.log.impl.filterimpl.a) r246).getMap();
        if (r247 == null) goto L597;
        Object r248 = "request_id";
        String r249 = r247.get(r248);
        if (r249 == null) goto L598;
    L605:
        if (r249 != null) goto L607;
        r249 = "";
    L607:
        r229.put(r248, r249);
        d31.d r250 = o();
        if (r250 == null) goto L610;
        String r251 = r250.c();
    L611:
        r229.put("connection_type", r251);
        d31.d r252 = o();
        if (r252 == null) goto L614;
        String r253 = r252.b();
    L615:
        r229.put("connection_sub_type", r253);
        d31.d r254 = o();
        if (r254 == null) goto L619;
        String r255 = r254.a();
        if (r255 == null) goto L619;
    L620:
        r229.put("anchor_connect_status", r255);
        if (o() == null) goto L623;
        Integer r256 = Integer.valueOf(n41.a.b());
    L624:
        r229.put("audience_connect_cnt", String.valueOf(r256));
        d31.d r257 = o();
        if (r257 == null) goto L627;
        String r258 = r257.s();
    L628:
        r229.put("room_status", r258);
        d31.d r259 = o();
        if (r259 == null) goto L631;
        r32 = r259.d();
    L631:
        r229.put("battle_mode", r32);
        com.bytedance.android.live.revlink.impl.multianchor.utils.q r260 = m();
        if (r260 == null) goto L636;
        LinkCrossRoomDataHolder r261 = r260.f();
        if (r261 == null) goto L636;
        Long r262 = Long.valueOf(r261.c());
    L637:
        r229.put("channel_id", String.valueOf(r262));
        com.bytedance.android.live.revlink.impl.mergepk.pkbase.e r263 = n();
        if (r263 != null) goto L640;
    L650:
        Map<String, String> r264 = com.bytedance.android.live.revenue.common.q.a(r6);
        if (r264 == null) goto L656;
        Iterator<Map.Entry<String, String>> r265 = r264.entrySet().iterator();
    L654:
        if (r265.hasNext() == false) goto L656;
        Map.Entry<String, String> r266 = r265.next();
        r229.put(r266.getKey(), r266.getValue());
    L656:
        mz0.n r267 = new mz0.n();
        Map<String, String> r268 = r267.a;
        Intrinsics.checkNotNullParameter(r268, "map");
        Intrinsics.checkNotNullParameter(r229, "map");
        r268.putAll(r229);
        com.bytedance.android.live.revlink.impl.mergepk.pkbase.e r269 = n();
        if (r269 == null) goto L661;
        Map<String, String> r270 = r269.getServerEventTrackingInfo();
        if (r270 == null) goto L661;
        Intrinsics.checkNotNullParameter(r270, "map");
        r268.putAll(r270);
    L661:
        mz0.m r271 = new mz0.m();
        r271.b(LogCommon.PAGE_SOURCE_LOG);
        r271.b(LogCommon.ROOM);
        ((ArrayList) r267.b).addAll(r271.a);
        cy0.e.a.getClass();
        cy0.j r272 = cy0.e.a.a;
        com.bytedance.android.scope.m.e.getClass();
        Object r273 = com.bytedance.android.scope.m.b(r272).a(Reflection.getOrCreateKotlinClass(mz0.i.class));
        Intrinsics.checkNotNull(r273);
        ((mz0.i) ((f80.a) r273)).w3(r5, r267.a, r267.b);
        goto L662
    L640:
        if (r263.isInInteractPk() != true) goto L650;
        com.bytedance.android.live.revlink.impl.mergepk.pkbase.e r274 = n();
        if (r274 == null) goto L650;
        ca r275 = r274.getInteractPkInfo();
        if (r275 == null) goto L650;
        r229.put("playmode_name", r275.getName());
        r229.put("playmode_id", r275.getId());
        if (r275.getInteractType() != 0) goto L648;
        Object r276 = "bonus_penalty";
    L649:
        r229.put("playmode_type", r276);
        goto L650
    L648:
        r276 = "pk_effect";
    L636:
        r262 = null;
        goto L637
    L627:
        r258 = "";
        goto L628
    L623:
        r256 = null;
    L619:
        r255 = DataType.FALSE;
        goto L620
    L614:
        r253 = "";
        goto L615
    L610:
        r251 = "";
    L598:
        r249 = "";
    L597:
        r248 = "request_id";
        goto L598
    L587:
        r245 = false;
    L599:
        r248 = "request_id";
        com.bytedance.android.live.revlink.impl.multianchor.utils.q r277 = m();
        if (r277 == null) goto L604;
        LinkCrossRoomDataHolder r278 = r277.f();
        if (r278 == null) goto L604;
        r249 = r278.l();
    L604:
        r249 = null;
        goto L605
    L579:
        r242 = DataType.TRUE;
        goto L580
    L575:
        r241 = DataType.FALSE;
    L571:
        r240 = DataType.FALSE;
        goto L572
    L562:
        r236 = null;
        goto L563
    L559:
        r235 = null;
    L555:
        r233 = DataType.FALSE;
    L664:
        return;
    L5:
        r3 = null;
        goto L6
    }

    public i0(com.bytedance.android.livesdk.revenue.service.room.c r1, yz0.g r2, com.bytedance.android.live.revlink.impl.global.c r3) {
        this.b = r1;
        this.c = r2;
        this.d = r3;
        this.a = TypesJVMKt.getJavaType(Reflection.typeOf(gf.class));
    }
}
