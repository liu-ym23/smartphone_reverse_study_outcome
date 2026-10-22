package com.larus.bmhome.chat.component.cvs;

import com.larus.bmhome.chat.i1;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final /* synthetic */ class b implements Function2 {
    public final /* synthetic */ ChatConversationComponent a;

    public /* synthetic */ b(ChatConversationComponent r1) {
        this.a = r1;
    }

    public final Object invoke(Object r9, Object r10) {
        ChatConversationComponent r0 = this.a;
        long r1 = ((Long) r9).longValue();
        long r11 = ((Long) r10).longValue();
        i1 r2 = r0.i;
        if (r2 == null) goto L8;
        if (r2.k != 0) goto L8;
        r2.k = r1;
        r2.l = r11;
        r2.a("botChangeStartTime", r1);
        r2.a("botChangeEndTime", r2.l);
    L8:
        return Unit.INSTANCE;
    }
}
