package com.bytedance.android.live.revenue.platform.room.impl;

import kotlin.jvm.internal.Intrinsics;
import yz0.o;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class n extends h {
    public final com.bytedance.android.live.revenue.core.a b;
    public final com.bytedance.android.scope.a<g> c;

    @Override // com.bytedance.android.live.revenue.platform.room.impl.h
    public final void onStart() {
        com.bytedance.android.live.revenue.core.a r0 = this.b;
        r0.b(o.class, r0.getScope());
    }

    public n(com.bytedance.android.live.revenue.core.a r2, e33.a r3) {
        Intrinsics.checkNotNullParameter(r2, "inst");
        Intrinsics.checkNotNullParameter(r3, "roomStateDispatcher");
        super(r3);
        this.b = r2;
        this.c = r3;
    }
}
