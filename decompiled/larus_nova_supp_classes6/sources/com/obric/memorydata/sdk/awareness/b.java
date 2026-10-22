package com.obric.memorydata.sdk.awareness;

import android.content.Context;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
public final /* synthetic */ class b implements Function0 {
    public final /* synthetic */ e.a a;

    public /* synthetic */ b(e.a r1) {
        this.a = r1;
    }

    public final Object invoke() {
        e.a r0 = this.a;
        Context r1 = r0.getContext();
        if (r1 == null) goto L5;
        r1.unbindService(r0.b);
        return Unit.INSTANCE;
    L5:
        return null;
    }
}
