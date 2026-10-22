package com.larus.bmhome.chat.helper;

import com.larus.im.callback.IIMCallback;
import com.larus.im.callback.IIMError;
import com.larus.im.internal.delegate.y0;
import kotlin.Result;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class b implements IIMCallback<Boolean> {
    public final /* synthetic */ kotlinx.coroutines.i<Boolean> a;

    public final boolean mustInMain() {
        return !y0.a();
    }

    public b(kotlinx.coroutines.j r1) {
        this.a = r1;
    }

    public final void onFailure(IIMError r2) {
        Intrinsics.checkNotNullParameter(r2, "error");
        Intrinsics.checkNotNullParameter(r2, "error");
        kotlinx.coroutines.i<Boolean> r3 = this.a;
        Result.Companion r0 = Result.Companion;
        r3.resumeWith(Result.constructor-impl(Boolean.FALSE));
    }

    public final void onSuccess(Object r2) {
        Boolean r3 = Boolean.valueOf(((Boolean) r2).booleanValue());
        this.a.resumeWith(Result.constructor-impl(r3));
    }
}
