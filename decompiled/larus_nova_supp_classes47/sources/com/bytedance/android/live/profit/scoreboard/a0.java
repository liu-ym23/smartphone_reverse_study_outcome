package com.bytedance.android.live.profit.scoreboard;

import io.reactivex.functions.Consumer;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class a0<T> implements Consumer {
    public final /* synthetic */ v a;
    public final /* synthetic */ v.g b;

    public a0(v r1, v.g r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void accept(Object r6) {
        Unit r7 = (Unit) r6;
        if (((Boolean) this.a.c.d().a).booleanValue() == true) goto L10;
        Pair r8 = (Pair) this.a.c.x().a;
        v r0 = this.a;
        v.g r1 = this.b;
        j80.d r2 = v.a(r0, r1.f, r1.c, (RegionId) r8.getFirst(), (j80.d) r8.getSecond());
        if ((!Intrinsics.areEqual(j80.b.a(this.b.c), r2)) == false) goto L9;
        jy0.b.d("ScoreboardBannerController", "(" + ((RegionId) r8.getFirst()).getId() + ", " + ((j80.d) r8.getSecond()) + ") to local pos: " + r2);
        j80.b.e(this.b.c, r2);
        return;
    L9:
        return;
    }
}
