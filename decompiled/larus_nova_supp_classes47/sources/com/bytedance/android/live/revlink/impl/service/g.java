package com.bytedance.android.live.revlink.impl.service;

import androidx.lifecycle.LiveData;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.profile.monitor.DataType;
import com.bytedance.android.live.revlink.api.ILinkService;
import com.bytedance.android.live.revlink.impl.LinkCrossRoomDataHolder;
import com.bytedance.android.live.revlink.impl.pk.utils.q;
import com.bytedance.android.live.revlink.impl.service.internal.LinkRevInternalServiceContext;
import com.bytedance.android.live.revlink.impl.utils.s;
import com.bytedance.android.livesdk.link.model.IBattleConfigSetting;
import com.bytedance.android.livesdk.link.model.IProfitGameStatusMessage;
import com.bytedance.android.livesdk.link.model.ITeamTask;
import com.bytedance.android.livesdk.link.model.q9;
import com.bytedance.android.livesdk.revenue.log.LogCommon;
import com.bytedance.android.livesdkapi.depend.model.live.IRoomBase;
import com.bytedance.ies.sdk.widgets.NextLiveData;
import com.bytedance.live.datacontext.m;
import com.bytedance.tools.kcp.ultrasettings.runtime.UltraSettingsManager;
import cy0.j;
import dq2.w;
import gd0.v;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.properties.ReadOnlyProperty;
import kotlin.reflect.KProperty;
import mz0.i;
import mz0.n;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class g implements kc0.e {
    public static final ReadOnlyProperty b = null;
    public static final boolean c = false;
    public int a;

    public static final class a {
        public static final /* synthetic */ KProperty[] a = null;

        static {
            a = new KProperty[]{Reflection.property1(new PropertyReference1Impl(a.class, "revLinkCurrentModeCostTimeOpt", "getRevLinkCurrentModeCostTimeOpt()Z", 0))};
        }

        public a() {
        }
    }

    public g() {
    }

    public final Map<String, String> e() {
        Pair[] r0 = new Pair[2];
        com.bytedance.android.live.revlink.impl.global.c r1 = com.bytedance.android.live.revlink.impl.global.b.k();
        if (r1 == null) goto L9;
        com.bytedance.android.live.revlink.impl.mergepk.pkbase.e r2 = r1.Ig();
        if (r2 == null) goto L9;
        IBattleConfigSetting r3 = r2.getConfigSetting();
        if (r3 == null) goto L9;
        Integer r4 = Integer.valueOf(r3.getModType());
    L10:
        r0[0] = TuplesKt.to("rev_mode_type", String.valueOf(r4));
        com.bytedance.android.live.revlink.impl.service.internal.a r5 = com.bytedance.android.live.revlink.impl.global.b.n();
        if (r5 == null) goto L14;
        String r6 = r5.ce();
        if (r6 == null) goto L14;
    L15:
        r0[1] = TuplesKt.to("rev_ui_layout", r6);
        return MapsKt.hashMapOf(r0);
    L14:
        r6 = "";
    L9:
        r4 = null;
        goto L10
    }

    static {
        a r0 = new a();
        com.bytedance.tools.kcp.ultrasettings.runtime.a r1 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("rev_link_current_mode_cost_time_opt", Boolean.FALSE, Boolean.TYPE, false);
        KProperty[] r2 = a.a;
        KProperty r12 = r2[0];
        ReadOnlyProperty r3 = UltraSettingsManager.a().a(r1.a, r1.b, r1.getType(), r1.d, r12);
        b = r3;
        c = ((Boolean) r3.getValue(r0, r2[0])).booleanValue();
    }

    public final int getCurrentMode() {
        if (c == true) goto L5;
        com.bytedance.android.live.revlink.impl.service.internal.a r0 = com.bytedance.android.live.revlink.impl.global.b.n();
        if (r0 != null) goto L11;
        return 0;
    L11:
        return r0.getCurrentMode();
    L5:
        return this.a;
    }

    public final Map<String, String> h() {
        HashMap r0 = new HashMap();
        d31.d r1 = com.bytedance.android.live.revlink.impl.global.b.c0();
        String r2 = "";
        if (r1 == null) goto L5;
        String r3 = r1.f();
    L6:
        r0.put("invite_mode", r3);
        d31.d r4 = com.bytedance.android.live.revlink.impl.global.b.c0();
        if (r4 == null) goto L9;
        String r5 = r4.s();
    L10:
        r0.put("room_status", r5);
        d31.d r6 = com.bytedance.android.live.revlink.impl.global.b.c0();
        int r7 = 0;
        if (r6 == null) goto L20;
        q r8 = com.bytedance.android.live.revlink.impl.global.b.W();
        if (r8 == null) goto L17;
        com.bytedance.android.live.revlink.impl.mergepk.pkdouble.c r9 = r8.g();
        if (r9 == null) goto L17;
        int r10 = r9.getInviteType();
    L18:
        String r12 = r6.p(r10);
        if (r12 == null) goto L20;
    L21:
        r0.put("invitee_list", r12);
        d31.d r13 = com.bytedance.android.live.revlink.impl.global.b.c0();
        if (r13 == null) goto L24;
        String r14 = r13.g();
    L25:
        r0.put("is_oncemore", r14);
        d31.d r15 = com.bytedance.android.live.revlink.impl.global.b.c0();
        if (r15 == null) goto L28;
        r2 = r15.o();
    L28:
        r0.put("is_manager", r2);
        w31.c r16 = com.bytedance.android.live.revlink.impl.global.b.T();
        Long r17 = null;
        if (r16 == null) goto L31;
        Long r18 = Long.valueOf(r16.i());
    L32:
        r0.put("pk_id", String.valueOf(r18));
        LinkCrossRoomDataHolder r19 = com.bytedance.android.live.revlink.impl.global.b.j();
        if (r19 == null) goto L35;
        r17 = Long.valueOf(r19.c());
    L35:
        r0.put("channel_id", String.valueOf(r17));
        w r20 = vh6.c.b(com.bytedance.android.livesdk.revenue.service.interact.d.class).M1();
        if (r20 == null) goto L38;
        r7 = r20.o();
    L38:
        if (r7 > 0) goto L40;
    L42:
        r0.put("is_game_connection", DataType.FALSE);
        com.bytedance.android.live.revlink.impl.global.c r22 = com.bytedance.android.live.revlink.impl.global.b.k();
        if (r22 == null) goto L49;
        com.bytedance.android.live.revlink.impl.mergepk.pkmulti.c r23 = r22.U7();
        if (r23 == null) goto L49;
        if (r23.getCurrentGameStatus() != IProfitGameStatusMessage.GameStatus.BizStart.ordinal()) goto L49;
        r0.put("is_game_connection", DataType.TRUE);
        r0.putAll(r23.getCurrentTrackInfo());
    L49:
        d31.d r24 = com.bytedance.android.live.revlink.impl.global.b.c0();
        if (r24 == null) goto L52;
        r24.r(r0);
    L52:
        return r0;
    L40:
        if (Intrinsics.areEqual((String) r0.get("room_status"), "live") == false) goto L42;
        r0.put("room_status", "audience_connection");
        goto L42
    L31:
        r18 = null;
        goto L32
    L24:
        r14 = "";
    L17:
        r10 = 0;
    L20:
        r12 = "";
        goto L21
    L9:
        r5 = "";
        goto L10
    L5:
        r3 = "";
        goto L6
    }

    public final boolean n() {
        com.bytedance.android.live.revlink.impl.settings.live.d r0 = com.bytedance.android.live.revlink.impl.settings.live.d.e;
        r0.getClass();
        if (((Boolean) com.bytedance.android.live.revlink.impl.settings.live.d.c.getValue(r0, com.bytedance.android.live.revlink.impl.settings.live.d.a[1])).booleanValue() == true) goto L6;
        return true;
    L6:
        return ((Boolean) vh6.c.b(wh6.a.class).getClientABValue(q41.a.f)).booleanValue();
    }

    public final Map<String, String> q() {
        LinkedHashMap r0 = new LinkedHashMap();
        q r1 = com.bytedance.android.live.revlink.impl.global.b.W();
        Long r2 = null;
        if (r1 == null) goto L11;
        com.bytedance.android.live.revlink.impl.mergepk.pkdouble.c r3 = r1.g();
        if (r3 == null) goto L11;
        com.bytedance.android.live.revlink.impl.pk.vm.pk.e r4 = r3.getTeamTaskService();
        if (r4 == null) goto L11;
        LiveData<com.bytedance.android.live.revlink.impl.pk.vm.pk.g> r5 = r4.getPkTeamTaskState();
        if (r5 == null) goto L11;
        com.bytedance.android.live.revlink.impl.pk.vm.pk.g r6 = (com.bytedance.android.live.revlink.impl.pk.vm.pk.g) r5.getValue();
    L12:
        boolean r7 = true;
        if ((!Intrinsics.areEqual(r6, com.bytedance.android.live.revlink.impl.pk.vm.pk.g.a.b)) == false) goto L27;
        q r8 = com.bytedance.android.live.revlink.impl.global.b.W();
        if (r8 == null) goto L23;
        com.bytedance.android.live.revlink.impl.mergepk.pkdouble.c r9 = r8.g();
        if (r9 == null) goto L23;
        com.bytedance.android.live.revlink.impl.pk.vm.pk.e r10 = r9.getTeamTaskService();
        if (r10 == null) goto L23;
        LiveData<com.bytedance.android.live.revlink.impl.pk.vm.pk.g> r12 = r10.getPkTeamTaskState();
        if (r12 == null) goto L23;
        com.bytedance.android.live.revlink.impl.pk.vm.pk.g r13 = (com.bytedance.android.live.revlink.impl.pk.vm.pk.g) r12.getValue();
    L25:
        if ((!Intrinsics.areEqual(r13, com.bytedance.android.live.revlink.impl.pk.vm.pk.g.d.b)) == false) goto L27;
        boolean r14 = true;
    L28:
        r0.put("is_caidan", String.valueOf(r14));
        com.bytedance.android.live.revlink.impl.mergepk.pkbase.e r15 = com.bytedance.android.live.revlink.impl.global.b.R();
        if (r15 == null) goto L33;
        LiveData<Long> r16 = r15.getBaseTimeLeft();
        if (r16 == null) goto L33;
        Long r17 = (Long) r16.getValue();
    L34:
        long r18 = 0;
        if (r17 == null) goto L46;
        com.bytedance.android.live.revlink.impl.mergepk.pkbase.e r19 = com.bytedance.android.live.revlink.impl.global.b.R();
        if (r19 == null) goto L42;
        LiveData<Long> r20 = r19.getBaseTimeLeft();
        if (r20 == null) goto L42;
        Long r22 = (Long) r20.getValue();
        if (r22 == null) goto L42;
    L44:
        if (r22.longValue() > 10) goto L46;
    L47:
        r0.put("is_touta", String.valueOf(r7));
        q r23 = com.bytedance.android.live.revlink.impl.global.b.W();
        if (r23 == null) goto L60;
        com.bytedance.android.live.revlink.impl.mergepk.pkdouble.c r24 = r23.g();
        if (r24 == null) goto L60;
        com.bytedance.android.live.revlink.impl.pk.vm.pk.e r25 = r24.getTeamTaskService();
        if (r25 == null) goto L60;
        LiveData<ITeamTask> r26 = r25.getPkTeamTask();
        if (r26 == null) goto L60;
        ITeamTask r27 = (ITeamTask) r26.getValue();
        if (r27 == null) goto L60;
        q9 r28 = r27.getTeamTaskConfig();
        if (r28 == null) goto L60;
        r18 = r28.getRewardBuffMultiple();
    L60:
        r0.put("caidan_times", String.valueOf(r18));
        w31.c r29 = com.bytedance.android.live.revlink.impl.global.b.T();
        if (r29 == null) goto L63;
        Long r30 = Long.valueOf(r29.i());
    L64:
        r0.put("pk_id", String.valueOf(r30));
        LinkCrossRoomDataHolder r32 = com.bytedance.android.live.revlink.impl.global.b.j();
        if (r32 == null) goto L67;
        r2 = Long.valueOf(r32.c());
    L67:
        r0.put("channel_id", String.valueOf(r2));
        d31.d r33 = com.bytedance.android.live.revlink.impl.global.b.c0();
        if (r33 == null) goto L70;
        String r34 = r33.f();
    L71:
        r0.put("invite_mode", r34);
        d31.d r35 = com.bytedance.android.live.revlink.impl.global.b.c0();
        if (r35 == null) goto L74;
        r35.r(r0);
    L74:
        return r0;
    L70:
        r34 = "";
        goto L71
    L63:
        r30 = null;
    L42:
        r22 = 0L;
    L46:
        r7 = false;
    L33:
        r17 = null;
    L23:
        r13 = null;
    L27:
        r14 = false;
    L11:
        r6 = null;
        goto L12
    }

    public final boolean V() {
        com.bytedance.android.live.revlink.impl.service.internal.a r0 = com.bytedance.android.live.revlink.impl.global.b.n();
        if (r0 != null) goto L7;
        return false;
    L7:
        return r0.V();
    }

    public final boolean a() {
        com.bytedance.android.live.revlink.impl.multianchor.service.a r0 = com.bytedance.android.live.revlink.impl.global.b.t();
        if (r0 == null) goto L7;
        f21.a r1 = r0.getConnectionContext();
        if (r1 == null) goto L7;
        return r1.f;
    L7:
        return false;
    }

    public final boolean c() {
        return v.a(getCurrentMode(), 4);
    }

    public final String g() {
        return wq2.e.a().g();
    }

    public final String getConnectionType() {
        int r0 = getCurrentMode();
        ILinkService r1 = (ILinkService) com.bytedance.android.live.revenue.core.util.f.a(ILinkService.class);
        if (v.a(r0, 4) == false) goto L12;
        p11.h r2 = r1.mo470getPkService();
        if (r2 == null) goto L7;
        q11.b r3 = r2.g();
    L9:
        if ((!Intrinsics.areEqual(r3, q11.b.C0295b.b)) == false) goto L16;
        return "pk";
    L16:
        return "link";
    L7:
        r3 = null;
        goto L9
    L12:
        if (v.a(r0, 64) == true) goto L18;
        return "";
    L18:
        return "link";
    }

    public final int getMixStreamType() {
        com.bytedance.android.live.revlink.impl.service.internal.a r0 = com.bytedance.android.live.revlink.impl.global.b.n();
        if (r0 != null) goto L7;
        return 0;
    L7:
        return r0.getMixStreamType();
    }

    public final long getPkId() {
        w31.c r0 = com.bytedance.android.live.revlink.impl.global.b.T();
        if (r0 != null) goto L7;
        return 0;
    L7:
        return r0.i();
    }

    public final boolean i() {
        i41.a r0 = com.bytedance.android.live.revlink.impl.global.b.g();
        if (r0 != null) goto L5;
    L7:
        return false;
    L5:
        if (r0.f != true) goto L7;
        return true;
    }

    public final String k() {
        w31.c r0 = com.bytedance.android.live.revlink.impl.global.b.T();
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.c();
    }

    public final void m() {
        com.bytedance.android.live.revlink.impl.service.internal.a r0 = com.bytedance.android.live.revlink.impl.global.b.n();
        if (r0 == null) goto L6;
        r0.m();
        return;
    }

    public final NextLiveData o() {
        ld.a r0 = ld.d.a();
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.Le();
    }

    public final boolean p() {
        com.bytedance.android.live.revlink.impl.service.internal.a r0 = com.bytedance.android.live.revlink.impl.global.b.n();
        if (r0 != null) goto L7;
        return true;
    L7:
        return r0.p();
    }

    public final void b(int r2) {
        com.bytedance.android.live.revlink.impl.service.internal.a r0 = com.bytedance.android.live.revlink.impl.global.b.n();
        if (r0 == null) goto L6;
        r0.b(r2);
        return;
    }

    public final void f(boolean r2) {
        com.bytedance.android.live.revlink.impl.global.c r0 = com.bytedance.android.live.revlink.impl.global.b.k();
        if (r0 == null) goto L5;
        LinkRevInternalServiceContext r1 = r0.Cj();
    L6:
        if (r1 == null) goto L11;
        m<Boolean> r3 = r1.isAppBackground();
        if (r3 == null) goto L12;
        r3.setValue(Boolean.valueOf(r2));
        return;
    L12:
        return;
    L11:
        return;
    L5:
        r1 = null;
        goto L6
    }

    public final void j(int r1) {
        this.a = r1;
    }

    public final void l(com.bytedance.android.live.service.prerequest.b.C0223b r2) {
        Intrinsics.checkNotNullParameter(r2, "callback");
        com.bytedance.android.live.revlink.impl.service.internal.a r0 = com.bytedance.android.live.revlink.impl.global.b.n();
        if (r0 == null) goto L6;
        r0.P9(r2);
        return;
    }

    public final void unLoadOtherWidget(int r2) {
        com.bytedance.android.live.revlink.impl.service.internal.a r0 = com.bytedance.android.live.revlink.impl.global.b.n();
        if (r0 == null) goto L6;
        r0.unLoadOtherWidget(r2);
        return;
    }

    public final void d(String r4, HashMap<String, String> r5) {
        Intrinsics.checkNotNullParameter(r4, "event");
        com.bytedance.android.live.revlink.impl.multianchor.utils.q r1 = com.bytedance.android.live.revlink.impl.global.b.v();
        if (r1 == null) goto L25;
        Intrinsics.checkNotNullParameter(r4, "event");
        LinkedHashMap r0 = new LinkedHashMap();
        r0.putAll(r5);
        d31.d r6 = r1.m();
        if (r6 == null) goto L7;
        Map<String, String> r7 = r6.i();
    L8:
        r0.putAll(r7);
        s r8 = r1.l();
        if (r8 == null) goto L11;
        String r9 = r8.e();
    L12:
        r0.put("user_id", String.valueOf(r9));
        com.bytedance.android.livesdk.revenue.service.room.c r10 = r1.c;
        if (r10 == null) goto L22;
        com.bytedance.android.livesdk.revenue.room.a r12 = r10.getRoomContext();
        if (r12 == null) goto L22;
        IRoomBase r13 = r12.getCommonRoom();
        if (r13 == null) goto L22;
        IBaseUser r14 = r13.getOwnerKt();
        if (r14 == null) goto L22;
        String r15 = r14.getIdString();
        if (r15 == null) goto L22;
    L23:
        r0.put("anchor_id", r15);
        n r16 = new n();
        Map<String, String> r2 = r16.a;
        Intrinsics.checkNotNullParameter(r2, "map");
        Intrinsics.checkNotNullParameter(r0, "map");
        r2.putAll(r0);
        mz0.m r3 = new mz0.m();
        r3.b(LogCommon.ROOM);
        r3.b(LogCommon.PAGE_SOURCE_LOG);
        List<Object> r17 = r16.b;
        ArrayList r18 = (ArrayList) r17;
        r18.addAll(r3.a);
        cy0.e.a.getClass();
        j r19 = cy0.e.a.a;
        com.bytedance.android.scope.m.e.getClass();
        Object r20 = com.bytedance.android.scope.m.b(r19).a(Reflection.getOrCreateKotlinClass(i.class));
        Intrinsics.checkNotNull(r20);
        ((i) ((f80.a) r20)).w3(r4, r16.a, r16.b);
        return;
    L22:
        r15 = "";
        goto L23
    L11:
        r9 = null;
        goto L12
    L7:
        r7 = MapsKt.emptyMap();
        goto L8
    }

    public final boolean r5(String r2, String r3, String r4, Integer r5) {
        Intrinsics.checkNotNullParameter(r2, "guideType");
        Intrinsics.checkNotNullParameter(r3, "toUserGroup");
        Intrinsics.checkNotNullParameter(r4, "page");
        com.bytedance.android.live.revlink.impl.service.internal.a r0 = com.bytedance.android.live.revlink.impl.global.b.n();
        if (r0 != null) goto L7;
        return false;
    L7:
        return r0.r5(r2, r3, r4, r5);
    }
}
