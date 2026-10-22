package com.larus.audio;

import kotlin.jvm.functions.Function0;
import m58.n;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final /* synthetic */ class h0 implements Function0 {
    public final /* synthetic */ n a;

    public /* synthetic */ h0(n r1) {
        this.a = r1;
    }

    public final Object invoke() {
        n r0 = this.a;
        int r1 = r0.b();
        if (r1 == (-1)) goto L7;
        if (r1 <= 0) goto L7;
        r0.a(r1 - 1);
    L7:
        return Integer.valueOf(r1);
    }
}
