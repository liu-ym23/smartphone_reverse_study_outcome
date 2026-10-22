package com.larus.avlink.plugins;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class w2 extends k4 {
    public final /* synthetic */ Function1<Boolean, Unit> a;

    public w2(c3 r1) {
        this.a = r1;
    }

    @Override // com.larus.avlink.plugins.k4
    public final void d(int r3) {
        Function1<Boolean, Unit> r0 = this.a;
        boolean r1 = true;
        if (r3 == 1) goto L6;
        r1 = false;
    L6:
        r0.invoke(Boolean.valueOf(r1));
    }
}
