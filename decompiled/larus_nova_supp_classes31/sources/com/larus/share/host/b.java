package com.larus.share.host;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final /* synthetic */ class b implements Function1 {
    public final /* synthetic */ com.larus.bmhome.share.panel.b a;

    public /* synthetic */ b(com.larus.bmhome.share.panel.b r1) {
        this.a = r1;
    }

    public final Object invoke(Object r3) {
        com.larus.bmhome.share.panel.b r0 = this.a;
        kn7.a r4 = (kn7.a) r3;
        int r1 = MainlandShareRuntimeServiceImpl.a;
        Intrinsics.checkNotNullParameter(r4, "$this$createShareExtra");
        kn7.c r2 = new kn7.c();
        r2.a = r0.n;
        r4.h = r2;
        return Unit.INSTANCE;
    }
}
