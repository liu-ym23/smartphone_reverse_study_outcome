package com.bytedance.android.live.liveinteract.revenue.battle;

import android.text.TextUtils;
import com.bytedance.android.live.base.model.message.a1;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.StateMachine;
import com.bytedance.android.live.liveinteract.api.fulllink.LinkMonitorData;
import com.bytedance.android.live.liveinteract.plantform.monitor.MultiLinkEventModule;
import com.bytedance.android.live.liveinteract.plantform.utils.TalkRoomLogUtils;
import com.bytedance.android.livesdk.chatroom.viewmodel.LivePlayModeLogContext;
import com.bytedance.ies.sdk.widgets.Widget;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.subjects.BehaviorSubject;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\b\u001a\u00020\u00052\u0018\u0010\u0004\u001a\u0014\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0000¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"Lcom/bytedance/android/live/core/utils/StateMachine$c;", "Lcom/bytedance/android/live/liveinteract/revenue/battle/GuestBattleStateMachine$c;", "Lcom/bytedance/android/live/liveinteract/revenue/battle/GuestBattleStateMachine$a;", "Lcom/bytedance/android/live/liveinteract/revenue/battle/GuestBattleStateMachine$b;", "p1", "", "invoke", "(Lcom/bytedance/android/live/core/utils/StateMachine$c;)V", "<anonymous>"}, k = 3, mv = {1, 5, 1})
public final /* synthetic */ class GuestBattleWidget$stateMachine$1 extends FunctionReferenceImpl implements Function1<StateMachine.c<? extends GuestBattleStateMachine.c, ? extends GuestBattleStateMachine.a, ? extends GuestBattleStateMachine.b>, Unit> {
    public GuestBattleWidget$stateMachine$1(GuestBattleWidget r8) {
        super(1, r8, GuestBattleWidget.class, "listenState", "listenState(Lcom/bytedance/android/live/core/utils/StateMachine$Transition;)V", 0);
    }

    public final void invoke(StateMachine.c<? extends GuestBattleStateMachine.c, ? extends GuestBattleStateMachine.a, ? extends GuestBattleStateMachine.b> r33) {
        Intrinsics.checkNotNullParameter(r33, "p1");
        GuestBattleWidget r2 = (GuestBattleWidget) ((CallableReference) this).receiver;
        int r3 = GuestBattleWidget.u;
        r2.getClass();
        Integer r4 = null;
        if ((r33 instanceof StateMachine.c.b) == true) goto L5;
        StateMachine.c<? extends GuestBattleStateMachine.c, ? extends GuestBattleStateMachine.a, ? extends GuestBattleStateMachine.b> r5 = null;
    L6:
        StateMachine.c.b r6 = (StateMachine.c.b) r5;
        if (r6 == null) goto L179;
        GuestBattleStateMachine.b r7 = (GuestBattleStateMachine.b) r6.d;
        if (r7 == null) goto L180;
        GuestBattleStateMachine.c r8 = (GuestBattleStateMachine.c) ((StateMachine.c.b) r33).c;
        GuestBattleStateMachine.c r0 = (GuestBattleStateMachine.c) r33.b();
        com.bytedance.android.livesdk.chatroom.model.interact.a0 r9 = r8.a;
        ALogger.e("[GuestBattle]GuestBattleWidget", "transition fromState=" + r0 + " toState=" + r8 + " action=" + ((GuestBattleStateMachine.a) r6.b) + " effect=" + r7);
        GuestBattleContext r10 = r2.n;
        if (r10 == null) goto L18;
        com.bytedance.live.datacontext.n<com.bytedance.android.livesdk.chatroom.model.interact.a0> r11 = r10.getBattleInfo();
        if (r11 == null) goto L18;
        r11.setValue(r9);
    L18:
        if (r8.a() == false) goto L25;
        com.bytedance.live.datacontext.j r12 = com.bytedance.android.live.liveinteract.api.utils.m.e(r2).J();
        if (r12 == null) goto L33;
        LivePlayModeLogContext r13 = (LivePlayModeLogContext) r12.getValue();
        if (r13 == null) goto L33;
        r13.addPlayMode(5);
    L33:
        if (r2.isAnchor() == true) goto L55;
        LinkedHashMap r14 = new LinkedHashMap();
        ii0.a.c(r14, false);
        if (r0.b() == false) goto L50;
        if (r8.a() == false) goto L50;
        TalkRoomLogUtils.O(null, 5, r14, false, 19);
        ii0.a.b = true;
        Boolean r15 = com.bytedance.android.live.liveinteract.api.utils.m.i().isAnchor();
        if (r15 == null) goto L41;
        boolean r16 = r15.booleanValue();
    L42:
        if (r16 == false) goto L44;
    L46:
        boolean r17 = false;
    L47:
        if (r17 == false) goto L126;
        ii0.a.h();
    L126:
        if (Intrinsics.areEqual(r7, GuestBattleStateMachine.b.f.b) == false) goto L129;
        com.bytedance.android.live.liveinteract.api.fulllink.revenue.a.a(r9);
        r2.Jq(r9, true, false);
        r2.Lq();
    L168:
        com.bytedance.android.live.liveinteract.plantform.base.g r1 = com.bytedance.android.live.liveinteract.plantform.base.f.a();
        if (r1 == null) goto L177;
        BehaviorSubject<Boolean> r18 = r1.U4();
        if (r18 == null) goto L178;
        r18.onNext(Boolean.TRUE);
        return;
    L178:
        return;
    L177:
        return;
    L129:
        if (Intrinsics.areEqual(r7, GuestBattleStateMachine.b.i.b) == false) goto L132;
        r2.Kq(r9);
        goto L168
    L132:
        if (Intrinsics.areEqual(r7, GuestBattleStateMachine.b.h.b) == false) goto L140;
        GuestBattleContext r19 = r2.n;
        if (r19 == null) goto L138;
        com.bytedance.live.datacontext.m<Integer> r20 = r19.getBattleState();
        if (r20 == null) goto L138;
        r20.setValue(2);
    L138:
        r2.xq();
        r2.f = Observable.timer(r9.getShowDuration(), TimeUnit.SECONDS).observeOn(AndroidSchedulers.mainThread()).subscribe(new s(r2));
        goto L168
    L140:
        if (Intrinsics.areEqual(r7, GuestBattleStateMachine.b.d.b) == false) goto L143;
        com.bytedance.android.live.liveinteract.api.fulllink.revenue.a.a(r9);
        r2.Fq(r0.a);
        r2.Jq(r9, true, false);
        r2.Lq();
        goto L168
    L143:
        if (Intrinsics.areEqual(r7, GuestBattleStateMachine.b.c.b) == false) goto L151;
        GuestBattleContext r21 = r2.n;
        if (r21 == null) goto L149;
        com.bytedance.live.datacontext.m<Integer> r22 = r21.getBattleState();
        if (r22 == null) goto L149;
        r22.setValue(3);
    L149:
        r2.xq();
        r2.Fq(r9);
        ALogger.i("GuestBattleChest", "Battle onFinishGuestBattle!");
        ((Widget) r2).dataCenter.put("data_adjust_public_screen_for_subtitle", 0);
        goto L168
    L151:
        if ((r7 instanceof GuestBattleStateMachine.b.C0067b) == false) goto L160;
        long r23 = System.currentTimeMillis();
        long r24 = r2.i;
        if (r23 >= r24) goto L155;
        long r25 = (r24 - r23) / ((long) 1000);
    L156:
        r2.j = r25;
        r2.xq();
        ALogger.i("[GuestBattle]GuestBattleWidget", "pause guestBattle");
        if (((GuestBattleStateMachine.b.C0067b) r7).b == false) goto L168;
        r2.Kq(r9);
        goto L168
    L155:
        r25 = -1;
        goto L156
    L160:
        if ((r7 instanceof GuestBattleStateMachine.b.e) == false) goto L165;
        r2.Nq(r9);
        ALogger.i("[GuestBattle]GuestBattleWidget", "resume guestBattle");
        if (((GuestBattleStateMachine.b.e) r7).b == false) goto L168;
        r2.Kq(r9);
        goto L168
    L165:
        if (Intrinsics.areEqual(r7, GuestBattleStateMachine.b.g.b) == false) goto L167;
        r2.Jq(r9, false, true);
        r2.Lq();
        goto L168
    L167:
        Intrinsics.areEqual(r7, GuestBattleStateMachine.b.a.b);
        goto L168
    L44:
        if (hd0.c.f().h() == false) goto L46;
        r17 = true;
        goto L47
    L41:
        r16 = false;
    L50:
        if (r0.a() == false) goto L126;
        if (r8.b() == false) goto L126;
        TalkRoomLogUtils.N(null, 5, r14, 0, 19);
        ii0.a.b = false;
        ii0.a.g();
        goto L126
    L55:
        if (r0.b() == false) goto L60;
        if (r8.a() == false) goto L60;
        TalkRoomLogUtils.K(5, null, 11);
    L97:
        if ((r0 instanceof GuestBattleStateMachine.c.C0068c) == false) goto L103;
        if (r8.b() == true) goto L107;
        if ((r8 instanceof GuestBattleStateMachine.c.e) == false) goto L103;
    L107:
        if (r2.k <= 0) goto L109;
        long r26 = (System.currentTimeMillis() - r2.k) / ((long) 1000);
    L110:
        MultiLinkEventModule r27 = com.bytedance.android.live.liveinteract.api.fulllink.revenue.a.a;
        Intrinsics.checkNotNullParameter(r9, "guestBattleInfo");
        if (r26 > 0) goto L113;
    L124:
        ALogger.i("GuestBattleFullLinkMonitor", "finishGuestBattleSession return, cause: duration = " + r26);
        goto L126
    L113:
        if (r26 > 86400) goto L124;
        List r28 = r9.getRawResults();
        if (r28 == null) goto L118;
        int r29 = r28.size();
    L119:
        JSONObject r110 = new JSONObject();
        com.bytedance.android.live.liveinteract.api.fulllink.revenue.a.c(r9, r110);
        r110.put("duration", r26);
        List r111 = r9.getRawResults();
        if (r111 == null) goto L122;
        int r112 = r111.size();
    L123:
        r110.put("battler_cnt", r112);
        nd0.c.p(nd0.c.a, LinkMonitorData.FinishGuestBattleSessionSuccess, r110, com.bytedance.android.live.liveinteract.api.fulllink.revenue.a.a, 0, null, false, null, 120);
        ALogger.d("GuestBattleFullLinkMonitor", "finishGuestBattleSession, duration: " + r26 + ", battleCnt: " + r29);
        goto L126
    L122:
        r112 = 0;
        goto L123
    L118:
        r29 = 0;
        goto L119
    L109:
        r26 = 0;
    L103:
        if ((r8 instanceof GuestBattleStateMachine.c.d) == false) goto L126;
        if (r8.b() == false) goto L126;
    L60:
        if (r0.a() == false) goto L97;
        if (r8.b() == false) goto L97;
        List r30 = r9.getResults();
        if (r30 == null) goto L66;
        Integer r31 = Integer.valueOf(r30.size());
    L67:
        Integer r113 = Integer.valueOf(r31.intValue() - 1);
        List r32 = r9.getResults();
        if (r32 == null) goto L82;
        ArrayList r34 = new ArrayList();
        Iterator r35 = r32.iterator();
    L71:
        if (r35.hasNext() == false) goto L81;
        Object r114 = r35.next();
        com.bytedance.android.livesdk.chatroom.model.interact.a0.d r115 = (com.bytedance.android.livesdk.chatroom.model.interact.a0.d) r114;
        if (TextUtils.isEmpty(r115.getScore()) == true) goto L75;
    L77:
        boolean r116 = false;
    L78:
        if (r116 == false) goto L71;
        r34.add(r114);
        goto L71
    L75:
        if ((!Intrinsics.areEqual(r115.getScore(), "0")) == false) goto L77;
        r116 = true;
        goto L78
    L81:
        r4 = Integer.valueOf(r34.size());
    L82:
        Integer r117 = Integer.valueOf(r4.intValue());
        a1 r36 = r2.o;
        if (r36 == null) goto L85;
        int r37 = r36.getFinishReason();
    L86:
        Integer r118 = Integer.valueOf(r37);
        a1 r38 = r2.o;
        if (r38 == null) goto L90;
        String r39 = r38.getFinishUserIdStr();
        if (r39 == null) goto L90;
    L91:
        String r119 = r39;
        if (r2.isAnchor() == false) goto L94;
        String r40 = "anchor";
    L95:
        TalkRoomLogUtils.L(5, r113, r117, r118, r119, r40, null, 259);
        MultiLinkEventModule r41 = com.bytedance.android.live.liveinteract.api.fulllink.revenue.a.a;
        Intrinsics.checkNotNullParameter(r9, "guestBattleInfo");
        JSONObject r42 = new JSONObject();
        com.bytedance.android.live.liveinteract.api.fulllink.revenue.a.c(r9, r42);
        r42.put("reason", r9.getFinishReason());
        r42.put("finish_toast", r9.getFinishToast());
        nd0.c.p(nd0.c.a, LinkMonitorData.FinishGuestBattleSuccess, r42, com.bytedance.android.live.liveinteract.api.fulllink.revenue.a.a, 0, null, false, null, 120);
        ALogger.d("GuestBattleFullLinkMonitor", "finishGuestBattle, reason: " + r9.getFinishReason() + ", toast: " + r9.getFinishToast());
        goto L97
    L94:
        r40 = "admin";
    L90:
        r39 = "";
        goto L91
    L85:
        r37 = 0;
        goto L86
    L66:
        r31 = null;
        goto L67
    L25:
        if (r8.b() == false) goto L33;
        com.bytedance.live.datacontext.j r43 = com.bytedance.android.live.liveinteract.api.utils.m.e(r2).J();
        if (r43 == null) goto L31;
        LivePlayModeLogContext r44 = (LivePlayModeLogContext) r43.getValue();
        if (r44 == null) goto L31;
        r44.removePlayMode(5);
    L31:
        MultiLinkEventModule r45 = com.bytedance.android.live.liveinteract.api.fulllink.revenue.a.a;
        ALogger.d("GuestBattleFullLinkMonitor", "reset");
        com.bytedance.android.live.liveinteract.api.fulllink.revenue.a.b = false;
        com.bytedance.android.live.liveinteract.api.fulllink.revenue.a.d.a();
        goto L33
    L180:
        return;
    L179:
        return;
    L5:
        r5 = r33;
        goto L6
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        invoke((StateMachine.c) r1);
        return Unit.INSTANCE;
    }
}
