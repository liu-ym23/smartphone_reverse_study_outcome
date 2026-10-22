package com.bytedance.android.live.openplatform.impl.miniappanchor.debug;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class d<T> implements Consumer {
    public final /* synthetic */ MiniAppAnchorDebugContextService a;

    public d(MiniAppAnchorDebugContextService r1) {
        this.a = r1;
    }

    public final void accept(Object r2) {
        Long r3 = (Long) r2;
        MiniAppAnchorDebugContextService r4 = this.a;
        if (r4.d == true) goto L6;
        MiniAppAnchorDebugContextService.g(r4, r4.getOpenPlatformContext().getContext());
        return;
    }
}
