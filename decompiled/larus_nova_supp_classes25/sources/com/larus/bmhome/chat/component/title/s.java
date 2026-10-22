package com.larus.bmhome.chat.component.title;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final /* synthetic */ class s implements Function1 {
    public final /* synthetic */ ChatTitleComponent a;

    public /* synthetic */ s(ChatTitleComponent r1) {
        this.a = r1;
    }

    public final Object invoke(Object r2) {
        ChatTitleComponent r0 = this.a;
        boolean r3 = ((Boolean) r2).booleanValue();
        com.larus.platform.api.g0 r1 = r0.n;
        if (r1 == null) goto L6;
        r1.setTitleIcon(r3);
    L6:
        return Unit.INSTANCE;
    }
}
