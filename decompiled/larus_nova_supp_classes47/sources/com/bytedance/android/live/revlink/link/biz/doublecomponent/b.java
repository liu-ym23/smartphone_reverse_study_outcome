package com.bytedance.android.live.revlink.link.biz.doublecomponent;

import c21.f;
import com.bytedance.android.live.link.constants.UserListInviteType;
import com.bytedance.android.live.profile.monitor.DataType;
import com.bytedance.android.live.revlink.api.ILinkService;
import com.bytedance.android.live.revlink.impl.LinkCrossRoomDataHolder;
import com.bytedance.android.live.revlink.impl.mergepk.pkbase.PkBaseDataContext;
import com.bytedance.android.live.revlink.impl.mergepk.pkbase.e;
import com.bytedance.android.live.revlink.impl.mergepk.pkbase.statemachine.PkBaseStateMachine;
import com.bytedance.android.live.revlink.impl.multianchor.utils.a0;
import com.bytedance.android.live.revlink.impl.pk.service.IPKLinkBizDataService;
import com.bytedance.android.live.revlink.impl.pk.utils.q;
import com.bytedance.android.live.revlink.link.biz.service.i;
import com.bytedance.android.live.saas.middleware.store.FileUtils;
import com.bytedance.android.live.schema.api.WebcastRedirectException;
import com.bytedance.android.livesdk.link.model.IBattleConfigSetting;
import com.bytedance.android.livesdk.link.model.IBattleRivalTag;
import com.bytedance.android.livesdk.link.model.aa;
import com.bytedance.android.livesdk.link.model.api.IBaseBattleSetting;
import com.bytedance.android.livesdk.link.model.m3;
import com.bytedance.android.livesdk.link.model.n3;
import com.bytedance.android.livesdk.revenue.log.LogCommon;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import cy0.j;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import mz0.m;
import mz0.n;
import p11.h;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class b implements com.bytedance.android.live.revlink.link.biz.service.c {
    public final String a;
    public final com.bytedance.android.live.revlink.link.infra.lifecontrol.context.a b;
    public final com.bytedance.android.livesdk.revenue.service.room.c c;
    public final Function3<Integer, Boolean, Long, Unit> d;
    public final a e;
    public final Function0<Boolean> f;
    public final Function0<Boolean> g;

    @Override // com.bytedance.android.live.revlink.link.biz.service.e
    public final void attach() {
    }

    @Override // com.bytedance.android.live.revlink.link.biz.service.e
    public final String getTAG() {
        return "RevenueLinkAnchorComponent";
    }

    @Override // com.bytedance.android.live.revlink.link.biz.service.e
    public final void detach() {
        Intrinsics.checkNotNullParameter(this, "$this$doublePkService");
        com.bytedance.android.live.revlink.impl.mergepk.pkdouble.c r1 = i.getContext(this).K8();
        if (r1 != null) goto L5;
        return;
    L5:
        e r2 = i.S(this);
        if (r2 != null) goto L8;
        return;
    L8:
        boolean r3 = ((Boolean) this.f.invoke()).booleanValue();
        boolean r4 = this.e.a;
        r1.getInviteType();
        long r5 = getContext().G();
        f r6 = r2.getBattlePlayMode();
        boolean r7 = this.e.a;
        boolean r8 = ((Boolean) this.g.invoke()).booleanValue();
        LinkedHashMap r9 = new LinkedHashMap();
        this.e.getClass();
        Intrinsics.areEqual(null, Boolean.TRUE);
        IRoom r10 = this.c.getRoomContext().getCommonRoom();
        IPKLinkBizDataService r12 = i.P(this);
        long r13 = 0;
        LinkCrossRoomDataHolder r15 = i.m(this);
        if (i.T(this).a() > 0) goto L11;
    L13:
        e r16 = i.S(this);
        LinkedHashMap r14 = new LinkedHashMap();
        if (l51.a.e() == false) goto L16;
        Object r17 = "on";
    L17:
        r14.put("gift_guest_switch_type", r17);
        q r18 = i.W(this);
        if (r18 == null) goto L518;
        long r23 = 0;
        if (r18.h() <= 0) goto L28;
        i97.a r22 = i97.a.a;
        if ((System.currentTimeMillis() - r18.h()) <= 0) goto L28;
        Object r26 = "gift_guest_switch_type";
        long r27 = r13;
        if ((System.currentTimeMillis() - r18.h()) >= 86400000) goto L29;
        r8 = r8;
        r9 = r9;
        String r19 = String.valueOf((System.currentTimeMillis() - r18.h()) / ((long) WebcastRedirectException.UNKNOWN));
    L34:
        r14.put("pk_description", "routine");
        r14.put("anchor_connection_type", "invite");
        if (i.T(this).e() == false) goto L39;
        String r20 = i.T(this).c();
        if (r20 == null) goto L41;
    L42:
        r14.put("invitee_id", r20);
        if (i.T(this).e() == false) goto L47;
        String r24 = iz.a.a(r10.getOwnerKt());
        if (r24 == null) goto L49;
    L50:
        r14.put("inviter_id", r24);
        r14.put("anchor_connect_status", "2");
        if (r3 == false) goto L53;
        Object r25 = "active";
    L54:
        r14.put("end_reason", r25);
        if (r12 == null) goto L59;
        IBattleRivalTag.a r28 = IBattleRivalTag.Companion;
        ArrayList<IBattleRivalTag> r29 = r12.getPkBattleRivalTagsInfo();
        r28.getClass();
        IBattleRivalTag.a.a(r29, r14);
    L59:
        if (r16 == null) goto L73;
        Object r33 = "passive";
        if (r16.modType() != PkBaseDataContext.PKModType.Vote) goto L74;
        r14.put("invite_mode", "vote");
        aa r0 = r16.getVoteSetting();
        if (r0 == null) goto L65;
        String r30 = r0.getVoteDes();
    L66:
        if (r30 == null) goto L74;
        aa r32 = r16.getVoteSetting();
        if (r32 == null) goto L71;
        String r34 = r32.getVoteDes();
        if (r34 == null) goto L71;
    L72:
        r14.put(FileUtils.PICTURE_THEME, r34);
    L71:
        r34 = "";
        goto L72
    L65:
        r30 = null;
    L74:
        e r35 = i.S(this);
        if (r35 == null) goto L79;
        boolean r36 = r35.isInCompetition();
        Object r37 = FileUtils.PICTURE_THEME;
        if (r36 != true) goto L80;
        r14.put("invite_mode", "compete");
    L80:
        e r38 = i.S(this);
        if (r38 == null) goto L97;
        Object r39 = "compete";
        if (r38.isCustomizePkPlay() != true) goto L98;
        r14.put("invite_mode", "customize_pk");
        e r40 = i.S(this);
        if (r40 == null) goto L88;
        String r42 = String.valueOf(r40.getCustomizePlayType());
        if (r42 == null) goto L88;
    L89:
        r14.put("customize_pk_type", r42);
        e r43 = i.S(this);
        if (r43 == null) goto L95;
        IBaseBattleSetting r44 = r43.getBattleSettings();
        if (r44 == null) goto L95;
        String r45 = String.valueOf(a0.a(r44));
        if (r45 == null) goto L95;
    L96:
        r14.put("membership_exchange_rate", r45);
    L95:
        r45 = "";
    L88:
        r42 = "";
    L98:
        h r46 = ((ILinkService) com.bytedance.android.live.revenue.core.util.f.a(ILinkService.class)).mo470getPkService();
        if (r46 == null) goto L102;
        String r47 = r46.D();
        if (r47 == null) goto L102;
    L104:
        if (r47.length() <= 0) goto L106;
        boolean r110 = true;
    L107:
        if (r110 == false) goto L109;
        r14.put("transform_reason", r47);
    L109:
        com.bytedance.android.live.revlink.impl.mergepk.pkdouble.c r48 = r18.g();
        e r111 = i.S(this);
        String r112 = "is_manager";
        String r310 = r19;
        String r49 = "";
        Object r410 = "connection_sub_type";
        if (r48 == null) goto L163;
        if (r111 == null) goto L163;
        String r411 = r48.isManager();
        Object r50 = DataType.FALSE;
        if (r411 != null) goto L115;
        String r52 = r49;
    L116:
        r14.put("is_manager", r52);
        if (r111.isOnceMoreBattle() == false) goto L119;
        Object r53 = DataType.TRUE;
    L120:
        r14.put("is_oncemore", r53);
        IPKLinkBizDataService r54 = i.T(this).g();
        if (r54 == null) goto L125;
        if (r54.getIsRealOrganizer() == false) goto L125;
    L127:
        r14.put("invitee_list", "active");
    L129:
        r14.put("connection_type", r48.getConnectionType());
        d31.d r55 = i.Z(this);
        Integer r113 = r48.getEndType();
        r55.getClass();
        String r56 = d31.d.e(r113);
        if (r56.length() != 0) goto L132;
        boolean r114 = true;
    L133:
        if (r114 == false) goto L135;
        r14.put("end_type", "room_close");
    L137:
        if (r48.getEndType() != null) goto L140;
        r14.put("end_type", "disconnect");
    L140:
        if (r48.isRoomCloser() == false) goto L143;
        r14.put("end_type", "room_close");
    L143:
        if (r48.isRoomCloser() == false) goto L145;
        r14.put("end_reason", "active");
    L145:
        if (r6 != null) goto L147;
        Object r57 = "pk";
        Long r58 = (Long) r111.getBaseTimeLeft().getValue();
        if (r58 != null) goto L154;
        r58 = 0L;
    L154:
        if (r58.longValue() > 0) goto L156;
        r14.put("room_status", "connection");
    L162:
        r14.put(r410, r49);
    L164:
        h r412 = ((ILinkService) com.bytedance.android.live.revenue.core.util.f.a(ILinkService.class)).mo470getPkService();
        if (r412 == null) goto L170;
        String r413 = r412.getInviteMode();
        if (r413 == null) goto L170;
        String r59 = r413;
    L171:
        r14.put("invite_mode", r59);
        String r115 = "audience_connect_cnt";
        if (r18.g() == null) goto L184;
        com.bytedance.android.live.revlink.impl.mergepk.pkdouble.c r60 = r18.g();
        if (r60 == null) goto L177;
        String r62 = r60.getConnectionType();
        if (r62 == null) goto L177;
    L178:
        r14.put("connection_type", r62);
        r14.put("channel_id", String.valueOf(r5));
        com.bytedance.android.live.revlink.impl.mergepk.pkdouble.c r63 = r18.g();
        if (r63 == null) goto L182;
        String r64 = r63.getAudienceConnectCnt();
        if (r64 == null) goto L182;
    L183:
        r14.put("audience_connect_cnt", r64);
    L182:
        r64 = r49;
    L177:
        r62 = r49;
    L184:
        if (r111 != null) goto L186;
        Object r414 = "connection_type";
        r115 = "audience_connect_cnt";
    L258:
        if (r8 == false) goto L260;
        r14.put("end_type", "room_close");
    L260:
        if (r48 == null) goto L262;
        Integer r65 = r48.getEndType();
    L263:
        String r116 = "other";
        String r66 = "belong";
        String r67 = "live";
        String r510 = r49;
        String r68 = "map";
        if (r65 != null) goto L266;
        Object r511 = r410;
    L268:
        n r69 = new n();
        Map<String, String> r117 = r69.a;
        Intrinsics.checkNotNullParameter(r117, "map");
        Intrinsics.checkNotNullParameter(r14, "map");
        r117.putAll(r14);
        m r118 = new m();
        com.bytedance.android.livesdk.revenue.log.h r119 = vh6.c.b(kr2.a.class).be();
        Intrinsics.checkNotNullParameter(r119, "linkInfoLog");
        r119.c(r27);
        Intrinsics.checkNotNullParameter(r310, "connectionTime");
        r119.b(r310);
        Intrinsics.checkNotNullParameter("room_close", "endType");
        r119.d("room_close");
        ((ArrayList) r118.a).add(r119.a);
        com.bytedance.android.livesdk.revenue.log.i r70 = vh6.c.b(kr2.a.class).ud();
        Intrinsics.checkNotNullParameter(r70, "pageSourceLog");
        Intrinsics.checkNotNullParameter("live", "belong");
        r70.a("live");
        Intrinsics.checkNotNullParameter("other", "type");
        r70.d("other");
        ((ArrayList) r118.a).add(r70.a);
        i.m(this).m(r118);
        r118.b(LogCommon.ROOM);
        ((ArrayList) r69.b).addAll(r118.a);
        Map<String, String> r72 = r69.a;
        r68 = "map";
        Intrinsics.checkNotNullParameter(r72, r68);
        LinkedHashMap r120 = r9;
        Intrinsics.checkNotNullParameter(r120, r68);
        r72.putAll(r120);
        cy0.e.a.getClass();
        j r73 = cy0.e.a.a;
        com.bytedance.android.scope.m.e.getClass();
        Object r74 = com.bytedance.android.scope.m.b(r73).a(Reflection.getOrCreateKotlinClass(mz0.i.class));
        Intrinsics.checkNotNull(r74);
        ((mz0.i) ((f80.a) r74)).w3("connection_over", r69.a, r69.b);
    L271:
        if (r111 == null) goto L276;
        PkBaseStateMachine.c r121 = r111.getCurPKBaseState();
        if (r121 == null) goto L276;
        if ((r121 instanceof PkBaseStateMachine.c.C0130c) != true) goto L276;
    L283:
        LinkedHashMap r122 = new LinkedHashMap();
        Object r123 = r33;
        r122.put("end_anchor_type", r123);
        if (i.T(this).a() > 0) goto L286;
    L288:
        long r124 = r27;
    L290:
        if (i.O(this).a() == null) goto L296;
        String r311 = "endType";
        cf2.a r75 = i.O(this).a();
        if (r75 == null) goto L297;
        af2.b r76 = r75.d;
        if (r76 == null) goto L297;
        int r77 = (int) af2.c.b(r76);
    L298:
        Intrinsics.checkNotNullParameter(this, "$this$pkDoubleUtils");
        if (i.getContext(this).el().a() == null) goto L305;
        Intrinsics.checkNotNullParameter(this, "$this$pkDoubleUtils");
        cf2.a r125 = i.getContext(this).el().a();
        if (r125 == null) goto L305;
        af2.b r126 = r125.d;
        if (r126 == null) goto L305;
        int r127 = (int) af2.c.b(r126);
    L306:
        r122.put("total_diamond", String.valueOf(r77 + r127));
        r122.put("invitor_diamond", String.valueOf(r77));
        r122.put("right_user_diamond", String.valueOf(r127));
        if (l51.a.r() == false) goto L309;
        Object r78 = "on";
    L310:
        r122.put(r26, r78);
        r122.put("is_cutoff", DataType.TRUE);
        if (i.T(this).q() == false) goto L313;
        Object r79 = DataType.TRUE;
    L314:
        r122.put("is_transform", r79);
        Object r128 = r50;
        r122.put("pk_type", r128);
        r122.put("pk_anchor_cnt", "2");
        r122.put("connection_anchor_cnt", "2");
        r122.put("anchor_connect_status", "2");
        r122.put("guest_in", r128);
        if (r111 == null) goto L319;
        Object r512 = r128;
        if (r111.isOnceMoreBattle() != true) goto L320;
        Object r80 = DataType.TRUE;
    L321:
        r122.put("is_oncemore", r80);
        if (r48 == null) goto L328;
        com.bytedance.android.live.revlink.impl.pk.vm.pk.e r82 = r48.getTeamTaskService();
        if (r82 == null) goto L328;
        if (r82.getTopSecKillTrigger() != true) goto L328;
        Object r83 = DataType.TRUE;
    L329:
        r122.put("is_top_smash", r83);
        r122.put("pk_mode", DataType.Normal);
        r122.put(r511, r510);
        r122.put("channel_id", String.valueOf(r5));
        if (i.p(this) == null) goto L337;
        com.bytedance.android.live.revlink.impl.service.internal.a r84 = i.p(this);
        if (r84 == null) goto L335;
        String r85 = String.valueOf(r84.Wp());
        if (r85 == null) goto L335;
    L336:
        r122.put("audience_num", r85);
    L335:
        r85 = r510;
    L337:
        if (r48 == null) goto L416;
        String r86 = r48.isManager();
        String r129 = r112;
        if (r86 != null) goto L341;
        r86 = r510;
    L341:
        r122.put(r129, r86);
        IPKLinkBizDataService r87 = i.T(this).g();
        if (r87 == null) goto L347;
        String r130 = "type";
        if (r87.getIsRealOrganizer() != true) goto L349;
    L352:
        r122.put("invitee_list", "active");
        Object r513 = "active";
    L355:
        if (q.b() == false) goto L357;
        Object r88 = DataType.TRUE;
    L358:
        r122.put("is_with_audience", r88);
        qr2.e r89 = n41.a.c();
        if (r89 == null) goto L361;
        long r131 = r89.b;
    L363:
        if (r131 != 0) goto L368;
        if (q.b() == false) goto L368;
        r131 = (System.currentTimeMillis() - q.c()) / ((long) WebcastRedirectException.UNKNOWN);
    L368:
        r122.put("audience_time", String.valueOf(r131));
        if (r16 == null) goto L371;
        PkBaseDataContext.PKModType r90 = r16.modType();
    L373:
        if (r90 != PkBaseDataContext.PKModType.Vote) goto L387;
        Object r92 = "invite_mode";
        r122.put(r92, "vote");
        aa r93 = r16.getVoteSetting();
        if (r93 == null) goto L377;
        String r94 = r93.getVoteDes();
    L378:
        if (r94 == null) goto L389;
        aa r95 = r16.getVoteSetting();
        if (r95 == null) goto L385;
        String r96 = r95.getVoteDes();
        if (r96 == null) goto L385;
    L386:
        r122.put(r37, r96);
    L385:
        r96 = r510;
    L389:
        if (r48.getEndReason().length() <= 0) goto L391;
        boolean r97 = true;
    L392:
        if (r97 == false) goto L395;
        r122.put("end_reason", r48.getEndReason());
    L399:
        Object r98 = r414;
        r122.put(r98, r48.getConnectionType());
        d31.d r99 = i.Z(this);
        Integer r100 = r48.getEndType();
        r99.getClass();
        String r101 = d31.d.e(r100);
        if (r101.length() != 0) goto L402;
        boolean r102 = true;
    L403:
        if (r102 == false) goto L405;
        Object r103 = "end_type";
        String r132 = "disconnect";
        r122.put(r103, r132);
    L407:
        if (r48.isRoomCloser() == false) goto L409;
        r122.put(r103, "room_close");
    L409:
        if (r7 == false) goto L411;
        r122.put(r103, "invite_success");
    L411:
        if (r111 != null) goto L413;
    L415:
        r122.put(r115, r48.getAudienceConnectCnt());
    L417:
        r122.put("room_status", i.Z(this).s());
        if (r48 == null) goto L420;
        Integer r133 = r48.getEndType();
    L421:
        if (r133 != null) goto L424;
    L430:
        if (r412 == null) goto L433;
        String r104 = r412.getInviteMode();
        if (r104 == null) goto L433;
    L434:
        r122.put(r92, r104);
        i.Z(this).r(r122);
        if (r48 == null) goto L437;
        r122.put(r98, r48.getConnectionType());
    L437:
        if (r12 == null) goto L439;
        IBattleRivalTag.a r105 = IBattleRivalTag.Companion;
        ArrayList<IBattleRivalTag> r106 = r12.getPkBattleRivalTagsInfo();
        r105.getClass();
        IBattleRivalTag.a.a(r106, r122);
    L439:
        if (r8 == false) goto L441;
        r122.put(r103, "room_close");
    L441:
        r122.put("anchor_connect_status", "2");
        r122.put("pk_time", String.valueOf(i.T(this).a()));
        n r107 = new n();
        Map<String, String> r108 = r107.a;
        Intrinsics.checkNotNullParameter(r108, r68);
        Intrinsics.checkNotNullParameter(r122, r68);
        r108.putAll(r122);
        m r109 = new m();
        com.bytedance.android.livesdk.revenue.log.i r134 = vh6.c.b(kr2.a.class).ud();
        Intrinsics.checkNotNullParameter(r134, "pageSourceLog");
        Intrinsics.checkNotNullParameter("live_detail", "page");
        r134.c("live_detail");
        String r135 = r67;
        Intrinsics.checkNotNullParameter(r135, r66);
        r134.a(r135);
        String r136 = r116;
        Intrinsics.checkNotNullParameter(r136, r130);
        r134.d(r136);
        ((ArrayList) r109.a).add(r134.a);
        i.m(this).m(r109);
        r109.b(LogCommon.ROOM);
        com.bytedance.android.livesdk.revenue.log.h r137 = vh6.c.b(kr2.a.class).be();
        Intrinsics.checkNotNullParameter(r137, "linkInfoLog");
        r137.c(r124);
        if (r48 != null) goto L444;
    L446:
        String r138 = r132;
    L447:
        Intrinsics.checkNotNullParameter(r138, r311);
        r137.d(r138);
        if (r111 == null) goto L450;
        String r139 = String.valueOf((System.currentTimeMillis() - r111.getPkStartTimeMs()) / ((long) WebcastRedirectException.UNKNOWN));
        Intrinsics.checkNotNullParameter(r139, "connectionTime");
        r137.b(r139);
    L450:
        ((ArrayList) r109.a).add(r137.a);
        ((ArrayList) r107.b).addAll(r109.a);
        cy0.e.a.getClass();
        j r140 = cy0.e.a.a;
        com.bytedance.android.scope.m.e.getClass();
        Object r141 = com.bytedance.android.scope.m.b(r140).a(Reflection.getOrCreateKotlinClass(mz0.i.class));
        Intrinsics.checkNotNull(r141);
        ((mz0.i) ((f80.a) r141)).w3("livesdk_pk_end", r107.a, r107.b);
        Object r142 = com.bytedance.android.scope.m.b(r140).b(er2.b.class);
        Intrinsics.checkNotNull(r142);
        iq2.b r143 = ((com.bytedance.live.kmp.core.c) r142).getChorusService();
        if (r143 == null) goto L520;
        if (r143.e() == false) goto L520;
        com.bytedance.android.live.liveinteract.model.a r144 = r143.c();
        if (r144 == null) goto L457;
        long r145 = r144.getStartTime();
    L459:
        if (r145 <= 0) goto L464;
        long r146 = com.bytedance.live.kmp.util.e.b() / ((long) WebcastRedirectException.UNKNOWN);
        com.bytedance.android.live.liveinteract.model.a r147 = r143.c();
        if (r147 == null) goto L463;
        r23 = r147.getStartTime();
    L463:
        r23 = r146 - r23;
    L464:
        Function3<Integer, Boolean, Long, Unit> r148 = this.d;
        if (r4 == false) goto L467;
        int r149 = 2;
    L468:
        r148.invoke(Integer.valueOf(r149), Boolean.valueOf(r3), Long.valueOf(r23));
        return;
    L467:
        r149 = 0;
        goto L468
    L457:
        r145 = 0;
    L520:
        return;
    L444:
        if (r48.isRoomCloser() != true) goto L446;
        r138 = "room_close";
    L433:
        r104 = r510;
        goto L434
    L424:
        if (r133.intValue() != 12) goto L430;
        if (r111 != null) goto L427;
    L429:
        r122.put("room_status", r57);
        goto L430
    L427:
        if (r111.isInBreakThrough() != true) goto L429;
        r122.put("room_status", "pve");
        goto L430
    L420:
        r133 = null;
        goto L421
    L413:
        if (r111.isInCompetition() != true) goto L415;
        r122.put(r92, r39);
        goto L415
    L405:
        r103 = "end_type";
        r132 = "disconnect";
        r122.put(r103, r101);
        goto L407
    L402:
        r102 = false;
        goto L403
    L395:
        if (r3 == false) goto L397;
        Object r150 = r513;
    L398:
        r122.put("end_reason", r150);
        goto L399
    L397:
        r150 = r123;
        goto L398
    L391:
        r97 = false;
        goto L392
    L377:
        r94 = null;
        goto L378
    L387:
        r92 = "invite_mode";
        goto L389
    L371:
        r90 = null;
        goto L373
    L361:
        r131 = 0;
        goto L363
    L357:
        r88 = r512;
    L349:
        if (r48.isRealOrgnizer() == false) goto L353;
        if (r87 == null) goto L352;
    L353:
        r513 = "active";
        r122.put("invitee_list", i.Z(this).q(r48.getInviteType(), false, true));
        goto L355
    L347:
        r130 = "type";
        goto L349
    L416:
        r66 = "belong";
        r67 = "live";
        r130 = "type";
        r116 = "other";
        r122 = r122;
        r103 = "end_type";
        r98 = r414;
        r132 = "disconnect";
        r92 = "invite_mode";
    L328:
        r83 = r512;
    L320:
        r80 = r512;
        goto L321
    L319:
        r512 = r128;
        goto L320
    L313:
        r79 = r50;
        goto L314
    L309:
        r78 = "off";
    L305:
        r127 = 0;
    L297:
        r77 = 0;
        goto L298
    L296:
        r311 = "endType";
        goto L297
    L286:
        if (i.m(this).i() != 0) goto L288;
        r124 = i.m(this).f();
    L276:
        if (r48 == null) goto L278;
        Integer r151 = r48.getEndType();
    L279:
        if (r151 != null) goto L282;
    L470:
        Object r152 = r37;
        Object r153 = r511;
        if (r111 == null) goto L521;
        PkBaseStateMachine.c r154 = r111.getCurPKBaseState();
        if (r154 != null) goto L475;
        return;
    L475:
        if ((r154 instanceof PkBaseStateMachine.c.d) != true) goto L523;
        LinkedHashMap r155 = new LinkedHashMap();
        qr2.e r156 = n41.a.c();
        if (r156 == null) goto L479;
        boolean r157 = r156.d;
    L480:
        if (r157 == false) goto L482;
        Object r158 = DataType.TRUE;
    L483:
        r155.put("is_with_audience", r158);
        qr2.e r159 = n41.a.c();
        if (r159 == null) goto L486;
        long r160 = r159.e;
    L488:
        if (r160 != 0) goto L496;
        qr2.e r161 = n41.a.c();
        if (r161 == null) goto L492;
        boolean r162 = r161.d;
    L493:
        if (r162 == false) goto L496;
        r160 = (System.currentTimeMillis() - q.c()) / ((long) WebcastRedirectException.UNKNOWN);
        goto L496
    L492:
        r162 = false;
    L496:
        r155.put("audience_time", String.valueOf(r160));
        if (r111.modType() != PkBaseDataContext.PKModType.Vote) goto L510;
        r155.put("invite_mode", "vote");
        aa r163 = r111.getVoteSetting();
        if (r163 == null) goto L501;
        String r164 = r163.getVoteDes();
    L502:
        if (r164 == null) goto L510;
        aa r165 = r111.getVoteSetting();
        if (r165 == null) goto L507;
        String r166 = r165.getVoteDes();
        if (r166 == null) goto L507;
    L508:
        r155.put(r152, r166);
    L507:
        r166 = r510;
        goto L508
    L501:
        r164 = null;
    L510:
        if (r111.modType() != PkBaseDataContext.PKModType.BreakThrough) goto L512;
        r155.put("invite_mode", "cooperation");
    L512:
        r155.put("room_status", i.Z(this).s());
        r155.put(r153, r510);
        n r167 = new n();
        Map<String, String> r168 = r167.a;
        String r169 = r68;
        Intrinsics.checkNotNullParameter(r168, r169);
        Intrinsics.checkNotNullParameter(r155, r169);
        r168.putAll(r155);
        m r170 = new m();
        i.m(this).m(r170);
        r170.b(LogCommon.ROOM);
        com.bytedance.android.livesdk.revenue.log.h r171 = vh6.c.b(kr2.a.class).be();
        Intrinsics.checkNotNullParameter(r171, "linkInfoLog");
        r171.c(r27);
        if (r3 == false) goto L515;
        String r172 = "room_close";
    L516:
        Intrinsics.checkNotNullParameter(r172, "endType");
        r171.d(r172);
        String r173 = String.valueOf((System.currentTimeMillis() - r111.getStartPenaltyTimeMs()) / ((long) WebcastRedirectException.UNKNOWN));
        Intrinsics.checkNotNullParameter(r173, "connectionTime");
        r171.b(r173);
        ((ArrayList) r170.a).add(r171.a);
        ((ArrayList) r167.b).addAll(r170.a);
        cy0.e.a.getClass();
        j r174 = cy0.e.a.a;
        com.bytedance.android.scope.m.e.getClass();
        Object r175 = com.bytedance.android.scope.m.b(r174).a(Reflection.getOrCreateKotlinClass(mz0.i.class));
        Intrinsics.checkNotNull(r175);
        ((mz0.i) ((f80.a) r175)).w3("punish_end", r167.a, r167.b);
        return;
    L515:
        r172 = "disconnect";
        goto L516
    L486:
        r160 = 0;
        goto L488
    L482:
        r158 = r50;
        goto L483
    L479:
        r157 = false;
        goto L480
    L523:
        return;
    L521:
        return;
    L282:
        if (r151.intValue() != 12) goto L470;
    L278:
        r151 = null;
        goto L279
    L266:
        r511 = r410;
        if (r65.intValue() == 12) goto L271;
    L262:
        r65 = null;
        goto L263
    L186:
        if (r111.getBreakThroughInfo() == null) goto L203;
        n3 r176 = r111.getBreakThroughInfo();
        if (r176 == null) goto L190;
        String r177 = r176.getMvpAnchorId();
    L191:
        if (r177 == null) goto L203;
        n3 r178 = r111.getBreakThroughInfo();
        if (r178 == null) goto L195;
        String r179 = r178.getMvpAnchorId();
    L197:
        if (Intrinsics.areEqual(r179, iz.a.a(r10.getOwnerKt())) == false) goto L199;
        Object r180 = DataType.TRUE;
    L200:
        r14.put("is_mvp", r180);
        goto L203
    L199:
        r180 = r50;
        goto L200
    L195:
        r179 = null;
        goto L197
    L190:
        r177 = null;
    L203:
        if (r111.getBreakThroughInfo() == null) goto L217;
        n3 r181 = r111.getBreakThroughInfo();
        if (r181 != null) goto L207;
    L209:
        boolean r182 = false;
    L210:
        r414 = "connection_type";
        if (r182 == false) goto L213;
        Object r183 = DataType.TRUE;
    L214:
        r14.put("is_finish", r183);
        if (r182 == true) goto L218;
        r14.put("finish_level", String.valueOf(r111.getBreakThroughStage()));
    L218:
        IBattleConfigSetting r184 = r111.getConfigSetting();
        if (r184 == null) goto L246;
        m3 r185 = r184.getBreakthroughConfig();
        if (r185 == null) goto L246;
        List r186 = r185.getStages();
        if (r186 == null) goto L246;
        if ((!r186.isEmpty()) != true) goto L246;
        IBattleConfigSetting r187 = r111.getConfigSetting();
        if (r187 == null) goto L233;
        m3 r188 = r187.getBreakthroughConfig();
        if (r188 == null) goto L233;
        List r189 = r188.getStages();
        if (r189 == null) goto L233;
        int r190 = r189.size();
    L234:
        IBattleConfigSetting r191 = r111.getConfigSetting();
        if (r191 == null) goto L243;
        m3 r192 = r191.getBreakthroughConfig();
        if (r192 == null) goto L243;
        List r193 = r192.getStages();
        if (r193 == null) goto L243;
        m3.b r194 = (m3.b) ListProtector.get(r193, r190 - 1);
        if (r194 == null) goto L243;
        Long r195 = Long.valueOf(r194.getTargetScore());
    L244:
        r14.put("pve_target_value", String.valueOf(r195));
    L243:
        r195 = null;
    L233:
        r190 = 0;
    L246:
        if (r111.isCustomizePkPlay() == false) goto L249;
        r14.put("customize_pk_type", String.valueOf(r111.getCustomizePlayType()));
    L249:
        if (i.O(this).a() == null) goto L258;
        cf2.a r196 = i.O(this).a();
        if (r196 == null) goto L255;
        af2.b r197 = r196.d;
        if (r197 == null) goto L255;
        Long r198 = Long.valueOf(af2.c.b(r197));
    L256:
        r14.put("pve_actual_value", String.valueOf(r198));
    L255:
        r198 = null;
        goto L256
    L213:
        r183 = r50;
        goto L214
    L207:
        if (r181.getState() != 1) goto L209;
        r182 = true;
        goto L210
    L217:
        r414 = "connection_type";
    L170:
        r59 = r49;
        goto L171
    L156:
        if (r111.modType() != PkBaseDataContext.PKModType.BreakThrough) goto L158;
        Object r199 = "pve";
    L159:
        r14.put("room_status", r199);
        goto L162
    L158:
        r199 = r57;
        goto L159
    L147:
        if ((r6 instanceof f.a) == false) goto L149;
        r14.put("room_status", "pve");
        r57 = "pk";
        goto L162
    L149:
        r57 = "pk";
        r14.put("room_status", r57);
        goto L162
    L135:
        r14.put("end_type", r56);
        goto L137
    L132:
        r114 = false;
    L125:
        if (r48.isRealOrgnizer() == false) goto L128;
        if (r54 == null) goto L127;
    L128:
        int r200 = UserListInviteType.a;
        r14.put("invitee_list", UserListInviteType.a(r48.getInviteType(), null));
        goto L129
    L119:
        r53 = r50;
        goto L120
    L115:
        r52 = r411;
    L163:
        r50 = DataType.FALSE;
        r112 = "is_manager";
        r49 = r49;
        r410 = r410;
        r57 = "pk";
        goto L164
    L106:
        r110 = false;
    L102:
        r47 = "";
        goto L104
    L97:
        r39 = "compete";
        goto L98
    L79:
        r37 = FileUtils.PICTURE_THEME;
        goto L80
    L73:
        r33 = "passive";
        goto L74
    L53:
        r25 = "passive";
    L49:
        r24 = "";
        goto L50
    L47:
        r24 = i.T(this).c();
        if (r24 != null) goto L50;
    L41:
        r20 = "";
        goto L42
    L39:
        r20 = iz.a.a(r10.getOwnerKt());
        if (r20 != null) goto L42;
    L29:
        StringBuilder r201 = new StringBuilder();
        e r202 = r18.d();
        if (r202 == null) goto L32;
        long r203 = r202.startTimeMs();
    L33:
        r201.append(String.valueOf(r203));
        r201.append(" ");
        i97.a r204 = i97.a.a;
        r201.append(System.currentTimeMillis());
        jy0.b.b("connection_time_error", r201.toString(), null);
        r19 = "";
        goto L34
    L32:
        r203 = 0;
    L28:
        r26 = "gift_guest_switch_type";
        r27 = r13;
        goto L29
    L518:
        return;
    L16:
        r17 = "off";
        goto L17
    L11:
        if (r15.i() != 0) goto L13;
        r13 = r15.f();
        goto L13
    }

    @Override // com.bytedance.android.live.revlink.link.biz.service.c, com.bytedance.android.live.revlink.link.biz.service.e, com.bytedance.android.live.revlink.link.biz.service.j
    public /* bridge */ /* synthetic */ com.bytedance.android.live.revlink.link.infra.lifecontrol.context.d getContext() {
        return getContext();
    }

    @Override // com.bytedance.android.live.revlink.link.biz.service.k
    public final com.bytedance.android.live.revlink.impl.global.c getLinkInstanceService() {
        return getContext();
    }

    @Override // com.bytedance.android.live.revlink.link.biz.service.e
    public final String getComponentName() {
        return this.a;
    }

    @Override // com.bytedance.android.live.revlink.link.biz.service.c, com.bytedance.android.live.revlink.link.biz.service.e, com.bytedance.android.live.revlink.link.biz.service.j
    public com.bytedance.android.live.revlink.link.infra.lifecontrol.context.a getContext() {
        return this.b;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public b(com.bytedance.android.live.revlink.link.infra.lifecontrol.context.a r2, com.bytedance.android.livesdk.revenue.service.room.c r3, Function3<? super Integer, ? super Boolean, ? super Long, Unit> r4, a r5, Function0<Boolean> r6, Function0<Boolean> r7) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "revRoomService");
        Intrinsics.checkNotNullParameter(r4, "logChorusOver");
        Intrinsics.checkNotNullParameter(r5, "bizDataContext");
        Intrinsics.checkNotNullParameter(r6, "isFinisher");
        Intrinsics.checkNotNullParameter(r7, "isRoomCloser");
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
        this.f = r6;
        this.g = r7;
        this.a = "DoubleEventTrackComponent";
    }
}
