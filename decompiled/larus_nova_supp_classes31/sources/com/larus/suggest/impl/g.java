package com.larus.suggest.impl;

import com.larus.suggest.impl.wcb.model.WcbSurface;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final /* synthetic */ class g implements Function0 {
    public final /* synthetic */ ChatWcbCoordinatorComponent a;

    public /* synthetic */ g(ChatWcbCoordinatorComponent r1) {
        this.a = r1;
    }

    public final Object invoke() {
        ChatWcbCoordinatorComponent r0 = this.a;
        if (r0.s == WcbSurface.MAIN_CONVERSATION) goto L7;
        return null;
    L7:
        return r0.h.c;
    }
}
