package com.larus.audio.ttsV2;

import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final /* synthetic */ class h implements Function2 {
    public final /* synthetic */ m58.p a;

    public /* synthetic */ h(m58.p r1) {
        this.a = r1;
    }

    public final Object invoke(Object r3, Object r4) {
        m58.p r0 = this.a;
        u58.a r5 = (u58.a) r3;
        int r6 = ((Integer) r4).intValue();
        Intrinsics.checkNotNullParameter(r5, "config");
        return r0.a(r5, r6);
    }
}
