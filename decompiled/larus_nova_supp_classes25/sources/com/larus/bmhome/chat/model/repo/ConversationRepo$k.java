package com.larus.bmhome.chat.model.repo;

import com.larus.im.bean.conversation.ConversationDeleteMode;
import com.larus.im.callback.IIMCallback;
import com.larus.im.callback.IIMError;
import com.larus.utils.logger.FLogger;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CompletableDeferred;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class ConversationRepo$k implements IIMCallback<Boolean> {
    public final /* synthetic */ String a;
    public final /* synthetic */ ConversationDeleteMode b;
    public final /* synthetic */ CompletableDeferred<Boolean> c;

    public final boolean mustInMain() {
        return !com.larus.im.internal.delegate.y0.a();
    }

    public final void onFailure(IIMError r4) {
        Intrinsics.checkNotNullParameter(r4, "error");
        Intrinsics.checkNotNullParameter(r4, "error");
        FLogger.a.e("ConversationRepo", "removeConversation failed conversationId=" + this.a + " deleteMode=" + this.b + " code=" + r4.getCode() + " msg=" + r4.getTips());
        this.c.complete(Boolean.FALSE);
    }

    public final void onSuccess(Object r4) {
        boolean r5 = ((Boolean) r4).booleanValue();
        FLogger.a.i("ConversationRepo", "removeConversation finished conversationId=" + this.a + " deleteMode=" + this.b + " result=" + r5);
        if (this.b != ConversationDeleteMode.DeleteMode_RealDelete) goto L6;
        if (r5 == false) goto L6;
        com.larus.bmhome.chat.adapter.p0.a.a(this.a);
    L6:
        this.c.complete(Boolean.TRUE);
    }

    public ConversationRepo$k(String r1, ConversationDeleteMode r2, CompletableDeferred<Boolean> r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }
}
