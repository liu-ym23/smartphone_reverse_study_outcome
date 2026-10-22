package com.larus.bmhome.chat.model.repo;

import com.larus.im.callback.IIMCallback;
import com.larus.im.callback.IIMError;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CompletableDeferred;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class BotRepo$c implements IIMCallback<uc9.t> {
    public final /* synthetic */ CompletableDeferred<Boolean> a;

    public final boolean mustInMain() {
        return !com.larus.im.internal.delegate.y0.a();
    }

    public BotRepo$c(CompletableDeferred<Boolean> r1) {
        this.a = r1;
    }

    public final void onFailure(IIMError r2) {
        Intrinsics.checkNotNullParameter(r2, "error");
        Intrinsics.checkNotNullParameter(r2, "error");
        this.a.complete(Boolean.FALSE);
    }

    public final void onSuccess(Object r2) {
        uc9.t r3 = (uc9.t) r2;
        Intrinsics.checkNotNullParameter(r3, "result");
        if (r3.a == false) goto L5;
        this.a.complete(Boolean.TRUE);
        return;
    L5:
        this.a.complete(Boolean.FALSE);
    }
}
