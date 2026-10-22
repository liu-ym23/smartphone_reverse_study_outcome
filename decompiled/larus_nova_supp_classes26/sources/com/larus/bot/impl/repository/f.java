package com.larus.bot.impl.repository;

import com.larus.im.bean.bot.BotModel;
import com.larus.im.callback.IIMCallback;
import com.larus.im.callback.IIMError;
import com.larus.im.internal.delegate.y0;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CompletableDeferred;
import uc9.t;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class f implements IIMCallback<BotModel> {
    public final /* synthetic */ CompletableDeferred<ub8.b> a;
    public final /* synthetic */ UgcBotRepo b;

    public final boolean mustInMain() {
        return !y0.a();
    }

    public final void onFailure(IIMError r5) {
        Intrinsics.checkNotNullParameter(r5, "error");
        Intrinsics.checkNotNullParameter(r5, "error");
        this.a.complete(new ub8.b(null, r5, 3));
    }

    public final void onSuccess(Object r6) {
        BotModel r7 = (BotModel) r6;
        Intrinsics.checkNotNullParameter(r7, "result");
        this.a.complete(new ub8.b(new t(true, r7), null, 6));
        this.b.c.postValue(r7.getBotId());
    }

    public f(CompletableDeferred<ub8.b> r1, UgcBotRepo r2) {
        this.a = r1;
        this.b = r2;
    }
}
