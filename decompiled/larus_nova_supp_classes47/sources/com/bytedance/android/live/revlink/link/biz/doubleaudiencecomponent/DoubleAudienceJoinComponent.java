package com.bytedance.android.live.revlink.link.biz.doubleaudiencecomponent;

import com.bytedance.android.live.revlink.link.biz.component.BackgroundComponent;
import com.bytedance.android.live.revlink.link.biz.service.d;
import com.bytedance.android.live.revlink.link.biz.service.i;
import com.bytedance.android.live.revlink.link.domain.anchorimpl.m;
import com.bytedance.android.live.revlink.link.domain.service.DomainManualLayout;
import com.bytedance.android.live.revlink.link.domain.service.RevLinkDomainAudienceService;
import com.bytedance.android.live.revlink.link.infra.lifecontrol.context.b;
import com.bytedance.android.live.revlink.link.utils.UtilsKt;
import com.bytedance.live.kmp.core.c;
import com.bytedance.revenue.platform.api.core.rx.f;
import cy0.e;
import cy0.j;
import io.reactivex.disposables.CompositeDisposable;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class DoubleAudienceJoinComponent implements d {
    public final String a;
    public final CompositeDisposable b;
    public final b c;
    public final RevLinkDomainAudienceService d;
    public final BackgroundComponent e;

    /* JADX INFO: renamed from: com.bytedance.android.live.revlink.link.biz.doubleaudiencecomponent.DoubleAudienceJoinComponent$attach$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"<anonymous>", "", "p1", "", "invoke", "(Ljava/lang/Boolean;)V"}, k = 3, mv = {1, 5, 1})
    public static final /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function1<Boolean, Unit> {
        public AnonymousClass1(DoubleAudienceJoinComponent r8) {
            super(1, r8, DoubleAudienceJoinComponent.class, "onAudienceSelfJoin", "onAudienceSelfJoin(Ljava/lang/Boolean;)V", 0);
        }

        public final void invoke(Boolean r4) {
            DoubleAudienceJoinComponent r0 = (DoubleAudienceJoinComponent) ((CallableReference) this).receiver;
            r0.getClass();
            if (r4 == null) goto L6;
            r4.booleanValue();
            DomainManualLayout r1 = r0.d.f;
            r1.a = r4.booleanValue();
            r1.b();
            BackgroundComponent r2 = r0.e;
            r2.d = r4.booleanValue();
            r2.c();
            return;
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1) {
            invoke((Boolean) r1);
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: renamed from: com.bytedance.android.live.revlink.link.biz.doubleaudiencecomponent.DoubleAudienceJoinComponent$attach$2, reason: invalid class name */
    @Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 5, 1})
    public static final /* synthetic */ class AnonymousClass2 extends FunctionReferenceImpl implements Function0<Unit> {
        public AnonymousClass2(DoubleAudienceJoinComponent r8) {
            super(0, r8, DoubleAudienceJoinComponent.class, "onAudienceSelfLeave", "onAudienceSelfLeave()V", 0);
        }

        /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
        public final void m905invoke() {
            DoubleAudienceJoinComponent r0 = (DoubleAudienceJoinComponent) ((CallableReference) this).receiver;
            DomainManualLayout r1 = r0.d.f;
            r1.a = false;
            r1.b();
            BackgroundComponent r2 = r0.e;
            r2.d = false;
            r2.c();
        }

        public /* bridge */ /* synthetic */ Object invoke() {
            m905invoke();
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: renamed from: com.bytedance.android.live.revlink.link.biz.doubleaudiencecomponent.DoubleAudienceJoinComponent$attach$3, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"<anonymous>", "", "p1", "", "invoke", "(Ljava/lang/Boolean;)V"}, k = 3, mv = {1, 5, 1})
    public static final /* synthetic */ class AnonymousClass3 extends FunctionReferenceImpl implements Function1<Boolean, Unit> {
        public AnonymousClass3(DoubleAudienceJoinComponent r8) {
            super(1, r8, DoubleAudienceJoinComponent.class, "onAudienceJoinSelfLink", "onAudienceJoinSelfLink(Ljava/lang/Boolean;)V", 0);
        }

        public final void invoke(Boolean r2) {
            DomainManualLayout r0 = ((DoubleAudienceJoinComponent) ((CallableReference) this).receiver).d.f;
            if (r2 == null) goto L5;
            boolean r3 = r2.booleanValue();
        L6:
            r0.b = r3;
            r0.b();
            return;
        L5:
            r3 = false;
            goto L6
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1) {
            invoke((Boolean) r1);
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: renamed from: com.bytedance.android.live.revlink.link.biz.doubleaudiencecomponent.DoubleAudienceJoinComponent$attach$4, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"<anonymous>", "", "p1", "", "invoke", "(Ljava/lang/Boolean;)V"}, k = 3, mv = {1, 5, 1})
    public static final /* synthetic */ class AnonymousClass4 extends FunctionReferenceImpl implements Function1<Boolean, Unit> {
        public AnonymousClass4(DoubleAudienceJoinComponent r8) {
            super(1, r8, DoubleAudienceJoinComponent.class, "onAudienceJoinGuestLink", "onAudienceJoinGuestLink(Ljava/lang/Boolean;)V", 0);
        }

        public final void invoke(Boolean r2) {
            DomainManualLayout r0 = ((DoubleAudienceJoinComponent) ((CallableReference) this).receiver).d.f;
            if (r2 == null) goto L5;
            boolean r3 = r2.booleanValue();
        L6:
            r0.c = r3;
            r0.b();
            return;
        L5:
            r3 = false;
            goto L6
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1) {
            invoke((Boolean) r1);
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: renamed from: com.bytedance.android.live.revlink.link.biz.doubleaudiencecomponent.DoubleAudienceJoinComponent$attach$5, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"<anonymous>", "", "p1", "", "invoke", "(Ljava/lang/Boolean;)V"}, k = 3, mv = {1, 5, 1})
    public static final /* synthetic */ class AnonymousClass5 extends FunctionReferenceImpl implements Function1<Boolean, Unit> {
        public AnonymousClass5(DoubleAudienceJoinComponent r8) {
            super(1, r8, DoubleAudienceJoinComponent.class, "onPkAnchorLeave", "onPkAnchorLeave(Ljava/lang/Boolean;)V", 0);
        }

        public final void invoke(Boolean r4) {
            DoubleAudienceJoinComponent r0 = (DoubleAudienceJoinComponent) ((CallableReference) this).receiver;
            m r1 = r0.getContext().im();
            String r2 = i.T(r0).b();
            if (r2 != null) goto L5;
            r2 = "";
        L5:
            r1.a(r2, !Intrinsics.areEqual(r4, Boolean.FALSE));
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1) {
            invoke((Boolean) r1);
            return Unit.INSTANCE;
        }
    }

    @Override // com.bytedance.android.live.revlink.link.biz.service.e
    public final String getTAG() {
        return "RevenueLinkAudienceComponent";
    }

    @Override // com.bytedance.android.live.revlink.link.biz.service.e
    public final void detach() {
        this.b.clear();
    }

    @Override // com.bytedance.android.live.revlink.link.biz.service.e
    public final void attach() {
        f.a(UtilsKt.i(getContext().getLinkDataSet().cn(), new AnonymousClass1(this)), this.b);
        f.a(UtilsKt.h(getContext().getLinkDataSet().y5(), new AnonymousClass2(this)), this.b);
        f.a(UtilsKt.i(getContext().getLinkDataSet().Fc(), new AnonymousClass3(this)), this.b);
        f.a(UtilsKt.i(getContext().getLinkDataSet().z9(), new AnonymousClass4(this)), this.b);
        f.a(UtilsKt.d(getContext().getLinkDataSet().io(), new AnonymousClass5(this)), this.b);
        e.a.getClass();
        j r1 = e.a.a;
        com.bytedance.android.scope.m.e.getClass();
        Object r0 = com.bytedance.android.scope.m.b(r1).b(com.bytedance.android.livesdk.revenue.service.interact.d.class);
        Intrinsics.checkNotNull(r0);
        if (((c) r0).Sl() == false) goto L6;
        getContext().getRoomDataCenterService().qd();
        return;
    }

    @Override // com.bytedance.android.live.revlink.link.biz.service.d, com.bytedance.android.live.revlink.link.biz.service.e, com.bytedance.android.live.revlink.link.biz.service.j
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

    @Override // com.bytedance.android.live.revlink.link.biz.service.d, com.bytedance.android.live.revlink.link.biz.service.e, com.bytedance.android.live.revlink.link.biz.service.j
    public b getContext() {
        return this.c;
    }

    public DoubleAudienceJoinComponent(b r2, RevLinkDomainAudienceService r3, BackgroundComponent r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "domainService");
        Intrinsics.checkNotNullParameter(r4, "backgroundComponent");
        this.c = r2;
        this.d = r3;
        this.e = r4;
        this.a = "DoubleAudienceJoinComponent";
        this.b = new CompositeDisposable();
    }
}
