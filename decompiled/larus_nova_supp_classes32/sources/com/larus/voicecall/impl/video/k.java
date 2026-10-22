package com.larus.voicecall.impl.video;

import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final /* synthetic */ class k implements Function1 {
    public /* synthetic */ k() {
    }

    public final Object invoke(Object r2) {
        if (((VideoPreviewState) r2) != VideoPreviewState.close) goto L5;
        boolean r3 = true;
    L7:
        return Boolean.valueOf(r3);
    L5:
        r3 = false;
        goto L7
    }
}
