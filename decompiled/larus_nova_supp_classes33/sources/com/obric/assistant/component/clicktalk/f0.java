package com.obric.assistant.component.clicktalk;

import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final /* synthetic */ class f0 implements Function0 {
    public final /* synthetic */ Function1 a;
    public final /* synthetic */ String b;

    public /* synthetic */ f0(Function1 r1, String r2) {
        this.a = r1;
        this.b = r2;
    }

    public final Object invoke() {
        Function1 r0 = this.a;
        String r1 = this.b;
        int r2 = ChatClickTalkComponent.L0;
        r0.invoke(r1);
        return Unit.INSTANCE;
    }
}
