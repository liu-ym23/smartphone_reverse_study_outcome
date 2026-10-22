package com.bytedance.android.live.revlink.link.biz.doublecomponent;

import android.graphics.RectF;
import com.bytedance.android.live.revenue.common.i;
import com.bytedance.android.live.revlink.link.biz.service.e;
import com.bytedance.android.live.revlink.link.utils.UtilsKt;
import com.bytedance.ies.sdk.widgets.NextLiveData;
import f31.f;
import io.reactivex.disposables.CompositeDisposable;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class BreakThroughUIOperationImpl implements com.bytedance.android.live.revlink.impl.pk.breakthrough.a, e {
    public zy0.b a;
    public final String b;
    public final CompositeDisposable c;
    public final String d;
    public final NextLiveData<b03.b> e;
    public final com.bytedance.android.live.revlink.link.infra.lifecontrol.context.d f;

    /* JADX INFO: renamed from: com.bytedance.android.live.revlink.link.biz.doublecomponent.BreakThroughUIOperationImpl$attach$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 5, 1})
    public static final /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function0<Unit> {
        public AnonymousClass1(BreakThroughUIOperationImpl r8) {
            super(0, r8, BreakThroughUIOperationImpl.class, "refreshLayout", "refreshLayout()V", 0);
        }

        /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
        public final void m910invoke() {
            ((BreakThroughUIOperationImpl) ((CallableReference) this).receiver).j();
        }

        public /* bridge */ /* synthetic */ Object invoke() {
            m910invoke();
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: renamed from: com.bytedance.android.live.revlink.link.biz.doublecomponent.BreakThroughUIOperationImpl$attach$2, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\b\u0010\u0001\u001a\u0004\u0018\u00010\u0000¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lb03/b;", "p1", "", "invoke", "(Lb03/b;)V", "<anonymous>"}, k = 3, mv = {1, 5, 1})
    public static final /* synthetic */ class AnonymousClass2 extends FunctionReferenceImpl implements Function1<b03.b, Unit> {
        public AnonymousClass2(BreakThroughUIOperationImpl r8) {
            super(1, r8, BreakThroughUIOperationImpl.class, "onPlatformChange", "onPlatformChange(Lcom/bytedance/android/platform/PlatformConfig;)V", 0);
        }

        public final void invoke(b03.b r2) {
            ((BreakThroughUIOperationImpl) ((CallableReference) this).receiver).e.setValue(r2);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1) {
            invoke((b03.b) r1);
            return Unit.INSTANCE;
        }
    }

    @Override // com.bytedance.android.live.revlink.impl.pk.breakthrough.a
    public final void a(String r2) {
        Intrinsics.checkNotNullParameter(r2, "lynxUrl");
    }

    @Override // com.bytedance.android.live.revlink.impl.pk.breakthrough.a
    public final void d() {
    }

    @Override // com.bytedance.android.live.revlink.impl.pk.breakthrough.a
    public final boolean e() {
        return true;
    }

    @Override // com.bytedance.android.live.revlink.impl.pk.breakthrough.a
    public final void g(String r2) {
        Intrinsics.checkNotNullParameter(r2, "source");
    }

    @Override // com.bytedance.android.live.revlink.link.biz.service.e
    public final String getTAG() {
        return "RevenueLinkBaseComponent";
    }

    @Override // com.bytedance.android.live.revlink.impl.pk.breakthrough.a
    public final void h() {
    }

    @Override // com.bytedance.android.live.revlink.impl.pk.breakthrough.a
    public final void i() {
    }

    @Override // com.bytedance.android.live.revlink.link.biz.service.e
    public final void detach() {
        this.c.clear();
        k();
    }

    public final void j() {
        f r1 = (f) getContext().hh().getValue();
        if (r1 != null) goto L5;
        return;
    L5:
        zy0.b r2 = this.a;
        if (r2 != null) goto L8;
        return;
    L8:
        b03.a r3 = b03.a.a;
        if (b03.a.c() == false) goto L11;
        int r6 = (int) r1.b.width();
        int r7 = i.b(48);
        RectF r4 = r1.b;
        com.bytedance.android.live.revlink.impl.multianchor.dynamic.i r5 = new com.bytedance.android.live.revlink.impl.multianchor.dynamic.i(r6, r7, (int) r4.left, ((int) r4.top) - i.b(8), 0);
    L12:
        getContext().k4().b(r5, r2, this.b);
        return;
    L11:
        r5 = new com.bytedance.android.live.revlink.impl.multianchor.dynamic.i(((int) r1.b.width()) - i.b(156), i.b(48), ((int) r1.b.left) + i.b(78), (((int) r1.b.top) - i.b(16)) + i.b(80), 0);
        goto L12
    }

    @Override // com.bytedance.android.live.revlink.link.biz.service.e
    public final void attach() {
        com.bytedance.revenue.platform.api.core.rx.f.a(UtilsKt.j(getContext().hh(), new AnonymousClass1(this)), this.c);
        com.bytedance.revenue.platform.api.core.rx.f.a(getContext().Pi(new AnonymousClass2(this)), this.c);
    }

    @Override // com.bytedance.android.live.revlink.impl.pk.breakthrough.a
    public final void f() {
        j();
        jy0.b.c("DoubleNativeComponent", "BreakThroughUIOperationImpl notifyLynxLoadSuccess", null, 4);
    }

    @Override // com.bytedance.android.live.revlink.link.biz.service.k
    public final com.bytedance.android.live.revlink.impl.global.c getLinkInstanceService() {
        return getContext();
    }

    public final void k() {
        getContext().k4().d(this.b, this.a);
        this.a = null;
    }

    @Override // com.bytedance.android.live.revlink.impl.pk.breakthrough.a
    public final NextLiveData b() {
        return this.e;
    }

    @Override // com.bytedance.android.live.revlink.link.biz.service.e
    public final String getComponentName() {
        return this.d;
    }

    @Override // com.bytedance.android.live.revlink.link.biz.service.e, com.bytedance.android.live.revlink.link.biz.service.j
    public com.bytedance.android.live.revlink.link.infra.lifecontrol.context.d getContext() {
        return this.f;
    }

    public BreakThroughUIOperationImpl(com.bytedance.android.live.revlink.link.infra.lifecontrol.context.d r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        this.f = r2;
        this.b = "breakthrough";
        this.c = new CompositeDisposable();
        this.d = "DoubleBreakThroughUIOperationImpl";
        this.e = new NextLiveData();
    }

    @Override // com.bytedance.android.live.revlink.impl.pk.breakthrough.a
    public final void c(boolean r3) {
        getContext().k4().a(this.a, !r3);
    }
}
