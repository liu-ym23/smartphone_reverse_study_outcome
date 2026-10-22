package com.larus.bmhome.chat.model;

import com.larus.im.bean.bot.BotModel;
import com.larus.im.callback.IIMCallback;
import com.larus.im.callback.IIMError;
import java.util.List;
import java.util.Map;
import kotlin.Result;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class u0 implements IIMCallback<Map<String, ? extends List<? extends BotModel>>> {
    public final /* synthetic */ kotlinx.coroutines.i<Map<String, ? extends List<BotModel>>> a;

    public final boolean mustInMain() {
        return !com.larus.im.internal.delegate.y0.a();
    }

    public u0(kotlinx.coroutines.j r1) {
        this.a = r1;
    }

    public final void onFailure(IIMError r2) {
        Intrinsics.checkNotNullParameter(r2, "error");
        if (this.a.isActive() == false) goto L6;
        kotlinx.coroutines.i<Map<String, ? extends List<BotModel>>> r3 = this.a;
        Result.Companion r0 = Result.Companion;
        r3.resumeWith(Result.constructor-impl(MapsKt.emptyMap()));
        return;
    }

    public final void onSuccess(Object r2) {
        Map r3 = (Map) r2;
        Intrinsics.checkNotNullParameter(r3, "result");
        if (this.a.isActive() == false) goto L6;
        this.a.resumeWith(Result.constructor-impl(r3));
        return;
    }
}
