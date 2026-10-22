package com.larus.account.saas.jsb.core;

import kotlin.jvm.internal.Intrinsics;
import y38.y;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class g implements x38.b {
    public final /* synthetic */ x38.g<FlowAccountUnbindCore.a> a;

    public g(y r1) {
        this.a = r1;
    }

    @Override // x38.b
    public final void a(b48.c r5) {
        Intrinsics.checkNotNullParameter(r5, "error");
        this.a.onSuccess(new FlowAccountUnbindCore.a(0, Integer.valueOf(r5.a), r5.b));
    }

    @Override // x38.b
    public final void b(b48.g r5) {
        Intrinsics.checkNotNullParameter(r5, "result");
        this.a.onSuccess(new FlowAccountUnbindCore.a(1, 0, ""));
    }
}
