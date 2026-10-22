package com.bytedance.android.live.revlink.link.core.service;

import kotlin.UninitializedPropertyAccessException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class e implements com.bytedance.android.scope.o {
    public p51.d a;
    public final o51.d b;

    public final void onStart() {
        o51.d r0 = this.b;
        Intrinsics.checkNotNullParameter(r0, "coreScope");
        p51.d r1 = new p51.d(r0);
        Intrinsics.checkNotNullParameter(r1, "scope");
        Object r2 = e33.k.a;
        if (r1.e != r2) goto L6;
        String r3 = "context";
    L24:
        if (r3 != null) goto L28;
        this.a = r1;
        com.bytedance.android.scope.l.a(r1);
        return;
    L28:
        throw new UninitializedPropertyAccessException(r3);
    L6:
        if (r1.f != r2) goto L9;
        r3 = "linkInternalDataSet";
        goto L24
    L9:
        if (r1.g != r2) goto L12;
        r3 = "dynamicLayoutClient";
        goto L24
    L12:
        if (r1.h != r2) goto L15;
        r3 = "linkDataScope";
        goto L24
    L15:
        if (r1.i != r2) goto L18;
        r3 = "revenueInstance";
        goto L24
    L18:
        if (r1.j != r2) goto L21;
        r3 = "revenueInstanceExt";
        goto L24
    L21:
        if (r1.k != r2) goto L23;
        r3 = "roomInstance";
        goto L24
    L23:
        r3 = null;
        goto L24
    }

    public final void onStop() {
        p51.d r0 = this.a;
        if (r0 == null) goto L5;
        com.bytedance.android.live.revlink.link.utils.a.c(r0);
    L5:
        this.a = null;
    }

    public e(o51.d r2) {
        Intrinsics.checkNotNullParameter(r2, "coreAudienceScope");
        this.b = r2;
    }
}
