package com.larus.bmhome.bigimg;

import kotlin.Result;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class s1 implements Function1<String, Unit> {
    public final /* synthetic */ kotlinx.coroutines.i<String> a;

    public s1(kotlinx.coroutines.j r1) {
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
