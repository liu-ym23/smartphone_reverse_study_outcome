package com.larus.bmhome.chat.model.repo;

import com.larus.im.callback.IIMCallback;
import com.larus.im.callback.IIMError;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CompletableDeferred;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class BotRepo$f implements IIMCallback<uc9.t> {
    public final /* synthetic */ CompletableDeferred<uc9.t> a;

    public final boolean mustInMain() {
        return !com.larus.im.internal.delegate.y0.a();
    }

    public BotRepo$f(CompletableDeferred<uc9.t> r1) {
        this.a = r1;
    }

    public final void onFailure(IIMError r2) {
        Intrinsics.checkNotNullParameter(r2, "error");
        Intrinsics.checkNotNullParameter(r2, "error");
        this.a.complete(null);
    }

    public final void onSuccess(Object r2) {
        uc9.t r3 = (uc9.t) r2;
        Intrinsics.checkNotNullParameter(r3, "result");
        this.a.complete(r3);
    }
}
