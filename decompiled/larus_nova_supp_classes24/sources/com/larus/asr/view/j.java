package com.larus.asr.view;

import com.larus.asr.VoiceInputType;
import com.larus.utils.logger.FLogger;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final /* synthetic */ class j implements Function0 {
    public final /* synthetic */ ChatSpeaker a;

    public /* synthetic */ j(ChatSpeaker r1) {
        this.a = r1;
    }

    public final Object invoke() {
        ChatSpeaker r0 = this.a;
        int r1 = ChatSpeaker.T;
        FLogger.a.i("ChatSpeaker", "[HF] ChatSpeaker handsfree send button clicked");
        Function2 r2 = r0.f;
        if (r2 == null) goto L6;
        r2.invoke(Boolean.TRUE, VoiceInputType.TouchSpeaker);
    L6:
        return Unit.INSTANCE;
    }
}
