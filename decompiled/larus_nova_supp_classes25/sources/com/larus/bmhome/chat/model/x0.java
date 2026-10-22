package com.larus.bmhome.chat.model;

import com.larus.im.callback.IIMCallback;
import com.larus.im.callback.IIMError;
import kotlin.Result;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class x0 implements IIMCallback<wc9.b> {
    public final /* synthetic */ kotlinx.coroutines.i<wc9.b> a;

    public final boolean mustInMain() {
        return !com.larus.im.internal.delegate.y0.a();
    }

    public x0(kotlinx.coroutines.j r1) {
        this.a = r1;
    }

    public final void onFailure(IIMError r2) {
        Intrinsics.checkNotNullParameter(r2, "error");
        if (this.a.isActive() == false) goto L6;
        this.a.resumeWith(Result.constructor-impl(null));
        return;
    }

    public final void onSuccess(Object r2) {
        wc9.b r3 = (wc9.b) r2;
        Intrinsics.checkNotNullParameter(r3, "result");
        if (this.a.isActive() == false) goto L6;
        this.a.resumeWith(Result.constructor-impl(r3));
        return;
    }
}
