package com.bytedance.android.live.liveinteract.revenue.game;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class i implements ne0.a {
    public final /* synthetic */ LinkMicGameWidget a;

    public i(LinkMicGameWidget r1) {
        this.a = r1;
    }

    @Override // ne0.a
    public final void a(ne0.e r1, Object r2) {
        Intrinsics.checkNotNullParameter(r1, "store");
        a r3 = this.a.c;
        if (r3 != null) goto L5;
        return;
    L5:
        if (r3.c() == false) goto L9;
        String r4 = qi0.c.b;
        qi0.c.m(r3.a);
        return;
    }
}
