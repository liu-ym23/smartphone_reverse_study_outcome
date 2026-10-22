package com.larus.audio.tts.notification;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final /* synthetic */ class d implements Function1 {
    public final /* synthetic */ boolean a;

    public /* synthetic */ d() {
        this.a = false;
    }

    public final Object invoke(Object r3) {
        boolean r0 = this.a;
        g r4 = (g) r3;
        Intrinsics.checkNotNullParameter(r4, "it");
        r4.f(r0);
        return Unit.INSTANCE;
    }
}
