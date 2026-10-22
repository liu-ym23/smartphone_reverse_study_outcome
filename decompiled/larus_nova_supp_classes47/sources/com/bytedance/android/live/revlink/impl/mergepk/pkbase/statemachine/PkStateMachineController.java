package com.bytedance.android.live.revlink.impl.mergepk.pkbase.statemachine;

import androidx.lifecycle.MutableLiveData;
import com.bytedance.android.live.base.exception.ApiServerException;
import com.bytedance.android.live.base.model.Extra;
import com.bytedance.android.live.base.model.message.m0;
import com.bytedance.android.live.network.response.ExtraResponse;
import com.bytedance.android.live.profile.monitor.DataType;
import com.bytedance.android.live.revenue.common.k;
import com.bytedance.android.live.revenue.common.message.CommonMessageTypeKt;
import com.bytedance.android.live.revenue.common.v;
import com.bytedance.android.live.revlink.impl.LinkCrossRoomDataHolder;
import com.bytedance.android.live.revlink.impl.mergepk.pkbase.subdatacontext.PkBaseTimeDataContext;
import com.bytedance.android.live.revlink.impl.multianchor.utils.AnchorLinkOptUtils;
import com.bytedance.android.live.revlink.impl.multianchor.utils.z;
import com.bytedance.android.live.revlink.impl.pk.utils.q;
import com.bytedance.android.live.revlink.impl.plantform.AnchorLinkUserCenterV2;
import com.bytedance.android.live.revlink.impl.utils.s;
import com.bytedance.android.live.revlink.impl.utils.t;
import com.bytedance.android.live.schema.api.WebcastRedirectException;
import com.bytedance.android.livesdk.link.model.IBattleBarConfig;
import com.bytedance.android.livesdk.link.model.IBattleConfigSetting;
import com.bytedance.android.livesdk.link.model.IBattleUserInfo;
import com.bytedance.android.livesdk.link.model.a5;
import com.bytedance.android.livesdk.link.model.api.IBaseBattleSetting;
import com.bytedance.android.livesdk.link.model.bridge.h1;
import com.bytedance.android.livesdk.link.model.bridge.i1;
import com.bytedance.android.livesdk.link.model.bridge.r0;
import com.bytedance.android.livesdk.link.model.bridge.y1;
import com.bytedance.android.livesdk.link.model.c1;
import com.bytedance.android.livesdk.link.model.c3;
import com.bytedance.android.livesdk.link.model.c5;
import com.bytedance.android.livesdk.link.model.f1;
import com.bytedance.android.livesdk.link.model.i3;
import com.bytedance.android.livesdk.link.model.i6;
import com.bytedance.android.livesdk.link.model.n3;
import com.bytedance.android.livesdk.link.model.p0;
import com.bytedance.android.livesdk.link.model.r;
import com.bytedance.android.livesdk.link.model.u1;
import com.bytedance.android.livesdk.link.model.y4;
import com.bytedance.android.livesdk.message.model.qj;
import com.bytedance.android.livesdk.message.model.u8;
import com.bytedance.android.livesdk.message.model.v8;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.IRoomKt_androidKt;
import com.bytedance.badger.collect.impl.constants.Constants;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.bytedance.revenue.platform.api.core.rx.l;
import com.bytedance.revenue.platform.api.core.rx.p;
import io.reactivex.Observable;
import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.properties.ReadOnlyProperty;
import kotlin.reflect.KProperty;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class PkStateMachineController {
    public final MutableLiveData<PkBaseStateMachine.b> a;
    public final MutableLiveData b;
    public final PkBaseTimeDataContext c;
    public a d;
    public final h e;
    public Disposable f;
    public final CompositeDisposable g;
    public com.bytedance.android.live.revlink.impl.mergepk.pkbase.statemachine.a h;
    public Disposable i;
    public final PkBaseStateMachine j;
    public final com.bytedance.android.live.revlink.impl.global.c k;
    public final i11.b l;
    public final Function0<Integer> m;
    public final boolean n;
    public final IRoom o;
    public final yz0.f p;

    public interface a {
        void onFinishCallback(PkBaseStateMachine.Source r1, f1 r2, Throwable r3);

        void onReceiveBattleEndPunishMsg(y4 r1);

        void onReceiveBattleFinishMsg(a5 r1);

        void onReceiveBattleMsg(c5 r1);

        void updateBattleStatsMeta(c3 r1);

        void updateBizExtra(c3 r1, r.b r2);
    }

    public static final class b {
    }

    public static final class c<T> implements Consumer {
        public final /* synthetic */ PkStateMachineController a;
        public final /* synthetic */ long b;
        public final /* synthetic */ PkBaseStateMachine.Source c;
        public final /* synthetic */ String d;
        public final /* synthetic */ Function2 e;
        public final /* synthetic */ long f;
        public final /* synthetic */ Function2 g;

        public c(PkStateMachineController r1, long r2, PkBaseStateMachine.Source r4, String r5, Function2 r6, long r7, Function2 r9) {
            this.a = r1;
            this.b = r2;
            this.c = r4;
            this.d = r5;
            this.e = r6;
            this.f = r7;
            this.g = r9;
        }

        public final void accept(Object r14) {
            ExtraResponse<r, Extra> r15 = (ExtraResponse) r14;
            i97.a r0 = i97.a.a;
            long r8 = System.currentTimeMillis();
            z r1 = this.a.g();
            if (r1 == null) goto L5;
            z.p(r1, ((Number) this.a.m.invoke()).intValue(), this.b, r15, this.c.toString(), this.d);
        L5:
            Function2 r2 = this.e;
            AnchorLinkOptUtils r3 = null;
            i11.b r4 = null;
            if (r2 == null) goto L11;
            if (r15 == null) goto L9;
            r r5 = (r) r15.data;
        L10:
            Unit r6 = (Unit) r2.invoke(r5, Long.valueOf(this.f));
            goto L11
        L9:
            r5 = null;
        L11:
            boolean r7 = false;
            if (r15 == null) goto L68;
            r r9 = (r) r15.data;
            if (r9 == null) goto L68;
            c3 r10 = r9.getBattleStatsMeta();
            if (r10 == null) goto L68;
            PkStateMachineController r12 = this.a;
            PkBaseStateMachine.Source r13 = this.c;
            r r16 = (r) r15.data;
            if (r16 == null) goto L20;
            r.b r17 = r16.getBizExtra();
        L21:
            r12.getClass();
            jy0.b.c("ttlive_PkStateMachine", "getBattleState succeed", null, 4);
            if (r17 == null) goto L26;
            a r18 = r12.d;
            if (r18 == null) goto L26;
            r18.updateBizExtra(r10, r17);
        L26:
            int r19 = com.bytedance.android.live.revlink.impl.mergepk.pkbase.statemachine.a.p;
            com.bytedance.android.live.revlink.impl.mergepk.pkbase.statemachine.a r110 = com.bytedance.android.live.revlink.impl.mergepk.pkbase.statemachine.a.C0134a.a(r10);
            if (r17 == null) goto L31;
            y1 r20 = r17.getOpenGameInfo();
            if (r20 == null) goto L31;
            String r22 = r20.getAppId();
        L32:
            if (r22 != null) goto L34;
        L35:
            r7 = true;
        L36:
            if (r7 == true) goto L39;
            r12.j.a(PkBaseStateMachine.a.j.c);
        L42:
            c1 r23 = r10.getBattleSetting();
            if (r23 != null) goto L45;
        L52:
            a r24 = r12.d;
            if (r24 == null) goto L55;
            r24.updateBattleStatsMeta(r10);
        L55:
            PkStateMachineController r25 = this.a;
            long r26 = r8 - this.f;
            int r27 = ((Number) r25.m.invoke()).intValue();
            z41.g r111 = z41.g.o;
            r111.getClass();
            if (((Boolean) z41.g.c.getValue(r111, z41.g.a[1])).booleanValue() == false) goto L65;
            i11.b r28 = r25.l;
            if ((r28 instanceof AnchorLinkUserCenterV2) == false) goto L62;
            r4 = r28;
        L62:
            AnchorLinkUserCenterV2 r29 = (AnchorLinkUserCenterV2) r4;
            if (r29 == null) goto L65;
            int r30 = AnchorLinkUserCenterV2.u;
            r29.O("getBattleStats for double", r15, r26, 2, r27, false);
        L65:
            Function2 r112 = this.g;
            if (r112 == null) goto L79;
            Unit r113 = (Unit) r112.invoke(Long.valueOf(this.f), Long.valueOf(r8));
            return;
        L79:
            return;
        L45:
            if (af2.d.d(r23) != true) goto L52;
            if (r12.n == false) goto L52;
            jy0.b.c("ttlive_PkStateMachine", "anchor call finishPk after getBattleState", null, 4);
            if (d51.c.A0.i() == false) goto L51;
            r12.j();
            goto L52
        L51:
            r12.c(PkBaseStateMachine.Source.PunishTimeUp);
            goto L52
        L39:
            if (r13 != PkBaseStateMachine.Source.MetaUpdate) goto L41;
            r12.j.a(new PkBaseStateMachine.a.e(r110));
            goto L42
        L41:
            r12.j.a(new PkBaseStateMachine.a.i(r110, r13, true));
            goto L42
        L34:
            if (r22.length() != 0) goto L36;
        L31:
            r22 = null;
            goto L32
        L20:
            r17 = null;
        L68:
            PkStateMachineController r114 = this.a;
            r114.j.a(PkBaseStateMachine.a.b.c);
            if (StringsKt.contains$default(this.d, "_retry", false, 2, null) == true) goto L77;
            com.bytedance.android.live.revlink.impl.global.c r32 = r114.k;
            if (r32 == null) goto L73;
            r3 = r32.vk();
        L73:
            if (r3 == null) goto L77;
            if (r3.a() != true) goto L77;
            PkStateMachineController.e(r114, this.c, "finish_pk_retry", 0, 60);
        L77:
            Unit r115 = Unit.INSTANCE;
        }
    }

    public static final class d<T> implements Consumer {
        public final /* synthetic */ PkStateMachineController a;
        public final /* synthetic */ long b;
        public final /* synthetic */ PkBaseStateMachine.Source c;
        public final /* synthetic */ String d;
        public final /* synthetic */ Function1 e;
        public final /* synthetic */ long f;

        public d(PkStateMachineController r1, long r2, PkBaseStateMachine.Source r4, String r5, Function1 r6, long r7) {
            this.a = r1;
            this.b = r2;
            this.c = r4;
            this.d = r5;
            this.e = r6;
            this.f = r7;
        }

        public final void accept(Object r29) {
            ApiServerException r9 = (Throwable) r29;
            z r1 = this.a.g();
            if (r1 == null) goto L5;
            r1.o(((Number) this.a.m.invoke()).intValue(), this.b, null, this.c.toString(), this.d, r9);
        L5:
            Function1 r2 = this.e;
            if (r2 == null) goto L9;
            Unit r3 = (Unit) r2.invoke(Long.valueOf(this.f));
        L9:
            if (StringsKt.contains$default(this.d, "_retry", false, 2, null) == true) goto L26;
            com.bytedance.android.live.revlink.impl.global.c r4 = this.a.k;
            if (r4 == null) goto L13;
            AnchorLinkOptUtils r5 = r4.vk();
        L14:
            if (r5 == null) goto L26;
            if (r5.a() != true) goto L26;
            if ((r9 instanceof ApiServerException) == true) goto L20;
            ApiServerException r6 = null;
        L21:
            ApiServerException r7 = r6;
            if (r7 != null) goto L24;
        L25:
            PkStateMachineController.e(this.a, this.c, "finish_pk_retry", 0, 60);
            return;
        L24:
            if (r7.getErrorCode() == 31001) goto L26;
        L20:
            r6 = r9;
            goto L21
        L13:
            r5 = null;
        L26:
            PkStateMachineController r8 = this.a;
            PkBaseStateMachine.Source r10 = this.c;
            r8.getClass();
            jy0.b.c("ttlive_PkStateMachine", "getBattleState failure", null, 4);
            r8.j.a(new PkBaseStateMachine.a.i(new com.bytedance.android.live.revlink.impl.mergepk.pkbase.statemachine.a(null, null, null, null, 0, null, null, null, null, null, null, null, null, null, null, 32767), r10, false));
            k.c(r9);
        }
    }

    public static final class e<T> implements Consumer {
        public final /* synthetic */ PkStateMachineController a;
        public final /* synthetic */ long b;
        public final /* synthetic */ long c;

        public e(PkStateMachineController r1, long r2, long r4) {
            this.a = r1;
            this.b = r2;
            this.c = r4;
        }

        public final void accept(Object r8) {
            ExtraResponse r9 = (ExtraResponse) r8;
            com.bytedance.android.live.revlink.impl.global.c r10 = this.a.k;
            if (r10 == null) goto L5;
            b21.e r12 = r10.Gm();
        L6:
            b21.e r0 = r12;
            if (r0 == null) goto L10;
            long r1 = this.b;
            long r4 = t.a(this.c);
            int r6 = ((Number) this.a.m.invoke()).intValue();
            int r13 = b21.e.b;
            r0.d(r1, null, r4, r6);
            return;
        L10:
            return;
        L5:
            r12 = null;
            goto L6
        }
    }

    public static final class f<T> implements Consumer {
        public final /* synthetic */ PkStateMachineController a;
        public final /* synthetic */ long b;
        public final /* synthetic */ long c;

        public f(PkStateMachineController r1, long r2, long r4) {
            this.a = r1;
            this.b = r2;
            this.c = r4;
        }

        public final void accept(Object r14) {
            Throwable r15 = (Throwable) r14;
            com.bytedance.android.live.revlink.impl.global.c r0 = this.a.k;
            if (r0 == null) goto L5;
            b21.e r1 = r0.Gm();
        L6:
            if (r1 == null) goto L8;
            r1.d(this.b, r15, t.a(this.c), ((Number) this.a.m.invoke()).intValue());
        L8:
            k.c(r15);
            PkStateMachineController.e(this.a, PkBaseStateMachine.Source.PunishTimeUp, null, 0, 62);
            return;
        L5:
            r1 = null;
            goto L6
        }
    }

    static {
    }

    public final void b() {
        yz0.f r0 = this.p;
        if (r0 == null) goto L5;
        com.bytedance.android.live.revenue.common.message.a r1 = com.bytedance.android.live.revenue.common.message.a.g;
        Observable r2 = yz0.h.a.a(r0, CommonMessageTypeKt.a(r1), false, 6);
        final PkStateMachineController$attach$1$1 r5 = new PkStateMachineController$attach$1$1(this);
        com.bytedance.revenue.platform.api.core.rx.f.a(r2.subscribe(new g(r5)), this.g);
        Observable r3 = yz0.h.a.a(r0, CommonMessageTypeKt.b(r1), false, 6);
        final PkStateMachineController$attach$1$2 r6 = new PkStateMachineController$attach$1$2(this);
        com.bytedance.revenue.platform.api.core.rx.f.a(r3.subscribe(new g(r6)), this.g);
        Intrinsics.checkNotNullParameter(r1, "$this$LINK_MIC_BATTLE_FINISH");
        Observable r4 = yz0.h.a.a(r0, (yh6.b) CommonMessageTypeKt.h.getValue(), false, 6);
        final PkStateMachineController$attach$1$3 r7 = new PkStateMachineController$attach$1$3(this);
        com.bytedance.revenue.platform.api.core.rx.f.a(r4.subscribe(new g(r7)), this.g);
        Intrinsics.checkNotNullParameter(r1, "$this$LINK_MIC_BATTLE_END_PUNISH");
        Observable r8 = yz0.h.a.a(r0, (yh6.b) CommonMessageTypeKt.i.getValue(), false, 6);
        final PkStateMachineController$attach$1$4 r9 = new PkStateMachineController$attach$1$4(this);
        com.bytedance.revenue.platform.api.core.rx.f.a(r8.subscribe(new g(r9)), this.g);
    L5:
        this.c.getTimeLeft().observeForever(this.e);
    }

    public final PkBaseStateMachine.c f() {
        return (PkBaseStateMachine.c) this.j.a.a.get();
    }

    public final z g() {
        com.bytedance.android.live.revlink.impl.global.c r0 = this.k;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getMultiPkMonitor();
    }

    public final void j() {
        i97.a r0 = i97.a.a;
        long r7 = System.currentTimeMillis();
        com.bytedance.android.live.revlink.impl.global.c r1 = this.k;
        r31.a r2 = null;
        if (r1 == null) goto L5;
        com.bytedance.android.live.revenuelink.connect.g r3 = r1.getAnchorConnectUtils();
    L6:
        long r4 = 0;
        if (r3 == null) goto L9;
        long r9 = r3.getChannelId();
    L10:
        com.bytedance.android.live.revlink.impl.mergepk.pkbase.statemachine.a r5 = this.h;
        if (r5 == null) goto L15;
        IBaseBattleSetting r6 = r5.a;
        if (r6 == null) goto L15;
        r4 = r6.getBattleId();
    L15:
        com.bytedance.android.live.revlink.impl.global.c r8 = this.k;
        if (r8 == null) goto L18;
        r2 = r8.getLinkNetwork();
    L18:
        if (r2 == null) goto L29;
        Observable<ExtraResponse<Object, Extra>> r10 = r2.R(r9, r4);
        if (r10 == null) goto L30;
        int r12 = p.a;
        Observable r13 = r10.subscribeOn(Schedulers.io());
        if (r13 == null) goto L31;
        Observable r14 = r13.observeOn(AndroidSchedulers.mainThread());
        if (r14 == null) goto L32;
        long r15 = r9;
        Disposable r16 = r14.subscribe(new e(this, r15, r7), new f(this, r15, r7));
        if (r16 == null) goto L33;
        com.bytedance.revenue.platform.api.core.rx.f.a(r16, this.g);
        return;
    L33:
        return;
    L32:
        return;
    L31:
        return;
    L30:
        return;
    L29:
        return;
    L9:
        r9 = 0;
        goto L10
    L5:
        r3 = null;
        goto L6
    }

    public final void c(PkBaseStateMachine.Source r28) {
        Intrinsics.checkNotNullParameter(r28, "stateSource");
        com.bytedance.android.live.revlink.impl.global.c r0 = this.k;
        s r1 = null;
        if (r0 == null) goto L5;
        com.bytedance.android.live.revenuelink.connect.g r2 = r0.getAnchorConnectUtils();
    L6:
        long r3 = 0;
        if (r2 == null) goto L9;
        long r23 = r2.getChannelId();
    L10:
        com.bytedance.android.live.revlink.impl.global.c r4 = this.k;
        if (r4 == null) goto L13;
        d21.d r5 = r4.getMergePkHelper();
    L15:
        if (r5 == null) goto L28;
        Intrinsics.checkNotNullParameter(r28, "source");
        int r6 = d21.c.b[r28.ordinal()];
        if (r6 == 1) goto L28;
        if (r6 != 2) goto L21;
        int r7 = 15;
    L29:
        i97.a r8 = i97.a.a;
        long r25 = System.currentTimeMillis();
        PkBaseStateMachine.Source r9 = PkBaseStateMachine.Source.PKTimeUp;
        if (r28 != r9) goto L32;
    L34:
        boolean r10 = false;
    L36:
        if (u41.a.c.a() == false) goto L49;
        int r12 = com.bytedance.android.live.revenue.common.h.a;
        StringBuilder r13 = new StringBuilder();
        r13.append(String.valueOf(r23));
        if (r10 == false) goto L40;
        String r14 = DataType.TRUE;
    L48:
        r13.append(r14);
        String r15 = com.bytedance.android.live.revenue.common.h.a(r13.toString());
    L50:
        String r17 = r15;
        com.bytedance.android.live.revlink.impl.mergepk.pkbase.statemachine.a r16 = this.h;
        if (r16 == null) goto L55;
        IBaseBattleSetting r18 = r16.a;
        if (r18 == null) goto L55;
        long r22 = r18.getBattleId();
    L56:
        com.bytedance.android.live.revlink.impl.global.c r19 = this.k;
        if (r19 == null) goto L59;
        r31.a r20 = r19.getLinkNetwork();
    L60:
        if (r20 == null) goto L89;
        com.bytedance.android.live.revlink.impl.global.c r110 = this.k;
        if (r110 == null) goto L64;
        LinkCrossRoomDataHolder r111 = r110.getLinkCrossRoomDataHolder();
    L65:
        if (r111 == null) goto L67;
        int r112 = r111.i();
    L68:
        if (r28 != r9) goto L70;
    L73:
        int r113 = 0;
    L74:
        com.bytedance.android.live.revlink.impl.global.c r24 = this.k;
        if (r24 == null) goto L77;
        r1 = r24.getRevLinkCommonUtil();
    L77:
        if (r1 == null) goto L79;
        r3 = r1.d();
    L79:
        Observable<ExtraResponse<f1, Extra>> r26 = r20.f(r23, r112, r113, 0, r7, r17, r3, ((Number) this.m.invoke()).intValue(), r22);
        if (r26 == null) goto L90;
        int r27 = p.a;
        Observable r29 = r26.subscribeOn(Schedulers.io());
        if (r29 == null) goto L91;
        Observable r30 = r29.observeOn(AndroidSchedulers.mainThread());
        if (r30 == null) goto L92;
        long r32 = r23;
        Disposable r33 = r30.subscribe(new com.bytedance.android.live.revlink.impl.mergepk.pkbase.statemachine.d(this, r32, r28, r25), new com.bytedance.android.live.revlink.impl.mergepk.pkbase.statemachine.e(this, r32, r28, r25));
        if (r33 == null) goto L93;
        com.bytedance.revenue.platform.api.core.rx.f.a(r33, this.g);
        return;
    L93:
        return;
    L92:
        return;
    L91:
        return;
    L90:
        return;
    L70:
        if (r28 == PkBaseStateMachine.Source.PunishTimeUp) goto L73;
        r113 = 1;
        goto L74
    L67:
        r112 = 0;
        goto L68
    L64:
        r111 = null;
        goto L65
    L89:
        return;
    L59:
        r20 = null;
    L55:
        r22 = 0;
        goto L56
    L40:
        StringBuilder r34 = new StringBuilder(DataType.FALSE);
        com.bytedance.android.live.revlink.impl.global.c r114 = this.k;
        if (r114 == null) goto L43;
        LinkCrossRoomDataHolder r115 = r114.getLinkCrossRoomDataHolder();
    L44:
        if (r115 == null) goto L46;
        Integer r116 = Integer.valueOf(r115.i());
    L47:
        r34.append(r116);
        r34.append(r7);
        r14 = r34.toString();
        goto L48
    L46:
        r116 = null;
        goto L47
    L43:
        r115 = null;
        goto L44
    L49:
        r15 = "";
        goto L50
    L32:
        if (r28 == PkBaseStateMachine.Source.PunishTimeUp) goto L34;
        r10 = true;
        goto L36
    L21:
        if (r6 != 3) goto L23;
        r7 = 8;
        goto L29
    L23:
        if (r6 != 4) goto L28;
        r7 = 11;
    L28:
        r7 = 0;
        goto L29
    L13:
        r5 = null;
        goto L15
    L9:
        r23 = 0;
        goto L10
    L5:
        r2 = null;
        goto L6
    }

    public final void i(yh6.c r26) {
        if (r26 != null) goto L5;
        return;
    L5:
        q r2 = null;
        Map r3 = null;
        if ((r26 instanceof r0) == false) goto L90;
        c5 r0 = ((vh7.c) r26).castTo(c5.class);
        a r1 = this.d;
        if (r1 == null) goto L10;
        r1.onReceiveBattleMsg(r0);
    L10:
        z r4 = g();
        if (r4 == null) goto L48;
        Intrinsics.checkNotNullParameter(r0, Constants.OperatorKey.MSG);
        LinkedHashMap r5 = new LinkedHashMap();
        r5.put("msg_id", String.valueOf(qj.a(r0)));
        m0 r7 = r0.getCommonData();
        String r8 = "";
        if (r7 == null) goto L16;
        String r9 = r7.getMethod();
        if (r9 == null) goto L16;
    L17:
        r5.put("server_message_name", r9);
        Map r10 = r0.getBattleUserInfoMap();
        if (r10 == null) goto L24;
        r5.put("pk_user_cnt", Integer.valueOf(r10.size()));
        r5.put("anchor_linked_count", String.valueOf(r10.size()));
        StringBuilder r12 = new StringBuilder("{");
        Iterator r13 = MapsKt.toMap(r10).entrySet().iterator();
    L21:
        if (r13.hasNext() == false) goto L23;
        Map.Entry r14 = (Map.Entry) r13.next();
        r12.append((String) r14.getKey());
        r12.append(':');
        r12.append(i3.a((IBattleUserInfo) r14.getValue()));
        r12.append(';');
        goto L21
    L23:
        r12.append('}');
        r5.put("battle_user_info", r12.toString());
    L24:
        u1 r15 = r0.getBattleSetting();
        if (r15 == null) goto L38;
        r5.put("pk_id", Long.valueOf(r15.getBattleId()));
        r5.put("pk_channel_id", Long.valueOf(r15.getChannelId()));
        r5.put("pk_duration", Long.valueOf(r15.getDuration()));
        r5.put("pk_start_time", Long.valueOf(r15.getStartTimeMs()));
        r5.put("pk_punish_duration", Long.valueOf(r15.getPunishDuration()));
        r5.put("pk_punish_start_time", Long.valueOf(r15.getPunishStartTimeMs()));
        r5.put("battle_type", Integer.valueOf(r15.getBattleType()));
        IBattleConfigSetting r16 = r15.getBattleConfigSetting();
        String r17 = DataType.FALSE;
        if (r16 == null) goto L30;
        String r18 = String.valueOf(r16.getPlayMode());
        if (r18 == null) goto L30;
    L31:
        r5.put("battle_play_mode", r18);
        IBattleConfigSetting r19 = r15.getBattleConfigSetting();
        if (r19 == null) goto L37;
        String r20 = String.valueOf(r19.getTeamMode());
        if (r20 == null) goto L37;
        r17 = r20;
    L37:
        r5.put("battle_team_mode", r17);
    L30:
        r18 = DataType.FALSE;
    L38:
        HashMap r22 = new HashMap();
        m0 r110 = r0.getCommonData();
        if (r110 == null) goto L44;
        String r111 = r110.getMethod();
        if (r111 == null) goto L44;
        r8 = r111;
    L44:
        r22.put("server_message_name", r8);
        if (r4.k() == false) goto L47;
        z.y(r4, "receive_battle_start_msg", r5, r22, 4);
        goto L48
    L47:
        r4.d(r5);
        int r6 = v.a;
        v.e("ttlive_anchor_link_multi_pk", "receive_battle_start_msg params=" + GsonProtectorUtils.toJson(l97.a.a, r5));
    L16:
        r9 = "";
    L48:
        u1 r23 = r0.getBattleSetting();
        if (r23 == null) goto L51;
        Long r24 = Long.valueOf(r23.getBattleId());
    L52:
        if (r24 == null) goto L88;
        u1 r25 = r0.getBattleSetting();
        if (r25 != null) goto L56;
    L58:
        u1 r27 = r0.getBattleSetting();
        if (r27 == null) goto L61;
        Long r28 = Long.valueOf(r27.getBattleId());
    L62:
        com.bytedance.android.live.revlink.impl.mergepk.pkbase.statemachine.a r29 = this.h;
        if (r29 == null) goto L67;
        IBaseBattleSetting r30 = r29.a;
        if (r30 == null) goto L67;
        Long r32 = Long.valueOf(r30.getBattleId());
    L69:
        if (Intrinsics.areEqual(r28, r32) == false) goto L77;
        StringBuilder r33 = new StringBuilder("repeat for same battle_id ");
        com.bytedance.android.live.revlink.impl.mergepk.pkbase.statemachine.a r34 = this.h;
        if (r34 == null) goto L75;
        IBaseBattleSetting r35 = r34.a;
        if (r35 == null) goto L75;
        Long r36 = Long.valueOf(r35.getBattleId());
    L76:
        r33.append(r36);
        jy0.b.c("ttlive_PkStateMachine", r33.toString(), null, 4);
        return;
    L75:
        r36 = null;
        goto L76
    L77:
        jy0.b.c("ttlive_PkStateMachine", "message start", null, 4);
        int r37 = com.bytedance.android.live.revlink.impl.mergepk.pkbase.statemachine.a.p;
        Intrinsics.checkNotNullParameter(r0, "battleMessage");
        u1 r38 = r0.getBattleSetting();
        Map r39 = r0.getBattleUserInfoMap();
        u1 r40 = r0.getBattleSetting();
        if (r40 == null) goto L80;
        IBattleBarConfig r112 = r40.getBarConfig();
    L81:
        com.bytedance.android.live.revlink.impl.mergepk.pkbase.b r113 = new com.bytedance.android.live.revlink.impl.mergepk.pkbase.b(r0.getSkinType(), r0.getSkinConfig());
        Map<String, String> r210 = h41.h.a(r0.getEventTrackingInfo());
        p0 r42 = e21.c.c(p0.Companion, r0.getBattleAttachedInfo());
        if (r42 != null) goto L84;
        r42 = (p0) vh7.f.c(p0.class);
    L84:
        p0 r211 = r42;
        if (r39 == null) goto L87;
        r3 = MapsKt.toMap(r39);
    L87:
        this.j.a(new PkBaseStateMachine.a.f(new com.bytedance.android.live.revlink.impl.mergepk.pkbase.statemachine.a(r38, r3, null, null, 0, r112, r113, null, null, null, null, null, r210, null, r211, 12188)));
        return;
    L80:
        r112 = null;
    L67:
        r32 = null;
        goto L69
    L61:
        r28 = null;
        goto L62
    L56:
        if (r25.getBattleId() != 0) goto L58;
    L88:
        jy0.b.c("ttlive_PkStateMachine", "illegal LinkMicBattleMessage " + r0, null, 4);
        return;
    L51:
        r24 = null;
        goto L52
    L90:
        if ((r26 instanceof v8) == false) goto L172;
        a5 r43 = (a5) ((vh7.c) r26).castTo(a5.class);
        a r44 = this.d;
        if (r44 == null) goto L95;
        r44.onReceiveBattleFinishMsg(r43);
    L95:
        if (h(this.n, r43) == false) goto L157;
        z r45 = g();
        if (r45 == null) goto L99;
        r45.w(r43);
    L99:
        com.bytedance.android.live.revlink.impl.global.c r46 = this.k;
        if (r46 == null) goto L102;
        d21.d r47 = r46.getMergePkHelper();
    L103:
        if (r47 == null) goto L105;
        PkBaseStateMachine.Source r48 = d21.d.b(r43.getEndReason());
    L107:
        if (((Number) this.m.invoke()).intValue() == 1) goto L109;
    L111:
        PkBaseStateMachine.c r49 = (PkBaseStateMachine.c) this.j.a.a.get();
        if (r43.getSkinConfig() == null) goto L114;
        com.bytedance.android.live.revlink.impl.mergepk.pkbase.b r50 = new com.bytedance.android.live.revlink.impl.mergepk.pkbase.b(r43.getSkinType(), r43.getSkinConfig());
    L115:
        int r52 = com.bytedance.android.live.revlink.impl.mergepk.pkbase.statemachine.a.p;
        com.bytedance.android.live.revlink.impl.mergepk.pkbase.statemachine.a r53 = com.bytedance.android.live.revlink.impl.mergepk.pkbase.statemachine.a.C0134a.b(r43, r49.a.f, r50);
        if (r48 == PkBaseStateMachine.Source.BattleFinishTimeUp) goto L146;
        if (r48 == PkBaseStateMachine.Source.BattleFinishInstantKill) goto L146;
        if (r48 == PkBaseStateMachine.Source.ScoreControl) goto L146;
        if (r48 != PkBaseStateMachine.Source.MultipleInvite) goto L125;
    L144:
        this.j.a(new PkBaseStateMachine.a.c(r53, r48));
        return;
    L125:
        if (r48 != PkBaseStateMachine.Source.CutShort) goto L135;
        com.bytedance.android.live.revlink.impl.global.c r54 = this.k;
        if (r54 == null) goto L129;
        r2 = r54.getPkUtils();
    L129:
        if (r2 == null) goto L144;
        com.bytedance.android.live.revlink.impl.mergepk.pkdouble.c r55 = r2.g();
        if (r55 == null) goto L144;
        if (r55.isFinisher() != true) goto L144;
    L135:
        if (r48 == PkBaseStateMachine.Source.RoomClose) goto L144;
        if (r48 == PkBaseStateMachine.Source.NormalToMultiple) goto L144;
        if (r48 == PkBaseStateMachine.Source.StartOpenGame) goto L144;
        if (r48 != PkBaseStateMachine.Source.RtcLinkerLeave) goto L191;
        this.j.a(new PkBaseStateMachine.a.d(r53, r48));
        return;
    L191:
        return;
    L146:
        if ((r49 instanceof PkBaseStateMachine.c.C0130c) == false) goto L194;
        this.j.a(new PkBaseStateMachine.a.C0128a(r53, r48));
        u1 r56 = r43.getBattleSetting();
        if (r56 != null) goto L150;
        return;
    L150:
        if (af2.d.d(r56) == true) goto L152;
        return;
    L152:
        if (this.n == false) goto L197;
        jy0.b.c("ttlive_PkStateMachine", "anchor call finishPk after getBattleState", null, 4);
        if (d51.c.A0.i() == false) goto L156;
        j();
        return;
    L156:
        c(PkBaseStateMachine.Source.PunishTimeUp);
        return;
    L197:
        return;
    L194:
        return;
    L114:
        r50 = r49.a.g;
        goto L115
    L109:
        if (r48 != PkBaseStateMachine.Source.BattleFinishInstantKill) goto L111;
        return;
    L105:
        r48 = null;
        goto L107
    L102:
        r47 = null;
        goto L103
    L157:
        z r57 = g();
        if (r57 == null) goto L161;
        r57.w(r43);
    L161:
        if (r43.getEndReason() != 0) goto L166;
        if (this.n == true) goto L166;
        e(this, PkBaseStateMachine.Source.BattleFinishTimeUp, null, 0, 62);
    L166:
        if (r43.getEndReason() != 6) goto L169;
        e(this, PkBaseStateMachine.Source.BattleFinishInstantKill, null, 0, 62);
    L169:
        if (r43.getEndReason() != 13) goto L200;
        this.j.a(new PkBaseStateMachine.a.c(new com.bytedance.android.live.revlink.impl.mergepk.pkbase.statemachine.a(null, null, null, null, 0, null, null, null, null, null, null, null, null, null, null, 32767), PkBaseStateMachine.Source.MultipleInvite));
        return;
    L200:
        return;
    L172:
        if ((r26 instanceof h1) == false) goto L181;
        i6 r58 = ((vh7.c) r26).castTo(i6.class);
        if (((Number) this.m.invoke()).intValue() != 1) goto L177;
        return;
    L177:
        if (((int) i1.c(r58)) != 7) goto L206;
        this.j.a(new PkBaseStateMachine.a.d(new com.bytedance.android.live.revlink.impl.mergepk.pkbase.statemachine.a(null, null, null, null, 0, null, null, null, null, null, null, null, null, null, null, 32767), PkBaseStateMachine.Source.LinkerLeave));
        return;
    L206:
        return;
    L181:
        if ((r26 instanceof u8) == false) goto L203;
        y4 r59 = ((vh7.c) r26).castTo(y4.class);
        a r60 = this.d;
        if (r60 == null) goto L185;
        r60.onReceiveBattleEndPunishMsg(r59);
    L185:
        this.j.a(new PkBaseStateMachine.a.c(new com.bytedance.android.live.revlink.impl.mergepk.pkbase.statemachine.a(r59.getBattleSetting(), null, null, null, 0, null, null, null, null, null, null, null, null, null, null, 32766), PkBaseStateMachine.Source.MultipleInvite));
        return;
    }

    public static final void a(PkStateMachineController r4, boolean r5) {
        r4.getClass();
        d51.c r0 = d51.c.A0;
        r0.getClass();
        ReadOnlyProperty r1 = d51.c.T;
        KProperty[] r2 = d51.c.a;
        if (((Boolean) r1.getValue(r0, r2[44])).booleanValue() == false) goto L10;
        Disposable r3 = r4.f;
        if (r3 == null) goto L8;
        r3.dispose();
    L8:
        long r6 = ((Number) d51.c.W.getValue(r0, r2[47])).longValue() * ((long) WebcastRedirectException.UNKNOWN);
        l r7 = l.a;
        int r8 = p.a;
        Scheduler r9 = Schedulers.computation();
        Disposable r10 = Observable.timer(r6, TimeUnit.MILLISECONDS, r9).observeOn(AndroidSchedulers.mainThread()).subscribe(new com.bytedance.android.live.revlink.impl.mergepk.pkbase.statemachine.g(r4, r5));
        com.bytedance.revenue.platform.api.core.rx.f.a(r10, r4.g);
        r4.f = r10;
        return;
    }

    public final boolean h(boolean r3, a5 r4) {
        if (((Number) this.m.invoke()).intValue() != 1) goto L5;
        return true;
    L5:
        if (r4 == null) goto L7;
        n3 r0 = r4.getBreakthroughInfo();
    L8:
        if (r0 != null) goto L10;
    L12:
        if (r3 == false) goto L14;
        y41.e r5 = y41.e.o;
        r5.getClass();
        return ((Boolean) y41.e.g.getValue(r5, y41.e.a[5])).booleanValue();
    L14:
        y41.e r6 = y41.e.o;
        r6.getClass();
        return ((Boolean) y41.e.h.getValue(r6, y41.e.a[6])).booleanValue();
    L10:
        if (r4.getEndReason() != 7) goto L12;
        return true;
    L7:
        r0 = null;
        goto L8
    }

    public static void e(PkStateMachineController r8, PkBaseStateMachine.Source r9, String r10, long r12, int r13) {
        if ((r13 & 2) == 0) goto L5;
        r10 = "finish_pk";
    L5:
        String r2 = r10;
        if ((r13 & 4) == 0) goto L14;
        com.bytedance.android.live.revlink.impl.global.c r14 = r8.k;
        if (r14 == null) goto L10;
        LinkCrossRoomDataHolder r15 = r14.getLinkCrossRoomDataHolder();
    L11:
        if (r15 == null) goto L13;
        r12 = r15.c();
        goto L14
    L13:
        r12 = 0;
        goto L14
    L10:
        r15 = null;
    L14:
        r8.d(r9, r2, r12, null, null, null);
    }

    public PkStateMachineController(com.bytedance.android.live.revlink.impl.global.c r2, AnchorLinkUserCenterV2 r3, Function0 r4, boolean r5, IRoom r6, yz0.f r7) {
        Intrinsics.checkNotNullParameter(r4, "scene");
        this.k = r2;
        this.l = r3;
        this.m = r4;
        this.n = r5;
        this.o = r6;
        this.p = r7;
        MutableLiveData<PkBaseStateMachine.b> r8 = new MutableLiveData();
        this.a = r8;
        this.b = r8;
        this.c = new PkBaseTimeDataContext(r2, r4);
        this.e = new h(this);
        this.g = new CompositeDisposable();
        this.j = new PkBaseStateMachine(new PkStateMachineController$stateMachine$1(this));
    }

    public final void d(PkBaseStateMachine.Source r26, String r27, long r28, Function2<? super r, ? super Long, Unit> r30, Function2<? super Long, ? super Long, Unit> r32, Function1<? super Long, Unit> r33) {
        Intrinsics.checkNotNullParameter(r26, "source");
        Intrinsics.checkNotNullParameter(r27, "reqSrc");
        jy0.b.f("ttlive_PkStateMachine", "getBattleStats scene=" + ((Number) this.m.invoke()).intValue() + " channelId=" + r28 + " from " + r26 + ' ' + r27, null, 4);
        com.bytedance.android.live.revlink.impl.global.c r0 = this.k;
        if (r0 == null) goto L5;
        s r1 = r0.getRevLinkCommonUtil();
    L7:
        if (r1 == null) goto L9;
        long r20 = r1.d();
    L11:
        if (r28 != 0) goto L18;
        com.bytedance.android.live.revlink.impl.global.c r2 = this.k;
        if (r2 == null) goto L15;
        com.bytedance.android.live.revlink.impl.multianchor.utils.d r3 = r2.of();
    L16:
        if (r3 == null) goto L18;
        r3.b("getBattleStats");
        goto L18
    L15:
        r3 = null;
    L18:
        i97.a r4 = i97.a.a;
        long r23 = System.currentTimeMillis();
        com.bytedance.android.live.revlink.impl.global.c r5 = this.k;
        if (r5 == null) goto L21;
        r31.a r12 = r5.getLinkNetwork();
    L22:
        if (r12 == null) goto L38;
        long r6 = 2;
        int r17 = ((Number) this.m.invoke()).intValue();
        boolean r18 = !this.n;
        IRoom r7 = this.o;
        if (r7 == null) goto L27;
        String r8 = IRoomKt_androidKt.getAnchorId(r7);
        if (r8 == null) goto L27;
    L28:
        Observable r9 = r12.O(r28, r6, r17, r18, r27, r20, r8);
        if (r9 == null) goto L39;
        int r10 = p.a;
        Observable r13 = r9.subscribeOn(Schedulers.io());
        if (r13 == null) goto L40;
        Observable r14 = r13.observeOn(AndroidSchedulers.mainThread());
        if (r14 == null) goto L41;
        Disposable r15 = r14.subscribe(new c(this, r28, r26, r27, r30, r23, r32), new d(this, r28, r26, r27, r33, r23));
        if (r15 == null) goto L42;
        com.bytedance.revenue.platform.api.core.rx.f.a(r15, this.g);
        return;
    L42:
        return;
    L41:
        return;
    L40:
        return;
    L39:
        return;
    L27:
        r8 = "";
        goto L28
    L38:
        return;
    L21:
        r12 = null;
        goto L22
    L9:
        r20 = 0;
        goto L11
    L5:
        r1 = null;
        goto L7
    }
}
