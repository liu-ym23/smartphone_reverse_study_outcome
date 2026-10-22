package com.larus.chat.gallery.impl.preview.datasource;

import com.larus.im.bean.message.Message;
import com.larus.im.callback.IIMCallback;
import com.larus.im.callback.IIMError;
import com.larus.im.internal.delegate.y0;
import com.larus.utils.logger.FLogger;
import java.util.List;
import kotlin.Result;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.SafeContinuation;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class s implements IIMCallback<List<? extends Message>> {
    public final /* synthetic */ Continuation<List<Message>> a;

    public final boolean mustInMain() {
        return !y0.a();
    }

    public s(SafeContinuation r1) {
        this.a = r1;
    }

    public final void onFailure(IIMError r4) {
        Intrinsics.checkNotNullParameter(r4, "error");
        FLogger.a.e("PreviewMessageDataSource", "getMessagesByCollectionId failed: " + r4);
        Continuation<List<Message>> r5 = this.a;
        Result.Companion r0 = Result.Companion;
        r5.resumeWith(Result.constructor-impl(CollectionsKt.emptyList()));
    }

    public final void onSuccess(Object r2) {
        List r3 = (List) r2;
        Intrinsics.checkNotNullParameter(r3, "result");
        this.a.resumeWith(Result.constructor-impl(r3));
    }
}
