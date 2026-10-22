package com.bytedance.android.live.revlink.link.biz.component.switchscenecompact;

import com.bytedance.android.live.revlink.impl.mergepk.pkbase.PkBaseDataContext;
import com.bytedance.android.live.revlink.impl.mergepk.pkmulti.PkMultiDataContext;
import com.bytedance.android.live.revlink.impl.multianchor.vm.MultiAnchorLinkContext;
import com.bytedance.android.live.revlink.impl.pk.scope.service.MultiPkScopeProviderService;
import com.bytedance.android.live.revlink.link.biz.component.MultiNativeComponent;
import com.bytedance.android.live.revlink.link.biz.component.MultiOtherComponent;
import com.bytedance.android.live.revlink.link.biz.component.MultiPKContextHolder;
import com.bytedance.android.live.revlink.link.biz.component.MultiRTCBizComponent;
import com.bytedance.android.live.revlink.link.biz.component.g;
import com.bytedance.android.live.revlink.link.biz.component.h;
import com.bytedance.android.live.revlink.link.biz.service.MultiPKComponent;
import com.bytedance.android.live.revlink.link.biz.service.c;
import com.bytedance.android.live.revlink.link.biz.service.e;
import com.bytedance.android.live.revlink.link.domain.service.RevLinkDomainAnchorService;
import com.bytedance.android.live.revlink.link.infra.lifecontrol.context.a;
import com.bytedance.live.datacontext.DataContext;
import com.bytedance.live.datacontext.d;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import jy0.b;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import yz0.f;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class MultiSceneCompactComponent implements c {
    public final String a;
    public final MultiNativeComponent b;
    public final MultiPKComponent c;
    public final MultiOtherComponent d;
    public final CompositeDisposable e;
    public final a f;
    public final com.bytedance.android.livesdk.revenue.service.room.c g;
    public final MultiPKContextHolder h;
    public final f i;

    @Override // com.bytedance.android.live.revlink.link.biz.service.e
    public final String getTAG() {
        return "RevenueLinkAnchorComponent";
    }

    @Override // com.bytedance.android.live.revlink.link.biz.service.e
    public final void detach() {
        this.d.detach();
        this.c.detach();
        this.b.detach();
        this.e.clear();
        b.c(e.a.a(this), "detach", null, 4);
    }

    @Override // com.bytedance.android.live.revlink.link.biz.service.e
    public final void attach() {
        b.c(e.a.a(this), "attach", null, 4);
        final PkMultiDataContext r0 = this.h.c;
        Pair r1 = d.a(new AnonymousClass1(r0));
        getContext().T6(PkMultiDataContext.TAG, (DataContext) r1.getFirst());
        com.bytedance.revenue.platform.api.core.rx.f.a((Disposable) r1.getSecond(), this.e);
        this.b.attach();
        this.c.attach();
        this.d.attach();
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
        return this.f;
    }

    public MultiSceneCompactComponent(a r17, com.bytedance.android.livesdk.revenue.service.room.c r18, PkBaseDataContext r19, MultiPKContextHolder r20, MultiRTCBizComponent r22, f r23, RevLinkDomainAnchorService r24, h r25, MultiAnchorLinkContext r26, g r27, MultiPkScopeProviderService r28, com.bytedance.android.live.revlink.link.streaminteract.biz.c r29) {
        Intrinsics.checkNotNullParameter(r17, "context");
        Intrinsics.checkNotNullParameter(r18, "roomService");
        Intrinsics.checkNotNullParameter(r19, "pkBaseDataContext");
        Intrinsics.checkNotNullParameter(r20, "pkContextHolder");
        Intrinsics.checkNotNullParameter(r22, "rtcBizComponent");
        Intrinsics.checkNotNullParameter(r23, "messageService");
        Intrinsics.checkNotNullParameter(r24, "domainAnchorService");
        Intrinsics.checkNotNullParameter(r25, "bizDataContext");
        Intrinsics.checkNotNullParameter(r26, "linkContext");
        Intrinsics.checkNotNullParameter(r27, "chorusComponent");
        Intrinsics.checkNotNullParameter(r28, "multiPkScopeService");
        Intrinsics.checkNotNullParameter(r29, "streamMixManagerService");
        this.f = r17;
        this.g = r18;
        this.h = r20;
        this.i = r23;
        this.a = "MultiSceneCompactComponent";
        MultiNativeComponent r1 = new MultiNativeComponent(getContext(), r19, r18);
        this.b = r1;
        this.c = new MultiPKComponent(getContext(), r18, r1);
        this.d = new MultiOtherComponent(getContext(), r22, getContext().getLinkDataSet(), r23, r24, r25, r26, r27, r28, r18, r29, r20);
        this.e = new CompositeDisposable();
    }
}
