package com.bytedance.android.live.revlink.link.biz.doublecomponent;

import androidx.lifecycle.LiveData;
import com.bytedance.android.live.revlink.impl.mergepk.pkbase.PkBaseDataContext;
import com.bytedance.android.live.revlink.impl.mergepk.pkbase.statemachine.PkBaseStateMachine;
import com.bytedance.android.live.revlink.impl.mergepk.pkbase.subdatacontext.PkBaseResult;
import com.bytedance.android.live.revlink.impl.multianchor.constants.PlayMode;
import com.bytedance.android.live.revlink.impl.pk.breakthrough.BreakThroughBarImpl;
import com.bytedance.android.live.revlink.impl.pk.scopeservice.PkLynxInfoImpl;
import com.bytedance.android.live.revlink.impl.pk.scopeservice.PkWidgetDataContext;
import com.bytedance.android.live.revlink.link.biz.component.BackgroundComponent;
import com.bytedance.android.live.revlink.link.biz.service.e;
import com.bytedance.android.live.revlink.link.biz.service.i;
import com.bytedance.android.live.revlink.link.utils.UtilsKt;
import com.bytedance.live.datacontext.DataContext;
import com.bytedance.revenue.platform.api.core.rx.f;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import w20.v9;
import z41.g;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class DoubleNativeComponent implements e, com.bytedance.android.live.revlink.impl.pk.scopeservice.a {
    public static final /* synthetic */ int q = 0;
    public final String a;
    public final CompositeDisposable b;
    public final List<String> c;
    public final List<String> d;
    public final List<String> e;
    public List<String> f;
    public PkLynxInfoImpl g;
    public BreakThroughBarImpl h;
    public final d i;
    public final LynxUIOperationImpl j;
    public final BreakThroughUIOperationImpl k;
    public boolean l;
    public final com.bytedance.android.live.revlink.link.infra.lifecontrol.context.d m;
    public final com.bytedance.android.livesdk.revenue.service.room.c n;
    public final BackgroundComponent o;
    public final PkBaseDataContext p;

    public static final class a {
    }

    /* JADX INFO: renamed from: com.bytedance.android.live.revlink.link.biz.doublecomponent.DoubleNativeComponent$attach$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\b\u0010\u0001\u001a\u0004\u0018\u00010\u0000¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/bytedance/android/live/revlink/impl/mergepk/pkbase/statemachine/PkBaseStateMachine$c;", "p1", "", "invoke", "(Lcom/bytedance/android/live/revlink/impl/mergepk/pkbase/statemachine/PkBaseStateMachine$c;)V", "<anonymous>"}, k = 3, mv = {1, 5, 1})
    public static final /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function1<PkBaseStateMachine.c, Unit> {
        public AnonymousClass1(DoubleNativeComponent r8) {
            super(1, r8, DoubleNativeComponent.class, "onPkStateChange", "onPkStateChange(Lcom/bytedance/android/live/revlink/impl/mergepk/pkbase/statemachine/PkBaseStateMachine$State;)V", 0);
        }

        public final void invoke(PkBaseStateMachine.c r7) {
            DoubleNativeComponent r0 = (DoubleNativeComponent) ((CallableReference) this).receiver;
            int r1 = DoubleNativeComponent.q;
            r0.getClass();
            List r2 = CollectionsKt.listOf(new PkBaseDataContext.PKModType[]{PkBaseDataContext.PKModType.Default, PkBaseDataContext.PKModType.SeasonRank, PkBaseDataContext.PKModType.InteractPk});
            if (r7 != null) goto L5;
        L21:
            r0.f = null;
            r0.c();
        L22:
            if (r7 != null) goto L24;
        L32:
            r0.l = false;
            return;
        L24:
            if (r7.a() != true) goto L32;
            if (r0.l == false) goto L28;
            return;
        L28:
            if (g.o.a() == true) goto L30;
            return;
        L30:
            if (r0.p.isInCloudCollaborate() == true) goto L36;
            r0.b("pk_hybrid");
            r0.b("pve_bar");
            r0.l = true;
            return;
        L36:
            return;
        L5:
            if (r7.a() != true) goto L21;
            if ((!Intrinsics.areEqual(r0.f, r0.d)) == false) goto L12;
            if (r0.p.isInVote() == false) goto L12;
            r0.c();
            r0.f = r0.d;
        L12:
            if ((!Intrinsics.areEqual(r0.f, r0.e)) == false) goto L17;
            if (r0.p.isInBreakThrough() == false) goto L17;
            r0.c();
            r0.f = r0.e;
        L17:
            if ((!Intrinsics.areEqual(r0.f, r0.c)) == false) goto L22;
            if (r2.contains(r0.p.modType()) == false) goto L22;
            r0.c();
            r0.f = r0.c;
            goto L22
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1) {
            invoke((PkBaseStateMachine.c) r1);
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: renamed from: com.bytedance.android.live.revlink.link.biz.doublecomponent.DoubleNativeComponent$attach$2, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "p1", "Lcom/bytedance/android/live/revlink/impl/multianchor/constants/PlayMode;", "invoke"}, k = 3, mv = {1, 5, 1})
    public static final /* synthetic */ class AnonymousClass2 extends FunctionReferenceImpl implements Function1<PlayMode, Unit> {
        public AnonymousClass2(DoubleNativeComponent r8) {
            super(1, r8, DoubleNativeComponent.class, "onTeamModeChange", "onTeamModeChange(Lcom/bytedance/android/live/revlink/impl/multianchor/constants/PlayMode;)V", 0);
        }

        public final void invoke(PlayMode r3) {
            DoubleNativeComponent r0 = (DoubleNativeComponent) ((CallableReference) this).receiver;
            int r1 = DoubleNativeComponent.q;
            if (r3 == null) goto L5;
            r0.getClass();
            return;
        L5:
            r0.c();
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1) {
            invoke((PlayMode) r1);
            return Unit.INSTANCE;
        }
    }

    static {
    }

    @Override // com.bytedance.android.live.revlink.link.biz.service.e
    public final String getTAG() {
        return "RevenueLinkBaseComponent";
    }

    @Override // com.bytedance.android.live.revlink.link.biz.service.e
    public final void attach() {
        LiveData<PkBaseStateMachine.c> r0 = this.p.getPkBaseState();
        AnonymousClass1 r1 = new AnonymousClass1(this);
        Intrinsics.checkNotNullParameter(r0, "$this$subscribeWithNotify");
        Intrinsics.checkNotNullParameter(r1, "onChange");
        Disposable r2 = UtilsKt.d(r0, r1);
        r1.invoke(r0.getValue());
        f.a(r2, this.b);
        f.a(UtilsKt.d(this.p.m596getTeamMode(), new AnonymousClass2(this)), this.b);
        Pair r3 = com.bytedance.live.datacontext.d.a(DoubleNativeComponent$attach$widgetDataPair$1.INSTANCE);
        ((PkWidgetDataContext) r3.getFirst()).getService().d(this);
        getContext().T6("IPkBaseWidgetService", (DataContext) r3.getFirst());
        f.a((Disposable) r3.getSecond(), this.b);
    }

    public final void d() {
        BreakThroughBarImpl r0 = this.h;
        if (r0 == null) goto L8;
        r0.m.getBaseTimeLeft().removeObserver(r0.i);
        r0.m.getBattleScoreData().removeObserver(r0.j);
        r0.l.getPlayState().removeObserver(r0.k);
        r0.g.clear();
        zy0.b r2 = r0.b;
        if (r2 == null) goto L7;
        r2.dispose();
    L7:
        r0.b = null;
        r0.e = false;
        r0.c.clear();
        r0.d.clear();
    L8:
        this.h = null;
        this.k.k();
    }

    public final void e() {
        PkLynxInfoImpl r0 = this.g;
        if (r0 == null) goto L8;
        r0.u.getPkBaseState().removeObserver(r0.l);
        r0.u.getBaseTimeLeft().removeObserver(r0.m);
        r0.u.getPkBaseResult().removeObserver(r0.o);
        r0.v.getTeamTaskOptAddition().removeObserver(r0.q);
        r0.w.getPkTeamTaskLynxData().removeObserver(r0.n);
        r0.w.getHandlePkConsecutiveWin().removeObserver(r0.r);
        r0.w.getHandleTeamTaskOverLine().removeObserver(r0.t);
        r0.w.getHandleFirstUpdateMessage().removeObserver(r0.s);
        r0.i.clear();
        zy0.b r2 = r0.b;
        if (r2 == null) goto L7;
        r2.dispose();
    L7:
        r0.b = null;
        r0.e = false;
        r0.c.clear();
        r0.d.clear();
        r0.g = PkLynxInfoImpl.LynxPkState.NONE;
        r0.h = PkBaseResult.NOT_FINISH;
    L8:
        this.g = null;
        this.j.removeAll();
    }

    public final void c() {
        e();
        d();
        this.l = false;
    }

    @Override // com.bytedance.android.live.revlink.link.biz.service.e
    public final void detach() {
        c();
        this.j.detach();
        this.k.detach();
        this.b.clear();
    }

    @Override // com.bytedance.android.live.revlink.link.biz.service.k
    public final com.bytedance.android.live.revlink.impl.global.c getLinkInstanceService() {
        return getContext();
    }

    @Override // com.bytedance.android.live.revlink.link.biz.service.e
    public final String getComponentName() {
        return this.a;
    }

    @Override // com.bytedance.android.live.revlink.link.biz.service.e, com.bytedance.android.live.revlink.link.biz.service.j
    public com.bytedance.android.live.revlink.link.infra.lifecontrol.context.d getContext() {
        return this.m;
    }

    @Override // com.bytedance.android.live.revlink.impl.pk.scopeservice.a
    public final void a(String r3) {
        Intrinsics.checkNotNullParameter(r3, "tag");
        int r0 = r3.hashCode();
        if (r0 == (-1563578176)) goto L11;
        if (r0 == (-204359949)) goto L8;
        return;
    L8:
        if (r3.equals("pve_bar") == false) goto L14;
        d();
        return;
    L14:
        return;
    L11:
        if (r3.equals("pk_hybrid") == false) goto L16;
        e();
        return;
    }

    @Override // com.bytedance.android.live.revlink.impl.pk.scopeservice.a
    public final void b(String r14) {
        Intrinsics.checkNotNullParameter(r14, "tag");
        List<String> r0 = this.f;
        if (r0 != null) goto L5;
        return;
    L5:
        if (r0.contains(r14) != true) goto L32;
        com.bytedance.android.live.revlink.impl.mergepk.pkbase.e r1 = i.S(this);
        if (r1 != null) goto L10;
        return;
    L10:
        Intrinsics.checkNotNullParameter(this, "$this$doublePkService");
        com.bytedance.android.live.revlink.impl.mergepk.pkdouble.c r2 = i.getContext(this).K8();
        if (r2 != null) goto L13;
        return;
    L13:
        int r3 = r14.hashCode();
        if (r3 == (-1563578176)) goto L25;
        if (r3 == (-204359949)) goto L19;
        return;
    L19:
        if (r14.equals("pve_bar") == false) goto L29;
        d();
        com.bytedance.android.live.revlink.impl.mergepk.pkbase.subplaymode.a r4 = r1.getBreakThroughService();
        if (r4 != null) goto L23;
        return;
    L23:
        BreakThroughBarImpl r15 = new BreakThroughBarImpl(r4, r1, r2, this.i, this.k, getContext(), this.n, new DoubleNativeComponent$loadWidgetByJsb$2(this.k), getContext().r9(), getContext().getLinkDataSet());
        this.h = r15;
        r15.attach();
        return;
    L29:
        return;
    L25:
        if (r14.equals("pk_hybrid") == false) goto L31;
        e();
        PkLynxInfoImpl r16 = new PkLynxInfoImpl(r1, r2, r2.getTeamTaskService(), this.i, getContext(), this.j, getContext().r9(), getContext().getLinkDataSet(), this.n, new DoubleNativeComponent$loadWidgetByJsb$1(this.j));
        this.g = r16;
        r16.attach();
        return;
    L31:
        return;
    }

    @Override // com.bytedance.android.live.revlink.impl.pk.scopeservice.a
    public final void handleBattleBgImage(v9 r3) {
        Intrinsics.checkNotNullParameter(r3, "params");
        BackgroundComponent r1 = this.o;
        r1.getClass();
        Intrinsics.checkNotNullParameter(r3, "params");
        r1.c = r3;
        r1.c();
    }

    public DoubleNativeComponent(com.bytedance.android.live.revlink.link.infra.lifecontrol.context.d r2, com.bytedance.android.livesdk.revenue.service.room.c r3, BackgroundComponent r4, PkBaseDataContext r5) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "roomService");
        Intrinsics.checkNotNullParameter(r4, "backgroundComponent");
        Intrinsics.checkNotNullParameter(r5, "pkBaseDataContext");
        this.m = r2;
        this.n = r3;
        this.o = r4;
        this.p = r5;
        this.a = "DoubleNativeComponent";
        this.b = new CompositeDisposable();
        this.c = CollectionsKt.listOf("pk_hybrid");
        this.d = CollectionsKt.listOf("pk_hybrid");
        this.e = CollectionsKt.listOf("pve_bar");
        this.i = new d(getContext());
        LynxUIOperationImpl r6 = new LynxUIOperationImpl(getContext());
        r6.attach();
        Unit r7 = Unit.INSTANCE;
        this.j = r6;
        BreakThroughUIOperationImpl r8 = new BreakThroughUIOperationImpl(getContext());
        r8.attach();
        this.k = r8;
    }
}
