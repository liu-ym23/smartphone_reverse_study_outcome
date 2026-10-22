package com.bytedance.android.live.revlink.link.core.service;

import io.reactivex.disposables.CompositeDisposable;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class l implements com.bytedance.android.live.revlink.link.biz.service.a {
    public final CompositeDisposable a;
    public boolean b;
    public final AnchorUILayoutManager c;
    public final yz0.f d;
    public final com.bytedance.android.live.revlink.link.infra.lifecontrol.context.a e;

    @Override // com.bytedance.android.live.revlink.link.biz.service.a, com.bytedance.android.live.revlink.link.biz.service.j
    public /* bridge */ /* synthetic */ com.bytedance.android.live.revlink.link.infra.lifecontrol.context.d getContext() {
        return getContext();
    }

    @Override // com.bytedance.android.live.revlink.link.biz.service.k
    public final com.bytedance.android.live.revlink.impl.global.c getLinkInstanceService() {
        return getContext();
    }

    @Override // com.bytedance.android.live.revlink.link.biz.service.a, com.bytedance.android.live.revlink.link.biz.service.j
    public com.bytedance.android.live.revlink.link.infra.lifecontrol.context.a getContext() {
        return this.e;
    }

    public l(AnchorUILayoutManager r2, yz0.f r3, com.bytedance.android.live.revlink.link.infra.lifecontrol.context.g r4) {
        Intrinsics.checkNotNullParameter(r2, "uiLayoutManager");
        Intrinsics.checkNotNullParameter(r3, "messageService");
        Intrinsics.checkNotNullParameter(r4, "context");
        this.c = r2;
        this.d = r3;
        this.e = r4;
        this.a = new CompositeDisposable();
    }
}
