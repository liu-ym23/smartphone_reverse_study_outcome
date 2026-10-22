package com.larus.dora.impl;

import com.bytedance.dora.device.DoraDevice;
import com.bytedance.dora.wear.WearState;
import com.larus.dora.impl.core.DoraAdapterExtKt;
import g49.d;
import kj4.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class DoraBuryPointManager$b implements uk4.c {
    public final /* synthetic */ DoraBuryPointManager a;

    public DoraBuryPointManager$b(DoraBuryPointManager r1) {
        this.a = r1;
    }

    public final void a(DoraDevice r3, WearState r4, WearState r5) {
        String r6 = DoraBuryPointManager.b;
        d.d(r6, "onWearingStateChanged leftState = " + r4 + ", rightState = " + r5);
        DoraDevice r0 = DoraAdapterExtKt.i(a.g(), false);
        if (r0 != null) goto L5;
    L14:
        d.d(r6, "onGlassOpenStateChange. is not G device.");
        return;
    L5:
        if (o59.a.l(r0) == false) goto L14;
        WearState r7 = WearState.ON;
        if (r4 == r7) goto L12;
        if (r5 == r7) goto L12;
        this.a.R(r0, true, "from:wearOff");
        return;
    L12:
        DoraBuryPointManager.m = System.currentTimeMillis();
    }
}
