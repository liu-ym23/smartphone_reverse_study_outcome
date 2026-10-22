package com.bytedance.android.live.revlink.impl.multianchor.dynamic.context;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.link.data.RevPkState;
import com.bytedance.android.live.revlink.impl.LinkCrossRoomDataHolder;
import com.bytedance.android.live.revlink.impl.lynxcontainer.PkLynxDataContext;
import com.bytedance.android.live.revlink.impl.mergepk.pkbase.PkBaseDataContext;
import com.bytedance.android.live.revlink.impl.mergepk.pkbase.statemachine.PkBaseStateMachine;
import com.bytedance.android.live.revlink.impl.multianchor.profit.ProfitInteractionDataContext;
import com.bytedance.android.live.revlink.impl.plantform.AnchorLinkUserCenterV2;
import com.bytedance.android.live.revlink.impl.region.RevLinkWindowRegionContext;
import com.bytedance.android.live.revlink.link.domain.dependencyimpl.DynamicContextDependencyImpl;
import com.bytedance.android.live.revlink.link.utils.UtilsKt;
import com.bytedance.badger.collect.impl.constants.Constants;
import com.bytedance.ies.sdk.widgets.NextLiveData;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.live.datacontext.DataContext;
import io.reactivex.Observable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import org.json.JSONObject;
import w20.ae;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class MultiDynamicContextImpl implements c, com.bytedance.android.live.revlink.impl.lynxcontainer.a {
    public final CompositeDisposable a;
    public final boolean b;
    public com.bytedance.android.live.revlink.impl.lynxcontainer.a c;
    public final com.bytedance.android.live.revlink.impl.multianchor.dynamic.l d;
    public final MultiDynamicLocalContext e;
    public final Lazy f;
    public final k0 g;
    public final e0 h;
    public final Function0<Integer> i;
    public final ld.a j;
    public final com.bytedance.android.livesdk.revenue.service.room.c k;
    public final com.bytedance.android.live.revlink.impl.global.c l;
    public final com.bytedance.android.live.revlink.impl.mergepk.pkbase.e m;
    public final e n;
    public final i11.c o;
    public final com.bytedance.android.live.revlink.impl.multianchor.ui.b p;
    public final com.bytedance.android.live.revlink.impl.global.c q;

    public MultiDynamicContextImpl() {
        throw null;
    }

    @Override // com.bytedance.android.live.revlink.impl.lynxcontainer.a
    public final String c(List<String> r1) {
        return "";
    }

    @Override // com.bytedance.android.live.revlink.impl.lynxcontainer.a
    public final void e() {
    }

    @Override // com.bytedance.android.live.revlink.impl.lynxcontainer.a
    public final void k() {
    }

    public final void n() {
        final k0 r0 = this.g;
        ld.a r1 = r0.z;
        if (r1 == null) goto L11;
        NextLiveData r2 = r1.getCleanMode();
        if (r2 == null) goto L11;
        Observable r3 = ld.c.a(r2);
        if (r3 == null) goto L11;
        Disposable r4 = r3.subscribe(new f0(r0));
        if (r4 == null) goto L11;
        com.bytedance.revenue.platform.api.core.rx.f.a(r4, r0.a);
    L11:
        e r5 = r0.D;
        if (r5 == null) goto L18;
        com.bytedance.live.datacontext.n<f31.i> r6 = r5.getWindowStatus();
        if (r6 == null) goto L18;
        Disposable r7 = com.bytedance.android.live.core.utils.b0.b(r6, new RevLinkOldDynamicDataContext$attach$2(r0));
        if (r7 == null) goto L18;
        com.bytedance.revenue.platform.api.core.rx.f.a(r7, r0.a);
    L18:
        com.bytedance.android.live.revlink.impl.multianchor.ui.i r8 = r0.H;
        if (r8 == null) goto L21;
        r8.g(r0.t);
    L21:
        e r9 = r0.D;
        if (r9 == null) goto L30;
        com.bytedance.live.datacontext.m<Boolean> r10 = r9.getChangeScreenEvent();
        if (r10 == null) goto L30;
        Observable r12 = r10.a();
        if (r12 == null) goto L30;
        Disposable r13 = r12.subscribe(new g0(r0));
        if (r13 == null) goto L30;
        com.bytedance.revenue.platform.api.core.rx.f.a(r13, r0.a);
    L30:
        MutableLiveData<Boolean> r14 = r0.e;
        e r15 = r0.D;
        boolean r16 = true;
        if (r15 == null) goto L37;
        com.bytedance.live.datacontext.m<Boolean> r17 = r15.getChangeScreenEvent();
        if (r17 == null) goto L37;
        Boolean r18 = (Boolean) r17.getValue();
        if (r18 == null) goto L37;
        boolean r19 = r18.booleanValue();
    L38:
        r14.setValue(Boolean.valueOf(r19));
        MutableLiveData<JSONObject> r20 = r0.u;
        e r22 = r0.D;
        if (r22 == null) goto L45;
        com.bytedance.live.datacontext.m<Boolean> r23 = r22.getChangeScreenEvent();
        if (r23 == null) goto L45;
        Boolean r24 = (Boolean) r23.getValue();
        if (r24 == null) goto L45;
        boolean r25 = r24.booleanValue();
    L46:
        r20.setValue(k0.l(r25));
        com.bytedance.android.live.revlink.impl.global.c r26 = r0.B;
        if (r26 == null) goto L49;
        ProfitInteractionDataContext r27 = r26.vj();
    L50:
        if (r27 == null) goto L56;
        com.bytedance.live.datacontext.m<Long> r28 = r27.getLinkStartTimeStamp();
        if (r28 == null) goto L56;
        Disposable r29 = com.bytedance.android.live.core.utils.b0.a(r28, new RevLinkOldDynamicDataContext$attach$4(r0));
        if (r29 == null) goto L56;
        com.bytedance.revenue.platform.api.core.rx.f.a(r29, r0.a);
    L56:
        com.bytedance.revenue.platform.api.core.rx.f.a(UtilsKt.e(r0.C.getLastBattleResultVisible(), true, new RevLinkOldDynamicDataContext$attach$5(r0)), r0.a);
        jy0.b.c("MultiDynamicContextImpl", "attach anchorLinkUserCenter: " + r0.E, null, 4);
        StringBuilder r30 = new StringBuilder("attach with anchorLinkUserCenter: ");
        i11.c r32 = r0.E;
        if (r32 == null) goto L59;
        int r33 = r32.hashCode();
    L60:
        r30.append(r33);
        jy0.b.c("multi_lynx_user", r30.toString(), null, 4);
        i11.c r34 = r0.E;
        if (r34 == null) goto L65;
        Disposable r35 = r34.m(new RevLinkOldDynamicDataContext$attach$6(r0));
        if (r35 == null) goto L65;
        com.bytedance.revenue.platform.api.core.rx.f.a(r35, r0.a);
    L65:
        i11.c r36 = r0.E;
        if (r36 == null) goto L69;
        List<com.bytedance.android.livesdk.link.model.p> r37 = r36.getOnlineUserList();
        if (r37 == null) goto L69;
    L70:
        ((Number) r0.y.invoke()).intValue();
        r0.j.setValue(r37);
        com.bytedance.android.live.revlink.impl.mergepk.pkbase.launcher.a r38 = r0.C.getPkAnchorLauncher();
        if (r38 == null) goto L75;
        MutableLiveData r39 = r38.f();
        if (r39 == null) goto L75;
        r39.observeForever(r0.o);
    L75:
        com.bytedance.android.live.revlink.impl.mergepk.pkbase.launcher.a r40 = r0.C.getPkAnchorLauncher();
        if (r40 == null) goto L80;
        MutableLiveData r42 = r40.j();
        if (r42 == null) goto L80;
        r42.observeForever(r0.p);
    L80:
        r0.C.getNeedShowLastResult().observeForever(r0.q);
        ld.a r43 = r0.z;
        if (r43 == null) goto L87;
        NextLiveData r44 = r43.z9();
        if (r44 == null) goto L87;
        Disposable r45 = UtilsKt.i(r44, new RevLinkOldDynamicDataContext$attach$7(r0));
        if (r45 == null) goto L87;
        com.bytedance.revenue.platform.api.core.rx.f.a(r45, r0.a);
    L87:
        ld.a r46 = r0.z;
        if (r46 == null) goto L94;
        NextLiveData r47 = r46.Fc();
        if (r47 == null) goto L94;
        Disposable r48 = UtilsKt.i(r47, new RevLinkOldDynamicDataContext$attach$8(r0));
        if (r48 == null) goto L94;
        com.bytedance.revenue.platform.api.core.rx.f.a(r48, r0.a);
    L94:
        final e0 r49 = this.h;
        r49.getClass();
        if (com.bytedance.android.live.revlink.impl.settings.dynamic.a.H.g() == false) goto L257;
        ld.a r50 = r49.D;
        if (r50 == null) goto L106;
        NextLiveData r52 = r50.getCleanMode();
        if (r52 == null) goto L106;
        Observable r53 = ld.c.a(r52);
        if (r53 == null) goto L106;
        Disposable r54 = r53.subscribe(new p(r49));
        if (r54 == null) goto L106;
        com.bytedance.revenue.platform.api.core.rx.f.a(r54, r49.d);
    L106:
        ld.a r55 = r49.D;
        if (r55 == null) goto L113;
        NextLiveData r56 = r55.lj();
        if (r56 == null) goto L113;
        Disposable r57 = UtilsKt.i(r56, new RevLinkDynamicDataContext$attach$2(r49));
        if (r57 == null) goto L113;
        com.bytedance.revenue.platform.api.core.rx.f.a(r57, r49.d);
    L113:
        ld.a r58 = r49.D;
        if (r58 == null) goto L120;
        NextLiveData r59 = r58.q2();
        if (r59 == null) goto L120;
        Disposable r60 = UtilsKt.i(r59, new RevLinkDynamicDataContext$attach$3(r49));
        if (r60 == null) goto L120;
        com.bytedance.revenue.platform.api.core.rx.f.a(r60, r49.d);
    L120:
        e r62 = r49.H;
        if (r62 == null) goto L127;
        com.bytedance.live.datacontext.n<f31.i> r63 = r62.getWindowStatus();
        if (r63 == null) goto L127;
        Disposable r64 = com.bytedance.android.live.core.utils.b0.b(r63, new RevLinkDynamicDataContext$attach$4(r49));
        if (r64 == null) goto L127;
        com.bytedance.revenue.platform.api.core.rx.f.a(r64, r49.d);
    L127:
        MutableLiveData<Boolean> r65 = r49.r;
        if (r65 == null) goto L130;
        r65.observeForever(r49.s);
    L130:
        e r66 = r49.H;
        if (r66 == null) goto L139;
        com.bytedance.live.datacontext.m<Boolean> r67 = r66.getChangeScreenEvent();
        if (r67 == null) goto L139;
        Observable r68 = r67.a();
        if (r68 == null) goto L139;
        Disposable r69 = r68.subscribe(new q(r49));
        if (r69 == null) goto L139;
        com.bytedance.revenue.platform.api.core.rx.f.a(r69, r49.d);
    L139:
        MutableLiveData<Boolean> r70 = r49.r;
        e r72 = r49.H;
        if (r72 == null) goto L146;
        com.bytedance.live.datacontext.m<Boolean> r73 = r72.getChangeScreenEvent();
        if (r73 == null) goto L146;
        Boolean r74 = (Boolean) r73.getValue();
        if (r74 == null) goto L146;
        boolean r75 = r74.booleanValue();
    L147:
        r70.setValue(Boolean.valueOf(r75));
        com.bytedance.android.live.revlink.impl.global.c r76 = r49.F;
        if (r76 == null) goto L154;
        RevLinkWindowRegionContext r77 = r76.P8();
        if (r77 == null) goto L154;
        com.bytedance.live.datacontext.j<com.bytedance.android.live.revlink.impl.multianchor.service.g> r78 = r77.getPartnerService();
        if (r78 == null) goto L154;
        com.bytedance.android.live.revlink.impl.multianchor.service.g r79 = (com.bytedance.android.live.revlink.impl.multianchor.service.g) r78.getValue();
    L155:
        if (r79 == null) goto L159;
        NextLiveData<String> r80 = r79.c();
        if (r80 == null) goto L159;
        r80.observeForever(r49.u);
    L159:
        ProfitInteractionDataContext r82 = r49.l();
        if (r82 == null) goto L166;
        com.bytedance.live.datacontext.m<Long> r83 = r82.getLinkStartTimeStamp();
        if (r83 == null) goto L166;
        Disposable r84 = com.bytedance.android.live.core.utils.b0.a(r83, new RevLinkDynamicDataContext$attach$6(r49));
        if (r84 == null) goto L166;
        com.bytedance.revenue.platform.api.core.rx.f.a(r84, r49.d);
    L166:
        ProfitInteractionDataContext r85 = r49.l();
        if (r85 == null) goto L173;
        com.bytedance.live.datacontext.m<String> r86 = r85.getLinkRecordTime();
        if (r86 == null) goto L173;
        Disposable r87 = com.bytedance.android.live.core.utils.b0.a(r86, new RevLinkDynamicDataContext$attach$7(r49));
        if (r87 == null) goto L173;
        com.bytedance.revenue.platform.api.core.rx.f.a(r87, r49.d);
    L173:
        com.bytedance.android.live.revlink.impl.multianchor.ui.i r88 = r49.K;
        if (r88 == null) goto L176;
        r88.g(r49.x);
    L176:
        ProfitInteractionDataContext r89 = r49.l();
        if (r89 == null) goto L179;
        r89.attachToDynamicContext(r49.G);
    L179:
        com.bytedance.revenue.platform.api.core.rx.f.a(UtilsKt.e(r49.G.getLastBattleResultVisible(), true, new RevLinkDynamicDataContext$attach$8(r49)), r49.d);
        r49.G.getNeedShowLastResult().observeForever(r49.t);
        LiveData<PkBaseStateMachine.c> r90 = r49.G.getPkBaseState();
        if (r90 == null) goto L182;
        r90.observeForever(r49.y);
    L182:
        String r92 = r49.k();
        com.bytedance.android.livesdk.revenue.service.room.c r93 = r49.E;
        String r94 = "";
        if (r93 == null) goto L190;
        com.bytedance.android.livesdk.revenue.room.a r95 = r93.getRoomContext();
        if (r95 == null) goto L190;
        IBaseUser r96 = r95.getCommonUser();
        if (r96 == null) goto L190;
        String r97 = r96.getIdString();
        if (r97 == null) goto L190;
    L192:
        if (r97.length() != 0) goto L194;
        boolean r98 = true;
    L195:
        if (r98 == true) goto L197;
    L196:
        r94 = r97;
    L216:
        if (Intrinsics.areEqual(r92, r94) == false) goto L223;
        LiveData<PkBaseStateMachine.c> r99 = r49.G.getPkBaseState();
        if (r99 == null) goto L220;
        PkBaseStateMachine.c r100 = (PkBaseStateMachine.c) r99.getValue();
    L221:
        if (r100 != null) goto L223;
        r49.l.setValue(Integer.valueOf(RevPkState.FINISHED.ordinal()));
        goto L223
    L220:
        r100 = null;
    L223:
        i11.c r101 = r49.I;
        if (r101 == null) goto L228;
        Disposable r102 = r101.m(new RevLinkDynamicDataContext$attach$9(r49));
        if (r102 == null) goto L228;
        com.bytedance.revenue.platform.api.core.rx.f.a(r102, r49.d);
    L228:
        i11.c r103 = r49.I;
        if (r103 == null) goto L232;
        List<com.bytedance.android.livesdk.link.model.p> r104 = r103.getOnlineUserList();
        if (r104 == null) goto L232;
    L233:
        ((Number) r49.C.invoke()).intValue();
        r49.q.setValue(r104);
        i11.c r105 = r49.I;
        if (r105 == null) goto L236;
        r105.i(r49.w);
    L236:
        MutableLiveData<String> r106 = r49.b;
        com.bytedance.android.live.revlink.impl.global.c r107 = r49.F;
        if (r107 == null) goto L241;
        LinkCrossRoomDataHolder r108 = r107.getLinkCrossRoomDataHolder();
        if (r108 == null) goto L241;
        String r109 = String.valueOf(r108.c());
    L242:
        r106.setValue(r109);
        ld.a r110 = r49.D;
        if (r110 == null) goto L249;
        NextLiveData r111 = r110.z9();
        if (r111 == null) goto L249;
        Disposable r112 = UtilsKt.i(r111, new RevLinkDynamicDataContext$attach$10(r49));
        if (r112 == null) goto L249;
        com.bytedance.revenue.platform.api.core.rx.f.a(r112, r49.d);
    L249:
        ld.a r113 = r49.D;
        if (r113 == null) goto L256;
        NextLiveData r114 = r113.Fc();
        if (r114 == null) goto L256;
        Disposable r115 = UtilsKt.i(r114, new RevLinkDynamicDataContext$attach$11(r49));
        if (r115 == null) goto L256;
        com.bytedance.revenue.platform.api.core.rx.f.a(r115, r49.d);
    L256:
        MutableLiveData<String> r116 = com.bytedance.android.live.revlink.link.streaminteract.biz.b.c;
        r116.setValue(null);
        com.bytedance.android.live.revlink.link.streaminteract.biz.b.d = null;
        r116.observeForever(r49.v);
    L241:
        r109 = null;
    L232:
        r104 = CollectionsKt.emptyList();
        goto L233
    L197:
        com.bytedance.android.live.revlink.impl.global.c r117 = r49.M;
        if (r117 == null) goto L207;
        com.bytedance.android.live.revlink.impl.utils.s r118 = r117.getRevLinkCommonUtil();
        if (r118 == null) goto L207;
        com.bytedance.android.livesdk.revenue.service.user.a r119 = r118.c;
        if (r119 == null) goto L204;
        IBaseUser r120 = r119.b();
    L205:
        if (r120 == null) goto L207;
        r97 = iz.a.a(r120);
    L208:
        if (r97 != null) goto L210;
    L213:
        if (r16 == true) goto L216;
    L210:
        if (r97.length() == 0) goto L213;
        r16 = false;
        goto L213
    L204:
        r120 = null;
    L207:
        r97 = null;
        goto L208
    L194:
        r98 = false;
    L190:
        r97 = "";
    L154:
        r79 = null;
    L146:
        r75 = true;
    L257:
        Pair r121 = com.bytedance.live.datacontext.d.a(MultiDynamicContextImpl$attach$1.INSTANCE);
        ((PkLynxDataContext) r121.getFirst()).getService().d(this);
        com.bytedance.android.live.revlink.impl.lynxcontainer.a r122 = this.c;
        if (r122 == null) goto L260;
        ((PkLynxDataContext) r121.getFirst()).getNewService().d(r122);
    L260:
        com.bytedance.android.live.revlink.impl.global.d.a((DataContext) r121.getFirst(), "IPkLynxContainerService", this.l);
        com.bytedance.revenue.platform.api.core.rx.f.a((Disposable) r121.getSecond(), this.a);
        Pair r123 = com.bytedance.live.datacontext.d.a(new MultiDynamicContextImpl$attach$3(this));
        ((MultiDynamicLocalContext) r123.getFirst()).getLocalComponentService().d(this.d);
        ((MultiDynamicLocalContext) r123.getFirst()).getTopReserveContext().d(this);
        com.bytedance.android.live.revlink.impl.global.d.a((DataContext) r123.getFirst(), Reflection.getOrCreateKotlinClass(MultiDynamicLocalContext.class), this.l);
        com.bytedance.revenue.platform.api.core.rx.f.a((Disposable) r123.getSecond(), this.a);
        this.d.getClass();
        return;
    L69:
        r37 = CollectionsKt.emptyList();
        goto L70
    L59:
        r33 = 0;
        goto L60
    L49:
        r27 = null;
    L45:
        r25 = true;
    L37:
        r19 = true;
        goto L38
    }

    public final void o() {
        this.a.clear();
        this.d.b.clear();
        k0 r0 = this.g;
        r0.a.clear();
        i11.c r1 = r0.E;
        if (r1 == null) goto L5;
        r1.l(r0.s);
    L5:
        com.bytedance.android.live.revlink.impl.multianchor.ui.i r2 = r0.H;
        if (r2 == null) goto L8;
        r2.k(r0.t);
    L8:
        com.bytedance.android.live.revlink.impl.mergepk.pkbase.launcher.a r3 = r0.C.getPkAnchorLauncher();
        if (r3 == null) goto L13;
        MutableLiveData r4 = r3.f();
        if (r4 == null) goto L13;
        r4.removeObserver(r0.o);
    L13:
        com.bytedance.android.live.revlink.impl.mergepk.pkbase.launcher.a r5 = r0.C.getPkAnchorLauncher();
        if (r5 == null) goto L18;
        MutableLiveData r6 = r5.j();
        if (r6 == null) goto L18;
        r6.removeObserver(r0.p);
    L18:
        r0.C.getNeedShowLastResult().removeObserver(r0.q);
        r0.C.getLastBattleResultVisible();
        e0 r7 = this.h;
        r7.d.clear();
        MutableLiveData<Boolean> r8 = r7.r;
        if (r8 == null) goto L21;
        r8.removeObserver(r7.s);
    L21:
        ProfitInteractionDataContext r9 = r7.l();
        if (r9 == null) goto L24;
        r9.detachfromDynamicContext(r7.G);
    L24:
        i11.c r10 = r7.I;
        if (r10 == null) goto L27;
        r10.l(r7.w);
    L27:
        com.bytedance.android.live.revlink.impl.multianchor.ui.i r12 = r7.K;
        if (r12 == null) goto L30;
        r12.k(r7.x);
    L30:
        com.bytedance.android.live.revlink.impl.global.c r13 = r7.F;
        if (r13 == null) goto L37;
        RevLinkWindowRegionContext r14 = r13.P8();
        if (r14 == null) goto L37;
        com.bytedance.live.datacontext.j<com.bytedance.android.live.revlink.impl.multianchor.service.g> r15 = r14.getPartnerService();
        if (r15 == null) goto L37;
        com.bytedance.android.live.revlink.impl.multianchor.service.g r16 = (com.bytedance.android.live.revlink.impl.multianchor.service.g) r15.getValue();
    L38:
        if (r16 == null) goto L42;
        NextLiveData<String> r17 = r16.c();
        if (r17 == null) goto L42;
        r17.removeObserver(r7.u);
    L42:
        MutableLiveData<String> r18 = com.bytedance.android.live.revlink.link.streaminteract.biz.b.c;
        r18.removeObserver(r7.v);
        r18.setValue(null);
        com.bytedance.android.live.revlink.link.streaminteract.biz.b.d = null;
        return;
    L37:
        r16 = null;
        goto L38
    }

    @Override // com.bytedance.android.live.revlink.impl.lynxcontainer.a
    public final void a(List<String> r2) {
        com.bytedance.android.live.revlink.impl.lynxcontainer.a r0 = this.c;
        if (r0 == null) goto L6;
        r0.a(r2);
        return;
    }

    @Override // com.bytedance.android.live.revlink.impl.lynxcontainer.a
    public final JSONObject f(List<String> r5) {
        k0 r0 = this.g;
        r0.getClass();
        JSONObject r1 = new JSONObject();
        List<String> r2 = r5;
        if (r2 != null) goto L5;
    L8:
        boolean r3 = true;
    L9:
        if (r3 == true) goto L15;
        Iterator<String> r6 = r5.iterator();
    L13:
        if (r6.hasNext() == false) goto L15;
        String r4 = r6.next();
        r1.put(r4, r0.f(r4));
    L15:
        return r1;
    L5:
        if (r2.isEmpty() == true) goto L8;
        r3 = false;
        goto L9
    }

    @Override // com.bytedance.android.live.revlink.impl.lynxcontainer.a
    public final void g(List<String> r2) {
        com.bytedance.android.live.revlink.impl.lynxcontainer.a r0 = this.c;
        if (r0 == null) goto L6;
        r0.g(r2);
        return;
    }

    @Override // com.bytedance.android.live.revlink.impl.lynxcontainer.a
    public final void h(List<String> r2) {
        com.bytedance.android.live.revlink.impl.lynxcontainer.a r0 = this.c;
        if (r0 == null) goto L6;
        r0.h(r2);
        return;
    }

    @Override // com.bytedance.android.live.revlink.impl.lynxcontainer.a
    public final void i(List<String> r2) {
        com.bytedance.android.live.revlink.impl.lynxcontainer.a r0 = this.c;
        if (r0 == null) goto L6;
        r0.i(r2);
        return;
    }

    @Override // com.bytedance.android.live.revlink.impl.multianchor.dynamic.context.c
    public final void j(int r2) {
        if (this.b == false) goto L8;
        com.bytedance.android.live.revlink.impl.multianchor.ui.b r3 = this.p;
        if (r3 == null) goto L13;
        r3.requestLayout("updateTopReserve");
        return;
    L13:
        return;
    L8:
        if (((Boolean) this.f.getValue()).booleanValue() == true) goto L15;
        com.bytedance.android.live.revlink.impl.multianchor.ui.b r4 = this.p;
        if (r4 == null) goto L16;
        r4.requestLayout("updateTopReserve");
        return;
    L16:
        return;
    }

    @Override // com.bytedance.android.live.revlink.impl.lynxcontainer.a
    public final void l(CallContext r2) {
        Intrinsics.checkNotNullParameter(r2, "callContext");
        com.bytedance.android.live.revlink.impl.lynxcontainer.a r0 = this.c;
        if (r0 == null) goto L6;
        r0.l(r2);
        return;
    }

    @Override // com.bytedance.android.live.revlink.impl.lynxcontainer.a
    public final int m(ae r2) {
        Intrinsics.checkNotNullParameter(r2, "params");
        com.bytedance.android.live.revlink.impl.lynxcontainer.a r0 = this.c;
        if (r0 != null) goto L7;
        return 1;
    L7:
        return r0.m(r2);
    }

    @Override // com.bytedance.android.live.revlink.impl.lynxcontainer.a
    public final void b(String r3, String r4) {
        Intrinsics.checkNotNullParameter(r3, "event");
        Intrinsics.checkNotNullParameter(r4, "action");
        if (com.bytedance.android.live.revlink.impl.settings.dynamic.a.H.g() == false) goto L11;
        e0 r0 = this.h;
        r0.getClass();
        Intrinsics.checkNotNullParameter(r3, "type");
        Intrinsics.checkNotNullParameter(r4, Constants.Keys.DATA);
        if (Intrinsics.areEqual(r3, "intercom_data") == false) goto L8;
        r0.k.setValue(new JSONObject(r4));
        return;
    L8:
        if (Intrinsics.areEqual(r3, "double_mute_status") == false) goto L16;
        r0.j.setValue(r4);
        return;
    L16:
        return;
    L11:
        com.bytedance.android.live.revlink.impl.lynxcontainer.a r1 = this.c;
        if (r1 == null) goto L17;
        r1.b(r3, r4);
        return;
    }

    @Override // com.bytedance.android.live.revlink.impl.lynxcontainer.a
    public final void d(CallContext r2, List<String> r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "tags");
        com.bytedance.android.live.revlink.impl.lynxcontainer.a r0 = this.c;
        if (r0 == null) goto L6;
        r0.d(r2, r3);
        return;
    }

    public MultiDynamicContextImpl(Function0 r22, ld.a r23, com.bytedance.android.livesdk.revenue.service.room.c r24, com.bytedance.android.live.revlink.impl.global.c r25, PkBaseDataContext r26, DynamicContextDependencyImpl r27, AnchorLinkUserCenterV2 r28, DynamicContextDependencyImpl r29, com.bytedance.android.live.revlink.link.domain.dependencyimpl.a r210, com.bytedance.android.live.revlink.impl.multianchor.ui.i r30, String r32, int r33) {
        if ((r33 & 512) == 0) goto L5;
        com.bytedance.android.live.revlink.impl.multianchor.ui.i r16 = null;
    L7:
        if ((r33 & 1024) == 0) goto L9;
        String r17 = null;
    L10:
        Intrinsics.checkNotNullParameter(r22, "scene");
        Intrinsics.checkNotNullParameter(r26, "pkBaseDataContext");
        Intrinsics.checkNotNullParameter(r210, "seiDependencies");
        this.i = r22;
        this.j = r23;
        this.k = r24;
        this.l = r25;
        this.m = r26;
        this.n = r27;
        this.o = r28;
        this.p = r29;
        this.q = null;
        this.a = new CompositeDisposable();
        com.bytedance.android.livesdk.revenue.room.a r1 = r24.getRoomContext();
        if (r1 == null) goto L15;
        boolean r2 = true;
        if (r1.getCommonIsAnchor() != true) goto L15;
    L16:
        this.b = r2;
        this.d = new com.bytedance.android.live.revlink.impl.multianchor.dynamic.l(new MultiDynamicContextImpl$localComponentManager$1(this));
        this.e = new MultiDynamicLocalContext();
        this.f = LazyKt.lazy(MultiDynamicContextImpl$isRelayoutOpt$2.INSTANCE);
        com.bytedance.android.live.revlink.impl.multianchor.ui.i r12 = r16;
        String r13 = r17;
        this.g = new k0(r22, r23, r24, r25, r26, r27, r28, r29, r210, r12, r13, null);
        this.h = new e0(r22, r23, r24, r25, r26, r27, r28, r29, r210, r12, r13, null);
        return;
    L15:
        r2 = false;
        goto L16
    L9:
        r17 = r32;
        goto L10
    L5:
        r16 = r30;
        goto L7
    }
}
