package com.bytedance.android.live.revlink.link.biz.multipkcomponent;

import com.bytedance.android.live.revlink.impl.mergepk.pkbase.statemachine.PkBaseStateMachine;
import com.bytedance.android.live.revlink.impl.mergepk.pkmulti.PkMultiDataContext;
import com.bytedance.android.live.revlink.impl.multianchor.pk.datacontext.MultiCommonPkDataContext;
import com.bytedance.android.live.revlink.impl.multianchor.pk.logger.c;
import com.bytedance.android.live.revlink.impl.pk.service.ToolBarPic;
import com.bytedance.android.live.revlink.impl.pk.service.i;
import com.bytedance.android.live.revlink.link.biz.service.e;
import com.bytedance.android.live.revlink.link.infra.lifecontrol.context.d;
import com.bytedance.android.live.revlink.link.utils.UtilsKt;
import com.bytedance.android.livesdk.revenue.log.LogCommon;
import com.bytedance.live.datacontext.DataContext;
import com.bytedance.revenue.platform.api.core.rx.f;
import cy0.j;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import j31.a;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import jy0.b;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import mz0.m;
import mz0.n;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class MultiAnchorTeamPkComponent implements e, MultiCommonPkDataContext.c {
    public final String a;
    public final c b;
    public final CompositeDisposable c;
    public final d d;
    public final com.bytedance.android.livesdk.revenue.service.room.c e;
    public final com.bytedance.android.live.revlink.impl.mergepk.pkbase.e f;
    public final a g;

    /* JADX INFO: renamed from: com.bytedance.android.live.revlink.link.biz.multipkcomponent.MultiAnchorTeamPkComponent$attach$5, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\b\u0010\u0001\u001a\u0004\u0018\u00010\u0000¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/bytedance/android/live/revlink/impl/mergepk/pkbase/statemachine/PkBaseStateMachine$c;", "p1", "", "invoke", "(Lcom/bytedance/android/live/revlink/impl/mergepk/pkbase/statemachine/PkBaseStateMachine$c;)V", "<anonymous>"}, k = 3, mv = {1, 5, 1})
    public static final /* synthetic */ class AnonymousClass5 extends FunctionReferenceImpl implements Function1<PkBaseStateMachine.c, Unit> {
        public AnonymousClass5(MultiAnchorTeamPkComponent r8) {
            super(1, r8, MultiAnchorTeamPkComponent.class, "onPkStateChange", "onPkStateChange(Lcom/bytedance/android/live/revlink/impl/mergepk/pkbase/statemachine/PkBaseStateMachine$State;)V", 0);
        }

        public final void invoke(PkBaseStateMachine.c r6) {
            MultiAnchorTeamPkComponent r0 = (MultiAnchorTeamPkComponent) ((CallableReference) this).receiver;
            r0.getClass();
            if (r6 == null) goto L22;
            b.c(PkMultiDataContext.TAG, "update pkstate" + r6.c + " updateToolbarIcon isMultiVotePk = " + r0.f.isInVote(), null, 4);
            r0.getContext().getRoomDataCenterService().k9(r6.a());
            if (r0.getContext().r9() == false) goto L11;
            if ((r6 instanceof PkBaseStateMachine.c.d) == false) goto L11;
            r0.b.b(r0.getContext().r9());
        L11:
            if (r6.b() == true) goto L15;
            i r7 = com.bytedance.android.live.revlink.link.biz.service.i.g0(r0);
            if (r7 == null) goto L19;
            r7.S2(ToolBarPic.PK_CLOSE_BROADCAST);
            return;
        L19:
            return;
        L15:
            i r8 = com.bytedance.android.live.revlink.link.biz.service.i.g0(r0);
            if (r8 == null) goto L21;
            r8.onMultiAnchorStateChange(2);
            return;
        L21:
            return;
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1) {
            invoke((PkBaseStateMachine.c) r1);
            return Unit.INSTANCE;
        }
    }

    @Override // com.bytedance.android.live.revlink.link.biz.service.e
    public final String getTAG() {
        return "RevenueLinkBaseComponent";
    }

    @Override // com.bytedance.android.live.revlink.impl.multianchor.pk.datacontext.MultiCommonPkDataContext.c
    public final Map<String, String> a() {
        return this.b.a();
    }

    @Override // com.bytedance.android.live.revlink.link.biz.service.e
    public final void attach() {
        Pair r0 = com.bytedance.live.datacontext.d.a(new AnonymousClass1(this));
        ((MultiCommonPkDataContext) r0.getFirst()).setRoomContext(this.e.getRoomContext());
        ((MultiCommonPkDataContext) r0.getFirst()).setStartParam(this.g);
        getContext().T6(MultiCommonPkDataContext.TAG, (DataContext) r0.getFirst());
        f.a((Disposable) r0.getSecond(), this.c);
        Pair r1 = com.bytedance.live.datacontext.d.a(new AnonymousClass3(this));
        getContext().T6(e.a.a(this), (DataContext) r1.getFirst());
        f.a((Disposable) r1.getSecond(), this.c);
        f.a(UtilsKt.d(this.f.getPkBaseState(), new AnonymousClass5(this)), this.c);
        c r2 = this.b;
        boolean r3 = getContext().r9();
        r2.getClass();
        if (r3 == false) goto L12;
        LinkedHashMap r4 = new LinkedHashMap();
        r4.putAll(r2.a());
        com.bytedance.android.live.revlink.impl.global.c r5 = r2.d;
        if (r5 == null) goto L8;
        com.bytedance.android.live.revlink.impl.mergepk.pkmulti.b r6 = r5.Q1();
    L9:
        if (r6 == null) goto L11;
        r6.setPkLauncher(false);
    L11:
        n r7 = new n();
        Map<String, String> r8 = r7.a;
        Intrinsics.checkNotNullParameter(r8, "map");
        Intrinsics.checkNotNullParameter(r4, "map");
        r8.putAll(r4);
        m r9 = new m();
        r9.b(LogCommon.ROOM);
        ((ArrayList) r7.b).addAll(r9.a);
        cy0.e.a.getClass();
        j r10 = cy0.e.a.a;
        com.bytedance.android.scope.m.e.getClass();
        Object r12 = com.bytedance.android.scope.m.b(r10).a(Reflection.getOrCreateKotlinClass(mz0.i.class));
        Intrinsics.checkNotNull(r12);
        ((mz0.i) ((f80.a) r12)).w3("livesdk_pk_start", r7.a, r7.b);
        goto L12
    L8:
        r6 = null;
    L12:
        com.bytedance.android.live.revlink.link.biz.service.i.L(this).v("team_pk");
        b.f("ttlive_anchor_link_multi_pk", "TeamPK loaded", null, 4);
    }

    @Override // com.bytedance.android.live.revlink.link.biz.service.e
    public final void detach() {
        com.bytedance.android.live.revlink.link.biz.service.i.L(this).u("team_pk");
        this.b.b(getContext().r9());
        this.c.clear();
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
    public d getContext() {
        return this.d;
    }

    public MultiAnchorTeamPkComponent(d r2, com.bytedance.android.livesdk.revenue.service.room.c r3, com.bytedance.android.live.revlink.impl.mergepk.pkbase.e r4, a r5) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "roomService");
        Intrinsics.checkNotNullParameter(r4, "pkBaseService");
        Intrinsics.checkNotNullParameter(r5, "startParam");
        this.d = r2;
        this.e = r3;
        this.f = r4;
        this.g = r5;
        this.a = "MultiAnchorTeamPkComponent";
        this.b = new c(r3, getContext());
        this.c = new CompositeDisposable();
    }
}
