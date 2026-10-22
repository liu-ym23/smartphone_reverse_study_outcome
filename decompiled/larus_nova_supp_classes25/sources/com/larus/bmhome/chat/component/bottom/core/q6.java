package com.larus.bmhome.chat.component.bottom.core;

import com.larus.bmhome.larkinput.api.service.LarkInputService;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import pq8.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final /* synthetic */ class q6 implements Function0 {
    public final /* synthetic */ CoreInputComponent a;

    public /* synthetic */ q6(CoreInputComponent r1) {
        this.a = r1;
    }

    public final Object invoke() {
        CoreInputComponent r0 = this.a;
        int r1 = CoreInputComponent.d3;
        a r2 = LarkInputService.b.a(new oq8.b(null));
        r0.h1 = r2;
        com.larus.bmhome.chat.component.bottom.core.inputtext.p0 r3 = r0.W4();
        if (r3 == null) goto L8;
        com.larus.bmhome.chat.component.bottom.core.inputtext.s r4 = r3.Z0();
        if (r4 == null) goto L8;
        r2.a(r4);
    L8:
        return Unit.INSTANCE;
    }
}
