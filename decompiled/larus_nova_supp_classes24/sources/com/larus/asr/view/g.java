package com.larus.asr.view;

import java.util.Set;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final /* synthetic */ class g implements Function1 {
    public final /* synthetic */ Set a;

    public /* synthetic */ g(Set r1) {
        this.a = r1;
    }

    public final Object invoke(Object r3) {
        Set r0 = this.a;
        y48.i r4 = (y48.i) r3;
        int r1 = ChatSpeaker.T;
        Intrinsics.checkNotNullParameter(r4, "it");
        if (r0 != null) goto L5;
    L8:
        boolean r5 = true;
    L10:
        return Boolean.valueOf(r5);
    L5:
        if (r0.contains(r4.a) == true) goto L8;
        r5 = false;
        goto L10
    }
}
