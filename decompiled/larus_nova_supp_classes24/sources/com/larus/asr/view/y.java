package com.larus.asr.view;

import com.larus.asr.y4;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final /* synthetic */ class y implements Function0 {
    public final /* synthetic */ ChatSpeaker a;

    public /* synthetic */ y(ChatSpeaker r1) {
        this.a = r1;
    }

    public final Object invoke() {
        y4 r0 = this.a.u.a;
        if (r0 == null) goto L6;
        r0.cancel();
    L6:
        return Unit.INSTANCE;
    }
}
