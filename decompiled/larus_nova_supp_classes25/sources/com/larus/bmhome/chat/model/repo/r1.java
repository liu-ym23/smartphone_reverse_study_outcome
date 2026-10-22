package com.larus.bmhome.chat.model.repo;

import com.larus.im.callback.IIMCallback;
import com.larus.im.callback.IIMError;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CompletableDeferred;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class r1 implements IIMCallback<wc9.k> {
    public final /* synthetic */ CompletableDeferred<wc9.k> a;

    public final boolean mustInMain() {
        return !com.larus.im.internal.delegate.y0.a();
    }

    public r1(CompletableDeferred<wc9.k> r1) {
        this.a = r1;
    }

    public final void onFailure(IIMError r2) {
        Intrinsics.checkNotNullParameter(r2, "error");
        Intrinsics.checkNotNullParameter(r2, "error");
        this.a.complete(null);
    }

    public final void onSuccess(Object r2) {
        wc9.k r3 = (wc9.k) r2;
        Intrinsics.checkNotNullParameter(r3, "result");
        this.a.complete(r3);
    }
}
