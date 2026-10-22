package com.larus.asr.session;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final /* synthetic */ class h1 implements Function1 {
    public final /* synthetic */ i1 a;

    public /* synthetic */ h1(i1 r1) {
        this.a = r1;
    }

    public final Object invoke(Object r3) {
        i1 r0 = this.a;
        byte[] r4 = (byte[]) r3;
        if (r4 == null) goto L6;
        r0.a.Ma(r0.b, r4);
    L6:
        return Unit.INSTANCE;
    }
}
