package com.larus.chat.gallery.impl.preview.datasource;

import com.larus.im.bean.message.MessageQueryResponse;
import com.larus.im.callback.IIMCallback;
import com.larus.im.callback.IIMError;
import com.larus.im.internal.delegate.y0;
import com.larus.utils.logger.FLogger;
import kotlin.Result;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.SafeContinuation;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class t implements IIMCallback<MessageQueryResponse> {
    public final /* synthetic */ Continuation<MessageQueryResponse> a;

    public final boolean mustInMain() {
        return !y0.a();
    }

    public t(SafeContinuation r1) {
        this.a = r1;
    }

    public final void onFailure(IIMError r4) {
        Intrinsics.checkNotNullParameter(r4, "error");
        FLogger.a.e("PreviewMessageDataSource", "queryMessages failed: " + r4);
        this.a.resumeWith(Result.constructor-impl(null));
    }

    public final void onSuccess(Object r2) {
        MessageQueryResponse r3 = (MessageQueryResponse) r2;
        Intrinsics.checkNotNullParameter(r3, "result");
        this.a.resumeWith(Result.constructor-impl(r3));
    }
}
