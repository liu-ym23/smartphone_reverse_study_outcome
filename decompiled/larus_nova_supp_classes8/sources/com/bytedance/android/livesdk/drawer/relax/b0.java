package com.bytedance.android.livesdk.drawer.relax;

import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class b0 {
    public final Function0<Integer> a;
    public final Function1<? super Function1<? super Integer, Integer>, Unit> b;
    public final Function2<? super Integer, ? super Boolean, Unit> c;
    public final Function0<Integer> d;
    public final Function1<? super Function1<? super Integer, Integer>, Unit> e;

    public b0(Function0<Integer> r2, Function1<? super Function1<? super Integer, Integer>, Unit> r3, Function2<? super Integer, ? super Boolean, Unit> r4, Function0<Integer> r5, Function1<? super Function1<? super Integer, Integer>, Unit> r6) {
        Intrinsics.checkNotNullParameter(r2, "selectedIndex");
        Intrinsics.checkNotNullParameter(r3, "setSelectedIndex");
        Intrinsics.checkNotNullParameter(r4, "handleTabChange");
        Intrinsics.checkNotNullParameter(r5, "refreshTab");
        Intrinsics.checkNotNullParameter(r6, "setRefreshTab");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
    }
}
