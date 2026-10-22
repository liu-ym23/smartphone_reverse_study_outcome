package com.bytedance.android.live.revlink.link.biz.audiencecomponent.switchscenecompact;

import com.bytedance.android.live.revlink.impl.mergepk.pkbase.PkBaseDataContext;
import com.bytedance.android.live.revlink.impl.mergepk.pkmulti.PkMultiDataContext;
import com.bytedance.android.live.revlink.link.biz.component.MultiNativeComponent;
import com.bytedance.android.live.revlink.link.biz.component.MultiPKContextHolder;
import com.bytedance.android.live.revlink.link.biz.service.MultiPKComponent;
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
public final class MultiSceneAudienceCompactComponent implements d {
    public final String a;
    public final MultiNativeComponent b;
    public final MultiPKComponent c;
    public final CompositeDisposable d;
    public final b e;
    public final c f;
    public final MultiPKContextHolder g;

    @Override // com.bytedance.android.live.revlink.link.biz.service.e
    public final String getTAG() {
        return "RevenueLinkAudienceComponent";
    }

    @Override // com.bytedance.android.live.revlink.link.biz.service.e
    public final void attach() {
        final PkMultiDataContext r0 = this.g.c;
        Pair r1 = com.bytedance.live.datacontext.d.a(new AnonymousClass1(r0));
        getContext().T6(PkMultiDataContext.TAG, (DataContext) r1.getFirst());
        f.a((Disposable) r1.getSecond(), this.d);
        this.b.attach();
        this.c.attach();
    }

    @Override // com.bytedance.android.live.revlink.link.biz.service.e
    public final void detach() {
        this.c.detach();
        this.b.detach();
        this.d.clear();
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
        return this.e;
    }

    public MultiSceneAudienceCompactComponent(b r2, c r3, PkBaseDataContext r4, MultiPKContextHolder r5) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "roomService");
        Intrinsics.checkNotNullParameter(r4, "pkBaseDataContext");
        Intrinsics.checkNotNullParameter(r5, "pkContextHolder");
        this.e = r2;
        this.f = r3;
        this.g = r5;
        this.a = "MultiSceneAudienceCompactComponent";
        MultiNativeComponent r6 = new MultiNativeComponent(getContext(), r4, r3);
        this.b = r6;
        this.c = new MultiPKComponent(getContext(), r3, r6);
        this.d = new CompositeDisposable();
    }
}
