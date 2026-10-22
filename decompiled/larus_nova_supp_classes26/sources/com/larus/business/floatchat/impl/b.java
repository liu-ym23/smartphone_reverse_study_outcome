package com.larus.business.floatchat.impl;

import com.larus.im.callback.IIMCallback;
import com.larus.im.callback.IIMError;
import com.larus.im.internal.delegate.y0;
import kotlin.Result;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.i;
import kotlinx.coroutines.j;
import wc9.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class b implements IIMCallback<e> {
    public final /* synthetic */ i<e> a;

    public final boolean mustInMain() {
        return !y0.a();
    }

    public b(j r1) {
        this.a = r1;
    }

    public final void onFailure(IIMError r2) {
        Intrinsics.checkNotNullParameter(r2, "error");
        Intrinsics.checkNotNullParameter(r2, "error");
        if (this.a.isActive() == false) goto L6;
        this.a.resumeWith(Result.constructor-impl(null));
        return;
    }

    public final void onSuccess(Object r2) {
        e r3 = (e) r2;
        if (this.a.isActive() == false) goto L6;
        this.a.resumeWith(Result.constructor-impl(r3));
        return;
    }
}
