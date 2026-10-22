package com.bytedance.android.livesdk.dynamicstrategy.impl.nfa;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class m {
    public final String a;
    public final long b;
    public final j c;

    public m(String r2, long r3, j r5) {
        Intrinsics.checkNotNullParameter(r2, "runnableName");
        Intrinsics.checkNotNullParameter(r5, "runnable");
        this.a = r2;
        this.b = r3;
        this.c = r5;
    }
}
