package com.bytedance.android.livesdk.dslservice.gecko;

import java.io.File;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class b {
    public final Function3<File, Boolean, String, Unit> a;
    public final Function1<Throwable, Unit> b;

    /* JADX WARN: Multi-variable type inference failed */
    public b(Function3<? super File, ? super Boolean, ? super String, Unit> r2, Function1<? super Throwable, Unit> r3) {
        Intrinsics.checkNotNullParameter(r2, "onSuccess");
        Intrinsics.checkNotNullParameter(r3, "onError");
        this.a = r2;
        this.b = r3;
    }
}
