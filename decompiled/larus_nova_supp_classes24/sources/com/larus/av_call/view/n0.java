package com.larus.av_call.view;

import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final /* synthetic */ class n0 implements Function2 {
    public final /* synthetic */ Function3 a;
    public final /* synthetic */ VoiceCallBottomLayout b;

    public /* synthetic */ n0(com.larus.voicecall.impl.component.bottom.j0 r1, VoiceCallBottomLayout r2) {
        this.a = r1;
        this.b = r2;
    }

    public final Object invoke(Object r4, Object r5) {
        Function3 r0 = this.a;
        VoiceCallBottomLayout r1 = this.b;
        String r6 = (String) r4;
        int r7 = ((Integer) r5).intValue();
        int r2 = VoiceCallBottomLayout.D;
        Intrinsics.checkNotNullParameter(r6, "suggest");
        r0.invoke(r6, r1.n, Integer.valueOf(r7));
        return Unit.INSTANCE;
    }
}
