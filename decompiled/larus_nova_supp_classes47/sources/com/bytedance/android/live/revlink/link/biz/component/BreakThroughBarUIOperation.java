package com.bytedance.android.live.revlink.link.biz.component;

import android.graphics.RectF;
import com.bytedance.android.live.revlink.impl.monitor.LiveFullLinkPKMonitor;
import com.bytedance.android.live.revlink.link.utils.UtilsKt;
import io.reactivex.disposables.CompositeDisposable;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class BreakThroughBarUIOperation implements com.bytedance.android.live.revlink.link.biz.service.e, f {
    public final String a;
    public zy0.b b;
    public final String c;
    public boolean d;
    public final CompositeDisposable e;
    public final com.bytedance.android.live.revlink.link.infra.lifecontrol.context.d f;

    /* JADX INFO: renamed from: com.bytedance.android.live.revlink.link.biz.component.BreakThroughBarUIOperation$attach$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 5, 1})
    public static final /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function0<Unit> {
        public AnonymousClass1(BreakThroughBarUIOperation r8) {
            super(0, r8, BreakThroughBarUIOperation.class, "refreshLayout", "refreshLayout()V", 0);
        }

        /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
        public final void m883invoke() {
            ((BreakThroughBarUIOperation) ((CallableReference) this).receiver).g();
        }

        public /* bridge */ /* synthetic */ Object invoke() {
            m883invoke();
            return Unit.INSTANCE;
        }
    }

    @Override // com.bytedance.android.live.revlink.link.biz.component.f
    public final void a(String r2) {
        Intrinsics.checkNotNullParameter(r2, "lynxUrl");
    }

    @Override // com.bytedance.android.live.revlink.link.biz.service.e
    public final void attach() {
        this.d = true;
        com.bytedance.revenue.platform.api.core.rx.f.a(UtilsKt.h(getContext().hh(), new AnonymousClass1(this)), this.e);
    }

    @Override // com.bytedance.android.live.revlink.link.biz.component.f
    public final void d() {
    }

    @Override // com.bytedance.android.live.revlink.link.biz.service.e
    public final void detach() {
        this.d = false;
        h();
        this.e.clear();
    }

    @Override // com.bytedance.android.live.revlink.link.biz.service.e
    public final String getTAG() {
        return "RevenueLinkBaseComponent";
    }

    @Override // com.bytedance.android.live.revlink.link.biz.component.f
    public final void e() {
        if (this.d == true) goto L6;
        jy0.b.c(com.bytedance.android.live.revlink.link.biz.service.e.a.a(this), "BreakThroughUIOperationImpl notifyLynxLoadSuccess return for not in life", null, 4);
        return;
    L6:
        g();
        jy0.b.c(com.bytedance.android.live.revlink.link.biz.service.e.a.a(this), "BreakThroughUIOperationImpl notifyLynxLoadSuccess", null, 4);
    }

    @Override // com.bytedance.android.live.revlink.link.biz.component.f
    public final void b() {
        getContext().k4().d(this.c, this.b);
    }

    public final void g() {
        jy0.b.c(com.bytedance.android.live.revlink.link.biz.service.e.a.a(this), "BreakThroughUIOperationImpl refreshLayout with layoutStatus: " + ((f31.f) getContext().hh().getValue()) + ", hybridCard: " + this.b + ", inLife: " + this.d, null, 4);
        if (this.d == true) goto L5;
        return;
    L5:
        f31.f r0 = (f31.f) getContext().hh().getValue();
        if (r0 != null) goto L8;
        return;
    L8:
        zy0.b r1 = this.b;
        if (r1 != null) goto L11;
        return;
    L11:
        x51.a r2 = getContext().k4();
        int r4 = (int) r0.b.width();
        int r5 = com.bytedance.android.live.revenue.common.i.b(48);
        RectF r3 = r0.b;
        r2.b(new com.bytedance.android.live.revlink.impl.multianchor.dynamic.i(r4, r5, (int) r3.left, ((int) r3.top) - com.bytedance.android.live.revenue.common.i.b(16), 0), r1, this.c);
    }

    @Override // com.bytedance.android.live.revlink.link.biz.service.k
    public final com.bytedance.android.live.revlink.impl.global.c getLinkInstanceService() {
        return getContext();
    }

    public final void h() {
        jy0.b.c(com.bytedance.android.live.revlink.link.biz.service.e.a.a(this), "BreakThroughUIOperationImpl call remove all lynxTag: " + this.c + ", hybridCard: " + this.b, null, 4);
        getContext().k4().d(this.c, this.b);
        this.b = null;
    }

    @Override // com.bytedance.android.live.revlink.link.biz.service.e
    public final String getComponentName() {
        return this.a;
    }

    @Override // com.bytedance.android.live.revlink.link.biz.service.e, com.bytedance.android.live.revlink.link.biz.service.j
    public com.bytedance.android.live.revlink.link.infra.lifecontrol.context.d getContext() {
        return this.f;
    }

    public BreakThroughBarUIOperation(com.bytedance.android.live.revlink.link.infra.lifecontrol.context.d r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        this.f = r2;
        this.a = "MultiBreakThroughBarUIOperation";
        this.c = "multi_breakthrough";
        this.e = new CompositeDisposable();
    }

    @Override // com.bytedance.android.live.revlink.link.biz.component.f
    public final void c(boolean r3) {
        getContext().k4().a(this.b, !r3);
    }

    @Override // com.bytedance.android.live.revlink.link.biz.component.f
    public final void f(String r10, String r12) {
        Intrinsics.checkNotNullParameter(r10, "lynxUrl");
        Intrinsics.checkNotNullParameter(r12, "source");
        if (this.d == false) goto L5;
        return;
    L5:
        com.bytedance.android.live.revlink.link.biz.service.i.R(this).b(com.bytedance.android.live.revlink.link.biz.service.e.a.a(this));
        LiveFullLinkPKMonitor.o(com.bytedance.android.live.revlink.link.biz.service.i.s(this), "link_break_through_top_bar_load_failed", r10, "context is null source".concat(r12), 7, 0, 16);
    }
}
