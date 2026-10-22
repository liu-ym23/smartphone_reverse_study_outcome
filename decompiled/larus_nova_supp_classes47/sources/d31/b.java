package d31;

import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.profile.monitor.DataType;
import com.bytedance.android.live.revlink.impl.global.LinkFakeGlobalService;
import com.bytedance.android.live.revlink.impl.multianchor.AnchorLinkInitType;
import com.bytedance.android.live.revlink.impl.multianchor.utils.q;
import com.bytedance.android.live.revlink.impl.multianchor.utils.x;
import com.bytedance.android.live.revlink.impl.multianchor.vm.g;
import com.bytedance.android.live.revlink.link.biz.service.i;
import com.bytedance.android.live.revlink.link.biz.service.k;
import com.bytedance.android.livesdk.link.model.IBattleConfigSetting;
import com.bytedance.android.livesdk.link.model.m3;
import com.bytedance.android.livesdk.link.model.n3;
import com.bytedance.android.livesdk.link.model.o9;
import com.bytedance.android.livesdk.link.model.p0;
import com.bytedance.android.livesdk.link.model.v3;
import com.bytedance.android.livesdk.revenue.log.LogCommon;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.IRoomBase;
import com.bytedance.android.livesdkapi.depend.model.live.IRoomKt_androidKt;
import com.bytedance.live.datacontext.m;
import com.bytedance.live.datacontext.n;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.revenue.platform.api.core.rx.l;
import com.bytedance.revenue.platform.api.core.rx.p;
import cy0.j;
import h41.h;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import mz0.o;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class b implements k {
    public Disposable a;
    public final com.bytedance.android.live.revlink.impl.global.c b;
    public final com.bytedance.android.livesdk.revenue.service.room.c c;

    public static final class a<T> implements Consumer {
        public final /* synthetic */ b a;
        public final /* synthetic */ v3 b;
        public final /* synthetic */ p0 c;
        public final /* synthetic */ String d;

        public a(b r1, v3 r2, p0 r3, String r4) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
        }

        public final void accept(Object r5) {
            Long r6 = (Long) r5;
            StringBuilder r7 = new StringBuilder("delay logConnectSuccess ");
            r7.append(i.r(this.a));
            r7.append(' ');
            com.bytedance.android.live.revlink.impl.multianchor.vm.b r0 = i.z(this.a);
            if (r0 == null) goto L7;
            m<String> r1 = r0.getConnectionSubType();
            if (r1 == null) goto L7;
            String r2 = (String) r1.getValue();
        L8:
            r7.append(r2);
            jy0.b.f("ttlive_anchor_link", r7.toString(), null, 4);
            String r3 = "random_individual";
            if (i.r(this.a) > 2) goto L19;
            com.bytedance.android.live.revlink.impl.multianchor.vm.b r8 = i.z(this.a);
            if (r8 == null) goto L28;
            m<String> r9 = r8.getConnectionSubType();
            if (r9 == null) goto L28;
            if (x.a(i.A(this.a).d()) == true) goto L18;
            r3 = "";
        L18:
            r9.setValue(r3);
        L28:
            this.a.d(this.b, this.c, this.d);
            com.bytedance.android.live.revlink.impl.multianchor.dialog.linkopt.e r10 = i.n(this.a);
            r10.getClass();
            Intrinsics.checkNotNullParameter("", "<set-?>");
            r10.c = "";
            return;
        L19:
            com.bytedance.android.live.revlink.impl.multianchor.vm.b r12 = i.z(this.a);
            if (r12 == null) goto L28;
            m<String> r13 = r12.getConnectionSubType();
            if (r13 == null) goto L28;
            if (x.a(i.A(this.a).d()) == true) goto L27;
            r3 = "manual_nlink";
        L27:
            r13.setValue(r3);
        L7:
            r2 = null;
            goto L8
        }
    }

    public final f21.a c() {
        com.bytedance.android.live.revlink.impl.multianchor.vm.b r0 = this.b.rb();
        if (r0 == null) goto L7;
        n<? extends f21.a> r1 = r0.getConnectionContext();
        if (r1 == null) goto L7;
        return (f21.a) r1.getValue();
    L7:
        return null;
    }

    @Override // com.bytedance.android.live.revlink.link.biz.service.k
    public final com.bytedance.android.live.revlink.impl.global.c getLinkInstanceService() {
        return this.b;
    }

    public final void b(Map<String, String> r9) {
        Intrinsics.checkNotNullParameter(r9, "logMap");
        com.bytedance.android.live.revlink.impl.mergepk.pkbase.e r0 = i.S(this);
        if (r0 != null) goto L5;
        return;
    L5:
        if (r0.getBreakThroughInfo() == null) goto L60;
        n3 r1 = r0.getBreakThroughInfo();
        int r3 = 0;
        if (r1 != null) goto L9;
    L11:
        boolean r2 = false;
    L12:
        String r4 = DataType.TRUE;
        String r5 = DataType.FALSE;
        if (r2 == false) goto L15;
        String r6 = DataType.TRUE;
    L16:
        r9.put("is_finish", r6);
        if (r2 == true) goto L19;
        r9.put("finish_level", String.valueOf(r0.getBreakThroughStage()));
    L31:
        IBattleConfigSetting r7 = r0.getConfigSetting();
        if (r7 == null) goto L38;
        m3 r8 = r7.getBreakthroughConfig();
        if (r8 == null) goto L38;
        List r10 = r8.getStages();
        if (r10 == null) goto L38;
        r3 = r10.size();
    L38:
        if (r3 <= 0) goto L51;
        IBattleConfigSetting r12 = r0.getConfigSetting();
        if (r12 == null) goto L49;
        m3 r13 = r12.getBreakthroughConfig();
        if (r13 == null) goto L49;
        List r14 = r13.getStages();
        if (r14 == null) goto L49;
        m3.b r15 = (m3.b) ListProtector.get(r14, r3 - 1);
        if (r15 == null) goto L49;
        String r16 = String.valueOf(r15.getTargetScore());
        if (r16 == null) goto L49;
    L50:
        r9.put("pve_target_value", r16);
    L49:
        r16 = DataType.FALSE;
    L51:
        n3 r17 = r0.getBreakThroughInfo();
        if (r17 == null) goto L57;
        String r18 = String.valueOf(r17.getTotalScore());
        if (r18 == null) goto L57;
        r5 = r18;
    L57:
        r9.put("pve_actual_value", r5);
        return;
    L19:
        n3 r19 = r0.getBreakThroughInfo();
        String r20 = null;
        if (r19 == null) goto L22;
        String r22 = r19.getMvpAnchorId();
    L23:
        IBaseUser r23 = this.c.getRoomContext().getCommonRoom().getOwnerKt();
        if (r23 == null) goto L27;
        r20 = r23.getIdString();
    L27:
        if (Intrinsics.areEqual(r22, r20) == true) goto L30;
        r4 = DataType.FALSE;
    L30:
        r9.put("is_mvp", r4);
        goto L31
    L22:
        r22 = null;
        goto L23
    L15:
        r6 = DataType.FALSE;
        goto L16
    L9:
        if (r1.getState() != 1) goto L11;
        r2 = true;
        goto L12
    }

    public b(LinkFakeGlobalService r2, com.bytedance.android.livesdk.revenue.service.room.c r3) {
        Intrinsics.checkNotNullParameter(r2, "linkInstanceService");
        Intrinsics.checkNotNullParameter(r3, "roomService");
        this.b = r2;
        this.c = r3;
    }

    public final void a(v3 r5, p0 r6, String r7) {
        f21.a r0 = c();
        if (r0 != null) goto L5;
        return;
    L5:
        if (r0.a() == false) goto L7;
    L10:
        boolean r1 = true;
    L11:
        if (r1 != true) goto L23;
        f21.a r2 = c();
        if (r2 != null) goto L16;
    L20:
        d(r5, r6, r7);
        com.bytedance.android.live.revlink.impl.multianchor.dialog.linkopt.e r8 = i.n(this);
        r8.getClass();
        Intrinsics.checkNotNullParameter("", "<set-?>");
        r8.c = "";
        return;
    L16:
        if (r2.a() != true) goto L20;
        l r3 = l.a;
        int r4 = p.a;
        this.a = Observable.timer(2, TimeUnit.MILLISECONDS, Schedulers.computation()).observeOn(AndroidSchedulers.mainThread()).subscribe(new a(this, r5, r6, r7));
        return;
    L23:
        return;
    L7:
        if (r0.j == true) goto L10;
        r1 = false;
        goto L11
    }

    public final void d(v3 r20, p0 r22, String r23) {
        LinkedHashMap r1 = new LinkedHashMap();
        com.bytedance.android.livesdk.revenue.room.a r3 = this.c.getRoomContext();
        r1.put("enter_from", r3.getPixEnterFrom());
        r1.put("anchor_connect_status", i.Z(this).a());
        r1.put("connection_anchor_cnt", i.Z(this).a());
        r1.put("invitee_id", String.valueOf(i.A(this).b()));
        r1.put("invitee_list", i.Z(this).p(i.A(this).b()));
        r1.put("channel_id", String.valueOf(i.A(this).a()));
        f21.a r4 = c();
        String r12 = "";
        if (r4 != null) goto L5;
    L16:
        String r5 = "";
    L17:
        r1.put("anchor_connection_type", r5);
        r1.put("is_transform", DataType.FALSE);
        IRoomBase r6 = r3.getCommonRoom();
        if ((r6 instanceof IRoom) == true) goto L20;
        r6 = null;
    L20:
        IRoom r7 = (IRoom) r6;
        if (r7 == null) goto L23;
        r1.put("audience_num", String.valueOf(IRoomKt_androidKt.getUserCountExt(r7)));
    L23:
        r1.put("invite_mode", "connection");
        r1.put("is_oncemore", DataType.FALSE);
        r1.put("room_status", i.Z(this).s());
        r1.put("source", i.n(this).c);
        f21.a r14 = c();
        if (r14 == null) goto L112;
        r1.put("anchor_type", i.B(this).F(r14.l));
        q r8 = i.B(this);
        boolean r10 = r14.k;
        int r9 = i.A(this).d();
        boolean r2 = r14.h;
        r8.getClass();
        r1.put("npk_link_type", q.D(r10, r9, r2));
        r1.put("connection_type", r14.m);
        int r13 = i.r(this);
        Object r18 = DataType.TRUE;
        if (r13 <= 2) goto L28;
        r1.put("connection_sub_type", i.Z(this).b());
    L45:
        if (r14.j == false) goto L50;
        if (com.bytedance.android.live.revenuelink.connect.b.b(r14.d) == false) goto L50;
        r1.put("anchor_connect_status", "4");
        r1.put("connection_anchor_cnt", "4");
    L50:
        if (x.a(r14.d) == false) goto L53;
        r1.put("anchor_connect_status", "4");
        r1.put("connection_anchor_cnt", "4");
        r1.put("invite_mode", "routine_pk");
        r1.put("room_status", "pk");
        r1.put("source", "pk_banner");
    L53:
        if (x.b(r14.d) == false) goto L61;
        int r15 = r14.d;
        if (r15 != 11) goto L57;
    L58:
        r1.put("connection_sub_type", "random_individual");
    L59:
        r1.put("source", "link_banner");
        goto L61
    L57:
        if (r15 != 10) goto L59;
    L61:
        if (x.c(r14.d) == false) goto L78;
        r1.put("anchor_connect_status", "2");
        r1.put("connection_sub_type", "");
        o9 r16 = r14.o.f;
        if (r16 == null) goto L78;
        Intrinsics.checkNotNullParameter(r16, "$this$linkedUserSize");
        List r17 = r16.getLinkedUsers();
        if (r17 == null) goto L67;
        int r19 = r17.size();
    L68:
        Integer r24 = Integer.valueOf(r19);
        if (r24.intValue() <= 2) goto L71;
        boolean r25 = true;
    L72:
        if (r25 == false) goto L74;
        Integer r110 = r24;
    L75:
        if (r110 == null) goto L78;
        r1.put("anchor_connect_status", String.valueOf(r110.intValue()));
        r1.put("connection_sub_type", "manual_nlink");
        goto L78
    L74:
        r110 = null;
        goto L75
    L71:
        r25 = false;
        goto L72
    L67:
        r19 = 0;
    L78:
        if (r14.k == false) goto L96;
        int r26 = r14.l;
        if (r26 != 3) goto L82;
    L85:
        boolean r27 = true;
    L86:
        if (r27 == false) goto L96;
        int r28 = r14.o.d;
        if (r28 != 1) goto L90;
        r12 = "pk";
    L94:
        r1.put("inviter_from_room_status", r12);
        goto L96
    L90:
        if (r28 != 7) goto L94;
        r12 = "connection";
        goto L94
    L82:
        if (r26 == 4) goto L85;
        r27 = false;
    L96:
        if (r14.f == false) goto L102;
        if (r14.g == false) goto L100;
        r1.put("from_room_status", "pk");
    L106:
        if (r14.l != 1) goto L108;
        Object r0 = r18;
    L109:
        r1.put("is_manager", r0);
        if (r14.c != AnchorLinkInitType.PERMIT_AGREE_MSG) goto L113;
        r1.put("is_manager", DataType.FALSE);
    L113:
        g r29 = i.A(this);
        if (r29 != null) goto L116;
    L118:
        r1.put("if_strategy_invite", DataType.FALSE);
    L119:
        if (r23 == null) goto L123;
        Map<String, String> r30 = h.a(r23);
        if (r30 == null) goto L123;
        r1.putAll(r30);
    L123:
        r1.put("audience_connect_cnt", DataType.FALSE);
        mz0.n r32 = new mz0.n();
        o r33 = new o(r32.a);
        r33.b(r1);
        if (r20 == null) goto L126;
        e21.e.d(r33, r20);
    L126:
        e21.c.e(r33, r22);
        mz0.m r34 = new mz0.m();
        i.m(this).a(r34);
        r34.b(LogCommon.ROOM);
        r34.b(LogCommon.PAGE_SOURCE_LOG);
        List<Object> r35 = r32.b;
        ArrayList r36 = (ArrayList) r35;
        r36.addAll(r34.a);
        cy0.e.a.getClass();
        j r37 = cy0.e.a.a;
        com.bytedance.android.scope.m.e.getClass();
        Object r38 = com.bytedance.android.scope.m.b(r37).a(Reflection.getOrCreateKotlinClass(mz0.i.class));
        Intrinsics.checkNotNull(r38);
        ((mz0.i) ((f80.a) r38)).w3("livesdk_connection_success", r32.a, r32.b);
        return;
    L116:
        if (r29.b() != 13) goto L118;
        r1.put("if_strategy_invite", r18);
        goto L119
    L108:
        r0 = DataType.FALSE;
        goto L109
    L100:
        r1.put("from_room_status", "connection");
        goto L106
    L102:
        if (r14.c != AnchorLinkInitType.LINK_SWITCH_CHANNEL) goto L104;
        r1.put("from_room_status", "connection");
        goto L106
    L104:
        r1.put("from_room_status", "live");
        goto L106
    L28:
        int r39 = r14.d;
        if (r39 != 6) goto L32;
        r1.put("connection_sub_type", "random_npk");
        r1.put("room_status", "pk");
        r1.put("invite_mode", "team_pk");
        goto L45
    L32:
        if (r39 != 7) goto L35;
        r1.put("connection_sub_type", "random_individual");
        goto L45
    L35:
        if (r39 != 5) goto L38;
        r1.put("connection_sub_type", "manual_nlink");
        goto L45
    L38:
        if (r39 != 4) goto L41;
        r1.put("connection_sub_type", "random_nlink");
        r1.put("room_status", "connection");
        goto L45
    L41:
        if (r14.j == false) goto L43;
        r1.put("connection_sub_type", "manual_nlink");
        goto L45
    L43:
        r1.put("connection_sub_type", "");
        goto L45
    L112:
        r18 = DataType.TRUE;
        goto L113
    L5:
        if (r4.c != AnchorLinkInitType.PERMIT_AGREE_MSG) goto L7;
        r5 = "apply";
        goto L17
    L7:
        int r40 = r4.d;
        if (r40 == 4) goto L12;
        if (r40 == 6) goto L12;
        boolean r42 = false;
    L13:
        if (r42 == true) goto L16;
        r5 = "invite";
    L12:
        r42 = true;
        goto L13
    }
}
