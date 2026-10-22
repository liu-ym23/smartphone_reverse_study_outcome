package com.larus.bot.impl.repository;

import com.larus.bmhome.bot.bean.BotLanguage;
import com.larus.im.callback.IIMCallback;
import com.larus.im.callback.IIMError;
import com.larus.im.internal.delegate.y0;
import kotlin.Result;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.j;
import uc9.t;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class h implements IIMCallback<t> {
    public final /* synthetic */ kotlinx.coroutines.i<ub8.f> a;
    public final /* synthetic */ BotLanguage b;

    public final boolean mustInMain() {
        return !y0.a();
    }

    public final void onFailure(IIMError r6) {
        Intrinsics.checkNotNullParameter(r6, "error");
        Intrinsics.checkNotNullParameter(r6, "error");
        kotlinx.coroutines.i<ub8.f> r0 = this.a;
        Result.Companion r1 = Result.Companion;
        r0.resumeWith(Result.constructor-impl(new ub8.f(false, this.b, null, Long.valueOf(r6.getCode()))));
    }

    public final void onSuccess(Object r6) {
        t r7 = (t) r6;
        Intrinsics.checkNotNullParameter(r7, "result");
        kotlinx.coroutines.i<ub8.f> r0 = this.a;
        Result.Companion r1 = Result.Companion;
        r0.resumeWith(Result.constructor-impl(new ub8.f(r7.a, this.b, r7.b, null)));
    }

    public h(j r1, BotLanguage r2) {
        this.a = r1;
        this.b = r2;
    }
}
