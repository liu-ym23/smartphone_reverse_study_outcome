package com.larus.bmhome.chat.component.trace;

import de8.c;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final /* synthetic */ class j implements Function0 {
    public final /* synthetic */ ChatTraceComponent a;

    public /* synthetic */ j(ChatTraceComponent r1) {
        this.a = r1;
    }

    public final Object invoke() {
        ChatTraceComponent r0 = this.a;
        int r1 = ChatTraceComponent.L;
        String r2 = r0.U2();
        c r5 = r0.f1();
        if (r5 == null) goto L5;
        boolean r6 = r5.B();
    L6:
        z$a.a(r0, r2, null, null, null, r6, false, 84);
        return Unit.INSTANCE;
    L5:
        r6 = false;
        goto L6
    }
}
