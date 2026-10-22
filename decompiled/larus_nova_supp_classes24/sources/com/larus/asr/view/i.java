package com.larus.asr.view;

import com.larus.utils.logger.FLogger;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final /* synthetic */ class i implements Function0 {
    public final /* synthetic */ ChatSpeaker a;

    public /* synthetic */ i(ChatSpeaker r1) {
        this.a = r1;
    }

    public final Object invoke() {
        ChatSpeaker r0 = this.a;
        int r1 = ChatSpeaker.T;
        FLogger.a.i("ChatSpeaker", "[HF] ChatSpeaker handsfree cancel button clicked");
        Function0 r2 = r0.e;
        if (r2 == null) goto L6;
        r2.invoke();
    L6:
        return Unit.INSTANCE;
    }
}
