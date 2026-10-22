package d31;

import androidx.lifecycle.LiveData;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.link.constants.UserListInviteType;
import com.bytedance.android.live.profile.monitor.DataType;
import com.bytedance.android.live.revlink.impl.LinkCrossRoomDataHolder;
import com.bytedance.android.live.revlink.impl.global.LinkFakeGlobalService;
import com.bytedance.android.live.revlink.impl.multianchor.pk.datacontext.MultiCommonPkDataContext;
import com.bytedance.android.live.revlink.impl.multianchor.ui.UILayout;
import com.bytedance.android.live.revlink.impl.multianchor.utils.x;
import com.bytedance.android.live.revlink.impl.pk.service.IPKLinkBizDataService;
import com.bytedance.android.live.revlink.impl.pk.utils.q;
import com.bytedance.android.live.revlink.impl.utils.s;
import com.bytedance.android.livesdk.link.model.IProfitGameStatusMessage;
import com.bytedance.android.livesdk.link.model.e1;
import com.bytedance.android.livesdk.link.model.f4;
import com.bytedance.android.livesdkapi.depend.model.live.IRoomBase;
import com.bytedance.android.scope.m;
import com.bytedance.live.datacontext.n;
import cy0.j;
import dq2.p;
import dq2.w;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.TypesJVMKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class d {
    public x11.a a;
    public final com.bytedance.android.livesdk.revenue.service.room.c b;
    public final com.bytedance.android.live.revlink.impl.global.c c;

    public static int n() {
        cy0.e.a.getClass();
        j r1 = cy0.e.a.a;
        m.e.getClass();
        Object r0 = m.b(r1).b(com.bytedance.android.livesdk.revenue.service.interact.d.class);
        Intrinsics.checkNotNull(r0);
        w r2 = ((com.bytedance.live.kmp.core.c) r0).M1();
        if (r2 != null) goto L7;
        return 0;
    L7:
        return r2.o();
    }

    public final String d() {
        x11.a r0 = this.a;
        if (r0 == null) goto L8;
        y11.b r1 = r0.mo1159do();
        if (r1 == null) goto L8;
        String r2 = r1.b();
        if (r2 == null) goto L8;
        return r2;
    L8:
        return "";
    }

    public final String f() {
        x11.a r0 = this.a;
        if (r0 == null) goto L7;
        y11.f r1 = r0.G9();
        if (r1 == null) goto L7;
        return r1.b();
    L7:
        return "";
    }

    public final String g() {
        com.bytedance.android.live.revlink.impl.global.c r0 = this.c;
        MultiCommonPkDataContext r1 = null;
        if (r0 == null) goto L5;
        com.bytedance.android.live.revlink.impl.mergepk.pkbase.e r2 = r0.Ig();
    L6:
        boolean r3 = false;
        if (r2 == null) goto L9;
        boolean r4 = r2.isOnceMoreBattle();
    L10:
        com.bytedance.android.live.revlink.impl.global.c r5 = this.c;
        if (r5 == null) goto L13;
        r1 = r5.uk();
    L13:
        if (r1 == null) goto L18;
        j31.a r6 = r1.getStartParam();
        if (r6 == null) goto L18;
        r3 = r6.e;
    L18:
        if ((r4 | r3) == false) goto L20;
        return DataType.TRUE;
    L20:
        return DataType.FALSE;
    L9:
        r4 = false;
        goto L10
    L5:
        r2 = null;
        goto L6
    }

    public final Map<String, String> i() {
        LinkedHashMap r0 = new LinkedHashMap();
        com.bytedance.android.live.revlink.impl.global.c r1 = this.c;
        f4 r2 = null;
        if (r1 == null) goto L5;
        com.bytedance.android.live.revlink.impl.multianchor.dialog.linkopt.f r3 = r1.getLinkPlayHelper();
    L6:
        boolean r4 = false;
        String r5 = DataType.FALSE;
        String r8 = "";
        if (r3 != null) goto L9;
    L19:
        com.bytedance.android.live.revlink.impl.global.c r6 = this.c;
        if (r6 == null) goto L26;
        com.bytedance.android.live.revlink.impl.mergepk.pkmulti.c r7 = r6.U7();
        if (r7 == null) goto L26;
        if (r7.getCurrentGameStatus() != IProfitGameStatusMessage.GameStatus.BizStart.ordinal()) goto L26;
        boolean r9 = true;
    L27:
        if (r9 == false) goto L29;
        String r10 = "game_link";
    L30:
        r0.put("invite_mode", r10);
        r0.put("pk_id", DataType.FALSE);
    L31:
        com.bytedance.android.live.revlink.impl.global.c r12 = this.c;
        if (r12 == null) goto L34;
        com.bytedance.android.live.revlink.impl.mergepk.pkbase.e r13 = r12.Ig();
    L35:
        if (r13 == null) goto L40;
        LiveData<Long> r14 = r13.getBaseTimeLeft();
        if (r14 == null) goto L40;
        Long r15 = (Long) r14.getValue();
        if (r15 == null) goto L40;
    L41:
        r0.put("pkleft_time", String.valueOf(r15.longValue()));
        d r16 = m();
        if (r16 == null) goto L44;
        String r17 = r16.s();
    L45:
        r0.put("room_status", r17);
        d r18 = m();
        if (r18 == null) goto L58;
        com.bytedance.android.live.revlink.impl.global.c r19 = this.c;
        if (r19 == null) goto L50;
        q r20 = r19.getPkUtils();
    L51:
        if (r20 == null) goto L55;
        com.bytedance.android.live.revlink.impl.mergepk.pkdouble.c r22 = r20.g();
        if (r22 == null) goto L55;
        int r23 = r22.getInviteType();
    L56:
        String r24 = r18.p(r23);
        if (r24 == null) goto L58;
    L59:
        r0.put("invitee_list", r24);
        d r25 = m();
        if (r25 == null) goto L62;
        String r26 = r25.g();
    L63:
        r0.put("is_oncemore", r26);
        d r27 = m();
        if (r27 == null) goto L66;
        r8 = r27.o();
    L66:
        r0.put("is_manager", r8);
        com.bytedance.android.live.revlink.impl.global.c r28 = this.c;
        if (r28 == null) goto L69;
        LinkCrossRoomDataHolder r29 = r28.getLinkCrossRoomDataHolder();
    L70:
        if (r29 == null) goto L72;
        Long r30 = Long.valueOf(r29.c());
    L73:
        r0.put("channel_id", String.valueOf(r30));
        cy0.e.a.getClass();
        j r32 = cy0.e.a.a;
        m.e.getClass();
        Object r33 = m.b(r32).b(com.bytedance.android.livesdk.revenue.service.interact.d.class);
        Intrinsics.checkNotNull(r33);
        w r34 = ((com.bytedance.live.kmp.core.c) r33).M1();
        if (r34 == null) goto L76;
        int r35 = r34.o();
    L77:
        if (r35 > 0) goto L79;
    L81:
        if (r13 == null) goto L130;
        LiveData<String> r36 = r13.getBattleEffectInfo();
        if (r36 == null) goto L130;
        String r37 = (String) r36.getValue();
        if (r37 == null) goto L130;
        com.bytedance.android.live.revlink.impl.global.c r38 = this.c;
        if (r38 == null) goto L89;
        com.bytedance.android.live.revlink.impl.multianchor.dialog.linkopt.f r39 = r38.getLinkPlayHelper();
    L90:
        if (r39 == null) goto L130;
        if (r39.h() != true) goto L130;
        if (r37.length() <= 0) goto L96;
        r4 = true;
    L96:
        if (r4 == false) goto L130;
        l97.a.a.fromJson(r37, TypesJVMKt.getJavaType(Reflection.typeOf(e1.class)));     // Catch: Exception -> L129
        e1 r40 = (e1) l97.a.a.fromJson(r37, TypesJVMKt.getJavaType(Reflection.typeOf(e1.class)));     // Catch: Exception -> L129
        if (r40 == null) goto L130;
        Map r42 = r40.getAnchorEffectMap();     // Catch: Exception -> L129
        if (r42 == null) goto L130;
        com.bytedance.android.live.revlink.impl.global.c r43 = this.c;     // Catch: Exception -> L129
        if (r43 == null) goto L104;
        s r44 = r43.getRevLinkCommonUtil();     // Catch: Exception -> L129
    L105:
        if (r44 == null) goto L107;
        String r45 = r44.c();     // Catch: Exception -> L129
    L108:
        Intrinsics.checkNotNull(r45);     // Catch: Exception -> L129
        com.bytedance.android.livesdk.link.model.j r46 = (com.bytedance.android.livesdk.link.model.j) r42.get(r45);     // Catch: Exception -> L129
        if (r46 == null) goto L130;
        long r47 = com.bytedance.live.kmp.util.e.b();     // Catch: Exception -> L129
        Iterator r48 = r46.getEffectList().iterator();     // Catch: Exception -> L129
    L112:
        if (r48.hasNext() == false) goto L122;
        f4 r49 = (f4) r48.next();     // Catch: Exception -> L129
        if (r47 <= r49.getStartTime()) goto L112;
        if (r47 >= r49.getEndTime()) goto L112;
        if (r49.getEffectType() == 1) goto L119;
        r2 = r49;
        goto L112
    L119:
        r2 = r49;
    L122:
        if (r2 == null) goto L127;
        String r50 = String.valueOf(r2.getEffectType());     // Catch: Exception -> L129
        if (r50 == null) goto L127;
        r5 = r50;
    L127:
        r0.put("current_pk_battle_effect_id", r5);     // Catch: Exception -> L129
        goto L130
    L107:
        r45 = null;
        goto L108
    L104:
        r44 = null;
        goto L105
    L89:
        r39 = null;
    L130:
        d r52 = m();
        if (r52 == null) goto L133;
        r52.r(r0);
    L133:
        return r0;
    L79:
        if (Intrinsics.areEqual((String) r0.get("room_status"), "live") == false) goto L81;
        r0.put("room_status", "audience_connection");
        goto L81
    L76:
        r35 = 0;
        goto L77
    L72:
        r30 = null;
        goto L73
    L69:
        r29 = null;
        goto L70
    L62:
        r26 = "";
    L55:
        r23 = 0;
        goto L56
    L50:
        r20 = null;
    L58:
        r24 = "";
        goto L59
    L44:
        r17 = "";
    L40:
        r15 = -1L;
        goto L41
    L34:
        r13 = null;
        goto L35
    L29:
        r10 = "connection";
    L26:
        r9 = false;
        goto L27
    L9:
        if (r3.h() != true) goto L19;
        d r53 = m();
        if (r53 == null) goto L13;
        String r54 = r53.f();
    L14:
        r0.put("invite_mode", r54);
        w31.c r55 = l();
        if (r55 == null) goto L17;
        Long r56 = Long.valueOf(r55.i());
    L18:
        r0.put("pk_id", String.valueOf(r56));
        goto L31
    L17:
        r56 = null;
        goto L18
    L13:
        r54 = "";
        goto L14
    L5:
        r3 = null;
        goto L6
    }

    public final f21.a j() {
        com.bytedance.android.live.revlink.impl.global.c r0 = this.c;
        if (r0 == null) goto L5;
        com.bytedance.android.live.revlink.impl.multianchor.vm.b r1 = r0.rb();
    L6:
        if (r1 == null) goto L11;
        n<? extends f21.a> r2 = r1.getConnectionContext();
        if (r2 != null) goto L10;
        return null;
    L10:
        return (f21.a) r2.getValue();
    L11:
        return null;
    L5:
        r1 = null;
        goto L6
    }

    public final com.bytedance.android.live.revlink.impl.multianchor.utils.w k() {
        com.bytedance.android.live.revlink.impl.global.c r0 = this.c;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getMultiLinkUtil();
    }

    public final w31.c l() {
        com.bytedance.android.live.revlink.impl.global.c r0 = this.c;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getPkLinkUtils();
    }

    public final d m() {
        com.bytedance.android.live.revlink.impl.global.c r0 = this.c;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getRevLinkLogHelper();
    }

    public final String s() {
        com.bytedance.android.live.revlink.impl.global.c r0 = this.c;
        com.bytedance.android.live.revlink.impl.multianchor.dialog.linkopt.f r1 = null;
        if (r0 == null) goto L5;
        com.bytedance.android.live.revlink.impl.multianchor.dialog.linkopt.f r2 = r0.getLinkPlayHelper();
    L7:
        if (r2 != null) goto L9;
    L11:
        com.bytedance.android.live.revlink.impl.global.c r3 = this.c;
        if (r3 == null) goto L14;
        r1 = r3.getLinkPlayHelper();
    L14:
        if (r1 != null) goto L16;
    L18:
        com.bytedance.android.live.revlink.impl.multianchor.utils.w r4 = k();
        if (r4 != null) goto L21;
    L23:
        cy0.e.a.getClass();
        j r5 = cy0.e.a.a;
        m.e.getClass();
        Object r6 = m.b(r5).b(com.bytedance.android.livesdk.revenue.service.interact.d.class);
        Intrinsics.checkNotNull(r6);
        p r7 = ((com.bytedance.live.kmp.core.c) r6).getInteractAudienceService();
        if (r7 != null) goto L26;
    L27:
        Object r8 = m.b(r5).b(com.bytedance.android.livesdk.revenue.service.interact.d.class);
        Intrinsics.checkNotNull(r8);
        w r9 = ((com.bytedance.live.kmp.core.c) r8).M1();
        if (r9 == null) goto L30;
        int r10 = r9.w();
    L31:
        if (r10 <= 0) goto L33;
    L36:
        return "audience_connection";
    L33:
        if (n41.a.b() > 0) goto L36;
        return "live";
    L30:
        r10 = 0;
        goto L31
    L26:
        if (r7.a() == true) goto L36;
    L21:
        if (r4.c() != true) goto L23;
        return "connection";
    L16:
        if (r1.c() != true) goto L18;
        return "pk";
    L9:
        if (r2.d() != true) goto L11;
        return "pve";
    L5:
        r2 = null;
        goto L7
    }

    public final String a() {
        com.bytedance.android.live.revlink.impl.multianchor.utils.w r0 = k();
        int r1 = 2;
        if (r0 != null) goto L5;
    L7:
        com.bytedance.android.live.revlink.impl.multianchor.utils.w r2 = k();
        if (r2 != null) goto L10;
    L20:
        return DataType.FALSE;
    L10:
        if (r2.d() != true) goto L20;
        com.bytedance.android.live.revlink.impl.multianchor.utils.w r3 = k();
        if (r3 == null) goto L16;
        i11.b r4 = r3.a();
        if (r4 == null) goto L16;
        r1 = r4.c();
    L16:
        if (r1 > 1) goto L19;
        return "2";
    L19:
        return String.valueOf(r1);
    L5:
        if (r0.e() != true) goto L7;
        return String.valueOf(2);
    }

    public final String b() {
        com.bytedance.android.live.revlink.impl.multianchor.utils.w r0 = k();
        if (r0 != null) goto L5;
    L21:
        return "";
    L5:
        if (r0.d() != true) goto L21;
        com.bytedance.android.live.revlink.impl.multianchor.utils.w r1 = k();
        if (r1 == null) goto L9;
        int r2 = r1.h();
    L11:
        if (r2 <= 2) goto L21;
        com.bytedance.android.live.revlink.impl.global.c r3 = this.c;
        if (r3 == null) goto L15;
        com.bytedance.android.live.revlink.impl.multianchor.vm.b r4 = r3.rb();
    L16:
        if (r4 == null) goto L21;
        com.bytedance.live.datacontext.m<String> r5 = r4.getConnectionSubType();
        if (r5 == null) goto L21;
        String r6 = (String) r5.getValue();
        if (r6 == null) goto L21;
        return r6;
    L15:
        r4 = null;
        goto L16
    L9:
        r2 = 0;
        goto L11
    }

    public final String c() {
        w31.c r0 = l();
        if (r0 != null) goto L5;
    L30:
        x11.a r1 = this.a;
        if (r1 == null) goto L42;
        y11.f r2 = r1.G9();
        if (r2 != null) goto L35;
        return "";
    L35:
        return r2.getConnectionType();
    L42:
        return "";
    L5:
        if (r0.n() != true) goto L30;
        com.bytedance.android.live.revlink.impl.multianchor.utils.w r3 = k();
        if (r3 != null) goto L10;
    L19:
        com.bytedance.android.live.revlink.impl.multianchor.utils.w r4 = k();
        if (r4 != null) goto L22;
        return "";
    L22:
        if (r4.d() != true) goto L38;
        f21.a r5 = j();
        if (r5 == null) goto L39;
        String r6 = r5.m;
        if (r6 != null) goto L29;
        return "";
    L29:
        return r6;
    L39:
        return "";
    L38:
        return "";
    L10:
        if (r3.e() != true) goto L19;
        com.bytedance.android.live.revlink.impl.global.c r7 = this.c;
        if (r7 == null) goto L14;
        IPKLinkBizDataService r8 = r7.mk();
    L15:
        if (r8 == null) goto L36;
        r6 = r8.getPkLinkConnectionType();
        if (r6 != null) goto L29;
        return "";
    L36:
        return "";
    L14:
        r8 = null;
        goto L15
    }

    public final String h() {
        com.bytedance.android.live.revlink.impl.multianchor.utils.w r0 = k();
        if (r0 == null) goto L5;
        UILayout r1 = r0.b();
    L7:
        if (r1 != UILayout.Normal) goto L10;
        return "equal";
    L10:
        if (r1 != UILayout.Enlarge) goto L13;
        return "focus";
    L13:
        if (r1 != UILayout.FULL) goto L15;
        return "floating";
    L15:
        return "";
    L5:
        r1 = null;
        goto L7
    }

    public final String o() {
        com.bytedance.android.live.revlink.impl.multianchor.utils.w r0 = k();
        if (r0 == null) goto L5;
        i11.b r1 = r0.a();
    L6:
        com.bytedance.android.livesdk.revenue.service.room.c r2 = this.b;
        if (r2 == null) goto L22;
        com.bytedance.android.livesdk.revenue.room.a r3 = r2.getRoomContext();
        if (r3 == null) goto L22;
        IRoomBase r4 = r3.getCommonRoom();
        if (r4 == null) goto L22;
        IBaseUser r5 = r4.getOwnerKt();
        if (r5 == null) goto L22;
        String r6 = r5.getIdString();
        if (r6 == null) goto L22;
        if (r1 != null) goto L19;
        return DataType.FALSE;
    L19:
        if (r1.N(r6) == false) goto L22;
        return DataType.TRUE;
    L22:
        return DataType.FALSE;
    L5:
        r1 = null;
        goto L6
    }

    public static String e(Integer r4) {
        if (r4 != null) goto L6;
        return "";
    L6:
        if (r4.intValue() != 12) goto L9;
        return "invite_success";
    L9:
        if (r4.intValue() != 0) goto L13;
        return "routine";
    L13:
        if (r4.intValue() != 6) goto L17;
        return "seckill";
    L17:
        if (r4.intValue() != 4) goto L21;
        return "oncemore";
    L21:
        if (r4.intValue() != 11) goto L25;
        return "room_close";
    L25:
        if (r4.intValue() != 8) goto L29;
        return "rtc_disconnect";
    L29:
        if (r4.intValue() != 1) goto L33;
        return "disconnect";
    L33:
        if (r4.intValue() != 13) goto L36;
        return "invite_success";
    L36:
        if (r4.intValue() != 14) goto L39;
        return "switch";
    L39:
        if (r4.intValue() != 16) goto L41;
        return "switch";
    L41:
        return "";
    }

    public final String p(int r5) {
        com.bytedance.android.live.revlink.impl.multianchor.utils.w r0 = k();
        boolean r1 = false;
        if (r0 != null) goto L5;
    L7:
        boolean r2 = false;
    L8:
        com.bytedance.android.live.revlink.impl.multianchor.utils.w r3 = k();
        if (r3 == null) goto L14;
        if (r3.e() != true) goto L14;
        r1 = true;
    L14:
        return q(r5, r2, r1);
    L5:
        if (r0.d() != true) goto L7;
        r2 = true;
        goto L8
    }

    public final void r(Map<String, String> r5) {
        Intrinsics.checkNotNullParameter(r5, "map");
        com.bytedance.android.live.revlink.impl.multianchor.utils.w r0 = k();
        if (r0 != null) goto L5;
    L7:
        r5.put("connection_type", c());
        r5.put("connection_sub_type", b());
    L8:
        r5.put("anchor_connect_status", a());
        return;
    L5:
        if (r0.e() != true) goto L7;
        r5.put("connection_type", c());
        r5.put("connection_sub_type", "");
        goto L8
    }

    public d(com.bytedance.android.livesdk.revenue.service.room.c r1, LinkFakeGlobalService r2) {
        this.b = r1;
        this.c = r2;
    }

    public final String q(int r6, boolean r7, boolean r8) {
        if (r7 == false) goto L52;
        com.bytedance.android.live.revlink.impl.global.c r9 = this.c;
        if (r9 == null) goto L7;
        com.bytedance.android.live.revlink.impl.multianchor.vm.b r10 = r9.rb();
    L8:
        if (r10 == null) goto L66;
        com.bytedance.android.live.revlink.impl.global.c r12 = this.c;
        if (r12 == null) goto L12;
        com.bytedance.android.live.revlink.impl.multianchor.vm.b r13 = r12.rb();
    L13:
        boolean r14 = false;
        if (r13 == null) goto L20;
        com.bytedance.live.datacontext.m<Integer> r15 = r13.getInviteType();
        if (r15 == null) goto L20;
        Integer r16 = (Integer) r15.getValue();
        if (r16 == null) goto L20;
        int r17 = r16.intValue();
    L21:
        f21.a r18 = j();
        if (r18 == null) goto L66;
        if (r17 != 13) goto L39;
        com.bytedance.android.live.revlink.impl.global.c r19 = this.c;
        if (r19 == null) goto L28;
        com.bytedance.android.live.revlink.impl.multianchor.utils.q r20 = r19.getMultiAnchorLinkLogUtils();
    L29:
        if (r20 == null) goto L31;
        String r22 = r20.F(r18.l);
    L33:
        if (Intrinsics.areEqual(r22, "inviter") == true) goto L64;
        if (r17 == 101) goto L51;
        if (r17 != 102) goto L68;
    L50:
        return "recommend";
    L68:
        return UserListInviteType.a(r17, null);
    L51:
        return "mutual_follow";
    L64:
        return "active";
    L31:
        r22 = null;
        goto L33
    L28:
        r20 = null;
        goto L29
    L39:
        if (x.a(r18.d) == false) goto L42;
        return "random";
    L42:
        if (r18.d == 1) goto L45;
        r14 = r18.a;
    L45:
        if (r14 == true) goto L64;
        if (r17 == 101) goto L51;
        if (r17 == 102) goto L50;
        return UserListInviteType.a(r17, null);
    L20:
        r17 = 0;
        goto L21
    L12:
        r13 = null;
    L66:
        return "";
    L7:
        r10 = null;
        goto L8
    L52:
        if (r8 == false) goto L66;
        w31.c r23 = l();
        if (r23 == null) goto L56;
        IPKLinkBizDataService r24 = r23.g();
    L57:
        if (r24 == null) goto L74;
        w31.c r25 = l();
        if (r25 == null) goto L74;
        IPKLinkBizDataService r26 = r25.g();
        if (r26 == null) goto L74;
        if (r26.getIsRealOrganizer() == true) goto L64;
    L74:
        return UserListInviteType.a(r6, null);
    L56:
        r24 = null;
        goto L57
    }
}
