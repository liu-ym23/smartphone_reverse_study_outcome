package com.larus.common.account.bdauth.repository;

import kotlin.Result;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class j implements n38.k {
    public final /* synthetic */ kotlinx.coroutines.i<n38.b> a;

    public j(kotlinx.coroutines.j r1) {
        this.a = r1;
    }

    public final void a(n38.b r2) {
        Intrinsics.checkNotNullParameter(r2, "result");
        if (this.a.isActive() == false) goto L6;
        this.a.resumeWith(Result.constructor-impl(r2));
        return;
    }

    public final void b(n38.b r2) {
        Intrinsics.checkNotNullParameter(r2, "result");
        if (this.a.isActive() == false) goto L6;
        this.a.resumeWith(Result.constructor-impl(r2));
        return;
    }
}
