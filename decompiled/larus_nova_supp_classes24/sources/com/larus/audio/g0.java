package com.larus.audio;

import kotlin.jvm.functions.Function0;
import m58.h;
import m58.w;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final /* synthetic */ class g0 implements Function0 {
    public /* synthetic */ g0() {
    }

    public final Object invoke() {
        w r0 = h.f;
        boolean r1 = false;
        if (r0 == null) goto L5;
        int r2 = r0.o();
    L7:
        if (1 > r2) goto L12;
        if (r2 >= 4) goto L12;
        r1 = true;
    L12:
        return Boolean.valueOf(r1);
    L5:
        r2 = 0;
        goto L7
    }
}
