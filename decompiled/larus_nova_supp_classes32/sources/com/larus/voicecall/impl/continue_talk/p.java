package com.larus.voicecall.impl.continue_talk;

import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final /* synthetic */ class p implements Function2 {
    public /* synthetic */ p() {
    }

    public final Object invoke(Object r1, Object r2) {
        wc9.e r3 = (wc9.e) r1;
        wc9.e r4 = (wc9.e) r2;
        int r5 = ChatContinuousTalkComponent.M;
        if (r4 == null) goto L5;
        String r6 = r4.a;
    L7:
        return Boolean.valueOf(com.larus.utils.o0.d(r6));
    L5:
        r6 = null;
        goto L7
    }
}
