package com.larus.asr;

import com.larus.audio.asr.c0;
import java.util.Set;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final /* synthetic */ class w0 implements Function0 {
    public final /* synthetic */ ChatBottomSpeakerComponent a;
    public final /* synthetic */ c0 b;

    public /* synthetic */ w0(ChatBottomSpeakerComponent r1, boolean r2, c0 r3) {
        this.a = r1;
        this.b = r3;
    }

    public final Object invoke() {
        ChatBottomSpeakerComponent r0 = this.a;
        c0 r1 = this.b;
        Set r2 = ChatBottomSpeakerComponent.F2;
        com.larus.bmhome.instruction.g r3 = r0.vc();
        if (r3 == null) goto L7;
        boolean r4 = r3.of(r1);
        boolean r5 = true;
        if (r4 != true) goto L7;
    L9:
        return Boolean.valueOf(r5);
    L7:
        r5 = false;
        goto L9
    }
}
