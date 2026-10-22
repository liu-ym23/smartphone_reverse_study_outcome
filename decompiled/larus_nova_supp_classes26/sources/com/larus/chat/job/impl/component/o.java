package com.larus.chat.job.impl.component;

import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final /* synthetic */ class o implements Function2 {
    public /* synthetic */ o() {
    }

    public final Object invoke(Object r2, Object r3) {
        wc9.e r4 = (wc9.e) r2;
        wc9.e r5 = (wc9.e) r3;
        int r0 = ChatJobPendingReplyModeComponent.p;
        String r1 = null;
        if (r4 == null) goto L5;
        String r6 = r4.a;
    L6:
        if (r5 == null) goto L9;
        r1 = r5.a;
    L9:
        return Boolean.valueOf(Intrinsics.areEqual(r6, r1));
    L5:
        r6 = null;
        goto L6
    }
}
