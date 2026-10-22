package com.bytedance.android.livesdk.drawer.relax;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class o {
    public final Function1<? super Boolean, Unit> a;

    public o(Function1<? super Boolean, Unit> r2) {
        Intrinsics.checkNotNullParameter(r2, "handleRetry");
        this.a = r2;
    }
}
