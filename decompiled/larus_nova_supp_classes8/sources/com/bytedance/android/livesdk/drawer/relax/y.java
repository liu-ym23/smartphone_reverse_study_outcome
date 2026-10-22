package com.bytedance.android.livesdk.drawer.relax;

import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class y {
    public final Function0<Boolean> a;
    public final Function1<? super Function1<? super Boolean, Boolean>, Unit> b;
    public final Function0<Integer> c;

    public y(Function0<Boolean> r2, Function1<? super Function1<? super Boolean, Boolean>, Unit> r3, Function0<Integer> r4) {
        Intrinsics.checkNotNullParameter(r2, "show");
        Intrinsics.checkNotNullParameter(r3, "setShowOpenLive");
        Intrinsics.checkNotNullParameter(r4, "openLiveShowCount");
        this.a = r2;
        this.b = r3;
        this.c = r4;
    }
}
