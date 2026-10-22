package com.obric.assistant.window;

import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final /* synthetic */ class o implements Function0 {
    public final /* synthetic */ ObricMsgComponent a;

    public /* synthetic */ o(ObricMsgComponent r1) {
        this.a = r1;
    }

    public final Object invoke() {
        ObricMsgComponent r0 = this.a;
        int r1 = ObricMsgComponent.T;
        va8.c r2 = r0.p3();
        if (r2 != null) goto L7;
        return null;
    L7:
        return r2.b();
    }
}
