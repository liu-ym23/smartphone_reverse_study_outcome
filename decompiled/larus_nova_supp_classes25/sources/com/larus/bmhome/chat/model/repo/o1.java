package com.larus.bmhome.chat.model.repo;

import com.larus.im.callback.IIMCallback;
import com.larus.im.callback.IIMError;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CompletableDeferred;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class o1 implements IIMCallback<Boolean> {
    public final /* synthetic */ CompletableDeferred<ub8.b> a;

    public final boolean mustInMain() {
        return !com.larus.im.internal.delegate.y0.a();
    }

    public o1(CompletableDeferred<ub8.b> r1) {
        this.a = r1;
    }

    public final void onFailure(IIMError r5) {
        Intrinsics.checkNotNullParameter(r5, "error");
        Intrinsics.checkNotNullParameter(r5, "error");
        this.a.complete(new ub8.b(null, r5, 3));
    }

    public final void onSuccess(Object r5) {
        boolean r6 = ((Boolean) r5).booleanValue();
        this.a.complete(new ub8.b(new uc9.t(r6, null), null, 6));
    }
}
