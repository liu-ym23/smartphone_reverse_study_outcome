package com.larus.bmhome.chat;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final /* synthetic */ class e1 implements Function1 {
    public final /* synthetic */ h1 a;

    public /* synthetic */ e1(h1 r1) {
        this.a = r1;
    }

    public final Object invoke(Object r2) {
        h1 r0 = this.a;
        Boolean r3 = (Boolean) r2;
        if (r0.b() == false) goto L6;
        r0.a.N9("click_back_button");
    L6:
        return Unit.INSTANCE;
    }
}
