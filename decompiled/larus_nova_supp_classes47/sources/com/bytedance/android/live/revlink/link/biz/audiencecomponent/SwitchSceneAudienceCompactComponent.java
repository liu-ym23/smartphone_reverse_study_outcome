package com.bytedance.android.live.revlink.link.biz.audiencecomponent;

import com.bytedance.android.live.revlink.impl.control.launchcontext.RevLinkSwitchExtraContext;
import com.bytedance.android.live.revlink.impl.mergepk.pkbase.PkBaseDataContext;
import com.bytedance.android.live.revlink.link.biz.audiencecomponent.switchscenecompact.DoubleSceneAudienceCompactComponent;
import com.bytedance.android.live.revlink.link.biz.audiencecomponent.switchscenecompact.MultiSceneAudienceCompactComponent;
import com.bytedance.android.live.revlink.link.biz.component.BackgroundComponent;
import com.bytedance.android.live.revlink.link.biz.component.MultiPKContextHolder;
import com.bytedance.android.live.revlink.link.biz.doubleaudiencecomponent.DoublePKAudienceDataContextHolder;
import com.bytedance.android.live.revlink.link.biz.service.i;
import com.bytedance.android.live.revlink.link.core.UILayoutServerIndex;
import com.bytedance.android.live.revlink.link.utils.UtilsKt;
import com.bytedance.android.live.revlink.widgetservice.RevLinkAudienceLaunchParam;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.subjects.PublishSubject;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class SwitchSceneAudienceCompactComponent implements com.bytedance.android.live.revlink.link.biz.service.d {
    public final String a;
    public final CompositeDisposable b;
    public com.bytedance.android.live.revlink.link.biz.service.d c;
    public final com.bytedance.android.live.revlink.link.infra.lifecontrol.context.b d;
    public final com.bytedance.android.livesdk.revenue.service.room.c e;
    public final BackgroundComponent f;
    public final PkBaseDataContext g;
    public final c h;
    public final MultiPKContextHolder i;
    public final DoublePKAudienceDataContextHolder j;

    /* JADX INFO: renamed from: com.bytedance.android.live.revlink.link.biz.audiencecomponent.SwitchSceneAudienceCompactComponent$attach$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "p1", "", "invoke"}, k = 3, mv = {1, 5, 1})
    public static final /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function1<Integer, Unit> {
        public AnonymousClass1(SwitchSceneAudienceCompactComponent r8) {
            super(1, r8, SwitchSceneAudienceCompactComponent.class, "onBizEnd", "onBizEnd(I)V", 0);
        }

        public final void invoke(int r6) {
            SwitchSceneAudienceCompactComponent r0 = (SwitchSceneAudienceCompactComponent) ((CallableReference) this).receiver;
            r0.getClass();
            jy0.b.c(com.bytedance.android.live.revlink.link.biz.service.e.a.a(r0), "on Biz end, end scene: " + r6 + ", compact component " + r0.c, null, 4);
            com.bytedance.android.live.revlink.link.biz.service.d r1 = r0.c;
            if (r1 != null) goto L6;
            return;
        L6:
            if (r6 != 1) goto L11;
            if ((r1 instanceof DoubleSceneAudienceCompactComponent) == false) goto L11;
        L13:
            r1.detach();
            r0.c = null;
            return;
        L11:
            if (r6 != 7) goto L13;
            boolean r7 = r1 instanceof MultiSceneAudienceCompactComponent;
            goto L13
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1) {
            invoke(((Number) r1).intValue());
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: renamed from: com.bytedance.android.live.revlink.link.biz.audiencecomponent.SwitchSceneAudienceCompactComponent$attach$2, reason: invalid class name */
    @Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 5, 1})
    public static final /* synthetic */ class AnonymousClass2 extends FunctionReferenceImpl implements Function0<Unit> {
        public AnonymousClass2(SwitchSceneAudienceCompactComponent r8) {
            super(0, r8, SwitchSceneAudienceCompactComponent.class, "onSwitchScene", "onSwitchScene()V", 0);
        }

        /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
        public final void m873invoke() {
            ((SwitchSceneAudienceCompactComponent) ((CallableReference) this).receiver).b();
        }

        public /* bridge */ /* synthetic */ Object invoke() {
            m873invoke();
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: renamed from: com.bytedance.android.live.revlink.link.biz.audiencecomponent.SwitchSceneAudienceCompactComponent$attach$3, reason: invalid class name */
    @Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 5, 1})
    public static final /* synthetic */ class AnonymousClass3 extends FunctionReferenceImpl implements Function0<Unit> {
        public AnonymousClass3(SwitchSceneAudienceCompactComponent r8) {
            super(0, r8, SwitchSceneAudienceCompactComponent.class, "refreshClassicScene", "refreshClassicScene()V", 0);
        }

        /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
        public final void m874invoke() {
            SwitchSceneAudienceCompactComponent.a((SwitchSceneAudienceCompactComponent) ((CallableReference) this).receiver);
        }

        public /* bridge */ /* synthetic */ Object invoke() {
            m874invoke();
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: renamed from: com.bytedance.android.live.revlink.link.biz.audiencecomponent.SwitchSceneAudienceCompactComponent$attach$4, reason: invalid class name */
    @Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 5, 1})
    public static final /* synthetic */ class AnonymousClass4 extends FunctionReferenceImpl implements Function0<Unit> {
        public AnonymousClass4(SwitchSceneAudienceCompactComponent r8) {
            super(0, r8, SwitchSceneAudienceCompactComponent.class, "refreshClassicScene", "refreshClassicScene()V", 0);
        }

        /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
        public final void m875invoke() {
            SwitchSceneAudienceCompactComponent.a((SwitchSceneAudienceCompactComponent) ((CallableReference) this).receiver);
        }

        public /* bridge */ /* synthetic */ Object invoke() {
            m875invoke();
            return Unit.INSTANCE;
        }
    }

    @Override // com.bytedance.android.live.revlink.link.biz.service.e
    public final String getTAG() {
        return "RevenueLinkAudienceComponent";
    }

    @Override // com.bytedance.android.live.revlink.link.biz.service.e
    public final void detach() {
        com.bytedance.android.live.revlink.link.biz.service.d r0 = this.c;
        if (r0 == null) goto L5;
        r0.detach();
    L5:
        this.c = null;
        this.b.clear();
    }

    @Override // com.bytedance.android.live.revlink.link.biz.service.e
    public final void attach() {
        PublishSubject<Integer> r0 = getContext().a9();
        final AnonymousClass1 r1 = new AnonymousClass1(this);
        com.bytedance.revenue.platform.api.core.rx.f.a(r0.subscribe(new a(r1)), this.b);
        com.bytedance.revenue.platform.api.core.rx.f.a(UtilsKt.g(getContext().t(), new AnonymousClass2(this)), this.b);
        com.bytedance.revenue.platform.api.core.rx.f.a(UtilsKt.h(getContext().getUiLayout(), new AnonymousClass3(this)), this.b);
        com.bytedance.revenue.platform.api.core.rx.f.a(i.t(this).R(new AnonymousClass4(this)), this.b);
        b();
    }

    public final void b() {
        jy0.b.c(com.bytedance.android.live.revlink.link.biz.service.e.a.a(this), "onSwitchScene scene: " + getContext().getScene() + ", current compact component " + this.c, null, 4);
        com.bytedance.android.live.revlink.link.biz.service.d r0 = this.c;
        if (r0 == null) goto L5;
        r0.detach();
    L5:
        this.c = null;
        int r1 = getContext().getScene();
        if (r1 != 1) goto L8;
        com.bytedance.android.live.revlink.link.biz.service.d r2 = new DoubleSceneAudienceCompactComponent(getContext(), this.e, this.f, this.g, this.h, this.j);
    L12:
        this.c = r2;
        jy0.b.c(com.bytedance.android.live.revlink.link.biz.service.e.a.a(this), "onSwitchScene scene: " + getContext().getScene() + ", attach component " + this.c, null, 4);
        com.bytedance.android.live.revlink.link.biz.service.d r3 = this.c;
        if (r3 == null) goto L16;
        r3.attach();
        return;
    L16:
        return;
    L8:
        if (r1 == 7) goto L10;
        r2 = null;
        goto L12
    L10:
        r2 = new MultiSceneAudienceCompactComponent(getContext(), this.e, this.g, this.i);
        goto L12
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
    public com.bytedance.android.live.revlink.link.infra.lifecontrol.context.b getContext() {
        return this.d;
    }

    public static final void a(SwitchSceneAudienceCompactComponent r13) {
        o51.e r0 = (o51.e) r13.getContext().getUiLayout().getValue();
        if (r0 == null) goto L32;
        int r1 = ((CopyOnWriteArrayList) i.t(r13).a).size();
        if (r1 != 0) goto L9;
        return;
    L9:
        if (r0.a.b == UILayoutServerIndex.Normal.ordinal()) goto L11;
    L13:
        boolean r2 = false;
    L14:
        jy0.b.c(com.bytedance.android.live.revlink.link.biz.service.e.a.a(r13), "onUILayoutChange scene: " + r13.getContext().getScene() + ", uiLayout: " + r0 + ", uiLayoutIndex: " + r0.a + "  indexOrdinal:" + r0.a.b + " isClassicDouble:" + r2 + ' ', null, 4);
        if (r13.getContext().getScene() == 1) goto L21;
        if (r2 == false) goto L21;
        jy0.b.c(com.bytedance.android.live.revlink.link.biz.service.e.a.a(r13), "onUILayoutChange call switch double", null, 4);
        com.bytedance.android.live.revlink.impl.service.internal.a r3 = i.p(r13);
        if (r3 == null) goto L27;
        int r4 = RevLinkAudienceLaunchParam.i;
        r3.Gp(4, new RevLinkSwitchExtraContext(null, null, null, null, RevLinkAudienceLaunchParam.Companion.a(1, r13.getContext().G()), 31));
        return;
    L27:
        return;
    L21:
        if (r13.getContext().getScene() == 7) goto L29;
        if (r2 == true) goto L30;
        jy0.b.c(com.bytedance.android.live.revlink.link.biz.service.e.a.a(r13), "onUILayoutChange call switch multi", null, 4);
        com.bytedance.android.live.revlink.impl.service.internal.a r5 = i.p(r13);
        if (r5 == null) goto L31;
        int r6 = RevLinkAudienceLaunchParam.i;
        r5.Gp(64, new RevLinkSwitchExtraContext(null, null, null, null, RevLinkAudienceLaunchParam.Companion.a(7, r13.getContext().G()), 31));
        return;
    L31:
        return;
    L30:
        return;
    L29:
        return;
    L11:
        if (r1 > 2) goto L13;
        r2 = true;
        goto L14
    }

    public SwitchSceneAudienceCompactComponent(com.bytedance.android.live.revlink.link.infra.lifecontrol.context.b r2, com.bytedance.android.livesdk.revenue.service.room.c r3, BackgroundComponent r4, PkBaseDataContext r5, c r6, MultiPKContextHolder r7, DoublePKAudienceDataContextHolder r8) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "roomService");
        Intrinsics.checkNotNullParameter(r4, "backgroundComponent");
        Intrinsics.checkNotNullParameter(r5, "pkBaseDataContext");
        Intrinsics.checkNotNullParameter(r6, "bizDataContext");
        Intrinsics.checkNotNullParameter(r7, "multiPKContextHolder");
        Intrinsics.checkNotNullParameter(r8, "pkAudienceDataContextHolder");
        this.d = r2;
        this.e = r3;
        this.f = r4;
        this.g = r5;
        this.h = r6;
        this.i = r7;
        this.j = r8;
        this.a = "SwitchSceneCompactComponent";
        this.b = new CompositeDisposable();
    }
}
