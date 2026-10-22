package com.larus.bmhome.chat.model.repo;

import com.larus.im.callback.IIMCallback;
import com.larus.im.callback.IIMError;
import java.util.List;
import kotlin.Result;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class ConversationRepo$f implements IIMCallback<List<? extends wc9.e>> {
    public final /* synthetic */ kotlinx.coroutines.i<List<wc9.e>> a;

    public final boolean mustInMain() {
        return !com.larus.im.internal.delegate.y0.a();
    }

    public ConversationRepo$f(kotlinx.coroutines.j r1) {
        this.a = r1;
    }

    public final void onFailure(IIMError r2) {
        Intrinsics.checkNotNullParameter(r2, "error");
        kotlinx.coroutines.i<List<wc9.e>> r3 = this.a;
        Result.Companion r0 = Result.Companion;
        r3.resumeWith(Result.constructor-impl(CollectionsKt.emptyList()));
    }

    public final void onSuccess(Object r2) {
        List r3 = (List) r2;
        Intrinsics.checkNotNullParameter(r3, "result");
        this.a.resumeWith(Result.constructor-impl(r3));
    }
}
