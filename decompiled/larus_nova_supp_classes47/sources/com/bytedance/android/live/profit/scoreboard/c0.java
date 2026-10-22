package com.bytedance.android.live.profit.scoreboard;

import io.reactivex.functions.Consumer;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class c0<T> implements Consumer {
    public final /* synthetic */ v a;
    public final /* synthetic */ v.g b;

    public c0(v r1, v.g r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void accept(Object r5) {
        Pair r6 = (Pair) r5;
        RegionId r0 = (RegionId) r6.component1();
        j80.d r7 = (j80.d) r6.component2();
        v r1 = this.a;
        v.g r2 = this.b;
        j80.d r3 = v.a(r1, r2.f, r2.c, r0, r7);
        if ((!Intrinsics.areEqual(this.b.d.getPos(), r3)) == false) goto L6;
        jy0.b.d("ScoreboardBannerController", "(" + r0.getId() + ", " + r7 + ") to local pos: " + r3);
        this.b.d.a(r3);
        return;
    }
}
