package com.larus.asr;

import com.larus.asr.view.ChatSpeaker;
import java.util.Set;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import s1a.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final /* synthetic */ class t0 implements Function0 {
    public final /* synthetic */ ChatBottomSpeakerComponent a;

    public /* synthetic */ t0(ChatBottomSpeakerComponent r1) {
        this.a = r1;
    }

    public final Object invoke() {
        ChatBottomSpeakerComponent r0 = this.a;
        Set r1 = ChatBottomSpeakerComponent.F2;
        if (a.c(r0).isDetached() == true) goto L10;
        ChatSpeaker r2 = r0.a4();
        if (r2 == null) goto L9;
        ChatSpeaker.W6(r2);
    L9:
        return Unit.INSTANCE;
    L10:
        return Unit.INSTANCE;
    }
}
