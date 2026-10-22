package com.larus.bmhome.chat.model.repo;

import com.larus.im.callback.IIMCallback;
import com.larus.im.callback.IIMError;
import java.util.List;
import kotlin.Result;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class p1 implements IIMCallback<List<? extends wc9.e>> {
    public final /* synthetic */ kotlinx.coroutines.i<List<wc9.e>> a;
    public final /* synthetic */ ConversationRepo b;

    public final boolean mustInMain() {
        return !com.larus.im.internal.delegate.y0.a();
    }

    public final void onFailure(IIMError r2) {
        Intrinsics.checkNotNullParameter(r2, "error");
        Intrinsics.checkNotNullParameter(r2, "error");
        kotlinx.coroutines.i<List<wc9.e>> r3 = this.a;
        Result.Companion r0 = Result.Companion;
        r3.resumeWith(Result.constructor-impl(CollectionsKt.emptyList()));
    }

    public final void onSuccess(Object r3) {
        List r4 = (List) r3;
        Intrinsics.checkNotNullParameter(r4, "result");
        kotlinx.coroutines.i<List<wc9.e>> r0 = this.a;
        Result.Companion r1 = Result.Companion;
        r0.resumeWith(Result.constructor-impl(ConversationRepo.z(this.b, r4)));
    }

    public p1(kotlinx.coroutines.j r1, ConversationRepo r2) {
        this.a = r1;
        this.b = r2;
    }
}
