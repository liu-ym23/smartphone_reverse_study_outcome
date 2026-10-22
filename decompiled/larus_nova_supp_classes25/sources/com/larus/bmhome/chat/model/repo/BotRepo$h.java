package com.larus.bmhome.chat.model.repo;

import com.larus.im.bean.bot.SpeakerVoice;
import com.larus.im.callback.IIMCallback;
import com.larus.im.callback.IIMError;
import kotlin.Result;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class BotRepo$h implements IIMCallback<uc9.t> {
    public final /* synthetic */ kotlinx.coroutines.i<ub8.h> a;
    public final /* synthetic */ SpeakerVoice b;

    public final boolean mustInMain() {
        return !com.larus.im.internal.delegate.y0.a();
    }

    public final void onFailure(IIMError r6) {
        Intrinsics.checkNotNullParameter(r6, "error");
        Intrinsics.checkNotNullParameter(r6, "error");
        kotlinx.coroutines.i<ub8.h> r0 = this.a;
        Result.Companion r1 = Result.Companion;
        r0.resumeWith(Result.constructor-impl(new ub8.h(false, this.b, Long.valueOf(r6.getCode()), r6.getTips())));
    }

    public final void onSuccess(Object r5) {
        uc9.t r6 = (uc9.t) r5;
        Intrinsics.checkNotNullParameter(r6, "result");
        kotlinx.coroutines.i<ub8.h> r0 = this.a;
        Result.Companion r1 = Result.Companion;
        r0.resumeWith(Result.constructor-impl(new ub8.h(r6.a, this.b, null, null)));
    }

    public BotRepo$h(kotlinx.coroutines.j r1, SpeakerVoice r2) {
        this.a = r1;
        this.b = r2;
    }
}
