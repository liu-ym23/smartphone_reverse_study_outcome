package com.larus.dora.impl.core;

import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class u0 implements com.larus.platform.api.b {
    public u0() {
    }

    public final void b(com.larus.platform.api.c r2) {
        Intrinsics.checkNotNullParameter(r2, "event");
    }

    public final void a(com.larus.platform.api.c r2) {
        Intrinsics.checkNotNullParameter(r2, "event");
        CoroutineScope r3 = DoraSyncManager.a;
        DoraSyncManager.c("3");
    }
}
