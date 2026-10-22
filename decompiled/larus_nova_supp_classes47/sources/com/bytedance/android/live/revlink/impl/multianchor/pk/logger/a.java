package com.bytedance.android.live.revlink.impl.multianchor.pk.logger;

import androidx.lifecycle.LiveData;
import c21.f;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.profile.monitor.DataType;
import com.bytedance.android.live.revlink.impl.mergepk.pkbase.PkBaseDataContext;
import com.bytedance.android.live.revlink.impl.mergepk.pkbase.e;
import com.bytedance.android.live.revlink.impl.multianchor.pk.datacontext.MultiCommonPkDataContext;
import com.bytedance.android.live.revlink.impl.multianchor.utils.w;
import com.bytedance.android.live.revlink.impl.multianchor.utils.x;
import com.bytedance.android.live.revlink.impl.multianchor.vm.g;
import com.bytedance.android.live.revlink.impl.pk.service.IPKLinkBizDataService;
import com.bytedance.android.live.saas.middleware.store.FileUtils;
import com.bytedance.android.live.schema.api.WebcastRedirectException;
import com.bytedance.android.livesdk.link.model.IBattleConfigSetting;
import com.bytedance.android.livesdk.link.model.api.IBaseBattleSetting;
import com.bytedance.android.livesdk.link.model.h3;
import com.bytedance.android.livesdk.link.model.p0;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.IRoomBase;
import com.bytedance.android.livesdkapi.depend.model.live.IRoomKt_androidKt;
import com.bytedance.live.datacontext.m;
import d31.d;
import f31.j;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class a {
    public final com.bytedance.android.livesdk.revenue.service.room.c a;
    public final com.bytedance.android.live.revlink.impl.global.c b;

    public final Map<String, String> a() {
        LinkedHashMap r1 = new LinkedHashMap();
        com.bytedance.android.live.revlink.impl.global.c r2 = this.b;
        if (r2 == null) goto L5;
        MultiCommonPkDataContext r3 = r2.uk();
    L6:
        if (r3 == null) goto L230;
        j31.a r4 = r3.getStartParam();
        if (r4 == null) goto L230;
        Boolean r5 = r4.a;
        if (r5 == null) goto L228;
        boolean r6 = r5.booleanValue();
        LinkedHashMap r7 = new LinkedHashMap();
        com.bytedance.android.live.revlink.impl.global.c r8 = this.b;
        if (r8 == null) goto L14;
        com.bytedance.android.live.revlink.impl.multianchor.vm.b r9 = r8.rb();
    L15:
        if (r9 == null) goto L19;
        p21.c r10 = r9.getMultiLinkLogger();
        if (r10 == null) goto L19;
        r7.putAll(r10.a());
    L19:
        String r12 = DataType.TRUE;
        r7.put("pk_type", DataType.TRUE);
        r7.put("pk_mode", "npk");
        Long r13 = r4.b;
        if (r13 == null) goto L22;
        long r14 = r13.longValue();
    L23:
        r7.put("pk_id", String.valueOf(r14));
        r7.put("is_transform", DataType.TRUE);
        if (r4.e == false) goto L26;
        String r15 = DataType.TRUE;
    L27:
        r7.put("is_oncemore", r15);
        Integer r16 = r4.f;
        if (r16 == null) goto L30;
        r7.put("pk_time", String.valueOf(r16.intValue()));
    L30:
        String r17 = r4.g;
        if (r17 == null) goto L33;
        r7.put("invite_mode", r17);
    L33:
        String r18 = r4.h;
        if (r18 == null) goto L36;
        r7.put(FileUtils.PICTURE_THEME, r18);
    L36:
        Integer r19 = r4.i;
        if (r19 == null) goto L39;
        r7.put("connection_anchor_cnt", String.valueOf(r19.intValue()));
    L39:
        HashMap<String, Integer> r20 = r4.d;
        Iterator<String> r110 = r20.keySet().iterator();
        int r111 = 0;
        boolean r112 = false;
    L41:
        if (r110.hasNext() == false) goto L55;
        String r22 = r110.next();
        int r23 = h21.a.a;
        Integer r24 = r20.get(r22);
        if (r24 != null) goto L45;
        r24 = 0;
    L45:
        int r25 = r24.intValue();
        if (r25 != 3) goto L48;
    L51:
        boolean r26 = true;
    L52:
        if (r26 == true) goto L53;
        r111 = r111 + 1;
        goto L41
    L53:
        r112 = true;
        goto L41
    L48:
        if (r25 == 4) goto L51;
        r26 = false;
        goto L52
    L55:
        r7.put("pk_anchor_cnt", String.valueOf(r111));
        if (r112 == false) goto L58;
        String r27 = DataType.TRUE;
    L59:
        r7.put("guest_in", r27);
        e r28 = b();
        if (r28 == null) goto L62;
        f r29 = r28.getLastBattlePlayMode();
    L63:
        String r30 = "pve";
        if ((r29 instanceof f.a) == false) goto L66;
        String r32 = "pve";
    L67:
        r7.put("from_room_status", r32);
        e r33 = b();
        if (r33 != null) goto L70;
    L72:
        r30 = "pk";
    L73:
        r7.put("room_status", r30);
        d r34 = d();
        if (r34 == null) goto L76;
        String r35 = r34.o();
    L77:
        r7.put("is_manager", r35);
        String r36 = r4.k;
        if (r36 == null) goto L80;
        r7.put("anchor_type", r36);
    L80:
        String r37 = r4.l;
        if (r37 == null) goto L83;
        r7.put("npk_link_type", r37);
    L83:
        String r38 = r4.v;
        if (r38 != null) goto L86;
        r38 = "link_banner";
    L86:
        r7.put("source", r38);
        String r39 = r4.m;
        if (r39 == null) goto L89;
        r7.put("invitee_connection_status", r39);
    L89:
        com.bytedance.android.livesdk.revenue.service.room.c r40 = this.a;
        if (r40 == null) goto L96;
        com.bytedance.android.livesdk.revenue.room.a r42 = r40.getRoomContext();
        if (r42 == null) goto L96;
        IRoom r43 = r42.getCommonRoom();
        if (r43 == null) goto L96;
        String r44 = r7.put("audience_num", String.valueOf(IRoomKt_androidKt.getUserCountExt(r43)));
    L96:
        String r45 = r4.n;
        if (r45 == null) goto L99;
        r7.put("customize_pk_type", r45);
    L99:
        String r46 = r4.o;
        if (r46 == null) goto L102;
        r7.put("giftvalue_exchange_rate", r46);
    L102:
        String r47 = r4.p;
        if (r47 == null) goto L105;
        r7.put("giftuv_exchange_rate", r47);
    L105:
        String r48 = r4.q;
        if (r48 == null) goto L108;
        r7.put("ticket_exchange_rate", r48);
    L108:
        String r49 = r4.r;
        if (r49 == null) goto L111;
        r7.put("like_exchange_rate", r49);
    L111:
        String r50 = r4.s;
        if (r50 == null) goto L114;
        r7.put("membership_exchange_rate", r50);
    L114:
        Long r52 = Long.valueOf(r4.t);
        if (r52.longValue() <= 0) goto L117;
        boolean r113 = true;
    L118:
        if (r113 == true) goto L121;
        r52 = null;
    L121:
        if (r52 == null) goto L124;
        r7.put("focus_gift_id", String.valueOf(r52.longValue()));
    L124:
        String r53 = r4.u;
        if (r53 != null) goto L127;
    L135:
        if (r6 == false) goto L165;
        d r54 = d();
        if (r54 == null) goto L139;
        r54.r(r7);
    L139:
        d r55 = d();
        if (r55 == null) goto L167;
        Intrinsics.checkNotNullParameter(r7, "map");
        w r56 = r55.k();
        if (r56 != null) goto L144;
    L154:
        f21.a r57 = r55.j();
        if (r57 != null) goto L157;
    L163:
        String r58 = r3;
    L164:
        r7.put("is_n_invite", r58);
        goto L167
    L157:
        if (r57.h != true) goto L163;
        f21.a r59 = r55.j();
        if (r59 == null) goto L163;
        if (r59.i == true) goto L163;
        r58 = DataType.TRUE;
        goto L164
    L144:
        if (r56.e() != true) goto L154;
        w31.c r60 = r55.l();
        if (r60 == null) goto L152;
        IPKLinkBizDataService r62 = r60.g();
        if (r62 == null) goto L152;
        if (r62.getLinkFromMultiInvite() != true) goto L152;
        String r63 = DataType.TRUE;
    L153:
        r7.put("is_n_invite", r63);
    L152:
        r63 = DataType.FALSE;
    L167:
        if (d() == null) goto L169;
        Integer r64 = Integer.valueOf(n41.a.b());
    L170:
        r7.put("audience_connect_cnt", String.valueOf(r64));
        com.bytedance.android.live.revlink.impl.global.c r65 = this.b;
        if (r65 == null) goto L173;
        com.bytedance.android.live.revlink.impl.multianchor.vm.b r66 = r65.rb();
    L174:
        if (r66 == null) goto L180;
        m<String> r67 = r66.getConnectionSubType();
        if (r67 == null) goto L180;
        String r68 = (String) r67.getValue();
        if (r68 == null) goto L180;
        r7.put("connection_sub_type", r68);
    L180:
        r7.put("anchor_connect_status", String.valueOf(r20.size()));
        com.bytedance.android.live.revlink.impl.global.c r69 = this.b;
        if (r69 == null) goto L183;
        g r70 = r69.getMultiAnchorLinkContextObj();
    L184:
        if (r70 != null) goto L186;
    L188:
        e r72 = b();
        if (r72 != null) goto L191;
    L202:
        com.bytedance.android.live.revlink.impl.global.c r73 = this.b;
        if (r73 == null) goto L205;
        g r74 = r73.getMultiAnchorLinkContextObj();
    L206:
        if (r74 == null) goto L208;
        Integer r75 = Integer.valueOf(r74.d());
    L209:
        if (r75 != null) goto L212;
    L214:
        r12 = r3;
    L215:
        r7.put("if_strategy_invite", r12);
        e r76 = b();
        if (r76 == null) goto L229;
        Map<String, String> r77 = r76.getCommonLogParams();
        if (r77 == null) goto L229;
        r7.putAll(r77);
        Map<String, String> r78 = r4.x;
        if (r78 == null) goto L222;
        r7.putAll(r78);
    L222:
        p0 r79 = r4.y;
        if (r79 == null) goto L229;
        String r80 = r79.getStrategyLogId();
        if (r80 != null) goto L227;
        r80 = "";
    L227:
        String r82 = r7.put("request_id", r80);
    L229:
        r1.putAll(r7);
        goto L230
    L212:
        if (r75.intValue() != 6) goto L214;
    L208:
        r75 = null;
        goto L209
    L205:
        r74 = null;
        goto L206
    L191:
        if (r72.isInCloudCollaborate() != true) goto L202;
        r7.put("invite_mode", "link_screen");
        e r83 = b();
        if (r83 == null) goto L200;
        IBaseBattleSetting r84 = r83.getBattleSettings();
        if (r84 == null) goto L200;
        h3 r85 = r84.getTitleConfig();
        if (r85 == null) goto L200;
        String r86 = r85.getContent();
        if (r86 == null) goto L200;
    L201:
        r7.put("playmode_name", r86);
    L200:
        r86 = "";
        goto L201
    L186:
        if (x.a(r70.d()) != true) goto L188;
        r7.put("from_room_status", "live");
        r7.put("anchor_connect_status", "4");
        r7.put("connection_anchor_cnt", "4");
        r7.put("invite_mode", "routine_pk");
        r7.put("room_status", "pk");
        r7.put("source", "pk_banner");
        goto L188
    L183:
        r70 = null;
        goto L184
    L173:
        r66 = null;
        goto L174
    L169:
        r64 = null;
        goto L170
    L165:
        r7.put("connection_type", "pk");
        goto L167
    L127:
        if (r53.length() <= 0) goto L129;
        boolean r114 = true;
    L130:
        if (r114 == true) goto L133;
        r53 = null;
    L133:
        if (r53 == null) goto L135;
        r7.put("focus_gift_name", r53);
        goto L135
    L129:
        r114 = false;
        goto L130
    L117:
        r113 = false;
        goto L118
    L76:
        r35 = "";
        goto L77
    L70:
        if (r33.isInBreakThrough() != true) goto L72;
    L66:
        r32 = "connection";
        goto L67
    L62:
        r29 = null;
        goto L63
    L58:
        r27 = DataType.FALSE;
        goto L59
    L26:
        r15 = DataType.FALSE;
        goto L27
    L22:
        r14 = 0;
        goto L23
    L14:
        r9 = null;
        goto L15
    L228:
        r7 = new LinkedHashMap();
    L230:
        return r1;
    L5:
        r3 = null;
        goto L6
    }

    public final e b() {
        com.bytedance.android.live.revlink.impl.global.c r0 = this.b;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.Ig();
    }

    public final Map<String, String> c() {
        LinkedHashMap r0 = new LinkedHashMap();
        com.bytedance.android.live.revlink.impl.global.c r1 = this.b;
        com.bytedance.android.live.revlink.impl.mergepk.pkmulti.b r2 = null;
        if (r1 == null) goto L5;
        MultiCommonPkDataContext r3 = r1.uk();
    L6:
        long r4 = 0;
        String r7 = "";
        if (r3 == null) goto L70;
        j31.a r8 = r3.getStartParam();
        if (r8 == null) goto L11;
        Integer r9 = r8.f;
    L12:
        r0.put("pk_time", String.valueOf(r9));
        j31.a r10 = r3.getStartParam();
        if (r10 == null) goto L21;
        Long r12 = r10.c;
        if (r12 == null) goto L21;
        long r13 = r12.longValue();
        if (r13 <= 0) goto L19;
        i97.a r14 = i97.a.a;
        String r15 = String.valueOf((System.currentTimeMillis() - r13) / ((long) WebcastRedirectException.UNKNOWN));
    L20:
        if (r15 == null) goto L21;
    L22:
        r0.put("connection_time", r15);
        Integer r16 = r3.getEndReason();
        String r17 = DataType.FALSE;
        if (r16 != null) goto L26;
    L28:
        Object r18 = DataType.TRUE;
    L29:
        r0.put("is_cutoff", r18);
        com.bytedance.android.livesdk.revenue.room.a r19 = r3.getRoomContext();
        if (r19 == null) goto L36;
        IRoom r20 = r19.getCommonRoom();
        if (r20 == null) goto L36;
        IBaseUser r22 = r20.getOwnerKt();
        if (r22 == null) goto L36;
        String r23 = iz.a.a(r22);
    L38:
        if (Intrinsics.areEqual(r23, r3.getInitiatorId()) == false) goto L40;
        String r24 = "active";
    L41:
        r0.put("end_reason", r24);
        Integer r25 = r3.getEndReason();
        if (r25 != null) goto L45;
    L47:
        r0.put("is_manager", r3.isPkManager());
        if (d() == null) goto L50;
        String r26 = d.e(r3.getEndReason());
    L51:
        r0.put("end_type", r26);
        if (r3.isTopSecKillTrigger() == true) goto L58;
        Integer r27 = r3.getKillFinishType();
        if (r27 != null) goto L57;
    L59:
        r0.put("is_top_smash", r17);
        com.bytedance.android.live.revlink.impl.global.c r28 = this.b;
        if (r28 == null) goto L62;
        com.bytedance.android.live.revlink.impl.multianchor.service.b r29 = r28.d6();
    L63:
        if (r29 == null) goto L67;
        j r30 = r29.getEndingLinkStatus();
        if (r30 == null) goto L67;
        r0.put("anchor_connect_status", String.valueOf(r30.a));
        r0.put("end_type", r30.b);
        r0.put("end_reason", "active");
    L67:
        Map<String, String> r5 = r3.getEventTrackingInfo();
        if (r5 == null) goto L70;
        r0.putAll(r5);
        goto L70
    L62:
        r29 = null;
        goto L63
    L57:
        if (r27.intValue() != 2) goto L59;
    L58:
        r17 = DataType.TRUE;
        goto L59
    L50:
        r26 = "";
        goto L51
    L45:
        if (r25.intValue() != 0) goto L47;
        r0.put("end_reason", "routine");
        goto L47
    L40:
        r24 = "passive";
    L36:
        r23 = null;
        goto L38
    L26:
        if (r16.intValue() != 0) goto L28;
        r18 = DataType.FALSE;
        goto L29
    L19:
        r15 = "";
    L21:
        r15 = "";
        goto L22
    L11:
        r9 = null;
    L70:
        d r6 = d();
        if (r6 == null) goto L73;
        Map<String, String> r32 = r6.i();
    L74:
        r0.putAll(r32);
        e r33 = b();
        if (r33 == null) goto L97;
        LiveData<List<cf2.a>> r34 = r33.getBaseScoreState();
        if (r34 == null) goto L97;
        List r35 = (List) r34.getValue();
        if (r35 == null) goto L97;
        Iterator r36 = r35.iterator();
        long r37 = 0;
    L82:
        if (r36.hasNext() == false) goto L96;
        cf2.a r110 = (cf2.a) r36.next();
        r4 = r4 + af2.c.b(r110.d);
        String r111 = r110.c;
        com.bytedance.android.livesdk.revenue.service.room.c r112 = this.a;
        if (r112 == null) goto L92;
        com.bytedance.android.livesdk.revenue.room.a r113 = r112.getRoomContext();
        if (r113 == null) goto L92;
        IRoomBase r114 = r113.getCommonRoom();
        if (r114 == null) goto L92;
        IBaseUser r115 = r114.getOwnerKt();
        if (r115 == null) goto L92;
        String r116 = r115.getIdString();
    L94:
        if (Intrinsics.areEqual(r111, r116) == false) goto L82;
        r37 = af2.c.b(r110.d);
    L92:
        r116 = null;
        goto L94
    L96:
        long r117 = r4;
        r4 = r37;
        long r38 = r117;
    L98:
        e r39 = b();
        if (r39 == null) goto L101;
        PkBaseDataContext.PKModType r40 = r39.modType();
    L103:
        if (r40 != PkBaseDataContext.PKModType.CloudCollaborate) goto L124;
        r0.put("invite_mode", "link_screen");
        e r42 = b();
        if (r42 == null) goto L112;
        IBaseBattleSetting r43 = r42.getBattleSettings();
        if (r43 == null) goto L112;
        h3 r44 = r43.getTitleConfig();
        if (r44 == null) goto L112;
        String r45 = r44.getContent();
        if (r45 == null) goto L112;
    L113:
        r0.put("playmode_name", r45);
        e r46 = b();
        if (r46 == null) goto L124;
        if (r46.getCloudCollaboratePanelType() != IBattleConfigSetting.BattleCloudCollaboratePanelType.BattleCloudCollaboratePanelType_ThroneFight.ordinal()) goto L124;
        e r47 = b();
        if (r47 == null) goto L123;
        String r48 = String.valueOf(r47.getThroneFightEvenCount());
        if (r48 == null) goto L123;
        r7 = r48;
    L123:
        r0.put("order", r7);
    L112:
        r45 = "";
    L124:
        r0.put("total_diamond", String.valueOf(r38));
        r0.put("invitor_diamond", String.valueOf(r4));
        com.bytedance.android.live.revlink.impl.global.c r49 = this.b;
        if (r49 == null) goto L127;
        r2 = r49.Q1();
    L127:
        if (r2 != null) goto L129;
    L131:
        return r0;
    L129:
        if (r2.isAnchorLinkFinisher() == false) goto L131;
        r0.put("end_reason", "active");
        goto L131
    L101:
        r40 = null;
    L97:
        r38 = 0;
        goto L98
    L73:
        r32 = MapsKt.emptyMap();
        goto L74
    L5:
        r3 = null;
        goto L6
    }

    public final d d() {
        com.bytedance.android.live.revlink.impl.global.c r0 = this.b;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getRevLinkLogHelper();
    }

    public a(com.bytedance.android.livesdk.revenue.service.room.c r1, com.bytedance.android.live.revlink.link.infra.lifecontrol.context.d r2) {
        this.a = r1;
        this.b = r2;
    }
}
