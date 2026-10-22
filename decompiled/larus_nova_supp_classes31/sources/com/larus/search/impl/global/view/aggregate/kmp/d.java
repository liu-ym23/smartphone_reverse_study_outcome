package com.larus.search.impl.global.view.aggregate.kmp;

import com.larus.im.bean.bot.BotModel;
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

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class d implements IIMCallback<List<? extends BotModel>> {
    public final /* synthetic */ Continuation<BotModel> a;

    public final boolean mustInMain() {
        return !y0.a();
    }

    public d(SafeContinuation r1) {
        this.a = r1;
    }

    public final void onFailure(IIMError r4) {
        Intrinsics.checkNotNullParameter(r4, "error");
        FLogger.a.w("ChatSearchActionHandler", "getBotByConversationId failed: " + r4);
        this.a.resumeWith(Result.constructor-impl(null));
    }

    public final void onSuccess(Object r3) {
        List r4 = (List) r3;
        Intrinsics.checkNotNullParameter(r4, "result");
        Continuation<BotModel> r0 = this.a;
        Result.Companion r1 = Result.Companion;
        r0.resumeWith(Result.constructor-impl(CollectionsKt.firstOrNull(r4)));
    }
}
