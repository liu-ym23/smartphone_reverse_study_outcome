package com.larus.bmhome.chat.model.repo;

import com.larus.im.bean.message.Message;
import com.larus.im.callback.IIMCallback;
import com.larus.im.callback.IIMError;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CompletableDeferred;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class ChatRepo$h implements IIMCallback<Message> {
    public final /* synthetic */ CompletableDeferred<Message> a;

    public final boolean mustInMain() {
        return !com.larus.im.internal.delegate.y0.a();
    }

    public ChatRepo$h(CompletableDeferred<Message> r1) {
        this.a = r1;
    }

    public final void onFailure(IIMError r2) {
        Intrinsics.checkNotNullParameter(r2, "error");
        Intrinsics.checkNotNullParameter(r2, "error");
        this.a.complete(null);
    }

    public final void onSuccess(Object r2) {
        CompletableDeferred<Message> r0 = this.a;
        r0.complete((Message) r2);
    }
}
