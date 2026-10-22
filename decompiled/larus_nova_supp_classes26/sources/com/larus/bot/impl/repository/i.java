package com.larus.bot.impl.repository;

import com.larus.im.bean.bot.ModelItem;
import com.larus.im.callback.IIMCallback;
import com.larus.im.callback.IIMError;
import com.larus.im.internal.delegate.y0;
import kotlin.Result;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.j;
import uc9.t;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class i implements IIMCallback<t> {
    public final /* synthetic */ kotlinx.coroutines.i<ub8.g> a;
    public final /* synthetic */ ModelItem b;

    public final boolean mustInMain() {
        return !y0.a();
    }

    public final void onFailure(IIMError r6) {
        Intrinsics.checkNotNullParameter(r6, "error");
        Intrinsics.checkNotNullParameter(r6, "error");
        kotlinx.coroutines.i<ub8.g> r0 = this.a;
        Result.Companion r1 = Result.Companion;
        r0.resumeWith(Result.constructor-impl(new ub8.g(false, this.b, Long.valueOf(r6.getCode()))));
    }

    public final void onSuccess(Object r5) {
        t r6 = (t) r5;
        Intrinsics.checkNotNullParameter(r6, "result");
        kotlinx.coroutines.i<ub8.g> r0 = this.a;
        Result.Companion r1 = Result.Companion;
        r0.resumeWith(Result.constructor-impl(new ub8.g(r6.a, this.b, null)));
    }

    public i(j r1, ModelItem r2) {
        this.a = r1;
        this.b = r2;
    }
}
