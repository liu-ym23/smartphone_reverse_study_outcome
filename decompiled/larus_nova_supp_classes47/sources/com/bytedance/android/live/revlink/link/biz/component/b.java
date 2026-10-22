package com.bytedance.android.live.revlink.link.biz.component;

import com.bytedance.android.live.revlink.link.core.service.AnchorUILayoutManager;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class b implements com.bytedance.android.live.revlink.link.biz.service.k {
    public final com.bytedance.android.live.revlink.impl.global.c a;
    public final AnchorUILayoutManager b;

    @Override // com.bytedance.android.live.revlink.link.biz.service.k
    public final com.bytedance.android.live.revlink.impl.global.c getLinkInstanceService() {
        return this.a;
    }

    public b(com.bytedance.android.live.revlink.link.infra.lifecontrol.context.d r2, AnchorUILayoutManager r3) {
        Intrinsics.checkNotNullParameter(r2, "linkInstanceService");
        Intrinsics.checkNotNullParameter(r3, "uiLayoutManager");
        this.a = r2;
        this.b = r3;
    }
}
