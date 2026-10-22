package com.larus.bmhome.chat.component.regen;

import com.larus.bmhome.chat.adapter.MessageAdapter;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final /* synthetic */ class b implements Function1 {
    public final /* synthetic */ RegenAnswerComponent a;
    public final /* synthetic */ wq8.b b;

    public /* synthetic */ b(RegenAnswerComponent r1, wq8.b r2) {
        this.a = r1;
        this.b = r2;
    }

    public final Object invoke(Object r3) {
        RegenAnswerComponent r0 = this.a;
        wq8.b r1 = this.b;
        h r4 = (h) r3;
        String r5 = r0.j;
        if (r5 != null) goto L5;
    L8:
        boolean r6 = true;
    L9:
        if (r6 == true) goto L13;
        RegenAnswerComponent.L2((MessageAdapter) r1, r0.j);
        return Unit.INSTANCE;
    L13:
        return Unit.INSTANCE;
    L5:
        if (r5.length() == 0) goto L8;
        r6 = false;
        goto L9
    }
}
