package com.larus.chat.gallery.impl.preview.datasource;

import com.larus.im.bean.message.Message;
import com.larus.im.bean.message.MessageQueryResponse;
import com.larus.im.callback.IIMCallback;
import com.larus.im.callback.IIMError;
import com.larus.im.internal.delegate.y0;
import com.larus.utils.logger.FLogger;
import java.util.Iterator;
import java.util.List;
import kotlin.Result;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.SafeContinuation;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class u implements IIMCallback<MessageQueryResponse> {
    public final /* synthetic */ Continuation<Message> a;
    public final /* synthetic */ PreviewMessageDataSource b;

    public final boolean mustInMain() {
        return !y0.a();
    }

    public final void onFailure(IIMError r4) {
        Intrinsics.checkNotNullParameter(r4, "error");
        FLogger.a.e("PreviewMessageDataSource", "querySelectMessage failed: " + r4);
        this.a.resumeWith(Result.constructor-impl(null));
    }

    public final void onSuccess(Object r6) {
        MessageQueryResponse r7 = (MessageQueryResponse) r6;
        Intrinsics.checkNotNullParameter(r7, "result");
        List r8 = r7.historyMessages;
        Object r0 = null;
        if (r8 == null) goto L11;
        PreviewMessageDataSource r1 = this.b;
        Iterator r9 = r8.iterator();
    L6:
        if (r9.hasNext() == false) goto L10;
        Object r2 = r9.next();
        if (Intrinsics.areEqual(((Message) r2).getMessageId(), r1.b) == false) goto L6;
        r0 = r2;
    L10:
        r0 = (Message) r0;
    L11:
        this.a.resumeWith(Result.constructor-impl(r0));
    }

    public u(SafeContinuation r1, PreviewMessageDataSource r2) {
        this.a = r1;
        this.b = r2;
    }
}
