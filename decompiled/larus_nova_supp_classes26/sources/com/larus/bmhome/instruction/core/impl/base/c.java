package com.larus.bmhome.instruction.core.impl.base;

import dq8.g;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class c {
    public final aq8.d a;
    public final CoroutineScope b;
    public final i c;

    public c(aq8.d r2, CoroutineScope r3, g r4, i r5) {
        Intrinsics.checkNotNullParameter(r2, "dependency");
        Intrinsics.checkNotNullParameter(r3, "scope");
        Intrinsics.checkNotNullParameter(r4, "eventSink");
        this.a = r2;
        this.b = r3;
        this.c = r5;
    }
}
