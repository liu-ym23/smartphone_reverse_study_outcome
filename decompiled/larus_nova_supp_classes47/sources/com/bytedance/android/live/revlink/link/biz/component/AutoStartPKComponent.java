package com.bytedance.android.live.revlink.link.biz.component;

import com.bytedance.android.live.profile.monitor.DataType;
import com.bytedance.android.live.revlink.impl.mergepk.params.BattleInviteType;
import com.bytedance.android.live.revlink.impl.mergepk.params.LinkmicBizType;
import com.bytedance.android.live.revlink.impl.mergepk.pkbase.PkBaseDataContext;
import com.bytedance.android.live.revlink.impl.model.BizType;
import com.bytedance.android.live.revlink.impl.multianchor.constants.PlayMode;
import com.bytedance.android.live.revlink.impl.multianchor.utils.u;
import com.bytedance.android.live.revlink.link.infra.rtcbiz.RTCAdvanceManagerService;
import com.bytedance.android.live.revlink.link.utils.UtilsKt;
import com.bytedance.android.livesdk.link.model.IBattleConfigSetting;
import com.bytedance.android.livesdk.link.model.aa;
import com.bytedance.android.livesdk.link.model.h9;
import com.bytedance.android.livesdk.link.model.w2;
import io.reactivex.disposables.CompositeDisposable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class AutoStartPKComponent implements com.bytedance.android.live.revlink.link.biz.service.c {
    public final String a;
    public boolean b;
    public int c;
    public long d;
    public final CompositeDisposable e;
    public final com.bytedance.android.live.revlink.link.infra.lifecontrol.context.a f;
    public final MultiPKContextHolder g;
    public final RTCAdvanceManagerService h;
    public final k11.f i;

    /* JADX INFO: renamed from: com.bytedance.android.live.revlink.link.biz.component.AutoStartPKComponent$attach$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\b\u001a\u00020\u00052\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u00002\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"", "Lcom/bytedance/android/livesdk/link/model/p;", "p1", "", "p2", "", "invoke", "(Ljava/util/List;I)V", "<anonymous>"}, k = 3, mv = {1, 5, 1})
    public static final /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function2<List<? extends com.bytedance.android.livesdk.link.model.p>, Integer, Unit> {
        public AnonymousClass1(AutoStartPKComponent r8) {
            super(2, r8, AutoStartPKComponent.class, "onOnlineListChange", "onOnlineListChange(Ljava/util/List;I)V", 0);
        }

        public final void invoke(List<? extends com.bytedance.android.livesdk.link.model.p> r2, int r3) {
            Intrinsics.checkNotNullParameter(r2, "p1");
            AutoStartPKComponent r4 = (AutoStartPKComponent) ((CallableReference) this).receiver;
            r4.getClass();
            if (r2.size() >= 2) goto L5;
            return;
        L5:
            if (r4.b == true) goto L9;
            r4.b = true;
            r4.a();
            return;
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            invoke((List) r1, ((Number) r2).intValue());
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: renamed from: com.bytedance.android.live.revlink.link.biz.component.AutoStartPKComponent$attach$2, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"<anonymous>", "", "p1", "", "invoke", "(Ljava/lang/Long;)V"}, k = 3, mv = {1, 5, 1})
    public static final /* synthetic */ class AnonymousClass2 extends FunctionReferenceImpl implements Function1<Long, Unit> {
        public AnonymousClass2(AutoStartPKComponent r8) {
            super(1, r8, AutoStartPKComponent.class, "onRtcHasReceiveChange", "onRtcHasReceiveChange(Ljava/lang/Long;)V", 0);
        }

        public final void invoke(Long r4) {
            AutoStartPKComponent r0 = (AutoStartPKComponent) ((CallableReference) this).receiver;
            r0.getClass();
            if (r4 == null) goto L6;
            r4.longValue();
            r0.d = r4.longValue();
            r0.a();
            return;
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1) {
            invoke((Long) r1);
            return Unit.INSTANCE;
        }
    }

    @Override // com.bytedance.android.live.revlink.link.biz.service.e
    public final String getTAG() {
        return "RevenueLinkAnchorComponent";
    }

    public final void a() {
        String r3 = null;
        jy0.b.c(com.bytedance.android.live.revlink.link.biz.service.e.a.a(this), "handleAutoStartBattle with bizType: " + this.c + ",  hasAllJoinChannel: " + this.b + ", context.channelID: " + getContext().G() + ", receivedReplyChannelID: " + this.d, null, 4);
        int r1 = this.c;
        BizType r2 = BizType.PK;
        if (r1 == r2.ordinal()) goto L8;
        if (this.c == BizType.OpenGame.ordinal()) goto L8;
        return;
    L8:
        if (this.d != getContext().G()) goto L10;
    L12:
        int r4 = this.c;
        if (r4 != r2.ordinal()) goto L121;
        u r5 = com.bytedance.android.live.revlink.link.biz.service.i.y(this);
        if (r5 == null) goto L19;
        int r6 = r5.D;
        int r7 = com.bytedance.android.live.revlink.impl.mergepk.pkdouble.d.a;
        if (r6 != 2) goto L19;
        boolean r8 = true;
    L20:
        if (r8 == false) goto L23;
        long r9 = l51.a.f();
    L22:
        long r10 = r9;
        if (r8 == false) goto L31;
        u r12 = com.bytedance.android.live.revlink.link.biz.service.i.y(this);
        if (r12 == null) goto L31;
        aa r13 = r12.E;
    L32:
        u r14 = com.bytedance.android.live.revlink.link.biz.service.i.y(this);
        if (r14 == null) goto L37;
        IBattleConfigSetting r15 = r14.M;
        if (r15 == null) goto L37;
        h9 r16 = r15.getSpecifyGiftConfig();
    L38:
        u r17 = com.bytedance.android.live.revlink.link.biz.service.i.y(this);
        if (r17 == null) goto L43;
        IBattleConfigSetting r18 = r17.M;
        if (r18 == null) goto L43;
        w2 r19 = r18.getShellConfig();
    L44:
        u r20 = com.bytedance.android.live.revlink.link.biz.service.i.y(this);
        if (r20 == null) goto L51;
        IBattleConfigSetting r22 = r20.M;
        if (r22 == null) goto L51;
        if (r22.getModType() != PkBaseDataContext.PKModType.SeasonRank.getType()) goto L51;
        boolean r110 = true;
    L52:
        u r23 = com.bytedance.android.live.revlink.link.biz.service.i.y(this);
        if (r23 == null) goto L59;
        IBattleConfigSetting r24 = r23.M;
        if (r24 == null) goto L59;
        if (r24.getModType() != PkBaseDataContext.PKModType.InteractPk.getType()) goto L59;
        boolean r25 = true;
    L60:
        BattleInviteType r111 = BattleInviteType.UNKNOWN;
        u r26 = com.bytedance.android.live.revlink.link.biz.service.i.y(this);
        if (r26 == null) goto L66;
        String r27 = r26.B;
        if (r27 == null) goto L66;
        String r112 = r27;
    L68:
        if (u41.a.c.a() == false) goto L78;
        int r28 = com.bytedance.android.live.revenue.common.h.a;
        StringBuilder r29 = new StringBuilder();
        r29.append(String.valueOf(com.bytedance.android.live.revlink.link.biz.service.i.d(this).getChannelId()));
        u r30 = com.bytedance.android.live.revlink.link.biz.service.i.y(this);
        if (r30 == null) goto L72;
        Integer r32 = Integer.valueOf(r30.A);
    L73:
        r29.append(r32);
        r29.append(DataType.FALSE);
        u r33 = com.bytedance.android.live.revlink.link.biz.service.i.y(this);
        if (r33 == null) goto L76;
        Integer r34 = Integer.valueOf(r33.d);
    L77:
        r29.append(r34);
        String r35 = com.bytedance.android.live.revenue.common.h.a(r29.toString());
    L79:
        c21.e.a r113 = new c21.e.a(r10, 7, null, r111, r112, r35, null, null, 452);
        u r36 = com.bytedance.android.live.revlink.link.biz.service.i.y(this);
        if (r36 == null) goto L85;
        IBattleConfigSetting r37 = r36.M;
        if (r37 == null) goto L85;
        String r38 = r37.getActivityId();
        if (r38 == null) goto L85;
    L87:
        if (r38.length() <= 0) goto L89;
        boolean r210 = true;
    L90:
        if (r210 == false) goto L93;
        c21.e r39 = new c21.e(r113, new c21.f.e(r38), "FlexActivityPk");
    L108:
        c21.e r40 = r39;
    L109:
        HashMap r42 = new HashMap();
        k11.c r43 = this.i.a();
        if (r43 != null) goto L112;
    L117:
        com.bytedance.android.live.revlink.impl.mergepk.pkbase.launcher.a r44 = this.g.c.getBasePKContext().getPkAnchorLauncher();
        if (r44 == null) goto L137;
        com.bytedance.android.live.revlink.impl.mergepk.pkbase.launcher.a.g.a(r44, r40, null, r42, 2);
    L137:
        this.c = BizType.None.ordinal();
        return;
    L112:
        if (r43.b != getContext().G()) goto L117;
        Map<String, String> r45 = r43.c;
        if (r45 != null) goto L116;
        r45 = MapsKt.emptyMap();
    L116:
        r42.putAll(r45);
        goto L117
    L93:
        if (r13 == null) goto L95;
        r40 = new c21.e(r113, new c21.f.m(7, r13), "Vote");
        goto L109
    L95:
        if (r16 == null) goto L97;
        r39 = new c21.e(r113, new c21.f.l(7, PlayMode.PERSONAL_PK, r16), "SpecifyGiftPk");
        goto L108
    L97:
        if (r19 == null) goto L99;
        r39 = new c21.e(r113, new c21.f.k(7, PlayMode.PERSONAL_PK, r19), "ShellPk");
        goto L108
    L99:
        if (r110 == false) goto L101;
        r39 = new c21.e(r113, c21.f.j.b, "SeasonRank");
        goto L108
    L101:
        if (r25 == false) goto L107;
        PlayMode r46 = PlayMode.PERSONAL_PK;
        u r47 = com.bytedance.android.live.revlink.link.biz.service.i.y(this);
        if (r47 == null) goto L105;
        IBattleConfigSetting r48 = r47.M;
    L106:
        r39 = new c21.e(r113, new c21.f.C0009f(7, r46, r48), "InteractPk");
        goto L108
    L105:
        r48 = null;
        goto L106
    L107:
        r39 = new c21.e(r113, new c21.f.h(7, PlayMode.PERSONAL_PK), "NormalPk");
        goto L108
    L89:
        r210 = false;
    L85:
        r38 = "";
        goto L87
    L76:
        r34 = null;
        goto L77
    L72:
        r32 = null;
        goto L73
    L78:
        r35 = "";
    L66:
        r112 = "";
    L59:
        r25 = false;
    L51:
        r110 = false;
    L43:
        r19 = null;
    L37:
        r16 = null;
    L31:
        r13 = null;
        goto L32
    L23:
        u r49 = com.bytedance.android.live.revlink.link.biz.service.i.y(this);
        if (r49 == null) goto L26;
        r9 = r49.A;
        goto L22
    L26:
        r9 = 300;
    L19:
        r8 = false;
        goto L20
    L121:
        if (r4 != BizType.OpenGame.ordinal()) goto L137;
        u r50 = com.bytedance.android.live.revlink.link.biz.service.i.y(this);
        if (r50 == null) goto L125;
        r3 = r50.F;
    L125:
        String r52 = r3;
        if (r52 != null) goto L128;
    L131:
        boolean r53 = true;
    L132:
        if (r53 == true) goto L137;
        c21.h r54 = new c21.h(0, LinkmicBizType.LinkmicBizTypeOpenGame, r52, false, 57);
        com.bytedance.android.live.revlink.impl.mergepk.pkbase.launcher.a r55 = this.g.c.getBasePKContext().getPkAnchorLauncher();
        if (r55 == null) goto L137;
        r55.k(new c21.k(r54, "switch_scene_bizStart"));
        goto L137
    L128:
        if (r52.length() == 0) goto L131;
        r53 = false;
        goto L132
    L10:
        if (this.b == true) goto L12;
    }

    @Override // com.bytedance.android.live.revlink.link.biz.service.e
    public final void detach() {
        this.e.clear();
    }

    @Override // com.bytedance.android.live.revlink.link.biz.service.e
    public final void attach() {
        u r0 = com.bytedance.android.live.revlink.link.biz.service.i.y(this);
        boolean r2 = false;
        if (r0 == null) goto L7;
        int r1 = r0.D;
        int r3 = com.bytedance.android.live.revlink.impl.mergepk.pkdouble.d.a;
        if (r1 != 1) goto L7;
        boolean r4 = true;
    L9:
        if (r4 == false) goto L12;
        jy0.b.c(com.bytedance.android.live.revlink.link.biz.service.e.a.a(this), "return for peak to link", null, 4);
        return;
    L12:
        u r5 = com.bytedance.android.live.revlink.link.biz.service.i.y(this);
        if (r5 == null) goto L15;
        r2 = r5.v;
    L15:
        if (r2 == false) goto L18;
        jy0.b.c(com.bytedance.android.live.revlink.link.biz.service.e.a.a(this), "return for is starter", null, 4);
        return;
    L18:
        u r6 = com.bytedance.android.live.revlink.link.biz.service.i.y(this);
        if (r6 == null) goto L21;
        int r7 = r6.i;
    L22:
        this.c = r7;
        a();
        com.bytedance.revenue.platform.api.core.rx.f.a(com.bytedance.android.live.revlink.link.biz.service.i.t(this).m(new AnonymousClass1(this)), this.e);
        if (((CopyOnWriteArrayList) com.bytedance.android.live.revlink.link.biz.service.i.t(this).a).size() >= 2) goto L25;
    L27:
        com.bytedance.revenue.platform.api.core.rx.f.a(UtilsKt.i(this.h.a, new AnonymousClass2(this)), this.e);
        return;
    L25:
        if (this.b == true) goto L27;
        this.b = true;
        a();
        goto L27
    L21:
        r7 = BizType.None.ordinal();
    L7:
        r4 = false;
        goto L9
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
        return this.f;
    }

    public AutoStartPKComponent(com.bytedance.android.live.revlink.link.infra.lifecontrol.context.g r2, MultiPKContextHolder r3, RTCAdvanceManagerService r4, k11.f r5) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "pkContextHolder");
        Intrinsics.checkNotNullParameter(r4, "rtcAdvanceManagerService");
        Intrinsics.checkNotNullParameter(r5, "dynamicInfoService");
        this.f = r2;
        this.g = r3;
        this.h = r4;
        this.i = r5;
        this.a = "AutoStartPKComponent";
        this.c = BizType.None.ordinal();
        this.e = new CompositeDisposable();
    }
}
