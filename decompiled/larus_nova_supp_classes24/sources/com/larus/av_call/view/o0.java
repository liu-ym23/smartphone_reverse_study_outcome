package com.larus.av_call.view;

import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final /* synthetic */ class o0 implements Function2 {
    public final /* synthetic */ Function2 a;
    public final /* synthetic */ VoiceCallBottomLayout b;

    public /* synthetic */ o0(com.larus.voicecall.impl.component.bottom.k0 r1, VoiceCallBottomLayout r2) {
        this.a = r1;
        this.b = r2;
    }

    public final Object invoke(Object r4, Object r5) {
        Function2 r0 = this.a;
        VoiceCallBottomLayout r1 = this.b;
        int r6 = ((Integer) r5).intValue();
        int r2 = VoiceCallBottomLayout.D;
        Intrinsics.checkNotNullParameter((String) r4, "<unused var>");
        r0.invoke(r1.n, Integer.valueOf(r6));
        return Unit.INSTANCE;
    }
}
