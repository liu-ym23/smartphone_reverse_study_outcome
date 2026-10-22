package com.larus.bmhome.chat.model.repo;

import com.larus.im.bean.message.Message;
import com.larus.im.callback.IIMCallback;
import com.larus.im.callback.IIMError;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CompletableDeferred;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class ChatRepo$g implements IIMCallback<List<? extends Message>> {
    public final /* synthetic */ CompletableDeferred<List<Message>> a;

    public final boolean mustInMain() {
        return !com.larus.im.internal.delegate.y0.a();
    }

    public ChatRepo$g(CompletableDeferred<List<Message>> r1) {
        this.a = r1;
    }

    public final void onFailure(IIMError r2) {
        Intrinsics.checkNotNullParameter(r2, "error");
        Intrinsics.checkNotNullParameter(r2, "error");
        this.a.complete(CollectionsKt.emptyList());
    }

    public final void onSuccess(Object r2) {
        List r3 = (List) r2;
        Intrinsics.checkNotNullParameter(r3, "result");
        this.a.complete(r3);
    }
}
