package com.larus.voicecall.impl.component.bottom.more_btn;

import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final /* synthetic */ class h implements Function0 {
    public final /* synthetic */ k a;

    public /* synthetic */ h(k r1) {
        this.a = r1;
    }

    public final Object invoke() {
        k r0 = this.a;
        t1a.b r1 = r0.a.b();
        if (r1 == null) goto L5;
        com.larus.voicecall.impl.component.picture.b r2 = (com.larus.voicecall.impl.component.picture.b) r1.o(Reflection.getOrCreateKotlinClass(com.larus.voicecall.impl.component.picture.b.class));
    L6:
        if (r2 == null) goto L8;
        r2.Jh();
    L8:
        r0.g = null;
        return Unit.INSTANCE;
    L5:
        r2 = null;
        goto L6
    }
}
