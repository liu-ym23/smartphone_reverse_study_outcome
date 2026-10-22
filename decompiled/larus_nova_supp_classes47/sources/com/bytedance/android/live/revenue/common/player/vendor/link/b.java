package com.bytedance.android.live.revenue.common.player.vendor.link;

import java.util.ArrayList;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class b {
    public final List<zx0.a> a;

    public b(Function1<? super List<zx0.a>, Unit> r2) {
        Intrinsics.checkNotNullParameter(r2, "strategyListScope");
        ArrayList r0 = new ArrayList();
        r2.invoke(r0);
        Unit r3 = Unit.INSTANCE;
        this.a = r0;
    }
}
