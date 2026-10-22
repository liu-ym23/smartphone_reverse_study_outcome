package com.larus.asr;

import java.util.Set;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final /* synthetic */ class l1 implements Function2 {
    public final /* synthetic */ ChatBottomSpeakerComponent a;

    public /* synthetic */ l1(ChatBottomSpeakerComponent r1) {
        this.a = r1;
    }

    public final Object invoke(Object r2, Object r3) {
        ChatBottomSpeakerComponent r0 = this.a;
        String r4 = (String) r2;
        String r5 = (String) r3;
        Set r6 = ChatBottomSpeakerComponent.F2;
        Intrinsics.checkNotNullParameter(r4, "asrResult");
        return Boolean.valueOf(((Boolean) r0.H.invoke(r4)).booleanValue());
    }
}
