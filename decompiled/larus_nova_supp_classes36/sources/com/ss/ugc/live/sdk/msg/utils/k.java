package com.ss.ugc.live.sdk.msg.utils;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class k {
    public final mmc.c a;
    public final g<?, Throwable> b;

    /* JADX WARN: Multi-variable type inference failed */
    public k(mmc.c r2, g<?, ? extends Throwable> r3) {
        Intrinsics.checkNotNullParameter(r2, "taskId");
        Intrinsics.checkNotNullParameter(r3, "result");
        this.a = r2;
        this.b = r3;
    }
}
