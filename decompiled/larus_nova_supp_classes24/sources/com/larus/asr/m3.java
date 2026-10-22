package com.larus.asr;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final /* synthetic */ class m3 implements Function1 {
    public final /* synthetic */ OChatBottomSpeakerComponent a;

    public /* synthetic */ m3(OChatBottomSpeakerComponent r1) {
        this.a = r1;
    }

    public final Object invoke(Object r2) {
        OChatBottomSpeakerComponent r0 = this.a;
        boolean r3 = ((Boolean) r2).booleanValue();
        Function1 r1 = r0.N2;
        if (r1 == null) goto L6;
        r1.invoke(Boolean.valueOf(r3));
    L6:
        return Unit.INSTANCE;
    }
}
