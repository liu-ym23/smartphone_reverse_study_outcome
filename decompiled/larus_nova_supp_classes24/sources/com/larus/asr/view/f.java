package com.larus.asr.view;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final /* synthetic */ class f implements Function1 {
    public /* synthetic */ f() {
    }

    public final Object invoke(Object r2) {
        y48.i r3 = (y48.i) r2;
        int r0 = ChatSpeaker.T;
        Intrinsics.checkNotNullParameter(r3, "it");
        if (r3.b == true) goto L5;
    L7:
        boolean r4 = false;
    L9:
        return Boolean.valueOf(r4);
    L5:
        if (r3.f == null) goto L7;
        r4 = true;
        goto L9
    }
}
