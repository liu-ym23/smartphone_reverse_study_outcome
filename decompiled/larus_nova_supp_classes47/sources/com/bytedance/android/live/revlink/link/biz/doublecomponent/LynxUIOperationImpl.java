package com.bytedance.android.live.revlink.link.biz.doublecomponent;

import android.graphics.RectF;
import androidx.lifecycle.LiveData;
import com.bytedance.android.live.revlink.impl.mergepk.pkbase.statemachine.PkBaseStateMachine;
import com.bytedance.android.live.revlink.impl.monitor.LiveFullLinkPKMonitor;
import com.bytedance.android.live.revlink.link.biz.service.e;
import com.bytedance.android.live.revlink.link.biz.service.i;
import com.bytedance.android.live.revlink.link.utils.UtilsKt;
import com.bytedance.android.livesdk.padutils.PadConfigUtils;
import com.bytedance.ies.sdk.widgets.NextLiveData;
import com.bytedance.revenue.platform.api.core.rx.f;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class LynxUIOperationImpl implements com.bytedance.android.live.revlink.impl.pk.scopeservice.b, e {
    public final String a;
    public final NextLiveData<b03.b> b;
    public zy0.b c;
    public final String d;
    public boolean e;
    public final CompositeDisposable f;
    public boolean g;
    public final com.bytedance.android.live.revlink.link.infra.lifecontrol.context.d h;

    /* JADX INFO: renamed from: com.bytedance.android.live.revlink.link.biz.doublecomponent.LynxUIOperationImpl$attach$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 5, 1})
    public static final /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function0<Unit> {
        public AnonymousClass1(LynxUIOperationImpl r8) {
            super(0, r8, LynxUIOperationImpl.class, "onLayoutChange", "onLayoutChange()V", 0);
        }

        /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
        public final void m913invoke() {
            ((LynxUIOperationImpl) ((CallableReference) this).receiver).i();
        }

        public /* bridge */ /* synthetic */ Object invoke() {
            m913invoke();
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: renamed from: com.bytedance.android.live.revlink.link.biz.doublecomponent.LynxUIOperationImpl$attach$2, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\b\u0010\u0001\u001a\u0004\u0018\u00010\u0000¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lb03/b;", "p1", "", "invoke", "(Lb03/b;)V", "<anonymous>"}, k = 3, mv = {1, 5, 1})
    public static final /* synthetic */ class AnonymousClass2 extends FunctionReferenceImpl implements Function1<b03.b, Unit> {
        public AnonymousClass2(LynxUIOperationImpl r8) {
            super(1, r8, LynxUIOperationImpl.class, "onPlatformChange", "onPlatformChange(Lcom/bytedance/android/platform/PlatformConfig;)V", 0);
        }

        public final void invoke(b03.b r2) {
            ((LynxUIOperationImpl) ((CallableReference) this).receiver).b.setValue(r2);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1) {
            invoke((b03.b) r1);
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: renamed from: com.bytedance.android.live.revlink.link.biz.doublecomponent.LynxUIOperationImpl$attach$3, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\b\u0010\u0001\u001a\u0004\u0018\u00010\u0000¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/bytedance/android/live/revlink/impl/mergepk/pkbase/statemachine/PkBaseStateMachine$c;", "p1", "", "invoke", "(Lcom/bytedance/android/live/revlink/impl/mergepk/pkbase/statemachine/PkBaseStateMachine$c;)V", "<anonymous>"}, k = 3, mv = {1, 5, 1})
    public static final /* synthetic */ class AnonymousClass3 extends FunctionReferenceImpl implements Function1<PkBaseStateMachine.c, Unit> {
        public AnonymousClass3(LynxUIOperationImpl r8) {
            super(1, r8, LynxUIOperationImpl.class, "onPkStateChange", "onPkStateChange(Lcom/bytedance/android/live/revlink/impl/mergepk/pkbase/statemachine/PkBaseStateMachine$State;)V", 0);
        }

        public final void invoke(PkBaseStateMachine.c r3) {
            LynxUIOperationImpl r4 = (LynxUIOperationImpl) ((CallableReference) this).receiver;
            r4.getClass();
            com.bytedance.android.live.revlink.impl.mergepk.pkbase.e r0 = i.S(r4);
            if (r0 == null) goto L7;
            boolean r1 = true;
            if (r0.isInVote() != true) goto L7;
        L9:
            if (r4.g == r1) goto L13;
            r4.g = r1;
            r4.i();
            return;
        L13:
            return;
        L7:
            r1 = false;
            goto L9
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1) {
            invoke((PkBaseStateMachine.c) r1);
            return Unit.INSTANCE;
        }
    }

    @Override // com.bytedance.android.live.revlink.impl.pk.scopeservice.b
    public final void a(String r2) {
        Intrinsics.checkNotNullParameter(r2, "lynxUrl");
    }

    @Override // com.bytedance.android.live.revlink.impl.pk.scopeservice.b
    public final void d() {
    }

    @Override // com.bytedance.android.live.revlink.link.biz.service.e
    public final void detach() {
        this.e = false;
        this.f.clear();
        removeAll();
    }

    @Override // com.bytedance.android.live.revlink.link.biz.service.e
    public final String getTAG() {
        return "RevenueLinkBaseComponent";
    }

    @Override // com.bytedance.android.live.revlink.impl.pk.scopeservice.b
    public final boolean e() {
        return !this.e;
    }

    @Override // com.bytedance.android.live.revlink.impl.pk.scopeservice.b
    public final void f() {
        d51.a r0 = d51.a.g;
        r0.getClass();
        String r3 = (String) d51.a.b.getValue(r0, d51.a.a[0]);
        LiveFullLinkPKMonitor.o(i.s(this), "link_pk_hybrid_lynx_load_failed", r3, "context is null", 0, 0, 24);
    }

    @Override // com.bytedance.android.live.revlink.impl.pk.scopeservice.b
    public final void h() {
        jy0.b.c("DoubleNativeComponent", "setHasFixSize", null, 4);
    }

    @Override // com.bytedance.android.live.revlink.impl.pk.scopeservice.b
    public final void removeAll() {
        jy0.b.c("DoubleNativeComponent", "removeAll", null, 4);
        getContext().k4().d(this.d, this.c);
        this.c = null;
    }

    @Override // com.bytedance.android.live.revlink.link.biz.service.e
    public final void attach() {
        f.a(UtilsKt.h(getContext().hh(), new AnonymousClass1(this)), this.f);
        f.a(getContext().Pi(new AnonymousClass2(this)), this.f);
        com.bytedance.android.live.revlink.impl.mergepk.pkbase.e r0 = i.S(this);
        if (r0 == null) goto L9;
        LiveData<PkBaseStateMachine.c> r1 = r0.getPkBaseState();
        if (r1 == null) goto L9;
        Disposable r2 = UtilsKt.d(r1, new AnonymousClass3(this));
        if (r2 == null) goto L9;
        f.a(r2, this.f);
    L9:
        this.e = true;
    }

    @Override // com.bytedance.android.live.revlink.impl.pk.scopeservice.b
    public final void c() {
        i();
        jy0.b.c("DoubleNativeComponent", "notifyLynxLoadSuccess", null, 4);
    }

    @Override // com.bytedance.android.live.revlink.link.biz.service.k
    public final com.bytedance.android.live.revlink.impl.global.c getLinkInstanceService() {
        return getContext();
    }

    public final void i() {
        f31.f r0 = (f31.f) getContext().hh().getValue();
        if (r0 != null) goto L5;
        return;
    L5:
        zy0.b r1 = this.c;
        if (r1 != null) goto L8;
        return;
    L8:
        com.bytedance.android.live.revlink.impl.mergepk.pkbase.e r2 = i.S(this);
        if (r2 == null) goto L13;
        boolean r4 = true;
        if (r2.isInVote() != true) goto L13;
    L14:
        if (r4 == false) goto L16;
        int r3 = 0 - com.bytedance.android.live.revenue.common.i.b(48);
    L17:
        if (r4 == false) goto L19;
        int r9 = -1;
    L20:
        b03.a r5 = b03.a.a;
        boolean r6 = b03.a.c();
        if (r6 == false) goto L23;
        int r7 = 36;
    L24:
        int r8 = com.bytedance.android.live.revenue.common.i.b(r7);
        if (r6 == false) goto L27;
        int r10 = 4;
    L28:
        int r12 = com.bytedance.android.live.revenue.common.i.b(r10);
        if (PadConfigUtils.a() == true) goto L31;
        int r13 = (int) r0.b.width();
        int r14 = com.bytedance.android.live.revenue.common.i.b(45);
        RectF r15 = r0.b;
        com.bytedance.android.live.revlink.impl.multianchor.dynamic.i r16 = new com.bytedance.android.live.revlink.impl.multianchor.dynamic.i(r13, r14, (int) r15.left, ((int) r15.bottom) + r3, r9);
    L32:
        getContext().k4().b(r16, r1, this.d);
        return;
    L31:
        int r17 = ((int) r0.b.width()) - (r12 * 2);
        int r18 = com.bytedance.android.live.revenue.common.i.b(45);
        RectF r19 = r0.b;
        r16 = new com.bytedance.android.live.revlink.impl.multianchor.dynamic.i(r17, r18, ((int) r19.left) + r12, ((int) r19.top) + r8, r9);
        goto L32
    L27:
        r10 = 78;
        goto L28
    L23:
        r7 = 150;
        goto L24
    L19:
        r9 = 0;
        goto L20
    L16:
        r3 = 0;
    L13:
        r4 = false;
        goto L14
    }

    @Override // com.bytedance.android.live.revlink.impl.pk.scopeservice.b
    public final NextLiveData b() {
        return this.b;
    }

    @Override // com.bytedance.android.live.revlink.link.biz.service.e
    public final String getComponentName() {
        return this.a;
    }

    @Override // com.bytedance.android.live.revlink.link.biz.service.e, com.bytedance.android.live.revlink.link.biz.service.j
    public com.bytedance.android.live.revlink.link.infra.lifecontrol.context.d getContext() {
        return this.h;
    }

    public LynxUIOperationImpl(com.bytedance.android.live.revlink.link.infra.lifecontrol.context.d r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        this.h = r2;
        this.a = "LynxUIOperationImpl";
        this.b = new NextLiveData();
        this.d = "pkLynxInfo";
        this.f = new CompositeDisposable();
    }

    @Override // com.bytedance.android.live.revlink.impl.pk.scopeservice.b
    public final void g(boolean r5) {
        jy0.b.c("DoubleNativeComponent", "updateVisibility: " + r5, null, 4);
        getContext().k4().a(this.c, r5);
    }
}
