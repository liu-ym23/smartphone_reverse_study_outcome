package com.larus.sheet.operation;

import kotlin.Result;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.i;
import kotlinx.coroutines.j;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class d implements nc5.a<Boolean> {
    public final /* synthetic */ i<Boolean> a;

    public d(j r1) {
        this.a = r1;
    }

    public final void onFailure(Throwable r2) {
        Intrinsics.checkNotNullParameter(r2, "error");
        if (this.a.isActive() == false) goto L6;
        i<Boolean> r3 = this.a;
        Result.Companion r0 = Result.Companion;
        r3.resumeWith(Result.constructor-impl(Boolean.FALSE));
        return;
    }

    public final void onSuccess(Object r2) {
        boolean r3 = ((Boolean) r2).booleanValue();
        if (this.a.isActive() == false) goto L6;
        Boolean r4 = Boolean.valueOf(r3);
        this.a.resumeWith(Result.constructor-impl(r4));
        return;
    }
}
