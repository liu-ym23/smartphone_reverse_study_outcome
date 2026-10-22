package com.bytedance.android.ec.core.arch.state;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KFunction;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class e implements Function1<b, Unit> {
    public final /* synthetic */ KFunction a;

    public e(KFunction r1) {
        this.a = r1;
    }

    public final Object invoke(Object r10) {
        b r11 = (b) r10;
        Intrinsics.checkNotNullParameter(r11, "p1");
        this.a.invoke(r11);
        return Unit.INSTANCE;
    }
}
