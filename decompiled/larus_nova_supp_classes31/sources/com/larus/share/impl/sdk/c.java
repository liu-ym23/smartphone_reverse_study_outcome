package com.larus.share.impl.sdk;

import kotlin.Result;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.i;
import kotlinx.coroutines.j;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class c implements Function1<String, Unit> {
    public final /* synthetic */ i<String> a;

    public c(j r1) {
        this.a = r1;
    }

    public final Object invoke(Object r2) {
        String r3 = (String) r2;
        if (this.a.isActive() == false) goto L6;
        this.a.resumeWith(Result.constructor-impl(r3));
    L6:
        return Unit.INSTANCE;
    }
}
