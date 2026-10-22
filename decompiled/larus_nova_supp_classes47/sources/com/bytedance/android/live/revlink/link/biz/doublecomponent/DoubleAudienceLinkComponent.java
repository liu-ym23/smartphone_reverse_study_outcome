package com.bytedance.android.live.revlink.link.biz.doublecomponent;

import com.bytedance.android.live.revlink.link.biz.service.e;
import com.bytedance.android.live.revlink.link.biz.service.i;
import com.bytedance.android.live.revlink.link.core.service.AnchorUILayoutManager;
import com.bytedance.android.live.revlink.link.infra.lifecontrol.context.g;
import com.bytedance.android.live.revlink.link.utils.UtilsKt;
import io.reactivex.disposables.CompositeDisposable;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import m51.f;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class DoubleAudienceLinkComponent implements com.bytedance.android.live.revlink.link.biz.service.c {
    public final String a;
    public final CompositeDisposable b;
    public boolean c;
    public boolean d;
    public final com.bytedance.android.live.revlink.link.infra.lifecontrol.context.a e;
    public final AnchorUILayoutManager f;

    /* JADX INFO: renamed from: com.bytedance.android.live.revlink.link.biz.doublecomponent.DoubleAudienceLinkComponent$attach$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"<anonymous>", "", "p1", "", "invoke", "(Ljava/lang/Boolean;)V"}, k = 3, mv = {1, 5, 1})
    public static final /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function1<Boolean, Unit> {
        public AnonymousClass1(DoubleAudienceLinkComponent r8) {
            super(1, r8, DoubleAudienceLinkComponent.class, "onAudienceJoinSelfLink", "onAudienceJoinSelfLink(Ljava/lang/Boolean;)V", 0);
        }

        public final void invoke(Boolean r6) {
            DoubleAudienceLinkComponent r0 = (DoubleAudienceLinkComponent) ((CallableReference) this).receiver;
            r0.getClass();
            Boolean r1 = Boolean.TRUE;
            r0.c = Intrinsics.areEqual(r6, r1);
            jy0.b.a(e.a.a(r0), "onAudienceJoinSelfLink needAdjust: " + r6);
            r0.a();
            if (r6 != null) goto L5;
            return;
        L5:
            if ((!Intrinsics.areEqual((Boolean) r0.getContext().getLinkDataSet().z9().getValue(), r1)) == false) goto L9;
            f r7 = i.d0(r0);
            String r2 = i.T(r0).b();
            r7.getClass();
            Intrinsics.checkNotNullParameter(r2, "interactId");
            Intrinsics.checkNotNullParameter("with_audience_change", "tag");
            return;
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1) {
            invoke((Boolean) r1);
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: renamed from: com.bytedance.android.live.revlink.link.biz.doublecomponent.DoubleAudienceLinkComponent$attach$2, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"<anonymous>", "", "p1", "", "invoke", "(Ljava/lang/Boolean;)V"}, k = 3, mv = {1, 5, 1})
    public static final /* synthetic */ class AnonymousClass2 extends FunctionReferenceImpl implements Function1<Boolean, Unit> {
        public AnonymousClass2(DoubleAudienceLinkComponent r8) {
            super(1, r8, DoubleAudienceLinkComponent.class, "onAudienceJoinGuestLink", "onAudienceJoinGuestLink(Ljava/lang/Boolean;)V", 0);
        }

        public final void invoke(Boolean r6) {
            DoubleAudienceLinkComponent r0 = (DoubleAudienceLinkComponent) ((CallableReference) this).receiver;
            r0.getClass();
            Boolean r1 = Boolean.TRUE;
            r0.d = Intrinsics.areEqual(r6, r1);
            jy0.b.a(e.a.a(r0), "onAudienceJoinGuestLink needAdjust: " + r6);
            r0.a();
            if (r6 != null) goto L5;
            return;
        L5:
            if ((!Intrinsics.areEqual((Boolean) r0.getContext().getLinkDataSet().Fc().getValue(), r1)) == false) goto L9;
            f r7 = i.d0(r0);
            String r2 = i.T(r0).b();
            r7.getClass();
            Intrinsics.checkNotNullParameter(r2, "interactId");
            Intrinsics.checkNotNullParameter("with_audience_change", "tag");
            return;
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1) {
            invoke((Boolean) r1);
            return Unit.INSTANCE;
        }
    }

    @Override // com.bytedance.android.live.revlink.link.biz.service.e
    public final String getTAG() {
        return "RevenueLinkAnchorComponent";
    }

    public final void a() {
        if (this.c == false) goto L5;
    L12:
        boolean r1 = this.c;
        boolean r2 = this.d;
        String r3 = getContext().Ab();
        Intrinsics.checkNotNullParameter(this, "$this$doubleGuestUID");
        o51.e r0 = new o51.e.i(r1, r2, r3, i.u(this));
    L13:
        jy0.b.a(e.a.a(this), "requestLayout selfHasAudience: " + this.c + ", guestHasAudience: " + this.d + ", uiLayout: " + r0);
        this.f.f(r0, "DoubleAudienceLinkComponent requestLayout");
        return;
    L5:
        if (this.d == true) goto L12;
        r0 = (o51.e) getContext().getUiLayout().getValue();
        if ((r0 instanceof o51.e.i) == false) goto L10;
        r0 = o51.e.g.e;
        goto L13
    L10:
        if (r0 != null) goto L13;
        r0 = com.bytedance.android.live.revlink.link.core.service.c.a(getContext());
        goto L13
    }

    @Override // com.bytedance.android.live.revlink.link.biz.service.e
    public final void detach() {
        this.b.clear();
    }

    @Override // com.bytedance.android.live.revlink.link.biz.service.e
    public final void attach() {
        com.bytedance.revenue.platform.api.core.rx.f.a(UtilsKt.i(getContext().getLinkDataSet().Fc(), new AnonymousClass1(this)), this.b);
        com.bytedance.revenue.platform.api.core.rx.f.a(UtilsKt.i(getContext().getLinkDataSet().z9(), new AnonymousClass2(this)), this.b);
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
        return this.e;
    }

    public DoubleAudienceLinkComponent(g r2, AnchorUILayoutManager r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "uiLayoutManager");
        this.e = r2;
        this.f = r3;
        this.a = "DoubleAudienceLinkComponent";
        this.b = new CompositeDisposable();
    }
}
