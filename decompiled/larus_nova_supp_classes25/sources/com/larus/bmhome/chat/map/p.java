package com.larus.bmhome.chat.map;

import com.larus.platform.service.t1;
import com.larus.utils.t0;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final /* synthetic */ class p implements Function1 {
    public final /* synthetic */ r a;

    public /* synthetic */ p(r r1) {
        this.a = r1;
    }

    public final Object invoke(Object r2) {
        final r r0 = this.a;
        if (((Boolean) r2).booleanValue() == false) goto L8;
        if (t1.a.d() == false) goto L8;
        t0.c(new q(r0));
    L8:
        return Unit.INSTANCE;
    }
}
