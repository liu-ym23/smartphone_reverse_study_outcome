package com.larus.bmhome.chat.model.repo;

import com.larus.im.bean.bot.BotModel;
import com.larus.im.callback.IIMCallback;
import com.larus.im.callback.IIMError;
import java.util.Map;
import kotlin.Result;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class BotRepo$e implements IIMCallback<Map<String, ? extends BotModel>> {
    public final /* synthetic */ kotlinx.coroutines.i<Map<String, BotModel>> a;

    public final boolean mustInMain() {
        return !com.larus.im.internal.delegate.y0.a();
    }

    public BotRepo$e(kotlinx.coroutines.j r1) {
        this.a = r1;
    }

    public final void onFailure(IIMError r2) {
        Intrinsics.checkNotNullParameter(r2, "error");
        Intrinsics.checkNotNullParameter(r2, "error");
        this.a.resumeWith(Result.constructor-impl(null));
    }

    public final void onSuccess(Object r2) {
        Map r3 = (Map) r2;
        Intrinsics.checkNotNullParameter(r3, "result");
        this.a.resumeWith(Result.constructor-impl(r3));
    }
}
