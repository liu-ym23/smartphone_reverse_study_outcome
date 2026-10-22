package com.larus.audio.tts.notification;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final /* synthetic */ class f implements Function1 {
    public final /* synthetic */ g.a a;

    public /* synthetic */ f(g.a r1) {
        this.a = r1;
    }

    public final Object invoke(Object r3) {
        g.a r0 = this.a;
        g r4 = (g) r3;
        Intrinsics.checkNotNullParameter(r4, "it");
        r4.c();
        r4.g(r0);
        r4.f(true);
        r4.e(true);
        return Unit.INSTANCE;
    }
}
