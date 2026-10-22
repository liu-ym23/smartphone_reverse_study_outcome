package com.larus.asr;

import com.larus.asr.view.ChatSpeaker;
import java.util.Set;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final /* synthetic */ class s0 implements Function0 {
    public final /* synthetic */ ChatBottomSpeakerComponent a;

    public /* synthetic */ s0(ChatBottomSpeakerComponent r1) {
        this.a = r1;
    }

    public final Object invoke() {
        ChatBottomSpeakerComponent r0 = this.a;
        Set r1 = ChatBottomSpeakerComponent.F2;
        ChatSpeaker r2 = r0.a4();
        if (r2 == null) goto L5;
        int r3 = r2.getHandsfreeBottomBlockHeight();
    L7:
        return Integer.valueOf(r3);
    L5:
        r3 = 0;
        goto L7
    }
}
