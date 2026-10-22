package com.lark.wire;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class e0 implements Function1<j0, Unit> {
    public final /* synthetic */ ProtoAdapter<Object> a;
    public final /* synthetic */ Object b;

    public e0(ProtoAdapter<Object> r1, Object r2) {
        this.a = r1;
        this.b = r2;
    }

    public final Object invoke(Object r3) {
        j0 r4 = (j0) r3;
        Intrinsics.checkNotNullParameter(r4, "forwardWriter");
        this.a.f(r4, this.b);
        return Unit.INSTANCE;
    }
}
