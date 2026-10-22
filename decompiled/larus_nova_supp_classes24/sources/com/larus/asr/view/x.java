package com.larus.asr.view;

import com.larus.asr.x4;
import com.larus.asr.y4;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final /* synthetic */ class x implements Function0 {
    public final /* synthetic */ ChatSpeaker a;

    public /* synthetic */ x(ChatSpeaker r1) {
        this.a = r1;
    }

    public final Object invoke() {
        x4 r0 = this.a.u;
        y4 r1 = r0.a;
        if (r1 == null) goto L5;
        r1.cancel();
    L5:
        y4 r7 = new y4(r0, r0.b, r0.c);
        r0.a = r7;
        r7.start();
        return Unit.INSTANCE;
    }
}
