package com.bytedance.android.live.profit.privilege.service;

import com.bytedance.android.scope.l;
import com.bytedance.android.scope.o;
import e33.k;
import kotlin.UninitializedPropertyAccessException;
import kotlin.jvm.internal.Intrinsics;
import yz0.m;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class d implements o, m {
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
        xu0.b r0 = new xu0.b(this.a);
        Intrinsics.checkNotNullParameter(r0, "scope");
        Object r1 = k.a;
        if (r0.e != r1) goto L6;
        String r2 = "revenueInstance";
    L12:
        if (r2 != null) goto L16;
        l.a(r0);
        return;
    L16:
        throw new UninitializedPropertyAccessException(r2);
    L6:
        if (r0.f != r1) goto L9;
        r2 = "revenueInstanceExt";
        goto L12
    L9:
        if (r0.g != r1) goto L11;
        r2 = "roomInstance";
        goto L12
    L11:
        r2 = null;
        goto L12
    }

    public d(cy0.f r2) {
        Intrinsics.checkNotNullParameter(r2, "instScope");
        this.a = r2;
    }
}
