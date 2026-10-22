package com.bytedance.android.live.revlink.link.biz.component;

import com.bytedance.android.live.revlink.impl.mergepk.pkbase.PkBaseDataContext;
import com.bytedance.android.live.revlink.impl.model.BizType;
import com.bytedance.android.live.revlink.impl.multianchor.utils.u;
import com.bytedance.android.live.revlink.impl.multianchor.vm.MultiAnchorLinkContext;
import com.bytedance.android.live.revlink.impl.pk.scope.service.MultiPkScopeProviderService;
import com.bytedance.android.live.revlink.link.biz.component.switchscenecompact.DoubleSceneCompactComponent;
import com.bytedance.android.live.revlink.link.biz.component.switchscenecompact.MultiSceneCompactComponent;
import com.bytedance.android.live.revlink.link.domain.service.RevLinkDomainAnchorService;
import com.bytedance.android.live.revlink.link.utils.UtilsKt;
import com.bytedance.android.livesdk.link.model.p0;
import com.bytedance.android.livesdk.link.model.v3;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.subjects.PublishSubject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class SwitchSceneCompactComponent implements com.bytedance.android.live.revlink.link.biz.service.c {
    public final String a;
    public final CompositeDisposable b;
    public com.bytedance.android.live.revlink.link.biz.service.c c;
    public final com.bytedance.android.live.revlink.link.infra.lifecontrol.context.a d;
    public final com.bytedance.android.livesdk.revenue.service.room.c e;
    public final BackgroundComponent f;
    public final PkBaseDataContext g;
    public final com.bytedance.android.live.revlink.link.streaminteract.biz.c h;
    public final h i;
    public final com.bytedance.android.live.revenuelink.rtc.i j;
    public final MultiPKContextHolder k;
    public final com.bytedance.android.live.revlink.link.biz.doublecomponent.c l;
    public final g m;
    public final MultiRTCBizComponent n;
    public final yz0.f o;
    public final RevLinkDomainAnchorService p;
    public final MultiAnchorLinkContext q;
    public final MultiPkScopeProviderService r;

    /* JADX INFO: renamed from: com.bytedance.android.live.revlink.link.biz.component.SwitchSceneCompactComponent$attach$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "p1", "", "invoke"}, k = 3, mv = {1, 5, 1})
    public static final /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function1<Integer, Unit> {
        public AnonymousClass1(SwitchSceneCompactComponent r8) {
            super(1, r8, SwitchSceneCompactComponent.class, "onBizEnd", "onBizEnd(I)V", 0);
        }

        public final void invoke(int r6) {
            SwitchSceneCompactComponent r0 = (SwitchSceneCompactComponent) ((CallableReference) this).receiver;
            com.bytedance.android.live.revlink.link.biz.service.c r1 = r0.c;
            if (r1 != null) goto L6;
            return;
        L6:
            if (r6 != 1) goto L11;
            if ((r1 instanceof DoubleCompactComponent) == false) goto L11;
        L13:
            jy0.b.c(com.bytedance.android.live.revlink.link.biz.service.e.a.a(r0), "onBizEnd scene=" + r6 + ", compactComponent=" + r1, null, 4);
            com.bytedance.android.live.revlink.link.biz.service.c r7 = r0.c;
            if (r7 == null) goto L16;
            r7.detach();
        L16:
            r0.c = null;
            return;
        L11:
            if (r6 != 7) goto L13;
            boolean r2 = r1 instanceof MultiSceneCompactComponent;
            goto L13
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1) {
            invoke(((Number) r1).intValue());
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: renamed from: com.bytedance.android.live.revlink.link.biz.component.SwitchSceneCompactComponent$attach$2, reason: invalid class name */
    @Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 5, 1})
    public static final /* synthetic */ class AnonymousClass2 extends FunctionReferenceImpl implements Function0<Unit> {
        public AnonymousClass2(SwitchSceneCompactComponent r8) {
            super(0, r8, SwitchSceneCompactComponent.class, "onSwitchScene", "onSwitchScene()V", 0);
        }

        /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
        public final void m898invoke() {
            ((SwitchSceneCompactComponent) ((CallableReference) this).receiver).a();
        }

        public /* bridge */ /* synthetic */ Object invoke() {
            m898invoke();
            return Unit.INSTANCE;
        }
    }

    @Override // com.bytedance.android.live.revlink.link.biz.service.e
    public final String getTAG() {
        return "RevenueLinkAnchorComponent";
    }

    public final void a() {
        jy0.b.c(com.bytedance.android.live.revlink.link.biz.service.e.a.a(this), "onSwitchScene old compactComponent=" + this.c, null, 4);
        com.bytedance.android.live.revlink.link.biz.service.c r1 = this.c;
        if (r1 == null) goto L5;
        r1.detach();
    L5:
        this.c = null;
        int r2 = getContext().getScene();
        if (r2 != 1) goto L8;
        com.bytedance.android.live.revlink.link.biz.service.c r3 = new DoubleSceneCompactComponent(getContext(), this.e, this.f, this.g, this.h, this.i, this.j, this.m, this.l);
    L12:
        this.c = r3;
        jy0.b.c(com.bytedance.android.live.revlink.link.biz.service.e.a.a(this), "onSwitchScene scene=" + getContext().getScene() + ", compactComponent=" + this.c, null, 4);
        com.bytedance.android.live.revlink.link.biz.service.c r4 = this.c;
        if (r4 == null) goto L16;
        r4.attach();
        return;
    L16:
        return;
    L8:
        if (r2 == 7) goto L10;
        r3 = null;
        goto L12
    L10:
        r3 = new MultiSceneCompactComponent(getContext(), this.e, this.g, this.k, this.n, this.o, this.p, this.i, this.q, this.m, this.r, this.h);
        goto L12
    }

    @Override // com.bytedance.android.live.revlink.link.biz.service.e
    public final void attach() {
        PublishSubject<Integer> r0 = getContext().a9();
        final AnonymousClass1 r1 = new AnonymousClass1(this);
        com.bytedance.revenue.platform.api.core.rx.f.a(r0.subscribe(new a(r1)), this.b);
        com.bytedance.revenue.platform.api.core.rx.f.a(UtilsKt.g(getContext().t(), new AnonymousClass2(this)), this.b);
        a();
        u r2 = com.bytedance.android.live.revlink.link.biz.service.i.y(this);
        if (r2 == null) goto L5;
        int r3 = r2.i;
    L7:
        if (e21.a.a(r3) == true) goto L21;
        d31.b r4 = com.bytedance.android.live.revlink.link.biz.service.i.C(this);
        com.bytedance.android.live.revlink.impl.control.launchcontext.a r5 = com.bytedance.android.live.revlink.link.biz.service.i.x(this);
        String r6 = null;
        if (r5 == null) goto L11;
        v3 r7 = r5.c;
    L12:
        com.bytedance.android.live.revlink.impl.control.launchcontext.a r8 = com.bytedance.android.live.revlink.link.biz.service.i.x(this);
        if (r8 == null) goto L15;
        p0 r9 = r8.d;
    L16:
        com.bytedance.android.live.revlink.impl.control.launchcontext.a r10 = com.bytedance.android.live.revlink.link.biz.service.i.x(this);
        if (r10 == null) goto L19;
        r6 = r10.e;
    L19:
        r4.a(r7, r9, r6);
        return;
    L15:
        r9 = null;
        goto L16
    L11:
        r7 = null;
        goto L12
    L21:
        return;
    L5:
        r3 = BizType.None.ordinal();
        goto L7
    }

    @Override // com.bytedance.android.live.revlink.link.biz.service.e
    public final void detach() {
        jy0.b.c(com.bytedance.android.live.revlink.link.biz.service.e.a.a(this), "detach scene=" + getContext().getScene() + ", compactComponent=" + this.c, null, 4);
        com.bytedance.android.live.revlink.link.biz.service.c r0 = this.c;
        if (r0 == null) goto L5;
        r0.detach();
    L5:
        this.c = null;
        this.b.clear();
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
        return this.d;
    }

    public SwitchSceneCompactComponent(com.bytedance.android.live.revlink.link.infra.lifecontrol.context.g r17, com.bytedance.android.livesdk.revenue.service.room.c r18, BackgroundComponent r19, PkBaseDataContext r20, com.bytedance.android.live.revlink.link.streaminteract.biz.c r22, h r23, com.bytedance.android.live.revenuelink.rtc.i r24, MultiPKContextHolder r25, com.bytedance.android.live.revlink.link.biz.doublecomponent.c r26, g r27, MultiRTCBizComponent r28, yz0.f r29, RevLinkDomainAnchorService r210, MultiAnchorLinkContext r30, MultiPkScopeProviderService r32) {
        Intrinsics.checkNotNullParameter(r17, "context");
        Intrinsics.checkNotNullParameter(r18, "roomService");
        Intrinsics.checkNotNullParameter(r19, "backgroundComponent");
        Intrinsics.checkNotNullParameter(r20, "pkBaseDataContext");
        Intrinsics.checkNotNullParameter(r22, "streamMixManagerService");
        Intrinsics.checkNotNullParameter(r23, "bizDataContext");
        Intrinsics.checkNotNullParameter(r24, "rtcManager");
        Intrinsics.checkNotNullParameter(r25, "multiPKContextHolder");
        Intrinsics.checkNotNullParameter(r26, "doublePKAnchorDataContextHolder");
        Intrinsics.checkNotNullParameter(r27, "multiChorusComponent");
        Intrinsics.checkNotNullParameter(r28, "rtcBizComponent");
        Intrinsics.checkNotNullParameter(r29, "messageService");
        Intrinsics.checkNotNullParameter(r210, "domainAnchorService");
        Intrinsics.checkNotNullParameter(r30, "linkContext");
        Intrinsics.checkNotNullParameter(r32, "multiPkScopeService");
        this.d = r17;
        this.e = r18;
        this.f = r19;
        this.g = r20;
        this.h = r22;
        this.i = r23;
        this.j = r24;
        this.k = r25;
        this.l = r26;
        this.m = r27;
        this.n = r28;
        this.o = r29;
        this.p = r210;
        this.q = r30;
        this.r = r32;
        this.a = "SwitchSceneCompactComponent";
        this.b = new CompositeDisposable();
    }
}
