package com.larus.bmhome.chat.layout.holder.helper;

import com.larus.im.callback.IMError;
import com.larus.utils.logger.FLogger;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class o1 implements mf9.a<mf9.c> {
    public final /* synthetic */ kotlinx.coroutines.i<mf9.c> a;

    public o1(kotlinx.coroutines.j r1) {
        this.a = r1;
    }

    public final void a(IMError r3) {
        Intrinsics.checkNotNullParameter(r3, "error");
        if (this.a.isActive() == false) goto L6;
        kotlinx.coroutines.i<mf9.c> r0 = this.a;
        Result.Companion r1 = Result.Companion;
        r0.resumeWith(Result.constructor-impl(ResultKt.createFailure(new Exception(r3.getException()))));
        FLogger.a.i("MessageCopyHelper", "getDeepResearchResource onFailure");
        return;
    }

    public final void b(mf9.c r3) {
        Intrinsics.checkNotNullParameter(r3, "result");
        if (this.a.isActive() == false) goto L6;
        this.a.resumeWith(Result.constructor-impl(r3));
        FLogger.a.i("MessageCopyHelper", "getDeepResearchResource loadFromLocal");
        return;
    }

    public final void onSuccess(Object r3) {
        mf9.c r4 = (mf9.c) r3;
        Intrinsics.checkNotNullParameter(r4, "result");
        if (this.a.isActive() == false) goto L6;
        this.a.resumeWith(Result.constructor-impl(r4));
        FLogger.a.i("MessageCopyHelper", "getDeepResearchResource success");
        return;
    }
}
