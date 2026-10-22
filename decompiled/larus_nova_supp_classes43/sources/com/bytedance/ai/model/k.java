package com.bytedance.ai.model;

import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final /* synthetic */ class k implements Function1 {
    public final /* synthetic */ Function3 a;

    public /* synthetic */ k(Function3 r1) {
        this.a = r1;
    }

    public final Object invoke(Object r10) {
        Function3 r0 = this.a;
        String r11 = (String) r10;
        AtomicInteger r1 = AppletRuntime.x;
        Intrinsics.checkNotNullParameter(r11, "errorMsg");
        if (r0 == null) goto L6;
        r0.invoke(null, Boolean.FALSE, r11);
    L6:
        return Unit.INSTANCE;
    }
}
