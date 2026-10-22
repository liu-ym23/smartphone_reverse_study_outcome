package com.bytedance.android.live.profit.scoreboard;

import kotlin.UninitializedPropertyAccessException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class i1 implements com.bytedance.android.scope.o, yz0.m {
    public final cy0.f a;

    public final void onStart() {
    }

    public final void onStop() {
    }

    @Override // yz0.m
    public final void onViewReady() {
    }

    @Override // yz0.m
    public final void onWidgetLoaded() {
    }

    @Override // yz0.m
    public final void x() {
    }

    @Override // yz0.m
    public final void i() {
        if (tb1.c.g == false) goto L18;
        p1 r0 = new p1(this.a);
        Intrinsics.checkNotNullParameter(r0, "scope");
        Object r1 = e33.k.a;
        if (r0.e != r1) goto L8;
        String r2 = "revenueInstance";
    L14:
        if (r2 != null) goto L17;
        com.bytedance.android.scope.l.a(r0);
        return;
    L17:
        throw new UninitializedPropertyAccessException(r2);
    L8:
        if (r0.f != r1) goto L11;
        r2 = "revenueInstanceExt";
        goto L14
    L11:
        if (r0.g != r1) goto L13;
        r2 = "roomInstance";
        goto L14
    L13:
        r2 = null;
        goto L14
    }

    public i1(cy0.f r2, ScoreboardExternalServiceFacade r3) {
        Intrinsics.checkNotNullParameter(r2, "instScope");
        Intrinsics.checkNotNullParameter(r3, "facade");
        this.a = r2;
    }
}
