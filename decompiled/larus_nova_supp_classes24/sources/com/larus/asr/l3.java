package com.larus.asr;

import kotlin.Pair;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final /* synthetic */ class l3 implements Function1 {
    public final /* synthetic */ OChatBottomSpeakerComponent a;

    public /* synthetic */ l3(OChatBottomSpeakerComponent r1) {
        this.a = r1;
    }

    public final Object invoke(Object r3) {
        OChatBottomSpeakerComponent r0 = this.a;
        Pair r4 = (Pair) r3;
        int r1 = OChatBottomSpeakerComponent.R2;
        Intrinsics.checkNotNullParameter(r4, "position");
        maa.f r2 = r0.G4();
        if (r2 != null) goto L7;
        return null;
    L7:
        return r2.I4(r4);
    }
}
