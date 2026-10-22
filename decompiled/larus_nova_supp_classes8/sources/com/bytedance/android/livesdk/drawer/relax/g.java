package com.bytedance.android.livesdk.drawer.relax;

import com.relax.relaxframework.TapEvent;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class g {
    public final Function0<String> a;
    public final Function1<? super TapEvent, Unit> b;
    public final Function0<Long> c;
    public final Function0<Boolean> d;

    public g(Function0<String> r2, Function1<? super TapEvent, Unit> r3, Function0<Long> r4, Function0<Boolean> r5) {
        Intrinsics.checkNotNullParameter(r2, "text");
        Intrinsics.checkNotNullParameter(r3, "onClick");
        Intrinsics.checkNotNullParameter(r4, "followStatus");
        Intrinsics.checkNotNullParameter(r5, "doFollowing");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
    }
}
