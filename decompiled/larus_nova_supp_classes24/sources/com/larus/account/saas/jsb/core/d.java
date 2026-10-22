package com.larus.account.saas.jsb.core;

import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import y38.k;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class d implements x38.b {
    public final /* synthetic */ x38.g<Unit> a;

    public d(k r1) {
        this.a = r1;
    }

    @Override // x38.b
    public final void a(b48.c r5) {
        Intrinsics.checkNotNullParameter(r5, "error");
        c48.a.a().a();
        String r6 = com.larus.init.task.accountsdk.a.a.getApplication().getString(2131899089);
        x38.g<Unit> r0 = this.a;
        FlowAccountLogoutCore.Error r1 = FlowAccountLogoutCore.Error.LOGOUT_FAILED;
        int r2 = r1.getCode();
        if (StringsKt.isBlank(r6) == false) goto L5;
        r6 = r1.getMessage();
    L5:
        r0.a(new x38.a(r2, r6, null));
    }

    @Override // x38.b
    public final void b(b48.g r2) {
        Intrinsics.checkNotNullParameter(r2, "result");
        this.a.onSuccess(Unit.INSTANCE);
    }
}
