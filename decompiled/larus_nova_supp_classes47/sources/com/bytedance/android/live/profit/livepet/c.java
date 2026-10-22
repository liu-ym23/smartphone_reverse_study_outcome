package com.bytedance.android.live.profit.livepet;

import com.bytedance.android.scope.l;
import com.bytedance.android.scope.o;
import cy0.f;
import e33.k;
import kotlin.UninitializedPropertyAccessException;
import kotlin.jvm.internal.Intrinsics;
import yz0.m;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class c implements o, m {
    public final f a;

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
        if (qu0.b.c.a().getEnabled() == false) goto L18;
        f r0 = this.a;
        Intrinsics.checkNotNullParameter(r0, "parent");
        ru0.c r1 = new ru0.c(r0);
        Intrinsics.checkNotNullParameter(r1, "scope");
        Object r2 = k.a;
        if (r1.e != r2) goto L8;
        String r3 = "revenueInstance";
    L14:
        if (r3 != null) goto L17;
        l.a(r1);
        return;
    L17:
        throw new UninitializedPropertyAccessException(r3);
    L8:
        if (r1.f != r2) goto L11;
        r3 = "revenueInstanceExt";
        goto L14
    L11:
        if (r1.g != r2) goto L13;
        r3 = "roomInstance";
        goto L14
    L13:
        r3 = null;
        goto L14
    }

    public c(f r2) {
        Intrinsics.checkNotNullParameter(r2, "scope");
        this.a = r2;
    }
}
