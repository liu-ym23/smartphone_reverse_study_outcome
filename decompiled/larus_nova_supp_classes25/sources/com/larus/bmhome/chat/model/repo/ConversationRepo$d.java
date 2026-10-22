package com.larus.bmhome.chat.model.repo;

import com.larus.im.callback.IIMCallback;
import com.larus.im.callback.IIMError;
import kotlin.Result;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class ConversationRepo$d implements IIMCallback<wc9.e> {
    public final /* synthetic */ kotlinx.coroutines.i<wc9.e> a;

    public final boolean mustInMain() {
        return !com.larus.im.internal.delegate.y0.a();
    }

    public ConversationRepo$d(kotlinx.coroutines.j r1) {
        this.a = r1;
    }

    public final void onFailure(IIMError r2) {
        Intrinsics.checkNotNullParameter(r2, "error");
        Intrinsics.checkNotNullParameter(r2, "error");
        this.a.resumeWith(Result.constructor-impl(null));
    }

    public final void onSuccess(Object r2) {
        this.a.resumeWith(Result.constructor-impl((wc9.e) r2));
    }
}
