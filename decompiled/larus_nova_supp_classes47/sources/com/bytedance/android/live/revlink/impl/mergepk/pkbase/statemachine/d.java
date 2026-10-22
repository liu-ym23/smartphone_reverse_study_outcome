package com.bytedance.android.live.revlink.impl.mergepk.pkbase.statemachine;

import com.bytedance.android.live.network.response.ExtraResponse;
import com.bytedance.android.live.revlink.impl.utils.t;
import com.bytedance.android.livesdk.link.model.IBattleBarConfig;
import com.bytedance.android.livesdk.link.model.api.IBaseBattleSetting;
import com.bytedance.android.livesdk.link.model.f1;
import com.bytedance.android.livesdk.link.model.g1;
import com.bytedance.android.livesdk.link.model.l9;
import com.bytedance.android.livesdk.link.model.n3;
import com.bytedance.android.livesdk.link.model.u1;
import com.bytedance.android.livesdk.link.model.z4;
import io.reactivex.functions.Consumer;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class d<T> implements Consumer {
    public final /* synthetic */ PkStateMachineController a;
    public final /* synthetic */ long b;
    public final /* synthetic */ PkBaseStateMachine.Source c;
    public final /* synthetic */ long d;

    public d(PkStateMachineController r1, long r2, PkBaseStateMachine.Source r4, long r5) {
        this.a = r1;
        this.b = r2;
        this.c = r4;
        this.d = r5;
    }

    public final void accept(Object r46) {
        ExtraResponse r1 = (ExtraResponse) r46;
        com.bytedance.android.live.revlink.impl.global.c r2 = this.a.k;
        if (r2 == null) goto L5;
        b21.e r4 = r2.Gm();
    L6:
        if (r4 == null) goto L8;
        long r5 = this.b;
        PkBaseStateMachine.Source r7 = this.c;
        long r9 = t.a(this.d);
        int r12 = ((Number) this.a.m.invoke()).intValue();
        int r3 = b21.e.b;
        r4.e(r5, r7, null, r9, r12);
    L8:
        PkBaseStateMachine.Source r6 = this.c;
        PkBaseStateMachine.Source r8 = PkBaseStateMachine.Source.RoomClose;
        if (r6 != r8) goto L13;
        d51.c r10 = d51.c.A0;
        r10.getClass();
        if (((Boolean) d51.c.l0.getValue(r10, d51.c.a[62])).booleanValue() == false) goto L13;
        return;
    L13:
        PkStateMachineController.a r13 = this.a.d;
        if (r13 == null) goto L16;
        r13.onFinishCallback(this.c, (f1) r1.data, null);
    L16:
        PkBaseStateMachine.Source r14 = this.c;
        PkBaseStateMachine.Source r15 = PkBaseStateMachine.Source.PunishTimeUp;
        if (r14 == r15) goto L75;
        PkStateMachineController r16 = this.a;
        if (r16.h(r16.n, null) == false) goto L73;
        PkStateMachineController r17 = this.a;
        f1 r18 = (f1) r1.data;
        r17.getClass();
        if (r18 == null) goto L85;
        int r19 = a.p;
        g1 r20 = r18.getFinishInfo();
        if (r20 == null) goto L37;
        u1 r22 = r20.getBattleSetting();
        List r23 = r20.getBattleScorePairList();
        u1 r24 = r20.getBattleSetting();
        if (r24 == null) goto L28;
        IBattleBarConfig r110 = r24.getBarConfig();
    L29:
        com.bytedance.android.live.revlink.impl.mergepk.pkbase.b r111 = new com.bytedance.android.live.revlink.impl.mergepk.pkbase.b(r20.getSkinType(), r20.getSkinConfig());
        Map r25 = r20.getGradeChanges();
        n3 r112 = r20.getBreakthroughInfo();
        Map r113 = r20.getBattleUserInfoMap();
        l9 r114 = r20.getSurvivalInfo();
        Map<String, String> r26 = h41.h.a(r20.getEventTrackingInfo());
        z4 r27 = r20.getFinishExtra();
        List r115 = CollectionsKt.toList(r23);
        if (r25 == null) goto L32;
        Map r116 = MapsKt.toMap(r25);
    L33:
        if (r113 == null) goto L35;
        Map r28 = MapsKt.toMap(r113);
    L36:
        a r29 = new a(r22, r28, r115, null, 0, r110, r111, r116, r112, r114, null, null, r26, r27, null, 19480);
    L38:
        com.bytedance.android.live.revlink.impl.global.c r30 = r17.k;
        if (r30 == null) goto L41;
        d21.d r32 = r30.getMergePkHelper();
    L42:
        if (r32 == null) goto L48;
        g1 r33 = r18.getFinishInfo();
        if (r33 == null) goto L46;
        int r34 = r33.getEndReason();
    L47:
        PkBaseStateMachine.Source r35 = d21.d.b(r34);
    L50:
        if (r35 != PkBaseStateMachine.Source.MultipleInvite) goto L52;
    L72:
        r17.j.a(new PkBaseStateMachine.a.c(r29, r8));
        return;
    L52:
        if (r35 == PkBaseStateMachine.Source.CutShort) goto L72;
        if (r35 == r8) goto L72;
        if (r35 == PkBaseStateMachine.Source.NormalToMultiple) goto L72;
        PkBaseStateMachine.Source r36 = PkBaseStateMachine.Source.RtcLinkerLeave;
        if (r35 != r36) goto L61;
        r17.j.a(new PkBaseStateMachine.a.d(r29, r36));
        return;
    L61:
        if ((((PkBaseStateMachine.c) r17.j.a.a.get()) instanceof PkBaseStateMachine.c.C0130c) == false) goto L77;
        r17.j.a(new PkBaseStateMachine.a.C0128a(r29, PkBaseStateMachine.Source.BattleFinishResponse));
        IBaseBattleSetting r37 = r29.a;
        if (r37 != null) goto L65;
        return;
    L65:
        if (af2.d.d(r37) == true) goto L67;
        return;
    L67:
        if (r17.n == false) goto L80;
        jy0.b.c("ttlive_PkStateMachine", "anchor call finishPk when handleBattleFinishResp", null, 4);
        if (d51.c.A0.i() == false) goto L71;
        r17.j();
        return;
    L71:
        r17.c(r15);
        return;
    L80:
        return;
    L77:
        return;
    L46:
        r34 = 0;
        goto L47
    L48:
        r35 = null;
        goto L50
    L41:
        r32 = null;
        goto L42
    L35:
        r28 = null;
        goto L36
    L32:
        r116 = null;
        goto L33
    L28:
        r110 = null;
        goto L29
    L37:
        r29 = new a(null, null, null, null, 0, null, null, null, null, null, null, null, null, null, null, 32767);
        goto L38
    L85:
        return;
    L73:
        PkStateMachineController.e(this.a, this.c, null, 0, 62);
        return;
    L75:
        return;
    L5:
        r4 = null;
        goto L6
    }
}
