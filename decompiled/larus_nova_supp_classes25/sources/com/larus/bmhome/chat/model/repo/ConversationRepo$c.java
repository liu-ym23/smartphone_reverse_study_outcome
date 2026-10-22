package com.larus.bmhome.chat.model.repo;

import com.larus.im.callback.IIMCallback;
import com.larus.im.callback.IIMError;
import com.larus.utils.logger.FLogger;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CompletableDeferred;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class ConversationRepo$c implements IIMCallback<wc9.e> {
    public final /* synthetic */ CompletableDeferred<wc9.e> a;

    public final boolean mustInMain() {
        return !com.larus.im.internal.delegate.y0.a();
    }

    public ConversationRepo$c(CompletableDeferred<wc9.e> r1) {
        this.a = r1;
    }

    public final void onFailure(IIMError r4) {
        Intrinsics.checkNotNullParameter(r4, "error");
        Intrinsics.checkNotNullParameter(r4, "error");
        FLogger.a.e("ConversationRepo", "createBotConversation failed! msg=" + r4.getTips() + " code=" + r4.getCode() + " err=" + r4.getException());
        this.a.complete(null);
    }

    public final void onSuccess(Object r2) {
        CompletableDeferred<wc9.e> r0 = this.a;
        r0.complete((wc9.e) r2);
    }
}
