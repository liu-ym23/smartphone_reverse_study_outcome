package com.larus.bmhome.chat.component.bottom.core;

import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final /* synthetic */ class h5 implements Function0 {
    public final /* synthetic */ CoreInputComponent a;
    public final /* synthetic */ Function0 b;
    public final /* synthetic */ boolean c;

    public /* synthetic */ h5(CoreInputComponent r1, Function0 r2, boolean r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    public final Object invoke() {
        CoreInputComponent r0 = this.a;
        Function0 r1 = this.b;
        boolean r2 = this.c;
        com.larus.bmhome.utils.x1 r3 = r0.H1;
        if (r3 == null) goto L6;
        r3.c(r1, r2);
    L6:
        return Unit.INSTANCE;
    }
}
