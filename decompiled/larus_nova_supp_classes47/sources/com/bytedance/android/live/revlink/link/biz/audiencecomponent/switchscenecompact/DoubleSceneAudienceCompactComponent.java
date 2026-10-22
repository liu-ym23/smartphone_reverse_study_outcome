package com.bytedance.android.live.revlink.link.biz.audiencecomponent.switchscenecompact;

import com.bytedance.android.live.revlink.impl.mergepk.pkbase.PkBaseDataContext;
import com.bytedance.android.live.revlink.impl.mergepk.pkdouble.PkDoubleAudienceDataContext;
import com.bytedance.android.live.revlink.impl.mergepk.pkdouble.PkDoubleDataContext;
import com.bytedance.android.live.revlink.link.biz.component.BackgroundComponent;
import com.bytedance.android.live.revlink.link.biz.doubleaudiencecomponent.DoubleAudienceOtherComponent;
import com.bytedance.android.live.revlink.link.biz.doubleaudiencecomponent.DoubleAudiencePKComponent;
import com.bytedance.android.live.revlink.link.biz.doubleaudiencecomponent.DoublePKAudienceDataContextHolder;
import com.bytedance.android.live.revlink.link.biz.doublecomponent.DoubleNativeComponent;
import com.bytedance.android.live.revlink.link.biz.doublecomponent.DoublePKComponent;
import com.bytedance.android.live.revlink.link.biz.service.d;
import com.bytedance.android.live.revlink.link.infra.lifecontrol.context.b;
import com.bytedance.android.livesdk.revenue.service.room.c;
import com.bytedance.live.datacontext.DataContext;
import com.bytedance.revenue.platform.api.core.rx.f;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class DoubleSceneAudienceCompactComponent implements d {
    public final String a;
    public final DoubleNativeComponent b;
    public final DoubleAudienceOtherComponent c;
    public final DoubleAudiencePKComponent d;
    public final DoublePKComponent e;
    public final CompositeDisposable f;
    public final b g;
    public final c h;
    public final DoublePKAudienceDataContextHolder i;

    @Override // com.bytedance.android.live.revlink.link.biz.service.e
    public final String getTAG() {
        return "RevenueLinkAudienceComponent";
    }

    @Override // com.bytedance.android.live.revlink.link.biz.service.e
    public final void attach() {
        final PkDoubleAudienceDataContext r0 = this.i.c;
        Pair r1 = com.bytedance.live.datacontext.d.a(new AnonymousClass1(r0));
        getContext().T6("IPkAudienceDataService", (DataContext) r1.getFirst());
        f.a((Disposable) r1.getSecond(), this.f);
        final PkDoubleDataContext r2 = r0.getDoublePkContext();
        Pair r3 = com.bytedance.live.datacontext.d.a(new AnonymousClass3(r2));
        getContext().T6(PkDoubleDataContext.TAG, (DataContext) r3.getFirst());
        f.a((Disposable) r3.getSecond(), this.f);
        this.b.attach();
        this.c.attach();
        this.d.attach();
        this.e.attach();
    }

    @Override // com.bytedance.android.live.revlink.link.biz.service.e
    public final void detach() {
        this.d.detach();
        this.c.detach();
        this.b.detach();
        this.e.detach();
        this.f.clear();
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
        return this.g;
    }

    public DoubleSceneAudienceCompactComponent(b r2, c r3, BackgroundComponent r4, PkBaseDataContext r5, com.bytedance.android.live.revlink.link.biz.audiencecomponent.c r6, DoublePKAudienceDataContextHolder r7) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "roomService");
        Intrinsics.checkNotNullParameter(r4, "backgroundComponent");
        Intrinsics.checkNotNullParameter(r5, "pkBaseDataContext");
        Intrinsics.checkNotNullParameter(r6, "bizDataContext");
        Intrinsics.checkNotNullParameter(r7, "pkAudienceDataContextHolder");
        this.g = r2;
        this.h = r3;
        this.i = r7;
        this.a = "DoubleSceneAudienceCompactComponent";
        this.b = new DoubleNativeComponent(getContext(), r3, r4, r5);
        this.c = new DoubleAudienceOtherComponent(getContext(), r6);
        this.d = new DoubleAudiencePKComponent(getContext(), r3, r6);
        this.e = new DoublePKComponent(getContext(), r5);
        this.f = new CompositeDisposable();
    }
}
