package com.bytedance.android.live.revlink.impl.multianchor.utils;

import androidx.lifecycle.LiveData;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.link.constants.UserListInviteType;
import com.bytedance.android.live.profile.monitor.DataType;
import com.bytedance.android.live.revlink.impl.LinkCrossRoomDataHolder;
import com.bytedance.android.live.revlink.impl.global.LinkFakeGlobalService;
import com.bytedance.android.live.revlink.impl.mergepk.pkbase.statemachine.PkBaseStateMachine;
import com.bytedance.android.live.revlink.impl.multianchor.pk.datacontext.MultiCommonPkDataContext;
import com.bytedance.android.live.revlink.impl.multianchor.ui.UILayout;
import com.bytedance.android.live.revlink.impl.pk.service.IPKLinkBizDataService;
import com.bytedance.android.live.saas.middleware.fresco.DefaultConfig;
import com.bytedance.android.livesdk.link.model.IAnchorUpdateLayoutContent;
import com.bytedance.android.livesdk.link.model.IRivalExtraInfo;
import com.bytedance.android.livesdk.link.model.api.IBaseBattleSetting;
import com.bytedance.android.livesdk.link.model.d6;
import com.bytedance.android.livesdk.link.model.h3;
import com.bytedance.android.livesdk.link.model.m2;
import com.bytedance.android.livesdk.link.model.n3;
import com.bytedance.android.livesdk.link.model.o2;
import com.bytedance.android.livesdk.link.model.p0;
import com.bytedance.android.livesdk.link.model.v3;
import com.bytedance.android.livesdk.revenue.log.LogCommon;
import com.bytedance.android.livesdk.revenue.log.LogCommonInstance;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.IRoomBase;
import com.bytedance.android.livesdkapi.depend.model.live.IRoomKtKt;
import com.bytedance.android.livesdkapi.depend.model.live.IRoomKt_androidKt;
import com.bytedance.ies.sdk.widgets.NextLiveData;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Deprecated;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class q {
    public x11.a a;
    public final ld.a b;
    public final com.bytedance.android.livesdk.revenue.service.room.c c;
    public final com.bytedance.android.live.revlink.impl.global.c d;

    public final LinkCrossRoomDataHolder f() {
        com.bytedance.android.live.revlink.impl.global.c r0 = this.d;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getLinkCrossRoomDataHolder();
    }

    public final com.bytedance.android.live.revlink.impl.multianchor.vm.g g() {
        com.bytedance.android.live.revlink.impl.global.c r0 = this.d;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getMultiAnchorLinkContextObj();
    }

    public final com.bytedance.android.live.revlink.impl.multianchor.service.d h() {
        com.bytedance.android.live.revlink.impl.global.c r0 = this.d;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.R8();
    }

    public final w i() {
        com.bytedance.android.live.revlink.impl.global.c r0 = this.d;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getMultiLinkUtil();
    }

    public final com.bytedance.android.live.revlink.impl.mergepk.pkbase.e j() {
        com.bytedance.android.live.revlink.impl.global.c r0 = this.d;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.Ig();
    }

    public final w31.c k() {
        com.bytedance.android.live.revlink.impl.global.c r0 = this.d;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getPkLinkUtils();
    }

    public final com.bytedance.android.live.revlink.impl.utils.s l() {
        com.bytedance.android.live.revlink.impl.global.c r0 = this.d;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getRevLinkCommonUtil();
    }

    public final d31.d m() {
        com.bytedance.android.live.revlink.impl.global.c r0 = this.d;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getRevLinkLogHelper();
    }

    public final String n() {
        com.bytedance.android.live.revlink.impl.global.c r0 = this.d;
        String r1 = null;
        if (r0 == null) goto L5;
        MultiCommonPkDataContext r2 = r0.uk();
    L6:
        if (r2 == null) goto L11;
        j31.a r3 = r2.getStartParam();
        if (r3 == null) goto L11;
        Map<String, Long> r4 = r3.j;
        if (r4 == null) goto L11;
    L12:
        int r5 = com.bytedance.android.live.revlink.impl.multianchor.pk.c.a;
        com.bytedance.android.live.revlink.impl.utils.s r6 = l();
        if (r6 == null) goto L15;
        r1 = r6.e();
    L15:
        Pair r7 = com.bytedance.android.live.revlink.impl.multianchor.pk.c.a(r1, r4);
        List r8 = (List) r7.component1();
        List r9 = (List) r7.component2();
        StringBuilder r10 = new StringBuilder();
        r10.append(r8.size());
        r10.append('V');
        r10.append(r9.size());
        return r10.toString();
    L11:
        r4 = MapsKt.emptyMap();
        goto L12
    L5:
        r2 = null;
        goto L6
    }

    public final void z() {
        LinkedHashMap r0 = new LinkedHashMap();
        com.bytedance.android.live.revlink.impl.utils.s r1 = l();
        if (r1 != null) goto L5;
    L7:
        String r2 = DataType.FALSE;
    L8:
        r0.put("is_anchor", r2);
        com.bytedance.android.live.revlink.impl.mergepk.pkbase.e r3 = j();
        if (r3 != null) goto L11;
    L13:
        String r4 = "connection";
    L14:
        r0.put("linkmic_status", r4);
        mz0.n r5 = new mz0.n();
        Map<String, String> r6 = r5.a;
        Intrinsics.checkNotNullParameter(r6, "map");
        Intrinsics.checkNotNullParameter(r0, "map");
        r6.putAll(r0);
        mz0.m r7 = new mz0.m();
        r7.b(LogCommon.ROOM);
        List<Object> r8 = r5.b;
        ArrayList r9 = (ArrayList) r8;
        r9.addAll(r7.a);
        cy0.e.a.getClass();
        cy0.j r10 = cy0.e.a.a;
        com.bytedance.android.scope.m.e.getClass();
        Object r12 = com.bytedance.android.scope.m.b(r10).a(Reflection.getOrCreateKotlinClass(mz0.i.class));
        Intrinsics.checkNotNull(r12);
        ((mz0.i) ((f80.a) r12)).w3("livesdk_revenue_interact_feedback_show", r5.a, r5.b);
        return;
    L11:
        if (r3.isBattleShow() != true) goto L13;
        r4 = "play";
        goto L14
    L5:
        if (r1.b() != true) goto L7;
        r2 = DataType.TRUE;
        goto L8
    }

    public final String b() {
        w r0 = i();
        if (r0 != null) goto L5;
    L7:
        w r1 = i();
        if (r1 == null) goto L12;
        i11.b r2 = r1.a();
        if (r2 == null) goto L12;
        int r3 = r2.c();
    L14:
        return String.valueOf(r3);
    L12:
        r3 = 0;
        goto L14
    L5:
        if (r0.e() != true) goto L7;
        r3 = 2;
        goto L14
    }

    @Deprecated(message = "replace with RevLinkLogHelper")
    public final String c() {
        w r0 = i();
        if (r0 != null) goto L5;
    L12:
        com.bytedance.android.livesdk.revenue.service.room.c r1 = this.c;
        if (r1 == null) goto L19;
        com.bytedance.android.livesdk.revenue.room.a r2 = r1.getRoomContext();
        if (r2 == null) goto L19;
        if (r2.getCommonIsAnchor() != true) goto L19;
        boolean r3 = true;
    L20:
        String r4 = "link";
        if (r3 == true) goto L28;
        com.bytedance.android.live.revlink.impl.mergepk.pkbase.e r5 = j();
        if (r5 != null) goto L25;
        return "link";
    L25:
        if (r5.isBattleShow() != true) goto L43;
        return "pk";
    L43:
        return "link";
    L28:
        com.bytedance.android.live.revlink.impl.multianchor.vm.g r6 = g();
        if (r6 != null) goto L31;
    L33:
        String r7 = "manual";
    L34:
        com.bytedance.android.live.revlink.impl.mergepk.pkbase.e r8 = j();
        if (r8 == null) goto L40;
        if (r8.isBattleShow() != true) goto L40;
        r4 = "npk";
    L40:
        return r7 + '_' + r4;
    L31:
        if (r6.d() != 4) goto L33;
        r7 = "random";
    L19:
        r3 = false;
        goto L20
    L5:
        if (r0.e() != true) goto L12;
        LinkCrossRoomDataHolder r9 = f();
        if (r9 == null) goto L10;
        String r10 = r9.d();
        if (r10 == null) goto L10;
        return r10;
    L10:
        return "";
    }

    public final String d() {
        w r0 = i();
        if (r0 != null) goto L5;
    L17:
        w r1 = i();
        if (r1 == null) goto L57;
        i11.b r2 = r1.a();
        if (r2 == null) goto L58;
        List<com.bytedance.android.livesdk.link.model.p> r3 = r2.getOnlineUserList();
        if (r3 == null) goto L59;
        List<com.bytedance.android.livesdk.link.model.p> r4 = r3;
        ArrayList r5 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r4, 10));
        Iterator<T> r6 = r4.iterator();
    L24:
        String r7 = null;
        if (r6.hasNext() == false) goto L30;
        IBaseUser r8 = ((com.bytedance.android.livesdk.link.model.p) r6.next()).getUser();
        if (r8 == null) goto L29;
        r7 = r8.getIdString();
    L29:
        r5.add(r7);
        goto L24
    L30:
        ArrayList r9 = new ArrayList();
        Iterator r10 = r5.iterator();
    L32:
        if (r10.hasNext() == false) goto L40;
        Object r12 = r10.next();
        String r13 = (String) r12;
        com.bytedance.android.live.revlink.impl.utils.s r14 = l();
        if (r14 == null) goto L36;
        String r15 = r14.e();
    L38:
        if ((!Intrinsics.areEqual(r13, r15)) == false) goto L32;
        r9.add(r12);
        goto L32
    L36:
        r15 = null;
        goto L38
    L40:
        String r16 = CollectionsKt.joinToString$default(r9, ",", null, null, 0, null, null, 62, null);
        if (r16 != null) goto L44;
        return "";
    L44:
        return r16;
    L59:
        return "";
    L58:
        return "";
    L57:
        return "";
    L5:
        if (r0.e() != true) goto L17;
        x11.a r17 = this.a;
        if (r17 == null) goto L53;
        y11.d r18 = r17.getPkService();
        if (r18 == null) goto L54;
        IBaseUser r19 = r18.c();
        if (r19 == null) goto L55;
        String r20 = r19.getIdString();
        if (r20 != null) goto L16;
        return "";
    L16:
        return r20;
    L55:
        return "";
    L54:
        return "";
    L53:
        return "";
    }

    public final String p() {
        w r0 = i();
        if (r0 != null) goto L5;
    L7:
        w r1 = i();
        if (r1 != null) goto L10;
    L12:
        return "live";
    L10:
        if (r1.e() != true) goto L12;
        return "pk";
    L5:
        if (r0.d() != true) goto L7;
        return "anchor";
    }

    public static String e(m2 r1) {
        if (r1 != null) goto L4;
        return "live";
    L4:
        if (o2.a(r1) == true) goto L6;
        return "live";
    L6:
        if (r1.getRoomScene() != 1) goto L9;
        return "pk";
    L9:
        return "anchor";
    }

    public final void B(boolean r9) {
        LinkedHashMap r0 = new LinkedHashMap();
        cy0.e.a.getClass();
        cy0.j r2 = cy0.e.a.a;
        com.bytedance.android.scope.m.e.getClass();
        Object r1 = com.bytedance.android.scope.m.b(r2).b(er2.b.class);
        Intrinsics.checkNotNull(r1);
        iq2.b r3 = ((com.bytedance.live.kmp.core.c) r1).getChorusService();
        w31.c r4 = k();
        if (r4 == null) goto L5;
        Map<String, String> r5 = r4.f();
    L6:
        r0.putAll(r5);
        d31.d r6 = m();
        String r7 = "";
        if (r6 == null) goto L9;
        String r8 = r6.c();
    L10:
        r0.put("connection_type", r8);
        x11.a r10 = this.a;
        if (r10 == null) goto L16;
        y11.f r12 = r10.G9();
        if (r12 == null) goto L16;
        String r13 = r12.getLinkAnchorCount();
        if (r13 == null) goto L16;
    L17:
        r0.put("anchor_cnt", r13);
        if (r9 == false) goto L20;
        String r14 = "open";
    L21:
        r0.put("mute_type", r14);
        com.bytedance.android.live.revlink.impl.multianchor.service.d r15 = h();
        if (r15 == null) goto L27;
        i11.b r16 = r15.getLinkUserCenter();
        if (r16 == null) goto L27;
        String r17 = String.valueOf(r16.c());
        if (r17 == null) goto L27;
    L28:
        r0.put("anchor_connect_status", r17);
        com.bytedance.android.live.revlink.impl.global.c r18 = this.d;
        if (r18 == null) goto L31;
        com.bytedance.android.live.revlink.impl.multianchor.dialog.linkopt.f r19 = r18.getLinkPlayHelper();
    L33:
        if (r19 != null) goto L35;
    L37:
        String r20 = "connection";
    L38:
        r0.put("room_status", r20);
        if (r3 != null) goto L41;
    L43:
        String r22 = DataType.FALSE;
    L44:
        r0.put("if_chorus", r22);
        if (r3 != null) goto L47;
    L62:
        mz0.n r23 = new mz0.n();
        Map<String, String> r24 = r23.a;
        Intrinsics.checkNotNullParameter(r24, "map");
        Intrinsics.checkNotNullParameter(r0, "map");
        r24.putAll(r0);
        mz0.m r25 = new mz0.m();
        LinkCrossRoomDataHolder r26 = f();
        if (r26 == null) goto L65;
        r26.a(r25);
    L65:
        r25.b(LogCommon.ROOM);
        r25.b(LogCommon.PAGE_SOURCE_LOG);
        List<Object> r27 = r23.b;
        ArrayList r28 = (ArrayList) r27;
        r28.addAll(r25.a);
        Object r29 = com.bytedance.android.scope.m.b(r2).a(Reflection.getOrCreateKotlinClass(mz0.i.class));
        Intrinsics.checkNotNull(r29);
        ((mz0.i) ((f80.a) r29)).w3("livesdk_pk_mute_button_click", r23.a, r23.b);
        return;
    L47:
        if (r3.e() != true) goto L62;
        String r30 = "leader";
        if (r3.d() != 1) goto L51;
        Object r32 = "leader";
    L52:
        r0.put("chorus_role_type", r32);
        if (r3.d() != 1) goto L55;
        r30 = "follower";
    L55:
        r0.put("chorus_right_role_type", r30);
        com.bytedance.android.live.liveinteract.model.a r33 = r3.c();
        if (r33 == null) goto L61;
        String r34 = String.valueOf(r33.getChorusId());
        if (r34 == null) goto L61;
        r7 = r34;
    L61:
        r0.put("chorus_id", r7);
        goto L62
    L51:
        r32 = "follower";
        goto L52
    L41:
        if (r3.e() != true) goto L43;
        r22 = DataType.TRUE;
        goto L44
    L35:
        if (r19.g() != true) goto L37;
        r20 = "pk";
        goto L38
    L31:
        r19 = null;
    L27:
        r17 = "2";
        goto L28
    L20:
        r14 = "close";
    L16:
        r13 = "";
        goto L17
    L9:
        r8 = "";
        goto L10
    L5:
        r5 = MapsKt.emptyMap();
        goto L6
    }

    public final String F(int r6) {
        com.bytedance.android.live.revlink.impl.multianchor.vm.g r0 = g();
        if (r0 == null) goto L5;
        Integer r1 = Integer.valueOf(r0.b());
    L7:
        if (r6 != 1) goto L9;
        if (r1 != null) goto L25;
    L28:
        return "inviter";
    L25:
        if (r1.intValue() != 13) goto L28;
        return "invitee";
    L9:
        if (r6 != 2) goto L11;
        return "inviter_follow";
    L11:
        if (r6 != 3) goto L13;
        if (r1 != null) goto L19;
        return "invitee";
    L19:
        if (r1.intValue() == 13) goto L28;
        return "invitee";
    L13:
        if (r6 == 4) goto L15;
        return "";
    L15:
        return "invitee_follow";
    L5:
        r1 = null;
        goto L7
    }

    public final void a(String r7, String r8) {
        Intrinsics.checkNotNullParameter(r7, "changeContent");
        Intrinsics.checkNotNullParameter(r8, "switch");
        LinkedHashMap r1 = new LinkedHashMap();
        d31.d r2 = m();
        if (r2 == null) goto L5;
        Map<String, String> r3 = r2.i();
    L6:
        r1.putAll(r3);
        LinkCrossRoomDataHolder r4 = f();
        Long r5 = null;
        if (r4 == null) goto L9;
        Long r6 = Long.valueOf(r4.c());
    L10:
        r1.put("channel_id", String.valueOf(r6));
        w31.c r9 = k();
        if (r9 == null) goto L13;
        r5 = Long.valueOf(r9.i());
    L13:
        r1.put("pk_id", String.valueOf(r5));
        d31.d r10 = m();
        if (r10 == null) goto L16;
        r10.r(r1);
    L16:
        r1.put("connection_anchor_cnt", b());
        r1.put("change_content", r7);
        r1.put("switch", r8);
        mz0.n r12 = new mz0.n();
        Map<String, String> r13 = r12.a;
        Intrinsics.checkNotNullParameter(r13, "map");
        Intrinsics.checkNotNullParameter(r1, "map");
        r13.putAll(r1);
        mz0.m r14 = new mz0.m();
        r14.b(LogCommon.ROOM);
        ((ArrayList) r12.b).addAll(r14.a);
        cy0.e.a.getClass();
        cy0.j r15 = cy0.e.a.a;
        com.bytedance.android.scope.m.e.getClass();
        Object r16 = com.bytedance.android.scope.m.b(r15).a(Reflection.getOrCreateKotlinClass(mz0.i.class));
        Intrinsics.checkNotNull(r16);
        ((mz0.i) ((f80.a) r16)).w3("livesdk_connection_manage_setting_change", r12.a, r12.b);
        return;
    L9:
        r6 = null;
        goto L10
    L5:
        r3 = MapsKt.emptyMap();
        goto L6
    }

    public final void q(String r7, String r8) {
        Intrinsics.checkNotNullParameter(r8, "choice");
        LinkedHashMap r1 = new LinkedHashMap();
        w31.c r2 = k();
        if (r2 == null) goto L5;
        Map<String, String> r3 = r2.f();
    L6:
        r1.putAll(r3);
        com.bytedance.android.live.revlink.impl.multianchor.vm.g r4 = g();
        Long r5 = null;
        if (r4 == null) goto L9;
        Long r6 = Long.valueOf(r4.a());
    L10:
        r1.put("channel_id", String.valueOf(r6));
        w31.c r9 = k();
        if (r9 == null) goto L13;
        r5 = Long.valueOf(r9.i());
    L13:
        r1.put("pk_id", String.valueOf(r5));
        d31.d r10 = m();
        if (r10 == null) goto L16;
        r10.r(r1);
    L16:
        r1.put("to_anchor_id", String.valueOf(r7));
        r1.put("connection_anchor_cnt", b());
        r1.put("choice", r8);
        mz0.n r12 = new mz0.n();
        Map<String, String> r13 = r12.a;
        Intrinsics.checkNotNullParameter(r13, "map");
        Intrinsics.checkNotNullParameter(r1, "map");
        r13.putAll(r1);
        mz0.m r14 = new mz0.m();
        r14.b(LogCommon.ROOM);
        ((ArrayList) r12.b).addAll(r14.a);
        cy0.e.a.getClass();
        cy0.j r15 = cy0.e.a.a;
        com.bytedance.android.scope.m.e.getClass();
        Object r16 = com.bytedance.android.scope.m.b(r15).a(Reflection.getOrCreateKotlinClass(mz0.i.class));
        Intrinsics.checkNotNull(r16);
        ((mz0.i) ((f80.a) r16)).w3("livesdk_connection_kickout_comfirm", r12.a, r12.b);
        return;
    L9:
        r6 = null;
        goto L10
    L5:
        r3 = MapsKt.emptyMap();
        goto L6
    }

    public final void t(String r7, String r8) {
        Intrinsics.checkNotNullParameter(r7, "buttonType");
        Intrinsics.checkNotNullParameter(r8, "source");
        LinkedHashMap r1 = new LinkedHashMap();
        w31.c r2 = k();
        if (r2 == null) goto L5;
        Map<String, String> r3 = r2.f();
    L6:
        r1.putAll(r3);
        com.bytedance.android.live.revlink.impl.multianchor.vm.g r4 = g();
        Long r5 = null;
        if (r4 == null) goto L9;
        Long r6 = Long.valueOf(r4.a());
    L10:
        r1.put("channel_id", String.valueOf(r6));
        w31.c r9 = k();
        if (r9 == null) goto L13;
        r5 = Long.valueOf(r9.i());
    L13:
        r1.put("pk_id", String.valueOf(r5));
        d31.d r10 = m();
        if (r10 == null) goto L16;
        r10.r(r1);
    L16:
        r1.put("connection_anchor_cnt", b());
        w r12 = i();
        if (r12 != null) goto L19;
    L21:
        String r13 = DataType.FALSE;
    L22:
        r1.put("is_manager", r13);
        r1.put("button_type", r7);
        r1.put("source", r8);
        mz0.n r14 = new mz0.n();
        Map<String, String> r15 = r14.a;
        Intrinsics.checkNotNullParameter(r15, "map");
        Intrinsics.checkNotNullParameter(r1, "map");
        r15.putAll(r1);
        mz0.m r16 = new mz0.m();
        r16.b(LogCommon.ROOM);
        ((ArrayList) r14.b).addAll(r16.a);
        cy0.e.a.getClass();
        cy0.j r17 = cy0.e.a.a;
        com.bytedance.android.scope.m.e.getClass();
        Object r18 = com.bytedance.android.scope.m.b(r17).a(Reflection.getOrCreateKotlinClass(mz0.i.class));
        Intrinsics.checkNotNull(r18);
        ((mz0.i) ((f80.a) r18)).w3("livesdk_connection_self_manage_banner_click", r14.a, r14.b);
        return;
    L19:
        if (w.f(r12) != true) goto L21;
        r13 = DataType.TRUE;
        goto L22
    L9:
        r6 = null;
        goto L10
    L5:
        r3 = MapsKt.emptyMap();
        goto L6
    }

    public final void w(com.bytedance.android.live.revlink.impl.pk.service.j r4, String r5) {
        Intrinsics.checkNotNullParameter(r4, "autoMatchParams");
        Intrinsics.checkNotNullParameter(r5, "clickResult");
        LinkedHashMap r0 = new LinkedHashMap();
        r0.put("source", r4.c);
        r0.put("click_result", r5);
        d31.d r6 = m();
        if (r6 == null) goto L5;
        String r7 = r6.s();
    L6:
        r0.put("room_status", r7);
        com.bytedance.android.live.revlink.impl.utils.s r8 = l();
        if (r8 == null) goto L9;
        String r9 = r8.e();
    L10:
        r0.put("anchor_id", String.valueOf(r9));
        r0.put("activity_name", r4.b);
        r0.put("click_type", "start");
        r0.put("open_game_app_id", r4.g);
        mz0.n r10 = new mz0.n();
        Map<String, String> r12 = r10.a;
        Intrinsics.checkNotNullParameter(r12, "map");
        Intrinsics.checkNotNullParameter(r0, "map");
        r12.putAll(r0);
        mz0.m r13 = new mz0.m();
        r13.b(LogCommon.ROOM);
        LinkCrossRoomDataHolder r1 = f();
        if (r1 == null) goto L13;
        r1.m(r13);
    L13:
        List<Object> r2 = r10.b;
        ArrayList r3 = (ArrayList) r2;
        r3.addAll(r13.a);
        cy0.e.a.getClass();
        cy0.j r14 = cy0.e.a.a;
        com.bytedance.android.scope.m.e.getClass();
        Object r15 = com.bytedance.android.scope.m.b(r14).a(Reflection.getOrCreateKotlinClass(mz0.i.class));
        Intrinsics.checkNotNull(r15);
        ((mz0.i) ((f80.a) r15)).w3("livesdk_cohost_game_start_guide_page_click_result", r10.a, r10.b);
        return;
    L9:
        r9 = null;
        goto L10
    L5:
        r7 = "";
        goto L6
    }

    public q(ld.a r1, com.bytedance.android.livesdk.revenue.service.room.c r2, LinkFakeGlobalService r3) {
        this.b = r1;
        this.c = r2;
        this.d = r3;
    }

    public static String D(boolean r1, int r2, boolean r3) {
        if (x.a(r2) == false) goto L7;
        return "triple";
    L7:
        if (x.b(r2) == false) goto L11;
        return "random_nlink";
    L11:
        if (r2 != 4) goto L13;
    L16:
        boolean r0 = true;
    L17:
        if (r0 == true) goto L19;
        if (r1 == false) goto L26;
        return "double";
    L26:
        if (r3 == false) goto L29;
        return "n_invite";
    L29:
        return "single";
    L19:
        if (x.d(r2) == false) goto L21;
        return "random_team";
    L21:
        return "random_double";
    L13:
        if (r2 == 6) goto L16;
        r0 = false;
        goto L17
    }

    public final void A(String r8, String r9, boolean r10) {
        Intrinsics.checkNotNullParameter(r9, "requestPage");
        LinkedHashMap r0 = new LinkedHashMap();
        w31.c r1 = k();
        if (r1 == null) goto L5;
        Map<String, String> r2 = r1.f();
    L6:
        r0.putAll(r2);
        com.bytedance.android.live.revlink.impl.utils.s r3 = l();
        String r4 = DataType.TRUE;
        if (r3 != null) goto L9;
    L11:
        Object r5 = DataType.FALSE;
    L12:
        r0.put("is_anchor", r5);
        r0.put("to_user_id", String.valueOf(r8));
        x11.a r6 = this.a;
        if (r6 == null) goto L18;
        y11.f r7 = r6.G9();
        if (r7 == null) goto L18;
        String r12 = r7.getLinkAnchorCount();
        if (r12 == null) goto L18;
    L19:
        r0.put("anchor_cnt", r12);
        ld.a r13 = this.b;
        IPKLinkBizDataService r14 = null;
        if (r13 == null) goto L24;
        NextLiveData r15 = r13.isCleanMode();
        if (r15 == null) goto L24;
        Boolean r16 = (Boolean) r15.getValue();
    L26:
        if (Intrinsics.areEqual(r16, Boolean.TRUE) == true) goto L29;
        r4 = DataType.FALSE;
    L29:
        r0.put("if_clear_mode", r4);
        r0.put("request_page", r9);
        if (r10 == false) goto L32;
        String r17 = "livesdk_follow";
    L33:
        com.bytedance.android.livesdk.revenue.service.room.c r18 = this.c;
        if (r18 == null) goto L40;
        com.bytedance.android.livesdk.revenue.room.a r19 = r18.getRoomContext();
        if (r19 == null) goto L40;
        if (r19.getCommonIsAnchor() != true) goto L40;
        String r110 = "anchor_to_anchor";
    L41:
        mz0.n r20 = new mz0.n();
        Map<String, String> r22 = r20.a;
        Intrinsics.checkNotNullParameter(r22, "map");
        Intrinsics.checkNotNullParameter(r0, "map");
        r22.putAll(r0);
        com.bytedance.android.live.revlink.impl.global.c r23 = this.d;
        if (r23 == null) goto L44;
        r14 = r23.mk();
    L44:
        if (r14 == null) goto L47;
        Map<String, String> r24 = r14.getFollowExtraParams(r8);
        if (r24 == null) goto L47;
    L48:
        Intrinsics.checkNotNullParameter(r24, "map");
        r22.putAll(r24);
        mz0.m r25 = new mz0.m();
        com.bytedance.android.livesdk.revenue.log.g r26 = vh6.c.b(kr2.a.class).K7();
        Intrinsics.checkNotNullParameter(r26, "followLog");
        r26.d();
        Intrinsics.checkNotNullParameter("multi_window", "scene");
        Intrinsics.checkNotNullParameter(r110, "followTarget");
        Intrinsics.checkNotNullParameter(DataType.FALSE, "isCurrentAnchor");
        r26.a("multi_window", r110, DataType.FALSE);
        ((ArrayList) r25.a).add(r26.a);
        r25.b(LogCommon.ROOM);
        r25.b(LogCommon.PAGE_SOURCE_LOG);
        r25.b(LogCommon.LIVE_SHARE_LOG);
        r25.b(LogCommon.RECOMMEND_SOURCE_LOG);
        r25.c(LogCommonInstance.LIVE_AD_LOG);
        r25.b(LogCommon.LIVE_END_PAGE_LOG);
        ((ArrayList) r20.b).addAll(r25.a);
        cy0.e.a.getClass();
        cy0.j r27 = cy0.e.a.a;
        com.bytedance.android.scope.m.e.getClass();
        Object r28 = com.bytedance.android.scope.m.b(r27).a(Reflection.getOrCreateKotlinClass(mz0.i.class));
        Intrinsics.checkNotNull(r28);
        ((mz0.i) ((f80.a) r28)).w3(r17, r20.a, r20.b);
        return;
    L47:
        r24 = MapsKt.emptyMap();
    L40:
        r110 = "audience_to_anchor";
        goto L41
    L32:
        r17 = "livesdk_unfollow";
    L24:
        r16 = null;
    L18:
        r12 = "";
        goto L19
    L9:
        if (r3.b() != true) goto L11;
        r5 = DataType.TRUE;
        goto L12
    L5:
        r2 = MapsKt.emptyMap();
        goto L6
    }

    public final void C(UILayout r8, String r9, String r10) {
        Intrinsics.checkNotNullParameter(r8, "uiLayout");
        LinkedHashMap r0 = new LinkedHashMap();
        d31.d r1 = m();
        if (r1 == null) goto L5;
        Map<String, String> r2 = r1.i();
    L6:
        r0.putAll(r2);
        com.bytedance.android.live.revlink.impl.multianchor.vm.g r3 = g();
        String r4 = null;
        if (r3 == null) goto L9;
        Long r5 = Long.valueOf(r3.a());
    L10:
        r0.put("channel_id", String.valueOf(r5));
        com.bytedance.android.live.revlink.impl.utils.s r6 = l();
        if (r6 == null) goto L13;
        String r7 = r6.e();
    L14:
        r0.put("user_id", String.valueOf(r7));
        w31.c r12 = k();
        if (r12 == null) goto L17;
        Long r13 = Long.valueOf(r12.i());
    L18:
        r0.put("pk_id", String.valueOf(r13));
        d31.d r14 = m();
        if (r14 == null) goto L21;
        r14.r(r0);
    L21:
        com.bytedance.android.live.revlink.impl.utils.s r15 = l();
        String r16 = DataType.TRUE;
        if (r15 != null) goto L24;
    L26:
        String r17 = DataType.FALSE;
    L27:
        r0.put("is_anchor", r17);
        UILayout r18 = UILayout.Enlarge;
        if (r8 != r18) goto L30;
        r0.put("enlarge_anchor_id", String.valueOf(r9));
    L30:
        com.bytedance.android.live.revlink.impl.utils.s r19 = l();
        if (r19 != null) goto L33;
    L83:
        w31.c r20 = k();
        if (r20 != null) goto L86;
    L90:
        w31.c r22 = k();
        if (r22 == null) goto L93;
        String r23 = r22.c();
    L94:
        r0.put("inviter_id", String.valueOf(r23));
        w31.c r24 = k();
        if (r24 == null) goto L97;
        r4 = r24.c();
    L97:
        r0.put("invitee_id", String.valueOf(r4));
        if (r8 != r18) goto L101;
        String r25 = "focus";
    L104:
        r0.put("enlarge_type", r25);
        int r26 = p.a[r8.ordinal()];
        if (r26 == 1) goto L108;
        if (r26 == 2) goto L108;
        String r27 = "livesdk_connection_average_display";
    L109:
        mz0.n r28 = new mz0.n();
        Map<String, String> r110 = r28.a;
        Intrinsics.checkNotNullParameter(r110, "map");
        Intrinsics.checkNotNullParameter(r0, "map");
        r110.putAll(r0);
        mz0.m r111 = new mz0.m();
        r111.b(LogCommon.ROOM);
        r111.b(LogCommon.PAGE_SOURCE_LOG);
        ((ArrayList) r28.b).addAll(r111.a);
        cy0.e.a.getClass();
        cy0.j r112 = cy0.e.a.a;
        com.bytedance.android.scope.m.e.getClass();
        Object r113 = com.bytedance.android.scope.m.b(r112).a(Reflection.getOrCreateKotlinClass(mz0.i.class));
        Intrinsics.checkNotNull(r113);
        ((mz0.i) ((f80.a) r113)).w3(r27, r28.a, r28.b);
        return;
    L108:
        r27 = "livesdk_connection_enlarge_display";
        goto L109
    L101:
        if (r8 != UILayout.FULL) goto L103;
        r25 = "floating";
        goto L104
    L103:
        r25 = "";
    L93:
        r23 = null;
        goto L94
    L86:
        if (r20.e() != true) goto L90;
        com.bytedance.android.live.revlink.impl.utils.s r29 = l();
        if (r29 == null) goto L93;
        r23 = r29.e();
        goto L94
    L33:
        if (r19.b() != true) goto L83;
        if (r10 != null) goto L39;
        com.bytedance.android.live.revlink.impl.utils.s r30 = l();
        if (r30 == null) goto L38;
        r10 = r30.e();
        goto L39
    L38:
        r10 = null;
    L39:
        r0.put("operator_id", String.valueOf(r10));
        com.bytedance.android.live.revlink.impl.global.c r32 = this.d;
        if (r32 == null) goto L42;
        com.bytedance.android.live.revlink.impl.multianchor.ui.g r33 = r32.n9();
    L43:
        if (r33 == null) goto L46;
        IAnchorUpdateLayoutContent.UpdateAnchorLayoutType r34 = r33.getUpdateType();
        if (r34 == null) goto L46;
    L47:
        int r35 = p.b[r34.ordinal()];
        if (r35 == 1) goto L60;
        if (r35 != 2) goto L59;
        if (r8 == r18) goto L60;
        if (r8 == UILayout.FULL) goto L60;
        w r36 = i();
        if (r36 == null) goto L60;
        if (w.f(r36) != true) goto L60;
    L59:
        String r37 = DataType.TRUE;
    L61:
        r0.put("is_change", r37);
        com.bytedance.android.live.revlink.impl.global.c r38 = this.d;
        if (r38 == null) goto L64;
        com.bytedance.android.live.revlink.impl.multianchor.ui.g r39 = r38.n9();
    L65:
        if (r39 == null) goto L68;
        IAnchorUpdateLayoutContent.AnchorLayoutRange r40 = r39.a();
        if (r40 == null) goto L68;
    L69:
        int r42 = p.c[r40.ordinal()];
        if (r42 == 1) goto L75;
        if (r42 != 2) goto L74;
        String r43 = "all";
    L76:
        r0.put("operate_type", r43);
        w r44 = i();
        if (r44 != null) goto L79;
    L81:
        r16 = DataType.FALSE;
    L82:
        r0.put("is_manager", r16);
        goto L83
    L79:
        if (w.f(r44) != true) goto L81;
    L74:
        throw new NoWhenBranchMatchedException();
    L75:
        r43 = "self";
    L68:
        r40 = IAnchorUpdateLayoutContent.AnchorLayoutRange.AnchorLayoutRangeMyRoom;
        goto L69
    L64:
        r39 = null;
    L60:
        r37 = DataType.FALSE;
    L46:
        r34 = IAnchorUpdateLayoutContent.UpdateAnchorLayoutType.UpdateAnchorLayoutTypeUnknown;
        goto L47
    L42:
        r33 = null;
        goto L43
    L24:
        if (r15.b() != true) goto L26;
        r17 = DataType.TRUE;
        goto L27
    L17:
        r13 = null;
        goto L18
    L13:
        r7 = null;
        goto L14
    L9:
        r5 = null;
        goto L10
    L5:
        r2 = MapsKt.emptyMap();
        goto L6
    }

    public final void r(String r8, String r9, String r10) {
        Intrinsics.checkNotNullParameter(r8, "buttonType");
        Intrinsics.checkNotNullParameter(r10, "source");
        LinkedHashMap r1 = new LinkedHashMap();
        w31.c r2 = k();
        if (r2 == null) goto L5;
        Map<String, String> r3 = r2.f();
    L6:
        r1.putAll(r3);
        com.bytedance.android.live.revlink.impl.global.c r4 = this.d;
        Long r5 = null;
        if (r4 == null) goto L9;
        com.bytedance.android.live.revenuelink.connect.f r6 = r4.Z0();
    L10:
        String r7 = DataType.FALSE;
        if (r6 == null) goto L18;
        LiveData<ey.f> r12 = r6.connectState();
        if (r12 == null) goto L18;
        ey.f r13 = (ey.f) r12.getValue();
        if (r13 == null) goto L18;
        String r14 = String.valueOf(r13.a);
        if (r14 == null) goto L18;
    L19:
        r1.put("channel_id", r14);
        w31.c r15 = k();
        if (r15 == null) goto L22;
        r5 = Long.valueOf(r15.i());
    L22:
        r1.put("pk_id", String.valueOf(r5));
        d31.d r16 = m();
        if (r16 == null) goto L25;
        r16.r(r1);
    L25:
        r1.put("connection_anchor_cnt", b());
        w r17 = i();
        if (r17 != null) goto L28;
    L30:
        r1.put("is_manager", r7);
        r1.put("button_type", r8);
        String r18 = "";
        if (r9 != null) goto L33;
        r9 = "";
    L33:
        r1.put("click_anchor_id", r9);
        r1.put("source", r10);
        com.bytedance.android.live.revlink.impl.mergepk.pkbase.e r19 = j();
        if (r19 != null) goto L36;
    L48:
        mz0.n r20 = new mz0.n();
        Map<String, String> r22 = r20.a;
        Intrinsics.checkNotNullParameter(r22, "map");
        Intrinsics.checkNotNullParameter(r1, "map");
        r22.putAll(r1);
        mz0.m r23 = new mz0.m();
        r23.b(LogCommon.ROOM);
        ((ArrayList) r20.b).addAll(r23.a);
        cy0.e.a.getClass();
        cy0.j r24 = cy0.e.a.a;
        com.bytedance.android.scope.m.e.getClass();
        Object r25 = com.bytedance.android.scope.m.b(r24).a(Reflection.getOrCreateKotlinClass(mz0.i.class));
        Intrinsics.checkNotNull(r25);
        ((mz0.i) ((f80.a) r25)).w3("livesdk_connection_manage_banner_click", r20.a, r20.b);
        return;
    L36:
        if (r19.isInCloudCollaborate() != true) goto L48;
        com.bytedance.android.live.revlink.impl.mergepk.pkbase.e r26 = j();
        if (r26 == null) goto L47;
        IBaseBattleSetting r27 = r26.getBattleSettings();
        if (r27 == null) goto L47;
        h3 r28 = r27.getTitleConfig();
        if (r28 == null) goto L47;
        String r29 = r28.getContent();
        if (r29 == null) goto L47;
        r18 = r29;
    L47:
        r1.put("playmode_name", r18);
        goto L48
    L28:
        if (w.f(r17) != true) goto L30;
        r7 = DataType.TRUE;
    L18:
        r14 = DataType.FALSE;
        goto L19
    L9:
        r6 = null;
        goto L10
    L5:
        r3 = MapsKt.emptyMap();
        goto L6
    }

    public final void s(String r7, String r8, String r9) {
        Intrinsics.checkNotNullParameter(r7, "allControlType");
        Intrinsics.checkNotNullParameter(r9, "source");
        LinkedHashMap r1 = new LinkedHashMap();
        w31.c r2 = k();
        if (r2 == null) goto L5;
        Map<String, String> r3 = r2.f();
    L6:
        r1.putAll(r3);
        com.bytedance.android.live.revlink.impl.multianchor.vm.g r4 = g();
        Long r5 = null;
        if (r4 == null) goto L9;
        Long r6 = Long.valueOf(r4.a());
    L10:
        r1.put("channel_id", String.valueOf(r6));
        w31.c r10 = k();
        if (r10 == null) goto L13;
        r5 = Long.valueOf(r10.i());
    L13:
        r1.put("pk_id", String.valueOf(r5));
        d31.d r12 = m();
        if (r12 == null) goto L16;
        r12.r(r1);
    L16:
        r1.put("connection_anchor_cnt", b());
        w r13 = i();
        if (r13 != null) goto L19;
    L21:
        String r14 = DataType.FALSE;
    L22:
        r1.put("is_manager", r14);
        r1.put("all_control_type", r7);
        if (r8 != null) goto L25;
        r8 = "";
    L25:
        r1.put("click_anchor_id", r8);
        r1.put("source", r9);
        mz0.n r15 = new mz0.n();
        Map<String, String> r16 = r15.a;
        Intrinsics.checkNotNullParameter(r16, "map");
        Intrinsics.checkNotNullParameter(r1, "map");
        r16.putAll(r1);
        mz0.m r17 = new mz0.m();
        r17.b(LogCommon.ROOM);
        ((ArrayList) r15.b).addAll(r17.a);
        cy0.e.a.getClass();
        cy0.j r18 = cy0.e.a.a;
        com.bytedance.android.scope.m.e.getClass();
        Object r19 = com.bytedance.android.scope.m.b(r18).a(Reflection.getOrCreateKotlinClass(mz0.i.class));
        Intrinsics.checkNotNull(r19);
        ((mz0.i) ((f80.a) r19)).w3("livesdk_connection_manage_banner_show", r15.a, r15.b);
        return;
    L19:
        if (w.f(r13) != true) goto L21;
        r14 = DataType.TRUE;
        goto L22
    L9:
        r6 = null;
        goto L10
    L5:
        r3 = MapsKt.emptyMap();
        goto L6
    }

    public final void x(String r3, boolean r4, String r5) {
        Intrinsics.checkNotNullParameter(r5, "requestPage");
        LinkedHashMap r0 = new LinkedHashMap();
        w31.c r1 = k();
        if (r1 == null) goto L5;
        Map<String, String> r2 = r1.f();
    L6:
        r0.putAll(r2);
        r0.put("follow_anchor_id", String.valueOf(r3));
        if (r4 == false) goto L9;
        String r6 = "anchor";
    L10:
        r0.put("follow_identity", r6);
        w31.c r7 = k();
        Long r8 = null;
        if (r7 == null) goto L13;
        Integer r9 = Integer.valueOf(r7.a());
    L14:
        r0.put("pk_time", String.valueOf(r9));
        w31.c r10 = k();
        if (r10 == null) goto L17;
        r8 = Long.valueOf(r10.i());
    L17:
        r0.put("pk_id", String.valueOf(r8));
        r0.put("request_page", r5);
        mz0.n r12 = new mz0.n();
        Map<String, String> r13 = r12.a;
        Intrinsics.checkNotNullParameter(r13, "map");
        Intrinsics.checkNotNullParameter(r0, "map");
        r13.putAll(r0);
        mz0.m r14 = new mz0.m();
        LinkCrossRoomDataHolder r15 = f();
        if (r15 == null) goto L20;
        r15.a(r14);
    L20:
        r14.b(LogCommon.ROOM);
        r14.b(LogCommon.PAGE_SOURCE_LOG);
        ((ArrayList) r12.b).addAll(r14.a);
        cy0.e.a.getClass();
        cy0.j r16 = cy0.e.a.a;
        com.bytedance.android.scope.m.e.getClass();
        Object r17 = com.bytedance.android.scope.m.b(r16).a(Reflection.getOrCreateKotlinClass(mz0.i.class));
        Intrinsics.checkNotNull(r17);
        ((mz0.i) ((f80.a) r17)).w3("livesdk_connection_counterpart_follow", r12.a, r12.b);
        return;
    L13:
        r9 = null;
        goto L14
    L9:
        r6 = "audience";
        goto L10
    L5:
        r2 = MapsKt.emptyMap();
        goto L6
    }

    public static /* synthetic */ String E(q r1, boolean r2, int r3, int r4) {
        if ((r4 & 2) == 0) goto L5;
        r3 = 0;
    L5:
        r1.getClass();
        return D(r2, r3, false);
    }

    public static void u(q r6, IRoom r7, m2 r8, String r9) {
        Intrinsics.checkNotNullParameter(r9, "source");
        Intrinsics.checkNotNullParameter("manual_link", "connectionType");
        LinkedHashMap r1 = new LinkedHashMap();
        com.bytedance.android.live.revlink.impl.multianchor.service.d r3 = r6.h();
        if (r3 == null) goto L5;
        r1.put("anchor_connect_status", String.valueOf(r3.getLinkUserCenter().c()));
    L5:
        boolean r5 = false;
        if (r9.length() <= 0) goto L8;
        boolean r4 = true;
    L9:
        if (r4 == false) goto L11;
        r1.put("source", r9);
    L11:
        String r10 = "";
        if (r7 == null) goto L17;
        IBaseUser r12 = r7.getOwnerKt();
        if (r12 == null) goto L17;
        String r13 = r12.getIdString();
        if (r13 == null) goto L17;
    L18:
        r1.put("invitee_id", r13);
        Integer r14 = Integer.valueOf(r8.getServerInviteType());
        com.bytedance.android.live.revlink.impl.multianchor.match.f r0 = null;
        if (r14 == null) goto L28;
        int r15 = r14.intValue();
        if (r15 != 101) goto L23;
        String r16 = "mutual_follow";
    L27:
        r1.put("invitee_list", r16);
        goto L28
    L23:
        if (r15 == 102) goto L25;
        r16 = UserListInviteType.a(r15, null);
        goto L27
    L25:
        r16 = "recommend";
    L28:
        r1.put("invitee_status", DataType.FALSE);
        if (o2.a(r8) != true) goto L31;
        boolean r17 = true;
    L32:
        r1.put("npk_link_type", E(r6, r17, 0, 6));
        r1.put("connection_type", "manual_npk");
        if ("manual_link".length() <= 0) goto L35;
        r5 = true;
    L35:
        if (r5 == false) goto L37;
        r1.put("connection_type", "manual_link");
    L37:
        com.bytedance.android.live.revlink.impl.global.c r18 = r6.d;
        if (r18 == null) goto L40;
        com.bytedance.android.live.revlink.impl.control.d r19 = r18.Rc();
    L41:
        if (r19 == null) goto L44;
        String r20 = r19.getRequestId();
        if (r20 == null) goto L44;
    L45:
        r1.put("request_id", r20);
        LinkCrossRoomDataHolder r22 = r6.f();
        if (r22 == null) goto L48;
        Long r23 = Long.valueOf(r22.c());
    L49:
        r1.put("channel_id", String.valueOf(r23));
        com.bytedance.android.live.revlink.impl.global.c r24 = r6.d;
        if (r24 == null) goto L52;
        r0 = r24.F8();
    L52:
        if (r0 == null) goto L54;
        r10 = r0.i(true);
    L54:
        r1.put("random_npk_status", r10);
        r1.put("follow_anchor_id", r6.d());
        r1.put("invite_status", e(r8));
        r1.put("anchor_connection_type", "invite");
        mz0.n r25 = new mz0.n();
        Map<String, String> r26 = r25.a;
        Intrinsics.checkNotNullParameter(r26, "map");
        Intrinsics.checkNotNullParameter(r1, "map");
        r26.putAll(r1);
        mz0.m r27 = new mz0.m();
        r27.b(LogCommon.ROOM);
        ((ArrayList) r25.b).addAll(r27.a);
        cy0.e.a.getClass();
        cy0.j r28 = cy0.e.a.a;
        com.bytedance.android.scope.m.e.getClass();
        Object r29 = com.bytedance.android.scope.m.b(r28).a(Reflection.getOrCreateKotlinClass(mz0.i.class));
        Intrinsics.checkNotNull(r29);
        ((mz0.i) ((f80.a) r29)).w3("livesdk_connection_invite_cancel", r25.a, r25.b);
        return;
    L48:
        r23 = null;
    L44:
        r20 = "";
        goto L45
    L40:
        r19 = null;
        goto L41
    L31:
        r17 = false;
    L17:
        r13 = "";
        goto L18
    L8:
        r4 = false;
        goto L9
    }

    public final void v(int r8, String r9, com.bytedance.android.live.revlink.impl.pk.vm.linkout.p r10, Function1<? super mz0.o, Unit> r12) {
        Intrinsics.checkNotNullParameter(r9, "source");
        LinkedHashMap r1 = new LinkedHashMap();
        com.bytedance.android.live.revlink.impl.multianchor.service.d r2 = h();
        if (r2 == null) goto L6;
        int r3 = r2.getLinkUserCenter().c();
        r1.put("anchor_connect_status", String.valueOf(r3));
        r1.put("connection_anchor_cnt", String.valueOf(r3));
    L6:
        if (r9.length() <= 0) goto L8;
        boolean r4 = true;
    L9:
        if (r4 == false) goto L11;
        r1.put("source", r9);
    L11:
        r1.put("is_oncemore", DataType.FALSE);
        if (x.d(r8) == false) goto L15;
        String r13 = "team_pk";
    L18:
        r1.put("invite_mode", r13);
        r1.put("npk_link_type", E(this, true, r8, 4));
        d31.d r14 = m();
        if (r14 == null) goto L21;
        r14.r(r1);
    L21:
        String r5 = "";
        if (x.d(r8) == false) goto L25;
        String r15 = "random_npk";
    L37:
        r1.put("connection_sub_type", r15);
        com.bytedance.android.live.revlink.impl.global.c r16 = this.d;
        p0 r6 = null;
        if (r16 == null) goto L40;
        com.bytedance.android.live.revlink.impl.control.d r17 = r16.Rc();
    L41:
        if (r17 == null) goto L44;
        String r18 = r17.getRequestId();
        if (r18 == null) goto L44;
    L45:
        r1.put("request_id", r18);
        LinkCrossRoomDataHolder r19 = f();
        if (r19 == null) goto L48;
        Long r20 = Long.valueOf(r19.c());
    L49:
        r1.put("channel_id", String.valueOf(r20));
        com.bytedance.android.live.revlink.impl.global.c r22 = this.d;
        if (r22 == null) goto L52;
        com.bytedance.android.live.revlink.impl.multianchor.match.f r23 = r22.F8();
    L53:
        if (r23 == null) goto L55;
        String r24 = r23.i(true);
    L56:
        r1.put("random_npk_status", r24);
        r1.put("follow_anchor_id", d());
        com.bytedance.android.live.revlink.impl.global.c r25 = this.d;
        if (r25 == null) goto L59;
        com.bytedance.android.live.revlink.impl.multianchor.dialog.linkopt.e r26 = r25.getLinkOptLogContext();
    L60:
        if (r26 == null) goto L62;
        String r27 = r26.a();
    L63:
        r1.put("from_room_status", r27);
        r1.put("anchor_connection_type", "invite");
        d31.d r28 = m();
        if (r28 == null) goto L66;
        String r29 = r28.c();
    L67:
        if (r29 != null) goto L69;
    L71:
        if (r29 != null) goto L73;
        r29 = "";
    L73:
        r1.put("connection_type", r29);
        if (x.b(r8) == false) goto L76;
        r1.put("connection_type", "random_link");
    L76:
        d31.d r30 = m();
        if (r30 == null) goto L79;
        r5 = r30.s();
    L79:
        r1.put("room_status", r5);
        r1.put("audience_connect_cnt", DataType.FALSE);
        r1.put("pk_time", "300");
        mz0.n r32 = new mz0.n();
        mz0.o r33 = new mz0.o(r32.a);
        r33.b(r1);
        if (r12 == null) goto L82;
        Unit r110 = (Unit) r12.invoke(r33);
    L82:
        if (r10 == null) goto L84;
        r6 = r10.a;
    L84:
        e21.c.e(r33, r6);
        mz0.m r34 = new mz0.m();
        r34.b(LogCommon.ROOM);
        ((ArrayList) r32.b).addAll(r34.a);
        cy0.e.a.getClass();
        cy0.j r35 = cy0.e.a.a;
        com.bytedance.android.scope.m.e.getClass();
        Object r36 = com.bytedance.android.scope.m.b(r35).a(Reflection.getOrCreateKotlinClass(mz0.i.class));
        Intrinsics.checkNotNull(r36);
        ((mz0.i) ((f80.a) r36)).w3("livesdk_random_match", r32.a, r32.b);
        return;
    L69:
        if (StringsKt.isBlank(r29) != true) goto L71;
        r29 = "random_pk";
        goto L71
    L66:
        r29 = null;
        goto L67
    L62:
        r27 = "";
        goto L63
    L59:
        r26 = null;
        goto L60
    L55:
        r24 = "";
        goto L56
    L52:
        r23 = null;
        goto L53
    L48:
        r20 = null;
    L44:
        r18 = "";
        goto L45
    L40:
        r17 = null;
        goto L41
    L25:
        if (x.a(r8) == false) goto L28;
    L36:
        r15 = "random_individual";
        goto L37
    L28:
        if (r8 != 9) goto L31;
        r15 = "";
        goto L37
    L31:
        if (r8 == 11) goto L36;
        if (r8 == 10) goto L36;
        r15 = "random_nlink";
        goto L37
    L15:
        if (x.a(r8) == false) goto L17;
        r13 = "routine_pk";
        goto L18
    L17:
        r13 = "connection";
        goto L18
    L8:
        r4 = false;
        goto L9
    }

    public final void y(IRoom r16, m2 r17, int r18, int r19, long r20, String r22, boolean r23) {
        Intrinsics.checkNotNullParameter(r22, "source");
        LinkedHashMap r2 = new LinkedHashMap();
        com.bytedance.android.live.revlink.impl.multianchor.service.d r3 = h();
        boolean r4 = false;
        if (r3 == null) goto L8;
        int r5 = r3.getLinkUserCenter().c();
        if (r5 != 1) goto L7;
        r5 = 0;
    L7:
        r2.put("anchor_connect_status", String.valueOf(r5));
        r2.put("connection_anchor_cnt", String.valueOf(r5));
    L8:
        d31.d r6 = m();
        String r7 = "";
        if (r6 == null) goto L11;
        String r8 = r6.s();
    L12:
        r2.put("room_status", r8);
        com.bytedance.android.live.revlink.impl.global.c r9 = this.d;
        Long r10 = null;
        if (r9 == null) goto L15;
        com.bytedance.android.live.revlink.impl.multianchor.dialog.linkopt.e r12 = r9.getLinkOptLogContext();
    L16:
        if (r12 == null) goto L19;
        String r13 = r12.c;
        if (r13 == null) goto L19;
    L20:
        r2.put("source", r13);
        if (o2.a(r17) != true) goto L23;
        boolean r1 = true;
    L24:
        r2.put("npk_link_type", E(this, r1, 0, 6));
        String r14 = "pk";
        if (o2.a(r17) == true) goto L27;
        String r15 = "live";
    L31:
        r2.put("invitee_room_status", r15);
        IRivalExtraInfo r24 = r17.getRivalExtraInfo();
        if (r24 == null) goto L38;
        d6 r25 = r24.getLinkerInfo();
        if (r25 == null) goto L38;
        List r26 = r25.getLinkedUserInfos();
        if (r26 == null) goto L38;
        int r27 = r26.size();
    L39:
        String r110 = DataType.FALSE;
        if (r27 <= 1) goto L50;
        IRivalExtraInfo r28 = r17.getRivalExtraInfo();
        if (r28 == null) goto L48;
        d6 r29 = r28.getLinkerInfo();
        if (r29 == null) goto L48;
        List r30 = r29.getLinkedUserInfos();
        if (r30 == null) goto L48;
        Integer r32 = Integer.valueOf(r30.size());
    L49:
        String r33 = String.valueOf(r32);
    L51:
        r2.put("invitee_connect_cnt", r33);
        IRivalExtraInfo r34 = r17.getRivalExtraInfo();
        if (r34 == null) goto L58;
        d6 r35 = r34.getLinkerInfo();
        if (r35 == null) goto L58;
        List r36 = r35.getLinkedUserInfos();
        if (r36 == null) goto L58;
        r2.put("invitee_connect_cnt", String.valueOf(r36.size()));
    L58:
        List r37 = r17.getParticipantRooms();
        if (r37 != null) goto L61;
    L63:
        r2.put("invite_type", "anchor");
        if (r16 == null) goto L68;
        IBaseUser r38 = r16.getOwnerKt();
        if (r38 == null) goto L68;
        String r39 = r38.getIdString();
    L69:
        if (r39 != null) goto L71;
        r39 = "";
    L71:
        r2.put("invitee_id", r39);
        LinkCrossRoomDataHolder r40 = f();
        if (r40 == null) goto L74;
        String r42 = r40.h();
    L75:
        r2.put("invitee_list", r42);
        if (r18 != 101) goto L81;
        if (r23 == false) goto L79;
        String r43 = "recommend";
    L80:
        r2.put("invitee_list", r43);
        goto L81
    L79:
        r43 = "mutual_follow";
    L81:
        r2.put("invitee_status", DataType.FALSE);
        IRoom r44 = r17.getRoom();
        if (r44 == null) goto L88;
        Map r111 = IRoomKt_androidKt.getLinkMapKt(r44);
        if (r111 == null) goto L88;
        if (r111.containsKey(String.valueOf(7)) != true) goto L88;
        r14 = "anchor";
    L95:
        r2.put("invitee_connection_status", r14);
        r2.put("is_oncemore", DataType.FALSE);
        r2.put("invite_mode", "connection");
        List r45 = r17.getParticipantRooms();
        if (r45 == null) goto L98;
        List r46 = CollectionsKt.toList(r45);
    L99:
        List r47 = r46;
        if (r47 != null) goto L102;
    L105:
        boolean r48 = true;
    L106:
        if (r48 == false) goto L108;
        String r49 = "single";
    L109:
        r2.put("npk_link_type", r49);
        d31.d r50 = m();
        if (r50 == null) goto L112;
        r50.r(r2);
    L112:
        r2.put("connection_sub_type", "manual_nlink");
        com.bytedance.android.live.revlink.impl.global.c r52 = this.d;
        if (r52 == null) goto L115;
        com.bytedance.android.live.revlink.impl.control.d r53 = r52.Rc();
    L116:
        if (r53 == null) goto L119;
        String r54 = r53.getRequestId();
        if (r54 == null) goto L119;
    L120:
        r2.put("request_id", r54);
        LinkCrossRoomDataHolder r55 = f();
        if (r55 == null) goto L123;
        Long r56 = Long.valueOf(r55.c());
    L124:
        r2.put("channel_id", String.valueOf(r56));
        com.bytedance.android.live.revlink.impl.global.c r57 = this.d;
        if (r57 == null) goto L127;
        com.bytedance.android.live.revlink.impl.multianchor.match.f r58 = r57.F8();
    L128:
        if (r58 == null) goto L130;
        r7 = r58.i(true);
    L130:
        r2.put("random_npk_status", r7);
        r2.put("follow_anchor_id", d());
        r2.put("invite_status", e(r17));
        r2.put("anchor_connection_type", "invite");
        r2.put("audience_connect_cnt", DataType.FALSE);
        if (r16 == null) goto L133;
        r10 = Long.valueOf(IRoomKtKt.getId((IRoomBase) r16));
    L133:
        r2.put("invitee_room_id", String.valueOf(r10));
        r2.put("list_num", String.valueOf(r19 + 1));
        r2.put("stay_time", String.valueOf(r20 / 1000));
        com.bytedance.android.live.revlink.impl.mergepk.pkbase.e r59 = j();
        if (r59 != null) goto L136;
    L152:
        mz0.n r60 = new mz0.n();
        Map<String, String> r62 = r60.a;
        Intrinsics.checkNotNullParameter(r62, "map");
        Intrinsics.checkNotNullParameter(r2, "map");
        r62.putAll(r2);
        mz0.m r63 = new mz0.m();
        r63.b(LogCommon.ROOM);
        ((ArrayList) r60.b).addAll(r63.a);
        cy0.e.a.getClass();
        cy0.j r64 = cy0.e.a.a;
        com.bytedance.android.scope.m.e.getClass();
        Object r65 = com.bytedance.android.scope.m.b(r64).a(Reflection.getOrCreateKotlinClass(mz0.i.class));
        Intrinsics.checkNotNull(r65);
        ((mz0.i) ((f80.a) r65)).w3("livesdk_connection_invite", r60.a, r60.b);
        return;
    L136:
        if (r59.isInBreakThrough() == false) goto L152;
        n3 r66 = r59.getBreakThroughInfo();
        if (r66 == null) goto L141;
        String r67 = String.valueOf(r66.getStage());
        if (r67 == null) goto L141;
    L142:
        r2.put("pve_level", r67);
        PkBaseStateMachine.c r68 = r59.getCurPKBaseState();
        r68.getClass();
        if ((r68 instanceof PkBaseStateMachine.c.d) == false) goto L152;
        n3 r69 = r59.getBreakThroughInfo();
        if (r69 != null) goto L147;
    L149:
        if (r4 == false) goto L151;
        r110 = DataType.TRUE;
    L151:
        r2.put("is_finish", r110);
        r2.put("finish_level", String.valueOf(r59.getBreakThroughStage()));
        goto L152
    L147:
        if (r69.getState() != 1) goto L149;
        r4 = true;
    L141:
        r67 = DataType.FALSE;
        goto L142
    L127:
        r58 = null;
        goto L128
    L123:
        r56 = null;
    L119:
        r54 = "";
        goto L120
    L115:
        r53 = null;
        goto L116
    L108:
        r49 = "double";
        goto L109
    L102:
        if (r47.isEmpty() == true) goto L105;
        r48 = false;
        goto L106
    L98:
        r46 = null;
    L88:
        if (r44 == null) goto L94;
        Map r70 = IRoomKt_androidKt.getLinkMapKt(r44);
        if (r70 == null) goto L94;
        if (r70.containsKey(String.valueOf(1)) == true) goto L95;
    L94:
        r14 = "live";
        goto L95
    L74:
        r42 = "";
    L68:
        r39 = null;
        goto L69
    L61:
        if (r37.size() <= 0) goto L63;
        r2.put("invitee_connect_cnt", String.valueOf(r37.size() + 1));
    L48:
        r32 = null;
        goto L49
    L50:
        r33 = DataType.FALSE;
    L38:
        r27 = 0;
        goto L39
    L27:
        if (r17.getRoomScene() != 1) goto L29;
        r15 = "pk";
        goto L31
    L29:
        r15 = "connection";
        goto L31
    L23:
        r1 = false;
    L19:
        r13 = "";
        goto L20
    L15:
        r12 = null;
        goto L16
    L11:
        r8 = "";
        goto L12
    }

    public static void o(q r16, int r17, boolean r18, boolean r19, int r20, boolean r22, int r23, String r24, String r25, v3 r26, p0 r27, String r28, int r29) {
        if ((r29 & 16) == 0) goto L5;
        boolean r4 = false;
    L7:
        if ((r29 & DefaultConfig.MAX_CACHE_ENTRIES) == 0) goto L9;
        v3 r6 = null;
    L11:
        if ((r29 & 512) == 0) goto L13;
        p0 r8 = null;
    L15:
        if ((r29 & 1024) == 0) goto L17;
        String r3 = null;
    L18:
        LinkedHashMap r9 = new LinkedHashMap();
        LinkCrossRoomDataHolder r10 = r16.f();
        if (r10 == null) goto L21;
        Long r12 = Long.valueOf(r10.c());
    L22:
        r9.put("channel_id", String.valueOf(r12));
        r9.put("is_oncemore", DataType.FALSE);
        r9.put("pk_description", "routine");
        r9.put("npk_link_type", E(r16, r18, 0, 6));
        String r5 = "relink_team";
        if (r23 != 21) goto L25;
        String r1 = "relink_player";
    L32:
        r9.put("connection_type", r1);
        r9.put("invitee_connection_status", r16.p());
        r9.put("inviter_connect_cnt", String.valueOf(r20));
        String r15 = "";
        if (x.c(r23) == false) goto L39;
        d31.d r2 = r16.m();
        if (r2 == null) goto L38;
        String r7 = r2.a();
        if (r7 == null) goto L38;
    L40:
        r9.put("anchor_connect_status", r7);
        if (r4 == false) goto L43;
        String r13 = "apply";
    L44:
        r9.put("anchor_connection_type", r13);
        r9.put("invite_mode", "connection");
        if (r24 != null) goto L47;
        String r14 = "";
    L48:
        r9.put("inviter_id", r14);
        if (r25 != null) goto L51;
        String r30 = "";
    L52:
        r9.put("inviter_room_id", r30);
        d31.d r32 = r16.m();
        if (r32 == null) goto L55;
        String r33 = r32.s();
    L56:
        r9.put("room_status", r33);
        if (r23 == 20) goto L61;
        if (r23 == 21) goto L60;
        Long r34 = null;
        r5 = UserListInviteType.a(r17, null);
    L62:
        r9.put("invitee_list", r5);
        if (r17 != 13) goto L65;
        r9.put("if_strategy_invite", DataType.TRUE);
    L66:
        d31.d r0 = r16.m();
        if (r0 == null) goto L69;
        r15 = r0.b();
    L69:
        r9.put("connection_sub_type", r15);
        w31.c r35 = r16.k();
        if (r35 == null) goto L72;
        Long r36 = Long.valueOf(r35.i());
    L73:
        r9.put("pk_id", String.valueOf(r36));
        r9.put("list_num", DataType.FALSE);
        r9.put("invite_type", "anchor");
        if (r3 == null) goto L78;
        Map<String, String> r37 = h41.h.a(r3);
        if (r37 == null) goto L78;
        r9.putAll(r37);
    L78:
        mz0.n r38 = new mz0.n();
        mz0.o r39 = new mz0.o(r38.a);
        r39.b(r9);
        e21.e.d(r39, r6);
        e21.c.e(r39, r8);
        mz0.m r40 = new mz0.m();
        r40.b(LogCommon.ROOM);
        List<Object> r42 = r38.b;
        ArrayList r43 = (ArrayList) r42;
        r43.addAll(r40.a);
        cy0.e.a.getClass();
        cy0.j r44 = cy0.e.a.a;
        com.bytedance.android.scope.m.e.getClass();
        Object r45 = com.bytedance.android.scope.m.b(r44).a(Reflection.getOrCreateKotlinClass(mz0.i.class));
        Intrinsics.checkNotNull(r45);
        ((mz0.i) ((f80.a) r45)).w3("livesdk_connection_invited_page_show", r38.a, r38.b);
        return;
    L72:
        r36 = r34;
        goto L73
    L65:
        r9.put("if_strategy_invite", DataType.FALSE);
        goto L66
    L60:
        r34 = null;
        r5 = "relink_player";
        goto L62
    L61:
        r34 = null;
        goto L62
    L55:
        r33 = "";
        goto L56
    L51:
        r30 = r25;
        goto L52
    L47:
        r14 = r24;
        goto L48
    L43:
        r13 = "invite";
    L38:
        r7 = "";
        goto L40
    L39:
        r7 = String.valueOf(r20);
        goto L40
    L25:
        if (r23 != 20) goto L27;
        r1 = "relink_team";
        goto L32
    L27:
        if (r18 == true) goto L31;
        if (r19 == true) goto L31;
        r1 = "manual_link";
    L31:
        r1 = "manual_npk";
        goto L32
    L21:
        r12 = null;
        goto L22
    L17:
        r3 = r28;
        goto L18
    L13:
        r8 = r27;
        goto L15
    L9:
        r6 = r26;
        goto L11
    L5:
        r4 = r22;
        goto L7
    }
}
