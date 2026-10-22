package com.bytedance.android.live.revlink.link.biz.service;

import androidx.lifecycle.LiveData;
import com.bytedance.android.live.revlink.impl.mergepk.pkbase.statemachine.PkBaseStateMachine;
import com.bytedance.android.live.revlink.impl.multianchor.constants.PlayMode;
import com.bytedance.android.live.revlink.link.biz.component.MultiNativeComponent;
import com.bytedance.android.live.revlink.link.biz.multipkcomponent.MultiAnchorPkComponent;
import com.bytedance.android.live.revlink.link.biz.multipkcomponent.MultiAnchorTeamPkComponent;
import com.bytedance.android.live.revlink.link.biz.multipkcomponent.MultiBreakThroughComponent;
import com.bytedance.android.live.revlink.link.utils.UtilsKt;
import com.bytedance.android.livesdk.link.model.api.IBaseBattleSetting;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class MultiPKComponent implements e {
    public final String a;
    public final CompositeDisposable b;
    public e c;
    public final com.bytedance.android.live.revlink.link.infra.lifecontrol.context.d d;
    public final com.bytedance.android.livesdk.revenue.service.room.c e;
    public final MultiNativeComponent f;

    /* JADX INFO: renamed from: com.bytedance.android.live.revlink.link.biz.service.MultiPKComponent$attach$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "p1", "Lcom/bytedance/android/live/revlink/impl/multianchor/constants/PlayMode;", "invoke"}, k = 3, mv = {1, 5, 1})
    public static final /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function1<PlayMode, Unit> {
        public AnonymousClass1(MultiPKComponent r8) {
            super(1, r8, MultiPKComponent.class, "onPlayModeChange", "onPlayModeChange(Lcom/bytedance/android/live/revlink/impl/multianchor/constants/PlayMode;)V", 0);
        }

        public final void invoke(PlayMode r15) {
            MultiPKComponent r0 = (MultiPKComponent) ((CallableReference) this).receiver;
            r0.getClass();
            com.bytedance.android.live.revlink.impl.mergepk.pkbase.e r1 = i.S(r0);
            if (r1 == null) goto L50;
            IBaseBattleSetting r2 = r1.getBattleSettings();
            if (r2 != null) goto L8;
        L46:
            if (r15 != null) goto L49;
            r0.a(null);
            return;
        L49:
            return;
        L8:
            if (r15 != PlayMode.PERSONAL_PK) goto L27;
            r0.a(r15);
            com.bytedance.android.live.revlink.impl.mergepk.pkbase.e r9 = i.S(r0);
            if (r9 == null) goto L27;
            com.bytedance.android.live.revlink.impl.mergepk.pkmulti.b r3 = i.M(r0);
            if (r3 == null) goto L27;
            if (r2.getDuration() <= 0) goto L27;
            if (r0.c != null) goto L27;
            if (r9.isInBreakThrough() == true) goto L23;
        L25:
            e r13 = new MultiAnchorPkComponent(r0.getContext(), r0.e, r9, r3.getPkStartParam());
        L26:
            r0.c = r13;
            r13.attach();
            goto L27
        L23:
            if (r9.getBreakThroughService() == null) goto L25;
            r13 = new MultiBreakThroughComponent(r0.getContext(), r0.e, r9, r3.getPkStartParam(), r9.getBreakThroughService(), r0.f);
        L27:
            com.bytedance.android.live.revlink.impl.mergepk.pkmulti.b r4 = i.M(r0);
            if (r4 == null) goto L30;
            Map<String, Long> r5 = r4.getUserIdToTeamId();
        L32:
            if (r15 != PlayMode.TEAM_PK) goto L46;
            if (r5 == null) goto L46;
            r0.a(r15);
            com.bytedance.android.live.revlink.impl.mergepk.pkbase.e r6 = i.S(r0);
            if (r6 == null) goto L46;
            com.bytedance.android.live.revlink.impl.mergepk.pkmulti.b r7 = i.M(r0);
            if (r7 == null) goto L46;
            if (r2.getDuration() <= 0) goto L46;
            if (r0.c != null) goto L46;
            MultiAnchorTeamPkComponent r8 = new MultiAnchorTeamPkComponent(r0.getContext(), r0.e, r6, r7.getPkStartParam());
            r0.c = r8;
            r8.attach();
            goto L46
        L30:
            r5 = null;
            goto L32
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1) {
            invoke((PlayMode) r1);
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: renamed from: com.bytedance.android.live.revlink.link.biz.service.MultiPKComponent$attach$2, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\b\u0010\u0001\u001a\u0004\u0018\u00010\u0000¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/bytedance/android/live/revlink/impl/mergepk/pkbase/statemachine/PkBaseStateMachine$c;", "p1", "", "invoke", "(Lcom/bytedance/android/live/revlink/impl/mergepk/pkbase/statemachine/PkBaseStateMachine$c;)V", "<anonymous>"}, k = 3, mv = {1, 5, 1})
    public static final /* synthetic */ class AnonymousClass2 extends FunctionReferenceImpl implements Function1<PkBaseStateMachine.c, Unit> {
        public AnonymousClass2(MultiPKComponent r8) {
            super(1, r8, MultiPKComponent.class, "onPKStateChange", "onPKStateChange(Lcom/bytedance/android/live/revlink/impl/mergepk/pkbase/statemachine/PkBaseStateMachine$State;)V", 0);
        }

        public final void invoke(PkBaseStateMachine.c r2) {
            ((MultiPKComponent) ((CallableReference) this).receiver).getClass();
            if ((r2 instanceof PkBaseStateMachine.c.C0130c) == false) goto L6;
            vh6.c.b(com.bytedance.android.livesdk.revenue.service.gift.a.class).v3();
            return;
        L6:
            if ((r2 instanceof PkBaseStateMachine.c.b) == false) goto L10;
            vh6.c.b(com.bytedance.android.livesdk.revenue.service.gift.a.class).Ek();
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

    @Override // com.bytedance.android.live.revlink.link.biz.service.e
    public final void detach() {
        this.b.clear();
        e r0 = this.c;
        if (r0 == null) goto L5;
        r0.detach();
    L5:
        this.c = null;
    }

    @Override // com.bytedance.android.live.revlink.link.biz.service.e
    public final void attach() {
        com.bytedance.android.live.revlink.impl.mergepk.pkbase.e r0 = i.S(this);
        if (r0 == null) goto L9;
        LiveData<PlayMode> r1 = r0.getTeamMode();
        if (r1 == null) goto L9;
        Disposable r2 = UtilsKt.d(r1, new AnonymousClass1(this));
        if (r2 == null) goto L9;
        com.bytedance.revenue.platform.api.core.rx.f.a(r2, this.b);
    L9:
        com.bytedance.android.live.revlink.impl.mergepk.pkbase.e r3 = i.S(this);
        if (r3 == null) goto L17;
        LiveData<PkBaseStateMachine.c> r4 = r3.getPkBaseState();
        if (r4 == null) goto L18;
        Disposable r5 = UtilsKt.d(r4, new AnonymousClass2(this));
        if (r5 == null) goto L19;
        com.bytedance.revenue.platform.api.core.rx.f.a(r5, this.b);
        return;
    L19:
        return;
    L18:
        return;
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
        return this.d;
    }

    public final void a(PlayMode r4) {
        e r0 = this.c;
        if (r0 != null) goto L5;
    L13:
        e r1 = this.c;
        if (r1 != null) goto L16;
        return;
    L16:
        if ((r1 instanceof MultiAnchorTeamPkComponent) == true) goto L18;
        return;
    L18:
        if (r4 == PlayMode.TEAM_PK) goto L25;
        if (r1 == null) goto L21;
        r1.detach();
    L21:
        this.c = null;
        return;
    L25:
        return;
    L5:
        if ((r0 instanceof MultiAnchorPkComponent) == true) goto L9;
        if ((r0 instanceof MultiBreakThroughComponent) == false) goto L13;
    L9:
        if (r4 == PlayMode.PERSONAL_PK) goto L13;
        if (r0 == null) goto L12;
        r0.detach();
    L12:
        this.c = null;
        goto L13
    }

    public MultiPKComponent(com.bytedance.android.live.revlink.link.infra.lifecontrol.context.d r2, com.bytedance.android.livesdk.revenue.service.room.c r3, MultiNativeComponent r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "roomService");
        Intrinsics.checkNotNullParameter(r4, "nativeComponent");
        this.d = r2;
        this.e = r3;
        this.f = r4;
        this.a = "MultiPKComponent";
        this.b = new CompositeDisposable();
    }
}
