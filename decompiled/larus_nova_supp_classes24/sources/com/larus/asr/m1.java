package com.larus.asr;

import java.util.Set;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final /* synthetic */ class m1 implements Function1 {
    public final /* synthetic */ Function2 a;

    public /* synthetic */ m1(Function2 r1) {
        this.a = r1;
    }

    public final Object invoke(Object r3) {
        Function2 r0 = this.a;
        String r4 = (String) r3;
        Set r1 = ChatBottomSpeakerComponent.F2;
        Intrinsics.checkNotNullParameter(r4, "asrResult");
        return Boolean.valueOf(((Boolean) r0.invoke(r4, null)).booleanValue());
    }
}
