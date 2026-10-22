package com.larus.bot.impl.repository;

import com.larus.im.callback.IIMCallback;
import com.larus.im.callback.IIMError;
import com.larus.im.internal.delegate.y0;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CompletableDeferred;
import uc9.t;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class g implements IIMCallback<t> {
    public final /* synthetic */ CompletableDeferred<ub8.b> a;

    public final boolean mustInMain() {
        return !y0.a();
    }

    public g(CompletableDeferred<ub8.b> r1) {
        this.a = r1;
    }

    public final void onFailure(IIMError r5) {
        Intrinsics.checkNotNullParameter(r5, "error");
        Intrinsics.checkNotNullParameter(r5, "error");
        this.a.complete(new ub8.b(null, r5, 3));
    }

    public final void onSuccess(Object r5) {
        t r6 = (t) r5;
        Intrinsics.checkNotNullParameter(r6, "result");
        this.a.complete(new ub8.b(r6, null, 6));
    }
}
