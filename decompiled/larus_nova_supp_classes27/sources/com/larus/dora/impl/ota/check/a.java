package com.larus.dora.impl.ota.check;

import kotlin.Result;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class a implements d {
    public a() {
    }

    @Override // com.larus.dora.impl.ota.check.d
    public final Object a(String r1, String r2, String r3, String r4, String r5, String r6, String r7, String r8, Continuation<? super Result<e49.a>> r9) {
        Result.Companion r10 = Result.Companion;
        return Result.constructor-impl(ResultKt.createFailure(new Exception("local OTAUpdateResponse is null")));
    }
}
