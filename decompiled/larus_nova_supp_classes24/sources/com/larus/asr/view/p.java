package com.larus.asr.view;

import com.larus.asr.VoiceInputType;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final /* synthetic */ class p implements Function0 {
    public final /* synthetic */ ChatSpeaker a;
    public final /* synthetic */ VoiceInputType b;

    public /* synthetic */ p(ChatSpeaker r1, VoiceInputType r2) {
        this.a = r1;
        this.b = r2;
    }

    public final Object invoke() {
        ChatSpeaker r0 = this.a;
        VoiceInputType r1 = this.b;
        Function2 r2 = r0.f;
        if (r2 == null) goto L5;
        r2.invoke(Boolean.FALSE, r1);
    L5:
        r0.k = false;
        ChatSpeaker.N8(r0, false, null, false, null, 14);
        return Unit.INSTANCE;
    }
}
