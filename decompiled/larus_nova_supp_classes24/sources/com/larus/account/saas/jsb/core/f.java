package com.larus.account.saas.jsb.core;

import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import y38.o;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class f implements x38.c {
    public final /* synthetic */ x38.g<Unit> a;

    public f(o r1) {
        this.a = r1;
    }

    @Override // x38.c
    public final void a(b48.c r5) {
        Intrinsics.checkNotNullParameter(r5, "error");
        x38.g<Unit> r0 = this.a;
        FlowAccountMobileSmsLoginCore.Error r2 = FlowAccountMobileSmsLoginCore.Error.LOGIN_FAILED;
        int r3 = r2.getCode();
        String r6 = r5.b;
        if (r6 != null) goto L5;
        r6 = r2.getMessage();
    L5:
        r0.a(new x38.a(r3, r6, null));
    }

    @Override // x38.c
    public final void b(b48.f r2) {
        Intrinsics.checkNotNullParameter(r2, "result");
        this.a.onSuccess(Unit.INSTANCE);
    }
}
