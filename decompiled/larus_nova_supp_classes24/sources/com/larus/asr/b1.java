package com.larus.asr;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final /* synthetic */ class b1 implements Function1 {
    public final /* synthetic */ ChatBottomSpeakerComponent a;

    public /* synthetic */ b1(ChatBottomSpeakerComponent r1) {
        this.a = r1;
    }

    public final Object invoke(Object r4) {
        ChatBottomSpeakerComponent r0 = this.a;
        boolean r5 = ((Boolean) r4).booleanValue();
        r0.B = r5;
        Object r1 = r0.F9();
        if ((r1 instanceof String) == false) goto L5;
        String r2 = (String) r1;
    L6:
        r0.Q3(r2, r5);
        r0.A.invoke(Boolean.valueOf(r5));
        return Unit.INSTANCE;
    L5:
        r2 = null;
        goto L6
    }
}
