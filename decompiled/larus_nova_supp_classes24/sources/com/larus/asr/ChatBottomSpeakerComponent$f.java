package com.larus.asr;

import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class ChatBottomSpeakerComponent$f implements Function0<Unit> {
    public final /* synthetic */ ChatBottomSpeakerComponent a;

    public final Object invoke() {
        maa.e r0 = s1a.d.a(this.a).getAbility(maa.e.class);
        if (r0 == null) goto L6;
        r0.v50("pressing bottom button");
    L6:
        return Unit.INSTANCE;
    }

    public ChatBottomSpeakerComponent$f(ChatBottomSpeakerComponent r1) {
        this.a = r1;
    }
}
