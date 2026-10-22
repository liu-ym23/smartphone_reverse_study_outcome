package com.bytedance.ai.model;

import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class o implements Function3 {
    @Override // kotlin.jvm.functions.Function3
    public final Object invoke(Object r5, Object r10, Object r11) {
        w0.f r12 = (w0.f) r5;
        ((Boolean) r10).getClass();
        Intrinsics.checkNotNullParameter((String) r11, "message");
        return Unit.INSTANCE;
    }
}
