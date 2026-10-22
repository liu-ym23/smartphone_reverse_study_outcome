package com.obric.memorydata.sdk.screencapture;

import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
public final class b {
    public final Function1<Function0<Unit>, Unit> a;
    public final Function1<ScreenData, Unit> b;
    public final Function0<Unit> c;

    public b(h r2, Function1 r3, i r4) {
        Intrinsics.checkNotNullParameter(r2, "post");
        Intrinsics.checkNotNullParameter(r3, "callback");
        Intrinsics.checkNotNullParameter(r4, "onComplete");
        this.a = r2;
        this.b = r3;
        this.c = r4;
    }
}
