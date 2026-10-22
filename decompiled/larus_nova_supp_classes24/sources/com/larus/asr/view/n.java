package com.larus.asr.view;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final /* synthetic */ class n implements Function1 {
    public final /* synthetic */ ChatSpeaker a;

    public /* synthetic */ n(ChatSpeaker r1) {
        this.a = r1;
    }

    public final Object invoke(Object r2) {
        ChatSpeaker r0 = this.a;
        r0.n = ((Boolean) r2).booleanValue();
        r0.b8();
        return Unit.INSTANCE;
    }
}
