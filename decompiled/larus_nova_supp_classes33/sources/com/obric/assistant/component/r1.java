package com.obric.assistant.component;

import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final /* synthetic */ class r1 implements Function0 {
    public final /* synthetic */ ObricIntercomComponent a;

    public /* synthetic */ r1(ObricIntercomComponent r1) {
        this.a = r1;
    }

    public final Object invoke() {
        ObricIntercomComponent r0 = this.a;
        Function1 r1 = r0.S;
        if (r1 == null) goto L5;
        r1.invoke(Boolean.TRUE);
    L5:
        r0.T.invoke(Boolean.TRUE);
        return Unit.INSTANCE;
    }
}
