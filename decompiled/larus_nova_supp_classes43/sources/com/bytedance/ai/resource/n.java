package com.bytedance.ai.resource;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final /* synthetic */ class n implements Function1 {
    public final /* synthetic */ Function1 a;

    public /* synthetic */ n(x r1) {
        this.a = r1;
    }

    public final Object invoke(Object r10) {
        Function1 r0 = this.a;
        Throwable r11 = (Throwable) r10;
        Intrinsics.checkNotNullParameter(r11, "it");
        com.bytedance.ai.utils.g.a.e("AppletResourceLoader", r11.getMessage());
        r0.invoke(r11);
        return Unit.INSTANCE;
    }
}
