package com.larus.audio;

import com.larus.platform.model.audio.ClientConfigKey;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final /* synthetic */ class t implements Function1 {
    public /* synthetic */ t() {
    }

    public final Object invoke(Object r2) {
        String r3 = (String) r2;
        Intrinsics.checkNotNullParameter(r3, "it");
        if (Intrinsics.areEqual(r3, ClientConfigKey.DORA.getKey()) == false) goto L5;
    L8:
        boolean r4 = true;
    L10:
        return Boolean.valueOf(r4);
    L5:
        if (Intrinsics.areEqual(r3, ClientConfigKey.DORA_RADIO.getKey()) == true) goto L8;
        r4 = false;
        goto L10
    }
}
