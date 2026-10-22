package com.larus.bmhome.chat.api;

import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final /* synthetic */ class h0 implements Function0 {
    public final /* synthetic */ q0 a;

    public /* synthetic */ h0(q0 r1) {
        this.a = r1;
    }

    public final Object invoke() {
        com.larus.bmhome.chat.component.cvs.y r0 = this.a.getProvider().u0();
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.h();
    }
}
