package com.bytedance.android.live.liveinteract.revenue.battle;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class o implements ne0.a {
    public final /* synthetic */ j a;

    public o(j r1) {
        this.a = r1;
    }

    @Override // ne0.a
    public final void a(ne0.e r2, Object r3) {
        Intrinsics.checkNotNullParameter(r2, "store");
        if (r3 == null) goto L5;
        String r4 = (String) r3;
    L6:
        this.a.a.nj(r4);
        return;
    L5:
        r4 = "";
        goto L6
    }
}
