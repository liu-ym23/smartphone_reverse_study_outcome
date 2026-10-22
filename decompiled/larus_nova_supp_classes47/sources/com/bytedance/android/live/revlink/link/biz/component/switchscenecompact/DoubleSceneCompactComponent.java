package com.bytedance.android.live.revlink.link.biz.component.switchscenecompact;

import com.bytedance.android.live.revenuelink.rtc.i;
import com.bytedance.android.live.revlink.impl.mergepk.pkbase.PkBaseDataContext;
import com.bytedance.android.live.revlink.impl.mergepk.pkdouble.PkDoubleAnchorDataContext;
import com.bytedance.android.live.revlink.impl.mergepk.pkdouble.PkDoubleDataContext;
import com.bytedance.android.live.revlink.link.biz.component.BackgroundComponent;
import com.bytedance.android.live.revlink.link.biz.component.g;
import com.bytedance.android.live.revlink.link.biz.component.h;
import com.bytedance.android.live.revlink.link.biz.doublecomponent.DoubleNativeComponent;
import com.bytedance.android.live.revlink.link.biz.doublecomponent.DoubleOtherComponent;
import com.bytedance.android.live.revlink.link.biz.doublecomponent.DoublePKComponent;
import com.bytedance.android.live.revlink.link.biz.doublecomponent.b;
import com.bytedance.android.live.revlink.link.biz.service.c;
import com.bytedance.android.live.revlink.link.infra.lifecontrol.context.a;
import com.bytedance.live.datacontext.DataContext;
import com.bytedance.live.datacontext.d;
import com.bytedance.revenue.platform.api.core.rx.f;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class DoubleSceneCompactComponent implements c {
    public final String a;
    public final DoubleNativeComponent b;
    public final DoubleOtherComponent c;
    public final b d;
    public final DoublePKComponent e;
    public final CompositeDisposable f;
    public final a g;
    public final com.bytedance.android.live.revlink.link.biz.doublecomponent.c h;

    @Override // com.bytedance.android.live.revlink.link.biz.service.e
    public final String getTAG() {
        return "RevenueLinkAnchorComponent";
    }

    @Override // com.bytedance.android.live.revlink.link.biz.service.e
    public final void attach() {
        final PkDoubleAnchorDataContext r0 = this.h.c;
        Pair r1 = d.a(new AnonymousClass1(r0));
        getContext().T6(PkDoubleAnchorDataContext.TAG, (DataContext) r1.getFirst());
        f.a((Disposable) r1.getSecond(), this.f);
        final PkDoubleDataContext r2 = r0.getDoublePkContext();
        Pair r3 = d.a(new AnonymousClass3(r2));
        getContext().T6(PkDoubleDataContext.TAG, (DataContext) r3.getFirst());
        f.a((Disposable) r3.getSecond(), this.f);
        this.b.attach();
        this.c.attach();
        this.d.getClass();
        this.e.attach();
    }

    @Override // com.bytedance.android.live.revlink.link.biz.service.e
    public final void detach() {
        this.d.detach();
        this.b.detach();
        this.c.detach();
        this.e.detach();
        this.f.clear();
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
    public a getContext() {
        return this.g;
    }

    public DoubleSceneCompactComponent(a r12, com.bytedance.android.livesdk.revenue.service.room.c r13, BackgroundComponent r14, PkBaseDataContext r15, com.bytedance.android.live.revlink.link.streaminteract.biz.c r16, final h r17, i r18, g r19, com.bytedance.android.live.revlink.link.biz.doublecomponent.c r20) {
        Intrinsics.checkNotNullParameter(r12, "context");
        Intrinsics.checkNotNullParameter(r13, "roomService");
        Intrinsics.checkNotNullParameter(r14, "backgroundComponent");
        Intrinsics.checkNotNullParameter(r15, "pkBaseDataContext");
        Intrinsics.checkNotNullParameter(r16, "streamMixManagerService");
        Intrinsics.checkNotNullParameter(r17, "bizDataContext");
        Intrinsics.checkNotNullParameter(r18, "rtcManager");
        Intrinsics.checkNotNullParameter(r19, "chorusComponent");
        Intrinsics.checkNotNullParameter(r20, "doublePKAnchorDataContextHolder");
        this.g = r12;
        this.h = r20;
        this.a = "DoubleCompactComponent";
        this.b = new DoubleNativeComponent(getContext(), r13, r14, r15);
        this.c = new DoubleOtherComponent(getContext(), r16, r17, r18);
        this.d = new b(getContext(), r13, new DoubleSceneCompactComponent$doubleEventTrackComponent$1(r19), r17, new DoubleSceneCompactComponent$doubleEventTrackComponent$2(r17), new DoubleSceneCompactComponent$doubleEventTrackComponent$3(r17));
        this.e = new DoublePKComponent(getContext(), r15);
        this.f = new CompositeDisposable();
    }
}
