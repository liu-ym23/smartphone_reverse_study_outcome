package h41;

import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.link.constants.UserListInviteType;
import com.bytedance.android.live.profile.monitor.DataType;
import com.bytedance.android.live.revlink.impl.LinkCrossRoomDataHolder;
import com.bytedance.android.live.revlink.impl.mergepk.pkbase.PkBaseDataContext;
import com.bytedance.android.live.revlink.impl.mergepk.pkbase.statemachine.PkBaseStateMachine;
import com.bytedance.android.live.revlink.impl.multianchor.dialog.linkopt.c0;
import com.bytedance.android.live.revlink.impl.multianchor.utils.a0;
import com.bytedance.android.live.revlink.impl.pk.service.IPKLinkBizDataService;
import com.bytedance.android.live.revlink.impl.pk.utils.q;
import com.bytedance.android.live.revlink.impl.pk.vm.linkout.PkCustomizePlayDataContext;
import com.bytedance.android.live.saas.middleware.store.FileUtils;
import com.bytedance.android.live.schema.api.WebcastRedirectException;
import com.bytedance.android.livesdk.chatroom.interact.model.h0;
import com.bytedance.android.livesdk.link.model.IBattleConfigSetting;
import com.bytedance.android.livesdk.link.model.IBattleRivalTag;
import com.bytedance.android.livesdk.link.model.ILinkMicBattleInviteMessage;
import com.bytedance.android.livesdk.link.model.aa;
import com.bytedance.android.livesdk.link.model.api.IBaseBattleSetting;
import com.bytedance.android.livesdk.link.model.d4;
import com.bytedance.android.livesdk.link.model.h3;
import com.bytedance.android.livesdk.link.model.h9;
import com.bytedance.android.livesdk.link.model.m3;
import com.bytedance.android.livesdk.link.model.n3;
import com.bytedance.android.livesdk.link.model.p;
import com.bytedance.android.livesdk.link.model.p0;
import com.bytedance.android.livesdk.link.model.u2;
import com.bytedance.android.livesdk.link.model.v0;
import com.bytedance.android.livesdk.link.model.v2;
import com.bytedance.android.livesdk.link.model.w2;
import com.bytedance.android.livesdk.revenue.log.LogCommon;
import com.bytedance.android.livesdk.revenue.log.i;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.live.kmp.core.KmpEnv;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import cy0.j;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import mz0.l;
import mz0.m;
import mz0.n;
import mz0.o;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class e {
    public final IRoom a;
    public final LinkCrossRoomDataHolder b;
    public final IPKLinkBizDataService c;
    public final com.bytedance.android.live.revlink.impl.global.c d;
    public final boolean e;
    public final x11.a f;

    public static boolean q(int r1) {
        if (r1 > 0) goto L4;
    L6:
        return false;
    L4:
        if (r1 >= 100) goto L6;
        return true;
    }

    public final void d() {
        LinkedHashMap r0 = new LinkedHashMap();
        int r1 = 0;
        long r2 = 0;
        w31.c r4 = n();
        if (r4 == null) goto L5;
        int r5 = r4.a();
    L6:
        if (r5 <= 0) goto L12;
        LinkCrossRoomDataHolder r6 = this.b;
        if (r6 == null) goto L12;
        if (r6.i() != 0) goto L12;
        r2 = this.b.f();
    L12:
        r0.put("pk_mode", DataType.Normal);
        q r7 = o();
        Long r8 = null;
        if (r7 == null) goto L15;
        com.bytedance.android.live.revlink.impl.mergepk.pkdouble.c r9 = r7.g();
    L16:
        com.bytedance.android.live.revlink.impl.mergepk.pkbase.e r10 = l();
        String r12 = DataType.TRUE;
        if (r9 != null) goto L19;
    L21:
        String r13 = DataType.FALSE;
    L22:
        r0.put("is_top_smash", r13);
        com.bytedance.android.live.revlink.impl.mergepk.pkbase.f r14 = k();
        if (r14 == null) goto L25;
        cf2.a r15 = r14.a();
    L26:
        if (r15 == null) goto L34;
        com.bytedance.android.live.revlink.impl.mergepk.pkbase.f r16 = k();
        if (r16 == null) goto L34;
        cf2.a r17 = r16.a();
        if (r17 == null) goto L34;
        af2.b r18 = r17.d;
        if (r18 == null) goto L34;
        int r19 = (int) af2.c.b(r18);
    L35:
        com.bytedance.android.live.revlink.impl.mergepk.pkdouble.e r20 = m();
        if (r20 == null) goto L38;
        cf2.a r22 = r20.a();
    L39:
        if (r22 == null) goto L47;
        com.bytedance.android.live.revlink.impl.mergepk.pkdouble.e r23 = m();
        if (r23 == null) goto L47;
        cf2.a r24 = r23.a();
        if (r24 == null) goto L47;
        af2.b r25 = r24.d;
        if (r25 == null) goto L47;
        r1 = (int) af2.c.b(r25);
    L47:
        r0.put("total_diamond", String.valueOf(r19 + r1));
        r0.put("invitor_diamond", String.valueOf(r19));
        r0.put("right_user_diamond", String.valueOf(r1));
        if (l51.a.r() == false) goto L50;
        String r3 = "on";
    L51:
        r0.put("gift_guest_switch_type", r3);
        r0.put("is_cutoff", DataType.TRUE);
        w31.c r26 = n();
        if (r26 != null) goto L54;
    L56:
        String r27 = DataType.FALSE;
    L57:
        r0.put("is_transform", r27);
        r0.put("pk_type", DataType.FALSE);
        r0.put("pk_anchor_cnt", "2");
        r0.put("connection_anchor_cnt", "2");
        r0.put("guest_in", DataType.FALSE);
        w31.c r28 = n();
        if (r28 == null) goto L60;
        r8 = Long.valueOf(r28.i());
    L60:
        r0.put("pk_id", String.valueOf(r8));
        String r29 = "";
        if (i() == null) goto L68;
        com.bytedance.android.live.revlink.impl.service.internal.a r30 = i();
        if (r30 == null) goto L66;
        String r32 = String.valueOf(r30.Wp());
        if (r32 == null) goto L66;
    L67:
        r0.put("audience_num", r32);
    L66:
        r32 = "";
    L68:
        long r33 = 0;
        if (r10 == null) goto L71;
        long r110 = r10.getPkStartTimeMs();
    L73:
        if (r10 == null) goto L121;
        r0.putAll(r10.getCommonLogParams());
        if (o() != null) goto L77;
    L79:
        r12 = DataType.FALSE;
    L80:
        r0.put("is_with_audience", r12);
        if (o() == null) goto L85;
        int r34 = q.d;
        qr2.e r35 = n41.a.c();
        if (r35 == null) goto L85;
        long r36 = r35.b;
    L87:
        if (r36 == 0) goto L89;
    L96:
        r0.put("audience_time", String.valueOf(r36));
        if (r10.modType() != PkBaseDataContext.PKModType.BreakThrough) goto L100;
        r0.put("invite_mode", "cooperation");
        b(r0, r10);
    L100:
        if (r10.modType() != PkBaseDataContext.PKModType.SeasonRank) goto L103;
        r0.put("invite_mode", "season_rank");
    L103:
        if (r10.modType() != PkBaseDataContext.PKModType.CloudCollaborate) goto L113;
        r0.put("invite_mode", "link_screen");
        IBaseBattleSetting r37 = r10.getBattleSettings();
        if (r37 == null) goto L110;
        h3 r38 = r37.getTitleConfig();
        if (r38 == null) goto L110;
        String r39 = r38.getContent();
        if (r39 == null) goto L110;
    L111:
        r0.put("playmode_name", r39);
    L110:
        r39 = "";
    L113:
        if (r10.getBattleSettings() == null) goto L121;
        IBaseBattleSetting r40 = r10.getBattleSettings();
        if (r40 == null) goto L120;
        String r42 = String.valueOf(r40.getDuration());
        if (r42 == null) goto L120;
        r29 = r42;
    L120:
        r0.put("pk_time", r29);
        goto L121
    L89:
        if (o() == null) goto L96;
        if (q.b() != true) goto L96;
        i97.a r43 = i97.a.a;
        long r44 = System.currentTimeMillis();
        if (o() == null) goto L95;
        r33 = q.c();
    L95:
        r36 = (r44 - r33) / ((long) WebcastRedirectException.UNKNOWN);
    L85:
        r36 = 0;
        goto L87
    L77:
        if (q.b() != true) goto L79;
    L121:
        IPKLinkBizDataService r45 = this.c;
        if (r45 == null) goto L124;
        IBattleRivalTag.a r46 = IBattleRivalTag.Companion;
        ArrayList<IBattleRivalTag> r47 = r45.getPkBattleRivalTagsInfo();
        r46.getClass();
        IBattleRivalTag.a.a(r47, r0);
    L124:
        c(r0);
        if (r10 != null) goto L127;
    L129:
        i97.a r48 = i97.a.a;
        String r49 = String.valueOf((System.currentTimeMillis() - r110) / ((long) WebcastRedirectException.UNKNOWN));
        n r50 = new n();
        Map<String, String> r52 = r50.a;
        Intrinsics.checkNotNullParameter(r52, "map");
        Intrinsics.checkNotNullParameter(r0, "map");
        r52.putAll(r0);
        if (r10 == null) goto L132;
        Map<String, String> r53 = r10.getServerEventTrackingInfo();
        Intrinsics.checkNotNullParameter(r53, "map");
        r52.putAll(r53);
    L132:
        m r54 = new m();
        i r55 = vh6.c.b(kr2.a.class).ud();
        Intrinsics.checkNotNullParameter(r55, "pageSourceLog");
        Intrinsics.checkNotNullParameter("live_detail", "page");
        r55.c("live_detail");
        Intrinsics.checkNotNullParameter("live", "belong");
        r55.a("live");
        Intrinsics.checkNotNullParameter("other", "type");
        r55.d("other");
        ((ArrayList) r54.a).add(r55.a);
        com.bytedance.android.livesdk.revenue.log.h r56 = vh6.c.b(kr2.a.class).be();
        l r57 = new l(r56);
        r57.a.c(r2);
        Intrinsics.checkNotNullParameter("disconnect", "endType");
        r57.a.d("disconnect");
        Intrinsics.checkNotNullParameter(r49, "connectionTime");
        r57.a.b(r49);
        e(r57);
        ((ArrayList) r54.a).add(r56.a);
        LinkCrossRoomDataHolder r58 = g();
        if (r58 == null) goto L135;
        r58.m(r54);
    L135:
        r54.b(LogCommon.ROOM);
        ((ArrayList) r50.b).addAll(r54.a);
        cy0.e.a.getClass();
        j r59 = cy0.e.a.a;
        com.bytedance.android.scope.m.e.getClass();
        Object r60 = com.bytedance.android.scope.m.b(r59).a(Reflection.getOrCreateKotlinClass(mz0.i.class));
        Intrinsics.checkNotNull(r60);
        ((mz0.i) ((f80.a) r60)).w3("livesdk_pk_end", r50.a, r50.b);
        return;
    L127:
        if (r10.isCustomizePkPlay() == false) goto L129;
        r0.put("invite_mode", "customize_pk");
        r0.put("customize_pk_type", String.valueOf(r10.getCustomizePlayType()));
        r0.put("membership_exchange_rate", String.valueOf(a0.a(r10.getBattleSettings())));
        goto L129
    L71:
        r110 = 0;
        goto L73
    L54:
        if (r26.q() != true) goto L56;
        r27 = DataType.TRUE;
        goto L57
    L50:
        r3 = "off";
        goto L51
    L38:
        r22 = null;
    L34:
        r19 = 0;
        goto L35
    L25:
        r15 = null;
        goto L26
    L19:
        if (r9.getTeamTaskService().getTopSecKillTrigger() == false) goto L21;
        r13 = DataType.TRUE;
        goto L22
    L15:
        r9 = null;
        goto L16
    L5:
        r5 = 0;
        goto L6
    }

    public final LinkCrossRoomDataHolder g() {
        com.bytedance.android.live.revlink.impl.global.c r0 = this.d;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getLinkCrossRoomDataHolder();
    }

    public final com.bytedance.android.live.revlink.impl.multianchor.dialog.linkopt.e h() {
        com.bytedance.android.live.revlink.impl.global.c r0 = this.d;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getLinkOptLogContext();
    }

    public final com.bytedance.android.live.revlink.impl.service.internal.a i() {
        com.bytedance.android.live.revlink.impl.global.c r0 = this.d;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.Do();
    }

    public final com.bytedance.android.live.revlink.impl.pk.service.a j() {
        com.bytedance.android.live.revlink.impl.global.c r0 = this.d;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.ja();
    }

    public final com.bytedance.android.live.revlink.impl.mergepk.pkbase.f k() {
        com.bytedance.android.live.revlink.impl.global.c r0 = this.d;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getPKBaseUtils();
    }

    public final com.bytedance.android.live.revlink.impl.mergepk.pkbase.e l() {
        com.bytedance.android.live.revlink.impl.global.c r0 = this.d;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.Ig();
    }

    public final com.bytedance.android.live.revlink.impl.mergepk.pkdouble.e m() {
        com.bytedance.android.live.revlink.impl.global.c r0 = this.d;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.el();
    }

    public final w31.c n() {
        com.bytedance.android.live.revlink.impl.global.c r0 = this.d;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getPkLinkUtils();
    }

    public final q o() {
        com.bytedance.android.live.revlink.impl.global.c r0 = this.d;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getPkUtils();
    }

    public final d31.d p() {
        com.bytedance.android.live.revlink.impl.global.c r0 = this.d;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getRevLinkLogHelper();
    }

    public final void t() {
        LinkedHashMap r1 = new LinkedHashMap();
        long r3 = 0;
        w31.c r5 = n();
        if (r5 == null) goto L5;
        int r6 = r5.a();
    L6:
        if (r6 <= 0) goto L12;
        LinkCrossRoomDataHolder r7 = this.b;
        if (r7 == null) goto L12;
        if (r7.i() != 0) goto L12;
        r3 = this.b.f();
    L12:
        q r8 = o();
        if (r8 == null) goto L15;
        com.bytedance.android.live.revlink.impl.mergepk.pkdouble.c r9 = r8.g();
    L16:
        com.bytedance.android.live.revlink.impl.mergepk.pkbase.e r10 = l();
        com.bytedance.android.live.revlink.impl.mergepk.pkbase.f r12 = k();
        if (r12 == null) goto L19;
        cf2.a r13 = r12.a();
    L20:
        if (r13 == null) goto L28;
        com.bytedance.android.live.revlink.impl.mergepk.pkbase.f r14 = k();
        if (r14 == null) goto L28;
        cf2.a r15 = r14.a();
        if (r15 == null) goto L28;
        af2.b r16 = r15.d;
        if (r16 == null) goto L28;
        int r17 = (int) af2.c.b(r16);
    L29:
        com.bytedance.android.live.revlink.impl.mergepk.pkdouble.e r18 = m();
        if (r18 == null) goto L32;
        cf2.a r19 = r18.a();
    L33:
        if (r19 == null) goto L41;
        com.bytedance.android.live.revlink.impl.mergepk.pkdouble.e r20 = m();
        if (r20 == null) goto L41;
        cf2.a r22 = r20.a();
        if (r22 == null) goto L41;
        af2.b r23 = r22.d;
        if (r23 == null) goto L41;
        int r24 = (int) af2.c.b(r23);
    L42:
        r1.put("total_diamond", String.valueOf(r17 + r24));
        r1.put("invitor_diamond", String.valueOf(r17));
        r1.put("right_user_diamond", String.valueOf(r24));
        if (l51.a.r() == false) goto L45;
        String r25 = "on";
    L46:
        r1.put("gift_guest_switch_type", r25);
        w31.c r26 = n();
        String r27 = DataType.TRUE;
        if (r26 != null) goto L49;
    L51:
        Object r28 = DataType.FALSE;
    L52:
        r1.put("is_transform", r28);
        r1.put("pk_type", DataType.FALSE);
        r1.put("pk_anchor_cnt", "2");
        r1.put("connection_anchor_cnt", "2");
        r1.put("guest_in", DataType.FALSE);
        w31.c r29 = n();
        if (r29 == null) goto L55;
        Long r30 = Long.valueOf(r29.i());
    L56:
        r1.put("pk_id", String.valueOf(r30));
        if (r9 != null) goto L59;
    L61:
        Object r32 = DataType.FALSE;
    L62:
        r1.put("is_top_smash", r32);
        r1.put("pk_mode", DataType.Normal);
        String r110 = "";
        if (i() == null) goto L71;
        com.bytedance.android.live.revlink.impl.service.internal.a r33 = i();
        if (r33 == null) goto L68;
        String r34 = String.valueOf(r33.Wp());
        if (r34 == null) goto L68;
    L69:
        r1.put("audience_num", r34);
    L68:
        r34 = "";
    L71:
        if (r10 == null) goto L73;
        long r111 = r10.getPkStartTimeMs();
    L75:
        if (r10 == null) goto L143;
        r1.putAll(r10.getCommonLogParams());
        if (o() != null) goto L79;
    L81:
        r27 = DataType.FALSE;
    L82:
        r1.put("is_with_audience", r27);
        if (o() == null) goto L87;
        int r35 = q.d;
        qr2.e r36 = n41.a.c();
        if (r36 == null) goto L87;
        long r2 = r36.b;
    L89:
        if (r2 == 0) goto L91;
    L99:
        r1.put("audience_time", String.valueOf(r2));
        if (r10.modType() != PkBaseDataContext.PKModType.Vote) goto L113;
        r1.put("invite_mode", "vote");
        aa r4 = r10.getVoteSetting();
        if (r4 == null) goto L104;
        String r37 = r4.getVoteDes();
    L105:
        if (r37 == null) goto L113;
        aa r38 = r10.getVoteSetting();
        if (r38 == null) goto L110;
        String r39 = r38.getVoteDes();
        if (r39 == null) goto L110;
    L111:
        r1.put(FileUtils.PICTURE_THEME, r39);
    L110:
        r39 = "";
        goto L111
    L104:
        r37 = null;
    L113:
        if (r10.modType() != PkBaseDataContext.PKModType.BreakThrough) goto L116;
        r1.put("invite_mode", "cooperation");
        b(r1, r10);
    L116:
        if (r10.isInCompetition() == false) goto L119;
        r1.put("invite_mode", "compete");
    L119:
        if (r10.getBattleSettings() == null) goto L127;
        IBaseBattleSetting r40 = r10.getBattleSettings();
        if (r40 == null) goto L124;
        String r42 = String.valueOf(r40.getDuration());
        if (r42 == null) goto L124;
    L125:
        r1.put("pk_time", r42);
    L124:
        r42 = "";
    L127:
        if (r10.isCustomizePkPlay() == false) goto L130;
        r1.put("invite_mode", "customize_pk");
        r1.put("customize_pk_type", String.valueOf(r10.getCustomizePlayType()));
        r1.put("membership_exchange_rate", String.valueOf(a0.a(r10.getBattleSettings())));
    L130:
        if (r10.modType() != PkBaseDataContext.PKModType.SeasonRank) goto L133;
        r1.put("invite_mode", "season_rank");
    L133:
        if (r10.modType() != PkBaseDataContext.PKModType.CloudCollaborate) goto L144;
        r1.put("invite_mode", "link_screen");
        IBaseBattleSetting r43 = r10.getBattleSettings();
        if (r43 == null) goto L142;
        h3 r44 = r43.getTitleConfig();
        if (r44 == null) goto L142;
        String r45 = r44.getContent();
        if (r45 == null) goto L142;
        r110 = r45;
    L142:
        r1.put("playmode_name", r110);
    L144:
        IPKLinkBizDataService r46 = this.c;
        if (r46 == null) goto L147;
        IBattleRivalTag.a r47 = IBattleRivalTag.Companion;
        ArrayList<IBattleRivalTag> r48 = r46.getPkBattleRivalTagsInfo();
        r47.getClass();
        IBattleRivalTag.a.a(r48, r1);
    L147:
        c(r1);
        if (r9 == null) goto L150;
        Integer r49 = r9.getEndType();
    L151:
        if (r49 != null) goto L154;
    L158:
        i97.a r50 = i97.a.a;
        long r52 = System.currentTimeMillis() - r111;
        long r53 = WebcastRedirectException.UNKNOWN;
        String r54 = String.valueOf(r52 / r53);
        n r55 = new n();
        Map<String, String> r56 = r55.a;
        Intrinsics.checkNotNullParameter(r56, "map");
        Intrinsics.checkNotNullParameter(r1, "map");
        r56.putAll(r1);
        if (r10 == null) goto L161;
        Map<String, String> r57 = r10.getServerEventTrackingInfo();
        Intrinsics.checkNotNullParameter(r57, "map");
        r56.putAll(r57);
    L161:
        m r58 = new m();
        i r59 = vh6.c.b(kr2.a.class).ud();
        Intrinsics.checkNotNullParameter(r59, "pageSourceLog");
        Intrinsics.checkNotNullParameter("live", "belong");
        r59.a("live");
        Intrinsics.checkNotNullParameter("other", "type");
        r59.d("other");
        Intrinsics.checkNotNullParameter("live_detail", "page");
        r59.c("live_detail");
        ((ArrayList) r58.a).add(r59.a);
        com.bytedance.android.livesdk.revenue.log.h r60 = vh6.c.b(kr2.a.class).be();
        l r62 = new l(r60);
        e(r62);
        Intrinsics.checkNotNullParameter(r54, "connectionTime");
        r62.a.b(r54);
        r62.a.c(r3);
        if (Intrinsics.areEqual((String) r1.get("end_type"), "room_close") == false) goto L164;
        Intrinsics.checkNotNullParameter("room_close", "endType");
        r62.a.d("room_close");
    L164:
        ((ArrayList) r58.a).add(r60.a);
        LinkCrossRoomDataHolder r63 = g();
        if (r63 == null) goto L167;
        r63.m(r58);
    L167:
        r58.b(LogCommon.ROOM);
        ((ArrayList) r55.b).addAll(r58.a);
        cy0.e.a.getClass();
        j r64 = cy0.e.a.a;
        com.bytedance.android.scope.m.e.getClass();
        Object r65 = com.bytedance.android.scope.m.b(r64).a(Reflection.getOrCreateKotlinClass(mz0.i.class));
        Intrinsics.checkNotNull(r65);
        ((mz0.i) ((f80.a) r65)).w3("livesdk_pk_end", r55.a, r55.b);
        Object r66 = com.bytedance.android.scope.m.b(r64).b(er2.b.class);
        Intrinsics.checkNotNull(r66);
        iq2.b r67 = ((com.bytedance.live.kmp.core.c) r66).getChorusService();
        if (r67 != null) goto L170;
        return;
    L170:
        if (r67.e() == true) goto L172;
        return;
    L172:
        if (r67.c() == null) goto L184;
        com.bytedance.android.live.liveinteract.model.a r68 = r67.c();
        if (r68 == null) goto L176;
        long r69 = r68.getStartTime();
    L177:
        long r70 = 0;
        if (r69 <= 0) goto L185;
        long r72 = com.bytedance.live.kmp.util.e.b() / r53;
        com.bytedance.android.live.liveinteract.model.a r73 = r67.c();
        if (r73 == null) goto L182;
        long r112 = r73.getStartTime();
    L183:
        long r113 = r72 - r112;
    L186:
        r(false, r113);
        return;
    L182:
        r112 = 0;
    L185:
        r113 = r70;
        goto L186
    L176:
        r69 = 0;
        goto L177
    L184:
        r70 = 0;
        goto L185
    L154:
        if (r49.intValue() != 1) goto L158;
        if (d51.c.A0.m() == false) goto L158;
        r1.put("end_reason", "passive");
        goto L158
    L150:
        r49 = null;
        goto L151
    L91:
        if (o() == null) goto L99;
        if (q.b() != true) goto L99;
        i97.a r74 = i97.a.a;
        long r75 = System.currentTimeMillis();
        if (o() == null) goto L97;
        long r114 = q.c();
    L98:
        r2 = (r75 - r114) / ((long) WebcastRedirectException.UNKNOWN);
        goto L99
    L97:
        r114 = 0;
    L87:
        r2 = 0;
        goto L89
    L79:
        if (q.b() != true) goto L81;
    L143:
        r3 = r3;
        goto L144
    L73:
        r111 = 0;
        goto L75
    L59:
        if (r9.getTeamTaskService().getTopSecKillTrigger() == false) goto L61;
        r32 = DataType.TRUE;
        goto L62
    L55:
        r30 = null;
        goto L56
    L49:
        if (r26.q() != true) goto L51;
        r28 = DataType.TRUE;
        goto L52
    L45:
        r25 = "off";
    L41:
        r24 = 0;
        goto L42
    L32:
        r19 = null;
    L28:
        r17 = 0;
        goto L29
    L19:
        r13 = null;
        goto L20
    L15:
        r9 = null;
        goto L16
    L5:
        r6 = 0;
        goto L6
    }

    public static void a(Map r2) {
        r2.put("audience_connect_cnt", String.valueOf(n41.a.b()));
    }

    public final void c(Map<String, String> r10) {
        q r0 = o();
        Integer r1 = null;
        if (r0 == null) goto L5;
        com.bytedance.android.live.revlink.impl.mergepk.pkdouble.c r2 = r0.g();
    L6:
        com.bytedance.android.live.revlink.impl.mergepk.pkbase.e r3 = l();
        String r4 = "";
        if (r2 == null) goto L41;
        Integer r5 = r2.getEndType();
        if (r5 == null) goto L15;
        if (r5.intValue() != 0) goto L15;
        r10.put("end_reason", "routine");
    L22:
        w31.c r6 = n();
        if (r6 == null) goto L25;
        IPKLinkBizDataService r7 = r6.g();
    L27:
        if (r7 != null) goto L29;
    L31:
        d31.d r8 = p();
        if (r8 == null) goto L35;
        String r9 = r8.p(r2.getInviteType());
        if (r9 == null) goto L35;
    L36:
        r10.put("invitee_list", r9);
    L37:
        String r12 = r2.isManager();
        if (r12 != null) goto L40;
        r12 = "";
    L40:
        r10.put("is_manager", r12);
        r10.put("audience_connect_cnt", r2.getAudienceConnectCnt());
    L35:
        r9 = "";
        goto L36
    L29:
        if (r7.getIsRealOrganizer() == false) goto L31;
        r10.put("invitee_list", "active");
        goto L37
    L25:
        r7 = null;
    L15:
        if (r2.isRoomCloser() == false) goto L17;
    L21:
        r10.put("end_reason", r2.getEndReason());
        goto L22
    L17:
        if (r2.isFinisher() == true) goto L21;
        if (d51.c.A0.m() == false) goto L21;
        r10.put("end_reason", "passive");
    L41:
        r10.put("connection_sub_type", "");
        r10.put("anchor_connect_status", "2");
        if (r2 == null) goto L49;
        if (r3 == null) goto L45;
        PkBaseDataContext.PKModType r13 = r3.modType();
    L47:
        if (r13 != PkBaseDataContext.PKModType.BreakThrough) goto L49;
        String r14 = "pve";
    L50:
        r10.put("room_status", r14);
        x11.a r15 = this.f;
        if (r15 == null) goto L53;
        y11.d r16 = r15.getPkService();
    L55:
        if (r16 == null) goto L58;
        r10.put("invite_mode", r16.getInviteMode());
    L58:
        if (r2 == null) goto L66;
        Integer r17 = r2.getEndType();
        if (r17 == null) goto L66;
        if (r17.intValue() != 0) goto L66;
        r10.put("end_type", "routine");
    L66:
        if (p() == null) goto L70;
        if (r2 == null) goto L69;
        r1 = r2.getEndType();
    L69:
        String r18 = d31.d.e(r1);
    L71:
        r10.put("end_type", r18);
        i97.a r19 = i97.a.a;
        long r20 = System.currentTimeMillis();
        q r22 = o();
        long r23 = 0;
        if (r22 == null) goto L76;
        com.bytedance.android.live.revlink.impl.mergepk.pkbase.e r24 = r22.d();
        if (r24 == null) goto L76;
        r23 = r24.startTimeMs();
    L76:
        r10.put("connection_time", String.valueOf((r20 - r23) / ((long) WebcastRedirectException.UNKNOWN)));
        if (r3 != null) goto L79;
        return;
    L79:
        if (r3.modType() != PkBaseDataContext.PKModType.Vote) goto L91;
        r10.put("invite_mode", "vote");
        if (r3.getVoteSetting() == null) goto L92;
        aa r25 = r3.getVoteSetting();
        if (r25 == null) goto L88;
        String r26 = r25.getVoteDes();
        if (r26 == null) goto L88;
        r4 = r26;
    L88:
        r10.put(FileUtils.PICTURE_THEME, r4);
        return;
    L92:
        return;
    L91:
        return;
    L70:
        r18 = "";
        goto L71
    L53:
        r16 = null;
        goto L55
    L45:
        r13 = null;
    L49:
        r14 = "pk";
        goto L50
    L5:
        r2 = null;
        goto L6
    }

    public final void e(l r5) {
        w31.c r0 = n();
        String r1 = "";
        String r2 = null;
        if (r0 != null) goto L5;
    L18:
        w31.c r3 = n();
        if (r3 == null) goto L21;
        r2 = r3.c();
    L21:
        r5.b(r2);
        IRoom r4 = this.a;
        if (r4 == null) goto L29;
        IBaseUser r6 = r4.getOwnerKt();
        if (r6 == null) goto L29;
        String r7 = r6.getIdString();
        if (r7 == null) goto L29;
        r1 = r7;
    L29:
        r5.a(r1);
        return;
    L5:
        if (r0.e() != true) goto L18;
        IRoom r8 = this.a;
        if (r8 == null) goto L14;
        IBaseUser r9 = r8.getOwnerKt();
        if (r9 == null) goto L14;
        String r10 = r9.getIdString();
        if (r10 == null) goto L14;
        r1 = r10;
    L14:
        r5.b(r1);
        w31.c r12 = n();
        if (r12 == null) goto L17;
        r2 = r12.c();
    L17:
        r5.a(r2);
    }

    public final void b(Map<String, String> r7, com.bytedance.android.live.revlink.impl.mergepk.pkbase.e r8) {
        n3 r0 = r8.getBreakThroughInfo();
        cf2.a r1 = null;
        if (r0 == null) goto L5;
        String r2 = r0.getMvpAnchorId();
    L6:
        String r3 = DataType.TRUE;
        if (r2 == null) goto L23;
        n3 r4 = r8.getBreakThroughInfo();
        if (r4 == null) goto L11;
        String r5 = r4.getMvpAnchorId();
    L12:
        IRoom r6 = this.a;
        if (r6 == null) goto L17;
        IBaseUser r9 = r6.getOwnerKt();
        if (r9 == null) goto L17;
        String r10 = r9.getIdString();
    L19:
        if (Intrinsics.areEqual(r5, r10) == false) goto L21;
        String r12 = DataType.TRUE;
    L22:
        r7.put("is_mvp", r12);
        goto L23
    L21:
        r12 = DataType.FALSE;
    L17:
        r10 = null;
        goto L19
    L11:
        r5 = null;
    L23:
        int r13 = 0;
        if (r8.getBreakThroughInfo() == null) goto L37;
        n3 r14 = r8.getBreakThroughInfo();
        if (r14 != null) goto L28;
    L30:
        boolean r15 = false;
    L31:
        if (r15 == true) goto L34;
        r3 = DataType.FALSE;
    L34:
        r7.put("is_finish", r3);
        if (r15 == true) goto L37;
        r7.put("finish_level", String.valueOf(r8.getBreakThroughStage()));
        goto L37
    L28:
        if (r14.getState() != 1) goto L30;
        r15 = true;
    L37:
        IBattleConfigSetting r16 = r8.getConfigSetting();
        if (r16 == null) goto L44;
        m3 r17 = r16.getBreakthroughConfig();
        if (r17 == null) goto L44;
        List r18 = r17.getStages();
        if (r18 == null) goto L44;
        int r19 = r18.size();
    L45:
        String r20 = "";
        if (r19 <= 0) goto L66;
        IBattleConfigSetting r22 = r8.getConfigSetting();
        if (r22 == null) goto L54;
        m3 r23 = r22.getBreakthroughConfig();
        if (r23 == null) goto L54;
        List r24 = r23.getStages();
        if (r24 == null) goto L54;
        r13 = r24.size();
    L54:
        IBattleConfigSetting r25 = r8.getConfigSetting();
        if (r25 == null) goto L64;
        m3 r26 = r25.getBreakthroughConfig();
        if (r26 == null) goto L64;
        List r27 = r26.getStages();
        if (r27 == null) goto L64;
        m3.b r28 = (m3.b) ListProtector.get(r27, r13 - 1);
        if (r28 == null) goto L64;
        String r29 = String.valueOf(r28.getTargetScore());
        if (r29 == null) goto L64;
    L65:
        r7.put("pve_target_value", r29);
    L64:
        r29 = "";
    L66:
        com.bytedance.android.live.revlink.impl.mergepk.pkbase.f r30 = k();
        if (r30 == null) goto L69;
        r1 = r30.a();
    L69:
        if (r1 == null) goto L82;
        com.bytedance.android.live.revlink.impl.mergepk.pkbase.f r32 = k();
        if (r32 == null) goto L80;
        cf2.a r33 = r32.a();
        if (r33 == null) goto L80;
        af2.b r34 = r33.d;
        if (r34 == null) goto L80;
        String r35 = String.valueOf(af2.c.b(r34));
        if (r35 == null) goto L80;
        r20 = r35;
    L80:
        r7.put("pve_actual_value", r20);
        return;
    L82:
        return;
    L44:
        r19 = 0;
        goto L45
    L5:
        r2 = null;
        goto L6
    }

    public final void r(boolean r7, long r8) {
        LinkedHashMap r0 = new LinkedHashMap();
        r0.put("anchor_connect_status", "2");
        x11.a r1 = this.f;
        com.bytedance.android.live.revlink.impl.multianchor.dialog.linkopt.f r2 = null;
        if (r1 == null) goto L5;
        y11.d r3 = r1.getPkService();
    L6:
        int r4 = 0;
        if (r3 != null) goto L9;
    L14:
        String r5 = "routine_pk";
    L15:
        r0.put("invite_mode", r5);
        int r6 = UserListInviteType.a;
        LinkCrossRoomDataHolder r9 = this.b;
        if (r9 == null) goto L18;
        r4 = r9.f();
    L18:
        r0.put("invitee_list", UserListInviteType.a(r4, null));
        com.bytedance.android.live.revlink.impl.global.c r10 = this.d;
        if (r10 == null) goto L21;
        r2 = r10.getLinkPlayHelper();
    L21:
        if (r2 != null) goto L23;
    L25:
        String r12 = "connection";
    L26:
        r0.put("room_status", r12);
        cy0.e.a.getClass();
        j r13 = cy0.e.a.a;
        com.bytedance.android.scope.m.e.getClass();
        Object r14 = com.bytedance.android.scope.m.b(r13).b(er2.b.class);
        Intrinsics.checkNotNull(r14);
        iq2.b r15 = ((com.bytedance.live.kmp.core.c) r14).getChorusService();
        if (r15 != null) goto L29;
        String r16 = "";
    L33:
        r0.put("role_type", r16);
        r0.put("over_type", "disconnect");
        if (r7 == false) goto L36;
        String r17 = DataType.TRUE;
    L37:
        r0.put("if_active", r17);
        r0.put("chorus_time", String.valueOf(r8));
        if (r15 != null) goto L40;
    L44:
        long r18 = 0;
    L45:
        r0.put("chorus_id", String.valueOf(r18));
        n r19 = new n();
        Map<String, String> r20 = r19.a;
        Intrinsics.checkNotNullParameter(r20, "map");
        Intrinsics.checkNotNullParameter(r0, "map");
        r20.putAll(r0);
        m r22 = new m();
        LinkCrossRoomDataHolder r23 = g();
        if (r23 == null) goto L48;
        r23.m(r22);
    L48:
        r22.b(LogCommon.ROOM);
        r22.b(LogCommon.PAGE_SOURCE_LOG);
        ((ArrayList) r19.b).addAll(r22.a);
        Object r24 = com.bytedance.android.scope.m.b(r13).a(Reflection.getOrCreateKotlinClass(mz0.i.class));
        Intrinsics.checkNotNull(r24);
        ((mz0.i) ((f80.a) r24)).w3("livesdk_connection_chorus_over", r19.a, r19.b);
        return;
    L40:
        if (r15.c() == null) goto L44;
        com.bytedance.android.live.liveinteract.model.a r25 = r15.c();
        if (r25 == null) goto L44;
        r18 = r25.getChorusId();
        goto L45
    L36:
        r17 = DataType.FALSE;
        goto L37
    L29:
        if (r15.d() != 1) goto L31;
        r16 = "leader";
        goto L33
    L31:
        r16 = "follower";
        goto L33
    L23:
        if (r2.c() != true) goto L25;
        r12 = "pk";
        goto L26
    L9:
        if (r3.getInviteMode().length() <= 0) goto L11;
        boolean r26 = true;
    L12:
        if (r26 != true) goto L14;
        r5 = r3.getInviteMode();
        goto L15
    L11:
        r26 = false;
        goto L12
    L5:
        r3 = null;
        goto L6
    }

    public final void v(Map<String, String> r6, String r7) {
        Intrinsics.checkNotNullParameter(r7, "eventName");
        if (r6 != null) goto L5;
        return;
    L5:
        n r0 = new n();
        o r1 = new o(r0.a);
        r1.b(r6);
        com.bytedance.android.live.revlink.impl.mergepk.pkdouble.e r8 = m();
        String r2 = null;
        if (r8 == null) goto L10;
        com.bytedance.android.live.revlink.impl.global.c r9 = r8.a;
        if (r9 == null) goto L10;
        com.bytedance.android.live.revlink.impl.mergepk.pkdouble.b r10 = r9.L1();
    L11:
        if (r10 == null) goto L13;
        p0 r3 = r10.getLaunchBattleAttachedInfo();
    L14:
        if (r3 == null) goto L16;
        e21.c.e(r1, r10.getLaunchBattleAttachedInfo());
    L16:
        m r12 = new m();
        LinkCrossRoomDataHolder r4 = g();
        if (r4 == null) goto L19;
        r4.m(r12);
    L19:
        i r5 = vh6.c.b(kr2.a.class).ud();
        Intrinsics.checkNotNullParameter(r5, "pageSourceLog");
        Intrinsics.checkNotNullParameter("live", "belong");
        r5.a("live");
        Intrinsics.checkNotNullParameter("other", "type");
        r5.d("other");
        Intrinsics.checkNotNullParameter("live_detail", "page");
        r5.c("live_detail");
        ((ArrayList) r12.a).add(r5.a);
        com.bytedance.android.livesdk.revenue.log.h r13 = vh6.c.b(kr2.a.class).be();
        Intrinsics.checkNotNullParameter(r13, "linkInfoLog");
        IRoom r14 = this.a;
        if (r14 == null) goto L25;
        IBaseUser r15 = r14.getOwnerKt();
        if (r15 == null) goto L25;
        String r16 = r15.getIdString();
        if (r16 == null) goto L25;
    L26:
        r13.e(r16);
        w31.c r17 = n();
        if (r17 == null) goto L29;
        r2 = r17.c();
    L29:
        r13.f(r2);
        String r18 = l51.a.m();
        Intrinsics.checkNotNullParameter(r18, "title");
        r13.h(r18);
        r13.a.i = l51.a.j();
        LinkCrossRoomDataHolder r19 = this.b;
        if (r19 == null) goto L32;
        int r20 = r19.f();
    L33:
        r13.c(r20);
        r13.g();
        ((ArrayList) r12.a).add(r13.a);
        r12.b(LogCommon.ROOM);
        ((ArrayList) r0.b).addAll(r12.a);
        cy0.e.a.getClass();
        j r22 = cy0.e.a.a;
        com.bytedance.android.scope.m.e.getClass();
        Object r23 = com.bytedance.android.scope.m.b(r22).a(Reflection.getOrCreateKotlinClass(mz0.i.class));
        Intrinsics.checkNotNull(r23);
        ((mz0.i) ((f80.a) r23)).w3(r7, r0.a, r0.b);
        return;
    L32:
        r20 = 0;
    L25:
        r16 = "";
        goto L26
    L13:
        r3 = null;
    L10:
        r10 = null;
        goto L11
    }

    public final void f(boolean r19, boolean r20, Map r22) {
        if (r20 == false) goto L5;
        return;
    L5:
        w31.c r1 = n();
        String r4 = "";
        if (r1 != null) goto L8;
    L20:
        w31.c r2 = n();
        if (r2 == null) goto L23;
        String r3 = r2.c();
    L24:
        IRoom r5 = this.a;
        if (r5 == null) goto L30;
        IBaseUser r6 = r5.getOwnerKt();
        if (r6 == null) goto L30;
        String r7 = r6.getIdString();
        if (r7 == null) goto L30;
    L32:
        if (this.e == false) goto L250;
        q r8 = o();
        if (r8 == null) goto L36;
        com.bytedance.android.live.revlink.impl.mergepk.pkdouble.c r9 = r8.g();
    L37:
        com.bytedance.android.live.revlink.impl.mergepk.pkbase.e r10 = l();
        if (r9 == null) goto L40;
        Integer r12 = r9.getEndType();
    L41:
        if (r12 != null) goto L44;
    L46:
        boolean r13 = false;
        long r14 = 0;
        if (r10 == null) goto L52;
        PkBaseStateMachine.c r15 = r10.getCurPKBaseState();
        if (r15 == null) goto L52;
        if ((r15 instanceof PkBaseStateMachine.c.C0130c) != true) goto L52;
    L53:
        w31.c r16 = n();
        if (r16 == null) goto L56;
        int r17 = r16.a();
    L57:
        if (r17 <= 0) goto L65;
        LinkCrossRoomDataHolder r18 = g();
        if (r18 == null) goto L65;
        if (r18.i() != 0) goto L65;
        LinkCrossRoomDataHolder r110 = g();
        if (r110 == null) goto L65;
        r14 = r110.f();
    L65:
        LinkedHashMap r111 = new LinkedHashMap();
        if (r19 == false) goto L68;
        Intrinsics.checkNotNull(r22);
        r111.putAll(r22);
    L68:
        com.bytedance.android.live.revlink.impl.mergepk.pkbase.f r112 = k();
        if (r112 == null) goto L71;
        cf2.a r113 = r112.a();
    L72:
        if (r113 == null) goto L80;
        com.bytedance.android.live.revlink.impl.mergepk.pkbase.f r114 = k();
        if (r114 == null) goto L80;
        cf2.a r115 = r114.a();
        if (r115 == null) goto L80;
        af2.b r116 = r115.d;
        if (r116 == null) goto L80;
        int r117 = (int) af2.c.b(r116);
    L81:
        com.bytedance.android.live.revlink.impl.mergepk.pkdouble.e r118 = m();
        if (r118 == null) goto L84;
        cf2.a r119 = r118.a();
    L85:
        if (r119 == null) goto L93;
        com.bytedance.android.live.revlink.impl.mergepk.pkdouble.e r120 = m();
        if (r120 == null) goto L93;
        cf2.a r121 = r120.a();
        if (r121 == null) goto L93;
        af2.b r122 = r121.d;
        if (r122 == null) goto L93;
        int r123 = (int) af2.c.b(r122);
    L94:
        r111.put("total_diamond", String.valueOf(r117 + r123));
        r111.put("invitor_diamond", String.valueOf(r117));
        r111.put("right_user_diamond", String.valueOf(r123));
        if (l51.a.r() == false) goto L97;
        String r124 = "on";
    L98:
        r111.put("gift_guest_switch_type", r124);
        String r125 = DataType.TRUE;
        if (r19 == false) goto L101;
        Object r126 = DataType.TRUE;
    L102:
        r111.put("is_cutoff", r126);
        w31.c r127 = n();
        if (r127 != null) goto L105;
    L107:
        Object r128 = DataType.FALSE;
    L108:
        r111.put("is_transform", r128);
        r111.put("pk_type", DataType.FALSE);
        r111.put("pk_anchor_cnt", "2");
        r111.put("anchor_connect_status", "2");
        r111.put("guest_in", DataType.FALSE);
        w31.c r129 = n();
        if (r129 == null) goto L111;
        Long r130 = Long.valueOf(r129.i());
    L112:
        r111.put("pk_id", String.valueOf(r130));
        if (r9 == null) goto L119;
        com.bytedance.android.live.revlink.impl.pk.vm.pk.e r23 = r9.getTeamTaskService();
        if (r23 == null) goto L119;
        if (r23.getTopSecKillTrigger() != true) goto L119;
        Object r24 = DataType.TRUE;
    L120:
        r111.put("is_top_smash", r24);
        r111.put("pk_mode", DataType.Normal);
        if (i() == null) goto L128;
        com.bytedance.android.live.revlink.impl.service.internal.a r25 = i();
        if (r25 == null) goto L126;
        String r26 = String.valueOf(r25.Wp());
        if (r26 == null) goto L126;
    L127:
        r111.put("audience_num", r26);
    L126:
        r26 = "";
    L128:
        long r131 = 0;
        if (r10 == null) goto L197;
        r111.putAll(r10.getCommonLogParams());
        if (o() != null) goto L133;
    L135:
        r125 = DataType.FALSE;
    L136:
        r111.put("is_with_audience", r125);
        if (o() == null) goto L141;
        int r27 = q.d;
        qr2.e r28 = n41.a.c();
        if (r28 == null) goto L141;
        long r132 = r28.b;
    L143:
        if (r132 == 0) goto L145;
    L153:
        r111.put("audience_time", String.valueOf(r132));
        if (r10.modType() != PkBaseDataContext.PKModType.Vote) goto L167;
        r111.put("invite_mode", "vote");
        aa r29 = r10.getVoteSetting();
        if (r29 == null) goto L158;
        String r30 = r29.getVoteDes();
    L159:
        if (r30 == null) goto L167;
        aa r32 = r10.getVoteSetting();
        if (r32 == null) goto L164;
        String r33 = r32.getVoteDes();
        if (r33 == null) goto L164;
    L165:
        r111.put(FileUtils.PICTURE_THEME, r33);
    L164:
        r33 = "";
        goto L165
    L158:
        r30 = null;
    L167:
        if (r10.isInCompetition() == false) goto L170;
        r111.put("invite_mode", "compete");
    L170:
        if (r10.isCustomizePkPlay() == false) goto L173;
        r111.put("invite_mode", "customize_pk");
        r111.put("customize_pk_type", String.valueOf(r10.getCustomizePlayType()));
        r111.put("membership_exchange_rate", String.valueOf(a0.a(r10.getBattleSettings())));
    L173:
        if (r10.modType() != PkBaseDataContext.PKModType.BreakThrough) goto L176;
        r111.put("invite_mode", "cooperation");
        b(r111, r10);
    L176:
        if (r10.modType() != PkBaseDataContext.PKModType.SeasonRank) goto L179;
        r111.put("invite_mode", "season_rank");
    L179:
        if (r10.modType() != PkBaseDataContext.PKModType.CloudCollaborate) goto L189;
        r111.put("invite_mode", "link_screen");
        IBaseBattleSetting r34 = r10.getBattleSettings();
        if (r34 == null) goto L186;
        h3 r35 = r34.getTitleConfig();
        if (r35 == null) goto L186;
        String r36 = r35.getContent();
        if (r36 == null) goto L186;
    L187:
        r111.put("playmode_name", r36);
    L186:
        r36 = "";
    L189:
        if (r10.getBattleSettings() == null) goto L197;
        IBaseBattleSetting r37 = r10.getBattleSettings();
        if (r37 == null) goto L196;
        String r38 = String.valueOf(r37.getDuration());
        if (r38 == null) goto L196;
        r4 = r38;
    L196:
        r111.put("pk_time", r4);
        goto L197
    L145:
        if (o() == null) goto L153;
        if (q.b() != true) goto L153;
        i97.a r39 = i97.a.a;
        long r133 = System.currentTimeMillis();
        if (o() == null) goto L151;
        long r134 = q.c();
    L152:
        r132 = (r133 - r134) / ((long) WebcastRedirectException.UNKNOWN);
        goto L153
    L151:
        r134 = 0;
    L141:
        r132 = 0;
        goto L143
    L133:
        if (q.b() != true) goto L135;
    L197:
        IPKLinkBizDataService r40 = this.c;
        if (r40 == null) goto L200;
        IBattleRivalTag.a r42 = IBattleRivalTag.Companion;
        ArrayList<IBattleRivalTag> r43 = r40.getPkBattleRivalTagsInfo();
        r42.getClass();
        IBattleRivalTag.a.a(r43, r111);
    L200:
        c(r111);
        CharSequence r44 = (CharSequence) r111.get("end_type");
        if (r44 != null) goto L203;
    L204:
        r13 = true;
    L205:
        if (r13 == false) goto L207;
        r111.put("end_type", "disconnection");
    L207:
        if (r19 == false) goto L209;
        r111.put("end_reason", "active");
    L209:
        n r45 = new n();
        Map<String, String> r46 = r45.a;
        Intrinsics.checkNotNullParameter(r46, "map");
        Intrinsics.checkNotNullParameter(r111, "map");
        r46.putAll(r111);
        if (r10 == null) goto L212;
        Map<String, String> r47 = r10.getServerEventTrackingInfo();
        Intrinsics.checkNotNullParameter(r47, "map");
        r46.putAll(r47);
    L212:
        m r48 = new m();
        com.bytedance.android.livesdk.revenue.log.h r49 = vh6.c.b(kr2.a.class).be();
        Intrinsics.checkNotNullParameter(r49, "linkInfoLog");
        r49.e(r3);
        r49.f(r7);
        r49.c(r14);
        if (r19 == false) goto L215;
        String r50 = "in_advance";
    L216:
        Intrinsics.checkNotNullParameter(r50, "endType");
        r49.d(r50);
        if (r19 == false) goto L223;
        i97.a r52 = i97.a.a;
        long r53 = System.currentTimeMillis();
        if (r10 == null) goto L221;
        long r135 = r10.getPkStartTimeMs();
    L222:
        String r54 = String.valueOf((r53 - r135) / ((long) WebcastRedirectException.UNKNOWN));
    L228:
        Intrinsics.checkNotNullParameter(r54, "connectionTime");
        r49.b(r54);
        ((ArrayList) r48.a).add(r49.a);
        LinkCrossRoomDataHolder r55 = g();
        if (r55 == null) goto L231;
        r55.m(r48);
    L231:
        r48.b(LogCommon.ROOM);
        ((ArrayList) r45.b).addAll(r48.a);
        cy0.e.a.getClass();
        j r56 = cy0.e.a.a;
        com.bytedance.android.scope.m.e.getClass();
        Object r57 = com.bytedance.android.scope.m.b(r56).a(Reflection.getOrCreateKotlinClass(mz0.i.class));
        Intrinsics.checkNotNull(r57);
        ((mz0.i) ((f80.a) r57)).w3("livesdk_pk_end", r45.a, r45.b);
        Object r58 = com.bytedance.android.scope.m.b(r56).b(er2.b.class);
        Intrinsics.checkNotNull(r58);
        iq2.b r59 = ((com.bytedance.live.kmp.core.c) r58).getChorusService();
        if (r19 == false) goto L252;
        if (r59 != null) goto L235;
        return;
    L235:
        if (r59.e() == true) goto L237;
        return;
    L237:
        if (r59.c() == null) goto L248;
        com.bytedance.android.live.liveinteract.model.a r60 = r59.c();
        if (r60 == null) goto L241;
        long r62 = r60.getStartTime();
    L243:
        if (r62 <= 0) goto L248;
        long r63 = com.bytedance.live.kmp.util.e.b() / ((long) WebcastRedirectException.UNKNOWN);
        com.bytedance.android.live.liveinteract.model.a r64 = r59.c();
        if (r64 == null) goto L247;
        r131 = r64.getStartTime();
    L247:
        r131 = r63 - r131;
        goto L248
    L241:
        r62 = 0;
    L248:
        r(true, r131);
        return;
    L252:
        return;
    L221:
        r135 = 0;
        goto L222
    L223:
        w31.c r65 = n();
        if (r65 == null) goto L226;
        Integer r66 = Integer.valueOf(r65.a());
    L227:
        r54 = String.valueOf(r66);
        goto L228
    L226:
        r66 = null;
        goto L227
    L215:
        r50 = "time_out";
        goto L216
    L203:
        if (r44.length() != 0) goto L205;
    L119:
        r24 = DataType.FALSE;
        goto L120
    L111:
        r130 = null;
        goto L112
    L105:
        if (r127.q() != true) goto L107;
        r128 = DataType.TRUE;
        goto L108
    L101:
        r126 = DataType.FALSE;
        goto L102
    L97:
        r124 = "off";
    L93:
        r123 = 0;
        goto L94
    L84:
        r119 = null;
    L80:
        r117 = 0;
        goto L81
    L71:
        r113 = null;
        goto L72
    L56:
        r17 = 0;
    L52:
        if (r19 == false) goto L53;
        return;
    L44:
        if (r12.intValue() != 11) goto L46;
        return;
    L40:
        r12 = null;
        goto L41
    L36:
        r9 = null;
        goto L37
    L250:
        return;
    L30:
        r7 = "";
        goto L32
    L23:
        r3 = null;
        goto L24
    L8:
        if (r1.e() != true) goto L20;
        IRoom r67 = this.a;
        if (r67 == null) goto L15;
        IBaseUser r68 = r67.getOwnerKt();
        if (r68 == null) goto L15;
        r3 = r68.getIdString();
        if (r3 == null) goto L15;
    L16:
        w31.c r69 = n();
        if (r69 == null) goto L19;
        r7 = r69.c();
        goto L32
    L19:
        r7 = null;
    L15:
        r3 = "";
        goto L16
    }

    public final void s(String r23, p0 r24, String r25) {
        long r2 = 0;
        if (this.e == false) goto L295;
        w31.c r4 = n();
        String r7 = "";
        if (r4 != null) goto L7;
    L19:
        w31.c r5 = n();
        if (r5 == null) goto L22;
        String r6 = r5.c();
    L23:
        IRoom r8 = this.a;
        if (r8 == null) goto L29;
        IBaseUser r9 = r8.getOwnerKt();
        if (r9 == null) goto L29;
        String r10 = r9.getIdString();
        if (r10 == null) goto L29;
    L30:
        LinkedHashMap r12 = new LinkedHashMap();
        w31.c r13 = n();
        if (r13 == null) goto L33;
        int r14 = r13.a();
    L35:
        if (r14 > 0) goto L38;
        KmpEnv r15 = KmpEnv.a;
        if (KmpEnv.a() == true) goto L38;
    L46:
        String r16 = "";
    L47:
        com.bytedance.android.live.revlink.impl.multianchor.dialog.linkopt.e r17 = h();
        if (r17 == null) goto L51;
        String r18 = r17.c;
        if (r18 == null) goto L51;
    L52:
        r12.put("source", r18);
        q r19 = o();
        if (r19 == null) goto L55;
        com.bytedance.android.live.revlink.impl.mergepk.pkdouble.c r110 = r19.g();
    L56:
        com.bytedance.android.live.revlink.impl.mergepk.pkbase.e r111 = l();
        if (r111 == null) goto L77;
        if (r110 == null) goto L77;
        if (r111.getBattleSettings() == null) goto L67;
        IBaseBattleSetting r112 = r111.getBattleSettings();
        if (r112 == null) goto L65;
        String r113 = String.valueOf(r112.getDuration());
        if (r113 == null) goto L65;
    L66:
        r12.put("pk_time", r113);
    L65:
        r113 = "";
    L67:
        d31.d r1 = p();
        if (r1 == null) goto L71;
        String r3 = r1.p(r110.getInviteType());
        if (r3 == null) goto L71;
    L72:
        r12.put("invitee_list", r3);
        if (r110.isPlayModeInviter() == false) goto L75;
        String r20 = "inviter";
    L76:
        r12.put("anchor_type", r20);
        goto L77
    L75:
        r20 = "invitee";
    L71:
        r3 = "";
    L77:
        r12.put("is_recommend_list", DataType.FALSE);
        w31.c r22 = n();
        if (r22 == null) goto L82;
        String r114 = r16;
        if (r22.q() != true) goto L83;
        r12.put("is_transform", DataType.TRUE);
    L84:
        r12.put("pk_anchor_cnt", "2");
        r12.put("connection_anchor_cnt", "2");
        r12.put("anchor_connect_status", "2");
        w31.c r26 = n();
        if (r26 == null) goto L87;
        IPKLinkBizDataService r27 = r26.g();
    L89:
        if (r27 == null) goto L97;
        w31.c r28 = n();
        if (r28 == null) goto L97;
        IPKLinkBizDataService r29 = r28.g();
        if (r29 == null) goto L97;
        long r115 = r2;
        if (r29.getSelfHasAudienceBeforePk() != true) goto L98;
        r12.put("from_room_status", "audience_connection");
    L105:
        r12.put("pk_description", "routine");
        if (i() == null) goto L113;
        com.bytedance.android.live.revlink.impl.service.internal.a r30 = i();
        if (r30 == null) goto L111;
        String r32 = String.valueOf(r30.Wp());
        if (r32 == null) goto L111;
    L112:
        r12.put("audience_num", r32);
    L111:
        r32 = "";
    L113:
        r12.put("room_status", r23);
        d31.d r33 = p();
        if (r33 == null) goto L116;
        String r34 = r33.c();
    L117:
        r12.put("connection_type", r34);
        r12.put("connection_sub_type", "");
        r12.put("invitee_connection_status", "pk");
        r12.put("npk_link_type", "single");
        r12.put("anchor_connection_type", "invite");
        r12.put("invite_mode", "routine_pk");
        if (r111 != null) goto L120;
    L129:
        x11.a r116 = this.f;
        if (r116 == null) goto L132;
        y11.d r117 = r116.getPkService();
    L133:
        if (r117 == null) goto L135;
        String r118 = r117.getInviteMode();
    L136:
        if (r118 == null) goto L143;
        String r210 = r10;
        if (r118.length() <= 0) goto L140;
        boolean r119 = true;
    L141:
        if (r119 != true) goto L145;
        r12.put("invite_mode", r118);
    L145:
        if (j() == null) goto L156;
        com.bytedance.android.live.revlink.impl.pk.service.a r35 = j();
        if (r35 == null) goto L149;
        h0 r36 = r35.d();
    L150:
        if (r36 == null) goto L156;
        com.bytedance.android.live.revlink.impl.pk.service.a r37 = j();
        if (r37 == null) goto L156;
        h0 r38 = r37.d();
        if (r38 == null) goto L156;
        r38.a(r12);
        goto L156
    L149:
        r36 = null;
    L156:
        IPKLinkBizDataService r39 = this.c;
        if (r39 == null) goto L159;
        IBattleRivalTag.a r120 = IBattleRivalTag.Companion;
        ArrayList<IBattleRivalTag> r40 = r39.getPkBattleRivalTagsInfo();
        r120.getClass();
        IBattleRivalTag.a.a(r40, r12);
    L159:
        if (r117 == null) goto L161;
        String r42 = r117.D();
    L162:
        if (r42 != null) goto L164;
    L170:
        if (r117 == null) goto L172;
        String r43 = r117.getTheme();
    L173:
        if (r43 != null) goto L175;
    L181:
        a(r12);
        w31.c r44 = n();
        if (r44 == null) goto L187;
        IPKLinkBizDataService r45 = r44.g();
        if (r45 == null) goto L187;
        String r46 = r45.getFlexActivityId();
        if (r46 == null) goto L187;
    L189:
        if (r46.length() <= 0) goto L191;
        boolean r47 = true;
    L193:
        if (r47 == false) goto L203;
        r12.put("pk_activity_type", r46);
        r12.put("invite_mode", "activity_pk");
        w31.c r48 = n();
        if (r48 == null) goto L203;
        IPKLinkBizDataService r49 = r48.g();
        if (r49 == null) goto L203;
        IPKLinkBizDataService.d r50 = r49.getLinkTypeParams();
        if (r50 == null) goto L203;
        if (r50.a != 3) goto L203;
        r12.put("source", "");
    L203:
        r12.put("is_random_match", DataType.FALSE);
        w31.c r52 = n();
        if (r52 == null) goto L206;
        IPKLinkBizDataService r53 = r52.g();
    L207:
        if (r53 == null) goto L241;
        w31.c r54 = n();
        if (r54 == null) goto L217;
        IPKLinkBizDataService r55 = r54.g();
        if (r55 == null) goto L217;
        IPKLinkBizDataService.d r56 = r55.getLinkTypeParams();
        if (r56 == null) goto L217;
        if (r56.a != 1) goto L217;
        r12.put("anchor_connection_type", "");
    L217:
        w31.c r57 = n();
        if (r57 == null) goto L224;
        IPKLinkBizDataService r58 = r57.g();
        if (r58 == null) goto L224;
        if (r58.getIsRandomReMatch() != true) goto L224;
        r12.put("is_rematch", DataType.TRUE);
    L224:
        w31.c r59 = n();
        if (r59 == null) goto L232;
        IPKLinkBizDataService r60 = r59.g();
        if (r60 == null) goto L232;
        IPKLinkBizDataService.d r62 = r60.getLinkTypeParams();
        if (r62 == null) goto L232;
        if (r62.b != 102) goto L232;
    L240:
        r12.put("is_random_match", DataType.TRUE);
    L232:
        w31.c r63 = n();
        if (r63 == null) goto L241;
        IPKLinkBizDataService r64 = r63.g();
        if (r64 == null) goto L241;
        IPKLinkBizDataService.d r65 = r64.getLinkTypeParams();
        if (r65 == null) goto L241;
        if (r65.b == 101) goto L240;
    L241:
        w31.c r66 = n();
        if (r66 != null) goto L244;
    L246:
        Object r67 = DataType.FALSE;
    L247:
        r12.put("is_manager", r67);
        com.bytedance.android.live.revlink.impl.mergepk.pkbase.e r68 = l();
        if (r68 != null) goto L250;
    L252:
        if (r68 != null) goto L254;
    L261:
        q r69 = o();
        if (r69 == null) goto L281;
        com.bytedance.android.live.revlink.impl.mergepk.pkbase.e r70 = r69.d();
        if (r70 == null) goto L270;
        IBattleConfigSetting r72 = r70.getConfigSetting();
        if (r72 == null) goto L270;
        if (r72.getActivityMode() != IBattleConfigSetting.BattleActivityMode.ActivityMode_Season.ordinal()) goto L270;
        boolean r73 = true;
    L272:
        if (r73 != true) goto L281;
        com.bytedance.android.live.revlink.impl.multianchor.dialog.linkopt.e r74 = h();
        if (r74 == null) goto L279;
        String r75 = r74.d;
        if (r75 == null) goto L279;
        r7 = r75;
    L279:
        r12.put("pk_activity_type", r7);
    L270:
        r73 = false;
    L281:
        if (r110 != null) goto L283;
    L285:
        r12.put("if_strategy_invite", DataType.FALSE);
    L286:
        if (r25 == null) goto L290;
        Map<String, String> r76 = h.a(r25);
        if (r76 == null) goto L290;
        r12.putAll(r76);
    L290:
        n r77 = new n();
        o r78 = new o(r77.a);
        r78.b(r12);
        e21.c.e(r78, r24);
        m r79 = new m();
        i r80 = vh6.c.b(kr2.a.class).ud();
        Intrinsics.checkNotNullParameter(r80, "pageSourceLog");
        Intrinsics.checkNotNullParameter("live_detail", "page");
        r80.c("live_detail");
        Intrinsics.checkNotNullParameter("other", "type");
        r80.d("other");
        Intrinsics.checkNotNullParameter("live", "belong");
        r80.a("live");
        ((ArrayList) r79.a).add(r80.a);
        com.bytedance.android.livesdk.revenue.log.h r82 = vh6.c.b(kr2.a.class).be();
        Intrinsics.checkNotNullParameter(r82, "linkInfoLog");
        r82.e(r6);
        r82.f(r210);
        r82.c(r115);
        String r121 = r114;
        Intrinsics.checkNotNullParameter(r121, "type");
        r82.i(r121);
        r82.g();
        ((ArrayList) r79.a).add(r82.a);
        LinkCrossRoomDataHolder r83 = g();
        if (r83 == null) goto L293;
        r83.m(r79);
    L293:
        r79.b(LogCommon.ROOM);
        ((ArrayList) r77.b).addAll(r79.a);
        cy0.e.a.getClass();
        j r84 = cy0.e.a.a;
        com.bytedance.android.scope.m.e.getClass();
        Object r85 = com.bytedance.android.scope.m.b(r84).a(Reflection.getOrCreateKotlinClass(mz0.i.class));
        Intrinsics.checkNotNull(r85);
        ((mz0.i) ((f80.a) r85)).w3("livesdk_connection_success", r77.a, r77.b);
        return;
    L283:
        if (r110.getInviteType() != 13) goto L285;
        r12.put("if_strategy_invite", DataType.TRUE);
        goto L286
    L254:
        if (r68.isInSpecifyGiftPk() == false) goto L261;
        r12.put("invite_mode", "focus_gift");
        IBattleConfigSetting r86 = r68.getConfigSetting();
        if (r86 == null) goto L258;
        h9 r122 = r86.getSpecifyGiftConfig();
    L259:
        if (r122 == null) goto L261;
        int r87 = c0.a;
        c0.a(r86.getSpecifyGiftConfig(), r12);
        goto L261
    L258:
        r122 = null;
        goto L259
    L250:
        if (r68.isInCompetition() == false) goto L252;
        r12.put("invite_mode", "compete");
        goto L252
    L244:
        if (r66.e() != true) goto L246;
        r67 = DataType.TRUE;
        goto L247
    L206:
        r53 = null;
        goto L207
    L191:
        r47 = false;
    L187:
        r46 = "";
        goto L189
    L175:
        if (r43.length() <= 0) goto L177;
        boolean r123 = true;
    L179:
        if (r123 != true) goto L181;
        r12.put(FileUtils.PICTURE_THEME, r43);
        goto L181
    L177:
        r123 = false;
        goto L179
    L172:
        r43 = null;
        goto L173
    L164:
        if (r42.length() <= 0) goto L166;
        boolean r124 = true;
    L168:
        if (r124 != true) goto L170;
        r12.put("transform_reason", r42);
        goto L170
    L166:
        r124 = false;
        goto L168
    L161:
        r42 = null;
        goto L162
    L140:
        r119 = false;
        goto L141
    L143:
        r210 = r10;
        goto L145
    L135:
        r118 = null;
        goto L136
    L132:
        r117 = null;
        goto L133
    L120:
        if (r111.modType() != PkBaseDataContext.PKModType.Vote) goto L129;
        r12.put("invite_mode", "vote");
        if (r111.getVoteSetting() == null) goto L129;
        aa r125 = r111.getVoteSetting();
        if (r125 == null) goto L127;
        String r126 = r125.getVoteDes();
        if (r126 == null) goto L127;
    L128:
        r12.put(FileUtils.PICTURE_THEME, r126);
    L127:
        r126 = "";
        goto L128
    L116:
        r34 = "";
    L98:
        w31.c r88 = n();
        if (r88 != null) goto L101;
    L103:
        String r89 = "live";
    L104:
        r12.put("from_room_status", r89);
        goto L105
    L101:
        if (r88.q() != true) goto L103;
        r89 = "connection";
    L97:
        r115 = r2;
        goto L98
    L87:
        r27 = null;
    L83:
        r12.put("is_transform", DataType.FALSE);
        goto L84
    L82:
        r114 = r16;
        goto L83
    L55:
        r110 = null;
    L51:
        r18 = "";
    L38:
        LinkCrossRoomDataHolder r127 = this.b;
        if (r127 == null) goto L46;
        if (r127.i() != 0) goto L46;
        LinkCrossRoomDataHolder r128 = g();
        if (r128 == null) goto L45;
        r2 = r128.f();
    L45:
        r16 = "pk";
        goto L47
    L33:
        r14 = 0;
    L29:
        r10 = "";
        goto L30
    L22:
        r6 = null;
        goto L23
    L7:
        if (r4.e() != true) goto L19;
        IRoom r90 = this.a;
        if (r90 == null) goto L14;
        IBaseUser r92 = r90.getOwnerKt();
        if (r92 == null) goto L14;
        r6 = r92.getIdString();
        if (r6 == null) goto L14;
    L15:
        w31.c r93 = n();
        if (r93 == null) goto L18;
        r10 = r93.c();
        goto L30
    L18:
        r10 = null;
    L14:
        r6 = "";
        goto L15
    }

    public e(com.bytedance.android.live.revlink.impl.global.c r1, boolean r2, IRoom r3, x11.a r4) {
        this.d = r1;
        this.e = r2;
        this.f = r4;
        this.b = g();
        this.a = r3;
        if (r1 == null) goto L5;
        IPKLinkBizDataService r5 = r1.mk();
    L6:
        this.c = r5;
        return;
    L5:
        r5 = null;
        goto L6
    }

    public final void w(PkBaseDataContext r49, com.bytedance.android.live.revlink.impl.mergepk.pkdouble.c r50, boolean r52, boolean r53) {
        q11.b.d r2 = q11.b.d.b;
        String r12 = "cooperation";
        String r13 = "activity_pk";
        String r25 = "invitee_list";
        String r0 = "customize_pk";
        String r28 = "pve";
        String r4 = "routine_pk";
        long r33 = 0;
        String r36 = "compete";
        String r39 = null;
        if (this.e == false) goto L307;
        LinkCrossRoomDataHolder r3 = g();
        if (r3 != null) goto L7;
    L9:
        LinkedHashMap r5 = new LinkedHashMap();
        com.bytedance.android.live.revlink.impl.pk.service.a r42 = j();
        if (r42 == null) goto L12;
        h0 r43 = r42.d();
    L13:
        if (r43 == null) goto L19;
        com.bytedance.android.live.revlink.impl.pk.service.a r44 = j();
        if (r44 == null) goto L19;
        String r45 = "";
        h0 r9 = r44.d();
        if (r9 == null) goto L20;
        r9.a(r5);
        Unit r10 = Unit.INSTANCE;
    L20:
        if (r49 == null) goto L31;
        IBaseBattleSetting r14 = r49.getBattleSettings();
        if (r14 == null) goto L31;
        String r46 = "pk_anchor_cnt";
        if (r14.getInviteType() != ILinkMicBattleInviteMessage.BattleInviteType.BattleInviteType_Normal_Activity.ordinal()) goto L32;
        r5.put("invite_mode", "activity_pk");
        IBaseBattleSetting r15 = r49.getBattleSettings();
        if (r15 == null) goto L29;
        String r16 = String.valueOf(r15.getDuration());
        if (r16 == null) goto L29;
    L30:
        r5.put("pk_time", r16);
    L33:
        if (r49 != null) goto L35;
    L39:
        if (r49 != null) goto L41;
    L50:
        if (r49 != null) goto L52;
    L78:
        d31.d r17 = p();
        if (r17 == null) goto L82;
        String r18 = r17.a();
        if (r18 == null) goto L82;
    L83:
        r5.put("anchor_connect_status", r18);
        d31.d r19 = p();
        if (r19 == null) goto L86;
        String r20 = r19.s();
    L87:
        r5.put("room_status", r20);
        w31.c r22 = n();
        if (r22 == null) goto L94;
        IPKLinkBizDataService r23 = r22.g();
        if (r23 == null) goto L94;
        boolean r110 = true;
        if (r23.getSelfHasAudienceBeforePk() != true) goto L95;
        r5.put("from_room_status", "audience_connection");
    L102:
        w31.c r24 = n();
        if (r24 == null) goto L109;
        IPKLinkBizDataService r26 = r24.g();
        if (r26 == null) goto L109;
        if (r26.getIsRandomReMatch() != true) goto L109;
        r5.put("source", "restart");
    L115:
        String r111 = "2";
        String r27 = r46;
        r5.put(r27, r111);
        if (p() == null) goto L118;
        Integer r40 = Integer.valueOf(n41.a.b());
    L119:
        r5.put("audience_connect_cnt", String.valueOf(r40));
        a(r5);
        if (r49 != null) goto L122;
    L124:
        r36 = r36;
    L125:
        if (r50 == null) goto L136;
        if (r49 == null) goto L136;
        String r6 = "is_oncemore";
        if (r49.isOnceMoreBattle() == false) goto L130;
        String r112 = DataType.TRUE;
    L131:
        r5.put(r6, r112);
        if (r50.isPlayModeInviter() == false) goto L134;
        String r113 = "inviter";
    L135:
        String r7 = "anchor_type";
        r5.put(r7, r113);
        r5.putAll(r49.getCommonLogParams());
    L137:
        if (r49 != null) goto L139;
    L141:
        String r1 = "customize_pk_type";
        String r114 = "membership_exchange_rate";
    L142:
        r5.put(r27, r111);
        d31.d r115 = p();
        if (r115 == null) goto L145;
        r115.r(r5);
        Unit r116 = Unit.INSTANCE;
    L145:
        String r47 = "connection_sub_type";
        String r29 = r6;
        String r48 = r45;
        r5.put(r47, r48);
        if (r53 == false) goto L158;
        w31.c r30 = n();
        if (r30 == null) goto L150;
        String r32 = r30.m();
    L152:
        if (r32.length() <= 0) goto L154;
        boolean r410 = true;
    L155:
        if (r410 == false) goto L158;
        r5.put("transform_reason", r32);
        goto L158
    L154:
        r410 = false;
        goto L155
    L150:
        r32 = r48;
    L158:
        if (r49 != null) goto L160;
    L162:
        r28 = r28;
        String r117 = "pk";
        r5.put("room_status", r117);
    L163:
        if (r49 == null) goto L165;
        IBaseBattleSetting r210 = r49.getBattleSettings();
    L166:
        if (r210 == null) goto L175;
        IBaseBattleSetting r211 = r49.getBattleSettings();
        if (r211 == null) goto L173;
        String r212 = String.valueOf(r211.getDuration());
        if (r212 == null) goto L173;
        String r8 = r212;
    L174:
        r5.put("pk_time", r8);
    L176:
        d31.d r34 = p();
        String r35 = r27;
        e r118 = this;
        String r213 = r117;
        String r119 = "linkInfoLog";
        if (r34 == null) goto L186;
        LinkCrossRoomDataHolder r37 = r118.b;
        if (r37 == null) goto L181;
        int r38 = r37.f();
    L182:
        String r54 = r34.p(r38);
        if (r54 == null) goto L186;
    L187:
        r5.put(r25, r54);
        w31.c r55 = n();
        if (r55 == null) goto L196;
        r25 = r25;
        if (r55.q() != true) goto L197;
        d31.d r56 = p();
        if (r56 == null) goto L194;
        String r57 = r56.o();
    L195:
        r5.put("is_manager", r57);
    L204:
        r5.put("is_random_match", DataType.FALSE);
        w31.c r58 = n();
        if (r58 == null) goto L207;
        IPKLinkBizDataService r59 = r58.g();
    L208:
        if (r59 == null) goto L236;
        w31.c r60 = n();
        if (r60 == null) goto L218;
        IPKLinkBizDataService r62 = r60.g();
        if (r62 == null) goto L218;
        IPKLinkBizDataService.d r63 = r62.getLinkTypeParams();
        if (r63 == null) goto L218;
        String r310 = "source";
        if (r63.b != 102) goto L219;
    L227:
        String r120 = DataType.TRUE;
        r5.put("is_random_match", r120);
    L229:
        w31.c r64 = n();
        if (r64 == null) goto L237;
        IPKLinkBizDataService r65 = r64.g();
        if (r65 == null) goto L237;
        String r311 = r114;
        if (r65.getLinkFromMultiInvite() != true) goto L238;
        r5.put("is_n_invite", r120);
    L238:
        com.bytedance.android.live.revlink.impl.mergepk.pkbase.e r66 = l();
        if (r66 != null) goto L241;
    L251:
        com.bytedance.android.live.revlink.impl.mergepk.pkbase.e r67 = l();
        if (r67 != null) goto L254;
    L275:
        LinkCrossRoomDataHolder r68 = r118.b;
        if (r68 != null) goto L278;
    L282:
        r5.put("if_strategy_invite", DataType.FALSE);
    L283:
        com.bytedance.android.live.revlink.impl.multianchor.dialog.linkopt.e r69 = h();
        if (r69 == null) goto L289;
        String r70 = r69.d;
        if (r70 == null) goto L289;
    L290:
        r5.put(r24, r70);
        n r72 = new n();
        String r214 = r120;
        o r121 = new o(r72.a);
        r121.b(r5);
        if (r49 == null) goto L293;
        r121.b(r49.getServerEventTrackingInfo());
        e21.c.e(r121, r49.getServerBattleAttachedInfo());
    L293:
        m r73 = new m();
        i r122 = vh6.c.b(kr2.a.class).ud();
        String r123 = "pageSourceLog";
        Intrinsics.checkNotNullParameter(r122, r123);
        String r215 = DataType.FALSE;
        String r411 = r1;
        String r74 = "belong";
        Intrinsics.checkNotNullParameter("live_take", r74);
        r122.a("live_take");
        String r75 = "live_detail";
        String r124 = "page";
        Intrinsics.checkNotNullParameter(r75, r124);
        r122.c(r75);
        String r216 = r7;
        ((ArrayList) r73.a).add(r122.a);
        com.bytedance.android.livesdk.revenue.log.h r76 = vh6.c.b(kr2.a.class).be();
        Intrinsics.checkNotNullParameter(r76, r119);
        w31.c r125 = n();
        if (r125 == null) goto L296;
        String r126 = r125.c();
    L297:
        r76.f(r126);
        IRoom r127 = r118.a;
        if (r127 == null) goto L302;
        IBaseUser r128 = r127.getOwnerKt();
        if (r128 == null) goto L302;
        String r129 = r128.getIdString();
    L303:
        r76.e(r129);
        ((ArrayList) r73.a).add(r76.a);
        LinkCrossRoomDataHolder r77 = g();
        if (r77 == null) goto L306;
        r77.m(r73);
        Unit r78 = Unit.INSTANCE;
    L306:
        r73.b(LogCommon.ROOM);
        ((ArrayList) r72.b).addAll(r73.a);
        cy0.e.a.getClass();
        j r79 = cy0.e.a.a;
        com.bytedance.android.scope.m.e.getClass();
        Object r80 = com.bytedance.android.scope.m.b(r79).a(Reflection.getOrCreateKotlinClass(mz0.i.class));
        Intrinsics.checkNotNull(r80);
        ((mz0.i) ((f80.a) r80)).w3("pk_start", r72.a, r72.b);
    L309:
        if (r118.e == true) goto L349;
        q11.b.d r217 = r2;
        if ((r217 instanceof q11.b.c) == false) goto L348;
        String r130 = r119;
        long r131 = 0;
        LinkCrossRoomDataHolder r82 = r118.b;
        if (r82 != null) goto L315;
    L317:
        LinkedHashMap r83 = new LinkedHashMap();
        if (r49 == null) goto L320;
        PkBaseDataContext.PKModType r84 = r49.modType();
    L322:
        if (r84 != PkBaseDataContext.PKModType.Vote) goto L331;
        r83.put("invite_mode", "vote");
        if (r49.getVoteSetting() == null) goto L331;
        aa r85 = r49.getVoteSetting();
        if (r85 == null) goto L329;
        String r86 = r85.getVoteDes();
        if (r86 == null) goto L329;
    L330:
        r83.put(FileUtils.PICTURE_THEME, r86);
    L329:
        r86 = r48;
    L331:
        r83.put("anchor_connect_status", r111);
        x11.a r87 = r118.f;
        if (r87 == null) goto L334;
        y11.d r88 = r87.getPkService();
    L335:
        if (r88 == null) goto L342;
        int r89 = r88.getInviteMode().length();
        String r412 = FileUtils.PICTURE_THEME;
        if (r89 <= 0) goto L339;
        boolean r90 = true;
    L340:
        if (r90 != true) goto L343;
        String r92 = r88.getInviteMode();
    L344:
        r83.put("invite_mode", r92);
        n r93 = new n();
        Map<String, String> r94 = r93.a;
        Intrinsics.checkNotNullParameter(r94, "map");
        Intrinsics.checkNotNullParameter(r83, "map");
        r94.putAll(r83);
        m r95 = new m();
        i r96 = vh6.c.b(kr2.a.class).ud();
        Intrinsics.checkNotNullParameter(r96, r123);
        Intrinsics.checkNotNullParameter("live_function", r74);
        r96.a("live_function");
        Intrinsics.checkNotNullParameter(r75, r124);
        r96.c(r75);
        ((ArrayList) r95.a).add(r96.a);
        com.bytedance.android.livesdk.revenue.log.h r97 = vh6.c.b(kr2.a.class).be();
        String r98 = r130;
        Intrinsics.checkNotNullParameter(r97, r98);
        r97.c(r131);
        ((ArrayList) r95.a).add(r97.a);
        LinkCrossRoomDataHolder r99 = g();
        if (r99 == null) goto L347;
        r99.m(r95);
        Unit r100 = Unit.INSTANCE;
    L347:
        r95.b(LogCommon.ROOM);
        ((ArrayList) r93.b).addAll(r95.a);
        cy0.e.a.getClass();
        j r101 = cy0.e.a.a;
        com.bytedance.android.scope.m.e.getClass();
        Object r102 = com.bytedance.android.scope.m.b(r101).a(Reflection.getOrCreateKotlinClass(mz0.i.class));
        Intrinsics.checkNotNull(r102);
        ((mz0.i) ((f80.a) r102)).w3("pk_transform", r93.a, r93.b);
    L351:
        if (r118.e == false) goto L640;
        q11.b.d r103 = r217;
        if ((r103 instanceof q11.b.a) == true) goto L641;
        if (r53 == true) goto L642;
        long r104 = 0;
        LinkCrossRoomDataHolder r105 = r118.b;
        if (r105 != null) goto L358;
    L360:
        LinkedHashMap r106 = new LinkedHashMap();
        w31.c r132 = n();
        if (r132 != null) goto L363;
    L365:
        String r133 = "invitee";
    L366:
        r106.put(r216, r133);
        q r134 = o();
        if (r134 == null) goto L369;
        PkCustomizePlayDataContext r135 = r134.f();
    L370:
        if (r135 == null) goto L374;
        IBattleConfigSetting r136 = r135.getBattleConfigSetting();
        if (r136 == null) goto L374;
        v2 r137 = r136.getSelfSettingRate();
    L375:
        if (r137 == null) goto L428;
        if (r135 == null) goto L382;
        IBattleConfigSetting r138 = r135.getBattleConfigSetting();
        if (r138 == null) goto L382;
        v2 r139 = r138.getSelfSettingRate();
        if (r139 == null) goto L382;
        int r140 = (int) r139.getPkValueType();
    L383:
        if (r140 > 0) goto L385;
    L429:
        if (r135 != null) goto L431;
    L433:
        boolean r141 = false;
    L434:
        if (r141 == false) goto L436;
        String r142 = r214;
    L437:
        r106.put("is_customized_setting", r142);
        com.bytedance.android.live.revlink.impl.multianchor.dialog.linkopt.e r143 = h();
        if (r143 == null) goto L443;
        String r144 = r143.a;
        if (r144 == null) goto L443;
    L444:
        r106.put(r310, r144);
        r106.put(r35, r111);
        r106.put("connection_anchor_cnt", r111);
        String r145 = r215;
        r106.put("is_transform", r145);
        r106.put("pk_description", "routine");
        String r107 = r48;
        r106.put("pk_activity_type", r107);
        r106.put("anchor_connect_status", r111);
        if (r52 == false) goto L447;
        String r108 = r214;
    L448:
        r106.put(r29, r108);
        if (r49 == null) goto L455;
        IBaseBattleSetting r109 = r49.getBattleSettings();
        if (r109 == null) goto L455;
        if (r109.getInviteType() != ILinkMicBattleInviteMessage.BattleInviteType.BattleInviteType_Normal_Activity.ordinal()) goto L455;
        r106.put("pk_description", "activity");
        r106.put("pk_activity_type", "chinese_valentine");
        r106.put("invite_mode", r13);
    L456:
        LinkCrossRoomDataHolder r146 = r118.b;
        if (r146 == null) goto L459;
        Integer r147 = Integer.valueOf(r146.f());
    L460:
        r106.put("invite_type", String.valueOf(r147));
        if ((r103 instanceof q11.b.C0295b) == false) goto L463;
        String r148 = "connection";
    L464:
        r106.put("from_room_status", r148);
        if (r50 == null) goto L472;
        d31.d r149 = p();
        if (r149 == null) goto L470;
        String r150 = r149.p(r50.getInviteType());
        if (r150 == null) goto L470;
    L471:
        r106.put(r25, r150);
    L470:
        r150 = r107;
    L472:
        com.bytedance.android.live.revlink.impl.pk.service.a r151 = j();
        if (r151 == null) goto L475;
        h0 r152 = r151.d();
    L476:
        if (r152 == null) goto L485;
        com.bytedance.android.live.revlink.impl.pk.service.a r153 = j();
        if (r153 == null) goto L483;
        h0 r154 = r153.d();
        if (r154 == null) goto L483;
        String r155 = String.valueOf(r154.a);
        if (r155 == null) goto L483;
    L484:
        r106.put("pk_automatch_type", r155);
    L483:
        r155 = r107;
    L485:
        d31.d r156 = p();
        if (r156 == null) goto L488;
        r156.r(r106);
        Unit r157 = Unit.INSTANCE;
    L488:
        r106.put("invitee_connection_status", r213);
        r106.put("anchor_connection_type", "invite");
        r106.put("npk_link_type", "single");
        if (i() == null) goto L496;
        com.bytedance.android.live.revlink.impl.service.internal.a r158 = i();
        if (r158 == null) goto L494;
        String r159 = String.valueOf(r158.Wp());
        if (r159 == null) goto L494;
    L495:
        r106.put("audience_num", r159);
    L494:
        r159 = r107;
    L496:
        IPKLinkBizDataService r160 = r118.c;
        if (r160 == null) goto L499;
        IBattleRivalTag.a r161 = IBattleRivalTag.Companion;
        ArrayList<IBattleRivalTag> r162 = r160.getPkBattleRivalTagsInfo();
        r161.getClass();
        IBattleRivalTag.a.a(r162, r106);
    L499:
        d31.d r163 = p();
        if (r163 == null) goto L502;
        String r164 = r163.f();
    L503:
        r106.put("invite_mode", r164);
        if (r49 == null) goto L506;
        PkBaseDataContext.PKModType r165 = r49.modType();
    L507:
        PkBaseDataContext.PKModType r166 = PkBaseDataContext.PKModType.Vote;
        if (r165 != r166) goto L520;
        r106.put("invite_mode", "vote");
        if (r49 == null) goto L512;
        aa r167 = r49.getVoteSetting();
    L513:
        if (r167 == null) goto L520;
        aa r168 = r49.getVoteSetting();
        if (r168 == null) goto L518;
        String r169 = r168.getVoteDes();
        if (r169 == null) goto L518;
    L519:
        String r170 = r412;
        r106.put(r170, r169);
    L522:
        if (q(r140) == false) goto L524;
        r106.put("invite_mode", r0);
    L524:
        if (r49 != null) goto L526;
    L528:
        x11.a r171 = r118.f;
        if (r171 == null) goto L531;
        y11.d r172 = r171.getPkService();
    L532:
        if (r172 == null) goto L534;
        String r173 = r172.D();
    L535:
        if (r173 != null) goto L537;
    L543:
        if (r172 == null) goto L545;
        String r174 = r172.getTheme();
    L546:
        if (r174 != null) goto L548;
        boolean r175 = true;
    L555:
        a(r106);
        w31.c r176 = n();
        if (r176 != null) goto L558;
    L568:
        w31.c r177 = n();
        if (r177 == null) goto L571;
        String r178 = r177.c();
    L572:
        IRoom r179 = r118.a;
        if (r179 == null) goto L577;
        IBaseUser r180 = r179.getOwnerKt();
        if (r180 == null) goto L577;
        r39 = r180.getIdString();
    L577:
        String r181 = r39;
        d31.d r182 = p();
        if (r182 == null) goto L580;
        String r183 = r182.s();
    L581:
        r106.put("room_status", r183);
        if (r49 != null) goto L584;
        r104 = r104;
        r181 = r181;
        r178 = r178;
    L632:
        r106.put(r47, r107);
        n r184 = new n();
        Map<String, String> r185 = r184.a;
        Intrinsics.checkNotNullParameter(r185, "map");
        Intrinsics.checkNotNullParameter(r106, "map");
        r185.putAll(r106);
        m r186 = new m();
        com.bytedance.android.livesdk.revenue.log.h r187 = vh6.c.b(kr2.a.class).be();
        Intrinsics.checkNotNullParameter(r187, r98);
        r187.c(r104);
        r187.e(r178);
        r187.f(r181);
        Intrinsics.checkNotNullParameter("disconnect", "endType");
        r187.d("disconnect");
        i97.a r188 = i97.a.a;
        long r189 = System.currentTimeMillis();
        if (r49 == null) goto L635;
        r33 = r49.getStartPenaltyTimeMs();
    L635:
        String r190 = String.valueOf((r189 - r33) / ((long) WebcastRedirectException.UNKNOWN));
        Intrinsics.checkNotNullParameter(r190, "connectionTime");
        r187.b(r190);
        ((ArrayList) r186.a).add(r187.a);
        LinkCrossRoomDataHolder r191 = g();
        if (r191 == null) goto L638;
        r191.m(r186);
        Unit r192 = Unit.INSTANCE;
    L638:
        r186.b(LogCommon.ROOM);
        ((ArrayList) r184.b).addAll(r186.a);
        cy0.e.a.getClass();
        j r193 = cy0.e.a.a;
        com.bytedance.android.scope.m.e.getClass();
        Object r194 = com.bytedance.android.scope.m.b(r193).a(Reflection.getOrCreateKotlinClass(mz0.i.class));
        Intrinsics.checkNotNull(r194);
        ((mz0.i) ((f80.a) r194)).w3("punish_end", r184.a, r184.b);
        return;
    L584:
        if (o() == null) goto L592;
        int r195 = q.d;
        qr2.e r196 = n41.a.c();
        if (r196 == null) goto L588;
        boolean r197 = r196.d;
    L590:
        if (r197 != true) goto L592;
        r145 = r214;
        goto L592
    L588:
        r197 = false;
    L592:
        r106.put("is_with_audience", r145);
        if (o() == null) goto L597;
        int r198 = q.d;
        qr2.e r199 = n41.a.c();
        if (r199 == null) goto L597;
        long r1100 = r199.e;
    L599:
        if (r1100 != 0) goto L615;
        if (o() == null) goto L615;
        int r1101 = q.d;
        qr2.e r1102 = n41.a.c();
        if (r1102 == null) goto L605;
        boolean r1103 = r1102.d;
    L607:
        if (r1103 != true) goto L615;
        i97.a r1104 = i97.a.a;
        long r1105 = System.currentTimeMillis();
        if (o() == null) goto L611;
        long r1106 = q.c();
    L612:
        long r1107 = r1105 - r1106;
        r104 = r104;
        long r1108 = r1107 / ((long) WebcastRedirectException.UNKNOWN);
    L616:
        r106.put("audience_time", String.valueOf(r1108));
        if (r49.modType() != r166) goto L626;
        r106.put("invite_mode", "vote");
        if (r49.getVoteSetting() == null) goto L626;
        aa r200 = r49.getVoteSetting();
        if (r200 == null) goto L624;
        String r201 = r200.getVoteDes();
        if (r201 == null) goto L624;
    L625:
        r106.put(r170, r201);
    L624:
        r201 = r107;
    L626:
        IBattleConfigSetting r202 = r49.getConfigSetting();
        if (r202 == null) goto L632;
        if (r202.getModType() != PkBaseDataContext.PKModType.BreakThrough.getType()) goto L632;
        r106.put("room_status", r28);
        r106.put("invite_mode", r12);
        goto L632
    L611:
        r1106 = 0;
        goto L612
    L605:
        r1103 = false;
    L615:
        r1108 = r1100;
    L597:
        r1100 = 0;
        goto L599
    L580:
        r183 = r107;
        goto L581
    L571:
        r178 = null;
        goto L572
    L558:
        if (r176.e() != r175) goto L568;
        IRoom r203 = r118.a;
        if (r203 == null) goto L564;
        IBaseUser r204 = r203.getOwnerKt();
        if (r204 == null) goto L564;
        r178 = r204.getIdString();
    L565:
        w31.c r1109 = n();
        if (r1109 == null) goto L577;
        r39 = r1109.c();
    L564:
        r178 = null;
        goto L565
    L548:
        if (r174.length() <= 0) goto L550;
        boolean r1110 = true;
    L551:
        r175 = true;
        if (r1110 != true) goto L555;
        r106.put(r170, r174);
        goto L555
    L550:
        r1110 = false;
        goto L551
    L545:
        r174 = null;
        goto L546
    L537:
        if (r173.length() <= 0) goto L539;
        boolean r1111 = true;
    L541:
        if (r1111 != true) goto L543;
        r106.put("transform_reason", r173);
        goto L543
    L539:
        r1111 = false;
        goto L541
    L534:
        r173 = null;
        goto L535
    L531:
        r172 = null;
        goto L532
    L526:
        if (r49.isInCompetition() != true) goto L528;
        r106.put("invite_mode", r36);
    L518:
        r169 = r107;
        goto L519
    L512:
        r167 = null;
    L520:
        r170 = r412;
        goto L522
    L506:
        r165 = null;
        goto L507
    L502:
        r164 = r107;
        goto L503
    L475:
        r152 = null;
        goto L476
    L463:
        r148 = r213;
        goto L464
    L459:
        r147 = null;
    L455:
        r106.put("invite_mode", r4);
        goto L456
    L447:
        r108 = r145;
    L443:
        r144 = r48;
        goto L444
    L436:
        r142 = r215;
        goto L437
    L431:
        if (r135.getBackOperationType4Log() != 2) goto L433;
        r141 = true;
        goto L434
    L385:
        if (r140 >= 100) goto L429;
        w31.c r1112 = n();
        if (r1112 == null) goto L389;
        Integer r1113 = Integer.valueOf(r1112.a());
    L390:
        r106.put("pk_time", String.valueOf(r1113));
        r106.put(r411, String.valueOf(r140));
        IBattleConfigSetting r1114 = r135.getBattleConfigSetting();
        if (r1114 == null) goto L396;
        v2 r1115 = r1114.getSelfSettingRate();
        if (r1115 == null) goto L396;
        String r1116 = String.valueOf(r1115.getPkLikeRate());
        if (r1116 == null) goto L396;
    L397:
        r106.put("like_exchange_rate", r1116);
        IBattleConfigSetting r1117 = r135.getBattleConfigSetting();
        if (r1117 == null) goto L403;
        v2 r1118 = r1117.getSelfSettingRate();
        if (r1118 == null) goto L403;
        String r1119 = String.valueOf(r1118.getPkGiftRate());
        if (r1119 == null) goto L403;
    L404:
        r106.put("giftvalue_exchange_rate", r1119);
        IBattleConfigSetting r1120 = r135.getBattleConfigSetting();
        if (r1120 == null) goto L410;
        v2 r1121 = r1120.getSelfSettingRate();
        if (r1121 == null) goto L410;
        String r1122 = String.valueOf(r1121.getPkUVRate());
        if (r1122 == null) goto L410;
    L411:
        r106.put("giftuv_exchange_rate", r1122);
        IBattleConfigSetting r1123 = r135.getBattleConfigSetting();
        if (r1123 == null) goto L417;
        v2 r1124 = r1123.getSelfSettingRate();
        if (r1124 == null) goto L417;
        String r1125 = String.valueOf(r1124.getPkTicketRate());
        if (r1125 == null) goto L417;
    L418:
        r106.put("ticket_exchange_rate", r1125);
        IBattleConfigSetting r1126 = r135.getBattleConfigSetting();
        if (r1126 == null) goto L426;
        v2 r1127 = r1126.getSelfSettingRate();
        if (r1127 == null) goto L426;
        String r1128 = String.valueOf(r1127.getPkVIPRate());
        if (r1128 == null) goto L426;
    L427:
        r106.put(r311, r1128);
    L426:
        r1128 = r48;
    L417:
        r1125 = r48;
    L410:
        r1122 = r48;
    L403:
        r1119 = r48;
    L396:
        r1116 = r48;
        goto L397
    L389:
        r1113 = null;
    L382:
        r140 = 0;
        goto L383
    L428:
        r140 = 0;
    L374:
        r137 = null;
        goto L375
    L369:
        r135 = null;
        goto L370
    L363:
        if (r132.e() != true) goto L365;
        r133 = "inviter";
        goto L366
    L358:
        if (r105.i() != 0) goto L360;
        r104 = r118.b.f();
        goto L360
    L642:
        return;
    L641:
        return;
    L640:
        return;
    L343:
        r92 = r4;
        goto L344
    L339:
        r90 = false;
        goto L340
    L342:
        r412 = FileUtils.PICTURE_THEME;
        goto L343
    L334:
        r88 = null;
        goto L335
    L320:
        r84 = null;
        goto L322
    L315:
        if (r82.i() != 0) goto L317;
        r131 = r118.b.f();
        goto L317
    L348:
        r412 = FileUtils.PICTURE_THEME;
        r217 = r217;
        r98 = r119;
        goto L351
    L349:
        r412 = FileUtils.PICTURE_THEME;
        r98 = r119;
        r217 = r2;
    L302:
        r129 = null;
        goto L303
    L296:
        r126 = null;
    L289:
        r70 = r48;
        goto L290
    L278:
        if (r68.f() != 13) goto L282;
        if (r52 == true) goto L282;
        if (r53 == false) goto L282;
        r5.put("if_strategy_invite", r120);
        goto L283
    L254:
        if (r67.isInCloudCollaborate() != true) goto L275;
        r5.put("invite_mode", "link_screen");
        com.bytedance.android.live.revlink.impl.mergepk.pkbase.e r205 = l();
        if (r205 == null) goto L263;
        IBaseBattleSetting r206 = r205.getBattleSettings();
        if (r206 == null) goto L263;
        h3 r207 = r206.getTitleConfig();
        if (r207 == null) goto L263;
        String r208 = r207.getContent();
        if (r208 == null) goto L263;
    L264:
        r5.put("playmode_name", r208);
        com.bytedance.android.live.revlink.impl.mergepk.pkbase.e r209 = l();
        if (r209 == null) goto L273;
        IBattleConfigSetting r218 = r209.getConfigSetting();
        if (r218 == null) goto L273;
        v0 r219 = r218.getCloudCollaborateConfig();
        if (r219 == null) goto L273;
        if (r219.getStartLightningEffect() != true) goto L273;
        String r220 = r120;
    L274:
        r5.put("is_open_light_effect", r220);
    L273:
        r220 = DataType.FALSE;
    L263:
        r208 = r48;
        goto L264
    L241:
        if (r66.isInSpecifyGiftPk() != true) goto L251;
        r5.put("invite_mode", "focus_gift");
        com.bytedance.android.live.revlink.impl.mergepk.pkbase.e r221 = l();
        if (r221 == null) goto L245;
        IBattleConfigSetting r222 = r221.getConfigSetting();
    L246:
        if (r222 == null) goto L248;
        h9 r1129 = r222.getSpecifyGiftConfig();
    L249:
        if (r1129 == null) goto L251;
        int r1130 = c0.a;
        c0.a(r222.getSpecifyGiftConfig(), r5);
        goto L251
    L248:
        r1129 = null;
        goto L249
    L245:
        r222 = null;
    L237:
        r311 = r114;
    L219:
        w31.c r223 = n();
        if (r223 == null) goto L228;
        IPKLinkBizDataService r224 = r223.g();
        if (r224 == null) goto L228;
        IPKLinkBizDataService.d r225 = r224.getLinkTypeParams();
        if (r225 == null) goto L228;
        if (r225.b == 101) goto L227;
    L228:
        r120 = DataType.TRUE;
    L218:
        r310 = "source";
        goto L219
    L236:
        r310 = "source";
        r120 = DataType.TRUE;
        goto L237
    L207:
        r59 = null;
        goto L208
    L194:
        r57 = r48;
    L197:
        w31.c r226 = n();
        if (r226 != null) goto L200;
    L202:
        String r227 = DataType.FALSE;
    L203:
        r5.put("is_manager", r227);
        goto L204
    L200:
        if (r226.e() != true) goto L202;
        r227 = DataType.TRUE;
        goto L203
    L196:
        r25 = r25;
        goto L197
    L181:
        r38 = 0;
    L186:
        r54 = r48;
    L173:
        r8 = r48;
        goto L174
    L175:
        r28 = r28;
        goto L176
    L165:
        r210 = null;
        goto L166
    L160:
        if (r49.modType() != PkBaseDataContext.PKModType.BreakThrough) goto L162;
        r28 = r28;
        r5.put("room_status", r28);
        r117 = "pk";
        goto L163
    L139:
        if (r49.isCustomizePkPlay() == false) goto L141;
        r5.put("invite_mode", "customize_pk");
        r1 = "customize_pk_type";
        r5.put(r1, String.valueOf(r49.getCustomizePlayType()));
        r114 = "membership_exchange_rate";
        r5.put(r114, String.valueOf(a0.a(r49.getBattleSettings())));
        goto L142
    L134:
        r113 = "invitee";
        goto L135
    L130:
        r112 = DataType.FALSE;
    L136:
        r6 = "is_oncemore";
        r7 = "anchor_type";
        goto L137
    L122:
        if (r49.isInCompetition() == false) goto L124;
        r36 = r36;
        r5.put("invite_mode", r36);
        goto L125
    L118:
        r40 = null;
    L109:
        com.bytedance.android.live.revlink.impl.multianchor.dialog.linkopt.e r228 = h();
        if (r228 == null) goto L113;
        String r229 = r228.c;
        if (r229 == null) goto L113;
    L114:
        r5.put("source", r229);
    L113:
        r229 = r45;
    L95:
        w31.c r230 = n();
        if (r230 != null) goto L98;
    L100:
        String r231 = "live";
    L101:
        r5.put("from_room_status", r231);
        goto L102
    L98:
        if (r230.q() != r110) goto L100;
        r231 = "connection";
    L94:
        r110 = true;
        goto L95
    L86:
        r20 = r45;
    L82:
        r18 = r45;
        goto L83
    L52:
        if (r49.modType() != PkBaseDataContext.PKModType.BreakThrough) goto L78;
        r5.put("invite_mode", "cooperation");
        IBattleConfigSetting r232 = r49.getConfigSetting();
        if (r232 == null) goto L60;
        m3 r233 = r232.getBreakthroughConfig();
        if (r233 == null) goto L60;
        List r234 = r233.getStages();
        if (r234 == null) goto L60;
        int r235 = r234.size();
    L61:
        if (r235 <= 0) goto L78;
        IBattleConfigSetting r236 = r49.getConfigSetting();
        if (r236 == null) goto L67;
        m3 r237 = r236.getBreakthroughConfig();
        if (r237 == null) goto L67;
        List r238 = r237.getStages();
    L68:
        if (r238 == null) goto L70;
        int r1131 = r238.size();
    L71:
        if (r238 == null) goto L76;
        m3.b r239 = (m3.b) ListProtector.get(r238, r1131 - 1);
        if (r239 == null) goto L76;
        String r240 = String.valueOf(r239.getTargetScore());
        if (r240 == null) goto L76;
    L77:
        r5.put("pve_target_value", r240);
    L76:
        r240 = r45;
        goto L77
    L70:
        r1131 = 0;
    L67:
        r238 = null;
    L60:
        r235 = 0;
        goto L61
    L41:
        if (r49.modType() != PkBaseDataContext.PKModType.Vote) goto L50;
        r5.put("invite_mode", "vote");
        if (r49.getVoteSetting() == null) goto L50;
        aa r241 = r49.getVoteSetting();
        if (r241 == null) goto L48;
        String r242 = r241.getVoteDes();
        if (r242 == null) goto L48;
    L49:
        r5.put(FileUtils.PICTURE_THEME, r242);
    L48:
        r242 = r45;
        goto L49
    L35:
        if (r49.isCustomizePkPlay() == false) goto L37;
    L38:
        r5.put("invite_mode", "customize_pk");
        goto L39
    L37:
        if (r49.isCustomPKPlay(false) == false) goto L39;
    L29:
        r16 = r45;
    L32:
        r5.put("invite_mode", "routine_pk");
    L31:
        r46 = "pk_anchor_cnt";
    L19:
        r45 = "";
        goto L20
    L12:
        r43 = null;
        goto L13
    L7:
        if (r3.c() != 0) goto L9;
        return;
    L307:
        r48 = "";
        r12 = "cooperation";
        r75 = "live_detail";
        r119 = "linkInfoLog";
        r213 = "pk";
        r47 = "connection_sub_type";
        r411 = "customize_pk_type";
        r29 = "is_oncemore";
        r214 = DataType.TRUE;
        r0 = "customize_pk";
        r13 = "activity_pk";
        r124 = "page";
        r74 = "belong";
        r311 = "membership_exchange_rate";
        r216 = "anchor_type";
        r118 = this;
        r4 = "routine_pk";
        r35 = "pk_anchor_cnt";
        r111 = "2";
        r310 = "source";
        r123 = "pageSourceLog";
        r215 = DataType.FALSE;
        goto L309
    }

    public final Map u(int r15, IBattleConfigSetting r16, long r17, long r19, c21.b r22) {
        com.bytedance.android.live.revlink.impl.multianchor.dialog.linkopt.e r3 = h();
        boolean r4 = false;
        c21.f r6 = null;
        if (r3 == null) goto L14;
        String r5 = r3.c;
        if (r5 == null) goto L14;
        if (r5.length() != 0) goto L9;
        boolean r7 = true;
    L10:
        if (r7 != true) goto L14;
        com.bytedance.android.live.revlink.impl.multianchor.dialog.linkopt.e r8 = h();
        if (r8 == null) goto L14;
        r8.b(null);
        goto L14
    L9:
        r7 = false;
    L14:
        ILinkMicBattleInviteMessage.BattleInviteType r9 = ILinkMicBattleInviteMessage.BattleInviteType.BattleInviteType_MultipleMatches3;
        if (r15 != r9.ordinal()) goto L17;
        return null;
    L17:
        com.bytedance.android.live.revlink.impl.global.c r10 = this.d;
        if (r10 == null) goto L20;
        com.bytedance.android.live.revlink.impl.multianchor.dialog.linkopt.f r12 = r10.getLinkPlayHelper();
    L21:
        if (r12 == null) goto L25;
        if (r12.e() != true) goto L25;
    L27:
        LinkedHashMap r13 = new LinkedHashMap();
        r13.put("invitee_status", DataType.FALSE);
        r13.put("is_recommend_list", DataType.FALSE);
        r13.put("pk_description", "routine");
        r13.put("anchor_connect_status", "2");
        r13.put("is_success", DataType.FALSE);
        if (r15 != ILinkMicBattleInviteMessage.BattleInviteType.BattleInviteType_Normal_Activity.ordinal()) goto L31;
        r13.put("pk_description", "activity");
        r13.put("pk_activity_type", "chinese_valentine");
        r13.put("invite_mode", "activity_pk");
    L37:
        if (r16 == null) goto L39;
        aa r14 = r16.getVoteData();
    L41:
        if (r14 == null) goto L53;
        r13.put("invite_mode", "vote");
        aa r18 = r16.getVoteData();
        if (r18 == null) goto L45;
        String r20 = r18.getVoteDes();
    L46:
        if (r20 == null) goto L53;
        aa r23 = r16.getVoteData();
        if (r23 == null) goto L51;
        String r24 = r23.getVoteDes();
        if (r24 == null) goto L51;
    L52:
        r13.put(FileUtils.PICTURE_THEME, r24);
    L51:
        r24 = "";
        goto L52
    L45:
        r20 = null;
    L53:
        if (r16 == null) goto L55;
        u2 r25 = r16.getSelfData();
    L57:
        if (r25 == null) goto L64;
        r13.put("invite_mode", "customize_pk");
        u2 r26 = r16.getSelfData();
        if (r26 == null) goto L62;
        String r27 = String.valueOf(r26.getPkValueType());
        if (r27 == null) goto L62;
    L63:
        r13.put("customize_pk_type", r27);
    L62:
        r27 = "";
    L64:
        if (r16 == null) goto L66;
        d4 r28 = r16.getCustomConfig();
    L67:
        if (r28 == null) goto L70;
        r13.put("invite_mode", "customize_pk");
    L70:
        if (r15 == ILinkMicBattleInviteMessage.BattleInviteType.BattleInviteType_Again.ordinal()) goto L91;
        cy0.e.a.getClass();
        j r29 = cy0.e.a.a;
        com.bytedance.android.scope.m.e.getClass();
        Object r1 = com.bytedance.android.scope.m.b(r29).b(com.bytedance.android.livesdk.revenue.service.user.a.class);
        Intrinsics.checkNotNull(r1);
        IBaseUser r2 = ((com.bytedance.live.kmp.core.c) r1).b();
        if (r2 == null) goto L75;
        String r30 = r2.getIdString();
        if (r30 == null) goto L75;
    L76:
        com.bytedance.android.live.revlink.impl.global.c r32 = this.d;
        if (r32 == null) goto L79;
        IPKLinkBizDataService r33 = r32.mk();
    L80:
        if (r33 == null) goto L91;
        w31.c r110 = n();
        if (r110 == null) goto L84;
        String r111 = r110.c();
    L85:
        String r34 = r33.getTransformReason(r111, r30);
        if (r34.length() <= 0) goto L88;
        r4 = true;
    L88:
        if (r4 == false) goto L91;
        r13.put("transform_reason", r34);
        goto L91
    L84:
        r111 = null;
        goto L85
    L79:
        r33 = null;
    L75:
        r30 = "";
    L91:
        if (r16 == null) goto L95;
        w2 r35 = r16.getShellConfig();
        if (r35 == null) goto L95;
        long r112 = r35.getType();
    L97:
        if (r112 <= 0) goto L99;
        r13.put("invite_mode", "compete");
    L99:
        if (r16 == null) goto L101;
        h9 r36 = r16.getSpecifyGiftConfig();
    L102:
        if (r36 == null) goto L104;
        r13.put("invite_mode", "focus_gift");
        int r37 = c0.a;
        c0.a(r16.getSpecifyGiftConfig(), r13);
    L104:
        q r38 = o();
        if (r38 == null) goto L107;
        com.bytedance.android.live.revlink.impl.mergepk.pkdouble.c r39 = r38.g();
    L108:
        com.bytedance.android.live.revlink.impl.mergepk.pkbase.e r40 = l();
        if (r16 == null) goto L114;
        if (r16.getModType() != PkBaseDataContext.PKModType.BreakThrough.getType()) goto L114;
        r13.put("invite_mode", "cooperation");
    L114:
        if (r40 != null) goto L116;
    L140:
        com.bytedance.android.live.revlink.impl.multianchor.dialog.linkopt.e r42 = h();
        if (r42 == null) goto L143;
        String r43 = r42.a();
    L144:
        r13.put("from_room_status", r43);
        r13.put("anchor_type", "play");
        com.bytedance.android.live.revlink.impl.multianchor.dialog.linkopt.e r44 = h();
        if (r44 == null) goto L148;
        String r45 = r44.a;
        if (r45 == null) goto L148;
    L149:
        r13.put("source", r45);
        d31.d r46 = p();
        if (r46 == null) goto L152;
        String r47 = r46.s();
    L153:
        r13.put("room_status", r47);
        r13.put("invitee_room_status", "pk");
        com.bytedance.android.live.revlink.impl.global.c r48 = this.d;
        if (r48 == null) goto L156;
        i11.b r49 = r48.c8();
    L157:
        if (r49 == null) goto L166;
        List<p> r50 = r49.getOnlineUserList();
        if (r50 == null) goto L161;
        Integer r52 = Integer.valueOf(r50.size());
    L162:
        String r53 = String.valueOf(r52.intValue());
        if (r53 != null) goto L165;
        r53 = "";
    L165:
        r13.put("invitee_connect_cnt", r53);
        goto L166
    L161:
        r52 = null;
    L166:
        r13.put("is_oncemore", DataType.FALSE);
        if (l() == null) goto L182;
        com.bytedance.android.live.revlink.impl.mergepk.pkbase.e r113 = l();
        if (r113 == null) goto L171;
        c21.f r114 = r113.getBattlePlayMode();
    L172:
        if (r114 == null) goto L182;
        if (r22 == null) goto L182;
        c21.f r54 = r22.b;
        if (r54 == null) goto L182;
        com.bytedance.android.live.revlink.impl.mergepk.pkbase.e r115 = l();
        if (r115 == null) goto L180;
        r6 = r115.getBattlePlayMode();
    L180:
        if (r54.a(r6) != true) goto L182;
        r13.put("is_oncemore", DataType.TRUE);
        goto L182
    L171:
        r114 = null;
    L182:
        a(r13);
        d31.d r55 = p();
        if (r55 == null) goto L185;
        String r56 = r55.s();
    L186:
        r13.put("room_status", r56);
        if (r39 == null) goto L194;
        d31.d r57 = p();
        if (r57 == null) goto L192;
        String r58 = r57.p(r39.getInviteType());
        if (r58 == null) goto L192;
    L193:
        r13.put("invitee_list", r58);
    L192:
        r58 = "";
    L194:
        r13.put("anchor_connection_type", "invite");
        r13.put("invite_type", "play");
        r13.put("connection_sub_type", "");
        a(r13);
        r13.put("pk_time", String.valueOf(r17));
        r13.put("list_num", DataType.FALSE);
        r13.put("stay_time", String.valueOf(r19 / 1000));
        return r13;
    L185:
        r56 = "";
        goto L186
    L156:
        r49 = null;
        goto L157
    L152:
        r47 = "";
    L148:
        r45 = "";
        goto L149
    L143:
        r43 = "";
        goto L144
    L116:
        if (r40.modType() != PkBaseDataContext.PKModType.BreakThrough) goto L140;
        r13.put("pve_level", String.valueOf(r40.getBreakThroughStage()));
        com.bytedance.android.live.revlink.impl.global.c r116 = this.d;
        if (r116 == null) goto L120;
        com.bytedance.android.live.revlink.impl.multianchor.dialog.linkopt.f r117 = r116.getLinkPlayHelper();
    L121:
        if (r117 == null) goto L140;
        com.bytedance.android.live.revlink.impl.global.c r118 = r117.c;
        if (r118 == null) goto L125;
        q r119 = r118.getPkUtils();
    L126:
        if (r119 == null) goto L128;
        q11.b r120 = r119.a();
    L130:
        if (Intrinsics.areEqual(r120, q11.b.c.b) != true) goto L140;
        r13.put("finish_level", String.valueOf(r40.getBreakThroughStage()));
        if (r40.getBreakThroughInfo() == null) goto L140;
        n3 r59 = r40.getBreakThroughInfo();
        if (r59 != null) goto L136;
    L138:
        Object r60 = DataType.FALSE;
    L139:
        r13.put("is_finish", r60);
        goto L140
    L136:
        if (r59.getState() != 1) goto L138;
        r60 = DataType.TRUE;
        goto L139
    L128:
        r120 = null;
        goto L130
    L125:
        r119 = null;
        goto L126
    L120:
        r117 = null;
        goto L121
    L107:
        r39 = null;
        goto L108
    L101:
        r36 = null;
    L95:
        r112 = 0;
        goto L97
    L66:
        r28 = null;
        goto L67
    L55:
        r25 = null;
        goto L57
    L39:
        r14 = null;
        goto L41
    L31:
        if (r15 != r9.ordinal()) goto L34;
        r13.put("invite_mode", "2in3pk");
        goto L37
    L34:
        if (r15 != ILinkMicBattleInviteMessage.BattleInviteType.BattleInviteType_OPENGAME.ordinal()) goto L36;
        r13.put("invite_mode", "cohost_game");
        goto L37
    L36:
        r13.put("invite_mode", "routine_pk");
    L25:
        if (r15 == ILinkMicBattleInviteMessage.BattleInviteType.BattleInviteType_OPENGAME.ordinal()) goto L27;
        return null;
    L20:
        r12 = null;
        goto L21
    }
}
