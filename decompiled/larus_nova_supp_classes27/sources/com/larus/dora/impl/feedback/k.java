package com.larus.dora.impl.feedback;

import java.io.IOException;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class k implements ff7.e {
    public final /* synthetic */ kotlinx.coroutines.i<Unit> a;

    public final void onSuccess() {
        pk4.j.d("DoraGFeedbackViewModel", "Device log upload success");
        kotlinx.coroutines.i<Unit> r0 = this.a;
        Result.Companion r1 = Result.Companion;
        r0.resumeWith(Result.constructor-impl(Unit.INSTANCE));
    }

    public k(kotlinx.coroutines.j r1) {
        this.a = r1;
    }

    public final void onFail(String r5) {
        pk4.j.b("DoraGFeedbackViewModel", "Device log upload failed, msg = " + r5);
        kotlinx.coroutines.i<Unit> r0 = this.a;
        Result.Companion r2 = Result.Companion;
        r0.resumeWith(Result.constructor-impl(ResultKt.createFailure(new IOException("Device log upload failed, msg = " + r5))));
    }
}
