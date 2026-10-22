package com.ss.android.lark.movable;

import com.ss.android.lark.movable.island.ScrollIsland;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class g implements jsb.b {
    public final /* synthetic */ MovableView a;

    public g(MovableView r1) {
        this.a = r1;
    }

    @Override // jsb.b
    public final void b(int r2) {
        this.a.m.remove(Integer.valueOf(r2));
    }

    @Override // jsb.b
    public final void a(jsb.a r2, ScrollIsland r3) {
        Intrinsics.checkNotNullParameter(r2, "info");
        Intrinsics.checkNotNullParameter(r3, "scrollIsland");
        this.a.m.put(Integer.valueOf(r2.a), r3);
    }
}
