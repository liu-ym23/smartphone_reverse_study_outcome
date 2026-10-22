package com.larus.chat.gallery.api.datasource;

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
public final class b implements IIMCallback<MessageQueryResponse> {
    public final /* synthetic */ a a;
    public final /* synthetic */ Continuation<ty8.c> b;

    public final boolean mustInMain() {
        return !y0.a();
    }

    public final void onFailure(IIMError r4) {
        Intrinsics.checkNotNullParameter(r4, "error");
        Intrinsics.checkNotNullParameter(r4, "error");
        FLogger.a.e("GalleryMessageLoadProcessor", "loadMore failed, error: " + r4);
        this.b.resumeWith(Result.constructor-impl(new ty8.c(null, false)));
    }

    public final void onSuccess(Object r4) {
        MessageQueryResponse r5 = (MessageQueryResponse) r4;
        Intrinsics.checkNotNullParameter(r5, "result");
        a r0 = this.a;
        r0.d = r5.pageToken;
        r0.f = r5.hasMore;
        FLogger.a.i("GalleryMessageLoadProcessor", "loadMore success, hasMore: " + this.a.f + ", pageToken: " + this.a.d);
        a.a(this.a, r5.historyMessages);
        Continuation<ty8.c> r1 = this.b;
        Result.Companion r2 = Result.Companion;
        r1.resumeWith(Result.constructor-impl(new ty8.c(r5.historyMessages, r5.hasMore)));
    }

    public b(a r1, SafeContinuation r2) {
        this.a = r1;
        this.b = r2;
    }
}
