package com.bytedance.android.live.revlink.link.biz.component;

import com.bytedance.android.live.revlink.link.domain.service.RevLinkDomainAnchorService;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class MultiFollowState implements com.bytedance.android.live.revlink.link.biz.service.c {
    public final String a;
    public final com.bytedance.android.live.revlink.link.infra.lifecontrol.context.a b;
    public final RevLinkDomainAnchorService c;

    @Override // com.bytedance.android.live.revlink.link.biz.service.e
    public final void attach() {
    }

    @Override // com.bytedance.android.live.revlink.link.biz.service.e
    public final void detach() {
    }

    @Override // com.bytedance.android.live.revlink.link.biz.service.e
    public final String getTAG() {
        return "RevenueLinkAnchorComponent";
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
        return this.b;
    }

    public MultiFollowState(com.bytedance.android.live.revlink.link.infra.lifecontrol.context.g r2, RevLinkDomainAnchorService r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "domainService");
        this.b = r2;
        this.c = r3;
        this.a = "MultiFollowState";
    }

    public final void a(final String r3, boolean r4, final String r5) {
        Intrinsics.checkNotNullParameter(r5, "source");
        if (r4 == true) goto L5;
        getContext().ko().k(new MultiFollowState$setFollowState$1(this, r3, r5));
        return;
    L5:
        s51.c r6 = RevLinkDomainAnchorService.f(this.c, r3, null, 2);
        if (r6 == null) goto L10;
        Intrinsics.checkNotNullParameter(r5, "requestSource");
        r6.j.h(true, r5);
        return;
    }
}
